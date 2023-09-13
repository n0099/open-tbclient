package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.db.pojo.ChatSysNotifyPojo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class kf8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] a;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final kf8 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-663023826, "Lcom/baidu/tieba/kf8$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-663023826, "Lcom/baidu/tieba/kf8$b;");
                    return;
                }
            }
            a = new kf8(null);
        }
    }

    public kf8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new int[]{1, 2, 3, 4};
        a();
    }

    public final void c() {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i : this.a) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("scene", Integer.valueOf(i));
                qf8.d().insert("tb_chat_sys_notify", null, contentValues);
            }
        }
    }

    public /* synthetic */ kf8(a aVar) {
        this();
    }

    public static kf8 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (kf8) invokeV.objValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !d() && qf8.d().c("CREATE TABLE IF NOT EXISTS tb_chat_sys_notify(scene INTEGER, content TEXT DEFAULT '没有最新消息', unread_num INTEGER DEFAULT 0);")) {
            c();
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            new LinkedList();
            Cursor cursor = null;
            boolean z = false;
            try {
                try {
                    cursor = qf8.d().e("select * from sqlite_master where type='table'", null);
                } catch (Exception e) {
                    TiebaStatic.printDBExceptionLog(e, "ChatSysNotifyDao.isExistsTable", new Object[0]);
                    e.printStackTrace();
                }
                if (cursor == null) {
                    return false;
                }
                cursor.moveToFirst();
                while (true) {
                    if (!cursor.moveToNext()) {
                        break;
                    } else if ("tb_chat_sys_notify".equals(cursor.getString(cursor.getColumnIndex("name")))) {
                        z = true;
                        break;
                    }
                }
                return z;
            } finally {
                fi.a(null);
            }
        }
        return invokeV.booleanValue;
    }

    public List<ChatSysNotifyPojo> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Cursor cursor = null;
            try {
                try {
                    cursor = qf8.d().e("select * from tb_chat_sys_notify", null);
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            ChatSysNotifyPojo chatSysNotifyPojo = new ChatSysNotifyPojo();
                            chatSysNotifyPojo.setType(cursor.getInt(cursor.getColumnIndex("scene")));
                            chatSysNotifyPojo.setUnread(cursor.getInt(cursor.getColumnIndex("unread_num")));
                            chatSysNotifyPojo.setContent(cursor.getString(cursor.getColumnIndex("content")));
                            arrayList.add(chatSysNotifyPojo);
                        }
                    }
                } catch (Exception e) {
                    TiebaStatic.printDBExceptionLog(e, "ChatSysNotifyDao.queryAll", new Object[0]);
                    e.printStackTrace();
                }
                return arrayList;
            } finally {
                fi.a(cursor);
            }
        }
        return (List) invokeV.objValue;
    }

    public ChatSysNotifyPojo f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            ChatSysNotifyPojo chatSysNotifyPojo = new ChatSysNotifyPojo();
            chatSysNotifyPojo.setType(i);
            Cursor cursor = null;
            try {
                try {
                    cursor = qf8.d().e("select * from tb_chat_sys_notify where scene=?", new String[]{String.valueOf(i)});
                    if (cursor != null) {
                        cursor.moveToFirst();
                        chatSysNotifyPojo.setUnread(cursor.getInt(cursor.getColumnIndex("unread_num")));
                        chatSysNotifyPojo.setContent(cursor.getString(cursor.getColumnIndex("content")));
                    }
                } catch (Exception e) {
                    TiebaStatic.printDBExceptionLog(e, "ChatSysNotifyDao.queryByScene", new Object[0]);
                    e.printStackTrace();
                }
                return chatSysNotifyPojo;
            } finally {
                fi.a(cursor);
            }
        }
        return (ChatSysNotifyPojo) invokeI.objValue;
    }

    public void g(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            h(i, "", i2);
        }
    }

    public synchronized void h(int i, @Nullable String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
            synchronized (this) {
                ContentValues contentValues = new ContentValues();
                if (!StringUtils.isNull(str)) {
                    contentValues.put("content", str);
                }
                if (i2 >= 0) {
                    contentValues.put("unread_num", Integer.valueOf(i2));
                }
                qf8.d().update("tb_chat_sys_notify", contentValues, "scene=?", new String[]{String.valueOf(i)});
            }
        }
    }
}
