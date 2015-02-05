package com.baidu.tieba.write;

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
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class AtListActivity extends BaseActivity<AtListActivity> implements AdapterView.OnItemClickListener, l {
    private LinearLayout Vq;
    private LinearLayout bca;
    private Button bcb;
    private View bcc;
    private AtSelectFriendList cfm;
    private LinearLayout cfu;
    private ImageView cfv;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    protected ArrayList<MetaData> cfk = new ArrayList<>();
    private EditText mEditText = null;
    private TextView cfl = null;
    private BdListView mListView = null;
    private final Handler mHandler = new Handler();
    private h cfn = null;
    private i cfo = null;
    private com.baidu.tieba.model.c cfp = null;
    private j cfq = null;
    private String cfr = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private final int cfs = 5;
    private boolean cft = true;
    private final Runnable cfw = new a(this);

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(AtListActivityConfig.class, AtListActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.x.at_list_activity);
        initData(bundle);
        initUI();
        iA(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().h(this.mParent);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cfq.notifyDataSetChanged();
        com.baidu.tbadk.core.util.bc.i(this.cfu, com.baidu.tieba.t.cp_bg_line_d);
        com.baidu.tbadk.core.util.bc.i(this.Vq, com.baidu.tieba.v.inputbox_top);
        com.baidu.tbadk.core.util.bc.c(this.cfv, com.baidu.tieba.v.icon_head_bar_search);
        int color = com.baidu.tbadk.core.util.bc.getColor(com.baidu.tieba.t.widget_searchbox_text);
        this.mEditText.setTextColor(color);
        this.mEditText.setHintTextColor(color);
        com.baidu.tbadk.core.util.bc.i((View) this.cfl, com.baidu.tieba.v.search_delete_button);
        com.baidu.tbadk.core.util.bc.i(this.bcc, com.baidu.tieba.v.invite_friend_list_item_bg_color);
        com.baidu.tbadk.core.util.bc.i((View) this.bcb, com.baidu.tieba.v.post_button_bg);
        com.baidu.tbadk.core.util.bc.b(this.bcb, com.baidu.tieba.t.post_button_text_color, 3);
        this.bcc.setEnabled(false);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.mNoDataView.f(getPageContext());
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.mNoDataView.onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eO(boolean z) {
        if (z) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.bca.setVisibility(8);
            return;
        }
        this.mListView.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        if (this.cft) {
            this.bca.setVisibility(0);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.cfq.getItem(i);
        if (item != null) {
            if (this.cft) {
                if (this.cfn == null && this.cfo == null) {
                    if (item.isChecked()) {
                        c(item);
                    } else if (5 <= this.cfm.getItemLength()) {
                        showToast(String.format(getPageContext().getString(com.baidu.tieba.z.invite_friend_exceed_max_count), 5));
                        return;
                    } else {
                        b(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.cfq.notifyDataSetChanged();
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
            com.baidu.adp.lib.util.l.c(getPageContext().getPageActivity(), this.mEditText);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.cfn != null) {
            this.cfn.cancel();
        }
        if (this.cfo != null) {
            this.cfo.cancel();
        }
        this.mHandler.removeCallbacks(this.cfw);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(com.baidu.tieba.w.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.ab.cp(com.baidu.tieba.z.no_chat_friends), null);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
        this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.z.select_friend));
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.w.progress);
        this.cfu = (LinearLayout) findViewById(com.baidu.tieba.w.search);
        this.Vq = (LinearLayout) findViewById(com.baidu.tieba.w.search_tap_text_layout);
        this.cfv = (ImageView) findViewById(com.baidu.tieba.w.at_search_logo);
        this.mEditText = (EditText) findViewById(com.baidu.tieba.w.at_search_edit);
        this.mEditText.addTextChangedListener(new c(this));
        this.cfl = (TextView) findViewById(com.baidu.tieba.w.at_search_del);
        this.cfl.setOnClickListener(new d(this));
        this.mListView = (BdListView) findViewById(com.baidu.tieba.w.list);
        this.cfq = new j(this, this.cft);
        this.cfq.a(this);
        this.cfq.a(new e(this));
        this.mListView.setAdapter((ListAdapter) this.cfq);
        this.mListView.setOnItemClickListener(this);
        if (!getIntent().getBooleanExtra(com.baidu.tbadk.core.frameworkData.a.SHOW_KEYBOARD, false) && this.mEditText.getParent() != null) {
            ((View) this.mEditText.getParent()).setFocusable(true);
            ((View) this.mEditText.getParent()).setFocusableInTouchMode(true);
        }
        this.bca = (LinearLayout) this.mParent.findViewById(com.baidu.tieba.w.invite_candidate);
        this.bcb = (Button) this.mParent.findViewById(com.baidu.tieba.w.button_send);
        this.bcb.setOnClickListener(new f(this));
        fT(0);
        this.cfm = (AtSelectFriendList) this.mParent.findViewById(com.baidu.tieba.w.candidate_list);
        this.cfm.setMaxCount(5);
        this.cfm.setItemOPerationHandler(new g(this));
        OM();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [412=4] */
    private void OM() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(com.baidu.tieba.u.invite_friend_candidate_item_height) + getResources().getDimensionPixelSize(com.baidu.tieba.u.invite_friend_candidate_padding_bottom) + getResources().getDimensionPixelSize(com.baidu.tieba.u.invite_friend_candidate_padding_top);
        this.bcc = new View(getPageContext().getContext());
        this.bcc.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListView.addFooterView(this.bcc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iA(String str) {
        if (!isFinishing()) {
            this.cfq.s(null);
            if (this.cfn != null) {
                this.cfn.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.cfp.Uq() != null) {
                    ArrayList<MetaData> CK = this.cfp.Uq().CK();
                    Iterator<MetaData> it = CK.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    this.cfq.s(CK);
                } else {
                    this.cfq.s(null);
                    if (this.cfo == null) {
                        this.cfo = new i(this, null);
                        this.cfo.setPriority(3);
                        this.cfo.execute("");
                    }
                }
            } else {
                this.cfn = new h(this, null);
                this.cfn.setPriority(2);
                this.cfn.execute(str);
                if (this.cfo == null && this.cfp.Uq() == null) {
                    this.cfo = new i(this, null);
                    this.cfo.setPriority(3);
                    this.cfo.execute("");
                }
            }
            this.cfq.notifyDataSetInvalidated();
            this.mListView.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.cfp = new com.baidu.tieba.model.c();
        if (bundle != null) {
            this.cft = bundle.getBoolean(com.baidu.tbadk.core.frameworkData.a.IS_NEED_MULTIPLE);
        } else {
            this.cft = getIntent().getBooleanExtra(com.baidu.tbadk.core.frameworkData.a.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MetaData metaData) {
        if (metaData != null) {
            this.cfm.d(metaData);
            fT(this.cfm.getItemLength());
            ON();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(MetaData metaData) {
        if (metaData != null) {
            this.cfm.f(metaData);
            fT(this.cfm.getItemLength());
            ON();
        }
    }

    private void ON() {
        if (this.cfm.getItemLength() > 0) {
            this.bcb.setEnabled(true);
        } else {
            this.bcb.setEnabled(false);
        }
    }

    private void fT(int i) {
        this.bcb.setText(String.format(getPageContext().getString(com.baidu.tieba.z.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    @Override // com.baidu.tieba.write.l
    public void a(View view, MetaData metaData) {
        if (metaData != null) {
            this.cfm.e(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.mListView;
    }
}
