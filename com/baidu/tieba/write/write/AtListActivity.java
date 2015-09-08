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
    private NoNetworkView aNK;
    private LinearLayout bKk;
    private Button bKl;
    private View bKm;
    private View bKq;
    private View bKr;
    private AtSelectFriendList dbV;
    private TextView dcc;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.u mNoDataView;
    protected ArrayList<MetaData> dbT = new ArrayList<>();
    private EditText bEI = null;
    private TextView dbU = null;
    private BdListView mListView = null;
    private final Handler mHandler = new Handler();
    private a dbW = null;
    private b dbX = null;
    private com.baidu.tieba.write.c.a dbY = null;
    private m dbZ = null;
    private String dca = null;
    private ProgressBar mProgress = null;
    private RelativeLayout boe = null;
    private View dcb = null;
    private final int dcd = 5;
    private boolean dce = true;
    private final Runnable dcf = new com.baidu.tieba.write.write.a(this);
    private NoNetworkView.a dcg = new e(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.at_list_activity);
        initData(bundle);
        initUI();
        lJ(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.boe);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aNK.onChangeSkinType(getPageContext(), i);
        this.dbZ.notifyDataSetChanged();
        com.baidu.tbadk.core.util.al.getColor(i.c.widget_searchbox_text);
        com.baidu.tbadk.core.util.al.h(this.bKm, i.e.invite_friend_list_item_bg_color);
        com.baidu.tbadk.core.util.al.h((View) this.bKl, i.e.post_button_bg);
        com.baidu.tbadk.core.util.al.b(this.bKl, i.c.cp_cont_i, 3);
        this.bKm.setEnabled(false);
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
    public void li(int i) {
        if (i == 2) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cJ(i.h.no_chat_friends));
            this.bKk.setVisibility(8);
        } else if (i == 1) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cJ(i.h.no_search_friends));
            this.bKk.setVisibility(8);
        } else if (i == 0) {
            this.mListView.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.dce) {
                this.bKk.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.dbZ.getItem(i);
        if (item != null) {
            if (this.dce) {
                if (this.dbW == null && this.dbX == null) {
                    if (item.isChecked()) {
                        b(item);
                    } else if (5 <= this.dbV.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(i.h.invite_friend_exceed_max_count), 5), i.e.icon_toast_game_error);
                        return;
                    } else {
                        a(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.dbZ.notifyDataSetChanged();
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
            com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), this.bEI);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.dbW != null) {
            this.dbW.cancel();
        }
        if (this.dbX != null) {
            this.dbX.cancel();
        }
        this.mHandler.removeCallbacks(this.dcf);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.boe = (RelativeLayout) findViewById(i.f.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.boe, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cJ(i.h.no_chat_friends), null);
        this.dcb = findViewById(i.f.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new f(this));
        Oj();
        this.aNK = (NoNetworkView) findViewById(i.f.view_no_network);
        this.aNK.a(this.dcg);
        this.mProgress = (ProgressBar) findViewById(i.f.progress);
        this.mListView = (BdListView) findViewById(i.f.list);
        this.dbZ = new m(this, this.dce);
        this.dbZ.a(this);
        this.dbZ.setCheckBoxStateChangedListener(new g(this));
        this.mListView.setAdapter((ListAdapter) this.dbZ);
        this.mListView.setOnItemClickListener(this);
        this.mListView.setOnTouchListener(new h(this));
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.bEI.getParent() != null) {
            ((View) this.bEI.getParent()).setFocusable(true);
            ((View) this.bEI.getParent()).setFocusableInTouchMode(true);
        }
        this.bKk = (LinearLayout) this.boe.findViewById(i.f.invite_candidate);
        this.bKl = (Button) this.boe.findViewById(i.f.button_send);
        this.bKl.setOnClickListener(new i(this));
        hI(0);
        this.dbV = (AtSelectFriendList) this.boe.findViewById(i.f.candidate_list);
        this.dbV.setMaxCount(5);
        this.dbV.setItemOPerationHandler(new j(this));
        YR();
    }

    private void Oj() {
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new k(this));
        this.dcc = this.mNavigationBar.setTitleText(getPageContext().getString(i.h.select_friend));
        this.bKr = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.add_new_friend_text, new l(this));
        this.bKq = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, i.g.navigationbar_search_edit, (View.OnClickListener) null);
        this.bKq.setVisibility(8);
        this.bEI = (EditText) this.bKq.findViewById(i.f.search_bar_edit);
        this.bEI.addTextChangedListener(new com.baidu.tieba.write.write.b(this));
        this.bEI.setOnFocusChangeListener(new c(this));
        this.dbU = (TextView) findViewById(i.f.search_bar_delete_button);
        this.dbU.setOnClickListener(new d(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [474=4] */
    private void YR() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_height) + getResources().getDimensionPixelSize(i.d.invite_friend_candidate_padding_bottom) + getResources().getDimensionPixelSize(i.d.invite_friend_candidate_padding_top);
        this.bKm = new View(getPageContext().getContext());
        this.bKm.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListView.addFooterView(this.bKm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lJ(String str) {
        if (!isFinishing()) {
            this.dbZ.setData(null);
            if (this.dbW != null) {
                this.dbW.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.dbY.ayw() != null) {
                    ArrayList<MetaData> ays = this.dbY.ayw().ays();
                    Iterator<MetaData> it = ays.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (ays != null && !ays.isEmpty()) {
                        li(0);
                    } else {
                        li(1);
                    }
                    this.dbZ.setData(ays);
                } else {
                    this.dbZ.setData(null);
                    if (this.dbX == null) {
                        this.dbX = new b(this, null);
                        this.dbX.setPriority(3);
                        this.dbX.execute("");
                    }
                }
            } else {
                this.dbW = new a(this, null);
                this.dbW.setPriority(2);
                this.dbW.execute(str);
                if (this.dbX == null && this.dbY.ayw() == null) {
                    this.dbX = new b(this, null);
                    this.dbX.setPriority(3);
                    this.dbX.execute("");
                }
            }
            this.dbZ.notifyDataSetInvalidated();
            this.mListView.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.dbY = new com.baidu.tieba.write.c.a();
        if (bundle != null) {
            this.dce = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.dce = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MetaData metaData) {
        if (metaData != null) {
            this.dbV.c(metaData);
            hI(this.dbV.getItemLength());
            YS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MetaData metaData) {
        if (metaData != null) {
            this.dbV.e(metaData);
            hI(this.dbV.getItemLength());
            YS();
        }
    }

    private void YS() {
        if (this.dbV.getItemLength() > 0) {
            this.bKl.setEnabled(true);
        } else {
            this.bKl.setEnabled(false);
        }
    }

    private void hI(int i) {
        this.bKl.setText(String.format(getPageContext().getString(i.h.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.b> {
        private com.baidu.tbadk.core.util.v afT;
        private String dci;

        private a() {
            this.afT = null;
            this.dci = null;
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
            AtListActivity.this.dbW = null;
            this.dci = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.dci = strArr[0];
            this.afT = new com.baidu.tbadk.core.util.v();
            if (this.dci != null && this.dci.length() > 0) {
                this.afT.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/sug");
                this.afT.o("uid", TbadkCoreApplication.getCurrentAccount());
                this.afT.o("q", this.dci);
                String tI = this.afT.tI();
                if (this.afT.uj().va().qZ()) {
                    com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
                    com.baidu.tieba.write.a.a ayw = AtListActivity.this.dbY.ayw();
                    if (ayw != null) {
                        bVar.a(tI, ayw.ayt());
                        return bVar;
                    }
                    bVar.a(tI, (HashMap<String, String>) null);
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
            AtListActivity.this.dbW = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.afT.uj().va().qZ() && this.dci != null && com.baidu.adp.lib.util.j.a(AtListActivity.this.bEI.getText(), "").equals(this.dci)) {
                if (bVar == null || bVar.ayu().isEmpty()) {
                    AtListActivity.this.li(1);
                } else {
                    AtListActivity.this.li(0);
                }
                AtListActivity.this.dbY.a(bVar);
                AtListActivity.this.dbZ.setData(bVar.ayu());
                AtListActivity.this.dbZ.notifyDataSetInvalidated();
                AtListActivity.this.mListView.setSelection(0);
            } else {
                AtListActivity.this.showToast(this.afT.getErrorString());
            }
            super.onPostExecute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.a> {
        private com.baidu.tbadk.core.util.v afT;

        private b() {
            this.afT = null;
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
            if (this.afT != null) {
                this.afT.gJ();
            }
            AtListActivity.this.dbX = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public com.baidu.tieba.write.a.a doInBackground(String... strArr) {
            this.afT = new com.baidu.tbadk.core.util.v();
            this.afT.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/list");
            String tI = this.afT.tI();
            if (!this.afT.uj().va().qZ()) {
                return null;
            }
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.lH(tI);
            return aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.a aVar) {
            AtListActivity.this.dbX = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.bKk != null && AtListActivity.this.bKk.getVisibility() == 0) {
                AtListActivity.this.dcb.setVisibility(0);
            }
            if (this.afT.uj().va().qZ()) {
                AtListActivity.this.dbY.a(aVar);
                if (AtListActivity.this.dbZ != null) {
                    if (com.baidu.adp.lib.util.j.a(AtListActivity.this.bEI.getText(), "").length() != 0) {
                        if (AtListActivity.this.dbY.ayx() != null) {
                            if (aVar != null && aVar.ayt() != null && !aVar.ayt().isEmpty()) {
                                AtListActivity.this.li(2);
                            }
                            AtListActivity.this.dbY.ayx().i(aVar.ayt());
                            AtListActivity.this.dbZ.notifyDataSetInvalidated();
                        }
                    } else {
                        if (aVar == null || aVar.ays() == null || !aVar.ays().isEmpty()) {
                            AtListActivity.this.li(0);
                        } else {
                            AtListActivity.this.li(2);
                        }
                        AtListActivity.this.dbT = aVar.ays();
                        AtListActivity.this.dbZ.setData(AtListActivity.this.dbT);
                        AtListActivity.this.dbZ.notifyDataSetInvalidated();
                        AtListActivity.this.mListView.setSelection(0);
                    }
                } else {
                    return;
                }
            } else {
                AtListActivity.this.showToast(this.afT.getErrorString());
            }
            super.onPostExecute(aVar);
        }
    }

    @Override // com.baidu.tieba.write.write.m.b
    public void a(View view, MetaData metaData) {
        if (metaData != null) {
            this.dbV.d(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.mListView;
    }
}
