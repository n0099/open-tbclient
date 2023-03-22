package com.baidu.tieba;

import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class s3 extends n3 {
    public static /* synthetic */ Interceptable $ic;
    public static final long e;
    public static final long f;
    public static final long g;
    public static final long h;
    public static final long i;
    public static final long j;
    public static final long k;
    public static long l;
    public transient /* synthetic */ FieldHolder $fh;
    public final u2 d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448315277, "Lcom/baidu/tieba/s3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448315277, "Lcom/baidu/tieba/s3;");
                return;
            }
        }
        e = n3.d("diffuseColor");
        f = n3.d("specularColor");
        g = n3.d("ambientColor");
        h = n3.d("emissiveColor");
        i = n3.d("reflectionColor");
        j = n3.d("ambientLightColor");
        long d = n3.d("fogColor");
        k = d;
        l = d | g | e | f | h | i | j;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s3(long j2) {
        super(j2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Long) newInitContext.callArgs[0]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = new u2();
        if (f(j2)) {
            return;
        }
        throw new GdxRuntimeException("Invalid type specified");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public s3(long j2, u2 u2Var) {
        this(j2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), u2Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Long) newInitContext.callArgs[0]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (u2Var != null) {
            this.d.e(u2Var);
        }
    }

    public static final boolean f(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j2)) == null) {
            if ((j2 & l) != 0) {
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: e */
    public int compareTo(n3 n3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n3Var)) == null) {
            long j2 = this.a;
            long j3 = n3Var.a;
            if (j2 != j3) {
                return (int) (j2 - j3);
            }
            return ((s3) n3Var).d.g() - this.d.g();
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tieba.n3
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (super.hashCode() * CyberPlayerManager.DP_MSG_INFO_CACHE_DURATION) + this.d.g();
        }
        return invokeV.intValue;
    }
}
