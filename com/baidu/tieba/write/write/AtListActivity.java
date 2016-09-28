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
import com.baidu.tieba.r;
import com.baidu.tieba.write.write.n;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class AtListActivity extends BaseActivity<AtListActivity> implements AdapterView.OnItemClickListener, n.b {
    private NoNetworkView bmi;
    private ImageView dsA;
    private LinearLayout dss;
    private Button dst;
    private View dsx;
    private View dsy;
    private AtSelectFriendList gfN;
    private TextView gfU;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.v mNoDataView;
    protected ArrayList<MetaData> gfL = new ArrayList<>();
    private EditText dmQ = null;
    private TextView gfM = null;
    private BdListView Cj = null;
    private final Handler mHandler = new Handler();
    private a gfO = null;
    private b gfP = null;
    private com.baidu.tieba.write.c.a gfQ = null;
    private n gfR = null;
    private String gfS = null;
    private ProgressBar coW = null;
    private RelativeLayout cUo = null;
    private View gfT = null;
    private final int gfV = 5;
    private boolean gfW = true;
    private final Runnable gfX = new com.baidu.tieba.write.write.a(this);
    private NoNetworkView.a fBz = new f(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(r.h.at_list_activity);
        initData(bundle);
        initUI();
        sH(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ah(i == 1);
        getLayoutMode().x(this.cUo);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bmi.onChangeSkinType(getPageContext(), i);
        this.gfR.notifyDataSetChanged();
        com.baidu.tbadk.core.util.av.getColor(r.d.common_color_10221);
        com.baidu.tbadk.core.util.av.k(this.mListFooter, r.f.invite_friend_list_item_bg_color);
        com.baidu.tbadk.core.util.av.k(this.dst, r.f.post_button_bg);
        com.baidu.tbadk.core.util.av.c(this.dst, r.d.cp_cont_i, 3);
        com.baidu.tbadk.core.util.av.b(this.dsA, r.f.icon_search_bg_s, r.f.icon_search_bg);
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
    public void tC(int i) {
        if (i == 2) {
            this.Cj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.de(r.j.no_chat_friends));
            this.dss.setVisibility(8);
        } else if (i == 1) {
            this.Cj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.de(r.j.no_search_friends));
            this.dss.setVisibility(8);
        } else if (i == 0) {
            this.Cj.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.gfW) {
                this.dss.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.gfR.getItem(i);
        if (item != null) {
            if (this.gfW) {
                if (this.gfO == null && this.gfP == null) {
                    if (item.isChecked()) {
                        b(item);
                    } else if (5 <= this.gfN.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(r.j.invite_friend_exceed_max_count), 5), r.f.icon_toast_game_error);
                        return;
                    } else {
                        a(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.gfR.notifyDataSetChanged();
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
            com.baidu.adp.lib.util.k.b(getPageContext().getPageActivity(), this.dmQ);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gfO != null) {
            this.gfO.cancel();
        }
        if (this.gfP != null) {
            this.gfP.cancel();
        }
        this.mHandler.removeCallbacks(this.gfX);
        if (this.coW != null) {
            this.coW.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.cUo = (RelativeLayout) findViewById(r.g.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.cUo, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.adp.lib.util.k.e(getActivity(), r.e.ds320)), NoDataViewFactory.d.de(r.j.no_chat_friends), null, true);
        this.gfT = findViewById(r.g.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new g(this));
        Vz();
        this.bmi = (NoNetworkView) findViewById(r.g.view_no_network);
        this.bmi.a(this.fBz);
        this.coW = (ProgressBar) findViewById(r.g.progress);
        this.Cj = (BdListView) findViewById(r.g.list);
        this.gfR = new n(this, this.gfW);
        this.gfR.a(this);
        this.gfR.a(new h(this));
        this.Cj.setAdapter((ListAdapter) this.gfR);
        this.Cj.setOnItemClickListener(this);
        this.Cj.setOnTouchListener(new i(this));
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.dmQ.getParent() != null) {
            ((View) this.dmQ.getParent()).setFocusable(true);
            ((View) this.dmQ.getParent()).setFocusableInTouchMode(true);
        }
        this.dss = (LinearLayout) this.cUo.findViewById(r.g.invite_candidate);
        this.dst = (Button) this.cUo.findViewById(r.g.button_send);
        this.dst.setOnClickListener(new j(this));
        mp(0);
        this.gfN = (AtSelectFriendList) this.cUo.findViewById(r.g.candidate_list);
        this.gfN.setMaxCount(5);
        this.gfN.setItemOPerationHandler(new k(this));
        azb();
    }

    private void Vz() {
        this.mNavigationBar = (NavigationBar) findViewById(r.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new l(this));
        this.gfU = this.mNavigationBar.setTitleText(getPageContext().getString(r.j.select_friend));
        this.dsy = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.add_new_friend_text, new m(this));
        this.dsA = (ImageView) this.dsy.findViewById(r.g.new_friend_search);
        this.dsx = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, r.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.dsx.setVisibility(8);
        this.dmQ = (EditText) this.dsx.findViewById(r.g.search_bar_edit);
        this.dmQ.addTextChangedListener(new com.baidu.tieba.write.write.b(this));
        this.dmQ.setOnFocusChangeListener(new c(this));
        this.gfM = (TextView) findViewById(r.g.search_bar_delete_button);
        this.gfM.setOnClickListener(new d(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [469=4] */
    private void azb() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(r.e.ds80) + getResources().getDimensionPixelSize(r.e.ds16) + getResources().getDimensionPixelSize(r.e.ds16);
        this.mListFooter = new View(getPageContext().getContext());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setFocusable(false);
        this.mListFooter.setFocusableInTouchMode(false);
        this.mListFooter.setContentDescription("");
        this.mListFooter.setVisibility(4);
        this.mListFooter.setBackgroundColor(0);
        this.mListFooter.setOnClickListener(new e(this));
        this.Cj.addFooterView(this.mListFooter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sH(String str) {
        if (!isFinishing()) {
            this.gfR.setData(null);
            if (this.gfO != null) {
                this.gfO.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.gfQ.bsK() != null) {
                    ArrayList<MetaData> bsG = this.gfQ.bsK().bsG();
                    Iterator<MetaData> it = bsG.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (bsG != null && !bsG.isEmpty()) {
                        tC(0);
                    } else {
                        tC(1);
                    }
                    this.gfR.setData(bsG);
                } else {
                    this.gfR.setData(null);
                    if (this.gfP == null) {
                        this.gfP = new b(this, null);
                        this.gfP.setPriority(3);
                        this.gfP.execute("");
                    }
                }
            } else {
                this.gfO = new a(this, null);
                this.gfO.setPriority(2);
                this.gfO.execute(str);
                if (this.gfP == null && this.gfQ.bsK() == null) {
                    this.gfP = new b(this, null);
                    this.gfP.setPriority(3);
                    this.gfP.execute("");
                }
            }
            this.gfR.notifyDataSetInvalidated();
            this.Cj.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.gfQ = new com.baidu.tieba.write.c.a();
        if (bundle != null) {
            this.gfW = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.gfW = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MetaData metaData) {
        if (metaData != null) {
            this.gfN.c(metaData);
            mp(this.gfN.getItemLength());
            azc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MetaData metaData) {
        if (metaData != null) {
            this.gfN.e(metaData);
            mp(this.gfN.getItemLength());
            azc();
        }
    }

    private void azc() {
        if (this.gfN.getItemLength() > 0) {
            this.dst.setEnabled(true);
        } else {
            this.dst.setEnabled(false);
        }
    }

    private void mp(int i) {
        this.dst.setText(String.format(getPageContext().getString(r.j.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.b> {
        private com.baidu.tbadk.core.util.ab aiu;
        private String gfZ;

        private a() {
            this.aiu = null;
            this.gfZ = null;
        }

        /* synthetic */ a(AtListActivity atListActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.coW.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.gfO = null;
            this.gfZ = null;
            AtListActivity.this.coW.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: L */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.gfZ = strArr[0];
            this.aiu = new com.baidu.tbadk.core.util.ab();
            if (this.gfZ != null && this.gfZ.length() > 0) {
                this.aiu.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/sug");
                this.aiu.n("uid", TbadkCoreApplication.getCurrentAccount());
                this.aiu.n("q", this.gfZ);
                String uu = this.aiu.uu();
                if (this.aiu.uS().vO().oF()) {
                    com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
                    com.baidu.tieba.write.a.a bsK = AtListActivity.this.gfQ.bsK();
                    if (bsK != null) {
                        bVar.c(uu, bsK.bsH());
                        return bVar;
                    }
                    bVar.c(uu, null);
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
            AtListActivity.this.gfO = null;
            AtListActivity.this.coW.setVisibility(8);
            if (this.aiu.uS().vO().oF() && this.gfZ != null && com.baidu.adp.lib.util.j.a(AtListActivity.this.dmQ.getText(), "").equals(this.gfZ)) {
                if (bVar == null || bVar.bsI().isEmpty()) {
                    AtListActivity.this.tC(1);
                } else {
                    AtListActivity.this.tC(0);
                }
                AtListActivity.this.gfQ.a(bVar);
                AtListActivity.this.gfR.setData(bVar.bsI());
                AtListActivity.this.gfR.notifyDataSetInvalidated();
                AtListActivity.this.Cj.setSelection(0);
            } else {
                AtListActivity.this.showToast(this.aiu.getErrorString());
            }
            super.onPostExecute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.a> {
        private com.baidu.tbadk.core.util.ab aiu;

        private b() {
            this.aiu = null;
        }

        /* synthetic */ b(AtListActivity atListActivity, b bVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.coW.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiu != null) {
                this.aiu.eg();
            }
            AtListActivity.this.gfP = null;
            AtListActivity.this.coW.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: M */
        public com.baidu.tieba.write.a.a doInBackground(String... strArr) {
            this.aiu = new com.baidu.tbadk.core.util.ab();
            this.aiu.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/list");
            String uu = this.aiu.uu();
            if (!this.aiu.uS().vO().oF()) {
                return null;
            }
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.sy(uu);
            return aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.a aVar) {
            AtListActivity.this.gfP = null;
            AtListActivity.this.coW.setVisibility(8);
            if (AtListActivity.this.dss != null && AtListActivity.this.dss.getVisibility() == 0) {
                AtListActivity.this.gfT.setVisibility(0);
            }
            if (this.aiu.uS().vO().oF()) {
                AtListActivity.this.gfQ.a(aVar);
                if (AtListActivity.this.gfR != null) {
                    if (com.baidu.adp.lib.util.j.a(AtListActivity.this.dmQ.getText(), "").length() != 0) {
                        if (AtListActivity.this.gfQ.bsL() != null) {
                            if (aVar != null && aVar.bsH() != null && !aVar.bsH().isEmpty()) {
                                AtListActivity.this.tC(2);
                            }
                            AtListActivity.this.gfQ.bsL().j(aVar.bsH());
                            AtListActivity.this.gfR.notifyDataSetInvalidated();
                        }
                    } else {
                        if (aVar == null || aVar.bsG() == null || !aVar.bsG().isEmpty()) {
                            AtListActivity.this.tC(0);
                        } else {
                            AtListActivity.this.tC(2);
                        }
                        AtListActivity.this.gfL = aVar.bsG();
                        AtListActivity.this.gfR.setData(AtListActivity.this.gfL);
                        AtListActivity.this.gfR.notifyDataSetInvalidated();
                        AtListActivity.this.Cj.setSelection(0);
                    }
                } else {
                    return;
                }
            } else {
                AtListActivity.this.showToast(this.aiu.getErrorString());
            }
            super.onPostExecute(aVar);
        }
    }

    @Override // com.baidu.tieba.write.write.n.b
    public void a(View view, MetaData metaData) {
        if (metaData != null) {
            this.gfN.d(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.Cj;
    }
}
