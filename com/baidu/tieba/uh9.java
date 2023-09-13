package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.view.FriendBotView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class uh9 extends e65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948211139, "Lcom/baidu/tieba/uh9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948211139, "Lcom/baidu/tieba/uh9;");
        }
    }

    /* loaded from: classes8.dex */
    public static final class a implements gi9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public a(Context context) {
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
                YunDialogManager.unMarkShowingDialogName("pbFriendBotBottomNewUser");
            }
        }

        @Override // com.baidu.tieba.gi9
        public void onShow() {
            xn9 H6;
            FriendBotView V0;
            xn9 H62;
            FriendBotView V02;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                PbFragment Z1 = ((PbActivity) this.a).Z1();
                if (Z1 != null && (H62 = Z1.H6()) != null && (V02 = H62.V0()) != null) {
                    V02.setDynamicLooping(false);
                }
                PbFragment Z12 = ((PbActivity) this.a).Z1();
                if (Z12 != null && (H6 = Z12.H6()) != null && (V0 = H6.V0()) != null) {
                    V0.r();
                }
                SharedPrefHelper.getInstance().putBoolean("pb_friend_bot_bottom_new_user_shown", true);
            }
        }
    }

    public uh9() {
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

    public static final void b(Context context) {
        xn9 H6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            Intrinsics.checkNotNullParameter(context, "$context");
            PbFragment Z1 = ((PbActivity) context).Z1();
            if (Z1 != null && (H6 = Z1.H6()) != null) {
                H6.Z3(new a(context));
            }
        }
    }

    @Override // com.baidu.tieba.e65
    public void a(final Context context, v55 data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, data) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            if (!(context instanceof PbActivity)) {
                YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "pb好朋友bot底部新手引导失败：当前Activity非PbActivity");
                YunDialogManager.unMarkShowingDialogName("pbFriendBotBottomNewUser");
                return;
            }
            SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.th9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        uh9.b(context);
                    }
                }
            }, 1000L);
        }
    }
}
