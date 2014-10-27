package com.baidu.tieba.plugins;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.o;
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.core.view.s;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.Iterator;
/* loaded from: classes.dex */
public class PluginCenterActivity extends BaseActivity {
    private o ahO;
    private a bGG;
    private NavigationBar mNavigationBar;
    private BdListView vl;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.plugin_center_activity);
        this.vl = (BdListView) findViewById(v.list);
        this.mNavigationBar = (NavigationBar) findViewById(v.navigation_bar);
        this.mNavigationBar.setTitleText(y.plugin_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ahO = NoDataViewFactory.a(this, findViewById(v.list_layout), r.a(NoDataViewFactory.ImgType.NODATA), s.bL(y.plugin_no_plugins), null);
        this.vl.setEmptyView(this.ahO);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.bGG = new a(this);
        ConfigInfos netConfigInfos = PluginCenter.getInstance().getNetConfigInfos();
        if (netConfigInfos != null && netConfigInfos.getConfigs() != null && netConfigInfos.getConfigs().size() > 0) {
            if (!TbadkApplication.m251getInst().isHao123HelperShouldOpen()) {
                Iterator<ConfigInfos.PluginConfig> it = netConfigInfos.getConfigs().iterator();
                while (it.hasNext()) {
                    if (PluginNameList.NAME_HAO123.equals(it.next().name)) {
                        it.remove();
                    }
                }
            }
            Iterator<ConfigInfos.PluginConfig> it2 = netConfigInfos.getConfigs().iterator();
            while (it2.hasNext()) {
                if (PluginNameList.NAME_LIVE.equals(it2.next().name)) {
                    it2.remove();
                }
            }
            this.bGG.aj(netConfigInfos.getConfigs());
            PluginCenter.getInstance().setTipUpdateRead();
        }
        this.vl.setAdapter((ListAdapter) this.bGG);
        this.vl.setOnItemClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(i);
        this.bGG.notifyDataSetChanged();
        getLayoutMode().h(findViewById(16908290));
        if (this.ahO != null) {
            this.ahO.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        PluginDetailActivity.startActivity(this, this.bGG.getItem(i).name);
    }
}
