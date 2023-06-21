package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.live.interfaces.defaultimpl.utils.MultiRatePlayUrlHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.rp8;
import com.baidu.tieba.tp8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class HorRankCard extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final double displayNum;
    public final String itemStatistics;
    public final int picType;
    public final int position;
    public List<a> rankInfoList;
    public final double ratio;
    public final rp8 rightText;
    public final boolean scrollEnabled;
    public final boolean showLeft;
    public final boolean showSep;
    public final int titleColor;
    public final int titleColorNight;

    /* loaded from: classes6.dex */
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
        public HorRankCard l;

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
        boolean z;
        boolean z2;
        boolean z3;
        int length;
        boolean z4;
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
        this.titleColor = tp8.b(jSONObject.optString("tColor", ""));
        this.titleColorNight = tp8.b(jSONObject.optString("tColorNight", ""));
        this.displayNum = jSONObject.optDouble("displayNum", 5.0d);
        this.ratio = jSONObject.optDouble(MapBundleKey.OfflineMapKey.OFFLINE_RATION, 1.0d);
        int optInt = jSONObject.optInt("picType", 1);
        if (optInt <= 0) {
            this.picType = 1;
        } else {
            this.picType = optInt;
        }
        if (jSONObject.optInt("scrollEnabled", 1) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.scrollEnabled = z;
        this.position = jSONObject.optInt(CriusAttrConstants.POSITION);
        this.itemStatistics = jSONObject.optString("itemStatistics");
        if (jSONObject.optInt("showLeft", 1) == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.showLeft = z2;
        if (jSONObject.optInt("showSep") == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.showSep = z3;
        JSONArray optJSONArray = jSONObject.optJSONArray("ranks");
        if (optJSONArray == null) {
            length = 0;
        } else {
            length = optJSONArray.length();
        }
        this.rankInfoList = new ArrayList(length);
        for (int i3 = 0; i3 < length; i3++) {
            a aVar = new a();
            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
            aVar.a = optJSONObject.optInt(MultiRatePlayUrlHelper.RANK);
            aVar.b = optJSONObject.optString("picUrl");
            aVar.c = optJSONObject.optString("picIcon");
            aVar.d = optJSONObject.optString("title");
            aVar.e = optJSONObject.optString("subTitle");
            aVar.f = optJSONObject.optString("postUrl");
            if (optJSONObject.optInt("isDone") == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            aVar.g = z4;
            aVar.h = optJSONObject.optString("btnText");
            aVar.i = optJSONObject.optString("btnDone");
            aVar.j = optJSONObject.optString("picScheme");
            aVar.k = tp8.b(optJSONObject.optString("bgColor", ""));
            tp8.b(optJSONObject.optString("bgColorNight", ""));
            optJSONObject.optLong("resourceId");
            aVar.l = this;
            this.rankInfoList.add(aVar);
        }
        this.rightText = rp8.a(jSONObject.optJSONObject("moreButton"));
    }

    public double getDisplayNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.displayNum;
        }
        return invokeV.doubleValue;
    }

    public String getItemStatistics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.itemStatistics;
        }
        return (String) invokeV.objValue;
    }

    public int getPicType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.picType;
        }
        return invokeV.intValue;
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.position;
        }
        return invokeV.intValue;
    }

    public List<a> getRankInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.rankInfoList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public double getRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.ratio;
        }
        return invokeV.doubleValue;
    }

    public rp8 getRightText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.rightText;
        }
        return (rp8) invokeV.objValue;
    }

    public int getTitleColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.titleColor;
        }
        return invokeV.intValue;
    }

    public int getTitleColorNight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.titleColorNight;
        }
        return invokeV.intValue;
    }

    public boolean isScrollEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.scrollEnabled;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.showLeft;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowSep() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.showSep;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean shouldResponseAttention() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return !ListUtils.isEmpty(this.rankInfoList);
        }
        return invokeV.booleanValue;
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
}
