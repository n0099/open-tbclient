package com.baidu.tieba.person.god;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class GodThreadListActivity extends BaseActivity<GodThreadListActivity> implements VoiceManager.c, FrsCommonImageLayout.c {
    protected VoiceManager bBm;
    private a eiA;
    private h eiB;
    private i eiC;
    private List<v> eiD;
    private MetaData eiE;
    private com.baidu.adp.lib.f.b<TbImageView> eiF;
    private long mUserId = 0;
    private int dMp = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bBm = getVoiceManager();
        if (this.bBm != null) {
            this.bBm.onCreate(getPageContext());
        }
        if (getIntent() != null) {
            this.mUserId = getIntent().getLongExtra("key_uid", 0L);
            this.dMp = getIntent().getIntExtra(GodThreadListActivityConfig.KEY_PAGE, 0);
            this.eiE = (MetaData) getIntent().getSerializableExtra(GodThreadListActivityConfig.KEY_AUTHOR);
        }
        this.eiD = new ArrayList();
        this.eiB = new h(this);
        this.eiA = new a(getPageContext(), this.eiB.aLu());
        this.eiC = new i(getPageContext());
        this.eiC.nZ(this.dMp);
        this.eiB.a(new d(this));
        this.eiB.a(new e(this));
        this.eiB.setOnSrollToBottomListener(new f(this));
        this.eiC.a(new g(this));
        this.eiB.jB();
        this.eiB.aLw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eiB != null) {
            this.eiB.onChangeSkinType(i);
        }
        if (this.eiA != null) {
            this.eiA.notifyDataSetChanged();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        this.bBm = getVoiceManager();
        if (this.bBm != null) {
            this.bBm.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.bBm == null) {
            this.bBm = VoiceManager.instance();
        }
        return this.bBm;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bBm = getVoiceManager();
        if (this.bBm != null) {
            this.bBm.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bBm = getVoiceManager();
        if (this.bBm != null) {
            this.bBm.onResume(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.bBm = getVoiceManager();
        if (this.bBm != null) {
            this.bBm.onDestory(getPageContext());
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.bBm = getVoiceManager();
        if (this.bBm != null) {
            this.bBm.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.bBm = getVoiceManager();
        if (this.bBm != null) {
            this.bBm.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.f.b<TbImageView> UV() {
        if (this.eiF == null) {
            this.eiF = FrsCommonImageLayout.o(getPageContext().getPageActivity(), 12);
        }
        return this.eiF;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR, stringExtra));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
