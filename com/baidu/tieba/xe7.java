package com.baidu.tieba;

import android.util.SparseIntArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.BigImgCard;
import com.baidu.tieba.lego.card.model.ButtonCard;
import com.baidu.tieba.lego.card.model.CardGroup;
import com.baidu.tieba.lego.card.model.FocusListCard;
import com.baidu.tieba.lego.card.model.HorRankCard;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.model.ImmersiveVideoCardEx;
import com.baidu.tieba.lego.card.model.ImmersiveWebViewCard;
import com.baidu.tieba.lego.card.model.LPBigImgCard;
import com.baidu.tieba.lego.card.model.OnePicInfoCard;
import com.baidu.tieba.lego.card.model.PlayPicInfoCard;
import com.baidu.tieba.lego.card.model.RankDetailTrendCard;
import com.baidu.tieba.lego.card.model.RankScoreCard;
import com.baidu.tieba.lego.card.model.SingleLineCard;
import com.baidu.tieba.lego.card.model.WebViewCard;
import com.baidu.tieba.lego.card.view.BaseCardView;
import com.baidu.tieba.lego.card.view.BigImgView;
import com.baidu.tieba.lego.card.view.ButtonCardView;
import com.baidu.tieba.lego.card.view.FocusListCardView;
import com.baidu.tieba.lego.card.view.HorRankCardView;
import com.baidu.tieba.lego.card.view.ImmersiveVideoCardViewEx;
import com.baidu.tieba.lego.card.view.ImmersiveWebViewCardView;
import com.baidu.tieba.lego.card.view.LPBigImgCardView;
import com.baidu.tieba.lego.card.view.OnePicInfoCardView;
import com.baidu.tieba.lego.card.view.PlayPicInfoCardView;
import com.baidu.tieba.lego.card.view.RankDetailTrendCardView;
import com.baidu.tieba.lego.card.view.RankScoreCardView;
import com.baidu.tieba.lego.card.view.SingleLineCardView;
import com.baidu.tieba.lego.card.view.WebViewCardView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class xe7 extends ye7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final xe7 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-291798175, "Lcom/baidu/tieba/xe7$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-291798175, "Lcom/baidu/tieba/xe7$b;");
                    return;
                }
            }
            a = new xe7(null);
        }
    }

    public /* synthetic */ xe7(a aVar) {
        this();
    }

    public static xe7 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (xe7) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ye7
    public ICardInfo b(JSONObject jSONObject, int i) throws CardParseException {
        InterceptResult invokeLI;
        ICardInfo playPicInfoCard;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, i)) == null) {
            if (i == 1) {
                playPicInfoCard = new PlayPicInfoCard(jSONObject);
            } else if (i == 2) {
                playPicInfoCard = new SingleLineCard(jSONObject);
            } else if (i == 3) {
                playPicInfoCard = new OnePicInfoCard(jSONObject);
            } else if (i == 5) {
                playPicInfoCard = new FocusListCard(jSONObject);
            } else if (i == 6) {
                playPicInfoCard = new HorRankCard(jSONObject);
            } else if (i == 7) {
                playPicInfoCard = new RankDetailTrendCard(jSONObject);
            } else if (i == 8) {
                playPicInfoCard = new RankScoreCard(jSONObject);
            } else if (i == 11) {
                playPicInfoCard = new CardGroup(jSONObject);
            } else if (i == 28) {
                playPicInfoCard = new ButtonCard(jSONObject);
            } else if (i == 18) {
                playPicInfoCard = new WebViewCard(jSONObject);
            } else if (i != 19) {
                switch (i) {
                    case 21:
                        playPicInfoCard = new LPBigImgCard(jSONObject);
                        break;
                    case 22:
                        playPicInfoCard = new ImmersiveVideoCardEx(jSONObject);
                        break;
                    case 23:
                        playPicInfoCard = new ImmersiveWebViewCard(jSONObject);
                        break;
                    default:
                        return null;
                }
            } else {
                playPicInfoCard = new BigImgCard(jSONObject);
            }
            return playPicInfoCard;
        }
        return (ICardInfo) invokeLI.objValue;
    }

    @Override // com.baidu.tieba.ye7
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SparseIntArray sparseIntArray = ye7.a;
            sparseIntArray.put(1, sparseIntArray.size() + 1);
            SparseIntArray sparseIntArray2 = ye7.a;
            sparseIntArray2.put(2, sparseIntArray2.size() + 1);
            SparseIntArray sparseIntArray3 = ye7.a;
            sparseIntArray3.put(3, sparseIntArray3.size() + 1);
            SparseIntArray sparseIntArray4 = ye7.a;
            sparseIntArray4.put(5, sparseIntArray4.size() + 1);
            SparseIntArray sparseIntArray5 = ye7.a;
            sparseIntArray5.put(6, sparseIntArray5.size() + 1);
            SparseIntArray sparseIntArray6 = ye7.a;
            sparseIntArray6.put(7, sparseIntArray6.size() + 1);
            SparseIntArray sparseIntArray7 = ye7.a;
            sparseIntArray7.put(8, sparseIntArray7.size() + 1);
            SparseIntArray sparseIntArray8 = ye7.a;
            sparseIntArray8.put(18, sparseIntArray8.size() + 1);
            SparseIntArray sparseIntArray9 = ye7.a;
            sparseIntArray9.put(19, sparseIntArray9.size() + 1);
            SparseIntArray sparseIntArray10 = ye7.a;
            sparseIntArray10.put(21, sparseIntArray10.size() + 1);
            SparseIntArray sparseIntArray11 = ye7.a;
            sparseIntArray11.put(22, sparseIntArray11.size() + 1);
            SparseIntArray sparseIntArray12 = ye7.a;
            sparseIntArray12.put(23, sparseIntArray12.size() + 1);
            SparseIntArray sparseIntArray13 = ye7.a;
            sparseIntArray13.put(28, sparseIntArray13.size() + 1);
            ye7.b.put(1, BdUniqueId.gen());
            ye7.b.put(2, BdUniqueId.gen());
            ye7.b.put(3, BdUniqueId.gen());
            ye7.b.put(5, BdUniqueId.gen());
            ye7.b.put(6, BdUniqueId.gen());
            ye7.b.put(7, BdUniqueId.gen());
            ye7.b.put(8, BdUniqueId.gen());
            ye7.b.put(18, BdUniqueId.gen());
            ye7.b.put(19, BdUniqueId.gen());
            ye7.b.put(21, BdUniqueId.gen());
            ye7.b.put(22, BdUniqueId.gen());
            ye7.b.put(23, BdUniqueId.gen());
            ye7.b.put(28, BdUniqueId.gen());
        }
    }

    @Override // com.baidu.tieba.ye7
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "lego_main" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ye7
    /* renamed from: e */
    public <T> BaseCardView a(TbPageContext<T> tbPageContext, ICardInfo iCardInfo, int i) {
        InterceptResult invokeLLI;
        BaseCardView playPicInfoCardView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, tbPageContext, iCardInfo, i)) == null) {
            int cardType = iCardInfo == null ? -1 : iCardInfo.getCardType();
            if (cardType == 1) {
                playPicInfoCardView = new PlayPicInfoCardView(tbPageContext);
            } else if (cardType == 2) {
                playPicInfoCardView = new SingleLineCardView(tbPageContext);
            } else if (cardType == 3) {
                playPicInfoCardView = new OnePicInfoCardView(tbPageContext);
            } else if (cardType == 5) {
                playPicInfoCardView = new FocusListCardView(tbPageContext);
            } else if (cardType == 6) {
                playPicInfoCardView = new HorRankCardView(tbPageContext);
            } else if (cardType == 7) {
                playPicInfoCardView = new RankDetailTrendCardView(tbPageContext);
            } else if (cardType == 8) {
                playPicInfoCardView = new RankScoreCardView(tbPageContext);
            } else if (cardType == 18) {
                playPicInfoCardView = new WebViewCardView(tbPageContext);
            } else if (cardType == 19) {
                playPicInfoCardView = new BigImgView(tbPageContext);
            } else if (cardType != 28) {
                switch (cardType) {
                    case 21:
                        playPicInfoCardView = new LPBigImgCardView(tbPageContext);
                        break;
                    case 22:
                        playPicInfoCardView = new ImmersiveVideoCardViewEx(tbPageContext);
                        break;
                    case 23:
                        playPicInfoCardView = new ImmersiveWebViewCardView(tbPageContext);
                        break;
                    default:
                        return null;
                }
            } else {
                playPicInfoCardView = new ButtonCardView(tbPageContext);
            }
            return playPicInfoCardView;
        }
        return (BaseCardView) invokeLLI.objValue;
    }

    public xe7() {
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
