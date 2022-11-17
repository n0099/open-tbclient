package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes5.dex */
public interface qj7<T extends ICardInfo> {
    void c(BdUniqueId bdUniqueId);

    void e();

    void f();

    void g();

    void h();

    void setAfterClickSchemeListener(ui7 ui7Var);

    void setBusinessType(int i);

    void setFromCDN(boolean z);

    void setMulDel(boolean z);

    void setPosition(int i);

    void update(Object obj);
}
