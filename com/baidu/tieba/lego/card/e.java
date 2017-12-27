package com.baidu.tieba.lego.card;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.l;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class e {
    public static final SparseIntArray eTn = new SparseIntArray();
    public static final SparseArray<BdUniqueId> eTo = new SparseArray<>();

    public abstract ICardInfo a(JSONObject jSONObject, int i) throws CardParseException;

    public abstract <T> l a(TbPageContext<T> tbPageContext, ICardInfo iCardInfo, int i);

    protected abstract void aNC();

    public abstract String uT();

    public e() {
        aNC();
    }
}
