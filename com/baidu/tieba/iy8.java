package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cy8;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class iy8 implements cg1<cy8> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static final class a implements cy8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ky8 b;

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

        @Override // com.baidu.tieba.cy8
        public void onDestroy() {
            ky8 ky8Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (ky8Var = this.b) != null) {
                ky8Var.p();
            }
        }

        @Override // com.baidu.tieba.cy8
        public void a(rk5 callback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, callback) == null) {
                Intrinsics.checkNotNullParameter(callback, "callback");
                ky8 ky8Var = this.b;
                if (ky8Var != null) {
                    ky8Var.s(callback);
                }
            }
        }

        @Override // com.baidu.tieba.cy8
        public void d(cy8.a callback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, callback) == null) {
                Intrinsics.checkNotNullParameter(callback, "callback");
                ky8 ky8Var = this.b;
                if (ky8Var != null) {
                    ky8Var.z(callback);
                }
            }
        }

        @Override // com.baidu.tieba.cy8
        public void b(Context context, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i) == null) {
                Intrinsics.checkNotNullParameter(context, "context");
                this.b = new ky8(context, i);
            }
        }

        @Override // com.baidu.tieba.cy8
        public void c(long j, List<ChatRoomInfo> roomInfoList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j, roomInfoList) == null) {
                Intrinsics.checkNotNullParameter(roomInfoList, "roomInfoList");
                ky8 ky8Var = this.b;
                if (ky8Var != null) {
                    ky8Var.A(j);
                }
                ky8 ky8Var2 = this.b;
                if (ky8Var2 != null) {
                    ky8Var2.o(roomInfoList);
                }
            }
        }
    }

    public iy8() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cg1
    /* renamed from: a */
    public cy8 getService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a();
        }
        return (cy8) invokeV.objValue;
    }
}
