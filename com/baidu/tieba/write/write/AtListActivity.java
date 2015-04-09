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
    private LinearLayout btc;
    private Button btd;
    private View bte;
    private View bti;
    private View btj;
    private AtSelectFriendList cwQ;
    private TextView cwX;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.s mNoDataView;
    protected ArrayList<MetaData> cwO = new ArrayList<>();
    private EditText mEditText = null;
    private TextView cwP = null;
    private BdListView mListView = null;
    private final Handler mHandler = new Handler();
    private l cwR = null;
    private m cwS = null;
    private com.baidu.tieba.write.b.a cwT = null;
    private n cwU = null;
    private String cwV = null;
    private ProgressBar mProgress = null;
    private RelativeLayout aXd = null;
    private View cwW = null;
    private final int cwY = 5;
    private boolean cwZ = true;
    private final Runnable cxa = new a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.at_list_activity);
        initData(bundle);
        initUI();
        jj(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().X(i == 1);
        getLayoutMode().h(this.aXd);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cwU.notifyDataSetChanged();
        com.baidu.tbadk.core.util.ba.getColor(com.baidu.tieba.s.widget_searchbox_text);
        com.baidu.tbadk.core.util.ba.i(this.bte, com.baidu.tieba.u.invite_friend_list_item_bg_color);
        com.baidu.tbadk.core.util.ba.i((View) this.btd, com.baidu.tieba.u.post_button_bg);
        com.baidu.tbadk.core.util.ba.b(this.btd, com.baidu.tieba.s.cp_cont_i, 3);
        this.bte.setEnabled(false);
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
    public void je(int i) {
        if (i == 2) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.no_chat_friends));
            this.btc.setVisibility(8);
        } else if (i == 1) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.no_search_friends));
            this.btc.setVisibility(8);
        } else if (i == 0) {
            this.mListView.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.cwZ) {
                this.btc.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.cwU.getItem(i);
        if (item != null) {
            if (this.cwZ) {
                if (this.cwR == null && this.cwS == null) {
                    if (item.isChecked()) {
                        c(item);
                    } else if (5 <= this.cwQ.getItemLength()) {
                        showToastWithIcon(String.format(getPageContext().getString(com.baidu.tieba.y.invite_friend_exceed_max_count), 5), com.baidu.tieba.u.icon_toast_game_error);
                        return;
                    } else {
                        b(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.cwU.notifyDataSetChanged();
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
        if (this.cwR != null) {
            this.cwR.cancel();
        }
        if (this.cwS != null) {
            this.cwS.cancel();
        }
        this.mHandler.removeCallbacks(this.cxa);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.aXd = (RelativeLayout) findViewById(com.baidu.tieba.v.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.aXd, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.w.cq(com.baidu.tieba.y.no_chat_friends), null);
        this.cwW = findViewById(com.baidu.tieba.v.at_candidate_border);
        this.mNoDataView.setOnTouchListener(new d(this));
        LH();
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.v.progress);
        this.mListView = (BdListView) findViewById(com.baidu.tieba.v.list);
        this.cwU = new n(this, this.cwZ);
        this.cwU.a(this);
        this.cwU.a(new e(this));
        this.mListView.setAdapter((ListAdapter) this.cwU);
        this.mListView.setOnItemClickListener(this);
        this.mListView.setOnTouchListener(new f(this));
        if (!getIntent().getBooleanExtra(com.baidu.tbadk.core.frameworkData.a.SHOW_KEYBOARD, false) && this.mEditText.getParent() != null) {
            ((View) this.mEditText.getParent()).setFocusable(true);
            ((View) this.mEditText.getParent()).setFocusableInTouchMode(true);
        }
        this.btc = (LinearLayout) this.aXd.findViewById(com.baidu.tieba.v.invite_candidate);
        this.btd = (Button) this.aXd.findViewById(com.baidu.tieba.v.button_send);
        this.btd.setOnClickListener(new g(this));
        gD(0);
        this.cwQ = (AtSelectFriendList) this.aXd.findViewById(com.baidu.tieba.v.candidate_list);
        this.cwQ.setMaxCount(5);
        this.cwQ.setItemOPerationHandler(new h(this));
        VQ();
    }

    private void LH() {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new i(this));
        this.cwX = this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.y.select_friend));
        this.btj = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.add_new_friend_text, new j(this));
        this.bti = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, com.baidu.tieba.w.navigationbar_search_edit, (View.OnClickListener) null);
        this.bti.setVisibility(8);
        this.mEditText = (EditText) this.bti.findViewById(com.baidu.tieba.v.search_bar_edit);
        this.mEditText.addTextChangedListener(new k(this));
        this.mEditText.setOnFocusChangeListener(new b(this));
        this.cwP = (TextView) findViewById(com.baidu.tieba.v.search_bar_delete_button);
        this.cwP.setOnClickListener(new c(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [458=4] */
    private void VQ() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_height) + getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_padding_bottom) + getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_padding_top);
        this.bte = new View(getPageContext().getContext());
        this.bte.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListView.addFooterView(this.bte);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jj(String str) {
        if (!isFinishing()) {
            this.cwU.p(null);
            if (this.cwR != null) {
                this.cwR.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.cwT.aqw() != null) {
                    ArrayList<MetaData> aql = this.cwT.aqw().aql();
                    Iterator<MetaData> it = aql.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    if (aql != null && !aql.isEmpty()) {
                        je(0);
                    } else {
                        je(1);
                    }
                    this.cwU.p(aql);
                } else {
                    this.cwU.p(null);
                    if (this.cwS == null) {
                        this.cwS = new m(this, null);
                        this.cwS.setPriority(3);
                        this.cwS.execute("");
                    }
                }
            } else {
                this.cwR = new l(this, null);
                this.cwR.setPriority(2);
                this.cwR.execute(str);
                if (this.cwS == null && this.cwT.aqw() == null) {
                    this.cwS = new m(this, null);
                    this.cwS.setPriority(3);
                    this.cwS.execute("");
                }
            }
            this.cwU.notifyDataSetInvalidated();
            this.mListView.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.cwT = new com.baidu.tieba.write.b.a();
        if (bundle != null) {
            this.cwZ = bundle.getBoolean(com.baidu.tbadk.core.frameworkData.a.IS_NEED_MULTIPLE);
        } else {
            this.cwZ = getIntent().getBooleanExtra(com.baidu.tbadk.core.frameworkData.a.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MetaData metaData) {
        if (metaData != null) {
            this.cwQ.d(metaData);
            gD(this.cwQ.getItemLength());
            VR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(MetaData metaData) {
        if (metaData != null) {
            this.cwQ.f(metaData);
            gD(this.cwQ.getItemLength());
            VR();
        }
    }

    private void VR() {
        if (this.cwQ.getItemLength() > 0) {
            this.btd.setEnabled(true);
        } else {
            this.btd.setEnabled(false);
        }
    }

    private void gD(int i) {
        this.btd.setText(String.format(getPageContext().getString(com.baidu.tieba.y.at_friend_candidate_send), Integer.valueOf(i), 5));
    }

    @Override // com.baidu.tieba.write.write.p
    public void a(View view, MetaData metaData) {
        if (metaData != null) {
            this.cwQ.e(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.mListView;
    }
}
