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
    private HotTopicListModel lFr;
    private HotTopicListView lFs;
    private List<n> lFt;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        an(bundle);
        this.lFr = new HotTopicListModel(getPageContext(), this);
        this.lFs = new HotTopicListView(getPageContext(), this, bundle);
        setContentView(this.lFs);
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
        boolean LoadData = this.lFr.LoadData();
        if (y.isEmpty(this.lFt)) {
            if (LoadData) {
                this.lFs.showLoadingView();
                this.lFs.WZ();
                return;
            }
            this.lFs.hideLoadingView();
            this.lFs.qa(false);
        } else if (!LoadData) {
            this.lFs.hideLoadingView();
            this.lFs.bRB();
        }
    }

    @Override // com.baidu.tieba.newlist.b
    public void q(int i, List<n> list) {
        this.lFs.hideLoadingView();
        this.lFs.bRB();
        this.lFs.WZ();
        if (i != 0 || y.isEmpty(list)) {
            if (y.isEmpty(this.lFt)) {
                this.lFs.qa(false);
                return;
            }
            return;
        }
        this.lFs.setData(list);
        this.lFs.WY();
        this.lFt = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lFs.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a078";
    }
}
