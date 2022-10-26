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
/* loaded from: classes6.dex */
public class x97 {
    public static /* synthetic */ Interceptable $ic;
    public static x97 a;
    public transient /* synthetic */ FieldHolder $fh;

    public x97() {
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

    public static x97 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                a = new x97();
            }
            return a;
        }
        return (x97) invokeV.objValue;
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Boolean bool;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                ba7.d().delete("tb_group_news", "notice_id = ?", new String[]{str});
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

    public LinkedList b(long j, int i, int i2, String str) {
        InterceptResult invokeCommon;
        Cursor e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str})) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            LinkedList linkedList = new LinkedList();
            if (i <= 0) {
                i = 20;
            }
            Cursor cursor = null;
            try {
                try {
                    if (j <= 0) {
                        if (TextUtils.isEmpty(str)) {
                            e = ba7.d().e("select * from tb_group_news ORDER BY time DESC LIMIT " + i + " OFFSET " + i2, null);
                        } else {
                            e = ba7.d().e(String.format("select * from tb_group_news WHERE cmd IN ( '%1$s' ) ORDER BY time DESC LIMIT " + i + " OFFSET " + i2, str), null);
                        }
                    } else if (TextUtils.isEmpty(str)) {
                        e = ba7.d().e("select * from tb_group_news WHERE time <=? ORDER BY time DESC LIMIT " + i + " OFFSET " + i2, new String[]{String.valueOf(j)});
                    } else {
                        e = ba7.d().e("select * from tb_group_news WHERE time <=? AND cmd IN ( ? ) ORDER BY time DESC LIMIT " + i + " OFFSET " + i2, new String[]{String.valueOf(j), str});
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
                gj.a(cursor);
                return h(linkedList);
            } catch (Throwable th) {
                gj.a(cursor);
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
                        cursor = ba7.d().e(String.format("select count(*) from tb_group_news WHERE cmd IN ( '%1$s' ) and content_status = %2$s", str, "" + i), null);
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
                gj.a(cursor);
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
                    ba7 d = ba7.d();
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
                gj.a(e);
                if (str2 != null) {
                    ba7.d().delete("tb_group_news", "notice_id<?", new String[]{str2});
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

    public int e(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, str, i)) == null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("content_status", (Integer) 3);
                    return ba7.d().update("tb_group_news", contentValues, "notice_id= ?", new String[]{str});
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
                    SQLiteStatement a2 = ba7.d().a(stringBuffer.toString());
                    if (a2 == null) {
                        gj.c(a2);
                        return -1L;
                    }
                    a2.clearBindings();
                    z97.b(a2, 1, groupNewsPojo.getCmd());
                    z97.b(a2, 2, groupNewsPojo.getContent());
                    a2.bindLong(3, groupNewsPojo.getContent_status());
                    z97.b(a2, 4, groupNewsPojo.getExt());
                    z97.b(a2, 5, groupNewsPojo.getGid());
                    z97.b(a2, 6, groupNewsPojo.getNotice_id());
                    a2.bindLong(7, groupNewsPojo.getTime());
                    long executeInsert = a2.executeInsert();
                    gj.c(a2);
                    return executeInsert;
                } catch (Exception e) {
                    TiebaStatic.printDBExceptionLog(e, "GroupNewsDao.insertByStatement", new Object[0]);
                    gj.c(null);
                    return -1L;
                }
            } catch (Throwable th) {
                gj.c(null);
                throw th;
            }
        }
        return invokeL.longValue;
    }

    public final LinkedList h(LinkedList linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, linkedList)) == null) {
            LinkedList linkedList2 = new LinkedList();
            ArrayList arrayList = new ArrayList();
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                GroupNewsPojo groupNewsPojo = (GroupNewsPojo) linkedList.get(i);
                boolean z = false;
                for (int i2 = 0; i2 < linkedList2.size(); i2++) {
                    if (((GroupNewsPojo) linkedList2.get(i2)).getContent().equals(groupNewsPojo.getContent())) {
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

    public Boolean i(LinkedList linkedList) {
        InterceptResult invokeL;
        ValidateItemData validateItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, linkedList)) == null) {
            Boolean bool = Boolean.FALSE;
            if (linkedList != null && linkedList.size() != 0) {
                try {
                    try {
                        ba7.d().f();
                        Iterator it = linkedList.iterator();
                        LinkedList linkedList2 = null;
                        List<ValidateItemData> list = null;
                        while (it.hasNext()) {
                            GroupNewsPojo groupNewsPojo = (GroupNewsPojo) it.next();
                            if (groupNewsPojo.getCmd().equals("apply_join_group")) {
                                if (linkedList2 == null) {
                                    linkedList2 = b(0L, Integer.MAX_VALUE, 0, "apply_join_group");
                                    if (ModelHelper.getInstance().getValidateModel() != null) {
                                        list = ModelHelper.getInstance().getValidateModel().convertToValidateItemDataList(linkedList2);
                                    }
                                    if (list == null) {
                                        list = new LinkedList();
                                    }
                                }
                                if (list != null) {
                                    if (ModelHelper.getInstance().getValidateModel() != null) {
                                        validateItemData = ModelHelper.getInstance().getValidateModel().convertToValidateItemData(groupNewsPojo);
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
                            contentValues.put("cmd", groupNewsPojo.getCmd());
                            contentValues.put("content", groupNewsPojo.getContent());
                            contentValues.put("content_status", Integer.valueOf(groupNewsPojo.getContent_status()));
                            contentValues.put("ext", groupNewsPojo.getExt());
                            contentValues.put(TbEnum.ParamKey.GID, groupNewsPojo.getGid());
                            contentValues.put("notice_id", groupNewsPojo.getNotice_id());
                            contentValues.put("time", Long.valueOf(groupNewsPojo.getTime()));
                            if (ba7.d().update("tb_group_news", contentValues, "notice_id=?", new String[]{groupNewsPojo.getNotice_id()}) == 0) {
                                f(groupNewsPojo);
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
                    ba7.d().b();
                }
            }
            return Boolean.FALSE;
        }
        return (Boolean) invokeL.objValue;
    }
}
