package com.baidu.tieba.lego.card;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.bl;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class e {
    public static final SparseIntArray duC = new SparseIntArray();
    public static final SparseArray<BdUniqueId> duD = new SparseArray<>();

    public abstract ICardInfo a(JSONObject jSONObject, int i) throws CardParseException;

    public abstract <T> bl a(TbPageContext<T> tbPageContext, int i, int i2);

    protected abstract void axL();

    public abstract String axz();

    public e() {
        axL();
    }
}
