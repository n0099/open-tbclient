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
import java.util.Iterator;
/* loaded from: classes.dex */
public class AtListActivity extends BaseActivity<AtListActivity> implements AdapterView.OnItemClickListener, n.b {
    private NoNetworkView aWZ;
    private LinearLayout cxb;
    private Button cxc;
    private View cxg;
    private View cxh;
    private AtSelectFriendList fce;
    private TextView fcl;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.q mNoDataView;
    protected ArrayList<MetaData> fcc = new ArrayList<>();
    private EditText crz = null;
    private TextView fcd = null;
    private BdListView zu = null;
    private final Handler mHandler = new Handler();
    private a fcf = null;
    private b fcg = null;
    private com.baidu.tieba.write.b.a fch = null;
    private n fci = null;
    private String fcj = null;
    private ProgressBar bDI = null;
    private RelativeLayout bZp = null;
    private View fck = null;
    private final int fcm = 5;
    private boolean fcn = true;
    private final Runnable fco = new com.baidu.tieba.write.write.a(this);
    private NoNetworkView.a fcp = new f(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.at_list_activity);
        initData(bundle);
        nq();
        pm(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ae(i == 1);
        getLayoutMode().x(this.bZp);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aWZ.onChangeSkinType(getPageContext(), i);
        this.fci.notifyDataSetChanged();
        com.baidu.tbadk.core.util.at.getColor(t.d.widget_searchbox_text);
        com.baidu.tbadk.core.util.at.k(this.mListFooter, t.f.invite_friend_list_item_bg_color);
        com.baidu.tbadk.core.util.at.k(this.cxc, t.f.post_button_bg);
        com.baidu.tbadk.core.util.at.c(this.cxc, t.d.cp_cont_i, 3);
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
    public void rj(int i) {
        if (i == 2) {
            this.zu.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cP(t.j.no_chat_friends));
            this.cxb.setVisibility(8);
        } else if (i == 1) {
            this.zu.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cP(t.j.no_search_friends));
            this.cxb.setVisibility(8);
        } else if (i == 0) {
            this.zu.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.fcn) {
                this.cxb.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.fci.getItem(i);
        if (item != null) {
            if (this.fcn) {
                if (this.fcf == null && this.fcg == null) {
                    if (item.isChecked()) {
                        b(item);
                    } else if (5 <= this.fce.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(t.j.invite_friend_exceed_max_count), 5), t.f.icon_toast_game_error);
                        return;
                    } else {
                        a(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.fci.notifyDataSetChanged();
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
            com.baidu.adp.lib.util.k.a(getPageContext().getPageActivity(), this.crz);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fcf != null) {
            this.fcf.cancel();
        }
        if (this.fcg != null) {
            this.fcg.cancel();
        }
        this.mHandler.removeCallbacks(this.fco);
        if (this.bDI != null) {
            this.bDI.setVisibility(8);
        }
        super.onDestroy();
    }

    private void nq() {
        this.bZp = (RelativeLayout) findViewById(t.g.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.bZp, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cP(t.j.no_chat_friends), null);
        this.fck = findViewById(t.g.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new g(this));
        Uv();
        this.aWZ = (NoNetworkView) findViewById(t.g.view_no_network);
        this.aWZ.a(this.fcp);
        this.bDI = (ProgressBar) findViewById(t.g.progress);
        this.zu = (BdListView) findViewById(t.g.list);
        this.fci = new n(this, this.fcn);
        this.fci.a(this);
        this.fci.a(new h(this));
        this.zu.setAdapter((ListAdapter) this.fci);
        this.zu.setOnItemClickListener(this);
        this.zu.setOnTouchListener(new i(this));
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.crz.getParent() != null) {
            ((View) this.crz.getParent()).setFocusable(true);
            ((View) this.crz.getParent()).setFocusableInTouchMode(true);
        }
        this.cxb = (LinearLayout) this.bZp.findViewById(t.g.invite_candidate);
        this.cxc = (Button) this.bZp.findViewById(t.g.button_send);
        this.cxc.setOnClickListener(new j(this));
        jX(0);
        this.fce = (AtSelectFriendList) this.bZp.findViewById(t.g.candidate_list);
        this.fce.setMaxCount(5);
        this.fce.setItemOPerationHandler(new k(this));
        akP();
    }

    private void Uv() {
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new l(this));
        this.fcl = this.mNavigationBar.setTitleText(getPageContext().getString(t.j.select_friend));
        this.cxh = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.add_new_friend_text, new m(this));
        this.cxg = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, t.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.cxg.setVisibility(8);
        this.crz = (EditText) this.cxg.findViewById(t.g.search_bar_edit);
        this.crz.addTextChangedListener(new com.baidu.tieba.write.write.b(this));
        this.crz.setOnFocusChangeListener(new c(this));
        this.fcd = (TextView) findViewById(t.g.search_bar_delete_button);
        this.fcd.setOnClickListener(new d(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [474=4] */
    private void akP() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(t.e.invite_friend_candidate_item_height) + getResources().getDimensionPixelSize(t.e.invite_friend_candidate_padding_bottom) + getResources().getDimensionPixelSize(t.e.invite_friend_candidate_padding_top);
        this.mListFooter = new View(getPageContext().getContext());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setFocusable(false);
        this.mListFooter.setFocusableInTouchMode(false);
        this.mListFooter.setContentDescription("");
        this.mListFooter.setVisibility(4);
        this.mListFooter.setBackgroundColor(0);
        this.mListFooter.setOnClickListener(new e(this));
        this.zu.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pm(String str) {
        if (!isFinishing()) {
            this.fci.setData(null);
            if (this.fcf != null) {
                this.fcf.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.fch.bbP() != null) {
                    ArrayList<MetaData> bbL = this.fch.bbP().bbL();
                    Iterator<MetaData> it = bbL.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (bbL != null && !bbL.isEmpty()) {
                        rj(0);
                    } else {
                        rj(1);
                    }
                    this.fci.setData(bbL);
                } else {
                    this.fci.setData(null);
                    if (this.fcg == null) {
                        this.fcg = new b(this, null);
                        this.fcg.setPriority(3);
                        this.fcg.execute("");
                    }
                }
            } else {
                this.fcf = new a(this, null);
                this.fcf.setPriority(2);
                this.fcf.execute(str);
                if (this.fcg == null && this.fch.bbP() == null) {
                    this.fcg = new b(this, null);
                    this.fcg.setPriority(3);
                    this.fcg.execute("");
                }
            }
            this.fci.notifyDataSetInvalidated();
            this.zu.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.fch = new com.baidu.tieba.write.b.a();
        if (bundle != null) {
            this.fcn = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.fcn = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MetaData metaData) {
        if (metaData != null) {
            this.fce.c(metaData);
            jX(this.fce.getItemLength());
            akQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MetaData metaData) {
        if (metaData != null) {
            this.fce.e(metaData);
            jX(this.fce.getItemLength());
            akQ();
        }
    }

    private void akQ() {
        if (this.fce.getItemLength() > 0) {
            this.cxc.setEnabled(true);
        } else {
            this.cxc.setEnabled(false);
        }
    }

    private void jX(int i) {
        this.cxc.setText(String.format(getPageContext().getString(t.j.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.data.c> {
        private com.baidu.tbadk.core.util.ab aeI;
        private String fcr;

        private a() {
            this.aeI = null;
            this.fcr = null;
        }

        /* synthetic */ a(AtListActivity atListActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.bDI.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.fcf = null;
            this.fcr = null;
            AtListActivity.this.bDI.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: L */
        public com.baidu.tieba.write.data.c doInBackground(String... strArr) {
            this.fcr = strArr[0];
            this.aeI = new com.baidu.tbadk.core.util.ab();
            if (this.fcr != null && this.fcr.length() > 0) {
                this.aeI.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/sug");
                this.aeI.n("uid", TbadkCoreApplication.getCurrentAccount());
                this.aeI.n("q", this.fcr);
                String tc = this.aeI.tc();
                if (this.aeI.tA().uv().nZ()) {
                    com.baidu.tieba.write.data.c cVar = new com.baidu.tieba.write.data.c();
                    com.baidu.tieba.write.data.a bbP = AtListActivity.this.fch.bbP();
                    if (bbP != null) {
                        cVar.b(tc, bbP.bbM());
                        return cVar;
                    }
                    cVar.b(tc, null);
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
            AtListActivity.this.fcf = null;
            AtListActivity.this.bDI.setVisibility(8);
            if (this.aeI.tA().uv().nZ() && this.fcr != null && com.baidu.adp.lib.util.j.a(AtListActivity.this.crz.getText(), "").equals(this.fcr)) {
                if (cVar == null || cVar.bbN().isEmpty()) {
                    AtListActivity.this.rj(1);
                } else {
                    AtListActivity.this.rj(0);
                }
                AtListActivity.this.fch.a(cVar);
                AtListActivity.this.fci.setData(cVar.bbN());
                AtListActivity.this.fci.notifyDataSetInvalidated();
                AtListActivity.this.zu.setSelection(0);
            } else {
                AtListActivity.this.showToast(this.aeI.getErrorString());
            }
            super.onPostExecute(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, com.baidu.tieba.write.data.a> {
        private com.baidu.tbadk.core.util.ab aeI;

        private b() {
            this.aeI = null;
        }

        /* synthetic */ b(AtListActivity atListActivity, b bVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.bDI.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aeI != null) {
                this.aeI.dl();
            }
            AtListActivity.this.fcg = null;
            AtListActivity.this.bDI.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: M */
        public com.baidu.tieba.write.data.a doInBackground(String... strArr) {
            this.aeI = new com.baidu.tbadk.core.util.ab();
            this.aeI.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/list");
            String tc = this.aeI.tc();
            if (!this.aeI.tA().uv().nZ()) {
                return null;
            }
            com.baidu.tieba.write.data.a aVar = new com.baidu.tieba.write.data.a();
            aVar.pe(tc);
            return aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.data.a aVar) {
            AtListActivity.this.fcg = null;
            AtListActivity.this.bDI.setVisibility(8);
            if (AtListActivity.this.cxb != null && AtListActivity.this.cxb.getVisibility() == 0) {
                AtListActivity.this.fck.setVisibility(0);
            }
            if (this.aeI.tA().uv().nZ()) {
                AtListActivity.this.fch.a(aVar);
                if (AtListActivity.this.fci != null) {
                    if (com.baidu.adp.lib.util.j.a(AtListActivity.this.crz.getText(), "").length() != 0) {
                        if (AtListActivity.this.fch.bbQ() != null) {
                            if (aVar != null && aVar.bbM() != null && !aVar.bbM().isEmpty()) {
                                AtListActivity.this.rj(2);
                            }
                            AtListActivity.this.fch.bbQ().j(aVar.bbM());
                            AtListActivity.this.fci.notifyDataSetInvalidated();
                        }
                    } else {
                        if (aVar == null || aVar.bbL() == null || !aVar.bbL().isEmpty()) {
                            AtListActivity.this.rj(0);
                        } else {
                            AtListActivity.this.rj(2);
                        }
                        AtListActivity.this.fcc = aVar.bbL();
                        AtListActivity.this.fci.setData(AtListActivity.this.fcc);
                        AtListActivity.this.fci.notifyDataSetInvalidated();
                        AtListActivity.this.zu.setSelection(0);
                    }
                } else {
                    return;
                }
            } else {
                AtListActivity.this.showToast(this.aeI.getErrorString());
            }
            super.onPostExecute(aVar);
        }
    }

    @Override // com.baidu.tieba.write.write.n.b
    public void a(View view, MetaData metaData) {
        if (metaData != null) {
            this.fce.d(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.zu;
    }
}
