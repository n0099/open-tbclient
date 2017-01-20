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
import com.baidu.tieba.r;
import com.baidu.tieba.write.write.n;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class AtListActivity extends BaseActivity<AtListActivity> implements AdapterView.OnItemClickListener, n.b {
    private NoNetworkView bxs;
    private LinearLayout dij;
    private Button dik;
    private View dio;
    private View dip;
    private ImageView dir;
    private AtSelectFriendList fKp;
    private TextView fKw;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    protected ArrayList<MetaData> fKn = new ArrayList<>();
    private EditText deH = null;
    private TextView fKo = null;
    private BdListView Bw = null;
    private final Handler mHandler = new Handler();
    private a fKq = null;
    private b fKr = null;
    private com.baidu.tieba.write.c.a fKs = null;
    private n fKt = null;
    private String fKu = null;
    private ProgressBar bkd = null;
    private RelativeLayout mParent = null;
    private View fKv = null;
    private final int fKx = 5;
    private boolean fKy = true;
    private final Runnable fKz = new com.baidu.tieba.write.write.a(this);
    private NoNetworkView.a fwl = new f(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(r.j.at_list_activity);
        initData(bundle);
        initUI();
        rJ(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ai(i == 1);
        getLayoutMode().v(this.mParent);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bxs.onChangeSkinType(getPageContext(), i);
        this.fKt.notifyDataSetChanged();
        com.baidu.tbadk.core.util.ap.getColor(r.e.common_color_10221);
        com.baidu.tbadk.core.util.ap.j(this.mListFooter, r.g.invite_friend_list_item_bg_color);
        com.baidu.tbadk.core.util.ap.j((View) this.dik, r.g.post_button_bg);
        com.baidu.tbadk.core.util.ap.c(this.dik, r.e.cp_cont_i, 3);
        com.baidu.tbadk.core.util.ap.b(this.dir, r.g.icon_search_bg_s, r.g.icon_search_bg);
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
    public void ti(int i) {
        if (i == 2) {
            this.Bw.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.di(r.l.no_chat_friends));
            this.dij.setVisibility(8);
        } else if (i == 1) {
            this.Bw.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.di(r.l.no_search_friends));
            this.dij.setVisibility(8);
        } else if (i == 0) {
            this.Bw.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.fKy) {
                this.dij.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.fKt.getItem(i);
        if (item != null) {
            if (this.fKy) {
                if (this.fKq == null && this.fKr == null) {
                    if (item.isChecked()) {
                        c(item);
                    } else if (5 <= this.fKp.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(r.l.invite_friend_exceed_max_count), 5), r.g.icon_toast_game_error);
                        return;
                    } else {
                        b(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.fKt.notifyDataSetChanged();
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
            com.baidu.adp.lib.util.k.b(getPageContext().getPageActivity(), this.deH);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fKq != null) {
            this.fKq.cancel();
        }
        if (this.fKr != null) {
            this.fKr.cancel();
        }
        this.mHandler.removeCallbacks(this.fKz);
        if (this.bkd != null) {
            this.bkd.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(r.h.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.adp.lib.util.k.e(getActivity(), r.f.ds320)), NoDataViewFactory.d.di(r.l.no_chat_friends), null, true);
        this.fKv = findViewById(r.h.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new g(this));
        adO();
        this.bxs = (NoNetworkView) findViewById(r.h.view_no_network);
        this.bxs.a(this.fwl);
        this.bkd = (ProgressBar) findViewById(r.h.progress);
        this.Bw = (BdListView) findViewById(r.h.list);
        this.fKt = new n(this, this.fKy);
        this.fKt.a(this);
        this.fKt.a(new h(this));
        this.Bw.setAdapter((ListAdapter) this.fKt);
        this.Bw.setOnItemClickListener(this);
        this.Bw.setOnTouchListener(new i(this));
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.deH.getParent() != null) {
            ((View) this.deH.getParent()).setFocusable(true);
            ((View) this.deH.getParent()).setFocusableInTouchMode(true);
        }
        this.dij = (LinearLayout) this.mParent.findViewById(r.h.invite_candidate);
        this.dik = (Button) this.mParent.findViewById(r.h.button_send);
        this.dik.setOnClickListener(new j(this));
        mn(0);
        this.fKp = (AtSelectFriendList) this.mParent.findViewById(r.h.candidate_list);
        this.fKp.setMaxCount(5);
        this.fKp.setItemOPerationHandler(new k(this));
        avB();
    }

    private void adO() {
        this.mNavigationBar = (NavigationBar) findViewById(r.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new l(this));
        this.fKw = this.mNavigationBar.setTitleText(getPageContext().getString(r.l.select_friend));
        this.dip = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.j.add_new_friend_text, new m(this));
        this.dir = (ImageView) this.dip.findViewById(r.h.new_friend_search);
        this.dio = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, r.j.navigationbar_search_edit, (View.OnClickListener) null);
        this.dio.setVisibility(8);
        this.deH = (EditText) this.dio.findViewById(r.h.search_bar_edit);
        this.deH.addTextChangedListener(new com.baidu.tieba.write.write.b(this));
        this.deH.setOnFocusChangeListener(new c(this));
        this.fKo = (TextView) findViewById(r.h.search_bar_delete_button);
        this.fKo.setOnClickListener(new d(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [469=4] */
    private void avB() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(r.f.ds80) + getResources().getDimensionPixelSize(r.f.ds16) + getResources().getDimensionPixelSize(r.f.ds16);
        this.mListFooter = new View(getPageContext().getContext());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setFocusable(false);
        this.mListFooter.setFocusableInTouchMode(false);
        this.mListFooter.setContentDescription("");
        this.mListFooter.setVisibility(4);
        this.mListFooter.setBackgroundColor(0);
        this.mListFooter.setOnClickListener(new e(this));
        this.Bw.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rJ(String str) {
        if (!isFinishing()) {
            this.fKt.setData(null);
            if (this.fKq != null) {
                this.fKq.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.fKs.bnz() != null) {
                    ArrayList<MetaData> bnv = this.fKs.bnz().bnv();
                    Iterator<MetaData> it = bnv.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (bnv != null && !bnv.isEmpty()) {
                        ti(0);
                    } else {
                        ti(1);
                    }
                    this.fKt.setData(bnv);
                } else {
                    this.fKt.setData(null);
                    if (this.fKr == null) {
                        this.fKr = new b(this, null);
                        this.fKr.setPriority(3);
                        this.fKr.execute("");
                    }
                }
            } else {
                this.fKq = new a(this, null);
                this.fKq.setPriority(2);
                this.fKq.execute(str);
                if (this.fKr == null && this.fKs.bnz() == null) {
                    this.fKr = new b(this, null);
                    this.fKr.setPriority(3);
                    this.fKr.execute("");
                }
            }
            this.fKt.notifyDataSetInvalidated();
            this.Bw.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.fKs = new com.baidu.tieba.write.c.a();
        if (bundle != null) {
            this.fKy = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.fKy = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MetaData metaData) {
        if (metaData != null) {
            this.fKp.d(metaData);
            mn(this.fKp.getItemLength());
            avC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(MetaData metaData) {
        if (metaData != null) {
            this.fKp.f(metaData);
            mn(this.fKp.getItemLength());
            avC();
        }
    }

    private void avC() {
        if (this.fKp.getItemLength() > 0) {
            this.dik.setEnabled(true);
        } else {
            this.dik.setEnabled(false);
        }
    }

    private void mn(int i) {
        this.dik.setText(String.format(getPageContext().getString(r.l.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.b> {
        private String fKB;
        private com.baidu.tbadk.core.util.y mNetwork;

        private a() {
            this.mNetwork = null;
            this.fKB = null;
        }

        /* synthetic */ a(AtListActivity atListActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.bkd.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.fKq = null;
            this.fKB = null;
            AtListActivity.this.bkd.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: H */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.fKB = strArr[0];
            this.mNetwork = new com.baidu.tbadk.core.util.y();
            if (this.fKB != null && this.fKB.length() > 0) {
                this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/sug");
                this.mNetwork.n(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.n("q", this.fKB);
                String ud = this.mNetwork.ud();
                if (this.mNetwork.uC().vw().isRequestSuccess()) {
                    com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
                    com.baidu.tieba.write.a.a bnz = AtListActivity.this.fKs.bnz();
                    if (bnz != null) {
                        bVar.c(ud, bnz.bnw());
                        return bVar;
                    }
                    bVar.c(ud, null);
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
            AtListActivity.this.fKq = null;
            AtListActivity.this.bkd.setVisibility(8);
            if (this.mNetwork.uC().vw().isRequestSuccess() && this.fKB != null && com.baidu.adp.lib.util.j.a(AtListActivity.this.deH.getText(), "").equals(this.fKB)) {
                if (bVar == null || bVar.bnx().isEmpty()) {
                    AtListActivity.this.ti(1);
                } else {
                    AtListActivity.this.ti(0);
                }
                AtListActivity.this.fKs.a(bVar);
                AtListActivity.this.fKt.setData(bVar.bnx());
                AtListActivity.this.fKt.notifyDataSetInvalidated();
                AtListActivity.this.Bw.setSelection(0);
            } else {
                AtListActivity.this.showToast(this.mNetwork.getErrorString());
            }
            super.onPostExecute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.a> {
        private com.baidu.tbadk.core.util.y mNetwork;

        private b() {
            this.mNetwork = null;
        }

        /* synthetic */ b(AtListActivity atListActivity, b bVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.bkd.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ee();
            }
            AtListActivity.this.fKr = null;
            AtListActivity.this.bkd.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public com.baidu.tieba.write.a.a doInBackground(String... strArr) {
            this.mNetwork = new com.baidu.tbadk.core.util.y();
            this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/list");
            String ud = this.mNetwork.ud();
            if (!this.mNetwork.uC().vw().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.rA(ud);
            return aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.a aVar) {
            AtListActivity.this.fKr = null;
            AtListActivity.this.bkd.setVisibility(8);
            if (AtListActivity.this.dij != null && AtListActivity.this.dij.getVisibility() == 0) {
                AtListActivity.this.fKv.setVisibility(0);
            }
            if (this.mNetwork.uC().vw().isRequestSuccess()) {
                AtListActivity.this.fKs.a(aVar);
                if (AtListActivity.this.fKt != null) {
                    if (com.baidu.adp.lib.util.j.a(AtListActivity.this.deH.getText(), "").length() != 0) {
                        if (AtListActivity.this.fKs.bnA() != null) {
                            if (aVar != null && aVar.bnw() != null && !aVar.bnw().isEmpty()) {
                                AtListActivity.this.ti(2);
                            }
                            AtListActivity.this.fKs.bnA().k(aVar.bnw());
                            AtListActivity.this.fKt.notifyDataSetInvalidated();
                        }
                    } else {
                        if (aVar == null || aVar.bnv() == null || !aVar.bnv().isEmpty()) {
                            AtListActivity.this.ti(0);
                        } else {
                            AtListActivity.this.ti(2);
                        }
                        AtListActivity.this.fKn = aVar.bnv();
                        AtListActivity.this.fKt.setData(AtListActivity.this.fKn);
                        AtListActivity.this.fKt.notifyDataSetInvalidated();
                        AtListActivity.this.Bw.setSelection(0);
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
            this.fKp.e(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.Bw;
    }
}
