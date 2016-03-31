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
import com.baidu.tieba.write.write.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public class AtListActivity extends BaseActivity<AtListActivity> implements AdapterView.OnItemClickListener, n.b {
    private NoNetworkView baT;
    private LinearLayout cwe;
    private Button cwf;
    private View cwj;
    private View cwk;
    private AtSelectFriendList eLq;
    private TextView eLx;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.p mNoDataView;
    protected ArrayList<MetaData> eLo = new ArrayList<>();
    private EditText cqC = null;
    private TextView eLp = null;
    private BdListView Je = null;
    private final Handler mHandler = new Handler();
    private a eLr = null;
    private b eLs = null;
    private com.baidu.tieba.write.b.a eLt = null;
    private n eLu = null;
    private String eLv = null;
    private ProgressBar aQj = null;
    private RelativeLayout bYK = null;
    private View eLw = null;
    private final int eLy = 5;
    private boolean eLz = true;
    private final Runnable eLA = new com.baidu.tieba.write.write.a(this);
    private NoNetworkView.a eLB = new f(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.at_list_activity);
        initData(bundle);
        pU();
        oY(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().x(this.bYK);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.baT.onChangeSkinType(getPageContext(), i);
        this.eLu.notifyDataSetChanged();
        com.baidu.tbadk.core.util.at.getColor(t.d.widget_searchbox_text);
        com.baidu.tbadk.core.util.at.k(this.mListFooter, t.f.invite_friend_list_item_bg_color);
        com.baidu.tbadk.core.util.at.k(this.cwf, t.f.post_button_bg);
        com.baidu.tbadk.core.util.at.b(this.cwf, t.d.cp_cont_i, 3);
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
    public void qO(int i) {
        if (i == 2) {
            this.Je.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dg(t.j.no_chat_friends));
            this.cwe.setVisibility(8);
        } else if (i == 1) {
            this.Je.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dg(t.j.no_search_friends));
            this.cwe.setVisibility(8);
        } else if (i == 0) {
            this.Je.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.eLz) {
                this.cwe.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.eLu.getItem(i);
        if (item != null) {
            if (this.eLz) {
                if (this.eLr == null && this.eLs == null) {
                    if (item.isChecked()) {
                        b(item);
                    } else if (5 <= this.eLq.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(t.j.invite_friend_exceed_max_count), 5), t.f.icon_toast_game_error);
                        return;
                    } else {
                        a(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.eLu.notifyDataSetChanged();
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
            com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), this.cqC);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.eLr != null) {
            this.eLr.cancel();
        }
        if (this.eLs != null) {
            this.eLs.cancel();
        }
        this.mHandler.removeCallbacks(this.eLA);
        if (this.aQj != null) {
            this.aQj.setVisibility(8);
        }
        super.onDestroy();
    }

    private void pU() {
        this.bYK = (RelativeLayout) findViewById(t.g.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.bYK, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dg(t.j.no_chat_friends), null);
        this.eLw = findViewById(t.g.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new g(this));
        Ux();
        this.baT = (NoNetworkView) findViewById(t.g.view_no_network);
        this.baT.a(this.eLB);
        this.aQj = (ProgressBar) findViewById(t.g.progress);
        this.Je = (BdListView) findViewById(t.g.list);
        this.eLu = new n(this, this.eLz);
        this.eLu.a(this);
        this.eLu.a(new h(this));
        this.Je.setAdapter((ListAdapter) this.eLu);
        this.Je.setOnItemClickListener(this);
        this.Je.setOnTouchListener(new i(this));
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.cqC.getParent() != null) {
            ((View) this.cqC.getParent()).setFocusable(true);
            ((View) this.cqC.getParent()).setFocusableInTouchMode(true);
        }
        this.cwe = (LinearLayout) this.bYK.findViewById(t.g.invite_candidate);
        this.cwf = (Button) this.bYK.findViewById(t.g.button_send);
        this.cwf.setOnClickListener(new j(this));
        ks(0);
        this.eLq = (AtSelectFriendList) this.bYK.findViewById(t.g.candidate_list);
        this.eLq.setMaxCount(5);
        this.eLq.setItemOPerationHandler(new k(this));
        akJ();
    }

    private void Ux() {
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new l(this));
        this.eLx = this.mNavigationBar.setTitleText(getPageContext().getString(t.j.select_friend));
        this.cwk = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.add_new_friend_text, new m(this));
        this.cwj = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, t.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.cwj.setVisibility(8);
        this.cqC = (EditText) this.cwj.findViewById(t.g.search_bar_edit);
        this.cqC.addTextChangedListener(new com.baidu.tieba.write.write.b(this));
        this.cqC.setOnFocusChangeListener(new c(this));
        this.eLp = (TextView) findViewById(t.g.search_bar_delete_button);
        this.eLp.setOnClickListener(new d(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [474=4] */
    private void akJ() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(t.e.invite_friend_candidate_item_height) + getResources().getDimensionPixelSize(t.e.invite_friend_candidate_padding_bottom) + getResources().getDimensionPixelSize(t.e.invite_friend_candidate_padding_top);
        this.mListFooter = new View(getPageContext().getContext());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setFocusable(false);
        this.mListFooter.setFocusableInTouchMode(false);
        this.mListFooter.setContentDescription("");
        this.mListFooter.setVisibility(4);
        this.mListFooter.setBackgroundColor(0);
        this.mListFooter.setOnClickListener(new e(this));
        this.Je.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oY(String str) {
        if (!isFinishing()) {
            this.eLu.setData(null);
            if (this.eLr != null) {
                this.eLr.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.eLt.aZB() != null) {
                    ArrayList<MetaData> aZw = this.eLt.aZB().aZw();
                    Iterator<MetaData> it = aZw.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (aZw != null && !aZw.isEmpty()) {
                        qO(0);
                    } else {
                        qO(1);
                    }
                    this.eLu.setData(aZw);
                } else {
                    this.eLu.setData(null);
                    if (this.eLs == null) {
                        this.eLs = new b(this, null);
                        this.eLs.setPriority(3);
                        this.eLs.execute("");
                    }
                }
            } else {
                this.eLr = new a(this, null);
                this.eLr.setPriority(2);
                this.eLr.execute(str);
                if (this.eLs == null && this.eLt.aZB() == null) {
                    this.eLs = new b(this, null);
                    this.eLs.setPriority(3);
                    this.eLs.execute("");
                }
            }
            this.eLu.notifyDataSetInvalidated();
            this.Je.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.eLt = new com.baidu.tieba.write.b.a();
        if (bundle != null) {
            this.eLz = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.eLz = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MetaData metaData) {
        if (metaData != null) {
            this.eLq.c(metaData);
            ks(this.eLq.getItemLength());
            akK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MetaData metaData) {
        if (metaData != null) {
            this.eLq.e(metaData);
            ks(this.eLq.getItemLength());
            akK();
        }
    }

    private void akK() {
        if (this.eLq.getItemLength() > 0) {
            this.cwf.setEnabled(true);
        } else {
            this.cwf.setEnabled(false);
        }
    }

    private void ks(int i) {
        this.cwf.setText(String.format(getPageContext().getString(t.j.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.data.c> {
        private com.baidu.tbadk.core.util.ab aiW;
        private String eLD;

        private a() {
            this.aiW = null;
            this.eLD = null;
        }

        /* synthetic */ a(AtListActivity atListActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.aQj.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.eLr = null;
            this.eLD = null;
            AtListActivity.this.aQj.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: H */
        public com.baidu.tieba.write.data.c doInBackground(String... strArr) {
            this.eLD = strArr[0];
            this.aiW = new com.baidu.tbadk.core.util.ab();
            if (this.eLD != null && this.eLD.length() > 0) {
                this.aiW.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/sug");
                this.aiW.p("uid", TbadkCoreApplication.getCurrentAccount());
                this.aiW.p("q", this.eLD);
                String vw = this.aiW.vw();
                if (this.aiW.vU().wP().qC()) {
                    com.baidu.tieba.write.data.c cVar = new com.baidu.tieba.write.data.c();
                    com.baidu.tieba.write.data.a aZB = AtListActivity.this.eLt.aZB();
                    if (aZB != null) {
                        cVar.a(vw, aZB.aZx());
                        return cVar;
                    }
                    cVar.a(vw, (HashMap<String, String>) null);
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
            AtListActivity.this.eLr = null;
            AtListActivity.this.aQj.setVisibility(8);
            if (this.aiW.vU().wP().qC() && this.eLD != null && com.baidu.adp.lib.util.j.a(AtListActivity.this.cqC.getText(), "").equals(this.eLD)) {
                if (cVar == null || cVar.aZz().isEmpty()) {
                    AtListActivity.this.qO(1);
                } else {
                    AtListActivity.this.qO(0);
                }
                AtListActivity.this.eLt.a(cVar);
                AtListActivity.this.eLu.setData(cVar.aZz());
                AtListActivity.this.eLu.notifyDataSetInvalidated();
                AtListActivity.this.Je.setSelection(0);
            } else {
                AtListActivity.this.showToast(this.aiW.getErrorString());
            }
            super.onPostExecute(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, com.baidu.tieba.write.data.a> {
        private com.baidu.tbadk.core.util.ab aiW;

        private b() {
            this.aiW = null;
        }

        /* synthetic */ b(AtListActivity atListActivity, b bVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.aQj.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiW != null) {
                this.aiW.gX();
            }
            AtListActivity.this.eLs = null;
            AtListActivity.this.aQj.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public com.baidu.tieba.write.data.a doInBackground(String... strArr) {
            this.aiW = new com.baidu.tbadk.core.util.ab();
            this.aiW.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/list");
            String vw = this.aiW.vw();
            if (!this.aiW.vU().wP().qC()) {
                return null;
            }
            com.baidu.tieba.write.data.a aVar = new com.baidu.tieba.write.data.a();
            aVar.oP(vw);
            return aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.data.a aVar) {
            AtListActivity.this.eLs = null;
            AtListActivity.this.aQj.setVisibility(8);
            if (AtListActivity.this.cwe != null && AtListActivity.this.cwe.getVisibility() == 0) {
                AtListActivity.this.eLw.setVisibility(0);
            }
            if (this.aiW.vU().wP().qC()) {
                AtListActivity.this.eLt.a(aVar);
                if (AtListActivity.this.eLu != null) {
                    if (com.baidu.adp.lib.util.j.a(AtListActivity.this.cqC.getText(), "").length() != 0) {
                        if (AtListActivity.this.eLt.aZC() != null) {
                            if (aVar != null && aVar.aZx() != null && !aVar.aZx().isEmpty()) {
                                AtListActivity.this.qO(2);
                            }
                            AtListActivity.this.eLt.aZC().i(aVar.aZx());
                            AtListActivity.this.eLu.notifyDataSetInvalidated();
                        }
                    } else {
                        if (aVar == null || aVar.aZw() == null || !aVar.aZw().isEmpty()) {
                            AtListActivity.this.qO(0);
                        } else {
                            AtListActivity.this.qO(2);
                        }
                        AtListActivity.this.eLo = aVar.aZw();
                        AtListActivity.this.eLu.setData(AtListActivity.this.eLo);
                        AtListActivity.this.eLu.notifyDataSetInvalidated();
                        AtListActivity.this.Je.setSelection(0);
                    }
                } else {
                    return;
                }
            } else {
                AtListActivity.this.showToast(this.aiW.getErrorString());
            }
            super.onPostExecute(aVar);
        }
    }

    @Override // com.baidu.tieba.write.write.n.b
    public void a(View view, MetaData metaData) {
        if (metaData != null) {
            this.eLq.d(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.Je;
    }
}
