package com.baidu.tieba.lego.card.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.jh7;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.mh7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class OnePicInfoCard extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String desc;
    public final List iconList;
    public final String pic;
    public final int tBgColor;
    public final int tBgColorN;
    public final String tag;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnePicInfoCard(JSONObject jSONObject) throws CardParseException {
        super(jSONObject);
        int length;
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
        this.tBgColor = mh7.b(jSONObject.optString("tBgColor", ""));
        this.tBgColorN = mh7.b(jSONObject.optString("tBgColorN", ""));
        JSONArray optJSONArray = jSONObject.optJSONArray("icons");
        if (optJSONArray == null) {
            length = 0;
        } else {
            length = optJSONArray.length();
        }
        this.iconList = new ArrayList(length);
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
            if (optJSONObject != null) {
                jh7 jh7Var = new jh7();
                jh7Var.c = optJSONObject.optInt("type");
                jh7Var.a = optJSONObject.optString("url");
                jh7Var.b = optJSONObject.optString("urlNight");
                jh7Var.d = optJSONObject.optString("content", "");
                this.iconList.add(jh7Var);
            }
        }
    }

    public String getDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.desc;
        }
        return (String) invokeV.objValue;
    }

    public List getIconList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.iconList;
        }
        return (List) invokeV.objValue;
    }

    public String getPic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.pic;
        }
        return (String) invokeV.objValue;
    }

    public String getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.tag;
        }
        return (String) invokeV.objValue;
    }

    public int gettBgColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.tBgColor;
        }
        return invokeV.intValue;
    }

    public int gettBgColorN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.tBgColorN;
        }
        return invokeV.intValue;
    }
}
