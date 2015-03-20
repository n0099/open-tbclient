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
import com.baidu.tieba.selectpoi.NavigationBarActivity;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class SelectLocationActivity extends NavigationBarActivity {
    private BdListView ann;
    private ImageView cvn;
    private l cvo;
    private AdapterView.OnItemClickListener cvp = new i(this);
    private CustomMessageListener cvq = new j(this, 2002013);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.select_location_activity);
        this.anm.setTitleText(y.select_position_title);
        this.cvn = (ImageView) this.anm.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.widget_nb_item_search, (View.OnClickListener) null);
        this.cvn.setOnClickListener(new k(this));
        this.ann = (BdListView) findViewById(v.select_position_list);
        this.cvo = new l(this);
        this.ann.setAdapter((ListAdapter) this.cvo);
        this.ann.setOnItemClickListener(this.cvp);
        registerListener(this.cvq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cvo.notifyDataSetChanged();
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
