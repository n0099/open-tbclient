package com.baidu.tieba;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class nm1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public nm1(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(int i, String str) {
        InterceptResult invokeIL;
        String str2;
        Uri parse;
        Cursor query;
        StringBuilder sb;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, str)) == null) {
            if (i != 0) {
                if (i == 1) {
                    sb = new StringBuilder();
                    str3 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_";
                } else if (i != 2) {
                    parse = null;
                    query = this.a.getContentResolver().query(parse, null, null, null, null);
                    if (query != null) {
                        r0 = query.moveToNext() ? query.getString(query.getColumnIndex("value")) : null;
                        query.close();
                    }
                    return r0;
                } else {
                    sb = new StringBuilder();
                    str3 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_";
                }
                sb.append(str3);
                sb.append(str);
                str2 = sb.toString();
            } else {
                str2 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID";
            }
            parse = Uri.parse(str2);
            query = this.a.getContentResolver().query(parse, null, null, null, null);
            if (query != null) {
            }
            return r0;
        }
        return (String) invokeIL.objValue;
    }
}
