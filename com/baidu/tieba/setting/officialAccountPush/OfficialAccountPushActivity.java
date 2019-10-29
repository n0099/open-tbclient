package com.baidu.tieba.setting.officialAccountPush;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class OfficialAccountPushActivity extends BaseActivity<OfficialAccountPushActivity> implements BdSwitchView.a {
    private BdListView fPR = null;
    private a iWK = null;
    private ArrayList<OfficialAccountPushInfo> list;
    private NavigationBar mNavigationBar;
    private NoNetworkView mNetworkView;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.official_account_push_activity);
        aLf();
        aDg();
        aDf();
    }

    private void aDf() {
        if (!j.isNetWorkAvailable() && v.isEmpty(this.list)) {
            cky();
        } else if (v.isEmpty(this.list)) {
            boR();
        } else if (this.iWK == null) {
            this.iWK = new a(getPageContext());
            this.iWK.setData(this.list);
            this.fPR.setAdapter((ListAdapter) this.iWK);
            this.iWK.setSwitchStateChangeListener(this);
        } else {
            this.iWK.setData(this.list);
            this.iWK.notifyDataSetChanged();
        }
    }

    private void aDg() {
        this.mRootView = (ViewGroup) findViewById(R.id.official_account_push_container);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_CENTER, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.offical_account_push_msg));
        this.fPR = (BdListView) findViewById(R.id.list);
        this.mNoDataView = NoDataViewFactory.a(this, this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds120)), NoDataViewFactory.d.iL(R.string.no_data_text), null);
        this.mNoDataView.setVisibility(0);
        this.mNetworkView = (NoNetworkView) this.mRootView.findViewById(R.id.no_network);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e, i);
        this.mNoDataView.onChangeSkinType(getPageContext(), i);
        this.mNetworkView.onChangeSkinType(getPageContext(), i);
    }

    private void aLf() {
        Intent intent = getIntent();
        if (intent != null) {
            this.list = intent.getParcelableArrayListExtra(OfficialAccountPushActivityConfig.OFFICIAL_LIST);
        }
    }

    public void boR() {
        this.fPR.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iL(R.string.no_data_text));
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public void cky() {
        this.fPR.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iL(R.string.refresh_view_title_text));
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        boolean z = BdSwitchView.SwitchState.ON == switchState;
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) view.getTag();
        if (officialAccountPushInfo != null) {
            c(z, officialAccountPushInfo.uid);
        }
    }

    public void c(boolean z, long j) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(6);
        requestUpdateMaskInfoMessage.setG_id(j);
        if (z) {
            requestUpdateMaskInfoMessage.setIsMask(0);
        } else {
            requestUpdateMaskInfoMessage.setIsMask(1);
        }
        requestUpdateMaskInfoMessage.setCallFrom(5);
        MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
        d(z, j);
    }

    private void d(boolean z, long j) {
        if (this.list != null && this.iWK != null) {
            if (!j.isNetWorkAvailable()) {
                this.iWK.notifyDataSetChanged();
                return;
            }
            for (int i = 0; i < this.list.size(); i++) {
                if (this.list.get(i).uid == j) {
                    if (z) {
                        this.list.get(i).iWO = 1;
                    } else {
                        this.list.get(i).iWO = 0;
                    }
                }
            }
            this.iWK.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
