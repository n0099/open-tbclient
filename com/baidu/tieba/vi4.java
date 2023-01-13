package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes6.dex */
public class vi4<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public static Object[] d;
    public static int e;
    public static Object[] f;
    public static int g;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] a;
    public Object[] b;
    public int c;

    public vi4() {
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
        this.a = ri4.a;
        this.b = ri4.b;
        this.c = 0;
    }

    public void clear() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (i = this.c) != 0) {
            c(this.a, this.b, i);
            this.a = ri4.a;
            this.b = ri4.b;
            this.c = 0;
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        int hashCode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int[] iArr = this.a;
            Object[] objArr = this.b;
            int i = this.c;
            int i2 = 1;
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                Object obj = objArr[i2];
                int i5 = iArr[i3];
                if (obj == null) {
                    hashCode = 0;
                } else {
                    hashCode = obj.hashCode();
                }
                i4 += hashCode ^ i5;
                i3++;
                i2 += 2;
            }
            return i4;
        }
        return invokeV.intValue;
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.c <= 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public static void c(int[] iArr, Object[] objArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65537, null, iArr, objArr, i) == null) {
            if (iArr.length == 8) {
                synchronized (qi4.class) {
                    if (g < 10) {
                        objArr[0] = f;
                        objArr[1] = iArr;
                        for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                            objArr[i2] = null;
                        }
                        f = objArr;
                        g++;
                    }
                }
            } else if (iArr.length == 4) {
                synchronized (qi4.class) {
                    if (e < 10) {
                        objArr[0] = d;
                        objArr[1] = iArr;
                        for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                            objArr[i3] = null;
                        }
                        d = objArr;
                        e++;
                    }
                }
            }
        }
    }

    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (i == 8) {
                synchronized (qi4.class) {
                    if (f != null) {
                        Object[] objArr = f;
                        this.b = objArr;
                        f = (Object[]) objArr[0];
                        this.a = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        g--;
                        return;
                    }
                }
            } else if (i == 4) {
                synchronized (qi4.class) {
                    if (d != null) {
                        Object[] objArr2 = d;
                        this.b = objArr2;
                        d = (Object[]) objArr2[0];
                        this.a = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        e--;
                        return;
                    }
                }
            }
            this.a = new int[i];
            this.b = new Object[i << 1];
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            int[] iArr = this.a;
            if (iArr.length < i) {
                Object[] objArr = this.b;
                a(i);
                int i2 = this.c;
                if (i2 > 0) {
                    System.arraycopy(iArr, 0, this.a, 0, i2);
                    System.arraycopy(objArr, 0, this.b, 0, this.c << 1);
                }
                c(iArr, objArr, this.c);
            }
        }
    }

    public boolean containsKey(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (e(obj) >= 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean containsValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (g(obj) >= 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int e(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj == null) {
                return f();
            }
            return d(obj, obj.hashCode());
        }
        return invokeL.intValue;
    }

    public V get(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) {
            int e2 = e(obj);
            if (e2 >= 0) {
                return (V) this.b[(e2 << 1) + 1];
            }
            return null;
        }
        return (V) invokeL.objValue;
    }

    public K h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            return (K) this.b[i << 1];
        }
        return (K) invokeI.objValue;
    }

    public V k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            return (V) this.b[(i << 1) + 1];
        }
        return (V) invokeI.objValue;
    }

    public V remove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, obj)) == null) {
            int e2 = e(obj);
            if (e2 >= 0) {
                return i(e2);
            }
            return null;
        }
        return (V) invokeL.objValue;
    }

    public int d(Object obj, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, obj, i)) == null) {
            int i2 = this.c;
            if (i2 == 0) {
                return -1;
            }
            int a = ri4.a(this.a, i2, i);
            if (a < 0) {
                return a;
            }
            if (obj.equals(this.b[a << 1])) {
                return a;
            }
            int i3 = a + 1;
            while (i3 < i2 && this.a[i3] == i) {
                if (obj.equals(this.b[i3 << 1])) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = a - 1; i4 >= 0 && this.a[i4] == i; i4--) {
                if (obj.equals(this.b[i4 << 1])) {
                    return i4;
                }
            }
            return ~i3;
        }
        return invokeLI.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Map) {
                Map map = (Map) obj;
                if (size() != map.size()) {
                    return false;
                }
                for (int i = 0; i < this.c; i++) {
                    try {
                        K h = h(i);
                        V k = k(i);
                        Object obj2 = map.get(h);
                        if (k == null) {
                            if (obj2 != null || !map.containsKey(h)) {
                                return false;
                            }
                        } else if (!k.equals(obj2)) {
                            return false;
                        }
                    } catch (ClassCastException | NullPointerException unused) {
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int i = this.c;
            if (i == 0) {
                return -1;
            }
            int a = ri4.a(this.a, i, 0);
            if (a < 0) {
                return a;
            }
            if (this.b[a << 1] == null) {
                return a;
            }
            int i2 = a + 1;
            while (i2 < i && this.a[i2] == 0) {
                if (this.b[i2 << 1] == null) {
                    return i2;
                }
                i2++;
            }
            for (int i3 = a - 1; i3 >= 0 && this.a[i3] == 0; i3--) {
                if (this.b[i3 << 1] == null) {
                    return i3;
                }
            }
            return ~i2;
        }
        return invokeV.intValue;
    }

    public int g(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
            int i = this.c * 2;
            Object[] objArr = this.b;
            if (obj == null) {
                for (int i2 = 1; i2 < i; i2 += 2) {
                    if (objArr[i2] == null) {
                        return i2 >> 1;
                    }
                }
                return -1;
            }
            for (int i3 = 1; i3 < i; i3 += 2) {
                if (obj.equals(objArr[i3])) {
                    return i3 >> 1;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public V i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            Object[] objArr = this.b;
            int i2 = i << 1;
            V v = (V) objArr[i2 + 1];
            int i3 = this.c;
            if (i3 <= 1) {
                c(this.a, objArr, i3);
                this.a = ri4.a;
                this.b = ri4.b;
                this.c = 0;
            } else {
                int[] iArr = this.a;
                int i4 = 8;
                if (iArr.length > 8 && i3 < iArr.length / 3) {
                    if (i3 > 8) {
                        i4 = i3 + (i3 >> 1);
                    }
                    int[] iArr2 = this.a;
                    Object[] objArr2 = this.b;
                    a(i4);
                    this.c--;
                    if (i > 0) {
                        System.arraycopy(iArr2, 0, this.a, 0, i);
                        System.arraycopy(objArr2, 0, this.b, 0, i2);
                    }
                    int i5 = this.c;
                    if (i < i5) {
                        int i6 = i + 1;
                        System.arraycopy(iArr2, i6, this.a, i, i5 - i);
                        System.arraycopy(objArr2, i6 << 1, this.b, i2, (this.c - i) << 1);
                    }
                } else {
                    int i7 = this.c - 1;
                    this.c = i7;
                    if (i < i7) {
                        int[] iArr3 = this.a;
                        int i8 = i + 1;
                        System.arraycopy(iArr3, i8, iArr3, i, i7 - i);
                        Object[] objArr3 = this.b;
                        System.arraycopy(objArr3, i8 << 1, objArr3, i2, (this.c - i) << 1);
                    }
                    Object[] objArr4 = this.b;
                    int i9 = this.c;
                    objArr4[i9 << 1] = null;
                    objArr4[(i9 << 1) + 1] = null;
                }
            }
            return v;
        }
        return (V) invokeI.objValue;
    }

    public V j(int i, V v) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048591, this, i, v)) == null) {
            int i2 = (i << 1) + 1;
            Object[] objArr = this.b;
            V v2 = (V) objArr[i2];
            objArr[i2] = v;
            return v2;
        }
        return (V) invokeIL.objValue;
    }

    public V put(K k, V v) {
        InterceptResult invokeLL;
        int i;
        int d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, k, v)) == null) {
            if (k == null) {
                d2 = f();
                i = 0;
            } else {
                int hashCode = k.hashCode();
                i = hashCode;
                d2 = d(k, hashCode);
            }
            if (d2 >= 0) {
                int i2 = (d2 << 1) + 1;
                Object[] objArr = this.b;
                V v2 = (V) objArr[i2];
                objArr[i2] = v;
                return v2;
            }
            int i3 = ~d2;
            int i4 = this.c;
            if (i4 >= this.a.length) {
                int i5 = 4;
                if (i4 >= 8) {
                    i5 = (i4 >> 1) + i4;
                } else if (i4 >= 4) {
                    i5 = 8;
                }
                int[] iArr = this.a;
                Object[] objArr2 = this.b;
                a(i5);
                int[] iArr2 = this.a;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr2, 0, this.b, 0, objArr2.length);
                }
                c(iArr, objArr2, this.c);
            }
            int i6 = this.c;
            if (i3 < i6) {
                int[] iArr3 = this.a;
                int i7 = i3 + 1;
                System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
                Object[] objArr3 = this.b;
                System.arraycopy(objArr3, i3 << 1, objArr3, i7 << 1, (this.c - i3) << 1);
            }
            this.a[i3] = i;
            Object[] objArr4 = this.b;
            int i8 = i3 << 1;
            objArr4[i8] = k;
            objArr4[i8 + 1] = v;
            this.c++;
            return null;
        }
        return (V) invokeLL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (isEmpty()) {
                return StringUtil.EMPTY_ARRAY;
            }
            StringBuilder sb = new StringBuilder(this.c * 28);
            sb.append('{');
            for (int i = 0; i < this.c; i++) {
                if (i > 0) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                K h = h(i);
                if (h != this) {
                    sb.append(h);
                } else {
                    sb.append("(this Map)");
                }
                sb.append(com.alipay.sdk.encrypt.a.h);
                V k = k(i);
                if (k != this) {
                    sb.append(k);
                } else {
                    sb.append("(this Map)");
                }
            }
            sb.append('}');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
