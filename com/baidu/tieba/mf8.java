package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.model.ModelHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class mf8 {
    public static /* synthetic */ Interceptable $ic;
    public static mf8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public mf8() {
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

    public static mf8 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                a = new mf8();
            }
            return a;
        }
        return (mf8) invokeV.objValue;
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Boolean bool;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                qf8.d().delete("tb_group_news", "notice_id = ?", new String[]{str});
                bool = Boolean.TRUE;
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "GroupNewsDao.deleteByNoticeId", new Object[0]);
                e.printStackTrace();
                bool = Boolean.FALSE;
            }
            return bool.booleanValue();
        }
        return invokeL.booleanValue;
    }

    public LinkedList<GroupNewsPojo> b(long j, int i, int i2, String str) {
        InterceptResult invokeCommon;
        Cursor e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str})) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            LinkedList<GroupNewsPojo> linkedList = new LinkedList<>();
            if (i <= 0) {
                i = 20;
            }
            Cursor cursor = null;
            try {
                try {
                    if (j <= 0) {
                        if (TextUtils.isEmpty(str)) {
                            e = qf8.d().e("select * from tb_group_news ORDER BY time DESC LIMIT " + i + " OFFSET " + i2, null);
                        } else {
                            e = qf8.d().e(String.format("select * from tb_group_news WHERE cmd IN ( '%1$s' ) ORDER BY time DESC LIMIT " + i + " OFFSET " + i2, str), null);
                        }
                    } else if (TextUtils.isEmpty(str)) {
                        e = qf8.d().e("select * from tb_group_news WHERE time <=? ORDER BY time DESC LIMIT " + i + " OFFSET " + i2, new String[]{String.valueOf(j)});
                    } else {
                        e = qf8.d().e("select * from tb_group_news WHERE time <=? AND cmd IN ( ? ) ORDER BY time DESC LIMIT " + i + " OFFSET " + i2, new String[]{String.valueOf(j), str});
                    }
                    cursor = e;
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            GroupNewsPojo groupNewsPojo = new GroupNewsPojo();
                            groupNewsPojo.setCmd(cursor.getString(cursor.getColumnIndex("cmd")));
                            groupNewsPojo.setContent(cursor.getString(cursor.getColumnIndex("content")));
                            groupNewsPojo.setContent_status(cursor.getInt(cursor.getColumnIndex("content_status")));
                            groupNewsPojo.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                            groupNewsPojo.setGid(cursor.getString(cursor.getColumnIndex(TbEnum.ParamKey.GID)));
                            groupNewsPojo.setNotice_id(cursor.getString(cursor.getColumnIndex("notice_id")));
                            groupNewsPojo.setTime(cursor.getLong(cursor.getColumnIndex("time")));
                            linkedList.add(groupNewsPojo);
                        }
                    }
                } catch (Exception e2) {
                    TiebaStatic.printDBExceptionLog(e2, "GroupNewsDao.getAllByCmd", new Object[0]);
                    e2.printStackTrace();
                }
                fi.a(cursor);
                return h(linkedList);
            } catch (Throwable th) {
                fi.a(cursor);
                throw th;
            }
        }
        return (LinkedList) invokeCommon.objValue;
    }

    public int d(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i)) == null) {
            Cursor cursor = null;
            int i2 = 0;
            try {
                try {
                    try {
                        cursor = qf8.d().e(String.format("select count(*) from tb_group_news WHERE cmd IN ( '%1$s' ) and content_status = %2$s", str, "" + i), null);
                        i2 = cursor.moveToFirst() ? cursor.getInt(0) : -1;
                    } catch (Exception e) {
                        TiebaStatic.printDBExceptionLog(e, "GroupNewsDao.getNewCountByCmd", new Object[0]);
                        e.printStackTrace();
                    }
                } catch (SQLiteException e2) {
                    TiebaStatic.printDBExceptionLog(e2, "GroupNewsDao.getNewCountByCmd", new Object[0]);
                    e2.printStackTrace();
                }
                return i2;
            } finally {
                fi.a(cursor);
            }
        }
        return invokeLI.intValue;
    }

    public boolean g(String str, int i) {
        InterceptResult invokeLI;
        Cursor e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i)) == null) {
            Cursor cursor = null;
            String str2 = null;
            cursor = null;
            if (i < 1000) {
                i = 1000;
            }
            try {
                try {
                    qf8 d = qf8.d();
                    e = d.e("SELECT * FROM tb_group_news ORDER BY notice_id DESC LIMIT " + i + ", 1", null);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (e.moveToNext()) {
                    str2 = e.getString(e.getColumnIndex("notice_id"));
                }
                fi.a(e);
                if (str2 != null) {
                    qf8.d().delete("tb_group_news", "notice_id<?", new String[]{str2});
                }
                fi.a(e);
                return true;
            } catch (Exception e3) {
                e = e3;
                cursor = e;
                e.printStackTrace();
                TiebaStatic.printDBExceptionLog(e, "shrink", new Object[0]);
                fi.a(cursor);
                return false;
            } catch (Throwable th2) {
                th = th2;
                cursor = e;
                fi.a(cursor);
                throw th;
            }
        }
        return invokeLI.booleanValue;
    }

    public int e(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, str, i)) == null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("content_status", (Integer) 3);
                    return qf8.d().update("tb_group_news", contentValues, "notice_id= ?", new String[]{str});
                }
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "GroupNewsDao.hideByNoticeIdSync", new Object[0]);
                e.printStackTrace();
            }
            return 0;
        }
        return invokeLI.intValue;
    }

    public final long f(GroupNewsPojo groupNewsPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, groupNewsPojo)) == null) {
            try {
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("INSERT INTO ");
                    stringBuffer.append("tb_group_news");
                    stringBuffer.append("(");
                    stringBuffer.append("cmd");
                    stringBuffer.append(",");
                    stringBuffer.append("content");
                    stringBuffer.append(",");
                    stringBuffer.append("content_status");
                    stringBuffer.append(",");
                    stringBuffer.append("ext");
                    stringBuffer.append(",");
                    stringBuffer.append(TbEnum.ParamKey.GID);
                    stringBuffer.append(",");
                    stringBuffer.append("notice_id");
                    stringBuffer.append(",");
                    stringBuffer.append("time");
                    stringBuffer.append(") VALUES(?,?,?,?,?,?,?)");
                    SQLiteStatement a2 = qf8.d().a(stringBuffer.toString());
                    if (a2 == null) {
                        fi.c(a2);
                        return -1L;
                    }
                    a2.clearBindings();
                    of8.b(a2, 1, groupNewsPojo.getCmd());
                    of8.b(a2, 2, groupNewsPojo.getContent());
                    a2.bindLong(3, groupNewsPojo.getContent_status());
                    of8.b(a2, 4, groupNewsPojo.getExt());
                    of8.b(a2, 5, groupNewsPojo.getGid());
                    of8.b(a2, 6, groupNewsPojo.getNotice_id());
                    a2.bindLong(7, groupNewsPojo.getTime());
                    long executeInsert = a2.executeInsert();
                    fi.c(a2);
                    return executeInsert;
                } catch (Exception e) {
                    TiebaStatic.printDBExceptionLog(e, "GroupNewsDao.insertByStatement", new Object[0]);
                    fi.c(null);
                    return -1L;
                }
            } catch (Throwable th) {
                fi.c(null);
                throw th;
            }
        }
        return invokeL.longValue;
    }

    public final LinkedList<GroupNewsPojo> h(LinkedList<GroupNewsPojo> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, linkedList)) == null) {
            LinkedList<GroupNewsPojo> linkedList2 = new LinkedList<>();
            ArrayList arrayList = new ArrayList();
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                GroupNewsPojo groupNewsPojo = linkedList.get(i);
                boolean z = false;
                for (int i2 = 0; i2 < linkedList2.size(); i2++) {
                    if (linkedList2.get(i2).getContent().equals(groupNewsPojo.getContent())) {
                        z = true;
                    }
                }
                if (z) {
                    arrayList.add(groupNewsPojo.getNotice_id());
                } else {
                    linkedList2.add(groupNewsPojo);
                }
                int size2 = arrayList.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    e((String) arrayList.get(i3), 3);
                }
            }
            return linkedList2;
        }
        return (LinkedList) invokeL.objValue;
    }

    public Boolean i(LinkedList<GroupNewsPojo> linkedList) {
        InterceptResult invokeL;
        ValidateItemData validateItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, linkedList)) == null) {
            Boolean bool = Boolean.FALSE;
            if (linkedList != null && linkedList.size() != 0) {
                try {
                    try {
                        qf8.d().f();
                        Iterator<GroupNewsPojo> it = linkedList.iterator();
                        LinkedList<GroupNewsPojo> linkedList2 = null;
                        List<ValidateItemData> list = null;
                        while (it.hasNext()) {
                            GroupNewsPojo next = it.next();
                            if (next.getCmd().equals("apply_join_group")) {
                                if (linkedList2 == null) {
                                    linkedList2 = b(0L, Integer.MAX_VALUE, 0, "apply_join_group");
                                    if (ModelHelper.getInstance().getValidateModel() != null) {
                                        list = ModelHelper.getInstance().getValidateModel().convertToValidateItemDataList(linkedList2);
                                    }
                                    if (list == null) {
                                        list = new LinkedList<>();
                                    }
                                }
                                if (list != null) {
                                    if (ModelHelper.getInstance().getValidateModel() != null) {
                                        validateItemData = ModelHelper.getInstance().getValidateModel().convertToValidateItemData(next);
                                    } else {
                                        validateItemData = null;
                                    }
                                    if (validateItemData != null) {
                                        for (ValidateItemData validateItemData2 : list) {
                                            if (validateItemData.getUserId() != null && validateItemData.getUserId().equals(validateItemData2.getUserId()) && validateItemData.getGroupId() != null && validateItemData.getGroupId().equals(validateItemData2.getGroupId())) {
                                                a(validateItemData2.getNotice_id());
                                            }
                                        }
                                    }
                                }
                            }
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("cmd", next.getCmd());
                            contentValues.put("content", next.getContent());
                            contentValues.put("content_status", Integer.valueOf(next.getContent_status()));
                            contentValues.put("ext", next.getExt());
                            contentValues.put(TbEnum.ParamKey.GID, next.getGid());
                            contentValues.put("notice_id", next.getNotice_id());
                            contentValues.put("time", Long.valueOf(next.getTime()));
                            if (qf8.d().update("tb_group_news", contentValues, "notice_id=?", new String[]{next.getNotice_id()}) == 0) {
                                f(next);
                            }
                            bool = Boolean.valueOf(bool.booleanValue() & true);
                        }
                    } catch (Exception e) {
                        TiebaStatic.printDBExceptionLog(e, "GroupNewsDao.updateData", new Object[0]);
                        e.printStackTrace();
                        bool = Boolean.FALSE;
                    }
                    return bool;
                } finally {
                    qf8.d().b();
                }
            }
            return Boolean.FALSE;
        }
        return (Boolean) invokeL.objValue;
    }
}
