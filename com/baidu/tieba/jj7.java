package com.baidu.tieba;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.squareup.wire.Message;
import java.util.List;
/* loaded from: classes4.dex */
public interface jj7 {
    boolean a();

    int b();

    void c(boolean z, Message message, boolean z2, int i);

    List<ICardInfo> d();

    boolean hasMore();
}
