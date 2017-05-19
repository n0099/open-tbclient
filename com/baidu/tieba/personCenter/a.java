package com.baidu.tieba.personCenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.personPolymeric.b.aa;
import com.baidu.tieba.personPolymeric.b.ab;
/* loaded from: classes.dex */
public class a extends BaseFragment implements VoiceManager.c {
    ab eyp;
    private VoiceManager eyq;
    private CustomMessageListener eys;
    private long userId;
    private boolean isSelf = true;
    private boolean eyr = false;
    private boolean eyt = false;
    private CustomMessageListener eyu = new b(this, CmdConfigCustom.CMD_CHANGE_PERSONAL_BACKGROUND);

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mIsLogin = TbadkCoreApplication.isLogin();
        if (getArguments() != null) {
            this.eyr = getArguments().getBoolean(PersonPolymericActivityConfig.RESOURCE_TYPE);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        t(bundle);
        if (this.userId <= 0 && TbadkCoreApplication.getCurrentAccount() != null) {
            this.userId = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.eyq = VoiceManager.instance();
        this.eyp = new ab(getBaseFragmentActivity(), getUniqueId(), this.userId, this.isSelf, this.eyr);
        this.eyp.a(this);
        if (this.eyp != null) {
            this.eyp.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
        this.eys = new c(this, CmdConfigCustom.CMD_HOME_HIDE_GUIDE);
        this.eys.setTag(getUniqueId());
        registerListener(this.eys);
        this.eyu.setTag(getUniqueId());
        registerListener(this.eyu);
        return this.eyp.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.eyr) {
            return null;
        }
        return "a011";
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.eyq.onStart(getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            if (isPrimary()) {
                this.eyp.aPL();
                if (this.mIsLogin) {
                    this.eyp.aPO();
                    return;
                } else {
                    this.eyp.aPP();
                    return;
                }
            }
            this.eyp.aPP();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.eyr) {
            this.eyp.aPL();
        }
        if (this.mIsLogin) {
            this.eyp.aPO();
        } else {
            this.eyp.aPP();
        }
        this.eyq.onResume(getPageContext());
        if (this.eyt) {
            this.eyp.aPQ();
            this.eyt = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.eyq.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.eyq.onStop(getPageContext());
    }

    private void t(Bundle bundle) {
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.userId = intent.getLongExtra("user_id", com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.isSelf = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_USER_SELF, true);
        } else if (bundle != null) {
            this.userId = bundle.getLong("user_id", com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.isSelf = bundle.getBoolean(PersonPolymericActivityConfig.IS_USER_SELF, true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.eyq.onDestory(getPageContext());
        this.eyp.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putLong("user_id", this.userId);
            bundle.putBoolean(PersonPolymericActivityConfig.IS_USER_SELF, this.isSelf);
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
                    this.eyp.resetData();
                    this.eyp.NA();
                    return;
                case 12002:
                    if (intent != null) {
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            aa.z(getPageContext());
                            return;
                        } else if (this.eyp.aPM() != null) {
                            this.eyp.aPM().Q(intent);
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
                            if (this.eyp.aPM() != null) {
                                this.eyp.aPM().aPG();
                                this.eyp.aPM().aPH();
                                return;
                            }
                            return;
                        } else if (intExtra == 2 && this.eyp.aPM() != null) {
                            this.eyp.aPM().aPI();
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
                            if (this.eyp.aPM() != null) {
                                this.eyp.aPM().aPG();
                                this.eyp.aPM().aPH();
                                return;
                            }
                            return;
                        } else if (intExtra2 == 2 && this.eyp.aPM() != null) {
                            this.eyp.aPM().aPI();
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 24001:
                    if (intent != null) {
                        this.eyp.resetData();
                        this.eyp.NA();
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
        return this.eyq;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eyp != null) {
            this.eyp.onChangeSkinType(i);
        }
    }
}
