package com.baidu.tieba.mainentrance;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateBarGuideActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.search.ResponseSearchFriendMessage;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.tbadkCore.FRSPageRequestMessage;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class SquareSearchActivity extends BaseActivity<SquareSearchActivity> implements com.baidu.adp.widget.ListView.x, h {
    private boolean anT;
    private List<e> bBE;
    private FragmentTabWidget bBH;
    private FragmentTabIndicator bBI;
    private LinearLayoutDetectsSoftKeyboard bBJ;
    private FrameLayout bBK;
    private FrameLayout bBL;
    private EditText bBM;
    private TextView bBN;
    private TextView bBO;
    private ImageView bBP;
    private View bBQ;
    private View bBR;
    private ListView bBS;
    private c bBT;
    private i bBU;
    private LinearLayout bBV;
    private PbListView bBW;
    private BdListView bBX;
    private a bBY;
    private com.baidu.tieba.postsearch.w bBZ;
    private f bCa;
    private ForumSuggestModel bCb;
    private com.baidu.tieba.postsearch.j bCc;
    private ao bCd;
    private ap bCe;
    private String bCf;
    private String bCg;
    private String bCh;
    private String bCi;
    private boolean bCl;
    private boolean bCo;
    private boolean bCq;
    private View bCr;
    private TextView bCs;
    private View bCt;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private int mMode = 0;
    private int bCj = 0;
    private int bCk = -1;
    private boolean bCm = true;
    private boolean bCn = true;
    private boolean bCp = false;
    private List<View> bCu = new ArrayList();
    private final View.OnClickListener bCv = new m(this);
    private final com.baidu.adp.framework.listener.e bCw = new x(this, 301001, true);
    private final HttpMessageListener bCx = new ah(this, CmdConfigHttp.FRS_HTTP_CMD, true);
    private CustomMessageListener bCy = new ai(this, 2001195);
    private CustomMessageListener bCz = new aj(this, 2001194);
    private HttpMessageListener bCA = new ak(this, CmdConfigHttp.SEARCH_FRIEND_CMD);
    private final Runnable bCB = new al(this);
    private CustomMessageListener bCC = new am(this, 2009002);
    private CustomMessageListener bCD = new an(this, 2009001);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponsedMessage<?> responsedMessage, boolean z) {
        int error = responsedMessage.getError();
        String string = StringUtils.isNull(responsedMessage.getErrorString()) ? getResources().getString(com.baidu.tieba.t.neterror) : responsedMessage.getErrorString();
        boolean z2 = error < -13 || error > -10;
        if (error == 0) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createFlagCfg(this.bCi, FrsActivityConfig.FRS_FROM_SEARCH, 1)));
        } else if (z2 && z && error == 3) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.t.login_to_use), true, 11013)));
            } else {
                sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), this.bCi)));
            }
        } else {
            showToast(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fE(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SEARCH_FRIEND_CMD);
        httpMessage.addParam("search_key", str);
        sendMessage(httpMessage);
    }

    private void Gd() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SEARCH_FRIEND_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SEARCH_FRIEND);
        tbHttpMessageTask.setResponsedClass(ResponseSearchFriendMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 11013:
                    sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), this.bCi)));
                    finish();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.r.home_dialog_search);
        init();
        getWindow().setSoftInputMode(1);
        Gd();
        registerListener(this.bCy);
        registerListener(this.bCz);
        registerListener(this.bCC);
        registerListener(this.bCD);
        registerListener(this.bCA);
        registerListener(this.bCw);
        registerListener(this.bCx);
        this.bCq = com.baidu.tbadk.core.sharedPref.b.sl().getBoolean("search_post_show_dropmenu", true);
        this.bCa = new f(this, this);
        this.bCa.Yj();
        this.bCa.Yi();
        this.bCl = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bCm = true;
        if (this.bCn) {
            this.mHandler.post(new n(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mMode = 0;
        if (this.mMode == 0) {
            TbadkSettings.getInst().saveBoolean("search_mode", true);
        } else {
            TbadkSettings.getInst().saveBoolean("search_mode", false);
        }
        hideLoadingView(this.bBK);
        FG();
    }

    public void FG() {
        this.mHandler.removeCallbacks(this.bCB);
        if (this.bCd != null) {
            this.bCd.cancel();
            this.bCd = null;
        }
        if (this.bCe != null) {
            this.bCe.cancel();
            this.bCe = null;
        }
    }

    private void init() {
        this.bBJ = (LinearLayoutDetectsSoftKeyboard) findViewById(com.baidu.tieba.q.parent);
        this.bBJ.setOnSoftKeyBoardShownListener(new o(this));
        this.bBJ.setOnTouchListener(new p(this));
        CG();
        MM();
        this.bBK = (FrameLayout) findViewById(com.baidu.tieba.q.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.o.ds80)), null, null);
        this.bBK.addView(this.mNoDataView);
        this.bBL = (FrameLayout) findViewById(com.baidu.tieba.q.home_search_list);
        Yk();
        Yl();
        this.bBQ = findViewById(com.baidu.tieba.q.empty_search_result);
        Ym();
        this.bBM.setText("");
        this.bBM.requestFocus();
        ShowSoftKeyPadDelay(this.bBM, 200);
        if (TbadkSettings.getInst().loadBoolean("search_mode", true)) {
            hf(0);
        } else {
            hf(1);
        }
    }

    private void MM() {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new q(this));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.r.square_search_navigation_view, (View.OnClickListener) null);
        this.bBP = (ImageView) addCustomView.findViewById(com.baidu.tieba.q.search_bar_icon);
        this.bBM = (EditText) addCustomView.findViewById(com.baidu.tieba.q.home_et_search);
        this.bBN = (TextView) addCustomView.findViewById(com.baidu.tieba.q.home_bt_search_del);
        this.bBO = (TextView) addCustomView.findViewById(com.baidu.tieba.q.home_bt_search_s);
        this.bBM.setOnFocusChangeListener(new r(this));
        this.bBO.setText(getPageContext().getString(com.baidu.tieba.t.enter_forum));
        this.bBO.setOnClickListener(this.bCv);
        this.bBM.setOnEditorActionListener(new s(this));
        this.bBN.setOnClickListener(new t(this));
        this.bBM.addTextChangedListener(new u(this));
    }

    private void CG() {
        this.bBH = (FragmentTabWidget) findViewById(com.baidu.tieba.q.square_search_tab_widget);
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(com.baidu.tieba.o.ds32));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.amU = com.baidu.tieba.n.main_bottom_button_color;
        fragmentTabIndicator.setText(getResources().getString(com.baidu.tieba.t.search_bar_text));
        this.bBI = new FragmentTabIndicator(getPageContext().getPageActivity());
        this.bBI.amU = com.baidu.tieba.n.main_bottom_button_color;
        this.bBI.setTextSize(0, getResources().getDimension(com.baidu.tieba.o.ds32));
        this.bBI.setGravity(17);
        this.bBI.setCompoundDrawablesRightResId(com.baidu.tieba.p.icon_toolbar_arrow_down);
        this.bBI.setText(getResources().getString(com.baidu.tieba.t.search_post_text));
        FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator2.amU = com.baidu.tieba.n.main_bottom_button_color;
        fragmentTabIndicator2.setTextSize(0, getResources().getDimension(com.baidu.tieba.o.ds32));
        fragmentTabIndicator2.setGravity(17);
        fragmentTabIndicator2.setText(getResources().getString(com.baidu.tieba.t.search_person));
        this.bBH.addView(fragmentTabIndicator);
        this.bBH.addView(this.bBI);
        this.bBH.addView(fragmentTabIndicator2);
        this.bBH.d(0, true);
        this.bBH.setTabSelectionListener(new v(this));
    }

    private void Yk() {
        this.bBS = (ListView) findViewById(com.baidu.tieba.q.home_lv_search_history);
        if (this.bBV == null) {
            this.bBV = new LinearLayout(getBaseContext());
            this.bBV.setOrientation(1);
            this.bBV.setBackgroundColor(ay.getColor(com.baidu.tieba.n.cp_bg_line_d));
        }
        this.bBS.addFooterView(this.bBV);
        this.bBT = new c(this);
        this.bBS.setAdapter((ListAdapter) this.bBT);
        this.bBS.setOnItemClickListener(new w(this));
    }

    private void Yl() {
        this.bBX = (BdListView) findViewById(com.baidu.tieba.q.home_lv_search_suggest);
        this.bBY = new a(this, null);
        this.bBZ = new com.baidu.tieba.postsearch.w(getPageContext());
        this.bBX.setOnItemClickListener(new y(this));
        z zVar = new z(this);
        this.bBX.setOnScrollListener(zVar);
        this.bBS.setOnScrollListener(zVar);
        this.bBX.setOnSrollToBottomListener(this);
    }

    private void Ym() {
        this.bBR = findViewById(com.baidu.tieba.q.search_dropmenu);
        TextView textView = (TextView) this.bBR.findViewById(com.baidu.tieba.q.dropmenu_all_text);
        textView.setTextColor(ay.getColor(com.baidu.tieba.n.cp_link_tip_a));
        ImageView imageView = (ImageView) this.bBR.findViewById(com.baidu.tieba.q.dropmenu_all_icon);
        imageView.setImageDrawable(ay.getDrawable(com.baidu.tieba.p.chx_tips_list_ok));
        imageView.setVisibility(0);
        TextView textView2 = (TextView) this.bBR.findViewById(com.baidu.tieba.q.dropmenu_thread_text);
        textView2.setTextColor(ay.getColor(com.baidu.tieba.n.cp_cont_c));
        ImageView imageView2 = (ImageView) this.bBR.findViewById(com.baidu.tieba.q.dropmenu_thread_icon);
        imageView2.setImageDrawable(ay.getDrawable(com.baidu.tieba.p.chx_tips_list_ok));
        imageView2.setVisibility(8);
        this.bBR.findViewById(com.baidu.tieba.q.dropmenu_all_layout).setOnClickListener(new aa(this, textView, imageView, textView2, imageView2));
        this.bBR.findViewById(com.baidu.tieba.q.dropmenu_thread_layout).setOnClickListener(new ab(this, textView, imageView, textView2, imageView2));
        this.bBR.findViewById(com.baidu.tieba.q.dropmenu_lower_part).setOnClickListener(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yn() {
        if (this.bBL.getVisibility() == 8 && this.mNoDataView.getVisibility() == 8 && this.bBQ.getVisibility() == 8) {
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.text_no_search_record));
        }
    }

    public void hf(int i) {
        switch (i) {
            case 0:
                if (this.mMode != 0) {
                    this.mMode = 0;
                    this.bBO.setText(getPageContext().getString(com.baidu.tieba.t.enter_forum));
                    this.bBM.setHint(com.baidu.tieba.t.search_bar);
                    FG();
                    Yu();
                    if (this.bCf.trim().length() > 0) {
                        Yt();
                        return;
                    } else {
                        Yp();
                        return;
                    }
                }
                return;
            case 1:
                if (this.mMode != 1) {
                    this.mMode = 1;
                    this.bBO.setText(getPageContext().getString(com.baidu.tieba.t.search));
                    this.bBM.setHint(com.baidu.tieba.t.search_post_hint);
                    FG();
                    Yu();
                    if (this.bCf.trim().length() > 0) {
                        this.bBX.setVisibility(8);
                        z(1, this.bCf);
                        return;
                    }
                    Yq();
                    return;
                }
                return;
            case 2:
            default:
                return;
            case 3:
                if (this.mMode != 3) {
                    this.mMode = 3;
                    this.bBX.setVisibility(8);
                    this.bBQ.setVisibility(8);
                    this.bBR.setVisibility(8);
                    this.bBO.setText(com.baidu.tieba.t.search);
                    this.bBM.setHint(com.baidu.tieba.t.search_friend_tip);
                    Yu();
                    FG();
                    Yr();
                    return;
                }
                return;
        }
    }

    public void Yo() {
        String trim = this.bBM.getText().toString().trim();
        if (!TextUtils.isEmpty(trim)) {
            if (UtilHelper.isNetOk()) {
                this.bCi = trim;
                this.bCm = false;
                sendMessage(hY(trim));
                return;
            }
            showToast(com.baidu.tieba.t.neterror);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yp() {
        this.bBX.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009002));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yq() {
        this.bBX.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009001));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yr() {
        this.bBX.setVisibility(8);
        if (!this.anT) {
            sendMessage(new RequestSearchPersonHistoryReadMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ArrayList<String> arrayList) {
        if (b(i, arrayList) || c(i, arrayList) || d(i, arrayList)) {
            Yy();
            this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.text_no_search_record));
            return;
        }
        Yx();
        List<e> arrayList2 = new ArrayList<>();
        if (i == 4) {
            arrayList2 = this.bBE;
        }
        a(i, arrayList, (this.bBE == null ? 0 : arrayList2.size()) != 0);
        this.bBT.aM(arrayList2);
        this.bBT.notifyDataSetChanged();
    }

    private void a(int i, ArrayList<String> arrayList, boolean z) {
        if (this.bBV != null) {
            this.bBV.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Context baseContext = getBaseContext();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (z) {
                    this.bCr = new View(baseContext);
                    this.bCr.setBackgroundColor(ay.getColor(com.baidu.tieba.n.cp_bg_line_b));
                    layoutParams.height = com.baidu.adp.lib.util.n.d(baseContext, com.baidu.tieba.o.ds20);
                    this.bBV.addView(this.bCr, layoutParams);
                }
                this.bCs = (TextView) com.baidu.adp.lib.g.b.hr().inflate(baseContext, com.baidu.tieba.r.search_history_title, null);
                this.bCs.setTextColor(ay.getColor(com.baidu.tieba.n.cp_cont_c));
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.leftMargin = com.baidu.adp.lib.util.n.d(baseContext, com.baidu.tieba.o.ds30);
                layoutParams2.topMargin = com.baidu.adp.lib.util.n.d(baseContext, com.baidu.tieba.o.ds36);
                layoutParams2.bottomMargin = com.baidu.adp.lib.util.n.d(baseContext, com.baidu.tieba.o.ds10);
                this.bBV.addView(this.bCs, layoutParams2);
                int size = arrayList.size();
                this.bCu.clear();
                for (int i2 = 0; i2 < size; i2++) {
                    String str = arrayList.get(i2);
                    if (!TextUtils.isEmpty(str)) {
                        View inflate = com.baidu.adp.lib.g.b.hr().inflate(baseContext, com.baidu.tieba.r.home_dialog_search_item, null);
                        ((TextView) inflate.findViewById(com.baidu.tieba.q.home_lv_search_forum)).setText(str);
                        ay.b((TextView) inflate.findViewById(com.baidu.tieba.q.home_lv_search_forum), com.baidu.tieba.n.cp_cont_b, 1);
                        inflate.findViewById(com.baidu.tieba.q.home_dialog_lv_search_forum_divider).setBackgroundColor(ay.getColor(com.baidu.tieba.n.cp_bg_line_b));
                        ay.i(inflate, com.baidu.tieba.p.addresslist_item_bg);
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                        inflate.setOnClickListener(new aq(this, str));
                        this.bCu.add(inflate);
                        this.bBV.addView(inflate, layoutParams3);
                    }
                }
                this.bCt = com.baidu.adp.lib.g.b.hr().inflate(baseContext, com.baidu.tieba.r.home_dialog_search_footer, null);
                ((TextView) this.bCt.findViewById(com.baidu.tieba.q.home_bt_search_footer)).setTextColor(ay.getColor(com.baidu.tieba.n.cp_link_tip_a));
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                this.bCt.setOnClickListener(new ac(this));
                this.bBV.addView(this.bCt, layoutParams4);
            }
        }
    }

    private boolean b(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.bBE == null || this.bBE.isEmpty()) && 4 == i && this.mMode == 0;
    }

    private boolean c(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && i == 5 && this.mMode != 5;
    }

    private boolean d(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && i == 6 && this.mMode != 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ys() {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).cn(getPageContext().getString(com.baidu.tieba.t.alert_clean_history)).a(getPageContext().getString(com.baidu.tieba.t.clear_all_text), new ad(this)).b(getPageContext().getString(com.baidu.tieba.t.alert_no_button), new af(this)).b(getPageContext()).rL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yt() {
        this.bBL.setVisibility(8);
        if (this.bCf != null) {
            if (this.bCf.equals(this.bCg)) {
                refresh();
                return;
            }
            this.mHandler.removeCallbacks(this.bCB);
            this.mHandler.postDelayed(this.bCB, 500L);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v5 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i, String str) {
        this.bBS.setVisibility(8);
        if (str != null && str.trim().length() > 0) {
            int i2 = this.bCo ? 1 : 0;
            if (str.equals(this.bCh) && i == this.bCj && this.bCk == i2) {
                refresh();
                return;
            }
            this.bCk = i2;
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append(TbConfig.SERVER_ADDRESS);
            stringBuffer.append(TbConfig.POST_SEARCH_URL);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("word", str));
            arrayList.add(new BasicNameValuePair("pn", String.valueOf(i)));
            arrayList.add(new BasicNameValuePair("rn", String.valueOf(50)));
            arrayList.add(new BasicNameValuePair("only_thread", new StringBuilder().append(i2).toString()));
            arrayList.add(new BasicNameValuePair("st_type", "search_post"));
            FG();
            this.bCe = new ap(this, stringBuffer.toString(), arrayList);
            this.bCe.setPriority(3);
            this.bCe.execute(new Object[0]);
            this.bCp = true;
        }
    }

    private FRSPageRequestMessage hY(String str) {
        FRSPageRequestMessage fRSPageRequestMessage = new FRSPageRequestMessage();
        fRSPageRequestMessage.setKw(str);
        fRSPageRequestMessage.setPn(1);
        if (com.baidu.tbadk.core.n.qc().qg()) {
            fRSPageRequestMessage.setRn(35);
        } else {
            fRSPageRequestMessage.setRn(50);
        }
        fRSPageRequestMessage.setWithGroup(1);
        int M = com.baidu.adp.lib.util.n.M(getPageContext().getPageActivity());
        int N = com.baidu.adp.lib.util.n.N(getPageContext().getPageActivity());
        float f = M / 320.0f;
        int i = bc.tB().tD() ? 2 : 1;
        fRSPageRequestMessage.setScrW(M);
        fRSPageRequestMessage.setScrH(N);
        fRSPageRequestMessage.setScrDip(f);
        fRSPageRequestMessage.setqType(i);
        return fRSPageRequestMessage;
    }

    private void Yu() {
        this.bBX.setNextPage(null);
        this.bBZ.clear();
        this.bBZ.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        int i;
        int i2 = 0;
        try {
            if (this.mMode == 0) {
                if (this.bCb != null) {
                    if (this.bCb.forum_list != null && this.bCb.forum_list.size() > 0) {
                        Yw();
                        this.bBX.setAdapter((ListAdapter) this.bBY);
                        this.bBY.hW(this.bCf);
                        this.bBY.D(this.bCb.forum_list);
                        this.bBY.notifyDataSetInvalidated();
                        return;
                    }
                    YA();
                    Yv();
                }
            } else if (this.bCc != null) {
                List<com.baidu.tieba.postsearch.k> list = this.bCc.bWB;
                if (list != null && list.size() > 0) {
                    Yw();
                    if (this.bCc.getCurrentPage() == 1) {
                        this.bBX.setVisibility(0);
                        this.bBZ.clear();
                        this.bBX.setAdapter((ListAdapter) this.bBZ);
                        this.bBX.setNextPage(YB());
                    }
                    if (!this.bCc.isHasMore()) {
                        YB().setText(getResources().getString(com.baidu.tieba.t.list_no_more));
                        YB().ux();
                    }
                    int aW = this.bBZ.aW(list);
                    if (aW > 0) {
                        i = this.bBX.getFirstVisiblePosition() - aW;
                        View childAt = this.bBX.getChildAt(0);
                        if (childAt != null) {
                            i2 = childAt.getTop();
                        }
                    } else {
                        i = 0;
                    }
                    this.bBZ.notifyDataSetChanged();
                    if (aW > 0) {
                        this.bBX.setSelectionFromTop(i, i2);
                    }
                    if (this.bCq) {
                        this.bBR.setVisibility(0);
                        this.bCq = false;
                        com.baidu.tbadk.core.sharedPref.b.sl().putBoolean("search_post_show_dropmenu", false);
                    }
                } else if (this.mNoDataView.getVisibility() != 0) {
                    Yy();
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.text_no_suggest));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void Yv() {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ay.getColor(com.baidu.tieba.n.cp_cont_h));
        TextView textView = (TextView) this.bBQ.findViewById(com.baidu.tieba.q.no_bar_found);
        textView.setTextColor(ay.getColor(com.baidu.tieba.n.cp_cont_c));
        TextView textView2 = (TextView) this.bBQ.findViewById(com.baidu.tieba.q.create_bar_guide);
        textView2.setTextColor(ay.getColor(com.baidu.tieba.n.cp_cont_b));
        String str = "";
        if (this.bCf != null) {
            str = this.bCf.length() > 6 ? String.valueOf(this.bCf.substring(0, 6)) + "..." : this.bCf;
        }
        String format = String.format(getPageContext().getString(com.baidu.tieba.t.empty_search_result_format), str);
        String format2 = String.format(getPageContext().getString(com.baidu.tieba.t.create_bar_guide_format), str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
        spannableStringBuilder.setSpan(foregroundColorSpan, 4, format.length() - 2, 33);
        textView.setText(spannableStringBuilder);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(format2);
        spannableStringBuilder2.setSpan(foregroundColorSpan, 5, format2.length() - 5, 33);
        textView2.setText(spannableStringBuilder2);
        Drawable drawable = ay.getDrawable(com.baidu.tieba.p.icon_search_list_add);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView2.setCompoundDrawablePadding(com.baidu.adp.lib.util.n.d(getBaseContext(), com.baidu.tieba.o.ds10));
        textView2.setCompoundDrawables(drawable, null, null, null);
        textView2.setOnClickListener(new ag(this));
    }

    private void Yw() {
        this.bBL.setVisibility(0);
        this.bBX.setVisibility(0);
        this.bBS.setVisibility(8);
        this.mNoDataView.setVisibility(8);
        this.bBR.setVisibility(8);
        this.bBI.setCompoundDrawablesRightResId(com.baidu.tieba.p.icon_toolbar_arrow_down);
        this.bBI.cz(TbadkCoreApplication.m411getInst().getSkinType());
        this.bBQ.setVisibility(8);
    }

    private void Yx() {
        this.bBL.setVisibility(0);
        this.bBS.setVisibility(0);
        this.bBX.setVisibility(8);
        this.mNoDataView.setVisibility(8);
        this.bBR.setVisibility(8);
        this.bBI.setCompoundDrawablesRightResId(com.baidu.tieba.p.icon_toolbar_arrow_down);
        this.bBI.cz(TbadkCoreApplication.m411getInst().getSkinType());
        this.bBQ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yy() {
        this.bBL.setVisibility(8);
        this.bBX.setVisibility(8);
        this.bBS.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.bBR.setVisibility(8);
        this.bBI.setCompoundDrawablesRightResId(com.baidu.tieba.p.icon_toolbar_arrow_down);
        this.bBI.cz(TbadkCoreApplication.m411getInst().getSkinType());
        this.bBQ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yz() {
        this.mNoDataView.setVisibility(8);
        this.bBR.setVisibility(0);
    }

    private void YA() {
        this.bBL.setVisibility(8);
        this.bBX.setVisibility(8);
        this.bBS.setVisibility(8);
        this.mNoDataView.setVisibility(8);
        this.bBR.setVisibility(8);
        this.bBI.setCompoundDrawablesRightResId(com.baidu.tieba.p.icon_toolbar_arrow_down);
        this.bBI.cz(TbadkCoreApplication.m411getInst().getSkinType());
        this.bBQ.setVisibility(0);
    }

    private PbListView YB() {
        if (this.bBW == null) {
            this.bBW = new PbListView(getPageContext().getPageActivity());
            this.bBW.ng();
        }
        return this.bBW;
    }

    @Override // com.baidu.tieba.mainentrance.h
    public void hX(String str) {
        this.bCl = true;
        this.bBE = new ArrayList();
        Yp();
    }

    @Override // com.baidu.tieba.mainentrance.h
    public void aN(List<e> list) {
        this.bCl = true;
        hideLoadingView(this.bBK);
        if (list == null || list.isEmpty()) {
            this.bBE = new ArrayList();
        } else {
            this.bBE = list;
        }
        Yp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bBH.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().j(this.bBJ);
        getLayoutMode().j(this.bBQ);
        ay.e(this.bBJ, i);
        if (this.bBU != null) {
            this.bBU.notifyDataSetChanged();
        }
        if (this.bBY != null) {
            this.bBY.notifyDataSetChanged();
        }
        if (this.bBZ != null) {
            this.bBZ.notifyDataSetChanged();
        }
        if (this.bBT != null) {
            this.bBT.notifyDataSetChanged();
        }
        ay.i(this.bBK, com.baidu.tieba.n.cp_bg_line_d);
        ay.c(this.bBP, com.baidu.tieba.p.icon_search_ba);
        ay.b(this.bBO, com.baidu.tieba.n.cp_cont_i, 1);
        try {
            hg(i);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    private void hg(int i) {
        if (this.bBV != null) {
            this.bBV.setBackgroundColor(ay.getColor(com.baidu.tieba.n.cp_bg_line_d));
        }
        if (this.bCr != null) {
            this.bCr.setBackgroundColor(ay.getColor(com.baidu.tieba.n.cp_bg_line_b));
        }
        if (this.bCs != null) {
            this.bCs.setTextColor(ay.getColor(com.baidu.tieba.n.cp_cont_c));
        }
        if (this.bCt != null) {
            ((TextView) this.bCt.findViewById(com.baidu.tieba.q.home_bt_search_footer)).setTextColor(ay.getColor(com.baidu.tieba.n.cp_link_tip_a));
        }
        if (this.bCu != null) {
            for (View view : this.bCu) {
                ay.b((TextView) view.findViewById(com.baidu.tieba.q.home_lv_search_forum), com.baidu.tieba.n.cp_cont_b, 1);
                view.findViewById(com.baidu.tieba.q.home_dialog_lv_search_forum_divider).setBackgroundColor(ay.getColor(com.baidu.tieba.n.cp_bg_line_b));
                ay.i(view, com.baidu.tieba.p.addresslist_item_bg);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeActivity();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            com.baidu.tbadk.core.c.b.e(getPageContext().getPageActivity(), 1);
        } else {
            com.baidu.tbadk.core.c.b.e(getPageContext().getPageActivity(), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        setSkinType(-1);
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void onScrollToBottom() {
        if (!this.bCp && this.bCc != null && this.bCc.isHasMore()) {
            z(this.bCc.getCurrentPage() + 1, this.bCf);
            YB().startLoadData();
        }
    }
}
