package com.baidu.tieba.lego.card;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.c.h;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class c {
    public static final SparseIntArray doW = new SparseIntArray();
    public static final SparseArray<BdUniqueId> doX = new SparseArray<>();

    public abstract <T> h a(TbPageContext<T> tbPageContext, int i, int i2);

    public abstract ICardInfo a(JSONObject jSONObject, int i) throws CardParseException;

    protected abstract void awH();

    public c() {
        awH();
    }
}
