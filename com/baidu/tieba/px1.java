package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class px1 extends gx1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ku1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "PreviewImageApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements zk3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ArrayMap a;
        public final /* synthetic */ JSONArray b;
        public final /* synthetic */ JSONArray c;
        public final /* synthetic */ JSONArray d;
        public final /* synthetic */ JSONObject e;
        public final /* synthetic */ px1 f;

        public a(px1 px1Var, ArrayMap arrayMap, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {px1Var, arrayMap, jSONArray, jSONArray2, jSONArray3, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = px1Var;
            this.a = arrayMap;
            this.b = jSONArray;
            this.c = jSONArray2;
            this.d = jSONArray3;
            this.e = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zk3
        /* renamed from: b */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = null;
            try {
                jSONArray = new JSONArray(str);
            } catch (JSONException unused) {
            }
            if (jSONArray != null && jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    String optString = optJSONObject.optString("fileID");
                    String optString2 = optJSONObject.optString("tempFileURL");
                    if (optJSONObject.optString("status").equals("0") && !TextUtils.isEmpty(optString2)) {
                        this.a.put(optString, optString2);
                    }
                }
                this.f.H(this.a, this.b, "images");
                this.f.H(this.a, this.c, "urls");
                this.f.H(this.a, this.d, "url");
                try {
                    this.e.put("images", this.b);
                    this.e.put("urls", this.c);
                    this.e.put("url", this.d);
                } catch (JSONException unused2) {
                }
                SwanAppActivity activity = tr2.V().getActivity();
                if (activity != null) {
                    np2.C().b(activity, this.e);
                } else {
                    np2.C().b(this.f.i(), this.e);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public px1(@NonNull iu1 iu1Var) {
        super(iu1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iu1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((iu1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final int A(@NonNull JSONObject jSONObject, @NonNull JSONArray jSONArray) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, jSONArray)) == null) {
            int optInt = jSONObject.optInt(ProgressInfo.JSON_KEY_CURRENT, -1);
            if (optInt >= 0) {
                return optInt;
            }
            String optString = jSONObject.optString(ProgressInfo.JSON_KEY_CURRENT);
            if (TextUtils.isEmpty(optString)) {
                return 0;
            }
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                if (TextUtils.equals(optString, jSONArray.getString(i))) {
                    return i;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public final String B(JSONArray jSONArray, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray, str, i)) == null) {
            if (str.equals("images")) {
                return jSONArray.optJSONObject(i).optString("url");
            }
            return jSONArray.optString(i);
        }
        return (String) invokeLLI.objValue;
    }

    public hy1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            r("#handlePreviewImage", false);
            if (o()) {
                g32.c("PreviewImageApi", "PreviewImageApi does not supported when app is invisible.");
                return new hy1(1001, "PreviewImageApi does not supported when app is invisible.");
            } else if (TextUtils.isEmpty(str)) {
                return new hy1(202);
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optBoolean("only_support_wifi") && !SwanAppNetworkUtils.j(i())) {
                        return new hy1(403);
                    }
                    String optString = jSONObject.optString("source", "unitedscheme");
                    String optString2 = jSONObject.optString("type", "0");
                    JSONArray optJSONArray = jSONObject.optJSONArray("urls");
                    if (optJSONArray != null && optJSONArray.length() != 0) {
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("images");
                        if (optJSONArray2 != null) {
                            G(optJSONArray2);
                            jSONObject.put("images", optJSONArray2);
                        } else {
                            JSONArray jSONArray = new JSONArray();
                            int length = optJSONArray.length();
                            for (int i = 0; i < length; i++) {
                                JSONObject jSONObject2 = new JSONObject();
                                String optString3 = optJSONArray.optString(i);
                                jSONObject2.put("url", optString3);
                                String b = nj3.b();
                                if (nj3.c(optString3) && !TextUtils.isEmpty(b)) {
                                    jSONObject2.put("referer", b);
                                }
                                String h0 = ad2.V().h0();
                                if (!TextUtils.isEmpty(h0)) {
                                    jSONObject2.put("user_agent", h0);
                                }
                                jSONArray.put(jSONObject2);
                            }
                            jSONObject.put("images", jSONArray);
                        }
                        if (TextUtils.equals(optString, "swan")) {
                            D(optJSONArray);
                        }
                        jSONObject.put("url", optJSONArray);
                        jSONObject.put("type", optString2);
                        int A = A(jSONObject, optJSONArray);
                        if (A >= 0 && A < optJSONArray.length()) {
                            jSONObject.put("index", String.valueOf(A));
                            ArrayMap<String, String> arrayMap = new ArrayMap<>();
                            JSONArray optJSONArray3 = jSONObject.optJSONArray("images");
                            JSONArray optJSONArray4 = jSONObject.optJSONArray("urls");
                            JSONArray optJSONArray5 = jSONObject.optJSONArray("url");
                            E(arrayMap, optJSONArray3, "images");
                            E(arrayMap, optJSONArray4, "urls");
                            E(arrayMap, optJSONArray5, "url");
                            if (arrayMap.keySet().size() > 0) {
                                F(jSONObject, arrayMap, optJSONArray3, optJSONArray4, optJSONArray5);
                            } else {
                                Context activity = tr2.V().getActivity();
                                if (activity != null) {
                                    np2.C().b(activity, jSONObject);
                                } else {
                                    np2.C().b(i(), jSONObject);
                                }
                            }
                            return hy1.f();
                        }
                        return new hy1(202);
                    }
                    return new hy1(202);
                } catch (JSONException unused) {
                    return new hy1(202);
                }
            }
        }
        return (hy1) invokeL.objValue;
    }

    public final JSONArray D(JSONArray jSONArray) {
        InterceptResult invokeL;
        g63 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONArray)) == null) {
            int length = jSONArray.length();
            if (jSONArray != null && length > 0 && (M = g63.M()) != null && !TextUtils.isEmpty(M.b) && !TextUtils.isEmpty(M.l0())) {
                for (int i = 0; i < length; i++) {
                    try {
                        String optString = jSONArray.optString(i);
                        PathType s = od3.s(optString);
                        if (s == PathType.BD_FILE) {
                            optString = od3.M(optString, M.b);
                        } else if (s == PathType.RELATIVE) {
                            optString = od3.L(optString, M, M.l0());
                        }
                        if (!TextUtils.isEmpty(optString)) {
                            jSONArray.put(i, optString);
                        }
                    } catch (JSONException unused) {
                    }
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public final void G(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jSONArray) == null) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("url");
                        String b = nj3.b();
                        if (nj3.c(optString) && !TextUtils.isEmpty(b)) {
                            optJSONObject.put("referer", b);
                        }
                        String h0 = ad2.V().h0();
                        if (!TextUtils.isEmpty(h0)) {
                            optJSONObject.put("user_agent", h0);
                        }
                    }
                } catch (JSONException unused) {
                    return;
                }
            }
        }
    }

    public final void E(ArrayMap<String, String> arrayMap, JSONArray jSONArray, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048580, this, arrayMap, jSONArray, str) == null) && jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                String B = B(jSONArray, str, i);
                if (!TextUtils.isEmpty(B) && od3.s(B) == PathType.CLOUD) {
                    arrayMap.put(B, B);
                }
            }
        }
    }

    public final void F(JSONObject jSONObject, ArrayMap<String, String> arrayMap, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLLL(1048581, this, jSONObject, arrayMap, jSONArray, jSONArray2, jSONArray3) == null) && jSONObject != null && arrayMap != null && arrayMap.keySet().size() > 0) {
            JSONArray jSONArray4 = new JSONArray();
            for (String str : arrayMap.values()) {
                jSONArray4.put(str);
            }
            pq1 l = np2.l();
            if (l == null) {
                return;
            }
            l.c(i(), jSONArray4, new a(this, arrayMap, jSONArray, jSONArray2, jSONArray3, jSONObject));
        }
    }

    public final void H(ArrayMap<String, String> arrayMap, JSONArray jSONArray, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048583, this, arrayMap, jSONArray, str) == null) && arrayMap != null && jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                String str2 = arrayMap.get(B(jSONArray, str, i));
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        if (str.equals("images")) {
                            jSONArray.optJSONObject(i).put("url", str2);
                        } else {
                            jSONArray.put(i, str2);
                        }
                    } catch (JSONException unused) {
                    }
                }
            }
        }
    }
}
