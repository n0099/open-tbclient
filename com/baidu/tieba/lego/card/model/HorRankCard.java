package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.z1.o.j.c;
import c.a.r0.z1.o.k.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
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
/* loaded from: classes5.dex */
public class HorRankCard extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final double displayNum;
    public final String itemStatistics;
    public final int picType;
    public final int position;
    public List<a> rankInfoList;
    public final double ratio;
    public final c rightText;
    public final boolean scrollEnabled;
    public final boolean showLeft;
    public final boolean showSep;
    public final int titleColor;
    public final int titleColorNight;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String f44080b;

        /* renamed from: c  reason: collision with root package name */
        public String f44081c;

        /* renamed from: d  reason: collision with root package name */
        public String f44082d;

        /* renamed from: e  reason: collision with root package name */
        public String f44083e;

        /* renamed from: f  reason: collision with root package name */
        public String f44084f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f44085g;

        /* renamed from: h  reason: collision with root package name */
        public String f44086h;

        /* renamed from: i  reason: collision with root package name */
        public String f44087i;

        /* renamed from: j  reason: collision with root package name */
        public String f44088j;
        public int k;
        public int l;
        public HorRankCard m;

        public a() {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorRankCard(JSONObject jSONObject) throws CardParseException {
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
        this.titleColor = b.b(jSONObject.optString("tColor", ""));
        this.titleColorNight = b.b(jSONObject.optString("tColorNight", ""));
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
        for (int i4 = 0; i4 < length; i4++) {
            a aVar = new a();
            JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
            aVar.a = optJSONObject.optInt("rank");
            aVar.f44080b = optJSONObject.optString("picUrl");
            aVar.f44081c = optJSONObject.optString("picIcon");
            aVar.f44082d = optJSONObject.optString("title");
            aVar.f44083e = optJSONObject.optString("subTitle");
            aVar.f44084f = optJSONObject.optString("postUrl");
            aVar.f44085g = optJSONObject.optInt("isDone") == 1;
            aVar.f44086h = optJSONObject.optString("btnText");
            aVar.f44087i = optJSONObject.optString("btnDone");
            aVar.f44088j = optJSONObject.optString("picScheme");
            aVar.k = b.b(optJSONObject.optString("bgColor", ""));
            aVar.l = b.b(optJSONObject.optString("bgColorNight", ""));
            optJSONObject.optLong("resourceId");
            aVar.m = this;
            this.rankInfoList.add(aVar);
        }
        this.rightText = c.a(jSONObject.optJSONObject("moreButton"));
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

    public c getRightText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.rightText : (c) invokeV.objValue;
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
                if (!TextUtils.isEmpty(aVar.f44084f) && !TextUtils.isEmpty(aVar.f44086h) && !TextUtils.isEmpty(aVar.f44087i) && TextUtils.equals(str, getFidFromPostUrl(aVar.f44084f))) {
                    aVar.f44085g = z;
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
                if (!TextUtils.isEmpty(aVar.f44084f) && !TextUtils.isEmpty(aVar.f44086h) && !TextUtils.isEmpty(aVar.f44087i) && TextUtils.equals(getTouidFromPostUrl(aVar.f44084f), str)) {
                    aVar.f44085g = z;
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
