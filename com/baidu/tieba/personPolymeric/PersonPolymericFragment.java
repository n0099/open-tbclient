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
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tbadk.BdToken.f;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.R;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.interactionpopupwindow.c;
import com.baidu.tieba.personPolymeric.b.g;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.Thread2GroupShareView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes24.dex */
public class PersonPolymericFragment extends BaseFragment implements VoiceManager.c {
    private VoiceManager aaB;
    private ShareSuccessReplyToServerModel jaw;
    private String lUX;
    private String lUY;
    private View mRootView;
    private g maP;
    private String nid;
    private String stType;
    private String threadId;
    private long userId;
    private boolean isHost = true;
    private String mPortrait = "";
    @Deprecated
    private boolean isBigV = false;
    private boolean maO = false;
    private boolean jjp = false;
    private long ltw = 0;
    private AntiHelper.a iIK = new AntiHelper.a() { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ax.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener kOe = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH_PERSONAL) { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonPolymericFragment.this.isHost) {
                PersonPolymericFragment.this.jjp = true;
            }
        }
    };
    private HttpMessageListener kSc = new HttpMessageListener(1001505) { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001505) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode == 200 && error == 0 && PersonPolymericFragment.this.maP != null) {
                    PersonPolymericFragment.this.maP.vU(true);
                }
            }
        }
    };
    private CustomMessageListener iJc = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UserData userData;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && PersonPolymericFragment.this.isHost) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && PersonPolymericFragment.this.maP != null) {
                        com.baidu.tieba.personPolymeric.c.a vU = PersonPolymericFragment.this.maP.vU(true);
                        PersonPolymericFragment.this.lUX = str;
                        if (vU != null && (userData = vU.getUserData()) != null) {
                            userData.setName_show(str);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener lUZ = new CustomMessageListener(2921378) { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && PersonPolymericFragment.this.isHost) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    PersonPolymericFragment.this.lUY = (String) data;
                }
            }
        }
    };
    private CustomMessageListener eNv = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
                if (data.feD != null && AntiHelper.a(PersonPolymericFragment.this.getActivity(), data.feD, PersonPolymericFragment.this.iIK) != null) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).al("obj_locate", ax.a.LOCATE_LIKE_PERSON));
                }
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mIsLogin = TbadkCoreApplication.isLogin();
        MessageManager.getInstance().registerListener(this.kOe);
        MessageManager.getInstance().registerListener(this.iJc);
        MessageManager.getInstance().registerListener(this.lUZ);
        MessageManager.getInstance().registerListener(this.kSc);
        MessageManager.getInstance().registerListener(this.eNv);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        b.dvd().reset();
        b.dvd().cX(currentTimeMillis);
        super.onCreate(bundle);
        this.aaB = getVoiceManager();
        if (this.aaB != null) {
            this.aaB.onCreate(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        aE(bundle);
        dvc();
        dvb();
        View inflate = layoutInflater.inflate(R.layout.fragment_person_center_layout, (ViewGroup) null);
        if (this.userId <= 0 && TbadkCoreApplication.getCurrentAccount() != null) {
            this.userId = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.mRootView = inflate;
        return inflate;
    }

    private void dvb() {
        aq aqVar = new aq("c13576");
        aqVar.al("obj_type", this.isHost ? 1 : 0);
        aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(aqVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.maP = new g(this, this.mRootView, getUniqueId(), this.userId, this.isHost, this.maO, this.mPortrait);
        this.jaw = new ShareSuccessReplyToServerModel();
        b.dvd().setCreateTime(System.currentTimeMillis() - b.dvd().bdL());
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.aaB = getVoiceManager();
        if (this.aaB != null) {
            this.aaB.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            this.maP.bQ(isPrimary());
            com.baidu.tieba.p.a.dBY().wM(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.aaB = getVoiceManager();
        if (this.aaB != null) {
            this.aaB.onResume(getPageContext());
        }
        this.maP.onResume();
        if (!this.isHost && this.isBigV) {
            this.ltw = System.currentTimeMillis();
        } else {
            this.ltw = -1L;
        }
        if (this.maP.dvm() != null) {
            if (!StringUtils.isNull(this.lUX)) {
                this.maP.dvm().QD(this.lUX);
                this.lUX = null;
            }
            if (!StringUtils.isNull(this.lUY)) {
                this.maP.dvm().QE(this.lUY);
                this.lUY = null;
            }
            if (this.jjp) {
                this.maP.dvm().dvh();
                this.jjp = false;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.aaB = getVoiceManager();
        if (this.aaB != null) {
            this.aaB.onPause(getPageContext());
        }
        if (this.ltw > 0) {
            TiebaStatic.log(new aq("c12263").dR("obj_duration", String.valueOf((System.currentTimeMillis() - this.ltw) / 1000)).al("obj_type", 2));
            this.ltw = 0L;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.aaB = getVoiceManager();
        if (this.aaB != null) {
            this.aaB.onStop(getPageContext());
        }
    }

    private void aE(Bundle bundle) {
        Map<String, String> paramPair;
        int length;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.userId = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            this.isHost = this.userId == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            if (intent.getParcelableExtra(IntentConfig.KEY_URI) != null) {
                Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
                String uri2 = uri.toString();
                if (f.p(uri)) {
                    f.bgz().d(uri, new f.a() { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.8
                        @Override // com.baidu.tbadk.BdToken.f.a
                        public void B(HashMap<String, Object> hashMap) {
                            if (hashMap != null && (hashMap.get(f.erN) instanceof String)) {
                                PersonPolymericFragment.this.mPortrait = (String) hashMap.get(f.erN);
                                if (!StringUtils.isNull(PersonPolymericFragment.this.mPortrait)) {
                                    PersonPolymericFragment.this.isHost = false;
                                }
                            }
                        }
                    });
                    return;
                } else if (StringUtils.isNull(uri2)) {
                    return;
                } else {
                    if (uri2.startsWith("tbusercenter://") || uri2.startsWith("com.baidu.tieba://usercenter")) {
                        String decode = Uri.decode(uri.getEncodedPath());
                        if (!StringUtils.isNull(decode)) {
                            if (uri2.startsWith("tbusercenter://")) {
                                KZ(decode);
                                Matcher matcher = Pattern.compile(".*fr=(.*)&portrait=([\\d]+).*").matcher(decode);
                                if (matcher.find()) {
                                    this.mPortrait = matcher.group(2);
                                    return;
                                }
                                int indexOf = decode.indexOf("portrait=");
                                if (indexOf >= 0 && (length = indexOf + "portrait=".length()) <= decode.length()) {
                                    this.mPortrait = decode.substring(length);
                                    if (!StringUtils.isNull(this.mPortrait)) {
                                        this.isHost = false;
                                        return;
                                    }
                                    return;
                                }
                                return;
                            } else if (uri2.startsWith("com.baidu.tieba://usercenter")) {
                                if (decode.startsWith("//")) {
                                    decode = decode.substring(2);
                                }
                                if (!StringUtils.isNull(decode) && (paramPair = be.getParamPair(decode)) != null) {
                                    String str = paramPair.get("uid");
                                    if (!StringUtils.isNull(str)) {
                                        this.userId = com.baidu.adp.lib.f.b.toLong(str, 0L);
                                    } else {
                                        this.userId = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                                    }
                                    this.isHost = this.userId == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
            }
            this.userId = intent.getLongExtra("user_id", com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.isHost = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_USER_SELF, true);
            this.isBigV = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_BIGV, false);
            this.maO = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_SHOW_THREAD_TOP, false);
            this.stType = intent.getStringExtra("st_type");
            this.threadId = intent.getStringExtra("thread_id");
            this.nid = intent.getStringExtra("nid");
        } else if (bundle != null) {
            this.userId = bundle.getLong("user_id", com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.isHost = bundle.getBoolean(PersonPolymericActivityConfig.IS_USER_SELF, true);
            this.isBigV = bundle.getBoolean(PersonPolymericActivityConfig.IS_BIGV, false);
            this.maO = bundle.getBoolean(PersonPolymericActivityConfig.IS_SHOW_THREAD_TOP, false);
            this.stType = bundle.getString("st_type");
            this.threadId = bundle.getString("thread_id");
            this.nid = bundle.getString("nid");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.aaB != null) {
            this.aaB.onDestory(getPageContext());
        }
        this.aaB = null;
        if (this.maP != null) {
            this.maP.onDestroy();
        }
        BdAsyncTask.removeAllTask(SetPrivacyModel.UNIQUE_ID_SET_PRIVACY_TASK);
        BdAsyncTask.removeAllTask(ForumManageModel.UNIQUE_ID_DEL_POST_TASK);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putLong("user_id", this.userId);
            bundle.putBoolean(PersonPolymericActivityConfig.IS_USER_SELF, this.isHost);
            bundle.putBoolean(PersonPolymericActivityConfig.IS_BIGV, this.isBigV);
            bundle.putBoolean(PersonPolymericActivityConfig.IS_SHOW_THREAD_TOP, this.maO);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        MessageManager.getInstance().unRegisterListener(this.kOe);
        MessageManager.getInstance().unRegisterListener(this.iJc);
        MessageManager.getInstance().unRegisterListener(this.lUZ);
        MessageManager.getInstance().unRegisterListener(this.kSc);
        MessageManager.getInstance().unRegisterListener(this.eNv);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 101:
                    if (this.maP.dvm() instanceof com.baidu.tieba.model.a) {
                        ((com.baidu.tieba.model.a) this.maP.dvm()).resetData();
                        ((com.baidu.tieba.model.a) this.maP.dvm()).loadData();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null && this.maP != null) {
                        this.maP.dvm().dvi().dwt().Y(intent);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    if (intent != null) {
                        int intExtra = intent.getIntExtra("upload_image_type", 0);
                        if (intExtra == 1) {
                            if (this.maP != null) {
                                this.maP.dvm().dvi().dwt().dvx();
                                this.maP.refreshData();
                                return;
                            }
                            return;
                        } else if (intExtra == 2 && this.maP != null) {
                            this.maP.dvr();
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST /* 12014 */:
                    if (intent != null) {
                        int intExtra2 = intent.getIntExtra("upload_image_type", 0);
                        if (intExtra2 == 1) {
                            if (this.maP != null) {
                                this.maP.dvm().dvi().dwt().dvx();
                                this.maP.refreshData();
                                return;
                            }
                            return;
                        } else if (intExtra2 == 2 && this.maP != null) {
                            this.maP.dvr();
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case RequestResponseCode.REQUEST_WRITE_NEW /* 13003 */:
                    ah(intent);
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.dzT().F(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                    S(intent);
                    return;
                case RequestResponseCode.REQUEST_MEMBER_GIFT /* 24001 */:
                    if (intent != null && (this.maP.dvm() instanceof com.baidu.tieba.model.a)) {
                        ((com.baidu.tieba.model.a) this.maP.dvm()).resetData();
                        ((com.baidu.tieba.model.a) this.maP.dvm()).loadData();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                    int intExtra3 = intent.getIntExtra("extra_share_status", 2);
                    int intExtra4 = intent.getIntExtra("extra_show_channel", 1);
                    if (intExtra3 == 1) {
                        com.baidu.tieba.o.a.dzT().F(getPageContext());
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                        aqVar.al("obj_locate", 8);
                        if (shareItem != null) {
                            aqVar.dR("tid", shareItem.tid);
                        }
                        aqVar.dR("pid", intent.getStringExtra("pid"));
                        TiebaStatic.log(aqVar);
                        if (shareItem != null && shareItem.linkUrl != null && this.jaw != null) {
                            this.jaw.a(shareItem.linkUrl, intExtra4, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.9
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void bwW() {
                                }

                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void a(final CustomDialogData customDialogData) {
                                    e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.9.1
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

    private void ah(Intent intent) {
        if (intent != null) {
            try {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                if (this.maP != null && !this.maP.d(postWriteCallBackData)) {
                    this.maP.b(postWriteCallBackData);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    private void S(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(cEd(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.oz(1);
            aVar.bf(thread2GroupShareView);
            aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) PersonPolymericFragment.this.getActivity().getSystemService("input_method");
                    l.hideSoftKeyPad(PersonPolymericFragment.this.getActivity(), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(PersonPolymericFragment.this.getActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.bxt() != null) {
                        Bundle bxt = shareItem.bxt();
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).al("obj_source", 1).al("obj_type", bxt.getInt("obj_type")).al("obj_param1", 3).dR("fid", bxt.getString("fid")).dR("tid", bxt.getString("tid")).al("obj_locate", 8));
                    }
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) PersonPolymericFragment.this.getActivity().getSystemService("input_method");
                    l.hideSoftKeyPad(PersonPolymericFragment.this.getActivity(), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.iW(true);
            aVar.b(getPageContext()).bpc();
            if (!k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.aP(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }

    private ShareFromPBMsgData cEd() {
        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.imageUri == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.imageUri.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.fgU);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.fName);
        shareFromPBMsgData.setThreadId(shareItem.tid);
        return shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.aaB == null) {
            this.aaB = VoiceManager.instance();
        }
        return this.aaB;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.maP != null) {
            this.maP.onChangeSkinType(i);
        }
    }

    private void dvc() {
        if (!TextUtils.isEmpty(this.stType)) {
            aq aqVar = new aq("c13541");
            aqVar.dR("tid", this.threadId);
            aqVar.w("uid", this.userId);
            int i = 5;
            if (AddFriendActivityConfig.TYPE_PB_HEAD.equals(this.stType)) {
                i = 1;
            } else if (AddFriendActivityConfig.TYPE_HOME_HEAD.equals(this.stType)) {
                i = 2;
            } else if (AddFriendActivityConfig.TYPE_FRS_HEAD.equals(this.stType)) {
                i = 3;
            } else if (AddFriendActivityConfig.TYPE_CONCERN_HEAD.equals(this.stType)) {
                i = 4;
            }
            aqVar.al("obj_source", i);
            TiebaStatic.log(aqVar);
        }
    }

    private void KZ(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        Map<String, String> paramPair = be.getParamPair(str);
        if (paramPair != null) {
            aq aqVar = new aq("c10320");
            aqVar.dR("obj_locate", paramPair.get("obj_locate"));
            aqVar.al("obj_type", 1);
            aqVar.dR("tid", paramPair.get("tid"));
            aqVar.dR("obj_source", paramPair.get("obj_source"));
            aqVar.dR(TiebaInitialize.Params.OBJ_PARAM2, paramPair.get(TiebaInitialize.Params.OBJ_PARAM2));
            aqVar.al(TiebaInitialize.Params.OBJ_TO, 3);
            aqVar.dR("obj_id", paramPair.get("bdid"));
            if (!at.isEmpty(paramPair.get(LogConfig.LOG_EXT_LOG))) {
                try {
                    JSONObject jSONObject = new JSONObject(paramPair.get(LogConfig.LOG_EXT_LOG));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        aqVar.dR(next, jSONObject.getString(next));
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
            }
            TiebaStatic.log(aqVar);
        }
    }
}
