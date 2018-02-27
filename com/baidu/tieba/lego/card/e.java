package com.baidu.tieba.lego.card;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.e.k;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class e {
    public static final SparseIntArray fau = new SparseIntArray();
    public static final SparseArray<BdUniqueId> fav = new SparseArray<>();

    public abstract <T> k a(TbPageContext<T> tbPageContext, ICardInfo iCardInfo, int i);

    public abstract ICardInfo a(JSONObject jSONObject, int i) throws CardParseException;

    protected abstract void aPz();

    public abstract String vG();

    public e() {
        aPz();
    }
}
