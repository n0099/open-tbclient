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
    private d bJd;
    private VoiceManager ffL;
    private long userId;
    private boolean isSelf = true;
    @Deprecated
    private boolean isBigV = false;
    private boolean bIY = false;
    private boolean crl = false;
    private long eIl = 0;
    private CustomMessageListener elt = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH_PERSONAL) { // from class: com.baidu.tieba.personCenter.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.isSelf) {
                a.this.crl = true;
            }
        }
    };
    private HttpMessageListener esx = new HttpMessageListener(CmdConfigHttp.GETPAYINFO_CMD) { // from class: com.baidu.tieba.personCenter.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001505) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode == 200 && error == 0 && a.this.bJd != null) {
                    a.this.bJd.ks(true);
                }
            }
        }
    };
    private CustomMessageListener cra = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personCenter.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data) && a.this.bJd != null) {
                    a.this.bJd.ks(true);
                }
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mIsLogin = TbadkCoreApplication.isLogin();
        if (getArguments() != null) {
            this.bIY = getArguments().getBoolean(PersonPolymericActivityConfig.RESOURCE_TYPE);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        x(bundle);
        View inflate = layoutInflater.inflate(d.j.fragment_person_center_layout, (ViewGroup) null);
        if (this.userId <= 0 && TbadkCoreApplication.getCurrentAccount() != null) {
            this.userId = b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.bJd = new com.baidu.tieba.personPolymeric.b.d(this, inflate, getUniqueId(), this.userId, this.isSelf, this.bIY);
        this.ffL = VoiceManager.instance();
        this.elt.setTag(getUniqueId());
        registerListener(this.elt);
        registerListener(this.cra);
        registerListener(this.esx);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.bIY) {
            return null;
        }
        return "a011";
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.ffL.onStart(getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            this.bJd.dE(isPrimary());
            com.baidu.tieba.j.a.bij().lP(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.ffL.onResume(getPageContext());
        this.bJd.onResume();
        if (!this.isSelf && this.isBigV) {
            this.eIl = System.currentTimeMillis();
        } else {
            this.eIl = -1L;
        }
        if (this.crl && this.bJd.aYg() != null) {
            this.bJd.aYg().Xq();
            this.crl = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.ffL.onPause(getPageContext());
        if (this.eIl > 0) {
            TiebaStatic.log(new ak("c12263").ad("obj_duration", String.valueOf((System.currentTimeMillis() - this.eIl) / 1000)).r("obj_type", 2));
            this.eIl = 0L;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.ffL.onStop(getPageContext());
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
        MessageManager.getInstance().unRegisterListener(this.cra);
        this.ffL.onDestory(getPageContext());
        if (this.bJd != null) {
            this.bJd.onDestroy();
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
                    if (this.bJd.aYg() instanceof com.baidu.tieba.model.a) {
                        ((com.baidu.tieba.model.a) this.bJd.aYg()).resetData();
                        ((com.baidu.tieba.model.a) this.bJd.aYg()).PP();
                        return;
                    }
                    return;
                case 12002:
                    if (intent != null) {
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            g.A(getPageContext());
                            return;
                        } else if (this.bJd != null && this.bJd.aYh() != null) {
                            this.bJd.aYh().T(intent);
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
                            if (this.bJd != null && this.bJd.aYh() != null) {
                                this.bJd.aYh().aYs();
                                this.bJd.aYh().aYt();
                                return;
                            }
                            return;
                        } else if (intExtra == 2 && this.bJd != null && this.bJd.aYh() != null) {
                            this.bJd.aYh().aYu();
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
                            if (this.bJd != null && this.bJd.aYh() != null) {
                                this.bJd.aYh().aYs();
                                this.bJd.aYh().aYt();
                                return;
                            }
                            return;
                        } else if (intExtra2 == 2 && this.bJd != null && this.bJd.aYh() != null) {
                            this.bJd.aYh().aYu();
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 24001:
                    if (intent != null && (this.bJd.aYg() instanceof com.baidu.tieba.model.a)) {
                        ((com.baidu.tieba.model.a) this.bJd.aYg()).resetData();
                        ((com.baidu.tieba.model.a) this.bJd.aYg()).PP();
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
        return this.ffL;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.bJd != null) {
            this.bJd.onChangeSkinType(i);
        }
    }
}
