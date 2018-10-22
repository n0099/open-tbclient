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
import com.baidu.tbadk.BdToken.a;
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
public class MainTabActivity extends BaseFragmentActivity implements com.baidu.tbadk.core.util.e.c, UserIconBox.b, VoiceManager.c, FrsCommonImageLayout.c, b {
    private static boolean hhT;
    private com.baidu.adp.lib.e.b<TbImageView> aGx;
    private CheckRealNameModel cre;
    private com.baidu.tieba.NEGFeedBack.a dAW;
    VoiceManager dAm;
    private com.baidu.tieba.write.c dDr;
    private com.baidu.tieba.ueg.c dDt;
    private ShareSuccessReplyToServerModel dQb;
    private com.baidu.tieba.ueg.b gzy;
    private as hhO;
    private e hhR;
    private a hhS;
    private com.baidu.adp.lib.e.b<TbImageView> hhV;
    private com.baidu.tieba.a hhX;
    private FrameLayout hhY;
    private d hia;
    private com.baidu.tbadk.BdToken.a hib;
    private String hiq;
    private boolean mTouchable;
    private boolean hhL = false;
    private int hhM = -1;
    private boolean hhN = false;
    private String mFrom = null;
    private volatile boolean mIsAdd = false;
    private long hhP = 0;
    private long hhQ = 0;
    private long hhU = -1;
    private boolean hhW = false;
    private String hhZ = "";
    boolean hic = false;
    boolean csb = false;
    private CustomMessageListener hie = new CustomMessageListener(2010045) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && MainTabActivity.this.hhR != null && TbadkCoreApplication.getInst().getCurrentActivity() == MainTabActivity.this) {
                MainTabActivity.this.hic = com.baidu.adp.lib.g.b.g(customResponsedMessage.getData().toString(), false);
                MainTabActivity.this.hhR.onKeyboardVisibilityChanged((MainTabActivity.this.hic || MainTabActivity.this.csb) ? true : true);
            }
        }
    };
    private final CustomMessageListener hif = new CustomMessageListener(2001377) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.12
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
                        MainTabActivity.this.hhR.aBh().cV(1);
                    } else if (TbadkCoreApplication.getInst().isThemeIconCover()) {
                        MainTabActivity.this.hhR.aBh().cV(2);
                    } else {
                        MainTabActivity.this.hhR.aBh().cV(1);
                    }
                }
            }
        }
    };
    public CustomMessageListener hig = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && MainTabActivity.this.hhR != null && MainTabActivity.this.hhR.aBh() != null) {
                if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    MainTabActivity.this.hhR.aBh().getTabWrapper().animate().translationY(MainTabActivity.this.hhR.aBh().getTabWrapper().getHeight()).setDuration(200L).start();
                } else {
                    MainTabActivity.this.hhR.aBh().getTabWrapper().animate().translationY(0.0f).setDuration(400L).start();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c eNh = new com.baidu.adp.framework.listener.c(1001) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ConfigVersion configVersion;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                if (socketResponsedMessage.getError() == 0 && (configVersion = responseOnlineMessage.getConfigVersion()) != null) {
                    MainTabActivity.this.vv(configVersion.sync);
                }
            }
        }
    };
    private CustomMessageListener hih = new CustomMessageListener(2001609) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.28
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
    private final CustomMessageListener hii = new CustomMessageListener(2001247) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getData() instanceof PayMemberInfoData) {
                    MainTabActivity.this.a((PayMemberInfoData) customResponsedMessage.getData());
                    TbadkCoreApplication.getInst().setPaymemberInfo((PayMemberInfoData) customResponsedMessage.getData());
                }
                UserData LX = com.baidu.tbadk.getUserInfo.b.LV().LX();
                if (TbadkCoreApplication.isLogin() && LX != null && LX.getUserId() != null && !LX.getUserId().equals(MainTabActivity.this.hhZ) && LX.getIsGodInvited()) {
                    MainTabActivity.this.hhZ = LX.getUserId();
                    MainTabActivity.this.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(MainTabActivity.this.getPageContext().getPageActivity(), "", TbWebViewActivityConfig.GOD_INVITE_JUMP_URL + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE, true)));
                }
            }
        }
    };
    private CustomMessageListener dBs = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                MainTabActivity.this.hhR.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    final CustomMessageListener hij = new CustomMessageListener(2007002) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.tbadk.mainTab.b> list;
            MainTabActivity.this.mIsAdd = false;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (list = ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).getList()) != null && list.size() != 0) {
                MainTabActivity.this.hhR.aj(list);
                if (MainTabActivity.this.hhN) {
                    MainTabActivity.this.hhR.aBh().setCurrentTabByType(MainTabActivity.this.hhM);
                } else {
                    MainTabActivity.this.ac(MainTabActivity.this.getIntent());
                }
                MainTabActivity.this.hhN = false;
                MainTabActivity.this.hhR.bEf();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, null));
            }
        }
    };
    final CustomMessageListener hik = new CustomMessageListener(2007013) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007013) {
                MainTabActivity.this.bbS();
                if (MainTabActivity.this.hhR != null && MainTabActivity.this.hhR.aBh() != null) {
                    MainTabActivity.this.hhM = MainTabActivity.this.hhR.aBh().getCurrentTabType();
                }
                MainTabActivity.this.hhN = true;
            }
        }
    };
    final CustomMessageListener hil = new CustomMessageListener(2921333) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (MainTabActivity.this.hhO != null || (customResponsedMessage.getData() instanceof as)) {
                    if (customResponsedMessage.getData() != null) {
                        MainTabActivity.this.hhO = (as) customResponsedMessage.getData();
                    }
                    if (!MainTabActivity.this.mIsAdd && MainTabActivity.this.hhO != null && TbadkCoreApplication.isLogin()) {
                        MainTabActivity.this.hia.c(MainTabActivity.this.hhO.recom_title, MainTabActivity.this.hhO.recom_topic, MainTabActivity.this.hhO.aos);
                    }
                }
            }
        }
    };
    private final CustomMessageListener him = new CustomMessageListener(2007005) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.e.b.Bg() == null) {
                c cVar = new c();
                cVar.a(MainTabActivity.this);
                com.baidu.tbadk.core.e.b.a(cVar);
            }
        }
    };
    private CheckRealNameModel.a hin = new CheckRealNameModel.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.7
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            if (CheckRealNameModel.TYPE_APP_FIRST_START.equals(str2) && i == 1990055) {
                TiebaStatic.log("c12138");
                MainTabActivity.this.hhR.vx(MainTabActivity.this.getResources().getString(e.j.check_real_name_message));
            }
        }
    };
    private CustomMessageListener aia = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && com.baidu.adp.lib.util.l.lo()) {
                MainTabActivity.this.akj();
                if (!MainTabActivity.hhT) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
                }
            }
        }
    };
    private CustomMessageListener bLU = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                MainTabActivity.this.hhW = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
                com.baidu.tbadk.core.sharedPref.b.getInstance().remove("key_feedback_tip");
                com.baidu.tbadk.core.sharedPref.b.getInstance().remove("key_feedback_tip_show");
                com.baidu.tbadk.core.sharedPref.b.getInstance().remove("key_feedback_tip_tab_show");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016560));
                if (MainTabActivity.this.hib != null) {
                    MainTabActivity.this.hib.check();
                }
            }
        }
    };
    private CustomMessageListener hio = new CustomMessageListener(2016509) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                n.avR = ((Boolean) customResponsedMessage.getData()).booleanValue();
                MainTabActivity.this.bDS();
            }
        }
    };
    private final CustomMessageListener hip = new CustomMessageListener(2001230) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", booleanValue);
                MainTabActivity.this.hhR.ns(booleanValue);
            }
        }
    };
    private CustomMessageListener cWU = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.21
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                boolean unused = MainTabActivity.hhT = true;
                if (MainTabActivity.this.hhR != null && MainTabActivity.this.hhR.bEg() != null && MainTabActivity.this.hhR.bEg().getAnimationView() != null && MainTabActivity.this.hhR.bEg().getAnimationView().getVisibility() != 0) {
                    MainTabActivity.this.hhR.bEg().setLottieView(false);
                }
                if (!TbadkCoreApplication.getInst().getActivityPrizeData().ES()) {
                    if (MainTabActivity.this.hhR != null) {
                        MainTabActivity.this.hhR.vw(null);
                    }
                } else {
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getInst().getActivityPrizeData().EW()) {
                        String EV = TbadkCoreApplication.getInst().getActivityPrizeData().EV();
                        if (!StringUtils.isNull(EV) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("activity_prize_get_tip" + TbadkCoreApplication.getCurrentAccount(), true)) {
                            ay.CU().a(MainTabActivity.this.getPageContext(), new String[]{EV}, true);
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("activity_prize_get_tip" + TbadkCoreApplication.getCurrentAccount(), false);
                        }
                    }
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                        if (MainTabActivity.this.hhR != null) {
                            MainTabActivity.this.hhR.vw(null);
                        }
                    } else {
                        String EY = TbadkCoreApplication.getInst().getActivityPrizeData().EY();
                        if (!StringUtils.isNull(EY)) {
                            if (MainTabActivity.this.hhR != null) {
                                MainTabActivity.this.hhR.vw(EY);
                            }
                        } else if (MainTabActivity.this.hhR != null) {
                            MainTabActivity.this.hhR.vw(null);
                        }
                    }
                }
                if (TbSingleton.getInstance().canShowPermDialog()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921360, MainTabActivity.this));
                }
            }
        }
    };
    private CustomMessageListener hir = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    MainTabActivity.this.hiq = UtilHelper.getCurrentDay();
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("last_resume_time", TbSingleton.getInstance().getLastResumeTime());
                    return;
                }
                String currentDay = UtilHelper.getCurrentDay();
                if (!StringUtils.isNull(currentDay) && !currentDay.equals(MainTabActivity.this.hiq)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
                }
                if (MainTabActivity.this.gzy == null) {
                    MainTabActivity.this.gzy = new com.baidu.tieba.ueg.b();
                }
                MainTabActivity.this.gzy.vr(MainTabActivity.this.gzy.hqe);
                MainTabActivity.this.gzy.hqe = as.a.ayF;
            }
        }
    };
    private final CustomMessageListener gxL = new CustomMessageListener(2016493) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.24
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            i iVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i) && (iVar = (i) customResponsedMessage.getData()) != null && !StringUtils.isNull(iVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(iVar);
                if (StringUtils.isNull(iVar.aSZ)) {
                    ay.CU().c(MainTabActivity.this.getPageContext(), new String[]{iVar.mLink});
                } else {
                    ay.CU().c(MainTabActivity.this.getPageContext(), new String[]{iVar.mLink, iVar.aSZ});
                }
            }
        }
    };
    private a.InterfaceC0118a agZ = new a.InterfaceC0118a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.25
        @Override // com.baidu.tbadk.BdToken.a.InterfaceC0118a
        public void dm(String str) {
            if (KuangFloatingViewController.getInstance().init()) {
                KuangFloatingViewController.getInstance().setInfo(str);
                ((BaseFragmentActivity) MainTabActivity.this.getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.25.1
                    @Override // com.baidu.tbadk.core.e
                    public void aE(boolean z) {
                        if (z) {
                            KuangFloatingViewController.getInstance().showFloatingView();
                            TiebaStatic.log(new am("c12264").x("obj_type", 3));
                        }
                    }
                });
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void vv(String str) {
        if (str != null && TbadkCoreApplication.getInst().getConfigVersion() != null && bDR()) {
            this.hhU = System.currentTimeMillis();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
        }
    }

    private boolean bDR() {
        if (-1 == this.hhU) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.hhU;
        return currentTimeMillis <= 0 || currentTimeMillis >= ReportUserInfoModel.TIME_INTERVAL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDS() {
        if (com.baidu.adp.lib.b.d.iR().aO("android_game_enter_switch") == 1 && n.avR) {
            this.hhR.nq(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016510));
            return;
        }
        this.hhR.nq(false);
        this.hhR.ns(false);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
    }

    public void a(PayMemberInfoData payMemberInfoData) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && payMemberInfoData != null) {
            if ((payMemberInfoData.Ki() == 1 || payMemberInfoData.Ki() == 2) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_member_deid_line", true)) {
                long wN = payMemberInfoData.wN() * 1000;
                if (wN < System.currentTimeMillis()) {
                    if (StringUtils.isNull(payMemberInfoData.Kj())) {
                        payMemberInfoData.gZ(getPageContext().getString(e.j.member));
                    } else {
                        payMemberInfoData.gZ(payMemberInfoData.Kj() + getPageContext().getString(e.j.member_already_Expire));
                    }
                    this.hhR.a(payMemberInfoData, 0);
                } else if (wN - System.currentTimeMillis() < 259200000) {
                    if (StringUtils.isNull(payMemberInfoData.Kj())) {
                        payMemberInfoData.gZ(getPageContext().getString(e.j.member));
                    } else {
                        payMemberInfoData.gZ(payMemberInfoData.Kj() + getPageContext().getString(e.j.member_will_Expire));
                    }
                    this.hhR.a(payMemberInfoData, 1);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.mTouchable) {
            return false;
        }
        if (this.hhR.aBh() == null || this.hhR.aBh().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1 || !this.hhR.bbW()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public void aBd() {
        if (this.hia != null) {
            this.hia.bDQ();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
        if (this.dDr == null) {
            this.dDr = new com.baidu.tieba.write.c(getPageContext(), this.hhY, "main_tab");
            this.dDr.wL("1");
        }
        if (!this.dDt.bFO()) {
            this.dDr.oc(false);
        }
    }

    protected void bbS() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007002, new com.baidu.tbadk.mainTab.d(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.baidu.tbadk.l.n.Oc().av(System.currentTimeMillis());
        if (TbadkCoreApplication.getInst().getIsFirstUse()) {
            x.a(new w<Object>() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.5
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
        c cVar = new c();
        com.baidu.tbadk.core.e.b.a(cVar);
        cVar.a(this);
        if (bDT()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        setContentView(e.h.maintabs_activity);
        this.hhY = (FrameLayout) findViewById(e.g.maintabContainer);
        com.baidu.tbadk.core.a.a.wx().wy();
        this.hhR = new e(this);
        this.hia = new d(this);
        this.hhR.np(this.mIsLogin);
        bDS();
        aMu();
        com.baidu.tieba.tblauncher.alarmRemind.b.bEl().e(this);
        this.hhX = new com.baidu.tieba.a();
        bbS();
        bcp();
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (bundle != null) {
            i2 = bundle.getInt("locate_type", 1);
            intent.putExtra("locate_type", i2);
        }
        this.hiq = UtilHelper.getCurrentDay();
        this.hhU = System.currentTimeMillis();
        MessageManager.getInstance().sendMessage(new CustomMessage(2921359));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
        if (TbadkCoreApplication.getFrom() != null && TbadkCoreApplication.getFrom().equals("aishide")) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005011, null));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005013, null));
        MessageManager.getInstance().registerStickyMode(2001404);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001404));
        i(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        com.baidu.tbadk.browser.a.bq(getPageContext().getPageActivity());
        String installOtherApp = TbadkCoreApplication.getInst().getInstallOtherApp();
        if (installOtherApp != null && installOtherApp.length() > 0) {
            UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), installOtherApp);
            TbadkCoreApplication.getInst().setInstallOtherApp(null);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.6
            @Override // java.lang.Runnable
            public void run() {
                MainTabActivity.this.mTouchable = true;
            }
        });
        registerListener(this.eNh);
        if (i2 == 1) {
            this.hhR.nr(true);
        } else {
            this.hhR.nr(false);
        }
        this.hhR.bEh();
        this.dAm = getVoiceManager();
        if (this.dAm != null) {
            this.dAm.onCreate(getPageContext());
        }
        registerListener(this.bLU);
        adjustResizeForSoftInput();
        addGlobalLayoutListener();
        MessageManager.getInstance().registerStickyMode(2007015);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007015));
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.l.n.Oc().Od();
        }
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.getUserInfo.b.LV().LW();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016480));
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("app_restart_times", com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("app_restart_times", 0) + 1);
        this.cre = new CheckRealNameModel(getPageContext());
        this.cre.a(this.hin);
        akj();
        this.dAW = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "homepage");
        this.dQb = new ShareSuccessReplyToServerModel();
        this.dDt = new com.baidu.tieba.ueg.c(getPageContext());
        this.hib = new com.baidu.tbadk.BdToken.a(getPageContext());
        this.hib.a(this.agZ);
        this.hib.check();
        TbadkCoreApplication.getInst().SendSkinTypeBroadcast(TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tbadk.l.n.Oc().aw(System.currentTimeMillis());
        MessageManager.getInstance().registerListener(this.gxL);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public ViewGroup getActivityRootView() {
        return this.hhY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akj() {
        String str = "check_real_name" + TbConfig.getVersion();
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(str, true) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && com.baidu.adp.lib.util.l.lo()) {
            this.cre.rp(CheckRealNameModel.TYPE_APP_FIRST_START);
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
                Map<String, String> fv = ay.fv(decode);
                if (fv != null) {
                    String str = fv.get("fr");
                    if (!"mpush".equals(str) && "bpush".equals(str)) {
                        am amVar = new am("c10320");
                        amVar.ax("obj_locate", fv.get("obj_locate"));
                        amVar.x("obj_type", 1);
                        amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, fv.get(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
                        amVar.ax("obj_param2", fv.get("obj_param2"));
                        amVar.x("obj_to", 1);
                        amVar.ax(VideoPlayActivityConfig.OBJ_ID, fv.get("bdid"));
                        if (!ao.isEmpty(fv.get("ext_log"))) {
                            try {
                                JSONObject jSONObject = new JSONObject(fv.get("ext_log"));
                                Iterator<String> keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    amVar.ax(next, jSONObject.getString(next));
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
            } else if (!StringUtils.isNull(dataString)) {
                if (dataString.startsWith("tbclient://") || dataString.startsWith("tbclient_zm://")) {
                    String dataString2 = intent.getDataString();
                    if (!StringUtils.isNull(dataString2)) {
                        ay.CU().c(getPageContext(), new String[]{dataString2});
                    }
                }
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
        this.dAm = getVoiceManager();
        if (this.dAm != null) {
            this.dAm.onStart(getPageContext());
        }
    }

    public boolean bDT() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005010, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005012, null));
        aMv();
        com.baidu.tbadk.coreExtra.messageCenter.a.Gz().GL();
        com.baidu.tbadk.coreExtra.messageCenter.a.Gz().GF();
        com.baidu.tbadk.coreExtra.messageCenter.a.Gz().bx(false);
        MessageManager.getInstance().unRegisterListener(this.gxL);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.bj(false);
            this.mWaitingDialog = null;
        }
        bDU();
        if (this.hhR != null) {
            this.hhR.onDestroy();
        }
        if (this.hia != null) {
            this.hia.onDestroy();
        }
        try {
            super.onDestroy();
        } catch (Exception e) {
        }
        com.baidu.tbadk.core.e.b.a(null);
        this.dAm = getVoiceManager();
        if (this.dAm != null) {
            this.dAm.onDestory(getPageContext());
        }
        if (this.dDr != null) {
            this.dDr.onDestroy();
        }
        if (this.dAW != null) {
            this.dAW.onDestroy();
        }
        if (this.dQb != null) {
            this.dQb.cancelLoadData();
        }
        if (this.hib != null) {
            this.hib.onDestroy();
        }
        if (this.gzy != null) {
            this.gzy.onDestroy();
        }
        if (this.hhR != null && this.hhR.bEg() != null) {
            this.hhR.bEg().onDestory();
        }
        System.gc();
    }

    private void bDU() {
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

    private void aMu() {
        registerListener(this.hif);
        this.hij.setPriority(100);
        registerListener(this.hij);
        registerListener(this.hik);
        registerListener(this.hil);
        registerListener(this.him);
        registerListener(this.hio);
        registerListener(this.hip);
        registerListener(this.hii);
        registerListener(this.skinTypeChangeListener);
        registerListener(this.hig);
        registerListener(this.aia);
        this.hhS = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.hhS, intentFilter);
        registerListener(this.dBs);
        registerListener(this.hih);
        registerListener(this.cWU);
        registerListener(this.aia);
        registerListener(this.hir);
        this.hie.setTag(getUniqueId());
        registerListener(this.hie);
    }

    private void aMv() {
        if (this.hhS != null) {
            unregisterReceiver(this.hhS);
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
        if (this.hhR != null && this.hhR.bEg() != null) {
            this.hhR.bEg().setLottieView(true);
        }
        if (this.hhR != null && this.hhR.aBh() != null) {
            this.hhM = this.hhR.aBh().getCurrentTabType();
        }
        changeSkinType(this.mSkinType);
        if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.l.n.Oc().Ob()) {
            com.baidu.tbadk.l.n.Oc().Od();
        }
        this.dAm = getVoiceManager();
        if (this.dAm != null) {
            this.dAm.onResume(getPageContext());
        }
        this.hhR.bEh();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001385, getActivity()));
        if (TbadkCoreApplication.getKeepLiveSwitch(getApplicationContext())) {
            com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921300, Boolean.FALSE));
                }
            }, 3000L);
        }
        com.baidu.tbadk.l.n.Oc().Od();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.hhW = true;
        if (z) {
            com.baidu.tbadk.getUserInfo.b.LV().LW();
            bDS();
            akj();
        }
        this.hhR.switchNaviBarStatus(z);
        bbS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (this.hhL) {
            this.hhL = false;
            CompatibleUtile.setAnim(getPageContext().getPageActivity(), e.a.down, e.a.hold);
        }
        this.dAm = getVoiceManager();
        if (this.dAm != null) {
            this.dAm.onPause(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921003));
        if (this.hia != null) {
            this.hia.bkY();
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
        bundle.putInt("locate_type", this.hhR.aBh().getCurrentTabType());
        bundle.putParcelable("android:fragments", null);
        bundle.putParcelable("android:support:fragments", null);
        this.dAm = getVoiceManager();
        if (this.dAm != null) {
            this.dAm.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.dAm = getVoiceManager();
        if (this.dAm != null) {
            this.dAm.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        U(intent);
        setIntent(intent);
        com.baidu.tbadk.getUserInfo.b.LV().LW();
        if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007008));
            bbS();
        }
        this.mFrom = intent.getStringExtra("from");
        int intExtra = intent.getIntExtra("locate_type", 1);
        if (intExtra == 200) {
            finish();
        } else if (intExtra == 11) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), true)));
            finish();
        } else if (intExtra == 12) {
            TbadkCoreApplication.getInst().notifyAppEnterBackground();
            finish();
        } else if (intExtra == 1 || intExtra == 3 || intExtra == 2 || intExtra == 4 || intExtra == 8 || intExtra == 15) {
            if (intExtra != 8 && intExtra != 3 && intExtra != 15) {
                intExtra = this.hhX.So();
            }
            if (this.hhR != null && this.hhR.aBh() != null) {
                this.hhR.aBh().setCurrentTabByType(intExtra);
            }
        }
        i(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        this.hhR.bEh();
    }

    protected void M(Activity activity) {
        new com.baidu.tbadk.core.dialog.a(activity).cy(e.j.confirm_title).aO(false).cz(e.j.background_process_permission).a(e.j.now_goto_setting, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                try {
                    MainTabActivity.this.startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
                    aVar.dismiss();
                } catch (Exception e) {
                    MainTabActivity.this.showToast(e.j.goto_developActivity_error_toast);
                }
            }
        }).b(e.j.next_time, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                MainTabActivity.this.bDV();
            }
        }).b(com.baidu.adp.base.i.aK(activity)).Au();
    }

    protected void bDV() {
        com.baidu.adp.lib.f.c.jC().d(getUniqueId());
        bDX();
        moveTaskToBack(true);
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
                if (this.dDr != null && this.dDr.isShowing()) {
                    this.dDr.aBj();
                    return true;
                } else if (this.hhR.bbW()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007010));
                    return true;
                } else {
                    if (System.currentTimeMillis() - this.hhP > SystemScreenshotManager.DELAY_TIME) {
                        showToast(e.j.double_back_quit);
                        this.hhP = System.currentTimeMillis();
                    } else if (UtilHelper.isBackgroundProcessLimitNone() && Build.VERSION.SDK_INT >= 14) {
                        M(getPageContext().getPageActivity());
                        return true;
                    } else {
                        bDV();
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
        try {
            this.hhR.aBh().setCurrentTabByType(this.hhX.So());
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

    private void bcp() {
        registerListener(new CustomMessageListener(2007009) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Integer) {
                    Integer num = (Integer) customResponsedMessage.getData();
                    if (num.intValue() == 2) {
                        MainTabActivity.this.hhR.nr(true);
                        MainTabActivity.this.hhR.jG(true);
                    } else if (num.intValue() == 1) {
                        MainTabActivity.this.hhR.nr(true);
                        MainTabActivity.this.hhR.jG(false);
                    } else {
                        MainTabActivity.this.hhR.nr(false);
                        MainTabActivity.this.hhR.jG(false);
                    }
                    MainTabActivity.this.hhR.bEh();
                }
            }
        });
    }

    protected void bDW() {
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
            if (this.hhR.aBh().getCurrentFragment() != null) {
                this.hhR.aBh().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 11001) {
            bDW();
        } else if (i == 13003) {
            ad(intent);
        } else if (i == 23007) {
            N(intent);
        } else if (i == 13011) {
            com.baidu.tieba.n.a.bsS().x(getPageContext());
        } else if (i == 24007) {
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1) {
                com.baidu.tieba.n.a.bsS().x(getPageContext());
                com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                if (shareItem != null && shareItem.linkUrl != null && this.dQb != null) {
                    this.dQb.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.14
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void HI() {
                        }

                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void a(final CustomDialogData customDialogData) {
                            com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.14.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a(MainTabActivity.this.getPageContext(), customDialogData).show();
                                }
                            }, 1000L);
                        }
                    });
                }
            }
        } else if (this.hhR.aBh().getCurrentFragment() != null) {
            this.hhR.aBh().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    private ShareFromPBMsgData aEX() {
        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.imageUri == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.imageUri.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.aNU);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.aNQ);
        shareFromPBMsgData.setThreadId(shareItem.tid);
        return shareFromPBMsgData;
    }

    private void N(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(aEX(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.cB(1);
            aVar.G(thread2GroupShareView);
            aVar.a(e.j.share, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.15
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MainTabActivity.this.HidenSoftKeyPad((InputMethodManager) MainTabActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(MainTabActivity.this.getPageContext().getPageActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.IQ() != null) {
                        Bundle IQ = shareItem.IQ();
                        TiebaStatic.log(new am("share_success").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).x("obj_type", IQ.getInt("obj_type")).x("obj_param1", 3).ax(ImageViewerConfig.FORUM_ID, IQ.getString(ImageViewerConfig.FORUM_ID)).ax("tid", IQ.getString("tid")));
                    }
                }
            });
            aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.16
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MainTabActivity.this.HidenSoftKeyPad((InputMethodManager) MainTabActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.aP(true);
            aVar.b(getPageContext()).Au();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.L(shareFromPBMsgData.getImageUrl(), false);
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
        this.hhR.onChangeSkinType(i);
        adjustResizeForSoftInputOnSkinTypeChanged(i);
        if (this.dDr != null) {
            this.dDr.onChangeSkinType();
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
            if (this.hhR != null && !this.hhR.d(postWriteCallBackData)) {
                this.hhR.b(postWriteCallBackData);
            }
        }
    }

    private void bDX() {
        if (System.currentTimeMillis() - this.hhQ >= 7200000) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage(2006002, hashMap));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005013, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            this.hhQ = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.b
    public int getCurrentTabType() {
        if (this.hhR.aBh() != null) {
            return this.hhR.aBh().getCurrentTabType();
        }
        return -1;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dAm == null) {
            this.dAm = VoiceManager.instance();
        }
        return this.dAm;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public ListView Eg() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Eh() {
        if (this.aGx == null) {
            this.aGx = UserIconBox.l(getPageContext().getPageActivity(), 8);
        }
        return this.aGx;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> ayZ() {
        if (this.hhV == null) {
            this.hhV = FrsCommonImageLayout.s(getPageContext().getPageActivity(), 12);
        }
        return this.hhV;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.17
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean Nz() {
                return true;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int NA() {
                return com.baidu.tbadk.pageStayDuration.e.NE().NG();
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
        if (this.hhW && currentPageSourceKeyList != null) {
            currentPageSourceKeyList.clear();
            this.hhW = false;
            return null;
        }
        return currentPageSourceKeyList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.csb = z;
        boolean z2 = this.hic || this.csb;
        if (this.hhR != null) {
            this.hhR.onKeyboardVisibilityChanged(z2);
        }
    }

    @Override // com.baidu.tbadk.core.util.e.c
    public boolean videoNeedPreload() {
        return aa.fN(1);
    }
}
