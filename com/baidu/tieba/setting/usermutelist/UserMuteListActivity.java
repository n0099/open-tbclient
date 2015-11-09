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
    private ArrayList<MuteUser> Xk;
    private com.baidu.tbadk.core.view.a aLW;
    private l cQu;
    private h cQv;
    private m cQw;
    private UserMuteAddAndDelModel cjm;
    private boolean caT = false;
    private m.a cQx = new a(this);
    private CustomMessageListener cQy = new b(this, CmdConfigCustom.CMD_USER_MUTE_LIST_NEED_REFRESH);
    private CustomMessageListener cQz = new c(this, CmdConfigCustom.CMD_USER_MUTE_LIST_REMOVE_ITEM);
    private h.b cQA = new d(this);
    private h.a cQB = new e(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Zw();
        this.cQw = new m(this.cQx);
        this.cjm = new UserMuteAddAndDelModel(this);
        registerListener(this.cQz);
        registerListener(this.cQy);
        this.cQv = new h(this, this.cQA, this.cQB);
        this.cQu = new l(this, this.cQv);
        this.cQu.getListView().setAdapter((ListAdapter) this.cQv);
        this.cQw.bg(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cQw.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.caT) {
            this.caT = false;
            if (this.cjm != null) {
                Zw();
                this.cQw.bg(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
            }
        }
    }

    private void Zw() {
        if (this.aLW == null) {
            this.aLW = new com.baidu.tbadk.core.view.a(getPageContext());
            this.aLW.b(new f(this));
            return;
        }
        this.aLW.av(true);
    }
}
