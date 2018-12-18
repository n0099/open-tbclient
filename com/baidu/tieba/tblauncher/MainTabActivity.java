package com.baidu.tieba.tblauncher;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.k;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BdToken.f;
import com.baidu.tbadk.KuangFloatingViewController;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.e;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.ExitAppMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.data.UserData;
import com.baidu.tbadk.data.i;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.l;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.e;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.Thread2GroupShareView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import protobuf.ConfigVersion;
/* loaded from: classes5.dex */
public class MainTabActivity extends BaseFragmentActivity implements com.baidu.tbadk.core.util.e.c, UserIconBox.b, VoiceManager.c, FrsCommonImageLayout.c, com.baidu.tieba.tblauncher.a {
    private static boolean hqP;
    private com.baidu.adp.lib.e.b<TbImageView> aKN;
    private CheckRealNameModel cuZ;
    private com.baidu.tieba.NEGFeedBack.a dIM;
    VoiceManager dIc;
    private com.baidu.tieba.write.c dLg;
    private com.baidu.tieba.ueg.c dLi;
    private ShareSuccessReplyToServerModel dXG;
    private com.baidu.tieba.ueg.b gHP;
    private as hqK;
    private d hqN;
    private a hqO;
    private com.baidu.adp.lib.e.b<TbImageView> hqR;
    private com.baidu.tieba.a hqT;
    private FrameLayout hqU;
    private c hqW;
    private com.baidu.tbadk.BdToken.d hqX;
    private String hrm;
    private boolean mTouchable;
    private boolean hqH = false;
    private int hqI = -1;
    private boolean hqJ = false;
    private String mFrom = null;
    private volatile boolean mIsAdd = false;
    private long hqL = 0;
    private long hqM = 0;
    private long hqQ = -1;
    private boolean hqS = false;
    private String hqV = "";
    boolean hqY = false;
    boolean cwc = false;
    private CustomMessageListener hqZ = new CustomMessageListener(2010045) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && MainTabActivity.this.hqN != null && TbadkCoreApplication.getInst().getCurrentActivity() == MainTabActivity.this) {
                MainTabActivity.this.hqY = com.baidu.adp.lib.g.b.g(customResponsedMessage.getData().toString(), false);
                MainTabActivity.this.hqN.onKeyboardVisibilityChanged((MainTabActivity.this.hqY || MainTabActivity.this.cwc) ? true : true);
            }
        }
    };
    private final CustomMessageListener hra = new CustomMessageListener(2001377) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001377) {
                MainTabActivity.this.finish();
            }
        }
    };
    private final CustomMessageListener skinTypeChangeListener = new CustomMessageListener(2001304) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                int oldSkinType = TbadkCoreApplication.getInst().getOldSkinType();
                if (!((intValue == 2 || oldSkinType == 2) ? false : true)) {
                    if ((intValue == 3 || intValue == 1 || intValue == 0) && oldSkinType == 2) {
                        MainTabActivity.this.hqN.aCo().dx(1);
                    } else if (TbadkCoreApplication.getInst().isThemeIconCover()) {
                        MainTabActivity.this.hqN.aCo().dx(2);
                    } else {
                        MainTabActivity.this.hqN.aCo().dx(1);
                    }
                }
            }
        }
    };
    public CustomMessageListener hrb = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && MainTabActivity.this.hqN != null && MainTabActivity.this.hqN.aCo() != null) {
                if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    MainTabActivity.this.hqN.aCo().getTabWrapper().animate().translationY(MainTabActivity.this.hqN.aCo().getTabWrapper().getHeight()).setDuration(200L).start();
                } else {
                    MainTabActivity.this.hqN.aCo().getTabWrapper().animate().translationY(0.0f).setDuration(400L).start();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c eVo = new com.baidu.adp.framework.listener.c(1001) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ConfigVersion configVersion;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                if (socketResponsedMessage.getError() == 0 && (configVersion = responseOnlineMessage.getConfigVersion()) != null) {
                    MainTabActivity.this.wd(configVersion.sync);
                }
            }
        }
    };
    private CustomMessageListener hrc = new CustomMessageListener(2001609) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                int indexOf = str.indexOf("?pid=");
                int indexOf2 = str.indexOf("&tid=");
                int indexOf3 = str.indexOf("&threadtype=");
                int indexOf4 = str.indexOf("&jump_type=");
                String substring = str.substring(indexOf + 5, indexOf2);
                String substring2 = str.substring(indexOf2 + 5, indexOf3);
                String substring3 = str.substring(indexOf3 + 12, indexOf4);
                String substring4 = str.substring(indexOf4 + 11, str.indexOf("&jump_tieba_native"));
                if (!StringUtils.isNull(substring3)) {
                    l.a(substring2, substring, substring4, new Integer(substring3).intValue(), MainTabActivity.this.getPageContext());
                }
            }
        }
    };
    private final CustomMessageListener hrd = new CustomMessageListener(2001247) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getData() instanceof PayMemberInfoData) {
                    MainTabActivity.this.a((PayMemberInfoData) customResponsedMessage.getData());
                    TbadkCoreApplication.getInst().setPaymemberInfo((PayMemberInfoData) customResponsedMessage.getData());
                }
                UserData Nn = com.baidu.tbadk.getUserInfo.b.Nl().Nn();
                if (TbadkCoreApplication.isLogin() && Nn != null && Nn.getUserId() != null && !Nn.getUserId().equals(MainTabActivity.this.hqV) && Nn.getIsGodInvited()) {
                    MainTabActivity.this.hqV = Nn.getUserId();
                    MainTabActivity.this.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(MainTabActivity.this.getPageContext().getPageActivity(), "", TbWebViewActivityConfig.GOD_INVITE_JUMP_URL + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE, true)));
                }
            }
        }
    };
    private CustomMessageListener dJi = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                MainTabActivity.this.hqN.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    final CustomMessageListener hre = new CustomMessageListener(2007002) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.tbadk.mainTab.b> list;
            MainTabActivity.this.mIsAdd = false;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (list = ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).getList()) != null && list.size() != 0) {
                MainTabActivity.this.hqN.ai(list);
                if (MainTabActivity.this.hqJ) {
                    MainTabActivity.this.hqN.aCo().setCurrentTabByType(MainTabActivity.this.hqI);
                } else {
                    MainTabActivity.this.ac(MainTabActivity.this.getIntent());
                }
                MainTabActivity.this.hqJ = false;
                MainTabActivity.this.hqN.bFH();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, null));
            }
        }
    };
    final CustomMessageListener hrf = new CustomMessageListener(2007013) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007013) {
                MainTabActivity.this.bdh();
                if (MainTabActivity.this.hqN != null && MainTabActivity.this.hqN.aCo() != null) {
                    MainTabActivity.this.hqI = MainTabActivity.this.hqN.aCo().getCurrentTabType();
                }
                MainTabActivity.this.hqJ = true;
            }
        }
    };
    final CustomMessageListener hrg = new CustomMessageListener(2921333) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (MainTabActivity.this.hqK != null || (customResponsedMessage.getData() instanceof as)) {
                    if (customResponsedMessage.getData() != null) {
                        MainTabActivity.this.hqK = (as) customResponsedMessage.getData();
                    }
                    if (!MainTabActivity.this.mIsAdd && MainTabActivity.this.hqK != null && TbadkCoreApplication.isLogin()) {
                        MainTabActivity.this.hqW.d(MainTabActivity.this.hqK.recom_title, MainTabActivity.this.hqK.recom_topic, MainTabActivity.this.hqK.asG);
                    }
                }
            }
        }
    };
    private final CustomMessageListener hrh = new CustomMessageListener(2007005) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.e.b.Cr() == null) {
                b bVar = new b();
                bVar.a(MainTabActivity.this);
                com.baidu.tbadk.core.e.b.a(bVar);
            }
        }
    };
    private CustomMessageListener hri = new CustomMessageListener(2921380) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && !ao.isEmpty((String) customResponsedMessage.getData())) {
                String str = (String) customResponsedMessage.getData();
                if (KuangFloatingViewController.getInstance().init()) {
                    KuangFloatingViewController.getInstance().setInfo(str);
                    ((BaseFragmentActivity) MainTabActivity.this.getPageContext().getOrignalPage()).grantWindowPermission(new e() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.5.1
                        @Override // com.baidu.tbadk.core.e
                        public void aV(boolean z) {
                            if (z) {
                                KuangFloatingViewController.getInstance().showFloatingView();
                                TiebaStatic.log(new am("c12264").x("obj_type", 3));
                            }
                        }
                    });
                }
            }
        }
    };
    private CheckRealNameModel.a hrj = new CheckRealNameModel.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.8
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            if (CheckRealNameModel.TYPE_APP_FIRST_START.equals(str2) && i == 1990055) {
                TiebaStatic.log("c12138");
                MainTabActivity.this.hqN.wf(MainTabActivity.this.getResources().getString(e.j.check_real_name_message));
            }
        }
    };
    private CustomMessageListener amp = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && com.baidu.adp.lib.util.l.ll()) {
                MainTabActivity.this.akO();
                if (!MainTabActivity.hqP) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
                }
            }
        }
    };
    private CustomMessageListener bQv = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                MainTabActivity.this.hqS = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
                com.baidu.tbadk.core.sharedPref.b.getInstance().remove("key_feedback_tip");
                com.baidu.tbadk.core.sharedPref.b.getInstance().remove("key_feedback_tip_show");
                com.baidu.tbadk.core.sharedPref.b.getInstance().remove("key_feedback_tip_tab_show");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016560));
                if (MainTabActivity.this.hqX != null) {
                    MainTabActivity.this.hqX.check();
                }
            }
        }
    };
    private CustomMessageListener hrk = new CustomMessageListener(2016509) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                n.aAe = ((Boolean) customResponsedMessage.getData()).booleanValue();
                MainTabActivity.this.bFu();
            }
        }
    };
    private final CustomMessageListener hrl = new CustomMessageListener(2001230) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", booleanValue);
                MainTabActivity.this.hqN.nI(booleanValue);
            }
        }
    };
    private CustomMessageListener deM = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.24
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                boolean unused = MainTabActivity.hqP = true;
                if (MainTabActivity.this.hqN != null && MainTabActivity.this.hqN.bFI() != null && MainTabActivity.this.hqN.bFI().getAnimationView() != null && MainTabActivity.this.hqN.bFI().getAnimationView().getVisibility() != 0) {
                    MainTabActivity.this.hqN.bFI().setLottieView(false);
                }
                if (!TbadkCoreApplication.getInst().getActivityPrizeData().Gh()) {
                    if (MainTabActivity.this.hqN != null) {
                        MainTabActivity.this.hqN.we(null);
                    }
                } else {
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getInst().getActivityPrizeData().Gl()) {
                        String Gk = TbadkCoreApplication.getInst().getActivityPrizeData().Gk();
                        if (!StringUtils.isNull(Gk) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("activity_prize_get_tip" + TbadkCoreApplication.getCurrentAccount(), true)) {
                            ay.Ef().a(MainTabActivity.this.getPageContext(), new String[]{Gk}, true);
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("activity_prize_get_tip" + TbadkCoreApplication.getCurrentAccount(), false);
                        }
                    }
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                        if (MainTabActivity.this.hqN != null) {
                            MainTabActivity.this.hqN.we(null);
                        }
                    } else {
                        String Gn = TbadkCoreApplication.getInst().getActivityPrizeData().Gn();
                        if (!StringUtils.isNull(Gn)) {
                            if (MainTabActivity.this.hqN != null) {
                                MainTabActivity.this.hqN.we(Gn);
                            }
                        } else if (MainTabActivity.this.hqN != null) {
                            MainTabActivity.this.hqN.we(null);
                        }
                    }
                }
                if (TbSingleton.getInstance().canShowPermDialog()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921360, MainTabActivity.this));
                }
            }
        }
    };
    private CustomMessageListener hrn = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    MainTabActivity.this.hrm = UtilHelper.getCurrentDay();
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("last_resume_time", TbSingleton.getInstance().getLastResumeTime());
                    return;
                }
                String currentDay = UtilHelper.getCurrentDay();
                if (!StringUtils.isNull(currentDay) && !currentDay.equals(MainTabActivity.this.hrm)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
                }
                if (MainTabActivity.this.gHP == null) {
                    MainTabActivity.this.gHP = new com.baidu.tieba.ueg.b();
                }
                MainTabActivity.this.gHP.wh(MainTabActivity.this.gHP.hyZ);
                MainTabActivity.this.gHP.hyZ = as.a.aCS;
            }
        }
    };
    private final CustomMessageListener gGc = new CustomMessageListener(2016493) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.26
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            i iVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i) && (iVar = (i) customResponsedMessage.getData()) != null && !StringUtils.isNull(iVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(iVar);
                if (StringUtils.isNull(iVar.aXm)) {
                    ay.Ef().c(MainTabActivity.this.getPageContext(), new String[]{iVar.mLink});
                } else {
                    ay.Ef().c(MainTabActivity.this.getPageContext(), new String[]{iVar.mLink, iVar.aXm});
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void wd(String str) {
        if (str != null && TbadkCoreApplication.getInst().getConfigVersion() != null && bFt()) {
            this.hqQ = System.currentTimeMillis();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
        }
    }

    private boolean bFt() {
        if (-1 == this.hqQ) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.hqQ;
        return currentTimeMillis <= 0 || currentTimeMillis >= ReportUserInfoModel.TIME_INTERVAL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFu() {
        if (com.baidu.adp.lib.b.d.iQ().aO("android_game_enter_switch") == 1 && n.aAe) {
            this.hqN.nG(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016510));
            return;
        }
        this.hqN.nG(false);
        this.hqN.nI(false);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
    }

    public void a(PayMemberInfoData payMemberInfoData) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && payMemberInfoData != null) {
            if ((payMemberInfoData.Ly() == 1 || payMemberInfoData.Ly() == 2) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_member_deid_line", true)) {
                long xZ = payMemberInfoData.xZ() * 1000;
                if (xZ < System.currentTimeMillis()) {
                    if (StringUtils.isNull(payMemberInfoData.Lz())) {
                        payMemberInfoData.hs(getPageContext().getString(e.j.member));
                    } else {
                        payMemberInfoData.hs(payMemberInfoData.Lz() + getPageContext().getString(e.j.member_already_Expire));
                    }
                    this.hqN.a(payMemberInfoData, 0);
                } else if (xZ - System.currentTimeMillis() < 259200000) {
                    if (StringUtils.isNull(payMemberInfoData.Lz())) {
                        payMemberInfoData.hs(getPageContext().getString(e.j.member));
                    } else {
                        payMemberInfoData.hs(payMemberInfoData.Lz() + getPageContext().getString(e.j.member_will_Expire));
                    }
                    this.hqN.a(payMemberInfoData, 1);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.mTouchable) {
            return false;
        }
        if (this.hqN.aCo() == null || this.hqN.aCo().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1 || !this.hqN.bdl()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public void aCk() {
        if (this.hqW != null) {
            this.hqW.aHz();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
        if (this.dLg == null) {
            this.dLg = new com.baidu.tieba.write.c(getPageContext(), this.hqU, "main_tab");
            this.dLg.xt("1");
        }
        if (!this.dLi.bHq()) {
            this.dLg.os(false);
        }
    }

    protected void bdh() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007002, new com.baidu.tbadk.mainTab.d(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.baidu.tbadk.l.n.Pp().aE(System.currentTimeMillis());
        if (TbadkCoreApplication.getInst().getIsFirstUse()) {
            x.a(new w<Object>() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.6
                @Override // com.baidu.tbadk.util.w
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
            U(getIntent());
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
        if (bFv()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        setContentView(e.h.maintabs_activity);
        this.hqU = (FrameLayout) findViewById(e.g.maintabContainer);
        com.baidu.tbadk.core.a.a.xJ().xK();
        this.hqN = new d(this);
        this.hqW = new c(this);
        this.hqN.nF(this.mIsLogin);
        bFu();
        aNJ();
        com.baidu.tieba.tblauncher.alarmRemind.b.bFN().e(this);
        this.hqT = new com.baidu.tieba.a();
        bdh();
        bdE();
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (bundle != null) {
            i2 = bundle.getInt("locate_type", 1);
            intent.putExtra("locate_type", i2);
        }
        this.hrm = UtilHelper.getCurrentDay();
        this.hqQ = System.currentTimeMillis();
        MessageManager.getInstance().sendMessage(new CustomMessage(2921359));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
        if (TbadkCoreApplication.getFrom() != null && TbadkCoreApplication.getFrom().equals("aishide")) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005011, null));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005013, null));
        MessageManager.getInstance().registerStickyMode(2001404);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001404));
        i(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        com.baidu.tbadk.browser.a.br(getPageContext().getPageActivity());
        String installOtherApp = TbadkCoreApplication.getInst().getInstallOtherApp();
        if (installOtherApp != null && installOtherApp.length() > 0) {
            UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), installOtherApp);
            TbadkCoreApplication.getInst().setInstallOtherApp(null);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.7
            @Override // java.lang.Runnable
            public void run() {
                MainTabActivity.this.mTouchable = true;
            }
        });
        registerListener(this.eVo);
        if (i2 == 1) {
            this.hqN.nH(true);
        } else {
            this.hqN.nH(false);
        }
        this.hqN.bFJ();
        this.dIc = getVoiceManager();
        if (this.dIc != null) {
            this.dIc.onCreate(getPageContext());
        }
        registerListener(this.bQv);
        adjustResizeForSoftInput();
        addGlobalLayoutListener();
        MessageManager.getInstance().registerStickyMode(2007015);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007015));
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.l.n.Pp().Pq();
        }
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.getUserInfo.b.Nl().Nm();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016480));
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("app_restart_times", com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("app_restart_times", 0) + 1);
        this.cuZ = new CheckRealNameModel(getPageContext());
        this.cuZ.a(this.hrj);
        akO();
        this.dIM = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "homepage");
        this.dXG = new ShareSuccessReplyToServerModel();
        this.dLi = new com.baidu.tieba.ueg.c(getPageContext());
        this.hqX = com.baidu.tbadk.BdToken.d.vz();
        TbadkCoreApplication.getInst().SendSkinTypeBroadcast(TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tbadk.l.n.Pp().aF(System.currentTimeMillis());
        MessageManager.getInstance().registerListener(this.gGc);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public ViewGroup getActivityRootView() {
        return this.hqU;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && this.hqX != null) {
            this.hqX.check();
            this.hqX.vA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akO() {
        String str = "check_real_name" + TbConfig.getVersion();
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(str, true) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && com.baidu.adp.lib.util.l.ll()) {
            this.cuZ.rS(CheckRealNameModel.TYPE_APP_FIRST_START);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(str, false);
        }
    }

    private void U(Intent intent) {
        if (intent != null) {
            String dataString = intent.getDataString();
            if (!StringUtils.isNull(dataString) && dataString.startsWith("tbmaintab://")) {
                String decode = Uri.decode(intent.getData().getEncodedPath());
                if (StringUtils.isNull(decode)) {
                    TiebaStatic.log(new am("c10320").x("obj_type", 1).x("obj_to", 1));
                    return;
                }
                if (decode.startsWith("//")) {
                    decode = decode.substring(2);
                }
                Map<String, String> fN = ay.fN(decode);
                if (fN != null) {
                    String str = fN.get("fr");
                    if (!"mpush".equals(str) && "bpush".equals(str)) {
                        am amVar = new am("c10320");
                        amVar.aA("obj_locate", fN.get("obj_locate"));
                        amVar.x("obj_type", 1);
                        amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, fN.get(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
                        amVar.aA("obj_param2", fN.get("obj_param2"));
                        amVar.x("obj_to", 1);
                        amVar.aA(VideoPlayActivityConfig.OBJ_ID, fN.get("bdid"));
                        if (!ao.isEmpty(fN.get("ext_log"))) {
                            try {
                                JSONObject jSONObject = new JSONObject(fN.get("ext_log"));
                                Iterator<String> keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    amVar.aA(next, jSONObject.getString(next));
                                }
                            } catch (Exception e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        TiebaStatic.log(amVar);
                        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SCHEMA_UPLOAD);
                        httpMessage.addParam("call_url", dataString);
                        MessageManager.getInstance().sendMessage(httpMessage);
                    }
                }
            } else if (!StringUtils.isNull(dataString) && (dataString.startsWith("tbclient://") || dataString.startsWith("tbclient_zm://"))) {
                String dataString2 = intent.getDataString();
                if (!StringUtils.isNull(dataString2)) {
                    ay.Ef().c(getPageContext(), new String[]{dataString2});
                }
            } else if (!StringUtils.isNULL(dataString) && dataString.startsWith(f.SCHEME)) {
                f.vF().a(intent.getData(), new f.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.10
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void n(HashMap<String, Object> hashMap) {
                        int intValue = (hashMap == null || !(hashMap.get(f.akV) instanceof Integer)) ? -1 : ((Integer) hashMap.get(f.akV)).intValue();
                        if (intValue != -1 && MainTabActivity.this.getIntent() != null) {
                            MainTabActivity.this.getIntent().putExtra("is_from_scheme", true);
                            MainTabActivity.this.getIntent().putExtra("locate_type", intValue);
                        }
                    }
                });
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
        this.dIc = getVoiceManager();
        if (this.dIc != null) {
            this.dIc.onStart(getPageContext());
        }
    }

    public boolean bFv() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005010, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005012, null));
        aNK();
        com.baidu.tbadk.coreExtra.messageCenter.a.HP().Ib();
        com.baidu.tbadk.coreExtra.messageCenter.a.HP().HV();
        com.baidu.tbadk.coreExtra.messageCenter.a.HP().bP(false);
        MessageManager.getInstance().unRegisterListener(this.gGc);
        MessageManager.getInstance().unRegisterListener(this.hri);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.bA(false);
            this.mWaitingDialog = null;
        }
        bFw();
        if (this.hqN != null) {
            this.hqN.onDestroy();
        }
        if (this.hqW != null) {
            this.hqW.onDestroy();
        }
        try {
            super.onDestroy();
        } catch (Exception e) {
        }
        com.baidu.tbadk.core.e.b.a(null);
        this.dIc = getVoiceManager();
        if (this.dIc != null) {
            this.dIc.onDestory(getPageContext());
        }
        if (this.dLg != null) {
            this.dLg.onDestroy();
        }
        if (this.dIM != null) {
            this.dIM.onDestroy();
        }
        if (this.dXG != null) {
            this.dXG.cancelLoadData();
        }
        if (this.gHP != null) {
            this.gHP.onDestroy();
        }
        if (this.hqN != null && this.hqN.bFI() != null) {
            this.hqN.bFI().onDestory();
        }
        System.gc();
    }

    private void bFw() {
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

    private void aNJ() {
        registerListener(this.hra);
        this.hre.setPriority(100);
        registerListener(this.hre);
        registerListener(this.hrf);
        registerListener(this.hrg);
        registerListener(this.hrh);
        registerListener(this.hrk);
        registerListener(this.hrl);
        registerListener(this.hrd);
        registerListener(this.skinTypeChangeListener);
        registerListener(this.hrb);
        registerListener(this.amp);
        this.hqO = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.hqO, intentFilter);
        registerListener(this.dJi);
        registerListener(this.hrc);
        registerListener(this.deM);
        registerListener(this.amp);
        registerListener(this.hrn);
        this.hqZ.setTag(getUniqueId());
        registerListener(this.hqZ);
        registerListener(this.hri);
    }

    private void aNK() {
        if (this.hqO != null) {
            unregisterReceiver(this.hqO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
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
        if (this.hqN != null && this.hqN.bFI() != null) {
            this.hqN.bFI().setLottieView(true);
        }
        if (this.hqN != null && this.hqN.aCo() != null) {
            this.hqI = this.hqN.aCo().getCurrentTabType();
        }
        changeSkinType(this.mSkinType);
        if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.l.n.Pp().Po()) {
            com.baidu.tbadk.l.n.Pp().Pq();
        }
        this.dIc = getVoiceManager();
        if (this.dIc != null) {
            this.dIc.onResume(getPageContext());
        }
        this.hqN.bFJ();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001385, getActivity()));
        if (TbadkCoreApplication.getKeepLiveSwitch(getApplicationContext())) {
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.11
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921300, Boolean.FALSE));
                }
            }, 3000L);
        }
        com.baidu.tbadk.l.n.Pp().Pq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.hqS = true;
        if (z) {
            com.baidu.tbadk.getUserInfo.b.Nl().Nm();
            bFu();
            akO();
        }
        this.hqN.switchNaviBarStatus(z);
        bdh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (this.hqH) {
            this.hqH = false;
            CompatibleUtile.setAnim(getPageContext().getPageActivity(), e.a.down, e.a.hold);
        }
        this.dIc = getVoiceManager();
        if (this.dIc != null) {
            this.dIc.onPause(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921003));
        if (this.hqW != null) {
            this.hqW.aHA();
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
        bundle.putInt("locate_type", this.hqN.aCo().getCurrentTabType());
        bundle.putParcelable("android:fragments", null);
        bundle.putParcelable("android:support:fragments", null);
        this.dIc = getVoiceManager();
        if (this.dIc != null) {
            this.dIc.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.dIc = getVoiceManager();
        if (this.dIc != null) {
            this.dIc.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        U(intent);
        com.baidu.tbadk.getUserInfo.b.Nl().Nm();
        if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007008));
            bdh();
        }
        this.mFrom = intent.getStringExtra("from");
        int intExtra = intent.getIntExtra("locate_type", 1);
        boolean booleanExtra = intent.getBooleanExtra("is_from_scheme", false);
        if (intExtra == 200) {
            finish();
        } else if (intExtra == 11) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), true)));
            finish();
        } else if (intExtra == 12) {
            TbadkCoreApplication.getInst().notifyAppEnterBackground();
            finish();
        } else if (intExtra == 1 || intExtra == 3 || intExtra == 2 || intExtra == 4 || intExtra == 8 || intExtra == 15) {
            if (intExtra != 8 && intExtra != 3 && intExtra != 15 && !booleanExtra) {
                intExtra = this.hqT.TD();
            }
            if (this.hqN != null && this.hqN.aCo() != null) {
                this.hqN.aCo().setCurrentTabByType(intExtra);
            }
        }
        i(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        this.hqN.bFJ();
    }

    protected void S(Activity activity) {
        new com.baidu.tbadk.core.dialog.a(activity).da(e.j.confirm_title).bf(false).db(e.j.background_process_permission).a(e.j.now_goto_setting, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.14
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                try {
                    MainTabActivity.this.startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
                    aVar.dismiss();
                } catch (Exception e) {
                    MainTabActivity.this.showToast(e.j.goto_developActivity_error_toast);
                }
            }
        }).b(e.j.next_time, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.13
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                MainTabActivity.this.bFx();
            }
        }).b(com.baidu.adp.base.i.aK(activity)).BF();
    }

    protected void bFx() {
        com.baidu.adp.lib.f.c.jA().d(getUniqueId());
        bFz();
        try {
            moveTaskToBack(true);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, com.baidu.adp.base.h
    public void onPreLoad(k kVar) {
        super.onPreLoad(kVar);
        ad.a(kVar, getUniqueId());
        com.baidu.tbadk.core.util.e.d.a(kVar, getUniqueId(), this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!MainTabActivityConfig.IS_BACK_CLOSE_ALL_ACTIVITY && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016322, (Class) null);
            if (runTask == null || !((Boolean) runTask.getData()).booleanValue()) {
                if (this.dLg != null && this.dLg.isShowing()) {
                    this.dLg.aCq();
                    return true;
                } else if (this.hqN.bdl()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007010));
                    return true;
                } else {
                    if (System.currentTimeMillis() - this.hqL > SystemScreenshotManager.DELAY_TIME) {
                        showToast(e.j.double_back_quit);
                        this.hqL = System.currentTimeMillis();
                    } else if (UtilHelper.isBackgroundProcessLimitNone() && Build.VERSION.SDK_INT >= 14) {
                        S(getPageContext().getPageActivity());
                        return true;
                    } else {
                        bFx();
                    }
                    return false;
                }
            }
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(Intent intent) {
        int TD;
        try {
            if (intent.getBooleanExtra("is_from_scheme", false)) {
                TD = intent.getIntExtra("locate_type", 1);
            } else {
                TD = this.hqT.TD();
            }
            this.hqN.aCo().setCurrentTabByType(TD);
        } catch (Throwable th) {
            finish();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        try {
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

    private void bdE() {
        registerListener(new CustomMessageListener(2007009) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Integer) {
                    Integer num = (Integer) customResponsedMessage.getData();
                    if (num.intValue() == 2) {
                        MainTabActivity.this.hqN.nH(true);
                        MainTabActivity.this.hqN.jT(true);
                    } else if (num.intValue() == 1) {
                        MainTabActivity.this.hqN.nH(true);
                        MainTabActivity.this.hqN.jT(false);
                    } else {
                        MainTabActivity.this.hqN.nH(false);
                        MainTabActivity.this.hqN.jT(false);
                    }
                    MainTabActivity.this.hqN.bFJ();
                }
            }
        });
    }

    protected void bFy() {
        AntiData antiData = new AntiData();
        antiData.setIfpost(1);
        if (antiData.getIfpost() == 0) {
            com.baidu.adp.lib.util.l.showToast(getPageContext().getPageActivity(), antiData.getForbid_info());
            return;
        }
        antiData.setIfVoice(false);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteActivityConfig(getPageContext().getPageActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, antiData, 13003, true, false, null, false, false, null, null, null, 0)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 != -1) {
            if (this.hqN.aCo().getCurrentFragment() != null) {
                this.hqN.aCo().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 11001) {
            bFy();
        } else if (i == 13003) {
            ad(intent);
        } else if (i == 23007) {
            N(intent);
        } else if (i == 13011) {
            com.baidu.tieba.n.a.bug().x(getPageContext());
        } else if (i == 24007) {
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1) {
                com.baidu.tieba.n.a.bug().x(getPageContext());
                com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                if (shareItem != null && shareItem.linkUrl != null && this.dXG != null) {
                    this.dXG.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.16
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void IY() {
                        }

                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void a(final CustomDialogData customDialogData) {
                            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.16.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a(MainTabActivity.this.getPageContext(), customDialogData).show();
                                }
                            }, 1000L);
                        }
                    });
                }
            }
        } else if (this.hqN.aCo().getCurrentFragment() != null) {
            this.hqN.aCo().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    private ShareFromPBMsgData aGf() {
        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
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

    private void N(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(aGf(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.dd(1);
            aVar.G(thread2GroupShareView);
            aVar.a(e.j.share, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.17
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MainTabActivity.this.HidenSoftKeyPad((InputMethodManager) MainTabActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(MainTabActivity.this.getPageContext().getPageActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.Kg() != null) {
                        Bundle Kg = shareItem.Kg();
                        TiebaStatic.log(new am("share_success").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).x("obj_type", Kg.getInt("obj_type")).x("obj_param1", 3).aA(ImageViewerConfig.FORUM_ID, Kg.getString(ImageViewerConfig.FORUM_ID)).aA("tid", Kg.getString("tid")));
                    }
                }
            });
            aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.18
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MainTabActivity.this.HidenSoftKeyPad((InputMethodManager) MainTabActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.bg(true);
            aVar.b(getPageContext()).BF();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.N(shareFromPBMsgData.getImageUrl(), false);
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
        this.hqN.onChangeSkinType(i);
        adjustResizeForSoftInputOnSkinTypeChanged(i);
        if (this.dLg != null) {
            this.dLg.onChangeSkinType();
        }
    }

    private void ad(Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        if (intent != null) {
            try {
                postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
            } catch (Exception e) {
                BdLog.e(e);
                postWriteCallBackData = null;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921030, postWriteCallBackData));
            if (this.hqN != null && !this.hqN.d(postWriteCallBackData)) {
                this.hqN.b(postWriteCallBackData);
            }
        }
    }

    private void bFz() {
        if (System.currentTimeMillis() - this.hqM >= 7200000) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage(2006002, hashMap));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005013, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            this.hqM = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.a
    public int getCurrentTabType() {
        if (this.hqN.aCo() != null) {
            return this.hqN.aCo().getCurrentTabType();
        }
        return -1;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dIc == null) {
            this.dIc = VoiceManager.instance();
        }
        return this.dIc;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public ListView Fu() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Fv() {
        if (this.aKN == null) {
            this.aKN = UserIconBox.l(getPageContext().getPageActivity(), 8);
        }
        return this.aKN;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> aAg() {
        if (this.hqR == null) {
            this.hqR = FrsCommonImageLayout.s(getPageContext().getPageActivity(), 12);
        }
        return this.hqR;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.19
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean OM() {
                return true;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int ON() {
                return com.baidu.tbadk.pageStayDuration.e.OR().OT();
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean a(com.baidu.tbadk.pageStayDuration.d dVar) {
                return false;
            }
        };
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        List<String> currentPageSourceKeyList = super.getCurrentPageSourceKeyList();
        if (this.hqS && currentPageSourceKeyList != null) {
            currentPageSourceKeyList.clear();
            this.hqS = false;
            return null;
        }
        return currentPageSourceKeyList;
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, com.baidu.adp.base.h
    public boolean isScroll() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.cwc = z;
        boolean z2 = this.hqY || this.cwc;
        if (this.hqN != null) {
            this.hqN.onKeyboardVisibilityChanged(z2);
        }
    }

    @Override // com.baidu.tbadk.core.util.e.c
    public boolean videoNeedPreload() {
        return aa.gp(1);
    }
}
