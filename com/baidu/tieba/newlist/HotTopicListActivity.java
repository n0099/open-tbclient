package com.baidu.tieba.newlist;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import java.util.List;
/* loaded from: classes8.dex */
public class HotTopicListActivity extends BaseActivity<HotTopicListActivity> implements b {
    private String callFrom = "";
    private HotTopicListModel lFF;
    private HotTopicListView lFG;
    private List<n> lFH;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        an(bundle);
        this.lFF = new HotTopicListModel(getPageContext(), this);
        this.lFG = new HotTopicListView(getPageContext(), this, bundle);
        setContentView(this.lFG);
        setIsAddSwipeBackLayout(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TiebaStatic.log(new ar("c13741").dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    private void an(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.callFrom = intent.getStringExtra("call_from");
        } else if (bundle != null) {
            this.callFrom = bundle.getString("call_from");
        }
    }

    @Override // com.baidu.tieba.newlist.b
    public void loadData() {
        boolean LoadData = this.lFF.LoadData();
        if (y.isEmpty(this.lFH)) {
            if (LoadData) {
                this.lFG.showLoadingView();
                this.lFG.WZ();
                return;
            }
            this.lFG.hideLoadingView();
            this.lFG.qa(false);
        } else if (!LoadData) {
            this.lFG.hideLoadingView();
            this.lFG.bRI();
        }
    }

    @Override // com.baidu.tieba.newlist.b
    public void q(int i, List<n> list) {
        this.lFG.hideLoadingView();
        this.lFG.bRI();
        this.lFG.WZ();
        if (i != 0 || y.isEmpty(list)) {
            if (y.isEmpty(this.lFH)) {
                this.lFG.qa(false);
                return;
            }
            return;
        }
        this.lFG.setData(list);
        this.lFG.WY();
        this.lFH = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lFG.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a078";
    }
}
