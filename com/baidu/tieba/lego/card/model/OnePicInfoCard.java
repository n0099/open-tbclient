package com.baidu.tieba.lego.card.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.nd7;
import com.repackage.qd7;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class OnePicInfoCard extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String desc;
    public final List<nd7> iconList;
    public final String pic;
    public final int tBgColor;
    public final int tBgColorN;
    public final String tag;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnePicInfoCard(JSONObject jSONObject) throws CardParseException {
        super(jSONObject);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((JSONObject) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.desc = jSONObject.optString("desc", "");
        this.pic = jSONObject.optString("pic");
        this.tag = jSONObject.optString("tag", "");
        this.tBgColor = qd7.b(jSONObject.optString("tBgColor", ""));
        this.tBgColorN = qd7.b(jSONObject.optString("tBgColorN", ""));
        JSONArray optJSONArray = jSONObject.optJSONArray("icons");
        int length = optJSONArray == null ? 0 : optJSONArray.length();
        this.iconList = new ArrayList(length);
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
            if (optJSONObject != null) {
                nd7 nd7Var = new nd7();
                nd7Var.c = optJSONObject.optInt("type");
                nd7Var.a = optJSONObject.optString("url");
                nd7Var.b = optJSONObject.optString("urlNight");
                nd7Var.d = optJSONObject.optString("content", "");
                this.iconList.add(nd7Var);
            }
        }
    }

    public String getDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.desc : (String) invokeV.objValue;
    }

    public List<nd7> getIconList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.iconList : (List) invokeV.objValue;
    }

    public String getPic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.pic : (String) invokeV.objValue;
    }

    public String getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.tag : (String) invokeV.objValue;
    }

    public int gettBgColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.tBgColor : invokeV.intValue;
    }

    public int gettBgColorN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.tBgColorN : invokeV.intValue;
    }
}
