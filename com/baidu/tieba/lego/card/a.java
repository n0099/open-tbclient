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
public class a extends c {
    private final List<c> doT;

    /* synthetic */ a(a aVar) {
        this();
    }

    private a() {
        this.doT = new ArrayList(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.lego.card.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0068a {
        private static final a doU = new a(null);
    }

    public static a awG() {
        return C0068a.doU;
    }

    public synchronized void a(c cVar) {
        this.doT.add(cVar);
    }

    @Override // com.baidu.tieba.lego.card.c
    protected void awH() {
    }

    @Override // com.baidu.tieba.lego.card.c
    public ICardInfo a(JSONObject jSONObject, int i) throws CardParseException {
        return b(jSONObject, i);
    }

    private ICardInfo b(JSONObject jSONObject, int i) throws CardParseException {
        for (c cVar : this.doT) {
            ICardInfo a = cVar.a(jSONObject, i);
            if (a != null) {
                return a;
            }
        }
        BdLog.e("No card factory for card type " + i);
        return null;
    }

    @Override // com.baidu.tieba.lego.card.c
    public <T> h a(TbPageContext<T> tbPageContext, int i, int i2) {
        h b = b(tbPageContext, i, i2);
        if (b != null) {
            b.setBusinessType(i2);
        }
        return b;
    }

    private <T> h b(TbPageContext<T> tbPageContext, int i, int i2) {
        for (c cVar : this.doT) {
            h a = cVar.a(tbPageContext, i, i2);
            if (a != null) {
                return a;
            }
        }
        BdLog.e("No card factory for card type " + i);
        return null;
    }

    public static ICardInfo mc(String str) {
        try {
            return F(new JSONObject(str));
        } catch (CardParseException e) {
            return null;
        } catch (JSONException e2) {
            return null;
        }
    }

    public static ICardInfo F(JSONObject jSONObject) throws CardParseException {
        return awG().a(jSONObject, jSONObject.optInt("card_type"));
    }
}
