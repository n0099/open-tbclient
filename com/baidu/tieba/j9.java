package com.baidu.tieba;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.h9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public abstract class j9 extends SQLiteOpenHelper implements h9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h9.a callback;
    public final String databaseName;

    public abstract void clearAllTables(SQLiteDatabase sQLiteDatabase);

    public abstract void createAllTables(SQLiteDatabase sQLiteDatabase);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j9(Context context, String str, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.databaseName = str;
    }

    private void exeCallback(SQLiteDatabase sQLiteDatabase) {
        h9.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, this, sQLiteDatabase) == null) && (aVar = this.callback) != null) {
            aVar.onDatabaseCreated(sQLiteDatabase);
        }
    }

    @Override // com.baidu.tieba.h9
    public boolean dropDatabase(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            return context.deleteDatabase(this.databaseName);
        }
        return invokeL.booleanValue;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sQLiteDatabase) == null) {
            createAllTables(sQLiteDatabase);
            exeCallback(sQLiteDatabase);
        }
    }

    @Override // com.baidu.tieba.h9
    public void setOnCreateCallback(h9.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.callback = aVar;
        }
    }

    public boolean executeDDLSqlIgnoreAnyErrors(SQLiteDatabase sQLiteDatabase, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, sQLiteDatabase, str)) == null) {
            try {
                sQLiteDatabase.execSQL(str);
                return true;
            } catch (Throwable th) {
                BdLog.e(str + ":" + th.getMessage());
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, sQLiteDatabase, i, i2) == null) {
            clearAllTables(sQLiteDatabase);
            createAllTables(sQLiteDatabase);
        }
    }
}
