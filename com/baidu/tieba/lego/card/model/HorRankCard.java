package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.od7;
import com.repackage.qd7;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class HorRankCard extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final double displayNum;
    public final String itemStatistics;
    public final int picType;
    public final int position;
    public List<a> rankInfoList;
    public final double ratio;
    public final od7 rightText;
    public final boolean scrollEnabled;
    public final boolean showLeft;
    public final boolean showSep;
    public final int titleColor;
    public final int titleColorNight;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public boolean g;
        public String h;
        public String i;
        public String j;
        public int k;
        public int l;
        public HorRankCard m;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorRankCard(JSONObject jSONObject) throws CardParseException {
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
        this.titleColor = qd7.b(jSONObject.optString("tColor", ""));
        this.titleColorNight = qd7.b(jSONObject.optString("tColorNight", ""));
        this.displayNum = jSONObject.optDouble("displayNum", 5.0d);
        this.ratio = jSONObject.optDouble("ratio", 1.0d);
        int optInt = jSONObject.optInt("picType", 1);
        if (optInt <= 0) {
            this.picType = 1;
        } else {
            this.picType = optInt;
        }
        this.scrollEnabled = jSONObject.optInt("scrollEnabled", 1) == 1;
        this.position = jSONObject.optInt("position");
        this.itemStatistics = jSONObject.optString("itemStatistics");
        this.showLeft = jSONObject.optInt("showLeft", 1) == 1;
        this.showSep = jSONObject.optInt("showSep") == 1;
        JSONArray optJSONArray = jSONObject.optJSONArray("ranks");
        int length = optJSONArray == null ? 0 : optJSONArray.length();
        this.rankInfoList = new ArrayList(length);
        for (int i3 = 0; i3 < length; i3++) {
            a aVar = new a();
            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
            aVar.a = optJSONObject.optInt("rank");
            aVar.b = optJSONObject.optString("picUrl");
            aVar.c = optJSONObject.optString("picIcon");
            aVar.d = optJSONObject.optString("title");
            aVar.e = optJSONObject.optString("subTitle");
            aVar.f = optJSONObject.optString("postUrl");
            aVar.g = optJSONObject.optInt("isDone") == 1;
            aVar.h = optJSONObject.optString("btnText");
            aVar.i = optJSONObject.optString("btnDone");
            aVar.j = optJSONObject.optString("picScheme");
            aVar.k = qd7.b(optJSONObject.optString("bgColor", ""));
            aVar.l = qd7.b(optJSONObject.optString("bgColorNight", ""));
            optJSONObject.optLong("resourceId");
            aVar.m = this;
            this.rankInfoList.add(aVar);
        }
        this.rightText = od7.a(jSONObject.optJSONObject("moreButton"));
    }

    public double getDisplayNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.displayNum : invokeV.doubleValue;
    }

    public String getItemStatistics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.itemStatistics : (String) invokeV.objValue;
    }

    public int getPicType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.picType : invokeV.intValue;
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.position : invokeV.intValue;
    }

    public List<a> getRankInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.rankInfoList : (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public double getRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.ratio : invokeV.doubleValue;
    }

    public od7 getRightText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.rightText : (od7) invokeV.objValue;
    }

    public int getTitleColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.titleColor : invokeV.intValue;
    }

    public int getTitleColorNight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.titleColorNight : invokeV.intValue;
    }

    public boolean isScrollEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.scrollEnabled : invokeV.booleanValue;
    }

    public boolean isShowLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.showLeft : invokeV.booleanValue;
    }

    public boolean isShowSep() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.showSep : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean responseAttentionForum(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048588, this, str, z)) == null) {
            boolean z2 = false;
            for (a aVar : this.rankInfoList) {
                if (!TextUtils.isEmpty(aVar.f) && !TextUtils.isEmpty(aVar.h) && !TextUtils.isEmpty(aVar.i) && TextUtils.equals(str, getFidFromPostUrl(aVar.f))) {
                    aVar.g = z;
                    z2 = true;
                }
            }
            return z2;
        }
        return invokeLZ.booleanValue;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean responseAttentionUser(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048589, this, str, z)) == null) {
            boolean z2 = false;
            for (a aVar : this.rankInfoList) {
                if (!TextUtils.isEmpty(aVar.f) && !TextUtils.isEmpty(aVar.h) && !TextUtils.isEmpty(aVar.i) && TextUtils.equals(getTouidFromPostUrl(aVar.f), str)) {
                    aVar.g = z;
                    z2 = true;
                }
            }
            return z2;
        }
        return invokeLZ.booleanValue;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean shouldResponseAttention() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? !ListUtils.isEmpty(this.rankInfoList) : invokeV.booleanValue;
    }
}
