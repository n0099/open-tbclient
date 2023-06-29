package com.baidu.tieba;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class u76 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile SQLiteDatabase a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            synchronized (u76.class) {
                yi.b(a);
            }
        }
    }

    public static synchronized SQLiteDatabase b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (u76.class) {
                try {
                } catch (Exception e) {
                    TiebaStatic.printDBExceptionLog(e, "RelationshipDbManager.getRelationshipDataBase", new Object[0]);
                }
                if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                    return null;
                }
                if (a != null && a.isOpen()) {
                    return a;
                }
                a = new t76(TbadkCoreApplication.getInst().getApp()).getWritableDatabase();
                return a;
            }
        }
        return (SQLiteDatabase) invokeV.objValue;
    }
}
