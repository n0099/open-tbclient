package com.baidu.tieba.setting.usermutelist;

import android.os.Bundle;
import android.widget.ListAdapter;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.setting.usermutelist.h;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.k;
import java.util.ArrayList;
import tbclient.UserMuteQuery.MuteUser;
/* loaded from: classes.dex */
public class UserMuteListActivity extends BaseActivity<UserMuteListActivity> {
    private ArrayList<MuteUser> Xn;
    private com.baidu.tbadk.core.view.a aMI;
    private com.baidu.tieba.usermute.k cHA;
    private l cHy;
    private h cHz;
    private UserMuteAddAndDelModel cbJ;
    private boolean bWv = false;
    private k.a cHB = new a(this);
    private CustomMessageListener cHC = new b(this, CmdConfigCustom.CMD_USER_MUTE_LIST_NEED_REFRESH);
    private CustomMessageListener cHD = new c(this, CmdConfigCustom.CMD_USER_MUTE_LIST_REMOVE_ITEM);
    private h.b cHE = new d(this);
    private h.a cHF = new e(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Yx();
        this.cHA = new com.baidu.tieba.usermute.k(this.cHB);
        this.cbJ = new UserMuteAddAndDelModel(this);
        registerListener(this.cHD);
        registerListener(this.cHC);
        this.cHz = new h(this, this.cHE, this.cHF);
        this.cHy = new l(this, this.cHz);
        this.cHy.getListView().setAdapter((ListAdapter) this.cHz);
        this.cHA.aG(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cHA.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bWv) {
            this.bWv = false;
            if (this.cbJ != null) {
                Yx();
                this.cHA.aG(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
            }
        }
    }

    private void Yx() {
        if (this.aMI == null) {
            this.aMI = new com.baidu.tbadk.core.view.a(getPageContext());
            this.aMI.b(new f(this));
            return;
        }
        this.aMI.av(true);
    }
}
