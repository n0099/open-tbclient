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
import com.baidu.tieba.dm5;
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
/* loaded from: classes9.dex */
public class zz7 implements t06, VoiceManager.j, FrsCommonImageLayout.e {
    public static /* synthetic */ Interceptable $ic;
    public static final String i0;
    public static final String j0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public u68 D;
    public FragmentContainerView E;
    @NonNull
    public final dm5 F;
    @Nullable
    public dm5.b G;
    public boolean H;
    public BottomCommonTipLayout I;
    public long J;
    public NetMessageListener K;
    public CustomMessageListener L;
    public CustomMessageListener M;
    public CustomMessageListener N;
    public HttpMessageListener O;
    public CustomMessageListener P;
    public CustomMessageListener Q;
    public Runnable R;
    public final CustomMessageListener S;

    /* renamed from: T  reason: collision with root package name */
    public final CustomMessageListener f1181T;
    public CustomMessageListener U;
    public CustomMessageListener V;
    public CustomMessageListener W;
    public CustomMessageListener X;
    public CustomMessageListener Y;
    public final CustomMessageListener Z;
    public n68 a;
    public CustomMessageListener a0;
    public FrsActivity b;
    public CustomMessageListener b0;
    public FrsFragment c;
    public CustomMessageListener c0;
    public FrsTabHostFragment d;
    public CustomMessageListener d0;
    public dva e;
    public final CustomMessageListener e0;
    public gt7 f;
    public CustomMessageListener f0;
    public boolean g;
    public final ItemCardHelper.c g0;
    public final Handler h;
    public Runnable h0;
    public String i;
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

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.IPlayView V1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    /* loaded from: classes9.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz7 a;

        /* loaded from: classes9.dex */
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
        public t(zz7 zz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var, Integer.valueOf(i)};
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
            this.a = zz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof gt7)) {
                if (!SharedPrefHelper.getInstance().getBoolean(this.a.l, true)) {
                    SafeHandler.getInst().post(this.a.R);
                }
                ((gt7) customResponsedMessage.getData()).a(new a(this));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class y implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz7 a;

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        /* loaded from: classes9.dex */
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
                    wx9.a(this.b.a.b.getPageContext(), this.a).show();
                }
            }
        }

        public y(zz7 zz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zz7Var;
        }

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void b(CustomDialogData customDialogData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customDialogData) == null) {
                SafeHandler.getInst().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(zz7 zz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var, Integer.valueOf(i)};
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
            this.a = zz7Var;
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

    /* loaded from: classes9.dex */
    public class a0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a0(zz7 zz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var, Integer.valueOf(i)};
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
            this.a = zz7Var;
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
                if (d0 != -1 && this.a.r0() && this.a.d != null) {
                    this.a.d.p3(d0);
                    if (this.a.c0(d0) != 1) {
                        this.a.c.K5(false);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz7 a;

        public b(zz7 zz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zz7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.s != null) {
                this.a.s.setVisibility(0);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b0 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b0(zz7 zz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var, Integer.valueOf(i)};
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
            this.a = zz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<uz7> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (ListUtils.isEmpty(newNotifyData) || this.a.d == null) {
                    return;
                }
                for (uz7 uz7Var : newNotifyData) {
                    if (uz7Var != null) {
                        for (int i2 = 0; i2 < this.a.f.g().size(); i2++) {
                            FragmentTabHost.c e3 = this.a.d.e3(i2);
                            if (e3 != null && (i = e3.a) != 1 && i != this.a.d.X2() && e3.a == uz7Var.a() && uz7Var.b() && e3.b.getTip(String.valueOf(e3.a)) != null) {
                                e3.b.getTip(String.valueOf(e3.a)).f1079view.setVisibility(0);
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(zz7 zz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var, Integer.valueOf(i)};
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
            this.a = zz7Var;
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

    /* loaded from: classes9.dex */
    public class c0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c0(zz7 zz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var, Integer.valueOf(i)};
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
            this.a = zz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                new BdTopToast(this.a.b, 2000).setIcon(false).setContent(this.a.b.getString(R.string.frs_top_forum_rules_click_toast)).show((ViewGroup) this.a.b.findViewById(R.id.obfuscated_res_0x7f090caf));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(zz7 zz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var, Integer.valueOf(i)};
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
            this.a = zz7Var;
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

    /* loaded from: classes9.dex */
    public class d0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d0(zz7 zz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var, Integer.valueOf(i)};
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
            this.a = zz7Var;
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

    /* loaded from: classes9.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(zz7 zz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var, Integer.valueOf(i)};
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
            this.a = zz7Var;
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

    /* loaded from: classes9.dex */
    public class e0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz7 a;

        public e0(zz7 zz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zz7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SafeHandler.getInst().removeCallbacks(this);
                this.a.s0();
                SafeHandler.getInst().postDelayed(this, 30000L);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(zz7 zz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var, Integer.valueOf(i)};
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
            this.a = zz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            if ((customResponsedMessage.getData() instanceof h58) && ((h58) customResponsedMessage.getData()).a != null) {
                View view2 = ((h58) customResponsedMessage.getData()).a;
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

    /* loaded from: classes9.dex */
    public class f0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f0(zz7 zz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var, Integer.valueOf(i)};
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
            this.a = zz7Var;
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

    /* loaded from: classes9.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(zz7 zz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var, Integer.valueOf(i)};
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
            this.a = zz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                Integer num = (Integer) customResponsedMessage.getData();
                if (this.a.c != null && this.a.G != null && this.a.c.V4() != null && this.a.c.V4().B() != null && (this.a.c.V4().B().b instanceof BaseFragment)) {
                    if (num.intValue() == 2 && this.a.G.getState() == 2) {
                        this.a.G.j();
                    } else if (num.intValue() == 0 && this.a.G.getState() == 1) {
                        if (this.a.b == null || this.a.b.p1() == null || !this.a.b.p1().b()) {
                            if ((this.a.a == null || !this.a.a.k()) && !this.a.q0() && !this.a.p0() && !this.a.G.p0()) {
                                if (sb5.j()) {
                                    sb5.h();
                                }
                                this.a.G.E1();
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(zz7 zz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var, Integer.valueOf(i)};
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
            this.a = zz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ChatRoomInfoData chatRoomInfoData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && !customResponsedMessage.hasError() && (customResponsedMessage.getData() instanceof ChatEntranceLoopData)) {
                ChatEntranceLoopData chatEntranceLoopData = (ChatEntranceLoopData) customResponsedMessage.getData();
                ChatRoomEntranceData entranceData = chatEntranceLoopData.getEntranceData();
                if (this.a.G != null && this.a.G.r2(chatEntranceLoopData.getUniqueId())) {
                    long j = 0;
                    if (this.a.J == 0 && entranceData != null && !ListUtils.isEmpty(entranceData.getChatRoomInfoList()) && (chatRoomInfoData = entranceData.getChatRoomInfoList().get(0)) != null) {
                        zz7 zz7Var = this.a;
                        if (chatRoomInfoData.getChatroomInfoBasicData() != null) {
                            j = chatRoomInfoData.getChatroomInfoBasicData().getForumId();
                        }
                        zz7Var.J = j;
                    }
                    if (entranceData == null || entranceData.getHotListOriginNum() <= 0) {
                        if (!this.a.H && this.a.E.getVisibility() != 8) {
                            this.a.E.setVisibility(8);
                        }
                    } else {
                        this.a.H = true;
                        this.a.U();
                    }
                    if (this.a.C && this.a.H && this.a.a0() != null) {
                        this.a.a0().L5(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003025));
                        this.a.C = false;
                    }
                    this.a.G.a0(entranceData);
                    this.a.G.l1(this.a.C);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(zz7 zz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var, Integer.valueOf(i)};
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
            this.a = zz7Var;
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

    /* loaded from: classes9.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(zz7 zz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var, Integer.valueOf(i)};
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
            this.a = zz7Var;
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

    /* loaded from: classes9.dex */
    public class k extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(zz7 zz7Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = zz7Var;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            dva dvaVar;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && !this.a.g && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    FrsPageHttpResponseMessage frsPageHttpResponseMessage = (FrsPageHttpResponseMessage) responsedMessage;
                    dvaVar = frsPageHttpResponseMessage.getResponseData();
                    i = frsPageHttpResponseMessage.getUpdateType();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    FRSPageSocketResponsedMessage fRSPageSocketResponsedMessage = (FRSPageSocketResponsedMessage) responsedMessage;
                    dvaVar = fRSPageSocketResponsedMessage.getResponseData();
                    i = fRSPageSocketResponsedMessage.getUpdateType();
                } else {
                    dvaVar = null;
                    i = -1;
                }
                if (dvaVar == null) {
                    return;
                }
                this.a.g = true;
                this.a.F0(dvaVar, true, i);
                if (dvaVar != null && dvaVar.getForum() != null && !StringUtils.isNull(dvaVar.getForum().getId())) {
                    aw4.b().l("2", dvaVar.getForum().getId());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(zz7 zz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var, Integer.valueOf(i)};
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
            this.a = zz7Var;
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

    /* loaded from: classes9.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(zz7 zz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var, Integer.valueOf(i)};
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
            this.a = zz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean) || !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            this.a.h0();
        }
    }

    /* loaded from: classes9.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(zz7 zz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var, Integer.valueOf(i)};
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
            this.a = zz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.hasError()) {
                return;
            }
            this.a.h0();
        }
    }

    /* loaded from: classes9.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz7 a;

        public o(zz7 zz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.G != null) {
                this.a.s.setVisibility(8);
                this.a.G.n2();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz7 a;

        public p(zz7 zz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zz7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.x == null) {
                    zz7 zz7Var = this.a;
                    zz7Var.x = (NavigationBarCoverTip) zz7Var.b.findViewById(R.id.obfuscated_res_0x7f0919ec);
                }
                f68.b(this.a.x, this.a.c, this.a.i);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz7 a;

        public q(zz7 zz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zz7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                zz7 zz7Var = this.a;
                boolean S = zz7Var.S(zz7Var.e.getGameTabInfo());
                if (S && S && this.a.d != null) {
                    this.a.d.r3(this.a.c);
                    this.a.d.o3(this.a.e, this.a.f);
                }
                if (this.a.b.isLoadingViewAttached()) {
                    this.a.b.hideLoadingView(this.a.b.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz7 a;

        public r(zz7 zz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zz7Var;
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
                this.a.k0(bundle);
                if (this.a.b.isLoadingViewAttached()) {
                    this.a.b.hideLoadingView(this.a.b.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class s extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz7 a;

        public s(zz7 zz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zz7Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                if (this.a.X() == 506) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.a.E.clearAnimation();
                    this.a.E.setAlpha(0.0f);
                    this.a.E.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class u extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(zz7 zz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var, Integer.valueOf(i)};
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
            this.a = zz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof View)) {
                return;
            }
            ItemCardHelper.l(this.a.b, this.a.b.getUniqueId(), (View) customResponsedMessage.getData(), (ViewGroup) this.a.b.findViewById(R.id.obfuscated_res_0x7f090caf));
        }
    }

    /* loaded from: classes9.dex */
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(zz7 zz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var, Integer.valueOf(i)};
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
            this.a = zz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && !this.a.g && this.a.e == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof dva)) {
                dva dvaVar = (dva) customResponsedMessage.getData();
                if (dvaVar.getForum() == null || this.a.i == null || !this.a.i.equals(dvaVar.getForum().getName())) {
                    return;
                }
                this.a.F0(dvaVar, false, -1);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class w implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz7 a;

        public w(zz7 zz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zz7Var;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                ItemCardHelper.y(this.a.b, ItemCardHelper.OrderTipStatus.FAIL, (ViewGroup) this.a.b.findViewById(R.id.obfuscated_res_0x7f090caf), 0L);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                ItemCardHelper.y(this.a.b, ItemCardHelper.OrderTipStatus.SUCCESS, (ViewGroup) this.a.b.findViewById(R.id.obfuscated_res_0x7f090caf), j);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class x implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz7 a;

        public x(zz7 zz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zz7Var;
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

    /* loaded from: classes9.dex */
    public class z extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(zz7 zz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz7Var, Integer.valueOf(i)};
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
            this.a = zz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.R();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948377330, "Lcom/baidu/tieba/zz7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948377330, "Lcom/baidu/tieba/zz7;");
                return;
            }
        }
        i0 = FrsFragment.class.getSimpleName();
        j0 = FrsTabHostFragment.class.getSimpleName();
    }

    public final void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            SafeHandler.getInst().postDelayed(new b(this), 700L);
        }
    }

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            BottomCommonTipLayout bottomCommonTipLayout = this.I;
            if (bottomCommonTipLayout != null && bottomCommonTipLayout.m()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    public final FragmentManager Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            FrsActivity frsActivity = this.b;
            if (frsActivity != null) {
                return frsActivity.getSupportFragmentManager();
            }
            return null;
        }
        return (FragmentManager) invokeV.objValue;
    }

    public FrsFragment a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.c;
        }
        return (FrsFragment) invokeV.objValue;
    }

    public FragmentTabHost b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            FrsTabHostFragment frsTabHostFragment = this.d;
            if (frsTabHostFragment == null) {
                return null;
            }
            return frsTabHostFragment.a3();
        }
        return (FragmentTabHost) invokeV.objValue;
    }

    public dva f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.e;
        }
        return (dva) invokeV.objValue;
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.s.setVisibility(8);
        }
    }

    public final void h0() {
        BottomCommonTipLayout bottomCommonTipLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && (bottomCommonTipLayout = this.I) != null) {
            bottomCommonTipLayout.l();
        }
    }

    public boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.H;
        }
        return invokeV.booleanValue;
    }

    public final boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921826, Boolean.class);
            if (runTask != null) {
                return Boolean.TRUE.equals(runTask.getData());
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921828, Boolean.class);
            if (runTask != null) {
                return Boolean.TRUE.equals(runTask.getData());
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return Z().findFragmentById(R.id.obfuscated_res_0x7f090cfb) instanceof FrsTabHostFragment;
        }
        return invokeV.booleanValue;
    }

    public final FrsTabHostFragment u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            if (this.d == null) {
                FrsTabHostFragment frsTabHostFragment = new FrsTabHostFragment(this);
                this.d = frsTabHostFragment;
                frsTabHostFragment.setBaseTag(j0);
                this.d.q3(this.k);
            }
            return this.d;
        }
        return (FrsTabHostFragment) invokeV.objValue;
    }

    public zz7(FrsActivity frsActivity) {
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
        this.F = cm5.a();
        this.H = false;
        this.K = new k(this, CmdConfigHttp.FRS_HTTP_CMD, 301001);
        this.L = new v(this, 2001615);
        this.M = new z(this, 2921342);
        this.N = new a0(this, 2001627);
        this.O = new b0(this, 0);
        this.P = new c0(this, 2921518);
        this.Q = new d0(this, 2921641);
        this.R = new e0(this);
        this.S = new f0(this, 2921788);
        this.f1181T = new a(this, 2921789);
        this.U = new c(this, 2005016);
        this.V = new d(this, 2921369);
        this.W = new e(this, 2921586);
        this.X = new f(this, 2921590);
        this.Y = new g(this, 2921761);
        this.Z = new h(this, 2921763);
        this.a0 = new i(this, 2921764);
        this.b0 = new j(this, 2921774);
        this.c0 = new l(this, 2921801);
        this.d0 = new m(this, 2921775);
        this.e0 = new n(this, 2921769);
        this.f0 = new u(this, 2001440);
        this.g0 = new w(this);
        this.h0 = new x(this);
        this.b = frsActivity;
        this.l = SharedPrefHelper.getSharedPrefKeyWithAccount("show_game_forem_tab_hot_point");
    }

    public void A0(Intent intent) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, intent) == null) && (frsFragment = this.c) != null) {
            frsFragment.u5(intent);
        }
    }

    public void D0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            bundle.putString("name", this.i);
            bundle.putInt("default_tab_id", this.k);
            bundle.putString("from", this.j);
        }
    }

    public void I0(int i2) {
        FragmentContainerView fragmentContainerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) && (fragmentContainerView = this.E) != null) {
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

    @Override // com.baidu.tieba.t06
    public s06 T1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
            FrsFragment frsFragment = this.c;
            if (frsFragment instanceof t06) {
                return frsFragment.T1(i2);
            }
            return null;
        }
        return (s06) invokeI.objValue;
    }

    public void V(MotionEvent motionEvent) {
        dm5.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, motionEvent) == null) && (bVar = this.G) != null) {
            bVar.G1(motionEvent);
        }
    }

    @Override // com.baidu.tieba.t06
    public void o0(r06 r06Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, r06Var) == null) {
            FrsFragment frsFragment = this.c;
            if (frsFragment instanceof t06) {
                frsFragment.o0(r06Var);
            }
        }
    }

    public final FrsFragment t0(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, bundle)) == null) {
            if (this.c == null) {
                FrsFragment frsFragment = new FrsFragment();
                this.c = frsFragment;
                frsFragment.setArguments(bundle);
                this.c.setBaseTag(i0);
            }
            FrsFragment frsFragment2 = this.c;
            frsFragment2.M = false;
            return frsFragment2;
        }
        return (FrsFragment) invokeL.objValue;
    }

    @Override // com.baidu.tieba.t06
    public void f1(int i2, s06 s06Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048611, this, i2, s06Var) == null) {
            FrsFragment frsFragment = this.c;
            if (frsFragment instanceof t06) {
                frsFragment.f1(i2, s06Var);
            }
        }
    }

    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!r0()) {
                this.c.setPrimary(false);
            } else {
                FrsTabHostFragment frsTabHostFragment = this.d;
                if (frsTabHostFragment != null) {
                    Fragment W2 = frsTabHostFragment.W2();
                    if (W2 instanceof BaseFragment) {
                        ((BaseFragment) W2).setPrimary(false);
                    }
                }
            }
            if (TbSingleton.getInstance().getSchemaForStartOtherAppAfterSwanApp() != null) {
                SafeHandler.getInst().postDelayed(this.h0, 1000L);
            }
            MessageManager.getInstance().unRegisterListener(this.f0);
            n68 n68Var = this.a;
            if (n68Var != null) {
                n68Var.h();
            }
        }
    }

    public final void G0() {
        dva dvaVar;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (dvaVar = this.e) != null && (themeColorInfo = dvaVar.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                themeElement = themeColorInfo.dark;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.q.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921571, themeElement));
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.m != this.k && r0()) {
                this.d.p3(this.k);
                if (c0(this.k) != 1) {
                    this.c.K5(false);
                }
                this.m = this.k;
                L0(this.d.W2(), this.k);
                return;
            }
            this.c.t4();
        }
    }

    public final void U() {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (X() == 506) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && this.E.getVisibility() != 0) {
                this.E.clearAnimation();
                this.E.setAlpha(0.0f);
                this.E.setVisibility(0);
                this.E.animate().alpha(1.0f).setDuration(700L).setStartDelay(300L).setListener(new s(this));
            }
        }
    }

    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!r0()) {
                this.c.setPrimary(true);
            } else {
                FrsTabHostFragment frsTabHostFragment = this.d;
                if (frsTabHostFragment != null) {
                    Fragment W2 = frsTabHostFragment.W2();
                    if (W2 instanceof BaseFragment) {
                        ((BaseFragment) W2).setPrimary(true);
                    }
                }
            }
            n68 n68Var = this.a;
            if (n68Var != null) {
                n68Var.n(true);
                if (this.a.j()) {
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
            ItemCardHelper.w(this.g0);
            MessageManager.getInstance().registerListener(this.f0);
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                td5.q().w(downloadData);
            }
        }
    }

    public final void P0() {
        dva dvaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (dvaVar = this.e) != null && dvaVar.getEntelechyTabInfo() != null && this.e.getEntelechyTabInfo().a != null) {
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

    public void E0(String str) {
        dva dvaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (dvaVar = this.e) != null && dvaVar.getForum() != null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SCREEN_SHOT).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.e.getForum().getId()).param("obj_type", 2));
        }
    }

    public void M0(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048588, this, i2) != null) || !this.H) {
            return;
        }
        if (i2 == 506) {
            if (this.E.getVisibility() != 8) {
                this.E.setVisibility(8);
            }
        } else if (this.E.getVisibility() != 0) {
            this.E.setVisibility(0);
        }
    }

    public final int c0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i2)) == null) {
            gt7 gt7Var = this.f;
            if (gt7Var == null || i2 >= ListUtils.getCount(gt7Var.g())) {
                return -1;
            }
            return this.f.g().get(i2).tab_id.intValue();
        }
        return invokeI.intValue;
    }

    public final int d0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) {
            gt7 gt7Var = this.f;
            if (gt7Var == null) {
                return -1;
            }
            int count = ListUtils.getCount(gt7Var.g());
            for (int i3 = 0; i3 < count; i3++) {
                if (this.f.g().get(i3).tab_id.intValue() == i2) {
                    return i3;
                }
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public final void j0(String str) {
        bm5 bm5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048615, this, str) == null) && this.G == null) {
            dm5 dm5Var = this.F;
            FrsFragment frsFragment = this.c;
            if (frsFragment != null) {
                bm5Var = frsFragment.A4();
            } else {
                bm5Var = null;
            }
            this.G = dm5Var.b(str, bm5Var);
            qt5.a(this.b.getSupportFragmentManager(), R.id.obfuscated_res_0x7f09070d, this.G.n());
        }
    }

    public final void k0(Bundle bundle) {
        FragmentManager Z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048616, this, bundle) == null) && (Z = Z()) != null && !Z.isDestroyed()) {
            try {
                FragmentTransaction beginTransaction = Z.beginTransaction();
                FrsFragment t0 = t0(bundle);
                t0.b6(this.q);
                t0.d6(this.r);
                t0.c6(this.u);
                beginTransaction.add(R.id.obfuscated_res_0x7f090cfb, t0);
                beginTransaction.commitNowAllowingStateLoss();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void F0(dva dvaVar, boolean z2, int i2) {
        FrsActivity frsActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{dvaVar, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) && dvaVar != null && dvaVar.getForum() != null && (frsActivity = this.b) != null && frsActivity.getPageContext() != null) {
            this.e = dvaVar;
            u68 u68Var = this.D;
            if (u68Var != null) {
                u68Var.c(dvaVar);
            }
            TbSingleton.getInstance().setFrsResponseData(dvaVar);
            ForumData forum = dvaVar.getForum();
            if (z2 && forum != null && !TextUtils.isEmpty(forum.getId())) {
                FrsVideoTabPlayActivityConfig.addFrsPageCount(forum.getId());
            }
            T(forum, dvaVar);
            if (forum.getIsShowBawuTask() && SharedPrefHelper.getInstance().getInt("key_bawu_task_toast", 0) == 0 && !this.y) {
                this.y = true;
                SafeHandler.getInst().postDelayed(new p(this), 30000L);
            }
            if (ListUtils.getCount(dvaVar.getGameTabInfo()) > 0) {
                this.h.post(new q(this));
            } else if (r0()) {
                this.h.post(new r(this));
            }
            G0();
            P0();
            if (forum.isLike() == 0 && TbadkCoreApplication.isLogin()) {
                DefaultLog.getInstance().i("FrsGuide", "命中实验，初始化frs吧关注引导");
                n68 n68Var = new n68(this.c, this.e);
                this.a = n68Var;
                this.b.registerListener(n68Var.j);
            }
        }
    }

    public void v0(int i2, int i3, Intent intent) {
        String str;
        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048627, this, i2, i3, intent) == null) {
            if (!r0()) {
                this.c.onActivityResult(i2, i3, intent);
            } else {
                FrsTabHostFragment frsTabHostFragment = this.d;
                if (frsTabHostFragment != null) {
                    if (1 == frsTabHostFragment.X2()) {
                        this.c.onActivityResult(i2, i3, intent);
                    } else {
                        Fragment W2 = this.d.W2();
                        if (W2 != null) {
                            W2.onActivityResult(i2, i3, intent);
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
                            shareSuccessReplyToServerModel.O(str, intExtra2, new y(this));
                        }
                    }
                } else if (i2 == 13011) {
                    RateManager.getInstance().notifyShare(this.b.getPageContext());
                } else if (i2 == 25064) {
                    FrsTabHostFragment frsTabHostFragment2 = this.d;
                    if (frsTabHostFragment2 != null && frsTabHostFragment2.f3() != null) {
                        this.d.f3().c(this.b.getPageContext());
                    } else {
                        FrsFragment frsFragment = this.c;
                        if (frsFragment != null && frsFragment.u2() != null && this.c.u2().c0() != null && this.c.u2().c0().g != null) {
                            this.c.u2().c0().g.c(this.b.getPageContext());
                        }
                    }
                }
            }
            dm5.b bVar = this.G;
            if (bVar != null) {
                bVar.onActivityResult(i2, i3, intent);
            }
        }
    }

    public final void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
            tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.b.registerListener(1021074, this.O);
        }
    }

    public int X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            FrsFragment frsFragment = this.c;
            if (frsFragment != null && frsFragment.V4() != null && this.c.V4().B() != null) {
                return this.c.V4().B().a;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (!r0()) {
                return this.c.d1();
            }
            FrsTabHostFragment frsTabHostFragment = this.d;
            if (frsTabHostFragment == null) {
                return null;
            }
            Fragment W2 = frsTabHostFragment.W2();
            if (!(W2 instanceof VoiceManager.j)) {
                return null;
            }
            return ((VoiceManager.j) W2).d1();
        }
        return (VoiceManager) invokeV.objValue;
    }

    public TbPageTag e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (!r0()) {
                return this.c.getTbPageTag();
            }
            FrsTabHostFragment frsTabHostFragment = this.d;
            if (frsTabHostFragment != null) {
                if (1 == frsTabHostFragment.X2()) {
                    return this.c.getTbPageTag();
                }
                Fragment W2 = this.d.W2();
                if (W2 instanceof BaseFragment) {
                    return ((BaseFragment) W2).getTbPageTag();
                }
            }
            return null;
        }
        return (TbPageTag) invokeV.objValue;
    }

    public final void l0() {
        FragmentManager Z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && (Z = Z()) != null && !Z.isDestroyed()) {
            try {
                FragmentTransaction beginTransaction = Z.beginTransaction();
                FrsTabHostFragment u0 = u0();
                u0.t3(this.q);
                u0.s3(this.r);
                beginTransaction.replace(R.id.obfuscated_res_0x7f090cfb, u0);
                beginTransaction.commitNowAllowingStateLoss();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void s0() {
        gt7 gt7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048624, this) == null) && (gt7Var = this.f) != null && !TextUtils.isEmpty(gt7Var.d())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.e.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public pb<TbImageView> y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            if (!r0()) {
                FrsFragment frsFragment = this.c;
                if (frsFragment instanceof FrsCommonImageLayout.e) {
                    return ((FrsCommonImageLayout.e) frsFragment).y0();
                }
            } else {
                FrsTabHostFragment frsTabHostFragment = this.d;
                if (frsTabHostFragment == null) {
                    return null;
                }
                Fragment W2 = frsTabHostFragment.W2();
                if (W2 instanceof FrsCommonImageLayout.e) {
                    return ((FrsCommonImageLayout.e) W2).y0();
                }
            }
            return null;
        }
        return (pb) invokeV.objValue;
    }

    public final void L0(Fragment fragment, int i2) {
        dva dvaVar;
        NavigationBar x2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048587, this, fragment, i2) != null) || !(fragment instanceof pt7) || (dvaVar = this.e) == null || dvaVar.getForum() == null || (x2 = ((pt7) fragment).x()) == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.e.getForum().getName(), 5, true, true) + this.b.getActivity().getString(R.string.obfuscated_res_0x7f0f078f));
        x2.setCenterTextTitle(sb.toString());
    }

    public final void T(ForumData forumData, dva dvaVar) {
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048595, this, forumData, dvaVar) == null) && forumData != null && !StringUtils.isNull(forumData.getId())) {
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
            this.J = j2;
            if (dvaVar != null && dvaVar.getUserData() != null && (dvaVar.getUserData().getIs_manager() == 1 || dvaVar.getUserData().getIs_bawu() == 1)) {
                z3 = true;
            } else {
                z3 = false;
            }
            dm5.b bVar = this.G;
            if (bVar != null) {
                bVar.B2(j2, name, z2, z3);
            }
        }
    }

    public final void N0(MemberBroadcastData memberBroadcastData) {
        String id;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, memberBroadcastData) == null) && this.b != null && memberBroadcastData != null) {
            if (this.I == null) {
                BottomCommonTipLayout bottomCommonTipLayout = new BottomCommonTipLayout(this.b);
                this.I = bottomCommonTipLayout;
                bottomCommonTipLayout.setId(R.id.member_broadcast_tip_layout);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds151);
                layoutParams.leftMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
                layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds203);
                layoutParams.gravity = 80;
                this.I.setLayoutParams(layoutParams);
                ViewGroup viewGroup = (ViewGroup) this.b.findViewById(16908290);
                if (viewGroup != null) {
                    viewGroup.addView(this.I);
                }
            }
            dva dvaVar = this.e;
            String str = "";
            if (dvaVar != null && dvaVar.getForum() != null && (id = this.e.getForum().getId()) != null) {
                str = id;
            }
            this.I.p(memberBroadcastData, "frs_vip_brd", 1, str);
        }
    }

    public final boolean S(List<FrsTabInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, list)) == null) {
            if (this.b.isLoadingViewAttached()) {
                FrsActivity frsActivity = this.b;
                frsActivity.hideLoadingView(frsActivity.findViewById(16908290));
            }
            if (r0()) {
                return false;
            }
            this.c.M = true;
            H0();
            if (SharedPrefHelper.getInstance().getBoolean("frs_game_login_tip", true)) {
                SharedPrefHelper.getInstance().putBoolean("frs_login_tip", true);
                SharedPrefHelper.getInstance().putBoolean("frs_game_login_tip", false);
            }
            m0(list);
            if (this.c.V4() != null) {
                this.c.V4().V(true);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void O0(MemberBroadcastData memberBroadcastData) {
        FrsActivity frsActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, memberBroadcastData) == null) && (frsActivity = this.b) != null && frsActivity.s1()) {
            n68 n68Var = this.a;
            if ((n68Var != null && n68Var.k()) || YunDialogManager.isShowingDialog()) {
                return;
            }
            if ((this.b.p1() == null || !this.b.p1().b()) && new MemberBroadcastHelper(memberBroadcastData).isMeetFrequency()) {
                dm5.b bVar = this.G;
                if (bVar != null && bVar.getState() == 2) {
                    this.G.j();
                }
                N0(memberBroadcastData);
            }
        }
    }

    public void w0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i2) == null) {
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
            G0();
            this.F.onChangeSkinType(i2);
            BottomCommonTipLayout bottomCommonTipLayout = this.I;
            if (bottomCommonTipLayout != null) {
                bottomCommonTipLayout.g();
            }
            SkinManager.setBackgroundResource(this.s, R.color.common_color_10050);
        }
    }

    public void i0(Bundle bundle) {
        FrsActivity frsActivity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048614, this, bundle) != null) || (frsActivity = this.b) == null) {
            return;
        }
        frsActivity.setContentView(R.layout.obfuscated_res_0x7f0d036c);
        FrameLayout frameLayout = (FrameLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090cfb);
        this.p = frameLayout;
        EMManager.from(frameLayout).setBackGroundColor(R.color.CAM_X0201);
        OvalActionButton ovalActionButton = (OvalActionButton) this.b.findViewById(R.id.obfuscated_res_0x7f090dac);
        this.q = ovalActionButton;
        ovalActionButton.setIsCircle(true);
        this.q.setHasShadow(false);
        View findViewById = this.b.findViewById(R.id.obfuscated_res_0x7f090f01);
        this.s = findViewById;
        findViewById.setOnClickListener(new o(this));
        this.t = (FrameLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090cd1);
        this.r = (FRSRefreshButton) this.b.findViewById(R.id.obfuscated_res_0x7f090dc9);
        this.u = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090d85);
        this.E = (FragmentContainerView) this.b.findViewById(R.id.obfuscated_res_0x7f09070d);
        this.b.registerListener(this.V);
        this.K.getHttpMessageListener().setPriority(-1);
        this.K.getSocketMessageListener().setPriority(-1);
        this.b.registerListener(this.L);
        this.N.setSelfListener(true);
        this.b.registerListener(this.N);
        this.M.setSelfListener(true);
        this.b.registerListener(this.M);
        this.b.registerListener(this.U);
        if (bundle == null) {
            this.i = this.b.getIntent().getStringExtra("name");
            this.j = this.b.getIntent().getStringExtra("from");
            this.k = this.b.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
        } else {
            this.i = bundle.getString("name");
            this.j = bundle.getString("from");
            this.k = bundle.getInt("default_tab_id", 0);
        }
        k0(bundle);
        j0(this.i);
        this.c.X5(this.G);
        this.n = new ShareSuccessReplyToServerModel();
        this.D = new u68(this.b);
        this.b.registerListener(this.K);
        this.b.registerListener(this.D.c);
        this.b.registerListener(this.D.d);
        this.b.registerListener(this.P);
        this.b.registerListener(this.W);
        this.b.registerListener(this.Q);
        this.b.registerListener(this.Y);
        this.Z.setTag(this.b.getUniqueId());
        this.b.registerListener(this.Z);
        this.b.registerListener(this.a0);
        this.X.setPriority(Integer.MAX_VALUE);
        this.X.setSelfListener(true);
        this.b.registerListener(this.X);
        this.b.registerListener(this.b0);
        this.b.registerListener(this.c0);
        this.b.registerListener(this.d0);
        this.b.registerListener(this.e0);
        this.b.registerListener(this.S);
        this.b.registerListener(this.f1181T);
    }

    public final void m0(List<FrsTabInfo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048618, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        l0();
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
        this.f = new gt7(this.b.getActivity(), arrayList);
        if (a0() != null) {
            this.f.k(a0().w());
            this.f.l(a0().v());
            if (a0().Q1() != null && a0().Q1().getForum() != null) {
                ForumData forum = a0().Q1().getForum();
                this.f.j(forum.getForumGameLabel());
                this.f.m(forum.getSpecialForumType());
            }
        }
        FrsFragment frsFragment = this.c;
        frsFragment.M = false;
        new b08(frsFragment).a(this.f);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001616, this.f);
        CustomMessage customMessage = new CustomMessage(2001616);
        customMessage.setTag(this.b.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public void x0() {
        n68 n68Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            MessageManager.getInstance().unRegisterListener(FrsNoListItemViewHolder.i);
            MessageManager.getInstance().unRegisterListener(this.Y);
            MessageManager.getInstance().unRegisterListener(this.Z);
            MessageManager.getInstance().unRegisterListener(this.a0);
            MessageManager.getInstance().unRegisterListener(this.b0);
            MessageManager.getInstance().unRegisterListener(this.d0);
            MessageManager.getInstance().unRegisterListener(this.e0);
            MessageManager.getInstance().unRegisterListener(this.S);
            MessageManager.getInstance().unRegisterListener(this.f1181T);
            this.h.removeCallbacksAndMessages(null);
            if (this.b.isLoadingViewAttached()) {
                FrsActivity frsActivity = this.b;
                frsActivity.hideLoadingView(frsActivity.findViewById(16908290));
            }
            if (this.R != null) {
                SafeHandler.getInst().removeCallbacks(this.R);
            }
            dva dvaVar = this.e;
            if (dvaVar != null && dvaVar.getForum() != null && (n68Var = this.a) != null) {
                n68Var.e(JavaTypesHelper.toLong(this.e.getForum().getId(), 0L));
            }
            SharedPrefHelper.getInstance().putBoolean(this.l, false);
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.n;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            FrsFragment frsFragment = this.c;
            if (frsFragment != null && frsFragment.J1() != null) {
                this.c.J1().V0();
            }
            NavigationBarCoverTip navigationBarCoverTip = this.x;
            if (navigationBarCoverTip != null) {
                navigationBarCoverTip.f();
            }
            if (FrsActivityConfig.FRS_FROM_FLUTTER_BCASTEDIT.equals(this.j)) {
                new ForumBroadcastHelper(TbadkCoreApplication.getInst()).sendClipBoardMessage();
            }
            if (FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT.equals(this.j)) {
                zh5.h().i(false);
            }
            SafeHandler.getInst().removeCallbacks(this.h0);
            ItemCardHelper.w(null);
            dm5.b bVar = this.G;
            if (bVar != null) {
                bVar.destroy();
                this.G = null;
            }
            this.F.a(null);
            n68 n68Var2 = this.a;
            if (n68Var2 != null) {
                n68Var2.f();
            }
        }
    }

    public boolean z0(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        FrsTabHostFragment frsTabHostFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048631, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                if (this.z) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921587));
                    return false;
                } else if (this.A) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921642));
                    return true;
                } else if (r0() && (frsTabHostFragment = this.d) != null && frsTabHostFragment.i3()) {
                    this.d.h3();
                    UtilHelper.setNavigationBarBackground(this.b, this.d.V2());
                    return false;
                } else {
                    FrsFragment frsFragment = this.c;
                    if (frsFragment != null && frsFragment.isAdded()) {
                        if (this.c.onKeyDown(i2, keyEvent)) {
                            return true;
                        }
                        R();
                        return false;
                    }
                    return this.b.u1(i2, keyEvent);
                }
            } else if (i2 == 24) {
                FrsFragment frsFragment2 = this.c;
                if (frsFragment2 != null && frsFragment2.isAdded()) {
                    return this.c.onKeyDown(i2, keyEvent);
                }
                return false;
            } else {
                return this.b.u1(i2, keyEvent);
            }
        }
        return invokeIL.booleanValue;
    }
}
