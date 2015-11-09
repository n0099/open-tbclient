package com.baidu.tieba.write.selectpoi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.i;
import com.baidu.tieba.selectpoi.NavigationBarActivity;
/* loaded from: classes.dex */
public class SelectLocationActivity extends NavigationBarActivity {
    private BdListView aII;
    private ImageView dnB;
    private l dnC;
    private AdapterView.OnItemClickListener bqZ = new i(this);
    private CustomMessageListener dnD = new j(this, CmdConfigCustom.CLOSE_SELECT_LOCATION_ACTIVITY);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.select_location_activity);
        this.aGn.setTitleText(i.h.select_position_title);
        this.dnB = (ImageView) this.aGn.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.widget_nb_item_search, (View.OnClickListener) null);
        this.dnB.setOnClickListener(new k(this));
        this.aII = (BdListView) findViewById(i.f.select_position_list);
        this.dnC = new l(this);
        this.aII.setAdapter((ListAdapter) this.dnC);
        this.aII.setOnItemClickListener(this.bqZ);
        registerListener(this.dnD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dnC.notifyDataSetChanged();
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
