package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes6.dex */
public interface ly8<T extends ICardInfo> {
    void d();

    void e();

    void g();

    void h();

    void i(BdUniqueId bdUniqueId);

    void setAfterClickSchemeListener(qx8 qx8Var);

    void setBusinessType(int i);

    void setFromCDN(boolean z);

    void setMulDel(boolean z);

    void setPosition(int i);

    void update(Object obj);
}
