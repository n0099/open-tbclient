package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public interface uya {
    void a(String str, int i, String str2);

    void b(String str);

    void c(String str, int i);

    void d(String str);

    void e(String str);

    /* loaded from: classes8.dex */
    public static class a implements uya {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.uya
        public void a(String speakerId, int i, String errMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, speakerId, i, errMsg) == null) {
                Intrinsics.checkNotNullParameter(speakerId, "speakerId");
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            }
        }

        @Override // com.baidu.tieba.uya
        public void b(String speakerId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, speakerId) == null) {
                Intrinsics.checkNotNullParameter(speakerId, "speakerId");
            }
        }

        @Override // com.baidu.tieba.uya
        public void c(String speakerId, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, speakerId, i) == null) {
                Intrinsics.checkNotNullParameter(speakerId, "speakerId");
            }
        }

        @Override // com.baidu.tieba.uya
        public void d(String speakerId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, speakerId) == null) {
                Intrinsics.checkNotNullParameter(speakerId, "speakerId");
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
