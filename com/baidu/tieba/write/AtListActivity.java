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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class AtListActivity extends BaseActivity implements AdapterView.OnItemClickListener, l {
    private LinearLayout OY;
    private LinearLayout aWa;
    private Button aWb;
    private View aWc;
    private com.baidu.tbadk.core.view.o ahO;
    private LinearLayout bSB;
    private ImageView bSC;
    private AtSelectFriendList bSt;
    private NavigationBar mNavigationBar;
    protected ArrayList<MetaData> bSr = new ArrayList<>();
    private EditText mEditText = null;
    private TextView bSs = null;
    private BdListView vl = null;
    private final Handler mHandler = new Handler();
    private h bSu = null;
    private i bSv = null;
    private com.baidu.tieba.model.c bSw = null;
    private j bSx = null;
    private String bSy = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private final int bSz = 5;
    private boolean bSA = true;
    private final Runnable bSD = new a(this);

    static {
        TbadkApplication.m251getInst().RegisterIntent(AtListActivityConfig.class, AtListActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.at_list_activity);
        d(bundle);
        initUI();
        hI(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().L(i == 1);
        getLayoutMode().h(this.mParent);
        if (this.ahO != null) {
            this.ahO.onChangeSkinType(i);
        }
        this.mNavigationBar.onChangeSkinType(i);
        this.bSx.notifyDataSetChanged();
        com.baidu.tbadk.core.util.aw.h(this.bSB, com.baidu.tieba.s.cp_bg_line_d);
        com.baidu.tbadk.core.util.aw.h(this.OY, com.baidu.tieba.u.inputbox_top);
        com.baidu.tbadk.core.util.aw.c(this.bSC, com.baidu.tieba.u.icon_head_bar_search);
        int color = com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.widget_searchbox_text);
        this.mEditText.setTextColor(color);
        this.mEditText.setHintTextColor(color);
        com.baidu.tbadk.core.util.aw.h((View) this.bSs, com.baidu.tieba.u.search_delete_button);
        com.baidu.tbadk.core.util.aw.h(this.aWc, com.baidu.tieba.u.invite_friend_list_item_bg_color);
        com.baidu.tbadk.core.util.aw.h((View) this.aWb, com.baidu.tieba.u.post_button_bg);
        com.baidu.tbadk.core.util.aw.b(this.aWb, com.baidu.tieba.s.post_button_text_color, 3);
        this.aWc.setEnabled(false);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.ahO.nv();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.ahO.onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eK(boolean z) {
        if (z) {
            this.vl.setVisibility(8);
            this.ahO.setVisibility(0);
            this.aWa.setVisibility(8);
            return;
        }
        this.vl.setVisibility(0);
        this.ahO.setVisibility(8);
        if (this.bSA) {
            this.aWa.setVisibility(0);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.bSx.getItem(i);
        if (item != null) {
            if (this.bSA) {
                if (this.bSu == null && this.bSv == null) {
                    if (item.isChecked()) {
                        c(item);
                    } else if (5 <= this.bSt.getItemLength()) {
                        showToast(String.format(getString(com.baidu.tieba.y.invite_friend_exceed_max_count), 5));
                        return;
                    } else {
                        b(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.bSx.notifyDataSetChanged();
                    return;
                }
                return;
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW, item.getName_show());
            bundle.putString(com.baidu.tbadk.core.frameworkData.a.USER_NAME, item.getUserName());
            bundle.putString(com.baidu.tbadk.core.frameworkData.a.USER_ID, item.getUserId());
            bundle.putString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT, item.getPortrait());
            intent.putExtras(bundle);
            com.baidu.adp.lib.util.m.b(this, this.mEditText);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.bSu != null) {
            this.bSu.cancel();
        }
        if (this.bSv != null) {
            this.bSv.cancel();
        }
        this.mHandler.removeCallbacks(this.bSD);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(com.baidu.tieba.v.parent);
        this.ahO = NoDataViewFactory.a(this, this.mParent, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.no_chat_friends), null);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
        this.mNavigationBar.setTitleText(getString(com.baidu.tieba.y.select_friend));
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.v.progress);
        this.bSB = (LinearLayout) findViewById(com.baidu.tieba.v.search);
        this.OY = (LinearLayout) findViewById(com.baidu.tieba.v.search_tap_text_layout);
        this.bSC = (ImageView) findViewById(com.baidu.tieba.v.at_search_logo);
        this.mEditText = (EditText) findViewById(com.baidu.tieba.v.at_search_edit);
        this.mEditText.addTextChangedListener(new c(this));
        this.bSs = (TextView) findViewById(com.baidu.tieba.v.at_search_del);
        this.bSs.setOnClickListener(new d(this));
        this.vl = (BdListView) findViewById(com.baidu.tieba.v.list);
        this.bSx = new j(this, this.bSA);
        this.bSx.a(this);
        this.bSx.a(new e(this));
        this.vl.setAdapter((ListAdapter) this.bSx);
        this.vl.setOnItemClickListener(this);
        if (!getIntent().getBooleanExtra(com.baidu.tbadk.core.frameworkData.a.SHOW_KEYBOARD, false) && this.mEditText.getParent() != null) {
            ((View) this.mEditText.getParent()).setFocusable(true);
            ((View) this.mEditText.getParent()).setFocusableInTouchMode(true);
        }
        this.aWa = (LinearLayout) this.mParent.findViewById(com.baidu.tieba.v.invite_candidate);
        this.aWb = (Button) this.mParent.findViewById(com.baidu.tieba.v.button_send);
        this.aWb.setOnClickListener(new f(this));
        fC(0);
        this.bSt = (AtSelectFriendList) this.mParent.findViewById(com.baidu.tieba.v.candidate_list);
        this.bSt.setMaxCount(5);
        this.bSt.setItemOPerationHandler(new g(this));
        Ng();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [412=4] */
    private void Ng() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_height) + getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_padding_bottom) + getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_padding_top);
        this.aWc = new View(this);
        this.aWc.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.vl.addFooterView(this.aWc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hI(String str) {
        if (!isFinishing()) {
            this.bSx.setData(null);
            if (this.bSu != null) {
                this.bSu.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.bSw.Tb() != null) {
                    ArrayList<MetaData> zd = this.bSw.Tb().zd();
                    Iterator<MetaData> it = zd.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    this.bSx.setData(zd);
                } else {
                    this.bSx.setData(null);
                    if (this.bSv == null) {
                        this.bSv = new i(this, null);
                        this.bSv.setPriority(3);
                        this.bSv.execute("");
                    }
                }
            } else {
                this.bSu = new h(this, null);
                this.bSu.setPriority(2);
                this.bSu.execute(str);
                if (this.bSv == null && this.bSw.Tb() == null) {
                    this.bSv = new i(this, null);
                    this.bSv.setPriority(3);
                    this.bSv.execute("");
                }
            }
            this.bSx.notifyDataSetInvalidated();
            this.vl.setSelection(0);
        }
    }

    private void d(Bundle bundle) {
        this.bSw = new com.baidu.tieba.model.c();
        if (bundle != null) {
            this.bSA = bundle.getBoolean(com.baidu.tbadk.core.frameworkData.a.IS_NEED_MULTIPLE);
        } else {
            this.bSA = getIntent().getBooleanExtra(com.baidu.tbadk.core.frameworkData.a.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MetaData metaData) {
        if (metaData != null) {
            this.bSt.d(metaData);
            fC(this.bSt.getItemLength());
            Nh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(MetaData metaData) {
        if (metaData != null) {
            this.bSt.f(metaData);
            fC(this.bSt.getItemLength());
            Nh();
        }
    }

    private void Nh() {
        if (this.bSt.getItemLength() > 0) {
            this.aWb.setEnabled(true);
        } else {
            this.aWb.setEnabled(false);
        }
    }

    private void fC(int i) {
        this.aWb.setText(String.format(getString(com.baidu.tieba.y.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    @Override // com.baidu.tieba.write.l
    public void a(View view, MetaData metaData) {
        if (metaData != null) {
            this.bSt.e(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.vl;
    }
}
