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
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
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
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.data.UserData;
import com.baidu.tbadk.data.h;
import com.baidu.tbadk.l.n;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.f;
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
/* loaded from: classes.dex */
public class MainTabActivity extends BaseFragmentActivity implements UserIconBox.b, VoiceManager.c, FrsCommonImageLayout.c, b {
    private static boolean gSP;
    private com.baidu.adp.lib.e.b<TbImageView> ayP;
    private CheckRealNameModel ccI;
    private com.baidu.tieba.write.c dBn;
    private ShareSuccessReplyToServerModel dBv;
    private com.baidu.tieba.ueg.c dBw;
    private com.baidu.tieba.NEGFeedBack.a dmY;
    VoiceManager dmn;
    private as gSK;
    private e gSN;
    private a gSO;
    private com.baidu.adp.lib.e.b<TbImageView> gSR;
    private com.baidu.tieba.a gST;
    private FrameLayout gSU;
    private d gSW;
    private com.baidu.tbadk.BdToken.a gSX;
    private boolean gTh;
    private String gTm;
    private com.baidu.tieba.ueg.b gkF;
    private boolean gSG = false;
    private int gSH = -1;
    private boolean gSI = false;
    private String mFrom = null;
    private volatile boolean gSJ = false;
    private long gSL = 0;
    private long gSM = 0;
    private long gSQ = -1;
    private boolean gSS = false;
    private String gSV = "";
    boolean gSY = false;
    boolean cdG = false;
    private CustomMessageListener gSZ = new CustomMessageListener(2010045) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && MainTabActivity.this.gSN != null && TbadkCoreApplication.getInst().getCurrentActivity() == MainTabActivity.this) {
                MainTabActivity.this.gSY = com.baidu.adp.lib.g.b.c(customResponsedMessage.getData().toString(), false);
                MainTabActivity.this.gSN.onKeyboardVisibilityChanged((MainTabActivity.this.gSY || MainTabActivity.this.cdG) ? true : true);
            }
        }
    };
    private final CustomMessageListener gTa = new CustomMessageListener(2001377) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.12
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
                        MainTabActivity.this.gSN.ayR().cB(1);
                    } else if (TbadkCoreApplication.getInst().isThemeIconCover()) {
                        MainTabActivity.this.gSN.ayR().cB(2);
                    } else {
                        MainTabActivity.this.gSN.ayR().cB(1);
                    }
                }
            }
        }
    };
    public CustomMessageListener gTb = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && MainTabActivity.this.gSN != null && MainTabActivity.this.gSN.ayR() != null) {
                if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    MainTabActivity.this.gSN.ayR().getTabWrapper().animate().translationY(MainTabActivity.this.gSN.ayR().getTabWrapper().getHeight()).setDuration(200L).start();
                } else {
                    MainTabActivity.this.gSN.ayR().getTabWrapper().animate().translationY(0.0f).setDuration(400L).start();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c eyf = new com.baidu.adp.framework.listener.c(1001) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ConfigVersion configVersion;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                if (socketResponsedMessage.getError() == 0 && (configVersion = responseOnlineMessage.getConfigVersion()) != null) {
                    MainTabActivity.this.uk(configVersion.sync);
                }
            }
        }
    };
    private CustomMessageListener gTc = new CustomMessageListener(2001609) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.30
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
                    k.a(substring2, substring, substring4, new Integer(substring3).intValue(), MainTabActivity.this.getPageContext());
                }
            }
        }
    };
    private final CustomMessageListener gTd = new CustomMessageListener(2001247) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getData() instanceof PayMemberInfoData) {
                    MainTabActivity.this.a((PayMemberInfoData) customResponsedMessage.getData());
                    TbadkCoreApplication.getInst().setPaymemberInfo((PayMemberInfoData) customResponsedMessage.getData());
                }
                UserData IJ = com.baidu.tbadk.getUserInfo.b.IH().IJ();
                if (TbadkCoreApplication.isLogin() && IJ != null && IJ.getUserId() != null && !IJ.getUserId().equals(MainTabActivity.this.gSV) && IJ.getIsGodInvited()) {
                    MainTabActivity.this.gSV = IJ.getUserId();
                    MainTabActivity.this.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(MainTabActivity.this.getPageContext().getPageActivity(), "", TbWebViewActivityConfig.GOD_INVITE_JUMP_URL + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE, true)));
                }
            }
        }
    };
    private CustomMessageListener dnt = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                MainTabActivity.this.gSN.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    final CustomMessageListener gTe = new CustomMessageListener(2007002) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.tbadk.mainTab.b> sE;
            MainTabActivity.this.gSJ = false;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (sE = ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).sE()) != null && sE.size() != 0) {
                MainTabActivity.this.gSN.aj(sE);
                if (MainTabActivity.this.gSI) {
                    MainTabActivity.this.gSN.ayR().setCurrentTabByType(MainTabActivity.this.gSH);
                } else {
                    MainTabActivity.this.Y(MainTabActivity.this.getIntent());
                }
                MainTabActivity.this.gSI = false;
                MainTabActivity.this.gSN.byj();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, null));
            }
        }
    };
    final CustomMessageListener gTf = new CustomMessageListener(2007013) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007013) {
                MainTabActivity.this.aWt();
                if (MainTabActivity.this.gSN != null && MainTabActivity.this.gSN.ayR() != null) {
                    MainTabActivity.this.gSH = MainTabActivity.this.gSN.ayR().getCurrentTabType();
                }
                MainTabActivity.this.gSI = true;
            }
        }
    };
    final CustomMessageListener gTg = new CustomMessageListener(2921333) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (MainTabActivity.this.gSK != null || (customResponsedMessage.getData() instanceof as)) {
                    if (customResponsedMessage.getData() != null) {
                        MainTabActivity.this.gSK = (as) customResponsedMessage.getData();
                    }
                    if (!MainTabActivity.this.gSJ && MainTabActivity.this.gSK != null && TbadkCoreApplication.isLogin()) {
                        MainTabActivity.this.gSW.c(MainTabActivity.this.gSK.recom_title, MainTabActivity.this.gSK.recom_topic, MainTabActivity.this.gSK.agX);
                    }
                }
            }
        }
    };
    private final CustomMessageListener gTi = new CustomMessageListener(2007005) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.e.b.xR() == null) {
                c cVar = new c();
                cVar.a(MainTabActivity.this);
                com.baidu.tbadk.core.e.b.a(cVar);
            }
        }
    };
    private CheckRealNameModel.a gTj = new CheckRealNameModel.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.8
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            if (CheckRealNameModel.TYPE_APP_FIRST_START.equals(str2) && i == 1990055) {
                TiebaStatic.log("c12138");
                MainTabActivity.this.gSN.um(MainTabActivity.this.getResources().getString(f.j.check_real_name_message));
            }
        }
    };
    private CustomMessageListener aaz = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && l.jV()) {
                MainTabActivity.this.aeQ();
                if (!MainTabActivity.gSP) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
                }
            }
        }
    };
    private CustomMessageListener bxA = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                MainTabActivity.this.gSS = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
                com.baidu.tbadk.core.sharedPref.b.getInstance().remove("key_feedback_tip");
                com.baidu.tbadk.core.sharedPref.b.getInstance().remove("key_feedback_tip_show");
                com.baidu.tbadk.core.sharedPref.b.getInstance().remove("key_feedback_tip_tab_show");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016560));
                if (MainTabActivity.this.gSX != null) {
                    MainTabActivity.this.gSX.check();
                }
            }
        }
    };
    private CustomMessageListener gTk = new CustomMessageListener(2016509) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                o.aoD = ((Boolean) customResponsedMessage.getData()).booleanValue();
                MainTabActivity.this.bxW();
            }
        }
    };
    private final CustomMessageListener gTl = new CustomMessageListener(2001230) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", booleanValue);
                MainTabActivity.this.gSN.mE(booleanValue);
            }
        }
    };
    private CustomMessageListener cIM = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.25
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                boolean unused = MainTabActivity.gSP = true;
                if (MainTabActivity.this.gSN != null && MainTabActivity.this.gSN.byk() != null && MainTabActivity.this.gSN.byk().getAnimationView() != null && MainTabActivity.this.gSN.byk().getAnimationView().getVisibility() != 0) {
                    MainTabActivity.this.gSN.byk().setLottieView(false);
                }
                if (!TbadkCoreApplication.getInst().getActivityPrizeData().BA()) {
                    if (MainTabActivity.this.gSN != null) {
                        MainTabActivity.this.gSN.ul(null);
                    }
                } else {
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getInst().getActivityPrizeData().BE()) {
                        String BD = TbadkCoreApplication.getInst().getActivityPrizeData().BD();
                        if (!StringUtils.isNull(BD) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("activity_prize_get_tip" + TbadkCoreApplication.getCurrentAccount(), true)) {
                            az.zI().a(MainTabActivity.this.getPageContext(), new String[]{BD}, true);
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("activity_prize_get_tip" + TbadkCoreApplication.getCurrentAccount(), false);
                        }
                    }
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                        if (MainTabActivity.this.gSN != null) {
                            MainTabActivity.this.gSN.ul(null);
                        }
                    } else {
                        String BG = TbadkCoreApplication.getInst().getActivityPrizeData().BG();
                        if (!StringUtils.isNull(BG)) {
                            if (MainTabActivity.this.gSN != null) {
                                MainTabActivity.this.gSN.ul(BG);
                            }
                        } else if (MainTabActivity.this.gSN != null) {
                            MainTabActivity.this.gSN.ul(null);
                        }
                    }
                }
                if (TbSingleton.getInstance().canShowPermDialog()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921360, MainTabActivity.this));
                }
            }
        }
    };
    private CustomMessageListener gTn = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    MainTabActivity.this.gTm = UtilHelper.getCurrentDay();
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("last_resume_time", TbSingleton.getInstance().getLastResumeTime());
                    return;
                }
                String currentDay = UtilHelper.getCurrentDay();
                if (!StringUtils.isNull(currentDay) && !currentDay.equals(MainTabActivity.this.gTm)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
                }
                if (MainTabActivity.this.gkF == null) {
                    MainTabActivity.this.gkF = new com.baidu.tieba.ueg.b();
                }
                MainTabActivity.this.gkF.uu(MainTabActivity.this.gkF.haV);
                MainTabActivity.this.gkF.haV = at.a.arw;
            }
        }
    };
    private final CustomMessageListener giR = new CustomMessageListener(2016493) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.27
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            h hVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof h) && (hVar = (h) customResponsedMessage.getData()) != null && !StringUtils.isNull(hVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(hVar);
                if (StringUtils.isNull(hVar.aLf)) {
                    az.zI().c(MainTabActivity.this.getPageContext(), new String[]{hVar.mLink});
                } else {
                    az.zI().c(MainTabActivity.this.getPageContext(), new String[]{hVar.mLink, hVar.aLf});
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void uk(String str) {
        if (str != null && TbadkCoreApplication.getInst().getConfigVersion() != null && bxV()) {
            this.gSQ = System.currentTimeMillis();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
        }
    }

    private boolean bxV() {
        if (-1 == this.gSQ) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.gSQ;
        return currentTimeMillis <= 0 || currentTimeMillis >= ReportUserInfoModel.TIME_INTERVAL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxW() {
        if (com.baidu.adp.lib.b.d.hv().ax("android_game_enter_switch") == 1 && o.aoD) {
            this.gSN.mC(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016510));
            return;
        }
        this.gSN.mC(false);
        this.gSN.mE(false);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
    }

    public void a(PayMemberInfoData payMemberInfoData) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && payMemberInfoData != null) {
            if ((payMemberInfoData.GT() == 1 || payMemberInfoData.GT() == 2) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_member_deid_line", true)) {
                long tB = payMemberInfoData.tB() * 1000;
                if (tB < System.currentTimeMillis()) {
                    if (StringUtils.isNull(payMemberInfoData.GU())) {
                        payMemberInfoData.go(getPageContext().getString(f.j.member));
                    } else {
                        payMemberInfoData.go(payMemberInfoData.GU() + getPageContext().getString(f.j.member_already_Expire));
                    }
                    this.gSN.a(payMemberInfoData, 0);
                } else if (tB - System.currentTimeMillis() < 259200000) {
                    if (StringUtils.isNull(payMemberInfoData.GU())) {
                        payMemberInfoData.go(getPageContext().getString(f.j.member));
                    } else {
                        payMemberInfoData.go(payMemberInfoData.GU() + getPageContext().getString(f.j.member_will_Expire));
                    }
                    this.gSN.a(payMemberInfoData, 1);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.gTh) {
            return false;
        }
        if (this.gSN.ayR() == null || this.gSN.ayR().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1 || !this.gSN.aWx()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public void ayO() {
        if (this.gSW != null) {
            this.gSW.bxU();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
        if (this.dBn == null) {
            this.dBn = new com.baidu.tieba.write.c(getPageContext(), this.gSU, "main_tab");
            this.dBn.vB("1");
        }
        if (!this.dBw.bzL()) {
            this.dBn.np(false);
        }
    }

    protected void aWt() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007002, new com.baidu.tbadk.mainTab.d(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        n.KO().ap(System.currentTimeMillis());
        if (TbadkCoreApplication.getInst().getIsFirstUse()) {
            v.a(new u<Object>() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.5
                @Override // com.baidu.tbadk.util.u
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
        if (getIntent() == null) {
            i = -1;
        } else {
            Q(getIntent());
            i = getIntent().getIntExtra("locate_type", 0);
            if (i == 200) {
                finish();
                return;
            }
            this.mFrom = getIntent().getStringExtra("from");
            if ("from_tieba_kuang".equals(this.mFrom) && this.mFrom != null) {
                TiebaStatic.log(new an("c12264").r("obj_type", 3));
                KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
                if (KuangFloatingViewController.getInstance().init()) {
                    ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.6
                        @Override // com.baidu.tbadk.core.e
                        public void ak(boolean z) {
                            if (z) {
                                KuangFloatingViewController.getInstance().showFloatingView();
                            }
                        }
                    });
                }
            }
        }
        c cVar = new c();
        com.baidu.tbadk.core.e.b.a(cVar);
        cVar.a(this);
        if (bxX()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        setContentView(f.h.maintabs_activity);
        this.gSU = (FrameLayout) findViewById(f.g.maintabContainer);
        com.baidu.tbadk.core.a.a.tk().tl();
        this.gSN = new e(this);
        this.gSW = new d(this);
        this.gSN.mB(this.mIsLogin);
        bxW();
        aGO();
        com.baidu.tieba.tblauncher.alarmRemind.b.byp().e(this);
        this.gST = new com.baidu.tieba.a();
        aWt();
        aWQ();
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (bundle != null) {
            i = bundle.getInt("locate_type", 1);
            intent.putExtra("locate_type", i);
        }
        this.gTm = UtilHelper.getCurrentDay();
        this.gSQ = System.currentTimeMillis();
        MessageManager.getInstance().sendMessage(new CustomMessage(2921359));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
        if (TbadkCoreApplication.getFrom() != null && TbadkCoreApplication.getFrom().equals("aishide")) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005011, null));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005013, null));
        MessageManager.getInstance().registerStickyMode(2001404);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001404));
        i(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        com.baidu.tbadk.browser.a.aB(getPageContext().getPageActivity());
        String installOtherApp = TbadkCoreApplication.getInst().getInstallOtherApp();
        if (installOtherApp != null && installOtherApp.length() > 0) {
            UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), installOtherApp);
            TbadkCoreApplication.getInst().setInstallOtherApp(null);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.7
            @Override // java.lang.Runnable
            public void run() {
                MainTabActivity.this.gTh = true;
            }
        });
        registerListener(this.eyf);
        if (i == 1) {
            this.gSN.mD(true);
        } else {
            this.gSN.mD(false);
        }
        this.gSN.byl();
        this.dmn = getVoiceManager();
        if (this.dmn != null) {
            this.dmn.onCreate(getPageContext());
        }
        registerListener(this.bxA);
        adjustResizeForSoftInput();
        addGlobalLayoutListener();
        MessageManager.getInstance().registerStickyMode(2007015);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007015));
        if (TbadkCoreApplication.isLogin()) {
            n.KO().KP();
        }
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.getUserInfo.b.IH().II();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016480));
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("app_restart_times", com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("app_restart_times", 0) + 1);
        this.ccI = new CheckRealNameModel(getPageContext());
        this.ccI.a(this.gTj);
        aeQ();
        this.dmY = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "homepage");
        this.dBv = new ShareSuccessReplyToServerModel();
        this.dBw = new com.baidu.tieba.ueg.c(getPageContext());
        this.gSX = new com.baidu.tbadk.BdToken.a(getPageContext());
        this.gSX.check();
        n.KO().aq(System.currentTimeMillis());
        MessageManager.getInstance().registerListener(this.giR);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public ViewGroup getActivityRootView() {
        return this.gSU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeQ() {
        String str = "check_real_name" + TbConfig.getVersion();
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(str, true) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && l.jV()) {
            this.ccI.qj(CheckRealNameModel.TYPE_APP_FIRST_START);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(str, false);
        }
    }

    private void Q(Intent intent) {
        if (intent != null) {
            String dataString = intent.getDataString();
            if (!StringUtils.isNull(dataString) && dataString.startsWith("tbmaintab://")) {
                String decode = Uri.decode(intent.getData().getEncodedPath());
                if (StringUtils.isNull(decode)) {
                    TiebaStatic.log(new an("c10320").r("obj_type", 1).r("obj_to", 1));
                    return;
                }
                if (decode.startsWith("//")) {
                    decode = decode.substring(2);
                }
                Map<String, String> eP = az.eP(decode);
                if (eP != null) {
                    String str = eP.get("fr");
                    if (!"mpush".equals(str) && "bpush".equals(str)) {
                        an anVar = new an("c10320");
                        anVar.ae("obj_locate", eP.get("obj_locate"));
                        anVar.r("obj_type", 1);
                        anVar.ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eP.get(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
                        anVar.ae("obj_param2", eP.get("obj_param2"));
                        anVar.r("obj_to", 1);
                        anVar.ae(VideoPlayActivityConfig.OBJ_ID, eP.get("bdid"));
                        if (!ap.isEmpty(eP.get("ext_log"))) {
                            try {
                                JSONObject jSONObject = new JSONObject(eP.get("ext_log"));
                                Iterator<String> keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    anVar.ae(next, jSONObject.getString(next));
                                }
                            } catch (Exception e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        TiebaStatic.log(anVar);
                        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SCHEMA_UPLOAD);
                        httpMessage.addParam("call_url", dataString);
                        MessageManager.getInstance().sendMessage(httpMessage);
                    }
                }
            } else if (!StringUtils.isNull(dataString)) {
                if (dataString.startsWith("tbclient://") || dataString.startsWith("tbclient_zm://")) {
                    String dataString2 = intent.getDataString();
                    if (!StringUtils.isNull(dataString2)) {
                        az.zI().c(getPageContext(), new String[]{dataString2});
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
        this.dmn = getVoiceManager();
        if (this.dmn != null) {
            this.dmn.onStart(getPageContext());
        }
    }

    public boolean bxX() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005010, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005012, null));
        aGP();
        com.baidu.tbadk.coreExtra.messageCenter.a.Dl().Dx();
        com.baidu.tbadk.coreExtra.messageCenter.a.Dl().Dr();
        com.baidu.tbadk.coreExtra.messageCenter.a.Dl().bc(false);
        MessageManager.getInstance().unRegisterListener(this.giR);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.aN(false);
            this.mWaitingDialog = null;
        }
        bxY();
        if (this.gSN != null) {
            this.gSN.onDestroy();
        }
        if (this.gSW != null) {
            this.gSW.onDestroy();
        }
        try {
            super.onDestroy();
        } catch (Exception e) {
        }
        com.baidu.tbadk.core.e.b.a(null);
        this.dmn = getVoiceManager();
        if (this.dmn != null) {
            this.dmn.onDestory(getPageContext());
        }
        if (this.dBn != null) {
            this.dBn.onDestroy();
        }
        if (this.dmY != null) {
            this.dmY.onDestroy();
        }
        if (this.dBv != null) {
            this.dBv.cancelLoadData();
        }
        if (this.gSX != null) {
            this.gSX.onDestroy();
        }
        if (this.gkF != null) {
            this.gkF.onDestroy();
        }
        if (this.gSN != null && this.gSN.byk() != null) {
            this.gSN.byk().onDestory();
        }
        System.gc();
    }

    private void bxY() {
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

    private void aGO() {
        registerListener(this.gTa);
        this.gTe.setPriority(100);
        registerListener(this.gTe);
        registerListener(this.gTf);
        registerListener(this.gTg);
        registerListener(this.gTi);
        registerListener(this.gTk);
        registerListener(this.gTl);
        registerListener(this.gTd);
        registerListener(this.skinTypeChangeListener);
        registerListener(this.gTb);
        registerListener(this.aaz);
        this.gSO = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.gSO, intentFilter);
        registerListener(this.dnt);
        registerListener(this.gTc);
        registerListener(this.cIM);
        registerListener(this.aaz);
        registerListener(this.gTn);
        this.gSZ.setTag(getUniqueId());
        registerListener(this.gSZ);
    }

    private void aGP() {
        if (this.gSO != null) {
            unregisterReceiver(this.gSO);
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
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gSN != null && this.gSN.byk() != null) {
            this.gSN.byk().setLottieView(true);
        }
        if (this.gSN != null && this.gSN.ayR() != null) {
            this.gSH = this.gSN.ayR().getCurrentTabType();
        }
        changeSkinType(this.mSkinType);
        if (TbadkCoreApplication.isLogin() && n.KO().KN()) {
            n.KO().KP();
        }
        this.dmn = getVoiceManager();
        if (this.dmn != null) {
            this.dmn.onResume(getPageContext());
        }
        if (this.gSN != null) {
            this.gSN.byl();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001385, getActivity()));
        if (KuangFloatingViewController.getInstance().init()) {
            ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.10
                @Override // com.baidu.tbadk.core.e
                public void ak(boolean z) {
                    if (z) {
                        KuangFloatingViewController.getInstance().showFloatingView();
                    }
                }
            });
        }
        if (TbadkCoreApplication.getKeepLiveSwitch(getApplicationContext())) {
            com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.11
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921300, Boolean.FALSE));
                }
            }, 3000L);
        }
        n.KO().KP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.gSS = true;
        if (z) {
            com.baidu.tbadk.getUserInfo.b.IH().II();
            bxW();
            aeQ();
        }
        this.gSN.switchNaviBarStatus(z);
        aWt();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (this.gSG) {
            this.gSG = false;
            CompatibleUtile.setAnim(getPageContext().getPageActivity(), f.a.down, f.a.hold);
        }
        this.dmn = getVoiceManager();
        if (this.dmn != null) {
            this.dmn.onPause(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921003));
        if (this.gSW != null) {
            this.gSW.bfi();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
        } catch (Exception e) {
        }
        bundle.putInt("locate_type", this.gSN.ayR().getCurrentTabType());
        bundle.putParcelable("android:fragments", null);
        bundle.putParcelable("android:support:fragments", null);
        this.dmn = getVoiceManager();
        if (this.dmn != null) {
            this.dmn.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.dmn = getVoiceManager();
        if (this.dmn != null) {
            this.dmn.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Q(intent);
        setIntent(intent);
        com.baidu.tbadk.getUserInfo.b.IH().II();
        if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007008));
            aWt();
        }
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
                intExtra = this.gST.OA();
            }
            if (this.gSN != null && this.gSN.ayR() != null) {
                this.gSN.ayR().setCurrentTabByType(intExtra);
            }
        }
        i(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        if (this.gSN != null) {
            this.gSN.byl();
        }
        this.mFrom = getIntent().getStringExtra("from");
        if ("from_tieba_kuang".equals(this.mFrom) && this.mFrom != null) {
            TiebaStatic.log(new an("c12264").r("obj_type", 3));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            if (KuangFloatingViewController.getInstance().init()) {
                ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.13
                    @Override // com.baidu.tbadk.core.e
                    public void ak(boolean z) {
                        if (z) {
                            KuangFloatingViewController.getInstance().showFloatingView();
                        }
                    }
                });
            }
        }
    }

    protected void H(Activity activity) {
        new com.baidu.tbadk.core.dialog.a(activity).ce(f.j.confirm_title).av(false).cf(f.j.background_process_permission).a(f.j.now_goto_setting, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.15
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                try {
                    MainTabActivity.this.startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
                    aVar.dismiss();
                } catch (Exception e) {
                    MainTabActivity.this.showToast(f.j.goto_developActivity_error_toast);
                }
            }
        }).b(f.j.next_time, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.14
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                MainTabActivity.this.bxZ();
            }
        }).b(i.ad(activity)).xe();
    }

    protected void bxZ() {
        com.baidu.adp.lib.f.c.ih().d(getUniqueId());
        byb();
        moveTaskToBack(true);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.k kVar) {
        super.onPreLoad(kVar);
        ae.a(kVar, getUniqueId());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!MainTabActivityConfig.IS_BACK_CLOSE_ALL_ACTIVITY && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016322, (Class) null);
            if (runTask == null || !((Boolean) runTask.getData()).booleanValue()) {
                if (this.dBn != null && this.dBn.isShowing()) {
                    this.dBn.bFv();
                    return true;
                } else if (this.gSN.aWx()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007010));
                    return true;
                } else {
                    if (System.currentTimeMillis() - this.gSL > 2000) {
                        showToast(f.j.double_back_quit);
                        this.gSL = System.currentTimeMillis();
                    } else if (UtilHelper.isBackgroundProcessLimitNone() && Build.VERSION.SDK_INT >= 14) {
                        H(getPageContext().getPageActivity());
                        return true;
                    } else {
                        bxZ();
                    }
                    return false;
                }
            }
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(Intent intent) {
        try {
            this.gSN.ayR().setCurrentTabByType(this.gST.OA());
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

    private void aWQ() {
        registerListener(new CustomMessageListener(2007009) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Integer) {
                    Integer num = (Integer) customResponsedMessage.getData();
                    if (num.intValue() == 2) {
                        MainTabActivity.this.gSN.mD(true);
                        MainTabActivity.this.gSN.iQ(true);
                    } else if (num.intValue() == 1) {
                        MainTabActivity.this.gSN.mD(true);
                        MainTabActivity.this.gSN.iQ(false);
                    } else {
                        MainTabActivity.this.gSN.mD(false);
                        MainTabActivity.this.gSN.iQ(false);
                    }
                    MainTabActivity.this.gSN.byl();
                }
            }
        });
    }

    protected void bya() {
        AntiData antiData = new AntiData();
        antiData.setIfpost(1);
        if (antiData.getIfpost() == 0) {
            l.showToast(getPageContext().getPageActivity(), antiData.getForbid_info());
            return;
        }
        antiData.setIfVoice(false);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteActivityConfig(getPageContext().getPageActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, antiData, 13003, true, false, null, false, false, null, null, null, 0)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 != -1) {
            if (this.gSN.ayR().getCurrentFragment() != null) {
                this.gSN.ayR().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 11001) {
            bya();
        } else if (i == 13003) {
            Z(intent);
        } else if (i == 23007) {
            J(intent);
        } else if (i == 13011) {
            com.baidu.tieba.n.a.bmW().x(getPageContext());
        } else if (i == 24007) {
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1) {
                com.baidu.tieba.n.a.bmW().x(getPageContext());
                com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                if (shareItem != null && shareItem.linkUrl != null && this.dBv != null) {
                    this.dBv.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.17
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void Es() {
                        }

                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void a(final CustomDialogData customDialogData) {
                            com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.17.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a(MainTabActivity.this.getPageContext(), customDialogData).show();
                                }
                            }, 1000L);
                        }
                    });
                }
            }
        } else if (this.gSN.ayR().getCurrentFragment() != null) {
            this.gSN.ayR().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    private ShareFromPBMsgData azw() {
        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.imageUri == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.imageUri.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.aGe);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.aGa);
        shareFromPBMsgData.setThreadId(shareItem.tid);
        return shareFromPBMsgData;
    }

    private void J(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(azw(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.ch(1);
            aVar.w(thread2GroupShareView);
            aVar.a(f.j.share, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.18
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MainTabActivity.this.HidenSoftKeyPad((InputMethodManager) MainTabActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(MainTabActivity.this.getPageContext().getPageActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.Fz() != null) {
                        Bundle Fz = shareItem.Fz();
                        TiebaStatic.log(new an("share_success").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_type", Fz.getInt("obj_type")).r("obj_param1", 3).ae(ImageViewerConfig.FORUM_ID, Fz.getString(ImageViewerConfig.FORUM_ID)).ae("tid", Fz.getString("tid")));
                    }
                }
            });
            aVar.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.19
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MainTabActivity.this.HidenSoftKeyPad((InputMethodManager) MainTabActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.aw(true);
            aVar.b(getPageContext()).xe();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.D(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        TbSingleton.getInstance().clearVideoRecord();
        super.finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.gSN.onChangeSkinType(i);
        adjustResizeForSoftInputOnSkinTypeChanged(i);
        if (this.dBn != null) {
            this.dBn.onChangeSkinType();
        }
    }

    private void Z(Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        if (intent != null) {
            try {
                postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
            } catch (Exception e) {
                BdLog.e(e);
                postWriteCallBackData = null;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921030, postWriteCallBackData));
            if (this.gSN != null && !this.gSN.d(postWriteCallBackData)) {
                this.gSN.b(postWriteCallBackData);
            }
        }
    }

    private void byb() {
        if (System.currentTimeMillis() - this.gSM >= 7200000) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage(2006002, hashMap));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005013, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            this.gSM = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.b
    public int getCurrentTabType() {
        if (this.gSN.ayR() != null) {
            return this.gSN.ayR().getCurrentTabType();
        }
        return -1;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dmn == null) {
            this.dmn = VoiceManager.instance();
        }
        return this.dmn;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public ListView AP() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> AQ() {
        if (this.ayP == null) {
            this.ayP = UserIconBox.i(getPageContext().getPageActivity(), 8);
        }
        return this.ayP;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> atL() {
        if (this.gSR == null) {
            this.gSR = FrsCommonImageLayout.p(getPageContext().getPageActivity(), 12);
        }
        return this.gSR;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.20
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean Kl() {
                return true;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int Km() {
                return com.baidu.tbadk.pageStayDuration.e.Kq().Ks();
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
        if (this.gSS && currentPageSourceKeyList != null) {
            currentPageSourceKeyList.clear();
            this.gSS = false;
            return null;
        }
        return currentPageSourceKeyList;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onKeyboardVisibilityChanged(boolean z) {
        this.cdG = z;
        boolean z2 = this.gSY || this.cdG;
        if (this.gSN != null) {
            this.gSN.onKeyboardVisibilityChanged(z2);
        }
    }
}
