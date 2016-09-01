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
import com.baidu.tieba.t;
import com.baidu.tieba.write.write.n;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class AtListActivity extends BaseActivity<AtListActivity> implements AdapterView.OnItemClickListener, n.b {
    private NoNetworkView blV;
    private LinearLayout dqV;
    private Button dqW;
    private View dra;
    private View drb;
    private ImageView drd;
    private AtSelectFriendList gdD;
    private TextView gdK;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.q mNoDataView;
    protected ArrayList<MetaData> gdB = new ArrayList<>();
    private EditText dlt = null;
    private TextView gdC = null;
    private BdListView Cj = null;
    private final Handler mHandler = new Handler();
    private a gdE = null;
    private b gdF = null;
    private com.baidu.tieba.write.c.a gdG = null;
    private n gdH = null;
    private String gdI = null;
    private ProgressBar coz = null;
    private RelativeLayout cSU = null;
    private View gdJ = null;
    private final int gdL = 5;
    private boolean gdM = true;
    private final Runnable gdN = new com.baidu.tieba.write.write.a(this);
    private NoNetworkView.a fyY = new f(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.at_list_activity);
        initData(bundle);
        initUI();
        ss(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ah(i == 1);
        getLayoutMode().x(this.cSU);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.blV.onChangeSkinType(getPageContext(), i);
        this.gdH.notifyDataSetChanged();
        com.baidu.tbadk.core.util.av.getColor(t.d.common_color_10221);
        com.baidu.tbadk.core.util.av.k(this.mListFooter, t.f.invite_friend_list_item_bg_color);
        com.baidu.tbadk.core.util.av.k(this.dqW, t.f.post_button_bg);
        com.baidu.tbadk.core.util.av.c(this.dqW, t.d.cp_cont_i, 3);
        com.baidu.tbadk.core.util.av.b(this.drd, t.f.icon_search_bg_s, t.f.icon_search_bg);
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
    public void to(int i) {
        if (i == 2) {
            this.Cj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.de(t.j.no_chat_friends));
            this.dqV.setVisibility(8);
        } else if (i == 1) {
            this.Cj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.de(t.j.no_search_friends));
            this.dqV.setVisibility(8);
        } else if (i == 0) {
            this.Cj.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.gdM) {
                this.dqV.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.gdH.getItem(i);
        if (item != null) {
            if (this.gdM) {
                if (this.gdE == null && this.gdF == null) {
                    if (item.isChecked()) {
                        b(item);
                    } else if (5 <= this.gdD.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(t.j.invite_friend_exceed_max_count), 5), t.f.icon_toast_game_error);
                        return;
                    } else {
                        a(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.gdH.notifyDataSetChanged();
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
            com.baidu.adp.lib.util.k.b(getPageContext().getPageActivity(), this.dlt);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gdE != null) {
            this.gdE.cancel();
        }
        if (this.gdF != null) {
            this.gdF.cancel();
        }
        this.mHandler.removeCallbacks(this.gdN);
        if (this.coz != null) {
            this.coz.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.cSU = (RelativeLayout) findViewById(t.g.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.cSU, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.de(t.j.no_chat_friends), null);
        this.gdJ = findViewById(t.g.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new g(this));
        Vg();
        this.blV = (NoNetworkView) findViewById(t.g.view_no_network);
        this.blV.a(this.fyY);
        this.coz = (ProgressBar) findViewById(t.g.progress);
        this.Cj = (BdListView) findViewById(t.g.list);
        this.gdH = new n(this, this.gdM);
        this.gdH.a(this);
        this.gdH.a(new h(this));
        this.Cj.setAdapter((ListAdapter) this.gdH);
        this.Cj.setOnItemClickListener(this);
        this.Cj.setOnTouchListener(new i(this));
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.dlt.getParent() != null) {
            ((View) this.dlt.getParent()).setFocusable(true);
            ((View) this.dlt.getParent()).setFocusableInTouchMode(true);
        }
        this.dqV = (LinearLayout) this.cSU.findViewById(t.g.invite_candidate);
        this.dqW = (Button) this.cSU.findViewById(t.g.button_send);
        this.dqW.setOnClickListener(new j(this));
        mh(0);
        this.gdD = (AtSelectFriendList) this.cSU.findViewById(t.g.candidate_list);
        this.gdD.setMaxCount(5);
        this.gdD.setItemOPerationHandler(new k(this));
        ayD();
    }

    private void Vg() {
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new l(this));
        this.gdK = this.mNavigationBar.setTitleText(getPageContext().getString(t.j.select_friend));
        this.drb = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.add_new_friend_text, new m(this));
        this.drd = (ImageView) this.drb.findViewById(t.g.new_friend_search);
        this.dra = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, t.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.dra.setVisibility(8);
        this.dlt = (EditText) this.dra.findViewById(t.g.search_bar_edit);
        this.dlt.addTextChangedListener(new com.baidu.tieba.write.write.b(this));
        this.dlt.setOnFocusChangeListener(new c(this));
        this.gdC = (TextView) findViewById(t.g.search_bar_delete_button);
        this.gdC.setOnClickListener(new d(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [476=4] */
    private void ayD() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(t.e.ds80) + getResources().getDimensionPixelSize(t.e.ds16) + getResources().getDimensionPixelSize(t.e.ds16);
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
    public void ss(String str) {
        if (!isFinishing()) {
            this.gdH.setData(null);
            if (this.gdE != null) {
                this.gdE.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.gdG.bse() != null) {
                    ArrayList<MetaData> bsa = this.gdG.bse().bsa();
                    Iterator<MetaData> it = bsa.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (bsa != null && !bsa.isEmpty()) {
                        to(0);
                    } else {
                        to(1);
                    }
                    this.gdH.setData(bsa);
                } else {
                    this.gdH.setData(null);
                    if (this.gdF == null) {
                        this.gdF = new b(this, null);
                        this.gdF.setPriority(3);
                        this.gdF.execute("");
                    }
                }
            } else {
                this.gdE = new a(this, null);
                this.gdE.setPriority(2);
                this.gdE.execute(str);
                if (this.gdF == null && this.gdG.bse() == null) {
                    this.gdF = new b(this, null);
                    this.gdF.setPriority(3);
                    this.gdF.execute("");
                }
            }
            this.gdH.notifyDataSetInvalidated();
            this.Cj.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.gdG = new com.baidu.tieba.write.c.a();
        if (bundle != null) {
            this.gdM = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.gdM = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MetaData metaData) {
        if (metaData != null) {
            this.gdD.c(metaData);
            mh(this.gdD.getItemLength());
            ayE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MetaData metaData) {
        if (metaData != null) {
            this.gdD.e(metaData);
            mh(this.gdD.getItemLength());
            ayE();
        }
    }

    private void ayE() {
        if (this.gdD.getItemLength() > 0) {
            this.dqW.setEnabled(true);
        } else {
            this.dqW.setEnabled(false);
        }
    }

    private void mh(int i) {
        this.dqW.setText(String.format(getPageContext().getString(t.j.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.b> {
        private com.baidu.tbadk.core.util.ab aiS;
        private String gdP;

        private a() {
            this.aiS = null;
            this.gdP = null;
        }

        /* synthetic */ a(AtListActivity atListActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.coz.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.gdE = null;
            this.gdP = null;
            AtListActivity.this.coz.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: M */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.gdP = strArr[0];
            this.aiS = new com.baidu.tbadk.core.util.ab();
            if (this.gdP != null && this.gdP.length() > 0) {
                this.aiS.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/sug");
                this.aiS.n("uid", TbadkCoreApplication.getCurrentAccount());
                this.aiS.n("q", this.gdP);
                String ue = this.aiS.ue();
                if (this.aiS.uD().vA().oE()) {
                    com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
                    com.baidu.tieba.write.a.a bse = AtListActivity.this.gdG.bse();
                    if (bse != null) {
                        bVar.c(ue, bse.bsb());
                        return bVar;
                    }
                    bVar.c(ue, null);
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
            AtListActivity.this.gdE = null;
            AtListActivity.this.coz.setVisibility(8);
            if (this.aiS.uD().vA().oE() && this.gdP != null && com.baidu.adp.lib.util.j.a(AtListActivity.this.dlt.getText(), "").equals(this.gdP)) {
                if (bVar == null || bVar.bsc().isEmpty()) {
                    AtListActivity.this.to(1);
                } else {
                    AtListActivity.this.to(0);
                }
                AtListActivity.this.gdG.a(bVar);
                AtListActivity.this.gdH.setData(bVar.bsc());
                AtListActivity.this.gdH.notifyDataSetInvalidated();
                AtListActivity.this.Cj.setSelection(0);
            } else {
                AtListActivity.this.showToast(this.aiS.getErrorString());
            }
            super.onPostExecute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.a> {
        private com.baidu.tbadk.core.util.ab aiS;

        private b() {
            this.aiS = null;
        }

        /* synthetic */ b(AtListActivity atListActivity, b bVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.coz.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiS != null) {
                this.aiS.eg();
            }
            AtListActivity.this.gdF = null;
            AtListActivity.this.coz.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: N */
        public com.baidu.tieba.write.a.a doInBackground(String... strArr) {
            this.aiS = new com.baidu.tbadk.core.util.ab();
            this.aiS.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/list");
            String ue = this.aiS.ue();
            if (!this.aiS.uD().vA().oE()) {
                return null;
            }
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.sj(ue);
            return aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.a aVar) {
            AtListActivity.this.gdF = null;
            AtListActivity.this.coz.setVisibility(8);
            if (AtListActivity.this.dqV != null && AtListActivity.this.dqV.getVisibility() == 0) {
                AtListActivity.this.gdJ.setVisibility(0);
            }
            if (this.aiS.uD().vA().oE()) {
                AtListActivity.this.gdG.a(aVar);
                if (AtListActivity.this.gdH != null) {
                    if (com.baidu.adp.lib.util.j.a(AtListActivity.this.dlt.getText(), "").length() != 0) {
                        if (AtListActivity.this.gdG.bsf() != null) {
                            if (aVar != null && aVar.bsb() != null && !aVar.bsb().isEmpty()) {
                                AtListActivity.this.to(2);
                            }
                            AtListActivity.this.gdG.bsf().j(aVar.bsb());
                            AtListActivity.this.gdH.notifyDataSetInvalidated();
                        }
                    } else {
                        if (aVar == null || aVar.bsa() == null || !aVar.bsa().isEmpty()) {
                            AtListActivity.this.to(0);
                        } else {
                            AtListActivity.this.to(2);
                        }
                        AtListActivity.this.gdB = aVar.bsa();
                        AtListActivity.this.gdH.setData(AtListActivity.this.gdB);
                        AtListActivity.this.gdH.notifyDataSetInvalidated();
                        AtListActivity.this.Cj.setSelection(0);
                    }
                } else {
                    return;
                }
            } else {
                AtListActivity.this.showToast(this.aiS.getErrorString());
            }
            super.onPostExecute(aVar);
        }
    }

    @Override // com.baidu.tieba.write.write.n.b
    public void a(View view, MetaData metaData) {
        if (metaData != null) {
            this.gdD.d(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.Cj;
    }
}
