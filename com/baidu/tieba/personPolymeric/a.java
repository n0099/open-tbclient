package com.baidu.tieba.personPolymeric;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.b.e;
import com.baidu.tieba.personPolymeric.b.h;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.view.k;
/* loaded from: classes.dex */
public class a extends BaseFragment implements VoiceManager.c {
    private VoiceManager fmA;
    private e fmC;
    private long userId;
    private boolean isSelf = true;
    @Deprecated
    private boolean isBigV = false;
    private boolean fhU = false;
    private boolean fmB = false;
    private boolean cyQ = false;
    private long eKg = 0;
    private AntiHelper.a cys = new AntiHelper.a() { // from class: com.baidu.tieba.personPolymeric.a.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12536").r("obj_locate", ap.a.ahv));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12535").r("obj_locate", ap.a.ahv));
        }
    };
    private CustomMessageListener eoZ = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH_PERSONAL) { // from class: com.baidu.tieba.personPolymeric.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.isSelf) {
                a.this.cyQ = true;
            }
        }
    };
    private HttpMessageListener esX = new HttpMessageListener(CmdConfigHttp.GETPAYINFO_CMD) { // from class: com.baidu.tieba.personPolymeric.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001505) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode == 200 && error == 0 && a.this.fmC != null) {
                    a.this.fmC.ke(true);
                }
            }
        }
    };
    private CustomMessageListener cyG = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personPolymeric.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data) && a.this.fmC != null) {
                    a.this.fmC.ke(true);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.personPolymeric.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
                if (data.arL != null && AntiHelper.a(a.this.getActivity(), data.arL, a.this.cys) != null) {
                    TiebaStatic.log(new ak("c12534").r("obj_locate", ap.a.ahv));
                }
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mIsLogin = TbadkCoreApplication.isLogin();
        if (getArguments() != null) {
            this.fhU = getArguments().getBoolean(PersonPolymericActivityConfig.RESOURCE_TYPE);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        x(bundle);
        View inflate = layoutInflater.inflate(d.h.fragment_person_center_layout, (ViewGroup) null);
        if (this.userId <= 0 && TbadkCoreApplication.getCurrentAccount() != null) {
            this.userId = b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.fmC = new e(this, inflate, getUniqueId(), this.userId, this.isSelf, this.fhU, this.fmB);
        this.fmA = getVoiceManager();
        if (this.fmA != null) {
            this.fmA.onCreate(getPageContext());
        }
        this.eoZ.setTag(getUniqueId());
        registerListener(this.eoZ);
        registerListener(this.cyG);
        registerListener(this.esX);
        registerListener(this.mAttentionListener);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.fhU) {
            return null;
        }
        return "a011";
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.fmA = getVoiceManager();
        if (this.fmA != null) {
            this.fmA.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            this.fmC.kb(isPrimary());
            com.baidu.tieba.j.a.bjW().lC(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.fmA = getVoiceManager();
        if (this.fmA != null) {
            this.fmA.onResume(getPageContext());
        }
        this.fmC.onResume();
        if (!this.isSelf && this.isBigV) {
            this.eKg = System.currentTimeMillis();
        } else {
            this.eKg = -1L;
        }
        if (this.cyQ && this.fmC.aZB() != null) {
            this.fmC.aZB().aZv();
            this.cyQ = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.fmA = getVoiceManager();
        if (this.fmA != null) {
            this.fmA.onPause(getPageContext());
        }
        if (this.eKg > 0) {
            TiebaStatic.log(new ak("c12263").ac("obj_duration", String.valueOf((System.currentTimeMillis() - this.eKg) / 1000)).r("obj_type", 2));
            this.eKg = 0L;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.fmA = getVoiceManager();
        if (this.fmA != null) {
            this.fmA.onStop(getPageContext());
        }
    }

    private void x(Bundle bundle) {
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.userId = intent.getLongExtra("user_id", b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.isSelf = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_USER_SELF, true);
            this.isBigV = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_BIGV, false);
            this.fmB = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_SHOW_THREAD_TOP, false);
        } else if (bundle != null) {
            this.userId = bundle.getLong("user_id", b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.isSelf = bundle.getBoolean(PersonPolymericActivityConfig.IS_USER_SELF, true);
            this.isBigV = bundle.getBoolean(PersonPolymericActivityConfig.IS_BIGV, false);
            this.fmB = bundle.getBoolean(PersonPolymericActivityConfig.IS_SHOW_THREAD_TOP, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.cyG);
        if (this.fmA != null) {
            this.fmA.onDestory(getPageContext());
        }
        this.fmA = null;
        if (this.fmC != null) {
            this.fmC.onDestroy();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putLong("user_id", this.userId);
            bundle.putBoolean(PersonPolymericActivityConfig.IS_USER_SELF, this.isSelf);
            bundle.putBoolean(PersonPolymericActivityConfig.IS_BIGV, this.isBigV);
            bundle.putBoolean(PersonPolymericActivityConfig.IS_SHOW_THREAD_TOP, this.fmB);
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
                    if (this.fmC.aZB() instanceof com.baidu.tieba.model.a) {
                        ((com.baidu.tieba.model.a) this.fmC.aZB()).resetData();
                        ((com.baidu.tieba.model.a) this.fmC.aZB()).Rx();
                        return;
                    }
                    return;
                case 12002:
                    if (intent != null) {
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            h.x(getPageContext());
                            return;
                        } else if (this.fmC != null && this.fmC.aZC() != null) {
                            this.fmC.aZC().O(intent);
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
                            if (this.fmC != null && this.fmC.aZC() != null) {
                                this.fmC.aZC().aZM();
                                this.fmC.aZC().aZN();
                                return;
                            }
                            return;
                        } else if (intExtra == 2 && this.fmC != null && this.fmC.aZC() != null) {
                            this.fmC.aZC().aZO();
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
                            if (this.fmC != null && this.fmC.aZC() != null) {
                                this.fmC.aZC().aZM();
                                this.fmC.aZC().aZN();
                                return;
                            }
                            return;
                        } else if (intExtra2 == 2 && this.fmC != null && this.fmC.aZC() != null) {
                            this.fmC.aZC().aZO();
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 23007:
                    K(intent);
                    return;
                case 24001:
                    if (intent != null && (this.fmC.aZB() instanceof com.baidu.tieba.model.a)) {
                        ((com.baidu.tieba.model.a) this.fmC.aZB()).resetData();
                        ((com.baidu.tieba.model.a) this.fmC.aZB()).Rx();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void K(Intent intent) {
        a(anw(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            final k kVar = new k(getActivity());
            kVar.setData(shareFromPBMsgData);
            aVar.ce(1);
            aVar.v(kVar);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.personPolymeric.a.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.getActivity().getSystemService("input_method");
                    l.a(a.this.getActivity(), kVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(a.this.getActivity(), j, str, str2, 0, kVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    com.baidu.tbadk.coreExtra.d.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.Ax() != null) {
                        Bundle Ax = shareItem.Ax();
                        TiebaStatic.log(new ak("share_success").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_type", Ax.getInt("obj_type")).r("obj_param1", 3).ac(ImageViewerConfig.FORUM_ID, Ax.getString(ImageViewerConfig.FORUM_ID)).ac("tid", Ax.getString("tid")));
                    }
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.a.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.getActivity().getSystemService("input_method");
                    l.a(a.this.getActivity(), kVar.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.ap(true);
            aVar.b(getPageContext()).th();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                kVar.G(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }

    private ShareFromPBMsgData anw() {
        com.baidu.tbadk.coreExtra.d.d shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.atR == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.atR.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.atU);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.atP);
        shareFromPBMsgData.setThreadId(shareItem.Xl);
        return shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.fmA == null) {
            this.fmA = VoiceManager.instance();
        }
        return this.fmA;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fmC != null) {
            this.fmC.onChangeSkinType(i);
        }
    }
}
