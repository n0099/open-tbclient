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
    private NoNetworkView aMQ;
    private LinearLayout bNA;
    private Button bNB;
    private View bNC;
    private View bNG;
    private View bNH;
    private AtSelectFriendList dom;
    private TextView dot;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.m mNoDataView;
    protected ArrayList<MetaData> dok = new ArrayList<>();
    private EditText bHW = null;
    private TextView dol = null;
    private BdListView mListView = null;
    private final Handler mHandler = new Handler();
    private a don = null;
    private b doo = null;
    private com.baidu.tieba.write.b.a dop = null;
    private m doq = null;
    private String dor = null;
    private ProgressBar mProgress = null;
    private RelativeLayout bro = null;
    private View dos = null;
    private final int dou = 5;
    private boolean dov = true;
    private final Runnable dow = new com.baidu.tieba.write.write.a(this);
    private NoNetworkView.a dox = new e(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.at_list_activity);
        initData(bundle);
        initUI();
        mu(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.bro);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aMQ.onChangeSkinType(getPageContext(), i);
        this.doq.notifyDataSetChanged();
        com.baidu.tbadk.core.util.an.getColor(i.c.widget_searchbox_text);
        com.baidu.tbadk.core.util.an.i(this.bNC, i.e.invite_friend_list_item_bg_color);
        com.baidu.tbadk.core.util.an.i((View) this.bNB, i.e.post_button_bg);
        com.baidu.tbadk.core.util.an.b(this.bNB, i.c.cp_cont_i, 3);
        this.bNC.setEnabled(false);
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
    public void mh(int i) {
        if (i == 2) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.no_chat_friends));
            this.bNA.setVisibility(8);
        } else if (i == 1) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(i.h.no_search_friends));
            this.bNA.setVisibility(8);
        } else if (i == 0) {
            this.mListView.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.dov) {
                this.bNA.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.doq.getItem(i);
        if (item != null) {
            if (this.dov) {
                if (this.don == null && this.doo == null) {
                    if (item.isChecked()) {
                        b(item);
                    } else if (5 <= this.dom.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(i.h.invite_friend_exceed_max_count), 5), i.e.icon_toast_game_error);
                        return;
                    } else {
                        a(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.doq.notifyDataSetChanged();
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
            com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), this.bHW);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.don != null) {
            this.don.cancel();
        }
        if (this.doo != null) {
            this.doo.cancel();
        }
        this.mHandler.removeCallbacks(this.dow);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.bro = (RelativeLayout) findViewById(i.f.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.bro, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cK(i.h.no_chat_friends), null);
        this.dos = findViewById(i.f.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new f(this));
        Ok();
        this.aMQ = (NoNetworkView) findViewById(i.f.view_no_network);
        this.aMQ.a(this.dox);
        this.mProgress = (ProgressBar) findViewById(i.f.progress);
        this.mListView = (BdListView) findViewById(i.f.list);
        this.doq = new m(this, this.dov);
        this.doq.a(this);
        this.doq.setCheckBoxStateChangedListener(new g(this));
        this.mListView.setAdapter((ListAdapter) this.doq);
        this.mListView.setOnItemClickListener(this);
        this.mListView.setOnTouchListener(new h(this));
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.bHW.getParent() != null) {
            ((View) this.bHW.getParent()).setFocusable(true);
            ((View) this.bHW.getParent()).setFocusableInTouchMode(true);
        }
        this.bNA = (LinearLayout) this.bro.findViewById(i.f.invite_candidate);
        this.bNB = (Button) this.bro.findViewById(i.f.button_send);
        this.bNB.setOnClickListener(new i(this));
        hO(0);
        this.dom = (AtSelectFriendList) this.bro.findViewById(i.f.candidate_list);
        this.dom.setMaxCount(5);
        this.dom.setItemOPerationHandler(new j(this));
        Zz();
    }

    private void Ok() {
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new k(this));
        this.dot = this.mNavigationBar.setTitleText(getPageContext().getString(i.h.select_friend));
        this.bNH = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.add_new_friend_text, new l(this));
        this.bNG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, i.g.navigationbar_search_edit, (View.OnClickListener) null);
        this.bNG.setVisibility(8);
        this.bHW = (EditText) this.bNG.findViewById(i.f.search_bar_edit);
        this.bHW.addTextChangedListener(new com.baidu.tieba.write.write.b(this));
        this.bHW.setOnFocusChangeListener(new c(this));
        this.dol = (TextView) findViewById(i.f.search_bar_delete_button);
        this.dol.setOnClickListener(new d(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [474=4] */
    private void Zz() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_height) + getResources().getDimensionPixelSize(i.d.invite_friend_candidate_padding_bottom) + getResources().getDimensionPixelSize(i.d.invite_friend_candidate_padding_top);
        this.bNC = new View(getPageContext().getContext());
        this.bNC.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListView.addFooterView(this.bNC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mu(String str) {
        if (!isFinishing()) {
            this.doq.setData(null);
            if (this.don != null) {
                this.don.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.dop.aBN() != null) {
                    ArrayList<MetaData> aBI = this.dop.aBN().aBI();
                    Iterator<MetaData> it = aBI.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (aBI != null && !aBI.isEmpty()) {
                        mh(0);
                    } else {
                        mh(1);
                    }
                    this.doq.setData(aBI);
                } else {
                    this.doq.setData(null);
                    if (this.doo == null) {
                        this.doo = new b(this, null);
                        this.doo.setPriority(3);
                        this.doo.execute("");
                    }
                }
            } else {
                this.don = new a(this, null);
                this.don.setPriority(2);
                this.don.execute(str);
                if (this.doo == null && this.dop.aBN() == null) {
                    this.doo = new b(this, null);
                    this.doo.setPriority(3);
                    this.doo.execute("");
                }
            }
            this.doq.notifyDataSetInvalidated();
            this.mListView.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.dop = new com.baidu.tieba.write.b.a();
        if (bundle != null) {
            this.dov = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.dov = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MetaData metaData) {
        if (metaData != null) {
            this.dom.c(metaData);
            hO(this.dom.getItemLength());
            ZA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MetaData metaData) {
        if (metaData != null) {
            this.dom.e(metaData);
            hO(this.dom.getItemLength());
            ZA();
        }
    }

    private void ZA() {
        if (this.dom.getItemLength() > 0) {
            this.bNB.setEnabled(true);
        } else {
            this.bNB.setEnabled(false);
        }
    }

    private void hO(int i) {
        this.bNB.setText(String.format(getPageContext().getString(i.h.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.data.c> {
        private com.baidu.tbadk.core.util.w afh;
        private String doz;

        private a() {
            this.afh = null;
            this.doz = null;
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
            AtListActivity.this.don = null;
            this.doz = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public com.baidu.tieba.write.data.c doInBackground(String... strArr) {
            this.doz = strArr[0];
            this.afh = new com.baidu.tbadk.core.util.w();
            if (this.doz != null && this.doz.length() > 0) {
                this.afh.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/sug");
                this.afh.o("uid", TbadkCoreApplication.getCurrentAccount());
                this.afh.o("q", this.doz);
                String tG = this.afh.tG();
                if (this.afh.uh().uZ().qV()) {
                    com.baidu.tieba.write.data.c cVar = new com.baidu.tieba.write.data.c();
                    com.baidu.tieba.write.data.a aBN = AtListActivity.this.dop.aBN();
                    if (aBN != null) {
                        cVar.a(tG, aBN.aBJ());
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
            AtListActivity.this.don = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (this.afh.uh().uZ().qV() && this.doz != null && com.baidu.adp.lib.util.j.a(AtListActivity.this.bHW.getText(), "").equals(this.doz)) {
                if (cVar == null || cVar.aBL().isEmpty()) {
                    AtListActivity.this.mh(1);
                } else {
                    AtListActivity.this.mh(0);
                }
                AtListActivity.this.dop.a(cVar);
                AtListActivity.this.doq.setData(cVar.aBL());
                AtListActivity.this.doq.notifyDataSetInvalidated();
                AtListActivity.this.mListView.setSelection(0);
            } else {
                AtListActivity.this.showToast(this.afh.getErrorString());
            }
            super.onPostExecute(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, com.baidu.tieba.write.data.a> {
        private com.baidu.tbadk.core.util.w afh;

        private b() {
            this.afh = null;
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
            if (this.afh != null) {
                this.afh.gJ();
            }
            AtListActivity.this.doo = null;
            AtListActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public com.baidu.tieba.write.data.a doInBackground(String... strArr) {
            this.afh = new com.baidu.tbadk.core.util.w();
            this.afh.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/list");
            String tG = this.afh.tG();
            if (!this.afh.uh().uZ().qV()) {
                return null;
            }
            com.baidu.tieba.write.data.a aVar = new com.baidu.tieba.write.data.a();
            aVar.mp(tG);
            return aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.data.a aVar) {
            AtListActivity.this.doo = null;
            AtListActivity.this.mProgress.setVisibility(8);
            if (AtListActivity.this.bNA != null && AtListActivity.this.bNA.getVisibility() == 0) {
                AtListActivity.this.dos.setVisibility(0);
            }
            if (this.afh.uh().uZ().qV()) {
                AtListActivity.this.dop.a(aVar);
                if (AtListActivity.this.doq != null) {
                    if (com.baidu.adp.lib.util.j.a(AtListActivity.this.bHW.getText(), "").length() != 0) {
                        if (AtListActivity.this.dop.aBO() != null) {
                            if (aVar != null && aVar.aBJ() != null && !aVar.aBJ().isEmpty()) {
                                AtListActivity.this.mh(2);
                            }
                            AtListActivity.this.dop.aBO().i(aVar.aBJ());
                            AtListActivity.this.doq.notifyDataSetInvalidated();
                        }
                    } else {
                        if (aVar == null || aVar.aBI() == null || !aVar.aBI().isEmpty()) {
                            AtListActivity.this.mh(0);
                        } else {
                            AtListActivity.this.mh(2);
                        }
                        AtListActivity.this.dok = aVar.aBI();
                        AtListActivity.this.doq.setData(AtListActivity.this.dok);
                        AtListActivity.this.doq.notifyDataSetInvalidated();
                        AtListActivity.this.mListView.setSelection(0);
                    }
                } else {
                    return;
                }
            } else {
                AtListActivity.this.showToast(this.afh.getErrorString());
            }
            super.onPostExecute(aVar);
        }
    }

    @Override // com.baidu.tieba.write.write.m.b
    public void a(View view, MetaData metaData) {
        if (metaData != null) {
            this.dom.d(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.mListView;
    }
}
