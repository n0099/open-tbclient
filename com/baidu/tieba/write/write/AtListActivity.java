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
    private NoNetworkView bEr;
    private LinearLayout dja;
    private Button djb;
    private View djf;
    private View djg;
    private ImageView dji;
    private AtSelectFriendList fQs;
    private TextView fQz;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.y mNoDataView;
    protected ArrayList<MetaData> fQq = new ArrayList<>();
    private EditText dfv = null;
    private TextView fQr = null;
    private BdListView Ik = null;
    private final Handler mHandler = new Handler();
    private a fQt = null;
    private b fQu = null;
    private com.baidu.tieba.write.c.a fQv = null;
    private n fQw = null;
    private String fQx = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View fQy = null;
    private final int fQA = 5;
    private boolean fQB = true;
    private final Runnable fQC = new com.baidu.tieba.write.write.a(this);
    private NoNetworkView.a fCv = new f(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.j.at_list_activity);
        initData(bundle);
        initUI();
        rk(null);
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
        this.bEr.onChangeSkinType(getPageContext(), i);
        this.fQw.notifyDataSetChanged();
        com.baidu.tbadk.core.util.aq.getColor(w.e.common_color_10221);
        com.baidu.tbadk.core.util.aq.j(this.mListFooter, w.g.invite_friend_list_item_bg_color);
        com.baidu.tbadk.core.util.aq.j(this.djb, w.g.post_button_bg);
        com.baidu.tbadk.core.util.aq.c(this.djb, w.e.cp_cont_i, 3);
        com.baidu.tbadk.core.util.aq.b(this.dji, w.g.icon_search_bg_s, w.g.icon_search_bg);
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
    public void tf(int i) {
        if (i == 2) {
            this.Ik.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dh(w.l.no_chat_friends));
            this.dja.setVisibility(8);
        } else if (i == 1) {
            this.Ik.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dh(w.l.no_search_friends));
            this.dja.setVisibility(8);
        } else if (i == 0) {
            this.Ik.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.fQB) {
                this.dja.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.fQw.getItem(i);
        if (item != null) {
            if (this.fQB) {
                if (this.fQt == null && this.fQu == null) {
                    if (item.isChecked()) {
                        c(item);
                    } else if (5 <= this.fQs.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(w.l.invite_friend_exceed_max_count), 5), w.g.icon_toast_game_error);
                        return;
                    } else {
                        b(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.fQw.notifyDataSetChanged();
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
            com.baidu.adp.lib.util.k.b(getPageContext().getPageActivity(), this.dfv);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fQt != null) {
            this.fQt.cancel();
        }
        if (this.fQu != null) {
            this.fQu.cancel();
        }
        this.mHandler.removeCallbacks(this.fQC);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(w.h.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.adp.lib.util.k.g(getActivity(), w.f.ds320)), NoDataViewFactory.d.dh(w.l.no_chat_friends), null, true);
        this.fQy = findViewById(w.h.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new g(this));
        auG();
        this.bEr = (NoNetworkView) findViewById(w.h.view_no_network);
        this.bEr.a(this.fCv);
        this.mProgress = (ProgressBar) findViewById(w.h.progress);
        this.Ik = (BdListView) findViewById(w.h.list);
        this.fQw = new n(this, this.fQB);
        this.fQw.a(this);
        this.fQw.a(new h(this));
        this.Ik.setAdapter((ListAdapter) this.fQw);
        this.Ik.setOnItemClickListener(this);
        this.Ik.setOnTouchListener(new i(this));
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.dfv.getParent() != null) {
            ((View) this.dfv.getParent()).setFocusable(true);
            ((View) this.dfv.getParent()).setFocusableInTouchMode(true);
        }
        this.dja = (LinearLayout) this.mParent.findViewById(w.h.invite_candidate);
        this.djb = (Button) this.mParent.findViewById(w.h.button_send);
        this.djb.setOnClickListener(new j(this));
        me(0);
        this.fQs = (AtSelectFriendList) this.mParent.findViewById(w.h.candidate_list);
        this.fQs.setMaxCount(5);
        this.fQs.setItemOPerationHandler(new k(this));
        auQ();
    }

    private void auG() {
        this.mNavigationBar = (NavigationBar) findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new l(this));
        this.fQz = this.mNavigationBar.setTitleText(getPageContext().getString(w.l.select_friend));
        this.djg = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.add_new_friend_text, new m(this));
        this.dji = (ImageView) this.djg.findViewById(w.h.new_friend_search);
        this.djf = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.navigationbar_search_edit, (View.OnClickListener) null);
        this.djf.setVisibility(8);
        this.dfv = (EditText) this.djf.findViewById(w.h.search_bar_edit);
        this.dfv.addTextChangedListener(new com.baidu.tieba.write.write.b(this));
        this.dfv.setOnFocusChangeListener(new c(this));
        this.fQr = (TextView) findViewById(w.h.search_bar_delete_button);
        this.fQr.setOnClickListener(new d(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [469=4] */
    private void auQ() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds80) + getResources().getDimensionPixelSize(w.f.ds16) + getResources().getDimensionPixelSize(w.f.ds16);
        this.mListFooter = new View(getPageContext().getContext());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setFocusable(false);
        this.mListFooter.setFocusableInTouchMode(false);
        this.mListFooter.setContentDescription("");
        this.mListFooter.setVisibility(4);
        this.mListFooter.setBackgroundColor(0);
        this.mListFooter.setOnClickListener(new e(this));
        this.Ik.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rk(String str) {
        if (!isFinishing()) {
            this.fQw.setData(null);
            if (this.fQt != null) {
                this.fQt.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.fQv.bnW() != null) {
                    ArrayList<MetaData> bnS = this.fQv.bnW().bnS();
                    Iterator<MetaData> it = bnS.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (bnS != null && !bnS.isEmpty()) {
                        tf(0);
                    } else {
                        tf(1);
                    }
                    this.fQw.setData(bnS);
                } else {
                    this.fQw.setData(null);
                    if (this.fQu == null) {
                        this.fQu = new b(this, null);
                        this.fQu.setPriority(3);
                        this.fQu.execute("");
                    }
                }
            } else {
                this.fQt = new a(this, null);
                this.fQt.setPriority(2);
                this.fQt.execute(str);
                if (this.fQu == null && this.fQv.bnW() == null) {
                    this.fQu = new b(this, null);
                    this.fQu.setPriority(3);
                    this.fQu.execute("");
                }
            }
            this.fQw.notifyDataSetInvalidated();
            this.Ik.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.fQv = new com.baidu.tieba.write.c.a();
        if (bundle != null) {
            this.fQB = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.fQB = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MetaData metaData) {
        if (metaData != null) {
            this.fQs.d(metaData);
            me(this.fQs.getItemLength());
            auR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(MetaData metaData) {
        if (metaData != null) {
            this.fQs.f(metaData);
            me(this.fQs.getItemLength());
            auR();
        }
    }

    private void auR() {
        if (this.fQs.getItemLength() > 0) {
            this.djb.setEnabled(true);
        } else {
            this.djb.setEnabled(false);
        }
    }

    private void me(int i) {
        this.djb.setText(String.format(getPageContext().getString(w.l.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.b> {
        private String fQE;
        private com.baidu.tbadk.core.util.z mNetwork;

        private a() {
            this.mNetwork = null;
            this.fQE = null;
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
            AtListActivity.this.fQt = null;
            this.fQE = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.fQE = strArr[0];
            this.mNetwork = new com.baidu.tbadk.core.util.z();
            if (this.fQE != null && this.fQE.length() > 0) {
                this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/sug");
                this.mNetwork.n(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.n("q", this.fQE);
                String uY = this.mNetwork.uY();
                if (this.mNetwork.vw().wq().isRequestSuccess()) {
                    com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
                    com.baidu.tieba.write.a.a bnW = AtListActivity.this.fQv.bnW();
                    if (bnW != null) {
                        bVar.e(uY, bnW.bnT());
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
            AtListActivity.this.fQt = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.vw().wq().isRequestSuccess() && this.fQE != null && com.baidu.adp.lib.util.j.a(AtListActivity.this.dfv.getText(), "").equals(this.fQE)) {
                if (bVar == null || bVar.bnU().isEmpty()) {
                    AtListActivity.this.tf(1);
                } else {
                    AtListActivity.this.tf(0);
                }
                AtListActivity.this.fQv.a(bVar);
                AtListActivity.this.fQw.setData(bVar.bnU());
                AtListActivity.this.fQw.notifyDataSetInvalidated();
                AtListActivity.this.Ik.setSelection(0);
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
                this.mNetwork.fr();
            }
            AtListActivity.this.fQu = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: H */
        public com.baidu.tieba.write.a.a doInBackground(String... strArr) {
            this.mNetwork = new com.baidu.tbadk.core.util.z();
            this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/list");
            String uY = this.mNetwork.uY();
            if (!this.mNetwork.vw().wq().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.rc(uY);
            return aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.a aVar) {
            AtListActivity.this.fQu = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.dja != null && AtListActivity.this.dja.getVisibility() == 0) {
                AtListActivity.this.fQy.setVisibility(0);
            }
            if (this.mNetwork.vw().wq().isRequestSuccess()) {
                AtListActivity.this.fQv.a(aVar);
                if (AtListActivity.this.fQw != null) {
                    if (com.baidu.adp.lib.util.j.a(AtListActivity.this.dfv.getText(), "").length() != 0) {
                        if (AtListActivity.this.fQv.bnX() != null) {
                            if (aVar != null && aVar.bnT() != null && !aVar.bnT().isEmpty()) {
                                AtListActivity.this.tf(2);
                            }
                            AtListActivity.this.fQv.bnX().k(aVar.bnT());
                            AtListActivity.this.fQw.notifyDataSetInvalidated();
                        }
                    } else {
                        if (aVar == null || aVar.bnS() == null || !aVar.bnS().isEmpty()) {
                            AtListActivity.this.tf(0);
                        } else {
                            AtListActivity.this.tf(2);
                        }
                        AtListActivity.this.fQq = aVar.bnS();
                        AtListActivity.this.fQw.setData(AtListActivity.this.fQq);
                        AtListActivity.this.fQw.notifyDataSetInvalidated();
                        AtListActivity.this.Ik.setSelection(0);
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
            this.fQs.e(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.Ik;
    }
}
