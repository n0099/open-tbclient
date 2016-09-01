package com.baidu.tieba.lego.card.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.adp.widget.ListView.y.a;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.e;
/* loaded from: classes.dex */
public abstract class a<T extends y.a> extends com.baidu.adp.widget.ListView.a<ICardInfo, T> implements e {
    protected int dAE;

    protected a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    public void setBusinessType(int i) {
        this.dAE = i;
    }
}
