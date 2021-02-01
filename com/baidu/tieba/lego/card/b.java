package com.baidu.tieba.lego.card;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends e {
    private final List<e> factories;

    private b() {
        this.factories = new ArrayList(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static final b lbk = new b();
    }

    public static b dbs() {
        return a.lbk;
    }

    public synchronized void a(e eVar) {
        this.factories.add(eVar);
    }

    @Override // com.baidu.tieba.lego.card.e
    protected void dbt() {
    }

    @Override // com.baidu.tieba.lego.card.e
    public String key() {
        return "lego_main";
    }

    @Override // com.baidu.tieba.lego.card.e
    public ICardInfo g(JSONObject jSONObject, int i) throws CardParseException {
        return h(jSONObject, i);
    }

    private ICardInfo h(JSONObject jSONObject, int i) throws CardParseException {
        for (e eVar : this.factories) {
            try {
                ICardInfo g = eVar.g(jSONObject, i);
                if (g != null) {
                    return g;
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
        com.baidu.tieba.lego.card.view.e b2 = b(tbPageContext, iCardInfo, i);
        if (b2 != null) {
            b2.setBusinessType(i);
        }
        return b2;
    }

    private <T> com.baidu.tieba.lego.card.view.e b(TbPageContext<T> tbPageContext, ICardInfo iCardInfo, int i) {
        com.baidu.tieba.lego.card.view.e a2;
        for (e eVar : this.factories) {
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

    public static ICardInfo NC(String str) {
        try {
            ICardInfo ey = ey(new JSONObject(str));
            if (ey != null) {
                if (ey.isValid()) {
                    return ey;
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

    public static ICardInfo ND(String str) throws Exception {
        ICardInfo ey = ey(new JSONObject(str));
        if (ey == null || !ey.isValid()) {
            return null;
        }
        return ey;
    }

    public static ICardInfo ey(JSONObject jSONObject) throws CardParseException {
        return dbs().g(jSONObject, jSONObject.optInt(IntentConfig.CARD_TYPE));
    }
}
