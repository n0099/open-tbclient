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
/* loaded from: classes20.dex */
public class HotTopicListActivity extends BaseActivity<HotTopicListActivity> implements b {
    private String callFrom = "";
    private HotTopicListModel kBn;
    private HotTopicListView kBo;
    private List<q> kBp;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as(bundle);
        this.kBn = new HotTopicListModel(getPageContext(), this);
        this.kBo = new HotTopicListView(getPageContext(), this, bundle);
        setContentView(this.kBo);
        setIsAddSwipeBackLayout(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TiebaStatic.log(new aq("c13741").dF("uid", TbadkCoreApplication.getCurrentAccount()));
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
        boolean LoadData = this.kBn.LoadData();
        if (y.isEmpty(this.kBp)) {
            if (LoadData) {
                this.kBo.showLoadingView();
                this.kBo.bHn();
                return;
            }
            this.kBo.hideLoadingView();
            this.kBo.nS(false);
        } else if (!LoadData) {
            this.kBo.hideLoadingView();
            this.kBo.bHu();
        }
    }

    @Override // com.baidu.tieba.newlist.b
    public void o(int i, List<q> list) {
        this.kBo.hideLoadingView();
        this.kBo.bHu();
        if (i != 0 || y.isEmpty(list)) {
            if (y.isEmpty(this.kBp)) {
                this.kBo.nS(false);
                return;
            }
            return;
        }
        this.kBo.setData(list);
        this.kBo.bIj();
        this.kBp = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kBo.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a078";
    }
}
