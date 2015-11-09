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
    private NoNetworkView aMY;
    private LinearLayout bNV;
    private Button bNW;
    private View bNX;
    private View bOb;
    private View bOc;
    private AtSelectFriendList dqb;
    private TextView dqi;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.m mNoDataView;
    protected ArrayList<MetaData> dpZ = new ArrayList<>();
    private EditText bIr = null;
    private TextView dqa = null;
    private BdListView mListView = null;
    private final Handler mHandler = new Handler();
    private a dqc = null;
    private b dqd = null;
    private com.baidu.tieba.write.b.a dqe = null;
    private m dqf = null;
    private String dqg = null;
    private ProgressBar mProgress = null;
    private RelativeLayout brS = null;
    private View dqh = null;
    private final int dqj = 5;
    private boolean dqk = true;
    private final Runnable dql = new com.baidu.tieba.write.write.a(this);
    private NoNetworkView.a dqm = new e(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.at_list_activity);
        initData(bundle);
        initUI();
        my(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.brS);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aMY.onChangeSkinType(getPageContext(), i);
        this.dqf.notifyDataSetChanged();
        com.baidu.tbadk.core.util.an.getColor(i.c.widget_searchbox_text);
        com.baidu.tbadk.core.util.an.i(this.bNX, i.e.invite_friend_list_item_bg_color);
        com.baidu.tbadk.core.util.an.i((View) this.bNW, i.e.post_button_bg);
        com.baidu.tbadk.core.util.an.b(this.bNW, i.c.cp_cont_i, 3);
        this.bNX.setEnabled(false);
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
    public void mv(int i) {
        if (i == 2) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.no_chat_friends));
            this.bNV.setVisibility(8);
        } else if (i == 1) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.no_search_friends));
            this.bNV.setVisibility(8);
        } else if (i == 0) {
            this.mListView.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.dqk) {
                this.bNV.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.dqf.getItem(i);
        if (item != null) {
            if (this.dqk) {
                if (this.dqc == null && this.dqd == null) {
                    if (item.isChecked()) {
                        b(item);
                    } else if (5 <= this.dqb.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(i.h.invite_friend_exceed_max_count), 5), i.e.icon_toast_game_error);
                        return;
                    } else {
                        a(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.dqf.notifyDataSetChanged();
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
            com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), this.bIr);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.dqc != null) {
            this.dqc.cancel();
        }
        if (this.dqd != null) {
            this.dqd.cancel();
        }
        this.mHandler.removeCallbacks(this.dql);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.brS = (RelativeLayout) findViewById(i.f.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.brS, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cK(i.h.no_chat_friends), null);
        this.dqh = findViewById(i.f.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new f(this));
        OC();
        this.aMY = (NoNetworkView) findViewById(i.f.view_no_network);
        this.aMY.a(this.dqm);
        this.mProgress = (ProgressBar) findViewById(i.f.progress);
        this.mListView = (BdListView) findViewById(i.f.list);
        this.dqf = new m(this, this.dqk);
        this.dqf.a(this);
        this.dqf.setCheckBoxStateChangedListener(new g(this));
        this.mListView.setAdapter((ListAdapter) this.dqf);
        this.mListView.setOnItemClickListener(this);
        this.mListView.setOnTouchListener(new h(this));
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.bIr.getParent() != null) {
            ((View) this.bIr.getParent()).setFocusable(true);
            ((View) this.bIr.getParent()).setFocusableInTouchMode(true);
        }
        this.bNV = (LinearLayout) this.brS.findViewById(i.f.invite_candidate);
        this.bNW = (Button) this.brS.findViewById(i.f.button_send);
        this.bNW.setOnClickListener(new i(this));
        ib(0);
        this.dqb = (AtSelectFriendList) this.brS.findViewById(i.f.candidate_list);
        this.dqb.setMaxCount(5);
        this.dqb.setItemOPerationHandler(new j(this));
        ZQ();
    }

    private void OC() {
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new k(this));
        this.dqi = this.mNavigationBar.setTitleText(getPageContext().getString(i.h.select_friend));
        this.bOc = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.add_new_friend_text, new l(this));
        this.bOb = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, i.g.navigationbar_search_edit, (View.OnClickListener) null);
        this.bOb.setVisibility(8);
        this.bIr = (EditText) this.bOb.findViewById(i.f.search_bar_edit);
        this.bIr.addTextChangedListener(new com.baidu.tieba.write.write.b(this));
        this.bIr.setOnFocusChangeListener(new c(this));
        this.dqa = (TextView) findViewById(i.f.search_bar_delete_button);
        this.dqa.setOnClickListener(new d(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [474=4] */
    private void ZQ() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_height) + getResources().getDimensionPixelSize(i.d.invite_friend_candidate_padding_bottom) + getResources().getDimensionPixelSize(i.d.invite_friend_candidate_padding_top);
        this.bNX = new View(getPageContext().getContext());
        this.bNX.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListView.addFooterView(this.bNX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void my(String str) {
        if (!isFinishing()) {
            this.dqf.setData(null);
            if (this.dqc != null) {
                this.dqc.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.dqe.aCz() != null) {
                    ArrayList<MetaData> aCu = this.dqe.aCz().aCu();
                    Iterator<MetaData> it = aCu.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (aCu != null && !aCu.isEmpty()) {
                        mv(0);
                    } else {
                        mv(1);
                    }
                    this.dqf.setData(aCu);
                } else {
                    this.dqf.setData(null);
                    if (this.dqd == null) {
                        this.dqd = new b(this, null);
                        this.dqd.setPriority(3);
                        this.dqd.execute("");
                    }
                }
            } else {
                this.dqc = new a(this, null);
                this.dqc.setPriority(2);
                this.dqc.execute(str);
                if (this.dqd == null && this.dqe.aCz() == null) {
                    this.dqd = new b(this, null);
                    this.dqd.setPriority(3);
                    this.dqd.execute("");
                }
            }
            this.dqf.notifyDataSetInvalidated();
            this.mListView.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.dqe = new com.baidu.tieba.write.b.a();
        if (bundle != null) {
            this.dqk = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.dqk = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MetaData metaData) {
        if (metaData != null) {
            this.dqb.c(metaData);
            ib(this.dqb.getItemLength());
            ZR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MetaData metaData) {
        if (metaData != null) {
            this.dqb.e(metaData);
            ib(this.dqb.getItemLength());
            ZR();
        }
    }

    private void ZR() {
        if (this.dqb.getItemLength() > 0) {
            this.bNW.setEnabled(true);
        } else {
            this.bNW.setEnabled(false);
        }
    }

    private void ib(int i) {
        this.bNW.setText(String.format(getPageContext().getString(i.h.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.data.c> {
        private com.baidu.tbadk.core.util.w afm;
        private String dqo;

        private a() {
            this.afm = null;
            this.dqo = null;
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
            AtListActivity.this.dqc = null;
            this.dqo = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public com.baidu.tieba.write.data.c doInBackground(String... strArr) {
            this.dqo = strArr[0];
            this.afm = new com.baidu.tbadk.core.util.w();
            if (this.dqo != null && this.dqo.length() > 0) {
                this.afm.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/sug");
                this.afm.o("uid", TbadkCoreApplication.getCurrentAccount());
                this.afm.o("q", this.dqo);
                String tG = this.afm.tG();
                if (this.afm.uh().va().qT()) {
                    com.baidu.tieba.write.data.c cVar = new com.baidu.tieba.write.data.c();
                    com.baidu.tieba.write.data.a aCz = AtListActivity.this.dqe.aCz();
                    if (aCz != null) {
                        cVar.a(tG, aCz.aCv());
                        return cVar;
                    }
                    cVar.a(tG, (HashMap<String, String>) null);
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
            AtListActivity.this.dqc = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.afm.uh().va().qT() && this.dqo != null && com.baidu.adp.lib.util.j.a(AtListActivity.this.bIr.getText(), "").equals(this.dqo)) {
                if (cVar == null || cVar.aCx().isEmpty()) {
                    AtListActivity.this.mv(1);
                } else {
                    AtListActivity.this.mv(0);
                }
                AtListActivity.this.dqe.a(cVar);
                AtListActivity.this.dqf.setData(cVar.aCx());
                AtListActivity.this.dqf.notifyDataSetInvalidated();
                AtListActivity.this.mListView.setSelection(0);
            } else {
                AtListActivity.this.showToast(this.afm.getErrorString());
            }
            super.onPostExecute(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, com.baidu.tieba.write.data.a> {
        private com.baidu.tbadk.core.util.w afm;

        private b() {
            this.afm = null;
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
            if (this.afm != null) {
                this.afm.gJ();
            }
            AtListActivity.this.dqd = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public com.baidu.tieba.write.data.a doInBackground(String... strArr) {
            this.afm = new com.baidu.tbadk.core.util.w();
            this.afm.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/list");
            String tG = this.afm.tG();
            if (!this.afm.uh().va().qT()) {
                return null;
            }
            com.baidu.tieba.write.data.a aVar = new com.baidu.tieba.write.data.a();
            aVar.mt(tG);
            return aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.data.a aVar) {
            AtListActivity.this.dqd = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.bNV != null && AtListActivity.this.bNV.getVisibility() == 0) {
                AtListActivity.this.dqh.setVisibility(0);
            }
            if (this.afm.uh().va().qT()) {
                AtListActivity.this.dqe.a(aVar);
                if (AtListActivity.this.dqf != null) {
                    if (com.baidu.adp.lib.util.j.a(AtListActivity.this.bIr.getText(), "").length() != 0) {
                        if (AtListActivity.this.dqe.aCA() != null) {
                            if (aVar != null && aVar.aCv() != null && !aVar.aCv().isEmpty()) {
                                AtListActivity.this.mv(2);
                            }
                            AtListActivity.this.dqe.aCA().i(aVar.aCv());
                            AtListActivity.this.dqf.notifyDataSetInvalidated();
                        }
                    } else {
                        if (aVar == null || aVar.aCu() == null || !aVar.aCu().isEmpty()) {
                            AtListActivity.this.mv(0);
                        } else {
                            AtListActivity.this.mv(2);
                        }
                        AtListActivity.this.dpZ = aVar.aCu();
                        AtListActivity.this.dqf.setData(AtListActivity.this.dpZ);
                        AtListActivity.this.dqf.notifyDataSetInvalidated();
                        AtListActivity.this.mListView.setSelection(0);
                    }
                } else {
                    return;
                }
            } else {
                AtListActivity.this.showToast(this.afm.getErrorString());
            }
            super.onPostExecute(aVar);
        }
    }

    @Override // com.baidu.tieba.write.write.m.b
    public void a(View view, MetaData metaData) {
        if (metaData != null) {
            this.dqb.d(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.mListView;
    }
}
