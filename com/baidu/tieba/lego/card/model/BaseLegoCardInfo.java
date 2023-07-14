package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.s46;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class BaseLegoCardInfo implements ICardInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean bCeiling;
    public final int cardType;
    public final String flipId;
    public final String itemId;
    public BdUniqueId mBdUniqueId;
    public ClientParams mClientParams;
    public String mGroupId;
    public boolean mHasShown;
    public int page;
    public final String sExtras;
    public String scheme;
    public final boolean showCover;
    public final String showExtra;
    public final String showKey;
    public int showLine;
    public int showSpace;
    public final int statTab;
    public final String statistics;
    public final String title;

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public double getRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return 0.0d;
        }
        return invokeV.doubleValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public BaseLegoCardInfo getUpdateCard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this : (BaseLegoCardInfo) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public int getViewCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public BaseLegoCardInfo getViewItem(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048598, this, i, i2)) == null) ? this : (BaseLegoCardInfo) invokeII.objValue;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public abstract boolean responseAttention(Object obj);

    /* loaded from: classes6.dex */
    public static class ClientParams implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ClientParams(JSONObject jSONObject) {
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
            if (jSONObject == null) {
                return;
            }
            s46.a().m(jSONObject);
        }
    }

    public BaseLegoCardInfo(JSONObject jSONObject) {
        boolean z;
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
        this.showSpace = 0;
        this.mHasShown = false;
        if (jSONObject == null) {
            this.cardType = 0;
            this.itemId = "";
            this.flipId = "";
            this.scheme = "";
            this.title = "";
            this.statistics = "";
            this.sExtras = "";
            this.showKey = "";
            this.showExtra = "";
            this.bCeiling = false;
            this.statTab = 0;
            this.showLine = -1;
            this.showCover = false;
            this.mClientParams = null;
            return;
        }
        this.cardType = jSONObject.optInt("card_type");
        this.itemId = jSONObject.optString("item_id");
        this.flipId = jSONObject.optString("flip_id");
        this.scheme = jSONObject.optString("scheme");
        this.title = jSONObject.optString("title");
        this.statistics = jSONObject.optString("statistics");
        this.sExtras = jSONObject.optString("sExtras");
        this.showKey = jSONObject.optString("showKey");
        this.showExtra = jSONObject.optString("showExtra");
        if (jSONObject.optInt("bCeiling") == 1) {
            z = true;
        } else {
            z = false;
        }
        this.bCeiling = z;
        this.statTab = jSONObject.optInt("statTab");
        this.showCover = jSONObject.optInt("showCover") == 1;
        this.showLine = jSONObject.optInt("showLine", -1);
        this.page = jSONObject.optInt("page", 0);
        this.mClientParams = new ClientParams(jSONObject.optJSONObject("client_params"));
    }

    private boolean equalsGroupId(BaseLegoCardInfo baseLegoCardInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, baseLegoCardInfo)) == null) {
            if (baseLegoCardInfo == null) {
                return false;
            }
            if (TextUtils.isEmpty(this.mGroupId)) {
                return TextUtils.isEmpty(baseLegoCardInfo.mGroupId);
            }
            return this.mGroupId.equals(baseLegoCardInfo.mGroupId);
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public final BaseLegoCardInfo getAdapterItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            return getViewItem(i, 0);
        }
        return (BaseLegoCardInfo) invokeI.objValue;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public boolean isReusable(ICardInfo iCardInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, iCardInfo)) == null) {
            if (getCardType() == iCardInfo.getCardType()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, bdUniqueId) == null) {
            this.mBdUniqueId = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public void setGroupId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.mGroupId = str;
        }
    }

    public void setShowLine(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.showLine = i;
        }
    }

    public void setShowSpace(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            this.showSpace = i;
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (!(obj instanceof BaseLegoCardInfo) || TextUtils.isEmpty(this.itemId)) {
                return false;
            }
            BaseLegoCardInfo baseLegoCardInfo = (BaseLegoCardInfo) obj;
            if (!this.itemId.equals(baseLegoCardInfo.itemId) || !equalsGroupId(baseLegoCardInfo)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public final int getAdapterCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return getViewCount();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public int getAdapterType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return getCardType();
        }
        return invokeV.intValue;
    }

    public String getCardTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.title;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public int getCardType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.cardType;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public String getFlipId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.flipId;
        }
        return (String) invokeV.objValue;
    }

    public String getItemId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.itemId;
        }
        return (String) invokeV.objValue;
    }

    public int getPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.page;
        }
        return invokeV.intValue;
    }

    public String getScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.scheme;
        }
        return (String) invokeV.objValue;
    }

    public String getShowExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.showExtra;
        }
        return (String) invokeV.objValue;
    }

    public String getShowKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.showKey;
        }
        return (String) invokeV.objValue;
    }

    public int getShowLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.showLine;
        }
        return invokeV.intValue;
    }

    public int getShowSpace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.showSpace;
        }
        return invokeV.intValue;
    }

    public int getStatTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.statTab;
        }
        return invokeV.intValue;
    }

    public String getStatistics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.statistics;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo, com.baidu.tieba.yn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mBdUniqueId;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public String getsExtras() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.sExtras;
        }
        return (String) invokeV.objValue;
    }

    public boolean isShowCover() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.showCover;
        }
        return invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (!TextUtils.isEmpty(this.itemId)) {
                i = this.itemId.hashCode();
            } else {
                i = 0;
            }
            if (!TextUtils.isEmpty(this.mGroupId)) {
                i2 = this.mGroupId.hashCode();
            } else {
                i2 = 0;
            }
            return 0 + i + i2;
        }
        return invokeV.intValue;
    }
}
