package com.baidu.tieba.lego.card;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.bi;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class e {
    public static final SparseIntArray dsm = new SparseIntArray();
    public static final SparseArray<BdUniqueId> dsn = new SparseArray<>();

    public abstract ICardInfo a(JSONObject jSONObject, int i) throws CardParseException;

    public abstract <T> bi a(TbPageContext<T> tbPageContext, int i, int i2);

    protected abstract void ayp();

    public e() {
        ayp();
    }
}
