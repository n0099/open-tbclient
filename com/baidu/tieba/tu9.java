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
public final class tu9 extends m15 {
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
    public static final class a implements fv9 {
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

        @Override // com.baidu.tieba.fv9
        public void onDismiss() {
            o1a i7;
            FriendBotView I0;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PbFragment S1 = ((PbActivity) this.a).S1();
                if (S1 != null && (i7 = S1.i7()) != null && (I0 = i7.I0()) != null) {
                    I0.x();
                }
                YunDialogManager.unMarkShowingDialogName("pbFriendBotBottomNewUser");
            }
        }

        @Override // com.baidu.tieba.fv9
        public void onShow() {
            o1a i7;
            FriendBotView I0;
            o1a i72;
            FriendBotView I02;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                PbFragment S1 = ((PbActivity) this.a).S1();
                if (S1 != null && (i72 = S1.i7()) != null && (I02 = i72.I0()) != null) {
                    I02.setDynamicLooping(false);
                }
                PbFragment S12 = ((PbActivity) this.a).S1();
                if (S12 != null && (i7 = S12.i7()) != null && (I0 = i7.I0()) != null) {
                    I0.r();
                }
                SharedPrefHelper.getInstance().putBoolean("pb_friend_bot_bottom_new_user_shown", true);
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

    public static final void b(Context context) {
        o1a i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            Intrinsics.checkNotNullParameter(context, "$context");
            PbFragment S1 = ((PbActivity) context).S1();
            if (S1 != null && (i7 = S1.i7()) != null) {
                i7.V3(new a(context));
            }
        }
    }

    @Override // com.baidu.tieba.m15
    public void a(final Context context, a15 data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, data) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            if (!(context instanceof PbActivity)) {
                YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "pb好朋友bot底部新手引导失败：当前Activity非PbActivity");
                YunDialogManager.unMarkShowingDialogName("pbFriendBotBottomNewUser");
                return;
            }
            SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.su9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        tu9.b(context);
                    }
                }
            }, 1000L);
        }
    }
}
