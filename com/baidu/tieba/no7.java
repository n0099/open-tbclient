package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.BottomCommonTipLayout;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.FrsVideoTabPlayActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.MemberBroadcastHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.ChatEntranceLoopData;
import com.baidu.tbadk.data.ChatRoomEntranceData;
import com.baidu.tbadk.data.ChatRoomInfoData;
import com.baidu.tbadk.data.MemberBroadcastData;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.mainTab.FragmentDelegate;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.FragmentTabStructure;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.FrsNoListItemViewHolder;
import com.baidu.tieba.frs.FrsTabHostFragment;
import com.baidu.tieba.frs.FrsTabViewPager;
import com.baidu.tieba.frs.gametab.AlaGameTabGetNewNotifyResponsedMessage;
import com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.rate.RateManager;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.xo5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes7.dex */
public class no7 implements h36, VoiceManager.i, FrsCommonImageLayout.e {
    public static /* synthetic */ Interceptable $ic;
    public static final String j0;
    public static final String r0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public er7 D;
    public ev7 E;
    public FragmentContainerView F;
    @NonNull
    public final xo5 G;
    public xo5.b H;
    public boolean I;
    public BottomCommonTipLayout J;
    public long K;
    public NetMessageListener L;
    public CustomMessageListener M;
    public CustomMessageListener N;
    public CustomMessageListener O;
    public HttpMessageListener P;
    public CustomMessageListener Q;
    public CustomMessageListener R;
    public Runnable S;

    /* renamed from: T  reason: collision with root package name */
    public final CustomMessageListener f1148T;
    public final CustomMessageListener U;
    public CustomMessageListener V;
    public CustomMessageListener W;
    public CustomMessageListener X;
    public CustomMessageListener Y;
    public CustomMessageListener Z;
    public xu7 a;
    public final CustomMessageListener a0;
    public FrsActivity b;
    public CustomMessageListener b0;
    public FrsFragment c;
    public CustomMessageListener c0;
    public FrsTabHostFragment d;
    public CustomMessageListener d0;
    public qea e;
    public CustomMessageListener e0;
    public yh7 f;
    public final CustomMessageListener f0;
    public boolean g;
    public CustomMessageListener g0;
    public final Handler h;
    public final ItemCardHelper.c h0;
    public String i;
    public Runnable i0;
    public String j;
    public int k;
    public String l;
    public int m;
    public ShareSuccessReplyToServerModel n;
    public boolean o;
    public FrameLayout p;
    public OvalActionButton q;
    public FRSRefreshButton r;
    public View s;
    public FrameLayout t;
    public LinearLayout u;
    public boolean v;
    public boolean w;
    public NavigationBarCoverTip x;
    public boolean y;
    public boolean z;

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager.IPlayView q1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    /* loaded from: classes7.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no7 a;

        /* loaded from: classes7.dex */
        public class a extends FragmentDelegate {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ t a;

