package com.baidu.tieba;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class xj4 extends SQLiteOpenHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static volatile xj4 b = null;
    public static final int c = 12;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<Class<?>, pj4> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948302279, "Lcom/baidu/tieba/xj4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948302279, "Lcom/baidu/tieba/xj4;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public xj4() {
        this("ai_apps_pms.db", c);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((String) objArr[0], ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xj4(String str, int i) {
        super(AppRuntime.getAppContext(), str, null, i, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue(), (DatabaseErrorHandler) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public static xj4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (b == null) {
                synchronized (xj4.class) {
                    if (b == null) {
                        b = new xj4();
                    }
                }
            }
            return b;
        }
        return (xj4) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b = null;
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ConcurrentHashMap<Class<?>, pj4> concurrentHashMap = new ConcurrentHashMap<>();
            this.a = concurrentHashMap;
            concurrentHashMap.put(gk4.class, new tj4());
            this.a.put(hk4.class, new uj4());
            this.a.put(PMSAppInfo.class, new qj4());
            this.a.put(ek4.class, new sj4());
            this.a.put(ck4.class, new rj4());
            this.a.put(ik4.class, new vj4());
            this.a.put(jk4.class, new wj4());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase) == null) {
            for (pj4 pj4Var : this.a.values()) {
                pj4Var.a(sQLiteDatabase);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048579, this, sQLiteDatabase, i, i2) == null) {
            for (pj4 pj4Var : this.a.values()) {
                pj4Var.onUpgrade(sQLiteDatabase, i, i2);
            }
        }
    }
}
