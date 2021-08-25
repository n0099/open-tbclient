package com.baidu.tieba.lego.card.model;

import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.o1.o.j.c;
import c.a.q0.o1.o.k.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class SingleLineCard extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int bgColor;
    public final int bgColorNight;
    public final c buttonInfo;
    public final int gravity;
    public final int height;
    public final String iconTitle;
    public final int iconTitleColor;
    public final int iconTitleColorNight;
    public final int iconType;
    public final String iconUrl;
    public final String iconUrlNight;
    public final int maxLines;
    public final int paramColor;
    public final int paramColorNight;
    public final List<String> params;
    public final boolean showLeftIcon;
    public final boolean showLeftLine;
    public final int textSize;
    public final int titleColor;
    public final int titleColorNight;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleLineCard(JSONObject jSONObject) throws CardParseException {
        super(jSONObject);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((JSONObject) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("icon");
        if (optJSONObject != null) {
            this.iconUrl = optJSONObject.optString("url");
            this.iconUrlNight = optJSONObject.optString("urlNight");
            this.iconType = optJSONObject.optInt("type");
            this.iconTitle = optJSONObject.optString("text");
            int b2 = b.b(optJSONObject.optString("tColor", ""));
            int b3 = b.b(optJSONObject.optString("tColorN", ""));
            if (!b.a(b2) && !b.a(b3)) {
                this.iconTitleColor = b2;
                this.iconTitleColorNight = b3;
            } else {
                this.iconTitleColor = SkinManager.getColor(R.color.CAM_X0302);
                this.iconTitleColorNight = SkinManager.getColor(R.color.CAM_X0302_1);
            }
        } else {
            this.iconUrl = "";
            this.iconUrlNight = "";
            this.iconType = 0;
            this.iconTitle = "";
            this.iconTitleColor = Integer.MAX_VALUE;
            this.iconTitleColorNight = Integer.MAX_VALUE;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("params");
        int length = optJSONArray == null ? 0 : optJSONArray.length();
        this.params = new ArrayList(length);
        for (int i4 = 0; i4 < length; i4++) {
            this.params.add(optJSONArray.optString(i4));
        }
        this.paramColor = b.b(jSONObject.optString("pColor", ""));
        this.paramColorNight = b.b(jSONObject.optString("pColorNight", ""));
        this.titleColor = b.b(jSONObject.optString("tColor", ""));
        this.titleColorNight = b.b(jSONObject.optString("tColorNight", ""));
        this.bgColor = b.b(jSONObject.optString("bgColor", ""));
        this.bgColorNight = b.b(jSONObject.optString("bgColorNight", ""));
        this.buttonInfo = c.a(jSONObject.optJSONObject("moreButton"));
        this.showLeftLine = jSONObject.optInt("showLeftLine") == 1;
        this.showLeftIcon = jSONObject.optInt("showLeftIcon") == 1;
        this.maxLines = jSONObject.optInt("maxLines", 1);
        this.textSize = jSONObject.optInt("textSize", 32);
        this.height = jSONObject.optInt("height", 40);
        this.gravity = jSONObject.optInt(NotificationCompat.WearableExtender.KEY_GRAVITY, 0);
    }

    public int getBgColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.bgColor : invokeV.intValue;
    }

    public int getBgColorNight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.bgColorNight : invokeV.intValue;
    }

    public c getButtonInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.buttonInfo : (c) invokeV.objValue;
    }

    public int getGravity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.gravity : invokeV.intValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.height : invokeV.intValue;
    }

    public String getIconTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.iconTitle : (String) invokeV.objValue;
    }

    public int getIconTitleColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.iconTitleColor : invokeV.intValue;
    }

    public int getIconTitleColorNight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.iconTitleColorNight : invokeV.intValue;
    }

    public int getIconType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.iconType : invokeV.intValue;
    }

    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.iconUrl : (String) invokeV.objValue;
    }

    public String getIconUrlNight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.iconUrlNight : (String) invokeV.objValue;
    }

    public int getMaxLines() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.maxLines : invokeV.intValue;
    }

    public int getParamColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.paramColor : invokeV.intValue;
    }

    public int getParamColorNight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.paramColorNight : invokeV.intValue;
    }

    public List<String> getParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.params : (List) invokeV.objValue;
    }

    public int getTextSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.textSize : invokeV.intValue;
    }

    public int getTitleColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.titleColor : invokeV.intValue;
    }

    public int getTitleColorNight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.titleColorNight : invokeV.intValue;
    }

    public boolean isShowLeftIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.showLeftIcon : invokeV.booleanValue;
    }

    public boolean isShowLeftLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.showLeftLine : invokeV.booleanValue;
    }
}
