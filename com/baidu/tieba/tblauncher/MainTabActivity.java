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
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.ExitAppMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.data.UserData;
import com.baidu.tbadk.data.h;
import com.baidu.tbadk.data.k;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.p;
import com.baidu.tbadk.util.z;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.Thread2GroupShareView;
import com.baidu.tieba.write.e;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import protobuf.ConfigVersion;
/* loaded from: classes4.dex */
public class MainTabActivity extends BaseFragmentActivity implements com.baidu.tbadk.core.util.e.c, UserIconBox.b, VoiceManager.c, FrsCommonImageLayout.c, com.baidu.tieba.tblauncher.a {
    private static boolean iLD;
    private com.baidu.adp.lib.e.b<TbImageView> bTV;
    private boolean bkc;
    private CheckRealNameModel dKY;
    private com.baidu.tieba.ueg.c eCs;
    VoiceManager eYE;
    private com.baidu.tieba.NEGFeedBack.a eZv;
    private e fcg;
    private ShareSuccessReplyToServerModel fot;
    private d iLB;
    private a iLC;
    private com.baidu.adp.lib.e.b<TbImageView> iLF;
    private com.baidu.tieba.a iLH;
    private FrameLayout iLI;
    private c iLK;
    private com.baidu.tbadk.BdToken.d iLL;
    private av iLy;
    private String iMa;
    private com.baidu.tieba.ueg.b icV;
    private boolean iLu = false;
    private int iLv = -1;
    private boolean iLw = false;
    private String mFrom = null;
    private volatile boolean iLx = false;
    private long iLz = 0;
    private long iLA = 0;
    private long iLE = -1;
    private boolean iLG = false;
    private String iLJ = "";
    boolean iLM = false;
    boolean dMb = false;
    private CustomMessageListener iLN = new CustomMessageListener(2010045) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && MainTabActivity.this.iLB != null && TbadkCoreApplication.getInst().getCurrentActivity() == MainTabActivity.this) {
                MainTabActivity.this.iLM = com.baidu.adp.lib.g.b.e(customResponsedMessage.getData().toString(), false);
                MainTabActivity.this.iLB.onKeyboardVisibilityChanged((MainTabActivity.this.iLM || MainTabActivity.this.dMb) ? true : true);
            }
        }
    };
    private final CustomMessageListener iLO = new CustomMessageListener(2001377) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.12
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
                        MainTabActivity.this.iLB.bed().gY(1);
                    } else if (TbadkCoreApplication.getInst().isThemeIconCover()) {
                        MainTabActivity.this.iLB.bed().gY(2);
                    } else {
                        MainTabActivity.this.iLB.bed().gY(1);
                    }
                }
            }
        }
    };
    public CustomMessageListener iLP = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && MainTabActivity.this.iLB != null && MainTabActivity.this.iLB.bed() != null) {
                if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    MainTabActivity.this.iLB.bed().getTabWrapper().animate().translationY(MainTabActivity.this.iLB.bed().getTabWrapper().getHeight()).setDuration(200L).start();
                } else {
                    MainTabActivity.this.iLB.bed().getTabWrapper().animate().translationY(0.0f).setDuration(400L).start();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c goN = new com.baidu.adp.framework.listener.c(1001) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ConfigVersion configVersion;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                if (socketResponsedMessage.getError() == 0 && (configVersion = responseOnlineMessage.getConfigVersion()) != null) {
                    MainTabActivity.this.CW(configVersion.sync);
                }
            }
        }
    };
    private CustomMessageListener iLQ = new CustomMessageListener(2001609) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof h)) {
                h hVar = (h) customResponsedMessage.getData();
                String link = hVar.getLink();
                int indexOf = link.indexOf("?pid=");
                int indexOf2 = link.indexOf("&tid=");
                int indexOf3 = link.indexOf("&threadtype=");
                int indexOf4 = link.indexOf("&jump_type=");
                String substring = link.substring(indexOf + 5, indexOf2);
                String substring2 = link.substring(indexOf2 + 5, indexOf3);
                String substring3 = link.substring(indexOf3 + 12, indexOf4);
                String substring4 = link.substring(indexOf4 + 11, link.indexOf("&jump_tieba_native"));
                if (!StringUtils.isNull(substring3)) {
                    int l = com.baidu.adp.lib.g.b.l(substring3, 0);
                    if (hVar.getPageContext() != null) {
                        p.a(substring2, substring, substring4, l, hVar.getPageContext());
                    } else {
                        p.a(substring2, substring, substring4, l, MainTabActivity.this.getPageContext());
                    }
                }
            }
        }
    };
    private final CustomMessageListener iLR = new CustomMessageListener(2001247) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getData() instanceof PayMemberInfoData) {
                    MainTabActivity.this.a((PayMemberInfoData) customResponsedMessage.getData());
                    TbadkCoreApplication.getInst().setPaymemberInfo((PayMemberInfoData) customResponsedMessage.getData());
                }
                UserData ang = com.baidu.tbadk.getUserInfo.b.ane().ang();
                if (TbadkCoreApplication.isLogin() && ang != null && ang.getUserId() != null && !ang.getUserId().equals(MainTabActivity.this.iLJ) && ang.getIsGodInvited()) {
                    MainTabActivity.this.iLJ = ang.getUserId();
                    MainTabActivity.this.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(MainTabActivity.this.getPageContext().getPageActivity(), "", TbWebViewActivityConfig.GOD_INVITE_JUMP_URL + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE, true)));
                }
            }
        }
    };
    private CustomMessageListener eZS = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                MainTabActivity.this.iLB.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    final CustomMessageListener iLS = new CustomMessageListener(2007002) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.tbadk.mainTab.b> list;
            MainTabActivity.this.iLx = false;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (list = ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).getList()) != null && list.size() != 0) {
                MainTabActivity.this.iLB.am(list);
                if (MainTabActivity.this.iLw) {
                    MainTabActivity.this.iLB.bed().setCurrentTabByType(MainTabActivity.this.iLv);
                } else if (MainTabActivity.this.getActivity().getIntent() == null || MainTabActivity.this.getActivity().getIntent().getDataString() == null || !MainTabActivity.this.getActivity().getIntent().getDataString().startsWith("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                    MainTabActivity.this.at(MainTabActivity.this.getIntent());
                } else {
                    MainTabActivity.this.iLB.bed().setCurrentTabByType(2);
                }
                MainTabActivity.this.iLw = false;
                MainTabActivity.this.iLB.cgH();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, null));
            }
        }
    };
    final CustomMessageListener iLT = new CustomMessageListener(2007013) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007013) {
                MainTabActivity.this.bEV();
                if (MainTabActivity.this.iLB != null && MainTabActivity.this.iLB.bed() != null) {
                    MainTabActivity.this.iLv = MainTabActivity.this.iLB.bed().getCurrentTabType();
                }
                MainTabActivity.this.iLw = true;
            }
        }
    };
    final CustomMessageListener iLU = new CustomMessageListener(2921333) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (MainTabActivity.this.iLy != null || (customResponsedMessage.getData() instanceof av)) {
                    if (customResponsedMessage.getData() != null) {
                        MainTabActivity.this.iLy = (av) customResponsedMessage.getData();
                    }
                    if (!MainTabActivity.this.iLx && MainTabActivity.this.iLy != null && TbadkCoreApplication.isLogin()) {
                        MainTabActivity.this.iLK.i(MainTabActivity.this.iLy.recom_title, MainTabActivity.this.iLy.recom_topic, MainTabActivity.this.iLy.bAj);
                    }
                }
            }
        }
    };
    private final CustomMessageListener iLV = new CustomMessageListener(2007005) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.e.b.abL() == null) {
                b bVar = new b();
                bVar.a(MainTabActivity.this);
                com.baidu.tbadk.core.e.b.a(bVar);
            }
        }
    };
    private CustomMessageListener iLW = new CustomMessageListener(2921380) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && !ap.isEmpty((String) customResponsedMessage.getData())) {
                String str = (String) customResponsedMessage.getData();
                if (KuangFloatingViewController.getInstance().init()) {
                    KuangFloatingViewController.getInstance().setInfo(str);
                    ((BaseFragmentActivity) MainTabActivity.this.getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.5.1
                        @Override // com.baidu.tbadk.core.e
                        public void df(boolean z) {
                            if (z) {
                                KuangFloatingViewController.getInstance().showFloatingView();
                                TiebaStatic.log(new am("c12264").T("obj_type", 3));
                            }
                        }
                    });
                }
            }
        }
    };
    private CheckRealNameModel.a iLX = new CheckRealNameModel.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.9
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            if (CheckRealNameModel.TYPE_APP_FIRST_START.equals(str2) && i == 1990055) {
                TiebaStatic.log("c12138");
                MainTabActivity.this.iLB.CY(MainTabActivity.this.getResources().getString(d.j.check_real_name_message));
            }
        }
    };
    private CustomMessageListener btv = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && l.lo()) {
                MainTabActivity.this.aMs();
                if (!MainTabActivity.iLD) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
                }
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                MainTabActivity.this.iLG = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
                com.baidu.tbadk.core.sharedPref.b.getInstance().remove("key_feedback_tip");
                com.baidu.tbadk.core.sharedPref.b.getInstance().remove("key_feedback_tip_show");
                com.baidu.tbadk.core.sharedPref.b.getInstance().remove("key_feedback_tip_tab_show");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016560));
                if (MainTabActivity.this.iLL != null) {
                    MainTabActivity.this.iLL.check();
                }
            }
        }
    };
    private CustomMessageListener iLY = new CustomMessageListener(2016509) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                n.bIF = ((Boolean) customResponsedMessage.getData()).booleanValue();
                MainTabActivity.this.cgu();
            }
        }
    };
    private final CustomMessageListener iLZ = new CustomMessageListener(2001230) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", booleanValue);
                MainTabActivity.this.iLB.qm(booleanValue);
            }
        }
    };
    private CustomMessageListener erX = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.25
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                boolean unused = MainTabActivity.iLD = true;
                if (MainTabActivity.this.iLB != null && MainTabActivity.this.iLB.cgI() != null && MainTabActivity.this.iLB.cgI().getAnimationView() != null && MainTabActivity.this.iLB.cgI().getAnimationView().getVisibility() != 0) {
                    MainTabActivity.this.iLB.cgI().setLottieView(false);
                }
                if (!TbadkCoreApplication.getInst().getActivityPrizeData().afM()) {
                    if (MainTabActivity.this.iLB != null) {
                        MainTabActivity.this.iLB.CX(null);
                    }
                } else {
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getInst().getActivityPrizeData().afQ()) {
                        String afP = TbadkCoreApplication.getInst().getActivityPrizeData().afP();
                        if (!StringUtils.isNull(afP) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("activity_prize_get_tip" + TbadkCoreApplication.getCurrentAccount(), true)) {
                            ba.adA().a(MainTabActivity.this.getPageContext(), new String[]{afP}, true);
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("activity_prize_get_tip" + TbadkCoreApplication.getCurrentAccount(), false);
                        }
                    }
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                        if (MainTabActivity.this.iLB != null) {
                            MainTabActivity.this.iLB.CX(null);
                        }
                    } else {
                        String afS = TbadkCoreApplication.getInst().getActivityPrizeData().afS();
                        if (!StringUtils.isNull(afS)) {
                            if (MainTabActivity.this.iLB != null) {
                                MainTabActivity.this.iLB.CX(afS);
                            }
                        } else if (MainTabActivity.this.iLB != null) {
                            MainTabActivity.this.iLB.CX(null);
                        }
                    }
                }
                if (TbSingleton.getInstance().canShowPermDialog()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921360, MainTabActivity.this));
                }
            }
        }
    };
    private CustomMessageListener iMb = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    MainTabActivity.this.iMa = UtilHelper.getCurrentDay();
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("last_resume_time", TbSingleton.getInstance().getLastResumeTime());
                    return;
                }
                String currentDay = UtilHelper.getCurrentDay();
                if (!StringUtils.isNull(currentDay) && !currentDay.equals(MainTabActivity.this.iMa)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
                }
                if (MainTabActivity.this.icV == null) {
                    MainTabActivity.this.icV = new com.baidu.tieba.ueg.b();
                }
                MainTabActivity.this.icV.Af(MainTabActivity.this.icV.iTH);
                MainTabActivity.this.icV.iTH = at.a.bLv;
            }
        }
    };
    private final CustomMessageListener gBp = new CustomMessageListener(2016493) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.27
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            k kVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof k) && (kVar = (k) customResponsedMessage.getData()) != null && !StringUtils.isNull(kVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(kVar);
                if (StringUtils.isNull(kVar.chx)) {
                    ba.adA().c(MainTabActivity.this.getPageContext(), new String[]{kVar.mLink});
                } else {
                    ba.adA().c(MainTabActivity.this.getPageContext(), new String[]{kVar.mLink, kVar.chx});
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void CW(String str) {
        if (str != null && TbadkCoreApplication.getInst().getConfigVersion() != null && cgt()) {
            this.iLE = System.currentTimeMillis();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
        }
    }

    private boolean cgt() {
        if (-1 == this.iLE) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.iLE;
        return currentTimeMillis <= 0 || currentTimeMillis >= ReportUserInfoModel.TIME_INTERVAL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgu() {
        if (com.baidu.adp.lib.b.d.iQ().aO("android_game_enter_switch") == 1 && n.bIF) {
            this.iLB.qk(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016510));
            return;
        }
        this.iLB.qk(false);
        this.iLB.qm(false);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
    }

    public void a(PayMemberInfoData payMemberInfoData) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && payMemberInfoData != null) {
            if ((payMemberInfoData.alm() == 1 || payMemberInfoData.alm() == 2) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_member_deid_line", true)) {
                long WU = payMemberInfoData.WU() * 1000;
                if (WU < System.currentTimeMillis()) {
                    if (StringUtils.isNull(payMemberInfoData.aln())) {
                        payMemberInfoData.ow(getPageContext().getString(d.j.member));
                    } else {
                        payMemberInfoData.ow(payMemberInfoData.aln() + getPageContext().getString(d.j.member_already_Expire));
                    }
                    this.iLB.a(payMemberInfoData, 0);
                } else if (WU - System.currentTimeMillis() < 259200000) {
                    if (StringUtils.isNull(payMemberInfoData.aln())) {
                        payMemberInfoData.ow(getPageContext().getString(d.j.member));
                    } else {
                        payMemberInfoData.ow(payMemberInfoData.aln() + getPageContext().getString(d.j.member_will_Expire));
                    }
                    this.iLB.a(payMemberInfoData, 1);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.bkc) {
            return false;
        }
        if (this.iLB.bed() == null || this.iLB.bed().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1 || !this.iLB.bEZ()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public void beb() {
        if (this.iLK != null) {
            this.iLK.bjz();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
        if (this.fcg == null) {
            this.fcg = new e(getPageContext(), this.iLI, "main_tab", TbSingleton.getInstance().isAnimEnable("anim_switch_sendthread_maintab") ? 2 : 1);
            this.fcg.Ek("1");
        }
        if (!this.eCs.cin() && this.iLB.bed() != null && this.iLB.bed().getFragmentTabWidget() != null) {
            this.fcg.a(false, this.iLB.bed().getTabWrapper(), this.iLB.bed().getFragmentTabWidget().getWriteView());
        }
    }

    protected void bEV() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007002, new com.baidu.tbadk.mainTab.d(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.baidu.tbadk.o.n.apn().bh(System.currentTimeMillis());
        if (TbadkCoreApplication.getInst().getIsFirstUse()) {
            aa.a(new z<Object>() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.6
                @Override // com.baidu.tbadk.util.z
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
            al(getIntent());
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
        if (cgv()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        setContentView(d.h.maintabs_activity);
        this.iLI = (FrameLayout) findViewById(d.g.maintabContainer);
        com.baidu.tbadk.core.a.a.WA().WB();
        this.iLB = new d(this);
        this.iLK = new c(this);
        this.iLB.qj(this.mIsLogin);
        cgu();
        bpz();
        com.baidu.tieba.tblauncher.alarmRemind.b.cgP().e(this);
        this.iLH = new com.baidu.tieba.a();
        bEV();
        bFl();
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (bundle != null) {
            i2 = bundle.getInt("locate_type", 1);
            intent.putExtra("locate_type", i2);
        }
        this.iMa = UtilHelper.getCurrentDay();
        this.iLE = System.currentTimeMillis();
        MessageManager.getInstance().sendMessage(new CustomMessage(2921359));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
        if (TbadkCoreApplication.getFrom() != null && TbadkCoreApplication.getFrom().equals("aishide")) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005011, null));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005013, null));
        MessageManager.getInstance().registerStickyMode(2001404);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001404));
        j(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        com.baidu.tbadk.browser.a.cF(getPageContext().getPageActivity());
        String installOtherApp = TbadkCoreApplication.getInst().getInstallOtherApp();
        if (installOtherApp != null && installOtherApp.length() > 0) {
            UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), installOtherApp);
            TbadkCoreApplication.getInst().setInstallOtherApp(null);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.7
            @Override // java.lang.Runnable
            public void run() {
                MainTabActivity.this.bkc = true;
            }
        });
        registerListener(this.goN);
        if (i2 == 1) {
            this.iLB.ql(true);
        } else {
            this.iLB.ql(false);
        }
        this.iLB.cgK();
        this.eYE = getVoiceManager();
        if (this.eYE != null) {
            this.eYE.onCreate(getPageContext());
        }
        registerListener(this.mAccountChangedListener);
        adjustResizeForSoftInput();
        addGlobalLayoutListener();
        MessageManager.getInstance().registerStickyMode(2007015);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007015));
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.o.n.apn().apo();
        }
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.getUserInfo.b.ane().anf();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016480));
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("app_restart_times", com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("app_restart_times", 0) + 1);
        this.dKY = new CheckRealNameModel(getPageContext());
        this.dKY.a(this.iLX);
        aMs();
        this.eZv = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "homepage");
        this.fot = new ShareSuccessReplyToServerModel();
        this.eCs = new com.baidu.tieba.ueg.c(getPageContext());
        int i3 = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("need_deal_diversion_jump", 2);
        if (i3 == 2) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("need_deal_diversion_jump", 1);
        } else if (i3 == 1) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("need_deal_diversion_jump", 0);
        }
        this.iLL = com.baidu.tbadk.BdToken.d.Uc();
        TbadkCoreApplication.getInst().SendSkinTypeBroadcast(TbadkCoreApplication.getInst().getSkinType());
        if (TbSingleton.getInstance().isEnableBenchmark() && TbSingleton.getInstance().getCpuFlopsDuration() <= 0) {
            com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.8
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.tbadk.f.a.Vp();
                }
            }, 5000L);
        }
        com.baidu.tbadk.o.n.apn().bi(System.currentTimeMillis());
        MessageManager.getInstance().registerListener(this.gBp);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public ViewGroup getActivityRootView() {
        return this.iLI;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && this.iLL != null) {
            this.iLL.check();
            this.iLL.Ud();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMs() {
        String str = "check_real_name" + TbConfig.getVersion();
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(str, true) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && l.lo()) {
            this.dKY.yN(CheckRealNameModel.TYPE_APP_FIRST_START);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(str, false);
        }
    }

    private void al(Intent intent) {
        if (intent != null) {
            String dataString = intent.getDataString();
            if (!StringUtils.isNull(dataString) && dataString.startsWith("tbmaintab://")) {
                String decode = Uri.decode(intent.getData().getEncodedPath());
                if (StringUtils.isNull(decode)) {
                    TiebaStatic.log(new am("c10320").T("obj_type", 1).T("obj_to", 1));
                    return;
                }
                if (decode.startsWith("//")) {
                    decode = decode.substring(2);
                }
                Map<String, String> mO = ba.mO(decode);
                if (mO != null) {
                    String str = mO.get("fr");
                    if (!"mpush".equals(str) && "bpush".equals(str)) {
                        am amVar = new am("c10320");
                        amVar.bJ("obj_locate", mO.get("obj_locate"));
                        amVar.T("obj_type", 1);
                        amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mO.get(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
                        amVar.bJ("obj_param2", mO.get("obj_param2"));
                        amVar.T("obj_to", 1);
                        amVar.bJ(VideoPlayActivityConfig.OBJ_ID, mO.get("bdid"));
                        if (!ap.isEmpty(mO.get("ext_log"))) {
                            try {
                                JSONObject jSONObject = new JSONObject(mO.get("ext_log"));
                                Iterator<String> keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    amVar.bJ(next, jSONObject.getString(next));
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
                    ba.adA().c(getPageContext(), new String[]{dataString2});
                }
            } else if (!StringUtils.isNULL(dataString) && dataString.startsWith(f.SCHEME)) {
                f.Ui().a(intent.getData(), new f.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.11
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void o(HashMap<String, Object> hashMap) {
                        int intValue = (hashMap == null || !(hashMap.get(f.brP) instanceof Integer)) ? -1 : ((Integer) hashMap.get(f.brP)).intValue();
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
        this.eYE = getVoiceManager();
        if (this.eYE != null) {
            this.eYE.onStart(getPageContext());
        }
    }

    public boolean cgv() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005010, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005012, null));
        bpA();
        com.baidu.tbadk.coreExtra.messageCenter.b.ahx().ahJ();
        com.baidu.tbadk.coreExtra.messageCenter.b.ahx().ahD();
        com.baidu.tbadk.coreExtra.messageCenter.b.ahx().dZ(false);
        MessageManager.getInstance().unRegisterListener(this.gBp);
        MessageManager.getInstance().unRegisterListener(this.iLW);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.dJ(false);
            this.mWaitingDialog = null;
        }
        cgw();
        if (this.iLB != null) {
            this.iLB.onDestroy();
        }
        if (this.iLK != null) {
            this.iLK.onDestroy();
        }
        try {
            super.onDestroy();
        } catch (Exception e) {
        }
        com.baidu.tbadk.core.e.b.a(null);
        this.eYE = getVoiceManager();
        if (this.eYE != null) {
            this.eYE.onDestory(getPageContext());
        }
        if (this.fcg != null) {
            this.fcg.onDestroy();
        }
        if (this.eZv != null) {
            this.eZv.onDestroy();
        }
        if (this.fot != null) {
            this.fot.cancelLoadData();
        }
        if (this.icV != null) {
            this.icV.onDestroy();
        }
        if (this.iLB != null && this.iLB.cgI() != null) {
            this.iLB.cgI().onDestory();
        }
        System.gc();
    }

    private void cgw() {
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

    private void j(Context context, Intent intent) {
        UtilHelper.commenDealIntent(context, intent);
        TbadkCoreApplication.setIntent(null);
    }

    private void bpz() {
        registerListener(this.iLO);
        this.iLS.setPriority(100);
        registerListener(this.iLS);
        registerListener(this.iLT);
        registerListener(this.iLU);
        registerListener(this.iLV);
        registerListener(this.iLY);
        registerListener(this.iLZ);
        registerListener(this.iLR);
        registerListener(this.skinTypeChangeListener);
        registerListener(this.iLP);
        registerListener(this.btv);
        this.iLC = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.iLC, intentFilter);
        registerListener(this.eZS);
        registerListener(this.iLQ);
        registerListener(this.erX);
        registerListener(this.btv);
        registerListener(this.iMb);
        this.iLN.setTag(getUniqueId());
        registerListener(this.iLN);
        registerListener(this.iLW);
    }

    private void bpA() {
        if (this.iLC != null) {
            unregisterReceiver(this.iLC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
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
        if (this.iLB != null && this.iLB.cgI() != null) {
            this.iLB.cgI().setLottieView(true);
        }
        if (this.iLB != null && this.iLB.bed() != null) {
            this.iLv = this.iLB.bed().getCurrentTabType();
        }
        changeSkinType(this.mSkinType);
        if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.o.n.apn().apl()) {
            com.baidu.tbadk.o.n.apn().apo();
        }
        this.eYE = getVoiceManager();
        if (this.eYE != null) {
            this.eYE.onResume(getPageContext());
        }
        this.iLB.cgK();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001385, getActivity()));
        if (TbadkCoreApplication.getKeepLiveSwitch(getApplicationContext())) {
            com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.13
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921300, Boolean.FALSE));
                }
            }, 3000L);
        }
        com.baidu.tbadk.o.n.apn().apo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.iLG = true;
        if (z) {
            com.baidu.tbadk.getUserInfo.b.ane().anf();
            cgu();
            aMs();
        }
        this.iLB.switchNaviBarStatus(z);
        this.iLB.cgM();
        bEV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (this.iLu) {
            this.iLu = false;
            CompatibleUtile.setAnim(getPageContext().getPageActivity(), d.a.down, d.a.hold);
        }
        this.eYE = getVoiceManager();
        if (this.eYE != null) {
            this.eYE.onPause(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921003));
        if (this.iLK != null) {
            this.iLK.bjA();
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
        bundle.putInt("locate_type", this.iLB.bed().getCurrentTabType());
        bundle.putParcelable("android:fragments", null);
        bundle.putParcelable("android:support:fragments", null);
        this.eYE = getVoiceManager();
        if (this.eYE != null) {
            this.eYE.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.eYE = getVoiceManager();
        if (this.eYE != null) {
            this.eYE.onStop(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        int i = 2;
        super.onNewIntent(intent);
        setIntent(intent);
        al(intent);
        com.baidu.tbadk.getUserInfo.b.ane().anf();
        if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007008));
            bEV();
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
            if (intExtra == 8 || intExtra == 3 || intExtra == 15 || booleanExtra) {
                i = intExtra;
            } else if (getActivity().getIntent() == null || getActivity().getIntent().getDataString() == null || !getActivity().getIntent().getDataString().startsWith("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                i = this.iLH.atX();
            }
            if (this.iLB != null && this.iLB.bed() != null) {
                this.iLB.bed().setCurrentTabByType(i);
            }
        }
        j(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        this.iLB.cgK();
    }

    protected void ao(Activity activity) {
        new com.baidu.tbadk.core.dialog.a(activity).gB(d.j.confirm_title).dq(false).gC(d.j.background_process_permission).a(d.j.now_goto_setting, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.15
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                try {
                    MainTabActivity.this.startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
                    aVar.dismiss();
                } catch (Exception e) {
                    MainTabActivity.this.showToast(d.j.goto_developActivity_error_toast);
                }
            }
        }).b(d.j.next_time, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.14
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                MainTabActivity.this.cgx();
            }
        }).b(i.aK(activity)).aaW();
    }

    protected void cgx() {
        com.baidu.adp.lib.f.c.jB().d(getUniqueId());
        cgz();
        try {
            moveTaskToBack(true);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.p pVar) {
        super.onPreLoad(pVar);
        ad.a(pVar, getUniqueId());
        com.baidu.tbadk.core.util.e.d.a(pVar, getUniqueId(), this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!MainTabActivityConfig.IS_BACK_CLOSE_ALL_ACTIVITY && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016322, (Class) null);
            if (runTask == null || !((Boolean) runTask.getData()).booleanValue()) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2016323, (Class) null);
                if (runTask2 == null || !((Boolean) runTask2.getData()).booleanValue()) {
                    if (this.fcg != null && this.fcg.isShowing()) {
                        this.fcg.qW(true);
                        return true;
                    } else if (this.iLB.bEZ()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007010));
                        return true;
                    } else {
                        if (System.currentTimeMillis() - this.iLz > 2000) {
                            showToast(d.j.double_back_quit);
                            this.iLz = System.currentTimeMillis();
                        } else if (UtilHelper.isBackgroundProcessLimitNone() && Build.VERSION.SDK_INT >= 14) {
                            ao(getPageContext().getPageActivity());
                            return true;
                        } else {
                            cgx();
                        }
                        return false;
                    }
                }
                return true;
            }
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(Intent intent) {
        int atX;
        try {
            if (intent.getBooleanExtra("is_from_scheme", false)) {
                atX = intent.getIntExtra("locate_type", 1);
            } else {
                atX = this.iLH.atX();
            }
            this.iLB.bed().setCurrentTabByType(atX);
        } catch (Throwable th) {
            finish();
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

    private void bFl() {
        registerListener(new CustomMessageListener(2007009) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Integer) {
                    Integer num = (Integer) customResponsedMessage.getData();
                    if (num.intValue() == 2) {
                        MainTabActivity.this.iLB.ql(true);
                        MainTabActivity.this.iLB.mx(true);
                    } else if (num.intValue() == 1) {
                        MainTabActivity.this.iLB.ql(true);
                        MainTabActivity.this.iLB.mx(false);
                    } else {
                        MainTabActivity.this.iLB.ql(false);
                        MainTabActivity.this.iLB.mx(false);
                    }
                    MainTabActivity.this.iLB.cgK();
                }
            }
        });
    }

    protected void cgy() {
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
            if (this.iLB.bed().getCurrentFragment() != null) {
                this.iLB.bed().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 11001) {
            cgy();
        } else if (i == 13003) {
            au(intent);
        } else if (i == 23007) {
            ad(intent);
        } else if (i == 13011) {
            com.baidu.tieba.n.a.bWn().w(getPageContext());
        } else if (i == 24007) {
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1) {
                com.baidu.tieba.n.a.bWn().w(getPageContext());
                com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                if (shareItem != null && shareItem.linkUrl != null && this.fot != null) {
                    this.fot.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.17
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void aiH() {
                        }

                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void a(final CustomDialogData customDialogData) {
                            com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.17.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a(MainTabActivity.this.getPageContext(), customDialogData).show();
                                }
                            }, 1000L);
                        }
                    });
                }
            }
        } else if (this.iLB.bed().getCurrentFragment() != null) {
            this.iLB.bed().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    private ShareFromPBMsgData bhB() {
        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.imageUri == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.imageUri.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.cbB);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.cbv);
        shareFromPBMsgData.setThreadId(shareItem.tid);
        return shareFromPBMsgData;
    }

    private void ad(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(bhB(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.gE(1);
            aVar.az(thread2GroupShareView);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.18
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MainTabActivity.this.HidenSoftKeyPad((InputMethodManager) MainTabActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(MainTabActivity.this.getPageContext().getPageActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.ajP() != null) {
                        Bundle ajP = shareItem.ajP();
                        TiebaStatic.log(new am("share_success").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).T("obj_type", ajP.getInt("obj_type")).T("obj_param1", 3).bJ(ImageViewerConfig.FORUM_ID, ajP.getString(ImageViewerConfig.FORUM_ID)).bJ("tid", ajP.getString("tid")));
                    }
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.19
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MainTabActivity.this.HidenSoftKeyPad((InputMethodManager) MainTabActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.dr(true);
            aVar.b(getPageContext()).aaW();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.ag(shareFromPBMsgData.getImageUrl(), false);
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
        this.iLB.onChangeSkinType(i);
        adjustResizeForSoftInputOnSkinTypeChanged(i);
        if (this.fcg != null) {
            this.fcg.onChangeSkinType(i);
        }
    }

    private void au(Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        if (intent != null) {
            try {
                postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
            } catch (Exception e) {
                BdLog.e(e);
                postWriteCallBackData = null;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921030, postWriteCallBackData));
            if (this.iLB != null && !this.iLB.d(postWriteCallBackData)) {
                this.iLB.b(postWriteCallBackData);
            }
        }
    }

    private void cgz() {
        if (System.currentTimeMillis() - this.iLA >= 7200000) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage(2006002, hashMap));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005013, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            this.iLA = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.a
    public int getCurrentTabType() {
        if (this.iLB.bed() != null) {
            return this.iLB.bed().getCurrentTabType();
        }
        return -1;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.eYE == null) {
            this.eYE = VoiceManager.instance();
        }
        return this.eYE;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public ListView aeZ() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> afa() {
        if (this.bTV == null) {
            this.bTV = UserIconBox.q(getPageContext().getPageActivity(), 8);
        }
        return this.bTV;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> bbO() {
        if (this.iLF == null) {
            this.iLF = FrsCommonImageLayout.y(getPageContext().getPageActivity(), 12);
        }
        return this.iLF;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.20
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean aoH() {
                return true;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int aoI() {
                return com.baidu.tbadk.pageStayDuration.e.aoM().aoP();
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
        if (this.iLG && currentPageSourceKeyList != null) {
            currentPageSourceKeyList.clear();
            this.iLG = false;
            return null;
        }
        return currentPageSourceKeyList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.dMb = z;
        boolean z2 = this.iLM || this.dMb;
        if (this.iLB != null) {
            this.iLB.onKeyboardVisibilityChanged(z2);
        }
    }

    @Override // com.baidu.tbadk.core.util.e.c
    public boolean videoNeedPreload() {
        return com.baidu.tbadk.util.ad.kd(1);
    }
}
