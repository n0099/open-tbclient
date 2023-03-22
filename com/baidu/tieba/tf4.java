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
/* loaded from: classes6.dex */
public abstract class tf4<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract ContentValues c(T t);

    public abstract T d(Cursor cursor) throws SQLException;

    public abstract List<T> e(Cursor cursor) throws SQLException;

    public tf4() {
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

    public ContentValues a(rg4 rg4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rg4Var)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("bundle_id", rg4Var.g);
            contentValues.put("category", Integer.valueOf(rg4Var.h));
            contentValues.put("version_name", rg4Var.j);
            contentValues.put("version_code", Long.valueOf(rg4Var.i));
            contentValues.put("size", Long.valueOf(rg4Var.k));
            contentValues.put(PackageTable.MD5, rg4Var.l);
            contentValues.put("sign", rg4Var.m);
            contentValues.put(TTDownloadField.TT_DOWNLOAD_URL, rg4Var.n);
            contentValues.put(PackageTable.FILE_PATH, rg4Var.a);
            contentValues.put(PackageTable.CURRENT_SIZE, Long.valueOf(rg4Var.b));
            contentValues.put("create_time", Long.valueOf(rg4Var.c));
            contentValues.put("update_time", Long.valueOf(rg4Var.d));
            contentValues.put("state", Integer.valueOf(rg4Var.e));
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public boolean b(Cursor cursor, rg4 rg4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cursor, rg4Var)) == null) {
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
                rg4Var.g = string;
                rg4Var.h = cursor.getInt(columnIndex2);
                rg4Var.j = cursor.getString(columnIndex3);
                rg4Var.i = cursor.getLong(columnIndex4);
                rg4Var.k = cursor.getLong(columnIndex5);
                rg4Var.l = cursor.getString(columnIndex6);
                rg4Var.m = cursor.getString(columnIndex7);
                rg4Var.n = cursor.getString(columnIndex8);
                rg4Var.a = cursor.getString(columnIndex10);
                rg4Var.b = cursor.getLong(columnIndex11);
                rg4Var.c = cursor.getLong(columnIndex12);
                rg4Var.d = cursor.getLong(columnIndex13);
                rg4Var.f = cursor.getLong(columnIndex9);
                rg4Var.e = cursor.getInt(columnIndex14);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
