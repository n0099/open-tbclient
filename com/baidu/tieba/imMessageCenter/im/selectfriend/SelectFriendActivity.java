package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.n;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.s;
import com.baidu.tbadk.coreExtra.relationship.GetContactListRequestMessage;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class SelectFriendActivity extends BaseActivity<SelectFriendActivity> {
    private LinearLayout MG;
    NavigationBar anm;
    BdListView ann;
    h btb;
    private CustomMessageListener btc;
    private s mNoDataView;
    private HttpMessageListener bsZ = new a(this, CmdConfigHttp.CMD_GET_FRIEND_LIST);
    private int bta = -1;
    private CustomMessageListener btd = new b(this, 2001188);
    private AdapterView.OnItemClickListener itemClickListener = new c(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.select_friend_main);
        this.MG = (LinearLayout) findViewById(v.select_friend_root_view);
        this.anm = (NavigationBar) findViewById(v.select_friend_nevigation_bar);
        this.anm.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new e(this));
        this.anm.setTitleText(y.select_friend_title);
        this.ann = (BdListView) findViewById(v.select_friend_listview);
        this.btb = new h(getPageContext().getPageActivity());
        this.ann.setAdapter((ListAdapter) this.btb);
        this.ann.setOnItemClickListener(this.itemClickListener);
        registerListener(this.btd);
        registerListener(this.bsZ);
        if (TbadkCoreApplication.m411getInst().getIntentClass(AddressListActivityConfig.class) == null) {
            sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_FRIEND_LIST));
        } else {
            MessageManager.getInstance().sendMessage(new GetContactListRequestMessage());
        }
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.w.cq(y.select_friend_no_data_tip), null);
        this.MG.addView(this.mNoDataView, 1);
        if (bundle != null) {
            this.bta = bundle.getInt("key_from_where");
        } else if (getIntent() != null) {
            this.bta = getIntent().getIntExtra("key_from_where", -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.btc != null) {
            this.btc = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.anm.onChangeSkinType(getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().X(i == 1);
        getLayoutMode().h(findViewById(v.select_friend_root_view));
    }

    @Override // android.app.Activity
    protected void onStart() {
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
        aVar.a(new LinearLayout.LayoutParams(n.d(getPageContext().getPageActivity(), t.ds640), -2));
        aVar.bZ(shareFromGameCenterMsgData.getTitle());
        com.baidu.tieba.im.widget.b bVar = new com.baidu.tieba.im.widget.b(getPageContext().getPageActivity());
        bVar.setData(shareFromGameCenterMsgData);
        aVar.j(bVar);
        aVar.a(y.share, new f(this, j, shareFromGameCenterMsgData, str, str2, bVar));
        aVar.b(y.alert_no_button, new g(this, bVar));
        aVar.ad(false);
        aVar.b(getPageContext()).re();
    }
}
