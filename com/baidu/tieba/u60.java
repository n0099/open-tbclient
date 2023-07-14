package com.baidu.tieba;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.baidu.tieba.r60;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class u60 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, r60.a aVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, context, aVar) == null) {
            if (context == null) {
                aVar.a(false, null);
                return;
            }
            try {
                Cursor query = context.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
                if (query != null) {
                    str = query.moveToNext() ? query.getString(query.getColumnIndex("value")) : null;
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
