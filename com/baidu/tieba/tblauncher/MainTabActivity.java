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
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.LoginActivity;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
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
import com.baidu.tbadk.mainTab.videoRedIcon.VideoRedIconRequest;
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
import com.baidu.tieba.service.AsInstallService;
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
import d.a.p0.a.g;
import d.a.p0.s.q.m1;
import d.a.p0.s.s.a;
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
/* loaded from: classes4.dex */
public class MainTabActivity extends BaseFragmentActivity implements d.a.q0.k3.a, VoiceManager.j, UserIconBox.c, FrsCommonImageLayout.e, IVideoNeedPreload {
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
    public d.a.q0.b mAppEntranceModel;
    public CustomMessageListener mBackgroundChangeListener;
    public d.a.p0.a.e mBdTokenController;
    public d.a.q0.p3.b mCancelController;
    public d.a.q0.e0.e mCategoryTipController;
    public CustomMessageListener mCategoryUpdateListener;
    public Runnable mCheckNewUserRedPackageRunnable;
    public CheckRealNameModel mCheckRealNameModel;
    public final CustomMessageListener mCloseMainTablistener;
    public d.a.d.e.k.b<TbImageView> mCommonImagePool;
    public Integer mCurrentTabIndex;
    public CustomMessageListener mEditorListener;
    public CustomMessageListener mEnterForumTabClickListener;
    public final CustomMessageListener mForceConfirmListener;
    public String mFrom;
    public CustomMessageListener mGameCenterInitListener;
    public final CustomMessageListener mGameMsgTipListener;
    public volatile boolean mIsAdd;
    public CustomMessageListener mJumpPbListener;
    public long mLastSyncTime;
    public d.a.q0.e0.e mLikeFirstForumTipsController;
    public CustomMessageListener mLikeForumListener;
    public int mLikeForumNum;
    public d.a.q0.k3.c mMainTabTopicTipController;
    public CustomMessageListener mMyCreateCenterListener;
    public d.a.q0.e0.e mMyTipController;
    public d.a.q0.h.a mNEGFeedBackManager;
    public CustomMessageListener mOnScreenSizeChangeListener;
    public final d.a.d.c.g.c mOnlineListener;
    public final CustomMessageListener mPersonInfoChangeListener;
    public d.a.d.c.g.a mPersonInfoMsgListener;
    public String mPreUserId;
    public d.a.q0.k3.e mPushInsertThreadController;
    public m1 mRecomPostTopic;
    public final CustomMessageListener mRefreshTablistener;
    public final CustomMessageListener mRefreshTiplistener;
    public final CustomMessageListener mSetMainTabInstListener;
    public ShareSuccessReplyToServerModel mShareSuccessReplyToServerModel;
    public CustomMessageListener mShowGoBackShouBaiListener;
    public CustomMessageListener mShowPostVideoSuccessListener;
    public final CustomMessageListener mStartPollVideoMsgListener;
    public CustomMessageListener mSyncFinishListener;
    public final CustomMessageListener mToHotTopicListener;
    public boolean mTouchable;
    public d.a.q0.p3.d mUegForwardCheckController;
    public d1 mUpdateReceiver;
    public d.a.d.e.k.b<TbImageView> mUserIconPool;
    public CustomMessageListener mVideoChannelNoticeListener;
    public d.a.q0.k3.d mViewController;
    public VoiceManager mVoiceManager;
    public WeakReference<Context> mWeakContext;
    public d.a.q0.a4.f mWriteTab;
    public CurrencySwitchTDouYBeanDialog mYYBeanForceConfirmDialog;
    public CustomMessageListener mYoungsterModeChangeListener;
    public boolean needAnim;
    public CustomMessageListener networkChangedListener;
    public PackageChangedReceiver packageChangedReceiver;
    public int reloginGotoType;
    public FrameLayout rootView;
    public CustomMessageListener showNewUserRedPackageListener;
    public CustomMessageListener showWriteThreadListener;
    public final CustomMessageListener skinTypeChangeListener;
    public final Runnable startPollVideoMsg;
    public CustomMessageListener updateMainTabProfileListener;
    public Timer youngsterNightTimer;
    public TimerTask youngsterUseTimeTask;
    public Timer youngsterUseTimer;
    public CustomMessageListener youngsterUseTimerListener;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21409a;

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
            this.f21409a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            UserData b2 = d.a.p0.a0.b.a().b();
            if (TbadkCoreApplication.isLogin() && b2 != null && b2.getUserId() != null && !b2.getUserId().equals(this.f21409a.mPreUserId) && b2.getIsGodInvited()) {
                this.f21409a.mPreUserId = b2.getUserId();
                this.f21409a.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.f21409a.getPageContext().getPageActivity(), "", TbWebViewActivityConfig.GOD_INVITE_JUMP_URL + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE, true)));
            }
            if (d.a.p0.s.d0.b.j().g("key_new_god_invited_my_tab_red_tip_showed", false) || !TbadkCoreApplication.isLogin() || b2 == null || b2.getUserId() == null || b2.getUserId().equals(this.f21409a.mPreUserId) || b2.getNewGodData() == null || !b2.getNewGodData().isNewGodInvited()) {
                return;
            }
            d.a.q0.x2.a.v().L(11, true, true);
            TiebaStatic.log(new StatisticItem("c13688").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_locate", 0));
            d.a.p0.s.d0.b.j().t("key_new_god_invited_my_tab_red_tip_showed", true);
        }
    }

    /* loaded from: classes4.dex */
    public class a0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21410e;

        public a0(MainTabActivity mainTabActivity) {
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
            this.f21410e = mainTabActivity;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.f21410e.processBeforeGoBack();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21411a;

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
            this.f21411a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = this.f21411a.mCurrentTabIndex.intValue();
                this.f21411a.mCurrentTabIndex = (Integer) customResponsedMessage.getData();
                if (this.f21411a.mCurrentTabIndex.intValue() == 1) {
                    this.f21411a.clearLikeFirstForumTips();
                } else if (intValue == 1) {
                    this.f21411a.showLikeFirstForumTips();
                }
                if (this.f21411a.mCurrentTabIndex.intValue() == 2) {
                    this.f21411a.clearNewCategoryTips();
                }
                if (this.f21411a.mCurrentTabIndex.intValue() == 4) {
                    this.f21411a.clearMyCreateCenterTips();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21412a;

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
            this.f21412a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof PostWriteCallBackData) || ((PostWriteCallBackData) customResponsedMessage.getData()).isDyamicCallback()) {
                return;
            }
            this.f21412a.mViewController.c0((PostWriteCallBackData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes4.dex */
    public class b0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21413e;

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
            this.f21413e = mainTabActivity;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                try {
                    this.f21413e.startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
                    aVar.dismiss();
                } catch (Exception unused) {
                    this.f21413e.showToast(R.string.goto_developActivity_error_toast);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b1 extends d.a.d.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21414a;

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
            this.f21414a = mainTabActivity;
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
                this.f21414a.checkVersion(configVersion.sync);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21415a;

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
            this.f21415a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<d.a.p0.g0.b> c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f21415a.mIsAdd = false;
                if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2007002 || customResponsedMessage.getData() == null || (c2 = ((d.a.p0.g0.d) customResponsedMessage.getData()).c()) == null || c2.size() == 0) {
                    return;
                }
                this.f21415a.mViewController.H(c2);
                if (this.f21415a.isUseCurrType) {
                    this.f21415a.mViewController.E().setCurrentTabByType(this.f21415a.reloginGotoType);
                } else if (this.f21415a.getActivity().getIntent() != null && this.f21415a.getActivity().getIntent().getDataString() != null && this.f21415a.getActivity().getIntent().getDataString().startsWith(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
                    this.f21415a.mViewController.E().setCurrentTabByType(2);
                } else {
                    MainTabActivity mainTabActivity = this.f21415a;
                    mainTabActivity.setupIntent(mainTabActivity.getIntent());
                }
                this.f21415a.isUseCurrType = false;
                this.f21415a.mViewController.U();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, null));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921543, null));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921567, null));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921579, 0));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21416a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c0(MainTabActivity mainTabActivity, int i2) {
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
            this.f21416a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof Integer)) {
                Integer num = (Integer) customResponsedMessage.getData();
                if (num.intValue() == 2) {
                    this.f21416a.mViewController.d0(true);
                    this.f21416a.mViewController.y(true);
                } else if (num.intValue() == 1) {
                    this.f21416a.mViewController.d0(true);
                    this.f21416a.mViewController.y(false);
                } else {
                    this.f21416a.mViewController.d0(false);
                    this.f21416a.mViewController.y(false);
                }
                this.f21416a.mViewController.R();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21417a;

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
            this.f21417a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.p0.u.h hVar;
            String a2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.p0.u.h) || (a2 = (hVar = (d.a.p0.u.h) customResponsedMessage.getData()).a()) == null) {
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
                baijiahaoData.oriUgcType = d.a.d.e.m.b.d(parse.getQueryParameter(TiebaStatic.Params.UGC_TYPE), 0);
                baijiahaoData.oriUgcVid = parse.getQueryParameter("ori_ugc_vid");
                if (!StringUtils.isNull(queryParameter3)) {
                    int d2 = d.a.d.e.m.b.d(queryParameter3, 0);
                    if (hVar.b() != null) {
                        d.a.p0.b1.s.a(queryParameter2, queryParameter, queryParameter4, d2, hVar.b(), baijiahaoData);
                    } else {
                        d.a.p0.b1.s.a(queryParameter2, queryParameter, queryParameter4, d2, this.f21417a.getPageContext(), baijiahaoData);
                    }
                } else {
                    if (StringUtils.isNull(queryParameter2)) {
                        queryParameter2 = "0";
                    }
                    if (hVar.b() != null) {
                        d.a.p0.b1.s.a(queryParameter2, queryParameter, queryParameter4, 0, hVar.b(), baijiahaoData);
                    } else {
                        d.a.p0.b1.s.a(queryParameter2, queryParameter, queryParameter4, 0, this.f21417a.getPageContext(), baijiahaoData);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21418a;

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
            this.f21418a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2007013) {
                this.f21418a.initTabsOnActivityCreated();
                if (this.f21418a.mViewController != null && this.f21418a.mViewController.E() != null) {
                    MainTabActivity mainTabActivity = this.f21418a;
                    mainTabActivity.reloginGotoType = mainTabActivity.mViewController.E().getCurrentTabType();
                }
                this.f21418a.isUseCurrType = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d0 implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21419a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f21420e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d0 f21421f;

            public a(d0 d0Var, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {d0Var, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21421f = d0Var;
                this.f21420e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.q0.h2.j.c.a(this.f21421f.f21419a.getPageContext(), this.f21420e).show();
                }
            }
        }

        public d0(MainTabActivity mainTabActivity) {
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
            this.f21419a = mainTabActivity;
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
                d.a.d.e.m.e.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d1 extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MainTabActivity this$0;

        public d1(MainTabActivity mainTabActivity) {
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

        public /* synthetic */ d1(MainTabActivity mainTabActivity, k kVar) {
            this(mainTabActivity);
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21422a;

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
            this.f21422a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (this.f21422a.mRecomPostTopic != null || (customResponsedMessage.getData() instanceof m1)) {
                if (customResponsedMessage.getData() != null) {
                    this.f21422a.mRecomPostTopic = (m1) customResponsedMessage.getData();
                }
                if (this.f21422a.mIsAdd || this.f21422a.mRecomPostTopic == null || !TbadkCoreApplication.isLogin()) {
                    return;
                }
                this.f21422a.mMainTabTopicTipController.j(this.f21422a.mRecomPostTopic.f53393a, this.f21422a.mRecomPostTopic.f53394b, this.f21422a.mRecomPostTopic.f53395c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f21423e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f21424f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f21425g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f21426h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f21427i;
        public final /* synthetic */ ShareFromPBMsgData j;
        public final /* synthetic */ MainTabActivity k;

        public e0(MainTabActivity mainTabActivity, Thread2GroupShareView thread2GroupShareView, long j, String str, String str2, String str3, ShareFromPBMsgData shareFromPBMsgData) {
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
            this.f21423e = thread2GroupShareView;
            this.f21424f = j;
            this.f21425g = str;
            this.f21426h = str2;
            this.f21427i = str3;
            this.j = shareFromPBMsgData;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.k.HidenSoftKeyPad((InputMethodManager) this.k.getSystemService("input_method"), this.f21423e.getChatMsgView());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.k.getPageContext().getPageActivity(), this.f21424f, this.f21425g, this.f21426h, this.f21427i, 0, this.f21423e.getLeaveMsg(), this.j.toChatMessageContent())));
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

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21428a;

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
            this.f21428a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            d.a.d.e.m.e.a().removeCallbacks(this.f21428a.startPollVideoMsg);
            d.a.d.e.m.e.a().postDelayed(this.f21428a.startPollVideoMsg, (customResponsedMessage.getData() instanceof Integer ? ((Integer) customResponsedMessage.getData()).intValue() : 0) * 1000);
        }
    }

    /* loaded from: classes4.dex */
    public class f0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f21429e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21430f;

        public f0(MainTabActivity mainTabActivity, Thread2GroupShareView thread2GroupShareView) {
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
            this.f21430f = mainTabActivity;
            this.f21429e = thread2GroupShareView;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f21430f.HidenSoftKeyPad((InputMethodManager) this.f21430f.getSystemService("input_method"), this.f21429e.getChatMsgView());
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21431e;

        public g(MainTabActivity mainTabActivity) {
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
            this.f21431e = mainTabActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!d.a.p0.e1.b.e.d()) {
                    VideoRedIconRequest videoRedIconRequest = new VideoRedIconRequest();
                    if (this.f21431e.mViewController != null && this.f21431e.mViewController.E() != null && this.f21431e.mViewController.E().getCurrentTabType() == 22) {
                        videoRedIconRequest.setCallFrom("video_tab");
                    }
                    this.f21431e.sendMessage(videoRedIconRequest);
                }
                int videoRedIconInterval = TbSingleton.getInstance().getVideoRedIconInterval();
                if (videoRedIconInterval > 5) {
                    d.a.d.e.m.e.a().postDelayed(this.f21431e.startPollVideoMsg, videoRedIconInterval * 1000);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21432a;

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
            this.f21432a = mainTabActivity;
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
                    this.f21432a.mViewController.E().d(1);
                } else if (TbadkCoreApplication.getInst().isThemeIconCover()) {
                    this.f21432a.mViewController.E().d(2);
                } else {
                    this.f21432a.mViewController.E().d(1);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21433a;

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
            this.f21433a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f21433a.dealForceConfirmSwitchTDouToYBean();
        }
    }

    /* loaded from: classes4.dex */
    public class h0 extends d.a.p0.m0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21434a;

        public h0(MainTabActivity mainTabActivity) {
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
            this.f21434a = mainTabActivity;
        }

        @Override // d.a.p0.m0.b
        public boolean canStat(d.a.p0.m0.d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // d.a.p0.m0.b
        public int getMaxCost() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? d.a.p0.m0.e.b().c() : invokeV.intValue;
        }

        @Override // d.a.p0.m0.b
        public boolean isCurrentPageCanBeAddToSourceTrace() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21435a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(MainTabActivity mainTabActivity, int i2) {
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
            this.f21435a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && d.a.p0.s.a0.b.b() == null) {
                d.a.q0.k3.b bVar = new d.a.q0.k3.b();
                bVar.g(this.f21435a);
                d.a.p0.s.a0.b.h(bVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21436a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i0(MainTabActivity mainTabActivity, int i2) {
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
            this.f21436a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                this.f21436a.isAccountStatChanged = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
                d.a.p0.s.d0.b.j().C("key_feedback_tip");
                d.a.p0.s.d0.b.j().C("key_feedback_tip_show");
                d.a.p0.s.d0.b.j().C("key_feedback_tip_tab_show");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016560));
                if (this.f21436a.mBdTokenController != null) {
                    this.f21436a.mBdTokenController.l(UtilHelper.getClipBoardContent());
                }
                if (this.f21436a.mViewController != null) {
                    this.f21436a.mViewController.I();
                }
                this.f21436a.clearConcernCacheWhenVersionUpdate();
                this.f21436a.checkCommitInterestInfo();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21437a;

        /* loaded from: classes4.dex */
        public class a implements d.a.p0.s.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(j jVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // d.a.p0.s.e
            public void onPermissionResult(boolean z) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                    KuangFloatingViewController.getInstance().showFloatingView();
                    TiebaStatic.log(new StatisticItem("c12264").param("obj_type", 3));
                }
            }
        }

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
            this.f21437a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || d.a.d.e.p.k.isEmpty((String) customResponsedMessage.getData())) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (KuangFloatingViewController.getInstance().init()) {
                KuangFloatingViewController.getInstance().setInfo(str);
                this.f21437a.getPageContext().getOrignalPage().grantWindowPermission(new a(this), false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21438a;

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
            this.f21438a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                GameCenterHelper.isGamePluginInit = ((Boolean) customResponsedMessage.getData()).booleanValue();
                this.f21438a.checkPluginEntranceState();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21439a;

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
            this.f21439a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || this.f21439a.mViewController == null) {
                return;
            }
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            MainTabActivity mainTabActivity = this.f21439a;
            if (currentActivity == mainTabActivity) {
                boolean z = false;
                mainTabActivity.isEditorVisible = d.a.d.e.m.b.a(customResponsedMessage.getData().toString(), false);
                MainTabActivity mainTabActivity2 = this.f21439a;
                this.f21439a.mViewController.N((mainTabActivity2.isEditorVisible || mainTabActivity2.isKeyboardVisible) ? true : true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21440a;

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
            this.f21440a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                d.a.p0.s.d0.b.j().t("game_is_show_tip", booleanValue);
                this.f21440a.mViewController.a0(booleanValue);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l extends d.a.p0.b1.f0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21441a;

        public l(MainTabActivity mainTabActivity) {
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
            this.f21441a = mainTabActivity;
        }

        @Override // d.a.p0.b1.f0
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

    /* loaded from: classes4.dex */
    public class l0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21442a;

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
            this.f21442a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                boolean unused = MainTabActivity.syncHasFinish = true;
                TbadkCoreApplication.getInst().syncHasFinish = true;
                if (this.f21442a.mViewController != null && this.f21442a.mViewController.D() != null && this.f21442a.mViewController.D().getAnimationView() != null && this.f21442a.mViewController.D().getAnimationView().getVisibility() != 0) {
                    this.f21442a.mViewController.D().setLottieView(false);
                }
                if (!TbadkCoreApplication.getInst().getActivityPrizeData().g()) {
                    if (this.f21442a.mViewController != null) {
                        this.f21442a.mViewController.W(null);
                    }
                } else {
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getInst().getActivityPrizeData().h()) {
                        String c2 = TbadkCoreApplication.getInst().getActivityPrizeData().c();
                        if (!StringUtils.isNull(c2)) {
                            d.a.p0.s.d0.b j = d.a.p0.s.d0.b.j();
                            if (j.g("activity_prize_get_tip" + TbadkCoreApplication.getCurrentAccount(), true)) {
                                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f21442a.getPageContext(), new String[]{c2}, true);
                                d.a.p0.s.d0.b j2 = d.a.p0.s.d0.b.j();
                                j2.t("activity_prize_get_tip" + TbadkCoreApplication.getCurrentAccount(), false);
                            }
                        }
                    }
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                        if (this.f21442a.mViewController != null) {
                            this.f21442a.mViewController.W(null);
                        }
                    } else {
                        String d2 = TbadkCoreApplication.getInst().getActivityPrizeData().d();
                        if (!StringUtils.isNull(d2)) {
                            if (this.f21442a.mViewController != null) {
                                this.f21442a.mViewController.W(d2);
                            }
                        } else if (this.f21442a.mViewController != null) {
                            this.f21442a.mViewController.W(null);
                        }
                    }
                }
                if (TbSingleton.getInstance().canShowPermDialog()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921360, this.f21442a));
                }
                d.a.p0.s.o.a.b().l("1", "");
                if (TbSingleton.getInstance().hasPerformedFirstLoginTest() && TbSingleton.getInstance().isNeedShowInterestGuide()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new InterestGuideActivityConfig(this.f21442a)));
                }
                d.a.p0.s.d0.b.j().w("key_app_launch_time", System.currentTimeMillis());
                this.f21442a.firstLoginTest();
                this.f21442a.dealForceConfirmSwitchTDouToYBean();
                this.f21442a.checkCreateCenterTip();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21443e;

        public m(MainTabActivity mainTabActivity) {
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
            this.f21443e = mainTabActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21443e.mTouchable = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21444a;

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
            this.f21444a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean z = false;
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    d.a.d.g.c.d();
                    d.a.d.g.c.j();
                    this.f21444a.lastDay = UtilHelper.getCurrentDay();
                    d.a.p0.s.d0.b.j().w("last_resume_time", TbSingleton.getInstance().getLastResumeTime());
                    if (!this.f21444a.isEnterImageViewActivity) {
                        this.f21444a.stopYoungsterUseTimeTask();
                        return;
                    } else {
                        this.f21444a.isEnterImageViewActivity = false;
                        return;
                    }
                }
                String currentDay = UtilHelper.getCurrentDay();
                if (!StringUtils.isNull(currentDay) && !currentDay.equals(this.f21444a.lastDay)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
                }
                if (this.f21444a.mCancelController == null) {
                    this.f21444a.mCancelController = new d.a.q0.p3.b();
                }
                this.f21444a.mCancelController.c(this.f21444a.mCancelController.f62010c);
                this.f21444a.mCancelController.f62010c = TbadkCoreStatisticKey.AntiLocateValue.LOCATE_HOT_BOOT;
                if (d.a.p0.e1.b.e.d()) {
                    int i2 = Calendar.getInstance().get(11);
                    d.a.p0.e1.b.e.f52545a = (i2 >= 23 || i2 < 7) ? true : true;
                    this.f21444a.stopYoungsterUseTimeTask();
                    this.f21444a.startYoungsterUseTimeTask();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21445e;

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
            this.f21445e = mainTabActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.p0.k.a.a();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21446a;

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
            this.f21446a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f21446a.isEnterImageViewActivity = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21447e;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(o oVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar};
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
                    d.a.d.g.c.b();
                }
            }
        }

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
            this.f21447e = mainTabActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && TbadkCoreApplication.getInst().isMainProcess(false)) {
                new Thread(new a(this)).start();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21448a;

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
            this.f21448a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer ? ((Integer) data).intValue() : 0) == 6) {
                    this.f21448a.stopYoungsterUseTimeTask();
                    this.f21448a.startYoungsterUseTimeTask();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p extends d.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21449a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(MainTabActivity mainTabActivity, int i2, int i3) {
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
            this.f21449a = mainTabActivity;
        }

        @Override // d.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z = responsedMessage instanceof ProfileSocketResponseMessage;
                if (z || (responsedMessage instanceof ProfileHttpResponseMessage)) {
                    if (responsedMessage.getOrginalMessage() != null) {
                        this.f21449a.getUniqueId();
                    }
                    if (z) {
                        this.f21449a.onResponseMessage((ProfileSocketResponseMessage) responsedMessage);
                    }
                    if (responsedMessage instanceof ProfileHttpResponseMessage) {
                        this.f21449a.onResponseMessage((ProfileHttpResponseMessage) responsedMessage);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21450a;

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
            this.f21450a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            this.f21450a.stopYoungsterUseTimeTask();
            if (booleanValue) {
                if (!this.f21450a.handlerYoungsterNightTask()) {
                    this.f21450a.startYoungsterUseTimeTask();
                }
                d.a.p0.e1.b.d.d(this.f21450a, null);
                TbSingleton.getInstance().setVideoChannelRecommendRedIcon(null);
                TbSingleton.getInstance().setVideoChannelAttentionRedIcon(null);
                MainTabActivity.clearVideoChannelTabImg();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21451a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(MainTabActivity mainTabActivity, int i2) {
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
            this.f21451a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f21451a.updateProfileInfo();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q0 extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21452e;

        public q0(MainTabActivity mainTabActivity) {
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
            this.f21452e = mainTabActivity;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.p0.e1.b.e.f52545a = true;
                this.f21452e.stopYoungsterUseTimeTask();
                this.f21452e.startYoungsterUseTimePeriodTask();
                this.f21452e.youngsterNightTimer.cancel();
                this.f21452e.youngsterNightTimer = null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21453a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(MainTabActivity mainTabActivity, int i2) {
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
            this.f21453a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || this.f21453a.mViewController == null || this.f21453a.mViewController.E() == null || this.f21453a.mViewController.E().getCurrentTabType() == 21) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = this.f21453a.mViewController.E().getFragmentTabWidget();
            if (fragmentTabWidget.getChildCount() < 2) {
                return;
            }
            MainTabActivity mainTabActivity = this.f21453a;
            mainTabActivity.mCategoryTipController = new d.a.q0.e0.e(mainTabActivity.getPageContext(), fragmentTabWidget.getChildAt(2));
            this.f21453a.mCategoryTipController.g0(R.drawable.bg_tip_blue_down);
            this.f21453a.mCategoryTipController.L(2);
            this.f21453a.mCategoryTipController.O(32);
            this.f21453a.mCategoryTipController.h0(true);
            this.f21453a.mCategoryTipController.k0(-d.a.d.e.p.l.g(this.f21453a, R.dimen.tbds10));
            this.f21453a.mCategoryTipController.X(R.color.CAM_X0101);
            this.f21453a.mCategoryTipController.P(R.dimen.tbds54);
            this.f21453a.mCategoryTipController.T(999);
            this.f21453a.mCategoryTipController.N(5000);
            this.f21453a.mCategoryTipController.a0(d.a.d.e.p.l.g(this.f21453a, R.dimen.tbds44));
            this.f21453a.mCategoryTipController.o0(str, "categoryUpdate", false, true);
        }
    }

    /* loaded from: classes4.dex */
    public class r0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21454a;

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
            this.f21454a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean) || this.f21454a.mViewController == null || this.f21454a.mViewController.E() == null) {
                return;
            }
            if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.f21454a.mViewController.E().getTabWrapper().animate().translationY(this.f21454a.mViewController.E().getTabWrapper().getHeight()).setDuration(200L).start();
            } else {
                this.f21454a.mViewController.E().getTabWrapper().animate().translationY(0.0f).setDuration(400L).start();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21455a;

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
            this.f21455a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f21455a.mViewController == null || this.f21455a.mViewController.E() == null || this.f21455a.mViewController.E().getCurrentTabType() == 22) {
                return;
            }
            String string = this.f21455a.getString(R.string.tieba_video_channel_is_comming);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = this.f21455a.mViewController.E().getFragmentTabWidget();
            if (fragmentTabWidget.getChildCount() < 2) {
                return;
            }
            MainTabActivity mainTabActivity = this.f21455a;
            mainTabActivity.mCategoryTipController = new d.a.q0.e0.e(mainTabActivity.getPageContext(), fragmentTabWidget.getChildAt(2));
            this.f21455a.mCategoryTipController.g0(R.drawable.bg_tip_blue_left);
            this.f21455a.mCategoryTipController.L(2);
            this.f21455a.mCategoryTipController.O(32);
            this.f21455a.mCategoryTipController.h0(true);
            this.f21455a.mCategoryTipController.k0(-d.a.d.e.p.l.g(this.f21455a, R.dimen.tbds10));
            this.f21455a.mCategoryTipController.X(R.color.CAM_X0101);
            this.f21455a.mCategoryTipController.P(R.dimen.tbds109);
            this.f21455a.mCategoryTipController.T(1);
            this.f21455a.mCategoryTipController.N(3000);
            this.f21455a.mCategoryTipController.a0(d.a.d.e.p.l.g(this.f21455a, R.dimen.tbds44));
            this.f21455a.mCategoryTipController.o0(string, "videoChannelComming", true, false);
        }
    }

    /* loaded from: classes4.dex */
    public class s0 extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21456e;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ s0 f21457e;

            public a(s0 s0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {s0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21457e = s0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f21457e.f21456e.stopYoungsterUseTimeTask();
                    if (d.a.p0.e1.b.d.f()) {
                        return;
                    }
                    this.f21457e.f21456e.startYoungsterUseTimePeriodTask();
                }
            }
        }

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
            this.f21456e = mainTabActivity;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.d.e.m.e.a().post(new a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21458a;

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
            this.f21458a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f21458a.mViewController == null || this.f21458a.mViewController.E() == null || this.f21458a.mViewController.E().getCurrentTabType() == 8) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = this.f21458a.mViewController.E().getFragmentTabWidget();
            if (fragmentTabWidget.getChildCount() < 4) {
                return;
            }
            String string = this.f21458a.getString(R.string.my_create_center_tips);
            MainTabActivity mainTabActivity = this.f21458a;
            mainTabActivity.mMyTipController = new d.a.q0.e0.e(mainTabActivity.getPageContext(), fragmentTabWidget.getChildAt(4));
            this.f21458a.mMyTipController.g0(R.drawable.bg_tip_blue_dropdown_right);
            this.f21458a.mMyTipController.L(2);
            this.f21458a.mMyTipController.O(48);
            this.f21458a.mMyTipController.h0(true);
            this.f21458a.mMyTipController.j0(-d.a.d.e.p.l.g(this.f21458a, R.dimen.tbds62));
            this.f21458a.mMyTipController.X(R.color.CAM_X0101);
            this.f21458a.mMyTipController.e0(R.dimen.T_X08);
            this.f21458a.mMyTipController.T(1);
            this.f21458a.mMyTipController.N(3000);
            this.f21458a.mMyTipController.d0(d.a.d.e.p.l.g(this.f21458a, R.dimen.tbds25));
            this.f21458a.mMyTipController.a0(d.a.d.e.p.l.g(this.f21458a, R.dimen.tbds33));
            this.f21458a.mMyTipController.b0(d.a.d.e.p.l.g(this.f21458a, R.dimen.tbds36));
            this.f21458a.mMyTipController.c0(d.a.d.e.p.l.g(this.f21458a, R.dimen.tbds36));
            this.f21458a.mMyTipController.o0(string, "mycreatecentertip", true, true);
        }
    }

    /* loaded from: classes4.dex */
    public class t0 extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21459e;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ t0 f21460e;

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
                this.f21460e = t0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && d.a.p0.e1.b.d.f()) {
                    this.f21460e.f21459e.stopYoungsterUseTimeTask();
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
            this.f21459e = mainTabActivity;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.d.e.m.e.a().post(new a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u implements CheckRealNameModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21461a;

        public u(MainTabActivity mainTabActivity) {
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
            this.f21461a = mainTabActivity;
        }

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i2, String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, str2, obj}) == null) && CheckRealNameModel.TYPE_APP_FIRST_START.equals(str2) && i2 == 1990055) {
                TiebaStatic.log("c12138");
                this.f21461a.mViewController.Y(this.f21461a.getResources().getString(R.string.check_real_name_message));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21462a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u0(MainTabActivity mainTabActivity, int i2) {
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
            this.f21462a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.p0.u.l lVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.p0.u.l) || (lVar = (d.a.p0.u.l) customResponsedMessage.getData()) == null || StringUtils.isNull(lVar.f54114a)) {
                return;
            }
            d.a.p0.r0.b.i(lVar);
            if (StringUtils.isNull(lVar.f54116c)) {
                UrlManager.getInstance().dealOneLink(this.f21462a.getPageContext(), new String[]{lVar.f54114a});
            } else {
                UrlManager.getInstance().dealOneLink(this.f21462a.getPageContext(), new String[]{lVar.f54114a, lVar.f54116c});
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21463a;

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
            this.f21463a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001377) {
                this.f21463a.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21464a;

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
            this.f21464a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f21464a.mWriteTab == null) {
                return;
            }
            this.f21464a.mWriteTab.x();
        }
    }

    /* loaded from: classes4.dex */
    public class w extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21465a;

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
            this.f21465a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && d.a.d.e.p.l.D()) {
                this.f21465a.checkRealName();
                if (MainTabActivity.syncHasFinish) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21466e;

        public w0(MainTabActivity mainTabActivity) {
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
            this.f21466e = mainTabActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || TbSingleton.getInstance().getNewUserRedPackageData() == null) {
                return;
            }
            TbSingleton.getInstance().setNewUserRedPackageShowed(true);
            this.f21466e.sendMessage(new CustomMessage(2002001, new NewUserRedPackageActivityConfig(this.f21466e, TbSingleton.getInstance().getNewUserRedPackageData())));
            TbSingleton.getInstance().setNewUserRedPackageData(null);
        }
    }

    /* loaded from: classes4.dex */
    public class x implements g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Intent f21467a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21468b;

        public x(MainTabActivity mainTabActivity, Intent intent) {
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
            this.f21468b = mainTabActivity;
            this.f21467a = intent;
        }

        @Override // d.a.p0.a.g.b
        public void onCallBack(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) || hashMap == null || this.f21467a == null) {
                return;
            }
            Object obj = hashMap.get(d.a.p0.a.g.B);
            int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : -1;
            Object obj2 = hashMap.get(d.a.p0.a.g.C);
            String str = obj2 instanceof String ? (String) obj2 : null;
            Object obj3 = hashMap.get(d.a.p0.a.g.A);
            String str2 = obj3 instanceof String ? (String) obj3 : null;
            if (intValue != -1) {
                this.f21467a.putExtra("is_from_scheme", true);
                this.f21467a.putExtra("locate_type", intValue);
                this.f21467a.putExtra("sub_locate_type", str);
                this.f21467a.putExtra("sub_tab_name", str2);
                d.a.p0.s.a0.b.f52916b = intValue;
                Object obj4 = hashMap.get(d.a.p0.a.g.D);
                String str3 = obj4 instanceof String ? (String) obj4 : null;
                Object obj5 = hashMap.get(d.a.p0.a.g.E);
                String str4 = obj5 instanceof String ? (String) obj5 : null;
                this.f21467a.putExtra(d.a.p0.a.g.D, str3);
                this.f21467a.putExtra(d.a.p0.a.g.E, str4);
            }
            d.a.p0.a.d.y().L(true);
            if (intValue == 1 && "ForumSquare".equals(str)) {
                d.a.p0.s.a0.b.f52917c = d.a.p0.s.a0.b.f52919e;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921528));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class x0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21469a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x0(MainTabActivity mainTabActivity, int i2) {
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
            this.f21469a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && !TbSingleton.getInstance().isNewUserRedPackageShowed() && this.f21469a.isResumed && TbSingleton.getInstance().hasPerformedFirstLoginTest()) {
                d.a.d.e.m.e.a().removeCallbacks(this.f21469a.mCheckNewUserRedPackageRunnable);
                d.a.d.e.m.e.a().postDelayed(this.f21469a.mCheckNewUserRedPackageRunnable, 200L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f21470e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21471f;

        public y(MainTabActivity mainTabActivity, String str) {
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
            this.f21471f = mainTabActivity;
            this.f21470e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                UrlManager.getInstance().dealOneLink(this.f21471f.getPageContext(), new String[]{this.f21470e});
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21472a;

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
            this.f21472a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.p0.u.j) && ViewHelper.checkUpIsLogin(this.f21472a.getPageContext().getPageActivity())) {
                this.f21472a.showWriteThreadView();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class z implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21473e;

        public z(MainTabActivity mainTabActivity) {
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
            this.f21473e = mainTabActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921300, Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class z0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MainTabActivity f21474a;

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
            this.f21474a = mainTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.q0.h3.q0.k) && ((d.a.q0.h3.q0.k) customResponsedMessage.getData()).f58819b && this.f21474a.mLikeForumNum == 0) {
                this.f21474a.createLikeFirstForumTips();
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
        this.mEditorListener = new k(this, 2010045);
        this.mCloseMainTablistener = new v(this, 2001377);
        this.skinTypeChangeListener = new g0(this, 2001304);
        this.bigdayModifyNavbarListener = new r0(this, 2921348);
        this.showWriteThreadListener = new y0(this, 2921452);
        this.mLikeForumListener = new z0(this, 2001437);
        this.mEnterForumTabClickListener = new a1(this, 2001384);
        this.mOnlineListener = new b1(this, 1001);
        this.mJumpPbListener = new c1(this, 2001609);
        this.mPersonInfoChangeListener = new a(this, 2001247);
        this.mShowPostVideoSuccessListener = new b(this, 2001374);
        this.mAddTablistener = new c(this, 2007002);
        this.mRefreshTablistener = new d(this, 2007013);
        this.mRefreshTiplistener = new e(this, 2921333);
        this.mStartPollVideoMsgListener = new f(this, 2921579);
        this.startPollVideoMsg = new g(this);
        this.mForceConfirmListener = new h(this, 2921543);
        this.mSetMainTabInstListener = new i(this, 2007005);
        this.mShowGoBackShouBaiListener = new j(this, 2921380);
        this.mPersonInfoMsgListener = new p(this, CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
        this.updateMainTabProfileListener = new q(this, 2921504);
        this.mCategoryUpdateListener = new r(this, 2921491);
        this.mVideoChannelNoticeListener = new s(this, 2921567);
        this.mMyCreateCenterListener = new t(this, 2921538);
        this.checkRealNameCallBack = new u(this);
        this.networkChangedListener = new w(this, 2000994);
        this.mAccountChangedListener = new i0(this, 2005016);
        this.mGameCenterInitListener = new j0(this, 2016509);
        this.mGameMsgTipListener = new k0(this, 2001230);
        this.mSyncFinishListener = new l0(this, 2001371);
        this.mBackgroundChangeListener = new m0(this, 2001011);
        this.enterImageViewActivityListener = new n0(this, 2010000);
        this.youngsterUseTimerListener = new o0(this, 2921561);
        this.mYoungsterModeChangeListener = new p0(this, 2921509);
        this.mToHotTopicListener = new u0(this, 2016493);
        this.mOnScreenSizeChangeListener = new v0(this, 2921414);
        this.mCheckNewUserRedPackageRunnable = new w0(this);
        this.showNewUserRedPackageListener = new x0(this, 2921532);
    }

    private void callWindowMissed() {
        View currentFocus;
        InputMethodManager inputMethodManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65591, this) == null) || (currentFocus = getCurrentFocus()) == null || currentFocus.getWindowToken() == null || (inputMethodManager = (InputMethodManager) getSystemService("input_method")) == null) {
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
        if ((interceptable == null || interceptable.invokeV(65592, this) == null) && this.mLikeForumNum == 1) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65593, this)) == null) {
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
        if (interceptable == null || interceptable.invokeV(65594, this) == null) {
            String p2 = d.a.p0.s.d0.b.j().p("user_interest_info", null);
            if (TextUtils.isEmpty(p2)) {
                return;
            }
            d.a.p0.s.d0.b.j().C("user_interest_info");
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GUIDE_INTEREST_COMMIT);
            httpMessage.addParam("interestList", p2);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkCreateCenterTip() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65595, this) == null) && CreateCenterTipSwitch.isOn()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921538));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPluginEntranceState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65596, this) == null) {
            if (SwitchManager.getInstance().findType(GameEnterSwitch.GAME_ENTER_KEY) == 1 && GameCenterHelper.isGamePluginInit) {
                this.mViewController.Z(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016510));
                return;
            }
            this.mViewController.Z(false);
            this.mViewController.a0(false);
            d.a.p0.s.d0.b.j().t("game_is_show_tip", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkRealName() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65597, this) == null) {
            String str = "check_real_name" + TbConfig.getVersion();
            if (d.a.p0.s.d0.b.j().g(str, true) && !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && d.a.d.e.p.l.D()) {
                this.mCheckRealNameModel.x(CheckRealNameModel.TYPE_APP_FIRST_START);
                d.a.p0.s.d0.b.j().t(str, false);
            }
        }
    }

    private void checkSchemeFromIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65598, this, intent) == null) || intent == null) {
            return;
        }
        String dataString = intent.getDataString();
        UtilHelper.clearClipBoardBySchemaParam(dataString);
        if (!StringUtils.isNull(dataString) && dataString.startsWith(SCHEME_MAINTAB)) {
            String decode = Uri.decode(intent.getData().getEncodedPath());
            if (StringUtils.isNull(decode)) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_type", 1).param(TiebaStatic.Params.OBJ_TO, 1).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
                d.a.p0.a.x.a(param, decode);
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
                d.a.p0.a.x.b(statisticItem, paramPair);
                statisticItem.param("obj_locate", paramPair.get("obj_locate"));
                statisticItem.param("obj_type", 1);
                statisticItem.param("obj_source", paramPair.get("obj_source"));
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, paramPair.get(TiebaStatic.Params.OBJ_PARAM2));
                statisticItem.param(TiebaStatic.Params.OBJ_TO, 1);
                statisticItem.param("obj_id", paramPair.get("bdid"));
                statisticItem.param("obj_name", TbadkCoreApplication.getInst().getStartType());
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, 1);
                if (!d.a.d.e.p.k.isEmpty(paramPair.get("ext_log"))) {
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
            d.a.p0.a.d.y().L(true);
        } else if (!StringUtils.isNull(dataString) && (dataString.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT) || dataString.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT_ZM) || dataString.startsWith(UrlSchemaHelper.SCHEMA_LIVE_SDK) || dataString.startsWith(UrlSchemaHelper.SCHEMA_CHUSHOU_LIVE_SDK))) {
            String dataString2 = intent.getDataString();
            if (!StringUtils.isNull(dataString2) && PermissionUtil.isAgreePrivacyPolicy()) {
                UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{dataString2});
                d.a.p0.a.d.y().L(true);
            }
        } else if (!StringUtils.isNULL(dataString) && dataString.startsWith(d.a.p0.a.g.f51838a)) {
            d.a.p0.a.g.b().e(intent.getData(), new x(this, intent));
        }
        String stringExtra = intent.getStringExtra(MainTabActivityConfig.TARGET_SCHEME);
        if (StringUtils.isNull(stringExtra)) {
            return;
        }
        d.a.d.e.m.e.a().postDelayed(new y(this, stringExtra), this.isCreated ? 0L : DeviceInfoUtil.getMainTabActJumpOtherDelayTime());
        getIntent().removeExtra(MainTabActivityConfig.TARGET_SCHEME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkVersion(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65599, this, str) == null) || str == null || TbadkCoreApplication.getInst().getConfigVersion() == null || !checkAutoSyncInterval()) {
            return;
        }
        this.mLastSyncTime = System.currentTimeMillis();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearConcernCacheWhenVersionUpdate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65600, this) == null) {
            String str = d.a.p0.s.d0.b.n("key_is_clear_concern_cache_when_version_update") + "_" + TbConfig.getVersion();
            if (d.a.p0.s.d0.b.j().g(str, false)) {
                return;
            }
            try {
                d.a.p0.s.r.a.f().e("tb.concern_page", TbadkCoreApplication.getCurrentAccount()).g("0", null);
                d.a.p0.s.d0.b.j().t(str, true);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLikeFirstForumTips() {
        d.a.q0.e0.e eVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65601, this) == null) && (eVar = this.mLikeFirstForumTipsController) != null && eVar.J()) {
            this.mLikeFirstForumTipsController.I();
        }
    }

    public static void clearVideoChannelTabImg() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65602, null) == null) {
            d.a.p0.g0.c cVar = new d.a.p0.g0.c();
            cVar.f52624g = "";
            cVar.f52622e = 22;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921492, cVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createLikeFirstForumTips() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65603, this) == null) {
            FragmentTabWidget fragmentTabWidget = this.mViewController.E().getFragmentTabWidget();
            if (fragmentTabWidget.getChildCount() < 2) {
                return;
            }
            d.a.q0.e0.e eVar = new d.a.q0.e0.e(getPageContext(), fragmentTabWidget.getChildAt(1));
            this.mLikeFirstForumTipsController = eVar;
            eVar.g0(R.drawable.bg_tip_blue_down);
            this.mLikeFirstForumTipsController.L(2);
            this.mLikeFirstForumTipsController.O(32);
            this.mLikeFirstForumTipsController.h0(true);
            this.mLikeFirstForumTipsController.k0(-d.a.d.e.p.l.g(this, R.dimen.tbds10));
            this.mLikeFirstForumTipsController.X(R.color.CAM_X0101);
            this.mLikeFirstForumTipsController.P(R.dimen.tbds54);
            this.mLikeFirstForumTipsController.T(1);
            this.mLikeFirstForumTipsController.N(4000);
            this.mLikeFirstForumTipsController.a0(d.a.d.e.p.l.g(this, R.dimen.tbds44));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealForceConfirmSwitchTDouToYBean() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65604, this) == null) && !this.mIsAdd && this.mYYBeanForceConfirmDialog == null && TbadkCoreApplication.isLogin() && CurrencySwitchUtil.isNeedConfirmTDouToYBeanSwitchOpen()) {
            CurrencySwitchTDouYBeanDialog currencySwitchTDouYBeanDialog = new CurrencySwitchTDouYBeanDialog(getPageContext());
            this.mYYBeanForceConfirmDialog = currencySwitchTDouYBeanDialog;
            currencySwitchTDouYBeanDialog.showDialog();
        }
    }

    private void dealIntent(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65605, this, context, intent) == null) {
            UtilHelper.commenDealIntent(context, intent);
            TbadkCoreApplication.setIntent(null);
        }
    }

    private void dispatchWriteCallbakcData(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65606, this, intent) == null) || intent == null) {
            return;
        }
        PostWriteCallBackData postWriteCallBackData = null;
        try {
            postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921030, postWriteCallBackData));
        d.a.q0.k3.d dVar = this.mViewController;
        if (dVar == null || dVar.z(postWriteCallBackData)) {
            return;
        }
        this.mViewController.e0(postWriteCallBackData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void firstLoginTest() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65607, this) == null) || TbSingleton.getInstance().hasPerformedFirstLoginTest()) {
            return;
        }
        TbSingleton.getInstance().setHasPerformedFirstLoginTest(true);
        if (d.a.p0.b.d.v()) {
            if (TbadkCoreApplication.isLogin() || LoginActivity.class.getName().equals(d.a.d.e.p.l.v())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2921535, this));
        } else if (d.a.p0.b.d.w()) {
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65608, this)) == null) {
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
        if (interceptable == null || interceptable.invokeL(65609, this, intent) == null) {
            long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
            String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
            String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
            showConfirmShareToPersonDialog(getShareMsgData(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
        }
    }

    private boolean handlerExitApp(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65610, this, intent)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65611, this)) == null) {
            int i2 = Calendar.getInstance().get(11);
            if (i2 < 23 && i2 >= 7) {
                d.a.p0.e1.b.e.f52545a = false;
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
                timer2.schedule(new q0(this), time, 1000L);
                return false;
            }
            d.a.p0.e1.b.e.f52545a = true;
            stopYoungsterUseTimeTask();
            startYoungsterUseTimePeriodTask();
            return true;
        }
        return invokeV.booleanValue;
    }

    private void manageService() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65612, this) == null) || System.currentTimeMillis() - this.leaveTime < SERVICE_BETWEEN_TIME) {
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
        if (!(interceptable == null || interceptable.invokeL(65613, this, profileHttpResponseMessage) == null) || profileHttpResponseMessage == null || profileHttpResponseMessage.GetUser() == null) {
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
        if (interceptable == null || interceptable.invokeV(65615, this) == null) {
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
            this.mUpdateReceiver = new d1(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
            registerReceiver(this.mUpdateReceiver, intentFilter);
            this.packageChangedReceiver = new PackageChangedReceiver();
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction(PackageChangedReceiver.ACTION_INSTALL);
            intentFilter2.addAction(PackageChangedReceiver.ACTION_UNINSTALL);
            intentFilter2.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter2.addAction("android.intent.action.PACKAGE_CHANGED");
            intentFilter2.addDataScheme(AsInstallService.SCHEME_PACKAGE_ADDED);
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
        if (interceptable == null || interceptable.invokeV(65616, this) == null) {
            registerListener(new c0(this, 2007009));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setupIntent(Intent intent) {
        d.a.q0.k3.d dVar;
        int a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65617, this, intent) == null) || intent == null || (dVar = this.mViewController) == null || dVar.E() == null) {
            return;
        }
        try {
            if (intent.hasExtra("locate_type")) {
                a2 = intent.getIntExtra("locate_type", 1);
            } else {
                a2 = this.mAppEntranceModel.a();
            }
            this.mViewController.E().setCurrentTabByType(a2);
        } catch (Throwable unused) {
            finish();
        }
    }

    private void showConfirmShareToPersonDialog(ShareFromPBMsgData shareFromPBMsgData, long j2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65618, this, new Object[]{shareFromPBMsgData, Long.valueOf(j2), str, str2, str3}) == null) || shareFromPBMsgData == null) {
            return;
        }
        d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(getPageContext().getPageActivity());
        Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(getPageContext().getPageActivity());
        thread2GroupShareView.setData(shareFromPBMsgData);
        aVar.setContentViewSize(1);
        aVar.setContentView(thread2GroupShareView);
        aVar.setPositiveButton(R.string.share, new e0(this, thread2GroupShareView, j2, str, str2, str3, shareFromPBMsgData));
        aVar.setNegativeButton(R.string.cancel, new f0(this, thread2GroupShareView));
        aVar.setCanceledOnTouchOutside(true);
        aVar.create(getPageContext()).show();
        if (d.a.d.e.p.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
            return;
        }
        thread2GroupShareView.c(shareFromPBMsgData.getImageUrl(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLikeFirstForumTips() {
        d.a.q0.e0.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65619, this) == null) || (eVar = this.mLikeFirstForumTipsController) == null || eVar.J()) {
            return;
        }
        d.a.q0.e0.e eVar2 = this.mLikeFirstForumTipsController;
        String string = getString(R.string.enterforumtab_like_forum_tips);
        eVar2.m0(string, "first_like_forum_enterforumtab_tips" + TbadkCoreApplication.getCurrentAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startYoungsterUseTimePeriodTask() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65620, this) == null) && this.youngsterUseTimer == null) {
            this.youngsterUseTimer = new Timer();
            t0 t0Var = new t0(this);
            this.youngsterUseTimeTask = t0Var;
            this.youngsterUseTimer.schedule(t0Var, 1000L, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startYoungsterUseTimeTask() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65621, this) == null) && this.youngsterUseTimer == null) {
            this.youngsterUseTimer = new Timer();
            s0 s0Var = new s0(this);
            this.youngsterUseTimeTask = s0Var;
            this.youngsterUseTimer.schedule(s0Var, d.a.p0.e1.b.d.c() ? 1000L : YOUNGSTER_USE_TIME_MAX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopYoungsterUseTimeTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65622, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(65623, this) == null) {
            d1 d1Var = this.mUpdateReceiver;
            if (d1Var != null) {
                unregisterReceiver(d1Var);
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
            new d.a.p0.s.s.a(activity).setTitle(R.string.confirm_title).setCancelable(false).setMessageId(R.string.background_process_permission).setPositiveButton(R.string.now_goto_setting, new b0(this)).setNegativeButton(R.string.next_time, new a0(this)).create(d.a.d.a.j.a(activity)).show();
        }
    }

    public void clearMyCreateCenterTips() {
        d.a.q0.e0.e eVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (eVar = this.mMyTipController) != null && eVar.J()) {
            this.mMyTipController.I();
            this.mMyTipController = null;
        }
    }

    public void clearNewCategoryTips() {
        d.a.q0.e0.e eVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (eVar = this.mCategoryTipController) != null && eVar.J()) {
            this.mCategoryTipController.I();
            this.mCategoryTipController = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, keyEvent)) == null) {
            if (!MainTabActivityConfig.IS_BACK_CLOSE_ALL_ACTIVITY && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016322, (Class) null);
                if (runTask == null || !((Boolean) runTask.getData()).booleanValue()) {
                    CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2016323, (Class) null);
                    if (runTask2 == null || !((Boolean) runTask2.getData()).booleanValue()) {
                        d.a.q0.a4.f fVar = this.mWriteTab;
                        if (fVar != null && fVar.l()) {
                            this.mWriteTab.k(true);
                            return true;
                        } else if (this.mViewController.K()) {
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
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            if (this.mTouchable) {
                if (this.mViewController.E() == null || this.mViewController.E().getCurrentTabType() != 1 || motionEvent.getPointerCount() <= 1 || !this.mViewController.K()) {
                    return super.dispatchTouchEvent(motionEvent);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            TbSingleton.getInstance().clearVideoRecord();
            TbSingleton.getInstance().setHasAgreeToPlay(false);
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public ViewGroup getActivityRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.rootView : (ViewGroup) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, d.a.p0.m0.a
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
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

    @Override // d.a.q0.k3.a
    public int getCurrentTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.mViewController.E() != null) {
                return this.mViewController.E().getCurrentTabType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public d.a.d.e.k.b<TbImageView> getFrsCommonImageLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.mCommonImagePool == null) {
                this.mCommonImagePool = FrsCommonImageLayout.m(getPageContext().getPageActivity(), 12);
            }
            return this.mCommonImagePool;
        }
        return (d.a.d.e.k.b) invokeV.objValue;
    }

    public boolean getGpuSwich() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? TbadkCoreApplication.getInst().isGpuOpen() : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, d.a.p0.m0.a
    public d.a.p0.m0.b getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? new h0(this) : (d.a.p0.m0.b) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, voiceData$VoiceModel)) == null) {
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
        if (interceptable != null && (invokeV = interceptable.invokeV(1048593, this)) != null) {
            return (TbPageTag) invokeV.objValue;
        }
        d.a.q0.k3.d dVar = this.mViewController;
        if (dVar != null && dVar.E() != null) {
            Fragment currentFragment = this.mViewController.E().getCurrentFragment();
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
    public d.a.d.e.k.b<TbImageView> getUserIconPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.mUserIconPool == null) {
                this.mUserIconPool = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.mUserIconPool;
        }
        return (d.a.d.e.k.b) invokeV.objValue;
    }

    public int getUserIconViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.mVoiceManager == null) {
                this.mVoiceManager = VoiceManager.instance();
            }
            return this.mVoiceManager;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public void gotoFeedback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            AntiData antiData = new AntiData();
            antiData.setIfpost(1);
            if (antiData.getIfpost() == 0) {
                d.a.d.e.p.l.M(getPageContext().getPageActivity(), antiData.getForbid_info());
            } else if (WriteActivityConfig.isAsyncWriting()) {
            } else {
                antiData.setIfVoice(false);
                WriteActivityConfig.newInstance(this).setType(0).setFrom(this.mFrom).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setFeedBack(true).setAntiData(antiData).send();
            }
        }
    }

    public void initTabsOnActivityCreated() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007002, new d.a.p0.g0.d(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048599, this, i2, i3, intent) == null) {
            if (i3 != -1) {
                if (i2 == 25059) {
                    d.a.q0.n.e();
                } else if (i2 == 25060) {
                    d.a.q0.n.e();
                }
            }
            if (i3 != -1) {
                if (this.mViewController.E().getCurrentFragment() != null) {
                    this.mViewController.E().getCurrentFragment().onActivityResult(i2, i3, intent);
                }
            } else if (i2 == 25046) {
                if (TbadkCoreApplication.isLogin()) {
                    d.a.p0.a.s.g().l(getPageContext());
                }
            } else if (i2 == 11001) {
                gotoFeedback();
            } else if (i2 == 13003 || i2 == 25048) {
                dispatchWriteCallbakcData(intent);
            } else if (i2 == 23007) {
                handleShareFriendForum(intent);
            } else if (i2 == 13011) {
                d.a.q0.v2.a.g().m(getPageContext());
            } else if (i2 == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    d.a.q0.v2.a.g().m(getPageContext());
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                    if (shareItem != null) {
                        int i4 = shareItem.I;
                        if (i4 == 0) {
                            statisticItem.param("obj_locate", 5);
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
                    shareSuccessReplyToServerModel.w(str, intExtra2, new d0(this));
                }
            } else if (i2 == 25059) {
                if (d.a.p0.b.d.v()) {
                    if (TbadkApplication.getInst().isNeedNewUserLead() && TbadkCoreApplication.isLogin()) {
                        InterestGuideActivityConfig interestGuideActivityConfig = new InterestGuideActivityConfig(this, 1);
                        interestGuideActivityConfig.setRequestCode(25060);
                        interestGuideActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, interestGuideActivityConfig));
                        return;
                    }
                    return;
                }
                d.a.q0.n.e();
            } else if (i2 == 25060) {
                if (d.a.p0.b.d.w()) {
                    if (TbadkCoreApplication.isLogin()) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921535, this));
                    return;
                }
                d.a.q0.n.e();
            } else if (this.mViewController.E().getCurrentFragment() != null) {
                this.mViewController.E().getCurrentFragment().onActivityResult(i2, i3, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.mViewController.L(i2);
            adjustResizeForSoftInputOnSkinTypeChanged(i2);
            d.a.q0.a4.f fVar = this.mWriteTab;
            if (fVar != null) {
                fVar.p(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, configuration) == null) || configuration == null) {
            return;
        }
        super.onConfigurationChanged(configuration);
        if (TbadkCoreApplication.getInst().getSkinType() != 1) {
            SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bundle) == null) {
            d.a.p0.o0.l.b().x(System.currentTimeMillis());
            if (TbadkCoreApplication.getInst().getIsFirstUse()) {
                d.a.p0.b1.i0.b(new l(this), null);
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
            d.a.p0.s.a0.b.f52917c = d.a.p0.s.a0.b.f52918d;
            if (getIntent() != null) {
                d.a.q0.k3.e eVar = new d.a.q0.k3.e(getPageContext());
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
            d.a.q0.k3.b bVar = new d.a.q0.k3.b();
            d.a.p0.s.a0.b.h(bVar);
            bVar.g(this);
            if (getGpuSwich()) {
                CompatibleUtile.getInstance().openGpu(getPageContext().getPageActivity());
            }
            setContentView(R.layout.maintabs_activity);
            this.rootView = (FrameLayout) findViewById(R.id.maintabContainer);
            if (d.a.p0.s.l.a.b() != null) {
                d.a.p0.s.l.a.b().e();
            }
            this.mViewController = new d.a.q0.k3.d(this);
            this.mMainTabTopicTipController = new d.a.q0.k3.c(this);
            this.mViewController.P(this.mIsLogin);
            checkPluginEntranceState();
            regReceiver();
            d.a.q0.k3.f.b.i().e(this);
            d.a.p0.a.d.y().q();
            this.mAppEntranceModel = new d.a.q0.b();
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
            d.a.p0.m.a.f(getPageContext().getPageActivity());
            String installOtherApp = TbadkCoreApplication.getInst().getInstallOtherApp();
            if (installOtherApp != null && installOtherApp.length() > 0) {
                UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), installOtherApp);
                TbadkCoreApplication.getInst().setInstallOtherApp(null);
            }
            this.mHandler.post(new m(this));
            TbadkCoreApplication.getInst().startTrackConfigRequest();
            if (PermissionUtil.checkLocationForGoogle(getActivity())) {
                MercatorModel.d().f();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921545, null));
            registerListener(this.mOnlineListener);
            if (i2 == 1) {
                this.mViewController.d0(true);
            } else {
                this.mViewController.d0(false);
            }
            this.mViewController.R();
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
                d.a.p0.o0.l.b().f();
            }
            if (TbadkCoreApplication.isLogin()) {
                d.a.p0.a0.b.a().d();
            }
            d.a.p0.s.d0.b.j().v("app_restart_times", d.a.p0.s.d0.b.j().k("app_restart_times", 0) + 1);
            CheckRealNameModel checkRealNameModel = new CheckRealNameModel(getPageContext());
            this.mCheckRealNameModel = checkRealNameModel;
            checkRealNameModel.A(this.checkRealNameCallBack);
            checkRealName();
            this.mNEGFeedBackManager = new d.a.q0.h.a(getPageContext(), "homepage");
            this.mShareSuccessReplyToServerModel = new ShareSuccessReplyToServerModel();
            this.mUegForwardCheckController = new d.a.q0.p3.d(getPageContext());
            this.mBdTokenController = d.a.p0.a.e.y();
            int loadInt = TbadkSettings.getInst().loadInt("skin_", 0);
            if (loadInt != 1) {
                SkinManager.setDayOrDarkSkinTypeWithSystemMode(false, true);
            } else {
                TbadkCoreApplication.getInst().setSkinTypeValue(loadInt);
                TbadkCoreApplication.getInst().SendSkinTypeBroadcast(loadInt);
            }
            if (TbSingleton.getInstance().isEnableBenchmark() && TbSingleton.getInstance().getCpuFlopsDuration() <= 0) {
                d.a.d.e.m.e.a().postDelayed(new n(this), 5000L);
            }
            MessageManager.getInstance().registerListener(this.mToHotTopicListener);
            TbSingleton.getInstance().startOneGame();
            this.mWeakContext = new WeakReference<>(TbadkCoreApplication.getInst());
            if (getResources() != null && getResources().getConfiguration() != null) {
                this.lastUiMode = getResources().getConfiguration().uiMode & 48;
            }
            d.a.x0.c.c(TbadkCoreApplication.getInst()).e(null);
            clearConcernCacheWhenVersionUpdate();
            if (this.mPushInsertThreadController.b(intent)) {
                this.mPushInsertThreadController.a(getIntent(), this.mViewController);
            }
            updateProfileInfo();
            if (d.a.p0.b.d.R()) {
                d.a.q0.v0.a.i().y(this, "6051001980-1210572494", d.a.q0.v0.a.b("personalize", "1"));
            }
            if (d.a.p0.b.d.x() && d.a.p0.b.d.D()) {
                d.a.q0.v0.a.i().z(this, d.a.q0.v0.d.c.e().d("frs_feed"), d.a.q0.v0.a.b("frs", "1"), "");
            }
            TbSingleton.getInstance().getChannelConfigModel().e();
            TbSingleton.getInstance().setActiveTimeStamp();
            if (d.a.p0.e1.b.e.d()) {
                d.a.p0.e1.b.d.f52528a = false;
                d.a.p0.e1.b.c.a();
                if (!handlerYoungsterNightTask()) {
                    startYoungsterUseTimeTask();
                }
            }
            this.isCreated = true;
            d.a.d.e.m.e.a().postDelayed(new o(this), 1000L);
            Thread.setDefaultUncaughtExceptionHandler(new d.a.d.j.c(Thread.getDefaultUncaughtExceptionHandler()));
            d.a.p0.o0.l.b().y(System.currentTimeMillis());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005010, null));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005012, null));
            unregReceiver();
            d.a.p0.t.d.b.g0().o();
            d.a.p0.t.d.b.g0().q();
            d.a.p0.t.d.b.g0().X(false);
            MessageManager.getInstance().unRegisterListener(this.mToHotTopicListener);
            MessageManager.getInstance().unRegisterListener(this.mShowGoBackShouBaiListener);
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null && getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
            }
            d.a.p0.s.f0.a aVar = this.mWaitingDialog;
            if (aVar != null) {
                aVar.h(false);
                this.mWaitingDialog = null;
            }
            callWindowMissed();
            d.a.q0.k3.d dVar = this.mViewController;
            if (dVar != null) {
                dVar.M();
            }
            d.a.q0.k3.c cVar = this.mMainTabTopicTipController;
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
            d.a.p0.s.a0.b.h(null);
            d.a.p0.y.d.h().l();
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            d.a.q0.a4.f fVar = this.mWriteTab;
            if (fVar != null) {
                fVar.r();
            }
            d.a.q0.h.a aVar2 = this.mNEGFeedBackManager;
            if (aVar2 != null) {
                aVar2.h();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.mShareSuccessReplyToServerModel;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            d.a.q0.p3.b bVar = this.mCancelController;
            if (bVar != null) {
                bVar.f();
            }
            d.a.q0.k3.d dVar2 = this.mViewController;
            if (dVar2 != null && dVar2.D() != null) {
                this.mViewController.D().t();
            }
            if (d.a.p0.b.d.a0()) {
                d.a.q0.v0.a.i().d("6061002332-203360688");
            }
            if (d.a.p0.b.d.b0()) {
                d.a.q0.v0.a.i().c("6061002410-390177882");
            }
            d.a.q0.m1.c.b().c();
            d.a.d.e.m.e.a().removeCallbacks(this.mCheckNewUserRedPackageRunnable);
            d.a.d.e.m.e.a().removeCallbacks(this.startPollVideoMsg);
            System.gc();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048604, this, i2, keyEvent)) == null) {
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
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048605, this, i2, keyEvent)) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048606, this, z2) == null) {
            this.isKeyboardVisible = z2;
            boolean z3 = this.isEditorVisible || z2;
            d.a.q0.k3.d dVar = this.mViewController;
            if (dVar != null) {
                dVar.N(z3);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        d.a.q0.k3.d dVar;
        FragmentTabHost.b g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, intent) == null) {
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
                d.a.p0.a0.b.a().d();
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
                    d.a.q0.k3.d dVar2 = this.mViewController;
                    if (dVar2 != null && dVar2.E() != null) {
                        this.mViewController.S(intExtra);
                    }
                } else if ((intExtra == 17 || intExtra == 18) && (dVar = this.mViewController) != null && dVar.E() != null) {
                    this.mViewController.E().setCurrentTab(0);
                }
                d.a.q0.k3.d dVar3 = this.mViewController;
                if (dVar3 != null && dVar3.E() != null && (g2 = this.mViewController.E().g(intExtra)) != null) {
                    Fragment fragment = g2.f12395c;
                    if (fragment instanceof d.a.p0.s.g) {
                        ((d.a.p0.s.g) fragment).B0(intent);
                    }
                }
                dealIntent(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
                d.a.q0.k3.d dVar4 = this.mViewController;
                if (dVar4 != null) {
                    dVar4.R();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
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
            d.a.q0.k3.c cVar = this.mMainTabTopicTipController;
            if (cVar != null) {
                cVar.g();
            }
            KuangFloatingViewController.getInstance().hideFloatingView();
            d.a.p0.y.d.h().i(true);
            clearLikeFirstForumTips();
            d.a.d.e.m.e.a().removeCallbacks(this.mCheckNewUserRedPackageRunnable);
            d.a.q0.k3.d dVar = this.mViewController;
            if (dVar != null) {
                dVar.Q();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, d.a.d.a.i
    public void onPreLoad(d.a.d.k.e.q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, qVar) == null) {
            super.onPreLoad(qVar);
            PreLoadImageHelper.load(qVar, getUniqueId());
            PreLoadVideoHelper.load(qVar, getUniqueId(), this);
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, bundle) == null) {
            try {
                super.onRestoreInstanceState(bundle);
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onResume();
            this.isResumed = true;
            if (this.doRefresh) {
                d.a.p0.b1.o0.f(this.mWeakContext);
                this.doRefresh = false;
            }
            d.a.q0.k3.d dVar = this.mViewController;
            if (dVar != null && dVar.D() != null) {
                this.mViewController.D().setLottieView(true);
            }
            d.a.q0.k3.d dVar2 = this.mViewController;
            if (dVar2 != null && dVar2.E() != null) {
                this.reloginGotoType = this.mViewController.E().getCurrentTabType();
            }
            changeSkinType(this.mSkinType);
            d.a.p0.y.d.h().i(true);
            if (TbadkCoreApplication.isLogin() && d.a.p0.o0.l.b().e()) {
                d.a.p0.o0.l.b().f();
            }
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            d.a.q0.k3.d dVar3 = this.mViewController;
            if (dVar3 != null) {
                dVar3.O();
                this.mViewController.R();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001385, getActivity()));
            if (TbadkCoreApplication.getKeepLiveSwitch(getApplicationContext())) {
                d.a.d.e.m.e.a().postDelayed(new z(this), 3000L);
            }
            d.a.p0.o0.l.b().f();
            if (d.a.p0.a.s.g().c() != null && d.a.p0.a.s.g().i() != null && d.a.p0.a.s.g().c().getCurTaskType() == 6) {
                d.a.p0.a.s.g().i().a();
            }
            showLikeFirstForumTips();
            if (this.mCurrentTabIndex.intValue() != 1) {
                showLikeFirstForumTips();
            }
            if (!TbSingleton.getInstance().isNewUserRedPackageShowed() && TbSingleton.getInstance().hasPerformedFirstLoginTest()) {
                d.a.d.e.m.e.a().removeCallbacks(this.mCheckNewUserRedPackageRunnable);
                d.a.d.e.m.e.a().postDelayed(this.mCheckNewUserRedPackageRunnable, 200L);
            }
            statisticDynamicIconExposure();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, bundle) == null) {
            try {
                super.onSaveInstanceState(bundle);
            } catch (Exception unused) {
            }
            bundle.putInt("locate_type", this.mViewController.E().getCurrentTabType());
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
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            super.onScreenShot(str);
            d.a.q0.k3.d dVar = this.mViewController;
            if (dVar == null || dVar.E() == null || this.mViewController.E().getCurrentTabType() != 2) {
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SCREEN_SHOT).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", 1));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.onStart();
            VoiceManager voiceManager = getVoiceManager();
            this.mVoiceManager = voiceManager;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048616, this, z2) == null) {
            super.onUserChanged(z2);
            this.isAccountStatChanged = true;
            if (z2) {
                d.a.p0.a0.b.a().d();
                checkPluginEntranceState();
                checkRealName();
                updateProfileInfo();
            }
            this.mViewController.f0(z2);
            this.mViewController.I();
            initTabsOnActivityCreated();
        }
    }

    public void processBeforeGoBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            d.a.d.e.l.d.h().b(getUniqueId());
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            d.a.q0.k3.d dVar = this.mViewController;
            if (dVar != null && dVar.E() != null) {
                FragmentTabHost E = this.mViewController.E();
                FragmentTabHost.b f2 = E.f(E.getCurrentTabIndex());
                if (f2 != null && f2.f12393a == 22) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void showMemberTip(PayMemberInfoData payMemberInfoData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, payMemberInfoData) == null) && TbadkCoreApplication.getInst().appResponseToIntentClass(MemberPayActivityConfig.class) && payMemberInfoData != null) {
            if ((payMemberInfoData.y() == 1 || payMemberInfoData.y() == 2) && d.a.p0.s.d0.b.j().g("show_member_deid_line", true)) {
                long w2 = payMemberInfoData.w() * 1000;
                if (w2 < System.currentTimeMillis()) {
                    if (StringUtils.isNull(payMemberInfoData.x())) {
                        payMemberInfoData.A(getPageContext().getString(R.string.member));
                    } else {
                        payMemberInfoData.A(payMemberInfoData.x() + getPageContext().getString(R.string.member_already_Expire));
                    }
                    this.mViewController.b0(payMemberInfoData, 0);
                } else if (w2 - System.currentTimeMillis() < 259200000) {
                    if (StringUtils.isNull(payMemberInfoData.x())) {
                        payMemberInfoData.A(getPageContext().getString(R.string.member));
                    } else {
                        payMemberInfoData.A(payMemberInfoData.x() + getPageContext().getString(R.string.member_will_Expire));
                    }
                    this.mViewController.b0(payMemberInfoData, 1);
                }
            }
        }
    }

    public void showWriteThreadView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            d.a.q0.k3.c cVar = this.mMainTabTopicTipController;
            if (cVar != null) {
                cVar.h();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
            if (this.mWriteTab == null) {
                d.a.q0.a4.f fVar = new d.a.q0.a4.f(getPageContext(), this.rootView, "main_tab", 3);
                this.mWriteTab = fVar;
                fVar.C("8");
            }
            if (this.mUegForwardCheckController.d() || this.mViewController.E() == null || this.mViewController.E().getFragmentTabWidget() == null) {
                return;
            }
            this.mWriteTab.G(false, this.mViewController.E().getTabWrapper(), this.mViewController.E().getFragmentTabWidget().getWriteView());
        }
    }

    public void statisticDynamicIconExposure() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048621, this) == null) && d.a.p0.g0.e.c.d().b()) {
            StatisticItem statisticItem = new StatisticItem("c14132");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public void updateProfileInfo() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && d.a.d.e.p.j.A() && TbadkCoreApplication.getCurrentAccount() != null) {
            ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
            profileRequestMessage.set_uid(Long.valueOf(d.a.d.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L)));
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? d.a.p0.b1.o0.a(1) : invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onResponseMessage(ProfileSocketResponseMessage profileSocketResponseMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65614, this, profileSocketResponseMessage) == null) || profileSocketResponseMessage == null || profileSocketResponseMessage.GetUser() == null) {
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
