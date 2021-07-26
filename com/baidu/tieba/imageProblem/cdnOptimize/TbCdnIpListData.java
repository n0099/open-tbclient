package com.baidu.tieba.imageProblem.cdnOptimize;

import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class TbCdnIpListData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f18039a;

    /* renamed from: b  reason: collision with root package name */
    public String f18040b;

    /* renamed from: c  reason: collision with root package name */
    public String f18041c;

    /* renamed from: d  reason: collision with root package name */
    public String f18042d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<ArrayList<String>> f18043e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f18044f;

    /* renamed from: g  reason: collision with root package name */
    public String f18045g;

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
        this.f18039a = 0;
        this.f18040b = null;
        this.f18041c = null;
        this.f18042d = null;
        this.f18044f = false;
        this.f18045g = null;
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
                this.f18039a = optJSONObject.optInt("errorno");
                this.f18040b = optJSONObject.optString("errmsg");
            }
            if (1 == jSONObject.optInt("cdn_switch")) {
                this.f18044f = true;
            } else {
                this.f18044f = false;
            }
            this.f18045g = jSONObject.optString("cdn_domain");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("cdn_img_info");
            if (optJSONObject2 != null) {
                this.f18041c = optJSONObject2.optString(BigdayActivityConfig.IMG_URL);
                this.f18042d = optJSONObject2.optString("img_md5");
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
                    this.f18043e = arrayList;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
