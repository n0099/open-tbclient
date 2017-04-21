package com.baidu.tieba.write.write;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.w;
import com.baidu.tieba.write.write.n;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class AtListActivity extends BaseActivity<AtListActivity> implements AdapterView.OnItemClickListener, n.b {
    private NoNetworkView bGI;
    private LinearLayout dlr;
    private Button dls;
    private View dlw;
    private View dlx;
    private ImageView dlz;
    private AtSelectFriendList fSO;
    private TextView fSV;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.y mNoDataView;
    protected ArrayList<MetaData> fSM = new ArrayList<>();
    private EditText dhM = null;
    private TextView fSN = null;
    private BdListView Im = null;
    private final Handler mHandler = new Handler();
    private a fSP = null;
    private b fSQ = null;
    private com.baidu.tieba.write.c.a fSR = null;
    private n fSS = null;
    private String fST = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View fSU = null;
    private final int fSW = 5;
    private boolean fSX = true;
    private final Runnable fSY = new com.baidu.tieba.write.write.a(this);
    private NoNetworkView.a fEL = new f(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.j.at_list_activity);
        initData(bundle);
        initUI();
        rl(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().aj(i == 1);
        getLayoutMode().t(this.mParent);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bGI.onChangeSkinType(getPageContext(), i);
        this.fSS.notifyDataSetChanged();
        com.baidu.tbadk.core.util.aq.getColor(w.e.common_color_10221);
        com.baidu.tbadk.core.util.aq.j(this.mListFooter, w.g.invite_friend_list_item_bg_color);
        com.baidu.tbadk.core.util.aq.j(this.dls, w.g.post_button_bg);
        com.baidu.tbadk.core.util.aq.c(this.dls, w.e.cp_cont_i, 3);
        com.baidu.tbadk.core.util.aq.b(this.dlz, w.g.icon_search_bg_s, w.g.icon_search_bg);
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
    public void tl(int i) {
        if (i == 2) {
            this.Im.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dh(w.l.no_chat_friends));
            this.dlr.setVisibility(8);
        } else if (i == 1) {
            this.Im.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dh(w.l.no_search_friends));
            this.dlr.setVisibility(8);
        } else if (i == 0) {
            this.Im.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.fSX) {
                this.dlr.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.fSS.getItem(i);
        if (item != null) {
            if (this.fSX) {
                if (this.fSP == null && this.fSQ == null) {
                    if (item.isChecked()) {
                        c(item);
                    } else if (5 <= this.fSO.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(w.l.invite_friend_exceed_max_count), 5), w.g.icon_toast_game_error);
                        return;
                    } else {
                        b(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.fSS.notifyDataSetChanged();
                    return;
                }
                return;
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString(IntentConfig.NAME_SHOW, item.getName_show());
            bundle.putString("user_name", item.getUserName());
            bundle.putString("user_id", item.getUserId());
            bundle.putString(IntentConfig.PORTRAIT, item.getPortrait());
            intent.putExtras(bundle);
            com.baidu.adp.lib.util.k.b(getPageContext().getPageActivity(), this.dhM);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fSP != null) {
            this.fSP.cancel();
        }
        if (this.fSQ != null) {
            this.fSQ.cancel();
        }
        this.mHandler.removeCallbacks(this.fSY);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(w.h.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.adp.lib.util.k.g(getActivity(), w.f.ds320)), NoDataViewFactory.d.dh(w.l.no_chat_friends), null, true);
        this.fSU = findViewById(w.h.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new g(this));
        avH();
        this.bGI = (NoNetworkView) findViewById(w.h.view_no_network);
        this.bGI.a(this.fEL);
        this.mProgress = (ProgressBar) findViewById(w.h.progress);
        this.Im = (BdListView) findViewById(w.h.list);
        this.fSS = new n(this, this.fSX);
        this.fSS.a(this);
        this.fSS.a(new h(this));
        this.Im.setAdapter((ListAdapter) this.fSS);
        this.Im.setOnItemClickListener(this);
        this.Im.setOnTouchListener(new i(this));
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.dhM.getParent() != null) {
            ((View) this.dhM.getParent()).setFocusable(true);
            ((View) this.dhM.getParent()).setFocusableInTouchMode(true);
        }
        this.dlr = (LinearLayout) this.mParent.findViewById(w.h.invite_candidate);
        this.dls = (Button) this.mParent.findViewById(w.h.button_send);
        this.dls.setOnClickListener(new j(this));
        mk(0);
        this.fSO = (AtSelectFriendList) this.mParent.findViewById(w.h.candidate_list);
        this.fSO.setMaxCount(5);
        this.fSO.setItemOPerationHandler(new k(this));
        avR();
    }

    private void avH() {
        this.mNavigationBar = (NavigationBar) findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new l(this));
        this.fSV = this.mNavigationBar.setTitleText(getPageContext().getString(w.l.select_friend));
        this.dlx = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.add_new_friend_text, new m(this));
        this.dlz = (ImageView) this.dlx.findViewById(w.h.new_friend_search);
        this.dlw = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.navigationbar_search_edit, (View.OnClickListener) null);
        this.dlw.setVisibility(8);
        this.dhM = (EditText) this.dlw.findViewById(w.h.search_bar_edit);
        this.dhM.addTextChangedListener(new com.baidu.tieba.write.write.b(this));
        this.dhM.setOnFocusChangeListener(new c(this));
        this.fSN = (TextView) findViewById(w.h.search_bar_delete_button);
        this.fSN.setOnClickListener(new d(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [469=4] */
    private void avR() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds80) + getResources().getDimensionPixelSize(w.f.ds16) + getResources().getDimensionPixelSize(w.f.ds16);
        this.mListFooter = new View(getPageContext().getContext());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setFocusable(false);
        this.mListFooter.setFocusableInTouchMode(false);
        this.mListFooter.setContentDescription("");
        this.mListFooter.setVisibility(4);
        this.mListFooter.setBackgroundColor(0);
        this.mListFooter.setOnClickListener(new e(this));
        this.Im.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rl(String str) {
        if (!isFinishing()) {
            this.fSS.setData(null);
            if (this.fSP != null) {
                this.fSP.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.fSR.boX() != null) {
                    ArrayList<MetaData> boT = this.fSR.boX().boT();
                    Iterator<MetaData> it = boT.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (boT != null && !boT.isEmpty()) {
                        tl(0);
                    } else {
                        tl(1);
                    }
                    this.fSS.setData(boT);
                } else {
                    this.fSS.setData(null);
                    if (this.fSQ == null) {
                        this.fSQ = new b(this, null);
                        this.fSQ.setPriority(3);
                        this.fSQ.execute("");
                    }
                }
            } else {
                this.fSP = new a(this, null);
                this.fSP.setPriority(2);
                this.fSP.execute(str);
                if (this.fSQ == null && this.fSR.boX() == null) {
                    this.fSQ = new b(this, null);
                    this.fSQ.setPriority(3);
                    this.fSQ.execute("");
                }
            }
            this.fSS.notifyDataSetInvalidated();
            this.Im.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.fSR = new com.baidu.tieba.write.c.a();
        if (bundle != null) {
            this.fSX = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.fSX = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MetaData metaData) {
        if (metaData != null) {
            this.fSO.d(metaData);
            mk(this.fSO.getItemLength());
            avS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(MetaData metaData) {
        if (metaData != null) {
            this.fSO.f(metaData);
            mk(this.fSO.getItemLength());
            avS();
        }
    }

    private void avS() {
        if (this.fSO.getItemLength() > 0) {
            this.dls.setEnabled(true);
        } else {
            this.dls.setEnabled(false);
        }
    }

    private void mk(int i) {
        this.dls.setText(String.format(getPageContext().getString(w.l.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.b> {
        private String fTa;
        private com.baidu.tbadk.core.util.z mNetwork;

        private a() {
            this.mNetwork = null;
            this.fTa = null;
        }

        /* synthetic */ a(AtListActivity atListActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.fSP = null;
            this.fTa = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.fTa = strArr[0];
            this.mNetwork = new com.baidu.tbadk.core.util.z();
            if (this.fTa != null && this.fTa.length() > 0) {
                this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/sug");
                this.mNetwork.n(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.n("q", this.fTa);
                String uY = this.mNetwork.uY();
                if (this.mNetwork.vw().wq().isRequestSuccess()) {
                    com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
                    com.baidu.tieba.write.a.a boX = AtListActivity.this.fSR.boX();
                    if (boX != null) {
                        bVar.e(uY, boX.boU());
                        return bVar;
                    }
                    bVar.e(uY, null);
                    return bVar;
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.fSP = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.vw().wq().isRequestSuccess() && this.fTa != null && com.baidu.adp.lib.util.j.a(AtListActivity.this.dhM.getText(), "").equals(this.fTa)) {
                if (bVar == null || bVar.boV().isEmpty()) {
                    AtListActivity.this.tl(1);
                } else {
                    AtListActivity.this.tl(0);
                }
                AtListActivity.this.fSR.a(bVar);
                AtListActivity.this.fSS.setData(bVar.boV());
                AtListActivity.this.fSS.notifyDataSetInvalidated();
                AtListActivity.this.Im.setSelection(0);
            } else {
                AtListActivity.this.showToast(this.mNetwork.getErrorString());
            }
            super.onPostExecute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.a> {
        private com.baidu.tbadk.core.util.z mNetwork;

        private b() {
            this.mNetwork = null;
        }

        /* synthetic */ b(AtListActivity atListActivity, b bVar) {
            this();
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
                this.mNetwork.fs();
            }
            AtListActivity.this.fSQ = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public com.baidu.tieba.write.a.a doInBackground(String... strArr) {
            this.mNetwork = new com.baidu.tbadk.core.util.z();
            this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/list");
            String uY = this.mNetwork.uY();
            if (!this.mNetwork.vw().wq().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.rd(uY);
            return aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.a aVar) {
            AtListActivity.this.fSQ = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.dlr != null && AtListActivity.this.dlr.getVisibility() == 0) {
                AtListActivity.this.fSU.setVisibility(0);
            }
            if (this.mNetwork.vw().wq().isRequestSuccess()) {
                AtListActivity.this.fSR.a(aVar);
                if (AtListActivity.this.fSS != null) {
                    if (com.baidu.adp.lib.util.j.a(AtListActivity.this.dhM.getText(), "").length() != 0) {
                        if (AtListActivity.this.fSR.boY() != null) {
                            if (aVar != null && aVar.boU() != null && !aVar.boU().isEmpty()) {
                                AtListActivity.this.tl(2);
                            }
                            AtListActivity.this.fSR.boY().k(aVar.boU());
                            AtListActivity.this.fSS.notifyDataSetInvalidated();
                        }
                    } else {
                        if (aVar == null || aVar.boT() == null || !aVar.boT().isEmpty()) {
                            AtListActivity.this.tl(0);
                        } else {
                            AtListActivity.this.tl(2);
                        }
                        AtListActivity.this.fSM = aVar.boT();
                        AtListActivity.this.fSS.setData(AtListActivity.this.fSM);
                        AtListActivity.this.fSS.notifyDataSetInvalidated();
                        AtListActivity.this.Im.setSelection(0);
                    }
                } else {
                    return;
                }
            } else {
                AtListActivity.this.showToast(this.mNetwork.getErrorString());
            }
            super.onPostExecute(aVar);
        }
    }

    @Override // com.baidu.tieba.write.write.n.b
    public void a(View view, MetaData metaData) {
        if (metaData != null) {
            this.fSO.e(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.Im;
    }
}
