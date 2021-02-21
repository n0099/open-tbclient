package com.baidu.tieba.tblauncher;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.live.tbadk.data.Config;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BdToken.f;
import com.baidu.tbadk.KuangFloatingViewController;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.NewUserRedPackageActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.message.ExitAppMessage;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.data.UserData;
import com.baidu.tbadk.data.i;
import com.baidu.tbadk.data.k;
import com.baidu.tbadk.data.m;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.switchs.GameEnterSwitch;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.util.ak;
import com.baidu.tbadk.util.r;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.Thread2GroupShareView;
import com.baidu.tieba.write.g;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import protobuf.ConfigVersion;
/* loaded from: classes.dex */
public class MainTabActivity extends BaseFragmentActivity implements com.baidu.tbadk.core.util.g.b, UserIconBox.a, VoiceManager.c, FrsCommonImageLayout.c, com.baidu.tieba.tblauncher.a {
    private static boolean syncHasFinish;
    private boolean esb;
    private com.baidu.adp.lib.d.b<TbImageView> flN;
    private com.baidu.tieba.ueg.d gEW;
    private FrameLayout hVb;
    private ShareSuccessReplyToServerModel jCx;
    VoiceManager jgu;
    private com.baidu.tieba.NEGFeedBack.a jhj;
    private g jkO;
    private CheckRealNameModel lVX;
    private com.baidu.tieba.ueg.b mNA;
    private WeakReference<Context> mWeakContext;
    private e nDB;
    private com.baidu.tieba.c.e nDQ;
    private String nDV;
    private bl nDk;
    private d nDn;
    private a nDo;
    private com.baidu.adp.lib.d.b<TbImageView> nDq;
    private com.baidu.tieba.b nDs;
    private c nDu;
    private com.baidu.tbadk.BdToken.d nDv;
    private com.baidu.tieba.c.e nDx;
    private int nDy;
    private boolean nDh = false;
    private int nDi = -1;
    private boolean nDj = false;
    private String mFrom = null;
    private volatile boolean mIsAdd = false;
    private long nDl = 0;
    private long nDm = 0;
    private long nDp = -1;
    private boolean nDr = false;
    private String nDt = "";
    boolean nDw = false;
    boolean hPA = false;
    boolean jfw = true;
    private Integer nDz = -1;
    private int nDA = 16;
    private boolean nDC = false;
    private CustomMessageListener nDD = new CustomMessageListener(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && MainTabActivity.this.nDn != null && TbadkCoreApplication.getInst().getCurrentActivity() == MainTabActivity.this) {
                MainTabActivity.this.nDw = com.baidu.adp.lib.f.b.toBoolean(customResponsedMessage.getData().toString(), false);
                MainTabActivity.this.nDn.onKeyboardVisibilityChanged((MainTabActivity.this.nDw || MainTabActivity.this.hPA) ? true : true);
            }
        }
    };
    private final CustomMessageListener nDE = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_MATINTAB) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001377) {
                MainTabActivity.this.finish();
            }
        }
    };
    private final CustomMessageListener skinTypeChangeListener = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                int oldSkinType = TbadkCoreApplication.getInst().getOldSkinType();
                if (!((intValue == 2 || oldSkinType == 2) ? false : true)) {
                    if ((intValue == 3 || intValue == 1 || intValue == 0) && oldSkinType == 2) {
                        MainTabActivity.this.nDn.cEC().changeStyle(1);
                    } else if (TbadkCoreApplication.getInst().isThemeIconCover()) {
                        MainTabActivity.this.nDn.cEC().changeStyle(2);
                    } else {
                        MainTabActivity.this.nDn.cEC().changeStyle(1);
                    }
                }
            }
        }
    };
    public CustomMessageListener nDF = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_IS_MIX) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && MainTabActivity.this.nDn != null && MainTabActivity.this.nDn.cEC() != null) {
                if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    MainTabActivity.this.nDn.cEC().getTabWrapper().animate().translationY(MainTabActivity.this.nDn.cEC().getTabWrapper().getHeight()).setDuration(200L).start();
                } else {
                    MainTabActivity.this.nDn.cEC().getTabWrapper().animate().translationY(0.0f).setDuration(400L).start();
                }
            }
        }
    };
    public CustomMessageListener nDG = new CustomMessageListener(2921452) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof k) && bh.checkUpIsLogin(MainTabActivity.this.getPageContext().getPageActivity())) {
                MainTabActivity.this.cEA();
            }
        }
    };
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.e) && ((com.baidu.tieba.tbadkCore.writeModel.e) customResponsedMessage.getData()).isSuccess && MainTabActivity.this.nDy == 0) {
                MainTabActivity.this.dPV();
            }
        }
    };
    private CustomMessageListener iJy = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = MainTabActivity.this.nDz.intValue();
                MainTabActivity.this.nDz = (Integer) customResponsedMessage.getData();
                if (MainTabActivity.this.nDz.intValue() == 1) {
                    MainTabActivity.this.dPX();
                } else if (intValue == 1) {
                    MainTabActivity.this.dPW();
                }
                if (MainTabActivity.this.nDz.intValue() == 2) {
                    MainTabActivity.this.dQc();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c kIz = new com.baidu.adp.framework.listener.c(1001) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ConfigVersion configVersion;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                if (socketResponsedMessage.getError() == 0 && (configVersion = responseOnlineMessage.getConfigVersion()) != null) {
                    MainTabActivity.this.TY(configVersion.sync);
                }
            }
        }
    };
    private CustomMessageListener nDH = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_JUMP_PB) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            i iVar;
            String link;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i) && (link = (iVar = (i) customResponsedMessage.getData()).getLink()) != null) {
                try {
                    Uri parse = Uri.parse(link);
                    String queryParameter = parse.getQueryParameter("pid");
                    String queryParameter2 = parse.getQueryParameter("tid");
                    String queryParameter3 = parse.getQueryParameter("threadtype");
                    String queryParameter4 = parse.getQueryParameter("jump_type");
                    BaijiahaoData baijiahaoData = new BaijiahaoData();
                    baijiahaoData.oriUgcNid = parse.getQueryParameter("ori_ugc_nid");
                    baijiahaoData.oriUgcTid = parse.getQueryParameter("ori_ugc_tid");
                    baijiahaoData.oriUgcType = com.baidu.adp.lib.f.b.toInt(parse.getQueryParameter("ori_ugc_type"), 0);
                    baijiahaoData.oriUgcVid = parse.getQueryParameter("ori_ugc_vid");
                    if (!StringUtils.isNull(queryParameter3)) {
                        int i = com.baidu.adp.lib.f.b.toInt(queryParameter3, 0);
                        if (iVar.getPageContext() != null) {
                            r.a(queryParameter2, queryParameter, queryParameter4, i, iVar.getPageContext(), baijiahaoData);
                        } else {
                            r.a(queryParameter2, queryParameter, queryParameter4, i, MainTabActivity.this.getPageContext(), baijiahaoData);
                        }
                    } else if (baijiahaoData != null) {
                        if (StringUtils.isNull(queryParameter2)) {
                            queryParameter2 = "0";
                        }
                        if (iVar.getPageContext() != null) {
                            r.a(queryParameter2, queryParameter, queryParameter4, 0, iVar.getPageContext(), baijiahaoData);
                        } else {
                            r.a(queryParameter2, queryParameter, queryParameter4, 0, MainTabActivity.this.getPageContext(), baijiahaoData);
                        }
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
        }
    };
    private final CustomMessageListener nDI = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_INFO_CHANGED) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getData() instanceof PayMemberInfoData) {
                    MainTabActivity.this.a((PayMemberInfoData) customResponsedMessage.getData());
                    TbadkCoreApplication.getInst().setPaymemberInfo((PayMemberInfoData) customResponsedMessage.getData());
                }
                UserData bCK = com.baidu.tbadk.getUserInfo.b.bCI().bCK();
                if (TbadkCoreApplication.isLogin() && bCK != null && bCK.getUserId() != null && !bCK.getUserId().equals(MainTabActivity.this.nDt) && bCK.getIsGodInvited()) {
                    MainTabActivity.this.nDt = bCK.getUserId();
                    MainTabActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(MainTabActivity.this.getPageContext().getPageActivity(), "", TbWebViewActivityConfig.GOD_INVITE_JUMP_URL + "?page_type=open_full_screen_opacity_web_page", true)));
                }
                if (!com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("key_new_god_invited_my_tab_red_tip_showed", false) && TbadkCoreApplication.isLogin() && bCK != null && bCK.getUserId() != null && !bCK.getUserId().equals(MainTabActivity.this.nDt) && bCK.getNewGodData() != null && bCK.getNewGodData().isNewGodInvited()) {
                    com.baidu.tieba.p.a.dFe().h(11, true, true);
                    TiebaStatic.log(new ar("c13688").v("uid", TbadkCoreApplication.getCurrentAccountId()).ap("obj_locate", 0));
                    com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("key_new_god_invited_my_tab_red_tip_showed", true);
                }
            }
        }
    };
    private CustomMessageListener jhT = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && !((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                MainTabActivity.this.nDn.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    final CustomMessageListener nDJ = new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.tbadk.mainTab.b> list;
            MainTabActivity.this.mIsAdd = false;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (list = ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).getList()) != null && list.size() != 0) {
                MainTabActivity.this.nDn.aR(list);
                if (MainTabActivity.this.nDj) {
                    MainTabActivity.this.nDn.cEC().setCurrentTabByType(MainTabActivity.this.nDi);
                } else if (MainTabActivity.this.getActivity().getIntent() == null || MainTabActivity.this.getActivity().getIntent().getDataString() == null || !MainTabActivity.this.getActivity().getIntent().getDataString().startsWith("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                    MainTabActivity.this.ai(MainTabActivity.this.getIntent());
                } else {
                    MainTabActivity.this.nDn.cEC().setCurrentTabByType(2);
                }
                MainTabActivity.this.nDj = false;
                MainTabActivity.this.nDn.dQs();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP, null));
            }
        }
    };
    final CustomMessageListener nDK = new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_REFRESH_TABS) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007013) {
                MainTabActivity.this.dhr();
                if (MainTabActivity.this.nDn != null && MainTabActivity.this.nDn.cEC() != null) {
                    MainTabActivity.this.nDi = MainTabActivity.this.nDn.cEC().getCurrentTabType();
                }
                MainTabActivity.this.nDj = true;
            }
        }
    };
    final CustomMessageListener nDL = new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (MainTabActivity.this.nDk != null || (customResponsedMessage.getData() instanceof bl)) {
                    if (customResponsedMessage.getData() != null) {
                        MainTabActivity.this.nDk = (bl) customResponsedMessage.getData();
                    }
                    if (!MainTabActivity.this.mIsAdd && MainTabActivity.this.nDk != null && TbadkCoreApplication.isLogin()) {
                        MainTabActivity.this.nDu.m(MainTabActivity.this.nDk.recom_title, MainTabActivity.this.nDk.recom_topic, MainTabActivity.this.nDk.ePh);
                    }
                }
            }
        }
    };
    private final CustomMessageListener nDM = new CustomMessageListener(CmdConfigCustom.MAINTAB_SET_INST) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.e.b.brG() == null) {
                b bVar = new b();
                bVar.a(MainTabActivity.this);
                com.baidu.tbadk.core.e.b.a(bVar);
            }
        }
    };
    private CustomMessageListener nDN = new CustomMessageListener(2921380) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && !au.isEmpty((String) customResponsedMessage.getData())) {
                String str = (String) customResponsedMessage.getData();
                if (KuangFloatingViewController.getInstance().init()) {
                    KuangFloatingViewController.getInstance().setInfo(str);
                    ((BaseFragmentActivity) MainTabActivity.this.getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.8.1
                        @Override // com.baidu.tbadk.core.e
                        public void onPermissionResult(boolean z) {
                            if (z) {
                                KuangFloatingViewController.getInstance().showFloatingView();
                                TiebaStatic.log(new ar("c12264").ap("obj_type", 3));
                            }
                        }
                    }, false);
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a nfi = new com.baidu.adp.framework.listener.a(1002700, CmdConfigSocket.CMD_PROFILE) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.13
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if ((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) {
                if (responsedMessage.getOrginalMessage() == null || MainTabActivity.this.getUniqueId() != null) {
                }
                if (responsedMessage instanceof ProfileSocketResponseMessage) {
                    MainTabActivity.this.a((ProfileSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof ProfileHttpResponseMessage) {
                    MainTabActivity.this.a((ProfileHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private CustomMessageListener nDO = new CustomMessageListener(2921504) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            MainTabActivity.this.dQa();
        }
    };
    private BroadcastReceiver nDP = new BroadcastReceiver() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.15
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Bundle bundleExtra;
            if (intent != null && (bundleExtra = intent.getBundleExtra(AlaLiveRoomActivityConfig.JUMP_ALA_LIVE_ROOM_DATA)) != null && TbadkCoreApplication.getInst().isMainProcess(false)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, (AlaLiveInfoCoreData) bundleExtra.getSerializable(AlaLiveRoomActivityConfig.JUMP_ALA_LIVE_ROOM_DATA_CORE), bundleExtra.getString(AlaLiveRoomActivityConfig.JUMP_ALA_LIVE_ROOM_DATA_FROM), null, bundleExtra.getBoolean(AlaLiveRoomActivityConfig.JUMP_ALA_LIVE_ROOM_DATA_HOST), "")));
            }
        }
    };
    private CustomMessageListener nDR = new CustomMessageListener(2921491) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && MainTabActivity.this.nDn != null && MainTabActivity.this.nDn.cEC() != null && MainTabActivity.this.nDn.cEC().getCurrentTabType() != 21) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    FragmentTabWidget fragmentTabWidget = MainTabActivity.this.nDn.cEC().getFragmentTabWidget();
                    if (fragmentTabWidget.getChildCount() >= 2) {
                        MainTabActivity.this.nDQ = new com.baidu.tieba.c.e(MainTabActivity.this.getPageContext(), fragmentTabWidget.getChildAt(2));
                        MainTabActivity.this.nDQ.en(R.drawable.bg_tip_blue_down);
                        MainTabActivity.this.nDQ.xh(2);
                        MainTabActivity.this.nDQ.em(32);
                        MainTabActivity.this.nDQ.setUseDirectOffset(true);
                        MainTabActivity.this.nDQ.setYOffset(-l.getDimens(MainTabActivity.this, R.dimen.tbds10));
                        MainTabActivity.this.nDQ.setTextColor(R.color.CAM_X0101);
                        MainTabActivity.this.nDQ.setHeight(R.dimen.tbds54);
                        MainTabActivity.this.nDQ.setMaxShowTime(999);
                        MainTabActivity.this.nDQ.eo(5000);
                        MainTabActivity.this.nDQ.xj(l.getDimens(MainTabActivity.this, R.dimen.tbds44));
                        MainTabActivity.this.nDQ.b(str, "categoryUpdate", false, true);
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a nDS = new CheckRealNameModel.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.17
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void b(int i, String str, String str2, Object obj) {
            if (CheckRealNameModel.TYPE_APP_FIRST_START.equals(str2) && i == 1990055) {
                TiebaStatic.log("c12138");
                MainTabActivity.this.nDn.Ua(MainTabActivity.this.getResources().getString(R.string.check_real_name_message));
            }
        }
    };
    private CustomMessageListener eGV = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && l.isNetOk()) {
                MainTabActivity.this.dQd();
                if (!MainTabActivity.syncHasFinish) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
                }
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                MainTabActivity.this.nDr = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
                com.baidu.tbadk.core.sharedPref.b.brQ().remove(SharedPrefConfig.KEY_FEEDBACK_TIP);
                com.baidu.tbadk.core.sharedPref.b.brQ().remove(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW);
                com.baidu.tbadk.core.sharedPref.b.brQ().remove(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP));
                if (MainTabActivity.this.nDv != null) {
                    MainTabActivity.this.nDv.ze(UtilHelper.getClipBoardContent());
                }
                if (MainTabActivity.this.nDn != null) {
                    MainTabActivity.this.nDn.dQx();
                }
                MainTabActivity.this.dQj();
            }
        }
    };
    private CustomMessageListener nDT = new CustomMessageListener(CmdConfigCustom.CMD_GAME_CENTER_INIT) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                q.eZH = ((Boolean) customResponsedMessage.getData()).booleanValue();
                MainTabActivity.this.dPZ();
            }
        }
    };
    private final CustomMessageListener nDU = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.GAME_TIP_SHOW, booleanValue);
                MainTabActivity.this.nDn.yL(booleanValue);
            }
        }
    };
    private CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                boolean unused = MainTabActivity.syncHasFinish = true;
                TbadkCoreApplication.getInst().syncHasFinish = true;
                if (MainTabActivity.this.nDn != null && MainTabActivity.this.nDn.dQt() != null && MainTabActivity.this.nDn.dQt().getAnimationView() != null && MainTabActivity.this.nDn.dQt().getAnimationView().getVisibility() != 0) {
                    MainTabActivity.this.nDn.dQt().setLottieView(false);
                }
                if (!TbadkCoreApplication.getInst().getActivityPrizeData().isSwitchTurn()) {
                    if (MainTabActivity.this.nDn != null) {
                        MainTabActivity.this.nDn.TZ(null);
                    }
                } else {
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getInst().getActivityPrizeData().isUserSatisfy()) {
                        String h5Url = TbadkCoreApplication.getInst().getActivityPrizeData().getH5Url();
                        if (!StringUtils.isNull(h5Url) && com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.ACTIVITY_PRIZE_GET_TIP + TbadkCoreApplication.getCurrentAccount(), true)) {
                            bf.bsV().a(MainTabActivity.this.getPageContext(), new String[]{h5Url}, true);
                            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.ACTIVITY_PRIZE_GET_TIP + TbadkCoreApplication.getCurrentAccount(), false);
                        }
                    }
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                        if (MainTabActivity.this.nDn != null) {
                            MainTabActivity.this.nDn.TZ(null);
                        }
                    } else {
                        String myTabText = TbadkCoreApplication.getInst().getActivityPrizeData().getMyTabText();
                        if (!StringUtils.isNull(myTabText)) {
                            if (MainTabActivity.this.nDn != null) {
                                MainTabActivity.this.nDn.TZ(myTabText);
                            }
                        } else if (MainTabActivity.this.nDn != null) {
                            MainTabActivity.this.nDn.TZ(null);
                        }
                    }
                }
                if (TbSingleton.getInstance().canShowPermDialog()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921360, MainTabActivity.this));
                }
                com.baidu.tbadk.core.business.b.blh().dC("1", "");
            }
        }
    };
    private CustomMessageListener nDW = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    MainTabActivity.this.nDV = UtilHelper.getCurrentDay();
                    com.baidu.tbadk.core.sharedPref.b.brQ().putLong("last_resume_time", TbSingleton.getInstance().getLastResumeTime());
                    return;
                }
                String currentDay = UtilHelper.getCurrentDay();
                if (!StringUtils.isNull(currentDay) && !currentDay.equals(MainTabActivity.this.nDV)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
                }
                if (MainTabActivity.this.mNA == null) {
                    MainTabActivity.this.mNA = new com.baidu.tieba.ueg.b();
                }
                MainTabActivity.this.mNA.Kq(MainTabActivity.this.mNA.nJZ);
                MainTabActivity.this.mNA.nJZ = ay.a.fbr;
            }
        }
    };
    private final CustomMessageListener kVu = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            m mVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof m) && (mVar = (m) customResponsedMessage.getData()) != null && !StringUtils.isNull(mVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(mVar);
                if (StringUtils.isNull(mVar.fAm)) {
                    bf.bsV().b(MainTabActivity.this.getPageContext(), new String[]{mVar.mLink});
                } else {
                    bf.bsV().b(MainTabActivity.this.getPageContext(), new String[]{mVar.mLink, mVar.fAm});
                }
            }
        }
    };
    private CustomMessageListener jim = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (MainTabActivity.this.jkO != null) {
                MainTabActivity.this.jkO.bGP();
            }
        }
    };
    private Runnable nDX = new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.38
        @Override // java.lang.Runnable
        public void run() {
            if (TbSingleton.getInstance().getNewUserRedPackageData() != null) {
                TbSingleton.getInstance().setNewUserRedPackageShowed(true);
                MainTabActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewUserRedPackageActivityConfig(MainTabActivity.this, TbSingleton.getInstance().getNewUserRedPackageData())));
                TbSingleton.getInstance().setNewUserRedPackageData(null);
            }
        }
    };
    private CustomMessageListener nDY = new CustomMessageListener(2921532) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbSingleton.getInstance().isNewUserRedPackageShowed() && MainTabActivity.this.nDC) {
                com.baidu.adp.lib.f.e.mA().removeCallbacks(MainTabActivity.this.nDX);
                com.baidu.adp.lib.f.e.mA().postDelayed(MainTabActivity.this.nDX, 200L);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void dPV() {
        FragmentTabWidget fragmentTabWidget = this.nDn.cEC().getFragmentTabWidget();
        if (fragmentTabWidget.getChildCount() >= 2) {
            this.nDx = new com.baidu.tieba.c.e(getPageContext(), fragmentTabWidget.getChildAt(1));
            this.nDx.en(R.drawable.bg_tip_blue_down);
            this.nDx.xh(2);
            this.nDx.em(32);
            this.nDx.setUseDirectOffset(true);
            this.nDx.setYOffset(-l.getDimens(this, R.dimen.tbds10));
            this.nDx.setTextColor(R.color.CAM_X0101);
            this.nDx.setHeight(R.dimen.tbds54);
            this.nDx.setMaxShowTime(1);
            this.nDx.eo(4000);
            this.nDx.xj(l.getDimens(this, R.dimen.tbds44));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPW() {
        if (this.nDx != null && !this.nDx.isShowing()) {
            this.nDx.aJ(getString(R.string.enterforumtab_like_forum_tips), "first_like_forum_enterforumtab_tips" + TbadkCoreApplication.getCurrentAccount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPX() {
        if (this.nDx != null && this.nDx.isShowing()) {
            this.nDx.Tz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TY(String str) {
        if (str != null && TbadkCoreApplication.getInst().getConfigVersion() != null && dPY()) {
            this.nDp = System.currentTimeMillis();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    private boolean dPY() {
        if (-1 == this.nDp) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.nDp;
        return currentTimeMillis <= 0 || currentTimeMillis >= 300000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPZ() {
        if (SwitchManager.getInstance().findType(GameEnterSwitch.GAME_ENTER_KEY) == 1 && q.eZH) {
            this.nDn.yJ(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_CHECK_UPDATE));
            return;
        }
        this.nDn.yJ(false);
        this.nDn.yL(false);
        com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.GAME_TIP_SHOW, false);
    }

    public void a(PayMemberInfoData payMemberInfoData) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && payMemberInfoData != null) {
            if ((payMemberInfoData.bAz() == 1 || payMemberInfoData.bAz() == 2) && com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.SHOW_MEMBER_DEID_LINE, true)) {
                long blA = payMemberInfoData.blA() * 1000;
                if (blA < System.currentTimeMillis()) {
                    if (StringUtils.isNull(payMemberInfoData.bAA())) {
                        payMemberInfoData.CD(getPageContext().getString(R.string.member));
                    } else {
                        payMemberInfoData.CD(payMemberInfoData.bAA() + getPageContext().getString(R.string.member_already_Expire));
                    }
                    this.nDn.a(payMemberInfoData, 0);
                } else if (blA - System.currentTimeMillis() < Config.THREAD_IMAGE_SAVE_MAX_TIME) {
                    if (StringUtils.isNull(payMemberInfoData.bAA())) {
                        payMemberInfoData.CD(getPageContext().getString(R.string.member));
                    } else {
                        payMemberInfoData.CD(payMemberInfoData.bAA() + getPageContext().getString(R.string.member_will_Expire));
                    }
                    this.nDn.a(payMemberInfoData, 1);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.esb) {
            return false;
        }
        if (this.nDn.cEC() == null || this.nDn.cEC().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1 || !this.nDn.dhv()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public void cEA() {
        if (this.nDu != null) {
            this.nDu.cMd();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
        if (this.jkO == null) {
            this.jkO = new g(getPageContext(), this.hVb, "main_tab", 3);
            this.jkO.Vj("8");
        }
        if (!this.gEW.dRA() && this.nDn.cEC() != null && this.nDn.cEC().getFragmentTabWidget() != null) {
            this.jkO.a(false, (View) this.nDn.cEC().getTabWrapper(), this.nDn.cEC().getFragmentTabWidget().getWriteView());
        }
    }

    protected void dhr() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ADD_FRAGMENT, new com.baidu.tbadk.mainTab.d(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.baidu.tbadk.n.l.bEl().ez(System.currentTimeMillis());
        if (TbadkCoreApplication.getInst().getIsFirstUse()) {
            af.a(new ae<Object>() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.9
                @Override // com.baidu.tbadk.util.ae
                public Object doInBackground() {
                    TbadkCoreApplication.getInst().setUsed();
                    return null;
                }
            }, null);
        }
        com.baidu.tbadk.core.util.ae.bsy();
        setIsAddSwipeBackLayout(false);
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.getDecorView();
        super.onCreate(bundle);
        int i = -1;
        com.baidu.tbadk.core.e.b.eYr = com.baidu.tbadk.core.e.b.eYs;
        if (getIntent() != null) {
            this.nDB = new e(getPageContext());
            if (!this.nDB.ak(getIntent())) {
                aa(getIntent());
            }
            i = getIntent().getIntExtra("locate_type", 0);
            if (i == 200) {
                finish();
                return;
            }
            this.mFrom = getIntent().getStringExtra("from");
        }
        int i2 = i;
        b bVar = new b();
        com.baidu.tbadk.core.e.b.a(bVar);
        bVar.a(this);
        if (dQe()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        setContentView(R.layout.maintabs_activity);
        this.hVb = (FrameLayout) findViewById(R.id.maintabContainer);
        if (com.baidu.tbadk.core.a.a.bkU() != null) {
            com.baidu.tbadk.core.a.a.bkU().reLoginByCacheAccount();
        }
        this.nDn = new d(this);
        this.nDu = new c(this);
        this.nDn.yI(this.mIsLogin);
        dPZ();
        cUB();
        com.baidu.tieba.tblauncher.alarmRemind.b.dQA().f(this);
        com.baidu.tbadk.BdToken.c.bhn().bhp();
        this.nDs = new com.baidu.tieba.b();
        dhr();
        dhI();
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (bundle != null) {
            i2 = bundle.getInt("locate_type", 1);
            intent.putExtra("locate_type", i2);
        }
        this.nDV = UtilHelper.getCurrentDay();
        this.nDp = System.currentTimeMillis();
        MessageManager.getInstance().sendMessage(new CustomMessage(2921359));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        if (TbadkCoreApplication.getFrom() != null && TbadkCoreApplication.getFrom().equals("aishide")) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_ACTIVE, null));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_CLEARTEMP, null));
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_VIDEO_CACHE_CLEAN);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VIDEO_CACHE_CLEAN));
        i(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        com.baidu.tbadk.browser.a.initCookie(getPageContext().getPageActivity());
        String installOtherApp = TbadkCoreApplication.getInst().getInstallOtherApp();
        if (installOtherApp != null && installOtherApp.length() > 0) {
            UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), installOtherApp);
            TbadkCoreApplication.getInst().setInstallOtherApp(null);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.10
            @Override // java.lang.Runnable
            public void run() {
                MainTabActivity.this.esb = true;
            }
        });
        TbadkCoreApplication.getInst().startTrackConfigRequest();
        if (com.baidu.tbadk.core.util.ae.checkLocationForGoogle(getActivity())) {
            MercatorModel.dOK().startLoad();
        }
        registerListener(this.kIz);
        if (i2 == 1) {
            this.nDn.yK(true);
        } else {
            this.nDn.yK(false);
        }
        this.nDn.dQv();
        this.jgu = getVoiceManager();
        if (this.jgu != null) {
            this.jgu.onCreate(getPageContext());
        }
        registerListener(this.mAccountChangedListener);
        adjustResizeBottomVirtualBar();
        adjustResizeForSoftInput();
        addGlobalLayoutListener();
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.MAINTAB_ONCREATE_END);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ONCREATE_END));
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.n.l.bEl().bEm();
        }
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.getUserInfo.b.bCI().bCJ();
        }
        com.baidu.tbadk.core.sharedPref.b.brQ().putInt(SharedPrefConfig.APP_RESTART_TIMES, com.baidu.tbadk.core.sharedPref.b.brQ().getInt(SharedPrefConfig.APP_RESTART_TIMES, 0) + 1);
        this.lVX = new CheckRealNameModel(getPageContext());
        this.lVX.a(this.nDS);
        dQd();
        this.jhj = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "homepage");
        this.jCx = new ShareSuccessReplyToServerModel();
        this.gEW = new com.baidu.tieba.ueg.d(getPageContext());
        this.nDv = com.baidu.tbadk.BdToken.d.bhD();
        int loadInt = TbadkSettings.getInst().loadInt(SharedPrefConfig.PREFS_SKIN_TYPE, 0);
        if (loadInt != 1) {
            ap.B(false, true);
        } else {
            TbadkCoreApplication.getInst().setSkinTypeValue(loadInt);
            TbadkCoreApplication.getInst().SendSkinTypeBroadcast(loadInt);
        }
        if (TbSingleton.getInstance().isEnableBenchmark() && TbSingleton.getInstance().getCpuFlopsDuration() <= 0) {
            com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.11
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.tbadk.f.a.bko();
                }
            }, 5000L);
        }
        MessageManager.getInstance().registerListener(this.kVu);
        TbSingleton.getInstance().startOneGame();
        this.mWeakContext = new WeakReference<>(TbadkCoreApplication.getInst());
        if (getResources() != null && getResources().getConfiguration() != null) {
            this.nDA = getResources().getConfiguration().uiMode & 48;
        }
        com.baidu.n.c.hp(TbadkCoreApplication.getInst()).a(null);
        dQj();
        if (this.nDB.ak(intent)) {
            this.nDB.a(getIntent(), this.nDn);
        }
        dQa();
        TbSingleton.getInstance().getChannelConfigModel().startLoad();
        TbSingleton.getInstance().setActiveTimeStamp();
        com.baidu.tbadk.n.l.bEl().eA(System.currentTimeMillis());
    }

    public void dQa() {
        if (j.isNetworkAvailableForImmediately() && TbadkCoreApplication.getCurrentAccount() != null) {
            ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
            profileRequestMessage.set_uid(Long.valueOf(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)));
            profileRequestMessage.set_need_post_count(1);
            profileRequestMessage.set_pn(1);
            profileRequestMessage.set_rn(1);
            profileRequestMessage.set_has_plist(1);
            profileRequestMessage.set_from_db(false);
            profileRequestMessage.set_error_hint(true);
            profileRequestMessage.setSelf(true);
            profileRequestMessage.setTag(getUniqueId());
            profileRequestMessage.setIs_from_usercenter(1);
            profileRequestMessage.setPage(1);
            sendMessage(profileRequestMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ProfileHttpResponseMessage profileHttpResponseMessage) {
        if (profileHttpResponseMessage != null && profileHttpResponseMessage.GetUser() != null) {
            this.nDy = profileHttpResponseMessage.GetUser().my_like_num.intValue();
            if (this.nDy == 1) {
                dPV();
                dPW();
            }
            dQb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ProfileSocketResponseMessage profileSocketResponseMessage) {
        if (profileSocketResponseMessage != null && profileSocketResponseMessage.GetUser() != null) {
            this.nDy = profileSocketResponseMessage.GetUser().my_like_num.intValue();
            if (this.nDy == 1) {
                dPV();
                dQb();
            }
        }
    }

    private void dQb() {
        if (this.nDy == 1) {
            dPV();
            if (TbadkCoreApplication.getInst().getCurrentActivity() == this && this.nDz.intValue() != 1) {
                dPW();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public ViewGroup getActivityRootView() {
        return this.hVb;
    }

    public void dQc() {
        if (this.nDQ != null && this.nDQ.isShowing()) {
            this.nDQ.Tz();
            this.nDQ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQd() {
        String str = SharedPrefConfig.CHECK_REAL_NAME + TbConfig.getVersion();
        if (com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(str, true) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && l.isNetOk()) {
            this.lVX.Ov(CheckRealNameModel.TYPE_APP_FIRST_START);
            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(str, false);
        }
    }

    private void aa(final Intent intent) {
        if (intent != null) {
            String dataString = intent.getDataString();
            UtilHelper.clearClipBoardBySchemaParam(dataString);
            if (!StringUtils.isNull(dataString) && dataString.startsWith("tbmaintab://")) {
                String decode = Uri.decode(intent.getData().getEncodedPath());
                if (StringUtils.isNull(decode)) {
                    TiebaStatic.log(new ar("c10320").ap("obj_type", 1).ap(TiebaInitialize.Params.OBJ_TO, 1).ap("obj_name", TbadkCoreApplication.getInst().getStartType()).ap(TiebaInitialize.Params.OBJ_PARAM3, 1));
                    return;
                }
                if (decode.startsWith("//")) {
                    decode = decode.substring(2);
                }
                Map<String, String> paramPair = bf.getParamPair(decode);
                if (paramPair != null) {
                    String str = paramPair.get("fr");
                    if (!"mpush".equals(str) && "bpush".equals(str)) {
                        ar arVar = new ar("c10320");
                        arVar.dR("obj_locate", paramPair.get("obj_locate"));
                        arVar.ap("obj_type", 1);
                        arVar.dR("obj_source", paramPair.get("obj_source"));
                        arVar.dR(TiebaInitialize.Params.OBJ_PARAM2, paramPair.get(TiebaInitialize.Params.OBJ_PARAM2));
                        arVar.ap(TiebaInitialize.Params.OBJ_TO, 1);
                        arVar.dR("obj_id", paramPair.get("bdid"));
                        arVar.ap("obj_name", TbadkCoreApplication.getInst().getStartType());
                        arVar.ap(TiebaInitialize.Params.OBJ_PARAM3, 1);
                        if (!au.isEmpty(paramPair.get(LogConfig.LOG_EXT_LOG))) {
                            try {
                                JSONObject jSONObject = new JSONObject(paramPair.get(LogConfig.LOG_EXT_LOG));
                                Iterator<String> keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    arVar.dR(next, jSONObject.getString(next));
                                }
                            } catch (Exception e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        TiebaStatic.log(arVar);
                        HttpMessage httpMessage = new HttpMessage(1003393);
                        httpMessage.addParam("call_url", dataString);
                        MessageManager.getInstance().sendMessage(httpMessage);
                    }
                    com.baidu.tbadk.BdToken.c.bhn().setSchemaUp(true);
                } else {
                    return;
                }
            } else if (!StringUtils.isNull(dataString) && (dataString.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT) || dataString.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT_ZM) || dataString.startsWith("bdtiebalive://") || dataString.startsWith("tiebachushou://"))) {
                String dataString2 = intent.getDataString();
                if (!StringUtils.isNull(dataString2)) {
                    bf.bsV().b(getPageContext(), new String[]{dataString2});
                    com.baidu.tbadk.BdToken.c.bhn().setSchemaUp(true);
                }
            } else if (!StringUtils.isNULL(dataString) && dataString.startsWith(f.eDv)) {
                f.bhH().a(intent.getData(), new f.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.19
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void onCallBack(HashMap<String, Object> hashMap) {
                        if (hashMap != null && intent != null) {
                            Object obj = hashMap.get(f.eDW);
                            int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : -1;
                            Object obj2 = hashMap.get(f.eDX);
                            String str2 = obj2 instanceof String ? (String) obj2 : null;
                            Object obj3 = hashMap.get(f.eDV);
                            String str3 = obj3 instanceof String ? (String) obj3 : null;
                            if (intValue != -1) {
                                intent.putExtra("is_from_scheme", true);
                                intent.putExtra("locate_type", intValue);
                                intent.putExtra("sub_locate_type", str2);
                                intent.putExtra("sub_tab_name", str3);
                                com.baidu.tbadk.core.e.b.eYq = intValue;
                                Object obj4 = hashMap.get(f.eDY);
                                String str4 = obj4 instanceof String ? (String) obj4 : null;
                                Object obj5 = hashMap.get(f.eDZ);
                                String str5 = obj5 instanceof String ? (String) obj5 : null;
                                intent.putExtra(f.eDY, str4);
                                intent.putExtra(f.eDZ, str5);
                            }
                            com.baidu.tbadk.BdToken.c.bhn().setSchemaUp(true);
                            if (intValue == 1 && "ForumSquare".equals(str2)) {
                                com.baidu.tbadk.core.e.b.eYr = com.baidu.tbadk.core.e.b.eYt;
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921528));
                            }
                        }
                    }
                });
            }
            final String stringExtra = intent.getStringExtra(MainTabActivityConfig.TARGET_SCHEME);
            if (!StringUtils.isNull(stringExtra)) {
                com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.20
                    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        bf.bsV().b(MainTabActivity.this.getPageContext(), new String[]{stringExtra});
                    }
                });
                getIntent().removeExtra(MainTabActivityConfig.TARGET_SCHEME);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.jgu = getVoiceManager();
        if (this.jgu != null) {
            this.jgu.onStart(getPageContext());
        }
    }

    public boolean dQe() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_SYNC, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_ACTIVE, null));
        cUC();
        com.baidu.tbadk.coreExtra.messageCenter.b.bxB().bxM();
        com.baidu.tbadk.coreExtra.messageCenter.b.bxB().bxH();
        com.baidu.tbadk.coreExtra.messageCenter.b.bxB().kj(false);
        MessageManager.getInstance().unRegisterListener(this.kVu);
        MessageManager.getInstance().unRegisterListener(this.nDN);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setDialogVisiable(false);
            this.mWaitingDialog = null;
        }
        dQf();
        if (this.nDn != null) {
            this.nDn.onDestroy();
        }
        if (this.nDu != null) {
            this.nDu.onDestroy();
        }
        try {
            super.onDestroy();
        } catch (Exception e) {
        }
        com.baidu.tbadk.core.e.b.a(null);
        com.baidu.tbadk.k.d.bCB().onDestory();
        this.jgu = getVoiceManager();
        if (this.jgu != null) {
            this.jgu.onDestory(getPageContext());
        }
        if (this.jkO != null) {
            this.jkO.onDestroy();
        }
        if (this.jhj != null) {
            this.jhj.onDestroy();
        }
        if (this.jCx != null) {
            this.jCx.cancelLoadData();
        }
        if (this.mNA != null) {
            this.mNA.onDestroy();
        }
        if (this.nDn != null && this.nDn.dQt() != null) {
            this.nDn.dQt().onDestory();
        }
        com.baidu.tieba.lc.c.dbh().onDestroy();
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.nDX);
        System.gc();
    }

    private void dQf() {
        InputMethodManager inputMethodManager;
        View currentFocus = getCurrentFocus();
        if (currentFocus != null && currentFocus.getWindowToken() != null && (inputMethodManager = (InputMethodManager) getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
            Method method = null;
            try {
                method = InputMethodManager.class.getDeclaredMethod("windowDismissed", IBinder.class);
            } catch (NoSuchMethodException e) {
            } catch (SecurityException e2) {
            }
            if (method != null && currentFocus != null) {
                method.setAccessible(true);
                try {
                    method.invoke(inputMethodManager, currentFocus.getWindowToken());
                } catch (IllegalAccessException e3) {
                } catch (IllegalArgumentException e4) {
                } catch (InvocationTargetException e5) {
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        try {
            super.onRestoreInstanceState(bundle);
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    private void i(Context context, Intent intent) {
        UtilHelper.commenDealIntent(context, intent);
        TbadkCoreApplication.setIntent(null);
    }

    private void cUB() {
        registerListener(this.nDE);
        this.nDJ.setPriority(100);
        registerListener(this.nDJ);
        registerListener(this.nDK);
        registerListener(this.nDL);
        registerListener(this.nDM);
        registerListener(this.nDT);
        registerListener(this.nDU);
        registerListener(this.nDI);
        registerListener(this.skinTypeChangeListener);
        registerListener(this.nDF);
        this.nDo = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.nDo, intentFilter);
        registerListener(this.jhT);
        registerListener(this.nDH);
        registerListener(this.mSyncFinishListener);
        registerListener(this.eGV);
        registerListener(this.nDW);
        this.nDD.setTag(getUniqueId());
        registerListener(this.nDD);
        registerListener(this.nDN);
        registerListener(this.jim);
        registerListener(this.nDG);
        registerListener(this.mLikeForumListener);
        registerListener(this.iJy);
        registerListener(this.nfi);
        registerListener(this.nDR);
        registerListener(this.nDO);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction(AlaLiveRoomActivityConfig.JUMP_ALA_LIVE_ROOM_BROADCAST);
        registerReceiver(this.nDP, intentFilter2);
        registerListener(this.nDY);
    }

    private void cUC() {
        if (this.nDo != null) {
            unregisterReceiver(this.nDo);
        }
        if (this.nDP != null) {
            unregisterReceiver(this.nDP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(TbConfig.getBroadcastActionNewVersion())) {
                TbadkCoreApplication.checkNeedShowNewVersion();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.nDC = true;
        if (this.jfw) {
            ak.b(this.mWeakContext);
            this.jfw = false;
        }
        if (this.nDn != null && this.nDn.dQt() != null) {
            this.nDn.dQt().setLottieView(true);
        }
        if (this.nDn != null && this.nDn.cEC() != null) {
            this.nDi = this.nDn.cEC().getCurrentTabType();
        }
        changeSkinType(this.mSkinType);
        com.baidu.tbadk.k.d.bCB().ld(true);
        if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.n.l.bEl().bEj()) {
            com.baidu.tbadk.n.l.bEl().bEm();
        }
        this.jgu = getVoiceManager();
        if (this.jgu != null) {
            this.jgu.onResume(getPageContext());
        }
        if (this.nDn != null) {
            this.nDn.dQv();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_ON_RESUME, getActivity()));
        if (TbadkCoreApplication.getKeepLiveSwitch(getApplicationContext())) {
            com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.21
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_KEEPLIVE_START_SERVICE, Boolean.FALSE));
                }
            }, IMConnection.RETRY_DELAY_TIMES);
        }
        com.baidu.tbadk.n.l.bEl().bEm();
        if (com.baidu.tbadk.BdToken.q.bhU().bhX() != null && com.baidu.tbadk.BdToken.q.bhU().bid() != null && com.baidu.tbadk.BdToken.q.bhU().bhX().getCurTaskType() == 6) {
            com.baidu.tbadk.BdToken.q.bhU().bid().complete();
        }
        dPW();
        if (this.nDz.intValue() != 1) {
            dPW();
        }
        if (!TbSingleton.getInstance().isNewUserRedPackageShowed()) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.nDX);
            com.baidu.adp.lib.f.e.mA().postDelayed(this.nDX, 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.nDr = true;
        if (z) {
            com.baidu.tbadk.getUserInfo.b.bCI().bCJ();
            dPZ();
            dQd();
            dQa();
        }
        this.nDn.switchNaviBarStatus(z);
        this.nDn.dQx();
        dhr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.nDC = false;
        LogoActivityConfig.isFirst = false;
        if (this.nDh) {
            this.nDh = false;
            CompatibleUtile.setAnim(getPageContext().getPageActivity(), R.anim.down, R.anim.hold);
        }
        this.jgu = getVoiceManager();
        if (this.jgu != null) {
            this.jgu.onPause(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOME_HIDE_GUIDE));
        if (this.nDu != null) {
            this.nDu.cMe();
        }
        KuangFloatingViewController.getInstance().hideFloatingView();
        com.baidu.tbadk.k.d.bCB().ld(true);
        dPX();
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.nDX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
        } catch (Exception e) {
        }
        bundle.putInt("locate_type", this.nDn.cEC().getCurrentTabType());
        bundle.putParcelable("android:fragments", null);
        bundle.putParcelable("android:support:fragments", null);
        this.jgu = getVoiceManager();
        if (this.jgu != null) {
            this.jgu.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.jgu = getVoiceManager();
        if (this.jgu != null) {
            this.jgu.onStop(getPageContext());
        }
        this.jfw = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        FragmentTabHost.b ou;
        int i = 2;
        super.onNewIntent(intent);
        setIntent(intent);
        String stringExtra = intent.getStringExtra(MainTabActivityConfig.TARGET_SCHEME);
        if (this.nDB.ak(intent)) {
            this.nDB.a(intent, this.nDn);
        } else {
            aa(intent);
        }
        if (StringUtils.isNull(stringExtra)) {
            com.baidu.tbadk.getUserInfo.b.bCI().bCJ();
            if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_RESET_TABS));
                dhr();
            }
            this.mFrom = intent.getStringExtra("from");
            int intExtra = intent.getIntExtra("locate_type", 1);
            boolean booleanExtra = intent.getBooleanExtra("is_from_scheme", false);
            if (intExtra == 200) {
                finish();
            } else if (intExtra == 11) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), true)));
                finish();
            } else if (intExtra == 12) {
                TbadkCoreApplication.getInst().notifyAppEnterBackground();
                finish();
            } else if (intExtra == 1 || intExtra == 20 || intExtra == 3 || intExtra == 2 || intExtra == 4 || intExtra == 8 || intExtra == 15) {
                if (intExtra != 8 && intExtra != 3 && intExtra != 15 && !booleanExtra) {
                    if (getActivity().getIntent() == null || getActivity().getIntent().getDataString() == null || !getActivity().getIntent().getDataString().startsWith("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                        if (intExtra != 2 && intExtra != 1 && intExtra != 20) {
                            i = this.nDs.bJp();
                        }
                    }
                    if (this.nDn != null || this.nDn.cEC() == null) {
                        intExtra = i;
                    } else {
                        this.nDn.setCurrentTabByType(i);
                        intExtra = i;
                    }
                }
                i = intExtra;
                if (this.nDn != null) {
                }
                intExtra = i;
            } else if ((intExtra == 17 || intExtra == 18 || intExtra == 19) && this.nDn != null && this.nDn.cEC() != null) {
                this.nDn.cEC().setCurrentTab(0);
            }
            if (this.nDn != null && this.nDn.cEC() != null && (ou = this.nDn.cEC().ou(intExtra)) != null && (ou.mContentFragment instanceof com.baidu.tbadk.core.g)) {
                ((com.baidu.tbadk.core.g) ou.mContentFragment).C(intent);
            }
            i(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
            if (this.nDn != null) {
                this.nDn.dQv();
            }
        }
    }

    protected void aw(Activity activity) {
        new com.baidu.tbadk.core.dialog.a(activity).nw(R.string.confirm_title).jF(false).nx(R.string.background_process_permission).a(R.string.now_goto_setting, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                try {
                    MainTabActivity.this.startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
                    aVar.dismiss();
                } catch (Exception e) {
                    MainTabActivity.this.showToast(R.string.goto_developActivity_error_toast);
                }
            }
        }).b(R.string.next_time, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.22
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                MainTabActivity.this.dQg();
            }
        }).b(com.baidu.adp.base.j.K(activity)).bqx();
    }

    protected void dQg() {
        com.baidu.adp.lib.e.d.mw().d(getUniqueId());
        dQi();
        try {
            moveTaskToBack(true);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, com.baidu.adp.base.i
    public void onPreLoad(com.baidu.adp.widget.ListView.q qVar) {
        super.onPreLoad(qVar);
        ag.a(qVar, getUniqueId());
        com.baidu.tbadk.core.util.g.c.a(qVar, getUniqueId(), this);
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!MainTabActivityConfig.IS_BACK_CLOSE_ALL_ACTIVITY && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
            if (runTask == null || !((Boolean) runTask.getData()).booleanValue()) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2016323, (Class) null);
                if (runTask2 == null || !((Boolean) runTask2.getData()).booleanValue()) {
                    if (this.jkO != null && this.jkO.isShowing()) {
                        this.jkO.zw(true);
                        return true;
                    } else if (this.nDn.dhv()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
                        return true;
                    } else {
                        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(2921405, Boolean.class, false);
                        if (runTask3 == null || runTask3.getData() == null || !(runTask3.getData() instanceof Boolean) || !((Boolean) runTask3.getData()).booleanValue()) {
                            if (System.currentTimeMillis() - this.nDl > 2000) {
                                showToast(R.string.double_back_quit);
                                this.nDl = System.currentTimeMillis();
                            } else if (UtilHelper.isBackgroundProcessLimitNone() && Build.VERSION.SDK_INT >= 14) {
                                aw(getPageContext().getPageActivity());
                                return true;
                            } else {
                                dQg();
                            }
                            return false;
                        }
                        return true;
                    }
                }
                return true;
            }
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(Intent intent) {
        int bJp;
        if (intent != null && this.nDn != null && this.nDn.cEC() != null) {
            try {
                if (intent.hasExtra("locate_type")) {
                    bJp = intent.getIntExtra("locate_type", 1);
                } else {
                    bJp = this.nDs.bJp();
                }
                this.nDn.cEC().setCurrentTabByType(bJp);
            } catch (Throwable th) {
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        try {
            if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921381, keyEvent));
            }
            return super.onKeyDown(i, keyEvent);
        } catch (IllegalStateException e) {
            if (i == 4) {
                finish();
            }
            return true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        try {
            return super.onKeyUp(i, keyEvent);
        } catch (IllegalStateException e) {
            if (i == 4) {
                finish();
            }
            return true;
        }
    }

    private void dhI() {
        registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Integer) {
                    Integer num = (Integer) customResponsedMessage.getData();
                    if (num.intValue() == 2) {
                        MainTabActivity.this.nDn.yK(true);
                        MainTabActivity.this.nDn.uc(true);
                    } else if (num.intValue() == 1) {
                        MainTabActivity.this.nDn.yK(true);
                        MainTabActivity.this.nDn.uc(false);
                    } else {
                        MainTabActivity.this.nDn.yK(false);
                        MainTabActivity.this.nDn.uc(false);
                    }
                    MainTabActivity.this.nDn.dQv();
                }
            }
        });
    }

    protected void dQh() {
        AntiData antiData = new AntiData();
        antiData.setIfpost(1);
        if (antiData.getIfpost() == 0) {
            l.showToast(getPageContext().getPageActivity(), antiData.getForbid_info());
        } else if (!WriteActivityConfig.isAsyncWriting()) {
            antiData.setIfVoice(false);
            WriteActivityConfig.newInstance(this).setType(0).setFrom(this.mFrom).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setFeedBack(true).setAntiData(antiData).send();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 != -1) {
            if (this.nDn.cEC().getCurrentFragment() != null) {
                this.nDn.cEC().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 25046) {
            if (TbadkCoreApplication.isLogin()) {
                com.baidu.tbadk.BdToken.q.bhU().c(getPageContext());
            }
        } else if (i == 11001) {
            dQh();
        } else if (i == 13003 || i == 25048) {
            aj(intent);
        } else if (i == 23007) {
            T(intent);
        } else if (i == 13011) {
            com.baidu.tieba.o.a.dCY().I(getPageContext());
        } else if (i == 24007) {
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1) {
                com.baidu.tieba.o.a.dCY().I(getPageContext());
                ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                ar arVar = new ar(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                arVar.ap("obj_locate", 5);
                if (shareItem != null) {
                    arVar.dR("tid", shareItem.tid);
                }
                arVar.dR("pid", intent.getStringExtra("pid"));
                TiebaStatic.log(arVar);
                if (shareItem != null && shareItem.linkUrl != null && this.jCx != null) {
                    this.jCx.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.26
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void byF() {
                        }

                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void a(final CustomDialogData customDialogData) {
                            com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.26.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a(MainTabActivity.this.getPageContext(), customDialogData).show();
                                }
                            }, 1000L);
                        }
                    });
                }
            }
        } else if (this.nDn.cEC().getCurrentFragment() != null) {
            this.nDn.cEC().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    private ShareFromPBMsgData cJy() {
        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.imageUri == null ? "https://tieba-fe.gz.bcebos.com/yunying/tieba_logo.jpg" : shareItem.imageUri.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.fuV);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.fName);
        shareFromPBMsgData.setThreadId(shareItem.tid);
        return shareFromPBMsgData;
    }

    private void T(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(cJy(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.nA(1);
            aVar.bn(thread2GroupShareView);
            aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.27
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MainTabActivity.this.HidenSoftKeyPad((InputMethodManager) MainTabActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(MainTabActivity.this.getPageContext().getPageActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.bzc() != null) {
                        Bundle bzc = shareItem.bzc();
                        TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ap("obj_source", 1).ap("obj_type", bzc.getInt("obj_type")).ap("obj_param1", 3).dR("fid", bzc.getString("fid")).dR("tid", bzc.getString("tid")).ap("obj_locate", 5));
                    }
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.28
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MainTabActivity.this.HidenSoftKeyPad((InputMethodManager) MainTabActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.jG(true);
            aVar.b(getPageContext()).bqx();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.aP(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        TbSingleton.getInstance().clearVideoRecord();
        TbSingleton.getInstance().setHasAgreeToPlay(false);
        super.finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.nDn.onChangeSkinType(i);
        adjustResizeForSoftInputOnSkinTypeChanged(i);
        if (this.jkO != null) {
            this.jkO.onChangeSkinType(i);
        }
    }

    private void aj(Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        if (intent != null) {
            try {
                postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
            } catch (Exception e) {
                BdLog.e(e);
                postWriteCallBackData = null;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PERSONALIZED_MAINTAB_ON_RESULT, postWriteCallBackData));
            if (this.nDn != null && !this.nDn.d(postWriteCallBackData)) {
                this.nDn.b(postWriteCallBackData);
            }
        }
    }

    private void dQi() {
        if (System.currentTimeMillis() - this.nDm >= 7200000) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "start");
            hashMap.put(BdStatsConstant.StatsKey.UNAME, TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_CLEARTEMP, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
            this.nDm = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.a
    public int getCurrentTabType() {
        if (this.nDn.cEC() != null) {
            return this.nDn.cEC().getCurrentTabType();
        }
        return -1;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.jgu == null) {
            this.jgu = VoiceManager.instance();
        }
        return this.jgu;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.a
    public com.baidu.adp.lib.d.b<TbImageView> buM() {
        if (this.flN == null) {
            this.flN = UserIconBox.E(getPageContext().getPageActivity(), 8);
        }
        return this.flN;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cBM() {
        if (this.nDq == null) {
            this.nDq = FrsCommonImageLayout.Q(getPageContext().getPageActivity(), 12);
        }
        return this.nDq;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return new com.baidu.tbadk.m.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.29
            @Override // com.baidu.tbadk.m.b
            public boolean isCurrentPageCanBeAddToSourceTrace() {
                return true;
            }

            @Override // com.baidu.tbadk.m.b
            public int getMaxCost() {
                return com.baidu.tbadk.m.e.bDS().getMaxCostFromServer();
            }

            @Override // com.baidu.tbadk.m.b
            public boolean canStat(com.baidu.tbadk.m.d dVar) {
                return false;
            }
        };
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        List<String> currentPageSourceKeyList = super.getCurrentPageSourceKeyList();
        if (this.nDr && currentPageSourceKeyList != null) {
            currentPageSourceKeyList.clear();
            this.nDr = false;
            return null;
        }
        return currentPageSourceKeyList;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag;
        if (this.nDn != null && this.nDn.cEC() != null) {
            Fragment currentFragment = this.nDn.cEC().getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                tbPageTag = ((BaseFragment) currentFragment).getTbPageTag();
                if (tbPageTag != null) {
                    TbPageTag tbPageTag2 = super.getTbPageTag();
                    tbPageTag2.locatePage = "";
                    return tbPageTag2;
                }
                return tbPageTag;
            }
        }
        tbPageTag = null;
        if (tbPageTag != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.hPA = z;
        boolean z2 = this.nDw || this.hPA;
        if (this.nDn != null) {
            this.nDn.onKeyboardVisibilityChanged(z2);
        }
    }

    @Override // com.baidu.tbadk.core.util.g.b
    public boolean videoNeedPreload() {
        return ak.rG(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            super.onConfigurationChanged(configuration);
            if (TbadkCoreApplication.getInst().getSkinType() != 1) {
                ap.B(true, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQj() {
        String str = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_is_clear_concern_cache_when_version_update") + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + TbConfig.getVersion();
        if (!com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(str, false)) {
            try {
                com.baidu.tbadk.core.c.a.bqr().dE("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).setForever("0", null);
                com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(str, true);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onScreenShot(String str) {
        super.onScreenShot(str);
        if (this.nDn != null && this.nDn.cEC() != null && this.nDn.cEC().getCurrentTabType() == 2) {
            TiebaStatic.log(new ar("c13848").dR("uid", TbadkCoreApplication.getCurrentAccount()).ap("obj_type", 1));
        }
    }
}
