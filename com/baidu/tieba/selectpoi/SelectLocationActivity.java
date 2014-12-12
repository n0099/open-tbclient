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
    private BdListView aez;
    private ImageView bNc;
    private l bNd;
    private AdapterView.OnItemClickListener bNe = new j(this);

    static {
        TbadkApplication.getInst().RegisterIntent(SelectLocationActivityConfig.class, SelectLocationActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(x.select_location_activity);
        this.aey.setTitleText(z.select_position_title);
        this.bNc = (ImageView) this.aey.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, x.widget_nb_item_search, (View.OnClickListener) null);
        this.bNc.setOnClickListener(new k(this));
        this.aez = (BdListView) findViewById(w.select_position_list);
        this.bNd = new l(this);
        this.aez.setAdapter((ListAdapter) this.bNd);
        this.aez.setOnItemClickListener(this.bNe);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bNd.notifyDataSetChanged();
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
