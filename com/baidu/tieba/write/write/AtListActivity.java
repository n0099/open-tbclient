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
    private NoNetworkView aFX;
    private LinearLayout bvM;
    private Button bvN;
    private View bvO;
    private View bvS;
    private View bvT;
    private AtSelectFriendList cBh;
    private TextView cBo;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    protected ArrayList<MetaData> cBf = new ArrayList<>();
    private EditText mEditText = null;
    private TextView cBg = null;
    private BdListView mListView = null;
    private final Handler mHandler = new Handler();
    private m cBi = null;
    private n cBj = null;
    private com.baidu.tieba.write.b.a cBk = null;
    private o cBl = null;
    private String cBm = null;
    private ProgressBar mProgress = null;
    private RelativeLayout aZJ = null;
    private View cBn = null;
    private final int cBp = 5;
    private boolean cBq = true;
    private final Runnable cBr = new a(this);
    private com.baidu.tbadk.core.view.ad cBs = new e(this);

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
        getLayoutMode().j(this.aZJ);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aFX.onChangeSkinType(getPageContext(), i);
        this.cBl.notifyDataSetChanged();
        com.baidu.tbadk.core.util.ay.getColor(com.baidu.tieba.n.widget_searchbox_text);
        com.baidu.tbadk.core.util.ay.i(this.bvO, com.baidu.tieba.p.invite_friend_list_item_bg_color);
        com.baidu.tbadk.core.util.ay.i((View) this.bvN, com.baidu.tieba.p.post_button_bg);
        com.baidu.tbadk.core.util.ay.b(this.bvN, com.baidu.tieba.n.cp_cont_i, 3);
        this.bvO.setEnabled(false);
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
            this.bvM.setVisibility(8);
        } else if (i == 1) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.no_search_friends));
            this.bvM.setVisibility(8);
        } else if (i == 0) {
            this.mListView.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.cBq) {
                this.bvM.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.cBl.getItem(i);
        if (item != null) {
            if (this.cBq) {
                if (this.cBi == null && this.cBj == null) {
                    if (item.isChecked()) {
                        c(item);
                    } else if (5 <= this.cBh.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(com.baidu.tieba.t.invite_friend_exceed_max_count), 5), com.baidu.tieba.p.icon_toast_game_error);
                        return;
                    } else {
                        b(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.cBl.notifyDataSetChanged();
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
        if (this.cBi != null) {
            this.cBi.cancel();
        }
        if (this.cBj != null) {
            this.cBj.cancel();
        }
        this.mHandler.removeCallbacks(this.cBr);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.aZJ = (RelativeLayout) findViewById(com.baidu.tieba.q.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.aZJ, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.ab.cv(com.baidu.tieba.t.no_chat_friends), null);
        this.cBn = findViewById(com.baidu.tieba.q.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new f(this));
        MM();
        this.aFX = (NoNetworkView) findViewById(com.baidu.tieba.q.view_no_network);
        this.aFX.a(this.cBs);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.q.progress);
        this.mListView = (BdListView) findViewById(com.baidu.tieba.q.list);
        this.cBl = new o(this, this.cBq);
        this.cBl.a(this);
        this.cBl.setCheckBoxStateChangedListener(new g(this));
        this.mListView.setAdapter((ListAdapter) this.cBl);
        this.mListView.setOnItemClickListener(this);
        this.mListView.setOnTouchListener(new h(this));
        if (!getIntent().getBooleanExtra(com.baidu.tbadk.core.frameworkData.c.SHOW_KEYBOARD, false) && this.mEditText.getParent() != null) {
            ((View) this.mEditText.getParent()).setFocusable(true);
            ((View) this.mEditText.getParent()).setFocusableInTouchMode(true);
        }
        this.bvM = (LinearLayout) this.aZJ.findViewById(com.baidu.tieba.q.invite_candidate);
        this.bvN = (Button) this.aZJ.findViewById(com.baidu.tieba.q.button_send);
        this.bvN.setOnClickListener(new i(this));
        gU(0);
        this.cBh = (AtSelectFriendList) this.aZJ.findViewById(com.baidu.tieba.q.candidate_list);
        this.cBh.setMaxCount(5);
        this.cBh.setItemOPerationHandler(new j(this));
        Xi();
    }

    private void MM() {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new k(this));
        this.cBo = this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.t.select_friend));
        this.bvT = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.add_new_friend_text, new l(this));
        this.bvS = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, com.baidu.tieba.r.navigationbar_search_edit, (View.OnClickListener) null);
        this.bvS.setVisibility(8);
        this.mEditText = (EditText) this.bvS.findViewById(com.baidu.tieba.q.search_bar_edit);
        this.mEditText.addTextChangedListener(new b(this));
        this.mEditText.setOnFocusChangeListener(new c(this));
        this.cBg = (TextView) findViewById(com.baidu.tieba.q.search_bar_delete_button);
        this.cBg.setOnClickListener(new d(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [474=4] */
    private void Xi() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(com.baidu.tieba.o.invite_friend_candidate_item_height) + getResources().getDimensionPixelSize(com.baidu.tieba.o.invite_friend_candidate_padding_bottom) + getResources().getDimensionPixelSize(com.baidu.tieba.o.invite_friend_candidate_padding_top);
        this.bvO = new View(getPageContext().getContext());
        this.bvO.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListView.addFooterView(this.bvO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kc(String str) {
        if (!isFinishing()) {
            this.cBl.setData(null);
            if (this.cBi != null) {
                this.cBi.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.cBk.asm() != null) {
                    ArrayList<MetaData> asb = this.cBk.asm().asb();
                    Iterator<MetaData> it = asb.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (asb != null && !asb.isEmpty()) {
                        jA(0);
                    } else {
                        jA(1);
                    }
                    this.cBl.setData(asb);
                } else {
                    this.cBl.setData(null);
                    if (this.cBj == null) {
                        this.cBj = new n(this, null);
                        this.cBj.setPriority(3);
                        this.cBj.execute("");
                    }
                }
            } else {
                this.cBi = new m(this, null);
                this.cBi.setPriority(2);
                this.cBi.execute(str);
                if (this.cBj == null && this.cBk.asm() == null) {
                    this.cBj = new n(this, null);
                    this.cBj.setPriority(3);
                    this.cBj.execute("");
                }
            }
            this.cBl.notifyDataSetInvalidated();
            this.mListView.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.cBk = new com.baidu.tieba.write.b.a();
        if (bundle != null) {
            this.cBq = bundle.getBoolean(com.baidu.tbadk.core.frameworkData.c.IS_NEED_MULTIPLE);
        } else {
            this.cBq = getIntent().getBooleanExtra(com.baidu.tbadk.core.frameworkData.c.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MetaData metaData) {
        if (metaData != null) {
            this.cBh.d(metaData);
            gU(this.cBh.getItemLength());
            Xj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(MetaData metaData) {
        if (metaData != null) {
            this.cBh.f(metaData);
            gU(this.cBh.getItemLength());
            Xj();
        }
    }

    private void Xj() {
        if (this.cBh.getItemLength() > 0) {
            this.bvN.setEnabled(true);
        } else {
            this.bvN.setEnabled(false);
        }
    }

    private void gU(int i) {
        this.bvN.setText(String.format(getPageContext().getString(com.baidu.tieba.t.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    @Override // com.baidu.tieba.write.write.q
    public void a(View view, MetaData metaData) {
        if (metaData != null) {
            this.cBh.e(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.mListView;
    }
}
