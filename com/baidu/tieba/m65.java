package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.data.TopNotifyData;
import com.baidu.tieba.yt6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class m65 extends e65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public m65() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            YunDialogManager.unMarkShowingDialogName("topNotify");
        }
    }

    @Override // com.baidu.tieba.e65
    public void a(Context context, v55 data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, data) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity != null && (currentActivity instanceof TbPageContextSupport)) {
                TopNotifyData a = TopNotifyData.Companion.a();
                if (a != null) {
                    mg5.a.i(a, new yt6.e() { // from class: com.baidu.tieba.w55
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // com.baidu.tieba.yt6.e
                        public final void onDismiss() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                m65.b();
                            }
                        }
                    });
                }
                YunDialogManager.markShowingDialogName("topNotify");
                return;
            }
            YunDialogManager.unMarkShowingDialogName("topNotify");
        }
    }
}
