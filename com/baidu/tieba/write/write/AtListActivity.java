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
import com.baidu.tieba.t;
import com.baidu.tieba.write.write.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public class AtListActivity extends BaseActivity<AtListActivity> implements AdapterView.OnItemClickListener, m.b {
    private NoNetworkView aWk;
    private LinearLayout clB;
    private Button clC;
    private View clG;
    private View clH;
    private TextView erD;
    private AtSelectFriendList erw;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.o mNoDataView;
    protected ArrayList<MetaData> eru = new ArrayList<>();
    private EditText cfX = null;
    private TextView erv = null;
    private BdListView IY = null;
    private final Handler mHandler = new Handler();
    private a erx = null;
    private b ery = null;
    private com.baidu.tieba.write.b.a erz = null;
    private m erA = null;
    private String erB = null;
    private ProgressBar aNo = null;
    private RelativeLayout bOs = null;
    private View erC = null;
    private final int erE = 5;
    private boolean erF = true;
    private final Runnable erG = new com.baidu.tieba.write.write.a(this);
    private NoNetworkView.a erH = new e(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.at_list_activity);
        initData(bundle);
        qD();
        nJ(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ac(i == 1);
        getLayoutMode().x(this.bOs);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aWk.onChangeSkinType(getPageContext(), i);
        this.erA.notifyDataSetChanged();
        com.baidu.tbadk.core.util.ar.getColor(t.d.widget_searchbox_text);
        com.baidu.tbadk.core.util.ar.k(this.mListFooter, t.f.invite_friend_list_item_bg_color);
        com.baidu.tbadk.core.util.ar.k(this.clC, t.f.post_button_bg);
        com.baidu.tbadk.core.util.ar.b(this.clC, t.d.cp_cont_i, 3);
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
    public void pU(int i) {
        if (i == 2) {
            this.IY.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dd(t.j.no_chat_friends));
            this.clB.setVisibility(8);
        } else if (i == 1) {
            this.IY.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dd(t.j.no_search_friends));
            this.clB.setVisibility(8);
        } else if (i == 0) {
            this.IY.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.erF) {
                this.clB.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.erA.getItem(i);
        if (item != null) {
            if (this.erF) {
                if (this.erx == null && this.ery == null) {
                    if (item.isChecked()) {
                        b(item);
                    } else if (5 <= this.erw.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(t.j.invite_friend_exceed_max_count), 5), t.f.icon_toast_game_error);
                        return;
                    } else {
                        a(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.erA.notifyDataSetChanged();
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
            com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), this.cfX);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.erx != null) {
            this.erx.cancel();
        }
        if (this.ery != null) {
            this.ery.cancel();
        }
        this.mHandler.removeCallbacks(this.erG);
        if (this.aNo != null) {
            this.aNo.setVisibility(8);
        }
        super.onDestroy();
    }

    private void qD() {
        this.bOs = (RelativeLayout) findViewById(t.g.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.bOs, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dd(t.j.no_chat_friends), null);
        this.erC = findViewById(t.g.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new f(this));
        SG();
        this.aWk = (NoNetworkView) findViewById(t.g.view_no_network);
        this.aWk.a(this.erH);
        this.aNo = (ProgressBar) findViewById(t.g.progress);
        this.IY = (BdListView) findViewById(t.g.list);
        this.erA = new m(this, this.erF);
        this.erA.a(this);
        this.erA.a(new g(this));
        this.IY.setAdapter((ListAdapter) this.erA);
        this.IY.setOnItemClickListener(this);
        this.IY.setOnTouchListener(new h(this));
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.cfX.getParent() != null) {
            ((View) this.cfX.getParent()).setFocusable(true);
            ((View) this.cfX.getParent()).setFocusableInTouchMode(true);
        }
        this.clB = (LinearLayout) this.bOs.findViewById(t.g.invite_candidate);
        this.clC = (Button) this.bOs.findViewById(t.g.button_send);
        this.clC.setOnClickListener(new i(this));
        jM(0);
        this.erw = (AtSelectFriendList) this.bOs.findViewById(t.g.candidate_list);
        this.erw.setMaxCount(5);
        this.erw.setItemOPerationHandler(new j(this));
        ahp();
    }

    private void SG() {
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new k(this));
        this.erD = this.mNavigationBar.setTitleText(getPageContext().getString(t.j.select_friend));
        this.clH = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.add_new_friend_text, new l(this));
        this.clG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, t.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.clG.setVisibility(8);
        this.cfX = (EditText) this.clG.findViewById(t.g.search_bar_edit);
        this.cfX.addTextChangedListener(new com.baidu.tieba.write.write.b(this));
        this.cfX.setOnFocusChangeListener(new c(this));
        this.erv = (TextView) findViewById(t.g.search_bar_delete_button);
        this.erv.setOnClickListener(new d(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [474=4] */
    private void ahp() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(t.e.invite_friend_candidate_item_height) + getResources().getDimensionPixelSize(t.e.invite_friend_candidate_padding_bottom) + getResources().getDimensionPixelSize(t.e.invite_friend_candidate_padding_top);
        this.mListFooter = new View(getPageContext().getContext());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.IY.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nJ(String str) {
        if (!isFinishing()) {
            this.erA.setData(null);
            if (this.erx != null) {
                this.erx.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.erz.aTb() != null) {
                    ArrayList<MetaData> aSW = this.erz.aTb().aSW();
                    Iterator<MetaData> it = aSW.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (aSW != null && !aSW.isEmpty()) {
                        pU(0);
                    } else {
                        pU(1);
                    }
                    this.erA.setData(aSW);
                } else {
                    this.erA.setData(null);
                    if (this.ery == null) {
                        this.ery = new b(this, null);
                        this.ery.setPriority(3);
                        this.ery.execute("");
                    }
                }
            } else {
                this.erx = new a(this, null);
                this.erx.setPriority(2);
                this.erx.execute(str);
                if (this.ery == null && this.erz.aTb() == null) {
                    this.ery = new b(this, null);
                    this.ery.setPriority(3);
                    this.ery.execute("");
                }
            }
            this.erA.notifyDataSetInvalidated();
            this.IY.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.erz = new com.baidu.tieba.write.b.a();
        if (bundle != null) {
            this.erF = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.erF = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MetaData metaData) {
        if (metaData != null) {
            this.erw.c(metaData);
            jM(this.erw.getItemLength());
            ahq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MetaData metaData) {
        if (metaData != null) {
            this.erw.e(metaData);
            jM(this.erw.getItemLength());
            ahq();
        }
    }

    private void ahq() {
        if (this.erw.getItemLength() > 0) {
            this.clC.setEnabled(true);
        } else {
            this.clC.setEnabled(false);
        }
    }

    private void jM(int i) {
        this.clC.setText(String.format(getPageContext().getString(t.j.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.data.c> {
        private com.baidu.tbadk.core.util.aa aiG;
        private String erJ;

        private a() {
            this.aiG = null;
            this.erJ = null;
        }

        /* synthetic */ a(AtListActivity atListActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.aNo.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.erx = null;
            this.erJ = null;
            AtListActivity.this.aNo.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public com.baidu.tieba.write.data.c doInBackground(String... strArr) {
            this.erJ = strArr[0];
            this.aiG = new com.baidu.tbadk.core.util.aa();
            if (this.erJ != null && this.erJ.length() > 0) {
                this.aiG.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/sug");
                this.aiG.p("uid", TbadkCoreApplication.getCurrentAccount());
                this.aiG.p("q", this.erJ);
                String uZ = this.aiG.uZ();
                if (this.aiG.vB().ww().rl()) {
                    com.baidu.tieba.write.data.c cVar = new com.baidu.tieba.write.data.c();
                    com.baidu.tieba.write.data.a aTb = AtListActivity.this.erz.aTb();
                    if (aTb != null) {
                        cVar.a(uZ, aTb.aSX());
                        return cVar;
                    }
                    cVar.a(uZ, (HashMap<String, String>) null);
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
            AtListActivity.this.erx = null;
            AtListActivity.this.aNo.setVisibility(8);
            if (this.aiG.vB().ww().rl() && this.erJ != null && com.baidu.adp.lib.util.j.a(AtListActivity.this.cfX.getText(), "").equals(this.erJ)) {
                if (cVar == null || cVar.aSZ().isEmpty()) {
                    AtListActivity.this.pU(1);
                } else {
                    AtListActivity.this.pU(0);
                }
                AtListActivity.this.erz.a(cVar);
                AtListActivity.this.erA.setData(cVar.aSZ());
                AtListActivity.this.erA.notifyDataSetInvalidated();
                AtListActivity.this.IY.setSelection(0);
            } else {
                AtListActivity.this.showToast(this.aiG.getErrorString());
            }
            super.onPostExecute(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, com.baidu.tieba.write.data.a> {
        private com.baidu.tbadk.core.util.aa aiG;

        private b() {
            this.aiG = null;
        }

        /* synthetic */ b(AtListActivity atListActivity, b bVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.aNo.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiG != null) {
                this.aiG.gT();
            }
            AtListActivity.this.ery = null;
            AtListActivity.this.aNo.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public com.baidu.tieba.write.data.a doInBackground(String... strArr) {
            this.aiG = new com.baidu.tbadk.core.util.aa();
            this.aiG.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/list");
            String uZ = this.aiG.uZ();
            if (!this.aiG.vB().ww().rl()) {
                return null;
            }
            com.baidu.tieba.write.data.a aVar = new com.baidu.tieba.write.data.a();
            aVar.nC(uZ);
            return aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.data.a aVar) {
            AtListActivity.this.ery = null;
            AtListActivity.this.aNo.setVisibility(8);
            if (AtListActivity.this.clB != null && AtListActivity.this.clB.getVisibility() == 0) {
                AtListActivity.this.erC.setVisibility(0);
            }
            if (this.aiG.vB().ww().rl()) {
                AtListActivity.this.erz.a(aVar);
                if (AtListActivity.this.erA != null) {
                    if (com.baidu.adp.lib.util.j.a(AtListActivity.this.cfX.getText(), "").length() != 0) {
                        if (AtListActivity.this.erz.aTc() != null) {
                            if (aVar != null && aVar.aSX() != null && !aVar.aSX().isEmpty()) {
                                AtListActivity.this.pU(2);
                            }
                            AtListActivity.this.erz.aTc().i(aVar.aSX());
                            AtListActivity.this.erA.notifyDataSetInvalidated();
                        }
                    } else {
                        if (aVar == null || aVar.aSW() == null || !aVar.aSW().isEmpty()) {
                            AtListActivity.this.pU(0);
                        } else {
                            AtListActivity.this.pU(2);
                        }
                        AtListActivity.this.eru = aVar.aSW();
                        AtListActivity.this.erA.setData(AtListActivity.this.eru);
                        AtListActivity.this.erA.notifyDataSetInvalidated();
                        AtListActivity.this.IY.setSelection(0);
                    }
                } else {
                    return;
                }
            } else {
                AtListActivity.this.showToast(this.aiG.getErrorString());
            }
            super.onPostExecute(aVar);
        }
    }

    @Override // com.baidu.tieba.write.write.m.b
    public void a(View view, MetaData metaData) {
        if (metaData != null) {
            this.erw.d(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.IY;
    }
}
