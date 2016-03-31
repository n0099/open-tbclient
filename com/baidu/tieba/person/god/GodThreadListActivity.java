package com.baidu.tieba.person.god;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.u;
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
    protected VoiceManager bja;
    private a dwO;
    private g dwP;
    private h dwQ;
    private List<u> dwR;
    private MetaData dwS;
    private com.baidu.adp.lib.f.b<TbImageView> dwT;
    private long mUserId = 0;
    private int ddc = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bja = getVoiceManager();
        if (this.bja != null) {
            this.bja.onCreate(getPageContext());
        }
        if (getIntent() != null) {
            this.mUserId = getIntent().getLongExtra("key_uid", 0L);
            this.ddc = getIntent().getIntExtra(GodThreadListActivityConfig.KEY_PAGE, 0);
            this.dwS = (MetaData) getIntent().getSerializableExtra(GodThreadListActivityConfig.KEY_AUTHOR);
        }
        this.dwR = new ArrayList();
        this.dwP = new g(this);
        this.dwO = new a(getPageContext(), this.dwP.aCf());
        this.dwQ = new h(getPageContext());
        this.dwQ.mG(this.ddc);
        this.dwP.a(new c(this));
        this.dwP.a(new d(this));
        this.dwP.setOnSrollToBottomListener(new e(this));
        this.dwQ.a(new f(this));
        this.dwP.nk();
        this.dwP.aCh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dwP != null) {
            this.dwP.onChangeSkinType(i);
        }
        if (this.dwO != null) {
            this.dwO.notifyDataSetChanged();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        this.bja = getVoiceManager();
        if (this.bja != null) {
            this.bja.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.bja == null) {
            this.bja = VoiceManager.instance();
        }
        return this.bja;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bja = getVoiceManager();
        if (this.bja != null) {
            this.bja.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bja = getVoiceManager();
        if (this.bja != null) {
            this.bja.onResume(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.bja = getVoiceManager();
        if (this.bja != null) {
            this.bja.onDestory(getPageContext());
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.bja = getVoiceManager();
        if (this.bja != null) {
            this.bja.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.bja = getVoiceManager();
        if (this.bja != null) {
            this.bja.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.f.b<TbImageView> Qr() {
        if (this.dwT == null) {
            this.dwT = FrsCommonImageLayout.o(getPageContext().getPageActivity(), 12);
        }
        return this.dwT;
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
