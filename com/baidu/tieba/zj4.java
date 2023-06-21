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
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.List;
/* loaded from: classes8.dex */
public abstract class zj4<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract ContentValues c(T t);

    public abstract T d(Cursor cursor) throws SQLException;

    public abstract List<T> e(Cursor cursor) throws SQLException;

    public zj4() {
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

    public ContentValues a(xk4 xk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, xk4Var)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("bundle_id", xk4Var.g);
            contentValues.put("category", Integer.valueOf(xk4Var.h));
            contentValues.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, xk4Var.j);
            contentValues.put("version_code", Long.valueOf(xk4Var.i));
            contentValues.put("size", Long.valueOf(xk4Var.k));
            contentValues.put(PackageTable.MD5, xk4Var.l);
            contentValues.put("sign", xk4Var.m);
            contentValues.put(TTDownloadField.TT_DOWNLOAD_URL, xk4Var.n);
            contentValues.put(PackageTable.FILE_PATH, xk4Var.a);
            contentValues.put(PackageTable.CURRENT_SIZE, Long.valueOf(xk4Var.b));
            contentValues.put("create_time", Long.valueOf(xk4Var.c));
            contentValues.put("update_time", Long.valueOf(xk4Var.d));
            contentValues.put("state", Integer.valueOf(xk4Var.e));
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public boolean b(Cursor cursor, xk4 xk4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cursor, xk4Var)) == null) {
            if (cursor != null) {
                int columnIndex = cursor.getColumnIndex("bundle_id");
                int columnIndex2 = cursor.getColumnIndex("category");
                int columnIndex3 = cursor.getColumnIndex(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
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
                xk4Var.g = string;
                xk4Var.h = cursor.getInt(columnIndex2);
                xk4Var.j = cursor.getString(columnIndex3);
                xk4Var.i = cursor.getLong(columnIndex4);
                xk4Var.k = cursor.getLong(columnIndex5);
                xk4Var.l = cursor.getString(columnIndex6);
                xk4Var.m = cursor.getString(columnIndex7);
                xk4Var.n = cursor.getString(columnIndex8);
                xk4Var.a = cursor.getString(columnIndex10);
                xk4Var.b = cursor.getLong(columnIndex11);
                xk4Var.c = cursor.getLong(columnIndex12);
                xk4Var.d = cursor.getLong(columnIndex13);
                xk4Var.f = cursor.getLong(columnIndex9);
                xk4Var.e = cursor.getInt(columnIndex14);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
