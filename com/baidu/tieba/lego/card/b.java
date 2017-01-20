package com.baidu.tieba.lego.card;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.bi;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends e {
    private final List<e> dsj;

    /* synthetic */ b(b bVar) {
        this();
    }

    private b() {
        this.dsj = new ArrayList(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static final b dsk = new b(null);
    }

    public static b ayo() {
        return a.dsk;
    }

    public synchronized void a(e eVar) {
        this.dsj.add(eVar);
    }

    public synchronized void a(e eVar, int i) {
        this.dsj.add(0, eVar);
    }

    @Override // com.baidu.tieba.lego.card.e
    protected void ayp() {
    }

    @Override // com.baidu.tieba.lego.card.e
    public ICardInfo a(JSONObject jSONObject, int i) throws CardParseException {
        return b(jSONObject, i);
    }

    private ICardInfo b(JSONObject jSONObject, int i) throws CardParseException {
        for (e eVar : this.dsj) {
            ICardInfo a2 = eVar.a(jSONObject, i);
            if (a2 != null) {
                return a2;
            }
        }
        BdLog.e("No card factory for card type " + i);
        return null;
    }

    @Override // com.baidu.tieba.lego.card.e
    public <T> bi a(TbPageContext<T> tbPageContext, int i, int i2) {
        bi b = b(tbPageContext, i, i2);
        if (b != null) {
            b.setBusinessType(i2);
        }
        return b;
    }

    private <T> bi b(TbPageContext<T> tbPageContext, int i, int i2) {
        for (e eVar : this.dsj) {
            bi a2 = eVar.a(tbPageContext, i, i2);
            if (a2 != null) {
                return a2;
            }
        }
        BdLog.e("No card factory for card type " + i);
        return null;
    }

    public static ICardInfo lM(String str) {
        try {
            ICardInfo r = r(new JSONObject(str));
            if (r != null) {
                if (r.isValid()) {
                    return r;
                }
            }
            return null;
        } catch (CardParseException e) {
            return null;
        } catch (JSONException e2) {
            return null;
        }
    }

    public static ICardInfo r(JSONObject jSONObject) throws CardParseException {
        return ayo().a(jSONObject, jSONObject.optInt("card_type"));
    }
}
