package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bf7;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class RankScoreCard extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String btnDone;
    public final String btnText;
    public final int d2Color;
    public final int d2ColorN;
    public final String d2Scheme;
    public final String desc;
    public final String desc2;
    public boolean isDone;
    public final String picUrl;
    public final String postUrl;
    public final int rank;
    public final double ratio;
    public final int sColor;
    public final int sColorNight;
    public final String subTitle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RankScoreCard(JSONObject jSONObject) throws CardParseException {
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
        this.rank = jSONObject.optInt("rank");
        this.desc = jSONObject.optString("desc");
        this.desc2 = jSONObject.optString("desc2");
        this.d2Color = bf7.b(jSONObject.optString("d2Color", ""));
        this.d2ColorN = bf7.b(jSONObject.optString("d2ColorN", ""));
        this.d2Scheme = jSONObject.optString("d2Scheme");
        this.ratio = jSONObject.optDouble("ratio");
        this.picUrl = jSONObject.optString("picUrl");
        this.subTitle = jSONObject.optString("subTitle");
        this.sColor = bf7.b(jSONObject.optString("sColor", ""));
        this.sColorNight = bf7.b(jSONObject.optString("sColorN", ""));
        this.postUrl = jSONObject.optString("postUrl");
        this.isDone = jSONObject.optInt("isDone") == 1;
        this.btnText = jSONObject.optString("btnText");
        this.btnDone = jSONObject.optString("btnDone");
    }

    public String getBtnDone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.btnDone : (String) invokeV.objValue;
    }

    public String getBtnText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.btnText : (String) invokeV.objValue;
    }

    public int getD2Color() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d2Color : invokeV.intValue;
    }

    public int getD2ColorN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.d2ColorN : invokeV.intValue;
    }

    public String getD2Scheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.d2Scheme : (String) invokeV.objValue;
    }

    public String getDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.desc : (String) invokeV.objValue;
    }

    public String getDesc2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.desc2 : (String) invokeV.objValue;
    }

    public String getPicUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.picUrl : (String) invokeV.objValue;
    }

    public String getPostUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.postUrl : (String) invokeV.objValue;
    }

    public int getRank() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.rank : invokeV.intValue;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public double getRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.ratio : invokeV.doubleValue;
    }

    public int getScoreColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.sColor : invokeV.intValue;
    }

    public int getScoreColorNight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.sColorNight : invokeV.intValue;
    }

    public String getSubTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.subTitle : (String) invokeV.objValue;
    }

    public boolean isDone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.isDone : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean responseAttentionForum(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048591, this, str, z)) == null) {
            if (TextUtils.equals(getFidFromPostUrl(this.postUrl), str)) {
                this.isDone = z;
                return true;
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean responseAttentionUser(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048592, this, str, z)) == null) {
            if (TextUtils.equals(getTouidFromPostUrl(this.postUrl), str)) {
                this.isDone = z;
                return true;
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public void setIsDone(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.isDone = z;
        }
    }

    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean shouldResponseAttention() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (TextUtils.isEmpty(this.postUrl) || TextUtils.isEmpty(this.btnText) || TextUtils.isEmpty(this.btnDone)) ? false : true : invokeV.booleanValue;
    }
}
