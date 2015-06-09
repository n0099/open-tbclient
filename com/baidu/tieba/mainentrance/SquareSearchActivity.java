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
    private List<e> bBF;
    private FragmentTabWidget bBI;
    private FragmentTabIndicator bBJ;
    private LinearLayoutDetectsSoftKeyboard bBK;
    private FrameLayout bBL;
    private FrameLayout bBM;
    private EditText bBN;
    private TextView bBO;
    private TextView bBP;
    private ImageView bBQ;
    private View bBR;
    private View bBS;
    private ListView bBT;
    private c bBU;
    private i bBV;
    private LinearLayout bBW;
    private PbListView bBX;
    private BdListView bBY;
    private a bBZ;
    private com.baidu.tieba.postsearch.w bCa;
    private f bCb;
    private ForumSuggestModel bCc;
    private com.baidu.tieba.postsearch.j bCd;
    private ao bCe;
    private ap bCf;
    private String bCg;
    private String bCh;
    private String bCi;
    private String bCj;
    private boolean bCm;
    private boolean bCp;
    private boolean bCr;
    private View bCs;
    private TextView bCt;
    private View bCu;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private int mMode = 0;
    private int bCk = 0;
    private int bCl = -1;
    private boolean bCn = true;
    private boolean bCo = true;
    private boolean bCq = false;
    private List<View> bCv = new ArrayList();
    private final View.OnClickListener bCw = new m(this);
    private final com.baidu.adp.framework.listener.e bCx = new x(this, 301001, true);
    private final HttpMessageListener bCy = new ah(this, CmdConfigHttp.FRS_HTTP_CMD, true);
    private CustomMessageListener bCz = new ai(this, 2001195);
    private CustomMessageListener bCA = new aj(this, 2001194);
    private HttpMessageListener bCB = new ak(this, CmdConfigHttp.SEARCH_FRIEND_CMD);
    private final Runnable bCC = new al(this);
    private CustomMessageListener bCD = new am(this, 2009002);
    private CustomMessageListener bCE = new an(this, 2009001);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponsedMessage<?> responsedMessage, boolean z) {
        int error = responsedMessage.getError();
        String string = StringUtils.isNull(responsedMessage.getErrorString()) ? getResources().getString(com.baidu.tieba.t.neterror) : responsedMessage.getErrorString();
        boolean z2 = error < -13 || error > -10;
        if (error == 0) {
            sendMessage(new CustomMessage(2003000, new FrsActivityConfig(getPageContext().getPageActivity()).createFlagCfg(this.bCj, FrsActivityConfig.FRS_FROM_SEARCH, 1)));
        } else if (z2 && z && error == 3) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.t.login_to_use), true, 11013)));
            } else {
                sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), this.bCj)));
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

    private void Ge() {
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
                    sendMessage(new CustomMessage(2002001, new CreateBarGuideActivityConfig(getPageContext().getPageActivity(), this.bCj)));
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
        Ge();
        registerListener(this.bCz);
        registerListener(this.bCA);
        registerListener(this.bCD);
        registerListener(this.bCE);
        registerListener(this.bCB);
        registerListener(this.bCx);
        registerListener(this.bCy);
        this.bCr = com.baidu.tbadk.core.sharedPref.b.sl().getBoolean("search_post_show_dropmenu", true);
        this.bCb = new f(this, this);
        this.bCb.Yk();
        this.bCb.Yj();
        this.bCm = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bCn = true;
        if (this.bCo) {
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
        hideLoadingView(this.bBL);
        FH();
    }

    public void FH() {
        this.mHandler.removeCallbacks(this.bCC);
        if (this.bCe != null) {
            this.bCe.cancel();
            this.bCe = null;
        }
        if (this.bCf != null) {
            this.bCf.cancel();
            this.bCf = null;
        }
    }

    private void init() {
        this.bBK = (LinearLayoutDetectsSoftKeyboard) findViewById(com.baidu.tieba.q.parent);
        this.bBK.setOnSoftKeyBoardShownListener(new o(this));
        this.bBK.setOnTouchListener(new p(this));
        CH();
        MN();
        this.bBL = (FrameLayout) findViewById(com.baidu.tieba.q.frame_layout);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.o.ds80)), null, null);
        this.bBL.addView(this.mNoDataView);
        this.bBM = (FrameLayout) findViewById(com.baidu.tieba.q.home_search_list);
        Yl();
        Ym();
        this.bBR = findViewById(com.baidu.tieba.q.empty_search_result);
        Yn();
        this.bBN.setText("");
        this.bBN.requestFocus();
        ShowSoftKeyPadDelay(this.bBN, 200);
        if (TbadkSettings.getInst().loadBoolean("search_mode", true)) {
            hf(0);
        } else {
            hf(1);
        }
    }

    private void MN() {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new q(this));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.r.square_search_navigation_view, (View.OnClickListener) null);
        this.bBQ = (ImageView) addCustomView.findViewById(com.baidu.tieba.q.search_bar_icon);
        this.bBN = (EditText) addCustomView.findViewById(com.baidu.tieba.q.home_et_search);
        this.bBO = (TextView) addCustomView.findViewById(com.baidu.tieba.q.home_bt_search_del);
        this.bBP = (TextView) addCustomView.findViewById(com.baidu.tieba.q.home_bt_search_s);
        this.bBN.setOnFocusChangeListener(new r(this));
        this.bBP.setText(getPageContext().getString(com.baidu.tieba.t.enter_forum));
        this.bBP.setOnClickListener(this.bCw);
        this.bBN.setOnEditorActionListener(new s(this));
        this.bBO.setOnClickListener(new t(this));
        this.bBN.addTextChangedListener(new u(this));
    }

    private void CH() {
        this.bBI = (FragmentTabWidget) findViewById(com.baidu.tieba.q.square_search_tab_widget);
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(com.baidu.tieba.o.ds32));
        fragmentTabIndicator.setGravity(17);
        fragmentTabIndicator.amU = com.baidu.tieba.n.main_bottom_button_color;
        fragmentTabIndicator.setText(getResources().getString(com.baidu.tieba.t.search_bar_text));
        this.bBJ = new FragmentTabIndicator(getPageContext().getPageActivity());
        this.bBJ.amU = com.baidu.tieba.n.main_bottom_button_color;
        this.bBJ.setTextSize(0, getResources().getDimension(com.baidu.tieba.o.ds32));
        this.bBJ.setGravity(17);
        this.bBJ.setCompoundDrawablesRightResId(com.baidu.tieba.p.icon_toolbar_arrow_down);
        this.bBJ.setText(getResources().getString(com.baidu.tieba.t.search_post_text));
        FragmentTabIndicator fragmentTabIndicator2 = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator2.amU = com.baidu.tieba.n.main_bottom_button_color;
        fragmentTabIndicator2.setTextSize(0, getResources().getDimension(com.baidu.tieba.o.ds32));
        fragmentTabIndicator2.setGravity(17);
        fragmentTabIndicator2.setText(getResources().getString(com.baidu.tieba.t.search_person));
        this.bBI.addView(fragmentTabIndicator);
        this.bBI.addView(this.bBJ);
        this.bBI.addView(fragmentTabIndicator2);
        this.bBI.d(0, true);
        this.bBI.setTabSelectionListener(new v(this));
    }

    private void Yl() {
        this.bBT = (ListView) findViewById(com.baidu.tieba.q.home_lv_search_history);
        if (this.bBW == null) {
            this.bBW = new LinearLayout(getBaseContext());
            this.bBW.setOrientation(1);
            this.bBW.setBackgroundColor(ay.getColor(com.baidu.tieba.n.cp_bg_line_d));
        }
        this.bBT.addFooterView(this.bBW);
        this.bBU = new c(this);
        this.bBT.setAdapter((ListAdapter) this.bBU);
        this.bBT.setOnItemClickListener(new w(this));
    }

    private void Ym() {
        this.bBY = (BdListView) findViewById(com.baidu.tieba.q.home_lv_search_suggest);
        this.bBZ = new a(this, null);
        this.bCa = new com.baidu.tieba.postsearch.w(getPageContext());
        this.bBY.setOnItemClickListener(new y(this));
        z zVar = new z(this);
        this.bBY.setOnScrollListener(zVar);
        this.bBT.setOnScrollListener(zVar);
        this.bBY.setOnSrollToBottomListener(this);
    }

    private void Yn() {
        this.bBS = findViewById(com.baidu.tieba.q.search_dropmenu);
        TextView textView = (TextView) this.bBS.findViewById(com.baidu.tieba.q.dropmenu_all_text);
        textView.setTextColor(ay.getColor(com.baidu.tieba.n.cp_link_tip_a));
        ImageView imageView = (ImageView) this.bBS.findViewById(com.baidu.tieba.q.dropmenu_all_icon);
        imageView.setImageDrawable(ay.getDrawable(com.baidu.tieba.p.chx_tips_list_ok));
        imageView.setVisibility(0);
        TextView textView2 = (TextView) this.bBS.findViewById(com.baidu.tieba.q.dropmenu_thread_text);
        textView2.setTextColor(ay.getColor(com.baidu.tieba.n.cp_cont_c));
        ImageView imageView2 = (ImageView) this.bBS.findViewById(com.baidu.tieba.q.dropmenu_thread_icon);
        imageView2.setImageDrawable(ay.getDrawable(com.baidu.tieba.p.chx_tips_list_ok));
        imageView2.setVisibility(8);
        this.bBS.findViewById(com.baidu.tieba.q.dropmenu_all_layout).setOnClickListener(new aa(this, textView, imageView, textView2, imageView2));
        this.bBS.findViewById(com.baidu.tieba.q.dropmenu_thread_layout).setOnClickListener(new ab(this, textView, imageView, textView2, imageView2));
        this.bBS.findViewById(com.baidu.tieba.q.dropmenu_lower_part).setOnClickListener(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yo() {
        if (this.bBM.getVisibility() == 8 && this.mNoDataView.getVisibility() == 8 && this.bBR.getVisibility() == 8) {
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.text_no_search_record));
        }
    }

    public void hf(int i) {
        switch (i) {
            case 0:
                if (this.mMode != 0) {
                    this.mMode = 0;
                    this.bBP.setText(getPageContext().getString(com.baidu.tieba.t.enter_forum));
                    this.bBN.setHint(com.baidu.tieba.t.search_bar);
                    FH();
                    Yv();
                    if (this.bCg.trim().length() > 0) {
                        Yu();
                        return;
                    } else {
                        Yq();
                        return;
                    }
                }
                return;
            case 1:
                if (this.mMode != 1) {
                    this.mMode = 1;
                    this.bBP.setText(getPageContext().getString(com.baidu.tieba.t.search));
                    this.bBN.setHint(com.baidu.tieba.t.search_post_hint);
                    FH();
                    Yv();
                    if (this.bCg.trim().length() > 0) {
                        this.bBY.setVisibility(8);
                        z(1, this.bCg);
                        return;
                    }
                    Yr();
                    return;
                }
                return;
            case 2:
            default:
                return;
            case 3:
                if (this.mMode != 3) {
                    this.mMode = 3;
                    this.bBY.setVisibility(8);
                    this.bBR.setVisibility(8);
                    this.bBS.setVisibility(8);
                    this.bBP.setText(com.baidu.tieba.t.search);
                    this.bBN.setHint(com.baidu.tieba.t.search_friend_tip);
                    Yv();
                    FH();
                    Ys();
                    return;
                }
                return;
        }
    }

    public void Yp() {
        String trim = this.bBN.getText().toString().trim();
        if (!TextUtils.isEmpty(trim)) {
            if (UtilHelper.isNetOk()) {
                this.bCj = trim;
                this.bCn = false;
                sendMessage(hY(trim));
                return;
            }
            showToast(com.baidu.tieba.t.neterror);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yq() {
        this.bBY.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009002));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yr() {
        this.bBY.setVisibility(8);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009001));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ys() {
        this.bBY.setVisibility(8);
        if (!this.anT) {
            sendMessage(new RequestSearchPersonHistoryReadMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ArrayList<String> arrayList) {
        if (b(i, arrayList) || c(i, arrayList) || d(i, arrayList)) {
            Yz();
            this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.text_no_search_record));
            return;
        }
        Yy();
        List<e> arrayList2 = new ArrayList<>();
        if (i == 4) {
            arrayList2 = this.bBF;
        }
        a(i, arrayList, (this.bBF == null ? 0 : arrayList2.size()) != 0);
        this.bBU.aM(arrayList2);
        this.bBU.notifyDataSetChanged();
    }

    private void a(int i, ArrayList<String> arrayList, boolean z) {
        if (this.bBW != null) {
            this.bBW.removeAllViews();
            if (arrayList != null && !arrayList.isEmpty() && getActivity() != null) {
                Context baseContext = getBaseContext();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (z) {
                    this.bCs = new View(baseContext);
                    this.bCs.setBackgroundColor(ay.getColor(com.baidu.tieba.n.cp_bg_line_b));
                    layoutParams.height = com.baidu.adp.lib.util.n.d(baseContext, com.baidu.tieba.o.ds20);
                    this.bBW.addView(this.bCs, layoutParams);
                }
                this.bCt = (TextView) com.baidu.adp.lib.g.b.hr().inflate(baseContext, com.baidu.tieba.r.search_history_title, null);
                this.bCt.setTextColor(ay.getColor(com.baidu.tieba.n.cp_cont_c));
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.leftMargin = com.baidu.adp.lib.util.n.d(baseContext, com.baidu.tieba.o.ds30);
                layoutParams2.topMargin = com.baidu.adp.lib.util.n.d(baseContext, com.baidu.tieba.o.ds36);
                layoutParams2.bottomMargin = com.baidu.adp.lib.util.n.d(baseContext, com.baidu.tieba.o.ds10);
                this.bBW.addView(this.bCt, layoutParams2);
                int size = arrayList.size();
                this.bCv.clear();
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
                        this.bCv.add(inflate);
                        this.bBW.addView(inflate, layoutParams3);
                    }
                }
                this.bCu = com.baidu.adp.lib.g.b.hr().inflate(baseContext, com.baidu.tieba.r.home_dialog_search_footer, null);
                ((TextView) this.bCu.findViewById(com.baidu.tieba.q.home_bt_search_footer)).setTextColor(ay.getColor(com.baidu.tieba.n.cp_link_tip_a));
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                this.bCu.setOnClickListener(new ac(this));
                this.bBW.addView(this.bCu, layoutParams4);
            }
        }
    }

    private boolean b(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && (this.bBF == null || this.bBF.isEmpty()) && 4 == i && this.mMode == 0;
    }

    private boolean c(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && i == 5 && this.mMode != 5;
    }

    private boolean d(int i, ArrayList<String> arrayList) {
        return (arrayList == null || arrayList.isEmpty()) && i == 6 && this.mMode != 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yt() {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).cn(getPageContext().getString(com.baidu.tieba.t.alert_clean_history)).a(getPageContext().getString(com.baidu.tieba.t.clear_all_text), new ad(this)).b(getPageContext().getString(com.baidu.tieba.t.alert_no_button), new af(this)).b(getPageContext()).rL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yu() {
        this.bBM.setVisibility(8);
        if (this.bCg != null) {
            if (this.bCg.equals(this.bCh)) {
                refresh();
                return;
            }
            this.mHandler.removeCallbacks(this.bCC);
            this.mHandler.postDelayed(this.bCC, 500L);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v5 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i, String str) {
        this.bBT.setVisibility(8);
        if (str != null && str.trim().length() > 0) {
            int i2 = this.bCp ? 1 : 0;
            if (str.equals(this.bCi) && i == this.bCk && this.bCl == i2) {
                refresh();
                return;
            }
            this.bCl = i2;
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append(TbConfig.SERVER_ADDRESS);
            stringBuffer.append(TbConfig.POST_SEARCH_URL);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("word", str));
            arrayList.add(new BasicNameValuePair("pn", String.valueOf(i)));
            arrayList.add(new BasicNameValuePair("rn", String.valueOf(50)));
            arrayList.add(new BasicNameValuePair("only_thread", new StringBuilder().append(i2).toString()));
            arrayList.add(new BasicNameValuePair("st_type", "search_post"));
            FH();
            this.bCf = new ap(this, stringBuffer.toString(), arrayList);
            this.bCf.setPriority(3);
            this.bCf.execute(new Object[0]);
            this.bCq = true;
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

    private void Yv() {
        this.bBY.setNextPage(null);
        this.bCa.clear();
        this.bCa.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        int i;
        int i2 = 0;
        try {
            if (this.mMode == 0) {
                if (this.bCc != null) {
                    if (this.bCc.forum_list != null && this.bCc.forum_list.size() > 0) {
                        Yx();
                        this.bBY.setAdapter((ListAdapter) this.bBZ);
                        this.bBZ.hW(this.bCg);
                        this.bBZ.D(this.bCc.forum_list);
                        this.bBZ.notifyDataSetInvalidated();
                        return;
                    }
                    YB();
                    Yw();
                }
            } else if (this.bCd != null) {
                List<com.baidu.tieba.postsearch.k> list = this.bCd.bWC;
                if (list != null && list.size() > 0) {
                    Yx();
                    if (this.bCd.getCurrentPage() == 1) {
                        this.bBY.setVisibility(0);
                        this.bCa.clear();
                        this.bBY.setAdapter((ListAdapter) this.bCa);
                        this.bBY.setNextPage(YC());
                    }
                    if (!this.bCd.isHasMore()) {
                        YC().setText(getResources().getString(com.baidu.tieba.t.list_no_more));
                        YC().ux();
                    }
                    int aW = this.bCa.aW(list);
                    if (aW > 0) {
                        i = this.bBY.getFirstVisiblePosition() - aW;
                        View childAt = this.bBY.getChildAt(0);
                        if (childAt != null) {
                            i2 = childAt.getTop();
                        }
                    } else {
                        i = 0;
                    }
                    this.bCa.notifyDataSetChanged();
                    if (aW > 0) {
                        this.bBY.setSelectionFromTop(i, i2);
                    }
                    if (this.bCr) {
                        this.bBS.setVisibility(0);
                        this.bCr = false;
                        com.baidu.tbadk.core.sharedPref.b.sl().putBoolean("search_post_show_dropmenu", false);
                    }
                } else if (this.mNoDataView.getVisibility() != 0) {
                    Yz();
                    this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.text_no_suggest));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void Yw() {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ay.getColor(com.baidu.tieba.n.cp_cont_h));
        TextView textView = (TextView) this.bBR.findViewById(com.baidu.tieba.q.no_bar_found);
        textView.setTextColor(ay.getColor(com.baidu.tieba.n.cp_cont_c));
        TextView textView2 = (TextView) this.bBR.findViewById(com.baidu.tieba.q.create_bar_guide);
        textView2.setTextColor(ay.getColor(com.baidu.tieba.n.cp_cont_b));
        String str = "";
        if (this.bCg != null) {
            str = this.bCg.length() > 6 ? String.valueOf(this.bCg.substring(0, 6)) + "..." : this.bCg;
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

    private void Yx() {
        this.bBM.setVisibility(0);
        this.bBY.setVisibility(0);
        this.bBT.setVisibility(8);
        this.mNoDataView.setVisibility(8);
        this.bBS.setVisibility(8);
        this.bBJ.setCompoundDrawablesRightResId(com.baidu.tieba.p.icon_toolbar_arrow_down);
        this.bBJ.cz(TbadkCoreApplication.m411getInst().getSkinType());
        this.bBR.setVisibility(8);
    }

    private void Yy() {
        this.bBM.setVisibility(0);
        this.bBT.setVisibility(0);
        this.bBY.setVisibility(8);
        this.mNoDataView.setVisibility(8);
        this.bBS.setVisibility(8);
        this.bBJ.setCompoundDrawablesRightResId(com.baidu.tieba.p.icon_toolbar_arrow_down);
        this.bBJ.cz(TbadkCoreApplication.m411getInst().getSkinType());
        this.bBR.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yz() {
        this.bBM.setVisibility(8);
        this.bBY.setVisibility(8);
        this.bBT.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.bBS.setVisibility(8);
        this.bBJ.setCompoundDrawablesRightResId(com.baidu.tieba.p.icon_toolbar_arrow_down);
        this.bBJ.cz(TbadkCoreApplication.m411getInst().getSkinType());
        this.bBR.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YA() {
        this.mNoDataView.setVisibility(8);
        this.bBS.setVisibility(0);
    }

    private void YB() {
        this.bBM.setVisibility(8);
        this.bBY.setVisibility(8);
        this.bBT.setVisibility(8);
        this.mNoDataView.setVisibility(8);
        this.bBS.setVisibility(8);
        this.bBJ.setCompoundDrawablesRightResId(com.baidu.tieba.p.icon_toolbar_arrow_down);
        this.bBJ.cz(TbadkCoreApplication.m411getInst().getSkinType());
        this.bBR.setVisibility(0);
    }

    private PbListView YC() {
        if (this.bBX == null) {
            this.bBX = new PbListView(getPageContext().getPageActivity());
            this.bBX.ng();
        }
        return this.bBX;
    }

    @Override // com.baidu.tieba.mainentrance.h
    public void hX(String str) {
        this.bCm = true;
        this.bBF = new ArrayList();
        Yq();
    }

    @Override // com.baidu.tieba.mainentrance.h
    public void aN(List<e> list) {
        this.bCm = true;
        hideLoadingView(this.bBL);
        if (list == null || list.isEmpty()) {
            this.bBF = new ArrayList();
        } else {
            this.bBF = list;
        }
        Yq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bBI.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().j(this.bBK);
        getLayoutMode().j(this.bBR);
        ay.e(this.bBK, i);
        if (this.bBV != null) {
            this.bBV.notifyDataSetChanged();
        }
        if (this.bBZ != null) {
            this.bBZ.notifyDataSetChanged();
        }
        if (this.bCa != null) {
            this.bCa.notifyDataSetChanged();
        }
        if (this.bBU != null) {
            this.bBU.notifyDataSetChanged();
        }
        ay.i(this.bBL, com.baidu.tieba.n.cp_bg_line_d);
        ay.c(this.bBQ, com.baidu.tieba.p.icon_search_ba);
        ay.b(this.bBP, com.baidu.tieba.n.cp_cont_i, 1);
        try {
            hg(i);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    private void hg(int i) {
        if (this.bBW != null) {
            this.bBW.setBackgroundColor(ay.getColor(com.baidu.tieba.n.cp_bg_line_d));
        }
        if (this.bCs != null) {
            this.bCs.setBackgroundColor(ay.getColor(com.baidu.tieba.n.cp_bg_line_b));
        }
        if (this.bCt != null) {
            this.bCt.setTextColor(ay.getColor(com.baidu.tieba.n.cp_cont_c));
        }
        if (this.bCu != null) {
            ((TextView) this.bCu.findViewById(com.baidu.tieba.q.home_bt_search_footer)).setTextColor(ay.getColor(com.baidu.tieba.n.cp_link_tip_a));
        }
        if (this.bCv != null) {
            for (View view : this.bCv) {
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
        if (!this.bCq && this.bCd != null && this.bCd.isHasMore()) {
            z(this.bCd.getCurrentPage() + 1, this.bCg);
            YC().startLoadData();
        }
    }
}
