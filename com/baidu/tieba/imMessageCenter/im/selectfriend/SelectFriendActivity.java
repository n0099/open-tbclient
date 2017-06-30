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
import com.baidu.tbadk.core.view.y;
import com.baidu.tbadk.coreExtra.relationship.GetContactListRequestMessage;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
public class SelectFriendActivity extends BaseActivity<SelectFriendActivity> {
    private LinearLayout aJF;
    NavigationBar aYl;
    BdListView bIQ;
    k dtf;
    private CustomMessageListener dtg;
    private CustomMessageListener dth;
    private y mNoDataView;
    private HttpMessageListener httpListener = new a(this, CmdConfigHttp.CMD_GET_FRIEND_LIST);
    private int dte = -1;
    private CustomMessageListener dti = new b(this, CmdConfigCustom.CMD_QUERY_CONTACT_LIST);
    private AdapterView.OnItemClickListener dtj = new c(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.j.select_friend_main);
        this.aJF = (LinearLayout) findViewById(w.h.select_friend_root_view);
        this.aYl = (NavigationBar) findViewById(w.h.select_friend_nevigation_bar);
        this.aYl.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new f(this));
        this.aYl.setTitleText(w.l.select_friend_title);
        this.bIQ = (BdListView) findViewById(w.h.select_friend_listview);
        this.dtf = new k(getPageContext().getPageActivity());
        this.bIQ.setAdapter((ListAdapter) this.dtf);
        this.bIQ.setOnItemClickListener(this.dtj);
        registerListener(this.dti);
        registerListener(this.httpListener);
        if (TbadkCoreApplication.m9getInst().getIntentClass(AddressListActivityConfig.class) == null) {
            sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_FRIEND_LIST));
        } else {
            MessageManager.getInstance().sendMessage(new GetContactListRequestMessage());
        }
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.adp.lib.util.k.g(getActivity(), w.f.ds220)), NoDataViewFactory.d.dg(w.l.select_friend_no_data_tip), null);
        this.aJF.addView(this.mNoDataView, 1);
        if (bundle != null) {
            this.dte = bundle.getInt("key_from_where");
        } else if (getIntent() != null) {
            this.dte = getIntent().getIntExtra("key_from_where", -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dtg != null) {
            MessageManager.getInstance().unRegisterListener(this.dtg);
            this.dtg = null;
        }
        if (this.dth != null) {
            MessageManager.getInstance().unRegisterListener(this.dth);
            this.dth = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.aYl.onChangeSkinType(getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(findViewById(w.h.select_friend_root_view));
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
    public void a(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ca(1);
        com.baidu.tieba.im.widget.b bVar = new com.baidu.tieba.im.widget.b(getPageContext().getPageActivity());
        bVar.setShareData(shareFromPBMsgData);
        aVar.v(bVar);
        aVar.a(w.l.share, new g(this, j, shareFromPBMsgData, str, str2, bVar));
        aVar.b(w.l.alert_no_button, new h(this, bVar));
        aVar.b(getPageContext()).ta();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, long j, String str, String str2) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ca(1);
        com.baidu.tieba.im.widget.b bVar = new com.baidu.tieba.im.widget.b(getPageContext().getPageActivity());
        bVar.setData(shareFromGameCenterMsgData);
        aVar.v(bVar);
        aVar.a(w.l.share, new i(this, j, shareFromGameCenterMsgData, str, str2, bVar));
        aVar.b(w.l.alert_no_button, new j(this, bVar));
        aVar.b(getPageContext()).ta();
    }
}
