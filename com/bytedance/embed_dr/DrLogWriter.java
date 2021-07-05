package com.bytedance.embed_dr;

import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public interface DrLogWriter {

    /* loaded from: classes6.dex */
    public static class a implements DrLogWriter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.bytedance.embed_dr.DrLogWriter
        public void logD(String str, String str2, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, th) == null) {
                Log.d(str, str2, th);
            }
        }

        @Override // com.bytedance.embed_dr.DrLogWriter
        public void logE(String str, String str2, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, th) == null) {
                Log.e(str, str2, th);
            }
        }

        @Override // com.bytedance.embed_dr.DrLogWriter
        public void logI(String str, String str2, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, th) == null) {
                Log.i(str, str2, th);
            }
        }

        @Override // com.bytedance.embed_dr.DrLogWriter
        public void logV(String str, String str2, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, th) == null) {
                Log.v(str, str2, th);
            }
        }

        @Override // com.bytedance.embed_dr.DrLogWriter
        public void logW(String str, String str2, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, th) == null) {
                Log.w(str, str2, th);
            }
        }
    }

    void logD(String str, String str2, @Nullable Throwable th);

    void logE(String str, String str2, @Nullable Throwable th);

    void logI(String str, String str2, @Nullable Throwable th);

    void logV(String str, String str2, @Nullable Throwable th);

    void logW(String str, String str2, @Nullable Throwable th);
}
