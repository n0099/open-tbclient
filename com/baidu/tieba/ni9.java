package com.baidu.tieba;

import com.baidu.android.imsdk.retrieve.util.FileMetaUtil;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ni9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, jSONObject, str)) == null) {
            try {
                jSONObject.put("bosMessage", str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static JSONObject b(File file, String str, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{file, str, str2, str3, Boolean.valueOf(z)})) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errno", str2);
                jSONObject.put("errmsg", str3);
                jSONObject.put(FileMetaUtil.IS_FILE, z ? "1" : "0");
                if (file != null && file.exists() && file.isFile()) {
                    jSONObject.put(FileMetaUtil.ZIP_PATH, str);
                    jSONObject.put("size", String.valueOf(file.length()));
                    jSONObject.put(FileMetaUtil.CREATE_TIME, file.lastModified());
                    jSONObject.put(FileMetaUtil.MODIFY_TIME, file.lastModified());
                }
            } catch (Exception e) {
                if (AppConfig.isDebug()) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject c(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (list != null) {
                try {
                    if (list.size() > 0) {
                        StringBuilder sb = new StringBuilder();
                        for (String str : list) {
                            sb.append(str);
                            sb.append("&");
                        }
                        jSONObject.put("space", sb.toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
