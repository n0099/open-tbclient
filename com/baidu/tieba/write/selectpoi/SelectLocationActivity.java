package com.baidu.tieba.write.selectpoi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.selectpoi.NavigationBarActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class SelectLocationActivity extends NavigationBarActivity {
    private BdListView aoy;
    private ImageView czV;
    private l czW;
    private AdapterView.OnItemClickListener czX = new i(this);
    private CustomMessageListener czY = new j(this, 2002013);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(r.select_location_activity);
        this.aox.setTitleText(t.select_position_title);
        this.czV = (ImageView) this.aox.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.widget_nb_item_search, (View.OnClickListener) null);
        this.czV.setOnClickListener(new k(this));
        this.aoy = (BdListView) findViewById(q.select_position_list);
        this.czW = new l(this);
        this.aoy.setAdapter((ListAdapter) this.czW);
        this.aoy.setOnItemClickListener(this.czX);
        registerListener(this.czY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.czW.notifyDataSetChanged();
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
