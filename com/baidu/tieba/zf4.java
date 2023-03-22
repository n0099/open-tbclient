package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class zf4 extends tf4<ug4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public zf4() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tf4
    /* renamed from: g */
    public ug4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cursor)) == null) {
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                return h(cursor);
            }
            return null;
        }
        return (ug4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.tf4
    public List<ug4> e(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cursor)) == null) {
            ArrayList arrayList = new ArrayList();
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                do {
                    arrayList.add(h(cursor));
                } while (cursor.moveToNext());
                return arrayList;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tf4
    /* renamed from: f */
    public ContentValues c(ug4 ug4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ug4Var)) == null) {
            ContentValues a = super.a(ug4Var);
            a.put("max_age", Long.valueOf(ug4Var.o));
            a.put("token", ug4Var.p);
            a.put("domains", ug4Var.q);
            a.put(GameGuideConfigInfo.KEY_APP_KEY, ug4Var.r);
            a.put("app_name", ug4Var.s);
            return a;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final ug4 h(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cursor)) == null) {
            if (cursor != null) {
                int columnIndex = cursor.getColumnIndex("max_age");
                int columnIndex2 = cursor.getColumnIndex("token");
                int columnIndex3 = cursor.getColumnIndex("domains");
                int columnIndex4 = cursor.getColumnIndex(GameGuideConfigInfo.KEY_APP_KEY);
                int columnIndex5 = cursor.getColumnIndex("app_name");
                ug4 ug4Var = new ug4();
                if (b(cursor, ug4Var)) {
                    ug4Var.o = cursor.getLong(columnIndex);
                    ug4Var.p = cursor.getString(columnIndex2);
                    ug4Var.q = cursor.getString(columnIndex3);
                    ug4Var.r = cursor.getString(columnIndex4);
                    ug4Var.s = cursor.getString(columnIndex5);
                    return ug4Var;
                }
                return null;
            }
            return null;
        }
        return (ug4) invokeL.objValue;
    }
}
