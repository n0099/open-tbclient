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
    private NoNetworkView bzB;
    private LinearLayout dsL;
    private Button dsM;
    private View dsQ;
    private View dsR;
    private ImageView dsT;
    private AtSelectFriendList gjN;
    private TextView gjU;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.y mNoDataView;
    protected ArrayList<MetaData> gjM = new ArrayList<>();
    private EditText dpg = null;
    private TextView bYi = null;
    private BdListView Ib = null;
    private final Handler mHandler = new Handler();
    private a gjO = null;
    private b gjP = null;
    private com.baidu.tieba.write.model.d gjQ = null;
    private n gjR = null;
    private String gjS = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View gjT = null;
    private final int gjV = 5;
    private boolean gjW = true;
    private final Runnable gjX = new com.baidu.tieba.write.write.a(this);
    private NoNetworkView.a fSZ = new f(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.j.at_list_activity);
        initData(bundle);
        initUI();
        sv(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.mParent);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bzB.onChangeSkinType(getPageContext(), i);
        this.gjR.notifyDataSetChanged();
        com.baidu.tbadk.core.util.as.getColor(w.e.common_color_10221);
        com.baidu.tbadk.core.util.as.j(this.mListFooter, w.g.invite_friend_list_item_bg_color);
        com.baidu.tbadk.core.util.as.j(this.dsM, w.g.post_button_bg);
        com.baidu.tbadk.core.util.as.c(this.dsM, w.e.cp_cont_i, 3);
        com.baidu.tbadk.core.util.as.b(this.dsT, w.g.icon_search_bg_s, w.g.icon_search_bg);
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
    public void tZ(int i) {
        if (i == 2) {
            this.Ib.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dg(w.l.no_chat_friends));
            this.dsL.setVisibility(8);
        } else if (i == 1) {
            this.Ib.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dg(w.l.no_search_friends));
            this.dsL.setVisibility(8);
        } else if (i == 0) {
            this.Ib.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.gjW) {
                this.dsL.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.gjR.getItem(i);
        if (item != null) {
            if (this.gjW) {
                if (this.gjO == null && this.gjP == null) {
                    if (item.isChecked()) {
                        d(item);
                    } else if (5 <= this.gjN.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(w.l.invite_friend_exceed_max_count), 5), w.g.icon_toast_game_error);
                        return;
                    } else {
                        c(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.gjR.notifyDataSetChanged();
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
            com.baidu.adp.lib.util.k.b(getPageContext().getPageActivity(), this.dpg);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gjO != null) {
            this.gjO.cancel();
        }
        if (this.gjP != null) {
            this.gjP.cancel();
        }
        this.mHandler.removeCallbacks(this.gjX);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(w.h.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.adp.lib.util.k.g(getActivity(), w.f.ds320)), NoDataViewFactory.d.dg(w.l.no_chat_friends), null, true);
        this.gjT = findViewById(w.h.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new g(this));
        Vk();
        this.bzB = (NoNetworkView) findViewById(w.h.view_no_network);
        this.bzB.a(this.fSZ);
        this.mProgress = (ProgressBar) findViewById(w.h.progress);
        this.Ib = (BdListView) findViewById(w.h.list);
        this.gjR = new n(this, this.gjW);
        this.gjR.a(this);
        this.gjR.a(new h(this));
        this.Ib.setAdapter((ListAdapter) this.gjR);
        this.Ib.setOnItemClickListener(this);
        this.Ib.setOnTouchListener(new i(this));
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.dpg.getParent() != null) {
            ((View) this.dpg.getParent()).setFocusable(true);
            ((View) this.dpg.getParent()).setFocusableInTouchMode(true);
        }
        this.dsL = (LinearLayout) this.mParent.findViewById(w.h.invite_candidate);
        this.dsM = (Button) this.mParent.findViewById(w.h.button_send);
        this.dsM.setOnClickListener(new j(this));
        mC(0);
        this.gjN = (AtSelectFriendList) this.mParent.findViewById(w.h.candidate_list);
        this.gjN.setMaxCount(5);
        this.gjN.setItemOPerationHandler(new k(this));
        axp();
    }

    private void Vk() {
        this.mNavigationBar = (NavigationBar) findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new l(this));
        this.gjU = this.mNavigationBar.setTitleText(getPageContext().getString(w.l.select_friend));
        this.dsR = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.add_new_friend_text, new m(this));
        this.dsT = (ImageView) this.dsR.findViewById(w.h.new_friend_search);
        this.dsQ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.navigationbar_search_edit, (View.OnClickListener) null);
        this.dsQ.setVisibility(8);
        this.dpg = (EditText) this.dsQ.findViewById(w.h.search_bar_edit);
        this.dpg.addTextChangedListener(new com.baidu.tieba.write.write.b(this));
        this.dpg.setOnFocusChangeListener(new c(this));
        this.bYi = (TextView) findViewById(w.h.search_bar_delete_button);
        this.bYi.setOnClickListener(new d(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [470=4] */
    private void axp() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds80) + getResources().getDimensionPixelSize(w.f.ds16) + getResources().getDimensionPixelSize(w.f.ds16);
        this.mListFooter = new View(getPageContext().getContext());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setFocusable(false);
        this.mListFooter.setFocusableInTouchMode(false);
        this.mListFooter.setContentDescription("");
        this.mListFooter.setVisibility(4);
        this.mListFooter.setBackgroundColor(0);
        this.mListFooter.setOnClickListener(new e(this));
        this.Ib.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sv(String str) {
        if (!isFinishing()) {
            this.gjR.setData(null);
            if (this.gjO != null) {
                this.gjO.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.gjQ.bsO() != null) {
                    ArrayList<MetaData> bsI = this.gjQ.bsO().bsI();
                    Iterator<MetaData> it = bsI.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (bsI != null && !bsI.isEmpty()) {
                        tZ(0);
                    } else {
                        tZ(1);
                    }
                    this.gjR.setData(bsI);
                } else {
                    this.gjR.setData(null);
                    if (this.gjP == null) {
                        this.gjP = new b(this, null);
                        this.gjP.setPriority(3);
                        this.gjP.execute("");
                    }
                }
            } else {
                this.gjO = new a(this, null);
                this.gjO.setPriority(2);
                this.gjO.execute(str);
                if (this.gjP == null && this.gjQ.bsO() == null) {
                    this.gjP = new b(this, null);
                    this.gjP.setPriority(3);
                    this.gjP.execute("");
                }
            }
            this.gjR.notifyDataSetInvalidated();
            this.Ib.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.gjQ = new com.baidu.tieba.write.model.d();
        if (bundle != null) {
            this.gjW = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.gjW = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(MetaData metaData) {
        if (metaData != null) {
            this.gjN.e(metaData);
            mC(this.gjN.getItemLength());
            axq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.gjN.g(metaData);
            mC(this.gjN.getItemLength());
            axq();
        }
    }

    private void axq() {
        if (this.gjN.getItemLength() > 0) {
            this.dsM.setEnabled(true);
        } else {
            this.dsM.setEnabled(false);
        }
    }

    private void mC(int i) {
        this.dsM.setText(String.format(getPageContext().getString(w.l.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.d> {
        private String gjZ;
        private com.baidu.tbadk.core.util.ab mNetwork;

        private a() {
            this.mNetwork = null;
            this.gjZ = null;
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
            AtListActivity.this.gjO = null;
            this.gjZ = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public com.baidu.tieba.write.a.d doInBackground(String... strArr) {
            this.gjZ = strArr[0];
            this.mNetwork = new com.baidu.tbadk.core.util.ab();
            if (this.gjZ != null && this.gjZ.length() > 0) {
                this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/sug");
                this.mNetwork.n(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.n("q", this.gjZ);
                String uy = this.mNetwork.uy();
                if (this.mNetwork.uV().vS().isRequestSuccess()) {
                    com.baidu.tieba.write.a.d dVar = new com.baidu.tieba.write.a.d();
                    com.baidu.tieba.write.a.b bsO = AtListActivity.this.gjQ.bsO();
                    if (bsO != null) {
                        dVar.e(uy, bsO.bsJ());
                        return dVar;
                    }
                    dVar.e(uy, null);
                    return dVar;
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.d dVar) {
            AtListActivity.this.gjO = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.uV().vS().isRequestSuccess() && this.gjZ != null && com.baidu.adp.lib.util.j.a(AtListActivity.this.dpg.getText(), "").equals(this.gjZ)) {
                if (dVar == null || dVar.bsK().isEmpty()) {
                    AtListActivity.this.tZ(1);
                } else {
                    AtListActivity.this.tZ(0);
                }
                AtListActivity.this.gjQ.a(dVar);
                AtListActivity.this.gjR.setData(dVar.bsK());
                AtListActivity.this.gjR.notifyDataSetInvalidated();
                AtListActivity.this.Ib.setSelection(0);
            } else {
                AtListActivity.this.showToast(this.mNetwork.getErrorString());
            }
            super.onPostExecute(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.b> {
        private com.baidu.tbadk.core.util.ab mNetwork;

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
            AtListActivity.this.gjP = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.mNetwork = new com.baidu.tbadk.core.util.ab();
            this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/list");
            String uy = this.mNetwork.uy();
            if (!this.mNetwork.uV().vS().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.sj(uy);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.gjP = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.dsL != null && AtListActivity.this.dsL.getVisibility() == 0) {
                AtListActivity.this.gjT.setVisibility(0);
            }
            if (this.mNetwork.uV().vS().isRequestSuccess()) {
                AtListActivity.this.gjQ.a(bVar);
                if (AtListActivity.this.gjR != null) {
                    if (com.baidu.adp.lib.util.j.a(AtListActivity.this.dpg.getText(), "").length() != 0) {
                        if (AtListActivity.this.gjQ.bsP() != null) {
                            if (bVar != null && bVar.bsJ() != null && !bVar.bsJ().isEmpty()) {
                                AtListActivity.this.tZ(2);
                            }
                            AtListActivity.this.gjQ.bsP().k(bVar.bsJ());
                            AtListActivity.this.gjR.notifyDataSetInvalidated();
                        }
                    } else {
                        if (bVar == null || bVar.bsI() == null || !bVar.bsI().isEmpty()) {
                            AtListActivity.this.tZ(0);
                        } else {
                            AtListActivity.this.tZ(2);
                        }
                        AtListActivity.this.gjM = bVar.bsI();
                        AtListActivity.this.gjR.setData(AtListActivity.this.gjM);
                        AtListActivity.this.gjR.notifyDataSetInvalidated();
                        AtListActivity.this.Ib.setSelection(0);
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

    @Override // com.baidu.tieba.write.write.n.b
    public void a(View view, MetaData metaData) {
        if (metaData != null) {
            this.gjN.f(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.w onGetPreLoadListView() {
        return this.Ib;
    }
}
