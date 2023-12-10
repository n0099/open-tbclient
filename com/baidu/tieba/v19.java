package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import com.baidu.tieba.p19;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class v19 implements gg1<p19> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static final class a implements p19 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public x19 b;

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

        @Override // com.baidu.tieba.p19
        public void onDestroy() {
            x19 x19Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (x19Var = this.b) != null) {
                x19Var.p();
            }
        }

        @Override // com.baidu.tieba.p19
        public void a(bl5 callback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, callback) == null) {
                Intrinsics.checkNotNullParameter(callback, "callback");
                x19 x19Var = this.b;
                if (x19Var != null) {
                    x19Var.s(callback);
                }
            }
        }

        @Override // com.baidu.tieba.p19
        public void d(p19.a callback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, callback) == null) {
                Intrinsics.checkNotNullParameter(callback, "callback");
                x19 x19Var = this.b;
                if (x19Var != null) {
                    x19Var.z(callback);
                }
            }
        }

        @Override // com.baidu.tieba.p19
        public void b(Context context, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i) == null) {
                Intrinsics.checkNotNullParameter(context, "context");
                this.b = new x19(context, i);
            }
        }

        @Override // com.baidu.tieba.p19
        public void c(long j, List<ChatRoomInfo> roomInfoList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j, roomInfoList) == null) {
                Intrinsics.checkNotNullParameter(roomInfoList, "roomInfoList");
                x19 x19Var = this.b;
                if (x19Var != null) {
                    x19Var.A(j);
                }
                x19 x19Var2 = this.b;
                if (x19Var2 != null) {
                    x19Var2.o(roomInfoList);
                }
            }
        }
    }

    public v19() {
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
    @Override // com.baidu.tieba.gg1
    /* renamed from: a */
    public p19 getService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a();
        }
        return (p19) invokeV.objValue;
    }
}
