package com.baidu.tieba.newlist;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import java.util.List;
/* loaded from: classes8.dex */
public class HotTopicListActivity extends BaseActivity<HotTopicListActivity> implements b {
    private String callFrom = "";
    private List<q> iqI;
    private HotTopicListModel jUL;
    private HotTopicListView jUM;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as(bundle);
        this.jUL = new HotTopicListModel(getPageContext(), this);
        this.jUM = new HotTopicListView(getPageContext(), this, bundle);
        setContentView(this.jUM);
        setIsAddSwipeBackLayout(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TiebaStatic.log(new ao("c13741").dk("uid", TbadkCoreApplication.getCurrentAccount()));
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
        boolean LoadData = this.jUL.LoadData();
        if (w.isEmpty(this.iqI)) {
            if (LoadData) {
                this.jUM.showLoadingView();
                this.jUM.btN();
                return;
            }
            this.jUM.hideLoadingView();
            this.jUM.mB(false);
        } else if (!LoadData) {
            this.jUM.hideLoadingView();
            this.jUM.btU();
        }
    }

    @Override // com.baidu.tieba.newlist.b
    public void n(int i, List<q> list) {
        this.jUM.hideLoadingView();
        this.jUM.btU();
        if (i != 0 || w.isEmpty(list)) {
            if (w.isEmpty(this.iqI)) {
                this.jUM.mB(false);
                return;
            }
            return;
        }
        this.jUM.setData(list);
        this.jUM.buJ();
        this.iqI = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jUM.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a024";
    }
}
