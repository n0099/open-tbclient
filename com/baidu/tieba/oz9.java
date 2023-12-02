package com.baidu.tieba;

import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.CommonStatisticUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.FriendBotView;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tieba.ju9;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.n0a;
import com.baidu.tieba.pb.bot.BotEntranceManager;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.AbilityConf;
import tbclient.CallRobotEntrance;
import tbclient.RobotEntrance;
import tbclient.RobotSkill;
import tbclient.RobotSkillInfo;
import tbclient.StyleConf;
import tbclient.StyleContentInfo;
/* loaded from: classes7.dex */
public final class oz9 extends o1a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final PbFragment c;
    public FriendBotView d;
    public ImageView e;
    public boolean f;
    public zv9 g;
    public CallRobotEntrance h;
    public Runnable i;
    public final int j;
    public final n0a.a k;
    public final FriendBotView.f l;

    /* loaded from: classes7.dex */
    public static final class c implements n0a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oz9 a;

        /* loaded from: classes7.dex */
        public static final class a implements ev9 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ oz9 a;
            public final /* synthetic */ String b;

            public a(oz9 oz9Var, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oz9Var, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = oz9Var;
                this.b = str;
            }

            @Override // com.baidu.tieba.ev9
            public void onDismiss() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a.d == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
                    }
                    this.a.f = false;
                    FriendBotView friendBotView = this.a.d;
                    if (friendBotView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
                        friendBotView = null;
                    }
                    friendBotView.x();
                    TbLog defaultLog = DefaultLog.getInstance();
                    defaultLog.e("BotGuideManager", "底bar点击引导展示完毕隐藏,文案：" + this.b);
                }
            }

            @Override // com.baidu.tieba.ev9
            public void onShow() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    SharedPrefHelper.getInstance().putLong("pb_friend_bot_bottom_click_last_time", System.currentTimeMillis());
                    if (this.a.d == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
                    }
                    this.a.f = true;
                    FriendBotView friendBotView = this.a.d;
                    FriendBotView friendBotView2 = null;
                    if (friendBotView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
                        friendBotView = null;
                    }
                    friendBotView.setDynamicLooping(true);
                    FriendBotView friendBotView3 = this.a.d;
                    if (friendBotView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
                    } else {
                        friendBotView2 = friendBotView3;
                    }
                    friendBotView2.r();
                    DefaultLog.getInstance().e("BotGuideManager", "底bar点击引导展示了,文案：" + this.b);
                }
            }
        }

        public c(oz9 oz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oz9Var;
        }

        @Override // com.baidu.tieba.n0a.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (YunDialogManager.isShowingDialog()) {
                    TbLog defaultLog = DefaultLog.getInstance();
                    defaultLog.e("BotGuideManager", "底bar点击引导未展示,云弹窗正在展示：" + YunDialogManager.getShowingDialog());
                } else if (hv9.c()) {
                    DefaultLog.getInstance().e("BotGuideManager", "底bar点击引导未展示,BotGuideManager在展示其他");
                } else {
                    long j = SharedPrefHelper.getInstance().getLong("pb_friend_bot_bottom_click_last_time", 0L);
                    boolean R2 = this.a.t().i7().R2();
                    if (!DateUtils.isToday(j) && !R2) {
                        if (this.a.g == null) {
                            DefaultLog.getInstance().e("BotGuideManager", "底bar点击引导未展示,pbData为null");
                            return;
                        }
                        zv9 zv9Var = this.a.g;
                        Intrinsics.checkNotNull(zv9Var);
                        RobotEntrance N = zv9Var.N();
                        if (N == null) {
                            DefaultLog.getInstance().e("BotGuideManager", "底bar点击引导未展示,pbData下robotEntrance为null");
                            return;
                        }
                        String str = N.bottom_bar_click_guide;
                        if (!TextUtils.isEmpty(str) && this.a.t() != null) {
                            Intrinsics.checkNotNullExpressionValue(this.a.t().u0(), "mPbFragment.getPbActivity()");
                            if (this.a.d == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
                            }
                            FriendBotView friendBotView = this.a.d;
                            if (friendBotView == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
                                friendBotView = null;
                            }
                            hv9.e(str, friendBotView, this.a.t().u0(), new a(this.a, str));
                            return;
                        }
                        TbLog defaultLog2 = DefaultLog.getInstance();
                        defaultLog2.e("BotGuideManager", "底bar点击引导未展示,guideText=" + str + ",mPbFragment=" + this.a.t());
                        return;
                    }
                    TbLog defaultLog3 = DefaultLog.getInstance();
                    defaultLog3.e("BotGuideManager", "底bar点击引导未展示,当天已经展示过了：" + DateUtils.isToday(j) + "，话题在展示：" + R2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class a implements FriendBotView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oz9 a;

        public a(oz9 oz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oz9Var;
        }

        @Override // com.baidu.tbadk.core.view.FriendBotView.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            this.a.E(3, 4, z);
            this.a.B();
        }

        @Override // com.baidu.tbadk.core.view.FriendBotView.f
        public void b(boolean z, boolean z2, String loadingToast) {
            AbilityConf abilityConf;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), loadingToast}) == null) {
                Intrinsics.checkNotNullParameter(loadingToast, "loadingToast");
                if (!nt5.a()) {
                    this.a.E(2, 4, z);
                    if (!TbadkCoreApplication.isLogin()) {
                        ViewHelper.skipToLoginActivity(this.a.t().getContext());
                    } else if (z2) {
                        this.a.B();
                    } else if (z) {
                        k4a.e(loadingToast);
                    } else {
                        CallRobotEntrance callRobotEntrance = this.a.h;
                        if (callRobotEntrance != null && (abilityConf = callRobotEntrance.ability_conf) != null) {
                            oz9 oz9Var = this.a;
                            String str = abilityConf.bot_uk;
                            Intrinsics.checkNotNullExpressionValue(str, "it.bot_uk");
                            oz9Var.p(loadingToast, str, abilityConf.skill_id.intValue());
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends FastRequest.b<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String d;
        public final /* synthetic */ oz9 e;
        public final /* synthetic */ String f;

        public b(String str, oz9 oz9Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, oz9Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = str;
            this.e = oz9Var;
            this.f = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: l */
        public void f(int i, String errMsg, Void r7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, errMsg, r7) == null) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                super.f(i, errMsg, r7);
                this.e.t().showToast(errMsg);
                PbModel l0 = this.e.t().l0();
                if (l0 != null) {
                    l0.m3();
                }
                uz9 G0 = this.e.t().i7().G0();
                if (G0 != null) {
                    G0.v();
                }
                CallRobotEntrance callRobotEntrance = this.e.h;
                if (callRobotEntrance != null) {
                    FriendBotView friendBotView = this.e.d;
                    if (friendBotView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
                        friendBotView = null;
                    }
                    friendBotView.k(callRobotEntrance);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: m */
        public void i(Void botResponse) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, botResponse) == null) {
                Intrinsics.checkNotNullParameter(botResponse, "botResponse");
                super.i(botResponse);
                k4a.e(this.d);
                k4a.b(this.e.t().l0(), this.f);
                if (this.e.i != null) {
                    SafeHandler inst = SafeHandler.getInst();
                    Runnable runnable = this.e.i;
                    Intrinsics.checkNotNull(runnable);
                    inst.removeCallbacks(runnable);
                }
                oz9 oz9Var = this.e;
                String token = this.f;
                Intrinsics.checkNotNullExpressionValue(token, "token");
                oz9Var.i = new mu9(token, this.e.t());
                SafeHandler inst2 = SafeHandler.getInst();
                Runnable runnable2 = this.e.i;
                Intrinsics.checkNotNull(runnable2);
                inst2.postDelayed(runnable2, this.e.j);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class d implements ju9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oz9 a;

        public d(oz9 oz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oz9Var;
        }

        @Override // com.baidu.tieba.ju9.b
        public void a(CallRobotEntrance data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                if (this.a.d == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
                }
                FriendBotView friendBotView = this.a.d;
                FriendBotView friendBotView2 = null;
                if (friendBotView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
                    friendBotView = null;
                }
                boolean o = friendBotView.o();
                this.a.x(data, o);
                if (!o) {
                    AbilityConf abilityConf = data.ability_conf;
                    if (abilityConf == null) {
                        return;
                    }
                    BotEntranceManager c = BotEntranceManager.c.c();
                    String str = abilityConf.bot_uk;
                    Intrinsics.checkNotNullExpressionValue(str, "abilityConf.bot_uk");
                    Integer num = abilityConf.skill_id;
                    Intrinsics.checkNotNullExpressionValue(num, "abilityConf.skill_id");
                    c.l(str, num.intValue());
                    this.a.h = data;
                    StyleConf styleConf = data.style_conf;
                    if (styleConf != null) {
                        oz9 oz9Var = this.a;
                        StyleContentInfo styleContentInfo = styleConf.day;
                        Intrinsics.checkNotNullExpressionValue(styleContentInfo, "it.day");
                        StyleContentInfo styleContentInfo2 = styleConf.dark;
                        Intrinsics.checkNotNullExpressionValue(styleContentInfo2, "it.dark");
                        ax4 ax4Var = new ax4(data, styleContentInfo, styleContentInfo2, false);
                        FriendBotView friendBotView3 = oz9Var.d;
                        if (friendBotView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
                            friendBotView3 = null;
                        }
                        friendBotView3.setCallRobotEntranceData(ax4Var);
                    }
                    this.a.G();
                    oz9 oz9Var2 = this.a;
                    FriendBotView friendBotView4 = oz9Var2.d;
                    if (friendBotView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
                    } else {
                        friendBotView2 = friendBotView4;
                    }
                    String loadingToast = friendBotView2.getLoadingToast();
                    Intrinsics.checkNotNullExpressionValue(loadingToast, "mBottomBot.loadingToast");
                    String str2 = abilityConf.bot_uk;
                    Intrinsics.checkNotNullExpressionValue(str2, "abilityConf.bot_uk");
                    oz9Var2.p(loadingToast, str2, abilityConf.skill_id.intValue());
                    return;
                }
                FriendBotView friendBotView5 = this.a.d;
                if (friendBotView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
                } else {
                    friendBotView2 = friendBotView5;
                }
                k4a.e(friendBotView2.getLoadingToast());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class e implements ev9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oz9 a;
        public final /* synthetic */ String b;

        public e(oz9 oz9Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oz9Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oz9Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.ev9
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.d == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
                }
                FriendBotView friendBotView = this.a.d;
                if (friendBotView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
                    friendBotView = null;
                }
                friendBotView.x();
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.e("BotGuideManager", "新手长按引导展示完毕隐藏,文案：" + this.b);
            }
        }

        @Override // com.baidu.tieba.ev9
        public void onShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.d == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
                }
                FriendBotView friendBotView = this.a.d;
                FriendBotView friendBotView2 = null;
                if (friendBotView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
                    friendBotView = null;
                }
                friendBotView.setDynamicLooping(true);
                FriendBotView friendBotView3 = this.a.d;
                if (friendBotView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
                } else {
                    friendBotView2 = friendBotView3;
                }
                friendBotView2.r();
                SharedPrefHelper.getInstance().putLong("pb_friend_bot_bottom_click_last_time", System.currentTimeMillis());
                DefaultLog.getInstance().e("BotGuideManager", "新手长按引导展示了,文案：" + this.b);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oz9(PbFragment mPbFragment, View view2) {
        super(mPbFragment.u0(), view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mPbFragment, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((BaseFragmentActivity) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(mPbFragment, "mPbFragment");
        this.c = mPbFragment;
        this.j = 30000;
        this.k = new c(this);
        this.l = new a(this);
    }

    public final void A(zv9 zv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zv9Var) == null) {
            this.g = zv9Var;
        }
    }

    public final void o(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.addRule(11);
                view2.setLayoutParams(layoutParams2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        }
    }

    public final void z(ImageView bottomCollect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bottomCollect) == null) {
            Intrinsics.checkNotNullParameter(bottomCollect, "bottomCollect");
            this.e = bottomCollect;
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            C(null);
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || !w()) {
            return;
        }
        FriendBotView friendBotView = this.d;
        if (friendBotView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
            friendBotView = null;
        }
        E(1, 4, friendBotView.o());
    }

    @Override // com.baidu.tieba.o1a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            v();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.d == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
            }
            if (this.h != null) {
                FriendBotView friendBotView = this.d;
                if (friendBotView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
                    friendBotView = null;
                }
                friendBotView.k(this.h);
            }
        }
    }

    public final FriendBotView r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            FriendBotView friendBotView = this.d;
            if (friendBotView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
                return null;
            }
            return friendBotView;
        }
        return (FriendBotView) invokeV.objValue;
    }

    public final n0a.a s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.k;
        }
        return (n0a.a) invokeV.objValue;
    }

    public final PbFragment t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.c;
        }
        return (PbFragment) invokeV.objValue;
    }

    public final boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && this.i != null) {
            SafeHandler inst = SafeHandler.getInst();
            Runnable runnable = this.i;
            Intrinsics.checkNotNull(runnable);
            inst.removeCallbacks(runnable);
        }
    }

    public final void C(ev9 ev9Var) {
        zv9 zv9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ev9Var) == null) && (zv9Var = this.g) != null) {
            Intrinsics.checkNotNull(zv9Var);
            if (zv9Var.N() != null) {
                zv9 zv9Var2 = this.g;
                Intrinsics.checkNotNull(zv9Var2);
                if (!ListUtils.isEmpty(zv9Var2.N().robot_skill_info)) {
                    zv9 zv9Var3 = this.g;
                    Intrinsics.checkNotNull(zv9Var3);
                    if (!ListUtils.isEmpty(zv9Var3.N().bottom_bar_robot_skill)) {
                        ju9.a aVar = ju9.a;
                        FriendBotView friendBotView = this.d;
                        if (friendBotView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
                            friendBotView = null;
                        }
                        BotEntranceManager.a aVar2 = BotEntranceManager.c;
                        zv9 zv9Var4 = this.g;
                        Intrinsics.checkNotNull(zv9Var4);
                        List<RobotSkillInfo> list = zv9Var4.N().robot_skill_info;
                        Intrinsics.checkNotNullExpressionValue(list, "mPbData!!.getRobotEntrance().robot_skill_info");
                        zv9 zv9Var5 = this.g;
                        Intrinsics.checkNotNull(zv9Var5);
                        List<RobotSkill> list2 = zv9Var5.N().bottom_bar_robot_skill;
                        Intrinsics.checkNotNullExpressionValue(list2, "mPbData!!.getRobotEntran…().bottom_bar_robot_skill");
                        aVar.b(friendBotView, aVar2.b(list, list2), new d(this), ev9Var);
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.baidu.tieba.oz9, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v19, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r11v3, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r11v8, types: [android.widget.ImageView] */
    public final void D(zv9 zv9Var) {
        boolean z;
        StyleConf styleConf;
        StyleContentInfo styleContentInfo;
        StyleContentInfo styleContentInfo2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, zv9Var) == null) {
            FriendBotView friendBotView = null;
            if (zv9Var != null && zv9Var.N() != null) {
                RobotEntrance N = zv9Var.N();
                if (N == null) {
                    return;
                }
                if (!ListUtils.isEmpty(N.robot_skill_info) && !ListUtils.isEmpty(N.bottom_bar_robot_skill)) {
                    if (!ListUtils.isEmpty(N.bottom_bar_robot_skill)) {
                        BotEntranceManager c2 = BotEntranceManager.c.c();
                        List<RobotSkillInfo> list = N.robot_skill_info;
                        Intrinsics.checkNotNullExpressionValue(list, "entrance.robot_skill_info");
                        List<RobotSkill> list2 = N.bottom_bar_robot_skill;
                        Intrinsics.checkNotNullExpressionValue(list2, "entrance.bottom_bar_robot_skill");
                        CallRobotEntrance c3 = c2.c(list, list2);
                        this.h = c3;
                        if (c3 == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        BotEntranceManager c4 = BotEntranceManager.c.c();
                        List<RobotSkillInfo> list3 = N.robot_skill_info;
                        Intrinsics.checkNotNullExpressionValue(list3, "entrance.robot_skill_info");
                        List<RobotSkill> list4 = N.bottom_bar_robot_skill;
                        Intrinsics.checkNotNullExpressionValue(list4, "entrance.bottom_bar_robot_skill");
                        RobotSkillInfo d2 = c4.d(list3, list4);
                        if (z) {
                            if (d2 != null) {
                                styleContentInfo = d2.style_day;
                                styleContentInfo2 = d2.style_dark;
                            }
                            styleContentInfo2 = null;
                            styleContentInfo = null;
                        } else {
                            CallRobotEntrance callRobotEntrance = this.h;
                            if (callRobotEntrance != null && (styleConf = callRobotEntrance.style_conf) != null) {
                                styleContentInfo = styleConf.day;
                                styleContentInfo2 = styleConf.dark;
                            }
                            styleContentInfo2 = null;
                            styleContentInfo = null;
                        }
                        if (styleContentInfo != null && styleContentInfo2 != null) {
                            FriendBotView friendBotView2 = this.d;
                            if (friendBotView2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
                                friendBotView2 = null;
                            }
                            friendBotView2.setVisibility(0);
                            FriendBotView friendBotView3 = this.d;
                            if (friendBotView3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
                                friendBotView3 = null;
                            }
                            o(friendBotView3);
                            ImageView imageView = this.e;
                            if (imageView == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mBottomCollect");
                                imageView = null;
                            }
                            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                            if (layoutParams != null) {
                                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                                layoutParams2.removeRule(11);
                                layoutParams2.addRule(0, R.id.obfuscated_res_0x7f091ba1);
                                ImageView imageView2 = this.e;
                                if (imageView2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mBottomCollect");
                                    imageView2 = null;
                                }
                                imageView2.setLayoutParams(layoutParams2);
                                FriendBotView friendBotView4 = this.d;
                                if (friendBotView4 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
                                    friendBotView4 = null;
                                }
                                friendBotView4.setClickCallBack(this.l);
                                ax4 ax4Var = new ax4(this.h, styleContentInfo, styleContentInfo2, z);
                                FriendBotView friendBotView5 = this.d;
                                if (friendBotView5 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
                                } else {
                                    friendBotView = friendBotView5;
                                }
                                friendBotView.setCallRobotEntranceData(ax4Var);
                                return;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                        }
                        FriendBotView friendBotView6 = this.d;
                        if (friendBotView6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
                            friendBotView6 = null;
                        }
                        friendBotView6.setVisibility(8);
                        ?? r11 = this.e;
                        if (r11 == 0) {
                            Intrinsics.throwUninitializedPropertyAccessException("mBottomCollect");
                        } else {
                            friendBotView = r11;
                        }
                        o(friendBotView);
                        return;
                    }
                    return;
                }
                FriendBotView friendBotView7 = this.d;
                if (friendBotView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
                    friendBotView7 = null;
                }
                friendBotView7.setVisibility(8);
                ?? r112 = this.e;
                if (r112 == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomCollect");
                } else {
                    friendBotView = r112;
                }
                o(friendBotView);
                return;
            }
            FriendBotView friendBotView8 = this.d;
            if (friendBotView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
                friendBotView8 = null;
            }
            friendBotView8.setVisibility(8);
            ?? r113 = this.e;
            if (r113 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("mBottomCollect");
            } else {
                friendBotView = r113;
            }
            o(friendBotView);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void E(int i, int i2, boolean z) {
        String str;
        zv9 zv9Var;
        String str2;
        String str3;
        zv9 zv9Var2;
        ThreadData threadData;
        ThreadData R;
        AbilityConf abilityConf;
        String str4;
        AbilityConf abilityConf2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            CallRobotEntrance callRobotEntrance = this.h;
            String str5 = "";
            String str6 = null;
            if (callRobotEntrance != null) {
                if (callRobotEntrance != null) {
                    abilityConf = callRobotEntrance.ability_conf;
                } else {
                    abilityConf = null;
                }
                if (abilityConf != null) {
                    CallRobotEntrance callRobotEntrance2 = this.h;
                    if (callRobotEntrance2 != null && (abilityConf2 = callRobotEntrance2.ability_conf) != null) {
                        str4 = abilityConf2.bot_uk;
                    } else {
                        str4 = null;
                    }
                    if (str4 == null) {
                        str4 = "";
                    }
                    str = str4;
                    zv9Var = this.g;
                    if (zv9Var == null) {
                        str2 = zv9Var.o();
                    } else {
                        str2 = null;
                    }
                    if (str2 != null) {
                        str3 = "";
                    } else {
                        str3 = str2;
                    }
                    zv9Var2 = this.g;
                    if (zv9Var2 == null) {
                        threadData = zv9Var2.R();
                    } else {
                        threadData = null;
                    }
                    if (threadData != null) {
                        zv9 zv9Var3 = this.g;
                        if (zv9Var3 != null && (R = zv9Var3.R()) != null) {
                            str6 = R.getTid();
                        }
                        str5 = String.valueOf(str6);
                    }
                    CommonStatisticUtils.statisticFriendBotView(i, str, i2, z, str3, str5);
                }
            }
            str = "";
            zv9Var = this.g;
            if (zv9Var == null) {
            }
            if (str2 != null) {
            }
            zv9Var2 = this.g;
            if (zv9Var2 == null) {
            }
            if (threadData != null) {
            }
            CommonStatisticUtils.statisticFriendBotView(i, str, i2, z, str3, str5);
        }
    }

    public final void p(String str, String str2, long j) {
        ThreadData threadData;
        String str3;
        String str4;
        String str5;
        ThreadData R;
        ThreadData R2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            zv9 zv9Var = this.g;
            String str6 = null;
            if (zv9Var != null) {
                threadData = zv9Var.R();
            } else {
                threadData = null;
            }
            if (threadData == null) {
                return;
            }
            zu9.a.a();
            long currentTimeMillis = System.currentTimeMillis();
            zv9 zv9Var2 = this.g;
            if (zv9Var2 != null && (R2 = zv9Var2.R()) != null) {
                str3 = R2.getFirstPostId();
            } else {
                str3 = null;
            }
            if (str3 == null) {
                str4 = "";
            } else {
                str4 = str3;
            }
            zv9 zv9Var3 = this.g;
            if (zv9Var3 != null && (R = zv9Var3.R()) != null) {
                str6 = R.getTid();
            }
            if (str6 == null) {
                str5 = "";
            } else {
                str5 = str6;
            }
            String c2 = k4a.c(str4, TbadkCoreApplication.getCurrentPortrait(), currentTimeMillis);
            k4a.a(this.c.getPageContext(), str2, j, str5, str4, c2, new b(str, this, c2));
        }
    }

    public final void G() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (hv9.c()) {
                DefaultLog.getInstance().e("BotGuideManager", "新手长按引导未展示,BotGuideManager在展示其他");
            } else if (SharedPrefHelper.getInstance().getBoolean("pb_friend_bot_bottom_long_click_shown", false)) {
                DefaultLog.getInstance().e("BotGuideManager", "新手长按引导未展示,长按引导已经展示过");
            } else if (SharedPrefHelper.getInstance().getBoolean("pb_friend_bot_bottom_new_user_shown", false) && (pbFragment = this.c) != null) {
                BaseFragmentActivity baseFragmentActivity = pbFragment.getBaseFragmentActivity();
                FriendBotView friendBotView = null;
                if (baseFragmentActivity != null) {
                    if (this.d == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
                    }
                    String string = baseFragmentActivity.getString(R.string.obfuscated_res_0x7f0f1024);
                    Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str…_bottom_long_click_shown)");
                    FriendBotView friendBotView2 = this.d;
                    if (friendBotView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
                    } else {
                        friendBotView = friendBotView2;
                    }
                    hv9.e(string, friendBotView, baseFragmentActivity, new e(this, string));
                    SharedPrefHelper.getInstance().putBoolean("pb_friend_bot_bottom_long_click_shown", true);
                    return;
                }
                TbLog defaultLog = DefaultLog.getInstance();
                StringBuilder sb = new StringBuilder();
                sb.append("新手长按引导未展示,activity=");
                sb.append(baseFragmentActivity);
                sb.append(",mBottomBot=");
                FriendBotView friendBotView3 = this.d;
                if (friendBotView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
                } else {
                    friendBotView = friendBotView3;
                }
                sb.append(friendBotView);
                defaultLog.e("BotGuideManager", sb.toString());
            } else {
                TbLog defaultLog2 = DefaultLog.getInstance();
                defaultLog2.e("BotGuideManager", "新手长按引导未展示,新手引导未展示过，mPbFragment==" + this.c);
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            View findViewById = this.b.findViewById(R.id.obfuscated_res_0x7f091ba1);
            Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById<F…(R.id.pb_editor_tool_bot)");
            this.d = (FriendBotView) findViewById;
            FriendBotView friendBotView = null;
            if (this.c.l0() != null) {
                FriendBotView friendBotView2 = this.d;
                if (friendBotView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
                    friendBotView2 = null;
                }
                friendBotView2.setTid(this.c.l0().R());
            }
            FriendBotView friendBotView3 = this.d;
            if (friendBotView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
            } else {
                friendBotView = friendBotView3;
            }
            friendBotView.l();
        }
    }

    public final boolean w() {
        InterceptResult invokeV;
        zv9 zv9Var;
        RobotEntrance robotEntrance;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.c.i7() != null && (zv9Var = this.g) != null) {
                FriendBotView friendBotView = null;
                if (zv9Var != null) {
                    robotEntrance = zv9Var.N();
                } else {
                    robotEntrance = null;
                }
                if (robotEntrance != null) {
                    if (this.d == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
                    }
                    FriendBotView friendBotView2 = this.d;
                    if (friendBotView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBottomBot");
                    } else {
                        friendBotView = friendBotView2;
                    }
                    if (friendBotView.getVisibility() != 8) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0015: INVOKE  (r2v1 int A[REMOVE]) = 
      (wrap: java.lang.Integer : 0x0013: IGET  (r2v0 java.lang.Integer A[REMOVE]) = (r0v2 tbclient.AbilityConf) tbclient.AbilityConf.skill_id java.lang.Integer)
     type: VIRTUAL call: java.lang.Integer.intValue():int), ('=' char)] */
    public final void x(CallRobotEntrance callRobotEntrance, boolean z) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048593, this, callRobotEntrance, z) != null) || callRobotEntrance == null) {
            return;
        }
        AbilityConf abilityConf = callRobotEntrance.ability_conf;
        StyleConf styleConf = callRobotEntrance.style_conf;
        if (abilityConf == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(abilityConf.skill_id.intValue());
        sb.append('=');
        String sb2 = sb.toString();
        if (styleConf != null && !TextUtils.isEmpty(styleConf.content)) {
            sb2 = sb2 + styleConf.content;
        }
        String str3 = sb2;
        ThreadData threadData = null;
        zv9 zv9Var = this.g;
        if (zv9Var == null) {
            str = "";
        } else {
            threadData = zv9Var.R();
            String o = zv9Var.o();
            Intrinsics.checkNotNullExpressionValue(o, "it.getForumId()");
            str = o;
        }
        if (threadData == null) {
            str2 = "";
        } else {
            str2 = threadData.getTid().toString();
        }
        String str4 = abilityConf.bot_uk;
        Intrinsics.checkNotNull(str3);
        CommonStatisticUtils.statisticBotSkillMenu(2, str4, 4, z, str, str3, str2);
    }
}
