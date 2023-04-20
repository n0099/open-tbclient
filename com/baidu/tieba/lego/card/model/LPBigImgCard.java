package com.baidu.tieba.lego.card.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tieba.cg;
import com.baidu.tieba.ii;
import com.baidu.tieba.qe8;
import com.baidu.tieba.ve8;
import com.baidu.tieba.xe8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class LPBigImgCard extends BaseCardInfo implements qe8<LPBigImgCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int bgColor;
    public final int bgColorNight;
    public final int btnColor;
    public final int btnColorNight;
    public final int btnHeight;
    public final String btnImgUrl;
    public final String btnLink;
    public final double btnPosRatio;
    public final String btnText;
    public final int btnWidth;
    public final int picHeight;
    public final String picUrl;
    public final int picWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LPBigImgCard(JSONObject jSONObject) {
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
        this.picUrl = jSONObject.optString("pic_url");
        this.picWidth = xe8.a(jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH));
        this.picHeight = xe8.a(jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT));
        this.bgColor = ve8.b(jSONObject.optString("bg_color"));
        this.bgColorNight = ve8.b(jSONObject.optString("bg_color_n"));
        this.btnText = jSONObject.optString("btn_text");
        this.btnColor = ve8.b(jSONObject.optString("btn_color"));
        this.btnColorNight = ve8.b(jSONObject.optString("btn_color_n"));
        this.btnImgUrl = jSONObject.optString("btn_img");
        this.btnWidth = xe8.a(jSONObject.optInt("btn_width"));
        this.btnHeight = xe8.a(jSONObject.optInt("btn_height"));
        this.btnPosRatio = jSONObject.optDouble("btn_pos", 0.5d);
        this.btnLink = jSONObject.optString("link");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qe8
    public void doLoad(LPBigImgCard lPBigImgCard, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lPBigImgCard, tbPageContext) == null) && lPBigImgCard != null && tbPageContext != null) {
            int l = ii.l(TbadkCoreApplication.getInst());
            cg.h().k(lPBigImgCard.getPicUrl(), 17, null, l, (int) ((lPBigImgCard.getPicHeight() / lPBigImgCard.getPicWidth()) * l), tbPageContext.getUniqueId(), new Object[0]);
        }
    }

    public int getBgColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.bgColor;
        }
        return invokeV.intValue;
    }

    public int getBgColorNight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.bgColorNight;
        }
        return invokeV.intValue;
    }

    public int getBtnColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.btnColor;
        }
        return invokeV.intValue;
    }

    public int getBtnColorNight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.btnColorNight;
        }
        return invokeV.intValue;
    }

    public int getBtnHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.btnHeight;
        }
        return invokeV.intValue;
    }

    public String getBtnImgUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.btnImgUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getBtnLink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.btnLink;
        }
        return (String) invokeV.objValue;
    }

    public double getBtnPosRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.btnPosRatio;
        }
        return invokeV.doubleValue;
    }

    public String getBtnText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.btnText;
        }
        return (String) invokeV.objValue;
    }

    public int getBtnWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.btnWidth;
        }
        return invokeV.intValue;
    }

    public int getPicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.picHeight;
        }
        return invokeV.intValue;
    }

    public String getPicUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.picUrl;
        }
        return (String) invokeV.objValue;
    }

    public int getPicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.picWidth;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public double getRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            int i = this.picWidth;
            if (i > 0) {
                return this.picHeight / i;
            }
            return super.getRatio();
        }
        return invokeV.doubleValue;
    }
}
