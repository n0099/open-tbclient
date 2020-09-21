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
import android.text.TextUtils;
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
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.t;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.live.tbadk.data.Config;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BdToken.f;
import com.baidu.tbadk.BdToken.q;
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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.message.ExitAppMessage;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.be;
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
import com.baidu.tbadk.data.j;
import com.baidu.tbadk.n.n;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.switchs.GameEnterSwitch;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.ai;
import com.baidu.tbadk.util.r;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.Thread2GroupShareView;
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
/* loaded from: classes21.dex */
public class MainTabActivity extends BaseFragmentActivity implements com.baidu.tbadk.core.util.f.b, UserIconBox.b, VoiceManager.c, FrsCommonImageLayout.c, com.baidu.tieba.tblauncher.a {
    private static boolean syncHasFinish;
    private WeakReference<Context> alw;
    private com.baidu.adp.lib.d.b<TbImageView> exy;
    private com.baidu.tieba.ueg.d fLE;
    VoiceManager hZU;
    private com.baidu.tieba.NEGFeedBack.a iaK;
    private g ies;
    private ShareSuccessReplyToServerModel itk;
    private CheckRealNameModel kQm;
    private FrameLayout lBB;
    private com.baidu.tieba.ueg.b lHj;
    private boolean mTouchable;
    private com.baidu.tbadk.BdToken.d muA;
    private com.baidu.tieba.c.e muC;
    private int muD;
    private e muG;
    private com.baidu.tieba.c.e muT;
    private String muY;
    private bg mup;
    private d mus;
    private a mut;
    private com.baidu.adp.lib.d.b<TbImageView> muv;
    private com.baidu.tieba.b mux;
    private c muz;
    private boolean mum = false;
    private int mun = -1;
    private boolean muo = false;
    private String mFrom = null;
    private volatile boolean mIsAdd = false;
    private long muq = 0;
    private long mur = 0;
    private long muu = -1;
    private boolean muw = false;
    private String muy = "";
    boolean muB = false;
    boolean gNB = false;
    boolean hYU = true;
    private Integer muE = -1;
    private int muF = 16;
    private CustomMessageListener muH = new CustomMessageListener(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && MainTabActivity.this.mus != null && TbadkCoreApplication.getInst().getCurrentActivity() == MainTabActivity.this) {
                MainTabActivity.this.muB = com.baidu.adp.lib.f.b.toBoolean(customResponsedMessage.getData().toString(), false);
                MainTabActivity.this.mus.onKeyboardVisibilityChanged((MainTabActivity.this.muB || MainTabActivity.this.gNB) ? true : true);
            }
        }
    };
    private final CustomMessageListener muI = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_MATINTAB) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.12
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
                        MainTabActivity.this.mus.crf().changeStyle(1);
                    } else if (TbadkCoreApplication.getInst().isThemeIconCover()) {
                        MainTabActivity.this.mus.crf().changeStyle(2);
                    } else {
                        MainTabActivity.this.mus.crf().changeStyle(1);
                    }
                }
            }
        }
    };
    public CustomMessageListener muJ = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && MainTabActivity.this.mus != null && MainTabActivity.this.mus.crf() != null) {
                if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    MainTabActivity.this.mus.crf().getTabWrapper().animate().translationY(MainTabActivity.this.mus.crf().getTabWrapper().getHeight()).setDuration(200L).start();
                } else {
                    MainTabActivity.this.mus.crf().getTabWrapper().animate().translationY(0.0f).setDuration(400L).start();
                }
            }
        }
    };
    public CustomMessageListener muK = new CustomMessageListener(2921452) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof j) && com.baidu.tbadk.core.util.bg.checkUpIsLogin(MainTabActivity.this.getPageContext().getPageActivity())) {
                MainTabActivity.this.crd();
            }
        }
    };
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData()).isSuccess && MainTabActivity.this.muD == 0) {
                MainTabActivity.this.dCu();
            }
        }
    };
    private CustomMessageListener mEnterForumTabClickListener = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = MainTabActivity.this.muE.intValue();
                MainTabActivity.this.muE = (Integer) customResponsedMessage.getData();
                if (MainTabActivity.this.muE.intValue() == 1) {
                    MainTabActivity.this.dCw();
                } else if (intValue == 1) {
                    MainTabActivity.this.dCv();
                }
                if (MainTabActivity.this.muE.intValue() == 2) {
                    MainTabActivity.this.dCB();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c jDN = new com.baidu.adp.framework.listener.c(1001) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ConfigVersion configVersion;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                if (socketResponsedMessage.getError() == 0 && (configVersion = responseOnlineMessage.getConfigVersion()) != null) {
                    MainTabActivity.this.RG(configVersion.sync);
                }
            }
        }
    };
    private CustomMessageListener muL = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_JUMP_PB) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.42
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
                            r.a(queryParameter2, queryParameter, queryParameter4, i, hVar.getPageContext(), baijiahaoData);
                        } else {
                            r.a(queryParameter2, queryParameter, queryParameter4, i, MainTabActivity.this.getPageContext(), baijiahaoData);
                        }
                    } else if (baijiahaoData != null) {
                        if (StringUtils.isNull(queryParameter2)) {
                            queryParameter2 = "0";
                        }
                        if (hVar.getPageContext() != null) {
                            r.a(queryParameter2, queryParameter, queryParameter4, 0, hVar.getPageContext(), baijiahaoData);
                        } else {
                            r.a(queryParameter2, queryParameter, queryParameter4, 0, MainTabActivity.this.getPageContext(), baijiahaoData);
                        }
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
        }
    };
    private final CustomMessageListener muM = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_INFO_CHANGED) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getData() instanceof PayMemberInfoData) {
                    MainTabActivity.this.a((PayMemberInfoData) customResponsedMessage.getData());
                    TbadkCoreApplication.getInst().setPaymemberInfo((PayMemberInfoData) customResponsedMessage.getData());
                }
                UserData btW = com.baidu.tbadk.getUserInfo.b.btU().btW();
                if (TbadkCoreApplication.isLogin() && btW != null && btW.getUserId() != null && !btW.getUserId().equals(MainTabActivity.this.muy) && btW.getIsGodInvited()) {
                    MainTabActivity.this.muy = btW.getUserId();
                    MainTabActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(MainTabActivity.this.getPageContext().getPageActivity(), "", TbWebViewActivityConfig.GOD_INVITE_JUMP_URL + "?page_type=open_full_screen_opacity_web_page", true)));
                }
                if (!com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean("key_new_god_invited_my_tab_red_tip_showed", false) && TbadkCoreApplication.isLogin() && btW != null && btW.getUserId() != null && !btW.getUserId().equals(MainTabActivity.this.muy) && btW.getNewGodData() != null && btW.getNewGodData().isNewGodInvited()) {
                    com.baidu.tieba.p.a.dsD().h(11, true, true);
                    TiebaStatic.log(new aq("c13688").u("uid", TbadkCoreApplication.getCurrentAccountId()).ai("obj_locate", 0));
                    com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean("key_new_god_invited_my_tab_red_tip_showed", true);
                }
            }
        }
    };
    private CustomMessageListener ibt = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && !((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                MainTabActivity.this.mus.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    final CustomMessageListener muN = new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.tbadk.mainTab.b> list;
            MainTabActivity.this.mIsAdd = false;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (list = ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).getList()) != null && list.size() != 0) {
                MainTabActivity.this.mus.aR(list);
                if (MainTabActivity.this.muo) {
                    MainTabActivity.this.mus.crf().setCurrentTabByType(MainTabActivity.this.mun);
                } else if (MainTabActivity.this.getActivity().getIntent() == null || MainTabActivity.this.getActivity().getIntent().getDataString() == null || !MainTabActivity.this.getActivity().getIntent().getDataString().startsWith("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                    MainTabActivity.this.ak(MainTabActivity.this.getIntent());
                } else {
                    MainTabActivity.this.mus.crf().setCurrentTabByType(2);
                }
                MainTabActivity.this.muo = false;
                MainTabActivity.this.mus.dCR();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP, null));
            }
        }
    };
    final CustomMessageListener muO = new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_REFRESH_TABS) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007013) {
                MainTabActivity.this.cVl();
                if (MainTabActivity.this.mus != null && MainTabActivity.this.mus.crf() != null) {
                    MainTabActivity.this.mun = MainTabActivity.this.mus.crf().getCurrentTabType();
                }
                MainTabActivity.this.muo = true;
            }
        }
    };
    final CustomMessageListener muP = new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (MainTabActivity.this.mup != null || (customResponsedMessage.getData() instanceof bg)) {
                    if (customResponsedMessage.getData() != null) {
                        MainTabActivity.this.mup = (bg) customResponsedMessage.getData();
                    }
                    if (!MainTabActivity.this.mIsAdd && MainTabActivity.this.mup != null && TbadkCoreApplication.isLogin()) {
                        MainTabActivity.this.muz.j(MainTabActivity.this.mup.recom_title, MainTabActivity.this.mup.recom_topic, MainTabActivity.this.mup.ece);
                    }
                }
            }
        }
    };
    private final CustomMessageListener muQ = new CustomMessageListener(CmdConfigCustom.MAINTAB_SET_INST) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.e.b.biV() == null) {
                b bVar = new b();
                bVar.a(MainTabActivity.this);
                com.baidu.tbadk.core.e.b.a(bVar);
            }
        }
    };
    private CustomMessageListener muR = new CustomMessageListener(2921380) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && !at.isEmpty((String) customResponsedMessage.getData())) {
                String str = (String) customResponsedMessage.getData();
                if (KuangFloatingViewController.getInstance().init()) {
                    KuangFloatingViewController.getInstance().setInfo(str);
                    ((BaseFragmentActivity) MainTabActivity.this.getPageContext().getOrignalPage()).grantWindowPermission(new com.baidu.tbadk.core.e() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.8.1
                        @Override // com.baidu.tbadk.core.e
                        public void onPermissionResult(boolean z) {
                            if (z) {
                                KuangFloatingViewController.getInstance().showFloatingView();
                                TiebaStatic.log(new aq("c12264").ai("obj_type", 3));
                            }
                        }
                    }, false);
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a lXx = new com.baidu.adp.framework.listener.a(1002700, CmdConfigSocket.CMD_PROFILE) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.13
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if ((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) {
                if (responsedMessage.getOrginalMessage() == null || MainTabActivity.this.getUniqueId() != null) {
                }
                if (responsedMessage instanceof ProfileSocketResponseMessage) {
                    MainTabActivity.this.a((ProfileSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof ProfileHttpResponseMessage) {
                    MainTabActivity.this.a((ProfileHttpResponseMessage) responsedMessage);
                }
            }
        }
    };
    private CustomMessageListener muS = new CustomMessageListener(2921504) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            MainTabActivity.this.dCz();
        }
    };
    private CustomMessageListener muU = new CustomMessageListener(2921491) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && MainTabActivity.this.mus != null && MainTabActivity.this.mus.crf() != null && MainTabActivity.this.mus.crf().getCurrentTabType() != 21) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    FragmentTabWidget fragmentTabWidget = MainTabActivity.this.mus.crf().getFragmentTabWidget();
                    if (fragmentTabWidget.getChildCount() >= 2) {
                        MainTabActivity.this.muT = new com.baidu.tieba.c.e(MainTabActivity.this.getPageContext(), fragmentTabWidget.getChildAt(2));
                        MainTabActivity.this.muT.eW(R.drawable.bg_tip_blue_down);
                        MainTabActivity.this.muT.setAnchor(2);
                        MainTabActivity.this.muT.eV(32);
                        MainTabActivity.this.muT.setUseDirectOffset(true);
                        MainTabActivity.this.muT.setYOffset(-l.getDimens(MainTabActivity.this, R.dimen.tbds10));
                        MainTabActivity.this.muT.setTextColor(R.color.cp_cont_a);
                        MainTabActivity.this.muT.setHeight(R.dimen.tbds54);
                        MainTabActivity.this.muT.setMaxShowTime(999);
                        MainTabActivity.this.muT.eX(5000);
                        MainTabActivity.this.muT.wc(l.getDimens(MainTabActivity.this, R.dimen.tbds44));
                        MainTabActivity.this.muT.b(str, "categoryUpdate", false, true);
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a muV = new CheckRealNameModel.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.16
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void b(int i, String str, String str2, Object obj) {
            if (CheckRealNameModel.TYPE_APP_FIRST_START.equals(str2) && i == 1990055) {
                TiebaStatic.log("c12138");
                MainTabActivity.this.mus.RI(MainTabActivity.this.getResources().getString(R.string.check_real_name_message));
            }
        }
    };
    private CustomMessageListener dUg = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && l.isNetOk()) {
                MainTabActivity.this.dCC();
                if (!MainTabActivity.syncHasFinish) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
                }
            }
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                MainTabActivity.this.muw = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
                com.baidu.tbadk.core.sharedPref.b.bjf().remove(SharedPrefConfig.KEY_FEEDBACK_TIP);
                com.baidu.tbadk.core.sharedPref.b.bjf().remove(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW);
                com.baidu.tbadk.core.sharedPref.b.bjf().remove(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP));
                if (MainTabActivity.this.muA != null) {
                    MainTabActivity.this.muA.yh(UtilHelper.getClipBoardContent());
                }
                if (MainTabActivity.this.mus != null) {
                    MainTabActivity.this.mus.dCW();
                }
                MainTabActivity.this.dCI();
            }
        }
    };
    private CustomMessageListener muW = new CustomMessageListener(CmdConfigCustom.CMD_GAME_CENTER_INIT) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                p.elx = ((Boolean) customResponsedMessage.getData()).booleanValue();
                MainTabActivity.this.dCy();
            }
        }
    };
    private final CustomMessageListener muX = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SharedPrefConfig.GAME_TIP_SHOW, booleanValue);
                MainTabActivity.this.mus.wy(booleanValue);
            }
        }
    };
    private CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                boolean unused = MainTabActivity.syncHasFinish = true;
                TbadkCoreApplication.getInst().syncHasFinish = true;
                if (MainTabActivity.this.mus != null && MainTabActivity.this.mus.dCS() != null && MainTabActivity.this.mus.dCS().getAnimationView() != null && MainTabActivity.this.mus.dCS().getAnimationView().getVisibility() != 0) {
                    MainTabActivity.this.mus.dCS().setLottieView(false);
                }
                if (!TbadkCoreApplication.getInst().getActivityPrizeData().isSwitchTurn()) {
                    if (MainTabActivity.this.mus != null) {
                        MainTabActivity.this.mus.RH(null);
                    }
                } else {
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getInst().getActivityPrizeData().isUserSatisfy()) {
                        String h5Url = TbadkCoreApplication.getInst().getActivityPrizeData().getH5Url();
                        if (!StringUtils.isNull(h5Url) && com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(SharedPrefConfig.ACTIVITY_PRIZE_GET_TIP + TbadkCoreApplication.getCurrentAccount(), true)) {
                            be.bkp().a(MainTabActivity.this.getPageContext(), new String[]{h5Url}, true);
                            com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SharedPrefConfig.ACTIVITY_PRIZE_GET_TIP + TbadkCoreApplication.getCurrentAccount(), false);
                        }
                    }
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                        if (MainTabActivity.this.mus != null) {
                            MainTabActivity.this.mus.RH(null);
                        }
                    } else {
                        String myTabText = TbadkCoreApplication.getInst().getActivityPrizeData().getMyTabText();
                        if (!StringUtils.isNull(myTabText)) {
                            if (MainTabActivity.this.mus != null) {
                                MainTabActivity.this.mus.RH(myTabText);
                            }
                        } else if (MainTabActivity.this.mus != null) {
                            MainTabActivity.this.mus.RH(null);
                        }
                    }
                }
                if (TbSingleton.getInstance().canShowPermDialog()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921360, MainTabActivity.this));
                }
                com.baidu.tbadk.core.business.a.bcS().dt("1", "");
            }
        }
    };
    private CustomMessageListener muZ = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    MainTabActivity.this.muY = UtilHelper.getCurrentDay();
                    com.baidu.tbadk.core.sharedPref.b.bjf().putLong("last_resume_time", TbSingleton.getInstance().getLastResumeTime());
                    return;
                }
                String currentDay = UtilHelper.getCurrentDay();
                if (!StringUtils.isNull(currentDay) && !currentDay.equals(MainTabActivity.this.muY)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
                }
                if (MainTabActivity.this.lHj == null) {
                    MainTabActivity.this.lHj = new com.baidu.tieba.ueg.b();
                }
                MainTabActivity.this.lHj.Jj(MainTabActivity.this.lHj.mCN);
                MainTabActivity.this.lHj.mCN = ax.a.enF;
            }
        }
    };
    private final CustomMessageListener jRo = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.data.l lVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && (lVar = (com.baidu.tbadk.data.l) customResponsedMessage.getData()) != null && !StringUtils.isNull(lVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(lVar);
                if (StringUtils.isNull(lVar.eLR)) {
                    be.bkp().b(MainTabActivity.this.getPageContext(), new String[]{lVar.mLink});
                } else {
                    be.bkp().b(MainTabActivity.this.getPageContext(), new String[]{lVar.mLink, lVar.eLR});
                }
            }
        }
    };
    private CustomMessageListener ibK = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (MainTabActivity.this.ies != null) {
                MainTabActivity.this.ies.bxW();
            }
        }
    };
    private Runnable mva = new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.37
        @Override // java.lang.Runnable
        public void run() {
            if (TbSingleton.getInstance().getNewUserRedPackageData() != null) {
                MainTabActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewUserRedPackageActivityConfig(MainTabActivity.this, TbSingleton.getInstance().getNewUserRedPackageData())));
                TbSingleton.getInstance().setNewUserRedPackageData(null);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void dCu() {
        FragmentTabWidget fragmentTabWidget = this.mus.crf().getFragmentTabWidget();
        if (fragmentTabWidget.getChildCount() >= 2) {
            this.muC = new com.baidu.tieba.c.e(getPageContext(), fragmentTabWidget.getChildAt(1));
            this.muC.eW(R.drawable.bg_tip_blue_down);
            this.muC.setAnchor(2);
            this.muC.eV(32);
            this.muC.setUseDirectOffset(true);
            this.muC.setYOffset(-l.getDimens(this, R.dimen.tbds10));
            this.muC.setTextColor(R.color.cp_cont_a);
            this.muC.setHeight(R.dimen.tbds54);
            this.muC.setMaxShowTime(1);
            this.muC.eX(4000);
            this.muC.wc(l.getDimens(this, R.dimen.tbds44));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCv() {
        if (this.muC != null && !this.muC.isShowing()) {
            this.muC.aG(getString(R.string.enterforumtab_like_forum_tips), "first_like_forum_enterforumtab_tips" + TbadkCoreApplication.getCurrentAccount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCw() {
        if (this.muC != null && this.muC.isShowing()) {
            this.muC.Oj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RG(String str) {
        if (str != null && TbadkCoreApplication.getInst().getConfigVersion() != null && dCx()) {
            this.muu = System.currentTimeMillis();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    private boolean dCx() {
        if (-1 == this.muu) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.muu;
        return currentTimeMillis <= 0 || currentTimeMillis >= 300000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCy() {
        if (SwitchManager.getInstance().findType(GameEnterSwitch.GAME_ENTER_KEY) == 1 && p.elx) {
            this.mus.ww(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_CHECK_UPDATE));
            return;
        }
        this.mus.ww(false);
        this.mus.wy(false);
        com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SharedPrefConfig.GAME_TIP_SHOW, false);
    }

    public void a(PayMemberInfoData payMemberInfoData) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && payMemberInfoData != null) {
            if ((payMemberInfoData.brN() == 1 || payMemberInfoData.brN() == 2) && com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(SharedPrefConfig.SHOW_MEMBER_DEID_LINE, true)) {
                long bdm = payMemberInfoData.bdm() * 1000;
                if (bdm < System.currentTimeMillis()) {
                    if (StringUtils.isNull(payMemberInfoData.brO())) {
                        payMemberInfoData.Ca(getPageContext().getString(R.string.member));
                    } else {
                        payMemberInfoData.Ca(payMemberInfoData.brO() + getPageContext().getString(R.string.member_already_Expire));
                    }
                    this.mus.a(payMemberInfoData, 0);
                } else if (bdm - System.currentTimeMillis() < Config.THREAD_IMAGE_SAVE_MAX_TIME) {
                    if (StringUtils.isNull(payMemberInfoData.brO())) {
                        payMemberInfoData.Ca(getPageContext().getString(R.string.member));
                    } else {
                        payMemberInfoData.Ca(payMemberInfoData.brO() + getPageContext().getString(R.string.member_will_Expire));
                    }
                    this.mus.a(payMemberInfoData, 1);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.mTouchable) {
            return false;
        }
        if (this.mus.crf() == null || this.mus.crf().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1 || !this.mus.cVp()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public void crd() {
        if (this.muz != null) {
            this.muz.cxw();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
        if (this.ies == null) {
            this.ies = new g(getPageContext(), this.lBB, "main_tab", 3);
            this.ies.SY("8");
        }
        if (!this.fLE.dEt() && this.mus.crf() != null && this.mus.crf().getFragmentTabWidget() != null) {
            this.ies.a(false, (View) this.mus.crf().getTabWrapper(), this.mus.crf().getFragmentTabWidget().getWriteView());
        }
    }

    protected void cVl() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ADD_FRAGMENT, new com.baidu.tbadk.mainTab.d(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        n.bvx().dp(System.currentTimeMillis());
        if (TbadkCoreApplication.getInst().getIsFirstUse()) {
            ae.a(new ad<Object>() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.9
                @Override // com.baidu.tbadk.util.ad
                public Object doInBackground() {
                    TbadkCoreApplication.getInst().setUsed();
                    return null;
                }
            }, null);
        }
        com.baidu.tbadk.core.util.ae.bjS();
        setIsAddSwipeBackLayout(false);
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.getDecorView();
        super.onCreate(bundle);
        int i = -1;
        if (getIntent() != null) {
            this.muG = new e(getPageContext());
            if (!this.muG.am(getIntent())) {
                ad(getIntent());
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
        if (dCD()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        setContentView(R.layout.maintabs_activity);
        this.lBB = (FrameLayout) findViewById(R.id.maintabContainer);
        com.baidu.tbadk.core.a.a.bcH().reLoginByCacheAccount();
        this.mus = new d(this);
        this.muz = new c(this);
        this.mus.wv(this.mIsLogin);
        dCy();
        cEV();
        com.baidu.tieba.tblauncher.alarmRemind.b.dCZ().f(this);
        com.baidu.tbadk.BdToken.c.aZe().aZg();
        this.mux = new com.baidu.tieba.b();
        cVl();
        cVB();
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (bundle != null) {
            i2 = bundle.getInt("locate_type", 1);
            intent.putExtra("locate_type", i2);
        }
        this.muY = UtilHelper.getCurrentDay();
        this.muu = System.currentTimeMillis();
        MessageManager.getInstance().sendMessage(new CustomMessage(2921359));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        if (TbadkCoreApplication.getFrom() != null && TbadkCoreApplication.getFrom().equals("aishide")) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_ACTIVE, null));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_CLEARTEMP, null));
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_VIDEO_CACHE_CLEAN);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VIDEO_CACHE_CLEAN));
        h(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        com.baidu.tbadk.browser.a.initCookie(getPageContext().getPageActivity());
        String installOtherApp = TbadkCoreApplication.getInst().getInstallOtherApp();
        if (installOtherApp != null && installOtherApp.length() > 0) {
            UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), installOtherApp);
            TbadkCoreApplication.getInst().setInstallOtherApp(null);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.10
            @Override // java.lang.Runnable
            public void run() {
                MainTabActivity.this.mTouchable = true;
            }
        });
        TbadkCoreApplication.getInst().startTrackConfigRequest();
        if (com.baidu.tbadk.core.util.ae.checkLocationForGoogle(getActivity())) {
            MercatorModel.dBy().startLoad();
        }
        registerListener(this.jDN);
        if (i2 == 1) {
            this.mus.wx(true);
        } else {
            this.mus.wx(false);
        }
        this.mus.dCU();
        this.hZU = getVoiceManager();
        if (this.hZU != null) {
            this.hZU.onCreate(getPageContext());
        }
        registerListener(this.mAccountChangedListener);
        adjustResizeForSoftInput();
        addGlobalLayoutListener();
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.MAINTAB_ONCREATE_END);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ONCREATE_END));
        if (TbadkCoreApplication.isLogin()) {
            n.bvx().bvy();
        }
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.getUserInfo.b.btU().btV();
        }
        com.baidu.tbadk.core.sharedPref.b.bjf().putInt(SharedPrefConfig.APP_RESTART_TIMES, com.baidu.tbadk.core.sharedPref.b.bjf().getInt(SharedPrefConfig.APP_RESTART_TIMES, 0) + 1);
        this.kQm = new CheckRealNameModel(getPageContext());
        this.kQm.a(this.muV);
        dCC();
        this.iaK = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "homepage");
        this.itk = new ShareSuccessReplyToServerModel();
        this.fLE = new com.baidu.tieba.ueg.d(getPageContext());
        this.muA = com.baidu.tbadk.BdToken.d.aZu();
        int loadInt = TbadkSettings.getInst().loadInt(SharedPrefConfig.PREFS_SKIN_TYPE, 0);
        if (loadInt != 1) {
            ap.C(false, true);
        } else {
            TbadkCoreApplication.getInst().setSkinTypeValue(loadInt);
            TbadkCoreApplication.getInst().SendSkinTypeBroadcast(loadInt);
        }
        if (TbSingleton.getInstance().isEnableBenchmark() && TbSingleton.getInstance().getCpuFlopsDuration() <= 0) {
            com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.11
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.tbadk.f.a.bbJ();
                }
            }, 5000L);
        }
        MessageManager.getInstance().registerListener(this.jRo);
        TbSingleton.getInstance().startOneGame();
        this.alw = new WeakReference<>(TbadkCoreApplication.getInst());
        if (getResources() != null && getResources().getConfiguration() != null) {
            this.muF = getResources().getConfiguration().uiMode & 48;
        }
        com.baidu.q.c.gh(TbadkCoreApplication.getInst()).a(null);
        dCI();
        if (this.muG.am(intent)) {
            this.muG.a(getIntent(), this.mus);
        }
        com.baidu.adp.lib.f.e.mX().postDelayed(this.mva, 200L);
        dCz();
        TbSingleton.getInstance().getChannelConfigModel().startLoad();
        n.bvx().dq(System.currentTimeMillis());
    }

    public void dCz() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && TbadkCoreApplication.getCurrentAccount() != null) {
            ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
            profileRequestMessage.set_uid(Long.valueOf(com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)));
            profileRequestMessage.set_need_post_count(1);
            profileRequestMessage.set_pn(1);
            profileRequestMessage.set_rn(1);
            profileRequestMessage.set_has_plist(1);
            profileRequestMessage.set_from_db(false);
            profileRequestMessage.set_error_hint(true);
            profileRequestMessage.setSelf(true);
            profileRequestMessage.setTag(getUniqueId());
            profileRequestMessage.setIs_from_usercenter(1);
            profileRequestMessage.setPage(1);
            sendMessage(profileRequestMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ProfileHttpResponseMessage profileHttpResponseMessage) {
        if (profileHttpResponseMessage != null && profileHttpResponseMessage.GetUser() != null) {
            this.muD = profileHttpResponseMessage.GetUser().my_like_num.intValue();
            if (this.muD == 1) {
                dCu();
                dCv();
            }
            dCA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ProfileSocketResponseMessage profileSocketResponseMessage) {
        if (profileSocketResponseMessage != null && profileSocketResponseMessage.GetUser() != null) {
            this.muD = profileSocketResponseMessage.GetUser().my_like_num.intValue();
            if (this.muD == 1) {
                dCu();
                dCA();
            }
        }
    }

    private void dCA() {
        if (this.muD == 1) {
            dCu();
            if (TbadkCoreApplication.getInst().getCurrentActivity() == this && this.muE.intValue() != 1) {
                dCv();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public ViewGroup getActivityRootView() {
        return this.lBB;
    }

    public void dCB() {
        if (this.muT != null && this.muT.isShowing()) {
            this.muT.Oj();
            this.muT = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCC() {
        String str = SharedPrefConfig.CHECK_REAL_NAME + TbConfig.getVersion();
        if (com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(str, true) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && l.isNetOk()) {
            this.kQm.MZ(CheckRealNameModel.TYPE_APP_FIRST_START);
            com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(str, false);
        }
    }

    private void ad(final Intent intent) {
        if (intent != null) {
            String dataString = intent.getDataString();
            UtilHelper.clearClipBoardBySchemaParam(dataString);
            if (!StringUtils.isNull(dataString) && dataString.startsWith("tbmaintab://")) {
                String decode = Uri.decode(intent.getData().getEncodedPath());
                if (StringUtils.isNull(decode)) {
                    TiebaStatic.log(new aq("c10320").ai("obj_type", 1).ai(TiebaInitialize.Params.OBJ_TO, 1));
                    return;
                }
                if (decode.startsWith("//")) {
                    decode = decode.substring(2);
                }
                Map<String, String> paramPair = be.getParamPair(decode);
                if (paramPair != null) {
                    String str = paramPair.get("fr");
                    if (!"mpush".equals(str) && "bpush".equals(str)) {
                        aq aqVar = new aq("c10320");
                        aqVar.dF("obj_locate", paramPair.get("obj_locate"));
                        aqVar.ai("obj_type", 1);
                        aqVar.dF("obj_source", paramPair.get("obj_source"));
                        aqVar.dF(TiebaInitialize.Params.OBJ_PARAM2, paramPair.get(TiebaInitialize.Params.OBJ_PARAM2));
                        aqVar.ai(TiebaInitialize.Params.OBJ_TO, 1);
                        aqVar.dF("obj_id", paramPair.get("bdid"));
                        if (!at.isEmpty(paramPair.get(LogConfig.LOG_EXT_LOG))) {
                            try {
                                JSONObject jSONObject = new JSONObject(paramPair.get(LogConfig.LOG_EXT_LOG));
                                Iterator<String> keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    aqVar.dF(next, jSONObject.getString(next));
                                }
                            } catch (Exception e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        TiebaStatic.log(aqVar);
                        HttpMessage httpMessage = new HttpMessage(1003393);
                        httpMessage.addParam("call_url", dataString);
                        MessageManager.getInstance().sendMessage(httpMessage);
                    }
                    com.baidu.tbadk.BdToken.c.aZe().setSchemaUp(true);
                } else {
                    return;
                }
            } else if (!StringUtils.isNull(dataString) && (dataString.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT) || dataString.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT_ZM) || dataString.startsWith("bdtiebalive://") || dataString.startsWith("tiebachushou://"))) {
                String dataString2 = intent.getDataString();
                if (!StringUtils.isNull(dataString2)) {
                    be.bkp().b(getPageContext(), new String[]{dataString2});
                    com.baidu.tbadk.BdToken.c.aZe().setSchemaUp(true);
                }
            } else if (!StringUtils.isNULL(dataString) && dataString.startsWith(com.baidu.tbadk.BdToken.f.dRc)) {
                com.baidu.tbadk.BdToken.f.aZy().a(intent.getData(), new f.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.18
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void z(HashMap<String, Object> hashMap) {
                        if (hashMap != null && intent != null) {
                            Object obj = hashMap.get(com.baidu.tbadk.BdToken.f.dRA);
                            int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : -1;
                            Object obj2 = hashMap.get(com.baidu.tbadk.BdToken.f.dRB);
                            String str2 = obj2 instanceof String ? (String) obj2 : null;
                            Object obj3 = hashMap.get(com.baidu.tbadk.BdToken.f.dRz);
                            String str3 = obj3 instanceof String ? (String) obj3 : null;
                            if (intValue != -1) {
                                intent.putExtra("is_from_scheme", true);
                                intent.putExtra("locate_type", intValue);
                                intent.putExtra("sub_locate_type", str2);
                                intent.putExtra("sub_tab_name", str3);
                                Object obj4 = hashMap.get(com.baidu.tbadk.BdToken.f.dRC);
                                String str4 = obj4 instanceof String ? (String) obj4 : null;
                                Object obj5 = hashMap.get(com.baidu.tbadk.BdToken.f.dRD);
                                String str5 = obj5 instanceof String ? (String) obj5 : null;
                                intent.putExtra(com.baidu.tbadk.BdToken.f.dRC, str4);
                                intent.putExtra(com.baidu.tbadk.BdToken.f.dRD, str5);
                            }
                            com.baidu.tbadk.BdToken.c.aZe().setSchemaUp(true);
                        }
                    }
                });
            }
            final String stringExtra = intent.getStringExtra(MainTabActivityConfig.TARGET_SCHEME);
            if (!StringUtils.isNull(stringExtra)) {
                com.baidu.adp.lib.f.e.mX().post(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.19
                    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        be.bkp().b(MainTabActivity.this.getPageContext(), new String[]{stringExtra});
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
        this.hZU = getVoiceManager();
        if (this.hZU != null) {
            this.hZU.onStart(getPageContext());
        }
    }

    public boolean dCD() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_SYNC, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_ACTIVE, null));
        cEW();
        com.baidu.tbadk.coreExtra.messageCenter.b.boP().bpa();
        com.baidu.tbadk.coreExtra.messageCenter.b.boP().boV();
        com.baidu.tbadk.coreExtra.messageCenter.b.boP().iD(false);
        MessageManager.getInstance().unRegisterListener(this.jRo);
        MessageManager.getInstance().unRegisterListener(this.muR);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setDialogVisiable(false);
            this.mWaitingDialog = null;
        }
        dCE();
        if (this.mus != null) {
            this.mus.onDestroy();
        }
        if (this.muz != null) {
            this.muz.onDestroy();
        }
        try {
            super.onDestroy();
        } catch (Exception e) {
        }
        com.baidu.tbadk.core.e.b.a(null);
        KuangFloatingFrsCopyLinkViewController.getInstance().onDestory();
        this.hZU = getVoiceManager();
        if (this.hZU != null) {
            this.hZU.onDestory(getPageContext());
        }
        if (this.ies != null) {
            this.ies.onDestroy();
        }
        if (this.iaK != null) {
            this.iaK.onDestroy();
        }
        if (this.itk != null) {
            this.itk.cancelLoadData();
        }
        if (this.lHj != null) {
            this.lHj.onDestroy();
        }
        if (this.mus != null && this.mus.dCS() != null) {
            this.mus.dCS().onDestory();
        }
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.mva);
        System.gc();
    }

    private void dCE() {
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

    private void h(Context context, Intent intent) {
        UtilHelper.commenDealIntent(context, intent);
        TbadkCoreApplication.setIntent(null);
    }

    private void cEV() {
        registerListener(this.muI);
        this.muN.setPriority(100);
        registerListener(this.muN);
        registerListener(this.muO);
        registerListener(this.muP);
        registerListener(this.muQ);
        registerListener(this.muW);
        registerListener(this.muX);
        registerListener(this.muM);
        registerListener(this.skinTypeChangeListener);
        registerListener(this.muJ);
        this.mut = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.mut, intentFilter);
        registerListener(this.ibt);
        registerListener(this.muL);
        registerListener(this.mSyncFinishListener);
        registerListener(this.dUg);
        registerListener(this.muZ);
        this.muH.setTag(getUniqueId());
        registerListener(this.muH);
        registerListener(this.muR);
        registerListener(this.ibK);
        registerListener(this.muK);
        registerListener(this.mLikeForumListener);
        registerListener(this.mEnterForumTabClickListener);
        registerListener(this.lXx);
        registerListener(this.muU);
        registerListener(this.muS);
    }

    private void cEW() {
        if (this.mut != null) {
            unregisterReceiver(this.mut);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
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
        if (this.hYU) {
            ai.b(this.alw);
            this.hYU = false;
        }
        if (this.mus != null && this.mus.dCS() != null) {
            this.mus.dCS().setLottieView(true);
        }
        if (this.mus != null && this.mus.crf() != null) {
            this.mun = this.mus.crf().getCurrentTabType();
        }
        changeSkinType(this.mSkinType);
        KuangFloatingFrsCopyLinkViewController.getInstance().hideFloatingView(true);
        if (TbadkCoreApplication.isLogin() && n.bvx().bvv()) {
            n.bvx().bvy();
        }
        this.hZU = getVoiceManager();
        if (this.hZU != null) {
            this.hZU.onResume(getPageContext());
        }
        if (this.mus != null) {
            this.mus.dCU();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_ON_RESUME, getActivity()));
        if (TbadkCoreApplication.getKeepLiveSwitch(getApplicationContext())) {
            com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.20
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_KEEPLIVE_START_SERVICE, Boolean.FALSE));
                }
            }, IMConnection.RETRY_DELAY_TIMES);
        }
        n.bvx().bvy();
        if (q.aZL().aZO() != null && q.aZL().aZU() != null && q.aZL().aZO().getCurTaskType() == 6) {
            q.aZL().aZU().complete();
        }
        dCv();
        if (this.muE.intValue() != 1) {
            dCv();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.muw = true;
        if (z) {
            com.baidu.tbadk.getUserInfo.b.btU().btV();
            dCy();
            dCC();
            dCz();
        }
        this.mus.switchNaviBarStatus(z);
        this.mus.dCW();
        cVl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (this.mum) {
            this.mum = false;
            CompatibleUtile.setAnim(getPageContext().getPageActivity(), R.anim.down, R.anim.hold);
        }
        this.hZU = getVoiceManager();
        if (this.hZU != null) {
            this.hZU.onPause(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOME_HIDE_GUIDE));
        if (this.muz != null) {
            this.muz.cxx();
        }
        KuangFloatingViewController.getInstance().hideFloatingView();
        KuangFloatingFrsCopyLinkViewController.getInstance().hideFloatingView(true);
        dCw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
        } catch (Exception e) {
        }
        bundle.putInt("locate_type", this.mus.crf().getCurrentTabType());
        bundle.putParcelable("android:fragments", null);
        bundle.putParcelable("android:support:fragments", null);
        this.hZU = getVoiceManager();
        if (this.hZU != null) {
            this.hZU.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.hZU = getVoiceManager();
        if (this.hZU != null) {
            this.hZU.onStop(getPageContext());
        }
        this.hYU = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        FragmentTabHost.b nY;
        int i = 2;
        super.onNewIntent(intent);
        setIntent(intent);
        String stringExtra = intent.getStringExtra(MainTabActivityConfig.TARGET_SCHEME);
        if (this.muG.am(intent)) {
            this.muG.a(intent, this.mus);
        } else {
            ad(intent);
        }
        if (StringUtils.isNull(stringExtra)) {
            com.baidu.tbadk.getUserInfo.b.btU().btV();
            if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_RESET_TABS));
                cVl();
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
                            i = this.mux.bAs();
                        }
                    }
                    if (this.mus != null || this.mus.crf() == null) {
                        intExtra = i;
                    } else {
                        this.mus.setCurrentTabByType(i);
                        intExtra = i;
                    }
                }
                i = intExtra;
                if (this.mus != null) {
                }
                intExtra = i;
            } else if ((intExtra == 17 || intExtra == 18 || intExtra == 19) && this.mus != null && this.mus.crf() != null) {
                this.mus.crf().setCurrentTab(0);
            }
            if (this.mus != null && this.mus.crf() != null && (nY = this.mus.crf().nY(intExtra)) != null && (nY.mContentFragment instanceof com.baidu.tbadk.core.g)) {
                ((com.baidu.tbadk.core.g) nY.mContentFragment).B(intent);
            }
            h(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
            if (this.mus != null) {
                this.mus.dCU();
            }
        }
    }

    protected void ax(Activity activity) {
        new com.baidu.tbadk.core.dialog.a(activity).nD(R.string.confirm_title).id(false).nE(R.string.background_process_permission).a(R.string.now_goto_setting, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.22
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                try {
                    MainTabActivity.this.startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
                    aVar.dismiss();
                } catch (Exception e) {
                    MainTabActivity.this.showToast(R.string.goto_developActivity_error_toast);
                }
            }
        }).b(R.string.next_time, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.21
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                MainTabActivity.this.dCF();
            }
        }).b(i.I(activity)).bia();
    }

    protected void dCF() {
        com.baidu.adp.lib.e.c.mR().d(getUniqueId());
        dCH();
        try {
            moveTaskToBack(true);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, com.baidu.adp.base.h
    public void onPreLoad(t tVar) {
        super.onPreLoad(tVar);
        ag.a(tVar, getUniqueId());
        com.baidu.tbadk.core.util.f.c.a(tVar, getUniqueId(), this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!MainTabActivityConfig.IS_BACK_CLOSE_ALL_ACTIVITY && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, (Class) null);
            if (runTask == null || !((Boolean) runTask.getData()).booleanValue()) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2016323, (Class) null);
                if (runTask2 == null || !((Boolean) runTask2.getData()).booleanValue()) {
                    if (this.ies != null && this.ies.isShowing()) {
                        this.ies.xl(true);
                        return true;
                    } else if (this.mus.cVp()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
                        return true;
                    } else {
                        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(2921405, Boolean.class, false);
                        if (runTask3 == null || runTask3.getData() == null || !(runTask3.getData() instanceof Boolean) || !((Boolean) runTask3.getData()).booleanValue()) {
                            if (System.currentTimeMillis() - this.muq > 2000) {
                                showToast(R.string.double_back_quit);
                                this.muq = System.currentTimeMillis();
                            } else if (UtilHelper.isBackgroundProcessLimitNone() && Build.VERSION.SDK_INT >= 14) {
                                ax(getPageContext().getPageActivity());
                                return true;
                            } else {
                                dCF();
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
    public void ak(Intent intent) {
        int bAs;
        if (intent != null && this.mus != null && this.mus.crf() != null) {
            try {
                if (intent.hasExtra("locate_type")) {
                    bAs = intent.getIntExtra("locate_type", 1);
                } else {
                    bAs = this.mux.bAs();
                }
                this.mus.crf().setCurrentTabByType(bAs);
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

    private void cVB() {
        registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Integer) {
                    Integer num = (Integer) customResponsedMessage.getData();
                    if (num.intValue() == 2) {
                        MainTabActivity.this.mus.wx(true);
                        MainTabActivity.this.mus.sg(true);
                    } else if (num.intValue() == 1) {
                        MainTabActivity.this.mus.wx(true);
                        MainTabActivity.this.mus.sg(false);
                    } else {
                        MainTabActivity.this.mus.wx(false);
                        MainTabActivity.this.mus.sg(false);
                    }
                    MainTabActivity.this.mus.dCU();
                }
            }
        });
    }

    protected void dCG() {
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
            if (this.mus.crf().getCurrentFragment() != null) {
                this.mus.crf().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 25046) {
            if (TbadkCoreApplication.isLogin()) {
                q.aZL().c(getPageContext());
            }
        } else if (i == 11001) {
            dCG();
        } else if (i == 13003 || i == 25048) {
            al(intent);
        } else if (i == 23007) {
            U(intent);
        } else if (i == 13011) {
            com.baidu.tieba.o.a.dqz().F(getPageContext());
        } else if (i == 24007) {
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1) {
                com.baidu.tieba.o.a.dqz().F(getPageContext());
                ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                aqVar.ai("obj_locate", 5);
                if (shareItem != null) {
                    aqVar.dF("tid", shareItem.tid);
                }
                aqVar.dF("pid", intent.getStringExtra("pid"));
                TiebaStatic.log(aqVar);
                if (shareItem != null && shareItem.linkUrl != null && this.itk != null) {
                    this.itk.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.25
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void bpT() {
                        }

                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void a(final CustomDialogData customDialogData) {
                            com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.25.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a(MainTabActivity.this.getPageContext(), customDialogData).show();
                                }
                            }, 1000L);
                        }
                    });
                }
            }
        } else if (this.mus.crf().getCurrentFragment() != null) {
            this.mus.crf().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    private ShareFromPBMsgData cuY() {
        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.imageUri == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.imageUri.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.eGA);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.fName);
        shareFromPBMsgData.setThreadId(shareItem.tid);
        return shareFromPBMsgData;
    }

    private void U(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(cuY(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.nH(1);
            aVar.aZ(thread2GroupShareView);
            aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.26
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MainTabActivity.this.HidenSoftKeyPad((InputMethodManager) MainTabActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(MainTabActivity.this.getPageContext().getPageActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.bqr() != null) {
                        Bundle bqr = shareItem.bqr();
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ai("obj_source", 1).ai("obj_type", bqr.getInt("obj_type")).ai("obj_param1", 3).dF("fid", bqr.getString("fid")).dF("tid", bqr.getString("tid")).ai("obj_locate", 5));
                    }
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.27
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MainTabActivity.this.HidenSoftKeyPad((InputMethodManager) MainTabActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.ie(true);
            aVar.b(getPageContext()).bia();
            if (!k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.aJ(shareFromPBMsgData.getImageUrl(), false);
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
        this.mus.onChangeSkinType(i);
        adjustResizeForSoftInputOnSkinTypeChanged(i);
        if (this.ies != null) {
            this.ies.onChangeSkinType(i);
        }
    }

    private void al(Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        if (intent != null) {
            try {
                postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
            } catch (Exception e) {
                BdLog.e(e);
                postWriteCallBackData = null;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PERSONALIZED_MAINTAB_ON_RESULT, postWriteCallBackData));
            if (this.mus != null && !this.mus.d(postWriteCallBackData)) {
                this.mus.b(postWriteCallBackData);
            }
        }
    }

    private void dCH() {
        if (System.currentTimeMillis() - this.mur >= 7200000) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "start");
            hashMap.put(BdStatsConstant.StatsKey.UNAME, TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_CLEARTEMP, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
            this.mur = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.a
    public int getCurrentTabType() {
        if (this.mus.crf() != null) {
            return this.mus.crf().getCurrentTabType();
        }
        return -1;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hZU == null) {
            this.hZU = VoiceManager.instance();
        }
        return this.hZU;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public ListView blX() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> blY() {
        if (this.exy == null) {
            this.exy = UserIconBox.u(getPageContext().getPageActivity(), 8);
        }
        return this.exy;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cot() {
        if (this.muv == null) {
            this.muv = FrsCommonImageLayout.G(getPageContext().getPageActivity(), 12);
        }
        return this.muv;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return new com.baidu.tbadk.m.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.28
            @Override // com.baidu.tbadk.m.b
            public boolean isCurrentPageCanBeAddToSourceTrace() {
                return true;
            }

            @Override // com.baidu.tbadk.m.b
            public int getMaxCost() {
                return com.baidu.tbadk.m.e.bve().getMaxCostFromServer();
            }

            @Override // com.baidu.tbadk.m.b
            public boolean canStat(com.baidu.tbadk.m.d dVar) {
                return false;
            }
        };
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public List<String> getCurrentPageSourceKeyList() {
        List<String> currentPageSourceKeyList = super.getCurrentPageSourceKeyList();
        if (this.muw && currentPageSourceKeyList != null) {
            currentPageSourceKeyList.clear();
            this.muw = false;
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
        if (this.mus != null && this.mus.crf() != null) {
            Fragment currentFragment = this.mus.crf().getCurrentFragment();
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
        this.gNB = z;
        boolean z2 = this.muB || this.gNB;
        if (this.mus != null) {
            this.mus.onKeyboardVisibilityChanged(z2);
        }
    }

    @Override // com.baidu.tbadk.core.util.f.b
    public boolean videoNeedPreload() {
        return ai.rc(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (configuration != null) {
            super.onConfigurationChanged(configuration);
            if (TbadkCoreApplication.getInst().getSkinType() != 1) {
                ap.C(true, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCI() {
        String str = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_is_clear_concern_cache_when_version_update") + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + TbConfig.getVersion();
        if (!com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(str, false)) {
            try {
                com.baidu.tbadk.core.c.a.bhV().dv("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).setForever("0", null);
                com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(str, true);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
