package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class yb8 extends mb8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static mb8 d = null;
    public static String e = "tb_oficial_msg_";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948324506, "Lcom/baidu/tieba/yb8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948324506, "Lcom/baidu/tieba/yb8;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yb8() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], (Class) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static synchronized yb8 w() {
        InterceptResult invokeV;
        yb8 yb8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (yb8.class) {
                if (d == null) {
                    d = new yb8();
                }
                yb8Var = (yb8) d;
            }
            return yb8Var;
        }
        return (yb8) invokeV.objValue;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00b5: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:29:0x00b5 */
    public static List<cc8> x() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Exception e2;
        Cursor cursor;
        Cursor cursor2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            Cursor cursor3 = null;
            ArrayList arrayList2 = null;
            try {
                try {
                    cursor = ub8.d().e("SELECT * FROM tb_message_center WHERE custom_group_type = ? AND (user_type = ? OR user_type = ?) ORDER BY visit_time DESC, last_content_time DESC", new String[]{String.valueOf(4), String.valueOf(3), String.valueOf(1)});
                    if (cursor != null) {
                        try {
                            arrayList = new ArrayList(cursor.getCount());
                            while (cursor.moveToNext()) {
                                try {
                                    cc8 cc8Var = new cc8();
                                    cc8Var.h(cursor.getString(cursor.getColumnIndex(TbEnum.ParamKey.GID)));
                                    cc8Var.j(cursor.getInt(cursor.getColumnIndex("unread_count")));
                                    cc8Var.i(cursor.getString(cursor.getColumnIndex("group_head")));
                                    cc8Var.g(cursor.getString(cursor.getColumnIndex("group_name")));
                                    cc8Var.k(cursor.getInt(cursor.getColumnIndex("user_type")));
                                    int columnIndex = cursor.getColumnIndex("visit_time");
                                    if (columnIndex >= 0) {
                                        cc8Var.l(cursor.getLong(columnIndex));
                                    }
                                    arrayList.add(cc8Var);
                                } catch (Exception e3) {
                                    e2 = e3;
                                    e2.printStackTrace();
                                    TiebaStatic.printDBExceptionLog(e2, "ImMessageCenterDao.getOfficalListFromDb", new Object[0]);
                                    ci.a(cursor);
                                    return arrayList;
                                }
                            }
                            arrayList2 = arrayList;
                        } catch (Exception e4) {
                            arrayList = null;
                            e2 = e4;
                        }
                    }
                    ci.a(cursor);
                    return arrayList2;
                } catch (Throwable th) {
                    th = th;
                    cursor3 = cursor2;
                    ci.a(cursor3);
                    throw th;
                }
            } catch (Exception e5) {
                arrayList = null;
                e2 = e5;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                ci.a(cursor3);
                throw th;
            }
        } else {
            return (List) invokeV.objValue;
        }
    }

    public static List<String> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            ArrayList arrayList = new ArrayList();
            Cursor cursor = null;
            try {
                try {
                    ub8 d2 = ub8.d();
                    cursor = d2.e("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND (user_type=? OR user_type=?) ORDER BY last_content_time ASC", new String[]{String.valueOf(4), String.valueOf(3), String.valueOf(1)});
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            arrayList.add(cursor.getString(cursor.getColumnIndex(TbEnum.ParamKey.GID)));
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    TiebaStatic.printDBExceptionLog(e2, "ImMessageCenterDao.getOfficalListFromDb", new Object[0]);
                }
                return arrayList;
            } finally {
                ci.a(cursor);
            }
        }
        return (List) invokeV.objValue;
    }

    public void A(long j, long j2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}) == null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("read_count", Integer.valueOf(i));
                ub8 d2 = ub8.d();
                int update = d2.update(e + j, contentValues, "mid = ?", new String[]{String.valueOf(j2)});
                BdLog.d("updateReadCount result = " + update);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void z(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("visit_time", Long.valueOf(j2));
                contentValues.put("unread_count", (Integer) 0);
                int update = ub8.d().update("tb_message_center", contentValues, "gid = ?", new String[]{String.valueOf(j)});
                BdLog.d("updateReadCount result = " + update);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
