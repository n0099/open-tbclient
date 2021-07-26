package com.baidu.tieba.lego.card.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.n1.o.k.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class FocusListCard extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MIN_FOCUS_ITEMS = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public final int bgColor;
    public final int bgColorNight;
    public final List<a> focusItemList;
    public final int titleColor;
    public final int titleColorNight;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f18244a;

        /* renamed from: b  reason: collision with root package name */
        public String f18245b;

        /* renamed from: c  reason: collision with root package name */
        public String f18246c;

        /* renamed from: d  reason: collision with root package name */
        public int f18247d;

        /* renamed from: e  reason: collision with root package name */
        public int f18248e;

        /* renamed from: f  reason: collision with root package name */
        public String f18249f;

        /* renamed from: g  reason: collision with root package name */
        public long f18250g;

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
    public FocusListCard(JSONObject jSONObject) throws CardParseException {
        super(jSONObject);
        JSONArray optJSONArray;
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
        this.titleColor = b.b(jSONObject.optString("titleColor", ""));
        this.titleColorNight = b.b(jSONObject.optString("titleColorNight", ""));
        this.bgColor = b.b(jSONObject.optString("bgColor", ""));
        this.bgColorNight = b.b(jSONObject.optString("bgColorNight", ""));
        JSONArray optJSONArray2 = jSONObject.optJSONArray("itemList");
        int length = optJSONArray2 == null ? 0 : optJSONArray2.length();
        this.focusItemList = new ArrayList(length);
        for (int i4 = 0; i4 < length; i4++) {
            JSONObject optJSONObject = optJSONArray2.optJSONObject(i4);
            if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("strList")) != null && optJSONArray.length() != 0) {
                a aVar = new a();
                try {
                    if (optJSONArray.length() > 0) {
                        aVar.f18244a = optJSONArray.getString(0);
                    }
                    if (optJSONArray.length() > 1) {
                        aVar.f18245b = optJSONArray.getString(1);
                    }
                    if (optJSONArray.length() > 2) {
                        aVar.f18246c = optJSONArray.getString(2);
                    }
                    aVar.f18247d = b.b(optJSONObject.optString("focusColor", ""));
                    aVar.f18248e = b.b(optJSONObject.optString("focusColorNight", ""));
                    aVar.f18249f = optJSONObject.optString("scheme");
                    aVar.f18250g = optJSONObject.optLong("resourceId");
                    this.focusItemList.add(aVar);
                } catch (Exception unused) {
                }
            }
        }
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

    public List<a> getFocusItemList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.focusItemList : (List) invokeV.objValue;
    }

    public int getTitleColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.titleColor : invokeV.intValue;
    }

    public int getTitleColorNight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.titleColorNight : invokeV.intValue;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.focusItemList.size() >= 3 && super.isValid() : invokeV.booleanValue;
    }
}
