package com.baidu.tieba.live.tbean.view;

import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.tieba.b.a;
/* loaded from: classes7.dex */
public class CustomViewHolder<T extends a> extends TypeAdapter.ViewHolder {
    protected T mCardView;

    public CustomViewHolder(T t) {
        super(t.getView());
        this.mCardView = t;
    }

    public T getCardView() {
        return this.mCardView;
    }
}
