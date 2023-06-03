package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.SocialOperation;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class mo4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final int b;
    public final int c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final Set<String> h;
    public final String i;
    public final Long j;
    public int k;

    public mo4(String str, int i, int i2, String str2, String str3, String str4, String str5, Set<String> set, String str6, Long l) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2), str2, str3, str4, str5, set, str6, l};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.c = i2;
        this.b = i;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = str5;
        this.h = set;
        this.i = str6;
        this.j = l;
    }

    public static mo4 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        HashSet hashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            try {
                String optString = jSONObject.optString("version");
                if (TextUtils.isEmpty(optString) || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
                    return null;
                }
                String optString2 = optJSONObject.optString("content_type");
                int optInt = optJSONObject.optInt("official_no");
                int optInt2 = optJSONObject.optInt("container_no");
                String optString3 = optJSONObject.optString("host_name");
                String optString4 = optJSONObject.optString("share_callback_url");
                JSONArray optJSONArray = optJSONObject.optJSONArray(SocialOperation.GAME_SIGNATURE);
                String optString5 = optJSONObject.optString("scheme_head");
                String optString6 = optJSONObject.optString("failure_url");
                HashSet hashSet2 = new HashSet();
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        String optString7 = optJSONArray.optString(i);
                        if (!TextUtils.isEmpty(optString7)) {
                            hashSet2.add(optString7);
                        }
                    }
                }
                if (hashSet2.size() > 0) {
                    hashSet = hashSet2;
                } else {
                    hashSet = null;
                }
                mo4 mo4Var = new mo4(optString2, optInt, optInt2, optString3, optString4, optString6, optString, hashSet, optString5, null);
                mo4Var.k = optJSONObject.optInt("use_openbundleid", -1);
                return mo4Var;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (mo4) invokeL.objValue;
    }
}
