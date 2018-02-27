package com.baidu.tieba.recapp.lego;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.e;
import com.baidu.tieba.lego.card.e.k;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.lego.model.AdPost;
import com.baidu.tieba.recapp.lego.model.AdPostPbData;
import com.baidu.tieba.recapp.lego.model.CriusAdCard;
import com.baidu.tieba.recapp.lego.model.DistributeVrVideoCard;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.model.postad.PostAdBaseData;
import com.baidu.tieba.recapp.lego.view.a.b;
import com.baidu.tieba.recapp.lego.view.d;
import com.baidu.tieba.recapp.lego.view.f;
import com.baidu.tieba.recapp.lego.view.form.c;
import com.baidu.tieba.recapp.lego.view.g;
import com.baidu.tieba.recapp.lego.view.i;
import org.json.JSONObject;
/* loaded from: classes3.dex */
class a extends e {
    @Override // com.baidu.tieba.lego.card.e
    protected void aPz() {
        fau.put(17, fau.size() + 1);
        fau.put(26, fau.size() + 1);
        fau.put(25, fau.size() + 1);
        fau.put(27, fau.size() + 1);
        fau.put(31, fau.size() + 1);
        fau.put(32, fau.size() + 1);
        fau.put(99, fau.size() + 1);
        fav.put(17, BdUniqueId.gen());
        fav.put(26, BdUniqueId.gen());
        fav.put(25, BdUniqueId.gen());
        fav.put(27, BdUniqueId.gen());
        fav.put(31, BdUniqueId.gen());
        fav.put(32, BdUniqueId.gen());
        fav.put(99, BdUniqueId.gen());
    }

    @Override // com.baidu.tieba.lego.card.e
    public String vG() {
        return "lego_for_RecApp";
    }

    @Override // com.baidu.tieba.lego.card.e
    public ICardInfo a(JSONObject jSONObject, int i) throws CardParseException {
        switch (i) {
            case 17:
                return new AdCard(jSONObject);
            case 25:
                if (MessageManager.getInstance().findTask(2016481) != null) {
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
            case 99:
                return new CriusAdCard(jSONObject);
            default:
                return null;
        }
    }

    @Override // com.baidu.tieba.lego.card.e
    public <T> k a(TbPageContext<T> tbPageContext, ICardInfo iCardInfo, int i) {
        switch (iCardInfo == null ? -1 : iCardInfo.getCardType()) {
            case 17:
            case 26:
                return e(tbPageContext, iCardInfo, i);
            case 25:
                if (MessageManager.getInstance().findTask(2016481) != null) {
                    return new com.baidu.tieba.recapp.lego.view.k(tbPageContext);
                }
                return null;
            case 27:
                return new c(tbPageContext);
            case 31:
                return d(tbPageContext, iCardInfo, i);
            case 32:
                return new com.baidu.tieba.recapp.lego.view.a.c(tbPageContext);
            case 99:
                return new i(tbPageContext);
            default:
                return null;
        }
    }

    private com.baidu.tieba.recapp.lego.view.a.a d(TbPageContext<?> tbPageContext, ICardInfo iCardInfo, int i) {
        if (iCardInfo instanceof AdPost) {
            AdPost adPost = (AdPost) iCardInfo;
            if (adPost.getCardType() == 31) {
                if (PostAdBaseData.STYLE_ONE_IMAGE.equals(adPost.feedData.style) || PostAdBaseData.STYLE_MULTI_IMAGE.equals(adPost.feedData.style)) {
                    return new b(tbPageContext);
                }
                return null;
            }
            return null;
        }
        return null;
    }

    private com.baidu.tieba.lego.card.e.b e(TbPageContext<?> tbPageContext, ICardInfo iCardInfo, int i) {
        if (iCardInfo instanceof AdCard) {
            AdCard adCard = (AdCard) iCardInfo;
            int cardType = adCard.getCardType();
            if (cardType == 17) {
                switch (adCard.goodsStyle) {
                    case 2:
                    case 8:
                        return new d(tbPageContext);
                    case 3:
                    case 4:
                    case 5:
                    default:
                        return null;
                    case 6:
                        return new com.baidu.tieba.recapp.lego.view.c(tbPageContext);
                    case 7:
                        return new com.baidu.tieba.recapp.lego.view.e(tbPageContext);
                    case 9:
                        return new g(tbPageContext);
                    case 10:
                        return new f(tbPageContext);
                }
            } else if (cardType == 26) {
                return new com.baidu.tieba.recapp.lego.view.b(tbPageContext);
            } else {
                BdLog.e("RecAppLegoFactory: specifyAdCardView got wrong card type!");
                return null;
            }
        }
        return null;
    }
}
