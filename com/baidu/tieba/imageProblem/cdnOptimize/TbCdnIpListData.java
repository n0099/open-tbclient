package com.baidu.tieba.imageProblem.cdnOptimize;

import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class TbCdnIpListData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f53305a;

    /* renamed from: b  reason: collision with root package name */
    public String f53306b;

    /* renamed from: c  reason: collision with root package name */
    public String f53307c;

    /* renamed from: d  reason: collision with root package name */
    public String f53308d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<ArrayList<String>> f53309e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f53310f;

    /* renamed from: g  reason: collision with root package name */
    public String f53311g;

    public TbCdnIpListData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f53305a = 0;
        this.f53306b = null;
        this.f53307c = null;
        this.f53308d = null;
        this.f53310f = false;
        this.f53311g = null;
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
                this.f53305a = optJSONObject.optInt("errorno");
                this.f53306b = optJSONObject.optString("errmsg");
            }
            if (1 == jSONObject.optInt("cdn_switch")) {
                this.f53310f = true;
            } else {
                this.f53310f = false;
            }
            this.f53311g = jSONObject.optString("cdn_domain");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("cdn_img_info");
            if (optJSONObject2 != null) {
                this.f53307c = optJSONObject2.optString(BigdayActivityConfig.IMG_URL);
                this.f53308d = optJSONObject2.optString("img_md5");
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("ip_list");
            if (optJSONArray2 != null) {
                int length = optJSONArray2.length();
                ArrayList<ArrayList<String>> arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(i2);
                    if (jSONObject2 != null && (optJSONArray = jSONObject2.optJSONArray("ip")) != null) {
                        int length2 = optJSONArray.length();
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        for (int i3 = 0; i3 < length2; i3++) {
                            String string = optJSONArray.getString(i3);
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
                    this.f53309e = arrayList;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
