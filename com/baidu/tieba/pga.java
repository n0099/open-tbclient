package com.baidu.tieba;

import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class pga {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public ArrayList<pga> e;

    public pga() {
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

    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            this.a = jSONObject.optString(ForumListActivityConfig.KEY_MENU_TYPE);
            this.b = jSONObject.optString("menu_name");
            this.c = jSONObject.optString("menu_id");
            String str = null;
            String optString = jSONObject.optString("default_logo_url", null);
            this.d = optString;
            if (optString != null) {
                str = this.d + "?v=2";
            }
            this.d = str;
            if (jSONObject.has("child_menu_list")) {
                ArrayList<pga> arrayList = new ArrayList<>();
                JSONArray optJSONArray = jSONObject.optJSONArray("child_menu_list");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    pga pgaVar = new pga();
                    pgaVar.a(optJSONArray.getJSONObject(i));
                    arrayList.add(pgaVar);
                }
                this.e = arrayList;
            }
        }
    }
}
