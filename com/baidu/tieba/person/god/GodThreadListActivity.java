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
    protected VoiceManager bEE;
    private a esE;
    private h esF;
    private i esG;
    private List<v> esH;
    private MetaData esI;
    private com.baidu.adp.lib.f.b<TbImageView> esJ;
    private long mUserId = 0;
    private int dYz = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bEE = getVoiceManager();
        if (this.bEE != null) {
            this.bEE.onCreate(getPageContext());
        }
        if (getIntent() != null) {
            this.mUserId = getIntent().getLongExtra("key_uid", 0L);
            this.dYz = getIntent().getIntExtra(GodThreadListActivityConfig.KEY_PAGE, 0);
            this.esI = (MetaData) getIntent().getSerializableExtra(GodThreadListActivityConfig.KEY_AUTHOR);
        }
        this.esH = new ArrayList();
        this.esF = new h(this);
        this.esE = new a(getPageContext(), this.esF.aNX());
        this.esG = new i(getPageContext());
        this.esG.ok(this.dYz);
        this.esF.a(new d(this));
        this.esF.a(new e(this));
        this.esF.setOnSrollToBottomListener(new f(this));
        this.esG.a(new g(this));
        this.esF.jA();
        this.esF.aNZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.esF != null) {
            this.esF.onChangeSkinType(i);
        }
        if (this.esE != null) {
            this.esE.notifyDataSetChanged();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        this.bEE = getVoiceManager();
        if (this.bEE != null) {
            this.bEE.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.bEE == null) {
            this.bEE = VoiceManager.instance();
        }
        return this.bEE;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bEE = getVoiceManager();
        if (this.bEE != null) {
            this.bEE.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bEE = getVoiceManager();
        if (this.bEE != null) {
            this.bEE.onResume(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.bEE = getVoiceManager();
        if (this.bEE != null) {
            this.bEE.onDestory(getPageContext());
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.bEE = getVoiceManager();
        if (this.bEE != null) {
            this.bEE.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.bEE = getVoiceManager();
        if (this.bEE != null) {
            this.bEE.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.f.b<TbImageView> VH() {
        if (this.esJ == null) {
            this.esJ = FrsCommonImageLayout.o(getPageContext().getPageActivity(), 12);
        }
        return this.esJ;
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
