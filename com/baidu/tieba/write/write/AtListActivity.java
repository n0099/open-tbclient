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
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class AtListActivity extends BaseActivity<AtListActivity> implements AdapterView.OnItemClickListener, q {
    private NoNetworkView aFY;
    private LinearLayout bvN;
    private Button bvO;
    private View bvP;
    private View bvT;
    private View bvU;
    private AtSelectFriendList cBi;
    private TextView cBp;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    protected ArrayList<MetaData> cBg = new ArrayList<>();
    private EditText mEditText = null;
    private TextView cBh = null;
    private BdListView mListView = null;
    private final Handler mHandler = new Handler();
    private m cBj = null;
    private n cBk = null;
    private com.baidu.tieba.write.b.a cBl = null;
    private o cBm = null;
    private String cBn = null;
    private ProgressBar mProgress = null;
    private RelativeLayout aZK = null;
    private View cBo = null;
    private final int cBq = 5;
    private boolean cBr = true;
    private final Runnable cBs = new a(this);
    private com.baidu.tbadk.core.view.ad cBt = new e(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.r.at_list_activity);
        initData(bundle);
        initUI();
        kc(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().j(this.aZK);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aFY.onChangeSkinType(getPageContext(), i);
        this.cBm.notifyDataSetChanged();
        com.baidu.tbadk.core.util.ay.getColor(com.baidu.tieba.n.widget_searchbox_text);
        com.baidu.tbadk.core.util.ay.i(this.bvP, com.baidu.tieba.p.invite_friend_list_item_bg_color);
        com.baidu.tbadk.core.util.ay.i((View) this.bvO, com.baidu.tieba.p.post_button_bg);
        com.baidu.tbadk.core.util.ay.b(this.bvO, com.baidu.tieba.n.cp_cont_i, 3);
        this.bvP.setEnabled(false);
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
    public void jA(int i) {
        if (i == 2) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.no_chat_friends));
            this.bvN.setVisibility(8);
        } else if (i == 1) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.no_search_friends));
            this.bvN.setVisibility(8);
        } else if (i == 0) {
            this.mListView.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.cBr) {
                this.bvN.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.cBm.getItem(i);
        if (item != null) {
            if (this.cBr) {
                if (this.cBj == null && this.cBk == null) {
                    if (item.isChecked()) {
                        c(item);
                    } else if (5 <= this.cBi.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(com.baidu.tieba.t.invite_friend_exceed_max_count), 5), com.baidu.tieba.p.icon_toast_game_error);
                        return;
                    } else {
                        b(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.cBm.notifyDataSetChanged();
                    return;
                }
                return;
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString(com.baidu.tbadk.core.frameworkData.c.NAME_SHOW, item.getName_show());
            bundle.putString("user_name", item.getUserName());
            bundle.putString("user_id", item.getUserId());
            bundle.putString(com.baidu.tbadk.core.frameworkData.c.PORTRAIT, item.getPortrait());
            intent.putExtras(bundle);
            com.baidu.adp.lib.util.n.c(getPageContext().getPageActivity(), this.mEditText);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.cBj != null) {
            this.cBj.cancel();
        }
        if (this.cBk != null) {
            this.cBk.cancel();
        }
        this.mHandler.removeCallbacks(this.cBs);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.aZK = (RelativeLayout) findViewById(com.baidu.tieba.q.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.aZK, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.no_chat_friends), null);
        this.cBo = findViewById(com.baidu.tieba.q.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new f(this));
        MN();
        this.aFY = (NoNetworkView) findViewById(com.baidu.tieba.q.view_no_network);
        this.aFY.a(this.cBt);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.q.progress);
        this.mListView = (BdListView) findViewById(com.baidu.tieba.q.list);
        this.cBm = new o(this, this.cBr);
        this.cBm.a(this);
        this.cBm.setCheckBoxStateChangedListener(new g(this));
        this.mListView.setAdapter((ListAdapter) this.cBm);
        this.mListView.setOnItemClickListener(this);
        this.mListView.setOnTouchListener(new h(this));
        if (!getIntent().getBooleanExtra(com.baidu.tbadk.core.frameworkData.c.SHOW_KEYBOARD, false) && this.mEditText.getParent() != null) {
            ((View) this.mEditText.getParent()).setFocusable(true);
            ((View) this.mEditText.getParent()).setFocusableInTouchMode(true);
        }
        this.bvN = (LinearLayout) this.aZK.findViewById(com.baidu.tieba.q.invite_candidate);
        this.bvO = (Button) this.aZK.findViewById(com.baidu.tieba.q.button_send);
        this.bvO.setOnClickListener(new i(this));
        gU(0);
        this.cBi = (AtSelectFriendList) this.aZK.findViewById(com.baidu.tieba.q.candidate_list);
        this.cBi.setMaxCount(5);
        this.cBi.setItemOPerationHandler(new j(this));
        Xj();
    }

    private void MN() {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new k(this));
        this.cBp = this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.t.select_friend));
        this.bvU = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.add_new_friend_text, new l(this));
        this.bvT = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, com.baidu.tieba.r.navigationbar_search_edit, (View.OnClickListener) null);
        this.bvT.setVisibility(8);
        this.mEditText = (EditText) this.bvT.findViewById(com.baidu.tieba.q.search_bar_edit);
        this.mEditText.addTextChangedListener(new b(this));
        this.mEditText.setOnFocusChangeListener(new c(this));
        this.cBh = (TextView) findViewById(com.baidu.tieba.q.search_bar_delete_button);
        this.cBh.setOnClickListener(new d(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [474=4] */
    private void Xj() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(com.baidu.tieba.o.invite_friend_candidate_item_height) + getResources().getDimensionPixelSize(com.baidu.tieba.o.invite_friend_candidate_padding_bottom) + getResources().getDimensionPixelSize(com.baidu.tieba.o.invite_friend_candidate_padding_top);
        this.bvP = new View(getPageContext().getContext());
        this.bvP.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListView.addFooterView(this.bvP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kc(String str) {
        if (!isFinishing()) {
            this.cBm.setData(null);
            if (this.cBj != null) {
                this.cBj.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.cBl.asn() != null) {
                    ArrayList<MetaData> asc = this.cBl.asn().asc();
                    Iterator<MetaData> it = asc.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (asc != null && !asc.isEmpty()) {
                        jA(0);
                    } else {
                        jA(1);
                    }
                    this.cBm.setData(asc);
                } else {
                    this.cBm.setData(null);
                    if (this.cBk == null) {
                        this.cBk = new n(this, null);
                        this.cBk.setPriority(3);
                        this.cBk.execute("");
                    }
                }
            } else {
                this.cBj = new m(this, null);
                this.cBj.setPriority(2);
                this.cBj.execute(str);
                if (this.cBk == null && this.cBl.asn() == null) {
                    this.cBk = new n(this, null);
                    this.cBk.setPriority(3);
                    this.cBk.execute("");
                }
            }
            this.cBm.notifyDataSetInvalidated();
            this.mListView.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.cBl = new com.baidu.tieba.write.b.a();
        if (bundle != null) {
            this.cBr = bundle.getBoolean(com.baidu.tbadk.core.frameworkData.c.IS_NEED_MULTIPLE);
        } else {
            this.cBr = getIntent().getBooleanExtra(com.baidu.tbadk.core.frameworkData.c.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MetaData metaData) {
        if (metaData != null) {
            this.cBi.d(metaData);
            gU(this.cBi.getItemLength());
            Xk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(MetaData metaData) {
        if (metaData != null) {
            this.cBi.f(metaData);
            gU(this.cBi.getItemLength());
            Xk();
        }
    }

    private void Xk() {
        if (this.cBi.getItemLength() > 0) {
            this.bvO.setEnabled(true);
        } else {
            this.bvO.setEnabled(false);
        }
    }

    private void gU(int i) {
        this.bvO.setText(String.format(getPageContext().getString(com.baidu.tieba.t.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    @Override // com.baidu.tieba.write.write.q
    public void a(View view, MetaData metaData) {
        if (metaData != null) {
            this.cBi.e(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.mListView;
    }
}
