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
    protected VoiceManager beZ;
    private a dzT;
    private g dzU;
    private h dzV;
    private List<v> dzW;
    private MetaData dzX;
    private com.baidu.adp.lib.f.b<TbImageView> dzY;
    private long mUserId = 0;
    private int dfw = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.beZ = getVoiceManager();
        if (this.beZ != null) {
            this.beZ.onCreate(getPageContext());
        }
        if (getIntent() != null) {
            this.mUserId = getIntent().getLongExtra("key_uid", 0L);
            this.dfw = getIntent().getIntExtra(GodThreadListActivityConfig.KEY_PAGE, 0);
            this.dzX = (MetaData) getIntent().getSerializableExtra(GodThreadListActivityConfig.KEY_AUTHOR);
        }
        this.dzW = new ArrayList();
        this.dzU = new g(this);
        this.dzT = new a(getPageContext(), this.dzU.aCz());
        this.dzV = new h(getPageContext());
        this.dzV.mx(this.dfw);
        this.dzU.a(new c(this));
        this.dzU.a(new d(this));
        this.dzU.setOnSrollToBottomListener(new e(this));
        this.dzV.a(new f(this));
        this.dzU.jy();
        this.dzU.aCB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dzU != null) {
            this.dzU.onChangeSkinType(i);
        }
        if (this.dzT != null) {
            this.dzT.notifyDataSetChanged();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        this.beZ = getVoiceManager();
        if (this.beZ != null) {
            this.beZ.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.beZ == null) {
            this.beZ = VoiceManager.instance();
        }
        return this.beZ;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.beZ = getVoiceManager();
        if (this.beZ != null) {
            this.beZ.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.beZ = getVoiceManager();
        if (this.beZ != null) {
            this.beZ.onResume(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.beZ = getVoiceManager();
        if (this.beZ != null) {
            this.beZ.onDestory(getPageContext());
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.beZ = getVoiceManager();
        if (this.beZ != null) {
            this.beZ.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.beZ = getVoiceManager();
        if (this.beZ != null) {
            this.beZ.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.f.b<TbImageView> Pq() {
        if (this.dzY == null) {
            this.dzY = FrsCommonImageLayout.o(getPageContext().getPageActivity(), 12);
        }
        return this.dzY;
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
