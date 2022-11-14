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
/* loaded from: classes5.dex */
public final class nr implements ur {
    public static /* synthetic */ Interceptable $ic;
    public static final b e;
    public transient /* synthetic */ FieldHolder $fh;
    public final pr a;
    public final List<byte[]> b;
    public final List<or> c;
    public final byte[] d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448312425, "Lcom/baidu/tieba/nr;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448312425, "Lcom/baidu/tieba/nr;");
                return;
            }
        }
        e = new b(null);
    }

    @JvmStatic
    public static final a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? e.a() : (a) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof nr) {
                    nr nrVar = (nr) obj;
                    return Intrinsics.areEqual(this.a, nrVar.a) && Intrinsics.areEqual(this.b, nrVar.b) && Intrinsics.areEqual(this.c, nrVar.c) && Intrinsics.areEqual(this.d, nrVar.d);
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
            pr prVar = this.a;
            int hashCode = (prVar != null ? prVar.hashCode() : 0) * 31;
            List<byte[]> list = this.b;
            int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
            List<or> list2 = this.c;
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

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public pr a;
        public List<byte[]> b;
        public List<or> c;
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

        public final nr d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return new nr(this.a, this.b, this.c, pt.c(this.d));
            }
            return (nr) invokeV.objValue;
        }

        public final a a(or orVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, orVar)) == null) {
                this.c.add(orVar);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a b(pr prVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, prVar)) == null) {
                this.a = prVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a c(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr)) == null) {
                List<byte[]> list = this.b;
                byte[] c = pt.c(bArr);
                Intrinsics.checkExpressionValueIsNotNull(c, "StringUtils.base64Encode(cipherSuite)");
                list.add(c);
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new a();
            }
            return (a) invokeV.objValue;
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public nr(pr prVar, List<byte[]> list, List<or> list2, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {prVar, list, list2, bArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = prVar;
        this.b = list;
        this.c = list2;
        this.d = bArr;
    }

    public byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            byte[] b2 = pt.b(b());
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

    @Override // com.baidu.tieba.ur
    public JSONObject c() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject2 = new JSONObject();
            pr prVar = this.a;
            if (prVar != null) {
                jSONObject = prVar.c();
            } else {
                jSONObject = null;
            }
            jSONObject2.putOpt("Random", jSONObject);
            jSONObject2.putOpt("CipherSuites", rr.a.b(this.b));
            jSONObject2.putOpt("Extensions", rr.a.a(this.c));
            jSONObject2.putOpt("SKR", pt.a(this.d));
            return jSONObject2;
        }
        return (JSONObject) invokeV.objValue;
    }
}
