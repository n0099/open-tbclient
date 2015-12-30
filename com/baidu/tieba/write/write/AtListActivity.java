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
import com.baidu.tieba.n;
import com.baidu.tieba.write.write.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public class AtListActivity extends BaseActivity<AtListActivity> implements AdapterView.OnItemClickListener, m.b {
    private NoNetworkView aUd;
    private LinearLayout cgZ;
    private Button cha;
    private View che;
    private View chf;
    private AtSelectFriendList dWD;
    private TextView dWK;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.o mNoDataView;
    protected ArrayList<MetaData> dWB = new ArrayList<>();
    private EditText cbx = null;
    private TextView dWC = null;
    private BdListView mListView = null;
    private final Handler mHandler = new Handler();
    private a dWE = null;
    private b dWF = null;
    private com.baidu.tieba.write.b.a dWG = null;
    private m dWH = null;
    private String dWI = null;
    private ProgressBar mProgress = null;
    private RelativeLayout bKF = null;
    private View dWJ = null;
    private final int dWL = 5;
    private boolean dWM = true;
    private final Runnable dWN = new com.baidu.tieba.write.write.a(this);
    private NoNetworkView.a dWO = new e(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.h.at_list_activity);
        initData(bundle);
        initUI();
        nr(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ac(i == 1);
        getLayoutMode().k(this.bKF);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aUd.onChangeSkinType(getPageContext(), i);
        this.dWH.notifyDataSetChanged();
        com.baidu.tbadk.core.util.as.getColor(n.d.widget_searchbox_text);
        com.baidu.tbadk.core.util.as.i(this.mListFooter, n.f.invite_friend_list_item_bg_color);
        com.baidu.tbadk.core.util.as.i((View) this.cha, n.f.post_button_bg);
        com.baidu.tbadk.core.util.as.b(this.cha, n.d.cp_cont_i, 3);
        this.mListFooter.setEnabled(false);
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
    public void oz(int i) {
        if (i == 2) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cM(n.j.no_chat_friends));
            this.cgZ.setVisibility(8);
        } else if (i == 1) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cM(n.j.no_search_friends));
            this.cgZ.setVisibility(8);
        } else if (i == 0) {
            this.mListView.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.dWM) {
                this.cgZ.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.dWH.getItem(i);
        if (item != null) {
            if (this.dWM) {
                if (this.dWE == null && this.dWF == null) {
                    if (item.isChecked()) {
                        b(item);
                    } else if (5 <= this.dWD.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(n.j.invite_friend_exceed_max_count), 5), n.f.icon_toast_game_error);
                        return;
                    } else {
                        a(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.dWH.notifyDataSetChanged();
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
            com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), this.cbx);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.dWE != null) {
            this.dWE.cancel();
        }
        if (this.dWF != null) {
            this.dWF.cancel();
        }
        this.mHandler.removeCallbacks(this.dWN);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.bKF = (RelativeLayout) findViewById(n.g.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.bKF, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cM(n.j.no_chat_friends), null);
        this.dWJ = findViewById(n.g.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new f(this));
        Qz();
        this.aUd = (NoNetworkView) findViewById(n.g.view_no_network);
        this.aUd.a(this.dWO);
        this.mProgress = (ProgressBar) findViewById(n.g.progress);
        this.mListView = (BdListView) findViewById(n.g.list);
        this.dWH = new m(this, this.dWM);
        this.dWH.a(this);
        this.dWH.setCheckBoxStateChangedListener(new g(this));
        this.mListView.setAdapter((ListAdapter) this.dWH);
        this.mListView.setOnItemClickListener(this);
        this.mListView.setOnTouchListener(new h(this));
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.cbx.getParent() != null) {
            ((View) this.cbx.getParent()).setFocusable(true);
            ((View) this.cbx.getParent()).setFocusableInTouchMode(true);
        }
        this.cgZ = (LinearLayout) this.bKF.findViewById(n.g.invite_candidate);
        this.cha = (Button) this.bKF.findViewById(n.g.button_send);
        this.cha.setOnClickListener(new i(this));
        jo(0);
        this.dWD = (AtSelectFriendList) this.bKF.findViewById(n.g.candidate_list);
        this.dWD.setMaxCount(5);
        this.dWD.setItemOPerationHandler(new j(this));
        aef();
    }

    private void Qz() {
        this.mNavigationBar = (NavigationBar) findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new k(this));
        this.dWK = this.mNavigationBar.setTitleText(getPageContext().getString(n.j.select_friend));
        this.chf = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.h.add_new_friend_text, new l(this));
        this.che = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, n.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.che.setVisibility(8);
        this.cbx = (EditText) this.che.findViewById(n.g.search_bar_edit);
        this.cbx.addTextChangedListener(new com.baidu.tieba.write.write.b(this));
        this.cbx.setOnFocusChangeListener(new c(this));
        this.dWC = (TextView) findViewById(n.g.search_bar_delete_button);
        this.dWC.setOnClickListener(new d(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [474=4] */
    private void aef() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(n.e.invite_friend_candidate_item_height) + getResources().getDimensionPixelSize(n.e.invite_friend_candidate_padding_bottom) + getResources().getDimensionPixelSize(n.e.invite_friend_candidate_padding_top);
        this.mListFooter = new View(getPageContext().getContext());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListView.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(String str) {
        if (!isFinishing()) {
            this.dWH.setData(null);
            if (this.dWE != null) {
                this.dWE.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.dWG.aKr() != null) {
                    ArrayList<MetaData> aKm = this.dWG.aKr().aKm();
                    Iterator<MetaData> it = aKm.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (aKm != null && !aKm.isEmpty()) {
                        oz(0);
                    } else {
                        oz(1);
                    }
                    this.dWH.setData(aKm);
                } else {
                    this.dWH.setData(null);
                    if (this.dWF == null) {
                        this.dWF = new b(this, null);
                        this.dWF.setPriority(3);
                        this.dWF.execute("");
                    }
                }
            } else {
                this.dWE = new a(this, null);
                this.dWE.setPriority(2);
                this.dWE.execute(str);
                if (this.dWF == null && this.dWG.aKr() == null) {
                    this.dWF = new b(this, null);
                    this.dWF.setPriority(3);
                    this.dWF.execute("");
                }
            }
            this.dWH.notifyDataSetInvalidated();
            this.mListView.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.dWG = new com.baidu.tieba.write.b.a();
        if (bundle != null) {
            this.dWM = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.dWM = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MetaData metaData) {
        if (metaData != null) {
            this.dWD.c(metaData);
            jo(this.dWD.getItemLength());
            aeg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MetaData metaData) {
        if (metaData != null) {
            this.dWD.e(metaData);
            jo(this.dWD.getItemLength());
            aeg();
        }
    }

    private void aeg() {
        if (this.dWD.getItemLength() > 0) {
            this.cha.setEnabled(true);
        } else {
            this.cha.setEnabled(false);
        }
    }

    private void jo(int i) {
        this.cha.setText(String.format(getPageContext().getString(n.j.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.data.c> {
        private com.baidu.tbadk.core.util.ab ahV;
        private String dWQ;

        private a() {
            this.ahV = null;
            this.dWQ = null;
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
            AtListActivity.this.dWE = null;
            this.dWQ = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public com.baidu.tieba.write.data.c doInBackground(String... strArr) {
            this.dWQ = strArr[0];
            this.ahV = new com.baidu.tbadk.core.util.ab();
            if (this.dWQ != null && this.dWQ.length() > 0) {
                this.ahV.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/sug");
                this.ahV.o("uid", TbadkCoreApplication.getCurrentAccount());
                this.ahV.o("q", this.dWQ);
                String tV = this.ahV.tV();
                if (this.ahV.uw().vq().qO()) {
                    com.baidu.tieba.write.data.c cVar = new com.baidu.tieba.write.data.c();
                    com.baidu.tieba.write.data.a aKr = AtListActivity.this.dWG.aKr();
                    if (aKr != null) {
                        cVar.a(tV, aKr.aKn());
                        return cVar;
                    }
                    cVar.a(tV, (HashMap<String, String>) null);
                    return cVar;
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.data.c cVar) {
            AtListActivity.this.dWE = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.ahV.uw().vq().qO() && this.dWQ != null && com.baidu.adp.lib.util.j.a(AtListActivity.this.cbx.getText(), "").equals(this.dWQ)) {
                if (cVar == null || cVar.aKp().isEmpty()) {
                    AtListActivity.this.oz(1);
                } else {
                    AtListActivity.this.oz(0);
                }
                AtListActivity.this.dWG.a(cVar);
                AtListActivity.this.dWH.setData(cVar.aKp());
                AtListActivity.this.dWH.notifyDataSetInvalidated();
                AtListActivity.this.mListView.setSelection(0);
            } else {
                AtListActivity.this.showToast(this.ahV.getErrorString());
            }
            super.onPostExecute(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, com.baidu.tieba.write.data.a> {
        private com.baidu.tbadk.core.util.ab ahV;

        private b() {
            this.ahV = null;
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
            if (this.ahV != null) {
                this.ahV.gL();
            }
            AtListActivity.this.dWF = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public com.baidu.tieba.write.data.a doInBackground(String... strArr) {
            this.ahV = new com.baidu.tbadk.core.util.ab();
            this.ahV.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/list");
            String tV = this.ahV.tV();
            if (!this.ahV.uw().vq().qO()) {
                return null;
            }
            com.baidu.tieba.write.data.a aVar = new com.baidu.tieba.write.data.a();
            aVar.nm(tV);
            return aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.data.a aVar) {
            AtListActivity.this.dWF = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.cgZ != null && AtListActivity.this.cgZ.getVisibility() == 0) {
                AtListActivity.this.dWJ.setVisibility(0);
            }
            if (this.ahV.uw().vq().qO()) {
                AtListActivity.this.dWG.a(aVar);
                if (AtListActivity.this.dWH != null) {
                    if (com.baidu.adp.lib.util.j.a(AtListActivity.this.cbx.getText(), "").length() != 0) {
                        if (AtListActivity.this.dWG.aKs() != null) {
                            if (aVar != null && aVar.aKn() != null && !aVar.aKn().isEmpty()) {
                                AtListActivity.this.oz(2);
                            }
                            AtListActivity.this.dWG.aKs().i(aVar.aKn());
                            AtListActivity.this.dWH.notifyDataSetInvalidated();
                        }
                    } else {
                        if (aVar == null || aVar.aKm() == null || !aVar.aKm().isEmpty()) {
                            AtListActivity.this.oz(0);
                        } else {
                            AtListActivity.this.oz(2);
                        }
                        AtListActivity.this.dWB = aVar.aKm();
                        AtListActivity.this.dWH.setData(AtListActivity.this.dWB);
                        AtListActivity.this.dWH.notifyDataSetInvalidated();
                        AtListActivity.this.mListView.setSelection(0);
                    }
                } else {
                    return;
                }
            } else {
                AtListActivity.this.showToast(this.ahV.getErrorString());
            }
            super.onPostExecute(aVar);
        }
    }

    @Override // com.baidu.tieba.write.write.m.b
    public void a(View view, MetaData metaData) {
        if (metaData != null) {
            this.dWD.d(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.mListView;
    }
}
