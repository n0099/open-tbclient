package com.baidu.tieba.lego.card.view;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.a;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public interface e<T extends ICardInfo> {
    void QN();

    void ao(Object obj);

    void bKA();

    void bKB();

    void bKC();

    void j(BdUniqueId bdUniqueId);

    void setAfterClickSchemeListener(a aVar);

    void setBusinessType(int i);

    void setDownloadAppCallback(c cVar);

    void setFromCDN(boolean z);

    void setPosition(int i);
}
