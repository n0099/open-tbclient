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
public abstract class yj4<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract ContentValues c(T t);

    public abstract T d(Cursor cursor) throws SQLException;

    public abstract List<T> e(Cursor cursor) throws SQLException;

    public yj4() {
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

    public ContentValues a(wk4 wk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, wk4Var)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("bundle_id", wk4Var.g);
            contentValues.put("category", Integer.valueOf(wk4Var.h));
            contentValues.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, wk4Var.j);
            contentValues.put("version_code", Long.valueOf(wk4Var.i));
            contentValues.put("size", Long.valueOf(wk4Var.k));
            contentValues.put(PackageTable.MD5, wk4Var.l);
            contentValues.put("sign", wk4Var.m);
            contentValues.put(TTDownloadField.TT_DOWNLOAD_URL, wk4Var.n);
            contentValues.put(PackageTable.FILE_PATH, wk4Var.a);
            contentValues.put(PackageTable.CURRENT_SIZE, Long.valueOf(wk4Var.b));
            contentValues.put("create_time", Long.valueOf(wk4Var.c));
            contentValues.put("update_time", Long.valueOf(wk4Var.d));
            contentValues.put("state", Integer.valueOf(wk4Var.e));
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public boolean b(Cursor cursor, wk4 wk4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cursor, wk4Var)) == null) {
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
                wk4Var.g = string;
                wk4Var.h = cursor.getInt(columnIndex2);
                wk4Var.j = cursor.getString(columnIndex3);
                wk4Var.i = cursor.getLong(columnIndex4);
                wk4Var.k = cursor.getLong(columnIndex5);
                wk4Var.l = cursor.getString(columnIndex6);
                wk4Var.m = cursor.getString(columnIndex7);
                wk4Var.n = cursor.getString(columnIndex8);
                wk4Var.a = cursor.getString(columnIndex10);
                wk4Var.b = cursor.getLong(columnIndex11);
                wk4Var.c = cursor.getLong(columnIndex12);
                wk4Var.d = cursor.getLong(columnIndex13);
                wk4Var.f = cursor.getLong(columnIndex9);
                wk4Var.e = cursor.getInt(columnIndex14);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
