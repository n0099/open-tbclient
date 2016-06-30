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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.u;
import com.baidu.tieba.write.write.n;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class AtListActivity extends BaseActivity<AtListActivity> implements AdapterView.OnItemClickListener, n.b {
    private NoNetworkView bkT;
    private LinearLayout dcq;
    private Button dcr;
    private View dcw;
    private View dcx;
    private ImageView dcz;
    private AtSelectFriendList fHH;
    private TextView fHO;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.q mNoDataView;
    protected ArrayList<MetaData> fHF = new ArrayList<>();
    private EditText cWP = null;
    private TextView fHG = null;
    private BdListView zt = null;
    private final Handler mHandler = new Handler();
    private a fHI = null;
    private b fHJ = null;
    private com.baidu.tieba.write.b.a fHK = null;
    private n fHL = null;
    private String fHM = null;
    private ProgressBar cbl = null;
    private RelativeLayout cEz = null;
    private View fHN = null;
    private final int fHP = 5;
    private boolean fHQ = true;
    private final Runnable fHR = new com.baidu.tieba.write.write.a(this);
    private NoNetworkView.a fHS = new f(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(u.h.at_list_activity);
        initData(bundle);
        nl();
        qY(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ad(i == 1);
        getLayoutMode().w(this.cEz);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bkT.onChangeSkinType(getPageContext(), i);
        this.fHL.notifyDataSetChanged();
        com.baidu.tbadk.core.util.av.getColor(u.d.common_color_10221);
        com.baidu.tbadk.core.util.av.k(this.mListFooter, u.f.invite_friend_list_item_bg_color);
        com.baidu.tbadk.core.util.av.k(this.dcr, u.f.post_button_bg);
        com.baidu.tbadk.core.util.av.c(this.dcr, u.d.cp_cont_i, 3);
        com.baidu.tbadk.core.util.av.a(this.dcz, u.f.icon_search_bg_s, u.f.icon_search_bg);
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
    public void sz(int i) {
        if (i == 2) {
            this.zt.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cQ(u.j.no_chat_friends));
            this.dcq.setVisibility(8);
        } else if (i == 1) {
            this.zt.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cQ(u.j.no_search_friends));
            this.dcq.setVisibility(8);
        } else if (i == 0) {
            this.zt.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.fHQ) {
                this.dcq.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.fHL.getItem(i);
        if (item != null) {
            if (this.fHQ) {
                if (this.fHI == null && this.fHJ == null) {
                    if (item.isChecked()) {
                        b(item);
                    } else if (5 <= this.fHH.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(u.j.invite_friend_exceed_max_count), 5), u.f.icon_toast_game_error);
                        return;
                    } else {
                        a(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.fHL.notifyDataSetChanged();
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
            com.baidu.adp.lib.util.k.a(getPageContext().getPageActivity(), this.cWP);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fHI != null) {
            this.fHI.cancel();
        }
        if (this.fHJ != null) {
            this.fHJ.cancel();
        }
        this.mHandler.removeCallbacks(this.fHR);
        if (this.cbl != null) {
            this.cbl.setVisibility(8);
        }
        super.onDestroy();
    }

    private void nl() {
        this.cEz = (RelativeLayout) findViewById(u.g.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.cEz, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cQ(u.j.no_chat_friends), null);
        this.fHN = findViewById(u.g.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new g(this));
        PQ();
        this.bkT = (NoNetworkView) findViewById(u.g.view_no_network);
        this.bkT.a(this.fHS);
        this.cbl = (ProgressBar) findViewById(u.g.progress);
        this.zt = (BdListView) findViewById(u.g.list);
        this.fHL = new n(this, this.fHQ);
        this.fHL.a(this);
        this.fHL.a(new h(this));
        this.zt.setAdapter((ListAdapter) this.fHL);
        this.zt.setOnItemClickListener(this);
        this.zt.setOnTouchListener(new i(this));
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.cWP.getParent() != null) {
            ((View) this.cWP.getParent()).setFocusable(true);
            ((View) this.cWP.getParent()).setFocusableInTouchMode(true);
        }
        this.dcq = (LinearLayout) this.cEz.findViewById(u.g.invite_candidate);
        this.dcr = (Button) this.cEz.findViewById(u.g.button_send);
        this.dcr.setOnClickListener(new j(this));
        ly(0);
        this.fHH = (AtSelectFriendList) this.cEz.findViewById(u.g.candidate_list);
        this.fHH.setMaxCount(5);
        this.fHH.setItemOPerationHandler(new k(this));
        atd();
    }

    private void PQ() {
        this.mNavigationBar = (NavigationBar) findViewById(u.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new l(this));
        this.fHO = this.mNavigationBar.setTitleText(getPageContext().getString(u.j.select_friend));
        this.dcx = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.add_new_friend_text, new m(this));
        this.dcz = (ImageView) this.dcx.findViewById(u.g.new_friend_search);
        this.dcw = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, u.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.dcw.setVisibility(8);
        this.cWP = (EditText) this.dcw.findViewById(u.g.search_bar_edit);
        this.cWP.addTextChangedListener(new com.baidu.tieba.write.write.b(this));
        this.cWP.setOnFocusChangeListener(new c(this));
        this.fHG = (TextView) findViewById(u.g.search_bar_delete_button);
        this.fHG.setOnClickListener(new d(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [476=4] */
    private void atd() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(u.e.ds80) + getResources().getDimensionPixelSize(u.e.ds16) + getResources().getDimensionPixelSize(u.e.ds16);
        this.mListFooter = new View(getPageContext().getContext());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setFocusable(false);
        this.mListFooter.setFocusableInTouchMode(false);
        this.mListFooter.setContentDescription("");
        this.mListFooter.setVisibility(4);
        this.mListFooter.setBackgroundColor(0);
        this.mListFooter.setOnClickListener(new e(this));
        this.zt.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qY(String str) {
        if (!isFinishing()) {
            this.fHL.setData(null);
            if (this.fHI != null) {
                this.fHI.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.fHK.bks() != null) {
                    ArrayList<MetaData> bko = this.fHK.bks().bko();
                    Iterator<MetaData> it = bko.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (bko != null && !bko.isEmpty()) {
                        sz(0);
                    } else {
                        sz(1);
                    }
                    this.fHL.setData(bko);
                } else {
                    this.fHL.setData(null);
                    if (this.fHJ == null) {
                        this.fHJ = new b(this, null);
                        this.fHJ.setPriority(3);
                        this.fHJ.execute("");
                    }
                }
            } else {
                this.fHI = new a(this, null);
                this.fHI.setPriority(2);
                this.fHI.execute(str);
                if (this.fHJ == null && this.fHK.bks() == null) {
                    this.fHJ = new b(this, null);
                    this.fHJ.setPriority(3);
                    this.fHJ.execute("");
                }
            }
            this.fHL.notifyDataSetInvalidated();
            this.zt.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.fHK = new com.baidu.tieba.write.b.a();
        if (bundle != null) {
            this.fHQ = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.fHQ = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MetaData metaData) {
        if (metaData != null) {
            this.fHH.c(metaData);
            ly(this.fHH.getItemLength());
            ate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MetaData metaData) {
        if (metaData != null) {
            this.fHH.e(metaData);
            ly(this.fHH.getItemLength());
            ate();
        }
    }

    private void ate() {
        if (this.fHH.getItemLength() > 0) {
            this.dcr.setEnabled(true);
        } else {
            this.dcr.setEnabled(false);
        }
    }

    private void ly(int i) {
        this.dcr.setText(String.format(getPageContext().getString(u.j.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.data.c> {
        private com.baidu.tbadk.core.util.ab afj;
        private String fHU;

        private a() {
            this.afj = null;
            this.fHU = null;
        }

        /* synthetic */ a(AtListActivity atListActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.cbl.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.fHI = null;
            this.fHU = null;
            AtListActivity.this.cbl.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: L */
        public com.baidu.tieba.write.data.c doInBackground(String... strArr) {
            this.fHU = strArr[0];
            this.afj = new com.baidu.tbadk.core.util.ab();
            if (this.fHU != null && this.fHU.length() > 0) {
                this.afj.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/sug");
                this.afj.n("uid", TbadkCoreApplication.getCurrentAccount());
                this.afj.n("q", this.fHU);
                String ta = this.afj.ta();
                if (this.afj.ty().uv().nU()) {
                    com.baidu.tieba.write.data.c cVar = new com.baidu.tieba.write.data.c();
                    com.baidu.tieba.write.data.a bks = AtListActivity.this.fHK.bks();
                    if (bks != null) {
                        cVar.c(ta, bks.bkp());
                        return cVar;
                    }
                    cVar.c(ta, null);
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
            AtListActivity.this.fHI = null;
            AtListActivity.this.cbl.setVisibility(8);
            if (this.afj.ty().uv().nU() && this.fHU != null && com.baidu.adp.lib.util.j.a(AtListActivity.this.cWP.getText(), "").equals(this.fHU)) {
                if (cVar == null || cVar.bkq().isEmpty()) {
                    AtListActivity.this.sz(1);
                } else {
                    AtListActivity.this.sz(0);
                }
                AtListActivity.this.fHK.a(cVar);
                AtListActivity.this.fHL.setData(cVar.bkq());
                AtListActivity.this.fHL.notifyDataSetInvalidated();
                AtListActivity.this.zt.setSelection(0);
            } else {
                AtListActivity.this.showToast(this.afj.getErrorString());
            }
            super.onPostExecute(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, com.baidu.tieba.write.data.a> {
        private com.baidu.tbadk.core.util.ab afj;

        private b() {
            this.afj = null;
        }

        /* synthetic */ b(AtListActivity atListActivity, b bVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.cbl.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afj != null) {
                this.afj.dm();
            }
            AtListActivity.this.fHJ = null;
            AtListActivity.this.cbl.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: M */
        public com.baidu.tieba.write.data.a doInBackground(String... strArr) {
            this.afj = new com.baidu.tbadk.core.util.ab();
            this.afj.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/list");
            String ta = this.afj.ta();
            if (!this.afj.ty().uv().nU()) {
                return null;
            }
            com.baidu.tieba.write.data.a aVar = new com.baidu.tieba.write.data.a();
            aVar.qO(ta);
            return aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.data.a aVar) {
            AtListActivity.this.fHJ = null;
            AtListActivity.this.cbl.setVisibility(8);
            if (AtListActivity.this.dcq != null && AtListActivity.this.dcq.getVisibility() == 0) {
                AtListActivity.this.fHN.setVisibility(0);
            }
            if (this.afj.ty().uv().nU()) {
                AtListActivity.this.fHK.a(aVar);
                if (AtListActivity.this.fHL != null) {
                    if (com.baidu.adp.lib.util.j.a(AtListActivity.this.cWP.getText(), "").length() != 0) {
                        if (AtListActivity.this.fHK.bkt() != null) {
                            if (aVar != null && aVar.bkp() != null && !aVar.bkp().isEmpty()) {
                                AtListActivity.this.sz(2);
                            }
                            AtListActivity.this.fHK.bkt().j(aVar.bkp());
                            AtListActivity.this.fHL.notifyDataSetInvalidated();
                        }
                    } else {
                        if (aVar == null || aVar.bko() == null || !aVar.bko().isEmpty()) {
                            AtListActivity.this.sz(0);
                        } else {
                            AtListActivity.this.sz(2);
                        }
                        AtListActivity.this.fHF = aVar.bko();
                        AtListActivity.this.fHL.setData(AtListActivity.this.fHF);
                        AtListActivity.this.fHL.notifyDataSetInvalidated();
                        AtListActivity.this.zt.setSelection(0);
                    }
                } else {
                    return;
                }
            } else {
                AtListActivity.this.showToast(this.afj.getErrorString());
            }
            super.onPostExecute(aVar);
        }
    }

    @Override // com.baidu.tieba.write.write.n.b
    public void a(View view, MetaData metaData) {
        if (metaData != null) {
            this.fHH.d(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.zt;
    }
}
