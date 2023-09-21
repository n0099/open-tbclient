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
/* loaded from: classes7.dex */
public class pnb {
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

    public pnb() {
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

    public static pnb a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            pnb pnbVar = new pnb();
            pnbVar.a = str;
            Cursor cursor = null;
            try {
                Cursor b = tnb.b(context, "setting_rit", null, "rit=?", new String[]{str}, null, null, "rit ASC");
                if (b == null) {
                    if (b != null) {
                        b.close();
                    }
                    return pnbVar;
                }
                if (b.moveToNext()) {
                    try {
                        JSONObject jSONObject = new JSONObject(rnb.g(b.getString(b.getColumnIndex("slot"))));
                        pnbVar.c = jSONObject.optString("img_width");
                        pnbVar.d = jSONObject.optString("img_height");
                        pnbVar.e = jSONObject.optString("express_width");
                        pnbVar.f = jSONObject.optString("express_height");
                        pnbVar.g = jSONObject.optInt("ad_count");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        pnbVar.b = d(new JSONObject(rnb.g(new JSONObject(b.getString(b.getColumnIndex("value"))).optString("message"))).optInt("slot_type"));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    try {
                        JSONObject jSONObject2 = new JSONObject(rnb.g(b.getString(b.getColumnIndex("config"))));
                        pnbVar.h = jSONObject2.optString("aid");
                        pnbVar.i = jSONObject2.optString("cid");
                        pnbVar.j = jSONObject2.optString("ext");
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                if (b != null) {
                    b.close();
                }
                return pnbVar;
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }
        return (pnb) invokeLL.objValue;
    }

    public static pnb b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            pnb pnbVar = new pnb();
            try {
                JSONObject jSONObject = new JSONObject(str);
                pnbVar.a = jSONObject.getString("ritId");
                pnbVar.c = jSONObject.getString("imgWidth");
                pnbVar.d = jSONObject.getString("imgHeight");
                pnbVar.e = jSONObject.getString("expressWidth");
                pnbVar.f = jSONObject.getString("expressHeight");
                pnbVar.g = jSONObject.getInt("adCount");
                pnbVar.h = jSONObject.getString("previewAid");
                pnbVar.i = jSONObject.getString("previewCid");
                pnbVar.j = jSONObject.getString("previewExt");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return pnbVar;
        }
        return (pnb) invokeL.objValue;
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
