package com.baidu.tieba.lego.card.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.v.a;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.f;
/* loaded from: classes.dex */
public abstract class a<T extends v.a> extends com.baidu.adp.widget.ListView.a<ICardInfo, T> implements f {
    protected int hZu;

    protected a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    public void setBusinessType(int i) {
        this.hZu = i;
    }
}
