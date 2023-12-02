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
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class ke4<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract ContentValues c(T t);

    public abstract T d(Cursor cursor) throws SQLException;

    public abstract List<T> e(Cursor cursor) throws SQLException;

    public ke4() {
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

    public ContentValues a(if4 if4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, if4Var)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("bundle_id", if4Var.g);
            contentValues.put("category", Integer.valueOf(if4Var.h));
            contentValues.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, if4Var.j);
            contentValues.put("version_code", Long.valueOf(if4Var.i));
            contentValues.put("size", Long.valueOf(if4Var.k));
            contentValues.put("md5", if4Var.l);
            contentValues.put("sign", if4Var.m);
            contentValues.put("downloadUrl", if4Var.n);
            contentValues.put(PackageTable.FILE_PATH, if4Var.a);
            contentValues.put(PackageTable.CURRENT_SIZE, Long.valueOf(if4Var.b));
            contentValues.put("create_time", Long.valueOf(if4Var.c));
            contentValues.put("update_time", Long.valueOf(if4Var.d));
            contentValues.put("state", Integer.valueOf(if4Var.e));
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public boolean b(Cursor cursor, if4 if4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cursor, if4Var)) == null) {
            if (cursor != null) {
                int columnIndex = cursor.getColumnIndex("bundle_id");
                int columnIndex2 = cursor.getColumnIndex("category");
                int columnIndex3 = cursor.getColumnIndex(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
                int columnIndex4 = cursor.getColumnIndex("version_code");
                int columnIndex5 = cursor.getColumnIndex("size");
                int columnIndex6 = cursor.getColumnIndex("md5");
                int columnIndex7 = cursor.getColumnIndex("sign");
                int columnIndex8 = cursor.getColumnIndex("downloadUrl");
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
                if4Var.g = string;
                if4Var.h = cursor.getInt(columnIndex2);
                if4Var.j = cursor.getString(columnIndex3);
                if4Var.i = cursor.getLong(columnIndex4);
                if4Var.k = cursor.getLong(columnIndex5);
                if4Var.l = cursor.getString(columnIndex6);
                if4Var.m = cursor.getString(columnIndex7);
                if4Var.n = cursor.getString(columnIndex8);
                if4Var.a = cursor.getString(columnIndex10);
                if4Var.b = cursor.getLong(columnIndex11);
                if4Var.c = cursor.getLong(columnIndex12);
                if4Var.d = cursor.getLong(columnIndex13);
                if4Var.f = cursor.getLong(columnIndex9);
                if4Var.e = cursor.getInt(columnIndex14);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
