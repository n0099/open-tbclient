package com.baidu.tieba;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.squareup.wire.Message;
import java.util.List;
/* loaded from: classes6.dex */
public interface sm7 {
    boolean a();

    int b();

    void c(boolean z, Message message, boolean z2, int i);

    List<ICardInfo> d();

    boolean hasMore();
}
