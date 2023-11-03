package com.baidu.tieba.lego.card.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.oi;
import java.io.Serializable;
/* loaded from: classes7.dex */
public interface ICardInfo extends Serializable, oi {
    int getAdapterCount();

    ICardInfo getAdapterItem(int i);

    int getAdapterType();

    int getCardType();

    String getFlipId();

    double getRatio();

    /* synthetic */ BdUniqueId getType();

    ICardInfo getUpdateCard();

    int getViewCount();

    ICardInfo getViewItem(int i, int i2);

    boolean isReusable(ICardInfo iCardInfo);

    boolean isValid();

    boolean responseAttention(Object obj);

    void setBdUniqueId(BdUniqueId bdUniqueId);

    void setGroupId(String str);
}
