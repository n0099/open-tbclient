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
    private NoNetworkView bGF;
    private View dfA;
    private View dfB;
    private ImageView dfD;
    private LinearLayout dfv;
    private Button dfw;
    private AtSelectFriendList fQS;
    private TextView fQZ;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.y mNoDataView;
    protected ArrayList<MetaData> fQQ = new ArrayList<>();
    private EditText dbN = null;
    private TextView fQR = null;
    private BdListView Im = null;
    private final Handler mHandler = new Handler();
    private a fQT = null;
    private b fQU = null;
    private com.baidu.tieba.write.c.a fQV = null;
    private n fQW = null;
    private String fQX = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private View fQY = null;
    private final int fRa = 5;
    private boolean fRb = true;
    private final Runnable fRc = new com.baidu.tieba.write.write.a(this);
    private NoNetworkView.a fBn = new f(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.j.at_list_activity);
        initData(bundle);
        initUI();
        rh(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ai(i == 1);
        getLayoutMode().t(this.mParent);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bGF.onChangeSkinType(getPageContext(), i);
        this.fQW.notifyDataSetChanged();
        com.baidu.tbadk.core.util.aq.getColor(w.e.common_color_10221);
        com.baidu.tbadk.core.util.aq.j(this.mListFooter, w.g.invite_friend_list_item_bg_color);
        com.baidu.tbadk.core.util.aq.j(this.dfw, w.g.post_button_bg);
        com.baidu.tbadk.core.util.aq.c(this.dfw, w.e.cp_cont_i, 3);
        com.baidu.tbadk.core.util.aq.b(this.dfD, w.g.icon_search_bg_s, w.g.icon_search_bg);
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
            this.Im.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dd(w.l.no_chat_friends));
            this.dfv.setVisibility(8);
        } else if (i == 1) {
            this.Im.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dd(w.l.no_search_friends));
            this.dfv.setVisibility(8);
        } else if (i == 0) {
            this.Im.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.fRb) {
                this.dfv.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.fQW.getItem(i);
        if (item != null) {
            if (this.fRb) {
                if (this.fQT == null && this.fQU == null) {
                    if (item.isChecked()) {
                        c(item);
                    } else if (5 <= this.fQS.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(w.l.invite_friend_exceed_max_count), 5), w.g.icon_toast_game_error);
                        return;
                    } else {
                        b(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.fQW.notifyDataSetChanged();
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
            com.baidu.adp.lib.util.k.b(getPageContext().getPageActivity(), this.dbN);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fQT != null) {
            this.fQT.cancel();
        }
        if (this.fQU != null) {
            this.fQU.cancel();
        }
        this.mHandler.removeCallbacks(this.fRc);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(w.h.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.adp.lib.util.k.g(getActivity(), w.f.ds320)), NoDataViewFactory.d.dd(w.l.no_chat_friends), null, true);
        this.fQY = findViewById(w.h.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new g(this));
        asC();
        this.bGF = (NoNetworkView) findViewById(w.h.view_no_network);
        this.bGF.a(this.fBn);
        this.mProgress = (ProgressBar) findViewById(w.h.progress);
        this.Im = (BdListView) findViewById(w.h.list);
        this.fQW = new n(this, this.fRb);
        this.fQW.a(this);
        this.fQW.a(new h(this));
        this.Im.setAdapter((ListAdapter) this.fQW);
        this.Im.setOnItemClickListener(this);
        this.Im.setOnTouchListener(new i(this));
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.dbN.getParent() != null) {
            ((View) this.dbN.getParent()).setFocusable(true);
            ((View) this.dbN.getParent()).setFocusableInTouchMode(true);
        }
        this.dfv = (LinearLayout) this.mParent.findViewById(w.h.invite_candidate);
        this.dfw = (Button) this.mParent.findViewById(w.h.button_send);
        this.dfw.setOnClickListener(new j(this));
        lX(0);
        this.fQS = (AtSelectFriendList) this.mParent.findViewById(w.h.candidate_list);
        this.fQS.setMaxCount(5);
        this.fQS.setItemOPerationHandler(new k(this));
        asM();
    }

    private void asC() {
        this.mNavigationBar = (NavigationBar) findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new l(this));
        this.fQZ = this.mNavigationBar.setTitleText(getPageContext().getString(w.l.select_friend));
        this.dfB = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.add_new_friend_text, new m(this));
        this.dfD = (ImageView) this.dfB.findViewById(w.h.new_friend_search);
        this.dfA = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.navigationbar_search_edit, (View.OnClickListener) null);
        this.dfA.setVisibility(8);
        this.dbN = (EditText) this.dfA.findViewById(w.h.search_bar_edit);
        this.dbN.addTextChangedListener(new com.baidu.tieba.write.write.b(this));
        this.dbN.setOnFocusChangeListener(new c(this));
        this.fQR = (TextView) findViewById(w.h.search_bar_delete_button);
        this.fQR.setOnClickListener(new d(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [469=4] */
    private void asM() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds80) + getResources().getDimensionPixelSize(w.f.ds16) + getResources().getDimensionPixelSize(w.f.ds16);
        this.mListFooter = new View(getPageContext().getContext());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setFocusable(false);
        this.mListFooter.setFocusableInTouchMode(false);
        this.mListFooter.setContentDescription("");
        this.mListFooter.setVisibility(4);
        this.mListFooter.setBackgroundColor(0);
        this.mListFooter.setOnClickListener(new e(this));
        this.Im.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rh(String str) {
        if (!isFinishing()) {
            this.fQW.setData(null);
            if (this.fQT != null) {
                this.fQT.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.fQV.bmR() != null) {
                    ArrayList<MetaData> bmO = this.fQV.bmR().bmO();
                    Iterator<MetaData> it = bmO.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (bmO != null && !bmO.isEmpty()) {
                        ti(0);
                    } else {
                        ti(1);
                    }
                    this.fQW.setData(bmO);
                } else {
                    this.fQW.setData(null);
                    if (this.fQU == null) {
                        this.fQU = new b(this, null);
                        this.fQU.setPriority(3);
                        this.fQU.execute("");
                    }
                }
            } else {
                this.fQT = new a(this, null);
                this.fQT.setPriority(2);
                this.fQT.execute(str);
                if (this.fQU == null && this.fQV.bmR() == null) {
                    this.fQU = new b(this, null);
                    this.fQU.setPriority(3);
                    this.fQU.execute("");
                }
            }
            this.fQW.notifyDataSetInvalidated();
            this.Im.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.fQV = new com.baidu.tieba.write.c.a();
        if (bundle != null) {
            this.fRb = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.fRb = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MetaData metaData) {
        if (metaData != null) {
            this.fQS.d(metaData);
            lX(this.fQS.getItemLength());
            asN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(MetaData metaData) {
        if (metaData != null) {
            this.fQS.f(metaData);
            lX(this.fQS.getItemLength());
            asN();
        }
    }

    private void asN() {
        if (this.fQS.getItemLength() > 0) {
            this.dfw.setEnabled(true);
        } else {
            this.dfw.setEnabled(false);
        }
    }

    private void lX(int i) {
        this.dfw.setText(String.format(getPageContext().getString(w.l.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.b> {
        private String fRe;
        private com.baidu.tbadk.core.util.z mNetwork;

        private a() {
            this.mNetwork = null;
            this.fRe = null;
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
            AtListActivity.this.fQT = null;
            this.fRe = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.fRe = strArr[0];
            this.mNetwork = new com.baidu.tbadk.core.util.z();
            if (this.fRe != null && this.fRe.length() > 0) {
                this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/sug");
                this.mNetwork.n(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.n("q", this.fRe);
                String ul = this.mNetwork.ul();
                if (this.mNetwork.uJ().vE().isRequestSuccess()) {
                    com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
                    com.baidu.tieba.write.a.a bmR = AtListActivity.this.fQV.bmR();
                    if (bmR != null) {
                        bVar.e(ul, bmR.bmP());
                        return bVar;
                    }
                    bVar.e(ul, null);
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
            AtListActivity.this.fQT = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork.uJ().vE().isRequestSuccess() && this.fRe != null && com.baidu.adp.lib.util.j.a(AtListActivity.this.dbN.getText(), "").equals(this.fRe)) {
                if (bVar == null || bVar.bmQ().isEmpty()) {
                    AtListActivity.this.ti(1);
                } else {
                    AtListActivity.this.ti(0);
                }
                AtListActivity.this.fQV.a(bVar);
                AtListActivity.this.fQW.setData(bVar.bmQ());
                AtListActivity.this.fQW.notifyDataSetInvalidated();
                AtListActivity.this.Im.setSelection(0);
            } else {
                AtListActivity.this.showToast(this.mNetwork.getErrorString());
            }
            super.onPostExecute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.a> {
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
            AtListActivity.this.fQU = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public com.baidu.tieba.write.a.a doInBackground(String... strArr) {
            this.mNetwork = new com.baidu.tbadk.core.util.z();
            this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/list");
            String ul = this.mNetwork.ul();
            if (!this.mNetwork.uJ().vE().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.qX(ul);
            return aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.a aVar) {
            AtListActivity.this.fQU = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.dfv != null && AtListActivity.this.dfv.getVisibility() == 0) {
                AtListActivity.this.fQY.setVisibility(0);
            }
            if (this.mNetwork.uJ().vE().isRequestSuccess()) {
                AtListActivity.this.fQV.a(aVar);
                if (AtListActivity.this.fQW != null) {
                    if (com.baidu.adp.lib.util.j.a(AtListActivity.this.dbN.getText(), "").length() != 0) {
                        if (AtListActivity.this.fQV.bmS() != null) {
                            if (aVar != null && aVar.bmP() != null && !aVar.bmP().isEmpty()) {
                                AtListActivity.this.ti(2);
                            }
                            AtListActivity.this.fQV.bmS().k(aVar.bmP());
                            AtListActivity.this.fQW.notifyDataSetInvalidated();
                        }
                    } else {
                        if (aVar == null || aVar.bmO() == null || !aVar.bmO().isEmpty()) {
                            AtListActivity.this.ti(0);
                        } else {
                            AtListActivity.this.ti(2);
                        }
                        AtListActivity.this.fQQ = aVar.bmO();
                        AtListActivity.this.fQW.setData(AtListActivity.this.fQQ);
                        AtListActivity.this.fQW.notifyDataSetInvalidated();
                        AtListActivity.this.Im.setSelection(0);
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
            this.fQS.e(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.Im;
    }
}
