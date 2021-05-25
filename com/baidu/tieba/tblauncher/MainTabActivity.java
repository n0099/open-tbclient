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
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
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
import com.baidu.sapi2.activity.LoginActivity;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.KuangFloatingViewController;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.InterestGuideActivityConfig;
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
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.ExitAppMessage;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.GameCenterHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.PreLoadImageHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload;
import com.baidu.tbadk.core.util.videoPreload.PreLoadVideoHelper;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.data.UserData;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.switchs.CreateCenterTipSwitch;
import com.baidu.tbadk.switchs.GameEnterSwitch;
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
import com.baidu.tieba.wallet.CurrencySwitchTDouYBeanDialog;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import d.a.m0.a.f;
import d.a.m0.r.q.l1;
import d.a.m0.r.s.a;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;
import protobuf.ConfigVersion;
/* loaded from: classes5.dex */
public class MainTabActivity extends BaseFragmentActivity implements d.a.n0.h3.a, VoiceManager.j, UserIconBox.c, FrsCommonImageLayout.e, IVideoNeedPreload {
    public static final long DOUBLE_BACK_TIME = 2000;
    public static final int FIRST_LIKE_FORUM_ENTERFORUMTAB_TIPS_TIME = 4000;
    public static final String KEY_FROM_TIEBA_KUANG = "from_tieba_kuang";
    public static final String KEY_LOTTIE_SHOW_COUNT = "key_lottie_show_count";
    public static final long MIN_SYNC_INTERVAL = 300000;
    public static final String SCHEME_MAINTAB = "tbmaintab://";
    public static final long SERVICE_BETWEEN_TIME = 7200000;
    public static final long SPAN_TIME = 259200000;
    public static final int TAB_ENTER_FORUM = 1;
    public static final int TAB_ENTER_MY = 4;
    public static final int TAB_ENTER_NEW_CATEGORY = 2;
    public static final long YOUNGSTER_USE_TIME_MAX = 2400000;
    public static final long YOUNGSTER_USE_TIME_PERIOD = 1000;
    public static boolean syncHasFinish;
    public String lastDay;
    public d.a.n0.b mAppEntranceModel;
    public d.a.m0.a.d mBdTokenController;
    public d.a.n0.m3.b mCancelController;
    public d.a.n0.d0.e mCategoryTipController;
    public CheckRealNameModel mCheckRealNameModel;
    public d.a.c.e.k.b<TbImageView> mCommonImagePool;
    public d.a.n0.d0.e mLikeFirstForumTipsController;
    public int mLikeForumNum;
    public d.a.n0.h3.c mMainTabTopicTipController;
    public d.a.n0.d0.e mMyTipController;
    public d.a.n0.h.a mNEGFeedBackManager;
    public d.a.n0.h3.e mPushInsertThreadController;
    public l1 mRecomPostTopic;
    public ShareSuccessReplyToServerModel mShareSuccessReplyToServerModel;
    public boolean mTouchable;
    public d.a.n0.m3.d mUegForwardCheckController;
    public b1 mUpdateReceiver;
    public d.a.c.e.k.b<TbImageView> mUserIconPool;
    public d.a.n0.h3.d mViewController;
    public VoiceManager mVoiceManager;
    public WeakReference<Context> mWeakContext;
    public d.a.n0.w3.f mWriteTab;
    public CurrencySwitchTDouYBeanDialog mYYBeanForceConfirmDialog;
    public FrameLayout rootView;
    public Timer youngsterNightTimer;
    public TimerTask youngsterUseTimeTask;
    public Timer youngsterUseTimer;
    public boolean needAnim = false;
    public int reloginGotoType = -1;
    public boolean isUseCurrType = false;
    public String mFrom = null;
    public volatile boolean mIsAdd = false;
    public long exitTime = 0;
    public long leaveTime = 0;
    public long mLastSyncTime = -1;
    public boolean isAccountStatChanged = false;
    public String mPreUserId = "";
    public boolean isEditorVisible = false;
    public boolean isKeyboardVisible = false;
    public boolean doRefresh = true;
    public Integer mCurrentTabIndex = -1;
    public int lastUiMode = 16;
    public boolean isResumed = false;
    public boolean isCreated = false;
    public boolean isEnterImageViewActivity = false;
    public CustomMessageListener mEditorListener = new k(2010045);
    public final CustomMessageListener mCloseMainTablistener = new v(2001377);
    public final CustomMessageListener skinTypeChangeListener = new g0(2001304);
    public CustomMessageListener bigdayModifyNavbarListener = new r0(2921348);
    public CustomMessageListener showWriteThreadListener = new w0(2921452);
    public CustomMessageListener mLikeForumListener = new x0(2001437);
    public CustomMessageListener mEnterForumTabClickListener = new y0(2001384);
    public final d.a.c.c.g.c mOnlineListener = new z0(1001);
    public CustomMessageListener mJumpPbListener = new a1(2001609);
    public final CustomMessageListener mPersonInfoChangeListener = new a(2001247);
    public CustomMessageListener mShowPostVideoSuccessListener = new b(2001374);
    public final CustomMessageListener mAddTablistener = new c(2007002);
    public final CustomMessageListener mRefreshTablistener = new d(2007013);
    public final CustomMessageListener mRefreshTiplistener = new e(2921333);
    public final CustomMessageListener mForceConfirmListener = new f(2921543);
    public final CustomMessageListener mSetMainTabInstListener = new g(2007005);
    public CustomMessageListener mShowGoBackShouBaiListener = new h(2921380);
    public d.a.c.c.g.a mPersonInfoMsgListener = new n(CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
    public CustomMessageListener updateMainTabProfileListener = new o(2921504);
    public BroadcastReceiver jumpAlaLiveRoomReceiver = new p();
    public CustomMessageListener mCategoryUpdateListener = new q(2921491);
    public CustomMessageListener mMyCreateCenterListener = new r(2921538);
    public CheckRealNameModel.b checkRealNameCallBack = new s();
    public CustomMessageListener networkChangedListener = new t(2000994);
    public CustomMessageListener mAccountChangedListener = new f0(2005016);
    public CustomMessageListener mGameCenterInitListener = new h0(2016509);
    public final CustomMessageListener mGameMsgTipListener = new i0(2001230);
    public CustomMessageListener mSyncFinishListener = new j0(2001371);
    public CustomMessageListener mBackgroundChangeListener = new k0(2001011);
    public CustomMessageListener enterImageViewActivityListener = new l0(2010000);
    public CustomMessageListener youngsterUseTimerListener = new m0(2921561);
    public CustomMessageListener mYoungsterModeChangeListener = new n0(2921509);
    public final CustomMessageListener mToHotTopicListener = new s0(2016493);
    public CustomMessageListener mOnScreenSizeChangeListener = new t0(2921414);
    public Runnable mCheckNewUserRedPackageRunnable = new u0();
    public CustomMessageListener showNewUserRedPackageListener = new v0(2921532);

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            UserData b2 = d.a.m0.z.b.a().b();
            if (TbadkCoreApplication.isLogin() && b2 != null && b2.getUserId() != null && !b2.getUserId().equals(MainTabActivity.this.mPreUserId) && b2.getIsGodInvited()) {
                MainTabActivity.this.mPreUserId = b2.getUserId();
                MainTabActivity.this.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(MainTabActivity.this.getPageContext().getPageActivity(), "", TbWebViewActivityConfig.GOD_INVITE_JUMP_URL + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE, true)));
            }
            if (d.a.m0.r.d0.b.j().g("key_new_god_invited_my_tab_red_tip_showed", false) || !TbadkCoreApplication.isLogin() || b2 == null || b2.getUserId() == null || b2.getUserId().equals(MainTabActivity.this.mPreUserId) || b2.getNewGodData() == null || !b2.getNewGodData().isNewGodInvited()) {
                return;
            }
            d.a.n0.u2.a.v().L(11, true, true);
            TiebaStatic.log(new StatisticItem("c13688").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_locate", 0));
            d.a.m0.r.d0.b.j().t("key_new_god_invited_my_tab_red_tip_showed", true);
        }
    }

    /* loaded from: classes5.dex */
    public class a0 extends CustomMessageListener {
        public a0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof Integer) {
                Integer num = (Integer) customResponsedMessage.getData();
                if (num.intValue() == 2) {
                    MainTabActivity.this.mViewController.Z(true);
                    MainTabActivity.this.mViewController.w(true);
                } else if (num.intValue() == 1) {
                    MainTabActivity.this.mViewController.Z(true);
                    MainTabActivity.this.mViewController.w(false);
                } else {
                    MainTabActivity.this.mViewController.Z(false);
                    MainTabActivity.this.mViewController.w(false);
                }
                MainTabActivity.this.mViewController.N();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a1 extends CustomMessageListener {
        public a1(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.m0.t.i iVar;
            String a2;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.m0.t.i) || (a2 = (iVar = (d.a.m0.t.i) customResponsedMessage.getData()).a()) == null) {
                return;
            }
            try {
                Uri parse = Uri.parse(a2);
                String queryParameter = parse.getQueryParameter("pid");
                String queryParameter2 = parse.getQueryParameter("tid");
                String queryParameter3 = parse.getQueryParameter("threadtype");
                String queryParameter4 = parse.getQueryParameter("jump_type");
                BaijiahaoData baijiahaoData = new BaijiahaoData();
                baijiahaoData.oriUgcNid = parse.getQueryParameter("ori_ugc_nid");
                baijiahaoData.oriUgcTid = parse.getQueryParameter("ori_ugc_tid");
                baijiahaoData.oriUgcType = d.a.c.e.m.b.d(parse.getQueryParameter(TiebaStatic.Params.UGC_TYPE), 0);
                baijiahaoData.oriUgcVid = parse.getQueryParameter("ori_ugc_vid");
                if (!StringUtils.isNull(queryParameter3)) {
                    int d2 = d.a.c.e.m.b.d(queryParameter3, 0);
                    if (iVar.b() != null) {
                        d.a.m0.z0.s.a(queryParameter2, queryParameter, queryParameter4, d2, iVar.b(), baijiahaoData);
                    } else {
                        d.a.m0.z0.s.a(queryParameter2, queryParameter, queryParameter4, d2, MainTabActivity.this.getPageContext(), baijiahaoData);
                    }
                } else {
                    if (StringUtils.isNull(queryParameter2)) {
                        queryParameter2 = "0";
                    }
                    if (iVar.b() != null) {
                        d.a.m0.z0.s.a(queryParameter2, queryParameter, queryParameter4, 0, iVar.b(), baijiahaoData);
                    } else {
                        d.a.m0.z0.s.a(queryParameter2, queryParameter, queryParameter4, 0, MainTabActivity.this.getPageContext(), baijiahaoData);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof PostWriteCallBackData) || ((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                return;
            }
            MainTabActivity.this.mViewController.Y((PostWriteCallBackData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes5.dex */
    public class b0 implements ShareSuccessReplyToServerModel.b {

        /* loaded from: classes5.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f20942e;

            public a(CustomDialogData customDialogData) {
                this.f20942e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.n0.e2.j.c.a(MainTabActivity.this.getPageContext(), this.f20942e).show();
            }
        }

        public b0() {
        }

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void a() {
        }

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void b(CustomDialogData customDialogData) {
            d.a.c.e.m.e.a().postDelayed(new a(customDialogData), 1000L);
        }
    }

    /* loaded from: classes5.dex */
    public class b1 extends BroadcastReceiver {
        public b1() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(TbConfig.getBroadcastActionNewVersion())) {
                TbadkCoreApplication.checkNeedShowNewVersion();
            }
        }

        public /* synthetic */ b1(MainTabActivity mainTabActivity, k kVar) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<d.a.m0.e0.b> c2;
            MainTabActivity.this.mIsAdd = false;
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2007002 || customResponsedMessage.getData() == null || (c2 = ((d.a.m0.e0.d) customResponsedMessage.getData()).c()) == null || c2.size() == 0) {
                return;
            }
            MainTabActivity.this.mViewController.F(c2);
            if (MainTabActivity.this.isUseCurrType) {
                MainTabActivity.this.mViewController.C().setCurrentTabByType(MainTabActivity.this.reloginGotoType);
            } else if (MainTabActivity.this.getActivity().getIntent() != null && MainTabActivity.this.getActivity().getIntent().getDataString() != null && MainTabActivity.this.getActivity().getIntent().getDataString().startsWith(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
                MainTabActivity.this.mViewController.C().setCurrentTabByType(2);
            } else {
                MainTabActivity mainTabActivity = MainTabActivity.this;
                mainTabActivity.setupIntent(mainTabActivity.getIntent());
            }
            MainTabActivity.this.isUseCurrType = false;
            MainTabActivity.this.mViewController.Q();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921543, null));
        }
    }

    /* loaded from: classes5.dex */
    public class c0 implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f20945e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f20946f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f20947g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f20948h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f20949i;
        public final /* synthetic */ ShareFromPBMsgData j;

        public c0(Thread2GroupShareView thread2GroupShareView, long j, String str, String str2, String str3, ShareFromPBMsgData shareFromPBMsgData) {
            this.f20945e = thread2GroupShareView;
            this.f20946f = j;
            this.f20947g = str;
            this.f20948h = str2;
            this.f20949i = str3;
            this.j = shareFromPBMsgData;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            MainTabActivity.this.HidenSoftKeyPad((InputMethodManager) MainTabActivity.this.getSystemService("input_method"), this.f20945e.getChatMsgView());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(MainTabActivity.this.getPageContext().getPageActivity(), this.f20946f, this.f20947g, this.f20948h, this.f20949i, 0, this.f20945e.getLeaveMsg(), this.j.toChatMessageContent())));
            aVar.dismiss();
            ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
            if (shareItem == null || shareItem.e() == null) {
                return;
            }
            Bundle e2 = shareItem.e();
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 1).param("obj_type", e2.getInt("obj_type")).param("obj_param1", 3).param("fid", e2.getString("fid")).param("tid", e2.getString("tid")).param("obj_locate", 5));
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007013) {
                MainTabActivity.this.initTabsOnActivityCreated();
                if (MainTabActivity.this.mViewController != null && MainTabActivity.this.mViewController.C() != null) {
                    MainTabActivity mainTabActivity = MainTabActivity.this;
                    mainTabActivity.reloginGotoType = mainTabActivity.mViewController.C().getCurrentTabType();
                }
                MainTabActivity.this.isUseCurrType = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d0 implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f20951e;

        public d0(Thread2GroupShareView thread2GroupShareView) {
            this.f20951e = thread2GroupShareView;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            MainTabActivity.this.HidenSoftKeyPad((InputMethodManager) MainTabActivity.this.getSystemService("input_method"), this.f20951e.getChatMsgView());
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            if (MainTabActivity.this.mRecomPostTopic != null || (customResponsedMessage.getData() instanceof l1)) {
                if (customResponsedMessage.getData() != null) {
                    MainTabActivity.this.mRecomPostTopic = (l1) customResponsedMessage.getData();
                }
                if (MainTabActivity.this.mIsAdd || MainTabActivity.this.mRecomPostTopic == null || !TbadkCoreApplication.isLogin()) {
                    return;
                }
                MainTabActivity.this.mMainTabTopicTipController.j(MainTabActivity.this.mRecomPostTopic.f50075a, MainTabActivity.this.mRecomPostTopic.f50076b, MainTabActivity.this.mRecomPostTopic.f50077c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e0 extends d.a.m0.k0.b {
        public e0() {
        }

        @Override // d.a.m0.k0.b
        public boolean canStat(d.a.m0.k0.d dVar) {
            return false;
        }

        @Override // d.a.m0.k0.b
        public int getMaxCost() {
            return d.a.m0.k0.e.b().c();
        }

        @Override // d.a.m0.k0.b
        public boolean isCurrentPageCanBeAddToSourceTrace() {
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public f(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            MainTabActivity.this.dealForceConfirmSwitchTDouToYBean();
        }
    }

    /* loaded from: classes5.dex */
    public class f0 extends CustomMessageListener {
        public f0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016) {
                return;
            }
            MainTabActivity.this.isAccountStatChanged = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            d.a.m0.r.d0.b.j().C("key_feedback_tip");
            d.a.m0.r.d0.b.j().C("key_feedback_tip_show");
            d.a.m0.r.d0.b.j().C("key_feedback_tip_tab_show");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016560));
            if (MainTabActivity.this.mBdTokenController != null) {
                MainTabActivity.this.mBdTokenController.l(UtilHelper.getClipBoardContent());
            }
            if (MainTabActivity.this.mViewController != null) {
                MainTabActivity.this.mViewController.G();
            }
            MainTabActivity.this.clearConcernCacheWhenVersionUpdate();
            MainTabActivity.this.checkCommitInterestInfo();
        }
    }

    /* loaded from: classes5.dex */
    public class g extends CustomMessageListener {
        public g(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && d.a.m0.r.a0.b.b() == null) {
                d.a.n0.h3.b bVar = new d.a.n0.h3.b();
                bVar.g(MainTabActivity.this);
                d.a.m0.r.a0.b.h(bVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g0 extends CustomMessageListener {
        public g0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            int oldSkinType = TbadkCoreApplication.getInst().getOldSkinType();
            boolean z = false;
            if ((intValue == 2 || oldSkinType == 2) ? false : true) {
                return;
            }
            if ((intValue == 3 || intValue == 1 || intValue == 0) && oldSkinType == 2) {
                z = true;
            }
            if (z) {
                MainTabActivity.this.mViewController.C().d(1);
            } else if (TbadkCoreApplication.getInst().isThemeIconCover()) {
                MainTabActivity.this.mViewController.C().d(2);
            } else {
                MainTabActivity.this.mViewController.C().d(1);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends CustomMessageListener {

        /* loaded from: classes5.dex */
        public class a implements d.a.m0.r.e {
            public a(h hVar) {
            }

            @Override // d.a.m0.r.e
            public void onPermissionResult(boolean z) {
                if (z) {
                    KuangFloatingViewController.getInstance().showFloatingView();
                    TiebaStatic.log(new StatisticItem("c12264").param("obj_type", 3));
                }
            }
        }

        public h(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || d.a.c.e.p.k.isEmpty((String) customResponsedMessage.getData())) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (KuangFloatingViewController.getInstance().init()) {
                KuangFloatingViewController.getInstance().setInfo(str);
                MainTabActivity.this.getPageContext().getOrignalPage().grantWindowPermission(new a(this), false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h0 extends CustomMessageListener {
        public h0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            GameCenterHelper.isGamePluginInit = ((Boolean) customResponsedMessage.getData()).booleanValue();
            MainTabActivity.this.checkPluginEntranceState();
        }
    }

    /* loaded from: classes5.dex */
    public class i extends d.a.m0.z0.f0<Object> {
        public i() {
        }

        @Override // d.a.m0.z0.f0
        public Object doInBackground() {
            TbadkCoreApplication.getInst().setUsed();
            return null;
        }
    }

    /* loaded from: classes5.dex */
    public class i0 extends CustomMessageListener {
        public i0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                d.a.m0.r.d0.b.j().t("game_is_show_tip", booleanValue);
                MainTabActivity.this.mViewController.W(booleanValue);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainTabActivity.this.mTouchable = true;
        }
    }

    /* loaded from: classes5.dex */
    public class j0 extends CustomMessageListener {
        public j0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2001371) {
                return;
            }
            boolean unused = MainTabActivity.syncHasFinish = true;
            TbadkCoreApplication.getInst().syncHasFinish = true;
            if (MainTabActivity.this.mViewController != null && MainTabActivity.this.mViewController.B() != null && MainTabActivity.this.mViewController.B().getAnimationView() != null && MainTabActivity.this.mViewController.B().getAnimationView().getVisibility() != 0) {
                MainTabActivity.this.mViewController.B().setLottieView(false);
            }
            if (!TbadkCoreApplication.getInst().getActivityPrizeData().g()) {
                if (MainTabActivity.this.mViewController != null) {
                    MainTabActivity.this.mViewController.S(null);
                }
            } else {
                if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getInst().getActivityPrizeData().h()) {
                    String c2 = TbadkCoreApplication.getInst().getActivityPrizeData().c();
                    if (!StringUtils.isNull(c2)) {
                        d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
                        if (j.g("activity_prize_get_tip" + TbadkCoreApplication.getCurrentAccount(), true)) {
                            UrlManager.getInstance().dealOneLink((TbPageContext<?>) MainTabActivity.this.getPageContext(), new String[]{c2}, true);
                            d.a.m0.r.d0.b j2 = d.a.m0.r.d0.b.j();
                            j2.t("activity_prize_get_tip" + TbadkCoreApplication.getCurrentAccount(), false);
                        }
                    }
                }
                if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    if (MainTabActivity.this.mViewController != null) {
                        MainTabActivity.this.mViewController.S(null);
                    }
                } else {
                    String d2 = TbadkCoreApplication.getInst().getActivityPrizeData().d();
                    if (!StringUtils.isNull(d2)) {
                        if (MainTabActivity.this.mViewController != null) {
                            MainTabActivity.this.mViewController.S(d2);
                        }
                    } else if (MainTabActivity.this.mViewController != null) {
                        MainTabActivity.this.mViewController.S(null);
                    }
                }
            }
            if (TbSingleton.getInstance().canShowPermDialog()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921360, MainTabActivity.this));
            }
            d.a.m0.r.o.a.b().l("1", "");
            MainTabActivity.this.firstLoginTest();
            MainTabActivity.this.dealForceConfirmSwitchTDouToYBean();
            MainTabActivity.this.checkCreateCenterTip();
        }
    }

    /* loaded from: classes5.dex */
    public class k extends CustomMessageListener {
        public k(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || MainTabActivity.this.mViewController == null) {
                return;
            }
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            MainTabActivity mainTabActivity = MainTabActivity.this;
            if (currentActivity == mainTabActivity) {
                boolean z = false;
                mainTabActivity.isEditorVisible = d.a.c.e.m.b.a(customResponsedMessage.getData().toString(), false);
                MainTabActivity mainTabActivity2 = MainTabActivity.this;
                MainTabActivity.this.mViewController.L((mainTabActivity2.isEditorVisible || mainTabActivity2.isKeyboardVisible) ? true : true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k0 extends CustomMessageListener {
        public k0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            boolean z = false;
            if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                d.a.c.g.c.d();
                d.a.c.g.c.j();
                MainTabActivity.this.lastDay = UtilHelper.getCurrentDay();
                d.a.m0.r.d0.b.j().w("last_resume_time", TbSingleton.getInstance().getLastResumeTime());
                if (!MainTabActivity.this.isEnterImageViewActivity) {
                    MainTabActivity.this.stopYoungsterUseTimeTask();
                    return;
                } else {
                    MainTabActivity.this.isEnterImageViewActivity = false;
                    return;
                }
            }
            String currentDay = UtilHelper.getCurrentDay();
            if (!StringUtils.isNull(currentDay) && !currentDay.equals(MainTabActivity.this.lastDay)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            }
            if (MainTabActivity.this.mCancelController == null) {
                MainTabActivity.this.mCancelController = new d.a.n0.m3.b();
            }
            MainTabActivity.this.mCancelController.c(MainTabActivity.this.mCancelController.f57465c);
            MainTabActivity.this.mCancelController.f57465c = TbadkCoreStatisticKey.AntiLocateValue.LOCATE_HOT_BOOT;
            if (d.a.m0.c1.b.e.d()) {
                int i2 = Calendar.getInstance().get(11);
                d.a.m0.c1.b.e.f49258a = (i2 >= 23 || i2 < 7) ? true : true;
                MainTabActivity.this.stopYoungsterUseTimeTask();
                MainTabActivity.this.startYoungsterUseTimeTask();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.j.a.a();
        }
    }

    /* loaded from: classes5.dex */
    public class l0 extends CustomMessageListener {
        public l0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            MainTabActivity.this.isEnterImageViewActivity = true;
        }
    }

    /* loaded from: classes5.dex */
    public class m implements Runnable {

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public a(m mVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.c.g.c.b();
            }
        }

        public m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TbadkCoreApplication.getInst().isMainProcess(false)) {
                new Thread(new a(this)).start();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m0 extends CustomMessageListener {
        public m0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer ? ((Integer) data).intValue() : 0) == 6) {
                MainTabActivity.this.stopYoungsterUseTimeTask();
                MainTabActivity.this.startYoungsterUseTimeTask();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n extends d.a.c.c.g.a {
        public n(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = responsedMessage instanceof ProfileSocketResponseMessage;
            if (z || (responsedMessage instanceof ProfileHttpResponseMessage)) {
                if (responsedMessage.getOrginalMessage() != null) {
                    MainTabActivity.this.getUniqueId();
                }
                if (z) {
                    MainTabActivity.this.onResponseMessage((ProfileSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof ProfileHttpResponseMessage) {
                    MainTabActivity.this.onResponseMessage((ProfileHttpResponseMessage) responsedMessage);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n0 extends CustomMessageListener {
        public n0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            MainTabActivity.this.stopYoungsterUseTimeTask();
            if (booleanValue) {
                if (!MainTabActivity.this.handlerYoungsterNightTask()) {
                    MainTabActivity.this.startYoungsterUseTimeTask();
                }
                d.a.m0.c1.b.d.d(MainTabActivity.this, null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o extends CustomMessageListener {
        public o(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            MainTabActivity.this.updateProfileInfo();
        }
    }

    /* loaded from: classes5.dex */
    public class o0 extends TimerTask {
        public o0() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            d.a.m0.c1.b.e.f49258a = true;
            MainTabActivity.this.stopYoungsterUseTimeTask();
            MainTabActivity.this.startYoungsterUseTimePeriodTask();
            MainTabActivity.this.youngsterNightTimer.cancel();
            MainTabActivity.this.youngsterNightTimer = null;
        }
    }

    /* loaded from: classes5.dex */
    public class p extends BroadcastReceiver {
        public p() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Bundle bundleExtra;
            if (intent == null || (bundleExtra = intent.getBundleExtra(AlaLiveRoomActivityConfig.JUMP_ALA_LIVE_ROOM_DATA)) == null || !TbadkCoreApplication.getInst().isMainProcess(false)) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(context, (AlaLiveInfoCoreData) bundleExtra.getSerializable(AlaLiveRoomActivityConfig.JUMP_ALA_LIVE_ROOM_DATA_CORE), bundleExtra.getString(AlaLiveRoomActivityConfig.JUMP_ALA_LIVE_ROOM_DATA_FROM), null, bundleExtra.getBoolean(AlaLiveRoomActivityConfig.JUMP_ALA_LIVE_ROOM_DATA_HOST), "")));
        }
    }

    /* loaded from: classes5.dex */
    public class p0 extends TimerTask {

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainTabActivity.this.stopYoungsterUseTimeTask();
                if (d.a.m0.c1.b.d.f()) {
                    return;
                }
                MainTabActivity.this.startYoungsterUseTimePeriodTask();
            }
        }

        public p0() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            d.a.c.e.m.e.a().post(new a());
        }
    }

    /* loaded from: classes5.dex */
    public class q extends CustomMessageListener {
        public q(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || MainTabActivity.this.mViewController == null || MainTabActivity.this.mViewController.C() == null || MainTabActivity.this.mViewController.C().getCurrentTabType() == 21) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = MainTabActivity.this.mViewController.C().getFragmentTabWidget();
            if (fragmentTabWidget.getChildCount() < 2) {
                return;
            }
            MainTabActivity mainTabActivity = MainTabActivity.this;
            mainTabActivity.mCategoryTipController = new d.a.n0.d0.e(mainTabActivity.getPageContext(), fragmentTabWidget.getChildAt(2));
            MainTabActivity.this.mCategoryTipController.g0(R.drawable.bg_tip_blue_down);
            MainTabActivity.this.mCategoryTipController.L(2);
            MainTabActivity.this.mCategoryTipController.O(32);
            MainTabActivity.this.mCategoryTipController.h0(true);
            MainTabActivity.this.mCategoryTipController.k0(-d.a.c.e.p.l.g(MainTabActivity.this, R.dimen.tbds10));
            MainTabActivity.this.mCategoryTipController.X(R.color.CAM_X0101);
            MainTabActivity.this.mCategoryTipController.P(R.dimen.tbds54);
            MainTabActivity.this.mCategoryTipController.T(999);
            MainTabActivity.this.mCategoryTipController.N(5000);
            MainTabActivity.this.mCategoryTipController.a0(d.a.c.e.p.l.g(MainTabActivity.this, R.dimen.tbds44));
            MainTabActivity.this.mCategoryTipController.o0(str, "categoryUpdate", false, true);
        }
    }

    /* loaded from: classes5.dex */
    public class q0 extends TimerTask {

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (d.a.m0.c1.b.d.f()) {
                    MainTabActivity.this.stopYoungsterUseTimeTask();
                }
            }
        }

        public q0() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            d.a.c.e.m.e.a().post(new a());
        }
    }

    /* loaded from: classes5.dex */
    public class r extends CustomMessageListener {
        public r(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || MainTabActivity.this.mViewController == null || MainTabActivity.this.mViewController.C() == null || MainTabActivity.this.mViewController.C().getCurrentTabType() == 8) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = MainTabActivity.this.mViewController.C().getFragmentTabWidget();
            if (fragmentTabWidget.getChildCount() < 4) {
                return;
            }
            String string = MainTabActivity.this.getString(R.string.my_create_center_tips);
            MainTabActivity mainTabActivity = MainTabActivity.this;
            mainTabActivity.mMyTipController = new d.a.n0.d0.e(mainTabActivity.getPageContext(), fragmentTabWidget.getChildAt(4));
            MainTabActivity.this.mMyTipController.g0(R.drawable.bg_tip_blue_dropdown_right);
            MainTabActivity.this.mMyTipController.L(2);
            MainTabActivity.this.mMyTipController.O(48);
            MainTabActivity.this.mMyTipController.h0(true);
            MainTabActivity.this.mMyTipController.j0(-d.a.c.e.p.l.g(MainTabActivity.this, R.dimen.tbds62));
            MainTabActivity.this.mMyTipController.X(R.color.CAM_X0101);
            MainTabActivity.this.mMyTipController.e0(R.dimen.T_X08);
            MainTabActivity.this.mMyTipController.T(1);
            MainTabActivity.this.mMyTipController.N(3000);
            MainTabActivity.this.mMyTipController.d0(d.a.c.e.p.l.g(MainTabActivity.this, R.dimen.tbds25));
            MainTabActivity.this.mMyTipController.a0(d.a.c.e.p.l.g(MainTabActivity.this, R.dimen.tbds33));
            MainTabActivity.this.mMyTipController.b0(d.a.c.e.p.l.g(MainTabActivity.this, R.dimen.tbds36));
            MainTabActivity.this.mMyTipController.c0(d.a.c.e.p.l.g(MainTabActivity.this, R.dimen.tbds36));
            MainTabActivity.this.mMyTipController.o0(string, "mycreatecentertip", true, true);
        }
    }

    /* loaded from: classes5.dex */
    public class r0 extends CustomMessageListener {
        public r0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean) || MainTabActivity.this.mViewController == null || MainTabActivity.this.mViewController.C() == null) {
                return;
            }
            if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                MainTabActivity.this.mViewController.C().getTabWrapper().animate().translationY(MainTabActivity.this.mViewController.C().getTabWrapper().getHeight()).setDuration(200L).start();
            } else {
                MainTabActivity.this.mViewController.C().getTabWrapper().animate().translationY(0.0f).setDuration(400L).start();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s implements CheckRealNameModel.b {
        public s() {
        }

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i2, String str, String str2, Object obj) {
            if (CheckRealNameModel.TYPE_APP_FIRST_START.equals(str2) && i2 == 1990055) {
                TiebaStatic.log("c12138");
                MainTabActivity.this.mViewController.U(MainTabActivity.this.getResources().getString(R.string.check_real_name_message));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s0 extends CustomMessageListener {
        public s0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.m0.t.m mVar;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.m0.t.m) || (mVar = (d.a.m0.t.m) customResponsedMessage.getData()) == null || StringUtils.isNull(mVar.f50797a)) {
                return;
            }
            d.a.m0.p0.b.i(mVar);
            if (StringUtils.isNull(mVar.f50799c)) {
                UrlManager.getInstance().dealOneLink(MainTabActivity.this.getPageContext(), new String[]{mVar.f50797a});
            } else {
                UrlManager.getInstance().dealOneLink(MainTabActivity.this.getPageContext(), new String[]{mVar.f50797a, mVar.f50799c});
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t extends CustomMessageListener {
        public t(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && d.a.c.e.p.l.D()) {
                MainTabActivity.this.checkRealName();
                if (MainTabActivity.syncHasFinish) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t0 extends CustomMessageListener {
        public t0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (MainTabActivity.this.mWriteTab != null) {
                MainTabActivity.this.mWriteTab.x();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u implements f.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Intent f20986a;

        public u(Intent intent) {
            this.f20986a = intent;
        }

        @Override // d.a.m0.a.f.b
        public void onCallBack(HashMap<String, Object> hashMap) {
            if (hashMap == null || this.f20986a == null) {
                return;
            }
            Object obj = hashMap.get(d.a.m0.a.f.A);
            int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : -1;
            Object obj2 = hashMap.get(d.a.m0.a.f.B);
            String str = obj2 instanceof String ? (String) obj2 : null;
            Object obj3 = hashMap.get(d.a.m0.a.f.z);
            String str2 = obj3 instanceof String ? (String) obj3 : null;
            if (intValue != -1) {
                this.f20986a.putExtra("is_from_scheme", true);
                this.f20986a.putExtra("locate_type", intValue);
                this.f20986a.putExtra("sub_locate_type", str);
                this.f20986a.putExtra("sub_tab_name", str2);
                d.a.m0.r.a0.b.f49636b = intValue;
                Object obj4 = hashMap.get(d.a.m0.a.f.C);
                String str3 = obj4 instanceof String ? (String) obj4 : null;
                Object obj5 = hashMap.get(d.a.m0.a.f.D);
                String str4 = obj5 instanceof String ? (String) obj5 : null;
                this.f20986a.putExtra(d.a.m0.a.f.C, str3);
                this.f20986a.putExtra(d.a.m0.a.f.D, str4);
            }
            d.a.m0.a.c.y().L(true);
            if (intValue == 1 && "ForumSquare".equals(str)) {
                d.a.m0.r.a0.b.f49637c = d.a.m0.r.a0.b.f49639e;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921528));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u0 implements Runnable {
        public u0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TbSingleton.getInstance().getNewUserRedPackageData() != null) {
                TbSingleton.getInstance().setNewUserRedPackageShowed(true);
                MainTabActivity.this.sendMessage(new CustomMessage(2002001, new NewUserRedPackageActivityConfig(MainTabActivity.this, TbSingleton.getInstance().getNewUserRedPackageData())));
                TbSingleton.getInstance().setNewUserRedPackageData(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v extends CustomMessageListener {
        public v(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001377) {
                MainTabActivity.this.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v0 extends CustomMessageListener {
        public v0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbSingleton.getInstance().isNewUserRedPackageShowed() && MainTabActivity.this.isResumed && TbSingleton.getInstance().hasPerformedFirstLoginTest()) {
                d.a.c.e.m.e.a().removeCallbacks(MainTabActivity.this.mCheckNewUserRedPackageRunnable);
                d.a.c.e.m.e.a().postDelayed(MainTabActivity.this.mCheckNewUserRedPackageRunnable, 200L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f20991e;

        public w(String str) {
            this.f20991e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            UrlManager.getInstance().dealOneLink(MainTabActivity.this.getPageContext(), new String[]{this.f20991e});
        }
    }

    /* loaded from: classes5.dex */
    public class w0 extends CustomMessageListener {
        public w0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.m0.t.k) && ViewHelper.checkUpIsLogin(MainTabActivity.this.getPageContext().getPageActivity())) {
                MainTabActivity.this.showWriteThreadView();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x implements Runnable {
        public x() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921300, Boolean.FALSE));
        }
    }

    /* loaded from: classes5.dex */
    public class x0 extends CustomMessageListener {
        public x0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.n0.e3.q0.e) && ((d.a.n0.e3.q0.e) customResponsedMessage.getData()).f54224b && MainTabActivity.this.mLikeForumNum == 0) {
                MainTabActivity.this.createLikeFirstForumTips();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y implements a.e {
        public y() {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            aVar.dismiss();
            MainTabActivity.this.processBeforeGoBack();
        }
    }

    /* loaded from: classes5.dex */
    public class y0 extends CustomMessageListener {
        public y0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            int intValue = MainTabActivity.this.mCurrentTabIndex.intValue();
            MainTabActivity.this.mCurrentTabIndex = (Integer) customResponsedMessage.getData();
            if (MainTabActivity.this.mCurrentTabIndex.intValue() == 1) {
                MainTabActivity.this.clearLikeFirstForumTips();
            } else if (intValue == 1) {
                MainTabActivity.this.showLikeFirstForumTips();
            }
            if (MainTabActivity.this.mCurrentTabIndex.intValue() == 2) {
                MainTabActivity.this.clearNewCategoryTips();
            }
            if (MainTabActivity.this.mCurrentTabIndex.intValue() == 4) {
                MainTabActivity.this.clearMyCreateCenterTips();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z implements a.e {
        public z() {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            try {
                MainTabActivity.this.startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
                aVar.dismiss();
            } catch (Exception unused) {
                MainTabActivity.this.showToast(R.string.goto_developActivity_error_toast);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z0 extends d.a.c.c.g.c {
        public z0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ConfigVersion configVersion;
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                if (socketResponsedMessage.getError() != 0 || (configVersion = responseOnlineMessage.getConfigVersion()) == null) {
                    return;
                }
                MainTabActivity.this.checkVersion(configVersion.sync);
            }
        }
    }

    private void callWindowMissed() {
        InputMethodManager inputMethodManager;
        View currentFocus = getCurrentFocus();
        if (currentFocus == null || currentFocus.getWindowToken() == null || (inputMethodManager = (InputMethodManager) getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        Method method = null;
        try {
            method = InputMethodManager.class.getDeclaredMethod("windowDismissed", IBinder.class);
        } catch (NoSuchMethodException | SecurityException unused) {
        }
        if (method == null || currentFocus == null) {
            return;
        }
        method.setAccessible(true);
        try {
            method.invoke(inputMethodManager, currentFocus.getWindowToken());
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
        }
    }

    private void checkAndShowLikeFirstForumTips() {
        if (this.mLikeForumNum == 1) {
            createLikeFirstForumTips();
            if (TbadkCoreApplication.getInst().getCurrentActivity() != this || this.mCurrentTabIndex.intValue() == 1) {
                return;
            }
            showLikeFirstForumTips();
        }
    }

    private boolean checkAutoSyncInterval() {
        if (-1 == this.mLastSyncTime) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.mLastSyncTime;
        return currentTimeMillis <= 0 || currentTimeMillis >= 300000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkCommitInterestInfo() {
        String p2 = d.a.m0.r.d0.b.j().p("user_interest_info", null);
        if (TextUtils.isEmpty(p2)) {
            return;
        }
        d.a.m0.r.d0.b.j().C("user_interest_info");
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GUIDE_INTEREST_COMMIT);
        httpMessage.addParam("interestList", p2);
        httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkCreateCenterTip() {
        if (CreateCenterTipSwitch.isOn()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921538));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPluginEntranceState() {
        if (SwitchManager.getInstance().findType(GameEnterSwitch.GAME_ENTER_KEY) == 1 && GameCenterHelper.isGamePluginInit) {
            this.mViewController.V(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016510));
            return;
        }
        this.mViewController.V(false);
        this.mViewController.W(false);
        d.a.m0.r.d0.b.j().t("game_is_show_tip", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkRealName() {
        String str = "check_real_name" + TbConfig.getVersion();
        if (d.a.m0.r.d0.b.j().g(str, true) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && d.a.c.e.p.l.D()) {
            this.mCheckRealNameModel.t(CheckRealNameModel.TYPE_APP_FIRST_START);
            d.a.m0.r.d0.b.j().t(str, false);
        }
    }

    private void checkSchemeFromIntent(Intent intent) {
        if (intent == null) {
            return;
        }
        String dataString = intent.getDataString();
        UtilHelper.clearClipBoardBySchemaParam(dataString);
        if (!StringUtils.isNull(dataString) && dataString.startsWith(SCHEME_MAINTAB)) {
            String decode = Uri.decode(intent.getData().getEncodedPath());
            if (StringUtils.isNull(decode)) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_type", 1).param(TiebaStatic.Params.OBJ_TO, 1).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
                d.a.m0.a.w.a(param, decode);
                TiebaStatic.log(param);
                return;
            }
            if (decode.startsWith("//")) {
                decode = decode.substring(2);
            }
            Map<String, String> paramPair = UrlManager.getParamPair(decode);
            if (paramPair == null) {
                return;
            }
            String str = paramPair.get("fr");
            if (!"mpush".equals(str) && "bpush".equals(str)) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE);
                d.a.m0.a.w.b(statisticItem, paramPair);
                statisticItem.param("obj_locate", paramPair.get("obj_locate"));
                statisticItem.param("obj_type", 1);
                statisticItem.param("obj_source", paramPair.get("obj_source"));
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, paramPair.get(TiebaStatic.Params.OBJ_PARAM2));
                statisticItem.param(TiebaStatic.Params.OBJ_TO, 1);
                statisticItem.param("obj_id", paramPair.get("bdid"));
                statisticItem.param("obj_name", TbadkCoreApplication.getInst().getStartType());
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, 1);
                if (!d.a.c.e.p.k.isEmpty(paramPair.get("ext_log"))) {
                    try {
                        JSONObject jSONObject = new JSONObject(paramPair.get("ext_log"));
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            statisticItem.param(next, jSONObject.getString(next));
                        }
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
                TiebaStatic.log(statisticItem);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SCHEMA_UPLOAD);
                httpMessage.addParam("call_url", dataString);
                MessageManager.getInstance().sendMessage(httpMessage);
            }
            d.a.m0.a.c.y().L(true);
        } else if (!StringUtils.isNull(dataString) && (dataString.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT) || dataString.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT_ZM) || dataString.startsWith(UrlSchemaHelper.SCHEMA_LIVE_SDK) || dataString.startsWith(UrlSchemaHelper.SCHEMA_CHUSHOU_LIVE_SDK))) {
            String dataString2 = intent.getDataString();
            if (!StringUtils.isNull(dataString2) && PermissionUtil.isAgreePrivacyPolicy()) {
                UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{dataString2});
                d.a.m0.a.c.y().L(true);
            }
        } else if (!StringUtils.isNULL(dataString) && dataString.startsWith(d.a.m0.a.f.f48709a)) {
            d.a.m0.a.f.b().e(intent.getData(), new u(intent));
        }
        String stringExtra = intent.getStringExtra(MainTabActivityConfig.TARGET_SCHEME);
        if (StringUtils.isNull(stringExtra)) {
            return;
        }
        d.a.c.e.m.e.a().postDelayed(new w(stringExtra), this.isCreated ? 0L : DeviceInfoUtil.getMainTabActJumpOtherDelayTime());
        getIntent().removeExtra(MainTabActivityConfig.TARGET_SCHEME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkVersion(String str) {
        if (str == null || TbadkCoreApplication.getInst().getConfigVersion() == null || !checkAutoSyncInterval()) {
            return;
        }
        this.mLastSyncTime = System.currentTimeMillis();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearConcernCacheWhenVersionUpdate() {
        String str = d.a.m0.r.d0.b.n("key_is_clear_concern_cache_when_version_update") + "_" + TbConfig.getVersion();
        if (d.a.m0.r.d0.b.j().g(str, false)) {
            return;
        }
        try {
            d.a.m0.r.r.a.f().e("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).g("0", null);
            d.a.m0.r.d0.b.j().t(str, true);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLikeFirstForumTips() {
        d.a.n0.d0.e eVar = this.mLikeFirstForumTipsController;
        if (eVar == null || !eVar.J()) {
            return;
        }
        this.mLikeFirstForumTipsController.I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createLikeFirstForumTips() {
        FragmentTabWidget fragmentTabWidget = this.mViewController.C().getFragmentTabWidget();
        if (fragmentTabWidget.getChildCount() < 2) {
            return;
        }
        d.a.n0.d0.e eVar = new d.a.n0.d0.e(getPageContext(), fragmentTabWidget.getChildAt(1));
        this.mLikeFirstForumTipsController = eVar;
        eVar.g0(R.drawable.bg_tip_blue_down);
        this.mLikeFirstForumTipsController.L(2);
        this.mLikeFirstForumTipsController.O(32);
        this.mLikeFirstForumTipsController.h0(true);
        this.mLikeFirstForumTipsController.k0(-d.a.c.e.p.l.g(this, R.dimen.tbds10));
        this.mLikeFirstForumTipsController.X(R.color.CAM_X0101);
        this.mLikeFirstForumTipsController.P(R.dimen.tbds54);
        this.mLikeFirstForumTipsController.T(1);
        this.mLikeFirstForumTipsController.N(4000);
        this.mLikeFirstForumTipsController.a0(d.a.c.e.p.l.g(this, R.dimen.tbds44));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealForceConfirmSwitchTDouToYBean() {
        if (!this.mIsAdd && this.mYYBeanForceConfirmDialog == null && TbadkCoreApplication.isLogin() && CurrencySwitchUtil.isNeedConfirmTDouToYBeanSwitchOpen()) {
            CurrencySwitchTDouYBeanDialog currencySwitchTDouYBeanDialog = new CurrencySwitchTDouYBeanDialog(getPageContext());
            this.mYYBeanForceConfirmDialog = currencySwitchTDouYBeanDialog;
            currencySwitchTDouYBeanDialog.showDialog();
        }
    }

    private void dealIntent(Context context, Intent intent) {
        UtilHelper.commenDealIntent(context, intent);
        TbadkCoreApplication.setIntent(null);
    }

    private void dispatchWriteCallbakcData(Intent intent) {
        if (intent != null) {
            PostWriteCallBackData postWriteCallBackData = null;
            try {
                postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921030, postWriteCallBackData));
            d.a.n0.h3.d dVar = this.mViewController;
            if (dVar == null || dVar.x(postWriteCallBackData)) {
                return;
            }
            this.mViewController.a0(postWriteCallBackData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void firstLoginTest() {
        if (TbSingleton.getInstance().hasPerformedFirstLoginTest()) {
            return;
        }
        TbSingleton.getInstance().setHasPerformedFirstLoginTest(true);
        if (d.a.m0.b.d.k()) {
            if (TbadkCoreApplication.isLogin() || LoginActivity.class.getName().equals(d.a.c.e.p.l.v())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2921535, this));
        } else if (d.a.m0.b.d.l()) {
            if (TbadkApplication.getInst().isNeedNewUserLead()) {
                InterestGuideActivityConfig interestGuideActivityConfig = new InterestGuideActivityConfig(this, 1);
                interestGuideActivityConfig.setRequestCode(25060);
                interestGuideActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, interestGuideActivityConfig));
            }
        } else if (TbadkApplication.getInst().isNeedNewUserLead()) {
            InterestGuideActivityConfig interestGuideActivityConfig2 = new InterestGuideActivityConfig(this, 1);
            interestGuideActivityConfig2.setRequestCode(25060);
            interestGuideActivityConfig2.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, interestGuideActivityConfig2));
        }
    }

    private ShareFromPBMsgData getShareMsgData() {
        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        Uri uri = shareItem.v;
        String uri2 = uri == null ? "https://tb5.bdstatic.com/yunying/tieba_logo.jpg" : uri.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.r);
        shareFromPBMsgData.setContent(shareItem.D);
        shareFromPBMsgData.setImageUrl(uri2);
        shareFromPBMsgData.setForumName(shareItem.p);
        shareFromPBMsgData.setThreadId(shareItem.K);
        return shareFromPBMsgData;
    }

    private void handleShareFriendForum(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        showConfirmShareToPersonDialog(getShareMsgData(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private boolean handlerExitApp(Intent intent) {
        if (intent == null || !intent.getBooleanExtra(MainTabActivityConfig.EXIT_APP, false)) {
            return false;
        }
        finish();
        System.exit(0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handlerYoungsterNightTask() {
        int i2 = Calendar.getInstance().get(11);
        if (i2 < 23 && i2 >= 7) {
            d.a.m0.c1.b.e.f49258a = false;
            Timer timer = this.youngsterNightTimer;
            if (timer != null) {
                timer.cancel();
                this.youngsterNightTimer = null;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 23);
            calendar.set(12, 0);
            calendar.set(13, 0);
            Date time = calendar.getTime();
            Timer timer2 = new Timer();
            this.youngsterNightTimer = timer2;
            timer2.schedule(new o0(), time, 1000L);
            return false;
        }
        d.a.m0.c1.b.e.f49258a = true;
        stopYoungsterUseTimeTask();
        startYoungsterUseTimePeriodTask();
        return true;
    }

    private void manageService() {
        if (System.currentTimeMillis() - this.leaveTime < SERVICE_BETWEEN_TIME) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", IntentConfig.START);
        hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
        hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
        MessageManager.getInstance().sendMessage(new CustomMessage(2006002, hashMap));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005013, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
        this.leaveTime = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onResponseMessage(ProfileHttpResponseMessage profileHttpResponseMessage) {
        if (profileHttpResponseMessage == null || profileHttpResponseMessage.GetUser() == null) {
            return;
        }
        int intValue = profileHttpResponseMessage.GetUser().my_like_num.intValue();
        this.mLikeForumNum = intValue;
        if (intValue == 1) {
            createLikeFirstForumTips();
            showLikeFirstForumTips();
        }
        checkAndShowLikeFirstForumTips();
    }

    private void regReceiver() {
        registerListener(this.mCloseMainTablistener);
        this.mAddTablistener.setPriority(100);
        registerListener(this.mAddTablistener);
        registerListener(this.mRefreshTablistener);
        registerListener(this.mRefreshTiplistener);
        registerListener(this.mForceConfirmListener);
        registerListener(this.mSetMainTabInstListener);
        registerListener(this.mGameCenterInitListener);
        registerListener(this.mGameMsgTipListener);
        registerListener(this.mPersonInfoChangeListener);
        registerListener(this.skinTypeChangeListener);
        registerListener(this.bigdayModifyNavbarListener);
        this.mUpdateReceiver = new b1(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.mUpdateReceiver, intentFilter);
        registerListener(this.mShowPostVideoSuccessListener);
        registerListener(this.mJumpPbListener);
        registerListener(this.mSyncFinishListener);
        registerListener(this.networkChangedListener);
        registerListener(this.mBackgroundChangeListener);
        registerListener(this.enterImageViewActivityListener);
        registerListener(this.youngsterUseTimerListener);
        registerListener(this.mYoungsterModeChangeListener);
        this.mEditorListener.setTag(getUniqueId());
        registerListener(this.mEditorListener);
        registerListener(this.mShowGoBackShouBaiListener);
        registerListener(this.mOnScreenSizeChangeListener);
        registerListener(this.showWriteThreadListener);
        registerListener(this.mLikeForumListener);
        registerListener(this.mEnterForumTabClickListener);
        registerListener(this.mPersonInfoMsgListener);
        registerListener(this.mCategoryUpdateListener);
        registerListener(this.mMyCreateCenterListener);
        registerListener(this.updateMainTabProfileListener);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction(AlaLiveRoomActivityConfig.JUMP_ALA_LIVE_ROOM_BROADCAST);
        registerReceiver(this.jumpAlaLiveRoomReceiver, intentFilter2);
        registerListener(this.showNewUserRedPackageListener);
    }

    private void registerNavigationBarEditStateListener() {
        registerListener(new a0(2007009));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setupIntent(Intent intent) {
        d.a.n0.h3.d dVar;
        int a2;
        if (intent == null || (dVar = this.mViewController) == null || dVar.C() == null) {
            return;
        }
        try {
            if (intent.hasExtra("locate_type")) {
                a2 = intent.getIntExtra("locate_type", 1);
            } else {
                a2 = this.mAppEntranceModel.a();
            }
            this.mViewController.C().setCurrentTabByType(a2);
        } catch (Throwable unused) {
            finish();
        }
    }

    private void showConfirmShareToPersonDialog(ShareFromPBMsgData shareFromPBMsgData, long j2, String str, String str2, String str3) {
        if (shareFromPBMsgData == null) {
            return;
        }
        d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(getPageContext().getPageActivity());
        Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
        thread2GroupShareView.setData(shareFromPBMsgData);
        aVar.setContentViewSize(1);
        aVar.setContentView(thread2GroupShareView);
        aVar.setPositiveButton(R.string.share, new c0(thread2GroupShareView, j2, str, str2, str3, shareFromPBMsgData));
        aVar.setNegativeButton(R.string.cancel, new d0(thread2GroupShareView));
        aVar.setCanceledOnTouchOutside(true);
        aVar.create(getPageContext()).show();
        if (d.a.c.e.p.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
            return;
        }
        thread2GroupShareView.c(shareFromPBMsgData.getImageUrl(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLikeFirstForumTips() {
        d.a.n0.d0.e eVar = this.mLikeFirstForumTipsController;
        if (eVar == null || eVar.J()) {
            return;
        }
        d.a.n0.d0.e eVar2 = this.mLikeFirstForumTipsController;
        String string = getString(R.string.enterforumtab_like_forum_tips);
        eVar2.m0(string, "first_like_forum_enterforumtab_tips" + TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startYoungsterUseTimePeriodTask() {
        if (this.youngsterUseTimer != null) {
            return;
        }
        this.youngsterUseTimer = new Timer();
        q0 q0Var = new q0();
        this.youngsterUseTimeTask = q0Var;
        this.youngsterUseTimer.schedule(q0Var, 1000L, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startYoungsterUseTimeTask() {
        if (this.youngsterUseTimer != null) {
            return;
        }
        this.youngsterUseTimer = new Timer();
        p0 p0Var = new p0();
        this.youngsterUseTimeTask = p0Var;
        this.youngsterUseTimer.schedule(p0Var, d.a.m0.c1.b.d.c() ? 1000L : YOUNGSTER_USE_TIME_MAX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopYoungsterUseTimeTask() {
        Timer timer = this.youngsterUseTimer;
        if (timer != null) {
            timer.cancel();
            this.youngsterUseTimer = null;
        }
        TimerTask timerTask = this.youngsterUseTimeTask;
        if (timerTask != null) {
            timerTask.cancel();
            this.youngsterUseTimeTask = null;
        }
    }

    private void unregReceiver() {
        b1 b1Var = this.mUpdateReceiver;
        if (b1Var != null) {
            unregisterReceiver(b1Var);
        }
        BroadcastReceiver broadcastReceiver = this.jumpAlaLiveRoomReceiver;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
    }

    public void checkBackgroundPermissionDialog(Activity activity) {
        new d.a.m0.r.s.a(activity).setTitle(R.string.confirm_title).setCancelable(false).setMessageId(R.string.background_process_permission).setPositiveButton(R.string.now_goto_setting, new z()).setNegativeButton(R.string.next_time, new y()).create(d.a.c.a.j.a(activity)).show();
    }

    public void clearMyCreateCenterTips() {
        d.a.n0.d0.e eVar = this.mMyTipController;
        if (eVar == null || !eVar.J()) {
            return;
        }
        this.mMyTipController.I();
        this.mMyTipController = null;
    }

    public void clearNewCategoryTips() {
        d.a.n0.d0.e eVar = this.mCategoryTipController;
        if (eVar == null || !eVar.J()) {
            return;
        }
        this.mCategoryTipController.I();
        this.mCategoryTipController = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!MainTabActivityConfig.IS_BACK_CLOSE_ALL_ACTIVITY && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016322, (Class) null);
            if (runTask == null || !((Boolean) runTask.getData()).booleanValue()) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2016323, (Class) null);
                if (runTask2 == null || !((Boolean) runTask2.getData()).booleanValue()) {
                    d.a.n0.w3.f fVar = this.mWriteTab;
                    if (fVar != null && fVar.l()) {
                        this.mWriteTab.k(true);
                        return true;
                    } else if (this.mViewController.I()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007010));
                        return true;
                    } else {
                        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(2921405, Boolean.class, Boolean.FALSE);
                        if (runTask3 == null || runTask3.getData() == null || !(runTask3.getData() instanceof Boolean) || !((Boolean) runTask3.getData()).booleanValue()) {
                            if (System.currentTimeMillis() - this.exitTime > 2000) {
                                showToast(R.string.double_back_quit);
                                this.exitTime = System.currentTimeMillis();
                                return false;
                            } else if (UtilHelper.isBackgroundProcessLimitNone() && Build.VERSION.SDK_INT >= 14) {
                                checkBackgroundPermissionDialog(getPageContext().getPageActivity());
                                return true;
                            } else {
                                processBeforeGoBack();
                                return false;
                            }
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mTouchable) {
            if (this.mViewController.C() == null || this.mViewController.C().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1 || !this.mViewController.I()) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        TbSingleton.getInstance().clearVideoRecord();
        TbSingleton.getInstance().setHasAgreeToPlay(false);
        super.finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public ViewGroup getActivityRootView() {
        return this.rootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, d.a.m0.k0.a
    public List<String> getCurrentPageSourceKeyList() {
        List<String> currentPageSourceKeyList = super.getCurrentPageSourceKeyList();
        if (!this.isAccountStatChanged || currentPageSourceKeyList == null) {
            return currentPageSourceKeyList;
        }
        currentPageSourceKeyList.clear();
        this.isAccountStatChanged = false;
        return null;
    }

    @Override // d.a.n0.h3.a
    public int getCurrentTabType() {
        if (this.mViewController.C() != null) {
            return this.mViewController.C().getCurrentTabType();
        }
        return -1;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public d.a.c.e.k.b<TbImageView> getFrsCommonImageLayoutPool() {
        if (this.mCommonImagePool == null) {
            this.mCommonImagePool = FrsCommonImageLayout.m(getPageContext().getPageActivity(), 12);
        }
        return this.mCommonImagePool;
    }

    public boolean getGpuSwich() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    /* JADX DEBUG: Method merged with bridge method */
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, d.a.m0.k0.a
    public d.a.m0.k0.b getPageStayFilter() {
        return new e0();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag;
        d.a.n0.h3.d dVar = this.mViewController;
        if (dVar != null && dVar.C() != null) {
            Fragment currentFragment = this.mViewController.C().getCurrentFragment();
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

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public d.a.c.e.k.b<TbImageView> getUserIconPool() {
        if (this.mUserIconPool == null) {
            this.mUserIconPool = UserIconBox.c(getPageContext().getPageActivity(), 8);
        }
        return this.mUserIconPool;
    }

    public int getUserIconViewId() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        if (this.mVoiceManager == null) {
            this.mVoiceManager = VoiceManager.instance();
        }
        return this.mVoiceManager;
    }

    public void gotoFeedback() {
        AntiData antiData = new AntiData();
        antiData.setIfpost(1);
        if (antiData.getIfpost() == 0) {
            d.a.c.e.p.l.M(getPageContext().getPageActivity(), antiData.getForbid_info());
        } else if (WriteActivityConfig.isAsyncWriting()) {
        } else {
            antiData.setIfVoice(false);
            WriteActivityConfig.newInstance(this).setType(0).setFrom(this.mFrom).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setFeedBack(true).setAntiData(antiData).send();
        }
    }

    public void initTabsOnActivityCreated() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007002, new d.a.m0.e0.d(getPageContext().getPageActivity())));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel;
        if (i3 != -1) {
            if (i2 == 25059) {
                d.a.n0.n.e();
            } else if (i2 == 25060) {
                d.a.n0.n.e();
            }
        }
        if (i3 != -1) {
            if (this.mViewController.C().getCurrentFragment() != null) {
                this.mViewController.C().getCurrentFragment().onActivityResult(i2, i3, intent);
            }
        } else if (i2 == 25046) {
            if (TbadkCoreApplication.isLogin()) {
                d.a.m0.a.r.g().l(getPageContext());
            }
        } else if (i2 == 11001) {
            gotoFeedback();
        } else if (i2 == 13003 || i2 == 25048) {
            dispatchWriteCallbakcData(intent);
        } else if (i2 == 23007) {
            handleShareFriendForum(intent);
        } else if (i2 == 13011) {
            d.a.n0.s2.a.g().m(getPageContext());
        } else if (i2 == 24007) {
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1) {
                d.a.n0.s2.a.g().m(getPageContext());
                ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                statisticItem.param("obj_locate", 5);
                if (shareItem != null) {
                    statisticItem.param("tid", shareItem.K);
                }
                statisticItem.param("pid", intent.getStringExtra("pid"));
                TiebaStatic.log(statisticItem);
                if (shareItem == null || (str = shareItem.t) == null || (shareSuccessReplyToServerModel = this.mShareSuccessReplyToServerModel) == null) {
                    return;
                }
                shareSuccessReplyToServerModel.s(str, intExtra2, new b0());
            }
        } else if (i2 == 25059) {
            if (d.a.m0.b.d.k()) {
                if (TbadkApplication.getInst().isNeedNewUserLead() && TbadkCoreApplication.isLogin()) {
                    InterestGuideActivityConfig interestGuideActivityConfig = new InterestGuideActivityConfig(this, 1);
                    interestGuideActivityConfig.setRequestCode(25060);
                    interestGuideActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, interestGuideActivityConfig));
                    return;
                }
                return;
            }
            d.a.n0.n.e();
        } else if (i2 == 25060) {
            if (d.a.m0.b.d.l()) {
                if (TbadkCoreApplication.isLogin()) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921535, this));
                return;
            }
            d.a.n0.n.e();
        } else if (this.mViewController.C().getCurrentFragment() != null) {
            this.mViewController.C().getCurrentFragment().onActivityResult(i2, i3, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        this.mViewController.J(i2);
        adjustResizeForSoftInputOnSkinTypeChanged(i2);
        d.a.n0.w3.f fVar = this.mWriteTab;
        if (fVar != null) {
            fVar.p(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (configuration == null) {
            return;
        }
        super.onConfigurationChanged(configuration);
        if (TbadkCoreApplication.getInst().getSkinType() != 1) {
            SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        d.a.m0.m0.l.b().x(System.currentTimeMillis());
        if (TbadkCoreApplication.getInst().getIsFirstUse()) {
            d.a.m0.z0.h0.b(new i(), null);
        }
        setIsAddSwipeBackLayout(false);
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.getDecorView();
        super.onCreate(bundle);
        if (handlerExitApp(getIntent())) {
            return;
        }
        int i2 = -1;
        d.a.m0.r.a0.b.f49637c = d.a.m0.r.a0.b.f49638d;
        if (getIntent() != null) {
            d.a.n0.h3.e eVar = new d.a.n0.h3.e(getPageContext());
            this.mPushInsertThreadController = eVar;
            if (!eVar.b(getIntent())) {
                checkSchemeFromIntent(getIntent());
            }
            i2 = getIntent().getIntExtra("locate_type", 0);
            if (i2 == 200) {
                finish();
                return;
            }
            this.mFrom = getIntent().getStringExtra("from");
        }
        d.a.n0.h3.b bVar = new d.a.n0.h3.b();
        d.a.m0.r.a0.b.h(bVar);
        bVar.g(this);
        if (getGpuSwich()) {
            CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
        }
        setContentView(R.layout.maintabs_activity);
        this.rootView = (FrameLayout) findViewById(R.id.maintabContainer);
        if (d.a.m0.r.l.a.b() != null) {
            d.a.m0.r.l.a.b().e();
        }
        this.mViewController = new d.a.n0.h3.d(this);
        this.mMainTabTopicTipController = new d.a.n0.h3.c(this);
        this.mViewController.M(this.mIsLogin);
        checkPluginEntranceState();
        regReceiver();
        d.a.n0.h3.f.b.i().e(this);
        d.a.m0.a.c.y().q();
        this.mAppEntranceModel = new d.a.n0.b();
        initTabsOnActivityCreated();
        registerNavigationBarEditStateListener();
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        if (bundle != null) {
            i2 = bundle.getInt("locate_type", 1);
            intent.putExtra("locate_type", i2);
        }
        this.lastDay = UtilHelper.getCurrentDay();
        this.mLastSyncTime = System.currentTimeMillis();
        MessageManager.getInstance().sendMessage(new CustomMessage(2921359));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
        if (TbadkCoreApplication.getFrom() != null && TbadkCoreApplication.getFrom().equals("aishide")) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005011, null));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005013, null));
        MessageManager.getInstance().registerStickyMode(2001404);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001404));
        dealIntent(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        d.a.m0.l.a.f(getPageContext().getPageActivity());
        String installOtherApp = TbadkCoreApplication.getInst().getInstallOtherApp();
        if (installOtherApp != null && installOtherApp.length() > 0) {
            UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), installOtherApp);
            TbadkCoreApplication.getInst().setInstallOtherApp(null);
        }
        this.mHandler.post(new j());
        TbadkCoreApplication.getInst().startTrackConfigRequest();
        if (PermissionUtil.checkLocationForGoogle(getActivity())) {
            MercatorModel.d().f();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921545, null));
        registerListener(this.mOnlineListener);
        if (i2 == 1) {
            this.mViewController.Z(true);
        } else {
            this.mViewController.Z(false);
        }
        this.mViewController.N();
        VoiceManager voiceManager = getVoiceManager();
        this.mVoiceManager = voiceManager;
        if (voiceManager != null) {
            voiceManager.onCreate(getPageContext());
        }
        registerListener(this.mAccountChangedListener);
        adjustResizeBottomVirtualBar();
        adjustResizeForSoftInput();
        addGlobalLayoutListener();
        MessageManager.getInstance().registerStickyMode(2007015);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007015));
        if (TbadkCoreApplication.isLogin()) {
            d.a.m0.m0.l.b().f();
        }
        if (TbadkCoreApplication.isLogin()) {
            d.a.m0.z.b.a().d();
        }
        d.a.m0.r.d0.b.j().v("app_restart_times", d.a.m0.r.d0.b.j().k("app_restart_times", 0) + 1);
        CheckRealNameModel checkRealNameModel = new CheckRealNameModel(getPageContext());
        this.mCheckRealNameModel = checkRealNameModel;
        checkRealNameModel.w(this.checkRealNameCallBack);
        checkRealName();
        this.mNEGFeedBackManager = new d.a.n0.h.a(getPageContext(), "homepage");
        this.mShareSuccessReplyToServerModel = new ShareSuccessReplyToServerModel();
        this.mUegForwardCheckController = new d.a.n0.m3.d(getPageContext());
        this.mBdTokenController = d.a.m0.a.d.y();
        int loadInt = TbadkSettings.getInst().loadInt("skin_", 0);
        if (loadInt != 1) {
            SkinManager.setDayOrDarkSkinTypeWithSystemMode(false, true);
        } else {
            TbadkCoreApplication.getInst().setSkinTypeValue(loadInt);
            TbadkCoreApplication.getInst().SendSkinTypeBroadcast(loadInt);
        }
        if (TbSingleton.getInstance().isEnableBenchmark() && TbSingleton.getInstance().getCpuFlopsDuration() <= 0) {
            d.a.c.e.m.e.a().postDelayed(new l(), 5000L);
        }
        MessageManager.getInstance().registerListener(this.mToHotTopicListener);
        TbSingleton.getInstance().startOneGame();
        this.mWeakContext = new WeakReference<>(TbadkCoreApplication.getInst());
        if (getResources() != null && getResources().getConfiguration() != null) {
            this.lastUiMode = getResources().getConfiguration().uiMode & 48;
        }
        d.a.t0.c.c(TbadkCoreApplication.getInst()).e(null);
        clearConcernCacheWhenVersionUpdate();
        if (this.mPushInsertThreadController.b(intent)) {
            this.mPushInsertThreadController.a(getIntent(), this.mViewController);
        }
        updateProfileInfo();
        if (d.a.m0.b.d.C()) {
            d.a.n0.s0.a.h().p(this, "6051001980-1210572494", d.a.n0.s0.a.a("personalize", "1"));
        }
        TbSingleton.getInstance().getChannelConfigModel().e();
        TbSingleton.getInstance().setActiveTimeStamp();
        if (d.a.m0.c1.b.e.d()) {
            d.a.m0.c1.b.d.f49241a = false;
            d.a.m0.c1.b.c.a();
            if (!handlerYoungsterNightTask()) {
                startYoungsterUseTimeTask();
            }
        }
        this.isCreated = true;
        d.a.c.e.m.e.a().postDelayed(new m(), 1000L);
        d.a.m0.m0.l.b().y(System.currentTimeMillis());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005010, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005012, null));
        unregReceiver();
        d.a.m0.s.d.b.g0().o();
        d.a.m0.s.d.b.g0().q();
        d.a.m0.s.d.b.g0().X(false);
        MessageManager.getInstance().unRegisterListener(this.mToHotTopicListener);
        MessageManager.getInstance().unRegisterListener(this.mShowGoBackShouBaiListener);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        d.a.m0.r.f0.a aVar = this.mWaitingDialog;
        if (aVar != null) {
            aVar.h(false);
            this.mWaitingDialog = null;
        }
        callWindowMissed();
        d.a.n0.h3.d dVar = this.mViewController;
        if (dVar != null) {
            dVar.K();
        }
        d.a.n0.h3.c cVar = this.mMainTabTopicTipController;
        if (cVar != null) {
            cVar.i();
        }
        CurrencySwitchTDouYBeanDialog currencySwitchTDouYBeanDialog = this.mYYBeanForceConfirmDialog;
        if (currencySwitchTDouYBeanDialog != null) {
            currencySwitchTDouYBeanDialog.onDestroy();
        }
        try {
            super.onDestroy();
        } catch (Exception unused) {
        }
        d.a.m0.r.a0.b.h(null);
        d.a.m0.x.d.h().l();
        VoiceManager voiceManager = getVoiceManager();
        this.mVoiceManager = voiceManager;
        if (voiceManager != null) {
            voiceManager.onDestory(getPageContext());
        }
        d.a.n0.w3.f fVar = this.mWriteTab;
        if (fVar != null) {
            fVar.r();
        }
        d.a.n0.h.a aVar2 = this.mNEGFeedBackManager;
        if (aVar2 != null) {
            aVar2.g();
        }
        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.mShareSuccessReplyToServerModel;
        if (shareSuccessReplyToServerModel != null) {
            shareSuccessReplyToServerModel.cancelLoadData();
        }
        d.a.n0.m3.b bVar = this.mCancelController;
        if (bVar != null) {
            bVar.f();
        }
        d.a.n0.h3.d dVar2 = this.mViewController;
        if (dVar2 != null && dVar2.B() != null) {
            this.mViewController.B().r();
        }
        d.a.n0.j1.c.b().c();
        d.a.c.e.m.e.a().removeCallbacks(this.mCheckNewUserRedPackageRunnable);
        System.gc();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        try {
            if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921381, keyEvent));
            }
            return super.onKeyDown(i2, keyEvent);
        } catch (IllegalStateException unused) {
            if (i2 == 4) {
                finish();
                return true;
            }
            return true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        try {
            return super.onKeyUp(i2, keyEvent);
        } catch (IllegalStateException unused) {
            if (i2 == 4) {
                finish();
                return true;
            }
            return true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z2) {
        this.isKeyboardVisible = z2;
        boolean z3 = this.isEditorVisible || z2;
        d.a.n0.h3.d dVar = this.mViewController;
        if (dVar != null) {
            dVar.L(z3);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        d.a.n0.h3.d dVar;
        FragmentTabHost.b g2;
        super.onNewIntent(intent);
        if (handlerExitApp(intent)) {
            return;
        }
        setIntent(intent);
        String stringExtra = intent.getStringExtra(MainTabActivityConfig.TARGET_SCHEME);
        if (this.mPushInsertThreadController.b(intent)) {
            this.mPushInsertThreadController.a(intent, this.mViewController);
        } else {
            checkSchemeFromIntent(intent);
        }
        if (StringUtils.isNull(stringExtra)) {
            d.a.m0.z.b.a().d();
            if (intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007008));
                initTabsOnActivityCreated();
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
            } else if (intExtra == 1 || intExtra == 20 || intExtra == 3 || intExtra == 2 || intExtra == 4 || intExtra == 8 || intExtra == 15) {
                if (intExtra != 8 && intExtra != 3 && intExtra != 15 && !booleanExtra) {
                    if (getActivity().getIntent() != null && getActivity().getIntent().getDataString() != null && getActivity().getIntent().getDataString().startsWith(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
                        intExtra = 2;
                    } else if (intExtra != 2 && intExtra != 1 && intExtra != 20) {
                        intExtra = this.mAppEntranceModel.a();
                    }
                }
                d.a.n0.h3.d dVar2 = this.mViewController;
                if (dVar2 != null && dVar2.C() != null) {
                    this.mViewController.O(intExtra);
                }
            } else if ((intExtra == 17 || intExtra == 18) && (dVar = this.mViewController) != null && dVar.C() != null) {
                this.mViewController.C().setCurrentTab(0);
            }
            d.a.n0.h3.d dVar3 = this.mViewController;
            if (dVar3 != null && dVar3.C() != null && (g2 = this.mViewController.C().g(intExtra)) != null) {
                Fragment fragment = g2.f12151c;
                if (fragment instanceof d.a.m0.r.g) {
                    ((d.a.m0.r.g) fragment).u0(intent);
                }
            }
            dealIntent(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
            d.a.n0.h3.d dVar4 = this.mViewController;
            if (dVar4 != null) {
                dVar4.N();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.isResumed = false;
        LogoActivityConfig.isFirst = false;
        if (this.needAnim) {
            this.needAnim = false;
            CompatibleUtile.setAnim(getPageContext().getPageActivity(), R.anim.down, R.anim.hold);
        }
        VoiceManager voiceManager = getVoiceManager();
        this.mVoiceManager = voiceManager;
        if (voiceManager != null) {
            voiceManager.onPause(getPageContext());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921003));
        d.a.n0.h3.c cVar = this.mMainTabTopicTipController;
        if (cVar != null) {
            cVar.g();
        }
        KuangFloatingViewController.getInstance().hideFloatingView();
        d.a.m0.x.d.h().i(true);
        clearLikeFirstForumTips();
        d.a.c.e.m.e.a().removeCallbacks(this.mCheckNewUserRedPackageRunnable);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, d.a.c.a.i
    public void onPreLoad(d.a.c.j.e.q qVar) {
        super.onPreLoad(qVar);
        PreLoadImageHelper.load(qVar, getUniqueId());
        PreLoadVideoHelper.load(qVar, getUniqueId(), this);
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        try {
            super.onRestoreInstanceState(bundle);
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.isResumed = true;
        if (this.doRefresh) {
            d.a.m0.z0.m0.f(this.mWeakContext);
            this.doRefresh = false;
        }
        d.a.n0.h3.d dVar = this.mViewController;
        if (dVar != null && dVar.B() != null) {
            this.mViewController.B().setLottieView(true);
        }
        d.a.n0.h3.d dVar2 = this.mViewController;
        if (dVar2 != null && dVar2.C() != null) {
            this.reloginGotoType = this.mViewController.C().getCurrentTabType();
        }
        changeSkinType(this.mSkinType);
        d.a.m0.x.d.h().i(true);
        if (TbadkCoreApplication.isLogin() && d.a.m0.m0.l.b().e()) {
            d.a.m0.m0.l.b().f();
        }
        VoiceManager voiceManager = getVoiceManager();
        this.mVoiceManager = voiceManager;
        if (voiceManager != null) {
            voiceManager.onResume(getPageContext());
        }
        d.a.n0.h3.d dVar3 = this.mViewController;
        if (dVar3 != null) {
            dVar3.N();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001385, getActivity()));
        if (TbadkCoreApplication.getKeepLiveSwitch(getApplicationContext())) {
            d.a.c.e.m.e.a().postDelayed(new x(), 3000L);
        }
        d.a.m0.m0.l.b().f();
        if (d.a.m0.a.r.g().c() != null && d.a.m0.a.r.g().i() != null && d.a.m0.a.r.g().c().getCurTaskType() == 6) {
            d.a.m0.a.r.g().i().a();
        }
        showLikeFirstForumTips();
        if (this.mCurrentTabIndex.intValue() != 1) {
            showLikeFirstForumTips();
        }
        if (!TbSingleton.getInstance().isNewUserRedPackageShowed() && TbSingleton.getInstance().hasPerformedFirstLoginTest()) {
            d.a.c.e.m.e.a().removeCallbacks(this.mCheckNewUserRedPackageRunnable);
            d.a.c.e.m.e.a().postDelayed(this.mCheckNewUserRedPackageRunnable, 200L);
        }
        statisticDynamicIconExposure();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
        } catch (Exception unused) {
        }
        bundle.putInt("locate_type", this.mViewController.C().getCurrentTabType());
        bundle.putParcelable("android:fragments", null);
        bundle.putParcelable("android:support:fragments", null);
        VoiceManager voiceManager = getVoiceManager();
        this.mVoiceManager = voiceManager;
        if (voiceManager != null) {
            voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onScreenShot(String str) {
        super.onScreenShot(str);
        d.a.n0.h3.d dVar = this.mViewController;
        if (dVar == null || dVar.C() == null || this.mViewController.C().getCurrentTabType() != 2) {
            return;
        }
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SCREEN_SHOT).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", 1));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        VoiceManager voiceManager = getVoiceManager();
        this.mVoiceManager = voiceManager;
        if (voiceManager != null) {
            voiceManager.onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        VoiceManager voiceManager = getVoiceManager();
        this.mVoiceManager = voiceManager;
        if (voiceManager != null) {
            voiceManager.onStop(getPageContext());
        }
        this.doRefresh = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z2) {
        super.onUserChanged(z2);
        this.isAccountStatChanged = true;
        if (z2) {
            d.a.m0.z.b.a().d();
            checkPluginEntranceState();
            checkRealName();
            updateProfileInfo();
        }
        this.mViewController.b0(z2);
        this.mViewController.G();
        initTabsOnActivityCreated();
    }

    public void processBeforeGoBack() {
        d.a.c.e.l.d.h().b(getUniqueId());
        manageService();
        try {
            moveTaskToBack(true);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    public void showMemberTip(PayMemberInfoData payMemberInfoData) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && payMemberInfoData != null) {
            if ((payMemberInfoData.u() == 1 || payMemberInfoData.u() == 2) && d.a.m0.r.d0.b.j().g("show_member_deid_line", true)) {
                long s2 = payMemberInfoData.s() * 1000;
                if (s2 < System.currentTimeMillis()) {
                    if (StringUtils.isNull(payMemberInfoData.t())) {
                        payMemberInfoData.w(getPageContext().getString(R.string.member));
                    } else {
                        payMemberInfoData.w(payMemberInfoData.t() + getPageContext().getString(R.string.member_already_Expire));
                    }
                    this.mViewController.X(payMemberInfoData, 0);
                } else if (s2 - System.currentTimeMillis() < 259200000) {
                    if (StringUtils.isNull(payMemberInfoData.t())) {
                        payMemberInfoData.w(getPageContext().getString(R.string.member));
                    } else {
                        payMemberInfoData.w(payMemberInfoData.t() + getPageContext().getString(R.string.member_will_Expire));
                    }
                    this.mViewController.X(payMemberInfoData, 1);
                }
            }
        }
    }

    public void showWriteThreadView() {
        d.a.n0.h3.c cVar = this.mMainTabTopicTipController;
        if (cVar != null) {
            cVar.h();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
        if (this.mWriteTab == null) {
            d.a.n0.w3.f fVar = new d.a.n0.w3.f(getPageContext(), this.rootView, "main_tab", 3);
            this.mWriteTab = fVar;
            fVar.C("8");
        }
        if (this.mUegForwardCheckController.d() || this.mViewController.C() == null || this.mViewController.C().getFragmentTabWidget() == null) {
            return;
        }
        this.mWriteTab.G(false, this.mViewController.C().getTabWrapper(), this.mViewController.C().getFragmentTabWidget().getWriteView());
    }

    public void statisticDynamicIconExposure() {
        if (d.a.m0.e0.e.c.d().b()) {
            StatisticItem statisticItem = new StatisticItem("c14132");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public void updateProfileInfo() {
        if (d.a.c.e.p.j.A() && TbadkCoreApplication.getCurrentAccount() != null) {
            ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
            profileRequestMessage.set_uid(Long.valueOf(d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L)));
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        return d.a.m0.z0.m0.a(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onResponseMessage(ProfileSocketResponseMessage profileSocketResponseMessage) {
        if (profileSocketResponseMessage == null || profileSocketResponseMessage.GetUser() == null) {
            return;
        }
        int intValue = profileSocketResponseMessage.GetUser().my_like_num.intValue();
        this.mLikeForumNum = intValue;
        if (intValue == 1) {
            createLikeFirstForumTips();
            checkAndShowLikeFirstForumTips();
        }
    }
}
