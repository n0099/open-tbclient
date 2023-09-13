package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.tieba.lego.card.utils.ColorUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ButtonCard extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BUTTON_COLOR_FILL = 2;
    public static final int BUTTON_COLOR_FRAME = 1;
    public static final int DEFAULT_BUTTON_COLOR_STYLE = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public final int bgColor;
    public final String bgPicUrl;
    public final int btnColorStyle;
    public final String btnScheme;
    public final int buttonColor;
    public final int cardHeight;
    public final int cardWidth;
    public int defaultHeight;
    public int defaultWidth;
    public String phoneNumber;
    public final String title;
    public final int titleColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ButtonCard(JSONObject jSONObject) {
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
        this.defaultWidth = PassBiometricUtil.k;
        this.defaultHeight = 80;
        this.title = jSONObject.optString("title", "");
        this.titleColor = ColorUtils.parseColor(jSONObject.optString("title_color"));
        this.buttonColor = ColorUtils.parseColor(jSONObject.optString("btn_color"));
        this.btnScheme = jSONObject.optString("btn_scheme", "");
        this.cardWidth = jSONObject.optInt("width", this.defaultWidth);
        this.cardHeight = jSONObject.optInt("height", this.defaultHeight);
        this.bgColor = ColorUtils.parseColor(jSONObject.optString("bg_color"));
        this.bgPicUrl = jSONObject.optString("bg_pic_url", "");
        this.btnColorStyle = jSONObject.optInt("btn_color_style", -1);
        extractPhoneNumber(this.btnScheme);
    }

    private void extractPhoneNumber(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.phoneNumber = "";
            } else {
                this.phoneNumber = str.substring(4);
            }
        }
    }

    public int getBgColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.bgColor;
        }
        return invokeV.intValue;
    }

    public String getBtnScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.btnScheme;
        }
        return (String) invokeV.objValue;
    }

    public int getButtonColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.buttonColor;
        }
        return invokeV.intValue;
    }

    public int getCardHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.cardHeight;
        }
        return invokeV.intValue;
    }

    public int getCardWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.cardWidth;
        }
        return invokeV.intValue;
    }

    public String getPhoneNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.phoneNumber;
        }
        return (String) invokeV.objValue;
    }

    public String getPicUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.bgPicUrl;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public double getRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i = this.cardWidth;
            if (i > 0) {
                return this.cardHeight / i;
            }
            return super.getRatio();
        }
        return invokeV.doubleValue;
    }

    public int getStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.btnColorStyle;
        }
        return invokeV.intValue;
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.title;
        }
        return (String) invokeV.objValue;
    }

    public int getTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.titleColor;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return !TextUtils.isEmpty(this.btnScheme);
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return super.toString() + this.bgPicUrl + this.btnScheme;
        }
        return (String) invokeV.objValue;
    }
}
