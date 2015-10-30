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
    private ArrayList<MuteUser> Xh;
    private com.baidu.tbadk.core.view.a aLO;
    private l cOY;
    private h cOZ;
    private m cPa;
    private UserMuteAddAndDelModel cik;
    private boolean cas = false;
    private m.a cPb = new a(this);
    private CustomMessageListener cPc = new b(this, CmdConfigCustom.CMD_USER_MUTE_LIST_NEED_REFRESH);
    private CustomMessageListener cPd = new c(this, CmdConfigCustom.CMD_USER_MUTE_LIST_REMOVE_ITEM);
    private h.b cPe = new d(this);
    private h.a cPf = new e(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Zb();
        this.cPa = new m(this.cPb);
        this.cik = new UserMuteAddAndDelModel(this);
        registerListener(this.cPd);
        registerListener(this.cPc);
        this.cOZ = new h(this, this.cPe, this.cPf);
        this.cOY = new l(this, this.cOZ);
        this.cOY.getListView().setAdapter((ListAdapter) this.cOZ);
        this.cPa.bg(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cPa.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cas) {
            this.cas = false;
            if (this.cik != null) {
                Zb();
                this.cPa.bg(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
            }
        }
    }

    private void Zb() {
        if (this.aLO == null) {
            this.aLO = new com.baidu.tbadk.core.view.a(getPageContext());
            this.aLO.b(new f(this));
            return;
        }
        this.aLO.av(true);
    }
}
