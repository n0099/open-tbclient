package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class FilterWord {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f65661a;

    /* renamed from: b  reason: collision with root package name */
    public String f65662b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f65663c;

    /* renamed from: d  reason: collision with root package name */
    public List<FilterWord> f65664d;

    public FilterWord(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f65661a = str;
        this.f65662b = str2;
    }

    public static FilterWord parseFromJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            try {
                FilterWord filterWord = new FilterWord();
                filterWord.setId(jSONObject.optString("id"));
                filterWord.setName(jSONObject.optString("name"));
                filterWord.setIsSelected(jSONObject.optBoolean("is_selected"));
                JSONArray optJSONArray = jSONObject.optJSONArray("options");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        FilterWord parseFromJson = parseFromJson(optJSONArray.optJSONObject(i2));
                        if (parseFromJson != null && parseFromJson.isValid()) {
                            filterWord.addOption(parseFromJson);
                        }
                    }
                }
                return filterWord;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (FilterWord) invokeL.objValue;
    }

    public void addOption(FilterWord filterWord) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, filterWord) == null) || filterWord == null) {
            return;
        }
        if (this.f65664d == null) {
            this.f65664d = new ArrayList();
        }
        this.f65664d.add(filterWord);
    }

    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f65661a : (String) invokeV.objValue;
    }

    public boolean getIsSelected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f65663c : invokeV.booleanValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f65662b : (String) invokeV.objValue;
    }

    public List<FilterWord> getOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f65664d : (List) invokeV.objValue;
    }

    public boolean hasSecondOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<FilterWord> list = this.f65664d;
            return (list == null || list.isEmpty()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (TextUtils.isEmpty(this.f65661a) || TextUtils.isEmpty(this.f65662b)) ? false : true : invokeV.booleanValue;
    }

    public void setId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f65661a = str;
        }
    }

    public void setIsSelected(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f65663c = z;
        }
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f65662b = str;
        }
    }

    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            try {
                if (isValid()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("id", getId());
                    jSONObject.put("name", getName());
                    jSONObject.put("is_selected", getIsSelected());
                    if (hasSecondOptions()) {
                        JSONArray jSONArray = new JSONArray();
                        for (FilterWord filterWord : getOptions()) {
                            jSONArray.put(filterWord.toJson());
                        }
                        if (jSONArray.length() > 0) {
                            jSONObject.put("options", jSONArray);
                        }
                    }
                    return jSONObject;
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public FilterWord() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
