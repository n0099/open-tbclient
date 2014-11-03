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
import com.baidu.tbadk.core.util.bo;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class BarFolderFirstDirActivity extends BaseActivity {
    public static String bMj = "st_type";
    private c bMg;
    private b bMh;
    protected ViewGroup bMi;
    private NavigationBar mNavigationBar;
    private ProgressBar xM;
    protected ListView mList = null;
    private String stType = null;

    public static void b(Activity activity, String str) {
        Intent intent = new Intent(activity, BarFolderFirstDirActivity.class);
        intent.putExtra(bMj, str);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.bar_folder_dir_activity);
        initUI();
        m(bundle);
        adn();
        TiebaStatic.eventStat(this, "category_1", "enter");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bMg.notifyDataSetChanged();
    }

    protected void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(getResources().getString(com.baidu.tieba.y.bar_first_dir_name));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mList = (ListView) findViewById(com.baidu.tieba.v.list);
        this.bMg = new c(this, new f(), true);
        this.mList.setAdapter((ListAdapter) this.bMg);
        this.xM = (ProgressBar) findViewById(com.baidu.tieba.v.progress);
        this.bMi = (ViewGroup) findViewById(com.baidu.tieba.v.body_container);
        bo.n(this.bMi);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bMh != null) {
            this.bMh.cancel();
        }
        a(null, true);
    }

    protected void adn() {
        this.mList.setOnItemClickListener(new a(this));
    }

    protected void m(Bundle bundle) {
        if (bundle != null) {
            this.stType = bundle.getString(bMj);
        } else {
            this.stType = getIntent().getStringExtra(bMj);
        }
        this.xM.setVisibility(0);
        this.mList.setEnabled(false);
        if (this.bMh != null) {
            this.bMh.cancel();
        }
        this.bMh = new b(this, null);
        this.bMh.setPriority(3);
        this.bMh.execute("");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(f fVar, boolean z) {
        this.xM.setVisibility(8);
        this.mList.setEnabled(true);
        this.bMh = null;
        if (!z) {
            if (fVar.yq()) {
                showToast(fVar.getErrorMsg());
                return;
            }
            this.bMg.J(fVar.ado());
            this.mList.setVisibility(4);
            this.bMg.notifyDataSetChanged();
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
        if (this.bMi != null) {
            bo.a(this.bMi, i);
        }
        aw.e(findViewById(com.baidu.tieba.v.root_view), i);
    }
}
