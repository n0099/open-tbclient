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
    private LinearLayout UN;
    private LinearLayout baG;
    private Button baH;
    private View baI;
    private AtSelectFriendList cdO;
    private LinearLayout cdW;
    private ImageView cdX;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    protected ArrayList<MetaData> cdM = new ArrayList<>();
    private EditText mEditText = null;
    private TextView cdN = null;
    private BdListView mListView = null;
    private final Handler mHandler = new Handler();
    private h cdP = null;
    private i cdQ = null;
    private com.baidu.tieba.model.c cdR = null;
    private j cdS = null;
    private String cdT = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private final int cdU = 5;
    private boolean cdV = true;
    private final Runnable cdY = new a(this);

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
        iu(null);
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
        this.cdS.notifyDataSetChanged();
        com.baidu.tbadk.core.util.ax.i(this.cdW, com.baidu.tieba.t.cp_bg_line_d);
        com.baidu.tbadk.core.util.ax.i(this.UN, com.baidu.tieba.v.inputbox_top);
        com.baidu.tbadk.core.util.ax.c(this.cdX, com.baidu.tieba.v.icon_head_bar_search);
        int color = com.baidu.tbadk.core.util.ax.getColor(com.baidu.tieba.t.widget_searchbox_text);
        this.mEditText.setTextColor(color);
        this.mEditText.setHintTextColor(color);
        com.baidu.tbadk.core.util.ax.i((View) this.cdN, com.baidu.tieba.v.search_delete_button);
        com.baidu.tbadk.core.util.ax.i(this.baI, com.baidu.tieba.v.invite_friend_list_item_bg_color);
        com.baidu.tbadk.core.util.ax.i((View) this.baH, com.baidu.tieba.v.post_button_bg);
        com.baidu.tbadk.core.util.ax.b(this.baH, com.baidu.tieba.t.post_button_text_color, 3);
        this.baI.setEnabled(false);
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
    public void eJ(boolean z) {
        if (z) {
            this.mListView.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.baG.setVisibility(8);
            return;
        }
        this.mListView.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        if (this.cdV) {
            this.baG.setVisibility(0);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.cdS.getItem(i);
        if (item != null) {
            if (this.cdV) {
                if (this.cdP == null && this.cdQ == null) {
                    if (item.isChecked()) {
                        c(item);
                    } else if (5 <= this.cdO.getItemLength()) {
                        showToast(String.format(getPageContext().getString(com.baidu.tieba.z.invite_friend_exceed_max_count), 5));
                        return;
                    } else {
                        b(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.cdS.notifyDataSetChanged();
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
        if (this.cdP != null) {
            this.cdP.cancel();
        }
        if (this.cdQ != null) {
            this.cdQ.cancel();
        }
        this.mHandler.removeCallbacks(this.cdY);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(com.baidu.tieba.w.parent);
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getContext(), this.mParent, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.ab.ci(com.baidu.tieba.z.no_chat_friends), null);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
        this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.z.select_friend));
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.w.progress);
        this.cdW = (LinearLayout) findViewById(com.baidu.tieba.w.search);
        this.UN = (LinearLayout) findViewById(com.baidu.tieba.w.search_tap_text_layout);
        this.cdX = (ImageView) findViewById(com.baidu.tieba.w.at_search_logo);
        this.mEditText = (EditText) findViewById(com.baidu.tieba.w.at_search_edit);
        this.mEditText.addTextChangedListener(new c(this));
        this.cdN = (TextView) findViewById(com.baidu.tieba.w.at_search_del);
        this.cdN.setOnClickListener(new d(this));
        this.mListView = (BdListView) findViewById(com.baidu.tieba.w.list);
        this.cdS = new j(this, this.cdV);
        this.cdS.a(this);
        this.cdS.a(new e(this));
        this.mListView.setAdapter((ListAdapter) this.cdS);
        this.mListView.setOnItemClickListener(this);
        if (!getIntent().getBooleanExtra(com.baidu.tbadk.core.frameworkData.a.SHOW_KEYBOARD, false) && this.mEditText.getParent() != null) {
            ((View) this.mEditText.getParent()).setFocusable(true);
            ((View) this.mEditText.getParent()).setFocusableInTouchMode(true);
        }
        this.baG = (LinearLayout) this.mParent.findViewById(com.baidu.tieba.w.invite_candidate);
        this.baH = (Button) this.mParent.findViewById(com.baidu.tieba.w.button_send);
        this.baH.setOnClickListener(new f(this));
        fO(0);
        this.cdO = (AtSelectFriendList) this.mParent.findViewById(com.baidu.tieba.w.candidate_list);
        this.cdO.setMaxCount(5);
        this.cdO.setItemOPerationHandler(new g(this));
        Ov();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [412=4] */
    private void Ov() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(com.baidu.tieba.u.invite_friend_candidate_item_height) + getResources().getDimensionPixelSize(com.baidu.tieba.u.invite_friend_candidate_padding_bottom) + getResources().getDimensionPixelSize(com.baidu.tieba.u.invite_friend_candidate_padding_top);
        this.baI = new View(getPageContext().getContext());
        this.baI.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListView.addFooterView(this.baI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iu(String str) {
        if (!isFinishing()) {
            this.cdS.r(null);
            if (this.cdP != null) {
                this.cdP.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.cdR.TX() != null) {
                    ArrayList<MetaData> Cr = this.cdR.TX().Cr();
                    Iterator<MetaData> it = Cr.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    this.cdS.r(Cr);
                } else {
                    this.cdS.r(null);
                    if (this.cdQ == null) {
                        this.cdQ = new i(this, null);
                        this.cdQ.setPriority(3);
                        this.cdQ.execute("");
                    }
                }
            } else {
                this.cdP = new h(this, null);
                this.cdP.setPriority(2);
                this.cdP.execute(str);
                if (this.cdQ == null && this.cdR.TX() == null) {
                    this.cdQ = new i(this, null);
                    this.cdQ.setPriority(3);
                    this.cdQ.execute("");
                }
            }
            this.cdS.notifyDataSetInvalidated();
            this.mListView.setSelection(0);
        }
    }

    private void initData(Bundle bundle) {
        this.cdR = new com.baidu.tieba.model.c();
        if (bundle != null) {
            this.cdV = bundle.getBoolean(com.baidu.tbadk.core.frameworkData.a.IS_NEED_MULTIPLE);
        } else {
            this.cdV = getIntent().getBooleanExtra(com.baidu.tbadk.core.frameworkData.a.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MetaData metaData) {
        if (metaData != null) {
            this.cdO.d(metaData);
            fO(this.cdO.getItemLength());
            Ow();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(MetaData metaData) {
        if (metaData != null) {
            this.cdO.f(metaData);
            fO(this.cdO.getItemLength());
            Ow();
        }
    }

    private void Ow() {
        if (this.cdO.getItemLength() > 0) {
            this.baH.setEnabled(true);
        } else {
            this.baH.setEnabled(false);
        }
    }

    private void fO(int i) {
        this.baH.setText(String.format(getPageContext().getString(com.baidu.tieba.z.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    @Override // com.baidu.tieba.write.l
    public void a(View view, MetaData metaData) {
        if (metaData != null) {
            this.cdO.e(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.mListView;
    }
}
