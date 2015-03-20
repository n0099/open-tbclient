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
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class AtListActivity extends BaseActivity<AtListActivity> implements AdapterView.OnItemClickListener, p {
    private LinearLayout bsM;
    private Button bsN;
    private View bsO;
    private View bsS;
    private View bsT;
    private TextView cwE;
    private AtSelectFriendList cwx;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.s mNoDataView;
    protected ArrayList<MetaData> cwv = new ArrayList<>();
    private EditText mEditText = null;
    private TextView cww = null;
    private BdListView mListView = null;
    private final Handler mHandler = new Handler();
    private l cwy = null;
    private m cwz = null;
    private com.baidu.tieba.write.b.a cwA = null;
    private n cwB = null;
    private String cwC = null;
    private ProgressBar mProgress = null;
    private RelativeLayout aWN = null;
    private View cwD = null;
    private final int cwF = 5;
    private boolean cwG = true;
    private final Runnable cwH = new a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.at_list_activity);
        initData(bundle);
        initUI();
        jg(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().X(i == 1);
        getLayoutMode().h(this.aWN);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cwB.notifyDataSetChanged();
        com.baidu.tbadk.core.util.ba.getColor(com.baidu.tieba.s.widget_searchbox_text);
        com.baidu.tbadk.core.util.ba.i(this.bsO, com.baidu.tieba.u.invite_friend_list_item_bg_color);
        com.baidu.tbadk.core.util.ba.i((View) this.bsN, com.baidu.tieba.u.post_button_bg);
        com.baidu.tbadk.core.util.ba.b(this.bsN, com.baidu.tieba.s.cp_cont_i, 3);
        this.bsO.setEnabled(false);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.mNoDataView.e(getPageContext());
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.mNoDataView.onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jb(int i) {
        if (i == 2) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.no_chat_friends));
            this.bsM.setVisibility(8);
        } else if (i == 1) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.no_search_friends));
            this.bsM.setVisibility(8);
        } else if (i == 0) {
            this.mListView.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.cwG) {
                this.bsM.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.cwB.getItem(i);
        if (item != null) {
            if (this.cwG) {
                if (this.cwy == null && this.cwz == null) {
                    if (item.isChecked()) {
                        c(item);
                    } else if (5 <= this.cwx.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(com.baidu.tieba.y.invite_friend_exceed_max_count), 5), com.baidu.tieba.u.icon_toast_game_error);
                        return;
                    } else {
                        b(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.cwB.notifyDataSetChanged();
                    return;
                }
                return;
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW, item.getName_show());
            bundle.putString("user_name", item.getUserName());
            bundle.putString("user_id", item.getUserId());
            bundle.putString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT, item.getPortrait());
            intent.putExtras(bundle);
            com.baidu.adp.lib.util.n.c(getPageContext().getPageActivity(), this.mEditText);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.cwy != null) {
            this.cwy.cancel();
        }
        if (this.cwz != null) {
            this.cwz.cancel();
        }
        this.mHandler.removeCallbacks(this.cwH);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.aWN = (RelativeLayout) findViewById(com.baidu.tieba.v.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.aWN, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.no_chat_friends), null);
        this.cwD = findViewById(com.baidu.tieba.v.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new d(this));
        Lv();
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.v.progress);
        this.mListView = (BdListView) findViewById(com.baidu.tieba.v.list);
        this.cwB = new n(this, this.cwG);
        this.cwB.a(this);
        this.cwB.a(new e(this));
        this.mListView.setAdapter((ListAdapter) this.cwB);
        this.mListView.setOnItemClickListener(this);
        this.mListView.setOnTouchListener(new f(this));
        if (!getIntent().getBooleanExtra(com.baidu.tbadk.core.frameworkData.a.SHOW_KEYBOARD, false) && this.mEditText.getParent() != null) {
            ((View) this.mEditText.getParent()).setFocusable(true);
            ((View) this.mEditText.getParent()).setFocusableInTouchMode(true);
        }
        this.bsM = (LinearLayout) this.aWN.findViewById(com.baidu.tieba.v.invite_candidate);
        this.bsN = (Button) this.aWN.findViewById(com.baidu.tieba.v.button_send);
        this.bsN.setOnClickListener(new g(this));
        gB(0);
        this.cwx = (AtSelectFriendList) this.aWN.findViewById(com.baidu.tieba.v.candidate_list);
        this.cwx.setMaxCount(5);
        this.cwx.setItemOPerationHandler(new h(this));
        VD();
    }

    private void Lv() {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new i(this));
        this.cwE = this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.y.select_friend));
        this.bsT = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.add_new_friend_text, new j(this));
        this.bsS = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, com.baidu.tieba.w.navigationbar_search_edit, (View.OnClickListener) null);
        this.bsS.setVisibility(8);
        this.mEditText = (EditText) this.bsS.findViewById(com.baidu.tieba.v.search_bar_edit);
        this.mEditText.addTextChangedListener(new k(this));
        this.mEditText.setOnFocusChangeListener(new b(this));
        this.cww = (TextView) findViewById(com.baidu.tieba.v.search_bar_delete_button);
        this.cww.setOnClickListener(new c(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [458=4] */
    private void VD() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_height) + getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_padding_bottom) + getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_padding_top);
        this.bsO = new View(getPageContext().getContext());
        this.bsO.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListView.addFooterView(this.bsO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jg(String str) {
        if (!isFinishing()) {
            this.cwB.p(null);
            if (this.cwy != null) {
                this.cwy.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.cwA.aqh() != null) {
                    ArrayList<MetaData> apW = this.cwA.aqh().apW();
                    Iterator<MetaData> it = apW.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (apW != null && !apW.isEmpty()) {
                        jb(0);
                    } else {
                        jb(1);
                    }
                    this.cwB.p(apW);
                } else {
                    this.cwB.p(null);
                    if (this.cwz == null) {
                        this.cwz = new m(this, null);
                        this.cwz.setPriority(3);
                        this.cwz.execute("");
                    }
                }
            } else {
                this.cwy = new l(this, null);
                this.cwy.setPriority(2);
                this.cwy.execute(str);
                if (this.cwz == null && this.cwA.aqh() == null) {
                    this.cwz = new m(this, null);
                    this.cwz.setPriority(3);
                    this.cwz.execute("");
                }
            }
            this.cwB.notifyDataSetInvalidated();
            this.mListView.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.cwA = new com.baidu.tieba.write.b.a();
        if (bundle != null) {
            this.cwG = bundle.getBoolean(com.baidu.tbadk.core.frameworkData.a.IS_NEED_MULTIPLE);
        } else {
            this.cwG = getIntent().getBooleanExtra(com.baidu.tbadk.core.frameworkData.a.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MetaData metaData) {
        if (metaData != null) {
            this.cwx.d(metaData);
            gB(this.cwx.getItemLength());
            VE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(MetaData metaData) {
        if (metaData != null) {
            this.cwx.f(metaData);
            gB(this.cwx.getItemLength());
            VE();
        }
    }

    private void VE() {
        if (this.cwx.getItemLength() > 0) {
            this.bsN.setEnabled(true);
        } else {
            this.bsN.setEnabled(false);
        }
    }

    private void gB(int i) {
        this.bsN.setText(String.format(getPageContext().getString(com.baidu.tieba.y.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    @Override // com.baidu.tieba.write.write.p
    public void a(View view, MetaData metaData) {
        if (metaData != null) {
            this.cwx.e(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.mListView;
    }
}
