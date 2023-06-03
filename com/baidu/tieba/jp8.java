package com.baidu.tieba;

import com.baidu.tieba.lego.card.model.ICardInfo;
import com.squareup.wire.Message;
import java.util.List;
/* loaded from: classes6.dex */
public interface jp8 {
    int a();

    void b(boolean z, Message message, boolean z2, int i);

    List<ICardInfo> c();

    boolean d();

    boolean hasMore();
}
