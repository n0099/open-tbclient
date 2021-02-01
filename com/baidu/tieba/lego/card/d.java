package com.baidu.tieba.lego.card;

import com.baidu.adp.BdUniqueId;
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
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class d extends e {
    private d() {
    }

    /* loaded from: classes9.dex */
    private static class a {
        private static final d lbl = new d();
    }

    public static d dbv() {
        return a.lbl;
    }

    @Override // com.baidu.tieba.lego.card.e
    protected void dbt() {
        lbm.put(1, lbm.size() + 1);
        lbm.put(2, lbm.size() + 1);
        lbm.put(3, lbm.size() + 1);
        lbm.put(5, lbm.size() + 1);
        lbm.put(6, lbm.size() + 1);
        lbm.put(7, lbm.size() + 1);
        lbm.put(8, lbm.size() + 1);
        lbm.put(18, lbm.size() + 1);
        lbm.put(19, lbm.size() + 1);
        lbm.put(21, lbm.size() + 1);
        lbm.put(22, lbm.size() + 1);
        lbm.put(23, lbm.size() + 1);
        lbm.put(28, lbm.size() + 1);
        lbn.put(1, BdUniqueId.gen());
        lbn.put(2, BdUniqueId.gen());
        lbn.put(3, BdUniqueId.gen());
        lbn.put(5, BdUniqueId.gen());
        lbn.put(6, BdUniqueId.gen());
        lbn.put(7, BdUniqueId.gen());
        lbn.put(8, BdUniqueId.gen());
        lbn.put(18, BdUniqueId.gen());
        lbn.put(19, BdUniqueId.gen());
        lbn.put(21, BdUniqueId.gen());
        lbn.put(22, BdUniqueId.gen());
        lbn.put(23, BdUniqueId.gen());
        lbn.put(28, BdUniqueId.gen());
    }

    @Override // com.baidu.tieba.lego.card.e
    public String key() {
        return "lego_main";
    }

    @Override // com.baidu.tieba.lego.card.e
    public ICardInfo g(JSONObject jSONObject, int i) throws CardParseException {
        switch (i) {
            case 1:
                return new PlayPicInfoCard(jSONObject);
            case 2:
                return new SingleLineCard(jSONObject);
            case 3:
                return new OnePicInfoCard(jSONObject);
            case 4:
            case 9:
            case 10:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 20:
            case 24:
            case 25:
            case 26:
            case 27:
            default:
                return null;
            case 5:
                return new FocusListCard(jSONObject);
            case 6:
                return new HorRankCard(jSONObject);
            case 7:
                return new RankDetailTrendCard(jSONObject);
            case 8:
                return new RankScoreCard(jSONObject);
            case 11:
                return new CardGroup(jSONObject);
            case 18:
                return new WebViewCard(jSONObject);
            case 19:
                return new BigImgCard(jSONObject);
            case 21:
                return new LPBigImgCard(jSONObject);
            case 22:
                return new ImmersiveVideoCardEx(jSONObject);
            case 23:
                return new ImmersiveWebViewCard(jSONObject);
            case 28:
                return new ButtonCard(jSONObject);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.e
    /* renamed from: c */
    public <T> BaseCardView a(TbPageContext<T> tbPageContext, ICardInfo iCardInfo, int i) {
        switch (iCardInfo == null ? -1 : iCardInfo.getCardType()) {
            case 1:
                return new PlayPicInfoCardView(tbPageContext);
            case 2:
                return new SingleLineCardView(tbPageContext);
            case 3:
                return new OnePicInfoCardView(tbPageContext);
            case 4:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 20:
            case 24:
            case 25:
            case 26:
            case 27:
            default:
                return null;
            case 5:
                return new FocusListCardView(tbPageContext);
            case 6:
                return new HorRankCardView(tbPageContext);
            case 7:
                return new RankDetailTrendCardView(tbPageContext);
            case 8:
                return new RankScoreCardView(tbPageContext);
            case 18:
                return new WebViewCardView(tbPageContext);
            case 19:
                return new BigImgView(tbPageContext);
            case 21:
                return new LPBigImgCardView(tbPageContext);
            case 22:
                return new ImmersiveVideoCardViewEx(tbPageContext);
            case 23:
                return new ImmersiveWebViewCardView(tbPageContext);
            case 28:
                return new ButtonCardView(tbPageContext);
        }
    }
}
