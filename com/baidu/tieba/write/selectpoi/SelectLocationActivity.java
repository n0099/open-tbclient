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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.selectpoi.NavigationBarActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class SelectLocationActivity extends NavigationBarActivity {
    private BdListView aSP;
    private AdapterView.OnItemClickListener bYq = new i(this);
    private CustomMessageListener eZA = new j(this, CmdConfigCustom.CLOSE_SELECT_LOCATION_ACTIVITY);
    private ImageView eZy;
    private l eZz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.select_location_activity);
        this.aKU.setTitleText(t.j.select_position_title);
        this.eZy = (ImageView) this.aKU.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.widget_nb_item_search, (View.OnClickListener) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), t.e.ds16), 0);
        this.eZy.setLayoutParams(layoutParams);
        this.eZy.setOnClickListener(new k(this));
        this.aSP = (BdListView) findViewById(t.g.select_position_list);
        this.eZz = new l(this);
        this.aSP.setAdapter((ListAdapter) this.eZz);
        this.aSP.setOnItemClickListener(this.bYq);
        registerListener(this.eZA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eZz.notifyDataSetChanged();
        at.a(this.eZy, t.f.icon_search_bg_s, t.f.icon_search_bg);
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
