package com.baidu.tieba;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
/* loaded from: classes6.dex */
public interface x51 {
    public static final ServiceReference a = new ServiceReference("nad.core", "statusBarTool");
    public static final x51 b = new a();

    void a(@NonNull Activity activity);

    /* loaded from: classes6.dex */
    public static class a implements x51 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // com.baidu.tieba.x51
        public void a(@NonNull Activity activity) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, activity) == null) && Build.VERSION.SDK_INT >= 21) {
                Window window = activity.getWindow();
                window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(activity.getResources().getColor(R.color.nad_white));
            }
        }
    }
}
