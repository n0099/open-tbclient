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
/* loaded from: classes7.dex */
public class HotTopicListActivity extends BaseActivity<HotTopicListActivity> implements b {
    private String callFrom = "";
    private HotTopicListModel lxn;
    private HotTopicListView lxo;
    private List<n> lxp;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        an(bundle);
        this.lxn = new HotTopicListModel(getPageContext(), this);
        this.lxo = new HotTopicListView(getPageContext(), this, bundle);
        setContentView(this.lxo);
        setIsAddSwipeBackLayout(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TiebaStatic.log(new aq("c13741").dW("uid", TbadkCoreApplication.getCurrentAccount()));
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
        boolean LoadData = this.lxn.LoadData();
        if (x.isEmpty(this.lxp)) {
            if (LoadData) {
                this.lxo.showLoadingView();
                this.lxo.Vq();
                return;
            }
            this.lxo.hideLoadingView();
            this.lxo.pQ(false);
        } else if (!LoadData) {
            this.lxo.hideLoadingView();
            this.lxo.bQX();
        }
    }

    @Override // com.baidu.tieba.newlist.b
    public void o(int i, List<n> list) {
        this.lxo.hideLoadingView();
        this.lxo.bQX();
        this.lxo.Vq();
        if (i != 0 || x.isEmpty(list)) {
            if (x.isEmpty(this.lxp)) {
                this.lxo.pQ(false);
                return;
            }
            return;
        }
        this.lxo.setData(list);
        this.lxo.Vp();
        this.lxp = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lxo.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a078";
    }
}
