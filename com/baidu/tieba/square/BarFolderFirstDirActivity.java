package com.baidu.tieba.square;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class BarFolderFirstDirActivity extends BaseActivity {
    public static String bLU = "st_type";
    private c bLR;
    private b bLS;
    protected ViewGroup bLT;
    private NavigationBar mNavigationBar;
    private ProgressBar xM;
    protected ListView mList = null;
    private String stType = null;

    public static void b(Activity activity, String str) {
        Intent intent = new Intent(activity, BarFolderFirstDirActivity.class);
        intent.putExtra(bLU, str);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.bar_folder_dir_activity);
        initUI();
        m(bundle);
        adk();
        TiebaStatic.eventStat(this, "category_1", "enter");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bLR.notifyDataSetChanged();
    }

    protected void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(getResources().getString(com.baidu.tieba.y.bar_first_dir_name));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mList = (ListView) findViewById(com.baidu.tieba.v.list);
        this.bLR = new c(this, new f(), true);
        this.mList.setAdapter((ListAdapter) this.bLR);
        this.xM = (ProgressBar) findViewById(com.baidu.tieba.v.progress);
        this.bLT = (ViewGroup) findViewById(com.baidu.tieba.v.body_container);
        bn.n(this.bLT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bLS != null) {
            this.bLS.cancel();
        }
        a(null, true);
    }

    protected void adk() {
        this.mList.setOnItemClickListener(new a(this));
    }

    protected void m(Bundle bundle) {
        if (bundle != null) {
            this.stType = bundle.getString(bLU);
        } else {
            this.stType = getIntent().getStringExtra(bLU);
        }
        this.xM.setVisibility(0);
        this.mList.setEnabled(false);
        if (this.bLS != null) {
            this.bLS.cancel();
        }
        this.bLS = new b(this, null);
        this.bLS.setPriority(3);
        this.bLS.execute("");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(f fVar, boolean z) {
        this.xM.setVisibility(8);
        this.mList.setEnabled(true);
        this.bLS = null;
        if (!z) {
            if (fVar.yo()) {
                showToast(fVar.getErrorMsg());
                return;
            }
            this.bLR.I(fVar.adl());
            this.mList.setVisibility(4);
            this.bLR.notifyDataSetChanged();
            this.mList.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(i);
        if (this.mList != null) {
            this.mList.invalidateViews();
        }
        if (this.bLT != null) {
            bn.a(this.bLT, i);
        }
        aw.e(findViewById(com.baidu.tieba.v.root_view), i);
    }
}
