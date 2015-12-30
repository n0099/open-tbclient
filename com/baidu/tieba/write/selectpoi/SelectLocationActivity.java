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
import com.baidu.tieba.n;
import com.baidu.tieba.selectpoi.NavigationBarActivity;
/* loaded from: classes.dex */
public class SelectLocationActivity extends NavigationBarActivity {
    private BdListView aRc;
    private ImageView dUg;
    private l dUh;
    private AdapterView.OnItemClickListener bJK = new i(this);
    private CustomMessageListener dUi = new j(this, CmdConfigCustom.CLOSE_SELECT_LOCATION_ACTIVITY);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.h.select_location_activity);
        this.aKK.setTitleText(n.j.select_position_title);
        this.dUg = (ImageView) this.aKK.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.h.widget_nb_item_search, (View.OnClickListener) null);
        this.dUg.setOnClickListener(new k(this));
        this.aRc = (BdListView) findViewById(n.g.select_position_list);
        this.dUh = new l(this);
        this.aRc.setAdapter((ListAdapter) this.dUh);
        this.aRc.setOnItemClickListener(this.bJK);
        registerListener(this.dUi);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dUh.notifyDataSetChanged();
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
