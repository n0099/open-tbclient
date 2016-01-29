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
    private ArrayList<MuteUser> YX;
    private com.baidu.tbadk.core.view.b aWB;
    private UserMuteAddAndDelModel cMI;
    private l dMh;
    private h dMi;
    private m dMj;
    private boolean cmV = false;
    private m.a dMk = new a(this);
    private CustomMessageListener dMl = new b(this, CmdConfigCustom.CMD_USER_MUTE_LIST_NEED_REFRESH);
    private CustomMessageListener dMm = new c(this, CmdConfigCustom.CMD_USER_MUTE_LIST_REMOVE_ITEM);
    private h.b dMn = new d(this);
    private h.a dMo = new e(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dMi = new h(this, this.dMn, this.dMo);
        this.dMh = new l(this, this.dMi);
        this.dMh.KM().setAdapter((ListAdapter) this.dMi);
        this.dMj = new m(this.dMk);
        this.cMI = new UserMuteAddAndDelModel(getPageContext());
        agV();
        registerListener(this.dMm);
        registerListener(this.dMl);
        this.dMj.bP(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dMj.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cmV) {
            this.cmV = false;
            if (this.cMI != null) {
                agV();
                this.dMj.bP(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
            }
        }
    }

    private void agV() {
        if (!com.baidu.adp.lib.util.i.iZ()) {
            this.dMh.anB();
        } else if (this.aWB == null) {
            this.aWB = new com.baidu.tbadk.core.view.b(getPageContext());
            this.aWB.b(new f(this));
        } else {
            this.aWB.aw(true);
        }
    }
}
