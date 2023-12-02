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
import com.baidu.tieba.lego.card.view.NewImmersiveWebViewCardView;
import com.baidu.tieba.lego.card.view.NewWebViewCardView;
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
/* loaded from: classes8.dex */
public class sf9 extends tf9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @Override // com.baidu.tieba.tf9
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "lego_main" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final sf9 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-433960827, "Lcom/baidu/tieba/sf9$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-433960827, "Lcom/baidu/tieba/sf9$b;");
                    return;
                }
            }
            a = new sf9(null);
        }
    }

    public sf9() {
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

    public static sf9 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (sf9) invokeV.objValue;
    }

    public /* synthetic */ sf9(a aVar) {
        this();
    }

    @Override // com.baidu.tieba.tf9
    public ICardInfo b(JSONObject jSONObject, int i) throws CardParseException {
        InterceptResult invokeLI;
        ICardInfo playPicInfoCard;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, i)) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 5) {
                            if (i != 6) {
                                if (i != 7) {
                                    if (i != 8) {
                                        if (i != 11) {
                                            if (i != 28) {
                                                if (i != 18) {
                                                    if (i != 19) {
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
                                                } else {
                                                    playPicInfoCard = new WebViewCard(jSONObject);
                                                }
                                            } else {
                                                playPicInfoCard = new ButtonCard(jSONObject);
                                            }
                                        } else {
                                            playPicInfoCard = new CardGroup(jSONObject);
                                        }
                                    } else {
                                        playPicInfoCard = new RankScoreCard(jSONObject);
                                    }
                                } else {
                                    playPicInfoCard = new RankDetailTrendCard(jSONObject);
                                }
                            } else {
                                playPicInfoCard = new HorRankCard(jSONObject);
                            }
                        } else {
                            playPicInfoCard = new FocusListCard(jSONObject);
                        }
                    } else {
                        playPicInfoCard = new OnePicInfoCard(jSONObject);
                    }
                } else {
                    playPicInfoCard = new SingleLineCard(jSONObject);
                }
            } else {
                playPicInfoCard = new PlayPicInfoCard(jSONObject);
            }
            return playPicInfoCard;
        }
        return (ICardInfo) invokeLI.objValue;
    }

    @Override // com.baidu.tieba.tf9
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SparseIntArray sparseIntArray = tf9.a;
            sparseIntArray.put(1, sparseIntArray.size() + 1);
            SparseIntArray sparseIntArray2 = tf9.a;
            sparseIntArray2.put(2, sparseIntArray2.size() + 1);
            SparseIntArray sparseIntArray3 = tf9.a;
            sparseIntArray3.put(3, sparseIntArray3.size() + 1);
            SparseIntArray sparseIntArray4 = tf9.a;
            sparseIntArray4.put(5, sparseIntArray4.size() + 1);
            SparseIntArray sparseIntArray5 = tf9.a;
            sparseIntArray5.put(6, sparseIntArray5.size() + 1);
            SparseIntArray sparseIntArray6 = tf9.a;
            sparseIntArray6.put(7, sparseIntArray6.size() + 1);
            SparseIntArray sparseIntArray7 = tf9.a;
            sparseIntArray7.put(8, sparseIntArray7.size() + 1);
            SparseIntArray sparseIntArray8 = tf9.a;
            sparseIntArray8.put(18, sparseIntArray8.size() + 1);
            SparseIntArray sparseIntArray9 = tf9.a;
            sparseIntArray9.put(19, sparseIntArray9.size() + 1);
            SparseIntArray sparseIntArray10 = tf9.a;
            sparseIntArray10.put(21, sparseIntArray10.size() + 1);
            SparseIntArray sparseIntArray11 = tf9.a;
            sparseIntArray11.put(22, sparseIntArray11.size() + 1);
            SparseIntArray sparseIntArray12 = tf9.a;
            sparseIntArray12.put(23, sparseIntArray12.size() + 1);
            SparseIntArray sparseIntArray13 = tf9.a;
            sparseIntArray13.put(28, sparseIntArray13.size() + 1);
            tf9.b.put(1, BdUniqueId.gen());
            tf9.b.put(2, BdUniqueId.gen());
            tf9.b.put(3, BdUniqueId.gen());
            tf9.b.put(5, BdUniqueId.gen());
            tf9.b.put(6, BdUniqueId.gen());
            tf9.b.put(7, BdUniqueId.gen());
            tf9.b.put(8, BdUniqueId.gen());
            tf9.b.put(18, BdUniqueId.gen());
            tf9.b.put(19, BdUniqueId.gen());
            tf9.b.put(21, BdUniqueId.gen());
            tf9.b.put(22, BdUniqueId.gen());
            tf9.b.put(23, BdUniqueId.gen());
            tf9.b.put(28, BdUniqueId.gen());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tf9
    /* renamed from: e */
    public <T> BaseCardView a(TbPageContext<T> tbPageContext, ICardInfo iCardInfo, int i) {
        InterceptResult invokeLLI;
        int cardType;
        BaseCardView playPicInfoCardView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, tbPageContext, iCardInfo, i)) == null) {
            if (iCardInfo == null) {
                cardType = -1;
            } else {
                cardType = iCardInfo.getCardType();
            }
            if (cardType != 1) {
                if (cardType != 2) {
                    if (cardType != 3) {
                        if (cardType != 5) {
                            if (cardType != 6) {
                                if (cardType != 7) {
                                    if (cardType != 8) {
                                        if (cardType != 18) {
                                            if (cardType != 19) {
                                                if (cardType != 28) {
                                                    switch (cardType) {
                                                        case 21:
                                                            playPicInfoCardView = new LPBigImgCardView(tbPageContext);
                                                            break;
                                                        case 22:
                                                            playPicInfoCardView = new ImmersiveVideoCardViewEx(tbPageContext);
                                                            break;
                                                        case 23:
                                                            if (mj6.e("https://unknown-tmp/")) {
                                                                playPicInfoCardView = new NewImmersiveWebViewCardView(tbPageContext);
                                                                break;
                                                            } else {
                                                                playPicInfoCardView = new ImmersiveWebViewCardView(tbPageContext);
                                                                break;
                                                            }
                                                        default:
                                                            return null;
                                                    }
                                                } else {
                                                    playPicInfoCardView = new ButtonCardView(tbPageContext);
                                                }
                                            } else {
                                                playPicInfoCardView = new BigImgView(tbPageContext);
                                            }
                                        } else if (mj6.e("https://ad-card-tmp/")) {
                                            playPicInfoCardView = new NewWebViewCardView(tbPageContext);
                                        } else {
                                            playPicInfoCardView = new WebViewCardView(tbPageContext);
                                        }
                                    } else {
                                        playPicInfoCardView = new RankScoreCardView(tbPageContext);
                                    }
                                } else {
                                    playPicInfoCardView = new RankDetailTrendCardView(tbPageContext);
                                }
                            } else {
                                playPicInfoCardView = new HorRankCardView(tbPageContext);
                            }
                        } else {
                            playPicInfoCardView = new FocusListCardView(tbPageContext);
                        }
                    } else {
                        playPicInfoCardView = new OnePicInfoCardView(tbPageContext);
                    }
                } else {
                    playPicInfoCardView = new SingleLineCardView(tbPageContext);
                }
            } else {
                playPicInfoCardView = new PlayPicInfoCardView(tbPageContext);
            }
            return playPicInfoCardView;
        }
        return (BaseCardView) invokeLLI.objValue;
    }
}
