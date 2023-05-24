package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.request.MessageExt;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.db.pojo.GroupChatRoomPojo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.codec.net.RFC1522Codec;
/* loaded from: classes6.dex */
public class n28 {
    public static /* synthetic */ Interceptable $ic;
    public static n28 a;
    public transient /* synthetic */ FieldHolder $fh;

    public n28() {
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

    public static synchronized n28 f() {
        InterceptResult invokeV;
        n28 n28Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (n28.class) {
                if (a == null) {
                    a = new n28();
                }
                n28Var = a;
            }
            return n28Var;
        }
        return (n28) invokeV.objValue;
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = "tb_group_chat_room_" + str;
        if (i().contains(str2)) {
            return;
        }
        s28.d().c("CREATE TABLE IF NOT EXISTS " + str2 + "(room_id LONG primary key, name TEXT, avatar TEXT, forum_Id TEXT, forum_name TEXT, " + MessageExt.KEY_LATEST_MSG_ID + " LONG, timestamp LONG, " + DBTableDefine.GroupInfoColumns.COLUMN_DELETE_TIEM + " LONG, top_time LONG, " + TableDefine.ZhiDaColumns.COLUMN_IS_SUBSCRIBE + " INTEGER DEFAULT 0, no_disturb INTEGER DEFAULT 0);");
    }

