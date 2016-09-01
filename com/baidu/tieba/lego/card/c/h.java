package com.baidu.tieba.lego.card.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.a;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public interface h<T extends ICardInfo> {
    void M(Object obj);

    void aBS();

    void aBT();

    void aBU();

    void i(BdUniqueId bdUniqueId);

    void setAfterClickSchemeListener(a aVar);

    void setBusinessType(int i);

    void setPosition(int i);
}
