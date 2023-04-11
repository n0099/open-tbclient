package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AppTransmitData;
/* loaded from: classes5.dex */
public class pp5 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TiebaStatic.Params.WISE_SAMPLE_ID, c());
                jSONObject.put(DI.YY.YY_HDID, TbadkCoreApplication.getInst().getHdid());
                jSONObject.put("yy_version", "");
            } catch (JSONException e) {
                BdLog.e(e);
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public static AppTransmitData b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            AppTransmitData.Builder builder = new AppTransmitData.Builder();
            builder.wise_sample_id = c();
            builder.yy_hdid = TbadkCoreApplication.getInst().getHdid();
            builder.yy_version = "";
            return builder.build(false);
        }
        return (AppTransmitData) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a;
        }
        return (String) invokeV.objValue;
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            a = str;
        }
    }
}
