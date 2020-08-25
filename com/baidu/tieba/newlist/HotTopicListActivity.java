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
/* loaded from: classes15.dex */
public class HotTopicListActivity extends BaseActivity<HotTopicListActivity> implements b {
    private String callFrom = "";
    private HotTopicListModel ksH;
    private HotTopicListView ksI;
    private List<q> ksJ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as(bundle);
        this.ksH = new HotTopicListModel(getPageContext(), this);
        this.ksI = new HotTopicListView(getPageContext(), this, bundle);
        setContentView(this.ksI);
        setIsAddSwipeBackLayout(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TiebaStatic.log(new aq("c13741").dD("uid", TbadkCoreApplication.getCurrentAccount()));
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
        boolean LoadData = this.ksH.LoadData();
        if (y.isEmpty(this.ksJ)) {
            if (LoadData) {
                this.ksI.showLoadingView();
                this.ksI.bFW();
                return;
            }
            this.ksI.hideLoadingView();
            this.ksI.nK(false);
        } else if (!LoadData) {
            this.ksI.hideLoadingView();
            this.ksI.bGd();
        }
    }

    @Override // com.baidu.tieba.newlist.b
    public void o(int i, List<q> list) {
        this.ksI.hideLoadingView();
        this.ksI.bGd();
        if (i != 0 || y.isEmpty(list)) {
            if (y.isEmpty(this.ksJ)) {
                this.ksI.nK(false);
                return;
            }
            return;
        }
        this.ksI.setData(list);
        this.ksI.bGS();
        this.ksJ = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ksI.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a024";
    }
}
