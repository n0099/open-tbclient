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
import com.baidu.tieba.i;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class PbHistoryActivity extends BaseActivity<PbHistoryActivity> {
    private com.baidu.tbadk.mvc.g.d<com.baidu.tieba.myCollection.baseHistory.b, com.baidu.tbadk.mvc.d.b, g> aKt;
    private final a.InterfaceC0052a<com.baidu.tieba.myCollection.baseHistory.b> avm = new b(this);
    private RelativeLayout ccn;
    private com.baidu.tieba.myCollection.baseHistory.a cco;
    private TextView mEditBtn;
    private BdListView mListView;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cco = new com.baidu.tieba.myCollection.baseHistory.a(this);
        this.cco.a(this.avm);
        this.ccn = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(i.g.pb_history_activity, (ViewGroup) null);
        setContentView(this.ccn);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(i.h.my_history);
        this.mEditBtn = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(i.h.delete_all_user_chat));
        this.mEditBtn.setOnClickListener(new c(this));
        this.mEditBtn.setVisibility(8);
        this.mListView = (BdListView) findViewById(i.f.list);
        this.aKt = new com.baidu.tbadk.mvc.g.d<>(getPageContext(), g.class, i.g.pb_history_list_item, null);
        this.aKt.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.C(i.h.pb_history_no_data_tip, i.h.pb_history_no_data_tip_2), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.mListView.setAdapter((ListAdapter) this.aKt);
        this.mListView.setOnItemClickListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Kk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aKt.a(getPageContext(), i);
        getLayoutMode().k(this.ccn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kk() {
        this.cco.CF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(List<com.baidu.tieba.myCollection.baseHistory.b> list) {
        if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
            aY(list);
        }
        if (this.aKt != null) {
            this.aKt.r(list);
        }
        if (list == null || list.size() == 0) {
            this.mEditBtn.setVisibility(8);
        } else {
            this.mEditBtn.setVisibility(0);
        }
    }

    private void aY(List<com.baidu.tieba.myCollection.baseHistory.b> list) {
        if (list != null && list.size() != 0) {
            Iterator<com.baidu.tieba.myCollection.baseHistory.b> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().sn() == 33) {
                    it.remove();
                }
            }
        }
    }
}
