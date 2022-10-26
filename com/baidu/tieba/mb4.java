package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class mb4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract ContentValues c(Object obj);

    public abstract Object d(Cursor cursor) throws SQLException;

    public abstract List e(Cursor cursor) throws SQLException;

    public mb4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public ContentValues a(kc4 kc4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, kc4Var)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("bundle_id", kc4Var.g);
            contentValues.put("category", Integer.valueOf(kc4Var.h));
            contentValues.put("version_name", kc4Var.j);
            contentValues.put("version_code", Long.valueOf(kc4Var.i));
            contentValues.put("size", Long.valueOf(kc4Var.k));
            contentValues.put(PackageTable.MD5, kc4Var.l);
            contentValues.put("sign", kc4Var.m);
            contentValues.put(TTDownloadField.TT_DOWNLOAD_URL, kc4Var.n);
            contentValues.put(PackageTable.FILE_PATH, kc4Var.a);
            contentValues.put(PackageTable.CURRENT_SIZE, Long.valueOf(kc4Var.b));
            contentValues.put("create_time", Long.valueOf(kc4Var.c));
            contentValues.put("update_time", Long.valueOf(kc4Var.d));
            contentValues.put("state", Integer.valueOf(kc4Var.e));
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public boolean b(Cursor cursor, kc4 kc4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cursor, kc4Var)) == null) {
            if (cursor != null) {
                int columnIndex = cursor.getColumnIndex("bundle_id");
                int columnIndex2 = cursor.getColumnIndex("category");
                int columnIndex3 = cursor.getColumnIndex("version_name");
                int columnIndex4 = cursor.getColumnIndex("version_code");
                int columnIndex5 = cursor.getColumnIndex("size");
                int columnIndex6 = cursor.getColumnIndex(PackageTable.MD5);
                int columnIndex7 = cursor.getColumnIndex("sign");
                int columnIndex8 = cursor.getColumnIndex(TTDownloadField.TT_DOWNLOAD_URL);
                int columnIndex9 = cursor.getColumnIndex("_id");
                int columnIndex10 = cursor.getColumnIndex(PackageTable.FILE_PATH);
                int columnIndex11 = cursor.getColumnIndex(PackageTable.CURRENT_SIZE);
                int columnIndex12 = cursor.getColumnIndex("create_time");
                int columnIndex13 = cursor.getColumnIndex("update_time");
                int columnIndex14 = cursor.getColumnIndex("state");
                String string = cursor.getString(columnIndex);
                if (TextUtils.isEmpty(string)) {
                    return false;
                }
                kc4Var.g = string;
                kc4Var.h = cursor.getInt(columnIndex2);
                kc4Var.j = cursor.getString(columnIndex3);
                kc4Var.i = cursor.getLong(columnIndex4);
                kc4Var.k = cursor.getLong(columnIndex5);
                kc4Var.l = cursor.getString(columnIndex6);
                kc4Var.m = cursor.getString(columnIndex7);
                kc4Var.n = cursor.getString(columnIndex8);
                kc4Var.a = cursor.getString(columnIndex10);
                kc4Var.b = cursor.getLong(columnIndex11);
                kc4Var.c = cursor.getLong(columnIndex12);
                kc4Var.d = cursor.getLong(columnIndex13);
                kc4Var.f = cursor.getLong(columnIndex9);
                kc4Var.e = cursor.getInt(columnIndex14);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
