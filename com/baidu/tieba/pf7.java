package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
/* loaded from: classes5.dex */
public interface pf7<T extends ICardInfo> {
    void c(BdUniqueId bdUniqueId);

    void d();

    void f();

    void g();

    void h();

    void setAfterClickSchemeListener(te7 te7Var);

    void setBusinessType(int i);

    void setFromCDN(boolean z);

    void setMulDel(boolean z);

    void setPosition(int i);

    void update(Object obj);
}
