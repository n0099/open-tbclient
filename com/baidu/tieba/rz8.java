package com.baidu.tieba;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.squareup.wire.Message;
import java.util.List;
/* loaded from: classes8.dex */
public interface rz8 {
    int a();

    void b(boolean z, Message message, boolean z2, int i);

    boolean c();

    List<ICardInfo> d();

    boolean hasMore();
}
