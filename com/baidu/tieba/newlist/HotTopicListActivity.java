package com.baidu.tieba.newlist;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import java.util.List;
/* loaded from: classes15.dex */
public class HotTopicListActivity extends BaseActivity<HotTopicListActivity> implements b {
    private String callFrom = "";
    private List<q> iwM;
    private HotTopicListModel kdk;
    private HotTopicListView kdl;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        at(bundle);
        this.kdk = new HotTopicListModel(getPageContext(), this);
        this.kdl = new HotTopicListView(getPageContext(), this, bundle);
        setContentView(this.kdl);
        setIsAddSwipeBackLayout(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TiebaStatic.log(new ap("c13741").dn("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    private void at(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.callFrom = intent.getStringExtra("call_from");
        } else if (bundle != null) {
            this.callFrom = bundle.getString("call_from");
        }
    }

    @Override // com.baidu.tieba.newlist.b
    public void loadData() {
        boolean LoadData = this.kdk.LoadData();
        if (x.isEmpty(this.iwM)) {
            if (LoadData) {
                this.kdl.showLoadingView();
                this.kdl.bwX();
                return;
            }
            this.kdl.hideLoadingView();
            this.kdl.ng(false);
        } else if (!LoadData) {
            this.kdl.hideLoadingView();
            this.kdl.bxe();
        }
    }

    @Override // com.baidu.tieba.newlist.b
    public void n(int i, List<q> list) {
        this.kdl.hideLoadingView();
        this.kdl.bxe();
        if (i != 0 || x.isEmpty(list)) {
            if (x.isEmpty(this.iwM)) {
                this.kdl.ng(false);
                return;
            }
            return;
        }
        this.kdl.setData(list);
        this.kdl.bxT();
        this.iwM = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kdl.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a024";
    }
}
