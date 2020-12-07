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
    private HotTopicListModel lwJ;
    private HotTopicListView lwK;
    private List<q> lwL;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        an(bundle);
        this.lwJ = new HotTopicListModel(getPageContext(), this);
        this.lwK = new HotTopicListView(getPageContext(), this, bundle);
        setContentView(this.lwK);
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
        boolean LoadData = this.lwJ.LoadData();
        if (y.isEmpty(this.lwL)) {
            if (LoadData) {
                this.lwK.showLoadingView();
                this.lwK.Yb();
                return;
            }
            this.lwK.hideLoadingView();
            this.lwK.px(false);
        } else if (!LoadData) {
            this.lwK.hideLoadingView();
            this.lwK.bSl();
        }
    }

    @Override // com.baidu.tieba.newlist.b
    public void o(int i, List<q> list) {
        this.lwK.hideLoadingView();
        this.lwK.bSl();
        this.lwK.Yb();
        if (i != 0 || y.isEmpty(list)) {
            if (y.isEmpty(this.lwL)) {
                this.lwK.px(false);
                return;
            }
            return;
        }
        this.lwK.setData(list);
        this.lwK.Ya();
        this.lwL = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lwK.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a078";
    }
}
