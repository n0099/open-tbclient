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
    private ArrayList<MuteUser> YA;
    private com.baidu.tbadk.core.view.b aUt;
    private UserMuteAddAndDelModel cFo;
    private l dwd;
    private h dwe;
    private m dwf;
    private boolean civ = false;
    private m.a dwg = new a(this);
    private CustomMessageListener dwh = new b(this, CmdConfigCustom.CMD_USER_MUTE_LIST_NEED_REFRESH);
    private CustomMessageListener dwi = new c(this, CmdConfigCustom.CMD_USER_MUTE_LIST_REMOVE_ITEM);
    private h.b dwj = new d(this);
    private h.a dwk = new e(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dwe = new h(this, this.dwj, this.dwk);
        this.dwd = new l(this, this.dwe);
        this.dwd.getListView().setAdapter((ListAdapter) this.dwe);
        this.dwf = new m(this.dwg);
        this.cFo = new UserMuteAddAndDelModel(getPageContext());
        adL();
        registerListener(this.dwi);
        registerListener(this.dwh);
        this.dwf.bL(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dwf.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.civ) {
            this.civ = false;
            if (this.cFo != null) {
                adL();
                this.dwf.bL(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
            }
        }
    }

    private void adL() {
        if (!com.baidu.adp.lib.util.i.iQ()) {
            this.dwd.ajD();
        } else if (this.aUt == null) {
            this.aUt = new com.baidu.tbadk.core.view.b(getPageContext());
            this.aUt.b(new f(this));
        } else {
            this.aUt.av(true);
        }
    }
}
