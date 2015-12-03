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
    private NoNetworkView aQl;
    private LinearLayout ccZ;
    private Button cda;
    private View cde;
    private View cdf;
    private AtSelectFriendList dPe;
    private TextView dPl;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.n mNoDataView;
    protected ArrayList<MetaData> dPc = new ArrayList<>();
    private EditText bXx = null;
    private TextView dPd = null;
    private BdListView mListView = null;
    private final Handler mHandler = new Handler();
    private a dPf = null;
    private b dPg = null;
    private com.baidu.tieba.write.b.a dPh = null;
    private m dPi = null;
    private String dPj = null;
    private ProgressBar mProgress = null;
    private RelativeLayout bGY = null;
    private View dPk = null;
    private final int dPm = 5;
    private boolean dPn = true;
    private final Runnable dPo = new com.baidu.tieba.write.write.a(this);
    private NoNetworkView.a dPp = new e(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.g.at_list_activity);
        initData(bundle);
        initUI();
        nt(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().af(i == 1);
        getLayoutMode().k(this.bGY);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aQl.onChangeSkinType(getPageContext(), i);
        this.dPi.notifyDataSetChanged();
        com.baidu.tbadk.core.util.as.getColor(n.c.widget_searchbox_text);
        com.baidu.tbadk.core.util.as.i(this.mListFooter, n.e.invite_friend_list_item_bg_color);
        com.baidu.tbadk.core.util.as.i((View) this.cda, n.e.post_button_bg);
        com.baidu.tbadk.core.util.as.b(this.cda, n.c.cp_cont_i, 3);
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
    public void nH(int i) {
        if (i == 2) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cS(n.i.no_chat_friends));
            this.ccZ.setVisibility(8);
        } else if (i == 1) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cS(n.i.no_search_friends));
            this.ccZ.setVisibility(8);
        } else if (i == 0) {
            this.mListView.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.dPn) {
                this.ccZ.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.dPi.getItem(i);
        if (item != null) {
            if (this.dPn) {
                if (this.dPf == null && this.dPg == null) {
                    if (item.isChecked()) {
                        b(item);
                    } else if (5 <= this.dPe.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(n.i.invite_friend_exceed_max_count), 5), n.e.icon_toast_game_error);
                        return;
                    } else {
                        a(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.dPi.notifyDataSetChanged();
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
            com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), this.bXx);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.dPf != null) {
            this.dPf.cancel();
        }
        if (this.dPg != null) {
            this.dPg.cancel();
        }
        this.mHandler.removeCallbacks(this.dPo);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.bGY = (RelativeLayout) findViewById(n.f.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.bGY, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cS(n.i.no_chat_friends), null);
        this.dPk = findViewById(n.f.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new f(this));
        Qh();
        this.aQl = (NoNetworkView) findViewById(n.f.view_no_network);
        this.aQl.a(this.dPp);
        this.mProgress = (ProgressBar) findViewById(n.f.progress);
        this.mListView = (BdListView) findViewById(n.f.list);
        this.dPi = new m(this, this.dPn);
        this.dPi.a(this);
        this.dPi.setCheckBoxStateChangedListener(new g(this));
        this.mListView.setAdapter((ListAdapter) this.dPi);
        this.mListView.setOnItemClickListener(this);
        this.mListView.setOnTouchListener(new h(this));
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.bXx.getParent() != null) {
            ((View) this.bXx.getParent()).setFocusable(true);
            ((View) this.bXx.getParent()).setFocusableInTouchMode(true);
        }
        this.ccZ = (LinearLayout) this.bGY.findViewById(n.f.invite_candidate);
        this.cda = (Button) this.bGY.findViewById(n.f.button_send);
        this.cda.setOnClickListener(new i(this));
        iP(0);
        this.dPe = (AtSelectFriendList) this.bGY.findViewById(n.f.candidate_list);
        this.dPe.setMaxCount(5);
        this.dPe.setItemOPerationHandler(new j(this));
        acW();
    }

    private void Qh() {
        this.mNavigationBar = (NavigationBar) findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new k(this));
        this.dPl = this.mNavigationBar.setTitleText(getPageContext().getString(n.i.select_friend));
        this.cdf = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.g.add_new_friend_text, new l(this));
        this.cde = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, n.g.navigationbar_search_edit, (View.OnClickListener) null);
        this.cde.setVisibility(8);
        this.bXx = (EditText) this.cde.findViewById(n.f.search_bar_edit);
        this.bXx.addTextChangedListener(new com.baidu.tieba.write.write.b(this));
        this.bXx.setOnFocusChangeListener(new c(this));
        this.dPd = (TextView) findViewById(n.f.search_bar_delete_button);
        this.dPd.setOnClickListener(new d(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [474=4] */
    private void acW() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(n.d.invite_friend_candidate_item_height) + getResources().getDimensionPixelSize(n.d.invite_friend_candidate_padding_bottom) + getResources().getDimensionPixelSize(n.d.invite_friend_candidate_padding_top);
        this.mListFooter = new View(getPageContext().getContext());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListView.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nt(String str) {
        if (!isFinishing()) {
            this.dPi.setData(null);
            if (this.dPf != null) {
                this.dPf.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.dPh.aHW() != null) {
                    ArrayList<MetaData> aHR = this.dPh.aHW().aHR();
                    Iterator<MetaData> it = aHR.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (aHR != null && !aHR.isEmpty()) {
                        nH(0);
                    } else {
                        nH(1);
                    }
                    this.dPi.setData(aHR);
                } else {
                    this.dPi.setData(null);
                    if (this.dPg == null) {
                        this.dPg = new b(this, null);
                        this.dPg.setPriority(3);
                        this.dPg.execute("");
                    }
                }
            } else {
                this.dPf = new a(this, null);
                this.dPf.setPriority(2);
                this.dPf.execute(str);
                if (this.dPg == null && this.dPh.aHW() == null) {
                    this.dPg = new b(this, null);
                    this.dPg.setPriority(3);
                    this.dPg.execute("");
                }
            }
            this.dPi.notifyDataSetInvalidated();
            this.mListView.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.dPh = new com.baidu.tieba.write.b.a();
        if (bundle != null) {
            this.dPn = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.dPn = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MetaData metaData) {
        if (metaData != null) {
            this.dPe.c(metaData);
            iP(this.dPe.getItemLength());
            acX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MetaData metaData) {
        if (metaData != null) {
            this.dPe.e(metaData);
            iP(this.dPe.getItemLength());
            acX();
        }
    }

    private void acX() {
        if (this.dPe.getItemLength() > 0) {
            this.cda.setEnabled(true);
        } else {
            this.cda.setEnabled(false);
        }
    }

    private void iP(int i) {
        this.cda.setText(String.format(getPageContext().getString(n.i.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.data.c> {
        private com.baidu.tbadk.core.util.ab agS;
        private String dPr;

        private a() {
            this.agS = null;
            this.dPr = null;
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
            AtListActivity.this.dPf = null;
            this.dPr = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public com.baidu.tieba.write.data.c doInBackground(String... strArr) {
            this.dPr = strArr[0];
            this.agS = new com.baidu.tbadk.core.util.ab();
            if (this.dPr != null && this.dPr.length() > 0) {
                this.agS.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/sug");
                this.agS.o("uid", TbadkCoreApplication.getCurrentAccount());
                this.agS.o("q", this.dPr);
                String ul = this.agS.ul();
                if (this.agS.uM().vG().rf()) {
                    com.baidu.tieba.write.data.c cVar = new com.baidu.tieba.write.data.c();
                    com.baidu.tieba.write.data.a aHW = AtListActivity.this.dPh.aHW();
                    if (aHW != null) {
                        cVar.a(ul, aHW.aHS());
                        return cVar;
                    }
                    cVar.a(ul, (HashMap<String, String>) null);
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
            AtListActivity.this.dPf = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.agS.uM().vG().rf() && this.dPr != null && com.baidu.adp.lib.util.j.a(AtListActivity.this.bXx.getText(), "").equals(this.dPr)) {
                if (cVar == null || cVar.aHU().isEmpty()) {
                    AtListActivity.this.nH(1);
                } else {
                    AtListActivity.this.nH(0);
                }
                AtListActivity.this.dPh.a(cVar);
                AtListActivity.this.dPi.setData(cVar.aHU());
                AtListActivity.this.dPi.notifyDataSetInvalidated();
                AtListActivity.this.mListView.setSelection(0);
            } else {
                AtListActivity.this.showToast(this.agS.getErrorString());
            }
            super.onPostExecute(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, com.baidu.tieba.write.data.a> {
        private com.baidu.tbadk.core.util.ab agS;

        private b() {
            this.agS = null;
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
            if (this.agS != null) {
                this.agS.gL();
            }
            AtListActivity.this.dPg = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public com.baidu.tieba.write.data.a doInBackground(String... strArr) {
            this.agS = new com.baidu.tbadk.core.util.ab();
            this.agS.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/list");
            String ul = this.agS.ul();
            if (!this.agS.uM().vG().rf()) {
                return null;
            }
            com.baidu.tieba.write.data.a aVar = new com.baidu.tieba.write.data.a();
            aVar.no(ul);
            return aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.data.a aVar) {
            AtListActivity.this.dPg = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.ccZ != null && AtListActivity.this.ccZ.getVisibility() == 0) {
                AtListActivity.this.dPk.setVisibility(0);
            }
            if (this.agS.uM().vG().rf()) {
                AtListActivity.this.dPh.a(aVar);
                if (AtListActivity.this.dPi != null) {
                    if (com.baidu.adp.lib.util.j.a(AtListActivity.this.bXx.getText(), "").length() != 0) {
                        if (AtListActivity.this.dPh.aHX() != null) {
                            if (aVar != null && aVar.aHS() != null && !aVar.aHS().isEmpty()) {
                                AtListActivity.this.nH(2);
                            }
                            AtListActivity.this.dPh.aHX().i(aVar.aHS());
                            AtListActivity.this.dPi.notifyDataSetInvalidated();
                        }
                    } else {
                        if (aVar == null || aVar.aHR() == null || !aVar.aHR().isEmpty()) {
                            AtListActivity.this.nH(0);
                        } else {
                            AtListActivity.this.nH(2);
                        }
                        AtListActivity.this.dPc = aVar.aHR();
                        AtListActivity.this.dPi.setData(AtListActivity.this.dPc);
                        AtListActivity.this.dPi.notifyDataSetInvalidated();
                        AtListActivity.this.mListView.setSelection(0);
                    }
                } else {
                    return;
                }
            } else {
                AtListActivity.this.showToast(this.agS.getErrorString());
            }
            super.onPostExecute(aVar);
        }
    }

    @Override // com.baidu.tieba.write.write.m.b
    public void a(View view, MetaData metaData) {
        if (metaData != null) {
            this.dPe.d(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.mListView;
    }
}
