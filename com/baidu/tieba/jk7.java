package com.baidu.tieba;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.compatible.EditorHelper;
import com.baidu.tieba.funAd.strategy.FunAdHistoryData;
import com.baidu.tieba.funAd.strategy.FunAdSidConfigData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class jk7 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jk7 b;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;

    public jk7() {
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
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        arrayList.add("pb_banner");
        this.a.add("frs_feed");
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            SharedPreferences.Editor edit = g().edit();
            edit.clear();
            return edit.commit();
        }
        return invokeV.booleanValue;
    }

    public static jk7 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (ik7.class) {
                    if (b == null) {
                        b = new jk7();
                    }
                }
            }
            return b;
        }
        return (jk7) invokeV.objValue;
    }

    public static SharedPreferences g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return TbadkCoreApplication.getInst().getSharedPreferences("fun_ad_sid_strategy_shaedpref_name", 0);
        }
        return (SharedPreferences) invokeV.objValue;
    }

    public List<String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    public void a(String str) {
        FunAdSidConfigData b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            ArrayList<FunAdHistoryData> c = hk7.f().c(str);
            if (ListUtils.isEmpty(c) || (b2 = ik7.e().b(str)) == null) {
                return;
            }
            List<FunAdHistoryData> h = h(c, b2.getRecordNum(), b2.getExpiryTime());
            SharedPreferences g = g();
            if (i(h, b2.getThreshold(), b2.getSpace(), g.getLong(str + "_fun_ad_last_change_sid_time", 0L))) {
                j(str, b2);
            }
        }
    }

    public String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if ("frs_feed".equals(str) && UbsABTestHelper.isFrsFunAdSdkTest() && UbsABTestHelper.isGetFunAdPreLoadABTest()) {
                return "6051002409-2123988582";
            }
            if (!UbsABTestHelper.isDuplicateRemovalFunAdABTest()) {
                return f(str);
            }
            FunAdSidConfigData b2 = ik7.e().b(str);
            if (b2 == null) {
                return f(str);
            }
            if (ListUtils.isEmpty(b2.getBearSidList())) {
                return f(str);
            }
            SharedPreferences g = g();
            return g.getString(str + "_fun_ad_current_sid_suffix", f(str));
        }
        return (String) invokeL.objValue;
    }

    public String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if ("pb_banner".equals(str)) {
                return dk7.o();
            }
            if ("frs_feed".equals(str)) {
                return dk7.e();
            }
            if ("pic".equals(str)) {
                return dk7.r();
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public final List<FunAdHistoryData> h(List<FunAdHistoryData> list, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{list, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            int size = list.size();
            if (size > i) {
                list = ListUtils.subList(list, size - i, size);
            }
            int size2 = list.size();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            int i2 = 0;
            Iterator<FunAdHistoryData> it = list.iterator();
            while (it.hasNext() && currentTimeMillis - it.next().getShowTime() > j) {
                i2++;
            }
            return ListUtils.subList(list, i2, size2);
        }
        return (List) invokeCommon.objValue;
    }

    public final boolean i(List<FunAdHistoryData> list, int i, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{list, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if ((System.currentTimeMillis() / 1000) - j2 <= j) {
                return false;
            }
            HashMap hashMap = new HashMap();
            for (FunAdHistoryData funAdHistoryData : list) {
                if (funAdHistoryData != null) {
                    String funAdKey = funAdHistoryData.getFunAdKey();
                    if (TextUtils.isEmpty(funAdKey)) {
                        continue;
                    } else {
                        Integer num = (Integer) hashMap.get(funAdKey);
                        if (num == null) {
                            num = 0;
                        }
                        if (num.intValue() + 1 >= i) {
                            return true;
                        }
                        hashMap.put(funAdKey, Integer.valueOf(num.intValue() + 1));
                    }
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final void j(String str, FunAdSidConfigData funAdSidConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, funAdSidConfigData) == null) {
            SharedPreferences g = g();
            int i = g.getInt(str + "_fun_ad_current_sid_index_suffix", -1);
            List<String> bearSidList = funAdSidConfigData.getBearSidList();
            if (ListUtils.isEmpty(bearSidList)) {
                return;
            }
            int size = (i + 1) % bearSidList.size();
            String str2 = (String) ListUtils.getItem(bearSidList, size);
            SharedPreferences g2 = g();
            EditorHelper.putInt(g2, str + "_fun_ad_current_sid_index_suffix", size);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            SharedPreferences g3 = g();
            EditorHelper.putString(g3, str + "_fun_ad_current_sid_suffix", str2);
            SharedPreferences g4 = g();
            EditorHelper.putLong(g4, str + "_fun_ad_last_change_sid_time", System.currentTimeMillis() / 1000);
        }
    }

    public void k(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) {
            if (jSONObject != null && UbsABTestHelper.isDuplicateRemovalFunAdABTest()) {
                for (String str : this.a) {
                    if (!TextUtils.isEmpty(str)) {
                        FunAdSidConfigData funAdSidConfigData = new FunAdSidConfigData();
                        JSONObject jSONObject2 = null;
                        if (jSONObject.has(str)) {
                            try {
                                jSONObject2 = jSONObject.getJSONObject(str);
                            } catch (JSONException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (jSONObject2 != null) {
                            funAdSidConfigData.parserJson(jSONObject2);
                            if (funAdSidConfigData.getForce() == 1) {
                                ik7.e().f(str, funAdSidConfigData);
                                SharedPreferences g = g();
                                EditorHelper.putInt(g, str + "_fun_ad_current_sid_index_suffix", -1);
                                j(str, funAdSidConfigData);
                            } else {
                                SharedPreferences g2 = g();
                                if ((System.currentTimeMillis() / 1000) - g2.getLong(str + "_fun_ad_last_change_sid_time", 0L) > funAdSidConfigData.getSpace()) {
                                    ik7.e().f(str, funAdSidConfigData);
                                    SharedPreferences g3 = g();
                                    EditorHelper.putInt(g3, str + "_fun_ad_current_sid_index_suffix", -1);
                                    j(str, funAdSidConfigData);
                                }
                            }
                        }
                    }
                }
                return;
            }
            b();
        }
    }
}
