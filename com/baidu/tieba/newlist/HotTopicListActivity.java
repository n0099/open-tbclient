package com.baidu.tieba.newlist;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import java.util.List;
/* loaded from: classes8.dex */
public class HotTopicListActivity extends BaseActivity<HotTopicListActivity> implements b {
    private String callFrom = "";
    private HotTopicListModel lBT;
    private HotTopicListView lBU;
    private List<n> lBV;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        an(bundle);
        this.lBT = new HotTopicListModel(getPageContext(), this);
        this.lBU = new HotTopicListView(getPageContext(), this, bundle);
        setContentView(this.lBU);
        setIsAddSwipeBackLayout(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TiebaStatic.log(new aq("c13741").dX("uid", TbadkCoreApplication.getCurrentAccount()));
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
        boolean LoadData = this.lBT.LoadData();
        if (x.isEmpty(this.lBV)) {
            if (LoadData) {
                this.lBU.showLoadingView();
                this.lBU.Zi();
                return;
            }
            this.lBU.hideLoadingView();
            this.lBU.pU(false);
        } else if (!LoadData) {
            this.lBU.hideLoadingView();
            this.lBU.bUO();
        }
    }

    @Override // com.baidu.tieba.newlist.b
    public void o(int i, List<n> list) {
        this.lBU.hideLoadingView();
        this.lBU.bUO();
        this.lBU.Zi();
        if (i != 0 || x.isEmpty(list)) {
            if (x.isEmpty(this.lBV)) {
                this.lBU.pU(false);
                return;
            }
            return;
        }
        this.lBU.setData(list);
        this.lBU.Zh();
        this.lBV = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lBU.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a078";
    }
}
