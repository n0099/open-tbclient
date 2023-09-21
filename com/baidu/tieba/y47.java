package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.faceshop.CollectEmotionData;
import com.baidu.tieba.faceshop.DiyEmotionData;
import com.baidu.tieba.faceshop.EmotionData;
import com.baidu.tieba.faceshop.EmotionGroupData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class y47 {
    public static /* synthetic */ Interceptable $ic;
    public static y47 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948280269, "Lcom/baidu/tieba/y47;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948280269, "Lcom/baidu/tieba/y47;");
                return;
            }
        }
        a = new y47();
    }

    public y47() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static y47 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a;
        }
        return (y47) invokeV.objValue;
    }

    public boolean a(CollectEmotionData collectEmotionData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, collectEmotionData)) == null) {
            SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
            f.beginTransaction();
            try {
                f.delete("user_collect_emotion", "uid = ? and pid = ?", new String[]{TbadkCoreApplication.getCurrentAccountForEmotion(), collectEmotionData.pid});
                ContentValues contentValues = new ContentValues();
                contentValues.put("pid", collectEmotionData.pid);
                contentValues.put("uid", collectEmotionData.uid);
                if (!TextUtils.isEmpty(collectEmotionData.getSharpText())) {
                    contentValues.put("sharp_text", collectEmotionData.getSharpText().toLowerCase());
                } else {
                    contentValues.put("sharp_text", "");
                }
                contentValues.put("order_id", Integer.valueOf(collectEmotionData.getOrderId()));
                contentValues.put("width", Integer.valueOf(collectEmotionData.width));
                contentValues.put("height", Integer.valueOf(collectEmotionData.height));
                contentValues.put("pic_url", collectEmotionData.picUrl);
                contentValues.put("thumbnail", collectEmotionData.thumbnail);
                contentValues.put("backup", collectEmotionData.backup);
                f.insert("user_collect_emotion", null, contentValues);
                f.setTransactionSuccessful();
                f.endTransaction();
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean c(DiyEmotionData diyEmotionData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, diyEmotionData)) == null) {
            o9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            SQLiteDatabase f = mainDBDatabaseManager.f();
            f.beginTransaction();
            try {
                f.delete("user_diy_emotion", "uid = ? and pid = ?", new String[]{TbadkCoreApplication.getCurrentAccountForEmotion(), diyEmotionData.getPid()});
                ContentValues contentValues = new ContentValues();
                contentValues.put("pid", diyEmotionData.getPid());
                contentValues.put("uid", diyEmotionData.getUid());
                if (!TextUtils.isEmpty(diyEmotionData.getSharpText())) {
                    contentValues.put("sharp_text", diyEmotionData.getSharpText().toLowerCase());
                } else {
                    contentValues.put("sharp_text", "");
                }
                contentValues.put("order_id", Integer.valueOf(diyEmotionData.getOrderId()));
                contentValues.put("width", Integer.valueOf(diyEmotionData.getWidth()));
                contentValues.put("height", Integer.valueOf(diyEmotionData.getHeight()));
                contentValues.put("pic_url", diyEmotionData.getPicUrl());
                contentValues.put("thumbnail", diyEmotionData.getThumbnail());
                contentValues.put("backup", diyEmotionData.getBackup());
                f.insert("user_diy_emotion", null, contentValues);
                f.setTransactionSuccessful();
                return true;
            } catch (Throwable th) {
                try {
                    mainDBDatabaseManager.h(th, "EmotionsDBManager.addDiyEmotion");
                    return false;
                } finally {
                    f.endTransaction();
                }
            }
        }
        return invokeL.booleanValue;
    }

    public boolean g(EmotionGroupData emotionGroupData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, emotionGroupData)) == null) {
            o9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            SQLiteDatabase f = mainDBDatabaseManager.f();
            f.beginTransaction();
            try {
                f.delete("emotion_group", "groupId = ?", new String[]{emotionGroupData.groupId});
                ContentValues contentValues = new ContentValues();
                contentValues.put("groupId", emotionGroupData.groupId);
                contentValues.put(TbEnum.SystemMessage.KEY_GROUP_NAME, emotionGroupData.groupName);
                contentValues.put("groupDesc", emotionGroupData.groupDesc);
                contentValues.put("emotionsCount", Integer.valueOf(emotionGroupData.emotionsCount));
                contentValues.put("width", Integer.valueOf(emotionGroupData.width));
                contentValues.put("height", Integer.valueOf(emotionGroupData.height));
                contentValues.put("status", Integer.valueOf(emotionGroupData.status));
                contentValues.put("downloadTime", Long.valueOf(emotionGroupData.downloadTime));
                contentValues.put("bytesLength", Integer.valueOf(emotionGroupData.bytesLength));
                contentValues.put("bytesReceived", Integer.valueOf(emotionGroupData.bytesReceived));
                contentValues.put(TTDownloadField.TT_DOWNLOAD_URL, emotionGroupData.downloadUrl);
                f.insert("emotion_group", null, contentValues);
                f.setTransactionSuccessful();
                return true;
            } catch (Throwable th) {
                try {
                    mainDBDatabaseManager.h(th, "EmotionsDBManager.addEmotionGroup");
                    return false;
                } finally {
                    f.endTransaction();
                }
            }
        }
        return invokeL.booleanValue;
    }

    public EmotionGroupData u(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, cursor)) == null) {
            EmotionGroupData emotionGroupData = new EmotionGroupData();
            emotionGroupData.groupId = cursor.getString(cursor.getColumnIndex("groupId"));
            emotionGroupData.groupName = cursor.getString(cursor.getColumnIndex(TbEnum.SystemMessage.KEY_GROUP_NAME));
            emotionGroupData.groupDesc = cursor.getString(cursor.getColumnIndex("groupDesc"));
            emotionGroupData.emotionsCount = cursor.getInt(cursor.getColumnIndex("emotionsCount"));
            emotionGroupData.width = cursor.getInt(cursor.getColumnIndex("width"));
            emotionGroupData.height = cursor.getInt(cursor.getColumnIndex("height"));
            emotionGroupData.status = cursor.getInt(cursor.getColumnIndex("status"));
            emotionGroupData.downloadTime = cursor.getInt(cursor.getColumnIndex("downloadTime"));
            emotionGroupData.bytesLength = cursor.getInt(cursor.getColumnIndex("bytesLength"));
            emotionGroupData.bytesReceived = cursor.getInt(cursor.getColumnIndex("bytesReceived"));
            emotionGroupData.downloadUrl = cursor.getString(cursor.getColumnIndex(TTDownloadField.TT_DOWNLOAD_URL));
            return emotionGroupData;
        }
        return (EmotionGroupData) invokeL.objValue;
    }

    public boolean b(List<CollectEmotionData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list == null) {
                return false;
            }
            int i = 0;
            for (CollectEmotionData collectEmotionData : list) {
                if (collectEmotionData != null && a(collectEmotionData)) {
                    i++;
                }
            }
            if (i <= 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean d(List<DiyEmotionData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (list == null) {
                return false;
            }
            int i = 0;
            for (DiyEmotionData diyEmotionData : list) {
                if (diyEmotionData != null && c(diyEmotionData)) {
                    i++;
                }
            }
            if (i <= 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void i(CollectEmotionData collectEmotionData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, collectEmotionData) != null) || collectEmotionData == null) {
            return;
        }
        o9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        try {
            mainDBDatabaseManager.f().delete("user_collect_emotion", "pid = ? and uid = ? ", new String[]{collectEmotionData.pid, collectEmotionData.uid});
        } catch (Throwable th) {
            mainDBDatabaseManager.h(th, "EmotionsDBManager.deleteCurCollect");
        }
    }

    public void j(DiyEmotionData diyEmotionData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, diyEmotionData) != null) || diyEmotionData == null) {
            return;
        }
        o9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        try {
            mainDBDatabaseManager.f().delete("user_diy_emotion", "pid = ? and uid = ? ", new String[]{diyEmotionData.getPid(), diyEmotionData.getUid()});
        } catch (Throwable th) {
            mainDBDatabaseManager.h(th, "EmotionsDBManager.deleteCurDiy");
        }
    }

    public boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            o9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            SQLiteDatabase f = mainDBDatabaseManager.f();
            f.beginTransaction();
            try {
                f.delete("emotions", "groupId = ?", new String[]{str});
                f.setTransactionSuccessful();
                return true;
            } catch (Throwable th) {
                try {
                    mainDBDatabaseManager.h(th, "EmotionsDBManager.deleteEmotion");
                    return false;
                } finally {
                    f.endTransaction();
                }
            }
        }
        return invokeL.booleanValue;
    }

    public EmotionData t(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, cursor)) == null) {
            EmotionData emotionData = new EmotionData();
            emotionData.setSharpText(cursor.getString(cursor.getColumnIndex("sharpText")));
            emotionData.setGroupId(cursor.getString(cursor.getColumnIndex("groupId")));
            emotionData.setOrderId(cursor.getInt(cursor.getColumnIndex("orderId")));
            return emotionData;
        }
        return (EmotionData) invokeL.objValue;
    }

    public boolean e(EmotionData emotionData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, emotionData)) == null) {
            o9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            SQLiteDatabase f = mainDBDatabaseManager.f();
            f.beginTransaction();
            try {
                f.delete("emotions", "sharpText = ?", new String[]{emotionData.getSharpText()});
                ContentValues contentValues = new ContentValues();
                contentValues.put("sharpText", emotionData.getSharpText());
                contentValues.put("groupId", emotionData.getGroupId());
                contentValues.put("orderId", Integer.valueOf(emotionData.getOrderId()));
                f.insert("emotions", null, contentValues);
                f.setTransactionSuccessful();
                return true;
            } catch (Throwable th) {
                try {
                    mainDBDatabaseManager.h(th, "EmotionsDBManager.addEmotion");
                    return false;
                } finally {
                    f.endTransaction();
                }
            }
        }
        return invokeL.booleanValue;
    }

    public boolean f(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048581, this, str, str2, i)) == null) {
            EmotionData emotionData = new EmotionData();
            emotionData.setSharpText(str);
            emotionData.setGroupId(str2);
            emotionData.setOrderId(i);
            return e(emotionData);
        }
        return invokeLLI.booleanValue;
    }

    public boolean h(String str, EmotionGroupData emotionGroupData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, emotionGroupData)) == null) {
            if (TextUtils.isEmpty(str) || emotionGroupData == null) {
                return false;
            }
            o9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            SQLiteDatabase f = mainDBDatabaseManager.f();
            f.beginTransaction();
            try {
                f.delete(EmotionUtil.TABLE_NAME_USER_EMOTIONS, "uid = ? and groupId = ?", new String[]{str, emotionGroupData.groupId});
                ContentValues contentValues = new ContentValues();
                contentValues.put("uid", str);
                contentValues.put("groupId", emotionGroupData.groupId);
                contentValues.put("updateTime", Long.valueOf(System.currentTimeMillis()));
                f.insert(EmotionUtil.TABLE_NAME_USER_EMOTIONS, null, contentValues);
                f.setTransactionSuccessful();
                return true;
            } catch (Throwable th) {
                try {
                    mainDBDatabaseManager.h(th, "EmotionsDBManager.addToMyEmotion");
                    return false;
                } finally {
                    f.endTransaction();
                }
            }
        }
        return invokeLL.booleanValue;
    }

    public void s(List<String> list, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, list, str) == null) && list != null && !list.isEmpty()) {
            Collections.reverse(list);
            o9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            SQLiteDatabase f = mainDBDatabaseManager.f();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    ContentValues contentValues = new ContentValues();
                    long j = 1 + currentTimeMillis;
                    contentValues.put("updateTime", Long.valueOf(currentTimeMillis));
                    f.update(EmotionUtil.TABLE_NAME_USER_EMOTIONS, contentValues, "uid = ? and groupId = ?", new String[]{str, it.next()});
                    currentTimeMillis = j;
                }
            } catch (Throwable th) {
                mainDBDatabaseManager.h(th, "EmotionsDBManager.orderEmotion");
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, CONST_STR, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public int l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            Cursor cursor = null;
            int i = 1;
            try {
                cursor = TiebaDatabase.getInstance().getMainDBDatabaseManager().f().rawQuery("SELECT count(*) FROM user_collect_emotion where uid = ? order by order_id asc ", new String[]{str});
                while (cursor.moveToNext()) {
                    i = cursor.getInt(0);
                }
            } finally {
                try {
                    return i;
                } finally {
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, CONST_STR, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public int m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            Cursor cursor = null;
            int i = 1;
            try {
                cursor = TiebaDatabase.getInstance().getMainDBDatabaseManager().f().rawQuery("SELECT count(*) FROM user_diy_emotion where uid = ? order by order_id asc ", new String[]{str});
                while (cursor.moveToNext()) {
                    i = cursor.getInt(0);
                }
            } finally {
                try {
                    return i;
                } finally {
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public EmotionGroupData n(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            o9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            try {
                cursor = mainDBDatabaseManager.f().rawQuery("SELECT * FROM emotion_group where groupId = ? ", new String[]{str});
                try {
                    if (cursor.moveToNext()) {
                        return u(cursor);
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        mainDBDatabaseManager.h(th, "EmotionsDBManager.getEmotionGroup");
                        return null;
                    } finally {
                        ei.a(cursor);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
            return null;
        }
        return (EmotionGroupData) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, CONST_STR, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public List<EmotionData> p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
            LinkedList linkedList = new LinkedList();
            Cursor cursor = null;
            try {
                cursor = f.rawQuery("SELECT * FROM emotions where groupId = ? order by orderId asc ", new String[]{String.valueOf(str)});
                while (cursor.moveToNext()) {
                    linkedList.add(t(cursor));
                }
            } finally {
                try {
                    return linkedList;
                } finally {
                }
            }
            return linkedList;
        }
        return (List) invokeL.objValue;
    }

    public void v(CollectEmotionData collectEmotionData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, collectEmotionData) != null) || collectEmotionData == null) {
            return;
        }
        o9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        SQLiteDatabase f = mainDBDatabaseManager.f();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("order_id", Integer.valueOf(collectEmotionData.getOrderId()));
            f.update("user_collect_emotion", contentValues, "uid = ? and pid = ?", new String[]{collectEmotionData.uid, collectEmotionData.pid});
        } catch (Throwable th) {
            mainDBDatabaseManager.h(th, "EmotionsDBManager.updateCollect");
        }
    }

    public void w(DiyEmotionData diyEmotionData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, diyEmotionData) != null) || diyEmotionData == null) {
            return;
        }
        o9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        SQLiteDatabase f = mainDBDatabaseManager.f();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("order_id", Integer.valueOf(diyEmotionData.getOrderId()));
            f.update("user_diy_emotion", contentValues, "uid = ? and pid = ?", new String[]{diyEmotionData.getUid(), diyEmotionData.getPid()});
        } catch (Throwable th) {
            mainDBDatabaseManager.h(th, "EmotionsDBManager.updateDiy");
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, CONST_STR, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public List<CollectEmotionData> q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (TextUtils.isEmpty(str)) {
                return arrayList;
            }
            Cursor cursor = null;
            try {
                cursor = TiebaDatabase.getInstance().getMainDBDatabaseManager().f().rawQuery("SELECT * FROM user_collect_emotion where uid = ? order by order_id desc ", new String[]{str});
                while (cursor.moveToNext()) {
                    CollectEmotionData collectEmotionData = new CollectEmotionData();
                    collectEmotionData.pid = cursor.getString(cursor.getColumnIndex("pid"));
                    collectEmotionData.uid = cursor.getString(cursor.getColumnIndex("uid"));
                    collectEmotionData.setSharpText(cursor.getString(cursor.getColumnIndex("sharp_text")).toLowerCase());
                    collectEmotionData.setOrderId(cursor.getInt(cursor.getColumnIndex("order_id")));
                    collectEmotionData.width = cursor.getInt(cursor.getColumnIndex("width"));
                    collectEmotionData.height = cursor.getInt(cursor.getColumnIndex("height"));
                    collectEmotionData.picUrl = cursor.getString(cursor.getColumnIndex("pic_url"));
                    collectEmotionData.thumbnail = cursor.getString(cursor.getColumnIndex("thumbnail"));
                    collectEmotionData.backup = cursor.getString(cursor.getColumnIndex("backup"));
                    collectEmotionData.setGroupId("collect_" + collectEmotionData.uid);
                    arrayList.add(collectEmotionData);
                }
            } finally {
                try {
                    return arrayList;
                } finally {
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, CONST_STR, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public List<DiyEmotionData> r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (TextUtils.isEmpty(str)) {
                return arrayList;
            }
            Cursor cursor = null;
            try {
                cursor = TiebaDatabase.getInstance().getMainDBDatabaseManager().f().rawQuery("SELECT * FROM user_diy_emotion where uid = ? order by order_id desc ", new String[]{str});
                while (cursor.moveToNext()) {
                    DiyEmotionData diyEmotionData = new DiyEmotionData();
                    diyEmotionData.setPid(cursor.getString(cursor.getColumnIndex("pid")));
                    diyEmotionData.setUid(cursor.getString(cursor.getColumnIndex("uid")));
                    diyEmotionData.setSharpText(cursor.getString(cursor.getColumnIndex("sharp_text")).toLowerCase());
                    diyEmotionData.setOrderId(cursor.getInt(cursor.getColumnIndex("order_id")));
                    diyEmotionData.setWidth(cursor.getInt(cursor.getColumnIndex("width")));
                    diyEmotionData.setHeight(cursor.getInt(cursor.getColumnIndex("height")));
                    diyEmotionData.setPicUrl(cursor.getString(cursor.getColumnIndex("pic_url")));
                    diyEmotionData.setThumbnail(cursor.getString(cursor.getColumnIndex("thumbnail")));
                    diyEmotionData.setBackup(cursor.getString(cursor.getColumnIndex("backup")));
                    diyEmotionData.setGroupId("diy_" + diyEmotionData.getUid());
                    arrayList.add(diyEmotionData);
                }
            } finally {
                try {
                    return arrayList;
                } finally {
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
