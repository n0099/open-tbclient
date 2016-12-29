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
    private NoNetworkView bpG;
    private LinearLayout daW;
    private Button daX;
    private View dbb;
    private View dbc;
    private ImageView dbe;
    private AtSelectFriendList fBU;
    private TextView fCb;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.w mNoDataView;
    protected ArrayList<MetaData> fBS = new ArrayList<>();
    private EditText cXt = null;
    private TextView fBT = null;
    private BdListView Ck = null;
    private final Handler mHandler = new Handler();
    private a fBV = null;
    private b fBW = null;
    private com.baidu.tieba.write.c.a fBX = null;
    private n fBY = null;
    private String fBZ = null;
    private ProgressBar ban = null;
    private RelativeLayout cFi = null;
    private View fCa = null;
    private final int fCc = 5;
    private boolean fCd = true;
    private final Runnable fCe = new com.baidu.tieba.write.write.a(this);
    private NoNetworkView.a fnf = new f(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(r.h.at_list_activity);
        initData(bundle);
        initUI();
        rq(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ai(i == 1);
        getLayoutMode().x(this.cFi);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bpG.onChangeSkinType(getPageContext(), i);
        this.fBY.notifyDataSetChanged();
        com.baidu.tbadk.core.util.ar.getColor(r.d.common_color_10221);
        com.baidu.tbadk.core.util.ar.k(this.mListFooter, r.f.invite_friend_list_item_bg_color);
        com.baidu.tbadk.core.util.ar.k(this.daX, r.f.post_button_bg);
        com.baidu.tbadk.core.util.ar.c(this.daX, r.d.cp_cont_i, 3);
        com.baidu.tbadk.core.util.ar.b(this.dbe, r.f.icon_search_bg_s, r.f.icon_search_bg);
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
    public void sx(int i) {
        if (i == 2) {
            this.Ck.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dh(r.j.no_chat_friends));
            this.daW.setVisibility(8);
        } else if (i == 1) {
            this.Ck.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.dh(r.j.no_search_friends));
            this.daW.setVisibility(8);
        } else if (i == 0) {
            this.Ck.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.fCd) {
                this.daW.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.fBY.getItem(i);
        if (item != null) {
            if (this.fCd) {
                if (this.fBV == null && this.fBW == null) {
                    if (item.isChecked()) {
                        c(item);
                    } else if (5 <= this.fBU.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(r.j.invite_friend_exceed_max_count), 5), r.f.icon_toast_game_error);
                        return;
                    } else {
                        b(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.fBY.notifyDataSetChanged();
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
            com.baidu.adp.lib.util.k.b(getPageContext().getPageActivity(), this.cXt);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fBV != null) {
            this.fBV.cancel();
        }
        if (this.fBW != null) {
            this.fBW.cancel();
        }
        this.mHandler.removeCallbacks(this.fCe);
        if (this.ban != null) {
            this.ban.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.cFi = (RelativeLayout) findViewById(r.g.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.cFi, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.adp.lib.util.k.e(getActivity(), r.e.ds320)), NoDataViewFactory.d.dh(r.j.no_chat_friends), null, true);
        this.fCa = findViewById(r.g.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new g(this));
        acE();
        this.bpG = (NoNetworkView) findViewById(r.g.view_no_network);
        this.bpG.a(this.fnf);
        this.ban = (ProgressBar) findViewById(r.g.progress);
        this.Ck = (BdListView) findViewById(r.g.list);
        this.fBY = new n(this, this.fCd);
        this.fBY.a(this);
        this.fBY.a(new h(this));
        this.Ck.setAdapter((ListAdapter) this.fBY);
        this.Ck.setOnItemClickListener(this);
        this.Ck.setOnTouchListener(new i(this));
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.cXt.getParent() != null) {
            ((View) this.cXt.getParent()).setFocusable(true);
            ((View) this.cXt.getParent()).setFocusableInTouchMode(true);
        }
        this.daW = (LinearLayout) this.cFi.findViewById(r.g.invite_candidate);
        this.daX = (Button) this.cFi.findViewById(r.g.button_send);
        this.daX.setOnClickListener(new j(this));
        lA(0);
        this.fBU = (AtSelectFriendList) this.cFi.findViewById(r.g.candidate_list);
        this.fBU.setMaxCount(5);
        this.fBU.setItemOPerationHandler(new k(this));
        auv();
    }

    private void acE() {
        this.mNavigationBar = (NavigationBar) findViewById(r.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new l(this));
        this.fCb = this.mNavigationBar.setTitleText(getPageContext().getString(r.j.select_friend));
        this.dbc = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.add_new_friend_text, new m(this));
        this.dbe = (ImageView) this.dbc.findViewById(r.g.new_friend_search);
        this.dbb = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, r.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.dbb.setVisibility(8);
        this.cXt = (EditText) this.dbb.findViewById(r.g.search_bar_edit);
        this.cXt.addTextChangedListener(new com.baidu.tieba.write.write.b(this));
        this.cXt.setOnFocusChangeListener(new c(this));
        this.fBT = (TextView) findViewById(r.g.search_bar_delete_button);
        this.fBT.setOnClickListener(new d(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [469=4] */
    private void auv() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(r.e.ds80) + getResources().getDimensionPixelSize(r.e.ds16) + getResources().getDimensionPixelSize(r.e.ds16);
        this.mListFooter = new View(getPageContext().getContext());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setFocusable(false);
        this.mListFooter.setFocusableInTouchMode(false);
        this.mListFooter.setContentDescription("");
        this.mListFooter.setVisibility(4);
        this.mListFooter.setBackgroundColor(0);
        this.mListFooter.setOnClickListener(new e(this));
        this.Ck.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rq(String str) {
        if (!isFinishing()) {
            this.fBY.setData(null);
            if (this.fBV != null) {
                this.fBV.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.fBX.bmb() != null) {
                    ArrayList<MetaData> blX = this.fBX.bmb().blX();
                    Iterator<MetaData> it = blX.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (blX != null && !blX.isEmpty()) {
                        sx(0);
                    } else {
                        sx(1);
                    }
                    this.fBY.setData(blX);
                } else {
                    this.fBY.setData(null);
                    if (this.fBW == null) {
                        this.fBW = new b(this, null);
                        this.fBW.setPriority(3);
                        this.fBW.execute("");
                    }
                }
            } else {
                this.fBV = new a(this, null);
                this.fBV.setPriority(2);
                this.fBV.execute(str);
                if (this.fBW == null && this.fBX.bmb() == null) {
                    this.fBW = new b(this, null);
                    this.fBW.setPriority(3);
                    this.fBW.execute("");
                }
            }
            this.fBY.notifyDataSetInvalidated();
            this.Ck.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.fBX = new com.baidu.tieba.write.c.a();
        if (bundle != null) {
            this.fCd = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.fCd = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MetaData metaData) {
        if (metaData != null) {
            this.fBU.d(metaData);
            lA(this.fBU.getItemLength());
            auw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(MetaData metaData) {
        if (metaData != null) {
            this.fBU.f(metaData);
            lA(this.fBU.getItemLength());
            auw();
        }
    }

    private void auw() {
        if (this.fBU.getItemLength() > 0) {
            this.daX.setEnabled(true);
        } else {
            this.daX.setEnabled(false);
        }
    }

    private void lA(int i) {
        this.daX.setText(String.format(getPageContext().getString(r.j.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.b> {
        private com.baidu.tbadk.core.util.z aiN;
        private String fCg;

        private a() {
            this.aiN = null;
            this.fCg = null;
        }

        /* synthetic */ a(AtListActivity atListActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.ban.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.fBV = null;
            this.fCg = null;
            AtListActivity.this.ban.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.fCg = strArr[0];
            this.aiN = new com.baidu.tbadk.core.util.z();
            if (this.fCg != null && this.fCg.length() > 0) {
                this.aiN.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/sug");
                this.aiN.n(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                this.aiN.n("q", this.fCg);
                String uk = this.aiN.uk();
                if (this.aiN.uI().vC().oH()) {
                    com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
                    com.baidu.tieba.write.a.a bmb = AtListActivity.this.fBX.bmb();
                    if (bmb != null) {
                        bVar.c(uk, bmb.blY());
                        return bVar;
                    }
                    bVar.c(uk, null);
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
            AtListActivity.this.fBV = null;
            AtListActivity.this.ban.setVisibility(8);
            if (this.aiN.uI().vC().oH() && this.fCg != null && com.baidu.adp.lib.util.j.a(AtListActivity.this.cXt.getText(), "").equals(this.fCg)) {
                if (bVar == null || bVar.blZ().isEmpty()) {
                    AtListActivity.this.sx(1);
                } else {
                    AtListActivity.this.sx(0);
                }
                AtListActivity.this.fBX.a(bVar);
                AtListActivity.this.fBY.setData(bVar.blZ());
                AtListActivity.this.fBY.notifyDataSetInvalidated();
                AtListActivity.this.Ck.setSelection(0);
            } else {
                AtListActivity.this.showToast(this.aiN.getErrorString());
            }
            super.onPostExecute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.a> {
        private com.baidu.tbadk.core.util.z aiN;

        private b() {
            this.aiN = null;
        }

        /* synthetic */ b(AtListActivity atListActivity, b bVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.ban.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiN != null) {
                this.aiN.eg();
            }
            AtListActivity.this.fBW = null;
            AtListActivity.this.ban.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: J */
        public com.baidu.tieba.write.a.a doInBackground(String... strArr) {
            this.aiN = new com.baidu.tbadk.core.util.z();
            this.aiN.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/list");
            String uk = this.aiN.uk();
            if (!this.aiN.uI().vC().oH()) {
                return null;
            }
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.rh(uk);
            return aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.a aVar) {
            AtListActivity.this.fBW = null;
            AtListActivity.this.ban.setVisibility(8);
            if (AtListActivity.this.daW != null && AtListActivity.this.daW.getVisibility() == 0) {
                AtListActivity.this.fCa.setVisibility(0);
            }
            if (this.aiN.uI().vC().oH()) {
                AtListActivity.this.fBX.a(aVar);
                if (AtListActivity.this.fBY != null) {
                    if (com.baidu.adp.lib.util.j.a(AtListActivity.this.cXt.getText(), "").length() != 0) {
                        if (AtListActivity.this.fBX.bmc() != null) {
                            if (aVar != null && aVar.blY() != null && !aVar.blY().isEmpty()) {
                                AtListActivity.this.sx(2);
                            }
                            AtListActivity.this.fBX.bmc().k(aVar.blY());
                            AtListActivity.this.fBY.notifyDataSetInvalidated();
                        }
                    } else {
                        if (aVar == null || aVar.blX() == null || !aVar.blX().isEmpty()) {
                            AtListActivity.this.sx(0);
                        } else {
                            AtListActivity.this.sx(2);
                        }
                        AtListActivity.this.fBS = aVar.blX();
                        AtListActivity.this.fBY.setData(AtListActivity.this.fBS);
                        AtListActivity.this.fBY.notifyDataSetInvalidated();
                        AtListActivity.this.Ck.setSelection(0);
                    }
                } else {
                    return;
                }
            } else {
                AtListActivity.this.showToast(this.aiN.getErrorString());
            }
            super.onPostExecute(aVar);
        }
    }

    @Override // com.baidu.tieba.write.write.n.b
    public void a(View view, MetaData metaData) {
        if (metaData != null) {
            this.fBU.e(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.Ck;
    }
}
