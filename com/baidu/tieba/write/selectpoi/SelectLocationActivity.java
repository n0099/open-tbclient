package com.baidu.tieba.write.selectpoi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.selectpoi.NavigationBarActivity;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class SelectLocationActivity extends NavigationBarActivity {
    private BdListView aWk;
    private ImageView fEB;
    private l fEC;
    private AdapterView.OnItemClickListener cDe = new i(this);
    private CustomMessageListener fED = new j(this, CmdConfigCustom.CLOSE_SELECT_LOCATION_ACTIVITY);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(u.h.select_location_activity);
        this.aOs.setTitleText(u.j.select_position_title);
        this.fEB = (ImageView) this.aOs.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.widget_nb_item_search, (View.OnClickListener) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), u.e.ds16), 0);
        this.fEB.setLayoutParams(layoutParams);
        this.fEB.setOnClickListener(new k(this));
        this.aWk = (BdListView) findViewById(u.g.select_position_list);
        this.fEC = new l(this);
        this.aWk.setAdapter((ListAdapter) this.fEC);
        this.aWk.setOnItemClickListener(this.cDe);
        registerListener(this.fED);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fEC.notifyDataSetChanged();
        av.a(this.fEB, u.f.icon_search_bg_s, u.f.icon_search_bg);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 23009:
                    finish();
                    return;
                default:
                    return;
            }
        }
    }
}
