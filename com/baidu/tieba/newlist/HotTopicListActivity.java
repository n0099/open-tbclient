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
/* loaded from: classes7.dex */
public class HotTopicListActivity extends BaseActivity<HotTopicListActivity> implements b {
    private String callFrom = "";
    private HotTopicListModel lHH;
    private HotTopicListView lHI;
    private List<n> lHJ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        an(bundle);
        this.lHH = new HotTopicListModel(getPageContext(), this);
        this.lHI = new HotTopicListView(getPageContext(), this, bundle);
        setContentView(this.lHI);
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
        boolean LoadData = this.lHH.LoadData();
        if (y.isEmpty(this.lHJ)) {
            if (LoadData) {
                this.lHI.showLoadingView();
                this.lHI.Xc();
                return;
            }
            this.lHI.hideLoadingView();
            this.lHI.qa(false);
        } else if (!LoadData) {
            this.lHI.hideLoadingView();
            this.lHI.bRO();
        }
    }

    @Override // com.baidu.tieba.newlist.b
    public void q(int i, List<n> list) {
        this.lHI.hideLoadingView();
        this.lHI.bRO();
        this.lHI.Xc();
        if (i != 0 || y.isEmpty(list)) {
            if (y.isEmpty(this.lHJ)) {
                this.lHI.qa(false);
                return;
            }
            return;
        }
        this.lHI.setData(list);
        this.lHI.Xb();
        this.lHJ = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lHI.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a078";
    }
}
