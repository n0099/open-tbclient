package com.baidu.tieba.newlist;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import java.util.List;
/* loaded from: classes21.dex */
public class HotTopicListActivity extends BaseActivity<HotTopicListActivity> implements b {
    private String callFrom = "";
    private HotTopicListModel lcW;
    private HotTopicListView lcX;
    private List<q> lcY;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as(bundle);
        this.lcW = new HotTopicListModel(getPageContext(), this);
        this.lcX = new HotTopicListView(getPageContext(), this, bundle);
        setContentView(this.lcX);
        setIsAddSwipeBackLayout(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TiebaStatic.log(new aq("c13741").dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    private void as(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.callFrom = intent.getStringExtra("call_from");
        } else if (bundle != null) {
            this.callFrom = bundle.getString("call_from");
        }
    }

    @Override // com.baidu.tieba.newlist.b
    public void loadData() {
        boolean LoadData = this.lcW.LoadData();
        if (y.isEmpty(this.lcY)) {
            if (LoadData) {
                this.lcX.showLoadingView();
                this.lcX.TK();
                return;
            }
            this.lcX.hideLoadingView();
            this.lcX.oP(false);
        } else if (!LoadData) {
            this.lcX.hideLoadingView();
            this.lcX.bMH();
        }
    }

    @Override // com.baidu.tieba.newlist.b
    public void o(int i, List<q> list) {
        this.lcX.hideLoadingView();
        this.lcX.bMH();
        if (i != 0 || y.isEmpty(list)) {
            if (y.isEmpty(this.lcY)) {
                this.lcX.oP(false);
                return;
            }
            return;
        }
        this.lcX.setData(list);
        this.lcX.TJ();
        this.lcY = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lcX.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a078";
    }
}
