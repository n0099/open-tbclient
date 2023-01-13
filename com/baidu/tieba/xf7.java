package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class xf7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public long d;
        public String e;
        public long f;
        public String g;
        public long h;
        public int i;
        public int j;

        public a() {
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
            this.a = null;
            this.b = null;
            this.c = null;
            this.f = 0L;
            this.g = null;
            this.h = 0L;
            this.i = 0;
            this.j = 0;
        }
    }

    public static a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            a aVar = new a();
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    aVar.a = optJSONObject.optString(TableDefine.UserInfoColumns.COLUMN_HEAD_URL);
                    aVar.b = optJSONObject.optString("user_id");
                    aVar.c = optJSONObject.optString("nick_name");
                    aVar.d = optJSONObject.optLong("caller_time");
                    aVar.e = optJSONObject.optString("caller_content");
                    aVar.f = optJSONObject.optLong("thread_id");
                    aVar.g = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
                    optJSONObject.optString("forum_name");
                    aVar.h = optJSONObject.optLong("post_id");
                    aVar.i = optJSONObject.optInt("msg_type");
                    aVar.j = optJSONObject.optInt("remind_count");
                }
                return aVar;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (a) invokeL.objValue;
    }
}
