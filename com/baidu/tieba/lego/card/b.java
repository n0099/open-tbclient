package com.baidu.tieba.lego.card;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.am;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends e {
    private final List<e> dCW;

    /* synthetic */ b(b bVar) {
        this();
    }

    private b() {
        this.dCW = new ArrayList(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static final b dCX = new b(null);
    }

    public static b aAk() {
        return a.dCX;
    }

    public synchronized void a(e eVar) {
        this.dCW.add(eVar);
    }

    public synchronized void a(e eVar, int i) {
        this.dCW.add(0, eVar);
    }

    @Override // com.baidu.tieba.lego.card.e
    protected void aAl() {
    }

    @Override // com.baidu.tieba.lego.card.e
    public String nq() {
        return "lego_main";
    }

    @Override // com.baidu.tieba.lego.card.e
    public ICardInfo a(JSONObject jSONObject, int i) throws CardParseException {
        return b(jSONObject, i);
    }

    private ICardInfo b(JSONObject jSONObject, int i) throws CardParseException {
        for (e eVar : this.dCW) {
            try {
                ICardInfo a2 = eVar.a(jSONObject, i);
                if (a2 != null) {
                    return a2;
                }
            } catch (Throwable th) {
                throw new CardParseException("Card type " + i + ", factory <" + eVar.nq() + "> respond exception", th);
            }
        }
        BdLog.e("No card factory for card type " + i);
        return null;
    }

    @Override // com.baidu.tieba.lego.card.e
    public <T> am a(TbPageContext<T> tbPageContext, ICardInfo iCardInfo, int i) {
        am b = b(tbPageContext, iCardInfo, i);
        if (b != null) {
            b.setBusinessType(i);
        }
        return b;
    }

    private <T> am b(TbPageContext<T> tbPageContext, ICardInfo iCardInfo, int i) {
        am a2;
        for (e eVar : this.dCW) {
            try {
                a2 = eVar.a(tbPageContext, iCardInfo, i);
            } catch (Throwable th) {
                BdLog.detailException("factory <" + eVar.nq() + "> respond exception", th);
            }
            if (a2 != null) {
                return a2;
            }
        }
        BdLog.e("No card factory for card type " + (iCardInfo == null ? -1 : iCardInfo.getCardType()));
        return null;
    }

    public static ICardInfo mF(String str) {
        try {
            ICardInfo u = u(new JSONObject(str));
            if (u != null) {
                if (u.isValid()) {
                    return u;
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

    public static ICardInfo u(JSONObject jSONObject) throws CardParseException {
        return aAk().a(jSONObject, jSONObject.optInt("card_type"));
    }
}
