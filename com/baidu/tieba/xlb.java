package com.baidu.tieba;

import android.content.Context;
import android.database.Cursor;
import com.baidu.android.util.io.FileUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class xlb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public int g;
    public String h;
    public String i;
    public String j;

    public static String d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            switch (i) {
                case 1:
                    return "Banner";
                case 2:
                    return "插屏";
                case 3:
                case 4:
                    return "开屏";
                case 5:
                    return "信息流";
                case 6:
                    return "贴片";
                case 7:
                    return "激励";
                case 8:
                    return "全屏";
                case 9:
                    return "Draw";
                default:
                    return FileUtils.UNKNOW;
            }
        }
        return (String) invokeI.objValue;
    }

    public xlb() {
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

    public static xlb a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            xlb xlbVar = new xlb();
            xlbVar.a = str;
            Cursor cursor = null;
            try {
                Cursor b = bmb.b(context, "setting_rit", null, "rit=?", new String[]{str}, null, null, "rit ASC");
                if (b == null) {
                    if (b != null) {
                        b.close();
                    }
                    return xlbVar;
                }
                if (b.moveToNext()) {
                    try {
                        JSONObject jSONObject = new JSONObject(zlb.g(b.getString(b.getColumnIndex("slot"))));
                        xlbVar.c = jSONObject.optString("img_width");
                        xlbVar.d = jSONObject.optString("img_height");
                        xlbVar.e = jSONObject.optString("express_width");
                        xlbVar.f = jSONObject.optString("express_height");
                        xlbVar.g = jSONObject.optInt("ad_count");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        xlbVar.b = d(new JSONObject(zlb.g(new JSONObject(b.getString(b.getColumnIndex("value"))).optString("message"))).optInt("slot_type"));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    try {
                        JSONObject jSONObject2 = new JSONObject(zlb.g(b.getString(b.getColumnIndex("config"))));
                        xlbVar.h = jSONObject2.optString("aid");
                        xlbVar.i = jSONObject2.optString("cid");
                        xlbVar.j = jSONObject2.optString("ext");
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                if (b != null) {
                    b.close();
                }
                return xlbVar;
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }
        return (xlb) invokeLL.objValue;
    }

    public static xlb b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            xlb xlbVar = new xlb();
            try {
                JSONObject jSONObject = new JSONObject(str);
                xlbVar.a = jSONObject.getString("ritId");
                xlbVar.c = jSONObject.getString("imgWidth");
                xlbVar.d = jSONObject.getString("imgHeight");
                xlbVar.e = jSONObject.getString("expressWidth");
                xlbVar.f = jSONObject.getString("expressHeight");
                xlbVar.g = jSONObject.getInt("adCount");
                xlbVar.h = jSONObject.getString("previewAid");
                xlbVar.i = jSONObject.getString("previewCid");
                xlbVar.j = jSONObject.getString("previewExt");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return xlbVar;
        }
        return (xlb) invokeL.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ritId", this.a);
                jSONObject.put("imgWidth", this.c);
                jSONObject.put("imgHeight", this.d);
                jSONObject.put("expressWidth", this.e);
                jSONObject.put("expressHeight", this.f);
                jSONObject.put("adCount", this.g);
                jSONObject.put("previewAid", this.h);
                jSONObject.put("previewCid", this.i);
                jSONObject.put("previewExt", this.j);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
