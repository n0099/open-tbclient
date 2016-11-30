package com.baidu.tieba.lego.card;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.c.u;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class e {
    public static final SparseIntArray dHy = new SparseIntArray();
    public static final SparseArray<BdUniqueId> dHz = new SparseArray<>();

    public abstract <T> u a(TbPageContext<T> tbPageContext, int i, int i2);

    public abstract ICardInfo a(JSONObject jSONObject, int i) throws CardParseException;

    protected abstract void aDO();

    public e() {
        aDO();
    }
}
