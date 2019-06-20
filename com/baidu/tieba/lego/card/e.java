package com.baidu.tieba.lego.card;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class e {
    public static final SparseIntArray gXK = new SparseIntArray();
    public static final SparseArray<BdUniqueId> gXL = new SparseArray<>();

    public abstract <T> com.baidu.tieba.lego.card.view.e a(TbPageContext<T> tbPageContext, ICardInfo iCardInfo, int i);

    protected abstract void bHt();

    public abstract ICardInfo d(JSONObject jSONObject, int i) throws CardParseException;

    public abstract String key();

    public e() {
        bHt();
    }
}
