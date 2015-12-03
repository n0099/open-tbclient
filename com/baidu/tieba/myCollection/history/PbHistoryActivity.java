package com.baidu.tieba.myCollection.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.mvc.model.a;
import com.baidu.tieba.n;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class PbHistoryActivity extends BaseActivity<PbHistoryActivity> {
    private com.baidu.tbadk.mvc.g.d<com.baidu.tieba.myCollection.baseHistory.b, com.baidu.tbadk.mvc.d.b, g> aNO;
    private final a.InterfaceC0054a<com.baidu.tieba.myCollection.baseHistory.b> awe = new b(this);
    private RelativeLayout cuP;
    private TextView cuQ;
    private com.baidu.tieba.myCollection.baseHistory.a cuR;
    private BdListView mListView;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cuR = new com.baidu.tieba.myCollection.baseHistory.a(this);
        this.cuR.a(this.awe);
        this.cuP = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(n.g.pb_history_activity, (ViewGroup) null);
        setContentView(this.cuP);
        this.mNavigationBar = (NavigationBar) findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(n.i.my_history);
        this.cuQ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(n.i.delete_all_user_chat));
        this.cuQ.setOnClickListener(new c(this));
        this.cuQ.setVisibility(8);
        this.mListView = (BdListView) findViewById(n.f.list);
        this.aNO = new com.baidu.tbadk.mvc.g.d<>(getPageContext(), g.class, n.g.pb_history_list_item, null);
        this.aNO.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.D(n.i.pb_history_no_data_tip, n.i.pb_history_no_data_tip_2), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.mListView.setAdapter((ListAdapter) this.aNO);
        this.mListView.setOnItemClickListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        LV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aNO.a(getPageContext(), i);
        getLayoutMode().k(this.cuP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LV() {
        this.cuR.Dz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bm(List<com.baidu.tieba.myCollection.baseHistory.b> list) {
        if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
            bn(list);
        }
        if (this.aNO != null) {
            this.aNO.r(list);
        }
        if (list == null || list.size() == 0) {
            this.cuQ.setVisibility(8);
        } else {
            this.cuQ.setVisibility(0);
        }
    }

    private void bn(List<com.baidu.tieba.myCollection.baseHistory.b> list) {
        if (list != null && list.size() != 0) {
            Iterator<com.baidu.tieba.myCollection.baseHistory.b> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().getThreadType() == 33) {
                    it.remove();
                }
            }
        }
    }
}
