package com.baidu.tieba.lego.card.model;

import com.baidu.adp.BdUniqueId;
import d.a.c.j.e.n;
import java.io.Serializable;
/* loaded from: classes4.dex */
public interface ICardInfo extends Serializable, n {
    int getAdapterCount();

    ICardInfo getAdapterItem(int i2);

    int getAdapterType();

    int getCardType();

    String getFlipId();

    double getRatio();

    /* synthetic */ BdUniqueId getType();

    ICardInfo getUpdateCard();

    int getViewCount();

    ICardInfo getViewItem(int i2, int i3);

    boolean isReusable(ICardInfo iCardInfo);

    boolean isValid();

    boolean responseAttention(Object obj);

    void setBdUniqueId(BdUniqueId bdUniqueId);

    void setGroupId(String str);
}
