package com.baidu.tieba.lego.card.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.b;
import java.io.Serializable;
/* loaded from: classes.dex */
public interface ICardInfo extends v, Serializable {
    int getAdapterCount();

    ICardInfo getAdapterItem(int i);

    int getAdapterType();

    b getAdvertAppInfo();

    int getCardType();

    String getFlipId();

    @Override // com.baidu.adp.widget.ListView.v
    BdUniqueId getType();

    ICardInfo getUpdateCard();

    int getViewCount();

    ICardInfo getViewItem(int i, int i2);

    boolean isValid();

    boolean responseAttention(Object obj);

    void setAdvertAppInfo(b bVar);

    void setBdUniqueId(BdUniqueId bdUniqueId);

    void setGroupId(String str);
}
