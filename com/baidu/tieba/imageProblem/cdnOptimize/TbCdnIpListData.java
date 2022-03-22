package com.baidu.tieba.imageProblem.cdnOptimize;

import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class TbCdnIpListData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f34088b;

    /* renamed from: c  reason: collision with root package name */
    public String f34089c;

    /* renamed from: d  reason: collision with root package name */
    public String f34090d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<ArrayList<String>> f34091e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f34092f;

    /* renamed from: g  reason: collision with root package name */
    public String f34093g;

    public TbCdnIpListData() {
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
        this.a = 0;
        this.f34088b = null;
        this.f34089c = null;
        this.f34090d = null;
        this.f34092f = false;
        this.f34093g = null;
    }

    public void parseJson(JSONObject jSONObject) {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("error");
            if (optJSONObject != null) {
                this.a = optJSONObject.optInt("errorno");
                this.f34088b = optJSONObject.optString("errmsg");
            }
            if (1 == jSONObject.optInt("cdn_switch")) {
                this.f34092f = true;
            } else {
                this.f34092f = false;
            }
            this.f34093g = jSONObject.optString("cdn_domain");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("cdn_img_info");
            if (optJSONObject2 != null) {
                this.f34089c = optJSONObject2.optString(BigdayActivityConfig.IMG_URL);
                this.f34090d = optJSONObject2.optString("img_md5");
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("ip_list");
            if (optJSONArray2 != null) {
                int length = optJSONArray2.length();
                ArrayList<ArrayList<String>> arrayList = new ArrayList<>();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(i);
                    if (jSONObject2 != null && (optJSONArray = jSONObject2.optJSONArray("ip")) != null) {
                        int length2 = optJSONArray.length();
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        for (int i2 = 0; i2 < length2; i2++) {
                            String string = optJSONArray.getString(i2);
                            if (string != null && string.length() > 0) {
                                arrayList2.add(string);
                            }
                        }
                        if (arrayList2.size() > 0) {
                            arrayList.add(arrayList2);
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    this.f34091e = arrayList;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
