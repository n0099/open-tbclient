package com.baidu.tieba.lego.card;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends e {
    private final List<e> heJ;

    private b() {
        this.heJ = new ArrayList(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static final b heK = new b();
    }

    public static b bHK() {
        return a.heK;
    }

    public synchronized void a(e eVar) {
        this.heJ.add(eVar);
    }

    @Override // com.baidu.tieba.lego.card.e
    protected void bHL() {
    }

    @Override // com.baidu.tieba.lego.card.e
    public String key() {
        return "lego_main";
    }

    @Override // com.baidu.tieba.lego.card.e
    public ICardInfo d(JSONObject jSONObject, int i) throws CardParseException {
        return e(jSONObject, i);
    }

    private ICardInfo e(JSONObject jSONObject, int i) throws CardParseException {
        for (e eVar : this.heJ) {
            try {
                ICardInfo d = eVar.d(jSONObject, i);
                if (d != null) {
                    return d;
                }
            } catch (Throwable th) {
                throw new CardParseException("Card type " + i + ", factory <" + eVar.key() + "> respond exception", th);
            }
        }
        BdLog.e("No card factory for card type " + i);
        return null;
    }

    @Override // com.baidu.tieba.lego.card.e
    public <T> com.baidu.tieba.lego.card.view.e a(TbPageContext<T> tbPageContext, ICardInfo iCardInfo, int i) {
        com.baidu.tieba.lego.card.view.e b = b(tbPageContext, iCardInfo, i);
        if (b != null) {
            b.setBusinessType(i);
        }
        return b;
    }

    private <T> com.baidu.tieba.lego.card.view.e b(TbPageContext<T> tbPageContext, ICardInfo iCardInfo, int i) {
        com.baidu.tieba.lego.card.view.e a2;
        for (e eVar : this.heJ) {
            try {
                a2 = eVar.a(tbPageContext, iCardInfo, i);
            } catch (Throwable th) {
                BdLog.detailException("factory <" + eVar.key() + "> respond exception", th);
            }
            if (a2 != null) {
                return a2;
            }
        }
        BdLog.e("No card factory for card type " + (iCardInfo == null ? -1 : iCardInfo.getCardType()));
        return null;
    }

    public static ICardInfo yP(String str) {
        try {
            ICardInfo ce = ce(new JSONObject(str));
            if (ce != null) {
                if (ce.isValid()) {
                    return ce;
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

    public static ICardInfo yQ(String str) throws Exception {
        ICardInfo ce = ce(new JSONObject(str));
        if (ce == null || !ce.isValid()) {
            return null;
        }
        return ce;
    }

    public static ICardInfo ce(JSONObject jSONObject) throws CardParseException {
        return bHK().d(jSONObject, jSONObject.optInt("card_type"));
    }
}
