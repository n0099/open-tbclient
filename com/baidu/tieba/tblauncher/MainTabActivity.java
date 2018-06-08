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
import com.baidu.adp.widget.ListView.k;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.KuangFloatingViewController;
import com.baidu.tbadk.TbConfig;
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
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.ExitAppMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.data.UserData;
import com.baidu.tbadk.data.h;
import com.baidu.tbadk.k.n;
import com.baidu.tbadk.util.l;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.HomePageStatic;
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
    private static boolean gNq;
    private com.baidu.adp.lib.e.b<TbImageView> ayn;
    private CheckRealNameModel bZn;
    VoiceManager dhB;
    private com.baidu.tieba.NEGFeedBack.a dim;
    private ShareSuccessReplyToServerModel dvD;
    private com.baidu.tieba.s.b dvE;
    private com.baidu.tieba.write.c dvv;
    private boolean gNH;
    private String gNM;
    private at gNl;
    private e gNo;
    private a gNp;
    private com.baidu.adp.lib.e.b<TbImageView> gNs;
    private com.baidu.tieba.a gNu;
    private FrameLayout gNv;
    private d gNx;
    private com.baidu.tbadk.BdToken.a gNy;
    private boolean isFirstGoMaintab;
    private boolean gNh = false;
    private int gNi = -1;
    private boolean gNj = false;
    private String mFrom = null;
    private volatile boolean gNk = false;
    private long gNm = 0;
    private long gNn = 0;
    private long gNr = -1;
    private boolean gNt = false;
    private String gNw = "";
    boolean gNz = false;
    boolean bZR = false;
    private CustomMessageListener gNA = new CustomMessageListener(2010045) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && MainTabActivity.this.gNo != null && TbadkCoreApplication.getInst().getCurrentActivity() == MainTabActivity.this) {
                MainTabActivity.this.gNz = com.baidu.adp.lib.g.b.d(customResponsedMessage.getData().toString(), false);
                MainTabActivity.this.gNo.onKeyboardVisibilityChanged(MainTabActivity.this.gNz | MainTabActivity.this.bZR);
            }
        }
    };
    private final CustomMessageListener gNB = new CustomMessageListener(2001377) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.12
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
                        MainTabActivity.this.gNo.byX().cy(1);
                    } else if (TbadkCoreApplication.getInst().isThemeIconCover()) {
                        MainTabActivity.this.gNo.byX().cy(2);
                    } else {
                        MainTabActivity.this.gNo.byX().cy(1);
                    }
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c eqz = new com.baidu.adp.framework.listener.c(1001) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ConfigVersion configVersion;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                if (socketResponsedMessage.getError() == 0 && (configVersion = responseOnlineMessage.getConfigVersion()) != null) {
                    MainTabActivity.this.ui(configVersion.sync);
                }
            }
        }
    };
    private CustomMessageListener gNC = new CustomMessageListener(2001609) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.27
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
    private final CustomMessageListener gND = new CustomMessageListener(2001247) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getData() instanceof PayMemberInfoData) {
                    MainTabActivity.this.a((PayMemberInfoData) customResponsedMessage.getData());
                    TbadkCoreApplication.getInst().setPaymemberInfo((PayMemberInfoData) customResponsedMessage.getData());
                }
                UserData Iw = com.baidu.tbadk.getUserInfo.b.Iu().Iw();
                if (TbadkCoreApplication.isLogin() && Iw != null && Iw.getUserId() != null && !Iw.getUserId().equals(MainTabActivity.this.gNw) && Iw.getIsGodInvited()) {
                    MainTabActivity.this.gNw = Iw.getUserId();
                    MainTabActivity.this.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(MainTabActivity.this.getPageContext().getPageActivity(), "", TbWebViewActivityConfig.GOD_INVITE_JUMP_URL + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE, true)));
                }
            }
        }
    };
    private CustomMessageListener diE = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                MainTabActivity.this.gNo.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    final CustomMessageListener gNE = new CustomMessageListener(2007002) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.tbadk.mainTab.b> sR;
            MainTabActivity.this.gNk = false;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (sR = ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).sR()) != null && sR.size() != 0) {
                MainTabActivity.this.gNo.ah(sR);
                if (MainTabActivity.this.gNj) {
                    MainTabActivity.this.gNo.byX().setCurrentTabByType(MainTabActivity.this.gNi);
                } else {
                    MainTabActivity.this.Y(MainTabActivity.this.getIntent());
                }
                MainTabActivity.this.gNj = false;
                MainTabActivity.this.gNo.byW();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, null));
            }
        }
    };
    final CustomMessageListener gNF = new CustomMessageListener(2007013) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007013) {
                MainTabActivity.this.aXu();
                if (MainTabActivity.this.gNo != null && MainTabActivity.this.gNo.byX() != null) {
                    MainTabActivity.this.gNi = MainTabActivity.this.gNo.byX().getCurrentTabType();
                }
                MainTabActivity.this.gNj = true;
            }
        }
    };
    final CustomMessageListener gNG = new CustomMessageListener(2921333) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (MainTabActivity.this.gNl != null || (customResponsedMessage.getData() instanceof at)) {
                    if (customResponsedMessage.getData() != null) {
                        MainTabActivity.this.gNl = (at) customResponsedMessage.getData();
                    }
                    if (!MainTabActivity.this.gNk && MainTabActivity.this.gNl != null && TbadkCoreApplication.isLogin()) {
                        MainTabActivity.this.gNx.c(MainTabActivity.this.gNl.recom_title, MainTabActivity.this.gNl.recom_topic, MainTabActivity.this.gNl.ahk);
                    }
                }
            }
        }
    };
    private final CustomMessageListener gNI = new CustomMessageListener(2007005) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.e.b.xN() == null) {
                c cVar = new c();
                cVar.a(MainTabActivity.this);
                com.baidu.tbadk.core.e.b.a(cVar);
            }
        }
    };
    private CheckRealNameModel.a gNJ = new CheckRealNameModel.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.6
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            if (CheckRealNameModel.TYPE_APP_FIRST_START.equals(str2) && i == 1990055) {
                TiebaStatic.log("c12138");
                MainTabActivity.this.gNo.uk(MainTabActivity.this.getResources().getString(d.k.check_real_name_message));
            }
        }
    };
    private CustomMessageListener aaR = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && com.baidu.adp.lib.util.l.jU()) {
                MainTabActivity.this.adS();
                if (!MainTabActivity.gNq) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
                }
            }
        }
    };
    private CustomMessageListener bvy = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                MainTabActivity.this.gNt = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
                com.baidu.tbadk.core.sharedPref.b.getInstance().remove("key_feedback_tip");
                com.baidu.tbadk.core.sharedPref.b.getInstance().remove("key_feedback_tip_show");
                com.baidu.tbadk.core.sharedPref.b.getInstance().remove("key_feedback_tip_tab_show");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016560));
                if (MainTabActivity.this.gNy != null) {
                    MainTabActivity.this.gNy.check();
                }
            }
        }
    };
    private CustomMessageListener gNK = new CustomMessageListener(2016509) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                o.aoC = ((Boolean) customResponsedMessage.getData()).booleanValue();
                MainTabActivity.this.byJ();
            }
        }
    };
    private final CustomMessageListener gNL = new CustomMessageListener(2001230) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", booleanValue);
                MainTabActivity.this.gNo.mI(booleanValue);
            }
        }
    };
    private CustomMessageListener cIo = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                boolean unused = MainTabActivity.gNq = true;
                if (!TbadkCoreApplication.getInst().getActivityPrizeData().Bu()) {
                    MainTabActivity.this.gNo.uj(null);
                    return;
                }
                if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getInst().getActivityPrizeData().By()) {
                    String Bx = TbadkCoreApplication.getInst().getActivityPrizeData().Bx();
                    if (!StringUtils.isNull(Bx) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("activity_prize_get_tip" + TbadkCoreApplication.getCurrentAccount(), true)) {
                        ay.zG().a(MainTabActivity.this.getPageContext(), new String[]{Bx}, true);
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("activity_prize_get_tip" + TbadkCoreApplication.getCurrentAccount(), false);
                    }
                }
                if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    MainTabActivity.this.gNo.uj(null);
                    return;
                }
                String BA = TbadkCoreApplication.getInst().getActivityPrizeData().BA();
                if (!StringUtils.isNull(BA)) {
                    MainTabActivity.this.gNo.uj(BA);
                } else {
                    MainTabActivity.this.gNo.uj(null);
                }
            }
        }
    };
    private CustomMessageListener gNN = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    MainTabActivity.this.gNM = UtilHelper.getCurrentDay();
                    return;
                }
                String currentDay = UtilHelper.getCurrentDay();
                if (!StringUtils.isNull(currentDay) && !currentDay.equals(MainTabActivity.this.gNM)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
                }
            }
        }
    };
    private final CustomMessageListener geq = new CustomMessageListener(2016493) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.25
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            h hVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof h) && (hVar = (h) customResponsedMessage.getData()) != null && !StringUtils.isNull(hVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(hVar);
                if (StringUtils.isNull(hVar.aKf)) {
                    ay.zG().c(MainTabActivity.this.getPageContext(), new String[]{hVar.mLink});
                } else {
                    ay.zG().c(MainTabActivity.this.getPageContext(), new String[]{hVar.mLink, hVar.aKf});
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void ui(String str) {
        if (str != null && TbadkCoreApplication.getInst().getConfigVersion() != null && byI()) {
            this.gNr = System.currentTimeMillis();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
        }
    }

    private boolean byI() {
        if (-1 == this.gNr) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.gNr;
        return currentTimeMillis <= 0 || currentTimeMillis >= ReportUserInfoModel.TIME_INTERVAL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byJ() {
        if (com.baidu.adp.lib.b.d.hv().aw("android_game_enter_switch") == 1 && o.aoC) {
            this.gNo.mG(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016510));
            return;
        }
        this.gNo.mG(false);
        this.gNo.mI(false);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
    }

    public void a(PayMemberInfoData payMemberInfoData) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && payMemberInfoData != null) {
            if ((payMemberInfoData.GF() == 1 || payMemberInfoData.GF() == 2) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_member_deid_line", true)) {
                long tK = payMemberInfoData.tK() * 1000;
                if (tK < System.currentTimeMillis()) {
                    if (StringUtils.isNull(payMemberInfoData.GG())) {
                        payMemberInfoData.gm(getPageContext().getString(d.k.member));
                    } else {
                        payMemberInfoData.gm(payMemberInfoData.GG() + getPageContext().getString(d.k.member_already_Expire));
                    }
                    this.gNo.a(payMemberInfoData, 0);
                } else if (tK - System.currentTimeMillis() < 259200000) {
                    if (StringUtils.isNull(payMemberInfoData.GG())) {
                        payMemberInfoData.gm(getPageContext().getString(d.k.member));
                    } else {
                        payMemberInfoData.gm(payMemberInfoData.GG() + getPageContext().getString(d.k.member_will_Expire));
                    }
                    this.gNo.a(payMemberInfoData, 1);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.gNH) {
            return false;
        }
        if (this.gNo.byX() == null || this.gNo.byX().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1 || !this.gNo.aXy()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public void axH() {
        if (this.gNx != null) {
            this.gNx.byH();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
        if (this.dvv == null) {
            this.dvv = new com.baidu.tieba.write.c(getPageContext(), this.gNv, "main_tab");
            this.dvv.vA("1");
        }
        if (!this.dvE.bAH()) {
            this.dvv.nt(false);
        }
    }

    protected void aXu() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007002, new com.baidu.tbadk.mainTab.d(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        n.Kx().am(System.currentTimeMillis());
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
                TiebaStatic.log(new am("c12264").r("obj_type", 3));
                KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
                if (KuangFloatingViewController.getInstance().init()) {
                    ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.4
                        @Override // com.baidu.tbadk.core.e
                        public void an(boolean z) {
                            if (z) {
                                KuangFloatingViewController.getInstance().showFloatingView();
                            }
                        }
                    });
                }
            }
        }
        this.isFirstGoMaintab = TbadkCoreApplication.getInst().isFirstGoMaintab();
        c cVar = new c();
        com.baidu.tbadk.core.e.b.a(cVar);
        cVar.a(this);
        if (byK()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        setContentView(d.i.maintabs_activity);
        this.gNv = (FrameLayout) findViewById(d.g.maintabContainer);
        com.baidu.tbadk.core.a.a.tA().tB();
        this.gNo = new e(this);
        this.gNx = new d(this);
        this.gNo.mF(this.mIsLogin);
        byJ();
        aFj();
        com.baidu.tieba.tblauncher.alarmRemind.b.bzc().m(this);
        this.gNu = new com.baidu.tieba.a();
        aXu();
        aXR();
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (bundle != null) {
            i = bundle.getInt("locate_type", 1);
            intent.putExtra("locate_type", i);
        }
        this.gNM = UtilHelper.getCurrentDay();
        this.gNr = System.currentTimeMillis();
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
        if (this.isFirstGoMaintab) {
            TbadkCoreApplication.getInst().setFirstGoMaintab(false);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.5
            @Override // java.lang.Runnable
            public void run() {
                MainTabActivity.this.gNH = true;
            }
        });
        registerListener(this.eqz);
        if (i == 1) {
            this.gNo.mH(true);
        } else {
            this.gNo.mH(false);
        }
        this.gNo.byY();
        this.dhB = getVoiceManager();
        if (this.dhB != null) {
            this.dhB.onCreate(getPageContext());
        }
        registerListener(this.bvy);
        adjustResizeForSoftInput();
        addGlobalLayoutListener();
        MessageManager.getInstance().registerStickyMode(2007015);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007015));
        if (TbadkCoreApplication.isLogin()) {
            n.Kx().Ky();
        }
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.getUserInfo.b.Iu().Iv();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016480));
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("app_restart_times", com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("app_restart_times", 0) + 1);
        this.bZn = new CheckRealNameModel(getPageContext());
        this.bZn.a(this.gNJ);
        adS();
        this.dim = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "homepage");
        this.dvD = new ShareSuccessReplyToServerModel();
        this.dvE = new com.baidu.tieba.s.b(getPageContext());
        this.gNy = new com.baidu.tbadk.BdToken.a(getPageContext());
        this.gNy.check();
        n.Kx().an(System.currentTimeMillis());
        MessageManager.getInstance().registerListener(this.geq);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public ViewGroup tq() {
        return this.gNv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adS() {
        String str = "check_real_name" + TbConfig.getVersion();
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(str, true) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && com.baidu.adp.lib.util.l.jU()) {
            this.bZn.qo(CheckRealNameModel.TYPE_APP_FIRST_START);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(str, false);
        }
    }

    private void Q(Intent intent) {
        if (intent != null) {
            String dataString = intent.getDataString();
            if (!StringUtils.isNull(dataString) && dataString.startsWith("tbmaintab://")) {
                String decode = Uri.decode(intent.getData().getEncodedPath());
                if (StringUtils.isNull(decode)) {
                    TiebaStatic.log(new am("c10320").r("obj_type", 1).r("obj_to", 1));
                    return;
                }
                if (decode.startsWith("//")) {
                    decode = decode.substring(2);
                }
                Map<String, String> eO = ay.eO(decode);
                if (eO != null) {
                    String str = eO.get("fr");
                    if (!"mpush".equals(str) && "bpush".equals(str)) {
                        am amVar = new am("c10320");
                        amVar.ah("obj_locate", eO.get("obj_locate"));
                        amVar.r("obj_type", 1);
                        amVar.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eO.get(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
                        amVar.ah("obj_param2", eO.get("obj_param2"));
                        amVar.r("obj_to", 1);
                        amVar.ah(VideoPlayActivityConfig.OBJ_ID, eO.get("bdid"));
                        if (!ao.isEmpty(eO.get("ext_log"))) {
                            try {
                                JSONObject jSONObject = new JSONObject(eO.get("ext_log"));
                                Iterator<String> keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    amVar.ah(next, jSONObject.getString(next));
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
                        ay.zG().c(getPageContext(), new String[]{dataString2});
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
        this.dhB = getVoiceManager();
        if (this.dhB != null) {
            this.dhB.onStart(getPageContext());
        }
    }

    public boolean byK() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005010, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005012, null));
        aFk();
        com.baidu.tbadk.coreExtra.messageCenter.a.CX().Dj();
        com.baidu.tbadk.coreExtra.messageCenter.a.CX().Dd();
        com.baidu.tbadk.coreExtra.messageCenter.a.CX().ba(false);
        MessageManager.getInstance().unRegisterListener(this.geq);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.aM(false);
            this.mWaitingDialog = null;
        }
        byL();
        if (this.gNo != null) {
            this.gNo.onDestroy();
        }
        if (this.gNx != null) {
            this.gNx.onDestroy();
        }
        try {
            super.onDestroy();
        } catch (Exception e) {
        }
        com.baidu.tbadk.core.e.b.a(null);
        this.dhB = getVoiceManager();
        if (this.dhB != null) {
            this.dhB.onDestory(getPageContext());
        }
        if (this.dvv != null) {
            this.dvv.onDestroy();
        }
        if (this.dim != null) {
            this.dim.onDestroy();
        }
        if (this.dvD != null) {
            this.dvD.cancelLoadData();
        }
        if (this.gNy != null) {
            this.gNy.onDestroy();
        }
        System.gc();
    }

    private void byL() {
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

    private void aFj() {
        registerListener(this.gNB);
        this.gNE.setPriority(100);
        registerListener(this.gNE);
        registerListener(this.gNF);
        registerListener(this.gNG);
        registerListener(this.gNI);
        registerListener(this.gNK);
        registerListener(this.gNL);
        registerListener(this.gND);
        registerListener(this.skinTypeChangeListener);
        registerListener(this.aaR);
        this.gNp = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.gNp, intentFilter);
        registerListener(this.diE);
        registerListener(this.gNC);
        registerListener(this.cIo);
        registerListener(this.aaR);
        registerListener(this.gNN);
        this.gNA.setTag(getUniqueId());
        registerListener(this.gNA);
    }

    private void aFk() {
        if (this.gNp != null) {
            unregisterReceiver(this.gNp);
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
        if (this.isFirstGoMaintab) {
            this.isFirstGoMaintab = false;
        }
        this.gNi = this.gNo.byX().getCurrentTabType();
        changeSkinType(this.mSkinType);
        if (TbadkCoreApplication.isLogin() && n.Kx().Kw()) {
            n.Kx().Ky();
        }
        this.dhB = getVoiceManager();
        if (this.dhB != null) {
            this.dhB.onResume(getPageContext());
        }
        if (this.gNo != null) {
            this.gNo.byY();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001385, getActivity()));
        if (KuangFloatingViewController.getInstance().init()) {
            ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.8
                @Override // com.baidu.tbadk.core.e
                public void an(boolean z) {
                    if (z) {
                        KuangFloatingViewController.getInstance().showFloatingView();
                    }
                }
            });
        }
        if (TbadkCoreApplication.getKeepLiveSwitch(getApplicationContext())) {
            com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921300, Boolean.FALSE));
                }
            }, 3000L);
        }
        n.Kx().Ky();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.gNt = true;
        if (z) {
            com.baidu.tbadk.getUserInfo.b.Iu().Iv();
            byJ();
            adS();
        }
        this.gNo.switchNaviBarStatus(z);
        aXu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (this.gNh) {
            this.gNh = false;
            CompatibleUtile.setAnim(getPageContext().getPageActivity(), d.a.down, d.a.hold);
        }
        this.dhB = getVoiceManager();
        if (this.dhB != null) {
            this.dhB.onPause(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921003));
        if (this.gNx != null) {
            this.gNx.bgm();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
        } catch (Exception e) {
        }
        bundle.putInt("locate_type", this.gNo.byX().getCurrentTabType());
        bundle.putParcelable("android:fragments", null);
        bundle.putParcelable("android:support:fragments", null);
        this.dhB = getVoiceManager();
        if (this.dhB != null) {
            this.dhB.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.dhB = getVoiceManager();
        if (this.dhB != null) {
            this.dhB.onStop(getPageContext());
        }
        HomePageStatic.dMt = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Q(intent);
        setIntent(intent);
        com.baidu.tbadk.getUserInfo.b.Iu().Iv();
        if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007008));
            aXu();
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
                intExtra = this.gNu.Oc();
            }
            this.gNo.byX().setCurrentTabByType(intExtra);
        }
        i(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        if (this.gNo != null) {
            this.gNo.byY();
        }
        this.mFrom = getIntent().getStringExtra("from");
        if ("from_tieba_kuang".equals(this.mFrom) && this.mFrom != null) {
            TiebaStatic.log(new am("c12264").r("obj_type", 3));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            if (KuangFloatingViewController.getInstance().init()) {
                ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.10
                    @Override // com.baidu.tbadk.core.e
                    public void an(boolean z) {
                        if (z) {
                            KuangFloatingViewController.getInstance().showFloatingView();
                        }
                    }
                });
            }
        }
    }

    protected void G(Activity activity) {
        new com.baidu.tbadk.core.dialog.a(activity).cb(d.k.confirm_title).au(false).cc(d.k.background_process_permission).a(d.k.now_goto_setting, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.13
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                try {
                    MainTabActivity.this.startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
                    aVar.dismiss();
                } catch (Exception e) {
                    MainTabActivity.this.showToast(d.k.goto_developActivity_error_toast);
                }
            }
        }).b(d.k.next_time, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                MainTabActivity.this.byM();
            }
        }).b(i.ad(activity)).xa();
    }

    protected void byM() {
        com.baidu.adp.lib.f.c.ig().d(getUniqueId());
        byO();
        moveTaskToBack(true);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, com.baidu.adp.base.h
    public void onPreLoad(k kVar) {
        super.onPreLoad(kVar);
        ae.a(kVar, getUniqueId());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!MainTabActivityConfig.IS_BACK_CLOSE_ALL_ACTIVITY && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016322, (Class) null);
            if (runTask == null || !((Boolean) runTask.getData()).booleanValue()) {
                if (this.dvv != null && this.dvv.isShowing()) {
                    this.dvv.bGf();
                    return true;
                } else if (this.gNo.aXy()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007010));
                    return true;
                } else {
                    if (System.currentTimeMillis() - this.gNm > 2000) {
                        showToast(d.k.double_back_quit);
                        this.gNm = System.currentTimeMillis();
                    } else if (UtilHelper.isBackgroundProcessLimitNone() && Build.VERSION.SDK_INT >= 14) {
                        G(getPageContext().getPageActivity());
                        return true;
                    } else {
                        byM();
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
            this.gNo.byX().setCurrentTabByType(this.gNu.Oc());
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

    private void aXR() {
        registerListener(new CustomMessageListener(2007009) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Integer) {
                    Integer num = (Integer) customResponsedMessage.getData();
                    if (num.intValue() == 2) {
                        MainTabActivity.this.gNo.mH(true);
                        MainTabActivity.this.gNo.iV(true);
                    } else if (num.intValue() == 1) {
                        MainTabActivity.this.gNo.mH(true);
                        MainTabActivity.this.gNo.iV(false);
                    } else {
                        MainTabActivity.this.gNo.mH(false);
                        MainTabActivity.this.gNo.iV(false);
                    }
                    MainTabActivity.this.gNo.byY();
                }
            }
        });
    }

    protected void byN() {
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
            if (i == 12007) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), 1, getPageContext().getString(d.k.login_home_tab), (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BACK)));
            }
            if (this.gNo.byX().getCurrentFragment() != null) {
                this.gNo.byX().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 11001) {
            byN();
        } else if (i == 13003) {
            Z(intent);
        } else if (i == 23007) {
            J(intent);
        } else if (i == 13011) {
            com.baidu.tieba.n.a.bnR().x(getPageContext());
        } else if (i == 24007) {
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1) {
                com.baidu.tieba.n.a.bnR().x(getPageContext());
                com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                if (shareItem != null && shareItem.linkUrl != null && this.dvD != null) {
                    this.dvD.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.15
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void Ee() {
                        }

                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void a(final CustomDialogData customDialogData) {
                            com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.15.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a(MainTabActivity.this.getPageContext(), customDialogData).show();
                                }
                            }, 1000L);
                        }
                    });
                }
            }
        } else if (this.gNo.byX().getCurrentFragment() != null) {
            this.gNo.byX().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    private ShareFromPBMsgData aym() {
        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.aFj == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.aFj.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.aFm);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.aFh);
        shareFromPBMsgData.setThreadId(shareItem.tid);
        return shareFromPBMsgData;
    }

    private void J(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(aym(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.ce(1);
            aVar.w(thread2GroupShareView);
            aVar.a(d.k.share, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.16
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MainTabActivity.this.HidenSoftKeyPad((InputMethodManager) MainTabActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(MainTabActivity.this.getPageContext().getPageActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.Fl() != null) {
                        Bundle Fl = shareItem.Fl();
                        TiebaStatic.log(new am("share_success").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_type", Fl.getInt("obj_type")).r("obj_param1", 3).ah(ImageViewerConfig.FORUM_ID, Fl.getString(ImageViewerConfig.FORUM_ID)).ah("tid", Fl.getString("tid")));
                    }
                }
            });
            aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.17
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MainTabActivity.this.HidenSoftKeyPad((InputMethodManager) MainTabActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.av(true);
            aVar.b(getPageContext()).xa();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.D(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.gNo.onChangeSkinType(i);
        bw(i);
        if (this.dvv != null) {
            this.dvv.onChangeSkinType();
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
            if (this.gNo != null && !this.gNo.d(postWriteCallBackData)) {
                this.gNo.b(postWriteCallBackData);
            }
        }
    }

    private void byO() {
        if (System.currentTimeMillis() - this.gNn >= 7200000) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage(2006002, hashMap));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005013, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            this.gNn = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.b
    public int getCurrentTabType() {
        if (this.gNo.byX() != null) {
            return this.gNo.byX().getCurrentTabType();
        }
        return -1;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dhB == null) {
            this.dhB = VoiceManager.instance();
        }
        return this.dhB;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public ListView AJ() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> AK() {
        if (this.ayn == null) {
            this.ayn = UserIconBox.h(getPageContext().getPageActivity(), 8);
        }
        return this.ayn;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> asR() {
        if (this.gNs == null) {
            this.gNs = FrsCommonImageLayout.o(getPageContext().getPageActivity(), 12);
        }
        return this.gNs;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.18
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean JU() {
                return true;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int JV() {
                return com.baidu.tbadk.pageStayDuration.e.JZ().Kb();
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
        if (this.gNt && currentPageSourceKeyList != null) {
            currentPageSourceKeyList.clear();
            this.gNt = false;
            return null;
        }
        return currentPageSourceKeyList;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onKeyboardVisibilityChanged(boolean z) {
        this.bZR = z;
        boolean z2 = this.gNz | this.bZR;
        if (this.gNo != null) {
            this.gNo.onKeyboardVisibilityChanged(z2);
        }
    }
}
