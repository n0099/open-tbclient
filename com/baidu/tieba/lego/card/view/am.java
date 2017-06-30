package com.baidu.tieba.lego.card.view;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.a;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public interface am<T extends ICardInfo> {
    void M(Object obj);

    void aAM();

    void aAN();

    void aAO();

    void aAP();

    void i(BdUniqueId bdUniqueId);

    void setAfterClickSchemeListener(a aVar);

    void setBusinessType(int i);

    void setDownloadAppCallback(c cVar);

    void setFromCDN(boolean z);

    void setPosition(int i);
}
