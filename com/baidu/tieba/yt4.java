package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class yt4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<UserData> a;
    public ArrayList<UserData> b;
    public st4 c;

    public yt4() {
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
        this.a = new ArrayList<>();
        this.b = new ArrayList<>();
        this.c = new st4();
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            try {
                b(new JSONObject(str));
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("common_user_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    UserData userData = new UserData();
                    userData.parserJson(optJSONArray.getJSONObject(i));
                    userData.mAttentionType = 2;
                    this.a.add(userData);
                }
            }
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    UserData userData2 = new UserData();
                    userData2.parserJson(optJSONArray2.getJSONObject(i2));
                    userData2.mAttentionType = 1;
                    this.b.add(userData2);
                }
            }
            this.c.i(jSONObject.optJSONObject("page"));
            jSONObject.optInt("tafriendnum", 0);
            jSONObject.optInt("commonfriendnum", 0);
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
