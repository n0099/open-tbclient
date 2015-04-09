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
import com.baidu.tbadk.core.view.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.List;
/* loaded from: classes.dex */
public class PbHistoryActivity extends BaseActivity<PbHistoryActivity> {
    private com.baidu.tbadk.mvc.j.d<com.baidu.tieba.myCollection.baseHistory.b, com.baidu.tbadk.mvc.e.c, g> aBJ;
    private final com.baidu.tbadk.mvc.model.d<com.baidu.tieba.myCollection.baseHistory.b> amL = new b(this);
    private RelativeLayout bEL;
    private com.baidu.tieba.myCollection.baseHistory.a bEM;
    private TextView mEditBtn;
    private BdListView mListView;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bEM = new com.baidu.tieba.myCollection.baseHistory.a(this);
        this.bEM.a(this.amL);
        this.bEL = (RelativeLayout) com.baidu.adp.lib.g.b.hH().inflate(getPageContext().getPageActivity(), w.pb_history_activity, null);
        setContentView(this.bEL);
        this.mNavigationBar = (NavigationBar) findViewById(v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(y.my_history);
        this.mEditBtn = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(y.delete_all_user_chat));
        this.mEditBtn.setOnClickListener(new c(this));
        this.mEditBtn.setVisibility(8);
        this.mListView = (BdListView) findViewById(v.list);
        this.aBJ = new com.baidu.tbadk.mvc.j.d<>(getPageContext(), g.class, w.pb_history_list_item, null);
        this.aBJ.a(com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.w.r(y.pb_history_no_data_tip, y.pb_history_no_data_tip_2), (u) null, (FrameLayout.LayoutParams) null);
        this.mListView.setAdapter((ListAdapter) this.aBJ);
        this.mListView.setOnItemClickListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        VA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aBJ.a(getPageContext(), i);
        getLayoutMode().h(this.bEL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VA() {
        this.bEM.AR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(List<com.baidu.tieba.myCollection.baseHistory.b> list) {
        if (this.aBJ != null) {
            this.aBJ.r(list);
        }
        if (list == null || list.size() == 0) {
            this.mEditBtn.setVisibility(8);
        } else {
            this.mEditBtn.setVisibility(0);
        }
    }
}
