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
import android.widget.ListView;
import android.widget.SeekBar;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import b.a.q0.a.g;
import b.a.q0.s.q.o1;
import b.a.q0.s.s.a;
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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.LoginActivity;
import com.baidu.searchbox.fluency.BdTracesManager;
import com.baidu.searchbox.fluency.config.BdTracesConfig;
import com.baidu.searchbox.launch.TTIStats;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.GrowthStatsUtil;
import com.baidu.tbadk.KuangFloatingViewController;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import com.baidu.tbadk.core.data.VideoClickTabData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentAction;
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
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.mainTab.videoRedIcon.VideoRedIconRequest;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.switchs.AdToMainTabActivitySwitch;
import com.baidu.tbadk.switchs.CreateCenterTipSwitch;
import com.baidu.tbadk.switchs.GameEnterSwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes9.dex */
public class MainTabActivity extends BaseFragmentActivity implements b.a.r0.o3.a, VoiceManager.j, UserIconBox.c, FrsCommonImageLayout.e, IVideoNeedPreload {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener bigdayModifyNavbarListener;
    public CheckRealNameModel.b checkRealNameCallBack;
    public boolean doRefresh;
    public CustomMessageListener enterImageViewActivityListener;
    public long exitTime;
    public boolean isAccountStatChanged;
    public boolean isCheckNewUserRedPackageRunnable;
    public boolean isCreated;
    public boolean isEditorVisible;
    public boolean isEnterImageViewActivity;
    public boolean isKeyboardVisible;
    public boolean isResumed;
    public boolean isUseCurrType;
    public String lastDay;
    public int lastUiMode;
    public long leaveTime;
    public CustomMessageListener mAccountChangedListener;
    public final CustomMessageListener mAddTablistener;
    public b.a.r0.b mAppEntranceModel;
    public final CustomMessageListener mBackHomeListener;
    public CustomMessageListener mBackgroundChangeListener;
    public b.a.q0.a.e mBdTokenController;
    public b.a.r0.t3.b mCancelController;
    public b.a.r0.f0.g mCategoryTipController;
    public CustomMessageListener mCategoryUpdateListener;
    public Runnable mCheckNewUserRedPackageRunnable;
    public CheckRealNameModel mCheckRealNameModel;
    public final CustomMessageListener mCloseMainTablistener;
    public b.a.e.e.k.b<TbImageView> mCommonImagePool;
    public Integer mCurrentTabIndex;
    public CustomMessageListener mEditorListener;
    public CustomMessageListener mEnterForumTabClickListener;
    public final CustomMessageListener mForceConfirmListener;
    public String mFrom;
    public CustomMessageListener mGameCenterInitListener;
    public volatile boolean mIsAdd;
    public CustomMessageListener mJumpPbListener;
    public long mLastSyncTime;
    public b.a.r0.f0.g mLikeFirstForumTipsController;
    public CustomMessageListener mLikeForumListener;
    public int mLikeForumNum;
    public b.a.r0.o3.c mMainTabTopicTipController;
    public CustomMessageListener mMyCreateCenterListener;
    public b.a.r0.f0.g mMyTipController;
    public b.a.r0.j.a mNEGFeedBackManager;
    public CustomMessageListener mOnScreenSizeChangeListener;
    public final b.a.e.c.g.c mOnlineListener;
    public final CustomMessageListener mPersonInfoChangeListener;
    public b.a.e.c.g.a mPersonInfoMsgListener;
    public String mPreUserId;
    public b.a.r0.o3.e mPushInsertThreadController;
    public o1 mRecomPostTopic;
    public final CustomMessageListener mRefreshTablistener;
    public final CustomMessageListener mRefreshTiplistener;
    public final CustomMessageListener mSetMainTabInstListener;
    public ShareSuccessReplyToServerModel mShareSuccessReplyToServerModel;
    public CustomMessageListener mShowGoBackShouBaiListener;
    public CustomMessageListener mShowPostVideoSuccessListener;
    public CustomMessageListener mSplashCloseListener;
    public final CustomMessageListener mStartPollVideoMsgListener;
    public CustomMessageListener mSyncFinishListener;
    public final CustomMessageListener mToHotTopicListener;
    public boolean mTouchable;
    public b.a.r0.t3.d mUegForwardCheckController;
    public e1 mUpdateReceiver;
    public b.a.e.e.k.b<TbImageView> mUserIconPool;
    public CustomMessageListener mVideoChannelNoticeListener;
    public final CustomMessageListener mVideoClickListener;
    public b.a.r0.o3.d mViewController;
    public VoiceManager mVoiceManager;
    public WeakReference<Context> mWeakContext;
    public b.a.r0.d4.f mWriteTab;
    public CurrencySwitchTDouYBeanDialog mYYBeanForceConfirmDialog;
    public CustomMessageListener mYoungsterModeChangeListener;
    public boolean myCreateCenterTipNeedShow;
    public boolean needAnim;
    public CustomMessageListener networkChangedListener;
    public PackageChangedReceiver packageChangedReceiver;
    public int reloginGotoType;
    public ViewGroup rootView;
    public CustomMessageListener showNewUserRedPackageListener;
    public CustomMessageListener showWriteThreadListener;
    public final CustomMessageListener skinTypeChangeListener;
    public final Runnable startPollVideoMsg;
    @Nullable
    public TiePlusEventController tiePlusEventController;
    public CustomMessageListener updateMainTabProfileListener;
    public boolean videoChannelNoticeNeedShow;
    public Timer youngsterNightTimer;
    public TimerTask youngsterUseTimeTask;
    public Timer youngsterUseTimer;
    public CustomMessageListener youngsterUseTimerListener;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54360a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54360a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            UserData b2 = b.a.q0.a0.b.a().b();
            if (TbadkCoreApplication.isLogin() && b2 != null && b2.getUserId() != null && !b2.getUserId().equals(this.f54360a.mPreUserId) && b2.getIsGodInvited()) {
                this.f54360a.mPreUserId = b2.getUserId();
                this.f54360a.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.f54360a.getPageContext().getPageActivity(), "", TbWebViewActivityConfig.GOD_INVITE_JUMP_URL + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE, true)));
            }
            if (b.a.q0.s.e0.b.j().g("key_new_god_invited_my_tab_red_tip_showed", false) || !TbadkCoreApplication.isLogin() || b2 == null || b2.getUserId() == null || b2.getUserId().equals(this.f54360a.mPreUserId) || b2.getNewGodData() == null || !b2.getNewGodData().isNewGodInvited()) {
                return;
            }
            b.a.r0.a3.a.v().L(11, true, true);
            TiebaStatic.log(new StatisticItem("c13688").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_locate", 0));
            b.a.q0.s.e0.b.j().t("key_new_god_invited_my_tab_red_tip_showed", true);
        }
    }

    /* loaded from: classes9.dex */
    public class a0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f54361e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54362f;

        public a0(MainTabActivity mainTabActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54362f = mainTabActivity;
            this.f54361e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                UrlManager.getInstance().dealOneLink(this.f54362f.getPageContext(), new String[]{this.f54361e});
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54363a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a1(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54363a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof b.a.r0.l3.s0.k) && ((b.a.r0.l3.s0.k) customResponsedMessage.getData()).f20875b && this.f54363a.mLikeForumNum == 0) {
                this.f54363a.createLikeFirstForumTips();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54364a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54364a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof PostWriteCallBackData) || ((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                return;
            }
            this.f54364a.mViewController.Q((PostWriteCallBackData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes9.dex */
    public class b0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54365e;

        public b0(MainTabActivity mainTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54365e = mainTabActivity;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.f54365e.processBeforeGoBack();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54366a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b1(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54366a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = this.f54366a.mCurrentTabIndex.intValue();
                this.f54366a.mCurrentTabIndex = (Integer) customResponsedMessage.getData();
                if (this.f54366a.mCurrentTabIndex.intValue() == 1) {
                    this.f54366a.clearLikeFirstForumTips();
                } else if (intValue == 1) {
                    this.f54366a.showLikeFirstForumTips();
                }
                if (this.f54366a.mCurrentTabIndex.intValue() == 2) {
                    this.f54366a.clearNewCategoryTips();
                }
                if (this.f54366a.mCurrentTabIndex.intValue() == 4) {
                    this.f54366a.clearMyCreateCenterTips();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54367a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54367a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            VideoClickTabData videoClickTabData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921610 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof VideoClickTabData) && (videoClickTabData = (VideoClickTabData) customResponsedMessage.getData()) != null && this.f54367a.isResumed) {
                TbSingleton.getInstance().setFromFeedVideoClick(true);
                this.f54367a.mViewController.z().getTabSpecByType(22);
                this.f54367a.mViewController.z().refreshVideoFragment(true, videoClickTabData.getMiddleFragment());
                TbSingleton.getInstance().setVideoChannelAttentionRedIcon(TbSingleton.getInstance().getVideoChannelAttentionRedIcon());
                this.f54367a.mViewController.z().setCurrentTabByType(22);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54368e;

        public c0(MainTabActivity mainTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54368e = mainTabActivity;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                try {
                    this.f54368e.startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
                    aVar.dismiss();
                } catch (Exception unused) {
                    this.f54368e.showToast(R.string.goto_developActivity_error_toast);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c1 extends b.a.e.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54369a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c1(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54369a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ConfigVersion configVersion;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && socketResponsedMessage != null && socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                if (socketResponsedMessage.getError() != 0 || (configVersion = responseOnlineMessage.getConfigVersion()) == null) {
                    return;
                }
                this.f54369a.checkVersion(configVersion.sync);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54370a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54370a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921611) {
                this.f54370a.mViewController.z().tbSelectionChanged(0, false);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54371a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d0(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54371a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof Integer)) {
                Integer num = (Integer) customResponsedMessage.getData();
                if (num.intValue() == 2) {
                    this.f54371a.mViewController.t(true);
                } else if (num.intValue() == 1) {
                    this.f54371a.mViewController.t(false);
                } else {
                    this.f54371a.mViewController.t(false);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54372a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d1(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54372a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.a.q0.u.i iVar;
            String a2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof b.a.q0.u.i) || (a2 = (iVar = (b.a.q0.u.i) customResponsedMessage.getData()).a()) == null) {
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
                baijiahaoData.oriUgcType = b.a.e.e.m.b.e(parse.getQueryParameter(TiebaStatic.Params.UGC_TYPE), 0);
                baijiahaoData.oriUgcVid = parse.getQueryParameter("ori_ugc_vid");
                if (!StringUtils.isNull(queryParameter3)) {
                    int e2 = b.a.e.e.m.b.e(queryParameter3, 0);
                    if (iVar.b() != null) {
                        b.a.q0.d1.v.a(queryParameter2, queryParameter, queryParameter4, e2, iVar.b(), baijiahaoData);
                    } else {
                        b.a.q0.d1.v.a(queryParameter2, queryParameter, queryParameter4, e2, this.f54372a.getPageContext(), baijiahaoData);
                    }
                } else {
                    if (StringUtils.isNull(queryParameter2)) {
                        queryParameter2 = "0";
                    }
                    if (iVar.b() != null) {
                        b.a.q0.d1.v.a(queryParameter2, queryParameter, queryParameter4, 0, iVar.b(), baijiahaoData);
                    } else {
                        b.a.q0.d1.v.a(queryParameter2, queryParameter, queryParameter4, 0, this.f54372a.getPageContext(), baijiahaoData);
                    }
                }
            } catch (Exception e3) {
                BdLog.e(e3);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54373a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54373a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<b.a.q0.h0.b> b2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f54373a.mIsAdd = false;
                if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2007002 || customResponsedMessage.getData() == null || (b2 = ((b.a.q0.h0.d) customResponsedMessage.getData()).b()) == null || b2.size() == 0) {
                    return;
                }
                this.f54373a.mViewController.B(b2);
                if (this.f54373a.isUseCurrType) {
                    this.f54373a.mViewController.z().setCurrentTabByType(this.f54373a.reloginGotoType);
                } else if (this.f54373a.getActivity().getIntent() != null && this.f54373a.getActivity().getIntent().getDataString() != null && this.f54373a.getActivity().getIntent().getDataString().startsWith(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
                    this.f54373a.mViewController.z().setCurrentTabByType(2);
                } else {
                    MainTabActivity mainTabActivity = this.f54373a;
                    mainTabActivity.setupIntent(mainTabActivity.getIntent());
                }
                this.f54373a.isUseCurrType = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, null));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921543, null));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921567, null));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921579, 0));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e0 implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54374a;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f54375e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e0 f54376f;

            public a(e0 e0Var, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {e0Var, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f54376f = e0Var;
                this.f54375e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.r0.k2.t.c.a(this.f54376f.f54374a.getPageContext(), this.f54375e).show();
                }
            }
        }

        public e0(MainTabActivity mainTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54374a = mainTabActivity;
        }

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void b(CustomDialogData customDialogData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customDialogData) == null) {
                b.a.e.e.m.e.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e1 extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MainTabActivity this$0;

        public e1(MainTabActivity mainTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mainTabActivity;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && intent.getAction().equals(TbConfig.getBroadcastActionNewVersion())) {
                TbadkCoreApplication.checkNeedShowNewVersion();
            }
        }

        public /* synthetic */ e1(MainTabActivity mainTabActivity, k kVar) {
            this(mainTabActivity);
        }
    }

    /* loaded from: classes9.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54377a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54377a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2007013) {
                this.f54377a.initTabsOnActivityCreated();
                if (this.f54377a.mViewController != null && this.f54377a.mViewController.z() != null) {
                    MainTabActivity mainTabActivity = this.f54377a;
                    mainTabActivity.reloginGotoType = mainTabActivity.mViewController.z().getCurrentTabType();
                }
                this.f54377a.isUseCurrType = true;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f54378e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f54379f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f54380g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f54381h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f54382i;
        public final /* synthetic */ ShareFromPBMsgData j;
        public final /* synthetic */ MainTabActivity k;

        public f0(MainTabActivity mainTabActivity, Thread2GroupShareView thread2GroupShareView, long j, String str, String str2, String str3, ShareFromPBMsgData shareFromPBMsgData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, thread2GroupShareView, Long.valueOf(j), str, str2, str3, shareFromPBMsgData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = mainTabActivity;
            this.f54378e = thread2GroupShareView;
            this.f54379f = j;
            this.f54380g = str;
            this.f54381h = str2;
            this.f54382i = str3;
            this.j = shareFromPBMsgData;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.k.HidenSoftKeyPad((InputMethodManager) this.k.getSystemService("input_method"), this.f54378e.getChatMsgView());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.k.getPageContext().getPageActivity(), this.f54379f, this.f54380g, this.f54381h, this.f54382i, 0, this.f54378e.getLeaveMsg(), this.j.toChatMessageContent())));
                aVar.dismiss();
                ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                if (shareItem == null || shareItem.e() == null) {
                    return;
                }
                Bundle e2 = shareItem.e();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 1).param("obj_type", e2.getInt("obj_type")).param("obj_param1", 3).param("fid", e2.getString("fid")).param("tid", e2.getString("tid")).param("obj_locate", 5));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54383a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54383a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (this.f54383a.mRecomPostTopic != null || (customResponsedMessage.getData() instanceof o1)) {
                if (customResponsedMessage.getData() != null) {
                    this.f54383a.mRecomPostTopic = (o1) customResponsedMessage.getData();
                }
                if (this.f54383a.mIsAdd || this.f54383a.mRecomPostTopic == null || !TbadkCoreApplication.isLogin()) {
                    return;
                }
                this.f54383a.mMainTabTopicTipController.j(this.f54383a.mRecomPostTopic.f13410a, this.f54383a.mRecomPostTopic.f13411b, this.f54383a.mRecomPostTopic.f13412c);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54384a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g0(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54384a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
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
                    this.f54384a.mViewController.z().changeStyle(1);
                } else if (TbadkCoreApplication.getInst().isThemeIconCover()) {
                    this.f54384a.mViewController.z().changeStyle(2);
                } else {
                    this.f54384a.mViewController.z().changeStyle(1);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54385a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54385a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            b.a.e.e.m.e.a().removeCallbacks(this.f54385a.startPollVideoMsg);
            b.a.e.e.m.e.a().postDelayed(this.f54385a.startPollVideoMsg, (customResponsedMessage.getData() instanceof Integer ? ((Integer) customResponsedMessage.getData()).intValue() : 0) * 1000);
        }
    }

    /* loaded from: classes9.dex */
    public class h0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f54386e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54387f;

        public h0(MainTabActivity mainTabActivity, Thread2GroupShareView thread2GroupShareView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, thread2GroupShareView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54387f = mainTabActivity;
            this.f54386e = thread2GroupShareView;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f54387f.HidenSoftKeyPad((InputMethodManager) this.f54387f.getSystemService("input_method"), this.f54386e.getChatMsgView());
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54388e;

        public i(MainTabActivity mainTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54388e = mainTabActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!b.a.q0.g1.b.c.d()) {
                    VideoRedIconRequest videoRedIconRequest = new VideoRedIconRequest();
                    if (this.f54388e.mViewController != null && this.f54388e.mViewController.z() != null && this.f54388e.mViewController.z().getCurrentTabType() == 22) {
                        videoRedIconRequest.setCallFrom("video_tab");
                    }
                    this.f54388e.sendMessage(videoRedIconRequest);
                }
                int videoRedIconInterval = TbSingleton.getInstance().getVideoRedIconInterval();
                if (videoRedIconInterval > 5) {
                    b.a.e.e.m.e.a().postDelayed(this.f54388e.startPollVideoMsg, videoRedIconInterval * 1000);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i0 extends b.a.q0.o0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54389a;

        public i0(MainTabActivity mainTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54389a = mainTabActivity;
        }

        @Override // b.a.q0.o0.b
        public boolean canStat(b.a.q0.o0.d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // b.a.q0.o0.b
        public int getMaxCost() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? b.a.q0.o0.e.b().c() : invokeV.intValue;
        }

        @Override // b.a.q0.o0.b
        public boolean isCurrentPageCanBeAddToSourceTrace() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54390a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54390a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f54390a.dealForceConfirmSwitchTDouToYBean();
        }
    }

    /* loaded from: classes9.dex */
    public class j0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54391a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j0(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54391a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                this.f54391a.isAccountStatChanged = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
                b.a.q0.s.e0.b.j().C("key_feedback_tip");
                b.a.q0.s.e0.b.j().C("key_feedback_tip_show");
                b.a.q0.s.e0.b.j().C("key_feedback_tip_tab_show");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016560));
                if (this.f54391a.mBdTokenController != null) {
                    this.f54391a.mBdTokenController.l(UtilHelper.getClipBoardContent());
                }
                if (this.f54391a.mViewController != null) {
                    this.f54391a.mViewController.C();
                }
                this.f54391a.clearConcernCacheWhenVersionUpdate();
                this.f54391a.checkCommitInterestInfo();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54392a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54392a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || this.f54392a.mViewController == null) {
                return;
            }
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            MainTabActivity mainTabActivity = this.f54392a;
            if (currentActivity == mainTabActivity) {
                boolean z = false;
                mainTabActivity.isEditorVisible = b.a.e.e.m.b.b(customResponsedMessage.getData().toString(), false);
                MainTabActivity mainTabActivity2 = this.f54392a;
                this.f54392a.mViewController.G((mainTabActivity2.isEditorVisible || mainTabActivity2.isKeyboardVisible) ? true : true);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class k0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54393a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k0(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54393a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                GameCenterHelper.isGamePluginInit = ((Boolean) customResponsedMessage.getData()).booleanValue();
                this.f54393a.checkPluginEntranceState();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54394a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54394a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && b.a.q0.s.b0.b.b() == null) {
                b.a.r0.o3.b bVar = new b.a.r0.o3.b();
                bVar.g(this.f54394a);
                b.a.q0.s.b0.b.h(bVar);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54395a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l0(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54395a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (MainTabActivity.syncHasFinish) {
                this.f54395a.doSyncFinishTask();
            }
            if (this.f54395a.videoChannelNoticeNeedShow) {
                this.f54395a.doVideoChannelNoticeShow();
            }
            MainTabActivity mainTabActivity = this.f54395a;
            if (mainTabActivity.myCreateCenterTipNeedShow) {
                mainTabActivity.doMyCreateCenterTip();
            }
            MainTabActivity mainTabActivity2 = this.f54395a;
            if (mainTabActivity2.isCheckNewUserRedPackageRunnable) {
                mainTabActivity2.isCheckNewUserRedPackageRunnable = false;
                b.a.e.e.m.e.a().removeCallbacks(this.f54395a.mCheckNewUserRedPackageRunnable);
                b.a.e.e.m.e.a().postDelayed(this.f54395a.mCheckNewUserRedPackageRunnable, 200L);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54396a;

        /* loaded from: classes9.dex */
        public class a implements b.a.q0.s.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(m mVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // b.a.q0.s.e
            public void onPermissionResult(boolean z) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                    KuangFloatingViewController.getInstance().showFloatingView();
                    TiebaStatic.log(new StatisticItem("c12264").param("obj_type", 3));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54396a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || b.a.e.e.p.k.isEmpty((String) customResponsedMessage.getData())) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (KuangFloatingViewController.getInstance().init()) {
                KuangFloatingViewController.getInstance().setInfo(str);
                this.f54396a.getPageContext().getOrignalPage().grantWindowPermission(new a(this), false);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class m0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54397a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m0(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54397a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                boolean unused = MainTabActivity.syncHasFinish = true;
                TbadkCoreApplication.getInst().syncHasFinish = true;
                if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                    return;
                }
                this.f54397a.doSyncFinishTask();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class n extends b.a.q0.d1.i0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54398a;

        public n(MainTabActivity mainTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54398a = mainTabActivity;
        }

        @Override // b.a.q0.d1.i0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                TbadkCoreApplication.getInst().setUsed();
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class n0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54399a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n0(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54399a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean z = false;
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    b.a.e.g.c.d();
                    b.a.e.g.c.j();
                    this.f54399a.lastDay = UtilHelper.getCurrentDay();
                    b.a.q0.s.e0.b.j().w("last_resume_time", TbSingleton.getInstance().getLastResumeTime());
                    if (!this.f54399a.isEnterImageViewActivity) {
                        this.f54399a.stopYoungsterUseTimeTask();
                        return;
                    } else {
                        this.f54399a.isEnterImageViewActivity = false;
                        return;
                    }
                }
                String currentDay = UtilHelper.getCurrentDay();
                if (!StringUtils.isNull(currentDay) && !currentDay.equals(this.f54399a.lastDay)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
                }
                if (this.f54399a.mCancelController == null) {
                    this.f54399a.mCancelController = new b.a.r0.t3.b();
                }
                this.f54399a.mCancelController.c(this.f54399a.mCancelController.f23852c);
                this.f54399a.mCancelController.f23852c = TbadkCoreStatisticKey.AntiLocateValue.LOCATE_HOT_BOOT;
                if (b.a.q0.g1.b.c.d()) {
                    int i2 = Calendar.getInstance().get(11);
                    b.a.q0.g1.b.c.f12608a = (i2 >= 23 || i2 < 7) ? true : true;
                    this.f54399a.stopYoungsterUseTimeTask();
                    this.f54399a.startYoungsterUseTimeTask();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54400e;

        public o(MainTabActivity mainTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54400e = mainTabActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f54400e.mTouchable = true;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class o0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54401a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o0(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54401a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f54401a.isEnterImageViewActivity = true;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54402e;

        public p(MainTabActivity mainTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54402e = mainTabActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.q0.k.a.a();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class p0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54403a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p0(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54403a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    ((Integer) data).intValue();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54404e;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.e.g.c.b();
                }
            }
        }

        public q(MainTabActivity mainTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54404e = mainTabActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && TbadkCoreApplication.getInst().isMainProcess(false)) {
                new Thread(new a(this)).start();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class q0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54405a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q0(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54405a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class r extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54406a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(MainTabActivity mainTabActivity, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54406a = mainTabActivity;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z = responsedMessage instanceof ProfileSocketResponseMessage;
                if (z || (responsedMessage instanceof ProfileHttpResponseMessage)) {
                    if (responsedMessage.getOrginalMessage() != null) {
                        this.f54406a.getUniqueId();
                    }
                    if (z) {
                        this.f54406a.onResponseMessage((ProfileSocketResponseMessage) responsedMessage);
                    }
                    if (responsedMessage instanceof ProfileHttpResponseMessage) {
                        this.f54406a.onResponseMessage((ProfileHttpResponseMessage) responsedMessage);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class r0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54407a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r0(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54407a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean) || this.f54407a.mViewController == null || this.f54407a.mViewController.z() == null) {
                return;
            }
            if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.f54407a.mViewController.z().getTabWrapper().animate().translationY(this.f54407a.mViewController.z().getTabWrapper().getHeight()).setDuration(200L).start();
            } else {
                this.f54407a.mViewController.z().getTabWrapper().animate().translationY(0.0f).setDuration(400L).start();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class s extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54408a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54408a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f54408a.updateProfileInfo();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class s0 extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54409e;

        public s0(MainTabActivity mainTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54409e = mainTabActivity;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.q0.g1.b.c.f12608a = true;
                this.f54409e.stopYoungsterUseTimeTask();
                this.f54409e.startYoungsterUseTimePeriodTask();
                this.f54409e.youngsterNightTimer.cancel();
                this.f54409e.youngsterNightTimer = null;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54410a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54410a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || this.f54410a.mViewController == null || this.f54410a.mViewController.z() == null || this.f54410a.mViewController.z().getCurrentTabType() == 21) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = this.f54410a.mViewController.z().getFragmentTabWidget();
            if (fragmentTabWidget.getChildCount() < 2) {
                return;
            }
            MainTabActivity mainTabActivity = this.f54410a;
            mainTabActivity.mCategoryTipController = new b.a.r0.f0.g(mainTabActivity.getPageContext(), fragmentTabWidget.getChildAt(2));
            this.f54410a.mCategoryTipController.g0(R.drawable.bg_tip_blue_down);
            this.f54410a.mCategoryTipController.L(2);
            this.f54410a.mCategoryTipController.O(32);
            this.f54410a.mCategoryTipController.h0(true);
            this.f54410a.mCategoryTipController.k0(-b.a.e.e.p.l.g(this.f54410a, R.dimen.tbds10));
            this.f54410a.mCategoryTipController.X(R.color.CAM_X0101);
            this.f54410a.mCategoryTipController.P(R.dimen.tbds54);
            this.f54410a.mCategoryTipController.T(999);
            this.f54410a.mCategoryTipController.N(5000);
            this.f54410a.mCategoryTipController.a0(b.a.e.e.p.l.g(this.f54410a, R.dimen.tbds44));
            this.f54410a.mCategoryTipController.o0(str, "categoryUpdate", false, true);
        }
    }

    /* loaded from: classes9.dex */
    public class t0 extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54411e;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ t0 f54412e;

            public a(t0 t0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {t0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f54412e = t0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f54412e.f54411e.stopYoungsterUseTimeTask();
                    if (b.a.q0.g1.b.b.e()) {
                        return;
                    }
                    this.f54412e.f54411e.startYoungsterUseTimePeriodTask();
                }
            }
        }

        public t0(MainTabActivity mainTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54411e = mainTabActivity;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.e.e.m.e.a().post(new a(this));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class u extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54413a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54413a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f54413a.mViewController == null || this.f54413a.mViewController.z() == null || this.f54413a.mViewController.z().getCurrentTabType() == 22) {
                return;
            }
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                this.f54413a.videoChannelNoticeNeedShow = true;
            } else {
                this.f54413a.doVideoChannelNoticeShow();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class u0 extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54414e;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ u0 f54415e;

            public a(u0 u0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {u0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f54415e = u0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && b.a.q0.g1.b.b.e()) {
                    this.f54415e.f54414e.stopYoungsterUseTimeTask();
                }
            }
        }

        public u0(MainTabActivity mainTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54414e = mainTabActivity;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.e.e.m.e.a().post(new a(this));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54416a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54416a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001377) {
                this.f54416a.finish();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class v0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54417a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v0(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54417a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.a.q0.u.n nVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof b.a.q0.u.n) || (nVar = (b.a.q0.u.n) customResponsedMessage.getData()) == null || StringUtils.isNull(nVar.f14159a)) {
                return;
            }
            b.a.q0.t0.b.j(nVar);
            if (StringUtils.isNull(nVar.f14161c)) {
                UrlManager.getInstance().dealOneLink(this.f54417a.getPageContext(), new String[]{nVar.f14159a});
            } else {
                UrlManager.getInstance().dealOneLink(this.f54417a.getPageContext(), new String[]{nVar.f14159a, nVar.f14161c});
            }
        }
    }

    /* loaded from: classes9.dex */
    public class w extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54418a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54418a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f54418a.mViewController == null || this.f54418a.mViewController.z() == null || this.f54418a.mViewController.z().getCurrentTabType() == 8) {
                return;
            }
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                this.f54418a.myCreateCenterTipNeedShow = true;
            } else {
                this.f54418a.doMyCreateCenterTip();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class w0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54419a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w0(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54419a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f54419a.mWriteTab == null) {
                return;
            }
            this.f54419a.mWriteTab.z();
        }
    }

    /* loaded from: classes9.dex */
    public class x implements CheckRealNameModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54420a;

        public x(MainTabActivity mainTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54420a = mainTabActivity;
        }

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i2, String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, str2, obj}) == null) && CheckRealNameModel.TYPE_APP_FIRST_START.equals(str2) && i2 == 1990055) {
                TiebaStatic.log("c12138");
                this.f54420a.mViewController.O(this.f54420a.getResources().getString(R.string.check_real_name_message));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class x0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54421e;

        public x0(MainTabActivity mainTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54421e = mainTabActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                    this.f54421e.isCheckNewUserRedPackageRunnable = true;
                } else {
                    this.f54421e.checkNewUserRedPackage();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class y extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54422a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54422a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && b.a.e.e.p.l.D()) {
                this.f54422a.checkRealName();
                if (MainTabActivity.syncHasFinish) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class y0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54423a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y0(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54423a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && !TbSingleton.getInstance().isNewUserRedPackageShowed() && this.f54423a.isResumed && TbSingleton.getInstance().hasPerformedFirstLoginTest()) {
                b.a.e.e.m.e.a().removeCallbacks(this.f54423a.mCheckNewUserRedPackageRunnable);
                b.a.e.e.m.e.a().postDelayed(this.f54423a.mCheckNewUserRedPackageRunnable, 200L);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class z implements g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Intent f54424a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54425b;

        public z(MainTabActivity mainTabActivity, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, intent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54425b = mainTabActivity;
            this.f54424a = intent;
        }

        @Override // b.a.q0.a.g.b
        public void onCallBack(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) || hashMap == null || this.f54424a == null) {
                return;
            }
            Object obj = hashMap.get(b.a.q0.a.g.E);
            int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : -1;
            Object obj2 = hashMap.get(b.a.q0.a.g.F);
            String str = obj2 instanceof String ? (String) obj2 : null;
            Object obj3 = hashMap.get(b.a.q0.a.g.D);
            String str2 = obj3 instanceof String ? (String) obj3 : null;
            if (intValue != -1) {
                this.f54424a.putExtra("is_from_scheme", true);
                this.f54424a.putExtra("locate_type", intValue);
                this.f54424a.putExtra("sub_locate_type", str);
                this.f54424a.putExtra("sub_tab_name", str2);
                b.a.q0.s.b0.b.f12896b = intValue;
                Object obj4 = hashMap.get(b.a.q0.a.g.G);
                String str3 = obj4 instanceof String ? (String) obj4 : null;
                Object obj5 = hashMap.get(b.a.q0.a.g.H);
                String str4 = obj5 instanceof String ? (String) obj5 : null;
                this.f54424a.putExtra(b.a.q0.a.g.G, str3);
                this.f54424a.putExtra(b.a.q0.a.g.H, str4);
            }
            b.a.q0.a.d.y().L(true);
            if (intValue == 1 && "ForumSquare".equals(str)) {
                b.a.q0.s.b0.b.f12897c = b.a.q0.s.b0.b.f12899e;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921528));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class z0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f54426a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z0(MainTabActivity mainTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54426a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof b.a.q0.u.k) && ViewHelper.checkUpIsLogin(this.f54426a.getPageContext().getPageActivity())) {
                this.f54426a.showWriteThreadView();
            }
        }
    }

    public MainTabActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.needAnim = false;
        this.reloginGotoType = -1;
        this.isUseCurrType = false;
        this.mFrom = null;
        this.mIsAdd = false;
        this.exitTime = 0L;
        this.leaveTime = 0L;
        this.mLastSyncTime = -1L;
        this.isAccountStatChanged = false;
        this.mPreUserId = "";
        this.isEditorVisible = false;
        this.isKeyboardVisible = false;
        this.doRefresh = true;
        this.mCurrentTabIndex = -1;
        this.lastUiMode = 16;
        this.isResumed = false;
        this.isCreated = false;
        this.isEnterImageViewActivity = false;
        this.isCheckNewUserRedPackageRunnable = false;
        this.mEditorListener = new k(this, 2010045);
        this.mCloseMainTablistener = new v(this, 2001377);
        this.skinTypeChangeListener = new g0(this, 2001304);
        this.bigdayModifyNavbarListener = new r0(this, 2921348);
        this.showWriteThreadListener = new z0(this, 2921452);
        this.mLikeForumListener = new a1(this, 2001437);
        this.mEnterForumTabClickListener = new b1(this, 2001384);
        this.mOnlineListener = new c1(this, 1001);
        this.mJumpPbListener = new d1(this, 2001609);
        this.mPersonInfoChangeListener = new a(this, 2001247);
        this.mShowPostVideoSuccessListener = new b(this, 2001374);
        this.mVideoClickListener = new c(this, 2921610);
        this.mBackHomeListener = new d(this, 2921611);
        this.mAddTablistener = new e(this, 2007002);
        this.mRefreshTablistener = new f(this, 2007013);
        this.mRefreshTiplistener = new g(this, 2921333);
        this.mStartPollVideoMsgListener = new h(this, 2921579);
        this.startPollVideoMsg = new i(this);
        this.mForceConfirmListener = new j(this, 2921543);
        this.mSetMainTabInstListener = new l(this, 2007005);
        this.mShowGoBackShouBaiListener = new m(this, 2921380);
        this.mPersonInfoMsgListener = new r(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
        this.updateMainTabProfileListener = new s(this, 2921504);
        this.mCategoryUpdateListener = new t(this, 2921491);
        this.videoChannelNoticeNeedShow = false;
        this.mVideoChannelNoticeListener = new u(this, 2921567);
        this.myCreateCenterTipNeedShow = false;
        this.mMyCreateCenterListener = new w(this, 2921538);
        this.checkRealNameCallBack = new x(this);
        this.networkChangedListener = new y(this, 2000994);
        this.mAccountChangedListener = new j0(this, 2005016);
        this.mGameCenterInitListener = new k0(this, 2016509);
        this.mSplashCloseListener = new l0(this, 2921636);
        this.mSyncFinishListener = new m0(this, 2001371);
        this.mBackgroundChangeListener = new n0(this, 2001011);
        this.enterImageViewActivityListener = new o0(this, 2010000);
        this.youngsterUseTimerListener = new p0(this, 2921561);
        this.mYoungsterModeChangeListener = new q0(this, 2921509);
        this.mToHotTopicListener = new v0(this, 2016493);
        this.mOnScreenSizeChangeListener = new w0(this, 2921414);
        this.mCheckNewUserRedPackageRunnable = new x0(this);
        this.showNewUserRedPackageListener = new y0(this, 2921532);
    }

    private void callWindowMissed() {
        View currentFocus;
        InputMethodManager inputMethodManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65589, this) == null) || (currentFocus = getCurrentFocus()) == null || currentFocus.getWindowToken() == null || (inputMethodManager = (InputMethodManager) getSystemService("input_method")) == null) {
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
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65590, this) == null) && this.mLikeForumNum == 1) {
            createLikeFirstForumTips();
            if (TbadkCoreApplication.getInst().getCurrentActivity() != this || this.mCurrentTabIndex.intValue() == 1) {
                return;
            }
            showLikeFirstForumTips();
        }
    }

    private boolean checkAutoSyncInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65591, this)) == null) {
            if (-1 == this.mLastSyncTime) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.mLastSyncTime;
            return currentTimeMillis <= 0 || currentTimeMillis >= 300000;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkCommitInterestInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65592, this) == null) {
            String p2 = b.a.q0.s.e0.b.j().p("user_interest_info", null);
            if (TextUtils.isEmpty(p2)) {
                return;
            }
            b.a.q0.s.e0.b.j().C("user_interest_info");
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GUIDE_INTEREST_COMMIT);
            httpMessage.addParam("interestList", p2);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void checkCreateCenterTip() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65593, this) == null) && CreateCenterTipSwitch.isOn()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921538));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPluginEntranceState() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65594, this) == null) && SwitchManager.getInstance().findType(GameEnterSwitch.GAME_ENTER_KEY) == 1 && GameCenterHelper.isGamePluginInit) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016510));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkRealName() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65595, this) == null) {
            String str = "check_real_name" + TbConfig.getVersion();
            if (b.a.q0.s.e0.b.j().g(str, true) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && b.a.e.e.p.l.D()) {
                this.mCheckRealNameModel.x(CheckRealNameModel.TYPE_APP_FIRST_START);
                b.a.q0.s.e0.b.j().t(str, false);
            }
        }
    }

    private void checkSchemeFromIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65596, this, intent) == null) || intent == null) {
            return;
        }
        String dataString = intent.getDataString();
        UtilHelper.clearClipBoardBySchemaParam(dataString);
        if (!StringUtils.isNull(dataString) && dataString.startsWith(SCHEME_MAINTAB)) {
            String decode = Uri.decode(intent.getData().getEncodedPath());
            if (StringUtils.isNull(decode)) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_type", 1).param(TiebaStatic.Params.OBJ_TO, 1).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
                b.a.q0.a.w.a(param, decode);
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
                b.a.q0.a.w.b(statisticItem, paramPair);
                statisticItem.param("obj_locate", paramPair.get("obj_locate"));
                statisticItem.param("obj_type", 1);
                statisticItem.param("obj_source", paramPair.get("obj_source"));
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, paramPair.get(TiebaStatic.Params.OBJ_PARAM2));
                statisticItem.param(TiebaStatic.Params.OBJ_TO, 1);
                statisticItem.param("obj_id", paramPair.get(TiebaStatic.Params.BDID));
                statisticItem.param("obj_name", TbadkCoreApplication.getInst().getStartType());
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, 1);
                if (!b.a.e.e.p.k.isEmpty(paramPair.get("ext_log"))) {
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
            b.a.q0.a.d.y().L(true);
        } else if (!StringUtils.isNull(dataString) && (dataString.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT) || dataString.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT_ZM) || dataString.startsWith(UrlSchemaHelper.SCHEMA_LIVE_SDK) || dataString.startsWith(UrlSchemaHelper.SCHEMA_CHUSHOU_LIVE_SDK))) {
            String dataString2 = intent.getDataString();
            if (!StringUtils.isNull(dataString2) && PermissionUtil.isAgreePrivacyPolicy()) {
                UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{dataString2});
                b.a.q0.a.d.y().L(true);
            }
        } else if (!StringUtils.isNULL(dataString) && dataString.startsWith(b.a.q0.a.g.f11777a)) {
            b.a.q0.a.g.b().e(intent.getData(), new z(this, intent));
        }
        String stringExtra = intent.getStringExtra(MainTabActivityConfig.TARGET_SCHEME);
        if (StringUtils.isNull(stringExtra)) {
            return;
        }
        b.a.e.e.m.e.a().postDelayed(new a0(this, stringExtra), this.isCreated ? 0L : DeviceInfoUtil.getMainTabActJumpOtherDelayTime());
        getIntent().removeExtra(MainTabActivityConfig.TARGET_SCHEME);
        GrowthStatsUtil.statisticChannel("push", stringExtra);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkVersion(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65597, this, str) == null) || str == null || TbadkCoreApplication.getInst().getConfigVersion() == null || !checkAutoSyncInterval()) {
            return;
        }
        this.mLastSyncTime = System.currentTimeMillis();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearConcernCacheWhenVersionUpdate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65598, this) == null) {
            String str = b.a.q0.s.e0.b.n("key_is_clear_concern_cache_when_version_update") + "_" + TbConfig.getVersion();
            if (b.a.q0.s.e0.b.j().g(str, false)) {
                return;
            }
            b.a.q0.s.r.a.f();
            try {
                b.a.q0.s.r.a.e("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).g("0", null);
                b.a.q0.s.e0.b.j().t(str, true);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLikeFirstForumTips() {
        b.a.r0.f0.g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65599, this) == null) && (gVar = this.mLikeFirstForumTipsController) != null && gVar.J()) {
            this.mLikeFirstForumTipsController.I();
        }
    }

    public static void clearVideoChannelTabImg() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65600, null) == null) {
            b.a.q0.h0.c cVar = new b.a.q0.h0.c();
            cVar.f12618g = "";
            cVar.f12616e = 22;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921492, cVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createLikeFirstForumTips() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65601, this) == null) {
            FragmentTabWidget fragmentTabWidget = this.mViewController.z().getFragmentTabWidget();
            if (fragmentTabWidget.getChildCount() < 2) {
                return;
            }
            b.a.r0.f0.g gVar = new b.a.r0.f0.g(getPageContext(), fragmentTabWidget.getChildAt(1));
            this.mLikeFirstForumTipsController = gVar;
            gVar.g0(R.drawable.bg_tip_blue_down);
            this.mLikeFirstForumTipsController.L(2);
            this.mLikeFirstForumTipsController.O(32);
            this.mLikeFirstForumTipsController.h0(true);
            this.mLikeFirstForumTipsController.k0(-b.a.e.e.p.l.g(this, R.dimen.tbds10));
            this.mLikeFirstForumTipsController.X(R.color.CAM_X0101);
            this.mLikeFirstForumTipsController.P(R.dimen.tbds54);
            this.mLikeFirstForumTipsController.T(1);
            this.mLikeFirstForumTipsController.N(4000);
            this.mLikeFirstForumTipsController.a0(b.a.e.e.p.l.g(this, R.dimen.tbds44));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealForceConfirmSwitchTDouToYBean() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65602, this) == null) && !this.mIsAdd && this.mYYBeanForceConfirmDialog == null && TbadkCoreApplication.isLogin() && CurrencySwitchUtil.isNeedConfirmTDouToYBeanSwitchOpen()) {
            CurrencySwitchTDouYBeanDialog currencySwitchTDouYBeanDialog = new CurrencySwitchTDouYBeanDialog(getPageContext());
            this.mYYBeanForceConfirmDialog = currencySwitchTDouYBeanDialog;
            currencySwitchTDouYBeanDialog.showDialog();
        }
    }

    private void dealIntent(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65603, this, context, intent) == null) {
            UtilHelper.commenDealIntent(context, intent);
            TbadkCoreApplication.setIntent(null);
        }
    }

    private void dispatchWriteCallbakcData(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65604, this, intent) == null) || intent == null) {
            return;
        }
        PostWriteCallBackData postWriteCallBackData = null;
        try {
            postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921030, postWriteCallBackData));
        b.a.r0.o3.d dVar = this.mViewController;
        if (dVar == null || dVar.u(postWriteCallBackData)) {
            return;
        }
        this.mViewController.R(postWriteCallBackData);
    }

    private void firstLoginTest() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65605, this) == null) || TbSingleton.getInstance().hasPerformedFirstLoginTest()) {
            return;
        }
        TbSingleton.getInstance().setHasPerformedFirstLoginTest(true);
        if (b.a.q0.b.d.n()) {
            if (TbadkCoreApplication.isLogin() || LoginActivity.class.getName().equals(b.a.e.e.p.l.v())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2921535, this));
        } else if (b.a.q0.b.d.o()) {
            if (TbadkApplication.getInst().isNeedNewUserLead()) {
                InterestGuideActivityConfig interestGuideActivityConfig = new InterestGuideActivityConfig(this, 4);
                interestGuideActivityConfig.setRequestCode(25060);
                interestGuideActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, interestGuideActivityConfig));
            }
        } else if (TbadkApplication.getInst().isNeedNewUserLead()) {
            InterestGuideActivityConfig interestGuideActivityConfig2 = new InterestGuideActivityConfig(this, 4);
            interestGuideActivityConfig2.setRequestCode(25060);
            interestGuideActivityConfig2.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, interestGuideActivityConfig2));
        }
    }

    private ShareFromPBMsgData getShareMsgData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65606, this)) == null) {
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
        return (ShareFromPBMsgData) invokeV.objValue;
    }

    private void handleShareFriendForum(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65607, this, intent) == null) {
            long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
            String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
            String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
            showConfirmShareToPersonDialog(getShareMsgData(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
        }
    }

    private boolean handlerExitApp(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65608, this, intent)) == null) {
            if (intent == null || !intent.getBooleanExtra(MainTabActivityConfig.EXIT_APP, false)) {
                return false;
            }
            finish();
            System.exit(0);
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handlerYoungsterNightTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65609, this)) == null) {
            int i2 = Calendar.getInstance().get(11);
            if (i2 < 23 && i2 >= 7) {
                b.a.q0.g1.b.c.f12608a = false;
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
                timer2.schedule(new s0(this), time, 1000L);
                return false;
            }
            b.a.q0.g1.b.c.f12608a = true;
            stopYoungsterUseTimeTask();
            startYoungsterUseTimePeriodTask();
            return true;
        }
        return invokeV.booleanValue;
    }

    private void manageService() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65610, this) == null) || System.currentTimeMillis() - this.leaveTime < SERVICE_BETWEEN_TIME) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", "start");
        hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
        hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
        MessageManager.getInstance().sendMessage(new CustomMessage(2006002, hashMap));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005013, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
        this.leaveTime = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onResponseMessage(ProfileHttpResponseMessage profileHttpResponseMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65611, this, profileHttpResponseMessage) == null) || profileHttpResponseMessage == null || profileHttpResponseMessage.GetUser() == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65613, this) == null) {
            registerListener(this.mCloseMainTablistener);
            this.mAddTablistener.setPriority(100);
            registerListener(this.mAddTablistener);
            this.mVideoClickListener.setPriority(2);
            registerListener(this.mVideoClickListener);
            registerListener(this.mBackHomeListener);
            registerListener(this.mRefreshTablistener);
            registerListener(this.mRefreshTiplistener);
            registerListener(this.mForceConfirmListener);
            registerListener(this.mSetMainTabInstListener);
            registerListener(this.mGameCenterInitListener);
            registerListener(this.mPersonInfoChangeListener);
            registerListener(this.skinTypeChangeListener);
            registerListener(this.bigdayModifyNavbarListener);
            this.mUpdateReceiver = new e1(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
            registerReceiver(this.mUpdateReceiver, intentFilter);
            this.packageChangedReceiver = new PackageChangedReceiver();
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction(PackageChangedReceiver.ACTION_INSTALL);
            intentFilter2.addAction(PackageChangedReceiver.ACTION_UNINSTALL);
            intentFilter2.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter2.addAction("android.intent.action.PACKAGE_CHANGED");
            intentFilter2.addDataScheme("package");
            registerReceiver(this.packageChangedReceiver, intentFilter2);
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
            registerListener(this.mVideoChannelNoticeListener);
            registerListener(this.mMyCreateCenterListener);
            registerListener(this.updateMainTabProfileListener);
            registerListener(this.showNewUserRedPackageListener);
            registerListener(this.mStartPollVideoMsgListener);
        }
    }

    private void registerNavigationBarEditStateListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65614, this) == null) {
            registerListener(new d0(this, 2007009));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setupIntent(Intent intent) {
        b.a.r0.o3.d dVar;
        int a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65615, this, intent) == null) || intent == null || (dVar = this.mViewController) == null || dVar.z() == null) {
            return;
        }
        try {
            if (intent.hasExtra("locate_type")) {
                a2 = intent.getIntExtra("locate_type", 1);
            } else {
                a2 = this.mAppEntranceModel.a();
            }
            this.mViewController.z().setCurrentTabByType(a2);
        } catch (Throwable th) {
            BdLog.e(th);
            finish();
        }
    }

    private void showConfirmShareToPersonDialog(ShareFromPBMsgData shareFromPBMsgData, long j2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65616, this, new Object[]{shareFromPBMsgData, Long.valueOf(j2), str, str2, str3}) == null) || shareFromPBMsgData == null) {
            return;
        }
        b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(getPageContext().getPageActivity());
        Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
        thread2GroupShareView.setData(shareFromPBMsgData);
        aVar.setContentViewSize(1);
        aVar.setContentView(thread2GroupShareView);
        aVar.setPositiveButton(R.string.share, new f0(this, thread2GroupShareView, j2, str, str2, str3, shareFromPBMsgData));
        aVar.setNegativeButton(R.string.cancel, new h0(this, thread2GroupShareView));
        aVar.setCanceledOnTouchOutside(true);
        aVar.create(getPageContext()).show();
        if (b.a.e.e.p.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
            return;
        }
        thread2GroupShareView.loadImageIcon(shareFromPBMsgData.getImageUrl(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLikeFirstForumTips() {
        b.a.r0.f0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65617, this) == null) || (gVar = this.mLikeFirstForumTipsController) == null || gVar.J()) {
            return;
        }
        b.a.r0.f0.g gVar2 = this.mLikeFirstForumTipsController;
        String string = getString(R.string.enterforumtab_like_forum_tips);
        gVar2.m0(string, "first_like_forum_enterforumtab_tips" + TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startYoungsterUseTimePeriodTask() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65618, this) == null) && this.youngsterUseTimer == null) {
            this.youngsterUseTimer = new Timer();
            u0 u0Var = new u0(this);
            this.youngsterUseTimeTask = u0Var;
            this.youngsterUseTimer.schedule(u0Var, 1000L, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startYoungsterUseTimeTask() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65619, this) == null) && this.youngsterUseTimer == null) {
            this.youngsterUseTimer = new Timer();
            t0 t0Var = new t0(this);
            this.youngsterUseTimeTask = t0Var;
            this.youngsterUseTimer.schedule(t0Var, b.a.q0.g1.b.b.c() ? 1000L : YOUNGSTER_USE_TIME_MAX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopYoungsterUseTimeTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65620, this) == null) {
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
    }

    private void unregReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65621, this) == null) {
            e1 e1Var = this.mUpdateReceiver;
            if (e1Var != null) {
                unregisterReceiver(e1Var);
            }
            PackageChangedReceiver packageChangedReceiver = this.packageChangedReceiver;
            if (packageChangedReceiver != null) {
                unregisterReceiver(packageChangedReceiver);
            }
        }
    }

    public void checkBackgroundPermissionDialog(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            new b.a.q0.s.s.a(activity).setTitle(R.string.confirm_title).setCancelable(false).setMessageId(R.string.background_process_permission).setPositiveButton(R.string.now_goto_setting, new c0(this)).setNegativeButton(R.string.next_time, new b0(this)).create(b.a.e.a.j.a(activity)).show();
        }
    }

    public void checkNewUserRedPackage() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || TbSingleton.getInstance().getNewUserRedPackageData() == null) {
            return;
        }
        TbSingleton.getInstance().setNewUserRedPackageShowed(true);
        sendMessage(new CustomMessage(2002001, new NewUserRedPackageActivityConfig(this, TbSingleton.getInstance().getNewUserRedPackageData())));
        TbSingleton.getInstance().setNewUserRedPackageData(null);
    }

    public void clearMyCreateCenterTips() {
        b.a.r0.f0.g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (gVar = this.mMyTipController) != null && gVar.J()) {
            this.mMyTipController.I();
            this.mMyTipController = null;
        }
    }

    public void clearNewCategoryTips() {
        b.a.r0.f0.g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (gVar = this.mCategoryTipController) != null && gVar.J()) {
            this.mCategoryTipController.I();
            this.mCategoryTipController = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, keyEvent)) == null) {
            if (!MainTabActivityConfig.IS_BACK_CLOSE_ALL_ACTIVITY && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
                if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                    return false;
                }
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016322, (Class) null);
                if (runTask == null || !((Boolean) runTask.getData()).booleanValue()) {
                    CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2016323, (Class) null);
                    if (runTask2 == null || !((Boolean) runTask2.getData()).booleanValue()) {
                        b.a.r0.d4.f fVar = this.mWriteTab;
                        if (fVar != null && fVar.l()) {
                            this.mWriteTab.k(true);
                            return true;
                        } else if (this.mViewController.D()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007010));
                            return true;
                        } else {
                            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(2921405, Boolean.class, Boolean.FALSE);
                            if (runTask3 == null || runTask3.getData() == null || !(runTask3.getData() instanceof Boolean) || !((Boolean) runTask3.getData()).booleanValue()) {
                                if (TbSingleton.getInstance().isFromFeedVideoClick()) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921612));
                                    return true;
                                }
                                if (System.currentTimeMillis() - this.exitTime > 2000) {
                                    showToast(R.string.double_back_quit);
                                    this.exitTime = System.currentTimeMillis();
                                } else if (UtilHelper.isBackgroundProcessLimitNone() && Build.VERSION.SDK_INT >= 14) {
                                    checkBackgroundPermissionDialog(getPageContext().getPageActivity());
                                    return true;
                                } else {
                                    processBeforeGoBack();
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
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            if (this.mTouchable) {
                if (this.mViewController.z() == null || this.mViewController.z().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1 || !this.mViewController.D()) {
                    return super.dispatchTouchEvent(motionEvent);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void doMyCreateCenterTip() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            FragmentTabWidget fragmentTabWidget = this.mViewController.z().getFragmentTabWidget();
            if (fragmentTabWidget.getChildCount() < 4) {
                return;
            }
            String string = getString(R.string.my_create_center_tips);
            b.a.r0.f0.g gVar = new b.a.r0.f0.g(getPageContext(), fragmentTabWidget.getChildAt(4));
            this.mMyTipController = gVar;
            gVar.g0(R.drawable.bg_tip_blue_dropdown_right);
            this.mMyTipController.L(2);
            this.mMyTipController.O(48);
            this.mMyTipController.h0(true);
            this.mMyTipController.j0(-b.a.e.e.p.l.g(this, R.dimen.tbds62));
            this.mMyTipController.X(R.color.CAM_X0101);
            this.mMyTipController.e0(R.dimen.T_X08);
            this.mMyTipController.T(1);
            this.mMyTipController.N(3000);
            this.mMyTipController.d0(b.a.e.e.p.l.g(this, R.dimen.tbds25));
            this.mMyTipController.a0(b.a.e.e.p.l.g(this, R.dimen.tbds33));
            this.mMyTipController.b0(b.a.e.e.p.l.g(this, R.dimen.tbds36));
            this.mMyTipController.c0(b.a.e.e.p.l.g(this, R.dimen.tbds36));
            this.mMyTipController.o0(string, "mycreatecentertip", true, true);
        }
    }

    public void doSyncFinishTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            b.a.r0.o3.d dVar = this.mViewController;
            if (dVar != null && dVar.y() != null && this.mViewController.y().getAnimationView() != null && this.mViewController.y().getAnimationView().getVisibility() != 0) {
                this.mViewController.y().setLottieView(false);
            }
            if (TbadkCoreApplication.getInst().getActivityPrizeData().g()) {
                if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getInst().getActivityPrizeData().h()) {
                    String c2 = TbadkCoreApplication.getInst().getActivityPrizeData().c();
                    if (!StringUtils.isNull(c2)) {
                        b.a.q0.s.e0.b j2 = b.a.q0.s.e0.b.j();
                        if (j2.g("activity_prize_get_tip" + TbadkCoreApplication.getCurrentAccount(), true)) {
                            UrlManager.getInstance().dealOneLink((TbPageContext<?>) getPageContext(), new String[]{c2}, true);
                            b.a.q0.s.e0.b j3 = b.a.q0.s.e0.b.j();
                            j3.t("activity_prize_get_tip" + TbadkCoreApplication.getCurrentAccount(), false);
                        }
                    }
                }
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    String d2 = TbadkCoreApplication.getInst().getActivityPrizeData().d();
                    if (!StringUtils.isNull(d2)) {
                        b.a.r0.o3.d dVar2 = this.mViewController;
                        if (dVar2 != null) {
                            dVar2.M(d2);
                        }
                    } else {
                        b.a.r0.o3.d dVar3 = this.mViewController;
                        if (dVar3 != null) {
                            dVar3.M(null);
                        }
                    }
                } else {
                    b.a.r0.o3.d dVar4 = this.mViewController;
                    if (dVar4 != null) {
                        dVar4.M(null);
                    }
                }
            } else {
                b.a.r0.o3.d dVar5 = this.mViewController;
                if (dVar5 != null) {
                    dVar5.M(null);
                }
            }
            if (TbSingleton.getInstance().canShowPermDialog()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921360, this));
            }
            b.a.q0.s.o.a.b().l("1", "");
            if (TbSingleton.getInstance().hasPerformedFirstLoginTest() && TbSingleton.getInstance().isNeedShowInterestGuide()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new InterestGuideActivityConfig(this)));
            }
            b.a.q0.s.e0.b.j().w("key_app_launch_time", System.currentTimeMillis());
            firstLoginTest();
            dealForceConfirmSwitchTDouToYBean();
            checkCreateCenterTip();
        }
    }

    public void doVideoChannelNoticeShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            String string = getString(R.string.tieba_video_channel_is_comming);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = this.mViewController.z().getFragmentTabWidget();
            if (fragmentTabWidget.getChildCount() < 2) {
                return;
            }
            b.a.r0.f0.g gVar = new b.a.r0.f0.g(getPageContext(), fragmentTabWidget.getChildAt(2));
            this.mCategoryTipController = gVar;
            gVar.g0(R.drawable.bg_tip_blue_left);
            this.mCategoryTipController.L(2);
            this.mCategoryTipController.O(32);
            this.mCategoryTipController.h0(true);
            this.mCategoryTipController.k0(-b.a.e.e.p.l.g(this, R.dimen.tbds10));
            this.mCategoryTipController.X(R.color.CAM_X0101);
            this.mCategoryTipController.P(R.dimen.tbds109);
            this.mCategoryTipController.T(1);
            this.mCategoryTipController.N(3000);
            this.mCategoryTipController.a0(b.a.e.e.p.l.g(this, R.dimen.tbds44));
            this.mCategoryTipController.o0(string, "videoChannelComming", true, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            TbSingleton.getInstance().clearVideoRecord();
            TbSingleton.getInstance().setHasAgreeToPlay(false);
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public ViewGroup getActivityRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.rootView : (ViewGroup) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, b.a.q0.o0.a
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            List<String> currentPageSourceKeyList = super.getCurrentPageSourceKeyList();
            if (!this.isAccountStatChanged || currentPageSourceKeyList == null) {
                return currentPageSourceKeyList;
            }
            currentPageSourceKeyList.clear();
            this.isAccountStatChanged = false;
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // b.a.r0.o3.a
    public int getCurrentTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.mViewController.z() != null) {
                return this.mViewController.z().getCurrentTabType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public b.a.e.e.k.b<TbImageView> getFrsCommonImageLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.mCommonImagePool == null) {
                this.mCommonImagePool = FrsCommonImageLayout.createFrsCommonIamgeLayoutPool(getPageContext().getPageActivity(), 12);
            }
            return this.mCommonImagePool;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    public boolean getGpuSwich() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? TbadkCoreApplication.getInst().isGpuOpen() : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, b.a.q0.o0.a
    public b.a.q0.o0.b getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? new i0(this) : (b.a.q0.o0.b) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        TbPageTag tbPageTag;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048597, this)) != null) {
            return (TbPageTag) invokeV.objValue;
        }
        b.a.r0.o3.d dVar = this.mViewController;
        if (dVar != null && dVar.z() != null) {
            Fragment currentFragment = this.mViewController.z().getCurrentFragment();
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
    public b.a.e.e.k.b<TbImageView> getUserIconPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.mUserIconPool == null) {
                this.mUserIconPool = UserIconBox.createUserIconPool(getPageContext().getPageActivity(), 8);
            }
            return this.mUserIconPool;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    public int getUserIconViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public SeekBar getVideoFloatSeekBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mViewController.A() : (SeekBar) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (this.mVoiceManager == null) {
                this.mVoiceManager = VoiceManager.instance();
            }
            return this.mVoiceManager;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public void gotoFeedback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            AntiData antiData = new AntiData();
            antiData.setIfpost(1);
            if (antiData.getIfpost() == 0) {
                b.a.e.e.p.l.M(getPageContext().getPageActivity(), antiData.getForbid_info());
            } else if (WriteActivityConfig.isAsyncWriting()) {
            } else {
                antiData.setIfVoice(false);
                WriteActivityConfig.newInstance(this).setType(0).setFrom(this.mFrom).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setFeedBack(true).setAntiData(antiData).send();
            }
        }
    }

    public void initTabsOnActivityCreated() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007002, new b.a.q0.h0.d(getPageContext().getPageActivity())));
            } finally {
                TTIStats.record("MainTabActivity.initTabsOnActivityCreated", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048604, this, i2, i3, intent) == null) {
            if (i3 != -1) {
                if (i2 == 25059) {
                    b.a.r0.o.e();
                } else if (i2 == 25060) {
                    b.a.r0.o.e();
                }
            }
            if (i3 != -1) {
                if (this.mViewController.z().getCurrentFragment() != null) {
                    this.mViewController.z().getCurrentFragment().onActivityResult(i2, i3, intent);
                }
            } else if (i2 == 25046) {
                if (TbadkCoreApplication.isLogin()) {
                    b.a.q0.a.r.g().l(getPageContext());
                }
            } else if (i2 == 11001) {
                gotoFeedback();
            } else if (i2 == 13003 || i2 == 25048) {
                dispatchWriteCallbakcData(intent);
            } else if (i2 == 23007) {
                handleShareFriendForum(intent);
            } else if (i2 == 13011) {
                b.a.r0.y2.a.g().m(getPageContext());
            } else if (i2 == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    b.a.r0.y2.a.g().m(getPageContext());
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                    if (shareItem != null) {
                        int i4 = shareItem.I;
                        if (i4 == 0) {
                            statisticItem.param("obj_locate", 15);
                        } else {
                            statisticItem.param("obj_locate", i4);
                        }
                    }
                    if (shareItem != null) {
                        statisticItem.param("tid", shareItem.K);
                    }
                    statisticItem.param("pid", intent.getStringExtra("pid"));
                    TiebaStatic.log(statisticItem);
                    if (shareItem == null || (str = shareItem.t) == null || (shareSuccessReplyToServerModel = this.mShareSuccessReplyToServerModel) == null) {
                        return;
                    }
                    shareSuccessReplyToServerModel.w(str, intExtra2, new e0(this));
                }
            } else if (i2 == 25059) {
                if (b.a.q0.b.d.n()) {
                    if (TbadkApplication.getInst().isNeedNewUserLead() && TbadkCoreApplication.isLogin()) {
                        InterestGuideActivityConfig interestGuideActivityConfig = new InterestGuideActivityConfig(this, 4);
                        interestGuideActivityConfig.setRequestCode(25060);
                        interestGuideActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, interestGuideActivityConfig));
                        return;
                    }
                    return;
                }
                b.a.r0.o.e();
            } else if (i2 == 25060) {
                if (b.a.q0.b.d.o()) {
                    if (TbadkCoreApplication.isLogin()) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921535, this));
                    return;
                }
                b.a.r0.o.e();
            } else if (i2 == 25064) {
                b.a.r0.d4.f fVar = this.mWriteTab;
                if (fVar != null) {
                    fVar.n(getPageContext());
                }
            } else if (this.mViewController.z().getCurrentFragment() != null) {
                this.mViewController.z().getCurrentFragment().onActivityResult(i2, i3, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.mViewController.E(i2);
            adjustResizeForSoftInputOnSkinTypeChanged(i2);
            b.a.r0.d4.f fVar = this.mWriteTab;
            if (fVar != null) {
                fVar.r(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        b.a.r0.o3.d dVar;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, configuration) == null) || configuration == null) {
            return;
        }
        super.onConfigurationChanged(configuration);
        if (TbadkCoreApplication.getInst().getSkinType() != 1 && (runTask = MessageManager.getInstance().runTask(2001281, String.class)) != null && !StringUtils.isNull((String) runTask.getData())) {
            SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
        }
        if (TbSingleton.getInstance().isFromFeedVideoClick() && configuration.orientation == 1 && (dVar = this.mViewController) != null) {
            dVar.E(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_CREATE_START_STAMP_KEY);
            b.a.q0.q0.l.b().x(System.currentTimeMillis());
            if (TbadkCoreApplication.getInst().getIsFirstUse()) {
                b.a.q0.d1.l0.b(new n(this), null);
            }
            if (AdToMainTabActivitySwitch.getIsOn()) {
                MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW = getIntent().getBooleanExtra(MainTabActivityConfig.SHOW_AD_FRAGMENT, false);
            }
            setIsAddSwipeBackLayout(false);
            Window window = getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.getDecorView();
            super.onCreate(bundle);
            if (this.tiePlusEventController == null) {
                this.tiePlusEventController = new TiePlusEventController(this, TiePlusStat.Locate.HOME);
            }
            getLifecycle().addObserver(this.tiePlusEventController);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_SUPER_CREATE_END_STAMP_KEY);
            if (handlerExitApp(getIntent())) {
                return;
            }
            b.a.q0.s.b0.b.f12897c = b.a.q0.s.b0.b.f12898d;
            if (getIntent() != null) {
                b.a.r0.o3.e eVar = new b.a.r0.o3.e(getPageContext());
                this.mPushInsertThreadController = eVar;
                if (!eVar.b(getIntent())) {
                    checkSchemeFromIntent(getIntent());
                }
                if (getIntent().getIntExtra("locate_type", 0) == 200) {
                    finish();
                    return;
                }
                this.mFrom = getIntent().getStringExtra("from");
            }
            b.a.r0.o3.b bVar = new b.a.r0.o3.b();
            b.a.q0.s.b0.b.h(bVar);
            bVar.g(this);
            if (getGpuSwich()) {
                CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
            }
            registerListener(this.mSplashCloseListener);
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                setContentView(R.layout.maintabs_ad_activity);
            } else {
                setContentView(R.layout.maintabs_activity);
            }
            this.rootView = (ViewGroup) findViewById(16908290);
            if (b.a.q0.s.l.a.b() != null) {
                b.a.q0.s.l.a.b().e();
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_HOME_FRAGMENT_CONTROLLER_START_STAMP_KEY);
            this.mViewController = new b.a.r0.o3.d(this);
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                b.a.r0.o3.f.b(this).a();
            }
            this.mMainTabTopicTipController = new b.a.r0.o3.c(this);
            this.mViewController.I(this.mIsLogin);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_HOME_FRAGMENT_CONTROLLER_END_STAMP_KEY);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CHECK_PLUGIN_ENTRANCE_STATE_START_STAMP_KEY);
            checkPluginEntranceState();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CHECK_PLUGIN_ENTRANCE_STATE_END_STAMP_KEY);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.REG_RECEIVER_START_STAMP_KEY);
            regReceiver();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.REG_RECEIVER_END_STAMP_KEY);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CHECK_CLIENT_CONFIG_START_STAMP_KEY);
            b.a.r0.o3.h.b.i().e(this);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CHECK_CLIENT_CONFIG_END_STAMP_KEY);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CHECK_AND_SEND_ACTIVE_CONFIG_START_STAMP_KEY);
            b.a.q0.a.d.y().q();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CHECK_AND_SEND_ACTIVE_CONFIG_END_STAMP_KEY);
            this.mAppEntranceModel = new b.a.r0.b();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_TABS_ON_ACTIVITY_CREATED_START_STAMP_KEY);
            initTabsOnActivityCreated();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_TABS_ON_ACTIVITY_CREATED_END_STAMP_KEY);
            registerNavigationBarEditStateListener();
            Intent intent = new Intent();
            intent.putExtras(getIntent());
            boolean z2 = true;
            if (bundle != null) {
                intent.putExtra("locate_type", bundle.getInt("locate_type", 1));
            }
            this.lastDay = UtilHelper.getCurrentDay();
            this.mLastSyncTime = System.currentTimeMillis();
            MessageManager.getInstance().sendMessage(new CustomMessage(2921359));
            if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            }
            if (TbadkCoreApplication.getFrom() != null && TbadkCoreApplication.getFrom().equals("aishide")) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005011, null));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005013, null));
            MessageManager.getInstance().registerStickyMode(2001404);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001404));
            dealIntent(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_COOKIE_START_STAMP_KEY);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_COOKIE_END_STAMP_KEY);
            String installOtherApp = TbadkCoreApplication.getInst().getInstallOtherApp();
            if (installOtherApp != null && installOtherApp.length() > 0) {
                UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), installOtherApp);
                TbadkCoreApplication.getInst().setInstallOtherApp(null);
            }
            this.mHandler.post(new o(this));
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.START_TRACK_CONFIG_REQUEST_START_STAMP_KEY);
            TbadkCoreApplication.getInst().startTrackConfigRequest();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.START_TRACK_CONFIG_REQUEST_END_STAMP_KEY);
            if (PermissionUtil.checkLocationForGoogle(getActivity())) {
                MercatorModel.d().f();
            }
            registerListener(this.mOnlineListener);
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            if (voiceManager != null) {
                voiceManager.onCreate(getPageContext());
            }
            registerListener(this.mAccountChangedListener);
            adjustResizeForSoftInput();
            addGlobalLayoutListener();
            if (TbadkCoreApplication.isLogin()) {
                b.a.q0.q0.l.b().f();
            }
            if (TbadkCoreApplication.isLogin()) {
                b.a.q0.a0.b.a().d();
            }
            b.a.q0.s.e0.b.j().v("app_restart_times", b.a.q0.s.e0.b.j().k("app_restart_times", 0) + 1);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CHECK_REAL_NAME_START_STAMP_KEY);
            CheckRealNameModel checkRealNameModel = new CheckRealNameModel(getPageContext());
            this.mCheckRealNameModel = checkRealNameModel;
            checkRealNameModel.A(this.checkRealNameCallBack);
            checkRealName();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CHECK_REAL_NAME_END_STAMP_KEY);
            this.mNEGFeedBackManager = new b.a.r0.j.a(getPageContext(), "homepage");
            this.mShareSuccessReplyToServerModel = new ShareSuccessReplyToServerModel();
            this.mUegForwardCheckController = new b.a.r0.t3.d(getPageContext());
            this.mBdTokenController = b.a.q0.a.e.y();
            int loadInt = TbadkSettings.getInst().loadInt("skin_", 0);
            if (loadInt != 1) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001281, String.class);
                if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                    SkinManager.setDayOrDarkSkinTypeWithSystemMode(false, true);
                }
            } else {
                TbadkCoreApplication.getInst().setSkinTypeValue(loadInt);
                TbadkCoreApplication.getInst().SendSkinTypeBroadcast(loadInt);
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            TiebaStatic.log(new StatisticItem("c14261").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", skinType == 4 ? 2 : skinType == 1 ? 1 : 0));
            if (TbSingleton.getInstance().isEnableBenchmark() && TbSingleton.getInstance().getCpuFlopsDuration() <= 0) {
                b.a.e.e.m.e.a().postDelayed(new p(this), 5000L);
            }
            MessageManager.getInstance().registerListener(this.mToHotTopicListener);
            TbSingleton.getInstance().startOneGame();
            this.mWeakContext = new WeakReference<>(TbadkCoreApplication.getInst());
            if (getResources() != null && getResources().getConfiguration() != null) {
                this.lastUiMode = getResources().getConfiguration().uiMode & 48;
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CLEAR_CONCERN_CACHE_WHEN_VERSION_UPDATE_START_STAMP_KEY);
            clearConcernCacheWhenVersionUpdate();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CLEAR_CONCERN_CACHE_WHEN_VERSION_UPDATE_END_STAMP_KEY);
            if (this.mPushInsertThreadController.b(intent)) {
                this.mPushInsertThreadController.a(getIntent(), this.mViewController);
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.UPDATE_PROFILE_INFO_START_STAMP_KEY);
            updateProfileInfo();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.UPDATE_PROFILE_INFO_END_STAMP_KEY);
            if (b.a.q0.b.d.J()) {
                b.a.r0.y0.a.i().B(this, "6051001980-1210572494", b.a.r0.y0.a.b("personalize", "1"));
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.TRY_LOAD_NATIVE_FUN_START_STAMP_KEY);
            if (b.a.q0.b.d.p() && b.a.q0.b.d.v()) {
                b.a.r0.y0.a.i().C(this, b.a.r0.y0.e.c.e().d("frs_feed"), b.a.r0.y0.a.b("frs", "1"), "");
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.TRY_LOAD_NATIVE_FUN_END_STAMP_KEY);
            TbSingleton.getInstance().getChannelConfigModel().e();
            TbSingleton.getInstance().setActiveTimeStamp();
            if (b.a.q0.g1.b.c.d()) {
                b.a.q0.g1.b.b.f12592a = false;
                b.a.q0.g1.b.a.a();
                if (!handlerYoungsterNightTask()) {
                    startYoungsterUseTimeTask();
                }
            }
            this.isCreated = true;
            b.a.e.e.m.e.a().postDelayed(new q(this), 1000L);
            Thread.setDefaultUncaughtExceptionHandler(new b.a.e.k.c(Thread.getDefaultUncaughtExceptionHandler()));
            int k2 = b.a.q0.s.e0.b.j().k("key_fps_time", 2);
            BdTracesManager.INSTANCE.init(new BdTracesConfig().newBuilder().fpsEnable((k2 <= 0 || !BdTracesManager.INSTANCE.isActiveUploadType()) ? false : false).debug(false).timeSliceMs(k2 * 1000).build());
            b.a.q0.q0.l.b().y(System.currentTimeMillis());
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_CREATE_END_STAMP_KEY);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005010, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005012, null));
            unregReceiver();
            b.a.q0.t.d.b.g0().o();
            b.a.q0.t.d.b.g0().q();
            b.a.q0.t.d.b.g0().X(false);
            MessageManager.getInstance().unRegisterListener(this.mToHotTopicListener);
            MessageManager.getInstance().unRegisterListener(this.mShowGoBackShouBaiListener);
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null && getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
            }
            b.a.q0.s.g0.a aVar = this.mWaitingDialog;
            if (aVar != null) {
                aVar.h(false);
                this.mWaitingDialog = null;
            }
            callWindowMissed();
            b.a.r0.o3.d dVar = this.mViewController;
            if (dVar != null) {
                dVar.F();
            }
            b.a.r0.o3.c cVar = this.mMainTabTopicTipController;
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
            b.a.q0.s.b0.b.h(null);
            b.a.q0.y.d.h().l();
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            b.a.r0.d4.f fVar = this.mWriteTab;
            if (fVar != null) {
                fVar.t();
            }
            b.a.r0.j.a aVar2 = this.mNEGFeedBackManager;
            if (aVar2 != null) {
                aVar2.h();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.mShareSuccessReplyToServerModel;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            b.a.r0.t3.b bVar = this.mCancelController;
            if (bVar != null) {
                bVar.f();
            }
            b.a.r0.o3.d dVar2 = this.mViewController;
            if (dVar2 != null && dVar2.y() != null) {
                this.mViewController.y().onDestory();
            }
            if (b.a.q0.b.d.Y()) {
                b.a.r0.y0.a.i().d("6061002332-203360688");
            }
            if (b.a.q0.b.d.Z()) {
                b.a.r0.y0.a.i().c("6061002410-390177882");
            }
            if (this.tiePlusEventController != null) {
                getLifecycle().removeObserver(this.tiePlusEventController);
            }
            b.a.r0.p1.c.b().c();
            b.a.e.j.f.c().cancel();
            b.a.e.e.m.e.a().removeCallbacks(this.mCheckNewUserRedPackageRunnable);
            b.a.e.e.m.e.a().removeCallbacks(this.startPollVideoMsg);
            System.gc();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048609, this, i2, keyEvent)) == null) {
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
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048610, this, i2, keyEvent)) == null) {
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
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z2) == null) {
            this.isKeyboardVisible = z2;
            boolean z3 = this.isEditorVisible || z2;
            b.a.r0.o3.d dVar = this.mViewController;
            if (dVar != null) {
                dVar.G(z3);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        b.a.r0.o3.d dVar;
        FragmentTabHost.b tabSpecByType;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, intent) == null) {
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
                b.a.q0.a0.b.a().d();
                if (intent.getBooleanExtra("refresh_all", false)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007008));
                    initTabsOnActivityCreated();
                }
                this.mFrom = intent.getStringExtra("from");
                int intExtra = intent.getIntExtra("locate_type", 0);
                boolean booleanExtra = intent.getBooleanExtra("is_from_scheme", false);
                if (intExtra == 200) {
                    finish();
                } else if (intExtra == 11) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), true)));
                    finish();
                } else if (intExtra == 12) {
                    TbadkCoreApplication.getInst().notifyAppEnterBackground();
                    finish();
                } else if (intExtra == 1 || intExtra == 20 || intExtra == 3 || intExtra == 2 || intExtra == 4 || intExtra == 8 || intExtra == 15 || intExtra == 22) {
                    if (intExtra != 8 && intExtra != 3 && intExtra != 15 && !booleanExtra) {
                        if (getActivity().getIntent() != null && getActivity().getIntent().getDataString() != null && getActivity().getIntent().getDataString().startsWith(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
                            intExtra = 2;
                        } else if (intExtra != 2 && intExtra != 1 && intExtra != 20) {
                            intExtra = this.mAppEntranceModel.a();
                        }
                    }
                    b.a.r0.o3.d dVar2 = this.mViewController;
                    if (dVar2 != null && dVar2.z() != null) {
                        this.mViewController.K(intExtra);
                    }
                } else if ((intExtra == 17 || intExtra == 18) && (dVar = this.mViewController) != null && dVar.z() != null) {
                    this.mViewController.z().setCurrentTab(0);
                }
                b.a.r0.o3.d dVar3 = this.mViewController;
                if (dVar3 != null && dVar3.z() != null && (tabSpecByType = this.mViewController.z().getTabSpecByType(intExtra)) != null) {
                    Fragment fragment = tabSpecByType.f45185c;
                    if (fragment instanceof b.a.q0.s.g) {
                        ((b.a.q0.s.g) fragment).setCurrentSubTab(intent);
                    }
                }
                dealIntent(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
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
            b.a.r0.o3.c cVar = this.mMainTabTopicTipController;
            if (cVar != null) {
                cVar.g();
            }
            KuangFloatingViewController.getInstance().hideFloatingView();
            b.a.q0.y.d.h().i(true);
            clearLikeFirstForumTips();
            b.a.e.e.m.e.a().removeCallbacks(this.mCheckNewUserRedPackageRunnable);
            b.a.r0.o3.d dVar = this.mViewController;
            if (dVar != null) {
                dVar.J();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, b.a.e.a.i
    public void onPreLoad(b.a.e.l.e.q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, qVar) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                super.onPreLoad(qVar);
                PreLoadImageHelper.load(qVar, getUniqueId());
                PreLoadVideoHelper.load(qVar, getUniqueId(), this);
            } finally {
                TTIStats.record("MainTabActivity.onPreLoad", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, bundle) == null) {
            try {
                super.onRestoreInstanceState(bundle);
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        b.a.r0.o3.d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_START_STAMP_KEY);
            super.onResume();
            this.isResumed = true;
            if (this.doRefresh) {
                b.a.q0.d1.s0.g(this.mWeakContext);
                this.doRefresh = false;
            }
            if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW && (dVar = this.mViewController) != null && dVar.y() != null) {
                this.mViewController.y().setLottieView(true);
            }
            b.a.r0.o3.d dVar2 = this.mViewController;
            if (dVar2 != null && dVar2.z() != null) {
                this.reloginGotoType = this.mViewController.z().getCurrentTabType();
            }
            changeSkinType(this.mSkinType);
            b.a.q0.y.d.h().i(true);
            if (TbadkCoreApplication.isLogin() && b.a.q0.q0.l.b().e()) {
                b.a.q0.q0.l.b().f();
            }
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            b.a.r0.o3.d dVar3 = this.mViewController;
            if (dVar3 != null) {
                dVar3.H();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001385, getActivity()));
            b.a.q0.q0.l.b().f();
            if (b.a.q0.a.r.g().c() != null && b.a.q0.a.r.g().i() != null && b.a.q0.a.r.g().c().getCurTaskType() == 6) {
                b.a.q0.a.r.g().i().a();
            }
            showLikeFirstForumTips();
            if (this.mCurrentTabIndex.intValue() != 1) {
                showLikeFirstForumTips();
            }
            if (!TbSingleton.getInstance().isNewUserRedPackageShowed() && TbSingleton.getInstance().hasPerformedFirstLoginTest()) {
                b.a.e.e.m.e.a().removeCallbacks(this.mCheckNewUserRedPackageRunnable);
                b.a.e.e.m.e.a().postDelayed(this.mCheckNewUserRedPackageRunnable, 200L);
            }
            statisticDynamicIconExposure();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                b.a.q0.w.c.q().w(downloadData);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, bundle) == null) {
            try {
                super.onSaveInstanceState(bundle);
            } catch (Exception unused) {
            }
            bundle.putInt("locate_type", this.mViewController.z().getCurrentTabType());
            bundle.putParcelable("android:fragments", null);
            bundle.putParcelable("android:support:fragments", null);
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onScreenShot(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            super.onScreenShot(str);
            b.a.r0.o3.d dVar = this.mViewController;
            if (dVar == null || dVar.z() == null || this.mViewController.z().getCurrentTabType() != 2) {
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SCREEN_SHOT).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", 1));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_ONSTART_START_STAMP_KEY);
            super.onStart();
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.MAINACTIVITY_ONSTART_END_STAMP_KEY);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            super.onStop();
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            this.doRefresh = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onUserChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z2) == null) {
            super.onUserChanged(z2);
            this.isAccountStatChanged = true;
            if (z2) {
                b.a.q0.a0.b.a().d();
                checkPluginEntranceState();
                checkRealName();
                updateProfileInfo();
            }
            this.mViewController.C();
            initTabsOnActivityCreated();
        }
    }

    public void processBeforeGoBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            b.a.e.e.l.d.h().b(getUniqueId());
            manageService();
            try {
                moveTaskToBack(true);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean shouldChangeStatusBarIconAndTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            b.a.r0.o3.d dVar = this.mViewController;
            if (dVar != null && dVar.z() != null) {
                FragmentTabHost z2 = this.mViewController.z();
                FragmentTabHost.b tabSpec = z2.getTabSpec(z2.getCurrentTabIndex());
                if (tabSpec != null && tabSpec.f45183a == 22) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void showMemberTip(PayMemberInfoData payMemberInfoData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048624, this, payMemberInfoData) == null) && TbadkCoreApplication.getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && payMemberInfoData != null) {
            if ((payMemberInfoData.y() == 1 || payMemberInfoData.y() == 2) && b.a.q0.s.e0.b.j().g("show_member_deid_line", true)) {
                long w2 = payMemberInfoData.w() * 1000;
                if (w2 < System.currentTimeMillis()) {
                    if (StringUtils.isNull(payMemberInfoData.x())) {
                        payMemberInfoData.A(getPageContext().getString(R.string.member));
                    } else {
                        payMemberInfoData.A(payMemberInfoData.x() + getPageContext().getString(R.string.member_already_Expire));
                    }
                    this.mViewController.P(payMemberInfoData, 0);
                } else if (w2 - System.currentTimeMillis() < 259200000) {
                    if (StringUtils.isNull(payMemberInfoData.x())) {
                        payMemberInfoData.A(getPageContext().getString(R.string.member));
                    } else {
                        payMemberInfoData.A(payMemberInfoData.x() + getPageContext().getString(R.string.member_will_Expire));
                    }
                    this.mViewController.P(payMemberInfoData, 1);
                }
            }
        }
    }

    public void showWriteThreadView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            b.a.r0.o3.c cVar = this.mMainTabTopicTipController;
            if (cVar != null) {
                cVar.h();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
            if (this.mWriteTab == null) {
                b.a.r0.d4.f fVar = new b.a.r0.d4.f(getPageContext(), this.rootView, "main_tab", 3);
                this.mWriteTab = fVar;
                fVar.E("8");
            }
            if (this.mUegForwardCheckController.d() || this.mViewController.z() == null || this.mViewController.z().getFragmentTabWidget() == null) {
                return;
            }
            this.mWriteTab.I(false, this.mViewController.z().getTabWrapper(), this.mViewController.z().getFragmentTabWidget().getWriteView());
        }
    }

    public void statisticDynamicIconExposure() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048626, this) == null) && b.a.q0.h0.e.c.d().b()) {
            StatisticItem statisticItem = new StatisticItem("c14132");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public void updateProfileInfo() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && b.a.e.e.p.j.A() && TbadkCoreApplication.getCurrentAccount() != null) {
            ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
            profileRequestMessage.set_uid(Long.valueOf(b.a.e.e.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L)));
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                return false;
            }
            return b.a.q0.d1.s0.a(1);
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onResponseMessage(ProfileSocketResponseMessage profileSocketResponseMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65612, this, profileSocketResponseMessage) == null) || profileSocketResponseMessage == null || profileSocketResponseMessage.GetUser() == null) {
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
