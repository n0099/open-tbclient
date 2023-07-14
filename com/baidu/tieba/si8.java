package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class si8 extends pl1<dq5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements dq5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(si8 si8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {si8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.dq5
        public void a(@NonNull Context context, long j, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), str}) == null) {
                GroupChatActivity.v1(context, j, i, str, 0);
            }
        }

        @Override // com.baidu.tieba.dq5
        public void c(@NonNull Context context, long j, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Long.valueOf(j), str, Integer.valueOf(i)}) == null) {
                GroupChatActivity.w1(context, j, -1, str, "", i);
            }
        }

        @Override // com.baidu.tieba.dq5
        public void d(@NonNull Context context, int i, long j, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), Boolean.valueOf(z)}) == null) {
                GroupChatActivity.x1(context, j, i, true);
            }
        }

        @Override // com.baidu.tieba.dq5
        public void b(@NonNull Context context, String str, long j, int i, String str2, @Nullable Bundle bundle, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, Long.valueOf(j), Integer.valueOf(i), str2, bundle, Boolean.valueOf(z)}) == null) {
                GroupChatActivity.y1(context, str, j, i, str2, bundle, z);
            }
        }
    }

    public si8() {
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
    @Override // com.baidu.tieba.pl1
    /* renamed from: a */
    public dq5 createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (dq5) invokeV.objValue;
    }
}
