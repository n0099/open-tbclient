package com.baidu.tieba.lego.card;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.c.q;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends e {
    private final List<e> dBQ;

    /* synthetic */ b(b bVar) {
        this();
    }

    private b() {
        this.dBQ = new ArrayList(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static final b dBR = new b(null);
    }

    public static b aBR() {
        return a.dBR;
    }

    public synchronized void a(e eVar) {
        this.dBQ.add(eVar);
    }

    @Override // com.baidu.tieba.lego.card.e
    protected void aBS() {
    }

    @Override // com.baidu.tieba.lego.card.e
    public ICardInfo a(JSONObject jSONObject, int i) throws CardParseException {
        return b(jSONObject, i);
    }

    private ICardInfo b(JSONObject jSONObject, int i) throws CardParseException {
        for (e eVar : this.dBQ) {
            ICardInfo a2 = eVar.a(jSONObject, i);
            if (a2 != null) {
                return a2;
            }
        }
        BdLog.e("No card factory for card type " + i);
        return null;
    }

    @Override // com.baidu.tieba.lego.card.e
    public <T> q a(TbPageContext<T> tbPageContext, int i, int i2) {
        q b = b(tbPageContext, i, i2);
        if (b != null) {
            b.setBusinessType(i2);
        }
        return b;
    }

    private <T> q b(TbPageContext<T> tbPageContext, int i, int i2) {
        for (e eVar : this.dBQ) {
            q a2 = eVar.a(tbPageContext, i, i2);
            if (a2 != null) {
                return a2;
            }
        }
        BdLog.e("No card factory for card type " + i);
        return null;
    }

    public static ICardInfo mY(String str) {
        try {
            return H(new JSONObject(str));
        } catch (CardParseException e) {
            return null;
        } catch (JSONException e2) {
            return null;
        }
    }

    public static ICardInfo H(JSONObject jSONObject) throws CardParseException {
        return aBR().a(jSONObject, jSONObject.optInt("card_type"));
    }
}
