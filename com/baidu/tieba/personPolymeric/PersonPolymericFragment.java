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
import com.baidu.adp.lib.f.b;
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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.R;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.interactionpopupwindow.c;
import com.baidu.tieba.personPolymeric.b.f;
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
/* loaded from: classes11.dex */
public class PersonPolymericFragment extends BaseFragment implements VoiceManager.c {
    private ShareSuccessReplyToServerModel gFE;
    private String jiA;
    private String jiB;
    private VoiceManager jnW;
    private f jnY;
    private View mRootView;
    private String stType;
    private String threadId;
    private long userId;
    private boolean isHost = true;
    private String mPortrait = "";
    @Deprecated
    private boolean isBigV = false;
    private boolean jnX = false;
    private boolean gqV = false;
    private long iIY = 0;
    private AntiHelper.a gqp = new AntiHelper.a() { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).X("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).X("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener iiu = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH_PERSONAL) { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (PersonPolymericFragment.this.isHost) {
                PersonPolymericFragment.this.gqV = true;
            }
        }
    };
    private HttpMessageListener imw = new HttpMessageListener(1001505) { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001505) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode == 200 && error == 0 && PersonPolymericFragment.this.jnY != null) {
                    PersonPolymericFragment.this.jnY.rx(true);
                }
            }
        }
    };
    private CustomMessageListener gqE = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UserData userData;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && PersonPolymericFragment.this.isHost) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && PersonPolymericFragment.this.jnY != null) {
                        com.baidu.tieba.personPolymeric.c.a rx2 = PersonPolymericFragment.this.jnY.rx(true);
                        PersonPolymericFragment.this.jiA = str;
                        if (rx2 != null && (userData = rx2.getUserData()) != null) {
                            userData.setName_show(str);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener jiC = new CustomMessageListener(2921378) { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && PersonPolymericFragment.this.isHost) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    PersonPolymericFragment.this.jiB = (String) data;
                }
            }
        }
    };
    private CustomMessageListener dat = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage.a data = ((UpdateAttentionMessage) customResponsedMessage).getData();
                if (data.dow != null && AntiHelper.a(PersonPolymericFragment.this.getActivity(), data.dow, PersonPolymericFragment.this.gqp) != null) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_LIKE_PERSON));
                }
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mIsLogin = TbadkCoreApplication.isLogin();
        MessageManager.getInstance().registerListener(this.iiu);
        MessageManager.getInstance().registerListener(this.gqE);
        MessageManager.getInstance().registerListener(this.jiC);
        MessageManager.getInstance().registerListener(this.imw);
        MessageManager.getInstance().registerListener(this.dat);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jnW = getVoiceManager();
        if (this.jnW != null) {
            this.jnW.onCreate(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        aw(bundle);
        cwZ();
        cwY();
        View inflate = layoutInflater.inflate(R.layout.fragment_person_center_layout, (ViewGroup) null);
        if (this.userId <= 0 && TbadkCoreApplication.getCurrentAccount() != null) {
            this.userId = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        }
        this.mRootView = inflate;
        return inflate;
    }

    private void cwY() {
        an anVar = new an("c13576");
        anVar.X("obj_type", this.isHost ? 1 : 0);
        anVar.cx("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(anVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.jnY = new f(this, this.mRootView, getUniqueId(), this.userId, this.isHost, this.jnX, this.mPortrait);
        this.gFE = new ShareSuccessReplyToServerModel();
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.jnW = getVoiceManager();
        if (this.jnW != null) {
            this.jnW.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded()) {
            this.jnY.onPrimary(isPrimary());
            com.baidu.tieba.p.a.cEk().so(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.jnW = getVoiceManager();
        if (this.jnW != null) {
            this.jnW.onResume(getPageContext());
        }
        this.jnY.onResume();
        if (!this.isHost && this.isBigV) {
            this.iIY = System.currentTimeMillis();
        } else {
            this.iIY = -1L;
        }
        if (this.jnY.cxg() != null) {
            if (!StringUtils.isNull(this.jiA)) {
                this.jnY.cxg().GS(this.jiA);
                this.jiA = null;
            }
            if (!StringUtils.isNull(this.jiB)) {
                this.jnY.cxg().GT(this.jiB);
                this.jiB = null;
            }
            if (this.gqV) {
                this.jnY.cxg().cxb();
                this.gqV = false;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.jnW = getVoiceManager();
        if (this.jnW != null) {
            this.jnW.onPause(getPageContext());
        }
        if (this.iIY > 0) {
            TiebaStatic.log(new an("c12263").cx("obj_duration", String.valueOf((System.currentTimeMillis() - this.iIY) / 1000)).X("obj_type", 2));
            this.iIY = 0L;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.jnW = getVoiceManager();
        if (this.jnW != null) {
            this.jnW.onStop(getPageContext());
        }
    }

    private void aw(Bundle bundle) {
        Map<String, String> paramPair;
        int length;
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            this.userId = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            this.isHost = this.userId == b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
            if (intent.getParcelableExtra("key_uri") != null) {
                Uri uri = (Uri) intent.getParcelableExtra("key_uri");
                String uri2 = uri.toString();
                if (com.baidu.tbadk.BdToken.f.n(uri)) {
                    com.baidu.tbadk.BdToken.f.axS().e(uri, new f.a() { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.8
                        @Override // com.baidu.tbadk.BdToken.f.a
                        public void n(HashMap<String, Object> hashMap) {
                            if (hashMap != null && (hashMap.get(com.baidu.tbadk.BdToken.f.cIA) instanceof String)) {
                                PersonPolymericFragment.this.mPortrait = (String) hashMap.get(com.baidu.tbadk.BdToken.f.cIA);
                                if (!StringUtils.isNull(PersonPolymericFragment.this.mPortrait)) {
                                    PersonPolymericFragment.this.isHost = false;
                                }
                            }
                        }
                    });
                } else if (!StringUtils.isNull(uri2) && (uri2.startsWith("tbusercenter://") || uri2.startsWith("com.baidu.tieba://usercenter"))) {
                    String decode = Uri.decode(uri.getEncodedPath());
                    if (!StringUtils.isNull(decode)) {
                        if (uri2.startsWith("tbusercenter://")) {
                            BO(decode);
                            Matcher matcher = Pattern.compile(".*fr=(.*)&portrait=([\\d]+).*").matcher(decode);
                            if (matcher.find()) {
                                this.mPortrait = matcher.group(2);
                            } else {
                                int indexOf = decode.indexOf("portrait=");
                                if (indexOf >= 0 && (length = indexOf + "portrait=".length()) <= decode.length()) {
                                    this.mPortrait = decode.substring(length);
                                    if (!StringUtils.isNull(this.mPortrait)) {
                                        this.isHost = false;
                                    }
                                } else {
                                    return;
                                }
                            }
                        } else if (uri2.startsWith("com.baidu.tieba://usercenter")) {
                            if (decode.startsWith("//")) {
                                decode = decode.substring(2);
                            }
                            if (!StringUtils.isNull(decode) && (paramPair = ba.getParamPair(decode)) != null) {
                                String str = paramPair.get("uid");
                                if (!StringUtils.isNull(str)) {
                                    this.userId = b.toLong(str, 0L);
                                } else {
                                    this.userId = b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                                }
                                this.isHost = this.userId == b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                            } else {
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                }
                String queryParameter = uri.getQueryParameter("obj_source");
                if ("shoubai".equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter)) {
                    String queryParameter2 = uri.getQueryParameter("obj_locate");
                    String queryParameter3 = uri.getQueryParameter("obj_type");
                    String queryParameter4 = uri.getQueryParameter("obj_param1");
                    String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                    an anVar = new an("c13561");
                    anVar.cx("obj_locate", queryParameter2);
                    anVar.cx("obj_type", queryParameter3);
                    anVar.cx("obj_param1", queryParameter4);
                    anVar.cx(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                    anVar.cx("obj_source", queryParameter);
                    TiebaStatic.log(anVar);
                    return;
                }
                return;
            }
            this.userId = intent.getLongExtra("user_id", b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.isHost = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_USER_SELF, true);
            this.isBigV = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_BIGV, false);
            this.jnX = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_SHOW_THREAD_TOP, false);
            this.stType = intent.getStringExtra("st_type");
            this.threadId = intent.getStringExtra("thread_id");
        } else if (bundle != null) {
            this.userId = bundle.getLong("user_id", b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.isHost = bundle.getBoolean(PersonPolymericActivityConfig.IS_USER_SELF, true);
            this.isBigV = bundle.getBoolean(PersonPolymericActivityConfig.IS_BIGV, false);
            this.jnX = bundle.getBoolean(PersonPolymericActivityConfig.IS_SHOW_THREAD_TOP, false);
            this.stType = bundle.getString("st_type");
            this.threadId = bundle.getString("thread_id");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.jnW != null) {
            this.jnW.onDestory(getPageContext());
        }
        this.jnW = null;
        if (this.jnY != null) {
            this.jnY.onDestroy();
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
            bundle.putBoolean(PersonPolymericActivityConfig.IS_SHOW_THREAD_TOP, this.jnX);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        MessageManager.getInstance().unRegisterListener(this.iiu);
        MessageManager.getInstance().unRegisterListener(this.gqE);
        MessageManager.getInstance().unRegisterListener(this.jiC);
        MessageManager.getInstance().unRegisterListener(this.imw);
        MessageManager.getInstance().unRegisterListener(this.dat);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 101:
                    if (this.jnY.cxg() instanceof com.baidu.tieba.model.a) {
                        ((com.baidu.tieba.model.a) this.jnY.cxg()).resetData();
                        ((com.baidu.tieba.model.a) this.jnY.cxg()).loadData();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null && this.jnY != null) {
                        this.jnY.cxg().cxc().cyi().ap(intent);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    if (intent != null) {
                        int intExtra = intent.getIntExtra("upload_image_type", 0);
                        if (intExtra == 1) {
                            if (this.jnY != null) {
                                this.jnY.cxg().cxc().cyi().cxr();
                                this.jnY.refreshData();
                                return;
                            }
                            return;
                        } else if (intExtra == 2 && this.jnY != null) {
                            this.jnY.cxl();
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
                            if (this.jnY != null) {
                                this.jnY.cxg().cxc().cyi().cxr();
                                this.jnY.refreshData();
                                return;
                            }
                            return;
                        } else if (intExtra2 == 2 && this.jnY != null) {
                            this.jnY.cxl();
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case RequestResponseCode.REQUEST_WRITE_NEW /* 13003 */:
                    aw(intent);
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.cCv().B(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                    aj(intent);
                    return;
                case RequestResponseCode.REQUEST_MEMBER_GIFT /* 24001 */:
                    if (intent != null && (this.jnY.cxg() instanceof com.baidu.tieba.model.a)) {
                        ((com.baidu.tieba.model.a) this.jnY.cxg()).resetData();
                        ((com.baidu.tieba.model.a) this.jnY.cxg()).loadData();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                    int intExtra3 = intent.getIntExtra("extra_share_status", 2);
                    int intExtra4 = intent.getIntExtra("extra_show_channel", 1);
                    if (intExtra3 == 1) {
                        com.baidu.tieba.o.a.cCv().B(getPageContext());
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (shareItem != null && shareItem.linkUrl != null && this.gFE != null) {
                            this.gFE.a(shareItem.linkUrl, intExtra4, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.9
                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void aLP() {
                                }

                                @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                                public void a(final CustomDialogData customDialogData) {
                                    e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.9.1
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

    private void aw(Intent intent) {
        if (intent != null) {
            try {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                if (this.jnY != null && !this.jnY.d(postWriteCallBackData)) {
                    this.jnY.b(postWriteCallBackData);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    private void aj(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(bJp(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.jZ(1);
            aVar.aO(thread2GroupShareView);
            aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.personPolymeric.PersonPolymericFragment.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) PersonPolymericFragment.this.getActivity().getSystemService("input_method");
                    l.hideSoftKeyPad(PersonPolymericFragment.this.getActivity(), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(PersonPolymericFragment.this.getActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.aMw() != null) {
                        Bundle aMw = shareItem.aMw();
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).X("obj_source", 1).X("obj_type", aMw.getInt("obj_type")).X("obj_param1", 3).cx("fid", aMw.getString("fid")).cx("tid", aMw.getString("tid")));
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
            aVar.fI(true);
            aVar.b(getPageContext()).aEG();
            if (!k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.am(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }

    private ShareFromPBMsgData bJp() {
        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.imageUri == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.imageUri.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.dqC);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.fName);
        shareFromPBMsgData.setThreadId(shareItem.tid);
        return shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.jnW == null) {
            this.jnW = VoiceManager.instance();
        }
        return this.jnW;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jnY != null) {
            this.jnY.onChangeSkinType(i);
        }
    }

    private void cwZ() {
        if (!TextUtils.isEmpty(this.stType)) {
            an anVar = new an("c13541");
            anVar.cx("tid", this.threadId);
            anVar.s("uid", this.userId);
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
            anVar.X("obj_source", i);
            TiebaStatic.log(anVar);
        }
    }

    private void BO(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        Map<String, String> paramPair = ba.getParamPair(str);
        if (paramPair != null) {
            an anVar = new an("c10320");
            anVar.cx("obj_locate", paramPair.get("obj_locate"));
            anVar.X("obj_type", 1);
            anVar.cx("tid", paramPair.get("tid"));
            anVar.cx("obj_source", paramPair.get("obj_source"));
            anVar.cx(TiebaInitialize.Params.OBJ_PARAM2, paramPair.get(TiebaInitialize.Params.OBJ_PARAM2));
            anVar.X(TiebaInitialize.Params.OBJ_TO, 3);
            anVar.cx("obj_id", paramPair.get("bdid"));
            if (!aq.isEmpty(paramPair.get(LogConfig.LOG_EXT_LOG))) {
                try {
                    JSONObject jSONObject = new JSONObject(paramPair.get(LogConfig.LOG_EXT_LOG));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        anVar.cx(next, jSONObject.getString(next));
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
            }
            TiebaStatic.log(anVar);
        }
    }
}
