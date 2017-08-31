package com.baidu.tieba.personCenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.b.d;
import com.baidu.tieba.personPolymeric.b.g;
/* loaded from: classes.dex */
public class a extends BaseFragment implements VoiceManager.c {
    private d bIm;
    private VoiceManager feS;
    private long userId;
    private boolean isSelf = true;
    @Deprecated
    private boolean isBigV = false;
    private boolean bIh = false;
    private boolean cqs = false;
    private long eHr = 0;
    private CustomMessageListener ekz = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH_PERSONAL) { // from class: com.baidu.tieba.personCenter.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.isSelf) {
                a.this.cqs = true;
            }
        }
    };
    private HttpMessageListener erD = new HttpMessageListener(CmdConfigHttp.GETPAYINFO_CMD) { // from class: com.baidu.tieba.personCenter.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001505) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode == 200 && error == 0 && a.this.bIm != null) {
                    a.this.bIm.kr(true);
                }
            }
        }
    };
    private CustomMessageListener cqi = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personCenter.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data) && a.this.bIm != null) {
                    a.this.bIm.kr(true);
                }
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mIsLogin = TbadkCoreApplication.isLogin();
        if (getArguments() != null) {
            this.bIh = getArguments().getBoolean(PersonPolymericActivityConfig.RESOURCE_TYPE);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        x(bundle);
        View inflate = layoutInflater.inflate(d.j.fragment_person_center_layout, (ViewGroup) null);
        if (this.userId <= 0 && TbadkCoreApplication.getCurrentAccount() != null) {
            this.userId = b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.bIm = new com.baidu.tieba.personPolymeric.b.d(this, inflate, getUniqueId(), this.userId, this.isSelf, this.bIh);
        this.feS = VoiceManager.instance();
        this.ekz.setTag(getUniqueId());
        registerListener(this.ekz);
        registerListener(this.cqi);
        registerListener(this.erD);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.bIh) {
            return null;
        }
        return "a011";
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.feS.onStart(getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            this.bIm.dD(isPrimary());
            com.baidu.tieba.j.a.bhY().lO(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.feS.onResume(getPageContext());
        this.bIm.onResume();
        if (!this.isSelf && this.isBigV) {
            this.eHr = System.currentTimeMillis();
        } else {
            this.eHr = -1L;
        }
        if (this.cqs && this.bIm.aXV() != null) {
            this.bIm.aXV().Xf();
            this.cqs = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.feS.onPause(getPageContext());
        if (this.eHr > 0) {
            TiebaStatic.log(new ak("c12263").ad("obj_duration", String.valueOf((System.currentTimeMillis() - this.eHr) / 1000)).r("obj_type", 2));
            this.eHr = 0L;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.feS.onStop(getPageContext());
    }

    private void x(Bundle bundle) {
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.userId = intent.getLongExtra("user_id", b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.isSelf = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_USER_SELF, true);
            this.isBigV = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_BIGV, false);
        } else if (bundle != null) {
            this.userId = bundle.getLong("user_id", b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.isSelf = bundle.getBoolean(PersonPolymericActivityConfig.IS_USER_SELF, true);
            this.isBigV = bundle.getBoolean(PersonPolymericActivityConfig.IS_BIGV, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.cqi);
        this.feS.onDestory(getPageContext());
        if (this.bIm != null) {
            this.bIm.onDestroy();
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
                    if (this.bIm.aXV() instanceof com.baidu.tieba.model.a) {
                        ((com.baidu.tieba.model.a) this.bIm.aXV()).resetData();
                        ((com.baidu.tieba.model.a) this.bIm.aXV()).PN();
                        return;
                    }
                    return;
                case 12002:
                    if (intent != null) {
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            g.A(getPageContext());
                            return;
                        } else if (this.bIm != null && this.bIm.aXW() != null) {
                            this.bIm.aXW().U(intent);
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
                            if (this.bIm != null && this.bIm.aXW() != null) {
                                this.bIm.aXW().aYh();
                                this.bIm.aXW().aYi();
                                return;
                            }
                            return;
                        } else if (intExtra == 2 && this.bIm != null && this.bIm.aXW() != null) {
                            this.bIm.aXW().aYj();
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
                            if (this.bIm != null && this.bIm.aXW() != null) {
                                this.bIm.aXW().aYh();
                                this.bIm.aXW().aYi();
                                return;
                            }
                            return;
                        } else if (intExtra2 == 2 && this.bIm != null && this.bIm.aXW() != null) {
                            this.bIm.aXW().aYj();
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 24001:
                    if (intent != null && (this.bIm.aXV() instanceof com.baidu.tieba.model.a)) {
                        ((com.baidu.tieba.model.a) this.bIm.aXV()).resetData();
                        ((com.baidu.tieba.model.a) this.bIm.aXV()).PN();
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
        return this.feS;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.bIm != null) {
            this.bIm.onChangeSkinType(i);
        }
    }
}
