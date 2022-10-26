package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class u97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public Class b;
    public List c;

    public u97(String str, Class cls) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, cls};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        this.a = str;
        this.b = cls;
    }

    public boolean c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                ba7.d().delete(this.a + str, "mid=?", new String[]{str2});
                return true;
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.deleteMsgByMid", new Object[0]);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0071: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:38:0x0071 */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Void a(LinkedList linkedList) {
        InterceptResult invokeL;
        Cursor cursor;
        Cursor cursor2;
        Iterator it;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, linkedList)) == null) {
            Cursor cursor3 = null;
            if (linkedList == null || linkedList.size() == 0) {
                return null;
            }
            LinkedList linkedList2 = new LinkedList();
            try {
                try {
                    cursor = ba7.d().e("select * from sqlite_master where type='table'", null);
                    if (cursor != null) {
                        try {
                            cursor.moveToFirst();
                            while (cursor.moveToNext()) {
                                linkedList2.add(cursor.getString(cursor.getColumnIndex("name")));
                            }
                        } catch (Exception e) {
                            e = e;
                            TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.createMsgTable", new Object[0]);
                            e.printStackTrace();
                            gj.a(cursor);
                            it = linkedList.iterator();
                            while (it.hasNext()) {
                            }
                            return null;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor3 = cursor2;
                    gj.a(cursor3);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                gj.a(cursor3);
                throw th;
            }
            gj.a(cursor);
            it = linkedList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!TextUtils.isEmpty(str) && !linkedList2.contains(str)) {
                    b(str);
                }
            }
            return null;
        }
        return (Void) invokeL.objValue;
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (this.c == null) {
                this.c = i();
            }
            List list = this.c;
            if (list != null && list.contains(str)) {
                Iterator it = this.c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String str2 = (String) it.next();
                    if (str2.equals(str)) {
                        this.c.remove(str2);
                        break;
                    }
                }
            }
            String str3 = this.a + str;
            return ba7.d().c("delete from " + str3);
        }
        return invokeL.booleanValue;
    }

    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (this.c == null) {
                this.c = i();
            }
            List list = this.c;
            if (list != null && list.contains(str)) {
                Iterator it = this.c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String str2 = (String) it.next();
                    if (str2.equals(str)) {
                        this.c.remove(str2);
                        break;
                    }
                }
            }
            String str3 = this.a + str;
            return ba7.d().c("DROP TABLE IF EXISTS " + str3);
        }
        return invokeL.booleanValue;
    }

    public long j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            Cursor cursor = null;
            try {
                try {
                    cursor = ba7.d().e("select max(mid) from " + (this.a + str), null);
                    if (cursor != null && cursor.moveToNext()) {
                        return cursor.getLong(0);
                    }
                } catch (SQLiteException e) {
                    TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getMaxLastMid", new Object[0]);
                    e.printStackTrace();
                    b(str);
                } catch (Exception e2) {
                    TiebaStatic.printDBExceptionLog(e2, "PersonalMsgDao.getMaxLastMid", new Object[0]);
                    e2.printStackTrace();
                }
                return 0L;
            } finally {
                gj.a(cursor);
            }
        }
        return invokeL.longValue;
    }

    public synchronized void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                ba7.d().c("CREATE TABLE IF NOT EXISTS " + (this.a + str) + "(mid BIGINT PRIMARY KEY, uid TEXT, user_info blob, to_uid TEXT, to_user_info blob, create_time BIGINT, msg_type int, " + IMConstants.MSG_STATUS + " int, content blob, ext blob, read_flag int default 0, is_delete int default 0, rid BIGINT, is_friend int default 1, read_count LONG default -1);");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0117 A[EXC_TOP_SPLITTER, LOOP:0: B:56:0x0117->B:29:0x011d, LOOP_START, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LinkedList f(long j, String str, String str2, int i) {
        InterceptResult invokeCommon;
        int i2;
        Cursor cursor;
        Cursor e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), str, str2, Integer.valueOf(i)})) == null) {
            Cursor cursor2 = null;
            if (j == 0) {
                return null;
            }
            String valueOf = String.valueOf(j);
            if (i <= 0) {
                i2 = 20;
            } else {
                i2 = i;
            }
            LinkedList linkedList = new LinkedList();
            String str3 = this.a + valueOf;
            try {
                try {
                } catch (Throwable th) {
                    th = th;
                    gj.a(cursor2);
                    throw th;
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursor = null;
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursor2 = null;
                gj.a(cursor2);
                throw th;
            }
            if (!TextUtils.isEmpty(str2) && !"0".equals(str2)) {
                e = ba7.d().e("select * from " + str3 + " WHERE rid<? AND is_delete=? ORDER BY rid DESC LIMIT " + i2, new String[]{str2, String.valueOf(0)});
                cursor = e;
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            CommonMsgPojo commonMsgPojo = new CommonMsgPojo();
                            commonMsgPojo.setGid(String.valueOf(nb7.j));
                            commonMsgPojo.setContent(cursor.getString(cursor.getColumnIndex("content")));
                            commonMsgPojo.setCreate_time(cursor.getLong(cursor.getColumnIndex("create_time")));
                            commonMsgPojo.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                            commonMsgPojo.setMid(cursor.getLong(cursor.getColumnIndex("mid")));
                            commonMsgPojo.setUid(String.valueOf(cursor.getLong(cursor.getColumnIndex("uid"))));
                            commonMsgPojo.setUser_info(cursor.getString(cursor.getColumnIndex("user_info")));
                            commonMsgPojo.setToUid(String.valueOf(cursor.getLong(cursor.getColumnIndex("to_uid"))));
                            commonMsgPojo.setToUser_info(cursor.getString(cursor.getColumnIndex("to_user_info")));
                            commonMsgPojo.setMsg_status(cursor.getInt(cursor.getColumnIndex(IMConstants.MSG_STATUS)));
                            commonMsgPojo.setMsg_type(cursor.getInt(cursor.getColumnIndex("msg_type")));
                            commonMsgPojo.setRid(cursor.getLong(cursor.getColumnIndex("rid")));
                            commonMsgPojo.setRead_flag(cursor.getInt(cursor.getColumnIndex("read_flag")));
                            commonMsgPojo.setIs_delete(cursor.getInt(cursor.getColumnIndex("is_delete")));
                            commonMsgPojo.setIsFriend(cursor.getInt(cursor.getColumnIndex("is_friend")));
                            commonMsgPojo.checkRidAndSelf();
                            linkedList.add(commonMsgPojo);
                        } catch (SQLiteException e4) {
                            e = e4;
                            TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getAll", new Object[0]);
                            e.printStackTrace();
                            b(valueOf);
                            gj.a(cursor);
                            return linkedList;
                        } catch (Exception e5) {
                            e = e5;
                            TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getAll", new Object[0]);
                            e.printStackTrace();
                            gj.a(cursor);
                            return linkedList;
                        }
                    }
                }
                gj.a(cursor);
                return linkedList;
            }
            if (TextUtils.isEmpty(str)) {
                e = ba7.d().e("select * from " + str3 + " WHERE is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i2, new String[]{String.valueOf(0)});
            } else {
                e = ba7.d().e("select * from " + str3 + " WHERE mid<? AND is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i2, new String[]{str, String.valueOf(0)});
            }
            cursor = e;
            if (cursor != null) {
            }
            gj.a(cursor);
            return linkedList;
        }
        return (LinkedList) invokeCommon.objValue;
    }

    public LinkedHashMap g(String str, int i, String str2, int i2) {
        InterceptResult invokeCommon;
        int i3;
        Cursor cursor;
        Cursor e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2)})) == null) {
            Cursor cursor2 = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (i2 <= 0) {
                i3 = 20;
            } else {
                i3 = i2;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String str3 = this.a + str;
            try {
                try {
                    if (TextUtils.isEmpty(str2)) {
                        e = ba7.d().e("select * from " + str3 + " WHERE msg_type=? AND is_delete=? ORDER BY rid DESC LIMIT " + i3, new String[]{String.valueOf(i), String.valueOf(0)});
                    } else {
                        e = ba7.d().e("select * from " + str3 + " WHERE mid <=? AND msg_type=? AND is_delete=? ORDER BY rid DESC LIMIT " + i3, new String[]{str2, String.valueOf(i), String.valueOf(0)});
                    }
                    cursor = e;
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            try {
                                linkedHashMap.put(cursor.getString(cursor.getColumnIndex("mid")), cursor.getString(cursor.getColumnIndex("content")));
                            } catch (SQLiteException e2) {
                                e = e2;
                                TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getAllByMsgType" + i, new Object[0]);
                                e.printStackTrace();
                                b(str);
                                gj.a(cursor);
                                return linkedHashMap;
                            } catch (Exception e3) {
                                e = e3;
                                TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getAllByMsgType" + i, new Object[0]);
                                e.printStackTrace();
                                gj.a(cursor);
                                return linkedHashMap;
                            }
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    gj.a(cursor2);
                    throw th;
                }
            } catch (SQLiteException e4) {
                e = e4;
                cursor = null;
            } catch (Exception e5) {
                e = e5;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursor2 = null;
                gj.a(cursor2);
                throw th;
            }
            gj.a(cursor);
            return linkedHashMap;
        }
        return (LinkedHashMap) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x011b A[EXC_TOP_SPLITTER, LOOP:0: B:65:0x011b->B:32:0x0213, LOOP_START, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LinkedList h(long j, String str, String str2, int i) {
        InterceptResult invokeCommon;
        int i2;
        Cursor cursor;
        String str3;
        Cursor e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), str, str2, Integer.valueOf(i)})) == null) {
            Cursor cursor2 = null;
            if (j == 0) {
                return null;
            }
            String valueOf = String.valueOf(j);
            if (i <= 0) {
                i2 = 20;
            } else {
                i2 = i;
            }
            LinkedList linkedList = new LinkedList();
            String str4 = this.a + valueOf;
            try {
                try {
                    try {
                        str3 = valueOf;
                    } catch (Throwable th) {
                        th = th;
                        gj.a(cursor2);
                        throw th;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    str3 = valueOf;
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursor2 = null;
                gj.a(cursor2);
                throw th;
            }
            if (!TextUtils.isEmpty(str2)) {
                try {
                } catch (SQLiteException e4) {
                    e = e4;
                    cursor = null;
                    TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getAll", new Object[0]);
                    e.printStackTrace();
                    b(str3);
                    gj.a(cursor);
                    return linkedList;
                }
                if (!"0".equals(str2)) {
                    e = ba7.d().e("select * from " + str4 + " WHERE rid<? AND is_delete=? ORDER BY rid DESC LIMIT " + i2, new String[]{str2, String.valueOf(0)});
                    cursor = e;
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            try {
                                ChatMessage chatMessage = (ChatMessage) this.b.newInstance();
                                chatMessage.setGroupId(String.valueOf(nb7.j));
                                chatMessage.setContent(cursor.getString(cursor.getColumnIndex("content")));
                                chatMessage.setTime(cursor.getLong(cursor.getColumnIndex("create_time")));
                                chatMessage.setExtra(cursor.getString(cursor.getColumnIndex("ext")));
                                chatMessage.setMsgId(cursor.getLong(cursor.getColumnIndex("mid")));
                                chatMessage.setUserId(cursor.getLong(cursor.getColumnIndex("uid")));
                                chatMessage.setUserInfo((UserData) OrmObject.objectWithJsonStr(cursor.getString(cursor.getColumnIndex("user_info")), UserData.class));
                                chatMessage.setToUserId(cursor.getLong(cursor.getColumnIndex("to_uid")));
                                chatMessage.setToUserInfo((UserData) OrmObject.objectWithJsonStr(cursor.getString(cursor.getColumnIndex("to_user_info")), UserData.class));
                                MsgLocalData msgLocalData = new MsgLocalData();
                                chatMessage.setLocalData(msgLocalData);
                                msgLocalData.setStatus(Short.valueOf((short) cursor.getInt(cursor.getColumnIndex(IMConstants.MSG_STATUS))));
                                msgLocalData.setErrorString(cursor.getString(cursor.getColumnIndex("ext")));
                                chatMessage.setErrorString(cursor.getString(cursor.getColumnIndex("ext")));
                                chatMessage.setMsgType(cursor.getInt(cursor.getColumnIndex("msg_type")));
                                chatMessage.setRecordId(cursor.getLong(cursor.getColumnIndex("rid")));
                                bd7.q(chatMessage);
                                bd7.d(chatMessage);
                                bd7.c(chatMessage);
                                chatMessage.setIsFriend(cursor.getInt(cursor.getColumnIndex("is_friend")));
                                int columnIndex = cursor.getColumnIndex("read_count");
                                if (columnIndex >= 0) {
                                    chatMessage.setReadCountPv(cursor.getInt(columnIndex));
                                }
                                linkedList.addFirst(chatMessage);
                            } catch (SQLiteException e5) {
                                e = e5;
                                TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getAll", new Object[0]);
                                e.printStackTrace();
                                b(str3);
                                gj.a(cursor);
                                return linkedList;
                            } catch (Exception e6) {
                                e = e6;
                                TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getAll", new Object[0]);
                                e.printStackTrace();
                                gj.a(cursor);
                                return linkedList;
                            }
                        }
                    }
                    gj.a(cursor);
                    return linkedList;
                }
            }
            if (TextUtils.isEmpty(str)) {
                e = ba7.d().e("select * from " + str4 + " WHERE is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i2, new String[]{String.valueOf(0)});
            } else {
                e = ba7.d().e("select * from " + str4 + " WHERE mid<? AND is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i2, new String[]{str, String.valueOf(0)});
            }
            cursor = e;
            if (cursor != null) {
            }
            gj.a(cursor);
            return linkedList;
        }
        return (LinkedList) invokeCommon.objValue;
    }

    public LinkedList i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            LinkedList linkedList = new LinkedList();
            Cursor cursor = null;
            try {
                try {
                    cursor = ba7.d().e("select * from sqlite_master where type='table'", null);
                    if (cursor != null) {
                        cursor.moveToFirst();
                        while (cursor.moveToNext()) {
                            String string = cursor.getString(cursor.getColumnIndex("name"));
                            if (string.startsWith(this.a)) {
                                linkedList.add(string.subSequence(this.a.length(), string.length()).toString());
                            }
                        }
                    }
                } catch (Exception e) {
                    TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getChatUserIdSync", new Object[0]);
                    e.printStackTrace();
                }
                return linkedList;
            } finally {
                gj.a(cursor);
            }
        }
        return (LinkedList) invokeV.objValue;
    }

    public CommonMsgPojo k(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            Cursor cursor2 = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String str2 = this.a + str;
            try {
                try {
                    cursor = ba7.d().e("select * from " + str2 + " WHERE is_delete=? ORDER BY rid DESC LIMIT 1", new String[]{String.valueOf(0)});
                    try {
                        CommonMsgPojo commonMsgPojo = new CommonMsgPojo();
                        if (cursor != null && cursor.moveToNext()) {
                            commonMsgPojo.setGid(str);
                            commonMsgPojo.setUid(cursor.getString(cursor.getColumnIndex("uid")));
                            commonMsgPojo.setUser_info(cursor.getString(cursor.getColumnIndex("user_info")));
                            commonMsgPojo.setToUid(cursor.getString(cursor.getColumnIndex("to_uid")));
                            commonMsgPojo.setToUser_info(cursor.getString(cursor.getColumnIndex("to_user_info")));
                            commonMsgPojo.setContent(cursor.getString(cursor.getColumnIndex("content")));
                            commonMsgPojo.setCreate_time(cursor.getLong(cursor.getColumnIndex("create_time")));
                            commonMsgPojo.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                            commonMsgPojo.setMid(cursor.getLong(cursor.getColumnIndex("mid")));
                            commonMsgPojo.setMsg_status(cursor.getInt(cursor.getColumnIndex(IMConstants.MSG_STATUS)));
                            commonMsgPojo.setMsg_type(cursor.getInt(cursor.getColumnIndex("msg_type")));
                            commonMsgPojo.setRid(cursor.getLong(cursor.getColumnIndex("rid")));
                            commonMsgPojo.setRead_flag(cursor.getInt(cursor.getColumnIndex("read_flag")));
                            commonMsgPojo.setIs_delete(cursor.getInt(cursor.getColumnIndex("is_delete")));
                            commonMsgPojo.setIsFriend(cursor.getInt(cursor.getColumnIndex("is_friend")));
                            gj.a(cursor);
                            return commonMsgPojo;
                        }
                    } catch (SQLiteException e) {
                        e = e;
                        TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getNewestMsgContext", new Object[0]);
                        e.printStackTrace();
                        b(str);
                        gj.a(cursor);
                        return null;
                    } catch (Exception e2) {
                        e = e2;
                        TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getNewestMsgContext", new Object[0]);
                        e.printStackTrace();
                        gj.a(cursor);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = str2;
                    gj.a(cursor2);
                    throw th;
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursor = null;
            } catch (Exception e4) {
                e = e4;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                gj.a(cursor2);
                throw th;
            }
            gj.a(cursor);
            return null;
        }
        return (CommonMsgPojo) invokeL.objValue;
    }

    public LinkedList l(Map map, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, map, i)) == null) {
            Cursor cursor = null;
            if (map == null || map.size() <= 0) {
                return null;
            }
            Set keySet = map.keySet();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM(");
            Iterator it = keySet.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                sb.append("SELECT * FROM ");
                sb.append(this.a + ((String) it.next()));
                sb.append(" WHERE ");
                sb.append("msg_type");
                sb.append(" = 7");
                sb.append(" AND ");
                sb.append("is_delete");
                sb.append(" = ");
                sb.append(0);
                int i3 = i2 + 1;
                if (i2 != map.size() - 1) {
                    sb.append(" UNION ALL ");
                }
                i2 = i3;
            }
            sb.append(") ORDER BY ");
            sb.append("create_time");
            sb.append(" DESC LIMIT ?");
            LinkedList linkedList = new LinkedList();
            try {
                try {
                    cursor = ba7.d().e(sb.toString(), new String[]{String.valueOf(i)});
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            ChatMessage chatMessage = (ChatMessage) this.b.newInstance();
                            chatMessage.setObjContent(map.get(cursor.getString(cursor.getColumnIndex("uid"))));
                            chatMessage.setContent(cursor.getString(cursor.getColumnIndex("content")));
                            chatMessage.setTime(cursor.getLong(cursor.getColumnIndex("create_time")));
                            chatMessage.setExtra(cursor.getString(cursor.getColumnIndex("ext")));
                            chatMessage.setMsgId(cursor.getLong(cursor.getColumnIndex("mid")));
                            chatMessage.setUserId(cursor.getLong(cursor.getColumnIndex("uid")));
                            chatMessage.setUserInfo((UserData) OrmObject.objectWithJsonStr(cursor.getString(cursor.getColumnIndex("user_info")), UserData.class));
                            chatMessage.setToUserId(cursor.getLong(cursor.getColumnIndex("to_uid")));
                            chatMessage.setToUserInfo((UserData) OrmObject.objectWithJsonStr(cursor.getString(cursor.getColumnIndex("to_user_info")), UserData.class));
                            MsgLocalData msgLocalData = new MsgLocalData();
                            chatMessage.setLocalData(msgLocalData);
                            msgLocalData.setStatus(Short.valueOf((short) cursor.getInt(cursor.getColumnIndex(IMConstants.MSG_STATUS))));
                            chatMessage.setMsgType(cursor.getInt(cursor.getColumnIndex("msg_type")));
                            chatMessage.setRecordId(cursor.getLong(cursor.getColumnIndex("rid")));
                            chatMessage.setIsFriend(cursor.getInt(cursor.getColumnIndex("is_friend")));
                            int columnIndex = cursor.getColumnIndex("read_count");
                            if (columnIndex >= 0) {
                                chatMessage.setReadCountPv(cursor.getInt(columnIndex));
                            }
                            linkedList.add(chatMessage);
                        }
                    }
                } catch (SQLiteException e) {
                    TiebaStatic.printDBExceptionLog(e, "OfficialMsgDao.getOfficialMsgByGid", new Object[0]);
                    e.printStackTrace();
                } catch (Exception e2) {
                    TiebaStatic.printDBExceptionLog(e2, "OfficialMsgDao.getOfficialMsgByGid", new Object[0]);
                    e2.printStackTrace();
                }
                return linkedList;
            } finally {
                gj.a(cursor);
            }
        }
        return (LinkedList) invokeLI.objValue;
    }

    public int m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            Cursor cursor = null;
            try {
                try {
                    try {
                        cursor = ba7.d().e("select count(*) from " + (this.a + str) + " WHERE read_flag=? AND is_delete=?", new String[]{String.valueOf(1), String.valueOf(0)});
                        if (cursor != null && cursor.moveToNext()) {
                            return cursor.getInt(0);
                        }
                    } catch (Exception e) {
                        TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getUnreadcount", new Object[0]);
                        e.printStackTrace();
                    }
                } catch (SQLiteException e2) {
                    TiebaStatic.printDBExceptionLog(e2, "PersonalMsgDao.getUnreadcount", new Object[0]);
                    e2.printStackTrace();
                }
                return 0;
            } finally {
                gj.a(cursor);
            }
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:26|27|(4:(3:77|78|(12:83|84|85|30|31|(5:62|63|64|65|66)(1:33)|34|(1:38)|39|40|41|42))|40|41|42)|29|30|31|(0)(0)|34|(2:36|38)|39|24) */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x02c8, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x02c9, code lost:
        r3 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x02cf, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x02d0, code lost:
        r3 = r23;
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0201 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x028f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean n(long j, List list, boolean z) {
        InterceptResult invokeCommon;
        Cursor cursor;
        SQLiteStatement sQLiteStatement;
        SQLiteStatement sQLiteStatement2;
        String str;
        String str2;
        SQLiteStatement sQLiteStatement3;
        ContentValues contentValues;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), list, Boolean.valueOf(z)})) == null) {
            String str4 = "rid";
            String str5 = "msg_type";
            if (list == null) {
                return false;
            }
            if (j != 0 && TbadkCoreApplication.getCurrentAccount() != null) {
                String valueOf = String.valueOf(j);
                String str6 = this.a + valueOf;
                if (this.c == null) {
                    this.c = i();
                }
                if (!this.c.contains(valueOf)) {
                    b(valueOf);
                    this.c.add(valueOf);
                }
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(" INSERT INTO ");
                    sb.append(str6);
                    sb.append("(");
                    sb.append("content");
                    sb.append(",");
                    sb.append("create_time");
                    sb.append(",");
                    sb.append("ext");
                    sb.append(",");
                    sb.append("mid");
                    sb.append(",");
                    sb.append("uid");
                    sb.append(",");
                    sb.append("user_info");
                    sb.append(",");
                    sb.append("to_uid");
                    sb.append(",");
                    sb.append("to_user_info");
                    sb.append(",");
                    sb.append(IMConstants.MSG_STATUS);
                    sb.append(",");
                    sb.append("msg_type");
                    sb.append(",");
                    sb.append("rid");
                    sb.append(",");
                    String str7 = "read_flag";
                    sb.append(str7);
                    sb.append(",");
                    String str8 = "is_delete";
                    try {
                        sb.append(str8);
                        sb.append(",");
                        sb.append("is_friend");
                        String str9 = "is_friend";
                        sb.append(") VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
                        sQLiteStatement = ba7.d().a(sb.toString());
                        try {
                            Iterator it = list.iterator();
                            long j2 = 0;
                            while (it.hasNext()) {
                                CommonMsgPojo commonMsgPojo = (CommonMsgPojo) it.next();
                                Iterator it2 = it;
                                try {
                                    if (z) {
                                        try {
                                            if (commonMsgPojo.isSelf() && commonMsgPojo.getRid() != 0) {
                                                sQLiteStatement2 = sQLiteStatement;
                                                try {
                                                    str = str8;
                                                    str2 = str7;
                                                    ba7.d().delete(str6, "mid=?", new String[]{String.valueOf(commonMsgPojo.getRid())});
                                                    contentValues = new ContentValues();
                                                    contentValues.put("content", commonMsgPojo.getContent());
                                                    contentValues.put("create_time", Long.valueOf(commonMsgPojo.getCreate_time()));
                                                    contentValues.put("ext", commonMsgPojo.getExt());
                                                    contentValues.put("mid", Long.valueOf(commonMsgPojo.getMid()));
                                                    contentValues.put("uid", commonMsgPojo.getUid());
                                                    contentValues.put("user_info", commonMsgPojo.getUser_info());
                                                    contentValues.put("to_uid", commonMsgPojo.getToUid());
                                                    contentValues.put("to_user_info", commonMsgPojo.getToUser_info());
                                                    contentValues.put(IMConstants.MSG_STATUS, Integer.valueOf(commonMsgPojo.getMsg_status()));
                                                    contentValues.put(str5, Integer.valueOf(commonMsgPojo.getMsg_type()));
                                                    contentValues.put("ext", commonMsgPojo.getExt());
                                                    contentValues.put(str4, Long.valueOf(commonMsgPojo.getRid()));
                                                    String str10 = str2;
                                                    contentValues.put(str10, Integer.valueOf(commonMsgPojo.getRead_flag()));
                                                    String str11 = str;
                                                    contentValues.put(str11, Integer.valueOf(commonMsgPojo.getIs_delete()));
                                                    String str12 = str9;
                                                    contentValues.put(str12, Integer.valueOf(commonMsgPojo.getIsFriend()));
                                                    str9 = str12;
                                                    String str13 = str4;
                                                    if (ba7.d().update(str6, contentValues, "mid=?", new String[]{String.valueOf(commonMsgPojo.getMid())}) != 0) {
                                                        try {
                                                            sQLiteStatement2.clearBindings();
                                                            sQLiteStatement3 = sQLiteStatement2;
                                                            try {
                                                                sQLiteStatement3.bindString(1, commonMsgPojo.getContent());
                                                                str3 = str5;
                                                                sQLiteStatement3.bindLong(2, commonMsgPojo.getCreate_time());
                                                                sQLiteStatement3.bindString(3, commonMsgPojo.getExt());
                                                                sQLiteStatement3.bindLong(4, commonMsgPojo.getMid());
                                                                sQLiteStatement3.bindString(5, commonMsgPojo.getUid());
                                                                sQLiteStatement3.bindString(6, commonMsgPojo.getUser_info());
                                                                sQLiteStatement3.bindString(7, commonMsgPojo.getToUid());
                                                                sQLiteStatement3.bindString(8, commonMsgPojo.getToUser_info());
                                                                sQLiteStatement3.bindLong(9, commonMsgPojo.getMsg_status());
                                                                sQLiteStatement3.bindLong(10, commonMsgPojo.getMsg_type());
                                                                sQLiteStatement3.bindLong(11, commonMsgPojo.getRid());
                                                                sQLiteStatement3.bindLong(12, commonMsgPojo.getRead_flag());
                                                                sQLiteStatement3.bindLong(13, commonMsgPojo.getIs_delete());
                                                                sQLiteStatement3.bindLong(14, commonMsgPojo.getIsFriend());
                                                                sQLiteStatement3.executeInsert();
                                                            } catch (Exception e) {
                                                                e = e;
                                                                sQLiteStatement = sQLiteStatement3;
                                                                try {
                                                                    TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.insertOrUpdate", new Object[0]);
                                                                    e.printStackTrace();
                                                                    gj.a(null);
                                                                    gj.c(sQLiteStatement);
                                                                    return true;
                                                                } catch (Throwable th) {
                                                                    th = th;
                                                                    cursor = null;
                                                                    gj.a(cursor);
                                                                    gj.c(sQLiteStatement);
                                                                    throw th;
                                                                }
                                                            } catch (Throwable th2) {
                                                                th = th2;
                                                                sQLiteStatement = sQLiteStatement3;
                                                                cursor = null;
                                                                gj.a(cursor);
                                                                gj.c(sQLiteStatement);
                                                                throw th;
                                                            }
                                                        } catch (Exception e2) {
                                                            e = e2;
                                                            sQLiteStatement3 = sQLiteStatement2;
                                                            sQLiteStatement = sQLiteStatement3;
                                                            TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.insertOrUpdate", new Object[0]);
                                                            e.printStackTrace();
                                                            gj.a(null);
                                                            gj.c(sQLiteStatement);
                                                            return true;
                                                        } catch (Throwable th3) {
                                                            th = th3;
                                                            sQLiteStatement3 = sQLiteStatement2;
                                                            sQLiteStatement = sQLiteStatement3;
                                                            cursor = null;
                                                            gj.a(cursor);
                                                            gj.c(sQLiteStatement);
                                                            throw th;
                                                        }
                                                    } else {
                                                        str3 = str5;
                                                        sQLiteStatement3 = sQLiteStatement2;
                                                    }
                                                    if (commonMsgPojo.getMsg_type() == 34 && j2 < commonMsgPojo.getCreate_time()) {
                                                        j2 = commonMsgPojo.getCreate_time();
                                                    }
                                                    long j3 = j2;
                                                    s(str6, j3);
                                                    j2 = j3;
                                                    sQLiteStatement = sQLiteStatement3;
                                                    str8 = str11;
                                                    str5 = str3;
                                                    str7 = str10;
                                                    str4 = str13;
                                                    it = it2;
                                                } catch (Exception e3) {
                                                    e = e3;
                                                    sQLiteStatement = sQLiteStatement2;
                                                    TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.insertOrUpdate", new Object[0]);
                                                    e.printStackTrace();
                                                    gj.a(null);
                                                    gj.c(sQLiteStatement);
                                                    return true;
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                    sQLiteStatement = sQLiteStatement2;
                                                    cursor = null;
                                                    gj.a(cursor);
                                                    gj.c(sQLiteStatement);
                                                    throw th;
                                                }
                                            }
                                        } catch (Exception e4) {
                                            e = e4;
                                        } catch (Throwable th5) {
                                            th = th5;
                                        }
                                    }
                                    s(str6, j3);
                                    j2 = j3;
                                    sQLiteStatement = sQLiteStatement3;
                                    str8 = str11;
                                    str5 = str3;
                                    str7 = str10;
                                    str4 = str13;
                                    it = it2;
                                } catch (Exception e5) {
                                    e = e5;
                                    sQLiteStatement = sQLiteStatement3;
                                    TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.insertOrUpdate", new Object[0]);
                                    e.printStackTrace();
                                    gj.a(null);
                                    gj.c(sQLiteStatement);
                                    return true;
                                } catch (Throwable th6) {
                                    th = th6;
                                    sQLiteStatement = sQLiteStatement3;
                                    cursor = null;
                                    gj.a(cursor);
                                    gj.c(sQLiteStatement);
                                    throw th;
                                }
                                str = str8;
                                sQLiteStatement2 = sQLiteStatement;
                                str2 = str7;
                                contentValues = new ContentValues();
                                contentValues.put("content", commonMsgPojo.getContent());
                                contentValues.put("create_time", Long.valueOf(commonMsgPojo.getCreate_time()));
                                contentValues.put("ext", commonMsgPojo.getExt());
                                contentValues.put("mid", Long.valueOf(commonMsgPojo.getMid()));
                                contentValues.put("uid", commonMsgPojo.getUid());
                                contentValues.put("user_info", commonMsgPojo.getUser_info());
                                contentValues.put("to_uid", commonMsgPojo.getToUid());
                                contentValues.put("to_user_info", commonMsgPojo.getToUser_info());
                                contentValues.put(IMConstants.MSG_STATUS, Integer.valueOf(commonMsgPojo.getMsg_status()));
                                contentValues.put(str5, Integer.valueOf(commonMsgPojo.getMsg_type()));
                                contentValues.put("ext", commonMsgPojo.getExt());
                                contentValues.put(str4, Long.valueOf(commonMsgPojo.getRid()));
                                String str102 = str2;
                                contentValues.put(str102, Integer.valueOf(commonMsgPojo.getRead_flag()));
                                String str112 = str;
                                contentValues.put(str112, Integer.valueOf(commonMsgPojo.getIs_delete()));
                                String str122 = str9;
                                contentValues.put(str122, Integer.valueOf(commonMsgPojo.getIsFriend()));
                                str9 = str122;
                                String str132 = str4;
                                if (ba7.d().update(str6, contentValues, "mid=?", new String[]{String.valueOf(commonMsgPojo.getMid())}) != 0) {
                                }
                                if (commonMsgPojo.getMsg_type() == 34) {
                                    j2 = commonMsgPojo.getCreate_time();
                                }
                                long j32 = j2;
                            }
                            gj.a(null);
                            gj.c(sQLiteStatement);
                            return true;
                        } catch (Exception e6) {
                            e = e6;
                        } catch (Throwable th7) {
                            th = th7;
                        }
                    } catch (Exception e7) {
                        e = e7;
                        sQLiteStatement = null;
                        TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.insertOrUpdate", new Object[0]);
                        e.printStackTrace();
                        gj.a(null);
                        gj.c(sQLiteStatement);
                        return true;
                    } catch (Throwable th8) {
                        th = th8;
                        cursor = null;
                        sQLiteStatement = null;
                        gj.a(cursor);
                        gj.c(sQLiteStatement);
                        throw th;
                    }
                } catch (Exception e8) {
                    e = e8;
                } catch (Throwable th9) {
                    th = th9;
                }
            } else {
                return false;
            }
        } else {
            return invokeCommon.booleanValue;
        }
    }

    public boolean o(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, str2)) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("is_delete", (Integer) 1);
                ba7.d().update(this.a + str, contentValues, "mid=?", new String[]{str2});
                return true;
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.markDeleteMsgByMid", new Object[0]);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public void s(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048594, this, str, j) == null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("ext", "expired");
                ba7 d = ba7.d();
                d.update(str, contentValues, "msg_type=? and create_time<?", new String[]{"34", "" + j});
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.updateState", new Object[0]);
                e.printStackTrace();
            }
        }
    }

    public void t(long j, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            String str = this.a + j;
            try {
                ContentValues contentValues = new ContentValues();
                if (z) {
                    i = 1;
                } else {
                    i = 0;
                }
                contentValues.put("is_delete", Integer.valueOf(i));
                ba7.d().update(str, contentValues, "uid!=?", new String[]{"0"});
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.updateState", new Object[0]);
                e.printStackTrace();
            }
        }
    }

    public boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            try {
                t(Long.parseLong(str), true);
                return true;
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.markDeleteMsgTable", new Object[0]);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.c = null;
        }
    }

    public boolean r(String str, int i) {
        InterceptResult invokeLI;
        String str2;
        Cursor e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048593, this, str, i)) == null) {
            Cursor cursor = null;
            String str3 = null;
            cursor = null;
            try {
                try {
                    str2 = this.a + str;
                    if (i < 1000) {
                        i = 1000;
                    }
                    e = ba7.d().e("SELECT * FROM " + str2 + " ORDER BY mid DESC LIMIT " + i + ", 1", null);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (e.moveToNext()) {
                    str3 = e.getString(e.getColumnIndex("mid"));
                }
                gj.a(e);
                if (str3 != null) {
                    ba7.d().delete(str2, "mid<?", new String[]{str3});
                }
                gj.a(e);
                return true;
            } catch (Exception e3) {
                e = e3;
                cursor = e;
                e.printStackTrace();
                TiebaStatic.printDBExceptionLog(e, "shrink", new Object[0]);
                gj.a(cursor);
                return false;
            } catch (Throwable th2) {
                th = th2;
                cursor = e;
                gj.a(cursor);
                throw th;
            }
        }
        return invokeLI.booleanValue;
    }

    public boolean u(long j, long j2, String str, String str2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, str2, Integer.valueOf(i)})) == null) {
            return v(j, j2, str, str2, i, null);
        }
        return invokeCommon.booleanValue;
    }

    public boolean v(long j, long j2, String str, String str2, int i, String str3) {
        InterceptResult invokeCommon;
        Boolean bool;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, str2, Integer.valueOf(i), str3})) == null) {
            Boolean bool2 = Boolean.FALSE;
            if (j == 0 || j2 == 0 || TbadkCoreApplication.getCurrentAccount() == null) {
                return false;
            }
            String valueOf = String.valueOf(j);
            if (TbadkCoreApplication.getCurrentAccount().equals(valueOf)) {
                valueOf = String.valueOf(j2);
            }
            String str4 = this.a + valueOf;
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("mid", str2);
                contentValues.put(IMConstants.MSG_STATUS, Integer.valueOf(i));
                if (str3 != null) {
                    contentValues.put("ext", str3);
                }
                if (ba7.d().update(str4, contentValues, "mid=?", new String[]{str}) > 0) {
                    bool = Boolean.TRUE;
                } else {
                    bool = Boolean.FALSE;
                }
                bool2 = bool;
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.updateState", new Object[0]);
                e.printStackTrace();
            }
            return bool2.booleanValue();
        }
        return invokeCommon.booleanValue;
    }
}
