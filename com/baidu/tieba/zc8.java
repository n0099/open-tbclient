package com.baidu.tieba;

import android.util.SparseIntArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.lego.view.AdCardMultiPicView;
import com.baidu.tieba.recapp.lego.view.AdCardSinglePicView;
import com.baidu.tieba.recapp.lego.view.AdCardVideoView;
import com.baidu.tieba.t65;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class zc8 extends we7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements t65.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;

        public a(zc8 zc8Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zc8Var, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
        }

        @Override // com.baidu.tieba.t65.a
        public Object build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new AdCardSinglePicView(this.a) : invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements t65.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;

        public b(zc8 zc8Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zc8Var, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
        }

        @Override // com.baidu.tieba.t65.a
        public Object build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new AdCardMultiPicView(this.a) : invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements t65.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ int b;

        public c(zc8 zc8Var, TbPageContext tbPageContext, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zc8Var, tbPageContext, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
            this.b = i;
        }

        @Override // com.baidu.tieba.t65.a
        public Object build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new AdCardVideoView(this.a, this.b) : invokeV.objValue;
        }
    }

    public zc8() {
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

    @Override // com.baidu.tieba.we7
    public <T> pf7 a(TbPageContext<T> tbPageContext, ICardInfo iCardInfo, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, tbPageContext, iCardInfo, i)) == null) {
            int cardType = iCardInfo == null ? -1 : iCardInfo.getCardType();
            if (cardType == 17 || cardType == 34) {
                return e(tbPageContext, iCardInfo, i);
            }
            return null;
        }
        return (pf7) invokeLLI.objValue;
    }

    @Override // com.baidu.tieba.we7
    public ICardInfo b(JSONObject jSONObject, int i) throws CardParseException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, i)) == null) {
            if (i == 17 || i == 34) {
                return new AdCard(jSONObject);
            }
            return null;
        }
        return (ICardInfo) invokeLI.objValue;
    }

    @Override // com.baidu.tieba.we7
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SparseIntArray sparseIntArray = we7.a;
            sparseIntArray.put(17, sparseIntArray.size() + 1);
            SparseIntArray sparseIntArray2 = we7.a;
            sparseIntArray2.put(33, sparseIntArray2.size() + 1);
            SparseIntArray sparseIntArray3 = we7.a;
            sparseIntArray3.put(34, sparseIntArray3.size() + 1);
            we7.b.put(17, BdUniqueId.gen());
            we7.b.put(33, BdUniqueId.gen());
            we7.b.put(34, BdUniqueId.gen());
        }
    }

    @Override // com.baidu.tieba.we7
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "lego_for_RecApp" : (String) invokeV.objValue;
    }

    public final BaseLegoCardView e(TbPageContext<?> tbPageContext, ICardInfo iCardInfo, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, tbPageContext, iCardInfo, i)) == null) {
            if (iCardInfo instanceof AdCard) {
                AdCard adCard = (AdCard) iCardInfo;
                int cardType = adCard.getCardType();
                if (cardType != 17 && cardType != 34) {
                    BdLog.e("RecAppLegoFactory: specifyAdCardView got wrong card type!");
                    return null;
                }
                int i2 = adCard.goodsStyle;
                if (i2 != 2) {
                    if (i2 != 14) {
                        if (i2 == 6) {
                            return (AdCardMultiPicView) t65.e().d(1102, new b(this, tbPageContext));
                        }
                        if (i2 != 7) {
                            if (i2 != 8) {
                                return null;
                            }
                        }
                    }
                    AdCardVideoView adCardVideoView = (AdCardVideoView) t65.e().d(PackageInfo.CODE_HOST_VERSION, new c(this, tbPageContext, i));
                    adCardVideoView.setBusinessType(i);
                    return adCardVideoView;
                }
                return (AdCardSinglePicView) t65.e().d(1101, new a(this, tbPageContext));
            }
            return null;
        }
        return (BaseLegoCardView) invokeLLI.objValue;
    }
}
