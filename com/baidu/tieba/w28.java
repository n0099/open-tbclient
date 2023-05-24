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
import org.apache.commons.codec.net.RFC1522Codec;
/* loaded from: classes8.dex */
public class w28 extends l28 {
    public static /* synthetic */ Interceptable $ic = null;
    public static l28 d = null;
    public static String e = "tb_oficial_msg_";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948218796, "Lcom/baidu/tieba/w28;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948218796, "Lcom/baidu/tieba/w28;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w28() {
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

    public static synchronized w28 w() {
        InterceptResult invokeV;
        w28 w28Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (w28.class) {
                if (d == null) {
                    d = new w28();
                }
                w28Var = (w28) d;
            }
            return w28Var;
        }
        return (w28) invokeV.objValue;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00b5: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:29:0x00b5 */
    public static List<a38> x() {
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
                    cursor = s28.d().e("SELECT * FROM tb_message_center WHERE custom_group_type = ? AND (user_type = ? OR user_type = ?) ORDER BY visit_time DESC, last_content_time DESC", new String[]{String.valueOf(4), String.valueOf(3), String.valueOf(1)});
                    if (cursor != null) {
                        try {
                            arrayList = new ArrayList(cursor.getCount());
                            while (cursor.moveToNext()) {
                                try {
                                    a38 a38Var = new a38();
                                    a38Var.h(cursor.getString(cursor.getColumnIndex(TbEnum.ParamKey.GID)));
                                    a38Var.j(cursor.getInt(cursor.getColumnIndex("unread_count")));
                                    a38Var.i(cursor.getString(cursor.getColumnIndex("group_head")));
                                    a38Var.g(cursor.getString(cursor.getColumnIndex("group_name")));
                                    a38Var.k(cursor.getInt(cursor.getColumnIndex("user_type")));
                                    int columnIndex = cursor.getColumnIndex("visit_time");
                                    if (columnIndex >= 0) {
                                        a38Var.l(cursor.getLong(columnIndex));
                                    }
                                    arrayList.add(a38Var);
                                } catch (Exception e3) {
                                    e2 = e3;
                                    e2.printStackTrace();
                                    TiebaStatic.printDBExceptionLog(e2, "ImMessageCenterDao.getOfficalListFromDb", new Object[0]);
                                    si.a(cursor);
                                    return arrayList;
                                }
                            }
                            arrayList2 = arrayList;
                        } catch (Exception e4) {
                            arrayList = null;
                            e2 = e4;
                        }
                    }
                    si.a(cursor);
                    return arrayList2;
                } catch (Throwable th) {
                    th = th;
                    cursor3 = cursor2;
                    si.a(cursor3);
                    throw th;
                }
            } catch (Exception e5) {
                arrayList = null;
                e2 = e5;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                si.a(cursor3);
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
                    s28 d2 = s28.d();
                    cursor = d2.e("SELECT * FROM tb_message_center WHERE  custom_group_type" + RFC1522Codec.PREFIX + " AND (user_type" + RFC1522Codec.PREFIX + " OR user_type=?) ORDER BY last_content_time ASC", new String[]{String.valueOf(4), String.valueOf(3), String.valueOf(1)});
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
                si.a(cursor);
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
                s28 d2 = s28.d();
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
                int update = s28.d().update("tb_message_center", contentValues, "gid = ?", new String[]{String.valueOf(j)});
                BdLog.d("updateReadCount result = " + update);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
