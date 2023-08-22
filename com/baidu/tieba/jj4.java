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
/* loaded from: classes6.dex */
public class jj4 extends dj4<ek4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public jj4() {
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
    @Override // com.baidu.tieba.dj4
    /* renamed from: g */
    public ek4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cursor)) == null) {
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                return h(cursor);
            }
            return null;
        }
        return (ek4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.dj4
    public List<ek4> e(Cursor cursor) {
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
    @Override // com.baidu.tieba.dj4
    /* renamed from: f */
    public ContentValues c(ek4 ek4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ek4Var)) == null) {
            ContentValues a = super.a(ek4Var);
            a.put("max_age", Long.valueOf(ek4Var.o));
            a.put("token", ek4Var.p);
            a.put("domains", ek4Var.q);
            a.put(GameGuideConfigInfo.KEY_APP_KEY, ek4Var.r);
            a.put("app_name", ek4Var.s);
            return a;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final ek4 h(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cursor)) == null) {
            if (cursor != null) {
                int columnIndex = cursor.getColumnIndex("max_age");
                int columnIndex2 = cursor.getColumnIndex("token");
                int columnIndex3 = cursor.getColumnIndex("domains");
                int columnIndex4 = cursor.getColumnIndex(GameGuideConfigInfo.KEY_APP_KEY);
                int columnIndex5 = cursor.getColumnIndex("app_name");
                ek4 ek4Var = new ek4();
                if (b(cursor, ek4Var)) {
                    ek4Var.o = cursor.getLong(columnIndex);
                    ek4Var.p = cursor.getString(columnIndex2);
                    ek4Var.q = cursor.getString(columnIndex3);
                    ek4Var.r = cursor.getString(columnIndex4);
                    ek4Var.s = cursor.getString(columnIndex5);
                    return ek4Var;
                }
                return null;
            }
            return null;
        }
        return (ek4) invokeL.objValue;
    }
}
