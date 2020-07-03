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
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
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
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.t;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.message.ExitAppMessage;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.o;
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
import com.baidu.tbadk.util.ag;
import com.baidu.tbadk.util.q;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.Thread2GroupShareView;
import com.baidu.tieba.write.g;
import com.baidu.tieba.write.h;
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
/* loaded from: classes9.dex */
public class MainTabActivity extends BaseFragmentActivity implements com.baidu.tbadk.core.util.f.c, UserIconBox.b, VoiceManager.c, FrsCommonImageLayout.c, com.baidu.tieba.tblauncher.a {
    private static boolean syncHasFinish;
    private WeakReference<Context> ajK;
    private com.baidu.adp.lib.d.b<TbImageView> efk;
    private com.baidu.tieba.ueg.d frL;
    private com.baidu.tieba.NEGFeedBack.a hAy;
    private g hDL;
    private ShareSuccessReplyToServerModel hRN;
    VoiceManager hzJ;
    private CheckRealNameModel kjb;
    private d lLB;
    private a lLC;
    private com.baidu.adp.lib.d.b<TbImageView> lLE;
    private com.baidu.tieba.b lLG;
    private FrameLayout lLH;
    private c lLJ;
    private com.baidu.tbadk.BdToken.d lLK;
    private e lLN;
    private be lLy;
    private String lMd;
    private com.baidu.tieba.ueg.b lax;
    private boolean mTouchable;
    private boolean lLv = false;
    private int lLw = -1;
    private boolean lLx = false;
    private String mFrom = null;
    private volatile boolean mIsAdd = false;
    private long lLz = 0;
    private long lLA = 0;
    private long lLD = -1;
    private boolean lLF = false;
    private String lLI = "";
    boolean lLL = false;
    boolean gsL = false;
    boolean hyM = true;
    private int lLM = 16;
    private CustomMessageListener lLO = new CustomMessageListener(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && MainTabActivity.this.lLB != null && TbadkCoreApplication.getInst().getCurrentActivity() == MainTabActivity.this) {
                MainTabActivity.this.lLL = com.baidu.adp.lib.f.b.toBoolean(customResponsedMessage.getData().toString(), false);
                MainTabActivity.this.lLB.onKeyboardVisibilityChanged((MainTabActivity.this.lLL || MainTabActivity.this.gsL) ? true : true);
            }
        }
    };
    private final CustomMessageListener lLP = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_MATINTAB) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.12
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
                        MainTabActivity.this.lLB.bZU().changeStyle(1);
                    } else if (TbadkCoreApplication.getInst().isThemeIconCover()) {
                        MainTabActivity.this.lLB.bZU().changeStyle(2);
                    } else {
                        MainTabActivity.this.lLB.bZU().changeStyle(1);
                    }
                }
            }
        }
    };
    public CustomMessageListener lLQ = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && MainTabActivity.this.lLB != null && MainTabActivity.this.lLB.bZU() != null) {
                if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    MainTabActivity.this.lLB.bZU().getTabWrapper().animate().translationY(MainTabActivity.this.lLB.bZU().getTabWrapper().getHeight()).setDuration(200L).start();
                } else {
                    MainTabActivity.this.lLB.bZU().getTabWrapper().animate().translationY(0.0f).setDuration(400L).start();
                }
            }
        }
    };
    public CustomMessageListener lLR = new CustomMessageListener(2921452) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i) && com.baidu.tbadk.core.util.be.checkUpIsLogin(MainTabActivity.this.getPageContext().getPageActivity())) {
                MainTabActivity.this.bZS();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c iXT = new com.baidu.adp.framework.listener.c(1001) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ConfigVersion configVersion;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                if (socketResponsedMessage.getError() == 0 && (configVersion = responseOnlineMessage.getConfigVersion()) != null) {
                    MainTabActivity.this.Nz(configVersion.sync);
                }
            }
        }
    };
    private CustomMessageListener lLS = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_JUMP_PB) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.36
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
    private final CustomMessageListener lLT = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_INFO_CHANGED) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getData() instanceof PayMemberInfoData) {
                    MainTabActivity.this.a((PayMemberInfoData) customResponsedMessage.getData());
                    TbadkCoreApplication.getInst().setPaymemberInfo((PayMemberInfoData) customResponsedMessage.getData());
                }
                UserData bgu = com.baidu.tbadk.getUserInfo.b.bgs().bgu();
                if (TbadkCoreApplication.isLogin() && bgu != null && bgu.getUserId() != null && !bgu.getUserId().equals(MainTabActivity.this.lLI) && bgu.getIsGodInvited()) {
                    MainTabActivity.this.lLI = bgu.getUserId();
                    MainTabActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(MainTabActivity.this.getPageContext().getPageActivity(), "", TbWebViewActivityConfig.GOD_INVITE_JUMP_URL + "?page_type=open_full_screen_opacity_web_page", true)));
                }
                if (!com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean("key_new_god_invited_my_tab_red_tip_showed", false) && TbadkCoreApplication.isLogin() && bgu != null && bgu.getUserId() != null && !bgu.getUserId().equals(MainTabActivity.this.lLI) && bgu.getNewGodData() != null && bgu.getNewGodData().isNewGodInvited()) {
                    com.baidu.tieba.p.a.daq().g(11, true, true);
                    TiebaStatic.log(new ao("c13688").s("uid", TbadkCoreApplication.getCurrentAccountId()).ag("obj_locate", 0));
                    com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean("key_new_god_invited_my_tab_red_tip_showed", true);
                }
            }
        }
    };
    private CustomMessageListener hBc = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && !((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                MainTabActivity.this.lLB.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    final CustomMessageListener lLU = new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.tbadk.mainTab.b> list;
            MainTabActivity.this.mIsAdd = false;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (list = ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).getList()) != null && list.size() != 0) {
                MainTabActivity.this.lLB.aI(list);
                if (MainTabActivity.this.lLx) {
                    MainTabActivity.this.lLB.bZU().setCurrentTabByType(MainTabActivity.this.lLw);
                } else if (MainTabActivity.this.getActivity().getIntent() == null || MainTabActivity.this.getActivity().getIntent().getDataString() == null || !MainTabActivity.this.getActivity().getIntent().getDataString().startsWith("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                    MainTabActivity.this.ai(MainTabActivity.this.getIntent());
                } else {
                    MainTabActivity.this.lLB.bZU().setCurrentTabByType(2);
                }
                MainTabActivity.this.lLx = false;
                MainTabActivity.this.lLB.dkf();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP, null));
            }
        }
    };
    final CustomMessageListener lLV = new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_REFRESH_TABS) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007013) {
                MainTabActivity.this.cDg();
                if (MainTabActivity.this.lLB != null && MainTabActivity.this.lLB.bZU() != null) {
                    MainTabActivity.this.lLw = MainTabActivity.this.lLB.bZU().getCurrentTabType();
                }
                MainTabActivity.this.lLx = true;
            }
        }
    };
    final CustomMessageListener lLW = new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (MainTabActivity.this.lLy != null || (customResponsedMessage.getData() instanceof be)) {
                    if (customResponsedMessage.getData() != null) {
                        MainTabActivity.this.lLy = (be) customResponsedMessage.getData();
                    }
                    if (!MainTabActivity.this.mIsAdd && MainTabActivity.this.lLy != null && TbadkCoreApplication.isLogin()) {
                        MainTabActivity.this.lLJ.j(MainTabActivity.this.lLy.recom_title, MainTabActivity.this.lLy.recom_topic, MainTabActivity.this.lLy.dKl);
                    }
                }
            }
        }
    };
    private final CustomMessageListener lLX = new CustomMessageListener(CmdConfigCustom.MAINTAB_SET_INST) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.e.b.aVG() == null) {
                b bVar = new b();
                bVar.a(MainTabActivity.this);
                com.baidu.tbadk.core.e.b.a(bVar);
            }
        }
    };
    private CustomMessageListener lLY = new CustomMessageListener(2921380) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && !ar.isEmpty((String) customResponsedMessage.getData())) {
                String str = (String) customResponsedMessage.getData();
                if (KuangFloatingViewController.getInstance().init()) {
                    KuangFloatingViewController.getInstance().setInfo(str);
                    ((BaseFragmentActivity) MainTabActivity.this.getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.6.1
                        @Override // com.baidu.tbadk.core.e
                        public void onPermissionResult(boolean z) {
                            if (z) {
                                KuangFloatingViewController.getInstance().showFloatingView();
                                TiebaStatic.log(new ao("c12264").ag("obj_type", 3));
                            }
                        }
                    });
                }
            }
        }
    };
    private h.a lLZ = new h.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.7
        @Override // com.baidu.tieba.write.h.a
        public void Fp(int i) {
            if (i == 4) {
                MainTabActivity.this.lLB.dkd();
            }
        }
    };
    private CheckRealNameModel.a lMa = new CheckRealNameModel.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.11
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void b(int i, String str, String str2, Object obj) {
            if (CheckRealNameModel.TYPE_APP_FIRST_START.equals(str2) && i == 1990055) {
                TiebaStatic.log("c12138");
                MainTabActivity.this.lLB.NB(MainTabActivity.this.getResources().getString(R.string.check_real_name_message));
            }
        }
    };
    private CustomMessageListener dCO = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && l.isNetOk()) {
                MainTabActivity.this.djQ();
                if (!MainTabActivity.syncHasFinish) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
                }
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                MainTabActivity.this.lLF = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
                com.baidu.tbadk.core.sharedPref.b.aVP().remove(SharedPrefConfig.KEY_FEEDBACK_TIP);
                com.baidu.tbadk.core.sharedPref.b.aVP().remove(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW);
                com.baidu.tbadk.core.sharedPref.b.aVP().remove(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP));
                if (MainTabActivity.this.lLK != null) {
                    MainTabActivity.this.lLK.uz(UtilHelper.getClipBoardContent());
                }
                if (MainTabActivity.this.lLB != null) {
                    MainTabActivity.this.lLB.dkk();
                }
                MainTabActivity.this.djW();
            }
        }
    };
    private CustomMessageListener lMb = new CustomMessageListener(CmdConfigCustom.CMD_GAME_CENTER_INIT) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                o.dTf = ((Boolean) customResponsedMessage.getData()).booleanValue();
                MainTabActivity.this.djP();
            }
        }
    };
    private final CustomMessageListener lMc = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.GAME_TIP_SHOW, booleanValue);
                MainTabActivity.this.lLB.uU(booleanValue);
            }
        }
    };
    private CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.28
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                boolean unused = MainTabActivity.syncHasFinish = true;
                TbadkCoreApplication.getInst().syncHasFinish = true;
                if (MainTabActivity.this.lLB != null && MainTabActivity.this.lLB.dkg() != null && MainTabActivity.this.lLB.dkg().getAnimationView() != null && MainTabActivity.this.lLB.dkg().getAnimationView().getVisibility() != 0) {
                    MainTabActivity.this.lLB.dkg().setLottieView(false);
                }
                if (!TbadkCoreApplication.getInst().getActivityPrizeData().isSwitchTurn()) {
                    if (MainTabActivity.this.lLB != null) {
                        MainTabActivity.this.lLB.NA(null);
                    }
                } else {
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getInst().getActivityPrizeData().isUserSatisfy()) {
                        String h5Url = TbadkCoreApplication.getInst().getActivityPrizeData().getH5Url();
                        if (!StringUtils.isNull(h5Url) && com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.ACTIVITY_PRIZE_GET_TIP + TbadkCoreApplication.getCurrentAccount(), true)) {
                            bc.aWU().a(MainTabActivity.this.getPageContext(), new String[]{h5Url}, true);
                            com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.ACTIVITY_PRIZE_GET_TIP + TbadkCoreApplication.getCurrentAccount(), false);
                        }
                    }
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                        if (MainTabActivity.this.lLB != null) {
                            MainTabActivity.this.lLB.NA(null);
                        }
                    } else {
                        String myTabText = TbadkCoreApplication.getInst().getActivityPrizeData().getMyTabText();
                        if (!StringUtils.isNull(myTabText)) {
                            if (MainTabActivity.this.lLB != null) {
                                MainTabActivity.this.lLB.NA(myTabText);
                            }
                        } else if (MainTabActivity.this.lLB != null) {
                            MainTabActivity.this.lLB.NA(null);
                        }
                    }
                }
                if (TbSingleton.getInstance().canShowPermDialog()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921360, MainTabActivity.this));
                }
                com.baidu.tbadk.core.business.a.aPM().da("1", "");
            }
        }
    };
    private CustomMessageListener lMe = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    MainTabActivity.this.lMd = UtilHelper.getCurrentDay();
                    com.baidu.tbadk.core.sharedPref.b.aVP().putLong("last_resume_time", TbSingleton.getInstance().getLastResumeTime());
                    return;
                }
                String currentDay = UtilHelper.getCurrentDay();
                if (!StringUtils.isNull(currentDay) && !currentDay.equals(MainTabActivity.this.lMd)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
                }
                if (MainTabActivity.this.lax == null) {
                    MainTabActivity.this.lax = new com.baidu.tieba.ueg.b();
                }
                MainTabActivity.this.lax.FN(MainTabActivity.this.lax.lTH);
                MainTabActivity.this.lax.lTH = av.a.dVf;
            }
        }
    };
    private final CustomMessageListener jkW = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            k kVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof k) && (kVar = (k) customResponsedMessage.getData()) != null && !StringUtils.isNull(kVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(kVar);
                if (StringUtils.isNull(kVar.esJ)) {
                    bc.aWU().b(MainTabActivity.this.getPageContext(), new String[]{kVar.mLink});
                } else {
                    bc.aWU().b(MainTabActivity.this.getPageContext(), new String[]{kVar.mLink, kVar.esJ});
                }
            }
        }
    };
    private CustomMessageListener hBt = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (MainTabActivity.this.hDL != null) {
                MainTabActivity.this.hDL.bke();
            }
        }
    };
    private Runnable lMf = new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.32
        @Override // java.lang.Runnable
        public void run() {
            if (TbSingleton.getInstance().getNewUserRedPackageData() != null) {
                MainTabActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewUserRedPackageActivityConfig(MainTabActivity.this, TbSingleton.getInstance().getNewUserRedPackageData())));
                TbSingleton.getInstance().setNewUserRedPackageData(null);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Nz(String str) {
        if (str != null && TbadkCoreApplication.getInst().getConfigVersion() != null && djO()) {
            this.lLD = System.currentTimeMillis();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    private boolean djO() {
        if (-1 == this.lLD) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.lLD;
        return currentTimeMillis <= 0 || currentTimeMillis >= 300000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djP() {
        if (SwitchManager.getInstance().findType(GameEnterSwitch.GAME_ENTER_KEY) == 1 && o.dTf) {
            this.lLB.uS(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_CHECK_UPDATE));
            return;
        }
        this.lLB.uS(false);
        this.lLB.uU(false);
        com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.GAME_TIP_SHOW, false);
    }

    public void a(PayMemberInfoData payMemberInfoData) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && payMemberInfoData != null) {
            if ((payMemberInfoData.bex() == 1 || payMemberInfoData.bex() == 2) && com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.SHOW_MEMBER_DEID_LINE, true)) {
                long aQf = payMemberInfoData.aQf() * 1000;
                if (aQf < System.currentTimeMillis()) {
                    if (StringUtils.isNull(payMemberInfoData.bey())) {
                        payMemberInfoData.yh(getPageContext().getString(R.string.member));
                    } else {
                        payMemberInfoData.yh(payMemberInfoData.bey() + getPageContext().getString(R.string.member_already_Expire));
                    }
                    this.lLB.a(payMemberInfoData, 0);
                } else if (aQf - System.currentTimeMillis() < Config.THREAD_IMAGE_SAVE_MAX_TIME) {
                    if (StringUtils.isNull(payMemberInfoData.bey())) {
                        payMemberInfoData.yh(getPageContext().getString(R.string.member));
                    } else {
                        payMemberInfoData.yh(payMemberInfoData.bey() + getPageContext().getString(R.string.member_will_Expire));
                    }
                    this.lLB.a(payMemberInfoData, 1);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.mTouchable) {
            return false;
        }
        if (this.lLB.bZU() == null || this.lLB.bZU().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1 || !this.lLB.cDk()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public void bZS() {
        if (this.lLJ != null) {
            this.lLJ.cfY();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
        if (this.hDL == null) {
            if (com.baidu.tbadk.a.d.aNV()) {
                this.hDL = new g(getPageContext(), this.lLH, "main_tab", 3);
            } else {
                this.hDL = new g(getPageContext(), this.lLH, "main_tab", 2);
            }
            this.hDL.OO("1");
        }
        this.hDL.a(this.lLZ);
        if (!this.frL.dlH() && this.lLB.bZU() != null && this.lLB.bZU().getFragmentTabWidget() != null) {
            if (!com.baidu.tbadk.a.d.aNV()) {
                this.lLB.dke();
            }
            this.hDL.a(false, (View) this.lLB.bZU().getTabWrapper(), this.lLB.bZU().getFragmentTabWidget().getWriteView());
        }
    }

    protected void cDg() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ADD_FRAGMENT, new com.baidu.tbadk.mainTab.d(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        n.bhU().cJ(System.currentTimeMillis());
        if (TbadkCoreApplication.getInst().getIsFirstUse()) {
            ad.a(new ac<Object>() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.8
                @Override // com.baidu.tbadk.util.ac
                public Object doInBackground() {
                    TbadkCoreApplication.getInst().setUsed();
                    return null;
                }
            }, null);
        }
        setIsAddSwipeBackLayout(false);
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.getDecorView();
        super.onCreate(bundle);
        int i = -1;
        if (getIntent() != null) {
            this.lLN = new e(getPageContext());
            if (!this.lLN.ak(getIntent())) {
                ab(getIntent());
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
        if (djR()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        setContentView(R.layout.maintabs_activity);
        this.lLH = (FrameLayout) findViewById(R.id.maintabContainer);
        com.baidu.tbadk.core.a.a.aPB().reLoginByCacheAccount();
        this.lLB = new d(this);
        this.lLJ = new c(this);
        this.lLB.uR(this.mIsLogin);
        djP();
        cmU();
        com.baidu.tieba.tblauncher.alarmRemind.b.dkn().f(this);
        com.baidu.tbadk.BdToken.c.aMo().aMp();
        this.lLG = new com.baidu.tieba.b();
        cDg();
        cDx();
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (bundle != null) {
            i2 = bundle.getInt("locate_type", 1);
            intent.putExtra("locate_type", i2);
        }
        this.lMd = UtilHelper.getCurrentDay();
        this.lLD = System.currentTimeMillis();
        MessageManager.getInstance().sendMessage(new CustomMessage(2921359));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        if (TbadkCoreApplication.getFrom() != null && TbadkCoreApplication.getFrom().equals("aishide")) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_ACTIVE, null));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_CLEARTEMP, null));
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_VIDEO_CACHE_CLEAN);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VIDEO_CACHE_CLEAN));
        g(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        com.baidu.tbadk.browser.a.initCookie(getPageContext().getPageActivity());
        String installOtherApp = TbadkCoreApplication.getInst().getInstallOtherApp();
        if (installOtherApp != null && installOtherApp.length() > 0) {
            UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), installOtherApp);
            TbadkCoreApplication.getInst().setInstallOtherApp(null);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.9
            @Override // java.lang.Runnable
            public void run() {
                MainTabActivity.this.mTouchable = true;
            }
        });
        TbadkCoreApplication.getInst().startTrackConfigRequest();
        if (com.baidu.tbadk.core.util.ac.checkLocationForGoogle(getActivity())) {
            MercatorModel.diV().startLoad();
        } else if (!bnj()) {
            com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean("key_location_request_dialog_has_shown", true);
            com.baidu.tbadk.core.util.ac.d(getActivity(), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE);
        }
        registerListener(this.iXT);
        if (i2 == 1) {
            this.lLB.uT(true);
        } else {
            this.lLB.uT(false);
        }
        this.lLB.dki();
        this.hzJ = getVoiceManager();
        if (this.hzJ != null) {
            this.hzJ.onCreate(getPageContext());
        }
        registerListener(this.mAccountChangedListener);
        adjustResizeForSoftInput();
        addGlobalLayoutListener();
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.MAINTAB_ONCREATE_END);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ONCREATE_END));
        if (TbadkCoreApplication.isLogin()) {
            n.bhU().bhV();
        }
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.getUserInfo.b.bgs().bgt();
        }
        com.baidu.tbadk.core.sharedPref.b.aVP().putInt(SharedPrefConfig.APP_RESTART_TIMES, com.baidu.tbadk.core.sharedPref.b.aVP().getInt(SharedPrefConfig.APP_RESTART_TIMES, 0) + 1);
        this.kjb = new CheckRealNameModel(getPageContext());
        this.kjb.a(this.lMa);
        djQ();
        this.hAy = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "homepage");
        this.hRN = new ShareSuccessReplyToServerModel();
        this.frL = new com.baidu.tieba.ueg.d(getPageContext());
        int i3 = com.baidu.tbadk.core.sharedPref.b.aVP().getInt("need_deal_diversion_jump", 2);
        if (i3 == 2) {
            com.baidu.tbadk.core.sharedPref.b.aVP().putInt("need_deal_diversion_jump", 1);
        } else if (i3 == 1) {
            com.baidu.tbadk.core.sharedPref.b.aVP().putInt("need_deal_diversion_jump", 0);
        }
        this.lLK = com.baidu.tbadk.BdToken.d.aMD();
        int loadInt = TbadkSettings.getInst().loadInt(SharedPrefConfig.PREFS_SKIN_TYPE, 0);
        if (loadInt != 1) {
            an.y(false, true);
        } else {
            TbadkCoreApplication.getInst().setSkinTypeValue(loadInt);
            TbadkCoreApplication.getInst().SendSkinTypeBroadcast(loadInt);
        }
        if (TbSingleton.getInstance().isEnableBenchmark() && TbSingleton.getInstance().getCpuFlopsDuration() <= 0) {
            com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.10
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.tbadk.f.a.aOD();
                }
            }, 5000L);
        }
        MessageManager.getInstance().registerListener(this.jkW);
        TbSingleton.getInstance().startOneGame();
        this.ajK = new WeakReference<>(TbadkCoreApplication.getInst());
        if (getResources() != null && getResources().getConfiguration() != null) {
            this.lLM = getResources().getConfiguration().uiMode & 48;
        }
        com.baidu.l.c.fK(TbadkCoreApplication.getInst()).a(null);
        djW();
        if (this.lLN.ak(intent)) {
            this.lLN.a(getIntent(), this.lLB);
        }
        com.baidu.adp.lib.f.e.lt().postDelayed(this.lMf, 200L);
        n.bhU().cK(System.currentTimeMillis());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public ViewGroup getActivityRootView() {
        return this.lLH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djQ() {
        String str = SharedPrefConfig.CHECK_REAL_NAME + TbConfig.getVersion();
        if (com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(str, true) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && l.isNetOk()) {
            this.kjb.IP(CheckRealNameModel.TYPE_APP_FIRST_START);
            com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(str, false);
        }
    }

    private void ab(final Intent intent) {
        if (intent != null) {
            String dataString = intent.getDataString();
            UtilHelper.clearClipBoardBySchemaParam(dataString);
            if (!StringUtils.isNull(dataString) && dataString.startsWith("tbmaintab://")) {
                String decode = Uri.decode(intent.getData().getEncodedPath());
                if (StringUtils.isNull(decode)) {
                    TiebaStatic.log(new ao("c10320").ag("obj_type", 1).ag(TiebaInitialize.Params.OBJ_TO, 1));
                    return;
                }
                if (decode.startsWith("//")) {
                    decode = decode.substring(2);
                }
                Map<String, String> paramPair = bc.getParamPair(decode);
                if (paramPair != null) {
                    String str = paramPair.get("fr");
                    if (!"mpush".equals(str) && "bpush".equals(str)) {
                        ao aoVar = new ao("c10320");
                        aoVar.dk("obj_locate", paramPair.get("obj_locate"));
                        aoVar.ag("obj_type", 1);
                        aoVar.dk("obj_source", paramPair.get("obj_source"));
                        aoVar.dk(TiebaInitialize.Params.OBJ_PARAM2, paramPair.get(TiebaInitialize.Params.OBJ_PARAM2));
                        aoVar.ag(TiebaInitialize.Params.OBJ_TO, 1);
                        aoVar.dk("obj_id", paramPair.get("bdid"));
                        if (!ar.isEmpty(paramPair.get(LogConfig.LOG_EXT_LOG))) {
                            try {
                                JSONObject jSONObject = new JSONObject(paramPair.get(LogConfig.LOG_EXT_LOG));
                                Iterator<String> keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    aoVar.dk(next, jSONObject.getString(next));
                                }
                            } catch (Exception e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        TiebaStatic.log(aoVar);
                        HttpMessage httpMessage = new HttpMessage(1003393);
                        httpMessage.addParam("call_url", dataString);
                        MessageManager.getInstance().sendMessage(httpMessage);
                    }
                    com.baidu.tbadk.BdToken.c.aMo().setSchemaUp(true);
                } else {
                    return;
                }
            } else if (!StringUtils.isNull(dataString) && (dataString.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT) || dataString.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT_ZM) || dataString.startsWith("bdtiebalive://") || dataString.startsWith("tiebachushou://"))) {
                String dataString2 = intent.getDataString();
                if (!StringUtils.isNull(dataString2)) {
                    bc.aWU().b(getPageContext(), new String[]{dataString2});
                    com.baidu.tbadk.BdToken.c.aMo().setSchemaUp(true);
                }
            } else if (!StringUtils.isNULL(dataString) && dataString.startsWith(com.baidu.tbadk.BdToken.f.dzP)) {
                com.baidu.tbadk.BdToken.f.aMH().a(intent.getData(), new f.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.14
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void C(HashMap<String, Object> hashMap) {
                        if (hashMap != null && intent != null) {
                            Object obj = hashMap.get(com.baidu.tbadk.BdToken.f.dAm);
                            int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : -1;
                            Object obj2 = hashMap.get(com.baidu.tbadk.BdToken.f.dAn);
                            String str2 = obj2 instanceof String ? (String) obj2 : null;
                            Object obj3 = hashMap.get(com.baidu.tbadk.BdToken.f.dAl);
                            String str3 = obj3 instanceof String ? (String) obj3 : null;
                            if (intValue != -1) {
                                intent.putExtra("is_from_scheme", true);
                                intent.putExtra("locate_type", intValue);
                                intent.putExtra("sub_locate_type", str2);
                                intent.putExtra("sub_tab_name", str3);
                                Object obj4 = hashMap.get(com.baidu.tbadk.BdToken.f.dAo);
                                String str4 = obj4 instanceof String ? (String) obj4 : null;
                                Object obj5 = hashMap.get(com.baidu.tbadk.BdToken.f.dAp);
                                String str5 = obj5 instanceof String ? (String) obj5 : null;
                                intent.putExtra(com.baidu.tbadk.BdToken.f.dAo, str4);
                                intent.putExtra(com.baidu.tbadk.BdToken.f.dAp, str5);
                            }
                            com.baidu.tbadk.BdToken.c.aMo().setSchemaUp(true);
                        }
                    }
                });
            }
            final String stringExtra = intent.getStringExtra(MainTabActivityConfig.TARGET_SCHEME);
            if (!StringUtils.isNull(stringExtra)) {
                com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.15
                    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        bc.aWU().b(MainTabActivity.this.getPageContext(), new String[]{stringExtra});
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
        this.hzJ = getVoiceManager();
        if (this.hzJ != null) {
            this.hzJ.onStart(getPageContext());
        }
    }

    public boolean djR() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_SYNC, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_ACTIVE, null));
        cmV();
        com.baidu.tbadk.coreExtra.messageCenter.b.bbo().bbA();
        com.baidu.tbadk.coreExtra.messageCenter.b.bbo().bbu();
        com.baidu.tbadk.coreExtra.messageCenter.b.bbo().hD(false);
        MessageManager.getInstance().unRegisterListener(this.jkW);
        MessageManager.getInstance().unRegisterListener(this.lLY);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setDialogVisiable(false);
            this.mWaitingDialog = null;
        }
        djS();
        if (this.lLB != null) {
            this.lLB.onDestroy();
        }
        if (this.lLJ != null) {
            this.lLJ.onDestroy();
        }
        try {
            super.onDestroy();
        } catch (Exception e) {
        }
        com.baidu.tbadk.core.e.b.a(null);
        this.hzJ = getVoiceManager();
        if (this.hzJ != null) {
            this.hzJ.onDestory(getPageContext());
        }
        if (this.hDL != null) {
            this.hDL.onDestroy();
        }
        if (this.hAy != null) {
            this.hAy.onDestroy();
        }
        if (this.hRN != null) {
            this.hRN.cancelLoadData();
        }
        if (this.lax != null) {
            this.lax.onDestroy();
        }
        if (this.lLB != null && this.lLB.dkg() != null) {
            this.lLB.dkg().onDestory();
        }
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.lMf);
        System.gc();
    }

    private void djS() {
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

    private void g(Context context, Intent intent) {
        UtilHelper.commenDealIntent(context, intent);
        TbadkCoreApplication.setIntent(null);
    }

    private void cmU() {
        registerListener(this.lLP);
        this.lLU.setPriority(100);
        registerListener(this.lLU);
        registerListener(this.lLV);
        registerListener(this.lLW);
        registerListener(this.lLX);
        registerListener(this.lMb);
        registerListener(this.lMc);
        registerListener(this.lLT);
        registerListener(this.skinTypeChangeListener);
        registerListener(this.lLQ);
        this.lLC = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.lLC, intentFilter);
        registerListener(this.hBc);
        registerListener(this.lLS);
        registerListener(this.mSyncFinishListener);
        registerListener(this.dCO);
        registerListener(this.lMe);
        this.lLO.setTag(getUniqueId());
        registerListener(this.lLO);
        registerListener(this.lLY);
        registerListener(this.hBt);
        registerListener(this.lLR);
    }

    private void cmV() {
        if (this.lLC != null) {
            unregisterReceiver(this.lLC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
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
        if (this.hyM) {
            ag.b(this.ajK);
            this.hyM = false;
        }
        if (this.lLB != null && this.lLB.dkg() != null) {
            this.lLB.dkg().setLottieView(true);
        }
        if (this.lLB != null && this.lLB.bZU() != null) {
            this.lLw = this.lLB.bZU().getCurrentTabType();
        }
        changeSkinType(this.mSkinType);
        if (TbadkCoreApplication.isLogin() && n.bhU().bhS()) {
            n.bhU().bhV();
        }
        this.hzJ = getVoiceManager();
        if (this.hzJ != null) {
            this.hzJ.onResume(getPageContext());
        }
        if (this.lLB != null) {
            this.lLB.dki();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_ON_RESUME, getActivity()));
        if (TbadkCoreApplication.getKeepLiveSwitch(getApplicationContext())) {
            com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.16
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_KEEPLIVE_START_SERVICE, Boolean.FALSE));
                }
            }, 3000L);
        }
        n.bhU().bhV();
        if (com.baidu.tbadk.BdToken.q.aMU().aMX() != null && com.baidu.tbadk.BdToken.q.aMU().aNd() != null && com.baidu.tbadk.BdToken.q.aMU().aMX().getCurTaskType() == 6) {
            com.baidu.tbadk.BdToken.q.aMU().aNd().complete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.lLF = true;
        if (z) {
            com.baidu.tbadk.getUserInfo.b.bgs().bgt();
            djP();
            djQ();
        }
        this.lLB.switchNaviBarStatus(z);
        this.lLB.dkk();
        cDg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (this.lLv) {
            this.lLv = false;
            CompatibleUtile.setAnim(getPageContext().getPageActivity(), R.anim.down, R.anim.hold);
        }
        this.hzJ = getVoiceManager();
        if (this.hzJ != null) {
            this.hzJ.onPause(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOME_HIDE_GUIDE));
        if (this.lLJ != null) {
            this.lLJ.cfZ();
        }
        KuangFloatingViewController.getInstance().hideFloatingView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
        } catch (Exception e) {
        }
        bundle.putInt("locate_type", this.lLB.bZU().getCurrentTabType());
        bundle.putParcelable("android:fragments", null);
        bundle.putParcelable("android:support:fragments", null);
        this.hzJ = getVoiceManager();
        if (this.hzJ != null) {
            this.hzJ.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.hzJ = getVoiceManager();
        if (this.hzJ != null) {
            this.hzJ.onStop(getPageContext());
        }
        this.hyM = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        FragmentTabHost.b lm;
        int i = 2;
        super.onNewIntent(intent);
        setIntent(intent);
        String stringExtra = intent.getStringExtra(MainTabActivityConfig.TARGET_SCHEME);
        if (this.lLN.ak(intent)) {
            this.lLN.a(intent, this.lLB);
        } else {
            ab(intent);
        }
        if (StringUtils.isNull(stringExtra)) {
            com.baidu.tbadk.getUserInfo.b.bgs().bgt();
            if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_RESET_TABS));
                cDg();
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
                            i = this.lLG.bmp();
                        }
                    }
                    if (this.lLB != null || this.lLB.bZU() == null) {
                        intExtra = i;
                    } else {
                        this.lLB.setCurrentTabByType(i);
                        intExtra = i;
                    }
                }
                i = intExtra;
                if (this.lLB != null) {
                }
                intExtra = i;
            } else if ((intExtra == 17 || intExtra == 18 || intExtra == 19) && this.lLB != null && this.lLB.bZU() != null) {
                this.lLB.bZU().setCurrentTab(0);
            }
            if (this.lLB != null && this.lLB.bZU() != null && (lm = this.lLB.bZU().lm(intExtra)) != null && (lm.mContentFragment instanceof com.baidu.tbadk.core.g)) {
                ((com.baidu.tbadk.core.g) lm.mContentFragment).z(intent);
            }
            g(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
            if (this.lLB != null) {
                this.lLB.dki();
            }
        }
    }

    protected void ar(Activity activity) {
        new com.baidu.tbadk.core.dialog.a(activity).kS(R.string.confirm_title).hf(false).kT(R.string.background_process_permission).a(R.string.now_goto_setting, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.18
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                try {
                    MainTabActivity.this.startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
                    aVar.dismiss();
                } catch (Exception e) {
                    MainTabActivity.this.showToast(R.string.goto_developActivity_error_toast);
                }
            }
        }).b(R.string.next_time, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.17
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                MainTabActivity.this.djT();
            }
        }).b(com.baidu.adp.base.i.G(activity)).aUN();
    }

    protected void djT() {
        com.baidu.adp.lib.e.c.ln().d(getUniqueId());
        djV();
        try {
            moveTaskToBack(true);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, com.baidu.adp.base.h
    public void onPreLoad(t tVar) {
        super.onPreLoad(tVar);
        ae.a(tVar, getUniqueId());
        com.baidu.tbadk.core.util.f.d.a(tVar, getUniqueId(), this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!MainTabActivityConfig.IS_BACK_CLOSE_ALL_ACTIVITY && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
            if (runTask == null || !((Boolean) runTask.getData()).booleanValue()) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2016323, (Class) null);
                if (runTask2 == null || !((Boolean) runTask2.getData()).booleanValue()) {
                    if (this.hDL != null && this.hDL.isShowing()) {
                        this.hDL.vH(true);
                        return true;
                    } else if (this.lLB.cDk()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
                        return true;
                    } else {
                        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(2921405, Boolean.class, false);
                        if (runTask3 == null || runTask3.getData() == null || !(runTask3.getData() instanceof Boolean) || !((Boolean) runTask3.getData()).booleanValue()) {
                            if (System.currentTimeMillis() - this.lLz > 2000) {
                                showToast(R.string.double_back_quit);
                                this.lLz = System.currentTimeMillis();
                            } else if (UtilHelper.isBackgroundProcessLimitNone() && Build.VERSION.SDK_INT >= 14) {
                                ar(getPageContext().getPageActivity());
                                return true;
                            } else {
                                djT();
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
        int bmp;
        if (intent != null && this.lLB != null && this.lLB.bZU() != null) {
            try {
                if (intent.hasExtra("locate_type")) {
                    bmp = intent.getIntExtra("locate_type", 1);
                } else {
                    bmp = this.lLG.bmp();
                }
                this.lLB.bZU().setCurrentTabByType(bmp);
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

    private void cDx() {
        registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.19
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Integer) {
                    Integer num = (Integer) customResponsedMessage.getData();
                    if (num.intValue() == 2) {
                        MainTabActivity.this.lLB.uT(true);
                        MainTabActivity.this.lLB.qL(true);
                    } else if (num.intValue() == 1) {
                        MainTabActivity.this.lLB.uT(true);
                        MainTabActivity.this.lLB.qL(false);
                    } else {
                        MainTabActivity.this.lLB.uT(false);
                        MainTabActivity.this.lLB.qL(false);
                    }
                    MainTabActivity.this.lLB.dki();
                }
            }
        });
    }

    protected void djU() {
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
            if (this.lLB.bZU().getCurrentFragment() != null) {
                this.lLB.bZU().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 25046) {
            if (TbadkCoreApplication.isLogin()) {
                com.baidu.tbadk.BdToken.q.aMU().c(getPageContext());
            }
        } else if (i == 11001) {
            djU();
        } else if (i == 13003) {
            aj(intent);
        } else if (i == 23007) {
            S(intent);
        } else if (i == 13011) {
            com.baidu.tieba.o.a.cYy().G(getPageContext());
        } else if (i == 24007) {
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1) {
                com.baidu.tieba.o.a.cYy().G(getPageContext());
                ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                if (shareItem != null && shareItem.linkUrl != null && this.hRN != null) {
                    this.hRN.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.20
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void bcu() {
                        }

                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void a(final CustomDialogData customDialogData) {
                            com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.20.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a(MainTabActivity.this.getPageContext(), customDialogData).show();
                                }
                            }, 1000L);
                        }
                    });
                }
            }
        } else if (this.lLB.bZU().getCurrentFragment() != null) {
            this.lLB.bZU().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    private ShareFromPBMsgData cdD() {
        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.imageUri == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.imageUri.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.enE);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.fName);
        shareFromPBMsgData.setThreadId(shareItem.tid);
        return shareFromPBMsgData;
    }

    private void S(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(cdD(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.kW(1);
            aVar.aP(thread2GroupShareView);
            aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.21
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MainTabActivity.this.HidenSoftKeyPad((InputMethodManager) MainTabActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(MainTabActivity.this.getPageContext().getPageActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.bde() != null) {
                        Bundle bde = shareItem.bde();
                        TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ag("obj_source", 1).ag("obj_type", bde.getInt("obj_type")).ag("obj_param1", 3).dk("fid", bde.getString("fid")).dk("tid", bde.getString("tid")));
                    }
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.22
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MainTabActivity.this.HidenSoftKeyPad((InputMethodManager) MainTabActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.hg(true);
            aVar.b(getPageContext()).aUN();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.aH(shareFromPBMsgData.getImageUrl(), false);
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
        this.lLB.onChangeSkinType(i);
        adjustResizeForSoftInputOnSkinTypeChanged(i);
        if (this.hDL != null) {
            this.hDL.onChangeSkinType(i);
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
            if (this.lLB != null && !this.lLB.d(postWriteCallBackData)) {
                this.lLB.b(postWriteCallBackData);
            }
        }
    }

    private void djV() {
        if (System.currentTimeMillis() - this.lLA >= 7200000) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "start");
            hashMap.put(BdStatsConstant.StatsKey.UNAME, TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_CLEARTEMP, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
            this.lLA = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.a
    public int getCurrentTabType() {
        if (this.lLB.bZU() != null) {
            return this.lLB.bZU().getCurrentTabType();
        }
        return -1;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hzJ == null) {
            this.hzJ = VoiceManager.instance();
        }
        return this.hzJ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public ListView aYH() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aYI() {
        if (this.efk == null) {
            this.efk = UserIconBox.t(getPageContext().getPageActivity(), 8);
        }
        return this.efk;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> bXn() {
        if (this.lLE == null) {
            this.lLE = FrsCommonImageLayout.B(getPageContext().getPageActivity(), 12);
        }
        return this.lLE;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return new com.baidu.tbadk.m.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.24
            @Override // com.baidu.tbadk.m.b
            public boolean isCurrentPageCanBeAddToSourceTrace() {
                return true;
            }

            @Override // com.baidu.tbadk.m.b
            public int getMaxCost() {
                return com.baidu.tbadk.m.e.bhB().getMaxCostFromServer();
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
        if (this.lLF && currentPageSourceKeyList != null) {
            currentPageSourceKeyList.clear();
            this.lLF = false;
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
        if (this.lLB != null && this.lLB.bZU() != null) {
            Fragment currentFragment = this.lLB.bZU().getCurrentFragment();
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
        this.gsL = z;
        boolean z2 = this.lLL || this.gsL;
        if (this.lLB != null) {
            this.lLB.onKeyboardVisibilityChanged(z2);
        }
    }

    @Override // com.baidu.tbadk.core.util.f.c
    public boolean videoNeedPreload() {
        return ag.og(1);
    }

    @Override // com.baidu.tbadk.core.util.f.c
    public boolean isCyberVideoUsedThisPage() {
        return com.baidu.tbadk.a.b.uL("cyber_player_test") || com.baidu.tbadk.a.b.uK("cyber_player_test");
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            super.onConfigurationChanged(configuration);
            if (TbadkCoreApplication.getInst().getSkinType() != 1) {
                an.y(true, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djW() {
        String str = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_is_clear_concern_cache_when_version_update") + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + TbConfig.getVersion();
        if (!com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(str, false)) {
            try {
                com.baidu.tbadk.core.c.a.aUM().dc("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).setForever("0", null);
                com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(str, true);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    private boolean bnj() {
        return com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean("key_location_request_dialog_has_shown", false);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 22001) {
            MercatorModel.diV().startLoad();
        }
    }
}
