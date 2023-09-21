package com.baidu.tieba;

import android.database.Cursor;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tieba.database.FrsVisitedInfoManager;
import com.baidu.tieba.jy6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes7.dex */
public final class ly6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public static final Map<String, Map<String, wfa>> c(jy6.a aVar, List<String> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, aVar, list)) == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String replace$default = StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(list.toString(), PreferencesUtil.LEFT_MOUNT, "(", false, 4, (Object) null), PreferencesUtil.RIGHT_MOUNT, SmallTailInfo.EMOTION_SUFFIX, false, 4, (Object) null);
            Cursor b = aVar.b(StringsKt__IndentKt.trimIndent("\n            SELECT * FROM forum_visited_info \n            WHERE fid IN " + replace$default + " \n            ORDER BY fid, date \n            DESC"), new String[0]);
            try {
                if (b.moveToFirst()) {
                    do {
                        String fid = b.getString(0);
                        String date = b.getString(1);
                        long j = b.getLong(2);
                        long j2 = b.getLong(3);
                        wfa wfaVar = new wfa();
                        wfaVar.g(fid);
                        wfaVar.f(date);
                        wfaVar.e(j);
                        wfaVar.h(j2);
                        if (linkedHashMap.get(fid) == null) {
                            Intrinsics.checkNotNullExpressionValue(fid, "fid");
                            linkedHashMap.put(fid, new LinkedHashMap());
                        }
                        Map map = (Map) linkedHashMap.get(fid);
                        if (map != null) {
                            Intrinsics.checkNotNullExpressionValue(date, "date");
                            map.put(date, wfaVar);
                        }
                        m41.i(b, new Column[]{jy6.a.d(0), jy6.a.d(1), jy6.a.c(2), jy6.a.c(3)});
                    } while (b.moveToNext());
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(b, null);
                    return linkedHashMap;
                }
                Unit unit2 = Unit.INSTANCE;
                CloseableKt.closeFinally(b, null);
                return linkedHashMap;
            } finally {
            }
        } else {
            return (Map) invokeLL.objValue;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public static final List<String> d(jy6.a aVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, aVar, i)) == null) {
            String curDate = FrsVisitedInfoManager.d.b().format(new Date());
            String fifteenAgoDate = FrsVisitedInfoManager.d.b().format(TimeHelper.getNDaysAgoDate(-14));
            Intrinsics.checkNotNullExpressionValue(fifteenAgoDate, "fifteenAgoDate");
            Intrinsics.checkNotNullExpressionValue(curDate, "curDate");
            Cursor b = aVar.b("SELECT fid, sum(custom_count) as sum_counts \nFROM forum_visited_info \nWHERE date BETWEEN ? AND ? \nGROUP BY fid \nORDER BY sum_counts \nDESC \nLIMIT ?", fifteenAgoDate, curDate, String.valueOf(i));
            try {
                ArrayList arrayList = new ArrayList();
                if (b.moveToFirst()) {
                    do {
                        String fid = b.getString(0);
                        Intrinsics.checkNotNullExpressionValue(fid, "fid");
                        arrayList.add(fid);
                        m41.i(b, new Column[]{jy6.a.d(0), jy6.a.b(1)});
                    } while (b.moveToNext());
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(b, null);
                    return arrayList;
                }
                Unit unit2 = Unit.INSTANCE;
                CloseableKt.closeFinally(b, null);
                return arrayList;
            } finally {
            }
        } else {
            return (List) invokeLI.objValue;
        }
    }
}
