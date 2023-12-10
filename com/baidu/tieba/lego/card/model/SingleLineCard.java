package com.baidu.tieba.lego.card.model;

import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.dg9;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.utils.ColorUtils;
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
    public final dg9 buttonInfo;
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
        int length;
        boolean z;
        boolean z2;
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
        JSONObject optJSONObject = jSONObject.optJSONObject("icon");
        if (optJSONObject != null) {
            this.iconUrl = optJSONObject.optString("url");
            this.iconUrlNight = optJSONObject.optString("urlNight");
            this.iconType = optJSONObject.optInt("type");
            this.iconTitle = optJSONObject.optString("text");
            int parseColor = ColorUtils.parseColor(optJSONObject.optString("tColor", ""));
            int parseColor2 = ColorUtils.parseColor(optJSONObject.optString("tColorN", ""));
            if (!ColorUtils.isColorInvalid(parseColor) && !ColorUtils.isColorInvalid(parseColor2)) {
                this.iconTitleColor = parseColor;
                this.iconTitleColorNight = parseColor2;
            } else {
                this.iconTitleColor = SkinManager.getColor(R.color.CAM_X0302);
                this.iconTitleColorNight = SkinManager.getColor(R.color.CAM_X0302_2);
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
        if (optJSONArray == null) {
            length = 0;
        } else {
            length = optJSONArray.length();
        }
        this.params = new ArrayList(length);
        for (int i3 = 0; i3 < length; i3++) {
            this.params.add(optJSONArray.optString(i3));
        }
        this.paramColor = ColorUtils.parseColor(jSONObject.optString("pColor", ""));
        this.paramColorNight = ColorUtils.parseColor(jSONObject.optString("pColorNight", ""));
        this.titleColor = ColorUtils.parseColor(jSONObject.optString("tColor", ""));
        this.titleColorNight = ColorUtils.parseColor(jSONObject.optString("tColorNight", ""));
        this.bgColor = ColorUtils.parseColor(jSONObject.optString("bgColor", ""));
        this.bgColorNight = ColorUtils.parseColor(jSONObject.optString("bgColorNight", ""));
        this.buttonInfo = dg9.a(jSONObject.optJSONObject("moreButton"));
        if (jSONObject.optInt("showLeftLine") == 1) {
            z = true;
        } else {
            z = false;
        }
        this.showLeftLine = z;
        if (jSONObject.optInt("showLeftIcon") == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.showLeftIcon = z2;
        this.maxLines = jSONObject.optInt("maxLines", 1);
        this.textSize = jSONObject.optInt("textSize", 32);
        this.height = jSONObject.optInt("height", 40);
        this.gravity = jSONObject.optInt(NotificationCompat.WearableExtender.KEY_GRAVITY, 0);
    }

    public int getBgColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.bgColor;
        }
        return invokeV.intValue;
    }

    public int getBgColorNight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.bgColorNight;
        }
        return invokeV.intValue;
    }

    public dg9 getButtonInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.buttonInfo;
        }
        return (dg9) invokeV.objValue;
    }

    public int getGravity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.gravity;
        }
        return invokeV.intValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.height;
        }
        return invokeV.intValue;
    }

    public String getIconTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.iconTitle;
        }
        return (String) invokeV.objValue;
    }

    public int getIconTitleColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.iconTitleColor;
        }
        return invokeV.intValue;
    }

    public int getIconTitleColorNight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.iconTitleColorNight;
        }
        return invokeV.intValue;
    }

    public int getIconType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.iconType;
        }
        return invokeV.intValue;
    }

    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.iconUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getIconUrlNight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.iconUrlNight;
        }
        return (String) invokeV.objValue;
    }

    public int getMaxLines() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.maxLines;
        }
        return invokeV.intValue;
    }

    public int getParamColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.paramColor;
        }
        return invokeV.intValue;
    }

    public int getParamColorNight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.paramColorNight;
        }
        return invokeV.intValue;
    }

    public List<String> getParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.params;
        }
        return (List) invokeV.objValue;
    }

    public int getTextSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.textSize;
        }
        return invokeV.intValue;
    }

    public int getTitleColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.titleColor;
        }
        return invokeV.intValue;
    }

    public int getTitleColorNight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.titleColorNight;
        }
        return invokeV.intValue;
    }

    public boolean isShowLeftIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.showLeftIcon;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowLeftLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.showLeftLine;
        }
        return invokeV.booleanValue;
    }
}
