package com.baidu.tieba.lego.c;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.squareup.wire.Message;
import java.util.List;
/* loaded from: classes.dex */
public interface a {
    void a(boolean z, Message message, boolean z2, int i);

    List<ICardInfo> aPi();

    int getPn();

    boolean hasData();

    boolean hasMore();
}
