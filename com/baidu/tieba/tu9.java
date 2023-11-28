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
/* loaded from: classes8.dex */
public final class tu9 extends j15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948193841, "Lcom/baidu/tieba/tu9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948193841, "Lcom/baidu/tieba/tu9;");
        }
    }

    /* loaded from: classes8.dex */
    public static final class a implements av9 {
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

        @Override // com.baidu.tieba.av9
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.onDismiss();
            }
        }

        @Override // com.baidu.tieba.av9
        public void onShow() {
            j1a i7;
            FriendBotView I0;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                PbFragment S1 = ((PbActivity) this.a).S1();
                if (S1 != null && (i7 = S1.i7()) != null && (I0 = i7.I0()) != null) {
                    I0.setDynamicLooping(false);
                }
                this.b.onShow();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class b implements av9 {
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

        @Override // com.baidu.tieba.av9
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.onDismiss();
            }
        }

        @Override // com.baidu.tieba.av9
        public void onShow() {
            j1a i7;
            FriendBotView I0;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                PbFragment S1 = ((PbActivity) this.a).S1();
                if (S1 != null && (i7 = S1.i7()) != null && (I0 = i7.I0()) != null) {
                    I0.setDynamicLooping(true);
                }
                this.b.onShow();
                SharedPrefHelper.getInstance().putLong("pb_friend_bot_bottom_click_last_time", System.currentTimeMillis());
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class c implements av9 {
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

        @Override // com.baidu.tieba.av9
        public void onDismiss() {
            j1a i7;
            FriendBotView I0;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PbFragment S1 = ((PbActivity) this.a).S1();
                if (S1 != null && (i7 = S1.i7()) != null && (I0 = i7.I0()) != null) {
                    I0.x();
                }
                YunDialogManager.unMarkShowingDialogName("pbFriendBotBottomNoUse");
            }
        }

        @Override // com.baidu.tieba.av9
        public void onShow() {
            j1a i7;
            FriendBotView I0;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                PbFragment S1 = ((PbActivity) this.a).S1();
                if (S1 != null && (i7 = S1.i7()) != null && (I0 = i7.I0()) != null) {
                    I0.r();
                }
                vu9.a.a();
                SharedPrefHelper.getInstance().putInt("pb_friend_bot_bottom_no_use_count", SharedPrefHelper.getInstance().getInt("pb_friend_bot_bottom_no_use_count", 0) + 1);
            }
        }
    }

    public tu9() {
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
        j1a i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, onDialogVisibleListener) == null) {
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(onDialogVisibleListener, "$onDialogVisibleListener");
            PbFragment S1 = ((PbActivity) context).S1();
            if (S1 != null && (i7 = S1.i7()) != null) {
                i7.V3(new a(context, onDialogVisibleListener));
            }
        }
    }

    @Override // com.baidu.tieba.j15
    public void a(final Context context, x05 data) {
        boolean z;
        List<RobotSkillInfo> list;
        List<RobotSkill> list2;
        StyleConf styleConf;
        StyleConfExtra styleConfExtra;
        String str;
        j1a i7;
        vv9 s1;
        RobotEntrance N;
        vv9 s12;
        RobotEntrance N2;
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
            if (BotEntranceManager.c.c().e().length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z && BotEntranceManager.c.c().f() != -1) {
                PbActivity pbActivity = (PbActivity) context;
                PbModel B1 = pbActivity.B1();
                FriendBotView friendBotView = null;
                if (B1 != null && (s12 = B1.s1()) != null && (N2 = s12.N()) != null) {
                    list = N2.robot_skill_info;
                } else {
                    list = null;
                }
                PbModel B12 = pbActivity.B1();
                if (B12 != null && (s1 = B12.s1()) != null && (N = s1.N()) != null) {
                    list2 = N.bottom_bar_robot_skill;
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
                        PbFragment S1 = pbActivity.S1();
                        if (S1 != null && (i7 = S1.i7()) != null) {
                            friendBotView = i7.I0();
                        }
                        dv9.e(str, friendBotView, (BaseFragmentActivity) context, new b(context, cVar));
                        return;
                    }
                    return;
                }
                YunDialogManager.unMarkShowingDialogName("pbFriendBotBottomNoUse");
                return;
            }
            SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.su9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        tu9.b(context, cVar);
                    }
                }
            }, 1000L);
        }
    }
}
