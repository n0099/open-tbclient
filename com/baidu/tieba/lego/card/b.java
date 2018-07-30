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
    private final List<e> ePv;

    private b() {
        this.ePv = new ArrayList(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static final b ePw = new b();
    }

    public static b aRb() {
        return a.ePw;
    }

    public synchronized void a(e eVar) {
        this.ePv.add(eVar);
    }

    @Override // com.baidu.tieba.lego.card.e
    protected void aRc() {
    }

    @Override // com.baidu.tieba.lego.card.e
    public String rs() {
        return "lego_main";
    }

    @Override // com.baidu.tieba.lego.card.e
    public ICardInfo a(JSONObject jSONObject, int i) throws CardParseException {
        return b(jSONObject, i);
    }

    private ICardInfo b(JSONObject jSONObject, int i) throws CardParseException {
        for (e eVar : this.ePv) {
            try {
                ICardInfo a2 = eVar.a(jSONObject, i);
                if (a2 != null) {
                    return a2;
                }
            } catch (Throwable th) {
                throw new CardParseException("Card type " + i + ", factory <" + eVar.rs() + "> respond exception", th);
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
        for (e eVar : this.ePv) {
            try {
                a2 = eVar.a(tbPageContext, iCardInfo, i);
            } catch (Throwable th) {
                BdLog.detailException("factory <" + eVar.rs() + "> respond exception", th);
            }
            if (a2 != null) {
                return a2;
            }
        }
        BdLog.e("No card factory for card type " + (iCardInfo == null ? -1 : iCardInfo.getCardType()));
        return null;
    }

    public static ICardInfo pn(String str) {
        try {
            ICardInfo O = O(new JSONObject(str));
            if (O != null) {
                if (O.isValid()) {
                    return O;
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

    public static ICardInfo po(String str) throws Exception {
        ICardInfo O = O(new JSONObject(str));
        if (O == null || !O.isValid()) {
            return null;
        }
        return O;
    }

    public static ICardInfo O(JSONObject jSONObject) throws CardParseException {
        return aRb().a(jSONObject, jSONObject.optInt("card_type"));
    }
}
