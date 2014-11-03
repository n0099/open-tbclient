package com.baidu.tieba.selectpoi;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class SelectLocationActivity extends NavigationBarActivity {
    private BdListView aJA;
    private c bIP;
    private AdapterView.OnItemClickListener bIQ = new b(this);

    static {
        TbadkApplication.m251getInst().RegisterIntent(SelectLocationActivityConfig.class, SelectLocationActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.select_location_activity);
        this.bhL.setTitleText(y.select_position_title);
        this.aJA = (BdListView) findViewById(v.select_position_list);
        this.bIP = new c(this);
        this.aJA.setAdapter((ListAdapter) this.bIP);
        this.aJA.setOnItemClickListener(this.bIQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.selectpoi.NavigationBarActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bIP.notifyDataSetChanged();
    }
}