    public final boolean b(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j)) == null) {
            boolean z = false;
            Cursor cursor = null;
            try {
                cursor = s28.d().e("select * from " + str + " WHERE room_id" + RFC1522Codec.PREFIX, new String[]{String.valueOf(j)});
                if (cursor != null) {
                    if (cursor.moveToNext()) {
                        z = true;
                    }
                }
                return z;
            } catch (SQLiteException e) {
                e.printStackTrace();
                return false;
            } finally {
                si.a(cursor);
            }
        }
        return invokeLJ.booleanValue;
    }

    public List<GroupChatRoomPojo> e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return d("select * from " + ("tb_group_chat_room_" + str) + " WHERE forum_Id" + RFC1522Codec.PREFIX, new String[]{str2});
        }
        return (List) invokeLL.objValue;
    }

    @Nullable
    public GroupChatRoomPojo c(String str, long j) {
        InterceptResult invokeLJ;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j)) == null) {
            Cursor cursor2 = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String str2 = "tb_group_chat_room_" + str;
            try {
                try {
                    cursor = s28.d().e("select * from " + str2 + " WHERE room_id" + RFC1522Codec.PREFIX, new String[]{String.valueOf(j)});
                    if (cursor != null) {
                        try {
                            if (cursor.moveToNext()) {
                                GroupChatRoomPojo groupChatRoomPojo = new GroupChatRoomPojo();
                                groupChatRoomPojo.setRoomId(j);
                                groupChatRoomPojo.setName(cursor.getString(cursor.getColumnIndex("name")));
                                groupChatRoomPojo.setAvatar(cursor.getString(cursor.getColumnIndex("avatar")));
                                groupChatRoomPojo.setForumId(cursor.getString(cursor.getColumnIndex("forum_Id")));
                                groupChatRoomPojo.setForumName(cursor.getString(cursor.getColumnIndex("forum_name")));
                                groupChatRoomPojo.W(cursor.getLong(cursor.getColumnIndex(MessageExt.KEY_LATEST_MSG_ID)));
                                groupChatRoomPojo.setTimestamp(cursor.getLong(cursor.getColumnIndex("timestamp")));
                                groupChatRoomPojo.setDeleteTime(cursor.getLong(cursor.getColumnIndex(DBTableDefine.GroupInfoColumns.COLUMN_DELETE_TIEM)));
                                groupChatRoomPojo.setTopTime(cursor.getLong(cursor.getColumnIndex("top_time")));
                                groupChatRoomPojo.setIsSubscribe(cursor.getInt(cursor.getColumnIndex(TableDefine.ZhiDaColumns.COLUMN_IS_SUBSCRIBE)));
                                groupChatRoomPojo.setNoDisturb(cursor.getInt(cursor.getColumnIndex("no_disturb")));
                                si.a(cursor);
                                return groupChatRoomPojo;
                            }
                        } catch (SQLiteException e) {
                            e = e;
                            TiebaStatic.printDBExceptionLog(e, "GroupChatRoomPojo#getGroupChatRoomPojo", new Object[0]);
                            si.a(cursor);
                            return null;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = str2;
                    si.a(cursor2);
                    throw th;
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                si.a(cursor2);
                throw th;
            }
            si.a(cursor);
            return null;
        }
        return (GroupChatRoomPojo) invokeLJ.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x00c4 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.database.Cursor] */
    public final List<GroupChatRoomPojo> d(String str, String[] strArr) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, strArr)) == null) {
            ?? r1 = 0;
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    cursor = s28.d().e(str, strArr);
                    if (cursor != null) {
                        try {
                            ArrayList arrayList = new ArrayList();
                            while (cursor.moveToNext()) {
                                GroupChatRoomPojo groupChatRoomPojo = new GroupChatRoomPojo();
                                groupChatRoomPojo.setRoomId(cursor.getLong(cursor.getColumnIndex("room_id")));
                                groupChatRoomPojo.setName(cursor.getString(cursor.getColumnIndex("name")));
                                groupChatRoomPojo.setAvatar(cursor.getString(cursor.getColumnIndex("avatar")));
                                groupChatRoomPojo.setForumId(cursor.getString(cursor.getColumnIndex("forum_Id")));
                                groupChatRoomPojo.setForumName(cursor.getString(cursor.getColumnIndex("forum_name")));
                                groupChatRoomPojo.W(cursor.getLong(cursor.getColumnIndex(MessageExt.KEY_LATEST_MSG_ID)));
                                groupChatRoomPojo.setTimestamp(cursor.getLong(cursor.getColumnIndex("timestamp")));
                                groupChatRoomPojo.setDeleteTime(cursor.getLong(cursor.getColumnIndex(DBTableDefine.GroupInfoColumns.COLUMN_DELETE_TIEM)));
                                groupChatRoomPojo.setTopTime(cursor.getLong(cursor.getColumnIndex("top_time")));
                                groupChatRoomPojo.setIsSubscribe(cursor.getInt(cursor.getColumnIndex(TableDefine.ZhiDaColumns.COLUMN_IS_SUBSCRIBE)));
                                groupChatRoomPojo.setNoDisturb(cursor.getInt(cursor.getColumnIndex("no_disturb")));
                                arrayList.add(groupChatRoomPojo);
                            }
                            si.a(cursor);
                            return arrayList;
                        } catch (SQLiteException e) {
                            e = e;
                            TiebaStatic.printDBExceptionLog(e, "GroupChatRoomPojo#getGroupChatRoomPojo", new Object[0]);
                            si.a(cursor);
                            return null;
                        }
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                    si.a(r1);
                    throw th;
                }
                si.a(cursor);
                return null;
            } catch (Throwable th2) {
                th = th2;
                r1 = str;
            }
        } else {
            return (List) invokeLL.objValue;
        }
    }

    public final boolean j(String str, GroupChatRoomPojo groupChatRoomPojo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, groupChatRoomPojo)) == null) {
            String str2 = "tb_group_chat_room_" + str;
            a(str);
            try {
                if (!b(str2, groupChatRoomPojo.getRoomId())) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("room_id", Long.valueOf(groupChatRoomPojo.getRoomId()));
                    contentValues.put("name", groupChatRoomPojo.getName());
                    contentValues.put("avatar", groupChatRoomPojo.getAvatar());
                    contentValues.put("forum_Id", groupChatRoomPojo.getForumId());
                    contentValues.put("forum_name", groupChatRoomPojo.getForumName());
                    contentValues.put(MessageExt.KEY_LATEST_MSG_ID, Long.valueOf(groupChatRoomPojo.getLatestMsgId()));
                    contentValues.put("timestamp", Long.valueOf(groupChatRoomPojo.getTimestamp()));
                    contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_DELETE_TIEM, Long.valueOf(groupChatRoomPojo.getDeleteTime()));
                    contentValues.put("top_time", Long.valueOf(groupChatRoomPojo.getTopTime()));
                    contentValues.put(TableDefine.ZhiDaColumns.COLUMN_IS_SUBSCRIBE, Integer.valueOf(groupChatRoomPojo.U()));
                    contentValues.put("no_disturb", Integer.valueOf(groupChatRoomPojo.V()));
                    if (s28.d().insert(str2, null, contentValues) == -1) {
                        return false;
                    }
                    return true;
                }
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "GroupChatRoomDao#insertGroupChatRoomPojo", new Object[0]);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public List<GroupChatRoomPojo> g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return d("select * from " + ("tb_group_chat_room_" + str), null);
        }
        return (List) invokeL.objValue;
    }

    public List<GroupChatRoomPojo> h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return d("select * from " + ("tb_group_chat_room_" + str) + " WHERE " + TableDefine.ZhiDaColumns.COLUMN_IS_SUBSCRIBE + RFC1522Codec.PREFIX, new String[]{String.valueOf(1)});
        }
        return (List) invokeL.objValue;
    }

    public final LinkedList<String> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            LinkedList<String> linkedList = new LinkedList<>();
            Cursor cursor = null;
            try {
                try {
                    cursor = s28.d().e("select * from sqlite_master where type='table'", null);
                    if (cursor != null) {
                        cursor.moveToFirst();
                        while (cursor.moveToNext()) {
                            String string = cursor.getString(cursor.getColumnIndex("name"));
                            if (string.startsWith("tb_group_chat_room_")) {
                                linkedList.add(string);
                            }
                        }
                    }
                } catch (Exception e) {
                    TiebaStatic.printDBExceptionLog(e, "GroupChatRoomDao.getTables", new Object[0]);
                    e.printStackTrace();
                }
                return linkedList;
            } finally {
                si.a(cursor);
            }
        }
        return (LinkedList) invokeV.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x009c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x0019 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: int */
    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: int */
    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final boolean k(@NonNull String str, @NonNull GroupChatRoomPojo groupChatRoomPojo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, groupChatRoomPojo)) == null) {
            String str2 = "tb_group_chat_room_" + str;
            a(str);
            int i = 0;
            i = 0;
            try {
                if (b(str2, groupChatRoomPojo.getRoomId())) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("name", groupChatRoomPojo.getName());
                    contentValues.put("avatar", groupChatRoomPojo.getAvatar());
                    contentValues.put("forum_Id", groupChatRoomPojo.getForumId());
                    contentValues.put("forum_name", groupChatRoomPojo.getForumName());
                    contentValues.put(MessageExt.KEY_LATEST_MSG_ID, Long.valueOf(groupChatRoomPojo.getLatestMsgId()));
                    contentValues.put("timestamp", Long.valueOf(groupChatRoomPojo.getTimestamp()));
                    contentValues.put(TableDefine.ZhiDaColumns.COLUMN_IS_SUBSCRIBE, Integer.valueOf(groupChatRoomPojo.U()));
                    if (s28.d().update(str2, contentValues, "room_id=?", new String[]{String.valueOf(groupChatRoomPojo.getRoomId())}) == 1) {
                        i = 1;
                    }
                } else {
                    i = j(str, groupChatRoomPojo);
                }
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "GroupChatRoomDao#updateGroupChatRoomPojo", new Object[i]);
            }
            return i;
        }
        return invokeLL.booleanValue;
    }

    public boolean l(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5, long j, long j2, long j3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{str, str2, str3, str4, str5, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)})) == null) {
            GroupChatRoomPojo groupChatRoomPojo = new GroupChatRoomPojo();
            groupChatRoomPojo.setName(str2);
            groupChatRoomPojo.setRoomId(j);
            groupChatRoomPojo.setForumName(str5);
            groupChatRoomPojo.setForumId(str4);
            groupChatRoomPojo.setAvatar(str3);
            groupChatRoomPojo.W(j2);
            groupChatRoomPojo.setTimestamp(j3);
            groupChatRoomPojo.setIsSubscribe(z ? 1 : 0);
            return k(str, groupChatRoomPojo);
        }
        return invokeCommon.booleanValue;
    }

    public boolean m(@NonNull String str, long j, @NonNull String str2, @NonNull String str3, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{str, Long.valueOf(j), str2, str3, Long.valueOf(j2)})) == null) {
            return o(str, j, str2, str3, DBTableDefine.GroupInfoColumns.COLUMN_DELETE_TIEM, j2);
        }
        return invokeCommon.booleanValue;
    }

    public boolean p(@NonNull String str, long j, @NonNull String str2, @NonNull String str3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{str, Long.valueOf(j), str2, str3, Boolean.valueOf(z)})) == null) {
            return n(str, j, str2, str3, "no_disturb", z);
        }
        return invokeCommon.booleanValue;
    }

    public boolean q(@NonNull String str, long j, @NonNull String str2, @NonNull String str3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{str, Long.valueOf(j), str2, str3, Boolean.valueOf(z)})) == null) {
            return n(str, j, str2, str3, TableDefine.ZhiDaColumns.COLUMN_IS_SUBSCRIBE, z);
        }
        return invokeCommon.booleanValue;
    }

    public boolean r(@NonNull String str, long j, @NonNull String str2, @NonNull String str3, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{str, Long.valueOf(j), str2, str3, Long.valueOf(j2)})) == null) {
            return o(str, j, str2, str3, "top_time", j2);
        }
        return invokeCommon.booleanValue;
    }

    public final boolean n(String str, long j, @NonNull String str2, @NonNull String str3, String str4, boolean z) {
        InterceptResult invokeCommon;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{str, Long.valueOf(j), str2, str3, str4, Boolean.valueOf(z)})) == null) {
            String str5 = "tb_group_chat_room_" + str;
            a(str);
            try {
                if (!b(str5, j)) {
                    return false;
                }
                ContentValues contentValues = new ContentValues();
                if (z) {
                    i = 1;
                } else {
                    i = 0;
                }
                contentValues.put(str4, Integer.valueOf(i));
                contentValues.put("name", str2);
                contentValues.put("avatar", str3);
                if (s28.d().update(str5, contentValues, "room_id=?", new String[]{String.valueOf(j)}) != 1) {
                    return false;
                }
                return true;
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "GroupChatRoomDao#updateIntField", new Object[0]);
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public final boolean o(@NonNull String str, long j, @NonNull String str2, @NonNull String str3, String str4, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{str, Long.valueOf(j), str2, str3, str4, Long.valueOf(j2)})) == null) {
            String str5 = "tb_group_chat_room_" + str;
            a(str);
            try {
                if (!b(str5, j)) {
                    return false;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put(str4, Long.valueOf(j2));
                contentValues.put("name", str2);
                contentValues.put("avatar", str3);
                if (s28.d().update(str5, contentValues, "room_id=?", new String[]{String.valueOf(j)}) != 1) {
                    return false;
                }
                return true;
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "GroupChatRoomDao#updateLongField", new Object[0]);
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }
}
