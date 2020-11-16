package com.baidu.tieba.newlist;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import java.util.List;
/* loaded from: classes20.dex */
public class HotTopicListActivity extends BaseActivity<HotTopicListActivity> implements b {
    private String callFrom = "";
    private HotTopicListModel ljk;
    private HotTopicListView ljl;
    private List<q> ljm;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as(bundle);
        this.ljk = new HotTopicListModel(getPageContext(), this);
        this.ljl = new HotTopicListView(getPageContext(), this, bundle);
        setContentView(this.ljl);
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
        boolean LoadData = this.ljk.LoadData();
        if (y.isEmpty(this.ljm)) {
            if (LoadData) {
                this.ljl.showLoadingView();
                this.ljl.VB();
                return;
            }
            this.ljl.hideLoadingView();
            this.ljl.pb(false);
        } else if (!LoadData) {
            this.ljl.hideLoadingView();
            this.ljl.bOA();
        }
    }

    @Override // com.baidu.tieba.newlist.b
    public void o(int i, List<q> list) {
        this.ljl.hideLoadingView();
        this.ljl.bOA();
        this.ljl.VB();
        if (i != 0 || y.isEmpty(list)) {
            if (y.isEmpty(this.ljm)) {
                this.ljl.pb(false);
                return;
            }
            return;
        }
        this.ljl.setData(list);
        this.ljl.VA();
        this.ljm = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ljl.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a078";
    }
}
