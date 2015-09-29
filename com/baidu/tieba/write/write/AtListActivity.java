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
    private NoNetworkView aMF;
    private LinearLayout bNp;
    private Button bNq;
    private View bNr;
    private View bNv;
    private View bNw;
    private AtSelectFriendList dnM;
    private TextView dnT;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.m mNoDataView;
    protected ArrayList<MetaData> dnK = new ArrayList<>();
    private EditText bHL = null;
    private TextView dnL = null;
    private BdListView mListView = null;
    private final Handler mHandler = new Handler();
    private a dnN = null;
    private b dnO = null;
    private com.baidu.tieba.write.b.a dnP = null;
    private m dnQ = null;
    private String dnR = null;
    private ProgressBar mProgress = null;
    private RelativeLayout brd = null;
    private View dnS = null;
    private final int dnU = 5;
    private boolean dnV = true;
    private final Runnable dnW = new com.baidu.tieba.write.write.a(this);
    private NoNetworkView.a dnX = new e(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.at_list_activity);
        initData(bundle);
        initUI();
        mr(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.brd);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aMF.onChangeSkinType(getPageContext(), i);
        this.dnQ.notifyDataSetChanged();
        com.baidu.tbadk.core.util.am.getColor(i.c.widget_searchbox_text);
        com.baidu.tbadk.core.util.am.i(this.bNr, i.e.invite_friend_list_item_bg_color);
        com.baidu.tbadk.core.util.am.i((View) this.bNq, i.e.post_button_bg);
        com.baidu.tbadk.core.util.am.b(this.bNq, i.c.cp_cont_i, 3);
        this.bNr.setEnabled(false);
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
    public void mf(int i) {
        if (i == 2) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.no_chat_friends));
            this.bNp.setVisibility(8);
        } else if (i == 1) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.no_search_friends));
            this.bNp.setVisibility(8);
        } else if (i == 0) {
            this.mListView.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.dnV) {
                this.bNp.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.dnQ.getItem(i);
        if (item != null) {
            if (this.dnV) {
                if (this.dnN == null && this.dnO == null) {
                    if (item.isChecked()) {
                        b(item);
                    } else if (5 <= this.dnM.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(i.h.invite_friend_exceed_max_count), 5), i.e.icon_toast_game_error);
                        return;
                    } else {
                        a(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.dnQ.notifyDataSetChanged();
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
            com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), this.bHL);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.dnN != null) {
            this.dnN.cancel();
        }
        if (this.dnO != null) {
            this.dnO.cancel();
        }
        this.mHandler.removeCallbacks(this.dnW);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.brd = (RelativeLayout) findViewById(i.f.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.brd, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cK(i.h.no_chat_friends), null);
        this.dnS = findViewById(i.f.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new f(this));
        Ok();
        this.aMF = (NoNetworkView) findViewById(i.f.view_no_network);
        this.aMF.a(this.dnX);
        this.mProgress = (ProgressBar) findViewById(i.f.progress);
        this.mListView = (BdListView) findViewById(i.f.list);
        this.dnQ = new m(this, this.dnV);
        this.dnQ.a(this);
        this.dnQ.setCheckBoxStateChangedListener(new g(this));
        this.mListView.setAdapter((ListAdapter) this.dnQ);
        this.mListView.setOnItemClickListener(this);
        this.mListView.setOnTouchListener(new h(this));
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.bHL.getParent() != null) {
            ((View) this.bHL.getParent()).setFocusable(true);
            ((View) this.bHL.getParent()).setFocusableInTouchMode(true);
        }
        this.bNp = (LinearLayout) this.brd.findViewById(i.f.invite_candidate);
        this.bNq = (Button) this.brd.findViewById(i.f.button_send);
        this.bNq.setOnClickListener(new i(this));
        hO(0);
        this.dnM = (AtSelectFriendList) this.brd.findViewById(i.f.candidate_list);
        this.dnM.setMaxCount(5);
        this.dnM.setItemOPerationHandler(new j(this));
        Zz();
    }

    private void Ok() {
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new k(this));
        this.dnT = this.mNavigationBar.setTitleText(getPageContext().getString(i.h.select_friend));
        this.bNw = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.add_new_friend_text, new l(this));
        this.bNv = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, i.g.navigationbar_search_edit, (View.OnClickListener) null);
        this.bNv.setVisibility(8);
        this.bHL = (EditText) this.bNv.findViewById(i.f.search_bar_edit);
        this.bHL.addTextChangedListener(new com.baidu.tieba.write.write.b(this));
        this.bHL.setOnFocusChangeListener(new c(this));
        this.dnL = (TextView) findViewById(i.f.search_bar_delete_button);
        this.dnL.setOnClickListener(new d(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [474=4] */
    private void Zz() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_height) + getResources().getDimensionPixelSize(i.d.invite_friend_candidate_padding_bottom) + getResources().getDimensionPixelSize(i.d.invite_friend_candidate_padding_top);
        this.bNr = new View(getPageContext().getContext());
        this.bNr.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListView.addFooterView(this.bNr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mr(String str) {
        if (!isFinishing()) {
            this.dnQ.setData(null);
            if (this.dnN != null) {
                this.dnN.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.dnP.aBD() != null) {
                    ArrayList<MetaData> aBy = this.dnP.aBD().aBy();
                    Iterator<MetaData> it = aBy.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (aBy != null && !aBy.isEmpty()) {
                        mf(0);
                    } else {
                        mf(1);
                    }
                    this.dnQ.setData(aBy);
                } else {
                    this.dnQ.setData(null);
                    if (this.dnO == null) {
                        this.dnO = new b(this, null);
                        this.dnO.setPriority(3);
                        this.dnO.execute("");
                    }
                }
            } else {
                this.dnN = new a(this, null);
                this.dnN.setPriority(2);
                this.dnN.execute(str);
                if (this.dnO == null && this.dnP.aBD() == null) {
                    this.dnO = new b(this, null);
                    this.dnO.setPriority(3);
                    this.dnO.execute("");
                }
            }
            this.dnQ.notifyDataSetInvalidated();
            this.mListView.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.dnP = new com.baidu.tieba.write.b.a();
        if (bundle != null) {
            this.dnV = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.dnV = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MetaData metaData) {
        if (metaData != null) {
            this.dnM.c(metaData);
            hO(this.dnM.getItemLength());
            ZA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MetaData metaData) {
        if (metaData != null) {
            this.dnM.e(metaData);
            hO(this.dnM.getItemLength());
            ZA();
        }
    }

    private void ZA() {
        if (this.dnM.getItemLength() > 0) {
            this.bNq.setEnabled(true);
        } else {
            this.bNq.setEnabled(false);
        }
    }

    private void hO(int i) {
        this.bNq.setText(String.format(getPageContext().getString(i.h.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.data.c> {
        private com.baidu.tbadk.core.util.w afg;
        private String dnZ;

        private a() {
            this.afg = null;
            this.dnZ = null;
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
            AtListActivity.this.dnN = null;
            this.dnZ = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public com.baidu.tieba.write.data.c doInBackground(String... strArr) {
            this.dnZ = strArr[0];
            this.afg = new com.baidu.tbadk.core.util.w();
            if (this.dnZ != null && this.dnZ.length() > 0) {
                this.afg.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/sug");
                this.afg.o("uid", TbadkCoreApplication.getCurrentAccount());
                this.afg.o("q", this.dnZ);
                String tG = this.afg.tG();
                if (this.afg.uh().uY().qV()) {
                    com.baidu.tieba.write.data.c cVar = new com.baidu.tieba.write.data.c();
                    com.baidu.tieba.write.data.a aBD = AtListActivity.this.dnP.aBD();
                    if (aBD != null) {
                        cVar.a(tG, aBD.aBz());
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
            AtListActivity.this.dnN = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.afg.uh().uY().qV() && this.dnZ != null && com.baidu.adp.lib.util.j.a(AtListActivity.this.bHL.getText(), "").equals(this.dnZ)) {
                if (cVar == null || cVar.aBB().isEmpty()) {
                    AtListActivity.this.mf(1);
                } else {
                    AtListActivity.this.mf(0);
                }
                AtListActivity.this.dnP.a(cVar);
                AtListActivity.this.dnQ.setData(cVar.aBB());
                AtListActivity.this.dnQ.notifyDataSetInvalidated();
                AtListActivity.this.mListView.setSelection(0);
            } else {
                AtListActivity.this.showToast(this.afg.getErrorString());
            }
            super.onPostExecute(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, com.baidu.tieba.write.data.a> {
        private com.baidu.tbadk.core.util.w afg;

        private b() {
            this.afg = null;
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
            if (this.afg != null) {
                this.afg.gJ();
            }
            AtListActivity.this.dnO = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public com.baidu.tieba.write.data.a doInBackground(String... strArr) {
            this.afg = new com.baidu.tbadk.core.util.w();
            this.afg.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/list");
            String tG = this.afg.tG();
            if (!this.afg.uh().uY().qV()) {
                return null;
            }
            com.baidu.tieba.write.data.a aVar = new com.baidu.tieba.write.data.a();
            aVar.mm(tG);
            return aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.data.a aVar) {
            AtListActivity.this.dnO = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.bNp != null && AtListActivity.this.bNp.getVisibility() == 0) {
                AtListActivity.this.dnS.setVisibility(0);
            }
            if (this.afg.uh().uY().qV()) {
                AtListActivity.this.dnP.a(aVar);
                if (AtListActivity.this.dnQ != null) {
                    if (com.baidu.adp.lib.util.j.a(AtListActivity.this.bHL.getText(), "").length() != 0) {
                        if (AtListActivity.this.dnP.aBE() != null) {
                            if (aVar != null && aVar.aBz() != null && !aVar.aBz().isEmpty()) {
                                AtListActivity.this.mf(2);
                            }
                            AtListActivity.this.dnP.aBE().i(aVar.aBz());
                            AtListActivity.this.dnQ.notifyDataSetInvalidated();
                        }
                    } else {
                        if (aVar == null || aVar.aBy() == null || !aVar.aBy().isEmpty()) {
                            AtListActivity.this.mf(0);
                        } else {
                            AtListActivity.this.mf(2);
                        }
                        AtListActivity.this.dnK = aVar.aBy();
                        AtListActivity.this.dnQ.setData(AtListActivity.this.dnK);
                        AtListActivity.this.dnQ.notifyDataSetInvalidated();
                        AtListActivity.this.mListView.setSelection(0);
                    }
                } else {
                    return;
                }
            } else {
                AtListActivity.this.showToast(this.afg.getErrorString());
            }
            super.onPostExecute(aVar);
        }
    }

    @Override // com.baidu.tieba.write.write.m.b
    public void a(View view, MetaData metaData) {
        if (metaData != null) {
            this.dnM.d(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.mListView;
    }
}
