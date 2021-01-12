package com.baidu.tieba.lego.card.view;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes.dex */
public interface e<T extends ICardInfo> {
    void aN(Object obj);

    void aSK();

    void cQy();

    void cZV();

    void cZW();

    void l(BdUniqueId bdUniqueId);

    void setAfterClickSchemeListener(com.baidu.tieba.lego.card.a aVar);

    void setBusinessType(int i);

    void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar);

    void setFromCDN(boolean z);

    void setPosition(int i);
}
