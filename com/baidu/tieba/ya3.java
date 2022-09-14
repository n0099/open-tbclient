package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes6.dex */
public abstract class ya3 implements cb3 {
    public static /* synthetic */ Interceptable $ic;
    public static final ReadWriteLock c;
    public transient /* synthetic */ FieldHolder $fh;
    public File a;
    public final long b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948323390, "Lcom/baidu/tieba/ya3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948323390, "Lcom/baidu/tieba/ya3;");
                return;
            }
        }
        c = new ReentrantReadWriteLock();
    }

    public ya3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = d();
        this.b = getMaxSize();
    }

    @Override // com.baidu.tieba.cb3
    public boolean a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            c.readLock().lock();
            try {
                return e() + j > this.b;
            } finally {
                c.readLock().unlock();
            }
        }
        return invokeJ.booleanValue;
    }

    @Override // com.baidu.tieba.cb3
    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            c.writeLock().lock();
            try {
                try {
                    if (this.a == null) {
                        this.a = d();
                    }
                    File file = this.a;
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    cj4.O(String.valueOf(e() + j).getBytes(), file);
                } catch (Exception e) {
                    if (ij1.a) {
                        e.printStackTrace();
                    }
                }
            } finally {
                c.writeLock().unlock();
            }
        }
    }

    @NonNull
    public abstract String c();

    public final File d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return new File(c() + File.separator + "record.pro");
        }
        return (File) invokeV.objValue;
    }

    public final long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.a == null) {
                this.a = d();
            }
            File file = this.a;
            if (file.exists() && file.isFile()) {
                String E = cj4.E(file);
                try {
                    if (!TextUtils.isEmpty(E) && TextUtils.isDigitsOnly(E.trim())) {
                        return Long.parseLong(E.trim());
                    }
                } catch (Exception e) {
                    if (ij1.a) {
                        e.printStackTrace();
                    }
                }
            }
            return 0L;
        }
        return invokeV.longValue;
    }
}
