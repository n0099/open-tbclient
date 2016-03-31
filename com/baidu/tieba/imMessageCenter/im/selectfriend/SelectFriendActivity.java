package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.p;
import com.baidu.tbadk.coreExtra.relationship.GetContactListRequestMessage;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class SelectFriendActivity extends BaseActivity<SelectFriendActivity> {
    private LinearLayout aDv;
    NavigationBar aOK;
    BdListView aWV;
    h cwy;
    private CustomMessageListener cwz;
    private p mNoDataView;
    private HttpMessageListener cww = new a(this, CmdConfigHttp.CMD_GET_FRIEND_LIST);
    private int cwx = -1;
    private CustomMessageListener cwA = new b(this, CmdConfigCustom.CMD_QUERY_CONTACT_LIST);
    private AdapterView.OnItemClickListener bzC = new c(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.select_friend_main);
        this.aDv = (LinearLayout) findViewById(t.g.select_friend_root_view);
        this.aOK = (NavigationBar) findViewById(t.g.select_friend_nevigation_bar);
        this.aOK.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new e(this));
        this.aOK.setTitleText(t.j.select_friend_title);
        this.aWV = (BdListView) findViewById(t.g.select_friend_listview);
        this.cwy = new h(getPageContext().getPageActivity());
        this.aWV.setAdapter((ListAdapter) this.cwy);
        this.aWV.setOnItemClickListener(this.bzC);
        registerListener(this.cwA);
        registerListener(this.cww);
        if (TbadkCoreApplication.m411getInst().getIntentClass(AddressListActivityConfig.class) == null) {
            sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_FRIEND_LIST));
        } else {
            MessageManager.getInstance().sendMessage(new GetContactListRequestMessage());
        }
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dg(t.j.select_friend_no_data_tip), null);
        this.aDv.addView(this.mNoDataView, 1);
        if (bundle != null) {
            this.cwx = bundle.getInt("key_from_where");
        } else if (getIntent() != null) {
            this.cwx = getIntent().getIntExtra("key_from_where", -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cwz != null) {
            this.cwz = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.aOK.onChangeSkinType(getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ab(i == 1);
        getLayoutMode().x(findViewById(t.g.select_friend_root_view));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.mNoDataView.e(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.mNoDataView.onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, long j, String str, String str2) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cc(1);
        com.baidu.tieba.im.widget.b bVar = new com.baidu.tieba.im.widget.b(getPageContext().getPageActivity());
        bVar.setData(shareFromGameCenterMsgData);
        aVar.z(bVar);
        aVar.a(t.j.share, new f(this, j, shareFromGameCenterMsgData, str, str2, bVar));
        aVar.b(t.j.alert_no_button, new g(this, bVar));
        aVar.b(getPageContext()).up();
    }
}
