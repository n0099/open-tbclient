package com.baidu.tieba.plugins;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.tbplugin.PluginsConfig;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class PluginCenterActivity extends BaseActivity {
    private b a;
    private BdListView b;
    private NavigationBar c;
    private LinearLayout d;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    @SuppressLint({"WrongViewCast"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.plugin_center_activity);
        this.b = (BdListView) findViewById(v.list);
        this.d = (LinearLayout) findViewById(v.empty);
        this.c = (NavigationBar) findViewById(v.navigation_bar);
        this.c.a(y.plugin_center);
        this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.b.setEmptyView(this.d);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.a = new b(this);
        this.b.setAdapter((ListAdapter) this.a);
        this.b.setOnItemClickListener(this);
        com.baidu.tbadk.tbplugin.m.a().a(new a(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
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
