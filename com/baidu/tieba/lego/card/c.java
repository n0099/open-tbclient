package com.baidu.tieba.lego.card;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.c.j;
import com.baidu.tieba.lego.card.model.ICardInfo;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class c {
    public static final SparseIntArray dlV = new SparseIntArray();
    public static final SparseArray<BdUniqueId> dlW = new SparseArray<>();

    public abstract <T> j a(TbPageContext<T> tbPageContext, int i, int i2);

    public abstract ICardInfo a(JSONObject jSONObject, int i);

    protected abstract void avV();

    public c() {
        avV();
    }
}
