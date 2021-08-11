package com.bytedance.sdk.openadsdk.core.e;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f66119a;

    /* renamed from: b  reason: collision with root package name */
    public int f66120b;

    /* renamed from: c  reason: collision with root package name */
    public String f66121c;

    /* renamed from: d  reason: collision with root package name */
    public String f66122d;

    /* renamed from: e  reason: collision with root package name */
    public String f66123e;

    /* renamed from: f  reason: collision with root package name */
    public int f66124f;

    /* renamed from: g  reason: collision with root package name */
    public int f66125g;

    /* renamed from: h  reason: collision with root package name */
    public int f66126h;

    public o(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("playable");
        if (optJSONObject != null) {
            this.f66122d = optJSONObject.optString("playable_url", "");
            this.f66123e = optJSONObject.optString("playable_download_url", "");
            this.f66124f = optJSONObject.optInt("if_playable_loading_show", 0);
            this.f66125g = optJSONObject.optInt("remove_loading_page_type", 0);
            this.f66126h = optJSONObject.optInt("playable_orientation", 0);
        }
        this.f66119a = jSONObject.optBoolean("is_playable");
        this.f66120b = jSONObject.optInt("playable_type", 0);
        this.f66121c = jSONObject.optString("playable_style");
    }

    public static boolean b(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, mVar)) == null) {
            o l = l(mVar);
            return (l == null || !l.f66119a || TextUtils.isEmpty(d(mVar))) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public static String c(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, mVar)) == null) {
            o l = l(mVar);
            if (l == null) {
                return null;
            }
            return l.f66121c;
        }
        return (String) invokeL.objValue;
    }

    public static String d(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, mVar)) == null) {
            o l = l(mVar);
            if (l == null) {
                return null;
            }
            return l.f66122d;
        }
        return (String) invokeL.objValue;
    }

    public static String e(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, mVar)) == null) {
            if (mVar == null) {
                return null;
            }
            if (!TextUtils.isEmpty(d(mVar))) {
                return d(mVar);
            }
            return mVar.V().j();
        }
        return (String) invokeL.objValue;
    }

    public static boolean f(m mVar) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, mVar)) == null) {
            if (TextUtils.isEmpty(d(mVar))) {
                if (mVar != null && mVar.V() != null) {
                    i2 = mVar.V().q();
                }
                i2 = 0;
            } else {
                o l = l(mVar);
                if (l != null) {
                    i2 = l.f66124f;
                }
                i2 = 0;
            }
            return i2 != 1;
        }
        return invokeL.booleanValue;
    }

    public static boolean g(m mVar) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, mVar)) == null) {
            if (TextUtils.isEmpty(d(mVar))) {
                if (mVar != null && mVar.V() != null) {
                    i2 = mVar.V().r();
                }
                i2 = 0;
            } else {
                o l = l(mVar);
                if (l != null) {
                    i2 = l.f66125g;
                }
                i2 = 0;
            }
            return i2 != 1;
        }
        return invokeL.booleanValue;
    }

    public static boolean h(m mVar) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, mVar)) == null) {
            if (TextUtils.isEmpty(d(mVar))) {
                if (mVar == null || mVar.V() == null) {
                    return false;
                }
                i2 = mVar.V().r();
            } else {
                o l = l(mVar);
                if (l == null) {
                    return false;
                }
                i2 = l.f66125g;
            }
            return i2 == 1;
        }
        return invokeL.booleanValue;
    }

    public static int i(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, mVar)) == null) {
            o l = l(mVar);
            if (l == null) {
                return 0;
            }
            return l.f66126h;
        }
        return invokeL.intValue;
    }

    public static boolean j(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, mVar)) == null) ? a(mVar) && m(mVar) == 1 : invokeL.booleanValue;
    }

    public static boolean k(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, mVar)) == null) ? a(mVar) && m(mVar) == 0 : invokeL.booleanValue;
    }

    public static o l(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, mVar)) == null) {
            if (mVar == null) {
                return null;
            }
            return mVar.g();
        }
        return (o) invokeL.objValue;
    }

    public static int m(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, mVar)) == null) {
            o l = l(mVar);
            if (l == null) {
                return 0;
            }
            return l.f66120b;
        }
        return invokeL.intValue;
    }

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            try {
                jSONObject.put("is_playable", this.f66119a);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (!TextUtils.isEmpty(this.f66122d)) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("playable_url", this.f66122d);
                    jSONObject2.put("playable_download_url", this.f66123e);
                    jSONObject2.put("if_playable_loading_show", this.f66124f);
                    jSONObject2.put("remove_loading_page_type", this.f66125g);
                    jSONObject2.put("playable_orientation", this.f66126h);
                    jSONObject.put("playable", jSONObject2);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            try {
                jSONObject.put("playable_type", this.f66120b);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            try {
                jSONObject.put("playable_style", this.f66121c);
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
        }
    }

    public static boolean a(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, mVar)) == null) {
            o l = l(mVar);
            return (l == null || !l.f66119a || TextUtils.isEmpty(e(mVar))) ? false : true;
        }
        return invokeL.booleanValue;
    }
}
