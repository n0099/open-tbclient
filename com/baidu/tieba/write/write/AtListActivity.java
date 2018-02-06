package com.baidu.tieba.write.write;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.d;
import com.baidu.tieba.write.write.AtSelectFriendList;
import com.baidu.tieba.write.write.a;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class AtListActivity extends BaseActivity<AtListActivity> implements AdapterView.OnItemClickListener, a.b {
    private NoNetworkView dpu;
    private LinearLayout eQZ;
    private Button eRa;
    private View eRe;
    private View eRf;
    private ImageView eRh;
    private AtSelectFriendList hJC;
    private TextView hJJ;
    private TextView hJK;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.h mNoDataView;
    protected ArrayList<MetaData> hJB = new ArrayList<>();
    private EditText rE = null;
    private TextView bSy = null;
    private BdListView avh = null;
    private final Handler mHandler = new Handler();
    private a hJD = null;
    private b hJE = null;
    private com.baidu.tieba.write.model.b hJF = null;
    private com.baidu.tieba.write.write.a hJG = null;
    private String hJH = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View hJI = null;
    private final int hJL = 5;
    private boolean hJM = true;
    private boolean hJN = false;
    private final Runnable hJO = new Runnable() { // from class: com.baidu.tieba.write.write.AtListActivity.1
        @Override // java.lang.Runnable
        public void run() {
            AtListActivity.this.uH(k.a(AtListActivity.this.rE.getText(), ""));
        }
    };
    private NoNetworkView.a hib = new NoNetworkView.a() { // from class: com.baidu.tieba.write.write.AtListActivity.6
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bu(boolean z) {
            if (z) {
                AtListActivity.this.uH(null);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.at_list_activity);
        initData(bundle);
        initUI();
        uH(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().aQ(i == 1);
        getLayoutMode().aM(this.mParent);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dpu.onChangeSkinType(getPageContext(), i);
        this.hJG.notifyDataSetChanged();
        aj.getColor(d.C0140d.common_color_10221);
        aj.s(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        aj.s(this.eRa, d.f.post_button_bg);
        aj.e(this.eRa, d.C0140d.cp_cont_i, 3);
        aj.a(this.eRh, d.f.icon_search_bg_s, d.f.icon_search_bg);
        aj.r(this.hJK, d.C0140d.navi_back_text_color);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.mNoDataView.e(getPageContext());
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.mNoDataView.onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xI(int i) {
        if (i == 2) {
            this.avh.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.no_chat_friends));
            this.eQZ.setVisibility(8);
        } else if (i == 1) {
            this.avh.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(d.j.no_search_friends));
            this.eQZ.setVisibility(8);
        } else if (i == 0) {
            this.avh.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.hJM) {
                this.eQZ.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.hJG.getItem(i);
        if (item != null) {
            if (this.hJM) {
                if (this.hJD == null && this.hJE == null) {
                    if (item.isChecked()) {
                        e(item);
                    } else if (5 <= this.hJC.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(d.j.invite_friend_exceed_max_count), 5), d.f.icon_toast_game_error);
                        return;
                    } else {
                        d(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.hJG.notifyDataSetChanged();
                    return;
                }
                return;
            }
            l.a(getPageContext().getPageActivity(), this.rE);
            if (this.hJN) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this, item.getUserIdLong(), item.getName_show(), item.getPortrait(), item.getGender(), item.getIsMyFriend())));
                TiebaStatic.log(new ak("c12930").f("obj_id", item.getUserIdLong()));
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("name_show", item.getName_show());
            bundle.putString("user_name", item.getUserName());
            bundle.putString("user_id", item.getUserId());
            bundle.putString(IntentConfig.PORTRAIT, item.getPortrait());
            intent.putExtras(bundle);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hJD != null) {
            this.hJD.cancel();
        }
        if (this.hJE != null) {
            this.hJE.cancel();
        }
        this.mHandler.removeCallbacks(this.hJO);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.t(getActivity(), d.e.ds320)), NoDataViewFactory.d.gp(d.j.no_chat_friends), null, true);
        this.hJI = findViewById(d.g.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.rE);
                    return false;
                }
                return false;
            }
        });
        awN();
        this.dpu = (NoNetworkView) findViewById(d.g.view_no_network);
        this.dpu.a(this.hib);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        this.avh = (BdListView) findViewById(d.g.list);
        this.hJG = new com.baidu.tieba.write.write.a(this, this.hJM);
        this.hJG.a(this);
        this.hJG.a(new TbCheckBox.a() { // from class: com.baidu.tieba.write.write.AtListActivity.8
            @Override // com.baidu.tbadk.core.view.TbCheckBox.a
            public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
                if (obj != null && (obj instanceof MetaData)) {
                    if (!z) {
                        AtListActivity.this.e((MetaData) obj);
                    } else if (5 <= AtListActivity.this.hJC.getItemLength()) {
                        AtListActivity.this.showToastWithIcon(String.format(AtListActivity.this.getPageContext().getString(d.j.invite_friend_exceed_max_count), 5), d.f.icon_toast_game_error);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                    } else {
                        AtListActivity.this.d((MetaData) obj);
                    }
                }
            }
        });
        this.avh.setAdapter((ListAdapter) this.hJG);
        this.avh.setOnItemClickListener(this);
        this.avh.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.AtListActivity.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.rE);
                    return false;
                }
                return false;
            }
        });
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.rE.getParent() != null) {
            ((View) this.rE.getParent()).setFocusable(true);
            ((View) this.rE.getParent()).setFocusableInTouchMode(true);
        }
        this.eQZ = (LinearLayout) this.mParent.findViewById(d.g.invite_candidate);
        this.eRa = (Button) this.mParent.findViewById(d.g.button_send);
        this.eRa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", AtListActivity.this.hJC.getDataList());
                intent.putExtras(bundle);
                l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.rE);
                AtListActivity.this.setResult(-1, intent);
                AtListActivity.this.finish();
            }
        });
        qH(0);
        this.hJC = (AtSelectFriendList) this.mParent.findViewById(d.g.candidate_list);
        this.hJC.setMaxCount(5);
        this.hJC.setItemOPerationHandler(new AtSelectFriendList.a() { // from class: com.baidu.tieba.write.write.AtListActivity.11
            @Override // com.baidu.tieba.write.write.AtSelectFriendList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = AtListActivity.this.avh.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof MetaData) {
                        AtListActivity.this.e((MetaData) obj);
                    }
                }
            }
        });
        aNg();
    }

    private void awN() {
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.hJK = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(d.j.cancel), new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AtListActivity.this.eRe != null && AtListActivity.this.eRe.getVisibility() == 0) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.rE);
                    AtListActivity.this.eRe.setVisibility(8);
                    AtListActivity.this.hJJ.setVisibility(0);
                    AtListActivity.this.eRf.setVisibility(0);
                    AtListActivity.this.rE.getText().clear();
                    return;
                }
                l.a(AtListActivity.this.getPageContext().getPageActivity(), AtListActivity.this.rE);
                AtListActivity.this.finish();
            }
        });
        this.hJJ = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.j.select_friend));
        this.eRf = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.hJJ.setVisibility(8);
                AtListActivity.this.eRf.setVisibility(8);
                AtListActivity.this.eRe.setVisibility(0);
                AtListActivity.this.rE.requestFocus();
            }
        });
        this.eRh = (ImageView) this.eRf.findViewById(d.g.new_friend_search);
        this.eRe = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.eRe.setVisibility(8);
        this.rE = (EditText) this.eRe.findViewById(d.g.search_bar_edit);
        this.rE.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.AtListActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a2 = k.a(editable, null);
                if (a2 != null) {
                    if (!a2.equals(AtListActivity.this.hJH)) {
                        AtListActivity.this.mHandler.removeCallbacks(AtListActivity.this.hJO);
                        AtListActivity.this.mHandler.postDelayed(AtListActivity.this.hJO, 300L);
                    }
                    if (a2.length() > 0) {
                        AtListActivity.this.bSy.setVisibility(0);
                    } else {
                        AtListActivity.this.bSy.setVisibility(8);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AtListActivity.this.hJH = k.a(charSequence, null);
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.rE.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.AtListActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.a(AtListActivity.this.getPageContext().getPageActivity(), view);
                } else {
                    l.b(AtListActivity.this.getPageContext().getPageActivity(), view);
                }
            }
        });
        this.bSy = (TextView) findViewById(d.g.search_bar_delete_button);
        this.bSy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.rE.getText().clear();
            }
        });
    }

    private void aNg() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds80) + getResources().getDimensionPixelSize(d.e.ds16) + getResources().getDimensionPixelSize(d.e.ds16);
        this.mListFooter = new View(getPageContext().getContext());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setFocusable(false);
        this.mListFooter.setFocusableInTouchMode(false);
        this.mListFooter.setContentDescription("");
        this.mListFooter.setVisibility(4);
        this.mListFooter.setBackgroundColor(0);
        this.mListFooter.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtListActivity.this.avh.requestFocus();
            }
        });
        this.avh.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uH(String str) {
        if (!isFinishing()) {
            this.hJG.setData(null);
            if (this.hJD != null) {
                this.hJD.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.hJF.bGT() != null) {
                    ArrayList<MetaData> bGI = this.hJF.bGT().bGI();
                    Iterator<MetaData> it = bGI.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (bGI != null && !bGI.isEmpty()) {
                        xI(0);
                    } else {
                        xI(1);
                    }
                    this.hJG.setData(bGI);
                } else {
                    this.hJG.setData(null);
                    if (this.hJE == null) {
                        this.hJE = new b();
                        this.hJE.setPriority(3);
                        this.hJE.execute("");
                    }
                }
            } else {
                this.hJD = new a();
                this.hJD.setPriority(2);
                this.hJD.execute(str);
                if (this.hJE == null && this.hJF.bGT() == null) {
                    this.hJE = new b();
                    this.hJE.setPriority(3);
                    this.hJE.execute("");
                }
            }
            this.hJG.notifyDataSetInvalidated();
            this.avh.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.hJF = new com.baidu.tieba.write.model.b();
        if (bundle != null) {
            this.hJM = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
            this.hJN = bundle.getBoolean(AtListActivityConfig.IS_FOR_CHAT, false);
            return;
        }
        this.hJM = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        this.hJN = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_CHAT, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.hJC.f(metaData);
            qH(this.hJC.getItemLength());
            aNh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MetaData metaData) {
        if (metaData != null) {
            this.hJC.h(metaData);
            qH(this.hJC.getItemLength());
            aNh();
        }
    }

    private void aNh() {
        if (this.hJC.getItemLength() > 0) {
            this.eRa.setEnabled(true);
        } else {
            this.eRa.setEnabled(false);
        }
    }

    private void qH(int i) {
        this.eRa.setText(String.format(getPageContext().getString(d.j.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.c> {
        private String hJQ;
        private x mNetwork;

        private a() {
            this.mNetwork = null;
            this.hJQ = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.hJD = null;
            this.hJQ = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public com.baidu.tieba.write.a.c doInBackground(String... strArr) {
            this.hJQ = strArr[0];
            this.mNetwork = new x();
            if (this.hJQ == null || this.hJQ.length() <= 0) {
                return null;
            }
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/sug");
            this.mNetwork.n("uid", TbadkCoreApplication.getCurrentAccount());
            this.mNetwork.n(WidgetRequestParam.REQ_PARAM_COMMENT_TOPIC, this.hJQ);
            if (AtListActivity.this.hJN) {
                this.mNetwork.n("from", "1");
            } else {
                this.mNetwork.n("from", "0");
            }
            String Cb = this.mNetwork.Cb();
            if (!this.mNetwork.Cz().Dx().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
            cVar.a(Cb, AtListActivity.this.hJF.bGT());
            return cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.c cVar) {
            AtListActivity.this.hJD = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.Cz().Dx().isRequestSuccess() && this.hJQ != null && k.a(AtListActivity.this.rE.getText(), "").equals(this.hJQ)) {
                if (cVar == null || cVar.bGK().isEmpty()) {
                    AtListActivity.this.xI(1);
                } else {
                    AtListActivity.this.xI(0);
                }
                AtListActivity.this.hJF.a(cVar);
                AtListActivity.this.hJG.setData(cVar.bGK());
                AtListActivity.this.hJG.notifyDataSetInvalidated();
                AtListActivity.this.avh.setSelection(0);
            } else {
                AtListActivity.this.showToast(this.mNetwork.getErrorString());
            }
            super.onPostExecute(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.b> {
        private x mNetwork;

        private b() {
            this.mNetwork = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.mS();
            }
            AtListActivity.this.hJE = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.mNetwork = new x();
            this.mNetwork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/list");
            if (AtListActivity.this.hJN) {
                this.mNetwork.n("from", "1");
            } else {
                this.mNetwork.n("from", "0");
            }
            String Cb = this.mNetwork.Cb();
            if (!this.mNetwork.Cz().Dx().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.uu(Cb);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.hJE = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.eQZ != null && AtListActivity.this.eQZ.getVisibility() == 0) {
                AtListActivity.this.hJI.setVisibility(0);
            }
            if (this.mNetwork.Cz().Dx().isRequestSuccess()) {
                AtListActivity.this.hJF.a(bVar);
                if (AtListActivity.this.hJG != null) {
                    if (k.a(AtListActivity.this.rE.getText(), "").length() != 0) {
                        if (AtListActivity.this.hJF.bGU() != null) {
                            if (bVar != null && bVar.bGJ() != null && !bVar.bGJ().isEmpty()) {
                                AtListActivity.this.xI(2);
                            }
                            AtListActivity.this.hJF.bGU().n(bVar.bGJ());
                            AtListActivity.this.hJG.notifyDataSetInvalidated();
                        }
                    } else {
                        if (bVar == null || bVar.bGI() == null || !bVar.bGI().isEmpty()) {
                            AtListActivity.this.xI(0);
                        } else {
                            AtListActivity.this.xI(2);
                        }
                        AtListActivity.this.hJB = bVar.bGI();
                        AtListActivity.this.hJG.setData(AtListActivity.this.hJB);
                        AtListActivity.this.hJG.notifyDataSetInvalidated();
                        AtListActivity.this.avh.setSelection(0);
                    }
                } else {
                    return;
                }
            } else {
                AtListActivity.this.showToast(this.mNetwork.getErrorString());
            }
            super.onPostExecute(bVar);
        }
    }

    @Override // com.baidu.tieba.write.write.a.b
    public void a(View view, MetaData metaData) {
        if (metaData != null) {
            this.hJC.g(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.l onGetPreLoadListView() {
        if (this.avh == null) {
            return null;
        }
        return this.avh.getPreLoadHandle();
    }
}
