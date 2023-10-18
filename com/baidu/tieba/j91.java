package com.baidu.tieba;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class j91 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    public abstract boolean b(SQLiteDatabase sQLiteDatabase);

    public j91() {
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
        this.a = false;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    public void c(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase) == null) {
            this.a = false;
            try {
                sQLiteDatabase.beginTransaction();
                if (b(sQLiteDatabase)) {
                    sQLiteDatabase.setTransactionSuccessful();
                    this.a = true;
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception unused2) {
                }
                throw th;
            }
            try {
                sQLiteDatabase.endTransaction();
            } catch (Exception unused3) {
            }
        }
    }
}
