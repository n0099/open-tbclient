package com.baidu.tieba.lego.card;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.e.k;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends e {
    private final List<e> faF;

    private b() {
        this.faF = new ArrayList(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static final b faG = new b();
    }

    public static b aPz() {
        return a.faG;
    }

    public synchronized void a(e eVar) {
        this.faF.add(eVar);
    }

    @Override // com.baidu.tieba.lego.card.e
    protected void aPA() {
    }

    @Override // com.baidu.tieba.lego.card.e
    public String vG() {
        return "lego_main";
    }

    @Override // com.baidu.tieba.lego.card.e
    public ICardInfo a(JSONObject jSONObject, int i) throws CardParseException {
        return b(jSONObject, i);
    }

    private ICardInfo b(JSONObject jSONObject, int i) throws CardParseException {
        for (e eVar : this.faF) {
            try {
                ICardInfo a2 = eVar.a(jSONObject, i);
                if (a2 != null) {
                    return a2;
                }
            } catch (Throwable th) {
                throw new CardParseException("Card type " + i + ", factory <" + eVar.vG() + "> respond exception", th);
            }
        }
        BdLog.e("No card factory for card type " + i);
        return null;
    }

    @Override // com.baidu.tieba.lego.card.e
    public <T> k a(TbPageContext<T> tbPageContext, ICardInfo iCardInfo, int i) {
        k b = b(tbPageContext, iCardInfo, i);
        if (b != null) {
            b.setBusinessType(i);
        }
        return b;
    }

    private <T> k b(TbPageContext<T> tbPageContext, ICardInfo iCardInfo, int i) {
        k a2;
        for (e eVar : this.faF) {
            try {
                a2 = eVar.a(tbPageContext, iCardInfo, i);
            } catch (Throwable th) {
                BdLog.detailException("factory <" + eVar.vG() + "> respond exception", th);
            }
            if (a2 != null) {
                return a2;
            }
        }
        BdLog.e("No card factory for card type " + (iCardInfo == null ? -1 : iCardInfo.getCardType()));
        return null;
    }

    public static ICardInfo or(String str) {
        try {
            ICardInfo I = I(new JSONObject(str));
            if (I != null) {
                if (I.isValid()) {
                    return I;
                }
            }
            return null;
        } catch (CardParseException e) {
            BdLog.detailException("CardFactory.getPageCardInfo", e);
            return null;
        } catch (JSONException e2) {
            BdLog.detailException("CardFactory.getPageCardInfo", e2);
            return null;
        }
    }

    public static ICardInfo I(JSONObject jSONObject) throws CardParseException {
        return aPz().a(jSONObject, jSONObject.optInt("card_type"));
    }
}
