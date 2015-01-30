package com.baidu.tieba.selectpoi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class SelectLocationActivity extends NavigationBarActivity {
    private BdListView aeW;
    private ImageView bOM;
    private l bON;
    private AdapterView.OnItemClickListener bOO = new j(this);

    static {
        TbadkApplication.getInst().RegisterIntent(SelectLocationActivityConfig.class, SelectLocationActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(x.select_location_activity);
        this.aeV.setTitleText(z.select_position_title);
        this.bOM = (ImageView) this.aeV.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, x.widget_nb_item_search, (View.OnClickListener) null);
        this.bOM.setOnClickListener(new k(this));
        this.aeW = (BdListView) findViewById(w.select_position_list);
        this.bON = new l(this);
        this.aeW.setAdapter((ListAdapter) this.bON);
        this.aeW.setOnItemClickListener(this.bOO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bON.notifyDataSetChanged();
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
