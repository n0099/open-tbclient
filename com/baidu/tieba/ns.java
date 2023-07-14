package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class ns {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hs a;
    public ks b;
    public byte[] c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ns() {
        this(null, null, null, 7, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((hs) objArr[0], (ks) objArr[1], (byte[]) objArr[2], ((Integer) objArr[3]).intValue(), (DefaultConstructorMarker) objArr[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof ns) {
                    ns nsVar = (ns) obj;
                    return Intrinsics.areEqual(this.a, nsVar.a) && Intrinsics.areEqual(this.b, nsVar.b) && Intrinsics.areEqual(this.c, nsVar.c);
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            hs hsVar = this.a;
            int hashCode = (hsVar != null ? hsVar.hashCode() : 0) * 31;
            ks ksVar = this.b;
            int hashCode2 = (hashCode + (ksVar != null ? ksVar.hashCode() : 0)) * 31;
            byte[] bArr = this.c;
            return hashCode2 + (bArr != null ? Arrays.hashCode(bArr) : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "HandshakeParams(clientHello=" + this.a + ", serverHello=" + this.b + ", encodeDHPublicKey=" + Arrays.toString(this.c) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    public ns(hs hsVar, ks ksVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hsVar, ksVar, bArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = hsVar;
        this.b = ksVar;
        this.c = bArr;
    }

    public /* synthetic */ ns(hs hsVar, ks ksVar, byte[] bArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : hsVar, (i & 2) != 0 ? null : ksVar, (i & 4) != 0 ? null : bArr);
    }

    public final void a(ks ksVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ksVar) == null) {
            this.b = ksVar;
        }
    }
}
