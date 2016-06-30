package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.coreExtra.relationship.GetContactListRequestMessage;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class SelectFriendActivity extends BaseActivity<SelectFriendActivity> {
    private LinearLayout aAr;
    NavigationBar aOs;
    BdListView aWk;
    h dcQ;
    private CustomMessageListener dcR;
    private q mNoDataView;
    private HttpMessageListener dcO = new a(this, CmdConfigHttp.CMD_GET_FRIEND_LIST);
    private int dcP = -1;
    private CustomMessageListener dcS = new b(this, CmdConfigCustom.CMD_QUERY_CONTACT_LIST);
    private AdapterView.OnItemClickListener bXj = new c(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(u.h.select_friend_main);
        this.aAr = (LinearLayout) findViewById(u.g.select_friend_root_view);
        this.aOs = (NavigationBar) findViewById(u.g.select_friend_nevigation_bar);
        this.aOs.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new e(this));
        this.aOs.setTitleText(u.j.select_friend_title);
        this.aWk = (BdListView) findViewById(u.g.select_friend_listview);
        this.dcQ = new h(getPageContext().getPageActivity());
        this.aWk.setAdapter((ListAdapter) this.dcQ);
        this.aWk.setOnItemClickListener(this.bXj);
        registerListener(this.dcS);
        registerListener(this.dcO);
        if (TbadkCoreApplication.m9getInst().getIntentClass(AddressListActivityConfig.class) == null) {
            sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_FRIEND_LIST));
        } else {
            MessageManager.getInstance().sendMessage(new GetContactListRequestMessage());
        }
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, k.c(getActivity(), u.e.ds220)), NoDataViewFactory.d.cQ(u.j.select_friend_no_data_tip), null);
        this.aAr.addView(this.mNoDataView, 1);
        if (bundle != null) {
            this.dcP = bundle.getInt("key_from_where");
        } else if (getIntent() != null) {
            this.dcP = getIntent().getIntExtra("key_from_where", -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dcR != null) {
            this.dcR = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.aOs.onChangeSkinType(getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ad(i == 1);
        getLayoutMode().w(findViewById(u.g.select_friend_root_view));
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
        aVar.bO(1);
        com.baidu.tieba.im.widget.b bVar = new com.baidu.tieba.im.widget.b(getPageContext().getPageActivity());
        bVar.setData(shareFromGameCenterMsgData);
        aVar.y(bVar);
        aVar.a(u.j.share, new f(this, j, shareFromGameCenterMsgData, str, str2, bVar));
        aVar.b(u.j.alert_no_button, new g(this, bVar));
        aVar.b(getPageContext()).rT();
    }
}
