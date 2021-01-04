package com.baidu.tieba.lego.card.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import java.io.Serializable;
/* loaded from: classes.dex */
public interface ICardInfo extends n, Serializable {
    int getAdapterCount();

    ICardInfo getAdapterItem(int i);

    int getAdapterType();

    int getCardType();

    String getFlipId();

    double getRatio();

    ICardInfo getUpdateCard();

    int getViewCount();

    ICardInfo getViewItem(int i, int i2);

    boolean isReusable(ICardInfo iCardInfo);

    boolean isValid();

    boolean responseAttention(Object obj);

    void setBdUniqueId(BdUniqueId bdUniqueId);

    void setGroupId(String str);
}
