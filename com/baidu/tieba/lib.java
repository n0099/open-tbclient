package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class lib {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TreeMap<String, String> a;
    public TreeMap<String, String> b;

    public lib(TreeMap<String, String> treeMap, TreeMap<String, String> treeMap2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {treeMap, treeMap2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = treeMap;
        this.b = treeMap2;
    }

    public static lib a(String str) {
        InterceptResult invokeL;
        TreeMap<String, String> treeMap;
        TreeMap<String, String> treeMap2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            TreeMap<String, String> treeMap3 = null;
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("mText");
                if (optString != null && !optString.isEmpty()) {
                    treeMap2 = c(optString);
                } else {
                    treeMap2 = null;
                }
                try {
                    String optString2 = jSONObject.optString("mImages");
                    if (optString2 != null && !optString2.isEmpty()) {
                        treeMap3 = c(optString2);
                    }
                } catch (JSONException e) {
                    treeMap = treeMap2;
                    e = e;
                    e.printStackTrace();
                    treeMap2 = treeMap;
                    return new lib(treeMap2, treeMap3);
                }
            } catch (JSONException e2) {
                e = e2;
                treeMap = null;
            }
            return new lib(treeMap2, treeMap3);
        }
        return (lib) invokeL.objValue;
    }

    public static String b(TreeMap<String, String> treeMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, treeMap)) == null) {
            if (treeMap != null && !treeMap.isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, String> entry : treeMap.entrySet()) {
                    try {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                return jSONObject.toString();
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static TreeMap<String, String> c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str != null && !str.isEmpty()) {
                TreeMap<String, String> treeMap = new TreeMap<>();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        treeMap.put(next, (String) jSONObject.get(next));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return treeMap;
            }
            return null;
        }
        return (TreeMap) invokeL.objValue;
    }

    public static String d(lib libVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, libVar)) == null) {
            if (libVar == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mText", b(libVar.a));
                jSONObject.put("mImages", b(libVar.b));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
