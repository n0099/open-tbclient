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
    private ArrayList<MuteUser> Xe;
    private com.baidu.tbadk.core.view.a aMv;
    private UserMuteAddAndDelModel caO;
    private l cza;
    private h czb;
    private com.baidu.tieba.usermute.k czc;
    private boolean bVP = false;
    private k.a czd = new a(this);
    private CustomMessageListener cze = new b(this, CmdConfigCustom.CMD_USER_MUTE_LIST_NEED_REFRESH);
    private CustomMessageListener czf = new c(this, CmdConfigCustom.CMD_USER_MUTE_LIST_REMOVE_ITEM);
    private h.b czg = new d(this);
    private h.a czh = new e(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Yv();
        this.czc = new com.baidu.tieba.usermute.k(this.czd);
        this.caO = new UserMuteAddAndDelModel(this);
        registerListener(this.czf);
        registerListener(this.cze);
        this.czb = new h(this, this.czg, this.czh);
        this.cza = new l(this, this.czb);
        this.cza.getListView().setAdapter((ListAdapter) this.czb);
        this.czc.aB(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.czc.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bVP) {
            this.bVP = false;
            if (this.caO != null) {
                Yv();
                this.czc.aB(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
            }
        }
    }

    private void Yv() {
        if (this.aMv == null) {
            this.aMv = new com.baidu.tbadk.core.view.a(getPageContext());
            this.aMv.b(new f(this));
            return;
        }
        this.aMv.av(true);
    }
}
