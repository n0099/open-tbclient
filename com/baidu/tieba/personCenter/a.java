package com.baidu.tieba.personCenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.personPolymeric.b.aj;
import com.baidu.tieba.personPolymeric.b.o;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends BaseFragment implements VoiceManager.c {
    private o bzs;
    private VoiceManager eQW;
    private long userId;
    private boolean isSelf = true;
    @Deprecated
    private boolean isBigV = false;
    private boolean bzn = false;
    private boolean cdu = false;
    private long euG = 0;
    private CustomMessageListener dRF = new b(this, CmdConfigCustom.CMD_REFRESH_PERSONAL);
    private CustomMessageListener cdk = new c(this, CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED);

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mIsLogin = TbadkCoreApplication.isLogin();
        if (getArguments() != null) {
            this.bzn = getArguments().getBoolean(PersonPolymericActivityConfig.RESOURCE_TYPE);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        t(bundle);
        View inflate = layoutInflater.inflate(w.j.fragment_person_center_layout, (ViewGroup) null);
        if (this.userId <= 0 && TbadkCoreApplication.getCurrentAccount() != null) {
            this.userId = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.bzs = new o(this, inflate, getUniqueId(), this.userId, this.isSelf, this.bzn);
        this.eQW = VoiceManager.instance();
        this.dRF.setTag(getUniqueId());
        registerListener(this.dRF);
        registerListener(this.cdk);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.bzn) {
            return null;
        }
        return "a011";
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.eQW.onStart(getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            this.bzs.dq(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.eQW.onResume(getPageContext());
        this.bzs.onResume();
        if (!this.isSelf && this.isBigV) {
            this.euG = System.currentTimeMillis();
        } else {
            this.euG = -1L;
        }
        if (this.cdu && this.bzs.aVb() != null) {
            this.bzs.aVb().UW();
            this.cdu = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.eQW.onPause(getPageContext());
        if (this.euG > 0) {
            TiebaStatic.log(new au("c12263").Z("obj_duration", String.valueOf((System.currentTimeMillis() - this.euG) / 1000)).r("obj_type", 2));
            this.euG = 0L;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.eQW.onStop(getPageContext());
    }

    private void t(Bundle bundle) {
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.userId = intent.getLongExtra("user_id", com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.isSelf = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_USER_SELF, true);
            this.isBigV = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_BIGV, false);
        } else if (bundle != null) {
            this.userId = bundle.getLong("user_id", com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.isSelf = bundle.getBoolean(PersonPolymericActivityConfig.IS_USER_SELF, true);
            this.isBigV = bundle.getBoolean(PersonPolymericActivityConfig.IS_BIGV, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.cdk);
        this.eQW.onDestory(getPageContext());
        if (this.bzs != null) {
            this.bzs.onDestroy();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putLong("user_id", this.userId);
            bundle.putBoolean(PersonPolymericActivityConfig.IS_USER_SELF, this.isSelf);
            bundle.putBoolean(PersonPolymericActivityConfig.IS_BIGV, this.isBigV);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 101:
                    if (this.bzs.aVb() instanceof com.baidu.tieba.model.b) {
                        ((com.baidu.tieba.model.b) this.bzs.aVb()).resetData();
                        ((com.baidu.tieba.model.b) this.bzs.aVb()).OZ();
                        return;
                    }
                    return;
                case 12002:
                    if (intent != null) {
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            aj.y(getPageContext());
                            return;
                        } else if (this.bzs.aVc() != null) {
                            this.bzs.aVc().Q(intent);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 12009:
                case 12010:
                    if (intent != null) {
                        int intExtra = intent.getIntExtra("upload_image_type", 0);
                        if (intExtra == 1) {
                            if (this.bzs.aVc() != null) {
                                this.bzs.aVc().aVn();
                                this.bzs.aVc().aVo();
                                return;
                            }
                            return;
                        } else if (intExtra == 2 && this.bzs.aVc() != null) {
                            this.bzs.aVc().aVp();
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 12014:
                    if (intent != null) {
                        int intExtra2 = intent.getIntExtra("upload_image_type", 0);
                        if (intExtra2 == 1) {
                            if (this.bzs.aVc() != null) {
                                this.bzs.aVc().aVn();
                                this.bzs.aVc().aVo();
                                return;
                            }
                            return;
                        } else if (intExtra2 == 2 && this.bzs.aVc() != null) {
                            this.bzs.aVc().aVp();
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 24001:
                    if (intent != null && (this.bzs.aVb() instanceof com.baidu.tieba.model.b)) {
                        ((com.baidu.tieba.model.b) this.bzs.aVb()).resetData();
                        ((com.baidu.tieba.model.b) this.bzs.aVb()).OZ();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.eQW;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.bzs != null) {
            this.bzs.onChangeSkinType(i);
        }
    }
}
