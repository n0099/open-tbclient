package com.baidu.tieba;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.swan.apps.database.subscribe.SwanAppSubscribeMsgProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public final class jb2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS swanapp_subscribe_msg(_id INTEGER PRIMARY KEY AUTOINCREMENT,appKey varchar(100) NOT NULL,templateId varchar(50) NOT NULL,title varchar(100) NOT NULL,tips TEXT,result TINYINT default 0);");
            } catch (Exception e) {
                e12.d("SwanAppSubscribeMsg", "createTable", e);
            }
        }
    }

    @WorkerThread
    public static void b(@Nullable String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, strArr) == null) {
            Application c = ln2.c();
            if (c != null && strArr != null) {
                StringBuilder sb = new StringBuilder();
                int length = strArr.length;
                for (int i = 0; i < length; i++) {
                    String str = strArr[i];
                    if (!TextUtils.isEmpty(str)) {
                        sb.append(str);
                        if (i < length - 1) {
                            sb.append(",");
                        }
                    }
                }
                int delete = c.getContentResolver().delete(SwanAppSubscribeMsgProvider.c, "appKey in (?)", new String[]{sb.toString()});
                e12.i("SwanAppSubscribeMsg", "deleteAllByAppKey count=" + delete + ", appKey=" + sb.toString());
                return;
            }
            e12.o("SwanAppSubscribeMsg", "deleteAllByAppKey fail");
        }
    }
}
