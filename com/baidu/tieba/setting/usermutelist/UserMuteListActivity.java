package com.baidu.tieba.setting.usermutelist;

import android.os.Bundle;
import android.widget.ListAdapter;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.setting.usermutelist.h;
import com.baidu.tieba.setting.usermutelist.m;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import java.util.ArrayList;
import tbclient.UserMuteQuery.MuteUser;
/* loaded from: classes.dex */
public class UserMuteListActivity extends BaseActivity<UserMuteListActivity> {
    private ArrayList<MuteUser> XX;
    private com.baidu.tbadk.core.view.b aQC;
    private UserMuteAddAndDelModel cBJ;
    private l doQ;
    private h doR;
    private m doS;
    private boolean cet = false;
    private m.a doT = new a(this);
    private CustomMessageListener doU = new b(this, CmdConfigCustom.CMD_USER_MUTE_LIST_NEED_REFRESH);
    private CustomMessageListener doV = new c(this, CmdConfigCustom.CMD_USER_MUTE_LIST_REMOVE_ITEM);
    private h.b doW = new d(this);
    private h.a doX = new e(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        acC();
        this.doS = new m(this.doT);
        this.cBJ = new UserMuteAddAndDelModel(getPageContext());
        registerListener(this.doV);
        registerListener(this.doU);
        this.doR = new h(this, this.doW, this.doX);
        this.doQ = new l(this, this.doR);
        this.doQ.getListView().setAdapter((ListAdapter) this.doR);
        this.doS.bC(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.doS.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cet) {
            this.cet = false;
            if (this.cBJ != null) {
                acC();
                this.doS.bC(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
            }
        }
    }

    private void acC() {
        if (this.aQC == null) {
            this.aQC = new com.baidu.tbadk.core.view.b(getPageContext());
            this.aQC.b(new f(this));
            return;
        }
        this.aQC.ay(true);
    }
}
