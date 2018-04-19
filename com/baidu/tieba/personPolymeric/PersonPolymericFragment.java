package com.baidu.tieba.personPolymeric;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
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
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.d;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.interactionpopupwindow.c;
import com.baidu.tieba.personPolymeric.b.e;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.Thread2GroupShareView;
import java.util.Map;
/* loaded from: classes3.dex */
public class PersonPolymericFragment extends BaseFragment implements VoiceManager.c {
    private ShareSuccessReplyToServerModel dll;
    private VoiceManager fHU;
    private e fHW;
    private View mRootView;
    private long userId;
    private boolean isSelf = true;
    @Deprecated
    private boolean isBigV = false;
    private boolean fDw = false;
    private boolean fHV = false;
    private boolean cYE = false;
    private long feD = 0;
    private AntiHelper.a cYh = new AntiHelper.a() { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new al("c12536").r("obj_locate", ar.a.aje));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new al("c12535").r("obj_locate", ar.a.aje));
        }
    };
    private CustomMessageListener eIf = new CustomMessageListener(2921004) { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonPolymericFragment.this.isSelf) {
                PersonPolymericFragment.this.cYE = true;
            }
        }
    };
    private HttpMessageListener eMj = new HttpMessageListener(CmdConfigHttp.GETPAYINFO_CMD) { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001505) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode == 200 && error == 0 && PersonPolymericFragment.this.fHW != null) {
                    PersonPolymericFragment.this.fHW.lf(true);
                }
            }
        }
    };
    private CustomMessageListener cYt = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof String) && !TextUtils.isEmpty((String) data) && PersonPolymericFragment.this.fHW != null) {
                    PersonPolymericFragment.this.fHW.lf(true);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
                if (data.auo != null && AntiHelper.a(PersonPolymericFragment.this.getActivity(), data.auo, PersonPolymericFragment.this.cYh) != null) {
                    TiebaStatic.log(new al("c12534").r("obj_locate", ar.a.aje));
                }
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mIsLogin = TbadkCoreApplication.isLogin();
        if (getArguments() != null) {
            this.fDw = getArguments().getBoolean(PersonPolymericActivityConfig.RESOURCE_TYPE);
        }
        MessageManager.getInstance().registerListener(this.eIf);
        MessageManager.getInstance().registerListener(this.cYt);
        MessageManager.getInstance().registerListener(this.eMj);
        MessageManager.getInstance().registerListener(this.mAttentionListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fHU = getVoiceManager();
        if (this.fHU != null) {
            this.fHU.onCreate(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        A(bundle);
        View inflate = layoutInflater.inflate(d.i.fragment_person_center_layout, (ViewGroup) null);
        if (this.userId <= 0 && TbadkCoreApplication.getCurrentAccount() != null) {
            this.userId = b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.mRootView = inflate;
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.fDw) {
            return null;
        }
        return "a011";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.fHW = new e(this, this.mRootView, getUniqueId(), this.userId, this.isSelf, this.fDw, this.fHV);
        this.dll = new ShareSuccessReplyToServerModel();
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.fHU = getVoiceManager();
        if (this.fHU != null) {
            this.fHU.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            this.fHW.fV(isPrimary());
            com.baidu.tieba.n.a.bkt().lI(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.fHU = getVoiceManager();
        if (this.fHU != null) {
            this.fHU.onResume(getPageContext());
        }
        this.fHW.onResume();
        if (!this.isSelf && this.isBigV) {
            this.feD = System.currentTimeMillis();
        } else {
            this.feD = -1L;
        }
        if (this.cYE && this.fHW.bfc() != null) {
            this.fHW.bfc().beY();
            this.cYE = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.fHU = getVoiceManager();
        if (this.fHU != null) {
            this.fHU.onPause(getPageContext());
        }
        if (this.feD > 0) {
            TiebaStatic.log(new al("c12263").ac("obj_duration", String.valueOf((System.currentTimeMillis() - this.feD) / 1000)).r("obj_type", 2));
            this.feD = 0L;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.fHU = getVoiceManager();
        if (this.fHU != null) {
            this.fHU.onStop(getPageContext());
        }
    }

    private void A(Bundle bundle) {
        Map<String, String> ep;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            if (!StringUtils.isNull(intent.getDataString()) && intent.getDataString().startsWith("com.baidu.tieba://usercenter")) {
                String decode = Uri.decode(intent.getData().getEncodedPath());
                if (!StringUtils.isNull(decode)) {
                    if (decode.startsWith("//")) {
                        decode = decode.substring(2);
                    }
                    if (!StringUtils.isNull(decode) && (ep = ax.ep(decode)) != null) {
                        String str = ep.get("uid");
                        if (!StringUtils.isNull(str)) {
                            this.userId = b.c(str, 0L);
                        } else {
                            this.userId = b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                        }
                        this.isSelf = this.userId == b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                        return;
                    }
                    return;
                }
                return;
            }
            this.userId = intent.getLongExtra("user_id", b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.isSelf = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_USER_SELF, true);
            this.isBigV = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_BIGV, false);
            this.fHV = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_SHOW_THREAD_TOP, false);
        } else if (bundle != null) {
            this.userId = bundle.getLong("user_id", b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.isSelf = bundle.getBoolean(PersonPolymericActivityConfig.IS_USER_SELF, true);
            this.isBigV = bundle.getBoolean(PersonPolymericActivityConfig.IS_BIGV, false);
            this.fHV = bundle.getBoolean(PersonPolymericActivityConfig.IS_SHOW_THREAD_TOP, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fHU != null) {
            this.fHU.onDestory(getPageContext());
        }
        this.fHU = null;
        if (this.fHW != null) {
            this.fHW.onDestroy();
        }
        BdAsyncTask.removeAllTask(SetPrivacyModel.UNIQUE_ID_SET_PRIVACY_TASK);
        BdAsyncTask.removeAllTask(ForumManageModel.UNIQUE_ID_DEL_POST_TASK);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putLong("user_id", this.userId);
            bundle.putBoolean(PersonPolymericActivityConfig.IS_USER_SELF, this.isSelf);
            bundle.putBoolean(PersonPolymericActivityConfig.IS_BIGV, this.isBigV);
            bundle.putBoolean(PersonPolymericActivityConfig.IS_SHOW_THREAD_TOP, this.fHV);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        MessageManager.getInstance().unRegisterListener(this.eIf);
        MessageManager.getInstance().unRegisterListener(this.cYt);
        MessageManager.getInstance().unRegisterListener(this.eMj);
        MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.coreExtra.c.d shareItem;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 101:
                    if (this.fHW.bfc() instanceof com.baidu.tieba.model.a) {
                        ((com.baidu.tieba.model.a) this.fHW.bfc()).resetData();
                        ((com.baidu.tieba.model.a) this.fHW.bfc()).OT();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null && this.fHW != null && this.fHW.bfd() != null) {
                        this.fHW.bfd().O(intent);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    if (intent != null) {
                        int intExtra = intent.getIntExtra("upload_image_type", 0);
                        if (intExtra == 1) {
                            if (this.fHW != null && this.fHW.bfd() != null) {
                                this.fHW.bfd().bfo();
                                this.fHW.bfd().bfp();
                                return;
                            }
                            return;
                        } else if (intExtra == 2 && this.fHW != null && this.fHW.bfd() != null) {
                            this.fHW.bfd().bfq();
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO /* 12014 */:
                    if (intent != null) {
                        int intExtra2 = intent.getIntExtra("upload_image_type", 0);
                        if (intExtra2 == 1) {
                            if (this.fHW != null && this.fHW.bfd() != null) {
                                this.fHW.bfd().bfo();
                                this.fHW.bfd().bfp();
                                return;
                            }
                            return;
                        } else if (intExtra2 == 2 && this.fHW != null && this.fHW.bfd() != null) {
                            this.fHW.bfd().bfq();
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 13003:
                    W(intent);
                    return;
                case 23007:
                    J(intent);
                    return;
                case 24001:
                    if (intent != null && (this.fHW.bfc() instanceof com.baidu.tieba.model.a)) {
                        ((com.baidu.tieba.model.a) this.fHW.bfc()).resetData();
                        ((com.baidu.tieba.model.a) this.fHW.bfc()).OT();
                        return;
                    }
                    return;
                case 24007:
                    int intExtra3 = intent.getIntExtra("extra_share_status", 2);
                    int intExtra4 = intent.getIntExtra("extra_show_channel", 1);
                    if (intExtra3 == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.dll != null) {
                        this.dll.a(shareItem.linkUrl, intExtra4, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.6
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void AF() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.6.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (PersonPolymericFragment.this.getPageContext().getPageActivity() != null) {
                                            c.a(PersonPolymericFragment.this.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void W(Intent intent) {
        if (intent != null) {
            try {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                if (this.fHW != null && !this.fHW.d(postWriteCallBackData)) {
                    this.fHW.b(postWriteCallBackData);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    private void J(Intent intent) {
        a(aua(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.cb(1);
            aVar.w(thread2GroupShareView);
            aVar.a(d.k.share, new a.b() { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) PersonPolymericFragment.this.getActivity().getSystemService("input_method");
                    l.b(PersonPolymericFragment.this.getActivity(), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(PersonPolymericFragment.this.getActivity(), j, str, str2, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.BL() != null) {
                        Bundle BL = shareItem.BL();
                        TiebaStatic.log(new al("share_success").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_type", BL.getInt("obj_type")).r("obj_param1", 3).ac(ImageViewerConfig.FORUM_ID, BL.getString(ImageViewerConfig.FORUM_ID)).ac("tid", BL.getString("tid")));
                    }
                }
            });
            aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) PersonPolymericFragment.this.getActivity().getSystemService("input_method");
                    l.b(PersonPolymericFragment.this.getActivity(), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.as(true);
            aVar.b(getPageContext()).tD();
            if (!k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.D(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }

    private ShareFromPBMsgData aua() {
        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.awV == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.awV.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.awY);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.awT);
        shareFromPBMsgData.setThreadId(shareItem.tid);
        return shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.fHU == null) {
            this.fHU = VoiceManager.instance();
        }
        return this.fHU;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fHW != null) {
            this.fHW.onChangeSkinType(i);
        }
    }
}
