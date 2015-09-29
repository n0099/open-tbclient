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
    private ArrayList<MuteUser> Xf;
    private com.baidu.tbadk.core.view.a aLD;
    private h cOA;
    private m cOB;
    private l cOz;
    private UserMuteAddAndDelModel chY;
    private boolean cah = false;
    private m.a cOC = new a(this);
    private CustomMessageListener cOD = new b(this, CmdConfigCustom.CMD_USER_MUTE_LIST_NEED_REFRESH);
    private CustomMessageListener cOE = new c(this, CmdConfigCustom.CMD_USER_MUTE_LIST_REMOVE_ITEM);
    private h.b cOF = new d(this);
    private h.a cOG = new e(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Zf();
        this.cOB = new m(this.cOC);
        this.chY = new UserMuteAddAndDelModel(this);
        registerListener(this.cOE);
        registerListener(this.cOD);
        this.cOA = new h(this, this.cOF, this.cOG);
        this.cOz = new l(this, this.cOA);
        this.cOz.getListView().setAdapter((ListAdapter) this.cOA);
        this.cOB.aY(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cOB.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cah) {
            this.cah = false;
            if (this.chY != null) {
                Zf();
                this.cOB.aY(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
            }
        }
    }

    private void Zf() {
        if (this.aLD == null) {
            this.aLD = new com.baidu.tbadk.core.view.a(getPageContext());
            this.aLD.b(new f(this));
            return;
        }
        this.aLD.av(true);
    }
}
