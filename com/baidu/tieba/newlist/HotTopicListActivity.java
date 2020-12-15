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
/* loaded from: classes21.dex */
public class HotTopicListActivity extends BaseActivity<HotTopicListActivity> implements b {
    private String callFrom = "";
    private HotTopicListModel lwL;
    private HotTopicListView lwM;
    private List<q> lwN;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        an(bundle);
        this.lwL = new HotTopicListModel(getPageContext(), this);
        this.lwM = new HotTopicListView(getPageContext(), this, bundle);
        setContentView(this.lwM);
        setIsAddSwipeBackLayout(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TiebaStatic.log(new ar("c13741").dY("uid", TbadkCoreApplication.getCurrentAccount()));
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
        boolean LoadData = this.lwL.LoadData();
        if (y.isEmpty(this.lwN)) {
            if (LoadData) {
                this.lwM.showLoadingView();
                this.lwM.Yb();
                return;
            }
            this.lwM.hideLoadingView();
            this.lwM.px(false);
        } else if (!LoadData) {
            this.lwM.hideLoadingView();
            this.lwM.bSm();
        }
    }

    @Override // com.baidu.tieba.newlist.b
    public void o(int i, List<q> list) {
        this.lwM.hideLoadingView();
        this.lwM.bSm();
        this.lwM.Yb();
        if (i != 0 || y.isEmpty(list)) {
            if (y.isEmpty(this.lwN)) {
                this.lwM.px(false);
                return;
            }
            return;
        }
        this.lwM.setData(list);
        this.lwM.Ya();
        this.lwN = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lwM.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a078";
    }
}
