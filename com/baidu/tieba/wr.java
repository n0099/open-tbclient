package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.ur;
import com.baidu.tieba.vr;
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
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class wr {
    public static /* synthetic */ Interceptable $ic;
    public static final a f;
    public transient /* synthetic */ FieldHolder $fh;
    public final vr a;
    public final byte[] b;
    public final int c;
    public final byte[] d;
    public final List<ur> e;

    /* loaded from: classes6.dex */
    public static final class a {
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

        @JvmStatic
        public final wr a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (str == null || TextUtils.isEmpty(str)) {
                    return null;
                }
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("get raw data:" + str);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    vr.b bVar = vr.c;
                    String optString = jSONObject.optString("Random");
                    Intrinsics.checkExpressionValueIsNotNull(optString, "dataObj.optString(\"Random\")");
                    vr b = bVar.b(optString);
                    String optString2 = jSONObject.optString("CipherSuite");
                    int optInt = jSONObject.optInt("LifeTime");
                    String optString3 = jSONObject.optString("SKR");
                    LinkedList linkedList = new LinkedList();
                    JSONArray optJSONArray = jSONObject.optJSONArray("Extensions");
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            String item = optJSONArray.optString(i);
                            ur.b bVar2 = ur.c;
                            Intrinsics.checkExpressionValueIsNotNull(item, "item");
                            ur b2 = bVar2.b(item);
                            if (b2 != null) {
                                linkedList.add(b2);
                            }
                        }
                    }
                    return new wr(b, vt.b(optString2), optInt, vt.b(optString3), linkedList);
                } catch (Exception e) {
                    e.printStackTrace();
                    DebugTrace debugTrace2 = DebugTrace.a;
                    debugTrace2.a("can not parse server hello:" + e.getMessage());
                    return null;
                }
            }
            return (wr) invokeL.objValue;
        }

        @JvmStatic
        public final wr b(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr)) == null) ? a(vt.a(bArr)) : (wr) invokeL.objValue;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448321074, "Lcom/baidu/tieba/wr;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448321074, "Lcom/baidu/tieba/wr;");
                return;
            }
        }
        f = new a(null);
    }

    public wr(vr vrVar, byte[] bArr, int i, byte[] bArr2, List<ur> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vrVar, bArr, Integer.valueOf(i), bArr2, list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = vrVar;
        this.b = bArr;
        this.c = i;
        this.d = bArr2;
        this.e = list;
    }

    @JvmStatic
    public static final wr a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) ? f.b(bArr) : (wr) invokeL.objValue;
    }

    public final List<ur> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.e : (List) invokeV.objValue;
    }

    public final int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : invokeV.intValue;
    }

    public final byte[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? vt.d(this.b) : (byte[]) invokeV.objValue;
    }

    public final byte[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? vt.d(this.d) : (byte[]) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof wr) {
                    wr wrVar = (wr) obj;
                    if (Intrinsics.areEqual(this.a, wrVar.a) && Intrinsics.areEqual(this.b, wrVar.b)) {
                        if (!(this.c == wrVar.c) || !Intrinsics.areEqual(this.d, wrVar.d) || !Intrinsics.areEqual(this.e, wrVar.e)) {
                        }
                    }
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            vr vrVar = this.a;
            int hashCode = (vrVar != null ? vrVar.hashCode() : 0) * 31;
            byte[] bArr = this.b;
            int hashCode2 = (((hashCode + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31) + this.c) * 31;
            byte[] bArr2 = this.d;
            int hashCode3 = (hashCode2 + (bArr2 != null ? Arrays.hashCode(bArr2) : 0)) * 31;
            List<ur> list = this.e;
            return hashCode3 + (list != null ? list.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "ServerHello(random=" + this.a + ", cipherSuiteBytes=" + Arrays.toString(this.b) + ", lifeTime=" + this.c + ", SKRBytes=" + Arrays.toString(this.d) + ", extensions=" + this.e + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }
}
