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
import com.baidu.adp.base.i;
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
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.p;
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
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.e;
import com.baidu.tbadk.core.message.ExitAppMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.data.UserData;
import com.baidu.tbadk.data.j;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.switchs.GameEnterSwitch;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.util.q;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.Thread2GroupShareView;
import com.baidu.tieba.write.f;
import com.baidu.tieba.write.g;
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
/* loaded from: classes7.dex */
public class MainTabActivity extends BaseFragmentActivity implements com.baidu.tbadk.core.util.g.c, UserIconBox.b, VoiceManager.c, FrsCommonImageLayout.c, com.baidu.tieba.tblauncher.a {
    private static boolean kld;
    private WeakReference<Context> OC;
    private com.baidu.adp.lib.d.b<TbImageView> deV;
    private com.baidu.tieba.ueg.d fSG;
    private ShareSuccessReplyToServerModel gCs;
    private com.baidu.tieba.NEGFeedBack.a gmW;
    VoiceManager gmi;
    private f gpH;
    private CheckRealNameModel iJu;
    private com.baidu.tieba.ueg.b jAS;
    private ay kkY;
    private String klC;
    private d klb;
    private a klc;
    private com.baidu.adp.lib.d.b<TbImageView> klf;
    private com.baidu.tieba.b klh;
    private FrameLayout kli;
    private c klk;
    private com.baidu.tbadk.BdToken.d kll;
    private boolean mTouchable;
    private boolean kkV = false;
    private int kkW = -1;
    private boolean kkX = false;
    private String mFrom = null;
    private volatile boolean mIsAdd = false;
    private long kkZ = 0;
    private long kla = 0;
    private long kle = -1;
    private boolean klg = false;
    private String klj = "";
    boolean klm = false;
    boolean fiB = false;
    boolean glo = true;
    private int kln = 16;
    private CustomMessageListener klo = new CustomMessageListener(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && MainTabActivity.this.klb != null && TbadkCoreApplication.getInst().getCurrentActivity() == MainTabActivity.this) {
                MainTabActivity.this.klm = com.baidu.adp.lib.f.b.toBoolean(customResponsedMessage.getData().toString(), false);
                MainTabActivity.this.klb.onKeyboardVisibilityChanged((MainTabActivity.this.klm || MainTabActivity.this.fiB) ? true : true);
            }
        }
    };
    private final CustomMessageListener klp = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_MATINTAB) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.12
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
                        MainTabActivity.this.klb.bDV().changeStyle(1);
                    } else if (TbadkCoreApplication.getInst().isThemeIconCover()) {
                        MainTabActivity.this.klb.bDV().changeStyle(2);
                    } else {
                        MainTabActivity.this.klb.bDV().changeStyle(1);
                    }
                }
            }
        }
    };
    public CustomMessageListener klq = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && MainTabActivity.this.klb != null && MainTabActivity.this.klb.bDV() != null) {
                if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    MainTabActivity.this.klb.bDV().getTabWrapper().animate().translationY(MainTabActivity.this.klb.bDV().getTabWrapper().getHeight()).setDuration(200L).start();
                } else {
                    MainTabActivity.this.klb.bDV().getTabWrapper().animate().translationY(0.0f).setDuration(400L).start();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c hDO = new com.baidu.adp.framework.listener.c(1001) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ConfigVersion configVersion;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                if (socketResponsedMessage.getError() == 0 && (configVersion = responseOnlineMessage.getConfigVersion()) != null) {
                    MainTabActivity.this.Jk(configVersion.sync);
                }
            }
        }
    };
    private CustomMessageListener klr = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_JUMP_PB) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            j jVar;
            String link;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof j) && (link = (jVar = (j) customResponsedMessage.getData()).getLink()) != null) {
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
                        if (jVar.getPageContext() != null) {
                            q.a(queryParameter2, queryParameter, queryParameter4, i, jVar.getPageContext(), baijiahaoData);
                        } else {
                            q.a(queryParameter2, queryParameter, queryParameter4, i, MainTabActivity.this.getPageContext(), baijiahaoData);
                        }
                    } else if (baijiahaoData != null) {
                        if (StringUtils.isNull(queryParameter2)) {
                            queryParameter2 = "0";
                        }
                        if (jVar.getPageContext() != null) {
                            q.a(queryParameter2, queryParameter, queryParameter4, 0, jVar.getPageContext(), baijiahaoData);
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
    private final CustomMessageListener kls = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_INFO_CHANGED) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getData() instanceof PayMemberInfoData) {
                    MainTabActivity.this.a((PayMemberInfoData) customResponsedMessage.getData());
                    TbadkCoreApplication.getInst().setPaymemberInfo((PayMemberInfoData) customResponsedMessage.getData());
                }
                UserData aNn = com.baidu.tbadk.getUserInfo.b.aNl().aNn();
                if (TbadkCoreApplication.isLogin() && aNn != null && aNn.getUserId() != null && !aNn.getUserId().equals(MainTabActivity.this.klj) && aNn.getIsGodInvited()) {
                    MainTabActivity.this.klj = aNn.getUserId();
                    MainTabActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(MainTabActivity.this.getPageContext().getPageActivity(), "", TbWebViewActivityConfig.GOD_INVITE_JUMP_URL + "?page_type=open_full_screen_opacity_web_page", true)));
                }
            }
        }
    };
    private CustomMessageListener gns = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                MainTabActivity.this.klb.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    final CustomMessageListener klt = new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.tbadk.mainTab.b> list;
            MainTabActivity.this.mIsAdd = false;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (list = ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).getList()) != null && list.size() != 0) {
                MainTabActivity.this.klb.aF(list);
                if (MainTabActivity.this.kkX) {
                    MainTabActivity.this.klb.bDV().setCurrentTabByType(MainTabActivity.this.kkW);
                } else if (MainTabActivity.this.getActivity().getIntent() == null || MainTabActivity.this.getActivity().getIntent().getDataString() == null || !MainTabActivity.this.getActivity().getIntent().getDataString().startsWith("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                    MainTabActivity.this.ay(MainTabActivity.this.getIntent());
                } else {
                    MainTabActivity.this.klb.bDV().setCurrentTabByType(2);
                }
                MainTabActivity.this.kkX = false;
                MainTabActivity.this.klb.cLF();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP, null));
            }
        }
    };
    final CustomMessageListener klu = new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_REFRESH_TABS) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007013) {
                MainTabActivity.this.cfJ();
                if (MainTabActivity.this.klb != null && MainTabActivity.this.klb.bDV() != null) {
                    MainTabActivity.this.kkW = MainTabActivity.this.klb.bDV().getCurrentTabType();
                }
                MainTabActivity.this.kkX = true;
            }
        }
    };
    final CustomMessageListener klv = new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (MainTabActivity.this.kkY != null || (customResponsedMessage.getData() instanceof ay)) {
                    if (customResponsedMessage.getData() != null) {
                        MainTabActivity.this.kkY = (ay) customResponsedMessage.getData();
                    }
                    if (!MainTabActivity.this.mIsAdd && MainTabActivity.this.kkY != null && TbadkCoreApplication.isLogin()) {
                        MainTabActivity.this.klk.h(MainTabActivity.this.kkY.recom_title, MainTabActivity.this.kkY.recom_topic, MainTabActivity.this.kkY.cMq);
                    }
                }
            }
        }
    };
    private final CustomMessageListener klw = new CustomMessageListener(CmdConfigCustom.MAINTAB_SET_INST) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.e.b.aDi() == null) {
                b bVar = new b();
                bVar.a(MainTabActivity.this);
                com.baidu.tbadk.core.e.b.a(bVar);
            }
        }
    };
    private CustomMessageListener klx = new CustomMessageListener(2921380) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && !aq.isEmpty((String) customResponsedMessage.getData())) {
                String str = (String) customResponsedMessage.getData();
                if (KuangFloatingViewController.getInstance().init()) {
                    KuangFloatingViewController.getInstance().setInfo(str);
                    ((BaseFragmentActivity) MainTabActivity.this.getPageContext().getOrignalPage()).grantWindowPermission(new e() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.5.1
                        @Override // com.baidu.tbadk.core.e
                        public void onPermissionResult(boolean z) {
                            if (z) {
                                KuangFloatingViewController.getInstance().showFloatingView();
                                TiebaStatic.log(new an("c12264").Z("obj_type", 3));
                            }
                        }
                    });
                }
            }
        }
    };
    private g.a kly = new g.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.6
        @Override // com.baidu.tieba.write.g.a
        public void CI(int i) {
            if (i == 4) {
                MainTabActivity.this.klb.cLD();
            }
        }
    };
    private CheckRealNameModel.a klz = new CheckRealNameModel.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.10
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void b(int i, String str, String str2, Object obj) {
            if (CheckRealNameModel.TYPE_APP_FIRST_START.equals(str2) && i == 1990055) {
                TiebaStatic.log("c12138");
                MainTabActivity.this.klb.Jm(MainTabActivity.this.getResources().getString(R.string.check_real_name_message));
            }
        }
    };
    private CustomMessageListener cGh = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && l.isNetOk()) {
                MainTabActivity.this.cLq();
                if (!MainTabActivity.kld) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
                }
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                MainTabActivity.this.klg = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
                com.baidu.tbadk.core.sharedPref.b.aDr().remove(SharedPrefConfig.KEY_FEEDBACK_TIP);
                com.baidu.tbadk.core.sharedPref.b.aDr().remove(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW);
                com.baidu.tbadk.core.sharedPref.b.aDr().remove(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP));
                if (MainTabActivity.this.kll != null) {
                    MainTabActivity.this.kll.check();
                }
                if (MainTabActivity.this.klb != null) {
                    MainTabActivity.this.klb.cLK();
                }
                MainTabActivity.this.cLw();
            }
        }
    };
    private CustomMessageListener klA = new CustomMessageListener(CmdConfigCustom.CMD_GAME_CENTER_INIT) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                n.cUB = ((Boolean) customResponsedMessage.getData()).booleanValue();
                MainTabActivity.this.cLp();
            }
        }
    };
    private final CustomMessageListener klB = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.GAME_TIP_SHOW, booleanValue);
                MainTabActivity.this.klb.sV(booleanValue);
            }
        }
    };
    private CustomMessageListener cDL = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.26
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                boolean unused = MainTabActivity.kld = true;
                if (MainTabActivity.this.klb != null && MainTabActivity.this.klb.cLG() != null && MainTabActivity.this.klb.cLG().getAnimationView() != null && MainTabActivity.this.klb.cLG().getAnimationView().getVisibility() != 0) {
                    MainTabActivity.this.klb.cLG().setLottieView(false);
                }
                if (!TbadkCoreApplication.getInst().getActivityPrizeData().isSwitchTurn()) {
                    if (MainTabActivity.this.klb != null) {
                        MainTabActivity.this.klb.Jl(null);
                    }
                } else {
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getInst().getActivityPrizeData().isUserSatisfy()) {
                        String h5Url = TbadkCoreApplication.getInst().getActivityPrizeData().getH5Url();
                        if (!StringUtils.isNull(h5Url) && com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.ACTIVITY_PRIZE_GET_TIP + TbadkCoreApplication.getCurrentAccount(), true)) {
                            ba.aEt().a(MainTabActivity.this.getPageContext(), new String[]{h5Url}, true);
                            com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.ACTIVITY_PRIZE_GET_TIP + TbadkCoreApplication.getCurrentAccount(), false);
                        }
                    }
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                        if (MainTabActivity.this.klb != null) {
                            MainTabActivity.this.klb.Jl(null);
                        }
                    } else {
                        String myTabText = TbadkCoreApplication.getInst().getActivityPrizeData().getMyTabText();
                        if (!StringUtils.isNull(myTabText)) {
                            if (MainTabActivity.this.klb != null) {
                                MainTabActivity.this.klb.Jl(myTabText);
                            }
                        } else if (MainTabActivity.this.klb != null) {
                            MainTabActivity.this.klb.Jl(null);
                        }
                    }
                }
                if (TbSingleton.getInstance().canShowPermDialog()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921360, MainTabActivity.this));
                }
                com.baidu.tbadk.core.business.a.axK().cf("1", "");
            }
        }
    };
    private CustomMessageListener klD = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    MainTabActivity.this.klC = UtilHelper.getCurrentDay();
                    com.baidu.tbadk.core.sharedPref.b.aDr().putLong("last_resume_time", TbSingleton.getInstance().getLastResumeTime());
                    return;
                }
                String currentDay = UtilHelper.getCurrentDay();
                if (!StringUtils.isNull(currentDay) && !currentDay.equals(MainTabActivity.this.klC)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
                }
                if (MainTabActivity.this.jAS == null) {
                    MainTabActivity.this.jAS = new com.baidu.tieba.ueg.b();
                }
                MainTabActivity.this.jAS.Dg(MainTabActivity.this.jAS.ktc);
                MainTabActivity.this.jAS.ktc = at.a.cWx;
            }
        }
    };
    private final CustomMessageListener hQr = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.28
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.data.l lVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && (lVar = (com.baidu.tbadk.data.l) customResponsedMessage.getData()) != null && !StringUtils.isNull(lVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(lVar);
                if (StringUtils.isNull(lVar.drv)) {
                    ba.aEt().b(MainTabActivity.this.getPageContext(), new String[]{lVar.mLink});
                } else {
                    ba.aEt().b(MainTabActivity.this.getPageContext(), new String[]{lVar.mLink, lVar.drv});
                }
            }
        }
    };
    private CustomMessageListener gnG = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (MainTabActivity.this.gpH != null) {
                MainTabActivity.this.gpH.cSY();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void Jk(String str) {
        if (str != null && TbadkCoreApplication.getInst().getConfigVersion() != null && cLo()) {
            this.kle = System.currentTimeMillis();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    private boolean cLo() {
        if (-1 == this.kle) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.kle;
        return currentTimeMillis <= 0 || currentTimeMillis >= 300000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLp() {
        if (SwitchManager.getInstance().findType(GameEnterSwitch.GAME_ENTER_KEY) == 1 && n.cUB) {
            this.klb.sT(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_CHECK_UPDATE));
            return;
        }
        this.klb.sT(false);
        this.klb.sV(false);
        com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.GAME_TIP_SHOW, false);
    }

    public void a(PayMemberInfoData payMemberInfoData) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && payMemberInfoData != null) {
            if ((payMemberInfoData.aLo() == 1 || payMemberInfoData.aLo() == 2) && com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.SHOW_MEMBER_DEID_LINE, true)) {
                long axW = payMemberInfoData.axW() * 1000;
                if (axW < System.currentTimeMillis()) {
                    if (StringUtils.isNull(payMemberInfoData.aLp())) {
                        payMemberInfoData.uz(getPageContext().getString(R.string.member));
                    } else {
                        payMemberInfoData.uz(payMemberInfoData.aLp() + getPageContext().getString(R.string.member_already_Expire));
                    }
                    this.klb.a(payMemberInfoData, 0);
                } else if (axW - System.currentTimeMillis() < Config.THREAD_IMAGE_SAVE_MAX_TIME) {
                    if (StringUtils.isNull(payMemberInfoData.aLp())) {
                        payMemberInfoData.uz(getPageContext().getString(R.string.member));
                    } else {
                        payMemberInfoData.uz(payMemberInfoData.aLp() + getPageContext().getString(R.string.member_will_Expire));
                    }
                    this.klb.a(payMemberInfoData, 1);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.mTouchable) {
            return false;
        }
        if (this.klb.bDV() == null || this.klb.bDV().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1 || !this.klb.cfN()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public void bDT() {
        if (this.klk != null) {
            this.klk.bJC();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
        if (this.gpH == null) {
            this.gpH = new f(getPageContext(), this.kli, "main_tab", 2);
            this.gpH.Kz("1");
        }
        this.gpH.a(this.kly);
        if (!this.fSG.cNh() && this.klb.bDV() != null && this.klb.bDV().getFragmentTabWidget() != null) {
            this.klb.cLE();
            this.gpH.a(false, (View) this.klb.bDV().getTabWrapper(), this.klb.bDV().getFragmentTabWidget().getWriteView());
        }
    }

    protected void cfJ() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ADD_FRAGMENT, new com.baidu.tbadk.mainTab.d(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.baidu.tbadk.n.n.aOY().bU(System.currentTimeMillis());
        if (TbadkCoreApplication.getInst().getIsFirstUse()) {
            ac.a(new ab<Object>() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.7
                @Override // com.baidu.tbadk.util.ab
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
            ar(getIntent());
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
        if (cLr()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        setContentView(R.layout.maintabs_activity);
        this.kli = (FrameLayout) findViewById(R.id.maintabContainer);
        com.baidu.tbadk.core.a.a.axz().reLoginByCacheAccount();
        this.klb = new d(this);
        this.klk = new c(this);
        this.klb.sS(this.mIsLogin);
        cLp();
        bQe();
        com.baidu.tieba.tblauncher.alarmRemind.b.cLN().f(this);
        com.baidu.tbadk.BdToken.c.avj().avk();
        this.klh = new com.baidu.tieba.b();
        cfJ();
        cga();
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (bundle != null) {
            i2 = bundle.getInt("locate_type", 1);
            intent.putExtra("locate_type", i2);
        }
        this.klC = UtilHelper.getCurrentDay();
        this.kle = System.currentTimeMillis();
        MessageManager.getInstance().sendMessage(new CustomMessage(2921359));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        if (TbadkCoreApplication.getFrom() != null && TbadkCoreApplication.getFrom().equals("aishide")) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_ACTIVE, null));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_CLEARTEMP, null));
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_VIDEO_CACHE_CLEAN);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VIDEO_CACHE_CLEAN));
        f(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        com.baidu.tbadk.browser.a.initCookie(getPageContext().getPageActivity());
        String installOtherApp = TbadkCoreApplication.getInst().getInstallOtherApp();
        if (installOtherApp != null && installOtherApp.length() > 0) {
            UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), installOtherApp);
            TbadkCoreApplication.getInst().setInstallOtherApp(null);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.8
            @Override // java.lang.Runnable
            public void run() {
                MainTabActivity.this.mTouchable = true;
            }
        });
        registerListener(this.hDO);
        if (i2 == 1) {
            this.klb.sU(true);
        } else {
            this.klb.sU(false);
        }
        this.klb.cLI();
        this.gmi = getVoiceManager();
        if (this.gmi != null) {
            this.gmi.onCreate(getPageContext());
        }
        registerListener(this.mAccountChangedListener);
        adjustResizeForSoftInput();
        addGlobalLayoutListener();
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.MAINTAB_ONCREATE_END);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ONCREATE_END));
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.n.n.aOY().aOZ();
        }
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.getUserInfo.b.aNl().aNm();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VR_LOGO_DOWNLAOD));
        com.baidu.tbadk.core.sharedPref.b.aDr().putInt(SharedPrefConfig.APP_RESTART_TIMES, com.baidu.tbadk.core.sharedPref.b.aDr().getInt(SharedPrefConfig.APP_RESTART_TIMES, 0) + 1);
        this.iJu = new CheckRealNameModel(getPageContext());
        this.iJu.a(this.klz);
        cLq();
        this.gmW = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "homepage");
        this.gCs = new ShareSuccessReplyToServerModel();
        this.fSG = new com.baidu.tieba.ueg.d(getPageContext());
        int i3 = com.baidu.tbadk.core.sharedPref.b.aDr().getInt("need_deal_diversion_jump", 2);
        if (i3 == 2) {
            com.baidu.tbadk.core.sharedPref.b.aDr().putInt("need_deal_diversion_jump", 1);
        } else if (i3 == 1) {
            com.baidu.tbadk.core.sharedPref.b.aDr().putInt("need_deal_diversion_jump", 0);
        }
        this.kll = com.baidu.tbadk.BdToken.d.avt();
        int loadInt = TbadkSettings.getInst().loadInt(SharedPrefConfig.PREFS_SKIN_TYPE, 0);
        if (loadInt != 1) {
            am.s(false, true);
        } else {
            TbadkCoreApplication.getInst().setSkinTypeValue(loadInt);
            TbadkCoreApplication.getInst().SendSkinTypeBroadcast(loadInt);
        }
        if (TbSingleton.getInstance().isEnableBenchmark() && TbSingleton.getInstance().getCpuFlopsDuration() <= 0) {
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.tbadk.f.a.awL();
                }
            }, 5000L);
        }
        MessageManager.getInstance().registerListener(this.hQr);
        TbSingleton.getInstance().startOneGame();
        this.OC = new WeakReference<>(TbadkCoreApplication.getInst());
        if (getResources() != null && getResources().getConfiguration() != null) {
            this.kln = getResources().getConfiguration().uiMode & 48;
        }
        com.baidu.n.c.ge(TbadkCoreApplication.getInst()).a(null);
        cLw();
        com.baidu.tbadk.n.n.aOY().bV(System.currentTimeMillis());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public ViewGroup getActivityRootView() {
        return this.kli;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && this.kll != null) {
            this.kll.check();
            this.kll.avu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLq() {
        String str = SharedPrefConfig.CHECK_REAL_NAME + TbConfig.getVersion();
        if (com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(str, true) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && l.isNetOk()) {
            this.iJu.EC(CheckRealNameModel.TYPE_APP_FIRST_START);
            com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(str, false);
        }
    }

    private void ar(final Intent intent) {
        if (intent != null) {
            String dataString = intent.getDataString();
            if (!StringUtils.isNull(dataString) && dataString.startsWith("tbmaintab://")) {
                String decode = Uri.decode(intent.getData().getEncodedPath());
                if (StringUtils.isNull(decode)) {
                    TiebaStatic.log(new an("c10320").Z("obj_type", 1).Z(TiebaInitialize.Params.OBJ_TO, 1));
                    return;
                }
                if (decode.startsWith("//")) {
                    decode = decode.substring(2);
                }
                Map<String, String> paramPair = ba.getParamPair(decode);
                if (paramPair != null) {
                    String str = paramPair.get("fr");
                    if (!"mpush".equals(str) && "bpush".equals(str)) {
                        an anVar = new an("c10320");
                        anVar.cp("obj_locate", paramPair.get("obj_locate"));
                        anVar.Z("obj_type", 1);
                        anVar.cp("obj_source", paramPair.get("obj_source"));
                        anVar.cp(TiebaInitialize.Params.OBJ_PARAM2, paramPair.get(TiebaInitialize.Params.OBJ_PARAM2));
                        anVar.Z(TiebaInitialize.Params.OBJ_TO, 1);
                        anVar.cp("obj_id", paramPair.get("bdid"));
                        if (!aq.isEmpty(paramPair.get(LogConfig.LOG_EXT_LOG))) {
                            try {
                                JSONObject jSONObject = new JSONObject(paramPair.get(LogConfig.LOG_EXT_LOG));
                                Iterator<String> keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    anVar.cp(next, jSONObject.getString(next));
                                }
                            } catch (Exception e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        TiebaStatic.log(anVar);
                        HttpMessage httpMessage = new HttpMessage(1003393);
                        httpMessage.addParam("call_url", dataString);
                        MessageManager.getInstance().sendMessage(httpMessage);
                    }
                } else {
                    return;
                }
            } else if (!StringUtils.isNull(dataString) && (dataString.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT) || dataString.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT_ZM) || dataString.startsWith("bdtiebalive://"))) {
                String dataString2 = intent.getDataString();
                if (!StringUtils.isNull(dataString2)) {
                    ba.aEt().b(getPageContext(), new String[]{dataString2});
                }
            } else if (!StringUtils.isNULL(dataString) && dataString.startsWith(com.baidu.tbadk.BdToken.f.cEb)) {
                com.baidu.tbadk.BdToken.f.avz().a(intent.getData(), new f.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.13
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void n(HashMap<String, Object> hashMap) {
                        String str2;
                        if (hashMap != null && intent != null) {
                            Object obj = hashMap.get(com.baidu.tbadk.BdToken.f.cEn);
                            int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : -1;
                            Object obj2 = hashMap.get(com.baidu.tbadk.BdToken.f.cEo);
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
            String stringExtra = intent.getStringExtra(MainTabActivityConfig.TARGET_SCHEME);
            if (!StringUtils.isNull(stringExtra)) {
                ba.aEt().b(getPageContext(), new String[]{stringExtra});
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
        this.gmi = getVoiceManager();
        if (this.gmi != null) {
            this.gmi.onStart(getPageContext());
        }
    }

    public boolean cLr() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_SYNC, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_ACTIVE, null));
        bQf();
        com.baidu.tbadk.coreExtra.messageCenter.b.aIj().aIv();
        com.baidu.tbadk.coreExtra.messageCenter.b.aIj().aIp();
        com.baidu.tbadk.coreExtra.messageCenter.b.aIj().fQ(false);
        MessageManager.getInstance().unRegisterListener(this.hQr);
        MessageManager.getInstance().unRegisterListener(this.klx);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setDialogVisiable(false);
            this.mWaitingDialog = null;
        }
        cLs();
        if (this.klb != null) {
            this.klb.onDestroy();
        }
        if (this.klk != null) {
            this.klk.onDestroy();
        }
        try {
            super.onDestroy();
        } catch (Exception e) {
        }
        com.baidu.tbadk.core.e.b.a(null);
        this.gmi = getVoiceManager();
        if (this.gmi != null) {
            this.gmi.onDestory(getPageContext());
        }
        if (this.gpH != null) {
            this.gpH.onDestroy();
        }
        if (this.gmW != null) {
            this.gmW.onDestroy();
        }
        if (this.gCs != null) {
            this.gCs.cancelLoadData();
        }
        if (this.jAS != null) {
            this.jAS.onDestroy();
        }
        if (this.klb != null && this.klb.cLG() != null) {
            this.klb.cLG().onDestory();
        }
        System.gc();
    }

    private void cLs() {
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

    private void f(Context context, Intent intent) {
        UtilHelper.commenDealIntent(context, intent);
        TbadkCoreApplication.setIntent(null);
    }

    private void bQe() {
        registerListener(this.klp);
        this.klt.setPriority(100);
        registerListener(this.klt);
        registerListener(this.klu);
        registerListener(this.klv);
        registerListener(this.klw);
        registerListener(this.klA);
        registerListener(this.klB);
        registerListener(this.kls);
        registerListener(this.skinTypeChangeListener);
        registerListener(this.klq);
        this.klc = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.klc, intentFilter);
        registerListener(this.gns);
        registerListener(this.klr);
        registerListener(this.cDL);
        registerListener(this.cGh);
        registerListener(this.klD);
        this.klo.setTag(getUniqueId());
        registerListener(this.klo);
        registerListener(this.klx);
        registerListener(this.gnG);
    }

    private void bQf() {
        if (this.klc != null) {
            unregisterReceiver(this.klc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
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
        if (this.glo) {
            af.b(this.OC);
            this.glo = false;
        }
        if (this.klb != null && this.klb.cLG() != null) {
            this.klb.cLG().setLottieView(true);
        }
        if (this.klb != null && this.klb.bDV() != null) {
            this.kkW = this.klb.bDV().getCurrentTabType();
        }
        changeSkinType(this.mSkinType);
        if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.n.n.aOY().aOW()) {
            com.baidu.tbadk.n.n.aOY().aOZ();
        }
        this.gmi = getVoiceManager();
        if (this.gmi != null) {
            this.gmi.onResume(getPageContext());
        }
        this.klb.cLI();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_ON_RESUME, getActivity()));
        if (TbadkCoreApplication.getKeepLiveSwitch(getApplicationContext())) {
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.14
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_KEEPLIVE_START_SERVICE, Boolean.FALSE));
                }
            }, 3000L);
        }
        com.baidu.tbadk.n.n.aOY().aOZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.klg = true;
        if (z) {
            com.baidu.tbadk.getUserInfo.b.aNl().aNm();
            cLp();
            cLq();
        }
        this.klb.switchNaviBarStatus(z);
        this.klb.cLK();
        cfJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (this.kkV) {
            this.kkV = false;
            CompatibleUtile.setAnim(getPageContext().getPageActivity(), R.anim.down, R.anim.hold);
        }
        this.gmi = getVoiceManager();
        if (this.gmi != null) {
            this.gmi.onPause(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOME_HIDE_GUIDE));
        if (this.klk != null) {
            this.klk.bJD();
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
        bundle.putInt("locate_type", this.klb.bDV().getCurrentTabType());
        bundle.putParcelable("android:fragments", null);
        bundle.putParcelable("android:support:fragments", null);
        this.gmi = getVoiceManager();
        if (this.gmi != null) {
            this.gmi.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.gmi = getVoiceManager();
        if (this.gmi != null) {
            this.gmi.onStop(getPageContext());
        }
        this.glo = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        int i = 2;
        super.onNewIntent(intent);
        setIntent(intent);
        String stringExtra = intent.getStringExtra(MainTabActivityConfig.TARGET_SCHEME);
        ar(intent);
        if (StringUtils.isNull(stringExtra)) {
            com.baidu.tbadk.getUserInfo.b.aNl().aNm();
            if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_RESET_TABS));
                cfJ();
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
            } else if (intExtra == 1 || intExtra == 3 || intExtra == 2 || intExtra == 4 || intExtra == 8 || intExtra == 15) {
                if (intExtra == 8 || intExtra == 3 || intExtra == 15 || booleanExtra) {
                    i = intExtra;
                } else if (getActivity().getIntent() == null || getActivity().getIntent().getDataString() == null || !getActivity().getIntent().getDataString().startsWith("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                    i = this.klh.aSX();
                }
                if (this.klb != null && this.klb.bDV() != null) {
                    this.klb.bDV().setCurrentTabByType(i);
                }
            }
            f(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
            this.klb.cLI();
        }
    }

    protected void as(Activity activity) {
        new com.baidu.tbadk.core.dialog.a(activity).jE(R.string.confirm_title).fz(false).jF(R.string.background_process_permission).a(R.string.now_goto_setting, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.16
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                try {
                    MainTabActivity.this.startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
                    aVar.dismiss();
                } catch (Exception e) {
                    MainTabActivity.this.showToast(R.string.goto_developActivity_error_toast);
                }
            }
        }).b(R.string.next_time, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.15
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                MainTabActivity.this.cLt();
            }
        }).b(i.ab(activity)).aCp();
    }

    protected void cLt() {
        com.baidu.adp.lib.e.c.gr().d(getUniqueId());
        cLv();
        try {
            moveTaskToBack(true);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, com.baidu.adp.base.h
    public void onPreLoad(p pVar) {
        super.onPreLoad(pVar);
        ad.a(pVar, getUniqueId());
        com.baidu.tbadk.core.util.g.d.a(pVar, getUniqueId(), this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!MainTabActivityConfig.IS_BACK_CLOSE_ALL_ACTIVITY && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
            if (runTask == null || !((Boolean) runTask.getData()).booleanValue()) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2016323, (Class) null);
                if (runTask2 == null || !((Boolean) runTask2.getData()).booleanValue()) {
                    if (this.gpH != null && this.gpH.isShowing()) {
                        this.gpH.tE(true);
                        return true;
                    } else if (this.klb.cfN()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
                        return true;
                    } else {
                        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(2921422, Boolean.class, false);
                        if (runTask3 == null || runTask3.getData() == null || !(runTask3.getData() instanceof Boolean) || !((Boolean) runTask3.getData()).booleanValue()) {
                            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(2921405, Boolean.class, false);
                            if (runTask4 == null || runTask4.getData() == null || !(runTask4.getData() instanceof Boolean) || !((Boolean) runTask4.getData()).booleanValue()) {
                                if (System.currentTimeMillis() - this.kkZ > 2000) {
                                    showToast(R.string.double_back_quit);
                                    this.kkZ = System.currentTimeMillis();
                                } else if (UtilHelper.isBackgroundProcessLimitNone() && Build.VERSION.SDK_INT >= 14) {
                                    as(getPageContext().getPageActivity());
                                    return true;
                                } else {
                                    cLt();
                                }
                                return false;
                            }
                            return true;
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
    public void ay(Intent intent) {
        int aSX;
        try {
            if (intent.getBooleanExtra("is_from_scheme", false)) {
                aSX = intent.getIntExtra("locate_type", 1);
            } else {
                aSX = this.klh.aSX();
            }
            this.klb.bDV().setCurrentTabByType(aSX);
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

    private void cga() {
        registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Integer) {
                    Integer num = (Integer) customResponsedMessage.getData();
                    if (num.intValue() == 2) {
                        MainTabActivity.this.klb.sU(true);
                        MainTabActivity.this.klb.oR(true);
                    } else if (num.intValue() == 1) {
                        MainTabActivity.this.klb.sU(true);
                        MainTabActivity.this.klb.oR(false);
                    } else {
                        MainTabActivity.this.klb.sU(false);
                        MainTabActivity.this.klb.oR(false);
                    }
                    MainTabActivity.this.klb.cLI();
                }
            }
        });
    }

    protected void cLu() {
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
            if (this.klb.bDV().getCurrentFragment() != null) {
                this.klb.bDV().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 11001) {
            cLu();
        } else if (i == 13003) {
            az(intent);
        } else if (i == 23007) {
            aj(intent);
        } else if (i == 13011) {
            com.baidu.tieba.n.a.cAA().A(getPageContext());
        } else if (i == 24007) {
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1) {
                com.baidu.tieba.n.a.cAA().A(getPageContext());
                ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                if (shareItem != null && shareItem.linkUrl != null && this.gCs != null) {
                    this.gCs.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.18
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void aJp() {
                        }

                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void a(final CustomDialogData customDialogData) {
                            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.18.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a(MainTabActivity.this.getPageContext(), customDialogData).show();
                                }
                            }, 1000L);
                        }
                    });
                }
            }
        } else if (this.klb.bDV().getCurrentFragment() != null) {
            this.klb.bDV().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    private ShareFromPBMsgData bHy() {
        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.imageUri == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.imageUri.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.dlS);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.fName);
        shareFromPBMsgData.setThreadId(shareItem.tid);
        return shareFromPBMsgData;
    }

    private void aj(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(bHy(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.jI(1);
            aVar.aO(thread2GroupShareView);
            aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.19
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MainTabActivity.this.HidenSoftKeyPad((InputMethodManager) MainTabActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(MainTabActivity.this.getPageContext().getPageActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.aJV() != null) {
                        Bundle aJV = shareItem.aJV();
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).Z("obj_source", 1).Z("obj_type", aJV.getInt("obj_type")).Z("obj_param1", 3).cp("fid", aJV.getString("fid")).cp("tid", aJV.getString("tid")));
                    }
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.20
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MainTabActivity.this.HidenSoftKeyPad((InputMethodManager) MainTabActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.fA(true);
            aVar.b(getPageContext()).aCp();
            if (!k.isEmpty(shareFromPBMsgData.getImageUrl())) {
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
        this.klb.onChangeSkinType(i);
        adjustResizeForSoftInputOnSkinTypeChanged(i);
        if (this.gpH != null) {
            this.gpH.onChangeSkinType(i);
        }
    }

    private void az(Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        if (intent != null) {
            try {
                postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
            } catch (Exception e) {
                BdLog.e(e);
                postWriteCallBackData = null;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PERSONALIZED_MAINTAB_ON_RESULT, postWriteCallBackData));
            if (this.klb != null && !this.klb.d(postWriteCallBackData)) {
                this.klb.b(postWriteCallBackData);
            }
        }
    }

    private void cLv() {
        if (System.currentTimeMillis() - this.kla >= 7200000) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "start");
            hashMap.put(BdStatsConstant.StatsKey.UNAME, TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_CLEARTEMP, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
            this.kla = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.a
    public int getCurrentTabType() {
        if (this.klb.bDV() != null) {
            return this.klb.bDV().getCurrentTabType();
        }
        return -1;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.gmi == null) {
            this.gmi = VoiceManager.instance();
        }
        return this.gmi;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public ListView aFQ() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aFR() {
        if (this.deV == null) {
            this.deV = UserIconBox.x(getPageContext().getPageActivity(), 8);
        }
        return this.deV;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> bBE() {
        if (this.klf == null) {
            this.klf = FrsCommonImageLayout.G(getPageContext().getPageActivity(), 12);
        }
        return this.klf;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return new com.baidu.tbadk.m.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.21
            @Override // com.baidu.tbadk.m.b
            public boolean isCurrentPageCanBeAddToSourceTrace() {
                return true;
            }

            @Override // com.baidu.tbadk.m.b
            public int getMaxCost() {
                return com.baidu.tbadk.m.e.aOF().getMaxCostFromServer();
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
        if (this.klg && currentPageSourceKeyList != null) {
            currentPageSourceKeyList.clear();
            this.klg = false;
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
        if (this.klb != null && this.klb.bDV() != null) {
            Fragment currentFragment = this.klb.bDV().getCurrentFragment();
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
        this.fiB = z;
        boolean z2 = this.klm || this.fiB;
        if (this.klb != null) {
            this.klb.onKeyboardVisibilityChanged(z2);
        }
    }

    @Override // com.baidu.tbadk.core.util.g.c
    public boolean videoNeedPreload() {
        return af.mC(1);
    }

    @Override // com.baidu.tbadk.core.util.g.c
    public boolean isCyberVideoUsedThisPage() {
        return com.baidu.tbadk.a.b.rs("cyber_player_test");
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            super.onConfigurationChanged(configuration);
            if (TbadkCoreApplication.getInst().getSkinType() != 1) {
                am.s(true, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLw() {
        String str = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_is_clear_concern_cache_when_version_update") + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + TbConfig.getVersion();
        if (!com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(str, false)) {
            try {
                com.baidu.tbadk.core.c.a.aCo().ch("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).setForever("0", null);
                com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(str, true);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
