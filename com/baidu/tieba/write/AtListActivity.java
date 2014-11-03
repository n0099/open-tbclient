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
    private LinearLayout Pc;
    private LinearLayout aWo;
    private Button aWp;
    private View aWq;
    private com.baidu.tbadk.core.view.o ahX;
    private AtSelectFriendList bSI;
    private LinearLayout bSQ;
    private ImageView bSR;
    private NavigationBar mNavigationBar;
    protected ArrayList<MetaData> bSG = new ArrayList<>();
    private EditText mEditText = null;
    private TextView bSH = null;
    private BdListView vl = null;
    private final Handler mHandler = new Handler();
    private h bSJ = null;
    private i bSK = null;
    private com.baidu.tieba.model.c bSL = null;
    private j bSM = null;
    private String bSN = null;
    private ProgressBar mProgress = null;
    private RelativeLayout mParent = null;
    private final int bSO = 5;
    private boolean bSP = true;
    private final Runnable bSS = new a(this);

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
        if (this.ahX != null) {
            this.ahX.onChangeSkinType(i);
        }
        this.mNavigationBar.onChangeSkinType(i);
        this.bSM.notifyDataSetChanged();
        com.baidu.tbadk.core.util.aw.h(this.bSQ, com.baidu.tieba.s.cp_bg_line_d);
        com.baidu.tbadk.core.util.aw.h(this.Pc, com.baidu.tieba.u.inputbox_top);
        com.baidu.tbadk.core.util.aw.c(this.bSR, com.baidu.tieba.u.icon_head_bar_search);
        int color = com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.widget_searchbox_text);
        this.mEditText.setTextColor(color);
        this.mEditText.setHintTextColor(color);
        com.baidu.tbadk.core.util.aw.h((View) this.bSH, com.baidu.tieba.u.search_delete_button);
        com.baidu.tbadk.core.util.aw.h(this.aWq, com.baidu.tieba.u.invite_friend_list_item_bg_color);
        com.baidu.tbadk.core.util.aw.h((View) this.aWp, com.baidu.tieba.u.post_button_bg);
        com.baidu.tbadk.core.util.aw.b(this.aWp, com.baidu.tieba.s.post_button_text_color, 3);
        this.aWq.setEnabled(false);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.ahX.nv();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.ahX.onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eK(boolean z) {
        if (z) {
            this.vl.setVisibility(8);
            this.ahX.setVisibility(0);
            this.aWo.setVisibility(8);
            return;
        }
        this.vl.setVisibility(0);
        this.ahX.setVisibility(8);
        if (this.bSP) {
            this.aWo.setVisibility(0);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        MetaData item = this.bSM.getItem(i);
        if (item != null) {
            if (this.bSP) {
                if (this.bSJ == null && this.bSK == null) {
                    if (item.isChecked()) {
                        c(item);
                    } else if (5 <= this.bSI.getItemLength()) {
                        showToast(String.format(getString(com.baidu.tieba.y.invite_friend_exceed_max_count), 5));
                        return;
                    } else {
                        b(item);
                    }
                    item.setChecked(item.isChecked() ? false : true);
                    this.bSM.notifyDataSetChanged();
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
        if (this.bSJ != null) {
            this.bSJ.cancel();
        }
        if (this.bSK != null) {
            this.bSK.cancel();
        }
        this.mHandler.removeCallbacks(this.bSS);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(com.baidu.tieba.v.parent);
        this.ahX = NoDataViewFactory.a(this, this.mParent, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.no_chat_friends), null);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new b(this));
        this.mNavigationBar.setTitleText(getString(com.baidu.tieba.y.select_friend));
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.v.progress);
        this.bSQ = (LinearLayout) findViewById(com.baidu.tieba.v.search);
        this.Pc = (LinearLayout) findViewById(com.baidu.tieba.v.search_tap_text_layout);
        this.bSR = (ImageView) findViewById(com.baidu.tieba.v.at_search_logo);
        this.mEditText = (EditText) findViewById(com.baidu.tieba.v.at_search_edit);
        this.mEditText.addTextChangedListener(new c(this));
        this.bSH = (TextView) findViewById(com.baidu.tieba.v.at_search_del);
        this.bSH.setOnClickListener(new d(this));
        this.vl = (BdListView) findViewById(com.baidu.tieba.v.list);
        this.bSM = new j(this, this.bSP);
        this.bSM.a(this);
        this.bSM.a(new e(this));
        this.vl.setAdapter((ListAdapter) this.bSM);
        this.vl.setOnItemClickListener(this);
        if (!getIntent().getBooleanExtra(com.baidu.tbadk.core.frameworkData.a.SHOW_KEYBOARD, false) && this.mEditText.getParent() != null) {
            ((View) this.mEditText.getParent()).setFocusable(true);
            ((View) this.mEditText.getParent()).setFocusableInTouchMode(true);
        }
        this.aWo = (LinearLayout) this.mParent.findViewById(com.baidu.tieba.v.invite_candidate);
        this.aWp = (Button) this.mParent.findViewById(com.baidu.tieba.v.button_send);
        this.aWp.setOnClickListener(new f(this));
        fC(0);
        this.bSI = (AtSelectFriendList) this.mParent.findViewById(com.baidu.tieba.v.candidate_list);
        this.bSI.setMaxCount(5);
        this.bSI.setItemOPerationHandler(new g(this));
        Nk();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [412=4] */
    private void Nk() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_height) + getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_padding_bottom) + getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_padding_top);
        this.aWq = new View(this);
        this.aWq.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.vl.addFooterView(this.aWq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hI(String str) {
        if (!isFinishing()) {
            this.bSM.setData(null);
            if (this.bSJ != null) {
                this.bSJ.cancel();
            }
            if (str == null || str.length() == 0) {
                if (this.bSL.Te() != null) {
                    ArrayList<MetaData> zf = this.bSL.Te().zf();
                    Iterator<MetaData> it = zf.iterator();
                    while (it.hasNext()) {
                        it.next().setChecked(false);
                    }
                    this.bSM.setData(zf);
                } else {
                    this.bSM.setData(null);
                    if (this.bSK == null) {
                        this.bSK = new i(this, null);
                        this.bSK.setPriority(3);
                        this.bSK.execute("");
                    }
                }
            } else {
                this.bSJ = new h(this, null);
                this.bSJ.setPriority(2);
                this.bSJ.execute(str);
                if (this.bSK == null && this.bSL.Te() == null) {
                    this.bSK = new i(this, null);
                    this.bSK.setPriority(3);
                    this.bSK.execute("");
                }
            }
            this.bSM.notifyDataSetInvalidated();
            this.vl.setSelection(0);
        }
    }

    private void d(Bundle bundle) {
        this.bSL = new com.baidu.tieba.model.c();
        if (bundle != null) {
            this.bSP = bundle.getBoolean(com.baidu.tbadk.core.frameworkData.a.IS_NEED_MULTIPLE);
        } else {
            this.bSP = getIntent().getBooleanExtra(com.baidu.tbadk.core.frameworkData.a.IS_NEED_MULTIPLE, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MetaData metaData) {
        if (metaData != null) {
            this.bSI.d(metaData);
            fC(this.bSI.getItemLength());
            Nl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(MetaData metaData) {
        if (metaData != null) {
            this.bSI.f(metaData);
            fC(this.bSI.getItemLength());
            Nl();
        }
    }

    private void Nl() {
        if (this.bSI.getItemLength() > 0) {
            this.aWp.setEnabled(true);
        } else {
            this.aWp.setEnabled(false);
        }
    }

    private void fC(int i) {
        this.aWp.setText(String.format(getString(com.baidu.tieba.y.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    @Override // com.baidu.tieba.write.l
    public void a(View view, MetaData metaData) {
        if (metaData != null) {
            this.bSI.e(metaData);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.vl;
    }
}
