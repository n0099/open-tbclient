package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class ne7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            SharedPrefHelper.getInstance().putString(SharedPrefHelper.getSharedPrefKeyWithAccount("search_forum_history"), "");
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        String string = SharedPrefHelper.getInstance().getString(SharedPrefHelper.getSharedPrefKeyWithAccount("search_forum_history"), "");
        if (!StringUtils.isNull(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray.length() <= 0) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    Object obj = jSONArray.get(i);
                    if (!str.equals(obj)) {
                        arrayList.add((String) obj);
                    }
                }
                SharedPrefHelper.getInstance().putString(SharedPrefHelper.getSharedPrefKeyWithAccount("search_forum_history"), new JSONArray((Collection) arrayList).toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void d(String str) {
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        String string = SharedPrefHelper.getInstance().getString(SharedPrefHelper.getSharedPrefKeyWithAccount("search_forum_history"), "");
        try {
            if (StringUtils.isNull(string)) {
                jSONArray = new JSONArray();
            } else {
                jSONArray = new JSONArray(string);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            int i = 1;
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                Object obj = jSONArray.get(i2);
                if ((obj instanceof String) && !str.equals(obj)) {
                    arrayList.add((String) obj);
                    i++;
                }
                if (i == 6) {
                    break;
                }
            }
            SharedPrefHelper.getInstance().putString(SharedPrefHelper.getSharedPrefKeyWithAccount("search_forum_history"), new JSONArray((Collection) arrayList).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String string = SharedPrefHelper.getInstance().getString(SharedPrefHelper.getSharedPrefKeyWithAccount("search_forum_history"), "");
            ArrayList<String> arrayList = null;
            if (StringUtils.isNull(string)) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray.length() <= 0) {
                    return null;
                }
                ArrayList<String> arrayList2 = new ArrayList<>();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        Object obj = jSONArray.get(i);
                        if (obj instanceof String) {
                            arrayList2.add((String) obj);
                        }
                    } catch (JSONException e) {
                        e = e;
                        arrayList = arrayList2;
                        e.printStackTrace();
                        return arrayList;
                    }
                }
                return arrayList2;
            } catch (JSONException e2) {
                e = e2;
            }
        } else {
            return (ArrayList) invokeV.objValue;
        }
    }
}
