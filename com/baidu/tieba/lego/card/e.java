package com.baidu.tieba.lego.card;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.c.q;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class e {
    public static final SparseIntArray dBT = new SparseIntArray();
    public static final SparseArray<BdUniqueId> dBU = new SparseArray<>();

    public abstract <T> q a(TbPageContext<T> tbPageContext, int i, int i2);

    public abstract ICardInfo a(JSONObject jSONObject, int i) throws CardParseException;

    protected abstract void aBS();

    public e() {
        aBS();
    }
}
