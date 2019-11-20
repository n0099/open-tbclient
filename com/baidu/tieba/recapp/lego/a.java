package com.baidu.tieba.recapp.lego;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.e;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.lego.model.AdPost;
import com.baidu.tieba.recapp.lego.model.AdPostPbData;
import com.baidu.tieba.recapp.lego.model.CriusAdCard;
import com.baidu.tieba.recapp.lego.model.DistributeVrVideoCard;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.model.VideoMiddlePageAdCard;
import com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData;
import com.baidu.tieba.recapp.lego.view.AdCardLoopPicView;
import com.baidu.tieba.recapp.lego.view.AdCardMultiPicView;
import com.baidu.tieba.recapp.lego.view.AdCardSinglePicView;
import com.baidu.tieba.recapp.lego.view.AdCardVideoView;
import com.baidu.tieba.recapp.lego.view.AdCardVrPicView;
import com.baidu.tieba.recapp.lego.view.AdCardVrVideoView;
import com.baidu.tieba.recapp.lego.view.CriusAdCardView;
import com.baidu.tieba.recapp.lego.view.DistributeVrVideoCardView;
import com.baidu.tieba.recapp.lego.view.VideoMiddlePageAdView;
import com.baidu.tieba.recapp.lego.view.form.FormCardView;
import com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView;
import com.baidu.tieba.recapp.lego.view.postad.AdPostImageView;
import com.baidu.tieba.recapp.lego.view.postad.AdPostPbView;
import org.json.JSONObject;
/* loaded from: classes3.dex */
class a extends e {
    @Override // com.baidu.tieba.lego.card.e
    protected void bHJ() {
        hdV.put(17, hdV.size() + 1);
        hdV.put(26, hdV.size() + 1);
        hdV.put(25, hdV.size() + 1);
        hdV.put(27, hdV.size() + 1);
        hdV.put(31, hdV.size() + 1);
        hdV.put(32, hdV.size() + 1);
        hdV.put(33, hdV.size() + 1);
        hdV.put(99, hdV.size() + 1);
        hdW.put(17, BdUniqueId.gen());
        hdW.put(26, BdUniqueId.gen());
        hdW.put(25, BdUniqueId.gen());
        hdW.put(27, BdUniqueId.gen());
        hdW.put(31, BdUniqueId.gen());
        hdW.put(32, BdUniqueId.gen());
        hdW.put(33, BdUniqueId.gen());
        hdW.put(99, BdUniqueId.gen());
    }

    @Override // com.baidu.tieba.lego.card.e
    public String key() {
        return "lego_for_RecApp";
    }

    @Override // com.baidu.tieba.lego.card.e
    public ICardInfo d(JSONObject jSONObject, int i) throws CardParseException {
        switch (i) {
            case 17:
                return new AdCard(jSONObject);
            case 25:
                if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_VR_LOGO_CAN_OPEN) != null) {
                    return new DistributeVrVideoCard(jSONObject);
                }
                return null;
            case 26:
                return new AdCard(jSONObject);
            case 27:
                return new FormCard(jSONObject);
            case 31:
                return new AdPost(jSONObject);
            case 32:
                return new AdPostPbData(jSONObject);
            case 33:
                return new VideoMiddlePageAdCard(jSONObject);
            case 99:
                return new CriusAdCard(jSONObject);
            default:
                return null;
        }
    }

    @Override // com.baidu.tieba.lego.card.e
    public <T> com.baidu.tieba.lego.card.view.e a(TbPageContext<T> tbPageContext, ICardInfo iCardInfo, int i) {
        switch (iCardInfo == null ? -1 : iCardInfo.getCardType()) {
            case 17:
            case 26:
                return e(tbPageContext, iCardInfo, i);
            case 25:
                if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_VR_LOGO_CAN_OPEN) != null) {
                    return new DistributeVrVideoCardView(tbPageContext);
                }
                return null;
            case 27:
                return new FormCardView(tbPageContext);
            case 31:
                return d(tbPageContext, iCardInfo, i);
            case 32:
                return new AdPostPbView(tbPageContext);
            case 33:
                return new VideoMiddlePageAdView(tbPageContext);
            case 99:
                return new CriusAdCardView(tbPageContext);
            default:
                return null;
        }
    }

    private AdPostBaseView d(TbPageContext<?> tbPageContext, ICardInfo iCardInfo, int i) {
        if (iCardInfo instanceof AdPost) {
            AdPost adPost = (AdPost) iCardInfo;
            if (adPost.getCardType() == 31) {
                if (PostAdBaseData.STYLE_ONE_IMAGE.equals(adPost.feedData.style) || PostAdBaseData.STYLE_MULTI_IMAGE.equals(adPost.feedData.style)) {
                    return new AdPostImageView(tbPageContext);
                }
                return null;
            }
            return null;
        }
        return null;
    }

    private BaseLegoCardView e(TbPageContext<?> tbPageContext, ICardInfo iCardInfo, int i) {
        if (iCardInfo instanceof AdCard) {
            AdCard adCard = (AdCard) iCardInfo;
            int cardType = adCard.getCardType();
            if (cardType == 17) {
                switch (adCard.goodsStyle) {
                    case 2:
                    case 8:
                        return new AdCardSinglePicView(tbPageContext);
                    case 3:
                    case 4:
                    case 5:
                    default:
                        return null;
                    case 6:
                        return new AdCardMultiPicView(tbPageContext);
                    case 7:
                        return new AdCardVideoView(tbPageContext);
                    case 9:
                        return new AdCardVrVideoView(tbPageContext);
                    case 10:
                        return new AdCardVrPicView(tbPageContext);
                }
            } else if (cardType == 26) {
                return new AdCardLoopPicView(tbPageContext);
            } else {
                BdLog.e("RecAppLegoFactory: specifyAdCardView got wrong card type!");
                return null;
            }
        }
        return null;
    }
}
