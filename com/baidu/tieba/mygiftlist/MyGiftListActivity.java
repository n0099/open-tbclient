package com.baidu.tieba.mygiftlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.view.u;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class MyGiftListActivity extends BaseActivity {
    private j bsT;
    private k bsU;
    private boolean mIsHost;
    private String st_type;
    private String bsV = null;
    private int sex = 0;
    private long Mm = 0;
    MyGiftNotifyMessage bsW = new MyGiftNotifyMessage();
    private u ati = new a(this);
    private final CustomMessageListener bsX = new b(this, 2001238);
    private final com.baidu.adp.framework.listener.e ayJ = new c(this, 308002);
    private aa bsY = new d(this);

    static {
        TbadkApplication.m251getInst().RegisterIntent(MyGiftListActivityConfig.class, MyGiftListActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tbadk.coreExtra.messageCenter.a.oB().oQ();
        Intent intent = getIntent();
        if (intent != null) {
            this.bsV = intent.getStringExtra("id");
            this.st_type = intent.getStringExtra("st_type");
            this.sex = intent.getIntExtra(MyGiftListActivityConfig.USER_SEX, 0);
        }
        if (this.bsV != null) {
            this.Mm = com.baidu.adp.lib.g.c.a(this.bsV, 0L);
        }
        this.bsT = new j(this, this.st_type);
        this.bsT.setUid(this.Mm);
        this.mIsHost = this.bsT.getIsSelf();
        initUI();
        this.ayJ.setSelfListener(true);
        registerListener(this.ayJ);
        registerListener(this.bsX);
        this.bsT.dR(false);
        this.bsT.LoadData();
        com.baidu.tbadk.coreExtra.messageCenter.a.oB().setMsgGiftNum(0);
        MessageManager.getInstance().dispatchResponsedMessage(this.bsW);
    }

    private void initUI() {
        this.bsU = new k(this, this.bsY, this.mIsHost);
        this.bsU.b(new e(this));
        VF();
    }

    public View.OnClickListener VE() {
        return new f(this);
    }

    private void VF() {
        this.bsU.g(this.ati);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bsU.onChangeSkinType(i);
    }

    public String VG() {
        String string = getString(y.he);
        if (this.sex == 2) {
            return getString(y.she);
        }
        return string;
    }
}
