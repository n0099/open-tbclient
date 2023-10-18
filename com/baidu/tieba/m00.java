package com.baidu.tieba;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.baidu.tieba.p00;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class m00 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, p00.a aVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, context, aVar) == null) {
            if (context == null) {
                aVar.a(false, null);
                return;
            }
            try {
                Cursor query = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
                if (query != null) {
                    query.moveToFirst();
                    int columnIndex = query.getColumnIndex("value");
                    str = columnIndex > 0 ? query.getString(columnIndex) : null;
                    query.close();
                } else {
                    str = null;
                }
                aVar.a(true, str);
            } catch (Throwable unused) {
                aVar.a(false, null);
            }
        }
    }
}