            @Override // com.baidu.tbadk.mainTab.FragmentDelegate
            public boolean isAvailable() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return true;
                }
                return invokeV.booleanValue;
            }

            public a(t tVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {tVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = tVar;
            }

            @Override // com.baidu.tbadk.mainTab.FragmentDelegate
            public TbFragmentTabIndicator getTabIndicator(Context context) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                    FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
                    this.mIndicator = fragmentTabIndicator;
                    fragmentTabIndicator.setTextSize(2.0f);
                    return this.mIndicator;
                }
                return (TbFragmentTabIndicator) invokeL.objValue;
            }

            @Override // com.baidu.tbadk.mainTab.FragmentDelegate
            public FragmentTabStructure createFragmentTabStructure() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    FrsSportsRecommendFragment frsSportsRecommendFragment = new FrsSportsRecommendFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", this.a.a.c.v());
                    bundle.putString("from", this.a.a.c.getFrom());
                    bundle.putString("forum_id", this.a.a.c.w());
                    bundle.putInt("tab_id", 503);
                    bundle.putBoolean("can_auto_play_video", this.a.a.e.isFrsVideoAutoPlay);
                    boolean z = true;
                    if (this.a.a.e.needLog != 1) {
                        z = false;
                    }
                    bundle.putBoolean(DownloadStatisticConstants.UBC_SOURCE_NEED_LOG, z);
                    bundle.putBoolean("is_brand_forum", this.a.a.e.isBrandForum);
                    FrsViewData frsViewData = new FrsViewData();
                    frsViewData.receiveData(this.a.a.e);
                    bundle.putSerializable("view_data", frsViewData);
                    frsSportsRecommendFragment.setArguments(bundle);
                    FragmentTabStructure fragmentTabStructure = new FragmentTabStructure();
                    fragmentTabStructure.frag = frsSportsRecommendFragment;
                    fragmentTabStructure.type = 25;
                    fragmentTabStructure.showIconType = FragmentTabStructure.SHOWTEXT;
                    return fragmentTabStructure;
                }
                return (FragmentTabStructure) invokeV.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(no7 no7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof yh7)) {
                if (!SharedPrefHelper.getInstance().getBoolean(this.a.l, true)) {
                    SafeHandler.getInst().post(this.a.S);
                }
                ((yh7) customResponsedMessage.getData()).a(new a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no7 a;

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomDialogData a;
            public final /* synthetic */ y b;

            public a(y yVar, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {yVar, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = yVar;
                this.a = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.b != null) {
                    ij9.a(this.b.a.b.getPageContext(), this.a).show();
                }
            }
        }

        public y(no7 no7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no7Var;
        }

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void b(CustomDialogData customDialogData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customDialogData) == null) {
                SafeHandler.getInst().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(no7 no7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            this.a.g0();
            YunDialogManager.unMarkShowingDialogName("frsGroupChatGuide");
        }
    }

    /* loaded from: classes7.dex */
    public class a0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a0(no7 no7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int d0;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    d0 = this.a.d0(9);
                    if (d0 == -1) {
                        d0 = this.a.d0(2);
                    }
                } else {
                    d0 = this.a.d0(intValue);
                }
                if (d0 != -1 && this.a.q0() && this.a.d != null) {
                    this.a.d.D2(d0);
                    if (this.a.c0(d0) != 1) {
                        this.a.c.Z4(false);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no7 a;

        public b(no7 no7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.s != null) {
                this.a.s.setVisibility(0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b0 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b0(no7 no7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<io7> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (ListUtils.isEmpty(newNotifyData) || this.a.d == null) {
                    return;
                }
                for (io7 io7Var : newNotifyData) {
                    if (io7Var != null) {
                        for (int i2 = 0; i2 < this.a.f.f().size(); i2++) {
                            FragmentTabHost.c s2 = this.a.d.s2(i2);
                            if (s2 != null && (i = s2.a) != 1 && i != this.a.d.l2() && s2.a == io7Var.a() && io7Var.b() && s2.b.getTip(String.valueOf(s2.a)) != null) {
                                s2.b.getTip(String.valueOf(s2.a)).f1084view.setVisibility(0);
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(no7 no7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016) {
                return;
            }
            this.a.o = true;
        }
    }

    /* loaded from: classes7.dex */
    public class c0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c0(no7 no7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                new BdTopToast(this.a.b, 2000).setIcon(false).setContent(this.a.b.getString(R.string.frs_top_forum_rules_click_toast)).show((ViewGroup) this.a.b.findViewById(R.id.obfuscated_res_0x7f090c54));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(no7 no7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                this.a.v = aVar.a();
                this.a.w = aVar.b();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d0(no7 no7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921641) {
                this.a.A = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(no7 no7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                this.a.z = booleanValue;
                if (booleanValue) {
                    this.a.q.setVisibility(8);
                    this.a.B = false;
                    return;
                }
                this.a.q.setVisibility(0);
                this.a.B = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no7 a;

        public e0(no7 no7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SafeHandler.getInst().removeCallbacks(this);
                this.a.r0();
                SafeHandler.getInst().postDelayed(this, 30000L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(no7 no7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            if ((customResponsedMessage.getData() instanceof wt7) && ((wt7) customResponsedMessage.getData()).a != null) {
                View view2 = ((wt7) customResponsedMessage.getData()).a;
                if (view2.getParent() != null) {
                    if (((ViewGroup) view2.getParent()) != this.a.t) {
                        ((ViewGroup) view2.getParent()).removeView(view2);
                        this.a.t.removeAllViews();
                        this.a.t.addView(view2);
                    }
                } else {
                    this.a.t.removeAllViews();
                    this.a.t.addView(view2);
                }
                this.a.t.setVisibility(0);
                return;
            }
            this.a.t.removeAllViews();
            this.a.t.setVisibility(8);
        }
    }

    /* loaded from: classes7.dex */
    public class f0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f0(no7 no7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            this.a.Q0();
        }
    }

    /* loaded from: classes7.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(no7 no7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                Integer num = (Integer) customResponsedMessage.getData();
                if (this.a.c != null && this.a.H != null && this.a.c.k4() != null && this.a.c.k4().B() != null && (this.a.c.k4().B().b instanceof BaseFragment)) {
                    if (num.intValue() == 2 && this.a.H.getState() == 2) {
                        this.a.H.g();
                    } else if (num.intValue() == 0 && this.a.H.getState() == 1) {
                        if (this.a.b == null || this.a.b.v1() == null || !this.a.b.v1().b()) {
                            if ((this.a.a != null && (this.a.a.l() || this.a.a.m())) || this.a.H.Z()) {
                                return;
                            }
                            if (of5.j()) {
                                of5.h();
                            }
                            this.a.H.b1();
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(no7 no7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ChatRoomInfoData chatRoomInfoData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && !customResponsedMessage.hasError() && (customResponsedMessage.getData() instanceof ChatEntranceLoopData)) {
                ChatEntranceLoopData chatEntranceLoopData = (ChatEntranceLoopData) customResponsedMessage.getData();
                ChatRoomEntranceData entranceData = chatEntranceLoopData.getEntranceData();
                if (this.a.H != null && this.a.H.I1(chatEntranceLoopData.getUniqueId())) {
                    long j = 0;
                    if (this.a.K == 0 && entranceData != null && !ListUtils.isEmpty(entranceData.getChatRoomInfoList()) && (chatRoomInfoData = entranceData.getChatRoomInfoList().get(0)) != null) {
                        no7 no7Var = this.a;
                        if (chatRoomInfoData.getChatroomInfoBasicData() != null) {
                            j = chatRoomInfoData.getChatroomInfoBasicData().getForumId();
                        }
                        no7Var.K = j;
                    }
                    if (entranceData == null || entranceData.getHotListOriginNum() <= 0) {
                        if (!this.a.I && this.a.F.getVisibility() != 8) {
                            this.a.F.setVisibility(8);
                        }
                    } else {
                        this.a.I = true;
                        this.a.S();
                    }
                    if (this.a.C && this.a.I && this.a.Z() != null) {
                        this.a.Z().a5(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003025));
                        this.a.C = false;
                    }
                    this.a.H.J(entranceData);
                    this.a.H.P0(this.a.C);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(no7 no7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.b.b != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    Runnable runnable = this.a.b.b.c;
                    SafeHandler.getInst().removeCallbacks(runnable);
                    SafeHandler.getInst().post(runnable);
                    return;
                }
                SafeHandler.getInst().removeCallbacks(this.a.b.b.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(no7 no7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof MemberBroadcastData) || this.a.e == null || !this.a.e.isMemberBroadcastForum) {
                return;
            }
            this.a.O0((MemberBroadcastData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes7.dex */
    public class k extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(no7 no7Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no7Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no7Var;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            qea qeaVar;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && !this.a.g && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    FrsPageHttpResponseMessage frsPageHttpResponseMessage = (FrsPageHttpResponseMessage) responsedMessage;
                    qeaVar = frsPageHttpResponseMessage.getResponseData();
                    i = frsPageHttpResponseMessage.getUpdateType();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    FRSPageSocketResponsedMessage fRSPageSocketResponsedMessage = (FRSPageSocketResponsedMessage) responsedMessage;
                    qeaVar = fRSPageSocketResponsedMessage.getResponseData();
                    i = fRSPageSocketResponsedMessage.getUpdateType();
                } else {
                    qeaVar = null;
                    i = -1;
                }
                if (qeaVar == null) {
                    return;
                }
                this.a.g = true;
                this.a.D0(qeaVar, true, i);
                if (qeaVar != null && qeaVar.getForum() != null && !StringUtils.isNull(qeaVar.getForum().getId())) {
                    r05.b().l("2", qeaVar.getForum().getId());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(no7 no7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof MemberBroadcastData)) {
                return;
            }
            this.a.O0((MemberBroadcastData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes7.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(no7 no7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean) || !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            this.a.i0();
        }
    }

    /* loaded from: classes7.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(no7 no7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.hasError()) {
                return;
            }
            this.a.i0();
        }
    }

    /* loaded from: classes7.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no7 a;

        public o(no7 no7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.H != null) {
                this.a.s.setVisibility(8);
                this.a.H.F1();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no7 a;

        public p(no7 no7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.x == null) {
                    no7 no7Var = this.a;
                    no7Var.x = (NavigationBarCoverTip) no7Var.b.findViewById(R.id.obfuscated_res_0x7f091901);
                }
                ru7.b(this.a.x, this.a.c, this.a.i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no7 a;

        public q(no7 no7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                no7 no7Var = this.a;
                boolean Q = no7Var.Q(no7Var.e.getGameTabInfo());
                if (Q && Q && this.a.d != null) {
                    this.a.d.F2(this.a.c);
                    this.a.d.C2(this.a.e, this.a.f);
                }
                if (this.a.b.isLoadingViewAttached()) {
                    this.a.b.hideLoadingView(this.a.b.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no7 a;

        public r(no7 no7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bundle bundle;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c.M = true;
                if (this.a.c != null) {
                    bundle = this.a.c.getArguments();
                } else {
                    bundle = null;
                }
                this.a.l0(bundle);
                if (this.a.b.isLoadingViewAttached()) {
                    this.a.b.hideLoadingView(this.a.b.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no7 a;

        public s(no7 no7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no7Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                if (this.a.V() == 506) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.a.F.clearAnimation();
                    this.a.F.setAlpha(0.0f);
                    this.a.F.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(no7 no7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof View)) {
                return;
            }
            ItemCardHelper.l(this.a.b, this.a.b.getUniqueId(), (View) customResponsedMessage.getData(), (ViewGroup) this.a.b.findViewById(R.id.obfuscated_res_0x7f090c54));
        }
    }

    /* loaded from: classes7.dex */
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(no7 no7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && !this.a.g && this.a.e == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof qea)) {
                qea qeaVar = (qea) customResponsedMessage.getData();
                if (qeaVar.getForum() == null || this.a.i == null || !this.a.i.equals(qeaVar.getForum().getName())) {
                    return;
                }
                this.a.D0(qeaVar, false, -1);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no7 a;

        public w(no7 no7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no7Var;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                ItemCardHelper.y(this.a.b, ItemCardHelper.OrderTipStatus.FAIL, (ViewGroup) this.a.b.findViewById(R.id.obfuscated_res_0x7f090c54), 0L);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                ItemCardHelper.y(this.a.b, ItemCardHelper.OrderTipStatus.SUCCESS, (ViewGroup) this.a.b.findViewById(R.id.obfuscated_res_0x7f090c54), j);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no7 a;

        public x(no7 no7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Intent parseUri = Intent.parseUri(TbSingleton.getInstance().getSchemaForStartOtherAppAfterSwanApp(), 1);
                    parseUri.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                    this.a.b.startActivity(parseUri);
                    TbSingleton.getInstance().setSchemaForStartOtherAppAfterSwanApp(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(no7 no7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.P();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948009267, "Lcom/baidu/tieba/no7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948009267, "Lcom/baidu/tieba/no7;");
                return;
            }
        }
        j0 = FrsFragment.class.getSimpleName();
        r0 = FrsTabHostFragment.class.getSimpleName();
    }

    public final void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            SafeHandler.getInst().postDelayed(new b(this), 700L);
        }
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            BottomCommonTipLayout bottomCommonTipLayout = this.J;
            if (bottomCommonTipLayout != null && bottomCommonTipLayout.m()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    public final FragmentManager X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            FrsActivity frsActivity = this.b;
            if (frsActivity != null) {
                return frsActivity.getSupportFragmentManager();
            }
            return null;
        }
        return (FragmentManager) invokeV.objValue;
    }

    public FrsFragment Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.c;
        }
        return (FrsFragment) invokeV.objValue;
    }

    @Nullable
    public xu7 a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.a;
        }
        return (xu7) invokeV.objValue;
    }

    public FragmentTabHost b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            FrsTabHostFragment frsTabHostFragment = this.d;
            if (frsTabHostFragment == null) {
                return null;
            }
            return frsTabHostFragment.o2();
        }
        return (FragmentTabHost) invokeV.objValue;
    }

    public qea f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.e;
        }
        return (qea) invokeV.objValue;
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.s.setVisibility(8);
        }
    }

    public final void i0() {
        BottomCommonTipLayout bottomCommonTipLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && (bottomCommonTipLayout = this.J) != null) {
            bottomCommonTipLayout.l();
        }
    }

    public boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.I;
        }
        return invokeV.booleanValue;
    }

    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            qea qeaVar = this.e;
            if (qeaVar != null && qeaVar.getForum() != null && this.e.getForum().isLike() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return X().findFragmentById(R.id.obfuscated_res_0x7f090c9b) instanceof FrsTabHostFragment;
        }
        return invokeV.booleanValue;
    }

    public final FrsTabHostFragment t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            if (this.d == null) {
                FrsTabHostFragment frsTabHostFragment = new FrsTabHostFragment(this);
                this.d = frsTabHostFragment;
                frsTabHostFragment.setBaseTag(r0);
                this.d.E2(this.k);
            }
            return this.d;
        }
        return (FrsTabHostFragment) invokeV.objValue;
    }

    public no7(FrsActivity frsActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = false;
        this.h = new Handler();
        this.k = 0;
        this.o = false;
        this.y = false;
        this.B = true;
        this.C = true;
        this.G = wo5.a();
        this.I = false;
        this.L = new k(this, CmdConfigHttp.FRS_HTTP_CMD, 301001);
        this.M = new v(this, 2001615);
        this.N = new z(this, 2921342);
        this.O = new a0(this, 2001627);
        this.P = new b0(this, 0);
        this.Q = new c0(this, 2921518);
        this.R = new d0(this, 2921641);
        this.S = new e0(this);
        this.f1148T = new f0(this, 2921788);
        this.U = new a(this, 2921789);
        this.V = new c(this, 2005016);
        this.W = new d(this, 2921369);
        this.X = new e(this, 2921586);
        this.Y = new f(this, 2921590);
        this.Z = new g(this, 2921761);
        this.a0 = new h(this, 2921763);
        this.b0 = new i(this, 2921764);
        this.c0 = new j(this, 2921774);
        this.d0 = new l(this, 2921801);
        this.e0 = new m(this, 2921775);
        this.f0 = new n(this, 2921769);
        this.g0 = new u(this, 2001440);
        this.h0 = new w(this);
        this.i0 = new x(this);
        this.b = frsActivity;
        this.l = SharedPrefHelper.getSharedPrefKeyWithAccount("show_game_forem_tab_hot_point");
    }

    @Override // com.baidu.tieba.h36
    public void I0(int i2, g36 g36Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, g36Var) == null) {
            FrsFragment frsFragment = this.c;
            if (frsFragment instanceof h36) {
                frsFragment.I0(i2, g36Var);
            }
        }
    }

    public void B0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            bundle.putString("name", this.i);
            bundle.putInt("default_tab_id", this.k);
            bundle.putString("from", this.j);
        }
    }

    public void H0(int i2) {
        FragmentContainerView fragmentContainerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i2) == null) && (fragmentContainerView = this.F) != null) {
            fragmentContainerView.setVisibility(i2);
        }
    }

    public void J0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.k = i2;
        }
    }

    public void K0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.m = i2;
        }
    }

    public void T(MotionEvent motionEvent) {
        xo5.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, motionEvent) == null) && (bVar = this.H) != null) {
            bVar.d1(motionEvent);
        }
    }

    @Override // com.baidu.tieba.h36
    public void Y(f36 f36Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, f36Var) == null) {
            FrsFragment frsFragment = this.c;
            if (frsFragment instanceof h36) {
                frsFragment.Y(f36Var);
            }
        }
    }

    @Override // com.baidu.tieba.h36
    public g36 n1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048618, this, i2)) == null) {
            FrsFragment frsFragment = this.c;
            if (frsFragment instanceof h36) {
                return frsFragment.n1(i2);
            }
            return null;
        }
        return (g36) invokeI.objValue;
    }

    public final FrsFragment s0(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, bundle)) == null) {
            if (this.c == null) {
                FrsFragment frsFragment = new FrsFragment();
                this.c = frsFragment;
                frsFragment.setArguments(bundle);
                this.c.setBaseTag(j0);
            }
            FrsFragment frsFragment2 = this.c;
            frsFragment2.M = false;
            return frsFragment2;
        }
        return (FrsFragment) invokeL.objValue;
    }

    public void y0(Intent intent) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048630, this, intent) == null) && (frsFragment = this.c) != null) {
            frsFragment.K4(intent);
        }
    }

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!q0()) {
                this.c.setPrimary(true);
            } else {
                FrsTabHostFragment frsTabHostFragment = this.d;
                if (frsTabHostFragment != null) {
                    Fragment k2 = frsTabHostFragment.k2();
                    if (k2 instanceof BaseFragment) {
                        ((BaseFragment) k2).setPrimary(true);
                    }
                }
            }
            xu7 xu7Var = this.a;
            if (xu7Var != null) {
                xu7Var.q(true);
                if (this.a.k()) {
                    this.a.g(null);
                } else {
                    DefaultLog.getInstance().e("FrsGuide", "frs吧关注引导未展示不满足条件：进入过本吧帖子");
                }
            }
            if (this.o) {
                this.o = false;
                FrsFragment frsFragment = this.c;
                if (frsFragment != null) {
                    frsFragment.refresh();
                }
            }
            ItemCardHelper.w(this.h0);
            MessageManager.getInstance().registerListener(this.g0);
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                lh5.q().w(downloadData);
            }
        }
    }

    public final void P0() {
        qea qeaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (qeaVar = this.e) != null && qeaVar.getEntelechyTabInfo() != null && this.e.getEntelechyTabInfo().a != null) {
            if (this.b.getIntent() != null && FrsActivityConfig.FRS_FROM_ITEM.equals(this.b.getIntent().getStringExtra("from"))) {
                return;
            }
            boolean z2 = false;
            Iterator<FrsTabInfo> it = this.e.getEntelechyTabInfo().a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().tab_type.intValue() == 16) {
                    z2 = true;
                    break;
                }
            }
            if (!z2) {
            }
        }
    }

    public void C0(String str) {
        qea qeaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (qeaVar = this.e) != null && qeaVar.getForum() != null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SCREEN_SHOT).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.e.getForum().getId()).param("obj_type", 2));
        }
    }

    public void M0(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048588, this, i2) != null) || !this.I) {
            return;
        }
        if (i2 == 506) {
            if (this.F.getVisibility() != 8) {
                this.F.setVisibility(8);
            }
        } else if (this.F.getVisibility() != 0) {
            this.F.setVisibility(0);
        }
    }

    public final int c0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i2)) == null) {
            yh7 yh7Var = this.f;
            if (yh7Var == null || i2 >= ListUtils.getCount(yh7Var.f())) {
                return -1;
            }
            return this.f.f().get(i2).tab_id.intValue();
        }
        return invokeI.intValue;
    }

    public final int d0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) {
            yh7 yh7Var = this.f;
            if (yh7Var == null) {
                return -1;
            }
            int count = ListUtils.getCount(yh7Var.f());
            for (int i3 = 0; i3 < count; i3++) {
                if (this.f.f().get(i3).tab_id.intValue() == i2) {
                    return i3;
                }
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public final void k0(String str) {
        vo5 vo5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048614, this, str) == null) && this.H == null) {
            xo5 xo5Var = this.G;
            FrsFragment frsFragment = this.c;
            if (frsFragment != null) {
                vo5Var = frsFragment.O3();
            } else {
                vo5Var = null;
            }
            this.H = xo5Var.b(str, vo5Var);
            ew5.a(this.b.getSupportFragmentManager(), R.id.obfuscated_res_0x7f0906ca, this.H.i());
        }
    }

    public final void l0(Bundle bundle) {
        FragmentManager X;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048615, this, bundle) == null) && (X = X()) != null && !X.isDestroyed()) {
            try {
                FragmentTransaction beginTransaction = X.beginTransaction();
                FrsFragment s0 = s0(bundle);
                s0.t5(this.q);
                s0.v5(this.r);
                s0.u5(this.u);
                beginTransaction.add(R.id.obfuscated_res_0x7f090c9b, s0);
                beginTransaction.commitNowAllowingStateLoss();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void D0(qea qeaVar, boolean z2, int i2) {
        FrsActivity frsActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{qeaVar, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) && qeaVar != null && qeaVar.getForum() != null && (frsActivity = this.b) != null && frsActivity.getPageContext() != null) {
            this.e = qeaVar;
            ev7 ev7Var = this.E;
            if (ev7Var != null) {
                ev7Var.c(qeaVar);
            }
            TbSingleton.getInstance().setFrsResponseData(qeaVar);
            ForumData forum = qeaVar.getForum();
            if (z2 && forum != null && !TextUtils.isEmpty(forum.getId())) {
                FrsVideoTabPlayActivityConfig.addFrsPageCount(forum.getId());
            }
            er7 er7Var = this.D;
            if (er7Var != null) {
                er7Var.a(z2);
                this.D.b();
            }
            R(forum, qeaVar);
            if (forum.getIsShowBawuTask() && SharedPrefHelper.getInstance().getInt("key_bawu_task_toast", 0) == 0 && !this.y) {
                this.y = true;
                SafeHandler.getInst().postDelayed(new p(this), 30000L);
            }
            if (ListUtils.getCount(qeaVar.getGameTabInfo()) > 0) {
                this.h.post(new q(this));
            } else if (q0()) {
                this.h.post(new r(this));
            }
            E0();
            P0();
            if (forum.isLike() == 0 && TbadkCoreApplication.isLogin()) {
                DefaultLog.getInstance().i("FrsGuide", "命中实验，初始化frs吧关注引导");
                xu7 xu7Var = new xu7(this.c, this.e);
                this.a = xu7Var;
                this.b.registerListener(xu7Var.l);
            }
        }
    }

    public void u0(int i2, int i3, Intent intent) {
        String str;
        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048626, this, i2, i3, intent) == null) {
            if (!q0()) {
                this.c.onActivityResult(i2, i3, intent);
            } else {
                FrsTabHostFragment frsTabHostFragment = this.d;
                if (frsTabHostFragment != null) {
                    if (1 == frsTabHostFragment.l2()) {
                        this.c.onActivityResult(i2, i3, intent);
                    } else {
                        Fragment k2 = this.d.k2();
                        if (k2 != null) {
                            k2.onActivityResult(i2, i3, intent);
                        }
                    }
                }
            }
            if (i3 == -1) {
                if (i2 == 24007) {
                    int intExtra = intent.getIntExtra("extra_share_status", 2);
                    int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                    if (intExtra == 1) {
                        RateManager.getInstance().notifyShare(this.b.getPageContext());
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        if (shareItem != null && (str = shareItem.linkUrl) != null && (shareSuccessReplyToServerModel = this.n) != null) {
                            shareSuccessReplyToServerModel.N(str, intExtra2, new y(this));
                        }
                    }
                } else if (i2 == 13011) {
                    RateManager.getInstance().notifyShare(this.b.getPageContext());
                } else if (i2 == 25064) {
                    FrsTabHostFragment frsTabHostFragment2 = this.d;
                    if (frsTabHostFragment2 != null && frsTabHostFragment2.t2() != null) {
                        this.d.t2().c(this.b.getPageContext());
                    } else {
                        FrsFragment frsFragment = this.c;
                        if (frsFragment != null && frsFragment.L1() != null && this.c.L1().c0() != null && this.c.L1().c0().g != null) {
                            this.c.L1().c0().g.c(this.b.getPageContext());
                        }
                    }
                }
            }
            xo5.b bVar = this.H;
            if (bVar != null) {
                bVar.onActivityResult(i2, i3, intent);
            }
        }
    }

    public final void E0() {
        qea qeaVar;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (qeaVar = this.e) != null && (themeColorInfo = qeaVar.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                themeElement = themeColorInfo.dark;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.q.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921571, themeElement));
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.m != this.k && q0()) {
                this.d.D2(this.k);
                if (c0(this.k) != 1) {
                    this.c.Z4(false);
                }
                this.m = this.k;
                L0(this.d.k2(), this.k);
                return;
            }
            this.c.H3();
        }
    }

    public final void S() {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (V() == 506) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && this.F.getVisibility() != 0) {
                this.F.clearAnimation();
                this.F.setAlpha(0.0f);
                this.F.setVisibility(0);
                this.F.animate().alpha(1.0f).setDuration(700L).setStartDelay(300L).setListener(new s(this));
            }
        }
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            if (!q0()) {
                this.c.setPrimary(false);
            } else {
                FrsTabHostFragment frsTabHostFragment = this.d;
                if (frsTabHostFragment != null) {
                    Fragment k2 = frsTabHostFragment.k2();
                    if (k2 instanceof BaseFragment) {
                        ((BaseFragment) k2).setPrimary(false);
                    }
                }
            }
            if (TbSingleton.getInstance().getSchemaForStartOtherAppAfterSwanApp() != null) {
                SafeHandler.getInst().postDelayed(this.i0, 1000L);
            }
            MessageManager.getInstance().unRegisterListener(this.g0);
            xu7 xu7Var = this.a;
            if (xu7Var != null) {
                xu7Var.h();
            }
        }
    }

    public final void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
            tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.b.registerListener(1021074, this.P);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!q0()) {
                return this.c.G0();
            }
            FrsTabHostFragment frsTabHostFragment = this.d;
            if (frsTabHostFragment == null) {
                return null;
            }
            Fragment k2 = frsTabHostFragment.k2();
            if (!(k2 instanceof VoiceManager.i)) {
                return null;
            }
            return ((VoiceManager.i) k2).G0();
        }
        return (VoiceManager) invokeV.objValue;
    }

    public int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            FrsFragment frsFragment = this.c;
            if (frsFragment != null && frsFragment.k4() != null && this.c.k4().B() != null) {
                return this.c.k4().B().a;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public TbPageTag e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (!q0()) {
                return this.c.getTbPageTag();
            }
            FrsTabHostFragment frsTabHostFragment = this.d;
            if (frsTabHostFragment != null) {
                if (1 == frsTabHostFragment.l2()) {
                    return this.c.getTbPageTag();
                }
                Fragment k2 = this.d.k2();
                if (k2 instanceof BaseFragment) {
                    return ((BaseFragment) k2).getTbPageTag();
                }
            }
            return null;
        }
        return (TbPageTag) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public ag<TbImageView> h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            if (!q0()) {
                FrsFragment frsFragment = this.c;
                if (frsFragment instanceof FrsCommonImageLayout.e) {
                    return ((FrsCommonImageLayout.e) frsFragment).h0();
                }
            } else {
                FrsTabHostFragment frsTabHostFragment = this.d;
                if (frsTabHostFragment == null) {
                    return null;
                }
                Fragment k2 = frsTabHostFragment.k2();
                if (k2 instanceof FrsCommonImageLayout.e) {
                    return ((FrsCommonImageLayout.e) k2).h0();
                }
            }
            return null;
        }
        return (ag) invokeV.objValue;
    }

    public final void m0() {
        FragmentManager X;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && (X = X()) != null && !X.isDestroyed()) {
            try {
                FragmentTransaction beginTransaction = X.beginTransaction();
                FrsTabHostFragment t0 = t0();
                t0.H2(this.q);
                t0.G2(this.r);
                beginTransaction.replace(R.id.obfuscated_res_0x7f090c9b, t0);
                beginTransaction.commitNowAllowingStateLoss();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void r0() {
        yh7 yh7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && (yh7Var = this.f) != null && !TextUtils.isEmpty(yh7Var.c())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.e.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void L0(Fragment fragment, int i2) {
        qea qeaVar;
        NavigationBar o2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048587, this, fragment, i2) != null) || !(fragment instanceof hi7) || (qeaVar = this.e) == null || qeaVar.getForum() == null || (o2 = ((hi7) fragment).o()) == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.e.getForum().getName(), 5, true, true) + this.b.getActivity().getString(R.string.obfuscated_res_0x7f0f077c));
        o2.setCenterTextTitle(sb.toString());
    }

    public final void R(ForumData forumData, qea qeaVar) {
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048595, this, forumData, qeaVar) == null) && forumData != null && !StringUtils.isNull(forumData.getId())) {
            String name = forumData.getName();
            if (forumData.isLike() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            long j2 = JavaTypesHelper.toLong(forumData.getId(), 0L);
            if (j2 <= 0) {
                return;
            }
            this.K = j2;
            if (qeaVar != null && qeaVar.getUserData() != null && (qeaVar.getUserData().getIs_manager() == 1 || qeaVar.getUserData().getIs_bawu() == 1)) {
                z3 = true;
            } else {
                z3 = false;
            }
            xo5.b bVar = this.H;
            if (bVar != null) {
                bVar.P1(j2, name, z2, z3);
            }
        }
    }

    public final void N0(MemberBroadcastData memberBroadcastData) {
        String id;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, memberBroadcastData) == null) && this.b != null && memberBroadcastData != null) {
            if (this.J == null) {
                BottomCommonTipLayout bottomCommonTipLayout = new BottomCommonTipLayout(this.b);
                this.J = bottomCommonTipLayout;
                bottomCommonTipLayout.setId(R.id.obfuscated_res_0x7f091726);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds151);
                layoutParams.leftMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
                layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds203);
                layoutParams.gravity = 80;
                this.J.setLayoutParams(layoutParams);
                ViewGroup viewGroup = (ViewGroup) this.b.findViewById(16908290);
                if (viewGroup != null) {
                    viewGroup.addView(this.J);
                }
            }
            qea qeaVar = this.e;
            String str = "";
            if (qeaVar != null && qeaVar.getForum() != null && (id = this.e.getForum().getId()) != null) {
                str = id;
            }
            this.J.p(memberBroadcastData, "frs_vip_brd", 1, str);
        }
    }

    public final boolean Q(List<FrsTabInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, list)) == null) {
            if (this.b.isLoadingViewAttached()) {
                FrsActivity frsActivity = this.b;
                frsActivity.hideLoadingView(frsActivity.findViewById(16908290));
            }
            if (q0()) {
                return false;
            }
            this.c.M = true;
            F0();
            if (SharedPrefHelper.getInstance().getBoolean("frs_game_login_tip", true)) {
                SharedPrefHelper.getInstance().putBoolean("frs_login_tip", true);
                SharedPrefHelper.getInstance().putBoolean("frs_game_login_tip", false);
            }
            n0(list);
            if (this.c.k4() != null) {
                this.c.k4().V(true);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void O0(MemberBroadcastData memberBroadcastData) {
        FrsActivity frsActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, memberBroadcastData) == null) && (frsActivity = this.b) != null && frsActivity.z1()) {
            xu7 xu7Var = this.a;
            if ((xu7Var != null && xu7Var.l()) || YunDialogManager.isShowingDialog()) {
                return;
            }
            if ((this.b.v1() == null || !this.b.v1().b()) && new MemberBroadcastHelper(memberBroadcastData).isMeetFrequency()) {
                xo5.b bVar = this.H;
                if (bVar != null && bVar.getState() == 2) {
                    this.H.g();
                }
                N0(memberBroadcastData);
            }
        }
    }

    public void v0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i2) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.b);
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.b);
            }
            FrsFragment frsFragment = this.c;
            if (frsFragment != null) {
                frsFragment.onChangeSkinType(i2);
            }
            FrsTabHostFragment frsTabHostFragment = this.d;
            if (frsTabHostFragment != null) {
                frsTabHostFragment.onChangeSkinType(i2);
            }
            FrsActivity frsActivity = this.b;
            UtilHelper.setNavigationBarBackground(frsActivity, SkinManager.getColor(i2, frsActivity.getResources(), R.color.CAM_X0201), true);
            E0();
            this.G.onChangeSkinType(i2);
            BottomCommonTipLayout bottomCommonTipLayout = this.J;
            if (bottomCommonTipLayout != null) {
                bottomCommonTipLayout.g();
            }
            xu7 xu7Var = this.a;
            if (xu7Var != null) {
                xu7Var.p();
            }
            SkinManager.setBackgroundResource(this.s, R.color.common_color_10050);
        }
    }

    public void j0(Bundle bundle) {
        FrsActivity frsActivity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048613, this, bundle) != null) || (frsActivity = this.b) == null) {
            return;
        }
        frsActivity.setContentView(R.layout.obfuscated_res_0x7f0d034e);
        FrameLayout frameLayout = (FrameLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090c9b);
        this.p = frameLayout;
        EMManager.from(frameLayout).setBackGroundColor(R.color.CAM_X0201);
        OvalActionButton ovalActionButton = (OvalActionButton) this.b.findViewById(R.id.obfuscated_res_0x7f090d4b);
        this.q = ovalActionButton;
        ovalActionButton.setIsCircle(true);
        this.q.setHasShadow(false);
        View findViewById = this.b.findViewById(R.id.obfuscated_res_0x7f090e97);
        this.s = findViewById;
        findViewById.setOnClickListener(new o(this));
        this.t = (FrameLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090c76);
        this.r = (FRSRefreshButton) this.b.findViewById(R.id.obfuscated_res_0x7f090d68);
        this.u = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090d25);
        this.F = (FragmentContainerView) this.b.findViewById(R.id.obfuscated_res_0x7f0906ca);
        this.b.registerListener(this.W);
        this.L.getHttpMessageListener().setPriority(-1);
        this.L.getSocketMessageListener().setPriority(-1);
        this.b.registerListener(this.M);
        this.O.setSelfListener(true);
        this.b.registerListener(this.O);
        this.N.setSelfListener(true);
        this.b.registerListener(this.N);
        this.b.registerListener(this.V);
        if (bundle == null) {
            this.i = this.b.getIntent().getStringExtra("name");
            this.j = this.b.getIntent().getStringExtra("from");
            this.k = this.b.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
        } else {
            this.i = bundle.getString("name");
            this.j = bundle.getString("from");
            this.k = bundle.getInt("default_tab_id", 0);
        }
        l0(bundle);
        k0(this.i);
        this.c.p5(this.H);
        this.D = new er7(this.b, this.c);
        this.n = new ShareSuccessReplyToServerModel();
        this.E = new ev7(this.b);
        this.b.registerListener(this.L);
        this.b.registerListener(this.E.c);
        this.b.registerListener(this.E.d);
        this.b.registerListener(this.Q);
        this.b.registerListener(this.X);
        this.b.registerListener(this.R);
        this.b.registerListener(this.Z);
        this.a0.setTag(this.b.getUniqueId());
        this.b.registerListener(this.a0);
        this.b.registerListener(this.b0);
        this.Y.setPriority(Integer.MAX_VALUE);
        this.Y.setSelfListener(true);
        this.b.registerListener(this.Y);
        this.b.registerListener(this.c0);
        this.b.registerListener(this.d0);
        this.b.registerListener(this.e0);
        this.b.registerListener(this.f0);
        this.b.registerListener(this.f1148T);
        this.b.registerListener(this.U);
    }

    public final void n0(List<FrsTabInfo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048617, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        m0();
        t tVar = new t(this, 2001616);
        tVar.setPriority(Integer.MAX_VALUE);
        tVar.setSelfListener(true);
        this.b.registerListener(tVar);
        ArrayList arrayList = new ArrayList();
        Iterator<FrsTabInfo> it = list.iterator();
        while (true) {
            boolean z2 = false;
            if (!it.hasNext()) {
                break;
            }
            FrsTabInfo next = it.next();
            if (next != null) {
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    FrsTabInfo frsTabInfo = (FrsTabInfo) it2.next();
                    if (frsTabInfo != null && frsTabInfo.tab_id == next.tab_id) {
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    arrayList.add(next);
                }
            }
        }
        this.f = new yh7(this.b.getActivity(), arrayList);
        if (Z() != null) {
            this.f.j(Z().w());
            this.f.k(Z().v());
            if (Z().l1() != null && Z().l1().getForum() != null) {
                ForumData forum = Z().l1().getForum();
                this.f.i(forum.getForumGameLabel());
                this.f.l(forum.getSpecialForumType());
            }
        }
        FrsFragment frsFragment = this.c;
        frsFragment.M = false;
        new po7(frsFragment).a(this.f);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001616, this.f);
        CustomMessage customMessage = new CustomMessage(2001616);
        customMessage.setTag(this.b.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public void w0() {
        xu7 xu7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            MessageManager.getInstance().unRegisterListener(FrsNoListItemViewHolder.i);
            MessageManager.getInstance().unRegisterListener(this.Z);
            MessageManager.getInstance().unRegisterListener(this.a0);
            MessageManager.getInstance().unRegisterListener(this.b0);
            MessageManager.getInstance().unRegisterListener(this.c0);
            MessageManager.getInstance().unRegisterListener(this.e0);
            MessageManager.getInstance().unRegisterListener(this.f0);
            MessageManager.getInstance().unRegisterListener(this.f1148T);
            MessageManager.getInstance().unRegisterListener(this.U);
            this.h.removeCallbacksAndMessages(null);
            if (this.b.isLoadingViewAttached()) {
                FrsActivity frsActivity = this.b;
                frsActivity.hideLoadingView(frsActivity.findViewById(16908290));
            }
            if (this.S != null) {
                SafeHandler.getInst().removeCallbacks(this.S);
            }
            qea qeaVar = this.e;
            if (qeaVar != null && qeaVar.getForum() != null && (xu7Var = this.a) != null) {
                xu7Var.e(JavaTypesHelper.toLong(this.e.getForum().getId(), 0L));
            }
            SharedPrefHelper.getInstance().putBoolean(this.l, false);
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.n;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            FrsFragment frsFragment = this.c;
            if (frsFragment != null && frsFragment.e1() != null) {
                this.c.e1().U0();
            }
            NavigationBarCoverTip navigationBarCoverTip = this.x;
            if (navigationBarCoverTip != null) {
                navigationBarCoverTip.f();
            }
            if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(this.j)) {
                new ForumBroadcastHelper(TbadkCoreApplication.getInst()).sendClipBoardMessage();
            }
            if (FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(this.j)) {
                xk5.h().i(false);
            }
            SafeHandler.getInst().removeCallbacks(this.i0);
            ItemCardHelper.w(null);
            xo5.b bVar = this.H;
            if (bVar != null) {
                bVar.destroy();
            }
            this.G.a(null);
            xu7 xu7Var2 = this.a;
            if (xu7Var2 != null) {
                xu7Var2.f();
            }
        }
    }

    public boolean x0(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        FrsTabHostFragment frsTabHostFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048629, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                if (this.z) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921587));
                    return false;
                } else if (this.A) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921642));
                    return true;
                } else if (q0() && (frsTabHostFragment = this.d) != null && frsTabHostFragment.w2()) {
                    this.d.v2();
                    UtilHelper.setNavigationBarBackground(this.b, this.d.j2());
                    return false;
                } else {
                    FrsFragment frsFragment = this.c;
                    if (frsFragment != null && frsFragment.isAdded()) {
                        if (this.c.onKeyDown(i2, keyEvent)) {
                            return true;
                        }
                        P();
                        return false;
                    }
                    return this.b.B1(i2, keyEvent);
                }
            } else if (i2 == 24) {
                FrsFragment frsFragment2 = this.c;
                if (frsFragment2 != null && frsFragment2.isAdded()) {
                    return this.c.onKeyDown(i2, keyEvent);
                }
                return false;
            } else {
                return this.b.B1(i2, keyEvent);
            }
        }
        return invokeIL.booleanValue;
    }
}
