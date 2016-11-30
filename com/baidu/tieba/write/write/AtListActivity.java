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
    private NoNetworkView bpe;
    private LinearLayout dxX;
    private Button dxY;
    private View dyc;
    private View dyd;
    private ImageView dyf;
    private AtSelectFriendList gnr;
    private TextView gny;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.w mNoDataView;
    protected ArrayList<MetaData> gnp = new ArrayList<>();
    private EditText dsz = null;
    private TextView gnq = null;
    private BdListView Cj = null;
    private final Handler mHandler = new Handler();
    private a gns = null;
    private b gnt = null;
    private com.baidu.tieba.write.c.a gnu = null;
    private n gnv = null;
    private String gnw = null;
    private ProgressBar cub = null;
    private RelativeLayout cZW = null;
    private View gnx = null;
    private final int gnz = 5;
    private boolean gnA = true;
    private final Runnable gnB = new com.baidu.tieba.write.write.a(this);
    private NoNetworkView.a fJb = new f(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(r.h.at_list_activity);
        initData(bundle);
        initUI();
        td(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ai(i == 1);
        getLayoutMode().x(this.cZW);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bpe.onChangeSkinType(getPageContext(), i);
        this.gnv.notifyDataSetChanged();
        com.baidu.tbadk.core.util.at.getColor(r.d.common_color_10221);
        com.baidu.tbadk.core.util.at.k(this.mListFooter, r.f.invite_friend_list_item_bg_color);
        com.baidu.tbadk.core.util.at.k(this.dxY, r.f.post_button_bg);
        com.baidu.tbadk.core.util.at.c(this.dxY, r.d.cp_cont_i, 3);
        com.baidu.tbadk.core.util.at.b(this.dyf, r.f.icon_search_bg_s, r.f.icon_search_bg);
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
    public void tY(int i) {
        if (i == 2) {
            this.Cj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.df(r.j.no_chat_friends));
            this.dxX.setVisibility(8);
        } else if (i == 1) {
            this.Cj.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.d.df(r.j.no_search_friends));
            this.dxX.setVisibility(8);
        } else if (i == 0) {
            this.Cj.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.gnA) {
                this.dxX.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.gnv.getItem(i);
        if (item != null) {
            if (this.gnA) {
                if (this.gns == null && this.gnt == null) {
                    if (item.isChecked()) {
                        c(item);
                    } else if (5 <= this.gnr.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(r.j.invite_friend_exceed_max_count), 5), r.f.icon_toast_game_error);
                        return;
                    } else {
                        b(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.gnv.notifyDataSetChanged();
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
            com.baidu.adp.lib.util.k.b(getPageContext().getPageActivity(), this.dsz);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gns != null) {
            this.gns.cancel();
        }
        if (this.gnt != null) {
            this.gnt.cancel();
        }
        this.mHandler.removeCallbacks(this.gnB);
        if (this.cub != null) {
            this.cub.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.cZW = (RelativeLayout) findViewById(r.g.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.cZW, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.adp.lib.util.k.e(getActivity(), r.e.ds320)), NoDataViewFactory.d.df(r.j.no_chat_friends), null, true);
        this.gnx = findViewById(r.g.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new g(this));
        WB();
        this.bpe = (NoNetworkView) findViewById(r.g.view_no_network);
        this.bpe.a(this.fJb);
        this.cub = (ProgressBar) findViewById(r.g.progress);
        this.Cj = (BdListView) findViewById(r.g.list);
        this.gnv = new n(this, this.gnA);
        this.gnv.a(this);
        this.gnv.a(new h(this));
        this.Cj.setAdapter((ListAdapter) this.gnv);
        this.Cj.setOnItemClickListener(this);
        this.Cj.setOnTouchListener(new i(this));
        if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.dsz.getParent() != null) {
            ((View) this.dsz.getParent()).setFocusable(true);
            ((View) this.dsz.getParent()).setFocusableInTouchMode(true);
        }
        this.dxX = (LinearLayout) this.cZW.findViewById(r.g.invite_candidate);
        this.dxY = (Button) this.cZW.findViewById(r.g.button_send);
        this.dxY.setOnClickListener(new j(this));
        mx(0);
        this.gnr = (AtSelectFriendList) this.cZW.findViewById(r.g.candidate_list);
        this.gnr.setMaxCount(5);
        this.gnr.setItemOPerationHandler(new k(this));
        aAY();
    }

    private void WB() {
        this.mNavigationBar = (NavigationBar) findViewById(r.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new l(this));
        this.gny = this.mNavigationBar.setTitleText(getPageContext().getString(r.j.select_friend));
        this.dyd = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.add_new_friend_text, new m(this));
        this.dyf = (ImageView) this.dyd.findViewById(r.g.new_friend_search);
        this.dyc = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, r.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.dyc.setVisibility(8);
        this.dsz = (EditText) this.dyc.findViewById(r.g.search_bar_edit);
        this.dsz.addTextChangedListener(new com.baidu.tieba.write.write.b(this));
        this.dsz.setOnFocusChangeListener(new c(this));
        this.gnq = (TextView) findViewById(r.g.search_bar_delete_button);
        this.gnq.setOnClickListener(new d(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [469=4] */
    private void aAY() {
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
    public void td(String str) {
        if (!isFinishing()) {
            this.gnv.setData(null);
            if (this.gns != null) {
                this.gns.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.gnu.bvf() != null) {
                    ArrayList<MetaData> bvb = this.gnu.bvf().bvb();
                    Iterator<MetaData> it = bvb.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (bvb != null && !bvb.isEmpty()) {
                        tY(0);
                    } else {
                        tY(1);
                    }
                    this.gnv.setData(bvb);
                } else {
                    this.gnv.setData(null);
                    if (this.gnt == null) {
                        this.gnt = new b(this, null);
                        this.gnt.setPriority(3);
                        this.gnt.execute("");
                    }
                }
            } else {
                this.gns = new a(this, null);
                this.gns.setPriority(2);
                this.gns.execute(str);
                if (this.gnt == null && this.gnu.bvf() == null) {
                    this.gnt = new b(this, null);
                    this.gnt.setPriority(3);
                    this.gnt.execute("");
                }
            }
            this.gnv.notifyDataSetInvalidated();
            this.Cj.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.gnu = new com.baidu.tieba.write.c.a();
        if (bundle != null) {
            this.gnA = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
        } else {
            this.gnA = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MetaData metaData) {
        if (metaData != null) {
            this.gnr.d(metaData);
            mx(this.gnr.getItemLength());
            aAZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(MetaData metaData) {
        if (metaData != null) {
            this.gnr.f(metaData);
            mx(this.gnr.getItemLength());
            aAZ();
        }
    }

    private void aAZ() {
        if (this.gnr.getItemLength() > 0) {
            this.dxY.setEnabled(true);
        } else {
            this.dxY.setEnabled(false);
        }
    }

    private void mx(int i) {
        this.dxY.setText(String.format(getPageContext().getString(r.j.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.b> {
        private com.baidu.tbadk.core.util.z ajm;
        private String gnD;

        private a() {
            this.ajm = null;
            this.gnD = null;
        }

        /* synthetic */ a(AtListActivity atListActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.cub.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            AtListActivity.this.gns = null;
            this.gnD = null;
            AtListActivity.this.cub.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: K */
        public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
            this.gnD = strArr[0];
            this.ajm = new com.baidu.tbadk.core.util.z();
            if (this.gnD != null && this.gnD.length() > 0) {
                this.ajm.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/sug");
                this.ajm.n("uid", TbadkCoreApplication.getCurrentAccount());
                this.ajm.n("q", this.gnD);
                String uy = this.ajm.uy();
                if (this.ajm.uW().vS().oH()) {
                    com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
                    com.baidu.tieba.write.a.a bvf = AtListActivity.this.gnu.bvf();
                    if (bvf != null) {
                        bVar.c(uy, bvf.bvc());
                        return bVar;
                    }
                    bVar.c(uy, null);
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
            AtListActivity.this.gns = null;
            AtListActivity.this.cub.setVisibility(8);
            if (this.ajm.uW().vS().oH() && this.gnD != null && com.baidu.adp.lib.util.j.a(AtListActivity.this.dsz.getText(), "").equals(this.gnD)) {
                if (bVar == null || bVar.bvd().isEmpty()) {
                    AtListActivity.this.tY(1);
                } else {
                    AtListActivity.this.tY(0);
                }
                AtListActivity.this.gnu.a(bVar);
                AtListActivity.this.gnv.setData(bVar.bvd());
                AtListActivity.this.gnv.notifyDataSetInvalidated();
                AtListActivity.this.Cj.setSelection(0);
            } else {
                AtListActivity.this.showToast(this.ajm.getErrorString());
            }
            super.onPostExecute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.a> {
        private com.baidu.tbadk.core.util.z ajm;

        private b() {
            this.ajm = null;
        }

        /* synthetic */ b(AtListActivity atListActivity, b bVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AtListActivity.this.cub.setVisibility(0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.ajm != null) {
                this.ajm.eg();
            }
            AtListActivity.this.gnt = null;
            AtListActivity.this.cub.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: L */
        public com.baidu.tieba.write.a.a doInBackground(String... strArr) {
            this.ajm = new com.baidu.tbadk.core.util.z();
            this.ajm.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/list");
            String uy = this.ajm.uy();
            if (!this.ajm.uW().vS().oH()) {
                return null;
            }
            com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
            aVar.sU(uy);
            return aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tieba.write.a.a aVar) {
            AtListActivity.this.gnt = null;
            AtListActivity.this.cub.setVisibility(8);
            if (AtListActivity.this.dxX != null && AtListActivity.this.dxX.getVisibility() == 0) {
                AtListActivity.this.gnx.setVisibility(0);
            }
            if (this.ajm.uW().vS().oH()) {
                AtListActivity.this.gnu.a(aVar);
                if (AtListActivity.this.gnv != null) {
                    if (com.baidu.adp.lib.util.j.a(AtListActivity.this.dsz.getText(), "").length() != 0) {
                        if (AtListActivity.this.gnu.bvg() != null) {
                            if (aVar != null && aVar.bvc() != null && !aVar.bvc().isEmpty()) {
                                AtListActivity.this.tY(2);
                            }
                            AtListActivity.this.gnu.bvg().j(aVar.bvc());
                            AtListActivity.this.gnv.notifyDataSetInvalidated();
                        }
                    } else {
                        if (aVar == null || aVar.bvb() == null || !aVar.bvb().isEmpty()) {
                            AtListActivity.this.tY(0);
                        } else {
                            AtListActivity.this.tY(2);
                        }
                        AtListActivity.this.gnp = aVar.bvb();
                        AtListActivity.this.gnv.setData(AtListActivity.this.gnp);
                        AtListActivity.this.gnv.notifyDataSetInvalidated();
                        AtListActivity.this.Cj.setSelection(0);
                    }
                } else {
                    return;
                }
            } else {
                AtListActivity.this.showToast(this.ajm.getErrorString());
            }
            super.onPostExecute(aVar);
        }
    }

    @Override // com.baidu.tieba.write.write.n.b
    public void a(View view, MetaData metaData) {
        if (metaData != null) {
            this.gnr.e(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.Cj;
    }
}
