package com.baidu.tieba.myCollection.history;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.core.view.z;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class PbHistoryActivity extends BaseActivity<PbHistoryActivity> {
    private com.baidu.tbadk.mvc.j.d<com.baidu.tieba.myCollection.baseHistory.b, com.baidu.tbadk.mvc.e.c, g> aDG;
    private final com.baidu.tbadk.mvc.model.d<com.baidu.tieba.myCollection.baseHistory.b> anO = new b(this);
    private RelativeLayout bHH;
    private com.baidu.tieba.myCollection.baseHistory.a bHI;
    private TextView mEditBtn;
    private BdListView mListView;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bHI = new com.baidu.tieba.myCollection.baseHistory.a(this);
        this.bHI.a(this.anO);
        this.bHH = (RelativeLayout) com.baidu.adp.lib.g.b.hr().inflate(getPageContext().getPageActivity(), r.pb_history_activity, null);
        setContentView(this.bHH);
        this.mNavigationBar = (NavigationBar) findViewById(q.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(t.my_history);
        this.mEditBtn = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(t.delete_all_user_chat));
        this.mEditBtn.setOnClickListener(new c(this));
        this.mEditBtn.setVisibility(8);
        this.mListView = (BdListView) findViewById(q.list);
        this.aDG = new com.baidu.tbadk.mvc.j.d<>(getPageContext(), g.class, r.pb_history_list_item, null);
        this.aDG.a(aa.a(NoDataViewFactory.ImgType.NODATA), ab.s(t.pb_history_no_data_tip, t.pb_history_no_data_tip_2), (z) null, (FrameLayout.LayoutParams) null);
        this.mListView.setAdapter((ListAdapter) this.aDG);
        this.mListView.setOnItemClickListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        WT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aDG.a(getPageContext(), i);
        getLayoutMode().j(this.bHH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WT() {
        this.bHI.BE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQ(List<com.baidu.tieba.myCollection.baseHistory.b> list) {
        if (this.aDG != null) {
            this.aDG.s(list);
        }
        if (list == null || list.size() == 0) {
            this.mEditBtn.setVisibility(8);
        } else {
            this.mEditBtn.setVisibility(0);
        }
    }
}
