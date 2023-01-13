package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class m4 extends f4 {
    public static /* synthetic */ Interceptable $ic;
    public static final long j;
    public static final long k;
    public static final long l;
    public static final long m;
    public static final long n;
    public static final long o;
    public static final long p;
    public static long q;
    public transient /* synthetic */ FieldHolder $fh;
    public final p5<Texture> d;
    public float e;
    public float f;
    public float g;
    public float h;
    public int i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448309542, "Lcom/baidu/tieba/m4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448309542, "Lcom/baidu/tieba/m4;");
                return;
            }
        }
        j = f4.d("diffuseTexture");
        k = f4.d("specularTexture");
        l = f4.d("bumpTexture");
        m = f4.d("normalTexture");
        n = f4.d("ambientTexture");
        o = f4.d("emissiveTexture");
        long d = f4.d("reflectionTexture");
        p = d;
        q = d | j | k | l | m | n | o;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m4(long j2) {
        super(j2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Long) newInitContext.callArgs[0]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 1.0f;
        this.h = 1.0f;
        this.i = 0;
        if (f(j2)) {
            this.d = new p5<>();
            return;
        }
        throw new GdxRuntimeException("Invalid type specified");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public <T extends Texture> m4(long j2, p5<T> p5Var) {
        this(j2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), p5Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this(((Long) newInitContext.callArgs[0]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.d.c(p5Var);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public <T extends Texture> m4(long j2, p5<T> p5Var, float f, float f2, float f3, float f4) {
        this(j2, p5Var, f, f2, f3, f4, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), p5Var, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Long) objArr2[0]).longValue(), (p5) objArr2[1], ((Float) objArr2[2]).floatValue(), ((Float) objArr2[3]).floatValue(), ((Float) objArr2[4]).floatValue(), ((Float) objArr2[5]).floatValue(), ((Integer) objArr2[6]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public <T extends Texture> m4(long j2, p5<T> p5Var, float f, float f2, float f3, float f4, int i) {
        this(j2, p5Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Long.valueOf(j2), p5Var, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(i)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Long) objArr2[0]).longValue(), (p5) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.e = f;
        this.f = f2;
        this.g = f3;
        this.h = f4;
        this.i = i;
    }

    public static final boolean f(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65541, null, j2)) == null) {
            if ((j2 & q) != 0) {
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: e */
    public int compareTo(f4 f4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f4Var)) == null) {
            long j2 = this.a;
            long j3 = f4Var.a;
            if (j2 != j3) {
                if (j2 < j3) {
                    return -1;
                }
                return 1;
            }
            m4 m4Var = (m4) f4Var;
            int compareTo = this.d.compareTo(m4Var.d);
            if (compareTo != 0) {
                return compareTo;
            }
            int i = this.i;
            int i2 = m4Var.i;
            if (i != i2) {
                return i - i2;
            }
            if (!com.badlogic.gdx.math.d.e(this.g, m4Var.g)) {
                if (this.g <= m4Var.g) {
                    return -1;
                }
                return 1;
            } else if (!com.badlogic.gdx.math.d.e(this.h, m4Var.h)) {
                if (this.h <= m4Var.h) {
                    return -1;
                }
                return 1;
            } else if (!com.badlogic.gdx.math.d.e(this.e, m4Var.e)) {
                if (this.e <= m4Var.e) {
                    return -1;
                }
                return 1;
            } else if (!com.badlogic.gdx.math.d.e(this.f, m4Var.f)) {
                if (this.f <= m4Var.f) {
                    return -1;
                }
                return 1;
            } else {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tieba.f4
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (((((((((((super.hashCode() * 991) + this.d.hashCode()) * 991) + v7.b(this.e)) * 991) + v7.b(this.f)) * 991) + v7.b(this.g)) * 991) + v7.b(this.h)) * 991) + this.i;
        }
        return invokeV.intValue;
    }
}
