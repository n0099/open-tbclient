package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class tr implements as {
    public static /* synthetic */ Interceptable $ic;
    public static final b e;
    public transient /* synthetic */ FieldHolder $fh;
    public final vr a;
    public final List<byte[]> b;
    public final List<ur> c;
    public final byte[] d;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public vr a;
        public List<byte[]> b;
        public List<ur> c;
        public byte[] d;

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
                    return;
                }
            }
            this.b = new LinkedList();
            this.c = new LinkedList();
        }

        public final a a(ur urVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, urVar)) == null) {
                this.c.add(urVar);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a b(vr vrVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vrVar)) == null) {
                this.a = vrVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a c(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr)) == null) {
                List<byte[]> list = this.b;
                byte[] c = vt.c(bArr);
                Intrinsics.checkExpressionValueIsNotNull(c, "StringUtils.base64Encode(cipherSuite)");
                list.add(c);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final tr d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new tr(this.a, this.b, this.c, vt.c(this.d)) : (tr) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        @JvmStatic
        public final a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a() : (a) invokeV.objValue;
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448318191, "Lcom/baidu/tieba/tr;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448318191, "Lcom/baidu/tieba/tr;");
                return;
            }
        }
        e = new b(null);
    }

    public tr(vr vrVar, List<byte[]> list, List<ur> list2, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vrVar, list, list2, bArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = vrVar;
        this.b = list;
        this.c = list2;
        this.d = bArr;
    }

    @JvmStatic
    public static final a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? e.a() : (a) invokeV.objValue;
    }

    public byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            byte[] b2 = vt.b(b());
            Intrinsics.checkExpressionValueIsNotNull(b2, "StringUtils.str2Byte(toJsonStr())");
            return b2;
        }
        return (byte[]) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String jSONObject = c().toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject, "toJsonObj().toString()");
            return jSONObject;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.as
    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            vr vrVar = this.a;
            jSONObject.putOpt("Random", vrVar != null ? vrVar.c() : null);
            jSONObject.putOpt("CipherSuites", xr.a.b(this.b));
            jSONObject.putOpt("Extensions", xr.a.a(this.c));
            jSONObject.putOpt("SKR", vt.a(this.d));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof tr) {
                    tr trVar = (tr) obj;
                    return Intrinsics.areEqual(this.a, trVar.a) && Intrinsics.areEqual(this.b, trVar.b) && Intrinsics.areEqual(this.c, trVar.c) && Intrinsics.areEqual(this.d, trVar.d);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            vr vrVar = this.a;
            int hashCode = (vrVar != null ? vrVar.hashCode() : 0) * 31;
            List<byte[]> list = this.b;
            int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
            List<ur> list2 = this.c;
            int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
            byte[] bArr = this.d;
            return hashCode3 + (bArr != null ? Arrays.hashCode(bArr) : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return "ClientHello(random=" + this.a + ", cipherSuites=" + this.b + ", extensions=" + this.c + ", SKRBytes=" + Arrays.toString(this.d) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }
}
