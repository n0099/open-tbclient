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
/* loaded from: classes13.dex */
public class OfficialAccountPushActivity extends BaseActivity<OfficialAccountPushActivity> implements BdSwitchView.a {
    private BdListView hJK = null;
    private a kXX = null;
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
        buk();
        bmb();
        bma();
    }

    private void bma() {
        if (!j.isNetWorkAvailable() && v.isEmpty(this.list)) {
            cZf();
        } else if (v.isEmpty(this.list)) {
            bZW();
        } else if (this.kXX == null) {
            this.kXX = new a(getPageContext());
            this.kXX.setData(this.list);
            this.hJK.setAdapter((ListAdapter) this.kXX);
            this.kXX.setSwitchStateChangeListener(this);
        } else {
            this.kXX.setData(this.list);
            this.kXX.notifyDataSetChanged();
        }
    }

    private void bmb() {
        this.mRootView = (ViewGroup) findViewById(R.id.official_account_push_container);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_CENTER, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.offical_account_push_msg));
        this.hJK = (BdListView) findViewById(R.id.list);
        this.mNoDataView = NoDataViewFactory.a(this, this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds120)), NoDataViewFactory.d.lT(R.string.no_data_text), null);
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

    private void buk() {
        Intent intent = getIntent();
        if (intent != null) {
            this.list = intent.getParcelableArrayListExtra(OfficialAccountPushActivityConfig.OFFICIAL_LIST);
        }
    }

    public void bZW() {
        this.hJK.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.lT(R.string.no_data_text));
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    public void cZf() {
        this.hJK.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.lT(R.string.refresh_view_title_text));
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        boolean z = BdSwitchView.SwitchState.ON == switchState;
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) view.getTag();
        if (officialAccountPushInfo != null) {
            d(z, officialAccountPushInfo.uid);
        }
    }

    public void d(boolean z, long j) {
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
        e(z, j);
    }

    private void e(boolean z, long j) {
        if (this.list != null && this.kXX != null) {
            if (!j.isNetWorkAvailable()) {
                this.kXX.notifyDataSetChanged();
                return;
            }
            for (int i = 0; i < this.list.size(); i++) {
                if (this.list.get(i).uid == j) {
                    if (z) {
                        this.list.get(i).is_on = 1;
                    } else {
                        this.list.get(i).is_on = 0;
                    }
                }
            }
            this.kXX.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
