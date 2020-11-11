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
/* loaded from: classes22.dex */
public class MainTabActivity extends BaseFragmentActivity implements com.baidu.tbadk.core.util.f.b, UserIconBox.b, VoiceManager.c, FrsCommonImageLayout.c, com.baidu.tieba.tblauncher.a {
    private static boolean syncHasFinish;
    private WeakReference<Context> alP;
    private com.baidu.adp.lib.d.b<TbImageView> eXS;
    private com.baidu.tieba.ueg.d gnN;
    VoiceManager iHo;
    private com.baidu.tieba.NEGFeedBack.a iIe;
    private g iLI;
    private ShareSuccessReplyToServerModel jaw;
    private CheckRealNameModel lxY;
    private boolean mTouchable;
    private FrameLayout mjn;
    private com.baidu.tieba.ueg.b moV;
    private bg ncD;
    private d ncG;
    private a ncH;
    private com.baidu.adp.lib.d.b<TbImageView> ncJ;
    private com.baidu.tieba.b ncL;
    private c ncN;
    private com.baidu.tbadk.BdToken.d ncO;
    private com.baidu.tieba.c.e ncQ;
    private int ncR;
    private e ncU;
    private com.baidu.tieba.c.e ndh;
    private String ndm;
    private boolean ncA = false;
    private int ncB = -1;
    private boolean ncC = false;
    private String mFrom = null;
    private volatile boolean mIsAdd = false;
    private long ncE = 0;
    private long ncF = 0;
    private long ncI = -1;
    private boolean ncK = false;
    private String ncM = "";
    boolean ncP = false;
    boolean hum = false;
    boolean iGo = true;
    private Integer ncS = -1;
    private int ncT = 16;
    private CustomMessageListener ncV = new CustomMessageListener(CmdConfigCustom.EDITOR_VISIBILITY_CHANGED) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && MainTabActivity.this.ncG != null && TbadkCoreApplication.getInst().getCurrentActivity() == MainTabActivity.this) {
                MainTabActivity.this.ncP = com.baidu.adp.lib.f.b.toBoolean(customResponsedMessage.getData().toString(), false);
                MainTabActivity.this.ncG.onKeyboardVisibilityChanged((MainTabActivity.this.ncP || MainTabActivity.this.hum) ? true : true);
            }
        }
    };
    private final CustomMessageListener ncW = new CustomMessageListener(CmdConfigCustom.CMD_CLOSE_MATINTAB) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.12
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
                        MainTabActivity.this.ncG.cAl().changeStyle(1);
                    } else if (TbadkCoreApplication.getInst().isThemeIconCover()) {
                        MainTabActivity.this.ncG.cAl().changeStyle(2);
                    } else {
                        MainTabActivity.this.ncG.cAl().changeStyle(1);
                    }
                }
            }
        }
    };
    public CustomMessageListener ncX = new CustomMessageListener(CmdConfigCustom.CMD_GET_LIVE_IS_MIX) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && MainTabActivity.this.ncG != null && MainTabActivity.this.ncG.cAl() != null) {
                if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    MainTabActivity.this.ncG.cAl().getTabWrapper().animate().translationY(MainTabActivity.this.ncG.cAl().getTabWrapper().getHeight()).setDuration(200L).start();
                } else {
                    MainTabActivity.this.ncG.cAl().getTabWrapper().animate().translationY(0.0f).setDuration(400L).start();
                }
            }
        }
    };
    public CustomMessageListener ncY = new CustomMessageListener(2921452) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof j) && com.baidu.tbadk.core.util.bg.checkUpIsLogin(MainTabActivity.this.getPageContext().getPageActivity())) {
                MainTabActivity.this.cAj();
            }
        }
    };
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData()).isSuccess && MainTabActivity.this.ncR == 0) {
                MainTabActivity.this.dLQ();
            }
        }
    };
    private CustomMessageListener ikl = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = MainTabActivity.this.ncS.intValue();
                MainTabActivity.this.ncS = (Integer) customResponsedMessage.getData();
                if (MainTabActivity.this.ncS.intValue() == 1) {
                    MainTabActivity.this.dLS();
                } else if (intValue == 1) {
                    MainTabActivity.this.dLR();
                }
                if (MainTabActivity.this.ncS.intValue() == 2) {
                    MainTabActivity.this.dLX();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c klh = new com.baidu.adp.framework.listener.c(1001) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ConfigVersion configVersion;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                if (socketResponsedMessage.getError() == 0 && (configVersion = responseOnlineMessage.getConfigVersion()) != null) {
                    MainTabActivity.this.Tk(configVersion.sync);
                }
            }
        }
    };
    private CustomMessageListener ncZ = new CustomMessageListener(CmdConfigCustom.CMD_SEARCH_JUMP_PB) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.42
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
    private final CustomMessageListener nda = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_INFO_CHANGED) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getData() instanceof PayMemberInfoData) {
                    MainTabActivity.this.a((PayMemberInfoData) customResponsedMessage.getData());
                    TbadkCoreApplication.getInst().setPaymemberInfo((PayMemberInfoData) customResponsedMessage.getData());
                }
                UserData bAY = com.baidu.tbadk.getUserInfo.b.bAW().bAY();
                if (TbadkCoreApplication.isLogin() && bAY != null && bAY.getUserId() != null && !bAY.getUserId().equals(MainTabActivity.this.ncM) && bAY.getIsGodInvited()) {
                    MainTabActivity.this.ncM = bAY.getUserId();
                    MainTabActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(MainTabActivity.this.getPageContext().getPageActivity(), "", TbWebViewActivityConfig.GOD_INVITE_JUMP_URL + "?page_type=open_full_screen_opacity_web_page", true)));
                }
                if (!com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean("key_new_god_invited_my_tab_red_tip_showed", false) && TbadkCoreApplication.isLogin() && bAY != null && bAY.getUserId() != null && !bAY.getUserId().equals(MainTabActivity.this.ncM) && bAY.getNewGodData() != null && bAY.getNewGodData().isNewGodInvited()) {
                    com.baidu.tieba.p.a.dBY().h(11, true, true);
                    TiebaStatic.log(new aq("c13688").w("uid", TbadkCoreApplication.getCurrentAccountId()).al("obj_locate", 0));
                    com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean("key_new_god_invited_my_tab_red_tip_showed", true);
                }
            }
        }
    };
    private CustomMessageListener iIN = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && !((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                MainTabActivity.this.ncG.c((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    };
    final CustomMessageListener ndb = new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.tbadk.mainTab.b> list;
            MainTabActivity.this.mIsAdd = false;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null && (list = ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).getList()) != null && list.size() != 0) {
                MainTabActivity.this.ncG.aU(list);
                if (MainTabActivity.this.ncC) {
                    MainTabActivity.this.ncG.cAl().setCurrentTabByType(MainTabActivity.this.ncB);
                } else if (MainTabActivity.this.getActivity().getIntent() == null || MainTabActivity.this.getActivity().getIntent().getDataString() == null || !MainTabActivity.this.getActivity().getIntent().getDataString().startsWith("com.baidu.tieba://deeplink?jump=new_hot_topic_list")) {
                    MainTabActivity.this.ai(MainTabActivity.this.getIntent());
                } else {
                    MainTabActivity.this.ncG.cAl().setCurrentTabByType(2);
                }
                MainTabActivity.this.ncC = false;
                MainTabActivity.this.ncG.dMn();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP, null));
            }
        }
    };
    final CustomMessageListener ndc = new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_REFRESH_TABS) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007013) {
                MainTabActivity.this.deE();
                if (MainTabActivity.this.ncG != null && MainTabActivity.this.ncG.cAl() != null) {
                    MainTabActivity.this.ncB = MainTabActivity.this.ncG.cAl().getCurrentTabType();
                }
                MainTabActivity.this.ncC = true;
            }
        }
    };
    final CustomMessageListener ndd = new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_REFRESH_TOPIC_TIP) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (MainTabActivity.this.ncD != null || (customResponsedMessage.getData() instanceof bg)) {
                    if (customResponsedMessage.getData() != null) {
                        MainTabActivity.this.ncD = (bg) customResponsedMessage.getData();
                    }
                    if (!MainTabActivity.this.mIsAdd && MainTabActivity.this.ncD != null && TbadkCoreApplication.isLogin()) {
                        MainTabActivity.this.ncN.k(MainTabActivity.this.ncD.recom_title, MainTabActivity.this.ncD.recom_topic, MainTabActivity.this.ncD.eCy);
                    }
                }
            }
        }
    };
    private final CustomMessageListener nde = new CustomMessageListener(CmdConfigCustom.MAINTAB_SET_INST) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.e.b.bpX() == null) {
                b bVar = new b();
                bVar.a(MainTabActivity.this);
                com.baidu.tbadk.core.e.b.a(bVar);
            }
        }
    };
    private CustomMessageListener ndf = new CustomMessageListener(2921380) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.8
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
                                TiebaStatic.log(new aq("c12264").al("obj_type", 3));
                            }
                        }
                    }, false);
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a mFG = new com.baidu.adp.framework.listener.a(1002700, CmdConfigSocket.CMD_PROFILE) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.13
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
    private CustomMessageListener ndg = new CustomMessageListener(2921504) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            MainTabActivity.this.dLV();
        }
    };
    private CustomMessageListener ndi = new CustomMessageListener(2921491) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && MainTabActivity.this.ncG != null && MainTabActivity.this.ncG.cAl() != null && MainTabActivity.this.ncG.cAl().getCurrentTabType() != 21) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    FragmentTabWidget fragmentTabWidget = MainTabActivity.this.ncG.cAl().getFragmentTabWidget();
                    if (fragmentTabWidget.getChildCount() >= 2) {
                        MainTabActivity.this.ndh = new com.baidu.tieba.c.e(MainTabActivity.this.getPageContext(), fragmentTabWidget.getChildAt(2));
                        MainTabActivity.this.ndh.fu(R.drawable.bg_tip_blue_down);
                        MainTabActivity.this.ndh.setAnchor(2);
                        MainTabActivity.this.ndh.ft(32);
                        MainTabActivity.this.ndh.setUseDirectOffset(true);
                        MainTabActivity.this.ndh.setYOffset(-l.getDimens(MainTabActivity.this, R.dimen.tbds10));
                        MainTabActivity.this.ndh.setTextColor(R.color.cp_cont_a);
                        MainTabActivity.this.ndh.setHeight(R.dimen.tbds54);
                        MainTabActivity.this.ndh.setMaxShowTime(999);
                        MainTabActivity.this.ndh.fv(5000);
                        MainTabActivity.this.ndh.xo(l.getDimens(MainTabActivity.this, R.dimen.tbds44));
                        MainTabActivity.this.ndh.b(str, "categoryUpdate", false, true);
                    }
                }
            }
        }
    };
    private CheckRealNameModel.a ndj = new CheckRealNameModel.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.16
        @Override // com.baidu.tieba.model.CheckRealNameModel.a
        public void b(int i, String str, String str2, Object obj) {
            if (CheckRealNameModel.TYPE_APP_FIRST_START.equals(str2) && i == 1990055) {
                TiebaStatic.log("c12138");
                MainTabActivity.this.ncG.Tm(MainTabActivity.this.getResources().getString(R.string.check_real_name_message));
            }
        }
    };
    private CustomMessageListener euz = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && l.isNetOk()) {
                MainTabActivity.this.dLY();
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
                MainTabActivity.this.ncK = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
                com.baidu.tbadk.core.sharedPref.b.bqh().remove(SharedPrefConfig.KEY_FEEDBACK_TIP);
                com.baidu.tbadk.core.sharedPref.b.bqh().remove(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW);
                com.baidu.tbadk.core.sharedPref.b.bqh().remove(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP));
                if (MainTabActivity.this.ncO != null) {
                    MainTabActivity.this.ncO.zA(UtilHelper.getClipBoardContent());
                }
                if (MainTabActivity.this.ncG != null) {
                    MainTabActivity.this.ncG.dMs();
                }
                MainTabActivity.this.dMe();
            }
        }
    };
    private CustomMessageListener ndk = new CustomMessageListener(CmdConfigCustom.CMD_GAME_CENTER_INIT) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                p.eLT = ((Boolean) customResponsedMessage.getData()).booleanValue();
                MainTabActivity.this.dLU();
            }
        }
    };
    private final CustomMessageListener ndl = new CustomMessageListener(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.GAME_TIP_SHOW, booleanValue);
                MainTabActivity.this.ncG.xF(booleanValue);
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
                if (MainTabActivity.this.ncG != null && MainTabActivity.this.ncG.dMo() != null && MainTabActivity.this.ncG.dMo().getAnimationView() != null && MainTabActivity.this.ncG.dMo().getAnimationView().getVisibility() != 0) {
                    MainTabActivity.this.ncG.dMo().setLottieView(false);
                }
                if (!TbadkCoreApplication.getInst().getActivityPrizeData().isSwitchTurn()) {
                    if (MainTabActivity.this.ncG != null) {
                        MainTabActivity.this.ncG.Tl(null);
                    }
                } else {
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getInst().getActivityPrizeData().isUserSatisfy()) {
                        String h5Url = TbadkCoreApplication.getInst().getActivityPrizeData().getH5Url();
                        if (!StringUtils.isNull(h5Url) && com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(SharedPrefConfig.ACTIVITY_PRIZE_GET_TIP + TbadkCoreApplication.getCurrentAccount(), true)) {
                            be.brr().a(MainTabActivity.this.getPageContext(), new String[]{h5Url}, true);
                            com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.ACTIVITY_PRIZE_GET_TIP + TbadkCoreApplication.getCurrentAccount(), false);
                        }
                    }
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                        if (MainTabActivity.this.ncG != null) {
                            MainTabActivity.this.ncG.Tl(null);
                        }
                    } else {
                        String myTabText = TbadkCoreApplication.getInst().getActivityPrizeData().getMyTabText();
                        if (!StringUtils.isNull(myTabText)) {
                            if (MainTabActivity.this.ncG != null) {
                                MainTabActivity.this.ncG.Tl(myTabText);
                            }
                        } else if (MainTabActivity.this.ncG != null) {
                            MainTabActivity.this.ncG.Tl(null);
                        }
                    }
                }
                if (TbSingleton.getInstance().canShowPermDialog()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921360, MainTabActivity.this));
                }
                com.baidu.tbadk.core.business.a.bjT().dF("1", "");
            }
        }
    };
    private CustomMessageListener ndn = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    MainTabActivity.this.ndm = UtilHelper.getCurrentDay();
                    com.baidu.tbadk.core.sharedPref.b.bqh().putLong("last_resume_time", TbSingleton.getInstance().getLastResumeTime());
                    return;
                }
                String currentDay = UtilHelper.getCurrentDay();
                if (!StringUtils.isNull(currentDay) && !currentDay.equals(MainTabActivity.this.ndm)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
                }
                if (MainTabActivity.this.moV == null) {
                    MainTabActivity.this.moV = new com.baidu.tieba.ueg.b();
                }
                MainTabActivity.this.moV.Ku(MainTabActivity.this.moV.nla);
                MainTabActivity.this.moV.nla = ax.a.eNY;
            }
        }
    };
    private final CustomMessageListener kyH = new CustomMessageListener(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.data.l lVar;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && (lVar = (com.baidu.tbadk.data.l) customResponsedMessage.getData()) != null && !StringUtils.isNull(lVar.mLink)) {
                com.baidu.tbadk.plugins.b.a(lVar);
                if (StringUtils.isNull(lVar.fmn)) {
                    be.brr().b(MainTabActivity.this.getPageContext(), new String[]{lVar.mLink});
                } else {
                    be.brr().b(MainTabActivity.this.getPageContext(), new String[]{lVar.mLink, lVar.fmn});
                }
            }
        }
    };
    private CustomMessageListener iJe = new CustomMessageListener(2921414) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (MainTabActivity.this.iLI != null) {
                MainTabActivity.this.iLI.bEY();
            }
        }
    };
    private Runnable ndo = new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.37
        @Override // java.lang.Runnable
        public void run() {
            if (TbSingleton.getInstance().getNewUserRedPackageData() != null) {
                MainTabActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewUserRedPackageActivityConfig(MainTabActivity.this, TbSingleton.getInstance().getNewUserRedPackageData())));
                TbSingleton.getInstance().setNewUserRedPackageData(null);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void dLQ() {
        FragmentTabWidget fragmentTabWidget = this.ncG.cAl().getFragmentTabWidget();
        if (fragmentTabWidget.getChildCount() >= 2) {
            this.ncQ = new com.baidu.tieba.c.e(getPageContext(), fragmentTabWidget.getChildAt(1));
            this.ncQ.fu(R.drawable.bg_tip_blue_down);
            this.ncQ.setAnchor(2);
            this.ncQ.ft(32);
            this.ncQ.setUseDirectOffset(true);
            this.ncQ.setYOffset(-l.getDimens(this, R.dimen.tbds10));
            this.ncQ.setTextColor(R.color.cp_cont_a);
            this.ncQ.setHeight(R.dimen.tbds54);
            this.ncQ.setMaxShowTime(1);
            this.ncQ.fv(4000);
            this.ncQ.xo(l.getDimens(this, R.dimen.tbds44));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLR() {
        if (this.ncQ != null && !this.ncQ.isShowing()) {
            this.ncQ.aM(getString(R.string.enterforumtab_like_forum_tips), "first_like_forum_enterforumtab_tips" + TbadkCoreApplication.getCurrentAccount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLS() {
        if (this.ncQ != null && this.ncQ.isShowing()) {
            this.ncQ.SR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tk(String str) {
        if (str != null && TbadkCoreApplication.getInst().getConfigVersion() != null && dLT()) {
            this.ncI = System.currentTimeMillis();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
        }
    }

    private boolean dLT() {
        if (-1 == this.ncI) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.ncI;
        return currentTimeMillis <= 0 || currentTimeMillis >= 300000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLU() {
        if (SwitchManager.getInstance().findType(GameEnterSwitch.GAME_ENTER_KEY) == 1 && p.eLT) {
            this.ncG.xD(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_CHECK_UPDATE));
            return;
        }
        this.ncG.xD(false);
        this.ncG.xF(false);
        com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.GAME_TIP_SHOW, false);
    }

    public void a(PayMemberInfoData payMemberInfoData) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && payMemberInfoData != null) {
            if ((payMemberInfoData.byP() == 1 || payMemberInfoData.byP() == 2) && com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(SharedPrefConfig.SHOW_MEMBER_DEID_LINE, true)) {
                long bko = payMemberInfoData.bko() * 1000;
                if (bko < System.currentTimeMillis()) {
                    if (StringUtils.isNull(payMemberInfoData.byQ())) {
                        payMemberInfoData.Dt(getPageContext().getString(R.string.member));
                    } else {
                        payMemberInfoData.Dt(payMemberInfoData.byQ() + getPageContext().getString(R.string.member_already_Expire));
                    }
                    this.ncG.a(payMemberInfoData, 0);
                } else if (bko - System.currentTimeMillis() < Config.THREAD_IMAGE_SAVE_MAX_TIME) {
                    if (StringUtils.isNull(payMemberInfoData.byQ())) {
                        payMemberInfoData.Dt(getPageContext().getString(R.string.member));
                    } else {
                        payMemberInfoData.Dt(payMemberInfoData.byQ() + getPageContext().getString(R.string.member_will_Expire));
                    }
                    this.ncG.a(payMemberInfoData, 1);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.mTouchable) {
            return false;
        }
        if (this.ncG.cAl() == null || this.ncG.cAl().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1 || !this.ncG.deI()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public void cAj() {
        if (this.ncN != null) {
            this.ncN.cGB();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_ENTERFORUM_GUIDE));
        if (this.iLI == null) {
            this.iLI = new g(getPageContext(), this.mjn, "main_tab", 3);
            this.iLI.UC("8");
        }
        if (!this.gnN.dNP() && this.ncG.cAl() != null && this.ncG.cAl().getFragmentTabWidget() != null) {
            this.iLI.a(false, (View) this.ncG.cAl().getTabWrapper(), this.ncG.cAl().getFragmentTabWidget().getWriteView());
        }
    }

    protected void deE() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ADD_FRAGMENT, new com.baidu.tbadk.mainTab.d(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        n.bCz().dV(System.currentTimeMillis());
        if (TbadkCoreApplication.getInst().getIsFirstUse()) {
            ae.a(new ad<Object>() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.9
                @Override // com.baidu.tbadk.util.ad
                public Object doInBackground() {
                    TbadkCoreApplication.getInst().setUsed();
                    return null;
                }
            }, null);
        }
        com.baidu.tbadk.core.util.ae.bqU();
        setIsAddSwipeBackLayout(false);
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.getDecorView();
        super.onCreate(bundle);
        int i = -1;
        if (getIntent() != null) {
            this.ncU = new e(getPageContext());
            if (!this.ncU.ak(getIntent())) {
                ab(getIntent());
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
        if (dLZ()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        setContentView(R.layout.maintabs_activity);
        this.mjn = (FrameLayout) findViewById(R.id.maintabContainer);
        com.baidu.tbadk.core.a.a.bjI().reLoginByCacheAccount();
        this.ncG = new d(this);
        this.ncN = new c(this);
        this.ncG.xC(this.mIsLogin);
        dLU();
        cOm();
        com.baidu.tieba.tblauncher.alarmRemind.b.dMv().f(this);
        com.baidu.tbadk.BdToken.c.bgf().bgh();
        this.ncL = new com.baidu.tieba.b();
        deE();
        deU();
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (bundle != null) {
            i2 = bundle.getInt("locate_type", 1);
            intent.putExtra("locate_type", i2);
        }
        this.ndm = UtilHelper.getCurrentDay();
        this.ncI = System.currentTimeMillis();
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
            MercatorModel.dKU().startLoad();
        }
        registerListener(this.klh);
        if (i2 == 1) {
            this.ncG.xE(true);
        } else {
            this.ncG.xE(false);
        }
        this.ncG.dMq();
        this.iHo = getVoiceManager();
        if (this.iHo != null) {
            this.iHo.onCreate(getPageContext());
        }
        registerListener(this.mAccountChangedListener);
        adjustResizeForSoftInput();
        addGlobalLayoutListener();
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.MAINTAB_ONCREATE_END);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_ONCREATE_END));
        if (TbadkCoreApplication.isLogin()) {
            n.bCz().bCA();
        }
        if (TbadkCoreApplication.isLogin()) {
            com.baidu.tbadk.getUserInfo.b.bAW().bAX();
        }
        com.baidu.tbadk.core.sharedPref.b.bqh().putInt(SharedPrefConfig.APP_RESTART_TIMES, com.baidu.tbadk.core.sharedPref.b.bqh().getInt(SharedPrefConfig.APP_RESTART_TIMES, 0) + 1);
        this.lxY = new CheckRealNameModel(getPageContext());
        this.lxY.a(this.ndj);
        dLY();
        this.iIe = new com.baidu.tieba.NEGFeedBack.a(getPageContext(), "homepage");
        this.jaw = new ShareSuccessReplyToServerModel();
        this.gnN = new com.baidu.tieba.ueg.d(getPageContext());
        this.ncO = com.baidu.tbadk.BdToken.d.bgv();
        int loadInt = TbadkSettings.getInst().loadInt(SharedPrefConfig.PREFS_SKIN_TYPE, 0);
        if (loadInt != 1) {
            ap.C(false, true);
        } else {
            TbadkCoreApplication.getInst().setSkinTypeValue(loadInt);
            TbadkCoreApplication.getInst().SendSkinTypeBroadcast(loadInt);
        }
        if (TbSingleton.getInstance().isEnableBenchmark() && TbSingleton.getInstance().getCpuFlopsDuration() <= 0) {
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.11
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.tbadk.f.a.biK();
                }
            }, 5000L);
        }
        MessageManager.getInstance().registerListener(this.kyH);
        TbSingleton.getInstance().startOneGame();
        this.alP = new WeakReference<>(TbadkCoreApplication.getInst());
        if (getResources() != null && getResources().getConfiguration() != null) {
            this.ncT = getResources().getConfiguration().uiMode & 48;
        }
        com.baidu.q.c.gq(TbadkCoreApplication.getInst()).a(null);
        dMe();
        if (this.ncU.ak(intent)) {
            this.ncU.a(getIntent(), this.ncG);
        }
        com.baidu.adp.lib.f.e.mY().postDelayed(this.ndo, 200L);
        dLV();
        TbSingleton.getInstance().getChannelConfigModel().startLoad();
        n.bCz().dW(System.currentTimeMillis());
    }

    public void dLV() {
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
            this.ncR = profileHttpResponseMessage.GetUser().my_like_num.intValue();
            if (this.ncR == 1) {
                dLQ();
                dLR();
            }
            dLW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ProfileSocketResponseMessage profileSocketResponseMessage) {
        if (profileSocketResponseMessage != null && profileSocketResponseMessage.GetUser() != null) {
            this.ncR = profileSocketResponseMessage.GetUser().my_like_num.intValue();
            if (this.ncR == 1) {
                dLQ();
                dLW();
            }
        }
    }

    private void dLW() {
        if (this.ncR == 1) {
            dLQ();
            if (TbadkCoreApplication.getInst().getCurrentActivity() == this && this.ncS.intValue() != 1) {
                dLR();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public ViewGroup getActivityRootView() {
        return this.mjn;
    }

    public void dLX() {
        if (this.ndh != null && this.ndh.isShowing()) {
            this.ndh.SR();
            this.ndh = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLY() {
        String str = SharedPrefConfig.CHECK_REAL_NAME + TbConfig.getVersion();
        if (com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(str, true) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && l.isNetOk()) {
            this.lxY.OD(CheckRealNameModel.TYPE_APP_FIRST_START);
            com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(str, false);
        }
    }

    private void ab(final Intent intent) {
        if (intent != null) {
            String dataString = intent.getDataString();
            UtilHelper.clearClipBoardBySchemaParam(dataString);
            if (!StringUtils.isNull(dataString) && dataString.startsWith("tbmaintab://")) {
                String decode = Uri.decode(intent.getData().getEncodedPath());
                if (StringUtils.isNull(decode)) {
                    TiebaStatic.log(new aq("c10320").al("obj_type", 1).al(TiebaInitialize.Params.OBJ_TO, 1));
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
                        aqVar.dR("obj_locate", paramPair.get("obj_locate"));
                        aqVar.al("obj_type", 1);
                        aqVar.dR("obj_source", paramPair.get("obj_source"));
                        aqVar.dR(TiebaInitialize.Params.OBJ_PARAM2, paramPair.get(TiebaInitialize.Params.OBJ_PARAM2));
                        aqVar.al(TiebaInitialize.Params.OBJ_TO, 1);
                        aqVar.dR("obj_id", paramPair.get("bdid"));
                        if (!at.isEmpty(paramPair.get(LogConfig.LOG_EXT_LOG))) {
                            try {
                                JSONObject jSONObject = new JSONObject(paramPair.get(LogConfig.LOG_EXT_LOG));
                                Iterator<String> keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    aqVar.dR(next, jSONObject.getString(next));
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
                    com.baidu.tbadk.BdToken.c.bgf().setSchemaUp(true);
                } else {
                    return;
                }
            } else if (!StringUtils.isNull(dataString) && (dataString.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT) || dataString.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT_ZM) || dataString.startsWith("bdtiebalive://") || dataString.startsWith("tiebachushou://"))) {
                String dataString2 = intent.getDataString();
                if (!StringUtils.isNull(dataString2)) {
                    be.brr().b(getPageContext(), new String[]{dataString2});
                    com.baidu.tbadk.BdToken.c.bgf().setSchemaUp(true);
                }
            } else if (!StringUtils.isNULL(dataString) && dataString.startsWith(com.baidu.tbadk.BdToken.f.eru)) {
                com.baidu.tbadk.BdToken.f.bgz().a(intent.getData(), new f.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.18
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void B(HashMap<String, Object> hashMap) {
                        if (hashMap != null && intent != null) {
                            Object obj = hashMap.get(com.baidu.tbadk.BdToken.f.erS);
                            int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : -1;
                            Object obj2 = hashMap.get(com.baidu.tbadk.BdToken.f.erT);
                            String str2 = obj2 instanceof String ? (String) obj2 : null;
                            Object obj3 = hashMap.get(com.baidu.tbadk.BdToken.f.erR);
                            String str3 = obj3 instanceof String ? (String) obj3 : null;
                            if (intValue != -1) {
                                intent.putExtra("is_from_scheme", true);
                                intent.putExtra("locate_type", intValue);
                                intent.putExtra("sub_locate_type", str2);
                                intent.putExtra("sub_tab_name", str3);
                                Object obj4 = hashMap.get(com.baidu.tbadk.BdToken.f.erU);
                                String str4 = obj4 instanceof String ? (String) obj4 : null;
                                Object obj5 = hashMap.get(com.baidu.tbadk.BdToken.f.erV);
                                String str5 = obj5 instanceof String ? (String) obj5 : null;
                                intent.putExtra(com.baidu.tbadk.BdToken.f.erU, str4);
                                intent.putExtra(com.baidu.tbadk.BdToken.f.erV, str5);
                            }
                            com.baidu.tbadk.BdToken.c.bgf().setSchemaUp(true);
                        }
                    }
                });
            }
            final String stringExtra = intent.getStringExtra(MainTabActivityConfig.TARGET_SCHEME);
            if (!StringUtils.isNull(stringExtra)) {
                com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.19
                    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.tblauncher.MainTabActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        be.brr().b(MainTabActivity.this.getPageContext(), new String[]{stringExtra});
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
        this.iHo = getVoiceManager();
        if (this.iHo != null) {
            this.iHo.onStart(getPageContext());
        }
    }

    public boolean dLZ() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_SYNC, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_STOP_ACTIVE, null));
        cOn();
        com.baidu.tbadk.coreExtra.messageCenter.b.bvS().bwd();
        com.baidu.tbadk.coreExtra.messageCenter.b.bvS().bvY();
        com.baidu.tbadk.coreExtra.messageCenter.b.bvS().jx(false);
        MessageManager.getInstance().unRegisterListener(this.kyH);
        MessageManager.getInstance().unRegisterListener(this.ndf);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setDialogVisiable(false);
            this.mWaitingDialog = null;
        }
        dMa();
        if (this.ncG != null) {
            this.ncG.onDestroy();
        }
        if (this.ncN != null) {
            this.ncN.onDestroy();
        }
        try {
            super.onDestroy();
        } catch (Exception e) {
        }
        com.baidu.tbadk.core.e.b.a(null);
        KuangFloatingFrsCopyLinkViewController.getInstance().onDestory();
        this.iHo = getVoiceManager();
        if (this.iHo != null) {
            this.iHo.onDestory(getPageContext());
        }
        if (this.iLI != null) {
            this.iLI.onDestroy();
        }
        if (this.iIe != null) {
            this.iIe.onDestroy();
        }
        if (this.jaw != null) {
            this.jaw.cancelLoadData();
        }
        if (this.moV != null) {
            this.moV.onDestroy();
        }
        if (this.ncG != null && this.ncG.dMo() != null) {
            this.ncG.dMo().onDestory();
        }
        com.baidu.tieba.lc.c.cYA().onDestroy();
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.ndo);
        System.gc();
    }

    private void dMa() {
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

    private void cOm() {
        registerListener(this.ncW);
        this.ndb.setPriority(100);
        registerListener(this.ndb);
        registerListener(this.ndc);
        registerListener(this.ndd);
        registerListener(this.nde);
        registerListener(this.ndk);
        registerListener(this.ndl);
        registerListener(this.nda);
        registerListener(this.skinTypeChangeListener);
        registerListener(this.ncX);
        this.ncH = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.ncH, intentFilter);
        registerListener(this.iIN);
        registerListener(this.ncZ);
        registerListener(this.mSyncFinishListener);
        registerListener(this.euz);
        registerListener(this.ndn);
        this.ncV.setTag(getUniqueId());
        registerListener(this.ncV);
        registerListener(this.ndf);
        registerListener(this.iJe);
        registerListener(this.ncY);
        registerListener(this.mLikeForumListener);
        registerListener(this.ikl);
        registerListener(this.mFG);
        registerListener(this.ndi);
        registerListener(this.ndg);
    }

    private void cOn() {
        if (this.ncH != null) {
            unregisterReceiver(this.ncH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
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
        if (this.iGo) {
            ai.b(this.alP);
            this.iGo = false;
        }
        if (this.ncG != null && this.ncG.dMo() != null) {
            this.ncG.dMo().setLottieView(true);
        }
        if (this.ncG != null && this.ncG.cAl() != null) {
            this.ncB = this.ncG.cAl().getCurrentTabType();
        }
        changeSkinType(this.mSkinType);
        KuangFloatingFrsCopyLinkViewController.getInstance().hideFloatingView(true);
        if (TbadkCoreApplication.isLogin() && n.bCz().bCx()) {
            n.bCz().bCA();
        }
        this.iHo = getVoiceManager();
        if (this.iHo != null) {
            this.iHo.onResume(getPageContext());
        }
        if (this.ncG != null) {
            this.ncG.dMq();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_ON_RESUME, getActivity()));
        if (TbadkCoreApplication.getKeepLiveSwitch(getApplicationContext())) {
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.20
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_KEEPLIVE_START_SERVICE, Boolean.FALSE));
                }
            }, IMConnection.RETRY_DELAY_TIMES);
        }
        n.bCz().bCA();
        if (q.bgM().bgP() != null && q.bgM().bgV() != null && q.bgM().bgP().getCurTaskType() == 6) {
            q.bgM().bgV().complete();
        }
        dLR();
        if (this.ncS.intValue() != 1) {
            dLR();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.ncK = true;
        if (z) {
            com.baidu.tbadk.getUserInfo.b.bAW().bAX();
            dLU();
            dLY();
            dLV();
        }
        this.ncG.switchNaviBarStatus(z);
        this.ncG.dMs();
        deE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogoActivityConfig.isFirst = false;
        if (this.ncA) {
            this.ncA = false;
            CompatibleUtile.setAnim(getPageContext().getPageActivity(), R.anim.down, R.anim.hold);
        }
        this.iHo = getVoiceManager();
        if (this.iHo != null) {
            this.iHo.onPause(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOME_HIDE_GUIDE));
        if (this.ncN != null) {
            this.ncN.cGC();
        }
        KuangFloatingViewController.getInstance().hideFloatingView();
        KuangFloatingFrsCopyLinkViewController.getInstance().hideFloatingView(true);
        dLS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
        } catch (Exception e) {
        }
        bundle.putInt("locate_type", this.ncG.cAl().getCurrentTabType());
        bundle.putParcelable("android:fragments", null);
        bundle.putParcelable("android:support:fragments", null);
        this.iHo = getVoiceManager();
        if (this.iHo != null) {
            this.iHo.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.iHo = getVoiceManager();
        if (this.iHo != null) {
            this.iHo.onStop(getPageContext());
        }
        this.iGo = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        FragmentTabHost.b oQ;
        int i = 2;
        super.onNewIntent(intent);
        setIntent(intent);
        String stringExtra = intent.getStringExtra(MainTabActivityConfig.TARGET_SCHEME);
        if (this.ncU.ak(intent)) {
            this.ncU.a(intent, this.ncG);
        } else {
            ab(intent);
        }
        if (StringUtils.isNull(stringExtra)) {
            com.baidu.tbadk.getUserInfo.b.bAW().bAX();
            if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_RESET_TABS));
                deE();
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
                            i = this.ncL.bHw();
                        }
                    }
                    if (this.ncG != null || this.ncG.cAl() == null) {
                        intExtra = i;
                    } else {
                        this.ncG.setCurrentTabByType(i);
                        intExtra = i;
                    }
                }
                i = intExtra;
                if (this.ncG != null) {
                }
                intExtra = i;
            } else if ((intExtra == 17 || intExtra == 18 || intExtra == 19) && this.ncG != null && this.ncG.cAl() != null) {
                this.ncG.cAl().setCurrentTab(0);
            }
            if (this.ncG != null && this.ncG.cAl() != null && (oQ = this.ncG.cAl().oQ(intExtra)) != null && (oQ.mContentFragment instanceof com.baidu.tbadk.core.g)) {
                ((com.baidu.tbadk.core.g) oQ.mContentFragment).B(intent);
            }
            h(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
            if (this.ncG != null) {
                this.ncG.dMq();
            }
        }
    }

    protected void az(Activity activity) {
        new com.baidu.tbadk.core.dialog.a(activity).ov(R.string.confirm_title).iV(false).ow(R.string.background_process_permission).a(R.string.now_goto_setting, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.22
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
                MainTabActivity.this.dMb();
            }
        }).b(i.I(activity)).bpc();
    }

    protected void dMb() {
        com.baidu.adp.lib.e.c.mS().d(getUniqueId());
        dMd();
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
                    if (this.iLI != null && this.iLI.isShowing()) {
                        this.iLI.ys(true);
                        return true;
                    } else if (this.ncG.deI()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT_CANCEL));
                        return true;
                    } else {
                        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(2921405, Boolean.class, false);
                        if (runTask3 == null || runTask3.getData() == null || !(runTask3.getData() instanceof Boolean) || !((Boolean) runTask3.getData()).booleanValue()) {
                            if (System.currentTimeMillis() - this.ncE > 2000) {
                                showToast(R.string.double_back_quit);
                                this.ncE = System.currentTimeMillis();
                            } else if (UtilHelper.isBackgroundProcessLimitNone() && Build.VERSION.SDK_INT >= 14) {
                                az(getPageContext().getPageActivity());
                                return true;
                            } else {
                                dMb();
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
    public void ai(Intent intent) {
        int bHw;
        if (intent != null && this.ncG != null && this.ncG.cAl() != null) {
            try {
                if (intent.hasExtra("locate_type")) {
                    bHw = intent.getIntExtra("locate_type", 1);
                } else {
                    bHw = this.ncL.bHw();
                }
                this.ncG.cAl().setCurrentTabByType(bHw);
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

    private void deU() {
        registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_TAB_NAVI_EDIT) { // from class: com.baidu.tieba.tblauncher.MainTabActivity.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Integer) {
                    Integer num = (Integer) customResponsedMessage.getData();
                    if (num.intValue() == 2) {
                        MainTabActivity.this.ncG.xE(true);
                        MainTabActivity.this.ncG.tn(true);
                    } else if (num.intValue() == 1) {
                        MainTabActivity.this.ncG.xE(true);
                        MainTabActivity.this.ncG.tn(false);
                    } else {
                        MainTabActivity.this.ncG.xE(false);
                        MainTabActivity.this.ncG.tn(false);
                    }
                    MainTabActivity.this.ncG.dMq();
                }
            }
        });
    }

    protected void dMc() {
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
            if (this.ncG.cAl().getCurrentFragment() != null) {
                this.ncG.cAl().getCurrentFragment().onActivityResult(i, i2, intent);
            }
        } else if (i == 25046) {
            if (TbadkCoreApplication.isLogin()) {
                q.bgM().c(getPageContext());
            }
        } else if (i == 11001) {
            dMc();
        } else if (i == 13003 || i == 25048) {
            aj(intent);
        } else if (i == 23007) {
            S(intent);
        } else if (i == 13011) {
            com.baidu.tieba.o.a.dzT().F(getPageContext());
        } else if (i == 24007) {
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1) {
                com.baidu.tieba.o.a.dzT().F(getPageContext());
                ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                aqVar.al("obj_locate", 5);
                if (shareItem != null) {
                    aqVar.dR("tid", shareItem.tid);
                }
                aqVar.dR("pid", intent.getStringExtra("pid"));
                TiebaStatic.log(aqVar);
                if (shareItem != null && shareItem.linkUrl != null && this.jaw != null) {
                    this.jaw.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.25
                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void bwW() {
                        }

                        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                        public void a(final CustomDialogData customDialogData) {
                            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.25.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.tieba.pb.interactionpopupwindow.c.a(MainTabActivity.this.getPageContext(), customDialogData).show();
                                }
                            }, 1000L);
                        }
                    });
                }
            }
        } else if (this.ncG.cAl().getCurrentFragment() != null) {
            this.ncG.cAl().getCurrentFragment().onActivityResult(i, i2, intent);
        }
    }

    private ShareFromPBMsgData cEd() {
        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.imageUri == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.imageUri.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.fgU);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.fName);
        shareFromPBMsgData.setThreadId(shareItem.tid);
        return shareFromPBMsgData;
    }

    private void S(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(cEd(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.oz(1);
            aVar.bf(thread2GroupShareView);
            aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.tblauncher.MainTabActivity.26
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    MainTabActivity.this.HidenSoftKeyPad((InputMethodManager) MainTabActivity.this.getSystemService("input_method"), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(MainTabActivity.this.getPageContext().getPageActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.bxt() != null) {
                        Bundle bxt = shareItem.bxt();
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).al("obj_source", 1).al("obj_type", bxt.getInt("obj_type")).al("obj_param1", 3).dR("fid", bxt.getString("fid")).dR("tid", bxt.getString("tid")).al("obj_locate", 5));
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
            aVar.iW(true);
            aVar.b(getPageContext()).bpc();
            if (!k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.aP(shareFromPBMsgData.getImageUrl(), false);
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
        this.ncG.onChangeSkinType(i);
        adjustResizeForSoftInputOnSkinTypeChanged(i);
        if (this.iLI != null) {
            this.iLI.onChangeSkinType(i);
        }
    }

    private void aj(Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        if (intent != null) {
            try {
                postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
            } catch (Exception e) {
                BdLog.e(e);
                postWriteCallBackData = null;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PERSONALIZED_MAINTAB_ON_RESULT, postWriteCallBackData));
            if (this.ncG != null && !this.ncG.d(postWriteCallBackData)) {
                this.ncG.b(postWriteCallBackData);
            }
        }
    }

    private void dMd() {
        if (System.currentTimeMillis() - this.ncF >= 7200000) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "start");
            hashMap.put(BdStatsConstant.StatsKey.UNAME, TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_CLEARTEMP, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_START_SYNC, null));
            this.ncF = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.tblauncher.a
    public int getCurrentTabType() {
        if (this.ncG.cAl() != null) {
            return this.ncG.cAl().getCurrentTabType();
        }
        return -1;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.iHo == null) {
            this.iHo = VoiceManager.instance();
        }
        return this.iHo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public ListView bta() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> btb() {
        if (this.eXS == null) {
            this.eXS = UserIconBox.u(getPageContext().getPageActivity(), 8);
        }
        return this.eXS;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cxz() {
        if (this.ncJ == null) {
            this.ncJ = FrsCommonImageLayout.G(getPageContext().getPageActivity(), 12);
        }
        return this.ncJ;
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
                return com.baidu.tbadk.m.e.bCg().getMaxCostFromServer();
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
        if (this.ncK && currentPageSourceKeyList != null) {
            currentPageSourceKeyList.clear();
            this.ncK = false;
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
        if (this.ncG != null && this.ncG.cAl() != null) {
            Fragment currentFragment = this.ncG.cAl().getCurrentFragment();
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
        this.hum = z;
        boolean z2 = this.ncP || this.hum;
        if (this.ncG != null) {
            this.ncG.onKeyboardVisibilityChanged(z2);
        }
    }

    @Override // com.baidu.tbadk.core.util.f.b
    public boolean videoNeedPreload() {
        return ai.rV(1);
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
    public void dMe() {
        String str = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_is_clear_concern_cache_when_version_update") + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + TbConfig.getVersion();
        if (!com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(str, false)) {
            try {
                com.baidu.tbadk.core.c.a.boX().dH("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).setForever("0", null);
                com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(str, true);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
