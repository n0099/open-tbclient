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
    private ArrayList<MuteUser> Xq;
    private com.baidu.tbadk.core.view.b bbk;
    private UserMuteAddAndDelModel dgD;
    private l eeH;
    private h eeI;
    private m eeJ;
    private boolean cxx = false;
    private m.a eeK = new a(this);
    private CustomMessageListener eeL = new b(this, CmdConfigCustom.CMD_USER_MUTE_LIST_NEED_REFRESH);
    private CustomMessageListener eeM = new c(this, CmdConfigCustom.CMD_USER_MUTE_LIST_REMOVE_ITEM);
    private h.b eeN = new d(this);
    private h.a eeO = new e(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eeI = new h(this, this.eeN, this.eeO);
        this.eeH = new l(this, this.eeI);
        this.eeH.Mg().setAdapter((ListAdapter) this.eeI);
        this.eeJ = new m(this.eeK);
        this.dgD = new UserMuteAddAndDelModel(getPageContext());
        akp();
        registerListener(this.eeM);
        registerListener(this.eeL);
        this.eeJ.bZ(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eeJ.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cxx) {
            this.cxx = false;
            if (this.dgD != null) {
                akp();
                this.eeJ.bZ(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
            }
        }
    }

    private void akp() {
        if (!com.baidu.adp.lib.util.i.jf()) {
            this.eeH.aPq();
            return;
        }
        if (this.bbk == null) {
            this.bbk = new com.baidu.tbadk.core.view.b(getPageContext());
            this.bbk.c(new f(this));
        }
        this.bbk.ay(true);
    }
}
