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
public class MainTabActivity extends BaseFragmentActivity implements com.baidu.tbadk.core.util.e.c, UserIconBox.b, VoiceManager.c, FrsCommonImageLayout.c, com.baidu.tieba.tblauncher.a {
    private static boolean hjD;
    private com.baidu.adp.lib.e.b<TbImageView> aHn;
    private CheckRealNameModel crg;
    VoiceManager dBD;
    private com.baidu.tieba.NEGFeedBack.a dCn;
    private com.baidu.tieba.write.c dEH;
    private com.baidu.tieba.ueg.c dEJ;
    private ShareSuccessReplyToServerModel dRe;
    private com.baidu.tieba.ueg.b gAZ;
    private d hjB;
    private a hjC;
    private com.baidu.adp.lib.e.b<TbImageView> hjF;
    private com.baidu.tieba.a hjH;
    private FrameLayout hjI;
    private c hjK;
    private com.baidu.tbadk.BdToken.a hjL;
    private String hjZ;
    private as hjy;
    private boolean mTouchable;
    private boolean hjv = false;
    private int hjw = -1;
    private boolean hjx = false;
    private String mFrom = null;
    private volatile boolean mIsAdd = false;
    private long hjz = 0;
    private long hjA = 0;
    private long hjE = -1;
    private boolean hjG = false;
    private String hjJ = "";
    boolean hjM = false;
    boolean csj = false;
    private CustomMessageListener hjN = new CustomMessageListener(2010045) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && MainTabActivity.this.hjB != null && TbadkCoreApplication.getInst().getCurrentActivity() == MainTabActivity.this) {
                MainTabActivity.this.hjM = com.baidu.adp.lib.g.b.g(customResponsedMessage.getData().toString(), false);
                MainTabActivity.this.hjB.onKeyboardVisibilityChanged((MainTabActivity.this.hjM || MainTabActivity.this.csj) ? true : true);
            }
        }
    };
    private final CustomMessageListener hjO = new CustomMessageListener(2001377) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.12
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
                        MainTabActivity.this.hjB.aAE().dj(1);
                    } else if (TbadkCoreApplication.getInst().isThemeIconCover()) {
                        MainTabActivity.this.hjB.aAE().dj(2);
                    } else {
                        MainTabActivity.this.hjB.aAE().dj(1);
                    }
                }
            }
        }
    };
    public CustomMessageListener hjP = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && MainTabActivity.this.hjB != null && MainTabActivity.this.hjB.aAE() != null) {
                if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    MainTabActivity.this.hjB.aAE().getTabWrapper().animate().translationY(MainTabActivity.this.hjB.aAE().getTabWrapper().getHeight()).setDuration(200L).start();
                } else {
                    MainTabActivity.this.hjB.aAE().getTabWrapper().animate().translationY(0.0f).setDuration(400L).start();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c eOz = new com.baidu.adp.framework.listener.c(1001) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ConfigVersion configVersion;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                if (socketResponsedMessage.getError() == 0 && (configVersion = responseOnlineMessage.getConfigVersion()) != null) {
                    MainTabActivity.this.vA(configVersion.sync);
                }
            }
        }
    };
    private CustomMessageListener hjQ = new CustomMessageListener(2001609) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.28
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
    private final CustomMessageListener hjR = new CustomMessageListener(2001247) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getData() instanceof PayMemberInfoData) {
                    MainTabActivity.this.a((PayMemberInfoData) customResponsedMessage.getData());
                    TbadkCoreApplication.getInst().setPaymemberInfo((PayMemberInfoData) customResponsedMessage.getData());
                }
                UserData Mj = com.baidu.tbadk.getUserInfo.b.Mh().Mj();
                if (TbadkCoreApplication.isLogin() && Mj != null && Mj.getUserId() != null && !Mj.getUserId().equals(MainTabActivity.this.hjJ) && Mj.getIsGodInvited()) {
                    MainTabActivity.this.hjJ = Mj.getUserId();
                    MainTabActivity.this.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(MainTabActivity.this.getPageContext().getPageActivity(), "", TbWebViewActivityConfig.GOD_INVITE_JUMP_URL + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE, true)));
                }
            }
        }
    };
    private CustomMessageListener dCJ = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                MainTabActivity.this.hjB.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    final CustomMessageListener hjS = new CustomMessageListener(2007002) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.tbadk.mainTab.b> list;
            MainTabActivity.this.mIsAdd = false;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (list = ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).getList()) != null && list.size() != 0) {
                MainTabActivity.this.hjB.ai(list);
                if (MainTabActivity.this.hjx) {
                    MainTabActivity.this.hjB.aAE().setCurrentTabByType(MainTabActivity.this.hjw);
                } else {
                    MainTabActivity.this.ac(MainTabActivity.this.getIntent());
                }
                MainTabActivity.this.hjx = false;
                MainTabActivity.this.hjB.bDE();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, null));
            }
        }
    };
    final CustomMessageListener hjT = new CustomMessageListener(2007013) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007013) {
                MainTabActivity.this.bbr();
                if (MainTabActivity.this.hjB != null && MainTabActivity.this.hjB.aAE() != null) {
                    MainTabActivity.this.hjw = MainTabActivity.this.hjB.aAE().getCurrentTabType();
                }
                MainTabActivity.this.hjx = true;
            }
        }
    };
    final CustomMessageListener hjU = new CustomMessageListener(2921333) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (MainTabActivity.this.hjy != null || (customResponsedMessage.getData() instanceof as)) {
                    if (customResponsedMessage.getData() != null) {
                        MainTabActivity.this.hjy = (as) customResponsedMessage.getData();
                    }
                    if (!MainTabActivity.this.mIsAdd && MainTabActivity.this.hjy != null && TbadkCoreApplication.isLogin()) {
                        MainTabActivity.this.hjK.d(MainTabActivity.this.hjy.recom_title, MainTabActivity.this.hjy.recom_topic, MainTabActivity.this.hjy.apf);
                    }
                }
            }
        }
    };
    private final CustomMessageListener hjV = new CustomMessageListener(2007005) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.e.b.Bn() == null) {
                b bVar = new b();
                bVar.a(MainTabActivity.this);
                com.baidu.tbadk.core.e.b.a(bVar);
            }
        }
    };
    private CheckRealNameModel.a hjW = new CheckRealNameModel.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.7
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            if (CheckRealNameModel.TYPE_APP_FIRST_START.equals(str2) && i == 1990055) {
                TiebaStatic.log("c12138");
                MainTabActivity.this.hjB.vC(MainTabActivity.this.getResources().getString(e.j.check_real_name_message));
            }
        }
    };
    private CustomMessageListener aiN = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && com.baidu.adp.lib.util.l.lm()) {
                MainTabActivity.this.ajG();
                if (!MainTabActivity.hjD) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
                }
            }
        }
    };
    private CustomMessageListener bMF = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                MainTabActivity.this.hjG = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
                com.baidu.tbadk.core.sharedPref.b.getInstance().remove("key_feedback_tip");
                com.baidu.tbadk.core.sharedPref.b.getInstance().remove("key_feedback_tip_show");
                com.baidu.tbadk.core.sharedPref.b.getInstance().remove("key_feedback_tip_tab_show");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016560));
                if (MainTabActivity.this.hjL != null) {
                    MainTabActivity.this.hjL.check();
                }
            }
        }
    };
    private CustomMessageListener hjX = new CustomMessageListener(2016509) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                n.awE = ((Boolean) customResponsedMessage.getData()).booleanValue();
                MainTabActivity.this.bDr();
            }
        }
    };
    private final CustomMessageListener hjY = new CustomMessageListener(2001230) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", booleanValue);
                MainTabActivity.this.hjB.nG(booleanValue);
            }
        }
    };
    private CustomMessageListener cYa = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.21
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                boolean unused = MainTabActivity.hjD = true;
                if (MainTabActivity.this.hjB != null && MainTabActivity.this.hjB.bDF() != null && MainTabActivity.this.hjB.bDF().getAnimationView() != null && MainTabActivity.this.hjB.bDF().getAnimationView().getVisibility() != 0) {
                    MainTabActivity.this.hjB.bDF().setLottieView(false);
                }
                if (!TbadkCoreApplication.getInst().getActivityPrizeData().Fd()) {
                    if (MainTabActivity.this.hjB != null) {
                        MainTabActivity.this.hjB.vB(null);
                    }
                } else {
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getInst().getActivityPrizeData().Fh()) {
                        String Fg = TbadkCoreApplication.getInst().getActivityPrizeData().Fg();
                        if (!StringUtils.isNull(Fg) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("activity_prize_get_tip" + TbadkCoreApplication.getCurrentAccount(), true)) {
                            ay.Db().a(MainTabActivity.this.getPageContext(), new String[]{Fg}, true);
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("activity_prize_get_tip" + TbadkCoreApplication.getCurrentAccount(), false);
                        }
                    }
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                        if (MainTabActivity.this.hjB != null) {
                            MainTabActivity.this.hjB.vB(null);
                        }
                    } else {
                        String Fj = TbadkCoreApplication.getInst().getActivityPrizeData().Fj();
                        if (!StringUtils.isNull(Fj)) {
                            if (MainTabActivity.this.hjB != null) {
                                MainTabActivity.this.hjB.vB(Fj);
                            }
                        } else if (MainTabActivity.this.hjB != null) {
                            MainTabActivity.this.hjB.vB(null);
                        }
                    }
                }
                if (TbSingleton.getInstance().canShowPermDialog()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921360, MainTabActivity.this));
                }
            }
        }
    };
    private CustomMessageListener hka = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    MainTabActivity.this.hjZ = UtilHelper.getCurrentDay();
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("last_resume_time", TbSingleton.getInstance().getLastResumeTime());
                    return;
                }
                String currentDay = UtilHelper.getCurrentDay();
                if (!StringUtils.isNull(currentDay) && !currentDay.equals(MainTabActivity.this.hjZ)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
                }
                if (MainTabActivity.this.gAZ == null) {
                    MainTabActivity.this.gAZ = new com.baidu.tieba.ueg.b();
                }
                MainTabActivity.this.gAZ.vK(MainTabActivity.this.gAZ.hrN);
                MainTabActivity.this.gAZ.hrN = as.a.azs;
            }
        }
    };
    private final CustomMessageListener gzm = new CustomMessageListener(2016493) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.24
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            i iVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i) && (iVar = (i) customResponsedMessage.getData()) != null && !StringUtils.isNull(iVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(iVar);
                if (StringUtils.isNull(iVar.aTP)) {
                    ay.Db().c(MainTabActivity.this.getPageContext(), new String[]{iVar.mLink});
                } else {
                    ay.Db().c(MainTabActivity.this.getPageContext(), new String[]{iVar.mLink, iVar.aTP});
                }
            }
        }
    };
    private a.InterfaceC0142a ahM = new a.InterfaceC0142a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.25
        @Override // com.baidu.tbadk.BdToken.a.InterfaceC0142a
        public void dm(final String str) {
            if (KuangFloatingViewController.getInstance().init()) {
                KuangFloatingViewController.getInstance().setInfo(str);
                ((BaseFragmentActivity) MainTabActivity.this.getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.25.1
                    @Override // com.baidu.tbadk.core.e
                    public void aU(boolean z) {
                        if (z) {
                            KuangFloatingViewController.getInstance().showFloatingView();
                            TiebaStatic.log(new am("c12264").x("obj_type", 3));
                        } else if (!ao.isEmpty(str)) {
                            com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                        } else {
                            com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), e.j.task_finish_can_get_award);
                        }
                    }
                });
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void vA(String str) {
        if (str != null && TbadkCoreApplication.getInst().getConfigVersion() != null && bDq()) {
            this.hjE = System.currentTimeMillis();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
        }
    }

    private boolean bDq() {
        if (-1 == this.hjE) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.hjE;
        return currentTimeMillis <= 0 || currentTimeMillis >= ReportUserInfoModel.TIME_INTERVAL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDr() {
        if (com.baidu.adp.lib.b.d.iQ().aO("android_game_enter_switch") == 1 && n.awE) {
            this.hjB.nE(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016510));
            return;
        }
        this.hjB.nE(false);
        this.hjB.nG(false);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
    }

    public void a(PayMemberInfoData payMemberInfoData) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && payMemberInfoData != null) {
            if ((payMemberInfoData.Ku() == 1 || payMemberInfoData.Ku() == 2) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_member_deid_line", true)) {
                long wV = payMemberInfoData.wV() * 1000;
                if (wV < System.currentTimeMillis()) {
                    if (StringUtils.isNull(payMemberInfoData.Kv())) {
                        payMemberInfoData.ha(getPageContext().getString(e.j.member));
                    } else {
                        payMemberInfoData.ha(payMemberInfoData.Kv() + getPageContext().getString(e.j.member_already_Expire));
                    }
                    this.hjB.a(payMemberInfoData, 0);
                } else if (wV - System.currentTimeMillis() < 259200000) {
                    if (StringUtils.isNull(payMemberInfoData.Kv())) {
                        payMemberInfoData.ha(getPageContext().getString(e.j.member));
                    } else {
                        payMemberInfoData.ha(payMemberInfoData.Kv() + getPageContext().getString(e.j.member_will_Expire));
                    }
                    this.hjB.a(payMemberInfoData, 1);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.mTouchable) {
            return false;
        }
        if (this.hjB.aAE() == null || this.hjB.aAE().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1 || !this.hjB.bbv()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public void aAA() {
        if (this.hjK != null) {
            this.hjK.aFN();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
        if (this.dEH == null) {
            this.dEH = new com.baidu.tieba.write.c(getPageContext(), this.hjI, "main_tab");
            this.dEH.wQ("1");
        }
        if (!this.dEJ.bFn()) {
            this.dEH.oq(false);
        }
    }

    protected void bbr() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007002, new com.baidu.tbadk.mainTab.d(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.baidu.tbadk.l.n.Ol().ax(System.currentTimeMillis());
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
        b bVar = new b();
        com.baidu.tbadk.core.e.b.a(bVar);
        bVar.a(this);
        if (bDs()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        setContentView(e.h.maintabs_activity);
        this.hjI = (FrameLayout) findViewById(e.g.maintabContainer);
        com.baidu.tbadk.core.a.a.wF().wG();
        this.hjB = new d(this);
        this.hjK = new c(this);
        this.hjB.nD(this.mIsLogin);
        bDr();
        aLS();
        com.baidu.tieba.tblauncher.alarmRemind.b.bDK().e(this);
        this.hjH = new com.baidu.tieba.a();
        bbr();
        bbO();
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (bundle != null) {
            i2 = bundle.getInt("locate_type", 1);
            intent.putExtra("locate_type", i2);
        }
        this.hjZ = UtilHelper.getCurrentDay();
        this.hjE = System.currentTimeMillis();
        MessageManager.getInstance().sendMessage(new CustomMessage(2921359));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
        if (TbadkCoreApplication.getFrom() != null && TbadkCoreApplication.getFrom().equals("aishide")) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005011, null));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005013, null));
        MessageManager.getInstance().registerStickyMode(2001404);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001404));
        i(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        com.baidu.tbadk.browser.a.bo(getPageContext().getPageActivity());
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
        registerListener(this.eOz);
        if (i2 == 1) {
            this.hjB.nF(true);
        } else {
            this.hjB.nF(false);
        }
        this.hjB.bDG();
        this.dBD = getVoiceManager();
        if (this.dBD != null) {
            this.dBD.onCreate(getPageContext());
        }
        registerListener(this.bMF);
        adjustResizeForSoftInput();
        addGlobalLayoutListener();
        MessageManager.getInstance().registerStickyMode(2007015);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007015));
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.l.n.Ol().Om();
        }
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.getUserInfo.b.Mh().Mi();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016480));
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("app_restart_times", com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("app_restart_times", 0) + 1);
        this.crg = new CheckRealNameModel(getPageContext());
        this.crg.a(this.hjW);
        ajG();
        this.dCn = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "homepage");
        this.dRe = new ShareSuccessReplyToServerModel();
        this.dEJ = new com.baidu.tieba.ueg.c(getPageContext());
        this.hjL = new com.baidu.tbadk.BdToken.a(getPageContext());
        this.hjL.a(this.ahM);
        TbadkCoreApplication.getInst().SendSkinTypeBroadcast(TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tbadk.l.n.Ol().ay(System.currentTimeMillis());
        MessageManager.getInstance().registerListener(this.gzm);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public ViewGroup getActivityRootView() {
        return this.hjI;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && this.hjL != null) {
            this.hjL.check();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajG() {
        String str = "check_real_name" + TbConfig.getVersion();
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(str, true) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && com.baidu.adp.lib.util.l.lm()) {
            this.crg.rq(CheckRealNameModel.TYPE_APP_FIRST_START);
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
                        ay.Db().c(getPageContext(), new String[]{dataString2});
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
        this.dBD = getVoiceManager();
        if (this.dBD != null) {
            this.dBD.onStart(getPageContext());
        }
    }

    public boolean bDs() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005010, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005012, null));
        aLT();
        com.baidu.tbadk.coreExtra.messageCenter.a.GL().GX();
        com.baidu.tbadk.coreExtra.messageCenter.a.GL().GR();
        com.baidu.tbadk.coreExtra.messageCenter.a.GL().bO(false);
        MessageManager.getInstance().unRegisterListener(this.gzm);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.bz(false);
            this.mWaitingDialog = null;
        }
        bDt();
        if (this.hjB != null) {
            this.hjB.onDestroy();
        }
        if (this.hjK != null) {
            this.hjK.onDestroy();
        }
        try {
            super.onDestroy();
        } catch (Exception e) {
        }
        com.baidu.tbadk.core.e.b.a(null);
        this.dBD = getVoiceManager();
        if (this.dBD != null) {
            this.dBD.onDestory(getPageContext());
        }
        if (this.dEH != null) {
            this.dEH.onDestroy();
        }
        if (this.dCn != null) {
            this.dCn.onDestroy();
        }
        if (this.dRe != null) {
            this.dRe.cancelLoadData();
        }
        if (this.hjL != null) {
            this.hjL.onDestroy();
        }
        if (this.gAZ != null) {
            this.gAZ.onDestroy();
        }
        if (this.hjB != null && this.hjB.bDF() != null) {
            this.hjB.bDF().onDestory();
        }
        System.gc();
    }

    private void bDt() {
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

    private void aLS() {
        registerListener(this.hjO);
        this.hjS.setPriority(100);
        registerListener(this.hjS);
        registerListener(this.hjT);
        registerListener(this.hjU);
        registerListener(this.hjV);
        registerListener(this.hjX);
        registerListener(this.hjY);
        registerListener(this.hjR);
        registerListener(this.skinTypeChangeListener);
        registerListener(this.hjP);
        registerListener(this.aiN);
        this.hjC = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.hjC, intentFilter);
        registerListener(this.dCJ);
        registerListener(this.hjQ);
        registerListener(this.cYa);
        registerListener(this.aiN);
        registerListener(this.hka);
        this.hjN.setTag(getUniqueId());
        registerListener(this.hjN);
    }

    private void aLT() {
        if (this.hjC != null) {
            unregisterReceiver(this.hjC);
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
        if (this.hjB != null && this.hjB.bDF() != null) {
            this.hjB.bDF().setLottieView(true);
        }
        if (this.hjB != null && this.hjB.aAE() != null) {
            this.hjw = this.hjB.aAE().getCurrentTabType();
        }
        changeSkinType(this.mSkinType);
        if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.l.n.Ol().Ok()) {
            com.baidu.tbadk.l.n.Ol().Om();
        }
        this.dBD = getVoiceManager();
        if (this.dBD != null) {
            this.dBD.onResume(getPageContext());
        }
        this.hjB.bDG();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001385, getActivity()));
        if (TbadkCoreApplication.getKeepLiveSwitch(getApplicationContext())) {
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921300, Boolean.FALSE));
                }
            }, 3000L);
        }
        com.baidu.tbadk.l.n.Ol().Om();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.hjG = true;
        if (z) {
            com.baidu.tbadk.getUserInfo.b.Mh().Mi();
            bDr();
            ajG();
        }
        this.hjB.switchNaviBarStatus(z);
        bbr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (this.hjv) {
            this.hjv = false;
            CompatibleUtile.setAnim(getPageContext().getPageActivity(), e.a.down, e.a.hold);
        }
        this.dBD = getVoiceManager();
        if (this.dBD != null) {
            this.dBD.onPause(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921003));
        if (this.hjK != null) {
            this.hjK.aFO();
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
        bundle.putInt("locate_type", this.hjB.aAE().getCurrentTabType());
        bundle.putParcelable("android:fragments", null);
        bundle.putParcelable("android:support:fragments", null);
        this.dBD = getVoiceManager();
        if (this.dBD != null) {
            this.dBD.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.dBD = getVoiceManager();
        if (this.dBD != null) {
            this.dBD.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        U(intent);
        setIntent(intent);
        com.baidu.tbadk.getUserInfo.b.Mh().Mi();
        if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007008));
            bbr();
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
                intExtra = this.hjH.Sx();
            }
            if (this.hjB != null && this.hjB.aAE() != null) {
                this.hjB.aAE().setCurrentTabByType(intExtra);
            }
        }
        i(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        this.hjB.bDG();
    }

    protected void P(Activity activity) {
        new com.baidu.tbadk.core.dialog.a(activity).cM(e.j.confirm_title).be(false).cN(e.j.background_process_permission).a(e.j.now_goto_setting, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.11
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
                MainTabActivity.this.bDu();
            }
        }).b(com.baidu.adp.base.i.aK(activity)).AB();
    }

    protected void bDu() {
        com.baidu.adp.lib.f.c.jA().d(getUniqueId());
        bDw();
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
                if (this.dEH != null && this.dEH.isShowing()) {
                    this.dEH.aAG();
                    return true;
                } else if (this.hjB.bbv()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007010));
                    return true;
                } else {
                    if (System.currentTimeMillis() - this.hjz > SystemScreenshotManager.DELAY_TIME) {
                        showToast(e.j.double_back_quit);
                        this.hjz = System.currentTimeMillis();
                    } else if (UtilHelper.isBackgroundProcessLimitNone() && Build.VERSION.SDK_INT >= 14) {
                        P(getPageContext().getPageActivity());
                        return true;
                    } else {
                        bDu();
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
            this.hjB.aAE().setCurrentTabByType(this.hjH.Sx());
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

    private void bbO() {
        registerListener(new CustomMessageListener(2007009) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Integer) {
                    Integer num = (Integer) customResponsedMessage.getData();
                    if (num.intValue() == 2) {
                        MainTabActivity.this.hjB.nF(true);
                        MainTabActivity.this.hjB.jQ(true);
                    } else if (num.intValue() == 1) {
                        MainTabActivity.this.hjB.nF(true);
                        MainTabActivity.this.hjB.jQ(false);
                    } else {
                        MainTabActivity.this.hjB.nF(false);
                        MainTabActivity.this.hjB.jQ(false);
                    }
                    MainTabActivity.this.hjB.bDG();
                }
            }
        });
    }

    protected void bDv() {
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
            if (this.hjB.aAE().getCurrentFragment() != null) {
                this.hjB.aAE().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 11001) {
            bDv();
        } else if (i == 13003) {
            ad(intent);
        } else if (i == 23007) {
            N(intent);
        } else if (i == 13011) {
            com.baidu.tieba.n.a.bso().x(getPageContext());
        } else if (i == 24007) {
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1) {
                com.baidu.tieba.n.a.bso().x(getPageContext());
                com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                if (shareItem != null && shareItem.linkUrl != null && this.dRe != null) {
                    this.dRe.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.14
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void HU() {
                        }

                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void a(final CustomDialogData customDialogData) {
                            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.14.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a(MainTabActivity.this.getPageContext(), customDialogData).show();
                                }
                            }, 1000L);
                        }
                    });
                }
            }
        } else if (this.hjB.aAE().getCurrentFragment() != null) {
            this.hjB.aAE().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    private ShareFromPBMsgData aEt() {
        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.imageUri == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.imageUri.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.aOK);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.aOG);
        shareFromPBMsgData.setThreadId(shareItem.tid);
        return shareFromPBMsgData;
    }

    private void N(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(aEt(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.cP(1);
            aVar.G(thread2GroupShareView);
            aVar.a(e.j.share, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.15
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MainTabActivity.this.HidenSoftKeyPad((InputMethodManager) MainTabActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(MainTabActivity.this.getPageContext().getPageActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.Jc() != null) {
                        Bundle Jc = shareItem.Jc();
                        TiebaStatic.log(new am("share_success").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).x("obj_type", Jc.getInt("obj_type")).x("obj_param1", 3).ax(ImageViewerConfig.FORUM_ID, Jc.getString(ImageViewerConfig.FORUM_ID)).ax("tid", Jc.getString("tid")));
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
            aVar.bf(true);
            aVar.b(getPageContext()).AB();
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
        this.hjB.onChangeSkinType(i);
        adjustResizeForSoftInputOnSkinTypeChanged(i);
        if (this.dEH != null) {
            this.dEH.onChangeSkinType();
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
            if (this.hjB != null && !this.hjB.d(postWriteCallBackData)) {
                this.hjB.b(postWriteCallBackData);
            }
        }
    }

    private void bDw() {
        if (System.currentTimeMillis() - this.hjA >= 7200000) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage(2006002, hashMap));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005013, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            this.hjA = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.a
    public int getCurrentTabType() {
        if (this.hjB.aAE() != null) {
            return this.hjB.aAE().getCurrentTabType();
        }
        return -1;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dBD == null) {
            this.dBD = VoiceManager.instance();
        }
        return this.dBD;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public ListView Eq() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Er() {
        if (this.aHn == null) {
            this.aHn = UserIconBox.l(getPageContext().getPageActivity(), 8);
        }
        return this.aHn;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> ayw() {
        if (this.hjF == null) {
            this.hjF = FrsCommonImageLayout.s(getPageContext().getPageActivity(), 12);
        }
        return this.hjF;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.17
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean NI() {
                return true;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int NJ() {
                return com.baidu.tbadk.pageStayDuration.e.NN().NP();
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
        if (this.hjG && currentPageSourceKeyList != null) {
            currentPageSourceKeyList.clear();
            this.hjG = false;
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
        this.csj = z;
        boolean z2 = this.hjM || this.csj;
        if (this.hjB != null) {
            this.hjB.onKeyboardVisibilityChanged(z2);
        }
    }

    @Override // com.baidu.tbadk.core.util.e.c
    public boolean videoNeedPreload() {
        return aa.gb(1);
    }
}
