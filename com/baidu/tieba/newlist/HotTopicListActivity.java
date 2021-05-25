package com.baidu.tieba.newlist;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.c.j.e.n;
import d.a.n0.b2.b;
import java.util.List;
/* loaded from: classes4.dex */
public class HotTopicListActivity extends BaseActivity<HotTopicListActivity> implements b {
    public String callFrom = "";
    public List<n> curDataList;
    public HotTopicListModel mModel;
    public HotTopicListView mView;

    private void initParamsFromIntent(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.callFrom = intent.getStringExtra(IntentConfig.CALL_FROM);
        } else if (bundle != null) {
            this.callFrom = bundle.getString(IntentConfig.CALL_FROM);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, d.a.m0.k0.a
    public String getCurrentPageKey() {
        return "a078";
    }

    @Override // d.a.n0.b2.b
    public void loadData() {
        boolean LoadData = this.mModel.LoadData();
        if (!ListUtils.isEmpty(this.curDataList)) {
            if (LoadData) {
                return;
            }
            this.mView.r();
            this.mView.B();
        } else if (LoadData) {
            this.mView.y();
            this.mView.s();
        } else {
            this.mView.r();
            this.mView.z(false);
        }
    }

    @Override // d.a.n0.b2.b
    public void netCallback(int i2, List<n> list) {
        this.mView.r();
        this.mView.B();
        this.mView.s();
        if (i2 == 0 && !ListUtils.isEmpty(list)) {
            this.mView.setData(list);
            this.mView.A();
            this.curDataList = list;
        } else if (ListUtils.isEmpty(this.curDataList)) {
            this.mView.z(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mView.v();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initParamsFromIntent(bundle);
        this.mModel = new HotTopicListModel(getPageContext(), this);
        HotTopicListView hotTopicListView = new HotTopicListView(getPageContext(), this, bundle);
        this.mView = hotTopicListView;
        setContentView(hotTopicListView);
        setIsAddSwipeBackLayout(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        loadData();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TiebaStatic.log(new StatisticItem("c13741").param("uid", TbadkCoreApplication.getCurrentAccount()));
    }
}
