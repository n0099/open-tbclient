package com.baidu.tieba.lego.card;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.c.h;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends d {
    private final List<d> dAz;

    /* synthetic */ b(b bVar) {
        this();
    }

    private b() {
        this.dAz = new ArrayList(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static final b dAA = new b(null);
    }

    public static b aBt() {
        return a.dAA;
    }

    public synchronized void a(d dVar) {
        this.dAz.add(dVar);
    }

    @Override // com.baidu.tieba.lego.card.d
    protected void aBu() {
    }

    @Override // com.baidu.tieba.lego.card.d
    public ICardInfo a(JSONObject jSONObject, int i) throws CardParseException {
        return b(jSONObject, i);
    }

    private ICardInfo b(JSONObject jSONObject, int i) throws CardParseException {
        for (d dVar : this.dAz) {
            ICardInfo a2 = dVar.a(jSONObject, i);
            if (a2 != null) {
                return a2;
            }
        }
        BdLog.e("No card factory for card type " + i);
        return null;
    }

    @Override // com.baidu.tieba.lego.card.d
    public <T> h a(TbPageContext<T> tbPageContext, int i, int i2) {
        h b = b(tbPageContext, i, i2);
        if (b != null) {
            b.setBusinessType(i2);
        }
        return b;
    }

    private <T> h b(TbPageContext<T> tbPageContext, int i, int i2) {
        for (d dVar : this.dAz) {
            h a2 = dVar.a(tbPageContext, i, i2);
            if (a2 != null) {
                return a2;
            }
        }
        BdLog.e("No card factory for card type " + i);
        return null;
    }

    public static ICardInfo mL(String str) {
        try {
            return F(new JSONObject(str));
        } catch (CardParseException e) {
            return null;
        } catch (JSONException e2) {
            return null;
        }
    }

    public static ICardInfo F(JSONObject jSONObject) throws CardParseException {
        return aBt().a(jSONObject, jSONObject.optInt("card_type"));
    }
}
