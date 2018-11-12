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
    private final List<e> ffM;

    private b() {
        this.ffM = new ArrayList(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static final b ffN = new b();
    }

    public static b aVX() {
        return a.ffN;
    }

    public synchronized void a(e eVar) {
        this.ffM.add(eVar);
    }

    @Override // com.baidu.tieba.lego.card.e
    protected void aVY() {
    }

    @Override // com.baidu.tieba.lego.card.e
    public String key() {
        return "lego_main";
    }

    @Override // com.baidu.tieba.lego.card.e
    public ICardInfo a(JSONObject jSONObject, int i) throws CardParseException {
        return b(jSONObject, i);
    }

    private ICardInfo b(JSONObject jSONObject, int i) throws CardParseException {
        for (e eVar : this.ffM) {
            try {
                ICardInfo a2 = eVar.a(jSONObject, i);
                if (a2 != null) {
                    return a2;
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
        for (e eVar : this.ffM) {
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

    public static ICardInfo qx(String str) {
        try {
            ICardInfo ai = ai(new JSONObject(str));
            if (ai != null) {
                if (ai.isValid()) {
                    return ai;
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

    public static ICardInfo qy(String str) throws Exception {
        ICardInfo ai = ai(new JSONObject(str));
        if (ai == null || !ai.isValid()) {
            return null;
        }
        return ai;
    }

    public static ICardInfo ai(JSONObject jSONObject) throws CardParseException {
        return aVX().a(jSONObject, jSONObject.optInt("card_type"));
    }
}
