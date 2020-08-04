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
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.message.ExitAppMessage;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.af;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bd;
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
/* loaded from: classes16.dex */
public class MainTabActivity extends BaseFragmentActivity implements com.baidu.tbadk.core.util.f.b, UserIconBox.b, VoiceManager.c, FrsCommonImageLayout.c, com.baidu.tieba.tblauncher.a {
    private static boolean syncHasFinish;
    private WeakReference<Context> ajF;
    private com.baidu.adp.lib.d.b<TbImageView> elu;
    private com.baidu.tieba.ueg.d fwT;
    VoiceManager hFy;
    private com.baidu.tieba.NEGFeedBack.a hGo;
    private g hJJ;
    private ShareSuccessReplyToServerModel hXO;
    private CheckRealNameModel ksa;
    private bf lSQ;
    private d lST;
    private a lSU;
    private com.baidu.adp.lib.d.b<TbImageView> lSW;
    private com.baidu.tieba.b lSY;
    private FrameLayout lSZ;
    private c lTb;
    private com.baidu.tbadk.BdToken.d lTc;
    private e lTf;
    private String lTv;
    private com.baidu.tieba.ueg.b lhO;
    private boolean mTouchable;
    private boolean lSN = false;
    private int lSO = -1;
    private boolean lSP = false;
    private String mFrom = null;
    private volatile boolean mIsAdd = false;
    private long lSR = 0;
    private long lSS = 0;
    private long lSV = -1;
    private boolean lSX = false;
    private String lTa = "";
    boolean lTd = false;
    boolean gyi = false;
    boolean hEA = true;
    private int lTe = 16;
    private CustomMessageListener lTg = new CustomMessageListener(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && MainTabActivity.this.lST != null && TbadkCoreApplication.getInst().getCurrentActivity() == MainTabActivity.this) {
                MainTabActivity.this.lTd = com.baidu.adp.lib.f.b.toBoolean(customResponsedMessage.getData().toString(), false);
                MainTabActivity.this.lST.onKeyboardVisibilityChanged((MainTabActivity.this.lTd || MainTabActivity.this.gyi) ? true : true);
            }
        }
    };
    private final CustomMessageListener lTh = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_MATINTAB) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.12
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
                        MainTabActivity.this.lST.cds().changeStyle(1);
                    } else if (TbadkCoreApplication.getInst().isThemeIconCover()) {
                        MainTabActivity.this.lST.cds().changeStyle(2);
                    } else {
                        MainTabActivity.this.lST.cds().changeStyle(1);
                    }
                }
            }
        }
    };
    public CustomMessageListener lTi = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && MainTabActivity.this.lST != null && MainTabActivity.this.lST.cds() != null) {
                if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    MainTabActivity.this.lST.cds().getTabWrapper().animate().translationY(MainTabActivity.this.lST.cds().getTabWrapper().getHeight()).setDuration(200L).start();
                } else {
                    MainTabActivity.this.lST.cds().getTabWrapper().animate().translationY(0.0f).setDuration(400L).start();
                }
            }
        }
    };
    public CustomMessageListener lTj = new CustomMessageListener(2921452) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i) && com.baidu.tbadk.core.util.bf.checkUpIsLogin(MainTabActivity.this.getPageContext().getPageActivity())) {
                MainTabActivity.this.cdq();
            }
        }
    };
    private final com.baidu.adp.framework.listener.c jgf = new com.baidu.adp.framework.listener.c(1001) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ConfigVersion configVersion;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                if (socketResponsedMessage.getError() == 0 && (configVersion = responseOnlineMessage.getConfigVersion()) != null) {
                    MainTabActivity.this.Oi(configVersion.sync);
                }
            }
        }
    };
    private CustomMessageListener lTk = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_JUMP_PB) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.36
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
    private final CustomMessageListener lTl = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_INFO_CHANGED) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getData() instanceof PayMemberInfoData) {
                    MainTabActivity.this.a((PayMemberInfoData) customResponsedMessage.getData());
                    TbadkCoreApplication.getInst().setPaymemberInfo((PayMemberInfoData) customResponsedMessage.getData());
                }
                UserData bkf = com.baidu.tbadk.getUserInfo.b.bkd().bkf();
                if (TbadkCoreApplication.isLogin() && bkf != null && bkf.getUserId() != null && !bkf.getUserId().equals(MainTabActivity.this.lTa) && bkf.getIsGodInvited()) {
                    MainTabActivity.this.lTa = bkf.getUserId();
                    MainTabActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(MainTabActivity.this.getPageContext().getPageActivity(), "", TbWebViewActivityConfig.GOD_INVITE_JUMP_URL + "?page_type=open_full_screen_opacity_web_page", true)));
                }
                if (!com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean("key_new_god_invited_my_tab_red_tip_showed", false) && TbadkCoreApplication.isLogin() && bkf != null && bkf.getUserId() != null && !bkf.getUserId().equals(MainTabActivity.this.lTa) && bkf.getNewGodData() != null && bkf.getNewGodData().isNewGodInvited()) {
                    com.baidu.tieba.p.a.ddy().g(11, true, true);
                    TiebaStatic.log(new ap("c13688").t("uid", TbadkCoreApplication.getCurrentAccountId()).ah("obj_locate", 0));
                    com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean("key_new_god_invited_my_tab_red_tip_showed", true);
                }
            }
        }
    };
    private CustomMessageListener hGX = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && !((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                MainTabActivity.this.lST.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    final CustomMessageListener lTm = new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.tbadk.mainTab.b> list;
            MainTabActivity.this.mIsAdd = false;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (list = ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).getList()) != null && list.size() != 0) {
                MainTabActivity.this.lST.aJ(list);
                if (MainTabActivity.this.lSP) {
                    MainTabActivity.this.lST.cds().setCurrentTabByType(MainTabActivity.this.lSO);
                } else if (MainTabActivity.this.getActivity().getIntent() == null || MainTabActivity.this.getActivity().getIntent().getDataString() == null || !MainTabActivity.this.getActivity().getIntent().getDataString().startsWith("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                    MainTabActivity.this.aj(MainTabActivity.this.getIntent());
                } else {
                    MainTabActivity.this.lST.cds().setCurrentTabByType(2);
                }
                MainTabActivity.this.lSP = false;
                MainTabActivity.this.lST.dnt();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP, null));
            }
        }
    };
    final CustomMessageListener lTn = new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_REFRESH_TABS) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007013) {
                MainTabActivity.this.cGP();
                if (MainTabActivity.this.lST != null && MainTabActivity.this.lST.cds() != null) {
                    MainTabActivity.this.lSO = MainTabActivity.this.lST.cds().getCurrentTabType();
                }
                MainTabActivity.this.lSP = true;
            }
        }
    };
    final CustomMessageListener lTo = new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (MainTabActivity.this.lSQ != null || (customResponsedMessage.getData() instanceof bf)) {
                    if (customResponsedMessage.getData() != null) {
                        MainTabActivity.this.lSQ = (bf) customResponsedMessage.getData();
                    }
                    if (!MainTabActivity.this.mIsAdd && MainTabActivity.this.lSQ != null && TbadkCoreApplication.isLogin()) {
                        MainTabActivity.this.lTb.k(MainTabActivity.this.lSQ.recom_title, MainTabActivity.this.lSQ.recom_topic, MainTabActivity.this.lSQ.dQx);
                    }
                }
            }
        }
    };
    private final CustomMessageListener lTp = new CustomMessageListener(CmdConfigCustom.MAINTAB_SET_INST) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.e.b.aZG() == null) {
                b bVar = new b();
                bVar.a(MainTabActivity.this);
                com.baidu.tbadk.core.e.b.a(bVar);
            }
        }
    };
    private CustomMessageListener lTq = new CustomMessageListener(2921380) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && !as.isEmpty((String) customResponsedMessage.getData())) {
                String str = (String) customResponsedMessage.getData();
                if (KuangFloatingViewController.getInstance().init()) {
                    KuangFloatingViewController.getInstance().setInfo(str);
                    ((BaseFragmentActivity) MainTabActivity.this.getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.6.1
                        @Override // com.baidu.tbadk.core.e
                        public void onPermissionResult(boolean z) {
                            if (z) {
                                KuangFloatingViewController.getInstance().showFloatingView();
                                TiebaStatic.log(new ap("c12264").ah("obj_type", 3));
                            }
                        }
                    }, false);
                }
            }
        }
    };
    private h.a lTr = new h.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.7
        @Override // com.baidu.tieba.write.h.a
        public void FL(int i) {
            if (i == 4) {
                MainTabActivity.this.lST.dnq();
            }
        }
    };
    private CheckRealNameModel.a lTs = new CheckRealNameModel.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.11
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void b(int i, String str, String str2, Object obj) {
            if (CheckRealNameModel.TYPE_APP_FIRST_START.equals(str2) && i == 1990055) {
                TiebaStatic.log("c12138");
                MainTabActivity.this.lST.Ok(MainTabActivity.this.getResources().getString(R.string.check_real_name_message));
            }
        }
    };
    private CustomMessageListener dIL = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && l.isNetOk()) {
                MainTabActivity.this.dnd();
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
                MainTabActivity.this.lSX = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
                com.baidu.tbadk.core.sharedPref.b.aZP().remove(SharedPrefConfig.KEY_FEEDBACK_TIP);
                com.baidu.tbadk.core.sharedPref.b.aZP().remove(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW);
                com.baidu.tbadk.core.sharedPref.b.aZP().remove(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP));
                if (MainTabActivity.this.lTc != null) {
                    MainTabActivity.this.lTc.vC(UtilHelper.getClipBoardContent());
                }
                if (MainTabActivity.this.lST != null) {
                    MainTabActivity.this.lST.dny();
                }
                MainTabActivity.this.dnj();
            }
        }
    };
    private CustomMessageListener lTt = new CustomMessageListener(CmdConfigCustom.CMD_GAME_CENTER_INIT) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                p.dZy = ((Boolean) customResponsedMessage.getData()).booleanValue();
                MainTabActivity.this.dnc();
            }
        }
    };
    private final CustomMessageListener lTu = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.GAME_TIP_SHOW, booleanValue);
                MainTabActivity.this.lST.vy(booleanValue);
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
                if (MainTabActivity.this.lST != null && MainTabActivity.this.lST.dnu() != null && MainTabActivity.this.lST.dnu().getAnimationView() != null && MainTabActivity.this.lST.dnu().getAnimationView().getVisibility() != 0) {
                    MainTabActivity.this.lST.dnu().setLottieView(false);
                }
                if (!TbadkCoreApplication.getInst().getActivityPrizeData().isSwitchTurn()) {
                    if (MainTabActivity.this.lST != null) {
                        MainTabActivity.this.lST.Oj(null);
                    }
                } else {
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getInst().getActivityPrizeData().isUserSatisfy()) {
                        String h5Url = TbadkCoreApplication.getInst().getActivityPrizeData().getH5Url();
                        if (!StringUtils.isNull(h5Url) && com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.ACTIVITY_PRIZE_GET_TIP + TbadkCoreApplication.getCurrentAccount(), true)) {
                            bd.baV().a(MainTabActivity.this.getPageContext(), new String[]{h5Url}, true);
                            com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.ACTIVITY_PRIZE_GET_TIP + TbadkCoreApplication.getCurrentAccount(), false);
                        }
                    }
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                        if (MainTabActivity.this.lST != null) {
                            MainTabActivity.this.lST.Oj(null);
                        }
                    } else {
                        String myTabText = TbadkCoreApplication.getInst().getActivityPrizeData().getMyTabText();
                        if (!StringUtils.isNull(myTabText)) {
                            if (MainTabActivity.this.lST != null) {
                                MainTabActivity.this.lST.Oj(myTabText);
                            }
                        } else if (MainTabActivity.this.lST != null) {
                            MainTabActivity.this.lST.Oj(null);
                        }
                    }
                }
                if (TbSingleton.getInstance().canShowPermDialog()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921360, MainTabActivity.this));
                }
                com.baidu.tbadk.core.business.a.aTH().dd("1", "");
            }
        }
    };
    private CustomMessageListener lTw = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    MainTabActivity.this.lTv = UtilHelper.getCurrentDay();
                    com.baidu.tbadk.core.sharedPref.b.aZP().putLong("last_resume_time", TbSingleton.getInstance().getLastResumeTime());
                    return;
                }
                String currentDay = UtilHelper.getCurrentDay();
                if (!StringUtils.isNull(currentDay) && !currentDay.equals(MainTabActivity.this.lTv)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
                }
                if (MainTabActivity.this.lhO == null) {
                    MainTabActivity.this.lhO = new com.baidu.tieba.ueg.b();
                }
                MainTabActivity.this.lhO.Gj(MainTabActivity.this.lhO.mbc);
                MainTabActivity.this.lhO.mbc = aw.a.ebA;
            }
        }
    };
    private final CustomMessageListener jtD = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            k kVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof k) && (kVar = (k) customResponsedMessage.getData()) != null && !StringUtils.isNull(kVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(kVar);
                if (StringUtils.isNull(kVar.ezd)) {
                    bd.baV().b(MainTabActivity.this.getPageContext(), new String[]{kVar.mLink});
                } else {
                    bd.baV().b(MainTabActivity.this.getPageContext(), new String[]{kVar.mLink, kVar.ezd});
                }
            }
        }
    };
    private CustomMessageListener hHo = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (MainTabActivity.this.hJJ != null) {
                MainTabActivity.this.hJJ.bnY();
            }
        }
    };
    private Runnable lTx = new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.32
        @Override // java.lang.Runnable
        public void run() {
            if (TbSingleton.getInstance().getNewUserRedPackageData() != null) {
                MainTabActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewUserRedPackageActivityConfig(MainTabActivity.this, TbSingleton.getInstance().getNewUserRedPackageData())));
                TbSingleton.getInstance().setNewUserRedPackageData(null);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Oi(String str) {
        if (str != null && TbadkCoreApplication.getInst().getConfigVersion() != null && dnb()) {
            this.lSV = System.currentTimeMillis();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    private boolean dnb() {
        if (-1 == this.lSV) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.lSV;
        return currentTimeMillis <= 0 || currentTimeMillis >= 300000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnc() {
        if (SwitchManager.getInstance().findType(GameEnterSwitch.GAME_ENTER_KEY) == 1 && p.dZy) {
            this.lST.vw(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_CHECK_UPDATE));
            return;
        }
        this.lST.vw(false);
        this.lST.vy(false);
        com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.GAME_TIP_SHOW, false);
    }

    public void a(PayMemberInfoData payMemberInfoData) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && payMemberInfoData != null) {
            if ((payMemberInfoData.big() == 1 || payMemberInfoData.big() == 2) && com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.SHOW_MEMBER_DEID_LINE, true)) {
                long aUb = payMemberInfoData.aUb() * 1000;
                if (aUb < System.currentTimeMillis()) {
                    if (StringUtils.isNull(payMemberInfoData.bih())) {
                        payMemberInfoData.zn(getPageContext().getString(R.string.member));
                    } else {
                        payMemberInfoData.zn(payMemberInfoData.bih() + getPageContext().getString(R.string.member_already_Expire));
                    }
                    this.lST.a(payMemberInfoData, 0);
                } else if (aUb - System.currentTimeMillis() < Config.THREAD_IMAGE_SAVE_MAX_TIME) {
                    if (StringUtils.isNull(payMemberInfoData.bih())) {
                        payMemberInfoData.zn(getPageContext().getString(R.string.member));
                    } else {
                        payMemberInfoData.zn(payMemberInfoData.bih() + getPageContext().getString(R.string.member_will_Expire));
                    }
                    this.lST.a(payMemberInfoData, 1);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.mTouchable) {
            return false;
        }
        if (this.lST.cds() == null || this.lST.cds().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1 || !this.lST.cGT()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public void cdq() {
        if (this.lTb != null) {
            this.lTb.cjy();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
        if (this.hJJ == null) {
            if (com.baidu.tbadk.a.d.aRN()) {
                this.hJJ = new g(getPageContext(), this.lSZ, "main_tab", 3);
            } else {
                this.hJJ = new g(getPageContext(), this.lSZ, "main_tab", 2);
            }
            this.hJJ.PA("1");
        }
        this.hJJ.a(this.lTr);
        if (!this.fwT.doV() && this.lST.cds() != null && this.lST.cds().getFragmentTabWidget() != null) {
            if (!com.baidu.tbadk.a.d.aRN()) {
                this.lST.dnr();
            }
            this.hJJ.a(false, (View) this.lST.cds().getTabWrapper(), this.lST.cds().getFragmentTabWidget().getWriteView());
        }
    }

    protected void cGP() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ADD_FRAGMENT, new com.baidu.tbadk.mainTab.d(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        n.blF().dd(System.currentTimeMillis());
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
            this.lTf = new e(getPageContext());
            if (!this.lTf.al(getIntent())) {
                ac(getIntent());
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
        if (dne()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        setContentView(R.layout.maintabs_activity);
        this.lSZ = (FrameLayout) findViewById(R.id.maintabContainer);
        com.baidu.tbadk.core.a.a.aTw().reLoginByCacheAccount();
        this.lST = new d(this);
        this.lTb = new c(this);
        this.lST.vv(this.mIsLogin);
        dnc();
        cqv();
        com.baidu.tieba.tblauncher.alarmRemind.b.dnB().f(this);
        com.baidu.tbadk.BdToken.c.aQc().aQd();
        this.lSY = new com.baidu.tieba.b();
        cGP();
        cHg();
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (bundle != null) {
            i2 = bundle.getInt("locate_type", 1);
            intent.putExtra("locate_type", i2);
        }
        this.lTv = UtilHelper.getCurrentDay();
        this.lSV = System.currentTimeMillis();
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
        if (com.baidu.tbadk.core.util.ad.checkLocationForGoogle(getActivity())) {
            MercatorModel.dmf().startLoad();
        }
        registerListener(this.jgf);
        if (i2 == 1) {
            this.lST.vx(true);
        } else {
            this.lST.vx(false);
        }
        this.lST.dnw();
        this.hFy = getVoiceManager();
        if (this.hFy != null) {
            this.hFy.onCreate(getPageContext());
        }
        registerListener(this.mAccountChangedListener);
        adjustResizeForSoftInput();
        addGlobalLayoutListener();
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.MAINTAB_ONCREATE_END);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ONCREATE_END));
        if (TbadkCoreApplication.isLogin()) {
            n.blF().blG();
        }
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.getUserInfo.b.bkd().bke();
        }
        com.baidu.tbadk.core.sharedPref.b.aZP().putInt(SharedPrefConfig.APP_RESTART_TIMES, com.baidu.tbadk.core.sharedPref.b.aZP().getInt(SharedPrefConfig.APP_RESTART_TIMES, 0) + 1);
        this.ksa = new CheckRealNameModel(getPageContext());
        this.ksa.a(this.lTs);
        dnd();
        this.hGo = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "homepage");
        this.hXO = new ShareSuccessReplyToServerModel();
        this.fwT = new com.baidu.tieba.ueg.d(getPageContext());
        int i3 = com.baidu.tbadk.core.sharedPref.b.aZP().getInt("need_deal_diversion_jump", 2);
        if (i3 == 2) {
            com.baidu.tbadk.core.sharedPref.b.aZP().putInt("need_deal_diversion_jump", 1);
        } else if (i3 == 1) {
            com.baidu.tbadk.core.sharedPref.b.aZP().putInt("need_deal_diversion_jump", 0);
        }
        this.lTc = com.baidu.tbadk.BdToken.d.aQr();
        int loadInt = TbadkSettings.getInst().loadInt(SharedPrefConfig.PREFS_SKIN_TYPE, 0);
        if (loadInt != 1) {
            ao.z(false, true);
        } else {
            TbadkCoreApplication.getInst().setSkinTypeValue(loadInt);
            TbadkCoreApplication.getInst().SendSkinTypeBroadcast(loadInt);
        }
        if (TbSingleton.getInstance().isEnableBenchmark() && TbSingleton.getInstance().getCpuFlopsDuration() <= 0) {
            com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.10
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.tbadk.f.a.aSy();
                }
            }, 5000L);
        }
        MessageManager.getInstance().registerListener(this.jtD);
        TbSingleton.getInstance().startOneGame();
        this.ajF = new WeakReference<>(TbadkCoreApplication.getInst());
        if (getResources() != null && getResources().getConfiguration() != null) {
            this.lTe = getResources().getConfiguration().uiMode & 48;
        }
        com.baidu.m.c.fN(TbadkCoreApplication.getInst()).a(null);
        dnj();
        if (this.lTf.al(intent)) {
            this.lTf.a(getIntent(), this.lST);
        }
        com.baidu.adp.lib.f.e.lt().postDelayed(this.lTx, 200L);
        n.blF().de(System.currentTimeMillis());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public ViewGroup getActivityRootView() {
        return this.lSZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnd() {
        String str = SharedPrefConfig.CHECK_REAL_NAME + TbConfig.getVersion();
        if (com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(str, true) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && l.isNetOk()) {
            this.ksa.JE(CheckRealNameModel.TYPE_APP_FIRST_START);
            com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(str, false);
        }
    }

    private void ac(final Intent intent) {
        if (intent != null) {
            String dataString = intent.getDataString();
            UtilHelper.clearClipBoardBySchemaParam(dataString);
            if (!StringUtils.isNull(dataString) && dataString.startsWith("tbmaintab://")) {
                String decode = Uri.decode(intent.getData().getEncodedPath());
                if (StringUtils.isNull(decode)) {
                    TiebaStatic.log(new ap("c10320").ah("obj_type", 1).ah(TiebaInitialize.Params.OBJ_TO, 1));
                    return;
                }
                if (decode.startsWith("//")) {
                    decode = decode.substring(2);
                }
                Map<String, String> paramPair = bd.getParamPair(decode);
                if (paramPair != null) {
                    String str = paramPair.get("fr");
                    if (!"mpush".equals(str) && "bpush".equals(str)) {
                        ap apVar = new ap("c10320");
                        apVar.dn("obj_locate", paramPair.get("obj_locate"));
                        apVar.ah("obj_type", 1);
                        apVar.dn("obj_source", paramPair.get("obj_source"));
                        apVar.dn(TiebaInitialize.Params.OBJ_PARAM2, paramPair.get(TiebaInitialize.Params.OBJ_PARAM2));
                        apVar.ah(TiebaInitialize.Params.OBJ_TO, 1);
                        apVar.dn("obj_id", paramPair.get("bdid"));
                        if (!as.isEmpty(paramPair.get(LogConfig.LOG_EXT_LOG))) {
                            try {
                                JSONObject jSONObject = new JSONObject(paramPair.get(LogConfig.LOG_EXT_LOG));
                                Iterator<String> keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    apVar.dn(next, jSONObject.getString(next));
                                }
                            } catch (Exception e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        TiebaStatic.log(apVar);
                        HttpMessage httpMessage = new HttpMessage(1003393);
                        httpMessage.addParam("call_url", dataString);
                        MessageManager.getInstance().sendMessage(httpMessage);
                    }
                    com.baidu.tbadk.BdToken.c.aQc().setSchemaUp(true);
                } else {
                    return;
                }
            } else if (!StringUtils.isNull(dataString) && (dataString.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT) || dataString.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT_ZM) || dataString.startsWith("bdtiebalive://") || dataString.startsWith("tiebachushou://"))) {
                String dataString2 = intent.getDataString();
                if (!StringUtils.isNull(dataString2)) {
                    bd.baV().b(getPageContext(), new String[]{dataString2});
                    com.baidu.tbadk.BdToken.c.aQc().setSchemaUp(true);
                }
            } else if (!StringUtils.isNULL(dataString) && dataString.startsWith(com.baidu.tbadk.BdToken.f.dFL)) {
                com.baidu.tbadk.BdToken.f.aQv().a(intent.getData(), new f.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.14
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void B(HashMap<String, Object> hashMap) {
                        if (hashMap != null && intent != null) {
                            Object obj = hashMap.get(com.baidu.tbadk.BdToken.f.dGi);
                            int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : -1;
                            Object obj2 = hashMap.get(com.baidu.tbadk.BdToken.f.dGj);
                            String str2 = obj2 instanceof String ? (String) obj2 : null;
                            Object obj3 = hashMap.get(com.baidu.tbadk.BdToken.f.dGh);
                            String str3 = obj3 instanceof String ? (String) obj3 : null;
                            if (intValue != -1) {
                                intent.putExtra("is_from_scheme", true);
                                intent.putExtra("locate_type", intValue);
                                intent.putExtra("sub_locate_type", str2);
                                intent.putExtra("sub_tab_name", str3);
                                Object obj4 = hashMap.get(com.baidu.tbadk.BdToken.f.dGk);
                                String str4 = obj4 instanceof String ? (String) obj4 : null;
                                Object obj5 = hashMap.get(com.baidu.tbadk.BdToken.f.dGl);
                                String str5 = obj5 instanceof String ? (String) obj5 : null;
                                intent.putExtra(com.baidu.tbadk.BdToken.f.dGk, str4);
                                intent.putExtra(com.baidu.tbadk.BdToken.f.dGl, str5);
                            }
                            com.baidu.tbadk.BdToken.c.aQc().setSchemaUp(true);
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
                        bd.baV().b(MainTabActivity.this.getPageContext(), new String[]{stringExtra});
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
        this.hFy = getVoiceManager();
        if (this.hFy != null) {
            this.hFy.onStart(getPageContext());
        }
    }

    public boolean dne() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_SYNC, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_ACTIVE, null));
        cqw();
        com.baidu.tbadk.coreExtra.messageCenter.b.bfl().bfw();
        com.baidu.tbadk.coreExtra.messageCenter.b.bfl().bfr();
        com.baidu.tbadk.coreExtra.messageCenter.b.bfl().ih(false);
        MessageManager.getInstance().unRegisterListener(this.jtD);
        MessageManager.getInstance().unRegisterListener(this.lTq);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setDialogVisiable(false);
            this.mWaitingDialog = null;
        }
        dnf();
        if (this.lST != null) {
            this.lST.onDestroy();
        }
        if (this.lTb != null) {
            this.lTb.onDestroy();
        }
        try {
            super.onDestroy();
        } catch (Exception e) {
        }
        com.baidu.tbadk.core.e.b.a(null);
        KuangFloatingFrsCopyLinkViewController.getInstance().onDestory();
        this.hFy = getVoiceManager();
        if (this.hFy != null) {
            this.hFy.onDestory(getPageContext());
        }
        if (this.hJJ != null) {
            this.hJJ.onDestroy();
        }
        if (this.hGo != null) {
            this.hGo.onDestroy();
        }
        if (this.hXO != null) {
            this.hXO.cancelLoadData();
        }
        if (this.lhO != null) {
            this.lhO.onDestroy();
        }
        if (this.lST != null && this.lST.dnu() != null) {
            this.lST.dnu().onDestory();
        }
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.lTx);
        System.gc();
    }

    private void dnf() {
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

    private void cqv() {
        registerListener(this.lTh);
        this.lTm.setPriority(100);
        registerListener(this.lTm);
        registerListener(this.lTn);
        registerListener(this.lTo);
        registerListener(this.lTp);
        registerListener(this.lTt);
        registerListener(this.lTu);
        registerListener(this.lTl);
        registerListener(this.skinTypeChangeListener);
        registerListener(this.lTi);
        this.lSU = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.lSU, intentFilter);
        registerListener(this.hGX);
        registerListener(this.lTk);
        registerListener(this.mSyncFinishListener);
        registerListener(this.dIL);
        registerListener(this.lTw);
        this.lTg.setTag(getUniqueId());
        registerListener(this.lTg);
        registerListener(this.lTq);
        registerListener(this.hHo);
        registerListener(this.lTj);
    }

    private void cqw() {
        if (this.lSU != null) {
            unregisterReceiver(this.lSU);
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
        if (this.hEA) {
            ag.b(this.ajF);
            this.hEA = false;
        }
        if (this.lST != null && this.lST.dnu() != null) {
            this.lST.dnu().setLottieView(true);
        }
        if (this.lST != null && this.lST.cds() != null) {
            this.lSO = this.lST.cds().getCurrentTabType();
        }
        changeSkinType(this.mSkinType);
        KuangFloatingFrsCopyLinkViewController.getInstance().hideFloatingView(true);
        if (TbadkCoreApplication.isLogin() && n.blF().blD()) {
            n.blF().blG();
        }
        this.hFy = getVoiceManager();
        if (this.hFy != null) {
            this.hFy.onResume(getPageContext());
        }
        if (this.lST != null) {
            this.lST.dnw();
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
        n.blF().blG();
        if (com.baidu.tbadk.BdToken.q.aQI().aQL() != null && com.baidu.tbadk.BdToken.q.aQI().aQR() != null && com.baidu.tbadk.BdToken.q.aQI().aQL().getCurTaskType() == 6) {
            com.baidu.tbadk.BdToken.q.aQI().aQR().complete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.lSX = true;
        if (z) {
            com.baidu.tbadk.getUserInfo.b.bkd().bke();
            dnc();
            dnd();
        }
        this.lST.switchNaviBarStatus(z);
        this.lST.dny();
        cGP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (this.lSN) {
            this.lSN = false;
            CompatibleUtile.setAnim(getPageContext().getPageActivity(), R.anim.down, R.anim.hold);
        }
        this.hFy = getVoiceManager();
        if (this.hFy != null) {
            this.hFy.onPause(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOME_HIDE_GUIDE));
        if (this.lTb != null) {
            this.lTb.cjz();
        }
        KuangFloatingViewController.getInstance().hideFloatingView();
        KuangFloatingFrsCopyLinkViewController.getInstance().hideFloatingView(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
        } catch (Exception e) {
        }
        bundle.putInt("locate_type", this.lST.cds().getCurrentTabType());
        bundle.putParcelable("android:fragments", null);
        bundle.putParcelable("android:support:fragments", null);
        this.hFy = getVoiceManager();
        if (this.hFy != null) {
            this.hFy.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.hFy = getVoiceManager();
        if (this.hFy != null) {
            this.hFy.onStop(getPageContext());
        }
        this.hEA = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        FragmentTabHost.b lG;
        int i = 2;
        super.onNewIntent(intent);
        setIntent(intent);
        String stringExtra = intent.getStringExtra(MainTabActivityConfig.TARGET_SCHEME);
        if (this.lTf.al(intent)) {
            this.lTf.a(intent, this.lST);
        } else {
            ac(intent);
        }
        if (StringUtils.isNull(stringExtra)) {
            com.baidu.tbadk.getUserInfo.b.bkd().bke();
            if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_RESET_TABS));
                cGP();
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
                            i = this.lSY.bqk();
                        }
                    }
                    if (this.lST != null || this.lST.cds() == null) {
                        intExtra = i;
                    } else {
                        this.lST.setCurrentTabByType(i);
                        intExtra = i;
                    }
                }
                i = intExtra;
                if (this.lST != null) {
                }
                intExtra = i;
            } else if ((intExtra == 17 || intExtra == 18 || intExtra == 19) && this.lST != null && this.lST.cds() != null) {
                this.lST.cds().setCurrentTab(0);
            }
            if (this.lST != null && this.lST.cds() != null && (lG = this.lST.cds().lG(intExtra)) != null && (lG.mContentFragment instanceof com.baidu.tbadk.core.g)) {
                ((com.baidu.tbadk.core.g) lG.mContentFragment).z(intent);
            }
            g(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
            if (this.lST != null) {
                this.lST.dnw();
            }
        }
    }

    protected void as(Activity activity) {
        new com.baidu.tbadk.core.dialog.a(activity).lm(R.string.confirm_title).hJ(false).ln(R.string.background_process_permission).a(R.string.now_goto_setting, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.18
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
                MainTabActivity.this.dng();
            }
        }).b(com.baidu.adp.base.i.G(activity)).aYL();
    }

    protected void dng() {
        com.baidu.adp.lib.e.c.ln().d(getUniqueId());
        dni();
        try {
            moveTaskToBack(true);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, com.baidu.adp.base.h
    public void onPreLoad(t tVar) {
        super.onPreLoad(tVar);
        af.a(tVar, getUniqueId());
        com.baidu.tbadk.core.util.f.c.a(tVar, getUniqueId(), this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!MainTabActivityConfig.IS_BACK_CLOSE_ALL_ACTIVITY && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
            if (runTask == null || !((Boolean) runTask.getData()).booleanValue()) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2016323, (Class) null);
                if (runTask2 == null || !((Boolean) runTask2.getData()).booleanValue()) {
                    if (this.hJJ != null && this.hJJ.isShowing()) {
                        this.hJJ.wl(true);
                        return true;
                    } else if (this.lST.cGT()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
                        return true;
                    } else {
                        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(2921405, Boolean.class, false);
                        if (runTask3 == null || runTask3.getData() == null || !(runTask3.getData() instanceof Boolean) || !((Boolean) runTask3.getData()).booleanValue()) {
                            if (System.currentTimeMillis() - this.lSR > 2000) {
                                showToast(R.string.double_back_quit);
                                this.lSR = System.currentTimeMillis();
                            } else if (UtilHelper.isBackgroundProcessLimitNone() && Build.VERSION.SDK_INT >= 14) {
                                as(getPageContext().getPageActivity());
                                return true;
                            } else {
                                dng();
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
    public void aj(Intent intent) {
        int bqk;
        if (intent != null && this.lST != null && this.lST.cds() != null) {
            try {
                if (intent.hasExtra("locate_type")) {
                    bqk = intent.getIntExtra("locate_type", 1);
                } else {
                    bqk = this.lSY.bqk();
                }
                this.lST.cds().setCurrentTabByType(bqk);
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

    private void cHg() {
        registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.19
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Integer) {
                    Integer num = (Integer) customResponsedMessage.getData();
                    if (num.intValue() == 2) {
                        MainTabActivity.this.lST.vx(true);
                        MainTabActivity.this.lST.rq(true);
                    } else if (num.intValue() == 1) {
                        MainTabActivity.this.lST.vx(true);
                        MainTabActivity.this.lST.rq(false);
                    } else {
                        MainTabActivity.this.lST.vx(false);
                        MainTabActivity.this.lST.rq(false);
                    }
                    MainTabActivity.this.lST.dnw();
                }
            }
        });
    }

    protected void dnh() {
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
            if (this.lST.cds().getCurrentFragment() != null) {
                this.lST.cds().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 25046) {
            if (TbadkCoreApplication.isLogin()) {
                com.baidu.tbadk.BdToken.q.aQI().c(getPageContext());
            }
        } else if (i == 11001) {
            dnh();
        } else if (i == 13003) {
            ak(intent);
        } else if (i == 23007) {
            T(intent);
        } else if (i == 13011) {
            com.baidu.tieba.o.a.dbG().F(getPageContext());
        } else if (i == 24007) {
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1) {
                com.baidu.tieba.o.a.dbG().F(getPageContext());
                ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                if (shareItem != null && shareItem.linkUrl != null && this.hXO != null) {
                    this.hXO.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.20
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void bgn() {
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
        } else if (this.lST.cds().getCurrentFragment() != null) {
            this.lST.cds().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    private ShareFromPBMsgData chd() {
        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.imageUri == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.imageUri.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.etQ);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.fName);
        shareFromPBMsgData.setThreadId(shareItem.tid);
        return shareFromPBMsgData;
    }

    private void T(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(chd(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.lq(1);
            aVar.aV(thread2GroupShareView);
            aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.21
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MainTabActivity.this.HidenSoftKeyPad((InputMethodManager) MainTabActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(MainTabActivity.this.getPageContext().getPageActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.bgL() != null) {
                        Bundle bgL = shareItem.bgL();
                        TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ah("obj_source", 1).ah("obj_type", bgL.getInt("obj_type")).ah("obj_param1", 3).dn("fid", bgL.getString("fid")).dn("tid", bgL.getString("tid")));
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
            aVar.hK(true);
            aVar.b(getPageContext()).aYL();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.aF(shareFromPBMsgData.getImageUrl(), false);
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
        this.lST.onChangeSkinType(i);
        adjustResizeForSoftInputOnSkinTypeChanged(i);
        if (this.hJJ != null) {
            this.hJJ.onChangeSkinType(i);
        }
    }

    private void ak(Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        if (intent != null) {
            try {
                postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
            } catch (Exception e) {
                BdLog.e(e);
                postWriteCallBackData = null;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PERSONALIZED_MAINTAB_ON_RESULT, postWriteCallBackData));
            if (this.lST != null && !this.lST.d(postWriteCallBackData)) {
                this.lST.b(postWriteCallBackData);
            }
        }
    }

    private void dni() {
        if (System.currentTimeMillis() - this.lSS >= 7200000) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "start");
            hashMap.put(BdStatsConstant.StatsKey.UNAME, TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_CLEARTEMP, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
            this.lSS = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.a
    public int getCurrentTabType() {
        if (this.lST.cds() != null) {
            return this.lST.cds().getCurrentTabType();
        }
        return -1;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hFy == null) {
            this.hFy = VoiceManager.instance();
        }
        return this.hFy;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public ListView bcE() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> bcF() {
        if (this.elu == null) {
            this.elu = UserIconBox.t(getPageContext().getPageActivity(), 8);
        }
        return this.elu;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> caJ() {
        if (this.lSW == null) {
            this.lSW = FrsCommonImageLayout.B(getPageContext().getPageActivity(), 12);
        }
        return this.lSW;
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
                return com.baidu.tbadk.m.e.blm().getMaxCostFromServer();
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
        if (this.lSX && currentPageSourceKeyList != null) {
            currentPageSourceKeyList.clear();
            this.lSX = false;
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
        if (this.lST != null && this.lST.cds() != null) {
            Fragment currentFragment = this.lST.cds().getCurrentFragment();
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
        this.gyi = z;
        boolean z2 = this.lTd || this.gyi;
        if (this.lST != null) {
            this.lST.onKeyboardVisibilityChanged(z2);
        }
    }

    @Override // com.baidu.tbadk.core.util.f.b
    public boolean videoNeedPreload() {
        return ag.oz(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            super.onConfigurationChanged(configuration);
            if (TbadkCoreApplication.getInst().getSkinType() != 1) {
                ao.z(true, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnj() {
        String str = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_is_clear_concern_cache_when_version_update") + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + TbConfig.getVersion();
        if (!com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(str, false)) {
            try {
                com.baidu.tbadk.core.c.a.aYG().df("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).setForever("0", null);
                com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(str, true);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
