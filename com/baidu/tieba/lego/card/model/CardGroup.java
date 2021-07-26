package com.baidu.tieba.lego.card.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.n1.o.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class CardGroup extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<BaseCardInfo> mCards;
    public final int showSep;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardGroup(JSONObject jSONObject) throws CardParseException {
        super(jSONObject);
        ICardInfo j;
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
        this.showSep = jSONObject.optInt("showSep", 1);
        JSONArray optJSONArray = jSONObject.optJSONArray("cards");
        int length = optJSONArray == null ? 0 : optJSONArray.length();
        this.mCards = new ArrayList(length);
        for (int i4 = 0; i4 < length; i4++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
            if (optJSONObject != null && (j = b.j(optJSONObject)) != null) {
                j.setGroupId(this.itemId);
                this.mCards.add((BaseCardInfo) j);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public int getViewCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mCards.size() : invokeV.intValue;
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mCards.size() == 0 : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? !isEmpty() && super.isValid() : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean responseAttentionForum(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) {
            boolean z2 = false;
            for (BaseCardInfo baseCardInfo : this.mCards) {
                if (baseCardInfo.responseAttentionForum(str, z)) {
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
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048583, this, str, z)) == null) {
            boolean z2 = false;
            for (BaseCardInfo baseCardInfo : this.mCards) {
                if (baseCardInfo.responseAttentionUser(str, z)) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public BaseCardInfo getViewItem(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
            int size = this.mCards.size();
            if (i2 < size) {
                int i4 = this.showSep;
                if (i4 == 0) {
                    this.mCards.get(i2).setShowSpace(0);
                } else if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 == 3) {
                            if (size == 1) {
                                this.mCards.get(i2).setShowSpace(3);
                            } else if (i2 == 0) {
                                this.mCards.get(i2).setShowSpace(2);
                            } else if (i2 == size - 1) {
                                this.mCards.get(i2).setShowSpace(1);
                            } else {
                                this.mCards.get(i2).setShowSpace(0);
                            }
                        }
                    } else if (i2 == 0) {
                        this.mCards.get(i2).setShowSpace(2);
                    } else {
                        this.mCards.get(i2).setShowSpace(0);
                    }
                } else if (i2 == size - 1) {
                    this.mCards.get(i2).setShowSpace(1);
                } else {
                    this.mCards.get(i2).setShowSpace(0);
                }
                if (this.mCards.get(i2).getShowLine() == -1) {
                    this.mCards.get(i2).setShowLine(this.showLine);
                }
                return new GroupCardInfo(this.mCards.get(i2));
            }
            return null;
        }
        return (BaseCardInfo) invokeII.objValue;
    }
}
