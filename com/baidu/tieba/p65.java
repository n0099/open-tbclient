package com.baidu.tieba;

import android.content.SharedPreferences;
import com.baidu.android.util.KVStorageFactory;
import com.baidu.searchbox.retrieve.debug.provider.DebugActiveUploadResult;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.UniKVTestSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class p65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            if (UniKVTestSwitch.getIsOn()) {
                sharedPreferences = KVStorageFactory.getSharedPreferences("UniKVTest", 0);
            } else {
                sharedPreferences = TbadkCoreApplication.getInst().getSharedPreferences("UniKVTest", 0);
            }
            int i = sharedPreferences.getInt(DebugActiveUploadResult.SOURCE, 0);
            StatisticItem statisticItem = new StatisticItem("shoubai_kv_test");
            StatisticItem addParam = statisticItem.addParam("obj_source", UniKVTestSwitch.getIsOn() + "");
            TiebaStatic.log(addParam.addParam("obj_param1", i + ""));
            sharedPreferences.edit().putInt(DebugActiveUploadResult.SOURCE, i + 1).apply();
        }
    }
}
