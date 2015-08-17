package com.baidu.tieba.write.write;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.i;
import com.baidu.tieba.write.write.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public class AtListActivity extends BaseActivity<AtListActivity> implements AdapterView.OnItemClickListener, m.b {
    private NoNetworkView aNx;
    private LinearLayout bJD;
    private Button bJE;
    private View bJF;
    private View bJJ;
    private View bJK;
    private AtSelectFriendList cSY;
    private TextView cTf;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.u mNoDataView;
    protected ArrayList<MetaData> cSW = new ArrayList<>();
    private EditText bEb = null;
    private TextView cSX = null;
    private BdListView mListView = null;
    private final Handler mHandler = new Handler();
    private a cSZ = null;
    private b cTa = null;
    private com.baidu.tieba.write.c.a cTb = null;
    private m cTc = null;
    private String cTd = null;
    private ProgressBar mProgress = null;
    private RelativeLayout bnG = null;
    private View cTe = null;
    private final int cTg = 5;
    private boolean cTh = true;
    private final Runnable cTi = new com.baidu.tieba.write.write.a(this);
    private NoNetworkView.a cTj = new e(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.at_list_activity);
        initData(bundle);
        initUI();
        lc(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.bnG);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aNx.onChangeSkinType(getPageContext(), i);
        this.cTc.notifyDataSetChanged();
        com.baidu.tbadk.core.util.al.getColor(i.c.widget_searchbox_text);
        com.baidu.tbadk.core.util.al.i(this.bJF, i.e.invite_friend_list_item_bg_color);
        com.baidu.tbadk.core.util.al.i((View) this.bJE, i.e.post_button_bg);
        com.baidu.tbadk.core.util.al.b(this.bJE, i.c.cp_cont_i, 3);
        this.bJF.setEnabled(false);
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
    public void kv(int i) {
        if (i == 2) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cD(i.C0057i.no_chat_friends));
            this.bJD.setVisibility(8);
        } else if (i == 1) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cD(i.C0057i.no_search_friends));
            this.bJD.setVisibility(8);
        } else if (i == 0) {
            this.mListView.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.cTh) {
                this.bJD.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.cTc.getItem(i);
        if (item != null) {
            if (this.cTh) {
                if (this.cSZ == null && this.cTa == null) {
                    if (item.isChecked()) {
                        b(item);
                    } else if (5 <= this.cSY.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(i.C0057i.invite_friend_exceed_max_count), 5), i.e.icon_toast_game_error);
                        return;
                    } else {
                        a(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.cTc.notifyDataSetChanged();
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
            com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), this.bEb);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.cSZ != null) {
            this.cSZ.cancel();
        }
        if (this.cTa != null) {
            this.cTa.cancel();
        }
        this.mHandler.removeCallbacks(this.cTi);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.bnG = (RelativeLayout) findViewById(i.f.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.bnG, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cD(i.C0057i.no_chat_friends), null);
        this.cTe = findViewById(i.f.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new f(this));
        Oi();
        this.aNx = (NoNetworkView) findViewById(i.f.view_no_network);
        this.aNx.a(this.cTj);
        this.mProgress = (ProgressBar) findViewById(i.f.progress);
        this.mListView = (BdListView) findViewById(i.f.list);
        this.cTc = new m(this, this.cTh);
        this.cTc.a(this);
        this.cTc.setCheckBoxStateChangedListener(new g(this));
        this.mListView.setAdapter((ListAdapter) this.cTc);
        this.mListView.setOnItemClickListener(this);
        this.mListView.setOnTouchListener(new h(this));
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.bEb.getParent() != null) {
            ((View) this.bEb.getParent()).setFocusable(true);
            ((View) this.bEb.getParent()).setFocusableInTouchMode(true);
        }
        this.bJD = (LinearLayout) this.bnG.findViewById(i.f.invite_candidate);
        this.bJE = (Button) this.bnG.findViewById(i.f.button_send);
        this.bJE.setOnClickListener(new i(this));
        hy(0);
        this.cSY = (AtSelectFriendList) this.bnG.findViewById(i.f.candidate_list);
        this.cSY.setMaxCount(5);
        this.cSY.setItemOPerationHandler(new j(this));
        YP();
    }

    private void Oi() {
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new k(this));
        this.cTf = this.mNavigationBar.setTitleText(getPageContext().getString(i.C0057i.select_friend));
        this.bJK = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.add_new_friend_text, new l(this));
        this.bJJ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, i.g.navigationbar_search_edit, (View.OnClickListener) null);
        this.bJJ.setVisibility(8);
        this.bEb = (EditText) this.bJJ.findViewById(i.f.search_bar_edit);
        this.bEb.addTextChangedListener(new com.baidu.tieba.write.write.b(this));
        this.bEb.setOnFocusChangeListener(new c(this));
        this.cSX = (TextView) findViewById(i.f.search_bar_delete_button);
        this.cSX.setOnClickListener(new d(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [474=4] */
    private void YP() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_height) + getResources().getDimensionPixelSize(i.d.invite_friend_candidate_padding_bottom) + getResources().getDimensionPixelSize(i.d.invite_friend_candidate_padding_top);
        this.bJF = new View(getPageContext().getContext());
        this.bJF.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListView.addFooterView(this.bJF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lc(String str) {
        if (!isFinishing()) {
            this.cTc.setData(null);
            if (this.cSZ != null) {
                this.cSZ.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.cTb.aud() != null) {
                    ArrayList<MetaData> atZ = this.cTb.aud().atZ();
                    Iterator<MetaData> it = atZ.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (atZ != null && !atZ.isEmpty()) {
                        kv(0);
                    } else {
                        kv(1);
                    }
                    this.cTc.setData(atZ);
                } else {
                    this.cTc.setData(null);
                    if (this.cTa == null) {
                        this.cTa = new b(this, null);
                        this.cTa.setPriority(3);
                        this.cTa.execute("");
                    }
                }
            } else {
                this.cSZ = new a(this, null);
                this.cSZ.setPriority(2);
                this.cSZ.execute(str);
                if (this.cTa == null && this.cTb.aud() == null) {
                    this.cTa = new b(this, null);
                    this.cTa.setPriority(3);
                    this.cTa.execute("");
                }
            }
            this.cTc.notifyDataSetInvalidated();
            this.mListView.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.cTb = new com.baidu.tieba.write.c.a();
        if (bundle != null) {
            this.cTh = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.cTh = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MetaData metaData) {
        if (metaData != null) {
            this.cSY.c(metaData);
            hy(this.cSY.getItemLength());
            YQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MetaData metaData) {
        if (metaData != null) {
            this.cSY.e(metaData);
            hy(this.cSY.getItemLength());
            YQ();
        }
    }

    private void YQ() {
        if (this.cSY.getItemLength() > 0) {
            this.bJE.setEnabled(true);
        } else {
            this.bJE.setEnabled(false);
        }
    }

    private void hy(int i) {
        this.bJE.setText(String.format(getPageContext().getString(i.C0057i.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.b> {
        private com.baidu.tbadk.core.util.v afJ;
        private String cTl;

        private a() {
            this.afJ = null;
            this.cTl = null;
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
            AtListActivity.this.cSZ = null;
            this.cTl = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.cTl = strArr[0];
            this.afJ = new com.baidu.tbadk.core.util.v();
            if (this.cTl != null && this.cTl.length() > 0) {
                this.afJ.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/sug");
                this.afJ.o("uid", TbadkCoreApplication.getCurrentAccount());
                this.afJ.o("q", this.cTl);
                String tD = this.afJ.tD();
                if (this.afJ.ue().uW().rb()) {
                    com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
                    com.baidu.tieba.write.a.a aud = AtListActivity.this.cTb.aud();
                    if (aud != null) {
                        bVar.a(tD, aud.aua());
                        return bVar;
                    }
                    bVar.a(tD, (HashMap<String, String>) null);
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
            AtListActivity.this.cSZ = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.afJ.ue().uW().rb() && this.cTl != null && com.baidu.adp.lib.util.j.a(AtListActivity.this.bEb.getText(), "").equals(this.cTl)) {
                if (bVar == null || bVar.aub().isEmpty()) {
                    AtListActivity.this.kv(1);
                } else {
                    AtListActivity.this.kv(0);
                }
                AtListActivity.this.cTb.a(bVar);
                AtListActivity.this.cTc.setData(bVar.aub());
                AtListActivity.this.cTc.notifyDataSetInvalidated();
                AtListActivity.this.mListView.setSelection(0);
            } else {
                AtListActivity.this.showToast(this.afJ.getErrorString());
            }
            super.onPostExecute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.a> {
        private com.baidu.tbadk.core.util.v afJ;

        private b() {
            this.afJ = null;
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
            if (this.afJ != null) {
                this.afJ.gM();
            }
            AtListActivity.this.cTa = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public com.baidu.tieba.write.a.a doInBackground(String... strArr) {
            this.afJ = new com.baidu.tbadk.core.util.v();
            this.afJ.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/list");
            String tD = this.afJ.tD();
            if (!this.afJ.ue().uW().rb()) {
                return null;
            }
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.la(tD);
            return aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.a aVar) {
            AtListActivity.this.cTa = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.bJD != null && AtListActivity.this.bJD.getVisibility() == 0) {
                AtListActivity.this.cTe.setVisibility(0);
            }
            if (this.afJ.ue().uW().rb()) {
                AtListActivity.this.cTb.a(aVar);
                if (AtListActivity.this.cTc != null) {
                    if (com.baidu.adp.lib.util.j.a(AtListActivity.this.bEb.getText(), "").length() != 0) {
                        if (AtListActivity.this.cTb.aue() != null) {
                            if (aVar != null && aVar.aua() != null && !aVar.aua().isEmpty()) {
                                AtListActivity.this.kv(2);
                            }
                            AtListActivity.this.cTb.aue().i(aVar.aua());
                            AtListActivity.this.cTc.notifyDataSetInvalidated();
                        }
                    } else {
                        if (aVar == null || aVar.atZ() == null || !aVar.atZ().isEmpty()) {
                            AtListActivity.this.kv(0);
                        } else {
                            AtListActivity.this.kv(2);
                        }
                        AtListActivity.this.cSW = aVar.atZ();
                        AtListActivity.this.cTc.setData(AtListActivity.this.cSW);
                        AtListActivity.this.cTc.notifyDataSetInvalidated();
                        AtListActivity.this.mListView.setSelection(0);
                    }
                } else {
                    return;
                }
            } else {
                AtListActivity.this.showToast(this.afJ.getErrorString());
            }
            super.onPostExecute(aVar);
        }
    }

    @Override // com.baidu.tieba.write.write.m.b
    public void a(View view, MetaData metaData) {
        if (metaData != null) {
            this.cSY.d(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.mListView;
    }
}
