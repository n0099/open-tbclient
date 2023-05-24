package com.baidu.tieba;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.PvThread;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes8.dex */
public final class wr6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public final boolean b;

    public wr6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = UbsABTestHelper.isAddExtraDuration();
    }

    public final void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (!this.b) {
                return;
            }
            if (TbadkCoreApplication.getInst().isMainProcess(false)) {
                if (!(activity instanceof BaseActivity) && !(activity instanceof BaseFragmentActivity)) {
                    String localClassName = activity.getLocalClassName();
                    Intrinsics.checkNotNullExpressionValue(localClassName, "activity.localClassName");
                    if (StringsKt__StringsKt.contains$default((CharSequence) localClassName, (CharSequence) "FlutterPageActivity", false, 2, (Object) null)) {
                        return;
                    }
                } else {
                    return;
                }
            }
            long currentTimeMillis = (System.currentTimeMillis() - this.a) / 1000;
            if (PermissionUtil.isAgreePrivacyPolicy()) {
                PvThread pvThread = new PvThread("use", String.valueOf(currentTimeMillis));
                pvThread.setPageName(activity.getLocalClassName());
                pvThread.start();
            }
        }
    }

    public final void b(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (!this.b) {
                return;
            }
            this.a = System.currentTimeMillis();
        }
    }
}
