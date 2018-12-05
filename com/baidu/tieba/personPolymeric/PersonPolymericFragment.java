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
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.e;
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
    private ShareSuccessReplyToServerModel dXG;
    private String grh;
    private String gri;
    private VoiceManager gvT;
    private e gvV;
    private View mRootView;
    private long userId;
    private boolean isSelf = true;
    @Deprecated
    private boolean isBigV = false;
    private boolean grf = false;
    private boolean gvU = false;
    private boolean dJD = false;
    private long fSK = 0;
    private AntiHelper.a dJg = new AntiHelper.a() { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").x("obj_locate", as.a.aCN));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").x("obj_locate", as.a.aCN));
        }
    };
    private CustomMessageListener mRefreshListener = new CustomMessageListener(2921004) { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonPolymericFragment.this.isSelf) {
                PersonPolymericFragment.this.dJD = true;
            }
        }
    };
    private HttpMessageListener fyV = new HttpMessageListener(CmdConfigHttp.GETPAYINFO_CMD) { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001505) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode == 200 && error == 0 && PersonPolymericFragment.this.gvV != null) {
                    PersonPolymericFragment.this.gvV.mj(true);
                }
            }
        }
    };
    private CustomMessageListener dJs = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UserData userData;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && PersonPolymericFragment.this.isSelf) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && PersonPolymericFragment.this.gvV != null) {
                        com.baidu.tieba.personPolymeric.c.a mj = PersonPolymericFragment.this.gvV.mj(true);
                        PersonPolymericFragment.this.grh = str;
                        if (mj != null && (userData = mj.getUserData()) != null) {
                            userData.setName_show(str);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener grk = new CustomMessageListener(2921378) { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && PersonPolymericFragment.this.isSelf) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    PersonPolymericFragment.this.gri = (String) data;
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
                if (data.aPr != null && AntiHelper.a(PersonPolymericFragment.this.getActivity(), data.aPr, PersonPolymericFragment.this.dJg) != null) {
                    TiebaStatic.log(new am("c12534").x("obj_locate", as.a.aCN));
                }
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mIsLogin = TbadkCoreApplication.isLogin();
        if (getArguments() != null) {
            this.grf = getArguments().getBoolean(PersonPolymericActivityConfig.RESOURCE_TYPE);
        }
        MessageManager.getInstance().registerListener(this.mRefreshListener);
        MessageManager.getInstance().registerListener(this.dJs);
        MessageManager.getInstance().registerListener(this.grk);
        MessageManager.getInstance().registerListener(this.fyV);
        MessageManager.getInstance().registerListener(this.mAttentionListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gvT = getVoiceManager();
        if (this.gvT != null) {
            this.gvT.onCreate(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        I(bundle);
        View inflate = layoutInflater.inflate(e.h.fragment_person_center_layout, (ViewGroup) null);
        if (this.userId <= 0 && TbadkCoreApplication.getCurrentAccount() != null) {
            this.userId = b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.mRootView = inflate;
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.grf) {
            return null;
        }
        return "a011";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.gvV = new com.baidu.tieba.personPolymeric.b.e(this, this.mRootView, getUniqueId(), this.userId, this.isSelf, this.grf, this.gvU);
        this.dXG = new ShareSuccessReplyToServerModel();
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.gvT = getVoiceManager();
        if (this.gvT != null) {
            this.gvT.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            this.gvV.gu(isPrimary());
            com.baidu.tieba.o.a.bvJ().mP(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.gvT = getVoiceManager();
        if (this.gvT != null) {
            this.gvT.onResume(getPageContext());
        }
        this.gvV.onResume();
        if (!this.isSelf && this.isBigV) {
            this.fSK = System.currentTimeMillis();
        } else {
            this.fSK = -1L;
        }
        if (this.gvV.bpY() != null) {
            if (!StringUtils.isNull(this.grh)) {
                this.gvV.bpY().tK(this.grh);
                this.grh = null;
            }
            if (!StringUtils.isNull(this.gri)) {
                this.gvV.bpY().tL(this.gri);
                this.gri = null;
            }
            if (this.dJD) {
                this.gvV.bpY().bpU();
                this.dJD = false;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.gvT = getVoiceManager();
        if (this.gvT != null) {
            this.gvT.onPause(getPageContext());
        }
        if (this.fSK > 0) {
            TiebaStatic.log(new am("c12263").aA("obj_duration", String.valueOf((System.currentTimeMillis() - this.fSK) / 1000)).x("obj_type", 2));
            this.fSK = 0L;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.gvT = getVoiceManager();
        if (this.gvT != null) {
            this.gvT.onStop(getPageContext());
        }
    }

    private void I(Bundle bundle) {
        Map<String, String> fN;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            if (!StringUtils.isNull(intent.getDataString()) && intent.getDataString().startsWith("com.baidu.tieba://usercenter")) {
                String decode = Uri.decode(intent.getData().getEncodedPath());
                if (!StringUtils.isNull(decode)) {
                    if (decode.startsWith("//")) {
                        decode = decode.substring(2);
                    }
                    if (!StringUtils.isNull(decode) && (fN = ay.fN(decode)) != null) {
                        String str = fN.get("uid");
                        if (!StringUtils.isNull(str)) {
                            this.userId = b.d(str, 0L);
                        } else {
                            this.userId = b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                        }
                        this.isSelf = this.userId == b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                        return;
                    }
                    return;
                }
                return;
            }
            this.userId = intent.getLongExtra("user_id", b.d(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.isSelf = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_USER_SELF, true);
            this.isBigV = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_BIGV, false);
            this.gvU = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_SHOW_THREAD_TOP, false);
        } else if (bundle != null) {
            this.userId = bundle.getLong("user_id", b.d(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.isSelf = bundle.getBoolean(PersonPolymericActivityConfig.IS_USER_SELF, true);
            this.isBigV = bundle.getBoolean(PersonPolymericActivityConfig.IS_BIGV, false);
            this.gvU = bundle.getBoolean(PersonPolymericActivityConfig.IS_SHOW_THREAD_TOP, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gvT != null) {
            this.gvT.onDestory(getPageContext());
        }
        this.gvT = null;
        if (this.gvV != null) {
            this.gvV.onDestroy();
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
            bundle.putBoolean(PersonPolymericActivityConfig.IS_SHOW_THREAD_TOP, this.gvU);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        MessageManager.getInstance().unRegisterListener(this.mRefreshListener);
        MessageManager.getInstance().unRegisterListener(this.dJs);
        MessageManager.getInstance().unRegisterListener(this.grk);
        MessageManager.getInstance().unRegisterListener(this.fyV);
        MessageManager.getInstance().unRegisterListener(this.mAttentionListener);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 101:
                    if (this.gvV.bpY() instanceof com.baidu.tieba.model.a) {
                        ((com.baidu.tieba.model.a) this.gvV.bpY()).resetData();
                        ((com.baidu.tieba.model.a) this.gvV.bpY()).loadData();
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null && this.gvV != null && this.gvV.bpZ() != null) {
                        this.gvV.bpZ().S(intent);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    if (intent != null) {
                        int intExtra = intent.getIntExtra("upload_image_type", 0);
                        if (intExtra == 1) {
                            if (this.gvV != null && this.gvV.bpZ() != null) {
                                this.gvV.bpZ().bqk();
                                this.gvV.bpZ().bql();
                                return;
                            }
                            return;
                        } else if (intExtra == 2 && this.gvV != null && this.gvV.bpZ() != null) {
                            this.gvV.bpZ().bqm();
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
                            if (this.gvV != null && this.gvV.bpZ() != null) {
                                this.gvV.bpZ().bqk();
                                this.gvV.bpZ().bql();
                                return;
                            }
                            return;
                        } else if (intExtra2 == 2 && this.gvV != null && this.gvV.bpZ() != null) {
                            this.gvV.bpZ().bqm();
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 13003:
                    aa(intent);
                    return;
                case 13011:
                    com.baidu.tieba.n.a.buh().x(getPageContext());
                    return;
                case 23007:
                    N(intent);
                    return;
                case 24001:
                    if (intent != null && (this.gvV.bpY() instanceof com.baidu.tieba.model.a)) {
                        ((com.baidu.tieba.model.a) this.gvV.bpY()).resetData();
                        ((com.baidu.tieba.model.a) this.gvV.bpY()).loadData();
                        return;
                    }
                    return;
                case 24007:
                    int intExtra3 = intent.getIntExtra("extra_share_status", 2);
                    int intExtra4 = intent.getIntExtra("extra_show_channel", 1);
                    if (intExtra3 == 1) {
                        com.baidu.tieba.n.a.buh().x(getPageContext());
                        d shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (shareItem != null && shareItem.linkUrl != null && this.dXG != null) {
                            this.dXG.a(shareItem.linkUrl, intExtra4, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.7
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void IY() {
                                }

                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void a(final CustomDialogData customDialogData) {
                                    com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.7.1
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
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void aa(Intent intent) {
        if (intent != null) {
            try {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                if (this.gvV != null && !this.gvV.d(postWriteCallBackData)) {
                    this.gvV.b(postWriteCallBackData);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    private void N(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(aGf(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.dd(1);
            aVar.G(thread2GroupShareView);
            aVar.a(e.j.share, new a.b() { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) PersonPolymericFragment.this.getActivity().getSystemService("input_method");
                    l.b(PersonPolymericFragment.this.getActivity(), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(PersonPolymericFragment.this.getActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.Kg() != null) {
                        Bundle Kg = shareItem.Kg();
                        TiebaStatic.log(new am("share_success").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).x("obj_type", Kg.getInt("obj_type")).x("obj_param1", 3).aA(ImageViewerConfig.FORUM_ID, Kg.getString(ImageViewerConfig.FORUM_ID)).aA("tid", Kg.getString("tid")));
                    }
                }
            });
            aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) PersonPolymericFragment.this.getActivity().getSystemService("input_method");
                    l.b(PersonPolymericFragment.this.getActivity(), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.bg(true);
            aVar.b(getPageContext()).BF();
            if (!k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.N(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }

    private ShareFromPBMsgData aGf() {
        d shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.imageUri == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.imageUri.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.aSj);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.aSf);
        shareFromPBMsgData.setThreadId(shareItem.tid);
        return shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.gvT == null) {
            this.gvT = VoiceManager.instance();
        }
        return this.gvT;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gvV != null) {
            this.gvV.onChangeSkinType(i);
        }
    }
}
