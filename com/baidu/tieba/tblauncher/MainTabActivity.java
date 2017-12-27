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
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.KuangFloatingViewController;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
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
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.e;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.ExitAppMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.data.UserData;
import com.baidu.tbadk.k.s;
import com.baidu.tbadk.mainTab.d;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.f;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import protobuf.ConfigVersion;
/* loaded from: classes.dex */
public class MainTabActivity extends BaseFragmentActivity implements UserIconBox.b, VoiceManager.c, com.baidu.tieba.tblauncher.a {
    private static boolean hna;
    private com.baidu.adp.lib.e.b<TbImageView> bcT;
    private CheckRealNameModel cvX;
    private com.baidu.tieba.write.c dIZ;
    private ShareSuccessReplyToServerModel dJg;
    private com.baidu.tieba.p.a dJh;
    VoiceManager dwG;
    private com.baidu.tieba.NEGFeedBack.a dxo;
    private FrameLayout fZw;
    private c hmY;
    private a hmZ;
    private com.baidu.tieba.a hnd;
    private boolean hnj;
    private String hnp;
    private boolean isFirstGoMaintab;
    private boolean hmT = false;
    private int hmU = -1;
    private boolean hmV = false;
    private String mFrom = null;
    private long hmW = 0;
    private long hmX = 0;
    private long hnb = -1;
    private boolean hnc = false;
    private String hne = "";
    private final CustomMessageListener hnf = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_MATINTAB) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001377) {
                MainTabActivity.this.finish();
            }
        }
    };
    private final CustomMessageListener skinTypeChangeListener = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                int oldSkinType = TbadkCoreApplication.getInst().getOldSkinType();
                if (!((intValue == 2 || oldSkinType == 2) ? false : true)) {
                    if ((intValue == 3 || intValue == 1 || intValue == 0) && oldSkinType == 2) {
                        MainTabActivity.this.hmY.bEg().fz(1);
                    } else if (TbadkCoreApplication.getInst().isThemeIconCover()) {
                        MainTabActivity.this.hmY.bEg().fz(2);
                    } else {
                        MainTabActivity.this.hmY.bEg().fz(1);
                    }
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c eDj = new com.baidu.adp.framework.listener.c(1001) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ConfigVersion configVersion;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                if (socketResponsedMessage.getError() == 0 && (configVersion = responseOnlineMessage.getConfigVersion()) != null) {
                    MainTabActivity.this.tv(configVersion.sync);
                }
            }
        }
    };
    private CustomMessageListener hng = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_JUMP_PB) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.24
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
    private final CustomMessageListener hnh = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_INFO_CHANGED) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getData() instanceof PayMemberInfoData) {
                    MainTabActivity.this.a((PayMemberInfoData) customResponsedMessage.getData());
                    TbadkCoreApplication.getInst().setPaymemberInfo((PayMemberInfoData) customResponsedMessage.getData());
                }
                UserData LV = com.baidu.tbadk.getUserInfo.b.LT().LV();
                if (TbadkCoreApplication.isLogin() && LV != null && LV.getUserId() != null && !LV.getUserId().equals(MainTabActivity.this.hne) && LV.getIsGodInvited()) {
                    MainTabActivity.this.hne = LV.getUserId();
                    MainTabActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(MainTabActivity.this.getPageContext().getPageActivity(), "", TbWebViewActivityConfig.GOD_INVITE_JUMP_URL + TbWebViewActivityConfig.JUMP_PARAMS, true)));
                }
            }
        }
    };
    private CustomMessageListener dxC = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                MainTabActivity.this.hmY.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    final CustomMessageListener guY = new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.tbadk.mainTab.b> wa;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (wa = ((d) customResponsedMessage.getData()).wa()) != null && wa.size() != 0) {
                MainTabActivity.this.hmY.af(wa);
                if (MainTabActivity.this.hmV) {
                    MainTabActivity.this.hmY.bEg().setCurrentTabByType(MainTabActivity.this.hmU);
                } else {
                    MainTabActivity.this.ac(MainTabActivity.this.getIntent());
                }
                MainTabActivity.this.hmV = false;
                MainTabActivity.this.hmY.bEf();
                int size = wa.size();
                for (int i = 0; i < size; i++) {
                    if (wa.get(i) != null && wa.get(i).Mz() != null && 15 == wa.get(i).Mz().type) {
                        if (MainTabActivity.this.hmY != null) {
                            MainTabActivity.this.hmY.bEi();
                            return;
                        }
                        return;
                    }
                }
            }
        }
    };
    final CustomMessageListener hni = new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_REFRESH_TABS) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007013) {
                MainTabActivity.this.aVK();
                if (MainTabActivity.this.hmY != null && MainTabActivity.this.hmY.bEg() != null) {
                    MainTabActivity.this.hmU = MainTabActivity.this.hmY.bEg().getCurrentTabType();
                }
                MainTabActivity.this.hmV = true;
            }
        }
    };
    private final CustomMessageListener hnk = new CustomMessageListener(CmdConfigCustom.MAINTAB_SET_INST) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.e.b.Bv() == null) {
                b bVar = new b();
                bVar.a(MainTabActivity.this);
                com.baidu.tbadk.core.e.b.a(bVar);
            }
        }
    };
    private CheckRealNameModel.a hnl = new CheckRealNameModel.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.5
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            if (CheckRealNameModel.TYPE_APP_FIRST_START.equals(str2) && i == 1990055) {
                TiebaStatic.log("c12138");
                MainTabActivity.this.hmY.tx(MainTabActivity.this.getResources().getString(d.j.check_real_name_message));
            }
        }
    };
    private CustomMessageListener hnm = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && l.oZ()) {
                MainTabActivity.this.afj();
                if (!MainTabActivity.hna) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
                }
            }
        }
    };
    private CustomMessageListener dJy = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                MainTabActivity.this.hnc = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
                com.baidu.tbadk.core.sharedPref.b.getInstance().remove("key_feedback_tip");
                com.baidu.tbadk.core.sharedPref.b.getInstance().remove("key_feedback_tip_show");
                com.baidu.tbadk.core.sharedPref.b.getInstance().remove("key_feedback_tip_tab_show");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP));
            }
        }
    };
    private CustomMessageListener hnn = new CustomMessageListener(CmdConfigCustom.CMD_GAME_CENTER_INIT) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                n.aTF = ((Boolean) customResponsedMessage.getData()).booleanValue();
                MainTabActivity.this.bDS();
            }
        }
    };
    private final CustomMessageListener hno = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", booleanValue);
                MainTabActivity.this.hmY.nI(booleanValue);
            }
        }
    };
    private CustomMessageListener dhO = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.21
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                boolean unused = MainTabActivity.hna = true;
                if (!TbadkCoreApplication.getInst().getActivityPrizeData().EU()) {
                    MainTabActivity.this.hmY.tw(null);
                    return;
                }
                if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getInst().getActivityPrizeData().EY()) {
                    String EX = TbadkCoreApplication.getInst().getActivityPrizeData().EX();
                    if (!StringUtils.isNull(EX) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("activity_prize_get_tip" + TbadkCoreApplication.getCurrentAccount(), true)) {
                        av.Di().a(MainTabActivity.this.getPageContext(), new String[]{EX}, true);
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("activity_prize_get_tip" + TbadkCoreApplication.getCurrentAccount(), false);
                    }
                }
                if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    MainTabActivity.this.hmY.tw(null);
                    return;
                }
                String Fa = TbadkCoreApplication.getInst().getActivityPrizeData().Fa();
                if (!StringUtils.isNull(Fa)) {
                    MainTabActivity.this.hmY.tw(Fa);
                } else {
                    MainTabActivity.this.hmY.tw(null);
                }
            }
        }
    };
    private CustomMessageListener hnq = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    MainTabActivity.this.hnp = UtilHelper.getCurrentDay();
                    return;
                }
                String currentDay = UtilHelper.getCurrentDay();
                if (!StringUtils.isNull(currentDay) && !currentDay.equals(MainTabActivity.this.hnp)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void tv(String str) {
        if (str != null && TbadkCoreApplication.getInst().getConfigVersion() != null && bDR()) {
            this.hnb = System.currentTimeMillis();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    private boolean bDR() {
        if (-1 == this.hnb) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.hnb;
        return currentTimeMillis <= 0 || currentTimeMillis >= ReportUserInfoModel.TIME_INTERVAL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDS() {
        if (com.baidu.adp.lib.b.d.mz().an("android_game_enter_switch") == 1 && n.aTF) {
            this.hmY.nG(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_CHECK_UPDATE));
            return;
        }
        this.hmY.nG(false);
        this.hmY.nI(false);
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("game_is_show_tip", false);
    }

    public void a(PayMemberInfoData payMemberInfoData) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && payMemberInfoData != null) {
            if ((payMemberInfoData.Kb() == 1 || payMemberInfoData.Kb() == 2) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_member_deid_line", true)) {
                long wT = payMemberInfoData.wT() * 1000;
                if (wT < System.currentTimeMillis()) {
                    if (StringUtils.isNull(payMemberInfoData.Kc())) {
                        payMemberInfoData.fF(getPageContext().getString(d.j.member));
                    } else {
                        payMemberInfoData.fF(payMemberInfoData.Kc() + getPageContext().getString(d.j.member_already_Expire));
                    }
                    this.hmY.a(payMemberInfoData, 0);
                } else if (wT - System.currentTimeMillis() < 259200000) {
                    if (StringUtils.isNull(payMemberInfoData.Kc())) {
                        payMemberInfoData.fF(getPageContext().getString(d.j.member));
                    } else {
                        payMemberInfoData.fF(payMemberInfoData.Kc() + getPageContext().getString(d.j.member_will_Expire));
                    }
                    this.hmY.a(payMemberInfoData, 1);
                }
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.hnj) {
            return false;
        }
        if (this.hmY.bEg() == null || this.hmY.bEg().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1 || !this.hmY.aVO()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public void awA() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
        if (this.dIZ == null) {
            this.dIZ = new com.baidu.tieba.write.c(getPageContext(), this.fZw, "main_tab");
            this.dIZ.uF("1");
        }
        if (this.hmY != null) {
            this.hmY.bEj();
        }
        if (!this.dJh.bGn()) {
            this.dIZ.op(false);
        }
    }

    protected void aVK() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ADD_FRAGMENT, new com.baidu.tbadk.mainTab.d(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        s.Og().aq(System.currentTimeMillis());
        setIsAddSwipeBackLayout(false);
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.getDecorView();
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        if (getIntent() == null) {
            i = -1;
        } else {
            S(getIntent());
            i = getIntent().getIntExtra("locate_type", 0);
            if (i == 200) {
                finish();
                return;
            }
            this.mFrom = getIntent().getStringExtra("from");
            if ("from_tieba_kuang".equals(this.mFrom)) {
                TiebaStatic.log(new ak("c12264").s("obj_type", 3));
                KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
                if (KuangFloatingViewController.getInstance().init()) {
                    ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new e() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.2
                        @Override // com.baidu.tbadk.core.e
                        public void aO(boolean z) {
                            if (z) {
                                KuangFloatingViewController.getInstance().showFloatingView();
                            }
                        }
                    });
                }
            }
        }
        this.isFirstGoMaintab = TbadkCoreApplication.getInst().isFirstGoMaintab();
        b bVar = new b();
        com.baidu.tbadk.core.e.b.a(bVar);
        bVar.a(this);
        if (bDU()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        setContentView(d.h.maintabs_activity);
        this.fZw = (FrameLayout) findViewById(d.g.maintabContainer);
        com.baidu.tbadk.core.a.a.wI().wJ();
        this.hmY = new c(this);
        this.hmY.nF(this.mIsLogin);
        bDS();
        aDM();
        com.baidu.tieba.tblauncher.alarmRemind.b.bEm().i(this);
        this.hnd = new com.baidu.tieba.a();
        aVK();
        aWh();
        bDT();
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (bundle != null) {
            i = bundle.getInt("locate_type", 1);
            intent.putExtra("locate_type", i);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        if (TbadkCoreApplication.getFrom() != null && TbadkCoreApplication.getFrom().equals("aishide")) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_ACTIVE, null));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_CLEARTEMP, null));
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_VIDEO_CACHE_CLEAN);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VIDEO_CACHE_CLEAN));
        i(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        com.baidu.tbadk.browser.a.aI(getPageContext().getPageActivity());
        String installOtherApp = TbadkCoreApplication.getInst().getInstallOtherApp();
        if (installOtherApp != null && installOtherApp.length() > 0) {
            UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), installOtherApp);
            TbadkCoreApplication.getInst().setInstallOtherApp(null);
        }
        if (this.isFirstGoMaintab) {
            TbadkCoreApplication.getInst().setFirstGoMaintab(false);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.3
            @Override // java.lang.Runnable
            public void run() {
                MainTabActivity.this.hnj = true;
            }
        });
        registerListener(this.eDj);
        if (i == 1) {
            this.hmY.nH(true);
        } else {
            this.hmY.nH(false);
        }
        this.hmY.bEh();
        this.dwG = getVoiceManager();
        if (this.dwG != null) {
            this.dwG.onCreate(getPageContext());
        }
        registerListener(this.dJy);
        adjustResizeForSoftInput();
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.MAINTAB_ONCREATE_END);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ONCREATE_END));
        s.Og().ar(System.currentTimeMillis());
        if (TbadkCoreApplication.isLogin()) {
            s.Og().Oh();
        }
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.getUserInfo.b.LT().LU();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VR_LOGO_DOWNLAOD));
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("app_restart_times", com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("app_restart_times", 0) + 1);
        this.cvX = new CheckRealNameModel(getPageContext());
        this.cvX.a(this.hnl);
        afj();
        this.dxo = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "homepage");
        this.dJg = new ShareSuccessReplyToServerModel();
        this.dJh = new com.baidu.tieba.p.a(getPageContext());
    }

    private void bDT() {
        av.Di().a(new av.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.4
            @Override // com.baidu.tbadk.core.util.av.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                Map<String, String> eh;
                if (strArr == null || strArr[0] == null) {
                    return 3;
                }
                String lowerCase = strArr[0].toLowerCase();
                if (lowerCase.contains("n/video/opersquare?jump_to_publish_video_thread=1")) {
                    String str = "";
                    String str2 = "";
                    String str3 = "";
                    String ei = av.ei(lowerCase);
                    if (!StringUtils.isNull(ei) && (eh = av.eh(ei)) != null) {
                        String str4 = eh.get("title");
                        str = !StringUtils.isNull(str4) ? URLDecoder.decode(str4) : str4;
                        str2 = eh.get(ImageViewerConfig.FORUM_ID);
                        str3 = eh.get(ImageViewerConfig.FORUM_NAME);
                        if (!StringUtils.isNull(str3)) {
                            str3 = URLDecoder.decode(str3);
                        }
                    }
                    if (ax.be(MainTabActivity.this.getBaseContext())) {
                        if (!StringUtils.isNull(str3) && !StringUtils.isNull(str2)) {
                            ForumWriteData forumWriteData = new ForumWriteData(str2, str3, null, null);
                            forumWriteData.writeCallFrom = "0";
                            f.a(tbPageContext, "", forumWriteData);
                        } else {
                            ForumWriteData forumWriteData2 = new ForumWriteData("", "", null, null);
                            forumWriteData2.writeCallFrom = "0";
                            f.a(tbPageContext, str, forumWriteData2);
                        }
                        TiebaStatic.log(new ak("c12611").s("obj_locate", 4).s("obj_type", 2));
                        TiebaStatic.log(new ak("c12292").ab("obj_locate", "3"));
                    }
                    return 0;
                }
                return 3;
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public ViewGroup wy() {
        return this.fZw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afj() {
        String str = "check_real_name" + TbConfig.getVersion();
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(str, true) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && l.oZ()) {
            this.cvX.oY(CheckRealNameModel.TYPE_APP_FIRST_START);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(str, false);
        }
    }

    private void S(Intent intent) {
        if (intent != null) {
            String dataString = intent.getDataString();
            if (!StringUtils.isNull(dataString) && dataString.startsWith("tbmaintab://")) {
                String decode = Uri.decode(intent.getData().getEncodedPath());
                if (StringUtils.isNull(decode)) {
                    TiebaStatic.log(new ak("c10320").s("obj_type", 1).s("obj_to", 1));
                    return;
                }
                if (decode.startsWith("//")) {
                    decode = decode.substring(2);
                }
                Map<String, String> eh = av.eh(decode);
                if (eh != null) {
                    String str = eh.get("fr");
                    if (!"mpush".equals(str) && "bpush".equals(str)) {
                        ak akVar = new ak("c10320");
                        akVar.ab("obj_locate", eh.get("obj_locate"));
                        akVar.s("obj_type", 1);
                        akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eh.get(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
                        akVar.ab("obj_param2", eh.get("obj_param2"));
                        akVar.s("obj_to", 1);
                        akVar.ab("obj_id", eh.get("bdid"));
                        if (!am.isEmpty(eh.get("ext_log"))) {
                            try {
                                JSONObject jSONObject = new JSONObject(eh.get("ext_log"));
                                Iterator<String> keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    akVar.ab(next, jSONObject.getString(next));
                                }
                            } catch (Exception e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        TiebaStatic.log(akVar);
                    }
                }
            } else if (!StringUtils.isNull(dataString)) {
                if (dataString.startsWith("tbclient://") || dataString.startsWith("tbclient_zm://")) {
                    String dataString2 = intent.getDataString();
                    if (!StringUtils.isNull(dataString2)) {
                        av.Di().c(getPageContext(), new String[]{dataString2});
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
        this.dwG = getVoiceManager();
        if (this.dwG != null) {
            this.dwG.onStart(getPageContext());
        }
    }

    public boolean bDU() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_SYNC, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_ACTIVE, null));
        aDN();
        com.baidu.tbadk.coreExtra.messageCenter.a.Gm().Gz();
        com.baidu.tbadk.coreExtra.messageCenter.a.Gm().Gs();
        com.baidu.tbadk.coreExtra.messageCenter.a.Gm().by(false);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        if (this.mWaitingDialog != null) {
            g.b(this.mWaitingDialog, getPageContext());
            this.mWaitingDialog = null;
        }
        bDV();
        if (this.hmY != null) {
            this.hmY.onDestroy();
        }
        try {
            super.onDestroy();
        } catch (Exception e) {
        }
        com.baidu.tbadk.core.e.b.a(null);
        this.dwG = getVoiceManager();
        if (this.dwG != null) {
            this.dwG.onDestory(getPageContext());
        }
        if (this.dIZ != null) {
            this.dIZ.onDestroy();
        }
        if (this.dxo != null) {
            this.dxo.onDestroy();
        }
        if (this.dJg != null) {
            this.dJg.cancelLoadData();
        }
        System.gc();
    }

    private void bDV() {
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

    private void aDM() {
        registerListener(this.hnf);
        this.guY.setPriority(100);
        registerListener(this.guY);
        registerListener(this.hni);
        registerListener(this.hnk);
        registerListener(this.hnn);
        registerListener(this.hno);
        registerListener(this.hnh);
        registerListener(this.skinTypeChangeListener);
        registerListener(this.hnm);
        this.hmZ = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.hmZ, intentFilter);
        registerListener(this.dxC);
        registerListener(this.hng);
        registerListener(this.dhO);
        registerListener(this.hnm);
        registerListener(this.hnq);
    }

    private void aDN() {
        if (this.hmZ != null) {
            unregisterReceiver(this.hmZ);
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
        this.hmU = this.hmY.bEg().getCurrentTabType();
        changeSkinType(this.mSkinType);
        if (TbadkCoreApplication.isLogin() && s.Og().Of()) {
            s.Og().Oh();
        }
        this.dwG = getVoiceManager();
        if (this.dwG != null) {
            this.dwG.onResume(getPageContext());
        }
        if (this.hmY != null) {
            this.hmY.bEh();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_ON_RESUME, getActivity()));
        if (KuangFloatingViewController.getInstance().init()) {
            ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new e() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.7
                @Override // com.baidu.tbadk.core.e
                public void aO(boolean z) {
                    if (z) {
                        KuangFloatingViewController.getInstance().showFloatingView();
                    }
                }
            });
        }
        if (TbadkCoreApplication.getKeepLiveSwitch(getApplicationContext())) {
            com.baidu.adp.lib.g.e.nr().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.8
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_KEEPLIVE_START_SERVICE, Boolean.FALSE));
                }
            }, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.hnc = true;
        if (z) {
            com.baidu.tbadk.getUserInfo.b.LT().LU();
            bDS();
            afj();
        }
        this.hmY.switchNaviBarStatus(z);
        aVK();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (this.hmT) {
            this.hmT = false;
            CompatibleUtile.setAnim(getPageContext().getPageActivity(), d.a.down, d.a.hold);
        }
        this.dwG = getVoiceManager();
        if (this.dwG != null) {
            this.dwG.onPause(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOME_HIDE_GUIDE));
        if (this.hmY != null) {
            this.hmY.bEj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
        } catch (Exception e) {
        }
        bundle.putInt("locate_type", this.hmY.bEg().getCurrentTabType());
        bundle.putParcelable("android:fragments", null);
        bundle.putParcelable("android:support:fragments", null);
        this.dwG = getVoiceManager();
        if (this.dwG != null) {
            this.dwG.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.dwG = getVoiceManager();
        if (this.dwG != null) {
            this.dwG.onStop(getPageContext());
        }
        HomePageStatic.dZD = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        S(intent);
        setIntent(intent);
        com.baidu.tbadk.getUserInfo.b.LT().LU();
        if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_RESET_TABS));
            aVK();
        }
        int intExtra = intent.getIntExtra("locate_type", 1);
        if (intExtra == 200) {
            finish();
        } else if (intExtra == 11) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), true)));
            finish();
        } else if (intExtra == 12) {
            TbadkCoreApplication.getInst().notifyAppEnterBackground();
            finish();
        } else if (intExtra == 1 || intExtra == 3 || intExtra == 2 || intExtra == 4 || intExtra == 8 || intExtra == 15) {
            if (intExtra != 8 && intExtra != 3 && intExtra != 15) {
                intExtra = this.hnd.RN();
            }
            this.hmY.bEg().setCurrentTabByType(intExtra);
        }
        i(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        if (this.hmY != null) {
            this.hmY.bEh();
        }
        this.mFrom = getIntent().getStringExtra("from");
        if ("from_tieba_kuang".equals(this.mFrom)) {
            TiebaStatic.log(new ak("c12264").s("obj_type", 3));
            KuangFloatingViewController.getInstance().setNeedShowFloatingView(true);
            if (KuangFloatingViewController.getInstance().init()) {
                ((BaseFragmentActivity) getPageContext().getOrignalPage()).grantWindowPermission(new e() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.9
                    @Override // com.baidu.tbadk.core.e
                    public void aO(boolean z) {
                        if (z) {
                            KuangFloatingViewController.getInstance().showFloatingView();
                        }
                    }
                });
            }
        }
    }

    protected void C(Activity activity) {
        new com.baidu.tbadk.core.dialog.a(activity).fc(d.j.confirm_title).aV(false).fd(d.j.background_process_permission).a(d.j.now_goto_setting, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                try {
                    MainTabActivity.this.startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
                    aVar.dismiss();
                } catch (Exception e) {
                    MainTabActivity.this.showToast(d.j.goto_developActivity_error_toast);
                }
            }
        }).b(d.j.next_time, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                MainTabActivity.this.bDW();
            }
        }).b(i.ak(activity)).AI();
    }

    protected void bDW() {
        com.baidu.adp.lib.f.c.nl().d(getUniqueId());
        bDY();
        moveTaskToBack(true);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.l lVar) {
        super.onPreLoad(lVar);
        ad.a(lVar, getUniqueId());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!MainTabActivityConfig.IS_BACK_CLOSE_ALL_ACTIVITY && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
            if (runTask == null || !((Boolean) runTask.getData()).booleanValue()) {
                if (this.dIZ != null && this.dIZ.isShowing()) {
                    this.dIZ.bLt();
                    return true;
                } else if (this.hmY.aVO()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
                    return true;
                } else {
                    if (System.currentTimeMillis() - this.hmW > 2000) {
                        showToast(d.j.double_back_quit);
                        this.hmW = System.currentTimeMillis();
                    } else if (UtilHelper.isBackgroundProcessLimitNone() && Build.VERSION.SDK_INT >= 14) {
                        C(getPageContext().getPageActivity());
                        return true;
                    } else {
                        bDW();
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
            this.hmY.bEg().setCurrentTabByType(this.hnd.RN());
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

    private void aWh() {
        registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Integer) {
                    Integer num = (Integer) customResponsedMessage.getData();
                    if (num.intValue() == 2) {
                        MainTabActivity.this.hmY.nH(true);
                        MainTabActivity.this.hmY.iY(true);
                    } else if (num.intValue() == 1) {
                        MainTabActivity.this.hmY.nH(true);
                        MainTabActivity.this.hmY.iY(false);
                    } else {
                        MainTabActivity.this.hmY.nH(false);
                        MainTabActivity.this.hmY.iY(false);
                    }
                    MainTabActivity.this.hmY.bEh();
                }
            }
        });
    }

    protected void bDX() {
        AntiData antiData = new AntiData();
        antiData.setIfpost(1);
        if (antiData.getIfpost() == 0) {
            l.showToast(getPageContext().getPageActivity(), antiData.getForbid_info());
            return;
        }
        antiData.setIfVoice(false);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteActivityConfig(getPageContext().getPageActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, antiData, 13003, true, false, null, false, false, null, null, null, 0)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.coreExtra.c.d shareItem;
        if (i2 != -1) {
            if (i == 12007) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), 1, getPageContext().getString(d.j.login_home_tab), (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BACK)));
            }
            if (this.hmY.bEg().getCurrentFragment() != null) {
                this.hmY.bEg().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 11001) {
            bDX();
        } else if (i == 13003) {
            ad(intent);
        } else if (i == 23007) {
            M(intent);
        } else if (i == 24007) {
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null && shareItem.linkUrl != null && this.dJg != null) {
                this.dJg.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.14
                    @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                    public void Hl() {
                    }

                    @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                    public void a(final CustomDialogData customDialogData) {
                        com.baidu.adp.lib.g.e.nr().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.14.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.tieba.pb.interactionpopupwindow.c.a(MainTabActivity.this.getPageContext(), customDialogData).show();
                            }
                        }, 1000L);
                    }
                });
            }
        } else if (this.hmY.bEg().getCurrentFragment() != null) {
            this.hmY.bEg().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    private ShareFromPBMsgData axa() {
        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.biN == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.biN.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.biQ);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.biL);
        shareFromPBMsgData.setThreadId(shareItem.tid);
        return shareFromPBMsgData;
    }

    private void M(Intent intent) {
        a(axa(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final com.baidu.tieba.view.l lVar = new com.baidu.tieba.view.l(getPageContext().getPageActivity());
            lVar.setData(shareFromPBMsgData);
            aVar.ff(1);
            aVar.aO(lVar);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.15
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MainTabActivity.this.HidenSoftKeyPad((InputMethodManager) MainTabActivity.this.getSystemService("input_method"), lVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(MainTabActivity.this.getPageContext().getPageActivity(), j, str, str2, 0, lVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.Iw() != null) {
                        Bundle Iw = shareItem.Iw();
                        TiebaStatic.log(new ak("share_success").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).s("obj_type", Iw.getInt("obj_type")).s("obj_param1", 3).ab(ImageViewerConfig.FORUM_ID, Iw.getString(ImageViewerConfig.FORUM_ID)).ab("tid", Iw.getString("tid")));
                    }
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.16
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MainTabActivity.this.HidenSoftKeyPad((InputMethodManager) MainTabActivity.this.getSystemService("input_method"), lVar.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.aW(true);
            aVar.b(getPageContext()).AI();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                lVar.J(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.hmY.onChangeSkinType(i);
        ex(i);
        if (this.dIZ != null) {
            this.dIZ.onChangeSkinType();
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
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PERSONALIZED_MAINTAB_ON_RESULT, postWriteCallBackData));
            this.hmY.b(postWriteCallBackData);
        }
    }

    private void bDY() {
        if (System.currentTimeMillis() - this.hmX >= 7200000) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_CLEARTEMP, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
            this.hmX = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.a
    public int getCurrentTabType() {
        if (this.hmY.bEg() != null) {
            return this.hmY.bEg().getCurrentTabType();
        }
        return -1;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dwG == null) {
            this.dwG = VoiceManager.instance();
        }
        return this.dwG;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public ListView El() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Em() {
        if (this.bcT == null) {
            this.bcT = UserIconBox.v(getPageContext().getPageActivity(), 8);
        }
        return this.bcT;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.17
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean Nq() {
                return true;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int Nr() {
                return com.baidu.tbadk.pageStayDuration.e.Nv().Nx();
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
        if (this.hnc && currentPageSourceKeyList != null) {
            currentPageSourceKeyList.clear();
            this.hnc = false;
            return null;
        }
        return currentPageSourceKeyList;
    }
}
