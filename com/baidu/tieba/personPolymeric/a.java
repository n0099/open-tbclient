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
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
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
import com.baidu.tieba.view.j;
/* loaded from: classes.dex */
public class a extends BaseFragment implements VoiceManager.c {
    private VoiceManager fek;
    private e fem;
    private long userId;
    private boolean isSelf = true;
    @Deprecated
    private boolean isBigV = false;
    private boolean eZF = false;
    private boolean fel = false;
    private boolean crv = false;
    private long eBr = 0;
    private AntiHelper.a cqX = new AntiHelper.a() { // from class: com.baidu.tieba.personPolymeric.a.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12536").r("obj_locate", ap.a.aha));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12535").r("obj_locate", ap.a.aha));
        }
    };
    private CustomMessageListener ehq = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH_PERSONAL) { // from class: com.baidu.tieba.personPolymeric.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.isSelf) {
                a.this.crv = true;
            }
        }
    };
    private HttpMessageListener eln = new HttpMessageListener(CmdConfigHttp.GETPAYINFO_CMD) { // from class: com.baidu.tieba.personPolymeric.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001505) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode == 200 && error == 0 && a.this.fem != null) {
                    a.this.fem.kk(true);
                }
            }
        }
    };
    private CustomMessageListener crl = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personPolymeric.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data) && a.this.fem != null) {
                    a.this.fem.kk(true);
                }
            }
        }
    };
    private CustomMessageListener aoH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.personPolymeric.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
                if (data.ars != null && AntiHelper.a(a.this.getActivity(), data.ars, a.this.cqX) != null) {
                    TiebaStatic.log(new ak("c12534").r("obj_locate", ap.a.aha));
                }
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mIsLogin = TbadkCoreApplication.isLogin();
        if (getArguments() != null) {
            this.eZF = getArguments().getBoolean(PersonPolymericActivityConfig.RESOURCE_TYPE);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        y(bundle);
        View inflate = layoutInflater.inflate(d.j.fragment_person_center_layout, (ViewGroup) null);
        if (this.userId <= 0 && TbadkCoreApplication.getCurrentAccount() != null) {
            this.userId = b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.fem = new e(this, inflate, getUniqueId(), this.userId, this.isSelf, this.eZF, this.fel);
        this.fek = getVoiceManager();
        if (this.fek != null) {
            this.fek.onCreate(getPageContext());
        }
        this.ehq.setTag(getUniqueId());
        registerListener(this.ehq);
        registerListener(this.crl);
        registerListener(this.eln);
        registerListener(this.aoH);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.eZF) {
            return null;
        }
        return "a011";
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.fek = getVoiceManager();
        if (this.fek != null) {
            this.fek.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            this.fem.kh(isPrimary());
            com.baidu.tieba.j.a.bgJ().lH(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.fek = getVoiceManager();
        if (this.fek != null) {
            this.fek.onResume(getPageContext());
        }
        this.fem.onResume();
        if (!this.isSelf && this.isBigV) {
            this.eBr = System.currentTimeMillis();
        } else {
            this.eBr = -1L;
        }
        if (this.crv && this.fem.aWy() != null) {
            this.fem.aWy().aWs();
            this.crv = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.fek = getVoiceManager();
        if (this.fek != null) {
            this.fek.onPause(getPageContext());
        }
        if (this.eBr > 0) {
            TiebaStatic.log(new ak("c12263").ac("obj_duration", String.valueOf((System.currentTimeMillis() - this.eBr) / 1000)).r("obj_type", 2));
            this.eBr = 0L;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.fek = getVoiceManager();
        if (this.fek != null) {
            this.fek.onStop(getPageContext());
        }
    }

    private void y(Bundle bundle) {
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.userId = intent.getLongExtra("user_id", b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.isSelf = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_USER_SELF, true);
            this.isBigV = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_BIGV, false);
            this.fel = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_SHOW_THREAD_TOP, false);
        } else if (bundle != null) {
            this.userId = bundle.getLong("user_id", b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.isSelf = bundle.getBoolean(PersonPolymericActivityConfig.IS_USER_SELF, true);
            this.isBigV = bundle.getBoolean(PersonPolymericActivityConfig.IS_BIGV, false);
            this.fel = bundle.getBoolean(PersonPolymericActivityConfig.IS_SHOW_THREAD_TOP, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.crl);
        if (this.fek != null) {
            this.fek.onDestory(getPageContext());
        }
        this.fek = null;
        if (this.fem != null) {
            this.fem.onDestroy();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putLong("user_id", this.userId);
            bundle.putBoolean(PersonPolymericActivityConfig.IS_USER_SELF, this.isSelf);
            bundle.putBoolean(PersonPolymericActivityConfig.IS_BIGV, this.isBigV);
            bundle.putBoolean(PersonPolymericActivityConfig.IS_SHOW_THREAD_TOP, this.fel);
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
                    if (this.fem.aWy() instanceof com.baidu.tieba.model.a) {
                        ((com.baidu.tieba.model.a) this.fem.aWy()).resetData();
                        ((com.baidu.tieba.model.a) this.fem.aWy()).Qf();
                        return;
                    }
                    return;
                case 12002:
                    if (intent != null) {
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            h.x(getPageContext());
                            return;
                        } else if (this.fem != null && this.fem.aWz() != null) {
                            this.fem.aWz().P(intent);
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
                            if (this.fem != null && this.fem.aWz() != null) {
                                this.fem.aWz().aWJ();
                                this.fem.aWz().aWK();
                                return;
                            }
                            return;
                        } else if (intExtra == 2 && this.fem != null && this.fem.aWz() != null) {
                            this.fem.aWz().aWL();
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
                            if (this.fem != null && this.fem.aWz() != null) {
                                this.fem.aWz().aWJ();
                                this.fem.aWz().aWK();
                                return;
                            }
                            return;
                        } else if (intExtra2 == 2 && this.fem != null && this.fem.aWz() != null) {
                            this.fem.aWz().aWL();
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 23007:
                    L(intent);
                    return;
                case 24001:
                    if (intent != null && (this.fem.aWy() instanceof com.baidu.tieba.model.a)) {
                        ((com.baidu.tieba.model.a) this.fem.aWy()).resetData();
                        ((com.baidu.tieba.model.a) this.fem.aWy()).Qf();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void L(Intent intent) {
        a(akL(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            final j jVar = new j(getActivity());
            jVar.setData(shareFromPBMsgData);
            aVar.ce(1);
            aVar.v(jVar);
            aVar.a(d.l.share, new a.b() { // from class: com.baidu.tieba.personPolymeric.a.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.getActivity().getSystemService("input_method");
                    l.a(a.this.getActivity(), jVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(a.this.getActivity(), j, str, str2, 0, jVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    com.baidu.tbadk.coreExtra.d.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.Ao() != null) {
                        Bundle Ao = shareItem.Ao();
                        TiebaStatic.log(new ak("share_success").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_type", Ao.getInt("obj_type")).r("obj_param1", 3).ac("fid", Ao.getString("fid")).ac("tid", Ao.getString("tid")));
                    }
                }
            });
            aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.a.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.getActivity().getSystemService("input_method");
                    l.a(a.this.getActivity(), jVar.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.ar(true);
            aVar.b(getPageContext()).tb();
            if (!k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                jVar.I(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }

    private ShareFromPBMsgData akL() {
        com.baidu.tbadk.coreExtra.d.d shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.atv == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.atv.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.aty);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.att);
        shareFromPBMsgData.setThreadId(shareItem.WT);
        return shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.fek == null) {
            this.fek = VoiceManager.instance();
        }
        return this.fek;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fem != null) {
            this.fem.onChangeSkinType(i);
        }
    }
}
