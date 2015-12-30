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
    private com.baidu.tbadk.mvc.g.d<com.baidu.tieba.myCollection.baseHistory.b, com.baidu.tbadk.mvc.d.b, g> aRG;
    private final a.InterfaceC0054a<com.baidu.tieba.myCollection.baseHistory.b> axI = new b(this);
    private RelativeLayout cyP;
    private TextView cyQ;
    private com.baidu.tieba.myCollection.baseHistory.a cyR;
    private BdListView mListView;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cyR = new com.baidu.tieba.myCollection.baseHistory.a(this);
        this.cyR.a(this.axI);
        this.cyP = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(n.h.pb_history_activity, (ViewGroup) null);
        setContentView(this.cyP);
        this.mNavigationBar = (NavigationBar) findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(n.j.my_history);
        this.cyQ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(n.j.delete_all_user_chat));
        this.cyQ.setOnClickListener(new c(this));
        this.cyQ.setVisibility(8);
        this.mListView = (BdListView) findViewById(n.g.list);
        this.aRG = new com.baidu.tbadk.mvc.g.d<>(getPageContext(), g.class, n.h.pb_history_list_item, null);
        this.aRG.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.C(n.j.pb_history_no_data_tip, n.j.pb_history_no_data_tip_2), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.mListView.setAdapter((ListAdapter) this.aRG);
        this.mListView.setOnItemClickListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Mo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aRG.a(getPageContext(), i);
        getLayoutMode().k(this.cyP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mo() {
        this.cyR.Do();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj(List<com.baidu.tieba.myCollection.baseHistory.b> list) {
        if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
            bk(list);
        }
        if (this.aRG != null) {
            this.aRG.s(list);
        }
        if (list == null || list.size() == 0) {
            this.cyQ.setVisibility(8);
        } else {
            this.cyQ.setVisibility(0);
        }
    }

    private void bk(List<com.baidu.tieba.myCollection.baseHistory.b> list) {
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
