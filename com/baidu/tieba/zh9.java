package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.FriendBotView;
import com.baidu.tieba.pb.bot.BotEntranceManager;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.CallRobotEntrance;
import tbclient.RobotEntrance;
import tbclient.RobotSkill;
import tbclient.RobotSkillInfo;
import tbclient.StyleConf;
import tbclient.StyleConfExtra;
/* loaded from: classes9.dex */
public final class zh9 extends e65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948360094, "Lcom/baidu/tieba/zh9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948360094, "Lcom/baidu/tieba/zh9;");
        }
    }

    /* loaded from: classes9.dex */
    public static final class a implements gi9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ c b;

        public a(Context context, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = cVar;
        }

        @Override // com.baidu.tieba.gi9
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.onDismiss();
            }
        }

        @Override // com.baidu.tieba.gi9
        public void onShow() {
            xn9 H6;
            FriendBotView V0;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                PbFragment Z1 = ((PbActivity) this.a).Z1();
                if (Z1 != null && (H6 = Z1.H6()) != null && (V0 = H6.V0()) != null) {
                    V0.setDynamicLooping(false);
                }
                this.b.onShow();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class b implements gi9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ c b;

        public b(Context context, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = cVar;
        }

        @Override // com.baidu.tieba.gi9
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.onDismiss();
            }
        }

        @Override // com.baidu.tieba.gi9
        public void onShow() {
            xn9 H6;
            FriendBotView V0;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                PbFragment Z1 = ((PbActivity) this.a).Z1();
                if (Z1 != null && (H6 = Z1.H6()) != null && (V0 = H6.V0()) != null) {
                    V0.setDynamicLooping(true);
                }
                this.b.onShow();
                SharedPrefHelper.getInstance().putLong("pb_friend_bot_bottom_click_last_time", System.currentTimeMillis());
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class c implements gi9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public c(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // com.baidu.tieba.gi9
        public void onDismiss() {
            xn9 H6;
            FriendBotView V0;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PbFragment Z1 = ((PbActivity) this.a).Z1();
                if (Z1 != null && (H6 = Z1.H6()) != null && (V0 = H6.V0()) != null) {
                    V0.x();
                }
                YunDialogManager.unMarkShowingDialogName("pbFriendBotBottomNoUse");
            }
        }

        @Override // com.baidu.tieba.gi9
        public void onShow() {
            xn9 H6;
            FriendBotView V0;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                PbFragment Z1 = ((PbActivity) this.a).Z1();
                if (Z1 != null && (H6 = Z1.H6()) != null && (V0 = H6.V0()) != null) {
                    V0.r();
                }
                bi9.a.a();
                SharedPrefHelper.getInstance().putInt("pb_friend_bot_bottom_no_use_count", SharedPrefHelper.getInstance().getInt("pb_friend_bot_bottom_no_use_count", 0) + 1);
            }
        }
    }

    public zh9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static final void b(Context context, c onDialogVisibleListener) {
        xn9 H6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, onDialogVisibleListener) == null) {
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(onDialogVisibleListener, "$onDialogVisibleListener");
            PbFragment Z1 = ((PbActivity) context).Z1();
            if (Z1 != null && (H6 = Z1.H6()) != null) {
                H6.Z3(new a(context, onDialogVisibleListener));
            }
        }
    }

    @Override // com.baidu.tieba.e65
    public void a(final Context context, v55 data) {
        boolean z;
        List<RobotSkillInfo> list;
        List<RobotSkill> list2;
        StyleConf styleConf;
        StyleConfExtra styleConfExtra;
        String str;
        xn9 H6;
        aj9 r1;
        RobotEntrance K;
        aj9 r12;
        RobotEntrance K2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, data) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            if (!(context instanceof PbActivity)) {
                YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "pb好朋友bot底部N天未点击引导失败：当前Activity非PbActivity");
                YunDialogManager.unMarkShowingDialogName("pbFriendBotBottomNoUse");
                return;
            }
            final c cVar = new c(context);
            boolean z2 = true;
            if (BotEntranceManager.c.c().f().length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z && BotEntranceManager.c.c().g() != -1) {
                PbActivity pbActivity = (PbActivity) context;
                PbModel J1 = pbActivity.J1();
                FriendBotView friendBotView = null;
                if (J1 != null && (r12 = J1.r1()) != null && (K2 = r12.K()) != null) {
                    list = K2.robot_skill_info;
                } else {
                    list = null;
                }
                PbModel J12 = pbActivity.J1();
                if (J12 != null && (r1 = J12.r1()) != null && (K = r1.K()) != null) {
                    list2 = K.bottom_bar_robot_skill;
                } else {
                    list2 = null;
                }
                if (!ListUtils.isEmpty(list) && !ListUtils.isEmpty(list2)) {
                    BotEntranceManager c2 = BotEntranceManager.c.c();
                    Intrinsics.checkNotNull(list);
                    Intrinsics.checkNotNull(list2);
                    CallRobotEntrance c3 = c2.c(list, list2);
                    if (c3 != null && (styleConf = c3.style_conf) != null && (styleConfExtra = styleConf.android_extra) != null && (str = styleConfExtra.guide_content) != null) {
                        if (str.length() != 0) {
                            z2 = false;
                        }
                        if (z2) {
                            YunDialogManager.unMarkShowingDialogName("pbFriendBotBottomNoUse");
                            return;
                        }
                        PbFragment Z1 = pbActivity.Z1();
                        if (Z1 != null && (H6 = Z1.H6()) != null) {
                            friendBotView = H6.V0();
                        }
                        ji9.e(str, friendBotView, (BaseFragmentActivity) context, new b(context, cVar));
                        return;
                    }
                    return;
                }
                YunDialogManager.unMarkShowingDialogName("pbFriendBotBottomNoUse");
                return;
            }
            SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yh9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        zh9.b(context, cVar);
                    }
                }
            }, 1000L);
        }
    }
}
