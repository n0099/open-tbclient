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
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ListView;
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
import com.baidu.adp.widget.ListView.t;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
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
import com.baidu.tbadk.KuangFloatingFrsCopyLinkViewController;
import com.baidu.tbadk.KuangFloatingViewController;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.message.ExitAppMessage;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.data.UserData;
import com.baidu.tbadk.data.h;
import com.baidu.tbadk.data.i;
import com.baidu.tbadk.data.k;
import com.baidu.tbadk.n.n;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.switchs.GameEnterSwitch;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ah;
import com.baidu.tbadk.util.q;
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
/* loaded from: classes16.dex */
public class MainTabActivity extends BaseFragmentActivity implements com.baidu.tbadk.core.util.f.b, UserIconBox.b, VoiceManager.c, FrsCommonImageLayout.c, com.baidu.tieba.tblauncher.a {
    private static boolean syncHasFinish;
    private WeakReference<Context> akU;
    private com.baidu.adp.lib.d.b<TbImageView> evp;
    private com.baidu.tieba.ueg.d fIl;
    VoiceManager hSO;
    private com.baidu.tieba.NEGFeedBack.a hTE;
    private g hXi;
    private ShareSuccessReplyToServerModel ilV;
    private com.baidu.tieba.c.e imf;
    private CheckRealNameModel kHF;
    private FrameLayout lsy;
    private com.baidu.tieba.ueg.b lyh;
    private boolean mTouchable;
    private bg mkB;
    private d mkE;
    private a mkF;
    private com.baidu.adp.lib.d.b<TbImageView> mkH;
    private com.baidu.tieba.b mkJ;
    private c mkL;
    private com.baidu.tbadk.BdToken.d mkM;
    private e mkP;
    private int mkV;
    private com.baidu.tieba.c.e mlc;
    private String mlh;
    private boolean mky = false;
    private int mkz = -1;
    private boolean mkA = false;
    private String mFrom = null;
    private volatile boolean mIsAdd = false;
    private long mkC = 0;
    private long mkD = 0;
    private long mkG = -1;
    private boolean mkI = false;
    private String mkK = "";
    boolean mkN = false;
    boolean gKh = false;
    boolean hRO = true;
    private int mkO = 16;
    private CustomMessageListener mkQ = new CustomMessageListener(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && MainTabActivity.this.mkE != null && TbadkCoreApplication.getInst().getCurrentActivity() == MainTabActivity.this) {
                MainTabActivity.this.mkN = com.baidu.adp.lib.f.b.toBoolean(customResponsedMessage.getData().toString(), false);
                MainTabActivity.this.mkE.onKeyboardVisibilityChanged((MainTabActivity.this.mkN || MainTabActivity.this.gKh) ? true : true);
            }
        }
    };
    private final CustomMessageListener mkR = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_MATINTAB) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.12
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
                        MainTabActivity.this.mkE.cnR().changeStyle(1);
                    } else if (TbadkCoreApplication.getInst().isThemeIconCover()) {
                        MainTabActivity.this.mkE.cnR().changeStyle(2);
                    } else {
                        MainTabActivity.this.mkE.cnR().changeStyle(1);
                    }
                }
            }
        }
    };
    public CustomMessageListener mkS = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && MainTabActivity.this.mkE != null && MainTabActivity.this.mkE.cnR() != null) {
                if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    MainTabActivity.this.mkE.cnR().getTabWrapper().animate().translationY(MainTabActivity.this.mkE.cnR().getTabWrapper().getHeight()).setDuration(200L).start();
                } else {
                    MainTabActivity.this.mkE.cnR().getTabWrapper().animate().translationY(0.0f).setDuration(400L).start();
                }
            }
        }
    };
    public CustomMessageListener mkT = new CustomMessageListener(2921452) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i) && com.baidu.tbadk.core.util.bg.checkUpIsLogin(MainTabActivity.this.getPageContext().getPageActivity())) {
                MainTabActivity.this.cnP();
            }
        }
    };
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData()).isSuccess && MainTabActivity.this.mkV == 1) {
                FragmentTabWidget fragmentTabWidget = MainTabActivity.this.mkE.cnR().getFragmentTabWidget();
                if (fragmentTabWidget.getChildCount() >= 2) {
                    MainTabActivity.this.imf = new com.baidu.tieba.c.e(MainTabActivity.this.getPageContext(), fragmentTabWidget.getChildAt(1));
                    MainTabActivity.this.imf.eL(R.drawable.bg_tip_blue_down);
                    MainTabActivity.this.imf.setAnchor(2);
                    MainTabActivity.this.imf.eK(32);
                    MainTabActivity.this.imf.setUseDirectOffset(true);
                    MainTabActivity.this.imf.setYOffset(-l.getDimens(MainTabActivity.this, R.dimen.tbds10));
                    MainTabActivity.this.imf.setTextColor(R.color.cp_cont_a);
                    MainTabActivity.this.imf.setHeight(R.dimen.tbds54);
                    MainTabActivity.this.imf.setMaxShowTime(99);
                    MainTabActivity.this.imf.eM(4000);
                    MainTabActivity.this.imf.vD(l.getDimens(MainTabActivity.this, R.dimen.tbds44));
                }
            }
        }
    };
    private CustomMessageListener mEnterForumTabClickListener = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 1 && MainTabActivity.this.imf != null && MainTabActivity.this.imf.isShowing()) {
                MainTabActivity.this.imf.NG();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c jvf = new com.baidu.adp.framework.listener.c(1001) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ConfigVersion configVersion;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                if (socketResponsedMessage.getError() == 0 && (configVersion = responseOnlineMessage.getConfigVersion()) != null) {
                    MainTabActivity.this.Rg(configVersion.sync);
                }
            }
        }
    };
    private CustomMessageListener mkU = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_JUMP_PB) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            h hVar;
            String link;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof h) && (link = (hVar = (h) customResponsedMessage.getData()).getLink()) != null) {
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
                        if (hVar.getPageContext() != null) {
                            q.a(queryParameter2, queryParameter, queryParameter4, i, hVar.getPageContext(), baijiahaoData);
                        } else {
                            q.a(queryParameter2, queryParameter, queryParameter4, i, MainTabActivity.this.getPageContext(), baijiahaoData);
                        }
                    } else if (baijiahaoData != null) {
                        if (StringUtils.isNull(queryParameter2)) {
                            queryParameter2 = "0";
                        }
                        if (hVar.getPageContext() != null) {
                            q.a(queryParameter2, queryParameter, queryParameter4, 0, hVar.getPageContext(), baijiahaoData);
                        } else {
                            q.a(queryParameter2, queryParameter, queryParameter4, 0, MainTabActivity.this.getPageContext(), baijiahaoData);
                        }
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
        }
    };
    private final CustomMessageListener mkW = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_INFO_CHANGED) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getData() instanceof PayMemberInfoData) {
                    MainTabActivity.this.a((PayMemberInfoData) customResponsedMessage.getData());
                    TbadkCoreApplication.getInst().setPaymemberInfo((PayMemberInfoData) customResponsedMessage.getData());
                }
                UserData bsR = com.baidu.tbadk.getUserInfo.b.bsP().bsR();
                if (TbadkCoreApplication.isLogin() && bsR != null && bsR.getUserId() != null && !bsR.getUserId().equals(MainTabActivity.this.mkK) && bsR.getIsGodInvited()) {
                    MainTabActivity.this.mkK = bsR.getUserId();
                    MainTabActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(MainTabActivity.this.getPageContext().getPageActivity(), "", TbWebViewActivityConfig.GOD_INVITE_JUMP_URL + "?page_type=open_full_screen_opacity_web_page", true)));
                }
                if (!com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("key_new_god_invited_my_tab_red_tip_showed", false) && TbadkCoreApplication.isLogin() && bsR != null && bsR.getUserId() != null && !bsR.getUserId().equals(MainTabActivity.this.mkK) && bsR.getNewGodData() != null && bsR.getNewGodData().isNewGodInvited()) {
                    com.baidu.tieba.p.a.doQ().h(11, true, true);
                    TiebaStatic.log(new aq("c13688").u("uid", TbadkCoreApplication.getCurrentAccountId()).ai("obj_locate", 0));
                    com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("key_new_god_invited_my_tab_red_tip_showed", true);
                }
            }
        }
    };
    private CustomMessageListener hUn = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && !((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                MainTabActivity.this.mkE.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    final CustomMessageListener mkX = new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.tbadk.mainTab.b> list;
            MainTabActivity.this.mIsAdd = false;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (list = ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).getList()) != null && list.size() != 0) {
                MainTabActivity.this.mkE.aP(list);
                if (MainTabActivity.this.mkA) {
                    MainTabActivity.this.mkE.cnR().setCurrentTabByType(MainTabActivity.this.mkz);
                } else if (MainTabActivity.this.getActivity().getIntent() == null || MainTabActivity.this.getActivity().getIntent().getDataString() == null || !MainTabActivity.this.getActivity().getIntent().getDataString().startsWith("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                    MainTabActivity.this.al(MainTabActivity.this.getIntent());
                } else {
                    MainTabActivity.this.mkE.cnR().setCurrentTabByType(2);
                }
                MainTabActivity.this.mkA = false;
                MainTabActivity.this.mkE.dyO();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP, null));
            }
        }
    };
    final CustomMessageListener mkY = new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_REFRESH_TABS) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007013) {
                MainTabActivity.this.cRE();
                if (MainTabActivity.this.mkE != null && MainTabActivity.this.mkE.cnR() != null) {
                    MainTabActivity.this.mkz = MainTabActivity.this.mkE.cnR().getCurrentTabType();
                }
                MainTabActivity.this.mkA = true;
            }
        }
    };
    final CustomMessageListener mkZ = new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (MainTabActivity.this.mkB != null || (customResponsedMessage.getData() instanceof bg)) {
                    if (customResponsedMessage.getData() != null) {
                        MainTabActivity.this.mkB = (bg) customResponsedMessage.getData();
                    }
                    if (!MainTabActivity.this.mIsAdd && MainTabActivity.this.mkB != null && TbadkCoreApplication.isLogin()) {
                        MainTabActivity.this.mkL.j(MainTabActivity.this.mkB.recom_title, MainTabActivity.this.mkB.recom_topic, MainTabActivity.this.mkB.dZQ);
                    }
                }
            }
        }
    };
    private final CustomMessageListener mla = new CustomMessageListener(CmdConfigCustom.MAINTAB_SET_INST) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.e.b.bib() == null) {
                b bVar = new b();
                bVar.a(MainTabActivity.this);
                com.baidu.tbadk.core.e.b.a(bVar);
            }
        }
    };
    private CustomMessageListener mlb = new CustomMessageListener(2921380) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && !at.isEmpty((String) customResponsedMessage.getData())) {
                String str = (String) customResponsedMessage.getData();
                if (KuangFloatingViewController.getInstance().init()) {
                    KuangFloatingViewController.getInstance().setInfo(str);
                    ((BaseFragmentActivity) MainTabActivity.this.getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.8.1
                        @Override // com.baidu.tbadk.core.e
                        public void onPermissionResult(boolean z) {
                            if (z) {
                                KuangFloatingViewController.getInstance().showFloatingView();
                                TiebaStatic.log(new aq("c12264").ai("obj_type", 3));
                            }
                        }
                    }, false);
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a lOe = new com.baidu.adp.framework.listener.a(1002700, CmdConfigSocket.CMD_PROFILE) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.13
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if ((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) {
                if (responsedMessage.getOrginalMessage() == null || MainTabActivity.this.getUniqueId() == null || MainTabActivity.this.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                    if (responsedMessage instanceof ProfileSocketResponseMessage) {
                        MainTabActivity.this.a((ProfileSocketResponseMessage) responsedMessage);
                    }
                    if (responsedMessage instanceof ProfileHttpResponseMessage) {
                        MainTabActivity.this.a((ProfileHttpResponseMessage) responsedMessage);
                    }
                }
            }
        }
    };
    private CustomMessageListener mld = new CustomMessageListener(2921491) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    FragmentTabWidget fragmentTabWidget = MainTabActivity.this.mkE.cnR().getFragmentTabWidget();
                    if (fragmentTabWidget.getChildCount() >= 2) {
                        MainTabActivity.this.mlc = new com.baidu.tieba.c.e(MainTabActivity.this.getPageContext(), fragmentTabWidget.getChildAt(2));
                        MainTabActivity.this.mlc.eL(R.drawable.bg_tip_blue_down);
                        MainTabActivity.this.mlc.setAnchor(2);
                        MainTabActivity.this.mlc.eK(32);
                        MainTabActivity.this.mlc.setUseDirectOffset(true);
                        MainTabActivity.this.mlc.setYOffset(-l.getDimens(MainTabActivity.this, R.dimen.tbds10));
                        MainTabActivity.this.mlc.setTextColor(R.color.cp_cont_a);
                        MainTabActivity.this.mlc.setHeight(R.dimen.tbds54);
                        MainTabActivity.this.mlc.setMaxShowTime(999);
                        MainTabActivity.this.mlc.eM(5000);
                        MainTabActivity.this.mlc.vD(l.getDimens(MainTabActivity.this, R.dimen.tbds44));
                        MainTabActivity.this.mlc.b(str, "categoryUpdate", false, true);
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a mle = new CheckRealNameModel.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.15
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void b(int i, String str, String str2, Object obj) {
            if (CheckRealNameModel.TYPE_APP_FIRST_START.equals(str2) && i == 1990055) {
                TiebaStatic.log("c12138");
                MainTabActivity.this.mkE.Ri(MainTabActivity.this.getResources().getString(R.string.check_real_name_message));
            }
        }
    };
    private CustomMessageListener dRS = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && l.isNetOk()) {
                MainTabActivity.this.dyz();
                if (!MainTabActivity.syncHasFinish) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
                }
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                MainTabActivity.this.mkI = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
                com.baidu.tbadk.core.sharedPref.b.bik().remove(SharedPrefConfig.KEY_FEEDBACK_TIP);
                com.baidu.tbadk.core.sharedPref.b.bik().remove(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW);
                com.baidu.tbadk.core.sharedPref.b.bik().remove(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP));
                if (MainTabActivity.this.mkM != null) {
                    MainTabActivity.this.mkM.xN(UtilHelper.getClipBoardContent());
                }
                if (MainTabActivity.this.mkE != null) {
                    MainTabActivity.this.mkE.dyT();
                }
                MainTabActivity.this.dyF();
            }
        }
    };
    private CustomMessageListener mlf = new CustomMessageListener(CmdConfigCustom.CMD_GAME_CENTER_INIT) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                p.eje = ((Boolean) customResponsedMessage.getData()).booleanValue();
                MainTabActivity.this.dyx();
            }
        }
    };
    private final CustomMessageListener mlg = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.GAME_TIP_SHOW, booleanValue);
                MainTabActivity.this.mkE.wn(booleanValue);
            }
        }
    };
    private CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                boolean unused = MainTabActivity.syncHasFinish = true;
                TbadkCoreApplication.getInst().syncHasFinish = true;
                if (MainTabActivity.this.mkE != null && MainTabActivity.this.mkE.dyP() != null && MainTabActivity.this.mkE.dyP().getAnimationView() != null && MainTabActivity.this.mkE.dyP().getAnimationView().getVisibility() != 0) {
                    MainTabActivity.this.mkE.dyP().setLottieView(false);
                }
                if (!TbadkCoreApplication.getInst().getActivityPrizeData().isSwitchTurn()) {
                    if (MainTabActivity.this.mkE != null) {
                        MainTabActivity.this.mkE.Rh(null);
                    }
                } else {
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getInst().getActivityPrizeData().isUserSatisfy()) {
                        String h5Url = TbadkCoreApplication.getInst().getActivityPrizeData().getH5Url();
                        if (!StringUtils.isNull(h5Url) && com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.ACTIVITY_PRIZE_GET_TIP + TbadkCoreApplication.getCurrentAccount(), true)) {
                            be.bju().a(MainTabActivity.this.getPageContext(), new String[]{h5Url}, true);
                            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.ACTIVITY_PRIZE_GET_TIP + TbadkCoreApplication.getCurrentAccount(), false);
                        }
                    }
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                        if (MainTabActivity.this.mkE != null) {
                            MainTabActivity.this.mkE.Rh(null);
                        }
                    } else {
                        String myTabText = TbadkCoreApplication.getInst().getActivityPrizeData().getMyTabText();
                        if (!StringUtils.isNull(myTabText)) {
                            if (MainTabActivity.this.mkE != null) {
                                MainTabActivity.this.mkE.Rh(myTabText);
                            }
                        } else if (MainTabActivity.this.mkE != null) {
                            MainTabActivity.this.mkE.Rh(null);
                        }
                    }
                }
                if (TbSingleton.getInstance().canShowPermDialog()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921360, MainTabActivity.this));
                }
                com.baidu.tbadk.core.business.a.bbY().dt("1", "");
            }
        }
    };
    private CustomMessageListener mli = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    MainTabActivity.this.mlh = UtilHelper.getCurrentDay();
                    com.baidu.tbadk.core.sharedPref.b.bik().putLong("last_resume_time", TbSingleton.getInstance().getLastResumeTime());
                    return;
                }
                String currentDay = UtilHelper.getCurrentDay();
                if (!StringUtils.isNull(currentDay) && !currentDay.equals(MainTabActivity.this.mlh)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
                }
                if (MainTabActivity.this.lyh == null) {
                    MainTabActivity.this.lyh = new com.baidu.tieba.ueg.b();
                }
                MainTabActivity.this.lyh.IF(MainTabActivity.this.lyh.msN);
                MainTabActivity.this.lyh.msN = ax.a.elj;
            }
        }
    };
    private final CustomMessageListener jIH = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            k kVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof k) && (kVar = (k) customResponsedMessage.getData()) != null && !StringUtils.isNull(kVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(kVar);
                if (StringUtils.isNull(kVar.eJB)) {
                    be.bju().b(MainTabActivity.this.getPageContext(), new String[]{kVar.mLink});
                } else {
                    be.bju().b(MainTabActivity.this.getPageContext(), new String[]{kVar.mLink, kVar.eJB});
                }
            }
        }
    };
    private CustomMessageListener hUE = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (MainTabActivity.this.hXi != null) {
                MainTabActivity.this.hXi.bwM();
            }
        }
    };
    private Runnable mlj = new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.36
        @Override // java.lang.Runnable
        public void run() {
            if (TbSingleton.getInstance().getNewUserRedPackageData() != null) {
                MainTabActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewUserRedPackageActivityConfig(MainTabActivity.this, TbSingleton.getInstance().getNewUserRedPackageData())));
                TbSingleton.getInstance().setNewUserRedPackageData(null);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Rg(String str) {
        if (str != null && TbadkCoreApplication.getInst().getConfigVersion() != null && dyw()) {
            this.mkG = System.currentTimeMillis();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    private boolean dyw() {
        if (-1 == this.mkG) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.mkG;
        return currentTimeMillis <= 0 || currentTimeMillis >= 300000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyx() {
        if (SwitchManager.getInstance().findType(GameEnterSwitch.GAME_ENTER_KEY) == 1 && p.eje) {
            this.mkE.wl(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_CHECK_UPDATE));
            return;
        }
        this.mkE.wl(false);
        this.mkE.wn(false);
        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.GAME_TIP_SHOW, false);
    }

    public void a(PayMemberInfoData payMemberInfoData) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && payMemberInfoData != null) {
            if ((payMemberInfoData.bqS() == 1 || payMemberInfoData.bqS() == 2) && com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.SHOW_MEMBER_DEID_LINE, true)) {
                long bcs = payMemberInfoData.bcs() * 1000;
                if (bcs < System.currentTimeMillis()) {
                    if (StringUtils.isNull(payMemberInfoData.bqT())) {
                        payMemberInfoData.BD(getPageContext().getString(R.string.member));
                    } else {
                        payMemberInfoData.BD(payMemberInfoData.bqT() + getPageContext().getString(R.string.member_already_Expire));
                    }
                    this.mkE.a(payMemberInfoData, 0);
                } else if (bcs - System.currentTimeMillis() < Config.THREAD_IMAGE_SAVE_MAX_TIME) {
                    if (StringUtils.isNull(payMemberInfoData.bqT())) {
                        payMemberInfoData.BD(getPageContext().getString(R.string.member));
                    } else {
                        payMemberInfoData.BD(payMemberInfoData.bqT() + getPageContext().getString(R.string.member_will_Expire));
                    }
                    this.mkE.a(payMemberInfoData, 1);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.mTouchable) {
            return false;
        }
        if (this.mkE.cnR() == null || this.mkE.cnR().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1 || !this.mkE.cRI()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public void cnP() {
        if (this.mkL != null) {
            this.mkL.cuc();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
        if (this.hXi == null) {
            this.hXi = new g(getPageContext(), this.lsy, "main_tab", 3);
            this.hXi.Sy("1");
        }
        if (!this.fIl.dAq() && this.mkE.cnR() != null && this.mkE.cnR().getFragmentTabWidget() != null) {
            this.hXi.a(false, (View) this.mkE.cnR().getTabWrapper(), this.mkE.cnR().getFragmentTabWidget().getWriteView());
        }
    }

    protected void cRE() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ADD_FRAGMENT, new com.baidu.tbadk.mainTab.d(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        n.bus().m40do(System.currentTimeMillis());
        if (TbadkCoreApplication.getInst().getIsFirstUse()) {
            ad.a(new ac<Object>() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.9
                @Override // com.baidu.tbadk.util.ac
                public Object doInBackground() {
                    TbadkCoreApplication.getInst().setUsed();
                    return null;
                }
            }, null);
        }
        ae.biX();
        setIsAddSwipeBackLayout(false);
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.getDecorView();
        super.onCreate(bundle);
        int i = -1;
        if (getIntent() != null) {
            this.mkP = new e(getPageContext());
            if (!this.mkP.an(getIntent())) {
                ae(getIntent());
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
        if (dyA()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        setContentView(R.layout.maintabs_activity);
        this.lsy = (FrameLayout) findViewById(R.id.maintabContainer);
        com.baidu.tbadk.core.a.a.bbN().reLoginByCacheAccount();
        this.mkE = new d(this);
        this.mkL = new c(this);
        this.mkE.wk(this.mIsLogin);
        dyx();
        cBn();
        com.baidu.tieba.tblauncher.alarmRemind.b.dyW().f(this);
        com.baidu.tbadk.BdToken.c.aYs().aYt();
        this.mkJ = new com.baidu.tieba.b();
        cRE();
        cRV();
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (bundle != null) {
            i2 = bundle.getInt("locate_type", 1);
            intent.putExtra("locate_type", i2);
        }
        this.mlh = UtilHelper.getCurrentDay();
        this.mkG = System.currentTimeMillis();
        MessageManager.getInstance().sendMessage(new CustomMessage(2921359));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        if (TbadkCoreApplication.getFrom() != null && TbadkCoreApplication.getFrom().equals("aishide")) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_ACTIVE, null));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_CLEARTEMP, null));
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_VIDEO_CACHE_CLEAN);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VIDEO_CACHE_CLEAN));
        h(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        com.baidu.tbadk.browser.a.initCookie(getPageContext().getPageActivity());
        String installOtherApp = TbadkCoreApplication.getInst().getInstallOtherApp();
        if (installOtherApp != null && installOtherApp.length() > 0) {
            UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), installOtherApp);
            TbadkCoreApplication.getInst().setInstallOtherApp(null);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.10
            @Override // java.lang.Runnable
            public void run() {
                MainTabActivity.this.mTouchable = true;
            }
        });
        TbadkCoreApplication.getInst().startTrackConfigRequest();
        if (ae.checkLocationForGoogle(getActivity())) {
            MercatorModel.dxA().startLoad();
        }
        registerListener(this.jvf);
        if (i2 == 1) {
            this.mkE.wm(true);
        } else {
            this.mkE.wm(false);
        }
        this.mkE.dyR();
        this.hSO = getVoiceManager();
        if (this.hSO != null) {
            this.hSO.onCreate(getPageContext());
        }
        registerListener(this.mAccountChangedListener);
        adjustResizeForSoftInput();
        addGlobalLayoutListener();
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.MAINTAB_ONCREATE_END);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ONCREATE_END));
        if (TbadkCoreApplication.isLogin()) {
            n.bus().but();
        }
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.getUserInfo.b.bsP().bsQ();
        }
        com.baidu.tbadk.core.sharedPref.b.bik().putInt(SharedPrefConfig.APP_RESTART_TIMES, com.baidu.tbadk.core.sharedPref.b.bik().getInt(SharedPrefConfig.APP_RESTART_TIMES, 0) + 1);
        this.kHF = new CheckRealNameModel(getPageContext());
        this.kHF.a(this.mle);
        dyz();
        this.hTE = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "homepage");
        this.ilV = new ShareSuccessReplyToServerModel();
        this.fIl = new com.baidu.tieba.ueg.d(getPageContext());
        this.mkM = com.baidu.tbadk.BdToken.d.aYH();
        int loadInt = TbadkSettings.getInst().loadInt(SharedPrefConfig.PREFS_SKIN_TYPE, 0);
        if (loadInt != 1) {
            ap.C(false, true);
        } else {
            TbadkCoreApplication.getInst().setSkinTypeValue(loadInt);
            TbadkCoreApplication.getInst().SendSkinTypeBroadcast(loadInt);
        }
        if (TbSingleton.getInstance().isEnableBenchmark() && TbSingleton.getInstance().getCpuFlopsDuration() <= 0) {
            com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.11
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.tbadk.f.a.baP();
                }
            }, 5000L);
        }
        MessageManager.getInstance().registerListener(this.jIH);
        TbSingleton.getInstance().startOneGame();
        this.akU = new WeakReference<>(TbadkCoreApplication.getInst());
        if (getResources() != null && getResources().getConfiguration() != null) {
            this.mkO = getResources().getConfiguration().uiMode & 48;
        }
        com.baidu.q.c.ga(TbadkCoreApplication.getInst()).a(null);
        dyF();
        if (this.mkP.an(intent)) {
            this.mkP.a(getIntent(), this.mkE);
        }
        com.baidu.adp.lib.f.e.mS().postDelayed(this.mlj, 200L);
        dyy();
        TbSingleton.getInstance().getChannelConfigModel().startLoad();
        n.bus().dp(System.currentTimeMillis());
    }

    public void dyy() {
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
            this.mkV = profileHttpResponseMessage.GetUser().my_like_num.intValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ProfileSocketResponseMessage profileSocketResponseMessage) {
        if (profileSocketResponseMessage != null && profileSocketResponseMessage.GetUser() != null) {
            this.mkV = profileSocketResponseMessage.GetUser().my_like_num.intValue();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public ViewGroup getActivityRootView() {
        return this.lsy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyz() {
        String str = SharedPrefConfig.CHECK_REAL_NAME + TbConfig.getVersion();
        if (com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(str, true) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && l.isNetOk()) {
            this.kHF.Mw(CheckRealNameModel.TYPE_APP_FIRST_START);
            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(str, false);
        }
    }

    private void ae(final Intent intent) {
        if (intent != null) {
            String dataString = intent.getDataString();
            UtilHelper.clearClipBoardBySchemaParam(dataString);
            if (!StringUtils.isNull(dataString) && dataString.startsWith("tbmaintab://")) {
                String decode = Uri.decode(intent.getData().getEncodedPath());
                if (StringUtils.isNull(decode)) {
                    TiebaStatic.log(new aq("c10320").ai("obj_type", 1).ai(TiebaInitialize.Params.OBJ_TO, 1));
                    return;
                }
                if (decode.startsWith("//")) {
                    decode = decode.substring(2);
                }
                Map<String, String> paramPair = be.getParamPair(decode);
                if (paramPair != null) {
                    String str = paramPair.get("fr");
                    if (!"mpush".equals(str) && "bpush".equals(str)) {
                        aq aqVar = new aq("c10320");
                        aqVar.dD("obj_locate", paramPair.get("obj_locate"));
                        aqVar.ai("obj_type", 1);
                        aqVar.dD("obj_source", paramPair.get("obj_source"));
                        aqVar.dD(TiebaInitialize.Params.OBJ_PARAM2, paramPair.get(TiebaInitialize.Params.OBJ_PARAM2));
                        aqVar.ai(TiebaInitialize.Params.OBJ_TO, 1);
                        aqVar.dD("obj_id", paramPair.get("bdid"));
                        if (!at.isEmpty(paramPair.get(LogConfig.LOG_EXT_LOG))) {
                            try {
                                JSONObject jSONObject = new JSONObject(paramPair.get(LogConfig.LOG_EXT_LOG));
                                Iterator<String> keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    aqVar.dD(next, jSONObject.getString(next));
                                }
                            } catch (Exception e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        TiebaStatic.log(aqVar);
                        HttpMessage httpMessage = new HttpMessage(1003393);
                        httpMessage.addParam("call_url", dataString);
                        MessageManager.getInstance().sendMessage(httpMessage);
                    }
                    com.baidu.tbadk.BdToken.c.aYs().setSchemaUp(true);
                } else {
                    return;
                }
            } else if (!StringUtils.isNull(dataString) && (dataString.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT) || dataString.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT_ZM) || dataString.startsWith("bdtiebalive://") || dataString.startsWith("tiebachushou://"))) {
                String dataString2 = intent.getDataString();
                if (!StringUtils.isNull(dataString2)) {
                    be.bju().b(getPageContext(), new String[]{dataString2});
                    com.baidu.tbadk.BdToken.c.aYs().setSchemaUp(true);
                }
            } else if (!StringUtils.isNULL(dataString) && dataString.startsWith(com.baidu.tbadk.BdToken.f.dOT)) {
                com.baidu.tbadk.BdToken.f.aYL().a(intent.getData(), new f.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.17
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void z(HashMap<String, Object> hashMap) {
                        if (hashMap != null && intent != null) {
                            Object obj = hashMap.get(com.baidu.tbadk.BdToken.f.dPq);
                            int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : -1;
                            Object obj2 = hashMap.get(com.baidu.tbadk.BdToken.f.dPr);
                            String str2 = obj2 instanceof String ? (String) obj2 : null;
                            Object obj3 = hashMap.get(com.baidu.tbadk.BdToken.f.dPp);
                            String str3 = obj3 instanceof String ? (String) obj3 : null;
                            if (intValue != -1) {
                                intent.putExtra("is_from_scheme", true);
                                intent.putExtra("locate_type", intValue);
                                intent.putExtra("sub_locate_type", str2);
                                intent.putExtra("sub_tab_name", str3);
                                Object obj4 = hashMap.get(com.baidu.tbadk.BdToken.f.dPs);
                                String str4 = obj4 instanceof String ? (String) obj4 : null;
                                Object obj5 = hashMap.get(com.baidu.tbadk.BdToken.f.dPt);
                                String str5 = obj5 instanceof String ? (String) obj5 : null;
                                intent.putExtra(com.baidu.tbadk.BdToken.f.dPs, str4);
                                intent.putExtra(com.baidu.tbadk.BdToken.f.dPt, str5);
                            }
                            com.baidu.tbadk.BdToken.c.aYs().setSchemaUp(true);
                        }
                    }
                });
            }
            final String stringExtra = intent.getStringExtra(MainTabActivityConfig.TARGET_SCHEME);
            if (!StringUtils.isNull(stringExtra)) {
                com.baidu.adp.lib.f.e.mS().post(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.18
                    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        be.bju().b(MainTabActivity.this.getPageContext(), new String[]{stringExtra});
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
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.hSO = getVoiceManager();
        if (this.hSO != null) {
            this.hSO.onStart(getPageContext());
        }
    }

    public boolean dyA() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_SYNC, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_ACTIVE, null));
        cBo();
        com.baidu.tbadk.coreExtra.messageCenter.b.bnV().bog();
        com.baidu.tbadk.coreExtra.messageCenter.b.bnV().bob();
        com.baidu.tbadk.coreExtra.messageCenter.b.bnV().iF(false);
        MessageManager.getInstance().unRegisterListener(this.jIH);
        MessageManager.getInstance().unRegisterListener(this.mlb);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setDialogVisiable(false);
            this.mWaitingDialog = null;
        }
        dyB();
        if (this.mkE != null) {
            this.mkE.onDestroy();
        }
        if (this.mkL != null) {
            this.mkL.onDestroy();
        }
        try {
            super.onDestroy();
        } catch (Exception e) {
        }
        com.baidu.tbadk.core.e.b.a(null);
        KuangFloatingFrsCopyLinkViewController.getInstance().onDestory();
        this.hSO = getVoiceManager();
        if (this.hSO != null) {
            this.hSO.onDestory(getPageContext());
        }
        if (this.hXi != null) {
            this.hXi.onDestroy();
        }
        if (this.hTE != null) {
            this.hTE.onDestroy();
        }
        if (this.ilV != null) {
            this.ilV.cancelLoadData();
        }
        if (this.lyh != null) {
            this.lyh.onDestroy();
        }
        if (this.mkE != null && this.mkE.dyP() != null) {
            this.mkE.dyP().onDestory();
        }
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.mlj);
        System.gc();
    }

    private void dyB() {
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

    private void h(Context context, Intent intent) {
        UtilHelper.commenDealIntent(context, intent);
        TbadkCoreApplication.setIntent(null);
    }

    private void cBn() {
        registerListener(this.mkR);
        this.mkX.setPriority(100);
        registerListener(this.mkX);
        registerListener(this.mkY);
        registerListener(this.mkZ);
        registerListener(this.mla);
        registerListener(this.mlf);
        registerListener(this.mlg);
        registerListener(this.mkW);
        registerListener(this.skinTypeChangeListener);
        registerListener(this.mkS);
        this.mkF = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.mkF, intentFilter);
        registerListener(this.hUn);
        registerListener(this.mkU);
        registerListener(this.mSyncFinishListener);
        registerListener(this.dRS);
        registerListener(this.mli);
        this.mkQ.setTag(getUniqueId());
        registerListener(this.mkQ);
        registerListener(this.mlb);
        registerListener(this.hUE);
        registerListener(this.mkT);
        registerListener(this.mEnterForumTabClickListener);
        registerListener(this.lOe);
        registerListener(this.mld);
    }

    private void cBo() {
        if (this.mkF != null) {
            unregisterReceiver(this.mkF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
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
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hRO) {
            ah.b(this.akU);
            this.hRO = false;
        }
        if (this.mkE != null && this.mkE.dyP() != null) {
            this.mkE.dyP().setLottieView(true);
        }
        if (this.mkE != null && this.mkE.cnR() != null) {
            this.mkz = this.mkE.cnR().getCurrentTabType();
        }
        changeSkinType(this.mSkinType);
        KuangFloatingFrsCopyLinkViewController.getInstance().hideFloatingView(true);
        if (TbadkCoreApplication.isLogin() && n.bus().buq()) {
            n.bus().but();
        }
        this.hSO = getVoiceManager();
        if (this.hSO != null) {
            this.hSO.onResume(getPageContext());
        }
        if (this.mkE != null) {
            this.mkE.dyR();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_ON_RESUME, getActivity()));
        if (TbadkCoreApplication.getKeepLiveSwitch(getApplicationContext())) {
            com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.19
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_KEEPLIVE_START_SERVICE, Boolean.FALSE));
                }
            }, IMConnection.RETRY_DELAY_TIMES);
        }
        n.bus().but();
        if (com.baidu.tbadk.BdToken.q.aYY().aZb() != null && com.baidu.tbadk.BdToken.q.aYY().aZh() != null && com.baidu.tbadk.BdToken.q.aYY().aZb().getCurTaskType() == 6) {
            com.baidu.tbadk.BdToken.q.aYY().aZh().complete();
        }
        if (this.imf != null && !this.imf.isShowing()) {
            this.imf.aG(getString(R.string.enterforumtab_like_forum_tips), "first_like_forum_enterforumtab_tips" + TbadkCoreApplication.getCurrentAccount());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.mkI = true;
        if (z) {
            com.baidu.tbadk.getUserInfo.b.bsP().bsQ();
            dyx();
            dyz();
            dyy();
        }
        this.mkE.switchNaviBarStatus(z);
        this.mkE.dyT();
        cRE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (this.mky) {
            this.mky = false;
            CompatibleUtile.setAnim(getPageContext().getPageActivity(), R.anim.down, R.anim.hold);
        }
        this.hSO = getVoiceManager();
        if (this.hSO != null) {
            this.hSO.onPause(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOME_HIDE_GUIDE));
        if (this.mkL != null) {
            this.mkL.cud();
        }
        KuangFloatingViewController.getInstance().hideFloatingView();
        KuangFloatingFrsCopyLinkViewController.getInstance().hideFloatingView(true);
        if (this.imf != null && this.imf.isShowing()) {
            this.imf.NG();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
        } catch (Exception e) {
        }
        bundle.putInt("locate_type", this.mkE.cnR().getCurrentTabType());
        bundle.putParcelable("android:fragments", null);
        bundle.putParcelable("android:support:fragments", null);
        this.hSO = getVoiceManager();
        if (this.hSO != null) {
            this.hSO.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.hSO = getVoiceManager();
        if (this.hSO != null) {
            this.hSO.onStop(getPageContext());
        }
        this.hRO = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        FragmentTabHost.b nM;
        int i = 2;
        super.onNewIntent(intent);
        setIntent(intent);
        String stringExtra = intent.getStringExtra(MainTabActivityConfig.TARGET_SCHEME);
        if (this.mkP.an(intent)) {
            this.mkP.a(intent, this.mkE);
        } else {
            ae(intent);
        }
        if (StringUtils.isNull(stringExtra)) {
            com.baidu.tbadk.getUserInfo.b.bsP().bsQ();
            if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_RESET_TABS));
                cRE();
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
                            i = this.mkJ.bzi();
                        }
                    }
                    if (this.mkE != null || this.mkE.cnR() == null) {
                        intExtra = i;
                    } else {
                        this.mkE.setCurrentTabByType(i);
                        intExtra = i;
                    }
                }
                i = intExtra;
                if (this.mkE != null) {
                }
                intExtra = i;
            } else if ((intExtra == 17 || intExtra == 18 || intExtra == 19) && this.mkE != null && this.mkE.cnR() != null) {
                this.mkE.cnR().setCurrentTab(0);
            }
            if (this.mkE != null && this.mkE.cnR() != null && (nM = this.mkE.cnR().nM(intExtra)) != null && (nM.mContentFragment instanceof com.baidu.tbadk.core.g)) {
                ((com.baidu.tbadk.core.g) nM.mContentFragment).B(intent);
            }
            h(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
            if (this.mkE != null) {
                this.mkE.dyR();
            }
        }
    }

    protected void at(Activity activity) {
        new com.baidu.tbadk.core.dialog.a(activity).ns(R.string.confirm_title).m39if(false).nt(R.string.background_process_permission).a(R.string.now_goto_setting, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.21
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                try {
                    MainTabActivity.this.startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
                    aVar.dismiss();
                } catch (Exception e) {
                    MainTabActivity.this.showToast(R.string.goto_developActivity_error_toast);
                }
            }
        }).b(R.string.next_time, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.20
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                MainTabActivity.this.dyC();
            }
        }).b(com.baidu.adp.base.i.I(activity)).bhg();
    }

    protected void dyC() {
        com.baidu.adp.lib.e.c.mM().d(getUniqueId());
        dyE();
        try {
            moveTaskToBack(true);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, com.baidu.adp.base.h
    public void onPreLoad(t tVar) {
        super.onPreLoad(tVar);
        ag.a(tVar, getUniqueId());
        com.baidu.tbadk.core.util.f.c.a(tVar, getUniqueId(), this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!MainTabActivityConfig.IS_BACK_CLOSE_ALL_ACTIVITY && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
            if (runTask == null || !((Boolean) runTask.getData()).booleanValue()) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2016323, (Class) null);
                if (runTask2 == null || !((Boolean) runTask2.getData()).booleanValue()) {
                    if (this.hXi != null && this.hXi.isShowing()) {
                        this.hXi.xa(true);
                        return true;
                    } else if (this.mkE.cRI()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
                        return true;
                    } else {
                        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(2921405, Boolean.class, false);
                        if (runTask3 == null || runTask3.getData() == null || !(runTask3.getData() instanceof Boolean) || !((Boolean) runTask3.getData()).booleanValue()) {
                            if (System.currentTimeMillis() - this.mkC > 2000) {
                                showToast(R.string.double_back_quit);
                                this.mkC = System.currentTimeMillis();
                            } else if (UtilHelper.isBackgroundProcessLimitNone() && Build.VERSION.SDK_INT >= 14) {
                                at(getPageContext().getPageActivity());
                                return true;
                            } else {
                                dyC();
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
    public void al(Intent intent) {
        int bzi;
        if (intent != null && this.mkE != null && this.mkE.cnR() != null) {
            try {
                if (intent.hasExtra("locate_type")) {
                    bzi = intent.getIntExtra("locate_type", 1);
                } else {
                    bzi = this.mkJ.bzi();
                }
                this.mkE.cnR().setCurrentTabByType(bzi);
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

    private void cRV() {
        registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.22
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Integer) {
                    Integer num = (Integer) customResponsedMessage.getData();
                    if (num.intValue() == 2) {
                        MainTabActivity.this.mkE.wm(true);
                        MainTabActivity.this.mkE.rW(true);
                    } else if (num.intValue() == 1) {
                        MainTabActivity.this.mkE.wm(true);
                        MainTabActivity.this.mkE.rW(false);
                    } else {
                        MainTabActivity.this.mkE.wm(false);
                        MainTabActivity.this.mkE.rW(false);
                    }
                    MainTabActivity.this.mkE.dyR();
                }
            }
        });
    }

    protected void dyD() {
        AntiData antiData = new AntiData();
        antiData.setIfpost(1);
        if (antiData.getIfpost() == 0) {
            l.showToast(getPageContext().getPageActivity(), antiData.getForbid_info());
            return;
        }
        antiData.setIfVoice(false);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteActivityConfig(getPageContext().getPageActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 != -1) {
            if (this.mkE.cnR().getCurrentFragment() != null) {
                this.mkE.cnR().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 25046) {
            if (TbadkCoreApplication.isLogin()) {
                com.baidu.tbadk.BdToken.q.aYY().c(getPageContext());
            }
        } else if (i == 11001) {
            dyD();
        } else if (i == 13003) {
            am(intent);
        } else if (i == 23007) {
            V(intent);
        } else if (i == 13011) {
            com.baidu.tieba.o.a.dmM().F(getPageContext());
        } else if (i == 24007) {
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1) {
                com.baidu.tieba.o.a.dmM().F(getPageContext());
                ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                aqVar.ai("obj_locate", 5);
                if (shareItem != null) {
                    aqVar.dD("tid", shareItem.tid);
                }
                aqVar.dD("pid", intent.getStringExtra("pid"));
                TiebaStatic.log(aqVar);
                if (shareItem != null && shareItem.linkUrl != null && this.ilV != null) {
                    this.ilV.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.24
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void boY() {
                        }

                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void a(final CustomDialogData customDialogData) {
                            com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.24.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a(MainTabActivity.this.getPageContext(), customDialogData).show();
                                }
                            }, 1000L);
                        }
                    });
                }
            }
        } else if (this.mkE.cnR().getCurrentFragment() != null) {
            this.mkE.cnR().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    private ShareFromPBMsgData crI() {
        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.imageUri == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.imageUri.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.eEq);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.fName);
        shareFromPBMsgData.setThreadId(shareItem.tid);
        return shareFromPBMsgData;
    }

    private void V(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(crI(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.nw(1);
            aVar.aX(thread2GroupShareView);
            aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.25
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MainTabActivity.this.HidenSoftKeyPad((InputMethodManager) MainTabActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(MainTabActivity.this.getPageContext().getPageActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.bpw() != null) {
                        Bundle bpw = shareItem.bpw();
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ai("obj_source", 1).ai("obj_type", bpw.getInt("obj_type")).ai("obj_param1", 3).dD("fid", bpw.getString("fid")).dD("tid", bpw.getString("tid")).ai("obj_locate", 5));
                    }
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.26
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MainTabActivity.this.HidenSoftKeyPad((InputMethodManager) MainTabActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.ig(true);
            aVar.b(getPageContext()).bhg();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.aJ(shareFromPBMsgData.getImageUrl(), false);
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
        this.mkE.onChangeSkinType(i);
        adjustResizeForSoftInputOnSkinTypeChanged(i);
        if (this.hXi != null) {
            this.hXi.onChangeSkinType(i);
        }
    }

    private void am(Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        if (intent != null) {
            try {
                postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
            } catch (Exception e) {
                BdLog.e(e);
                postWriteCallBackData = null;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PERSONALIZED_MAINTAB_ON_RESULT, postWriteCallBackData));
            if (this.mkE != null && !this.mkE.d(postWriteCallBackData)) {
                this.mkE.b(postWriteCallBackData);
            }
        }
    }

    private void dyE() {
        if (System.currentTimeMillis() - this.mkD >= 7200000) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "start");
            hashMap.put(BdStatsConstant.StatsKey.UNAME, TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_CLEARTEMP, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
            this.mkD = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.a
    public int getCurrentTabType() {
        if (this.mkE.cnR() != null) {
            return this.mkE.cnR().getCurrentTabType();
        }
        return -1;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hSO == null) {
            this.hSO = VoiceManager.instance();
        }
        return this.hSO;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public ListView blc() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> bld() {
        if (this.evp == null) {
            this.evp = UserIconBox.u(getPageContext().getPageActivity(), 8);
        }
        return this.evp;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> clf() {
        if (this.mkH == null) {
            this.mkH = FrsCommonImageLayout.D(getPageContext().getPageActivity(), 12);
        }
        return this.mkH;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return new com.baidu.tbadk.m.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.27
            @Override // com.baidu.tbadk.m.b
            public boolean isCurrentPageCanBeAddToSourceTrace() {
                return true;
            }

            @Override // com.baidu.tbadk.m.b
            public int getMaxCost() {
                return com.baidu.tbadk.m.e.btZ().getMaxCostFromServer();
            }

            @Override // com.baidu.tbadk.m.b
            public boolean a(com.baidu.tbadk.m.d dVar) {
                return false;
            }
        };
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        List<String> currentPageSourceKeyList = super.getCurrentPageSourceKeyList();
        if (this.mkI && currentPageSourceKeyList != null) {
            currentPageSourceKeyList.clear();
            this.mkI = false;
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
        if (this.mkE != null && this.mkE.cnR() != null) {
            Fragment currentFragment = this.mkE.cnR().getCurrentFragment();
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
        this.gKh = z;
        boolean z2 = this.mkN || this.gKh;
        if (this.mkE != null) {
            this.mkE.onKeyboardVisibilityChanged(z2);
        }
    }

    @Override // com.baidu.tbadk.core.util.f.b
    public boolean videoNeedPreload() {
        return ah.qL(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            super.onConfigurationChanged(configuration);
            if (TbadkCoreApplication.getInst().getSkinType() != 1) {
                ap.C(true, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyF() {
        String str = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_is_clear_concern_cache_when_version_update") + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + TbConfig.getVersion();
        if (!com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(str, false)) {
            try {
                com.baidu.tbadk.core.c.a.bhb().dv("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).setForever("0", null);
                com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(str, true);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
