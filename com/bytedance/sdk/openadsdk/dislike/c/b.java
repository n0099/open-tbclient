package com.bytedance.sdk.openadsdk.dislike.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.PersonalizationPrompt;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f67148a;

    /* renamed from: b  reason: collision with root package name */
    public List<FilterWord> f67149b;

    /* renamed from: c  reason: collision with root package name */
    public PersonalizationPrompt f67150c;

    /* renamed from: d  reason: collision with root package name */
    public String f67151d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f67152e;

    /* renamed from: f  reason: collision with root package name */
    public String f67153f;

    /* renamed from: g  reason: collision with root package name */
    public String f67154g;

    /* renamed from: h  reason: collision with root package name */
    public String f67155h;

    public b(JSONObject jSONObject) {
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
        this.f67148a = 0;
        this.f67149b = new ArrayList();
        this.f67148a = jSONObject.optInt("dislike_control", 0);
        this.f67152e = jSONObject.optBoolean("close_on_dislike", false);
        JSONArray optJSONArray = jSONObject.optJSONArray("filter_words");
        if (optJSONArray != null) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                FilterWord parseFromJson = FilterWord.parseFromJson(optJSONArray.optJSONObject(i4));
                if (parseFromJson != null && parseFromJson.isValid()) {
                    this.f67149b.add(parseFromJson);
                }
            }
        }
        this.f67150c = PersonalizationPrompt.parseFromJson(jSONObject.optJSONObject("personalization_prompts"));
        this.f67153f = jSONObject.optString(LegoListActivityConfig.AD_ID);
        this.f67154g = jSONObject.optString("ext");
    }

    public PersonalizationPrompt a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67150c : (PersonalizationPrompt) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f67151d = str;
        }
    }

    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            jSONObject.put("dislike_control", this.f67148a);
            jSONObject.put("filter_words", g());
            jSONObject.put("personalization_prompts", h());
            jSONObject.put("close_on_dislike", j());
        }
    }

    public List<FilterWord> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f67149b : (List) invokeV.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f67155h = str;
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f67151d : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f67153f : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f67154g : (String) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f67148a == 1 : invokeV.booleanValue;
    }

    public JSONArray g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            List<FilterWord> list = this.f67149b;
            if (list != null) {
                for (FilterWord filterWord : list) {
                    JSONObject json = filterWord.toJson();
                    if (json != null) {
                        jSONArray.put(json);
                    }
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeV.objValue;
    }

    public JSONObject h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            PersonalizationPrompt personalizationPrompt = this.f67150c;
            if (personalizationPrompt != null) {
                return personalizationPrompt.toJson();
            }
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f67155h : (String) invokeV.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f67152e : invokeV.booleanValue;
    }
}
