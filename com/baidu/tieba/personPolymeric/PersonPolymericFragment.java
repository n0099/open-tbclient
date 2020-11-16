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
/* loaded from: classes23.dex */
public class PersonPolymericFragment extends BaseFragment implements VoiceManager.c {
    private VoiceManager aaG;
    private ShareSuccessReplyToServerModel jbi;
    private String lVp;
    private String lVq;
    private View mRootView;
    private g mbh;
    private String nid;
    private String stType;
    private String threadId;
    private long userId;
    private boolean isHost = true;
    private String mPortrait = "";
    @Deprecated
    private boolean isBigV = false;
    private boolean mbg = false;
    private boolean jka = false;
    private long ltM = 0;
    private AntiHelper.a iJy = new AntiHelper.a() { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ak("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ak("obj_locate", ay.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener kOr = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH_PERSONAL) { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonPolymericFragment.this.isHost) {
                PersonPolymericFragment.this.jka = true;
            }
        }
    };
    private HttpMessageListener kSp = new HttpMessageListener(1001505) { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001505) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode == 200 && error == 0 && PersonPolymericFragment.this.mbh != null) {
                    PersonPolymericFragment.this.mbh.vX(true);
                }
            }
        }
    };
    private CustomMessageListener iJQ = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UserData userData;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && PersonPolymericFragment.this.isHost) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && PersonPolymericFragment.this.mbh != null) {
                        com.baidu.tieba.personPolymeric.c.a vX = PersonPolymericFragment.this.mbh.vX(true);
                        PersonPolymericFragment.this.lVp = str;
                        if (vX != null && (userData = vX.getUserData()) != null) {
                            userData.setName_show(str);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener lVr = new CustomMessageListener(2921378) { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && PersonPolymericFragment.this.isHost) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    PersonPolymericFragment.this.lVq = (String) data;
                }
            }
        }
    };
    private CustomMessageListener eMu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
                if (data.fdL != null && AntiHelper.a(PersonPolymericFragment.this.getActivity(), data.fdL, PersonPolymericFragment.this.iJy) != null) {
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ak("obj_locate", ay.a.LOCATE_LIKE_PERSON));
                }
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mIsLogin = TbadkCoreApplication.isLogin();
        MessageManager.getInstance().registerListener(this.kOr);
        MessageManager.getInstance().registerListener(this.iJQ);
        MessageManager.getInstance().registerListener(this.lVr);
        MessageManager.getInstance().registerListener(this.kSp);
        MessageManager.getInstance().registerListener(this.eMu);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        b.duD().reset();
        b.duD().cX(currentTimeMillis);
        super.onCreate(bundle);
        this.aaG = getVoiceManager();
        if (this.aaG != null) {
            this.aaG.onCreate(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        aE(bundle);
        duC();
        duB();
        View inflate = layoutInflater.inflate(R.layout.fragment_person_center_layout, (ViewGroup) null);
        if (this.userId <= 0 && TbadkCoreApplication.getCurrentAccount() != null) {
            this.userId = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.mRootView = inflate;
        return inflate;
    }

    private void duB() {
        ar arVar = new ar("c13576");
        arVar.ak("obj_type", this.isHost ? 1 : 0);
        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(arVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mbh = new g(this, this.mRootView, getUniqueId(), this.userId, this.isHost, this.mbg, this.mPortrait);
        this.jbi = new ShareSuccessReplyToServerModel();
        b.duD().setCreateTime(System.currentTimeMillis() - b.duD().bde());
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.aaG = getVoiceManager();
        if (this.aaG != null) {
            this.aaG.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            this.mbh.bS(isPrimary());
            com.baidu.tieba.q.a.dBC().wP(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.aaG = getVoiceManager();
        if (this.aaG != null) {
            this.aaG.onResume(getPageContext());
        }
        this.mbh.onResume();
        if (!this.isHost && this.isBigV) {
            this.ltM = System.currentTimeMillis();
        } else {
            this.ltM = -1L;
        }
        if (this.mbh.duM() != null) {
            if (!StringUtils.isNull(this.lVp)) {
                this.mbh.duM().PY(this.lVp);
                this.lVp = null;
            }
            if (!StringUtils.isNull(this.lVq)) {
                this.mbh.duM().PZ(this.lVq);
                this.lVq = null;
            }
            if (this.jka) {
                this.mbh.duM().duH();
                this.jka = false;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.aaG = getVoiceManager();
        if (this.aaG != null) {
            this.aaG.onPause(getPageContext());
        }
        if (this.ltM > 0) {
            TiebaStatic.log(new ar("c12263").dR("obj_duration", String.valueOf((System.currentTimeMillis() - this.ltM) / 1000)).ak("obj_type", 2));
            this.ltM = 0L;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.aaG = getVoiceManager();
        if (this.aaG != null) {
            this.aaG.onStop(getPageContext());
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
                    f.bfS().d(uri, new f.a() { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.8
                        @Override // com.baidu.tbadk.BdToken.f.a
                        public void onCallBack(HashMap<String, Object> hashMap) {
                            if (hashMap != null && (hashMap.get(f.eqh) instanceof String)) {
                                PersonPolymericFragment.this.mPortrait = (String) hashMap.get(f.eqh);
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
                                KA(decode);
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
            this.mbg = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_SHOW_THREAD_TOP, false);
            this.stType = intent.getStringExtra("st_type");
            this.threadId = intent.getStringExtra("thread_id");
            this.nid = intent.getStringExtra("nid");
        } else if (bundle != null) {
            this.userId = bundle.getLong("user_id", com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.isHost = bundle.getBoolean(PersonPolymericActivityConfig.IS_USER_SELF, true);
            this.isBigV = bundle.getBoolean(PersonPolymericActivityConfig.IS_BIGV, false);
            this.mbg = bundle.getBoolean(PersonPolymericActivityConfig.IS_SHOW_THREAD_TOP, false);
            this.stType = bundle.getString("st_type");
            this.threadId = bundle.getString("thread_id");
            this.nid = bundle.getString("nid");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.aaG != null) {
            this.aaG.onDestory(getPageContext());
        }
        this.aaG = null;
        if (this.mbh != null) {
            this.mbh.onDestroy();
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
            bundle.putBoolean(PersonPolymericActivityConfig.IS_SHOW_THREAD_TOP, this.mbg);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        MessageManager.getInstance().unRegisterListener(this.kOr);
        MessageManager.getInstance().unRegisterListener(this.iJQ);
        MessageManager.getInstance().unRegisterListener(this.lVr);
        MessageManager.getInstance().unRegisterListener(this.kSp);
        MessageManager.getInstance().unRegisterListener(this.eMu);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 101:
                    if (this.mbh.duM() instanceof com.baidu.tieba.model.a) {
                        ((com.baidu.tieba.model.a) this.mbh.duM()).resetData();
                        ((com.baidu.tieba.model.a) this.mbh.duM()).loadData();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null && this.mbh != null) {
                        this.mbh.duM().duI().dvT().Y(intent);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    if (intent != null) {
                        int intExtra = intent.getIntExtra("upload_image_type", 0);
                        if (intExtra == 1) {
                            if (this.mbh != null) {
                                this.mbh.duM().duI().dvT().duX();
                                this.mbh.refreshData();
                                return;
                            }
                            return;
                        } else if (intExtra == 2 && this.mbh != null) {
                            this.mbh.duR();
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
                            if (this.mbh != null) {
                                this.mbh.duM().duI().dvT().duX();
                                this.mbh.refreshData();
                                return;
                            }
                            return;
                        } else if (intExtra2 == 2 && this.mbh != null) {
                            this.mbh.duR();
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
                    com.baidu.tieba.p.a.dzt().F(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                    S(intent);
                    return;
                case RequestResponseCode.REQUEST_MEMBER_GIFT /* 24001 */:
                    if (intent != null && (this.mbh.duM() instanceof com.baidu.tieba.model.a)) {
                        ((com.baidu.tieba.model.a) this.mbh.duM()).resetData();
                        ((com.baidu.tieba.model.a) this.mbh.duM()).loadData();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                    int intExtra3 = intent.getIntExtra("extra_share_status", 2);
                    int intExtra4 = intent.getIntExtra("extra_show_channel", 1);
                    if (intExtra3 == 1) {
                        com.baidu.tieba.p.a.dzt().F(getPageContext());
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        ar arVar = new ar(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                        arVar.ak("obj_locate", 8);
                        if (shareItem != null) {
                            arVar.dR("tid", shareItem.tid);
                        }
                        arVar.dR("pid", intent.getStringExtra("pid"));
                        TiebaStatic.log(arVar);
                        if (shareItem != null && shareItem.linkUrl != null && this.jbi != null) {
                            this.jbi.a(shareItem.linkUrl, intExtra4, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.9
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void bwm() {
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
                if (this.mbh != null && !this.mbh.d(postWriteCallBackData)) {
                    this.mbh.b(postWriteCallBackData);
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
        a(cDH(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.ov(1);
            aVar.bg(thread2GroupShareView);
            aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) PersonPolymericFragment.this.getActivity().getSystemService("input_method");
                    l.hideSoftKeyPad(PersonPolymericFragment.this.getActivity(), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(PersonPolymericFragment.this.getActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.bwJ() != null) {
                        Bundle bwJ = shareItem.bwJ();
                        TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ak("obj_source", 1).ak("obj_type", bwJ.getInt("obj_type")).ak("obj_param1", 3).dR("fid", bwJ.getString("fid")).dR("tid", bwJ.getString("tid")).ak("obj_locate", 8));
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
            aVar.iX(true);
            aVar.b(getPageContext()).bog();
            if (!k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.aP(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }

    private ShareFromPBMsgData cDH() {
        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.imageUri == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.imageUri.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.fgc);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.fName);
        shareFromPBMsgData.setThreadId(shareItem.tid);
        return shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.aaG == null) {
            this.aaG = VoiceManager.instance();
        }
        return this.aaG;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mbh != null) {
            this.mbh.onChangeSkinType(i);
        }
    }

    private void duC() {
        if (!TextUtils.isEmpty(this.stType)) {
            ar arVar = new ar("c13541");
            arVar.dR("tid", this.threadId);
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
            arVar.ak("obj_source", i);
            TiebaStatic.log(arVar);
        }
    }

    private void KA(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        Map<String, String> paramPair = bf.getParamPair(str);
        if (paramPair != null) {
            ar arVar = new ar("c10320");
            arVar.dR("obj_locate", paramPair.get("obj_locate"));
            arVar.ak("obj_type", 1);
            arVar.dR("tid", paramPair.get("tid"));
            arVar.dR("obj_source", paramPair.get("obj_source"));
            arVar.dR(TiebaInitialize.Params.OBJ_PARAM2, paramPair.get(TiebaInitialize.Params.OBJ_PARAM2));
            arVar.ak(TiebaInitialize.Params.OBJ_TO, 3);
            arVar.dR("obj_id", paramPair.get("bdid"));
            if (!au.isEmpty(paramPair.get(LogConfig.LOG_EXT_LOG))) {
                try {
                    JSONObject jSONObject = new JSONObject(paramPair.get(LogConfig.LOG_EXT_LOG));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        arVar.dR(next, jSONObject.getString(next));
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
            }
            TiebaStatic.log(arVar);
        }
    }
}
