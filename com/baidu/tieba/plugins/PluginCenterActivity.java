package com.baidu.tieba.plugins;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortool.ab;
import com.baidu.tbadk.tbplugin.PluginsConfig;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class PluginCenterActivity extends BaseActivity {
    private c a;
    private BdListView b;
    private NavigationBar c;
    private LinearLayout d;
    private ab e;
    private Handler f = new Handler();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    @SuppressLint({"WrongViewCast"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.s.plugin_center_activity);
        this.b = (BdListView) findViewById(com.baidu.tieba.r.list);
        this.d = (LinearLayout) findViewById(com.baidu.tieba.r.empty);
        this.c = (NavigationBar) findViewById(com.baidu.tieba.r.navigation_bar);
        this.c.a(u.plugin_center);
        this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.b.setEmptyView(this.d);
        this.e = new ab(this);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.a = new c(this);
        this.b.setAdapter((ListAdapter) this.a);
        this.b.setOnItemClickListener(this);
        com.baidu.tbadk.tbplugin.m.a().a(new a(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f.postDelayed(new b(this), 300L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.c.c(i);
        this.a.notifyDataSetChanged();
        getLayoutMode().a(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        PluginDetailActivity.a(this, ((PluginsConfig.PluginConfig) this.a.getItem(i)).name);
    }
}
