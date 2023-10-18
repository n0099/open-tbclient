package com.baidu.tieba;

import android.content.Context;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public interface z21 {
    public static final ServiceReference a = new ServiceReference("nad.core", "browserDownload");
    public static final z21 b = new a();

    /* loaded from: classes9.dex */
    public interface b extends c {
        void b(String str, @Nullable String str2);
    }

    /* loaded from: classes9.dex */
    public interface c {
        void a(String str);
    }

    void a(Object obj, c cVar);

    void b(Context context, RelativeLayout relativeLayout, String str);

    void release();

    /* loaded from: classes9.dex */
    public class a implements z21 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.z21
        public void a(Object obj, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, obj, cVar) == null) {
            }
        }

        @Override // com.baidu.tieba.z21
        public void b(Context context, RelativeLayout relativeLayout, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, relativeLayout, str) == null) {
            }
        }

        @Override // com.baidu.tieba.z21
        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

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
    }
}
