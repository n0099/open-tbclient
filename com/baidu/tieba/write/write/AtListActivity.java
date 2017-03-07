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
    private NoNetworkView bEy;
    private LinearLayout dkB;
    private Button dkC;
    private View dkG;
    private View dkH;
    private ImageView dkJ;
    private AtSelectFriendList fOI;
    private TextView fOP;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.y mNoDataView;
    protected ArrayList<MetaData> fOG = new ArrayList<>();
    private EditText dgY = null;
    private TextView fOH = null;
    private BdListView IK = null;
    private final Handler mHandler = new Handler();
    private a fOJ = null;
    private b fOK = null;
    private com.baidu.tieba.write.c.a fOL = null;
    private n fOM = null;
    private String fON = null;
    private ProgressBar bqO = null;
    private RelativeLayout mParent = null;
    private View fOO = null;
    private final int fOQ = 5;
    private boolean fOR = true;
    private final Runnable fOS = new com.baidu.tieba.write.write.a(this);
    private NoNetworkView.a fAN = new f(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.j.at_list_activity);
        initData(bundle);
        initUI();
        qR(null);
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
        this.bEy.onChangeSkinType(getPageContext(), i);
        this.fOM.notifyDataSetChanged();
        com.baidu.tbadk.core.util.aq.getColor(w.e.common_color_10221);
        com.baidu.tbadk.core.util.aq.j(this.mListFooter, w.g.invite_friend_list_item_bg_color);
        com.baidu.tbadk.core.util.aq.j(this.dkC, w.g.post_button_bg);
        com.baidu.tbadk.core.util.aq.c(this.dkC, w.e.cp_cont_i, 3);
        com.baidu.tbadk.core.util.aq.b(this.dkJ, w.g.icon_search_bg_s, w.g.icon_search_bg);
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
    public void th(int i) {
        if (i == 2) {
            this.IK.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.de(w.l.no_chat_friends));
            this.dkB.setVisibility(8);
        } else if (i == 1) {
            this.IK.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.de(w.l.no_search_friends));
            this.dkB.setVisibility(8);
        } else if (i == 0) {
            this.IK.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.fOR) {
                this.dkB.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.fOM.getItem(i);
        if (item != null) {
            if (this.fOR) {
                if (this.fOJ == null && this.fOK == null) {
                    if (item.isChecked()) {
                        c(item);
                    } else if (5 <= this.fOI.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(w.l.invite_friend_exceed_max_count), 5), w.g.icon_toast_game_error);
                        return;
                    } else {
                        b(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.fOM.notifyDataSetChanged();
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
            com.baidu.adp.lib.util.k.b(getPageContext().getPageActivity(), this.dgY);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fOJ != null) {
            this.fOJ.cancel();
        }
        if (this.fOK != null) {
            this.fOK.cancel();
        }
        this.mHandler.removeCallbacks(this.fOS);
        if (this.bqO != null) {
            this.bqO.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(w.h.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.adp.lib.util.k.g(getActivity(), w.f.ds320)), NoDataViewFactory.d.de(w.l.no_chat_friends), null, true);
        this.fOO = findViewById(w.h.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new g(this));
        auN();
        this.bEy = (NoNetworkView) findViewById(w.h.view_no_network);
        this.bEy.a(this.fAN);
        this.bqO = (ProgressBar) findViewById(w.h.progress);
        this.IK = (BdListView) findViewById(w.h.list);
        this.fOM = new n(this, this.fOR);
        this.fOM.a(this);
        this.fOM.a(new h(this));
        this.IK.setAdapter((ListAdapter) this.fOM);
        this.IK.setOnItemClickListener(this);
        this.IK.setOnTouchListener(new i(this));
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.dgY.getParent() != null) {
            ((View) this.dgY.getParent()).setFocusable(true);
            ((View) this.dgY.getParent()).setFocusableInTouchMode(true);
        }
        this.dkB = (LinearLayout) this.mParent.findViewById(w.h.invite_candidate);
        this.dkC = (Button) this.mParent.findViewById(w.h.button_send);
        this.dkC.setOnClickListener(new j(this));
        md(0);
        this.fOI = (AtSelectFriendList) this.mParent.findViewById(w.h.candidate_list);
        this.fOI.setMaxCount(5);
        this.fOI.setItemOPerationHandler(new k(this));
        auX();
    }

    private void auN() {
        this.mNavigationBar = (NavigationBar) findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new l(this));
        this.fOP = this.mNavigationBar.setTitleText(getPageContext().getString(w.l.select_friend));
        this.dkH = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.add_new_friend_text, new m(this));
        this.dkJ = (ImageView) this.dkH.findViewById(w.h.new_friend_search);
        this.dkG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.navigationbar_search_edit, (View.OnClickListener) null);
        this.dkG.setVisibility(8);
        this.dgY = (EditText) this.dkG.findViewById(w.h.search_bar_edit);
        this.dgY.addTextChangedListener(new com.baidu.tieba.write.write.b(this));
        this.dgY.setOnFocusChangeListener(new c(this));
        this.fOH = (TextView) findViewById(w.h.search_bar_delete_button);
        this.fOH.setOnClickListener(new d(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [469=4] */
    private void auX() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds80) + getResources().getDimensionPixelSize(w.f.ds16) + getResources().getDimensionPixelSize(w.f.ds16);
        this.mListFooter = new View(getPageContext().getContext());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setFocusable(false);
        this.mListFooter.setFocusableInTouchMode(false);
        this.mListFooter.setContentDescription("");
        this.mListFooter.setVisibility(4);
        this.mListFooter.setBackgroundColor(0);
        this.mListFooter.setOnClickListener(new e(this));
        this.IK.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qR(String str) {
        if (!isFinishing()) {
            this.fOM.setData(null);
            if (this.fOJ != null) {
                this.fOJ.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.fOL.bnm() != null) {
                    ArrayList<MetaData> bni = this.fOL.bnm().bni();
                    Iterator<MetaData> it = bni.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (bni != null && !bni.isEmpty()) {
                        th(0);
                    } else {
                        th(1);
                    }
                    this.fOM.setData(bni);
                } else {
                    this.fOM.setData(null);
                    if (this.fOK == null) {
                        this.fOK = new b(this, null);
                        this.fOK.setPriority(3);
                        this.fOK.execute("");
                    }
                }
            } else {
                this.fOJ = new a(this, null);
                this.fOJ.setPriority(2);
                this.fOJ.execute(str);
                if (this.fOK == null && this.fOL.bnm() == null) {
                    this.fOK = new b(this, null);
                    this.fOK.setPriority(3);
                    this.fOK.execute("");
                }
            }
            this.fOM.notifyDataSetInvalidated();
            this.IK.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.fOL = new com.baidu.tieba.write.c.a();
        if (bundle != null) {
            this.fOR = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.fOR = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MetaData metaData) {
        if (metaData != null) {
            this.fOI.d(metaData);
            md(this.fOI.getItemLength());
            auY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(MetaData metaData) {
        if (metaData != null) {
            this.fOI.f(metaData);
            md(this.fOI.getItemLength());
            auY();
        }
    }

    private void auY() {
        if (this.fOI.getItemLength() > 0) {
            this.dkC.setEnabled(true);
        } else {
            this.dkC.setEnabled(false);
        }
    }

    private void md(int i) {
        this.dkC.setText(String.format(getPageContext().getString(w.l.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.b> {
        private String fOU;
        private com.baidu.tbadk.core.util.z mNetwork;

        private a() {
            this.mNetwork = null;
            this.fOU = null;
        }

        /* synthetic */ a(AtListActivity atListActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.bqO.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.fOJ = null;
            this.fOU = null;
            AtListActivity.this.bqO.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.fOU = strArr[0];
            this.mNetwork = new com.baidu.tbadk.core.util.z();
            if (this.fOU != null && this.fOU.length() > 0) {
                this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/sug");
                this.mNetwork.n(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.n("q", this.fOU);
                String uB = this.mNetwork.uB();
                if (this.mNetwork.uZ().vT().isRequestSuccess()) {
                    com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
                    com.baidu.tieba.write.a.a bnm = AtListActivity.this.fOL.bnm();
                    if (bnm != null) {
                        bVar.d(uB, bnm.bnj());
                        return bVar;
                    }
                    bVar.d(uB, null);
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
            AtListActivity.this.fOJ = null;
            AtListActivity.this.bqO.setVisibility(8);
            if (this.mNetwork.uZ().vT().isRequestSuccess() && this.fOU != null && com.baidu.adp.lib.util.j.a(AtListActivity.this.dgY.getText(), "").equals(this.fOU)) {
                if (bVar == null || bVar.bnk().isEmpty()) {
                    AtListActivity.this.th(1);
                } else {
                    AtListActivity.this.th(0);
                }
                AtListActivity.this.fOL.a(bVar);
                AtListActivity.this.fOM.setData(bVar.bnk());
                AtListActivity.this.fOM.notifyDataSetInvalidated();
                AtListActivity.this.IK.setSelection(0);
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
            AtListActivity.this.bqO.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fm();
            }
            AtListActivity.this.fOK = null;
            AtListActivity.this.bqO.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: H */
        public com.baidu.tieba.write.a.a doInBackground(String... strArr) {
            this.mNetwork = new com.baidu.tbadk.core.util.z();
            this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/list");
            String uB = this.mNetwork.uB();
            if (!this.mNetwork.uZ().vT().isRequestSuccess()) {
                return null;
            }
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.qI(uB);
            return aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.a aVar) {
            AtListActivity.this.fOK = null;
            AtListActivity.this.bqO.setVisibility(8);
            if (AtListActivity.this.dkB != null && AtListActivity.this.dkB.getVisibility() == 0) {
                AtListActivity.this.fOO.setVisibility(0);
            }
            if (this.mNetwork.uZ().vT().isRequestSuccess()) {
                AtListActivity.this.fOL.a(aVar);
                if (AtListActivity.this.fOM != null) {
                    if (com.baidu.adp.lib.util.j.a(AtListActivity.this.dgY.getText(), "").length() != 0) {
                        if (AtListActivity.this.fOL.bnn() != null) {
                            if (aVar != null && aVar.bnj() != null && !aVar.bnj().isEmpty()) {
                                AtListActivity.this.th(2);
                            }
                            AtListActivity.this.fOL.bnn().k(aVar.bnj());
                            AtListActivity.this.fOM.notifyDataSetInvalidated();
                        }
                    } else {
                        if (aVar == null || aVar.bni() == null || !aVar.bni().isEmpty()) {
                            AtListActivity.this.th(0);
                        } else {
                            AtListActivity.this.th(2);
                        }
                        AtListActivity.this.fOG = aVar.bni();
                        AtListActivity.this.fOM.setData(AtListActivity.this.fOG);
                        AtListActivity.this.fOM.notifyDataSetInvalidated();
                        AtListActivity.this.IK.setSelection(0);
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
            this.fOI.e(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.IK;
    }
}
