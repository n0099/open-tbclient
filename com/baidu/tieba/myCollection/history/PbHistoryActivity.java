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
import com.baidu.tieba.t;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class PbHistoryActivity extends BaseActivity<PbHistoryActivity> {
    private BdListView IY;
    private final a.InterfaceC0055a<com.baidu.tieba.myCollection.baseHistory.b> ayB = new b(this);
    private com.baidu.tbadk.mvc.g.d<com.baidu.tieba.myCollection.baseHistory.b, com.baidu.tbadk.mvc.d.b, g> bzn;
    private RelativeLayout cFw;
    private TextView cFx;
    private com.baidu.tieba.myCollection.baseHistory.a cFy;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cFy = new com.baidu.tieba.myCollection.baseHistory.a(getPageContext());
        this.cFy.a(this.ayB);
        this.cFw = (RelativeLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(t.h.pb_history_activity, (ViewGroup) null);
        setContentView(this.cFw);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(t.j.my_history);
        this.cFx = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(t.j.delete_all_user_chat));
        this.cFx.setOnClickListener(new c(this));
        this.cFx.setVisibility(8);
        this.IY = (BdListView) findViewById(t.g.list);
        this.bzn = new com.baidu.tbadk.mvc.g.d<>(getPageContext(), g.class, t.h.pb_history_list_item, null);
        this.bzn.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.y(t.j.pb_history_no_data_tip, t.j.pb_history_no_data_tip_2), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.IY.setAdapter((ListAdapter) this.bzn);
        this.IY.setOnItemClickListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Oh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bzn.a(getPageContext(), i);
        getLayoutMode().x(this.cFw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oh() {
        this.cFy.EJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bk(List<com.baidu.tieba.myCollection.baseHistory.b> list) {
        if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
            bl(list);
        }
        if (this.bzn != null) {
            this.bzn.w(list);
        }
        if (list == null || list.size() == 0) {
            this.cFx.setVisibility(8);
        } else {
            this.cFx.setVisibility(0);
        }
    }

    private void bl(List<com.baidu.tieba.myCollection.baseHistory.b> list) {
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
