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
import com.baidu.tieba.selectpoi.NavigationBarActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class SelectLocationActivity extends NavigationBarActivity {
    private BdListView aTj;
    private ImageView eoL;
    private l eoM;
    private AdapterView.OnItemClickListener bNt = new i(this);
    private CustomMessageListener eoN = new j(this, CmdConfigCustom.CLOSE_SELECT_LOCATION_ACTIVITY);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.select_location_activity);
        this.aLP.setTitleText(t.j.select_position_title);
        this.eoL = (ImageView) this.aLP.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.widget_nb_item_search, (View.OnClickListener) null);
        this.eoL.setOnClickListener(new k(this));
        this.aTj = (BdListView) findViewById(t.g.select_position_list);
        this.eoM = new l(this);
        this.aTj.setAdapter((ListAdapter) this.eoM);
        this.aTj.setOnItemClickListener(this.bNt);
        registerListener(this.eoN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eoM.notifyDataSetChanged();
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
