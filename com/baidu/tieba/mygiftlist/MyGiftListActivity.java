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
    private j bth;
    private k bti;
    private boolean mIsHost;
    private String st_type;
    private String btj = null;
    private int sex = 0;
    private long Mp = 0;
    MyGiftNotifyMessage btk = new MyGiftNotifyMessage();
    private u atr = new a(this);
    private final CustomMessageListener btl = new b(this, 2001238);
    private final com.baidu.adp.framework.listener.e ayS = new c(this, 308002);
    private aa btm = new d(this);

    static {
        TbadkApplication.m251getInst().RegisterIntent(MyGiftListActivityConfig.class, MyGiftListActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tbadk.coreExtra.messageCenter.a.oD().oS();
        Intent intent = getIntent();
        if (intent != null) {
            this.btj = intent.getStringExtra("id");
            this.st_type = intent.getStringExtra("st_type");
            this.sex = intent.getIntExtra(MyGiftListActivityConfig.USER_SEX, 0);
        }
        if (this.btj != null) {
            this.Mp = com.baidu.adp.lib.g.c.a(this.btj, 0L);
        }
        this.bth = new j(this, this.st_type);
        this.bth.setUid(this.Mp);
        this.mIsHost = this.bth.getIsSelf();
        initUI();
        this.ayS.setSelfListener(true);
        registerListener(this.ayS);
        registerListener(this.btl);
        this.bth.dR(false);
        this.bth.LoadData();
        com.baidu.tbadk.coreExtra.messageCenter.a.oD().setMsgGiftNum(0);
        MessageManager.getInstance().dispatchResponsedMessage(this.btk);
    }

    private void initUI() {
        this.bti = new k(this, this.btm, this.mIsHost);
        this.bti.b(new e(this));
        VI();
    }

    public View.OnClickListener VH() {
        return new f(this);
    }

    private void VI() {
        this.bti.g(this.atr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bti.onChangeSkinType(i);
    }

    public String VJ() {
        String string = getString(y.he);
        if (this.sex == 2) {
            return getString(y.she);
        }
        return string;
    }
}
