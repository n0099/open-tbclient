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
    private BdListView aNj;
    private ImageView dMH;
    private l dMI;
    private AdapterView.OnItemClickListener bGd = new i(this);
    private CustomMessageListener dMJ = new j(this, CmdConfigCustom.CLOSE_SELECT_LOCATION_ACTIVITY);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.g.select_location_activity);
        this.aJm.setTitleText(n.i.select_position_title);
        this.dMH = (ImageView) this.aJm.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.g.widget_nb_item_search, (View.OnClickListener) null);
        this.dMH.setOnClickListener(new k(this));
        this.aNj = (BdListView) findViewById(n.f.select_position_list);
        this.dMI = new l(this);
        this.aNj.setAdapter((ListAdapter) this.dMI);
        this.aNj.setOnItemClickListener(this.bGd);
        registerListener(this.dMJ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dMI.notifyDataSetChanged();
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
