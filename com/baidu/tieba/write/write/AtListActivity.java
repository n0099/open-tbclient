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
    private NoNetworkView byr;
    private LinearLayout dkP;
    private Button dkQ;
    private View dkU;
    private View dkV;
    private ImageView dkX;
    private AtSelectFriendList fYO;
    private TextView fYV;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.y mNoDataView;
    protected ArrayList<MetaData> fYM = new ArrayList<>();
    private EditText dhk = null;
    private TextView fYN = null;
    private BdListView Ic = null;
    private final Handler mHandler = new Handler();
    private a fYP = null;
    private b fYQ = null;
    private com.baidu.tieba.write.model.d fYR = null;
    private n fYS = null;
    private String fYT = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View fYU = null;
    private final int fYW = 5;
    private boolean fYX = true;
    private final Runnable fYY = new com.baidu.tieba.write.write.a(this);
    private NoNetworkView.a fJi = new f(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.j.at_list_activity);
        initData(bundle);
        initUI();
        rv(null);
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
        this.byr.onChangeSkinType(getPageContext(), i);
        this.fYS.notifyDataSetChanged();
        com.baidu.tbadk.core.util.aq.getColor(w.e.common_color_10221);
        com.baidu.tbadk.core.util.aq.j(this.mListFooter, w.g.invite_friend_list_item_bg_color);
        com.baidu.tbadk.core.util.aq.j(this.dkQ, w.g.post_button_bg);
        com.baidu.tbadk.core.util.aq.c(this.dkQ, w.e.cp_cont_i, 3);
        com.baidu.tbadk.core.util.aq.b(this.dkX, w.g.icon_search_bg_s, w.g.icon_search_bg);
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
    public void tD(int i) {
        if (i == 2) {
            this.Ic.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.de(w.l.no_chat_friends));
            this.dkP.setVisibility(8);
        } else if (i == 1) {
            this.Ic.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.de(w.l.no_search_friends));
            this.dkP.setVisibility(8);
        } else if (i == 0) {
            this.Ic.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.fYX) {
                this.dkP.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.fYS.getItem(i);
        if (item != null) {
            if (this.fYX) {
                if (this.fYP == null && this.fYQ == null) {
                    if (item.isChecked()) {
                        d(item);
                    } else if (5 <= this.fYO.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(w.l.invite_friend_exceed_max_count), 5), w.g.icon_toast_game_error);
                        return;
                    } else {
                        c(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.fYS.notifyDataSetChanged();
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
            com.baidu.adp.lib.util.k.b(getPageContext().getPageActivity(), this.dhk);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fYP != null) {
            this.fYP.cancel();
        }
        if (this.fYQ != null) {
            this.fYQ.cancel();
        }
        this.mHandler.removeCallbacks(this.fYY);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(w.h.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.adp.lib.util.k.g(getActivity(), w.f.ds320)), NoDataViewFactory.d.de(w.l.no_chat_friends), null, true);
        this.fYU = findViewById(w.h.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new g(this));
        TV();
        this.byr = (NoNetworkView) findViewById(w.h.view_no_network);
        this.byr.a(this.fJi);
        this.mProgress = (ProgressBar) findViewById(w.h.progress);
        this.Ic = (BdListView) findViewById(w.h.list);
        this.fYS = new n(this, this.fYX);
        this.fYS.a(this);
        this.fYS.a(new h(this));
        this.Ic.setAdapter((ListAdapter) this.fYS);
        this.Ic.setOnItemClickListener(this);
        this.Ic.setOnTouchListener(new i(this));
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.dhk.getParent() != null) {
            ((View) this.dhk.getParent()).setFocusable(true);
            ((View) this.dhk.getParent()).setFocusableInTouchMode(true);
        }
        this.dkP = (LinearLayout) this.mParent.findViewById(w.h.invite_candidate);
        this.dkQ = (Button) this.mParent.findViewById(w.h.button_send);
        this.dkQ.setOnClickListener(new j(this));
        mr(0);
        this.fYO = (AtSelectFriendList) this.mParent.findViewById(w.h.candidate_list);
        this.fYO.setMaxCount(5);
        this.fYO.setItemOPerationHandler(new k(this));
        atH();
    }

    private void TV() {
        this.mNavigationBar = (NavigationBar) findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new l(this));
        this.fYV = this.mNavigationBar.setTitleText(getPageContext().getString(w.l.select_friend));
        this.dkV = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.add_new_friend_text, new m(this));
        this.dkX = (ImageView) this.dkV.findViewById(w.h.new_friend_search);
        this.dkU = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.navigationbar_search_edit, (View.OnClickListener) null);
        this.dkU.setVisibility(8);
        this.dhk = (EditText) this.dkU.findViewById(w.h.search_bar_edit);
        this.dhk.addTextChangedListener(new com.baidu.tieba.write.write.b(this));
        this.dhk.setOnFocusChangeListener(new c(this));
        this.fYN = (TextView) findViewById(w.h.search_bar_delete_button);
        this.fYN.setOnClickListener(new d(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [470=4] */
    private void atH() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds80) + getResources().getDimensionPixelSize(w.f.ds16) + getResources().getDimensionPixelSize(w.f.ds16);
        this.mListFooter = new View(getPageContext().getContext());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setFocusable(false);
        this.mListFooter.setFocusableInTouchMode(false);
        this.mListFooter.setContentDescription("");
        this.mListFooter.setVisibility(4);
        this.mListFooter.setBackgroundColor(0);
        this.mListFooter.setOnClickListener(new e(this));
        this.Ic.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rv(String str) {
        if (!isFinishing()) {
            this.fYS.setData(null);
            if (this.fYP != null) {
                this.fYP.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.fYR.boq() != null) {
                    ArrayList<MetaData> bol = this.fYR.boq().bol();
                    Iterator<MetaData> it = bol.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (bol != null && !bol.isEmpty()) {
                        tD(0);
                    } else {
                        tD(1);
                    }
                    this.fYS.setData(bol);
                } else {
                    this.fYS.setData(null);
                    if (this.fYQ == null) {
                        this.fYQ = new b(this, null);
                        this.fYQ.setPriority(3);
                        this.fYQ.execute("");
                    }
                }
            } else {
                this.fYP = new a(this, null);
                this.fYP.setPriority(2);
                this.fYP.execute(str);
                if (this.fYQ == null && this.fYR.boq() == null) {
                    this.fYQ = new b(this, null);
                    this.fYQ.setPriority(3);
                    this.fYQ.execute("");
                }
            }
            this.fYS.notifyDataSetInvalidated();
            this.Ic.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.fYR = new com.baidu.tieba.write.model.d();
        if (bundle != null) {
            this.fYX = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.fYX = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(MetaData metaData) {
        if (metaData != null) {
            this.fYO.e(metaData);
            mr(this.fYO.getItemLength());
            atI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MetaData metaData) {
        if (metaData != null) {
            this.fYO.g(metaData);
            mr(this.fYO.getItemLength());
            atI();
        }
    }

    private void atI() {
        if (this.fYO.getItemLength() > 0) {
            this.dkQ.setEnabled(true);
        } else {
            this.dkQ.setEnabled(false);
        }
    }

    private void mr(int i) {
        this.dkQ.setText(String.format(getPageContext().getString(w.l.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.c> {
        private String fZa;
        private com.baidu.tbadk.core.util.z mNetwork;

        private a() {
            this.mNetwork = null;
            this.fZa = null;
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
            AtListActivity.this.fYP = null;
            this.fZa = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public com.baidu.tieba.write.a.c doInBackground(String... strArr) {
            this.fZa = strArr[0];
            this.mNetwork = new com.baidu.tbadk.core.util.z();
            if (this.fZa != null && this.fZa.length() > 0) {
                this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/sug");
                this.mNetwork.n(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.n("q", this.fZa);
                String ug = this.mNetwork.ug();
                if (this.mNetwork.uF().vB().isRequestSuccess()) {
                    com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
                    com.baidu.tieba.write.a.b boq = AtListActivity.this.fYR.boq();
                    if (boq != null) {
                        cVar.e(ug, boq.bom());
                        return cVar;
                    }
                    cVar.e(ug, null);
                    return cVar;
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.c cVar) {
            AtListActivity.this.fYP = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.uF().vB().isRequestSuccess() && this.fZa != null && com.baidu.adp.lib.util.j.a(AtListActivity.this.dhk.getText(), "").equals(this.fZa)) {
                if (cVar == null || cVar.bon().isEmpty()) {
                    AtListActivity.this.tD(1);
                } else {
                    AtListActivity.this.tD(0);
                }
                AtListActivity.this.fYR.a(cVar);
                AtListActivity.this.fYS.setData(cVar.bon());
                AtListActivity.this.fYS.notifyDataSetInvalidated();
                AtListActivity.this.Ic.setSelection(0);
            } else {
                AtListActivity.this.showToast(this.mNetwork.getErrorString());
            }
            super.onPostExecute(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.b> {
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
            AtListActivity.this.fYQ = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.mNetwork = new com.baidu.tbadk.core.util.z();
            this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/list");
            String ug = this.mNetwork.ug();
            if (!this.mNetwork.uF().vB().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
            bVar.rk(ug);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
            AtListActivity.this.fYQ = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.dkP != null && AtListActivity.this.dkP.getVisibility() == 0) {
                AtListActivity.this.fYU.setVisibility(0);
            }
            if (this.mNetwork.uF().vB().isRequestSuccess()) {
                AtListActivity.this.fYR.a(bVar);
                if (AtListActivity.this.fYS != null) {
                    if (com.baidu.adp.lib.util.j.a(AtListActivity.this.dhk.getText(), "").length() != 0) {
                        if (AtListActivity.this.fYR.bor() != null) {
                            if (bVar != null && bVar.bom() != null && !bVar.bom().isEmpty()) {
                                AtListActivity.this.tD(2);
                            }
                            AtListActivity.this.fYR.bor().k(bVar.bom());
                            AtListActivity.this.fYS.notifyDataSetInvalidated();
                        }
                    } else {
                        if (bVar == null || bVar.bol() == null || !bVar.bol().isEmpty()) {
                            AtListActivity.this.tD(0);
                        } else {
                            AtListActivity.this.tD(2);
                        }
                        AtListActivity.this.fYM = bVar.bol();
                        AtListActivity.this.fYS.setData(AtListActivity.this.fYM);
                        AtListActivity.this.fYS.notifyDataSetInvalidated();
                        AtListActivity.this.Ic.setSelection(0);
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
            this.fYO.f(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public com.baidu.adp.widget.ListView.w onGetPreLoadListView() {
        return this.Ic;
    }
}
