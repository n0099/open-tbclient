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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bb;
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
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.p;
import com.baidu.tbadk.util.z;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.Thread2GroupShareView;
import com.baidu.tieba.write.e;
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
/* loaded from: classes4.dex */
public class MainTabActivity extends BaseFragmentActivity implements com.baidu.tbadk.core.util.e.c, UserIconBox.b, VoiceManager.c, FrsCommonImageLayout.c, com.baidu.tieba.tblauncher.a {
    private static boolean jkL;
    private WeakReference<Context> bBD;
    private boolean bqR;
    private com.baidu.adp.lib.e.b<TbImageView> ccT;
    private CheckRealNameModel dZq;
    private com.baidu.tieba.ueg.d eXh;
    private ShareSuccessReplyToServerModel fJN;
    VoiceManager ftO;
    private com.baidu.tieba.NEGFeedBack.a fuF;
    private e fxr;
    private com.baidu.tieba.ueg.b iBV;
    private av jkG;
    private d jkJ;
    private a jkK;
    private com.baidu.adp.lib.e.b<TbImageView> jkN;
    private com.baidu.tieba.a jkP;
    private FrameLayout jkQ;
    private c jkS;
    private com.baidu.tbadk.BdToken.d jkT;
    private String jli;
    private boolean jkC = false;
    private int jkD = -1;
    private boolean jkE = false;
    private String mFrom = null;
    private volatile boolean jkF = false;
    private long jkH = 0;
    private long jkI = 0;
    private long jkM = -1;
    private boolean jkO = false;
    private String jkR = "";
    boolean jkU = false;
    boolean eat = false;
    boolean fsY = true;
    private CustomMessageListener jkV = new CustomMessageListener(2010045) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && MainTabActivity.this.jkJ != null && TbadkCoreApplication.getInst().getCurrentActivity() == MainTabActivity.this) {
                MainTabActivity.this.jkU = com.baidu.adp.lib.g.b.d(customResponsedMessage.getData().toString(), false);
                MainTabActivity.this.jkJ.onKeyboardVisibilityChanged((MainTabActivity.this.jkU || MainTabActivity.this.eat) ? true : true);
            }
        }
    };
    private final CustomMessageListener jkW = new CustomMessageListener(2001377) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.12
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
                        MainTabActivity.this.jkJ.bnz().hS(1);
                    } else if (TbadkCoreApplication.getInst().isThemeIconCover()) {
                        MainTabActivity.this.jkJ.bnz().hS(2);
                    } else {
                        MainTabActivity.this.jkJ.bnz().hS(1);
                    }
                }
            }
        }
    };
    public CustomMessageListener jkX = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && MainTabActivity.this.jkJ != null && MainTabActivity.this.jkJ.bnz() != null) {
                if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    MainTabActivity.this.jkJ.bnz().getTabWrapper().animate().translationY(MainTabActivity.this.jkJ.bnz().getTabWrapper().getHeight()).setDuration(200L).start();
                } else {
                    MainTabActivity.this.jkJ.bnz().getTabWrapper().animate().translationY(0.0f).setDuration(400L).start();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c gMn = new com.baidu.adp.framework.listener.c(1001) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ConfigVersion configVersion;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                if (socketResponsedMessage.getError() == 0 && (configVersion = responseOnlineMessage.getConfigVersion()) != null) {
                    MainTabActivity.this.Fi(configVersion.sync);
                }
            }
        }
    };
    private CustomMessageListener jkY = new CustomMessageListener(2001609) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.31
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
                    int f = com.baidu.adp.lib.g.b.f(substring3, 0);
                    if (hVar.getPageContext() != null) {
                        p.a(substring2, substring, substring4, f, hVar.getPageContext());
                    } else {
                        p.a(substring2, substring, substring4, f, MainTabActivity.this.getPageContext());
                    }
                }
            }
        }
    };
    private final CustomMessageListener jkZ = new CustomMessageListener(2001247) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getData() instanceof PayMemberInfoData) {
                    MainTabActivity.this.a((PayMemberInfoData) customResponsedMessage.getData());
                    TbadkCoreApplication.getInst().setPaymemberInfo((PayMemberInfoData) customResponsedMessage.getData());
                }
                UserData atq = com.baidu.tbadk.getUserInfo.b.ato().atq();
                if (TbadkCoreApplication.isLogin() && atq != null && atq.getUserId() != null && !atq.getUserId().equals(MainTabActivity.this.jkR) && atq.getIsGodInvited()) {
                    MainTabActivity.this.jkR = atq.getUserId();
                    MainTabActivity.this.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(MainTabActivity.this.getPageContext().getPageActivity(), "", TbWebViewActivityConfig.GOD_INVITE_JUMP_URL + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE, true)));
                }
            }
        }
    };
    private CustomMessageListener fve = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                MainTabActivity.this.jkJ.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    final CustomMessageListener jla = new CustomMessageListener(2007002) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.tbadk.mainTab.b> list;
            MainTabActivity.this.jkF = false;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (list = ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).getList()) != null && list.size() != 0) {
                MainTabActivity.this.jkJ.aq(list);
                if (MainTabActivity.this.jkE) {
                    MainTabActivity.this.jkJ.bnz().setCurrentTabByType(MainTabActivity.this.jkD);
                } else if (MainTabActivity.this.getActivity().getIntent() == null || MainTabActivity.this.getActivity().getIntent().getDataString() == null || !MainTabActivity.this.getActivity().getIntent().getDataString().startsWith("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                    MainTabActivity.this.aw(MainTabActivity.this.getIntent());
                } else {
                    MainTabActivity.this.jkJ.bnz().setCurrentTabByType(2);
                }
                MainTabActivity.this.jkE = false;
                MainTabActivity.this.jkJ.crx();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, null));
            }
        }
    };
    final CustomMessageListener jlb = new CustomMessageListener(2007013) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007013) {
                MainTabActivity.this.bPs();
                if (MainTabActivity.this.jkJ != null && MainTabActivity.this.jkJ.bnz() != null) {
                    MainTabActivity.this.jkD = MainTabActivity.this.jkJ.bnz().getCurrentTabType();
                }
                MainTabActivity.this.jkE = true;
            }
        }
    };
    final CustomMessageListener jlc = new CustomMessageListener(2921333) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (MainTabActivity.this.jkG != null || (customResponsedMessage.getData() instanceof av)) {
                    if (customResponsedMessage.getData() != null) {
                        MainTabActivity.this.jkG = (av) customResponsedMessage.getData();
                    }
                    if (!MainTabActivity.this.jkF && MainTabActivity.this.jkG != null && TbadkCoreApplication.isLogin()) {
                        MainTabActivity.this.jkS.j(MainTabActivity.this.jkG.recom_title, MainTabActivity.this.jkG.recom_topic, MainTabActivity.this.jkG.bIw);
                    }
                }
            }
        }
    };
    private final CustomMessageListener jld = new CustomMessageListener(2007005) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.f.b.ahF() == null) {
                b bVar = new b();
                bVar.a(MainTabActivity.this);
                com.baidu.tbadk.core.f.b.a(bVar);
            }
        }
    };
    private CustomMessageListener jle = new CustomMessageListener(2921380) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && !aq.isEmpty((String) customResponsedMessage.getData())) {
                String str = (String) customResponsedMessage.getData();
                if (KuangFloatingViewController.getInstance().init()) {
                    KuangFloatingViewController.getInstance().setInfo(str);
                    ((BaseFragmentActivity) MainTabActivity.this.getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.5.1
                        @Override // com.baidu.tbadk.core.e
                        public void dE(boolean z) {
                            if (z) {
                                KuangFloatingViewController.getInstance().showFloatingView();
                                TiebaStatic.log(new an("c12264").P("obj_type", 3));
                            }
                        }
                    });
                }
            }
        }
    };
    private CheckRealNameModel.a jlf = new CheckRealNameModel.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.9
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void a(int i, String str, String str2, Object obj) {
            if (CheckRealNameModel.TYPE_APP_FIRST_START.equals(str2) && i == 1990055) {
                TiebaStatic.log("c12138");
                MainTabActivity.this.jkJ.Fk(MainTabActivity.this.getResources().getString(R.string.check_real_name_message));
            }
        }
    };
    private CustomMessageListener bBu = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && l.kt()) {
                MainTabActivity.this.aUy();
                if (!MainTabActivity.jkL) {
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
                MainTabActivity.this.jkO = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
                com.baidu.tbadk.core.sharedPref.b.ahO().remove("key_feedback_tip");
                com.baidu.tbadk.core.sharedPref.b.ahO().remove("key_feedback_tip_show");
                com.baidu.tbadk.core.sharedPref.b.ahO().remove("key_feedback_tip_tab_show");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016560));
                if (MainTabActivity.this.jkT != null) {
                    MainTabActivity.this.jkT.check();
                }
                if (MainTabActivity.this.jkJ != null) {
                    MainTabActivity.this.jkJ.crC();
                }
            }
        }
    };
    private CustomMessageListener jlg = new CustomMessageListener(2016509) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                n.bRq = ((Boolean) customResponsedMessage.getData()).booleanValue();
                MainTabActivity.this.crk();
            }
        }
    };
    private final CustomMessageListener jlh = new CustomMessageListener(2001230) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("game_is_show_tip", booleanValue);
                MainTabActivity.this.jkJ.rp(booleanValue);
            }
        }
    };
    private CustomMessageListener byN = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.25
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                boolean unused = MainTabActivity.jkL = true;
                if (MainTabActivity.this.jkJ != null && MainTabActivity.this.jkJ.cry() != null && MainTabActivity.this.jkJ.cry().getAnimationView() != null && MainTabActivity.this.jkJ.cry().getAnimationView().getVisibility() != 0) {
                    MainTabActivity.this.jkJ.cry().setLottieView(false);
                }
                if (!TbadkCoreApplication.getInst().getActivityPrizeData().alQ()) {
                    if (MainTabActivity.this.jkJ != null) {
                        MainTabActivity.this.jkJ.Fj(null);
                    }
                } else {
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getInst().getActivityPrizeData().alU()) {
                        String alT = TbadkCoreApplication.getInst().getActivityPrizeData().alT();
                        if (!StringUtils.isNull(alT) && com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("activity_prize_get_tip" + TbadkCoreApplication.getCurrentAccount(), true)) {
                            bb.ajC().a(MainTabActivity.this.getPageContext(), new String[]{alT}, true);
                            com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("activity_prize_get_tip" + TbadkCoreApplication.getCurrentAccount(), false);
                        }
                    }
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                        if (MainTabActivity.this.jkJ != null) {
                            MainTabActivity.this.jkJ.Fj(null);
                        }
                    } else {
                        String alW = TbadkCoreApplication.getInst().getActivityPrizeData().alW();
                        if (!StringUtils.isNull(alW)) {
                            if (MainTabActivity.this.jkJ != null) {
                                MainTabActivity.this.jkJ.Fj(alW);
                            }
                        } else if (MainTabActivity.this.jkJ != null) {
                            MainTabActivity.this.jkJ.Fj(null);
                        }
                    }
                }
                if (TbSingleton.getInstance().canShowPermDialog()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921360, MainTabActivity.this));
                }
                com.baidu.tbadk.core.business.a.acs().bB("1", "");
            }
        }
    };
    private CustomMessageListener jlj = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    MainTabActivity.this.jli = UtilHelper.getCurrentDay();
                    com.baidu.tbadk.core.sharedPref.b.ahO().putLong("last_resume_time", TbSingleton.getInstance().getLastResumeTime());
                    return;
                }
                String currentDay = UtilHelper.getCurrentDay();
                if (!StringUtils.isNull(currentDay) && !currentDay.equals(MainTabActivity.this.jli)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
                }
                if (MainTabActivity.this.iBV == null) {
                    MainTabActivity.this.iBV = new com.baidu.tieba.ueg.b();
                }
                MainTabActivity.this.iBV.BU(MainTabActivity.this.iBV.jsO);
                MainTabActivity.this.iBV.jsO = au.a.bUj;
            }
        }
    };
    private final CustomMessageListener gYR = new CustomMessageListener(2016493) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.27
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            k kVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof k) && (kVar = (k) customResponsedMessage.getData()) != null && !StringUtils.isNull(kVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(kVar);
                if (StringUtils.isNull(kVar.cqS)) {
                    bb.ajC().c(MainTabActivity.this.getPageContext(), new String[]{kVar.mLink});
                } else {
                    bb.ajC().c(MainTabActivity.this.getPageContext(), new String[]{kVar.mLink, kVar.cqS});
                }
            }
        }
    };
    private CustomMessageListener fvs = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (MainTabActivity.this.fxr != null) {
                MainTabActivity.this.fxr.czy();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Fi(String str) {
        if (str != null && TbadkCoreApplication.getInst().getConfigVersion() != null && crj()) {
            this.jkM = System.currentTimeMillis();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
        }
    }

    private boolean crj() {
        if (-1 == this.jkM) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.jkM;
        return currentTimeMillis <= 0 || currentTimeMillis >= ReportUserInfoModel.TIME_INTERVAL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crk() {
        if (com.baidu.adp.lib.b.d.hS().az("android_game_enter_switch") == 1 && n.bRq) {
            this.jkJ.rn(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016510));
            return;
        }
        this.jkJ.rn(false);
        this.jkJ.rp(false);
        com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("game_is_show_tip", false);
    }

    public void a(PayMemberInfoData payMemberInfoData) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && payMemberInfoData != null) {
            if ((payMemberInfoData.aru() == 1 || payMemberInfoData.aru() == 2) && com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("show_member_deid_line", true)) {
                long acD = payMemberInfoData.acD() * 1000;
                if (acD < System.currentTimeMillis()) {
                    if (StringUtils.isNull(payMemberInfoData.arv())) {
                        payMemberInfoData.pU(getPageContext().getString(R.string.member));
                    } else {
                        payMemberInfoData.pU(payMemberInfoData.arv() + getPageContext().getString(R.string.member_already_Expire));
                    }
                    this.jkJ.a(payMemberInfoData, 0);
                } else if (acD - System.currentTimeMillis() < 259200000) {
                    if (StringUtils.isNull(payMemberInfoData.arv())) {
                        payMemberInfoData.pU(getPageContext().getString(R.string.member));
                    } else {
                        payMemberInfoData.pU(payMemberInfoData.arv() + getPageContext().getString(R.string.member_will_Expire));
                    }
                    this.jkJ.a(payMemberInfoData, 1);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.bqR) {
            return false;
        }
        if (this.jkJ.bnz() == null || this.jkJ.bnz().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1 || !this.jkJ.bPw()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public void bnx() {
        if (this.jkS != null) {
            this.jkS.bsX();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
        if (this.fxr == null) {
            this.fxr = new e(getPageContext(), this.jkQ, "main_tab", TbSingleton.getInstance().isAnimEnable("anim_switch_sendthread_maintab") ? 2 : 1);
            this.fxr.GC("1");
        }
        if (!this.eXh.ctd() && this.jkJ.bnz() != null && this.jkJ.bnz().getFragmentTabWidget() != null) {
            this.fxr.a(false, (View) this.jkJ.bnz().getTabWrapper(), this.jkJ.bnz().getFragmentTabWidget().getWriteView());
        }
    }

    protected void bPs() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007002, new com.baidu.tbadk.mainTab.d(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.baidu.tbadk.p.n.avz().bx(System.currentTimeMillis());
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
            ao(getIntent());
            i = getIntent().getIntExtra("locate_type", 0);
            if (i == 200) {
                finish();
                return;
            }
            this.mFrom = getIntent().getStringExtra("from");
        }
        int i2 = i;
        b bVar = new b();
        com.baidu.tbadk.core.f.b.a(bVar);
        bVar.a(this);
        if (crl()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        setContentView(R.layout.maintabs_activity);
        this.jkQ = (FrameLayout) findViewById(R.id.maintabContainer);
        com.baidu.tbadk.core.a.a.acf().acg();
        this.jkJ = new d(this);
        this.jkS = new c(this);
        this.jkJ.rm(this.mIsLogin);
        crk();
        bzT();
        com.baidu.tieba.tblauncher.alarmRemind.b.crF().e(this);
        com.baidu.tbadk.BdToken.c.Zg().Zh();
        this.jkP = new com.baidu.tieba.a();
        bPs();
        bPH();
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (bundle != null) {
            i2 = bundle.getInt("locate_type", 1);
            intent.putExtra("locate_type", i2);
        }
        this.jli = UtilHelper.getCurrentDay();
        this.jkM = System.currentTimeMillis();
        MessageManager.getInstance().sendMessage(new CustomMessage(2921359));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
        if (TbadkCoreApplication.getFrom() != null && TbadkCoreApplication.getFrom().equals("aishide")) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005011, null));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005013, null));
        MessageManager.getInstance().registerStickyMode(2001404);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001404));
        j(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        com.baidu.tbadk.browser.a.cl(getPageContext().getPageActivity());
        String installOtherApp = TbadkCoreApplication.getInst().getInstallOtherApp();
        if (installOtherApp != null && installOtherApp.length() > 0) {
            UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), installOtherApp);
            TbadkCoreApplication.getInst().setInstallOtherApp(null);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.7
            @Override // java.lang.Runnable
            public void run() {
                MainTabActivity.this.bqR = true;
            }
        });
        registerListener(this.gMn);
        if (i2 == 1) {
            this.jkJ.ro(true);
        } else {
            this.jkJ.ro(false);
        }
        this.jkJ.crA();
        this.ftO = getVoiceManager();
        if (this.ftO != null) {
            this.ftO.onCreate(getPageContext());
        }
        registerListener(this.mAccountChangedListener);
        adjustResizeForSoftInput();
        addGlobalLayoutListener();
        MessageManager.getInstance().registerStickyMode(2007015);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007015));
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.p.n.avz().avA();
        }
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.getUserInfo.b.ato().atp();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016480));
        com.baidu.tbadk.core.sharedPref.b.ahO().putInt("app_restart_times", com.baidu.tbadk.core.sharedPref.b.ahO().getInt("app_restart_times", 0) + 1);
        this.dZq = new CheckRealNameModel(getPageContext());
        this.dZq.a(this.jlf);
        aUy();
        this.fuF = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "homepage");
        this.fJN = new ShareSuccessReplyToServerModel();
        this.eXh = new com.baidu.tieba.ueg.d(getPageContext());
        int i3 = com.baidu.tbadk.core.sharedPref.b.ahO().getInt("need_deal_diversion_jump", 2);
        if (i3 == 2) {
            com.baidu.tbadk.core.sharedPref.b.ahO().putInt("need_deal_diversion_jump", 1);
        } else if (i3 == 1) {
            com.baidu.tbadk.core.sharedPref.b.ahO().putInt("need_deal_diversion_jump", 0);
        }
        this.jkT = com.baidu.tbadk.BdToken.d.Zq();
        TbadkCoreApplication.getInst().SendSkinTypeBroadcast(TbadkCoreApplication.getInst().getSkinType());
        if (TbSingleton.getInstance().isEnableBenchmark() && TbSingleton.getInstance().getCpuFlopsDuration() <= 0) {
            com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.8
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.tbadk.f.a.aaS();
                }
            }, 5000L);
        }
        MessageManager.getInstance().registerListener(this.gYR);
        TbSingleton.getInstance().startOneGame();
        this.bBD = new WeakReference<>(TbadkCoreApplication.getInst());
        com.baidu.tbadk.p.n.avz().by(System.currentTimeMillis());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public ViewGroup getActivityRootView() {
        return this.jkQ;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && this.jkT != null) {
            this.jkT.check();
            this.jkT.Zr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUy() {
        String str = "check_real_name" + TbConfig.getVersion();
        if (com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean(str, true) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && l.kt()) {
            this.dZq.AQ(CheckRealNameModel.TYPE_APP_FIRST_START);
            com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean(str, false);
        }
    }

    private void ao(final Intent intent) {
        if (intent != null) {
            String dataString = intent.getDataString();
            if (!StringUtils.isNull(dataString) && dataString.startsWith("tbmaintab://")) {
                String decode = Uri.decode(intent.getData().getEncodedPath());
                if (StringUtils.isNull(decode)) {
                    TiebaStatic.log(new an("c10320").P("obj_type", 1).P("obj_to", 1));
                    return;
                }
                if (decode.startsWith("//")) {
                    decode = decode.substring(2);
                }
                Map<String, String> oo = bb.oo(decode);
                if (oo != null) {
                    String str = oo.get("fr");
                    if (!"mpush".equals(str) && "bpush".equals(str)) {
                        an anVar = new an("c10320");
                        anVar.bT("obj_locate", oo.get("obj_locate"));
                        anVar.P("obj_type", 1);
                        anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, oo.get(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
                        anVar.bT("obj_param2", oo.get("obj_param2"));
                        anVar.P("obj_to", 1);
                        anVar.bT(VideoPlayActivityConfig.OBJ_ID, oo.get("bdid"));
                        if (!aq.isEmpty(oo.get("ext_log"))) {
                            try {
                                JSONObject jSONObject = new JSONObject(oo.get("ext_log"));
                                Iterator<String> keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    anVar.bT(next, jSONObject.getString(next));
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
            } else if (!StringUtils.isNull(dataString) && (dataString.startsWith("tbclient://") || dataString.startsWith("tbclient_zm://"))) {
                String dataString2 = intent.getDataString();
                if (!StringUtils.isNull(dataString2)) {
                    bb.ajC().c(getPageContext(), new String[]{dataString2});
                }
            } else if (!StringUtils.isNULL(dataString) && dataString.startsWith(f.bzd)) {
                f.Zw().a(intent.getData(), new f.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.11
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void o(HashMap<String, Object> hashMap) {
                        String str2;
                        if (hashMap != null && intent != null) {
                            Object obj = hashMap.get(f.bzo);
                            int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : -1;
                            Object obj2 = hashMap.get(f.bzp);
                            if (!(obj2 instanceof String)) {
                                str2 = null;
                            } else {
                                str2 = (String) obj2;
                            }
                            if (intValue != -1) {
                                intent.putExtra("is_from_scheme", true);
                                intent.putExtra("locate_type", intValue);
                                intent.putExtra("sub_locate_type", str2);
                            }
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
        this.ftO = getVoiceManager();
        if (this.ftO != null) {
            this.ftO.onStart(getPageContext());
        }
    }

    public boolean crl() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005010, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005012, null));
        bzU();
        com.baidu.tbadk.coreExtra.messageCenter.b.anD().anP();
        com.baidu.tbadk.coreExtra.messageCenter.b.anD().anJ();
        com.baidu.tbadk.coreExtra.messageCenter.b.anD().eA(false);
        MessageManager.getInstance().unRegisterListener(this.gYR);
        MessageManager.getInstance().unRegisterListener(this.jle);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.ej(false);
            this.mWaitingDialog = null;
        }
        crm();
        if (this.jkJ != null) {
            this.jkJ.onDestroy();
        }
        if (this.jkS != null) {
            this.jkS.onDestroy();
        }
        try {
            super.onDestroy();
        } catch (Exception e) {
        }
        com.baidu.tbadk.core.f.b.a(null);
        this.ftO = getVoiceManager();
        if (this.ftO != null) {
            this.ftO.onDestory(getPageContext());
        }
        if (this.fxr != null) {
            this.fxr.onDestroy();
        }
        if (this.fuF != null) {
            this.fuF.onDestroy();
        }
        if (this.fJN != null) {
            this.fJN.cancelLoadData();
        }
        if (this.iBV != null) {
            this.iBV.onDestroy();
        }
        if (this.jkJ != null && this.jkJ.cry() != null) {
            this.jkJ.cry().onDestory();
        }
        System.gc();
    }

    private void crm() {
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

    private void bzT() {
        registerListener(this.jkW);
        this.jla.setPriority(100);
        registerListener(this.jla);
        registerListener(this.jlb);
        registerListener(this.jlc);
        registerListener(this.jld);
        registerListener(this.jlg);
        registerListener(this.jlh);
        registerListener(this.jkZ);
        registerListener(this.skinTypeChangeListener);
        registerListener(this.jkX);
        this.jkK = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.jkK, intentFilter);
        registerListener(this.fve);
        registerListener(this.jkY);
        registerListener(this.byN);
        registerListener(this.bBu);
        registerListener(this.jlj);
        this.jkV.setTag(getUniqueId());
        registerListener(this.jkV);
        registerListener(this.jle);
        registerListener(this.fvs);
    }

    private void bzU() {
        if (this.jkK != null) {
            unregisterReceiver(this.jkK);
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
        if (this.fsY) {
            ad.c(this.bBD);
            this.fsY = false;
        }
        if (this.jkJ != null && this.jkJ.cry() != null) {
            this.jkJ.cry().setLottieView(true);
        }
        if (this.jkJ != null && this.jkJ.bnz() != null) {
            this.jkD = this.jkJ.bnz().getCurrentTabType();
        }
        changeSkinType(this.mSkinType);
        if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.p.n.avz().avx()) {
            com.baidu.tbadk.p.n.avz().avA();
        }
        this.ftO = getVoiceManager();
        if (this.ftO != null) {
            this.ftO.onResume(getPageContext());
        }
        this.jkJ.crA();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001385, getActivity()));
        if (TbadkCoreApplication.getKeepLiveSwitch(getApplicationContext())) {
            com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.13
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921300, Boolean.FALSE));
                }
            }, 3000L);
        }
        com.baidu.tbadk.p.n.avz().avA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.jkO = true;
        if (z) {
            com.baidu.tbadk.getUserInfo.b.ato().atp();
            crk();
            aUy();
        }
        this.jkJ.switchNaviBarStatus(z);
        this.jkJ.crC();
        bPs();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (this.jkC) {
            this.jkC = false;
            CompatibleUtile.setAnim(getPageContext().getPageActivity(), R.anim.down, R.anim.hold);
        }
        this.ftO = getVoiceManager();
        if (this.ftO != null) {
            this.ftO.onPause(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921003));
        if (this.jkS != null) {
            this.jkS.bsY();
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
        bundle.putInt("locate_type", this.jkJ.bnz().getCurrentTabType());
        bundle.putParcelable("android:fragments", null);
        bundle.putParcelable("android:support:fragments", null);
        this.ftO = getVoiceManager();
        if (this.ftO != null) {
            this.ftO.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.ftO = getVoiceManager();
        if (this.ftO != null) {
            this.ftO.onStop(getPageContext());
        }
        this.fsY = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        int i = 2;
        super.onNewIntent(intent);
        setIntent(intent);
        ao(intent);
        com.baidu.tbadk.getUserInfo.b.ato().atp();
        if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007008));
            bPs();
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
                i = this.jkP.aAr();
            }
            if (this.jkJ != null && this.jkJ.bnz() != null) {
                this.jkJ.bnz().setCurrentTabByType(i);
            }
        }
        j(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        this.jkJ.crA();
    }

    protected void au(Activity activity) {
        new com.baidu.tbadk.core.dialog.a(activity).ht(R.string.confirm_title).dQ(false).hu(R.string.background_process_permission).a(R.string.now_goto_setting, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.15
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                try {
                    MainTabActivity.this.startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
                    aVar.dismiss();
                } catch (Exception e) {
                    MainTabActivity.this.showToast(R.string.goto_developActivity_error_toast);
                }
            }
        }).b(R.string.next_time, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.14
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                MainTabActivity.this.crn();
            }
        }).b(i.ab(activity)).agI();
    }

    protected void crn() {
        com.baidu.adp.lib.f.c.iE().d(getUniqueId());
        crp();
        try {
            moveTaskToBack(true);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.p pVar) {
        super.onPreLoad(pVar);
        com.baidu.tbadk.core.util.ad.a(pVar, getUniqueId());
        com.baidu.tbadk.core.util.e.d.a(pVar, getUniqueId(), this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!MainTabActivityConfig.IS_BACK_CLOSE_ALL_ACTIVITY && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016322, (Class) null);
            if (runTask == null || !((Boolean) runTask.getData()).booleanValue()) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2016323, (Class) null);
                if (runTask2 == null || !((Boolean) runTask2.getData()).booleanValue()) {
                    if (this.fxr != null && this.fxr.isShowing()) {
                        this.fxr.sb(true);
                        return true;
                    } else if (this.jkJ.bPw()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007010));
                        return true;
                    } else {
                        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(2921405, Boolean.class, false);
                        if (runTask3 == null || runTask3.getData() == null || !(runTask3.getData() instanceof Boolean) || !((Boolean) runTask3.getData()).booleanValue()) {
                            if (System.currentTimeMillis() - this.jkH > 2000) {
                                showToast(R.string.double_back_quit);
                                this.jkH = System.currentTimeMillis();
                            } else if (UtilHelper.isBackgroundProcessLimitNone() && Build.VERSION.SDK_INT >= 14) {
                                au(getPageContext().getPageActivity());
                                return true;
                            } else {
                                crn();
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
    public void aw(Intent intent) {
        int aAr;
        try {
            if (intent.getBooleanExtra("is_from_scheme", false)) {
                aAr = intent.getIntExtra("locate_type", 1);
            } else {
                aAr = this.jkP.aAr();
            }
            this.jkJ.bnz().setCurrentTabByType(aAr);
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

    private void bPH() {
        registerListener(new CustomMessageListener(2007009) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Integer) {
                    Integer num = (Integer) customResponsedMessage.getData();
                    if (num.intValue() == 2) {
                        MainTabActivity.this.jkJ.ro(true);
                        MainTabActivity.this.jkJ.nB(true);
                    } else if (num.intValue() == 1) {
                        MainTabActivity.this.jkJ.ro(true);
                        MainTabActivity.this.jkJ.nB(false);
                    } else {
                        MainTabActivity.this.jkJ.ro(false);
                        MainTabActivity.this.jkJ.nB(false);
                    }
                    MainTabActivity.this.jkJ.crA();
                }
            }
        });
    }

    protected void cro() {
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
            if (this.jkJ.bnz().getCurrentFragment() != null) {
                this.jkJ.bnz().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 11001) {
            cro();
        } else if (i == 13003) {
            ax(intent);
        } else if (i == 23007) {
            ag(intent);
        } else if (i == 13011) {
            com.baidu.tieba.n.a.chl().y(getPageContext());
        } else if (i == 24007) {
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1) {
                com.baidu.tieba.n.a.chl().y(getPageContext());
                com.baidu.tbadk.coreExtra.c.e shareItem = TbadkCoreApplication.getInst().getShareItem();
                if (shareItem != null && shareItem.linkUrl != null && this.fJN != null) {
                    this.fJN.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.17
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void aoN() {
                        }

                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void a(final CustomDialogData customDialogData) {
                            com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.17.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a(MainTabActivity.this.getPageContext(), customDialogData).show();
                                }
                            }, 1000L);
                        }
                    });
                }
            }
        } else if (this.jkJ.bnz().getCurrentFragment() != null) {
            this.jkJ.bnz().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    private ShareFromPBMsgData bra() {
        com.baidu.tbadk.coreExtra.c.e shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.imageUri == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.imageUri.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.ckI);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.ckC);
        shareFromPBMsgData.setThreadId(shareItem.tid);
        return shareFromPBMsgData;
    }

    private void ag(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(bra(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.hx(1);
            aVar.aH(thread2GroupShareView);
            aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.18
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MainTabActivity.this.HidenSoftKeyPad((InputMethodManager) MainTabActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(MainTabActivity.this.getPageContext().getPageActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    com.baidu.tbadk.coreExtra.c.e shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.apW() != null) {
                        Bundle apW = shareItem.apW();
                        TiebaStatic.log(new an("share_success").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).P("obj_type", apW.getInt("obj_type")).P("obj_param1", 3).bT("fid", apW.getString("fid")).bT("tid", apW.getString("tid")));
                    }
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.19
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MainTabActivity.this.HidenSoftKeyPad((InputMethodManager) MainTabActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.dR(true);
            aVar.b(getPageContext()).agI();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.am(shareFromPBMsgData.getImageUrl(), false);
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
        this.jkJ.onChangeSkinType(i);
        adjustResizeForSoftInputOnSkinTypeChanged(i);
        if (this.fxr != null) {
            this.fxr.onChangeSkinType(i);
        }
    }

    private void ax(Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        if (intent != null) {
            try {
                postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
            } catch (Exception e) {
                BdLog.e(e);
                postWriteCallBackData = null;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921030, postWriteCallBackData));
            if (this.jkJ != null && !this.jkJ.d(postWriteCallBackData)) {
                this.jkJ.b(postWriteCallBackData);
            }
        }
    }

    private void crp() {
        if (System.currentTimeMillis() - this.jkI >= 7200000) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage(2006002, hashMap));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005013, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            this.jkI = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.a
    public int getCurrentTabType() {
        if (this.jkJ.bnz() != null) {
            return this.jkJ.bnz().getCurrentTabType();
        }
        return -1;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.ftO == null) {
            this.ftO = VoiceManager.instance();
        }
        return this.ftO;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public ListView ald() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> ale() {
        if (this.ccT == null) {
            this.ccT = UserIconBox.q(getPageContext().getPageActivity(), 8);
        }
        return this.ccT;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> blm() {
        if (this.jkN == null) {
            this.jkN = FrsCommonImageLayout.y(getPageContext().getPageActivity(), 12);
        }
        return this.jkN;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.o.a
    public com.baidu.tbadk.o.b getPageStayFilter() {
        return new com.baidu.tbadk.o.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.20
            @Override // com.baidu.tbadk.o.b
            public boolean auT() {
                return true;
            }

            @Override // com.baidu.tbadk.o.b
            public int auU() {
                return com.baidu.tbadk.o.e.auZ().avc();
            }

            @Override // com.baidu.tbadk.o.b
            public boolean a(com.baidu.tbadk.o.d dVar) {
                return false;
            }
        };
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.o.a
    public List<String> getCurrentPageSourceKeyList() {
        List<String> currentPageSourceKeyList = super.getCurrentPageSourceKeyList();
        if (this.jkO && currentPageSourceKeyList != null) {
            currentPageSourceKeyList.clear();
            this.jkO = false;
            return null;
        }
        return currentPageSourceKeyList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.eat = z;
        boolean z2 = this.jkU || this.eat;
        if (this.jkJ != null) {
            this.jkJ.onKeyboardVisibilityChanged(z2);
        }
    }

    @Override // com.baidu.tbadk.core.util.e.c
    public boolean videoNeedPreload() {
        return ad.kY(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            super.onConfigurationChanged(configuration);
            int i = configuration.uiMode & 48;
            if (TbadkCoreApplication.getInst().getSkinType() == 1 && i == 16) {
                TbadkCoreApplication.getInst().setSkinType(0);
            } else if (TbadkCoreApplication.getInst().getSkinType() == 0 && i == 32) {
                TbadkCoreApplication.getInst().setSkinType(1);
            }
        }
    }
}
