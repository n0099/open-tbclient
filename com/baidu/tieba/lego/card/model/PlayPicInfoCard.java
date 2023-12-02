package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ag9;
import com.baidu.tieba.bg9;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.utils.ColorUtils;
import com.baidu.tieba.zf9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class PlayPicInfoCard extends BaseCardInfo implements zf9<PlayPicInfoCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int descOnPic;
    public final long duration;
    public final List<b> imageResList;
    public final a mBottomInfo;
    public final c mWaterMark;
    public final double ratio;
    public final int showDot;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public bg9 c;
        public ag9 d;

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (jSONObject != null) {
                this.a = jSONObject.optString("lbText");
                this.b = jSONObject.optString("lbScheme");
                bg9 bg9Var = new bg9();
                this.c = bg9Var;
                bg9Var.d = jSONObject.optString("rText");
                this.c.c = jSONObject.optInt("rIconType");
                this.c.a = jSONObject.optString("rIcon");
                this.c.b = jSONObject.optString("rIconN");
                JSONObject optJSONObject = jSONObject.optJSONObject("cb");
                if (optJSONObject != null) {
                    ag9 ag9Var = new ag9(optJSONObject);
                    this.d = ag9Var;
                    if (!ag9Var.j()) {
                        this.d = null;
                    }
                }
            }
        }

        public static a a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                return new a(jSONObject);
            }
            return (a) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public String d;
        public int e;
        public int f;
        public int g;
        public int h;
        public String i;

        public b() {
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

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public int c;
        public int d;

        public c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (jSONObject != null) {
                this.a = jSONObject.optString("pic");
                this.b = jSONObject.optString("picN");
                this.c = jSONObject.optInt("xPos");
                this.d = jSONObject.optInt("yPos");
            }
        }

        public static c a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                c cVar = new c(jSONObject);
                if (!cVar.b()) {
                    return null;
                }
                return cVar;
            }
            return (c) invokeL.objValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (TextUtils.isEmpty(this.a) && TextUtils.isEmpty(this.b) && this.c == 0 && this.d == 0) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayPicInfoCard(JSONObject jSONObject) throws CardParseException {
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
        this.ratio = jSONObject.optDouble(MapBundleKey.OfflineMapKey.OFFLINE_RATION, -1.0d);
        this.duration = jSONObject.optLong("duration", 5000L);
        this.descOnPic = jSONObject.optInt("descOnPic", 1);
        this.showDot = jSONObject.optInt("show_dot", 1);
        JSONArray optJSONArray = jSONObject.optJSONArray(SocialConstants.PARAM_IMAGE);
        if (optJSONArray == null) {
            length = 0;
        } else {
            length = optJSONArray.length();
        }
        this.imageResList = new ArrayList(length);
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
            String optString = optJSONObject.optString("pic");
            if (!TextUtils.isEmpty(optString)) {
                b bVar = new b();
                bVar.i = this.statistics;
                bVar.g = this.statTab;
                bVar.a = optJSONObject.optString("picId");
                bVar.b = optString;
                bVar.c = optJSONObject.optString("scheme");
                bVar.d = optJSONObject.optString("desc");
                bVar.e = ColorUtils.parseColor(optJSONObject.optString("descColor", ""));
                bVar.f = ColorUtils.parseColor(optJSONObject.optString("descColorNight", ""));
                int optInt = optJSONObject.optInt("mLines");
                bVar.h = optInt <= 1 ? 1 : optInt;
                this.imageResList.add(bVar);
            }
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("bInfo");
        if (optJSONObject2 != null) {
            this.mBottomInfo = a.a(optJSONObject2);
        } else {
            this.mBottomInfo = null;
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("wMark");
        if (optJSONObject3 != null) {
            this.mWaterMark = c.a(optJSONObject3);
        } else {
            this.mWaterMark = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.zf9
    public void doLoad(PlayPicInfoCard playPicInfoCard, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, playPicInfoCard, tbPageContext) == null) && playPicInfoCard != null && tbPageContext != null) {
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst());
            int i = (int) (equipmentWidth * playPicInfoCard.ratio);
            for (b bVar : this.imageResList) {
                BdResourceLoader.getInstance().loadResource(bVar.b, 17, null, equipmentWidth, i, tbPageContext.getUniqueId(), new Object[0]);
            }
        }
    }

    public a getBottomInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mBottomInfo;
        }
        return (a) invokeV.objValue;
    }

    public int getDescOnPic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.descOnPic;
        }
        return invokeV.intValue;
    }

    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.duration;
        }
        return invokeV.longValue;
    }

    public List<b> getImageResList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.imageResList;
        }
        return (List) invokeV.objValue;
    }

    public int getMaxLineForToptitle() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i2 = 1;
            for (b bVar : this.imageResList) {
                if (bVar != null && (i = bVar.h) > i2) {
                    i2 = i;
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public double getRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.ratio;
        }
        return invokeV.doubleValue;
    }

    public int getShowDot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.showDot;
        }
        return invokeV.intValue;
    }

    public c getWaterMark() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mWaterMark;
        }
        return (c) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.imageResList.size() != 0 && super.isValid()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
