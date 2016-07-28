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
    private NoNetworkView bmB;
    private LinearLayout dfo;
    private Button dfp;
    private View dft;
    private View dfu;
    private ImageView dfw;
    private TextView fTF;
    private AtSelectFriendList fTy;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.q mNoDataView;
    protected ArrayList<MetaData> fTw = new ArrayList<>();
    private EditText cZK = null;
    private TextView fTx = null;
    private BdListView zU = null;
    private final Handler mHandler = new Handler();
    private a fTz = null;
    private b fTA = null;
    private com.baidu.tieba.write.c.a fTB = null;
    private n fTC = null;
    private String fTD = null;
    private ProgressBar cdm = null;
    private RelativeLayout cHo = null;
    private View fTE = null;
    private final int fTG = 5;
    private boolean fTH = true;
    private final Runnable fTI = new com.baidu.tieba.write.write.a(this);
    private NoNetworkView.a fTJ = new f(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(u.h.at_list_activity);
        initData(bundle);
        initUI();
        rI(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().af(i == 1);
        getLayoutMode().w(this.cHo);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bmB.onChangeSkinType(getPageContext(), i);
        this.fTC.notifyDataSetChanged();
        com.baidu.tbadk.core.util.av.getColor(u.d.common_color_10221);
        com.baidu.tbadk.core.util.av.k(this.mListFooter, u.f.invite_friend_list_item_bg_color);
        com.baidu.tbadk.core.util.av.k(this.dfp, u.f.post_button_bg);
        com.baidu.tbadk.core.util.av.c(this.dfp, u.d.cp_cont_i, 3);
        com.baidu.tbadk.core.util.av.b(this.dfw, u.f.icon_search_bg_s, u.f.icon_search_bg);
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
    public void sN(int i) {
        if (i == 2) {
            this.zU.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cQ(u.j.no_chat_friends));
            this.dfo.setVisibility(8);
        } else if (i == 1) {
            this.zU.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cQ(u.j.no_search_friends));
            this.dfo.setVisibility(8);
        } else if (i == 0) {
            this.zU.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.fTH) {
                this.dfo.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.fTC.getItem(i);
        if (item != null) {
            if (this.fTH) {
                if (this.fTz == null && this.fTA == null) {
                    if (item.isChecked()) {
                        b(item);
                    } else if (5 <= this.fTy.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(u.j.invite_friend_exceed_max_count), 5), u.f.icon_toast_game_error);
                        return;
                    } else {
                        a(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.fTC.notifyDataSetChanged();
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
            com.baidu.adp.lib.util.k.b(getPageContext().getPageActivity(), this.cZK);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fTz != null) {
            this.fTz.cancel();
        }
        if (this.fTA != null) {
            this.fTA.cancel();
        }
        this.mHandler.removeCallbacks(this.fTI);
        if (this.cdm != null) {
            this.cdm.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.cHo = (RelativeLayout) findViewById(u.g.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.cHo, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cQ(u.j.no_chat_friends), null);
        this.fTE = findViewById(u.g.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new g(this));
        Qu();
        this.bmB = (NoNetworkView) findViewById(u.g.view_no_network);
        this.bmB.a(this.fTJ);
        this.cdm = (ProgressBar) findViewById(u.g.progress);
        this.zU = (BdListView) findViewById(u.g.list);
        this.fTC = new n(this, this.fTH);
        this.fTC.a(this);
        this.fTC.a(new h(this));
        this.zU.setAdapter((ListAdapter) this.fTC);
        this.zU.setOnItemClickListener(this);
        this.zU.setOnTouchListener(new i(this));
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.cZK.getParent() != null) {
            ((View) this.cZK.getParent()).setFocusable(true);
            ((View) this.cZK.getParent()).setFocusableInTouchMode(true);
        }
        this.dfo = (LinearLayout) this.cHo.findViewById(u.g.invite_candidate);
        this.dfp = (Button) this.cHo.findViewById(u.g.button_send);
        this.dfp.setOnClickListener(new j(this));
        lE(0);
        this.fTy = (AtSelectFriendList) this.cHo.findViewById(u.g.candidate_list);
        this.fTy.setMaxCount(5);
        this.fTy.setItemOPerationHandler(new k(this));
        atP();
    }

    private void Qu() {
        this.mNavigationBar = (NavigationBar) findViewById(u.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new l(this));
        this.fTF = this.mNavigationBar.setTitleText(getPageContext().getString(u.j.select_friend));
        this.dfu = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.add_new_friend_text, new m(this));
        this.dfw = (ImageView) this.dfu.findViewById(u.g.new_friend_search);
        this.dft = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, u.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.dft.setVisibility(8);
        this.cZK = (EditText) this.dft.findViewById(u.g.search_bar_edit);
        this.cZK.addTextChangedListener(new com.baidu.tieba.write.write.b(this));
        this.cZK.setOnFocusChangeListener(new c(this));
        this.fTx = (TextView) findViewById(u.g.search_bar_delete_button);
        this.fTx.setOnClickListener(new d(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [476=4] */
    private void atP() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(u.e.ds80) + getResources().getDimensionPixelSize(u.e.ds16) + getResources().getDimensionPixelSize(u.e.ds16);
        this.mListFooter = new View(getPageContext().getContext());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setFocusable(false);
        this.mListFooter.setFocusableInTouchMode(false);
        this.mListFooter.setContentDescription("");
        this.mListFooter.setVisibility(4);
        this.mListFooter.setBackgroundColor(0);
        this.mListFooter.setOnClickListener(new e(this));
        this.zU.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rI(String str) {
        if (!isFinishing()) {
            this.fTC.setData(null);
            if (this.fTz != null) {
                this.fTz.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.fTB.bnO() != null) {
                    ArrayList<MetaData> bnK = this.fTB.bnO().bnK();
                    Iterator<MetaData> it = bnK.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (bnK != null && !bnK.isEmpty()) {
                        sN(0);
                    } else {
                        sN(1);
                    }
                    this.fTC.setData(bnK);
                } else {
                    this.fTC.setData(null);
                    if (this.fTA == null) {
                        this.fTA = new b(this, null);
                        this.fTA.setPriority(3);
                        this.fTA.execute("");
                    }
                }
            } else {
                this.fTz = new a(this, null);
                this.fTz.setPriority(2);
                this.fTz.execute(str);
                if (this.fTA == null && this.fTB.bnO() == null) {
                    this.fTA = new b(this, null);
                    this.fTA.setPriority(3);
                    this.fTA.execute("");
                }
            }
            this.fTC.notifyDataSetInvalidated();
            this.zU.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.fTB = new com.baidu.tieba.write.c.a();
        if (bundle != null) {
            this.fTH = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.fTH = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MetaData metaData) {
        if (metaData != null) {
            this.fTy.c(metaData);
            lE(this.fTy.getItemLength());
            atQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MetaData metaData) {
        if (metaData != null) {
            this.fTy.e(metaData);
            lE(this.fTy.getItemLength());
            atQ();
        }
    }

    private void atQ() {
        if (this.fTy.getItemLength() > 0) {
            this.dfp.setEnabled(true);
        } else {
            this.dfp.setEnabled(false);
        }
    }

    private void lE(int i) {
        this.dfp.setText(String.format(getPageContext().getString(u.j.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.b> {
        private com.baidu.tbadk.core.util.ab afX;
        private String fTL;

        private a() {
            this.afX = null;
            this.fTL = null;
        }

        /* synthetic */ a(AtListActivity atListActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.cdm.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.fTz = null;
            this.fTL = null;
            AtListActivity.this.cdm.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: M */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.fTL = strArr[0];
            this.afX = new com.baidu.tbadk.core.util.ab();
            if (this.fTL != null && this.fTL.length() > 0) {
                this.afX.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/sug");
                this.afX.n("uid", TbadkCoreApplication.getCurrentAccount());
                this.afX.n("q", this.fTL);
                String sZ = this.afX.sZ();
                if (this.afX.tx().uv().nJ()) {
                    com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
                    com.baidu.tieba.write.a.a bnO = AtListActivity.this.fTB.bnO();
                    if (bnO != null) {
                        bVar.c(sZ, bnO.bnL());
                        return bVar;
                    }
                    bVar.c(sZ, null);
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
            AtListActivity.this.fTz = null;
            AtListActivity.this.cdm.setVisibility(8);
            if (this.afX.tx().uv().nJ() && this.fTL != null && com.baidu.adp.lib.util.j.a(AtListActivity.this.cZK.getText(), "").equals(this.fTL)) {
                if (bVar == null || bVar.bnM().isEmpty()) {
                    AtListActivity.this.sN(1);
                } else {
                    AtListActivity.this.sN(0);
                }
                AtListActivity.this.fTB.a(bVar);
                AtListActivity.this.fTC.setData(bVar.bnM());
                AtListActivity.this.fTC.notifyDataSetInvalidated();
                AtListActivity.this.zU.setSelection(0);
            } else {
                AtListActivity.this.showToast(this.afX.getErrorString());
            }
            super.onPostExecute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.a> {
        private com.baidu.tbadk.core.util.ab afX;

        private b() {
            this.afX = null;
        }

        /* synthetic */ b(AtListActivity atListActivity, b bVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.cdm.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afX != null) {
                this.afX.dl();
            }
            AtListActivity.this.fTA = null;
            AtListActivity.this.cdm.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: N */
        public com.baidu.tieba.write.a.a doInBackground(String... strArr) {
            this.afX = new com.baidu.tbadk.core.util.ab();
            this.afX.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/list");
            String sZ = this.afX.sZ();
            if (!this.afX.tx().uv().nJ()) {
                return null;
            }
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.rz(sZ);
            return aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.a aVar) {
            AtListActivity.this.fTA = null;
            AtListActivity.this.cdm.setVisibility(8);
            if (AtListActivity.this.dfo != null && AtListActivity.this.dfo.getVisibility() == 0) {
                AtListActivity.this.fTE.setVisibility(0);
            }
            if (this.afX.tx().uv().nJ()) {
                AtListActivity.this.fTB.a(aVar);
                if (AtListActivity.this.fTC != null) {
                    if (com.baidu.adp.lib.util.j.a(AtListActivity.this.cZK.getText(), "").length() != 0) {
                        if (AtListActivity.this.fTB.bnP() != null) {
                            if (aVar != null && aVar.bnL() != null && !aVar.bnL().isEmpty()) {
                                AtListActivity.this.sN(2);
                            }
                            AtListActivity.this.fTB.bnP().j(aVar.bnL());
                            AtListActivity.this.fTC.notifyDataSetInvalidated();
                        }
                    } else {
                        if (aVar == null || aVar.bnK() == null || !aVar.bnK().isEmpty()) {
                            AtListActivity.this.sN(0);
                        } else {
                            AtListActivity.this.sN(2);
                        }
                        AtListActivity.this.fTw = aVar.bnK();
                        AtListActivity.this.fTC.setData(AtListActivity.this.fTw);
                        AtListActivity.this.fTC.notifyDataSetInvalidated();
                        AtListActivity.this.zU.setSelection(0);
                    }
                } else {
                    return;
                }
            } else {
                AtListActivity.this.showToast(this.afX.getErrorString());
            }
            super.onPostExecute(aVar);
        }
    }

    @Override // com.baidu.tieba.write.write.n.b
    public void a(View view, MetaData metaData) {
        if (metaData != null) {
            this.fTy.d(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.zU;
    }
}
