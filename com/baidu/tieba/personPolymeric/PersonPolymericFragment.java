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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bf;
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
    private VoiceManager abD;
    private ShareSuccessReplyToServerModel joM;
    private View mRootView;
    private String mjy;
    private String mjz;
    private g mpp;
    private String nid;
    private String stType;
    private String threadId;
    private long userId;
    private boolean isHost = true;
    private String mPortrait = "";
    @Deprecated
    private boolean isBigV = false;
    private boolean mpo = false;
    private boolean jxF = false;
    private long lHA = 0;
    private AntiHelper.a iUs = new AntiHelper.a() { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener lbL = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH_PERSONAL) { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonPolymericFragment.this.isHost) {
                PersonPolymericFragment.this.jxF = true;
            }
        }
    };
    private HttpMessageListener lfK = new HttpMessageListener(1001505) { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001505) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode == 200 && error == 0 && PersonPolymericFragment.this.mpp != null) {
                    PersonPolymericFragment.this.mpp.wB(true);
                }
            }
        }
    };
    private CustomMessageListener iUK = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UserData userData;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && PersonPolymericFragment.this.isHost) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && PersonPolymericFragment.this.mpp != null) {
                        com.baidu.tieba.personPolymeric.c.a wB = PersonPolymericFragment.this.mpp.wB(true);
                        PersonPolymericFragment.this.mjy = str;
                        if (wB != null && (userData = wB.getUserData()) != null) {
                            userData.setName_show(str);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener mjA = new CustomMessageListener(2921378) { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && PersonPolymericFragment.this.isHost) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    PersonPolymericFragment.this.mjz = (String) data;
                }
            }
        }
    };
    private CustomMessageListener eTG = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
                if (data.flk != null && AntiHelper.a(PersonPolymericFragment.this.getActivity(), data.flk, PersonPolymericFragment.this.iUs) != null) {
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).al("obj_locate", ay.a.LOCATE_LIKE_PERSON));
                }
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mIsLogin = TbadkCoreApplication.isLogin();
        MessageManager.getInstance().registerListener(this.lbL);
        MessageManager.getInstance().registerListener(this.iUK);
        MessageManager.getInstance().registerListener(this.mjA);
        MessageManager.getInstance().registerListener(this.lfK);
        MessageManager.getInstance().registerListener(this.eTG);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        b.dzW().reset();
        b.dzW().dw(currentTimeMillis);
        super.onCreate(bundle);
        this.abD = getVoiceManager();
        if (this.abD != null) {
            this.abD.onCreate(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        aF(bundle);
        dzV();
        dzU();
        View inflate = layoutInflater.inflate(R.layout.fragment_person_center_layout, (ViewGroup) null);
        if (this.userId <= 0 && TbadkCoreApplication.getCurrentAccount() != null) {
            this.userId = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.mRootView = inflate;
        return inflate;
    }

    private void dzU() {
        ar arVar = new ar("c13576");
        arVar.al("obj_type", this.isHost ? 1 : 0);
        arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(arVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mpp = new g(this, this.mRootView, getUniqueId(), this.userId, this.isHost, this.mpo, this.mPortrait);
        this.joM = new ShareSuccessReplyToServerModel();
        b.dzW().setCreateTime(System.currentTimeMillis() - b.dzW().bgj());
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.abD = getVoiceManager();
        if (this.abD != null) {
            this.abD.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            this.mpp.cb(isPrimary());
            com.baidu.tieba.q.a.dGO().xt(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.abD = getVoiceManager();
        if (this.abD != null) {
            this.abD.onResume(getPageContext());
        }
        this.mpp.onResume();
        if (!this.isHost && this.isBigV) {
            this.lHA = System.currentTimeMillis();
        } else {
            this.lHA = -1L;
        }
        if (this.mpp.dAf() != null) {
            if (!StringUtils.isNull(this.mjy)) {
                this.mpp.dAf().Rh(this.mjy);
                this.mjy = null;
            }
            if (!StringUtils.isNull(this.mjz)) {
                this.mpp.dAf().Ri(this.mjz);
                this.mjz = null;
            }
            if (this.jxF) {
                this.mpp.dAf().dAa();
                this.jxF = false;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.abD = getVoiceManager();
        if (this.abD != null) {
            this.abD.onPause(getPageContext());
        }
        if (this.lHA > 0) {
            TiebaStatic.log(new ar("c12263").dY("obj_duration", String.valueOf((System.currentTimeMillis() - this.lHA) / 1000)).al("obj_type", 2));
            this.lHA = 0L;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.abD = getVoiceManager();
        if (this.abD != null) {
            this.abD.onStop(getPageContext());
        }
    }

    private void aF(Bundle bundle) {
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
                    f.biX().d(uri, new f.a() { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.8
                        @Override // com.baidu.tbadk.BdToken.f.a
                        public void onCallBack(HashMap<String, Object> hashMap) {
                            if (hashMap != null && (hashMap.get(f.exh) instanceof String)) {
                                PersonPolymericFragment.this.mPortrait = (String) hashMap.get(f.exh);
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
                                LH(decode);
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
                                if (!StringUtils.isNull(decode) && (paramPair = bf.getParamPair(decode)) != null) {
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
            this.mpo = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_SHOW_THREAD_TOP, false);
            this.stType = intent.getStringExtra("st_type");
            this.threadId = intent.getStringExtra("thread_id");
            this.nid = intent.getStringExtra("nid");
        } else if (bundle != null) {
            this.userId = bundle.getLong("user_id", com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.isHost = bundle.getBoolean(PersonPolymericActivityConfig.IS_USER_SELF, true);
            this.isBigV = bundle.getBoolean(PersonPolymericActivityConfig.IS_BIGV, false);
            this.mpo = bundle.getBoolean(PersonPolymericActivityConfig.IS_SHOW_THREAD_TOP, false);
            this.stType = bundle.getString("st_type");
            this.threadId = bundle.getString("thread_id");
            this.nid = bundle.getString("nid");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.abD != null) {
            this.abD.onDestory(getPageContext());
        }
        this.abD = null;
        if (this.mpp != null) {
            this.mpp.onDestroy();
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
            bundle.putBoolean(PersonPolymericActivityConfig.IS_SHOW_THREAD_TOP, this.mpo);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        MessageManager.getInstance().unRegisterListener(this.lbL);
        MessageManager.getInstance().unRegisterListener(this.iUK);
        MessageManager.getInstance().unRegisterListener(this.mjA);
        MessageManager.getInstance().unRegisterListener(this.lfK);
        MessageManager.getInstance().unRegisterListener(this.eTG);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 101:
                    if (this.mpp.dAf() instanceof com.baidu.tieba.model.a) {
                        ((com.baidu.tieba.model.a) this.mpp.dAf()).resetData();
                        ((com.baidu.tieba.model.a) this.mpp.dAf()).loadData();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null && this.mpp != null) {
                        this.mpp.dAf().dAb().dBm().Y(intent);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    if (intent != null) {
                        int intExtra = intent.getIntExtra("upload_image_type", 0);
                        if (intExtra == 1) {
                            if (this.mpp != null) {
                                this.mpp.dAf().dAb().dBm().dAq();
                                this.mpp.refreshData();
                                return;
                            }
                            return;
                        } else if (intExtra == 2 && this.mpp != null) {
                            this.mpp.dAk();
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
                            if (this.mpp != null) {
                                this.mpp.dAf().dAb().dBm().dAq();
                                this.mpp.refreshData();
                                return;
                            }
                            return;
                        } else if (intExtra2 == 2 && this.mpp != null) {
                            this.mpp.dAk();
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
                    com.baidu.tieba.p.a.dEL().F(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                    S(intent);
                    return;
                case RequestResponseCode.REQUEST_MEMBER_GIFT /* 24001 */:
                    if (intent != null && (this.mpp.dAf() instanceof com.baidu.tieba.model.a)) {
                        ((com.baidu.tieba.model.a) this.mpp.dAf()).resetData();
                        ((com.baidu.tieba.model.a) this.mpp.dAf()).loadData();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                    int intExtra3 = intent.getIntExtra("extra_share_status", 2);
                    int intExtra4 = intent.getIntExtra("extra_show_channel", 1);
                    if (intExtra3 == 1) {
                        com.baidu.tieba.p.a.dEL().F(getPageContext());
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        ar arVar = new ar(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                        arVar.al("obj_locate", 8);
                        if (shareItem != null) {
                            arVar.dY("tid", shareItem.tid);
                        }
                        arVar.dY("pid", intent.getStringExtra("pid"));
                        TiebaStatic.log(arVar);
                        if (shareItem != null && shareItem.linkUrl != null && this.joM != null) {
                            this.joM.a(shareItem.linkUrl, intExtra4, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.9
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void bzM() {
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
                if (this.mpp != null && !this.mpp.d(postWriteCallBackData)) {
                    this.mpp.b(postWriteCallBackData);
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
        a(cIV(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.oT(1);
            aVar.bi(thread2GroupShareView);
            aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) PersonPolymericFragment.this.getActivity().getSystemService("input_method");
                    l.hideSoftKeyPad(PersonPolymericFragment.this.getActivity(), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(PersonPolymericFragment.this.getActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.bAj() != null) {
                        Bundle bAj = shareItem.bAj();
                        TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).al("obj_source", 1).al("obj_type", bAj.getInt("obj_type")).al("obj_param1", 3).dY("fid", bAj.getString("fid")).dY("tid", bAj.getString("tid")).al("obj_locate", 8));
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
            aVar.jm(true);
            aVar.b(getPageContext()).brv();
            if (!k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.aQ(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }

    private ShareFromPBMsgData cIV() {
        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.imageUri == null ? "https://tieba-fe.gz.bcebos.com/yunying/tieba_logo.jpg" : shareItem.imageUri.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.fnC);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.fName);
        shareFromPBMsgData.setThreadId(shareItem.tid);
        return shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.abD == null) {
            this.abD = VoiceManager.instance();
        }
        return this.abD;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mpp != null) {
            this.mpp.onChangeSkinType(i);
        }
    }

    private void dzV() {
        if (!TextUtils.isEmpty(this.stType)) {
            ar arVar = new ar("c13541");
            arVar.dY("tid", this.threadId);
            arVar.w("uid", this.userId);
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
            arVar.al("obj_source", i);
            TiebaStatic.log(arVar);
        }
    }

    private void LH(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        Map<String, String> paramPair = bf.getParamPair(str);
        if (paramPair != null) {
            ar arVar = new ar("c10320");
            arVar.dY("obj_locate", paramPair.get("obj_locate"));
            arVar.al("obj_type", 1);
            arVar.dY("tid", paramPair.get("tid"));
            arVar.dY("obj_source", paramPair.get("obj_source"));
            arVar.dY(TiebaInitialize.Params.OBJ_PARAM2, paramPair.get(TiebaInitialize.Params.OBJ_PARAM2));
            arVar.al(TiebaInitialize.Params.OBJ_TO, 3);
            arVar.dY("obj_id", paramPair.get("bdid"));
            if (!au.isEmpty(paramPair.get(LogConfig.LOG_EXT_LOG))) {
                try {
                    JSONObject jSONObject = new JSONObject(paramPair.get(LogConfig.LOG_EXT_LOG));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        arVar.dY(next, jSONObject.getString(next));
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
            }
            TiebaStatic.log(arVar);
        }
    }
}
