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
    protected VoiceManager ben;
    private a dcl;
    private g dcm;
    private h dcn;
    private List<u> dco;
    private MetaData dcp;
    private com.baidu.adp.lib.f.b<TbImageView> dcq;
    private long mUserId = 0;
    private int cJL = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ben = getVoiceManager();
        if (this.ben != null) {
            this.ben.onCreate(getPageContext());
        }
        if (getIntent() != null) {
            this.mUserId = getIntent().getLongExtra("key_uid", 0L);
            this.cJL = getIntent().getIntExtra(GodThreadListActivityConfig.KEY_PAGE, 0);
            this.dcp = (MetaData) getIntent().getSerializableExtra(GodThreadListActivityConfig.KEY_AUTHOR);
        }
        this.dco = new ArrayList();
        this.dcm = new g(this);
        this.dcl = new a(getPageContext(), this.dcm.auz());
        this.dcn = new h(getPageContext());
        this.dcn.lx(this.cJL);
        this.dcm.a(new c(this));
        this.dcm.a(new d(this));
        this.dcm.setOnSrollToBottomListener(new e(this));
        this.dcn.a(new f(this));
        this.dcm.ns();
        this.dcm.auB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dcm != null) {
            this.dcm.onChangeSkinType(i);
        }
        if (this.dcl != null) {
            this.dcl.notifyDataSetChanged();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        this.ben = getVoiceManager();
        if (this.ben != null) {
            this.ben.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.ben == null) {
            this.ben = VoiceManager.instance();
        }
        return this.ben;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.ben = getVoiceManager();
        if (this.ben != null) {
            this.ben.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.ben = getVoiceManager();
        if (this.ben != null) {
            this.ben.onResume(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.ben = getVoiceManager();
        if (this.ben != null) {
            this.ben.onDestory(getPageContext());
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.ben = getVoiceManager();
        if (this.ben != null) {
            this.ben.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.ben = getVoiceManager();
        if (this.ben != null) {
            this.ben.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.f.b<TbImageView> OC() {
        if (this.dcq == null) {
            this.dcq = FrsCommonImageLayout.l(getPageContext().getPageActivity(), 12);
        }
        return this.dcq;
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
