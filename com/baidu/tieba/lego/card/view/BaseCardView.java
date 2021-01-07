package com.baidu.tieba.lego.card.view;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.model.BaseCardInfo;
/* loaded from: classes9.dex */
public abstract class BaseCardView<T extends BaseCardInfo> extends BaseLegoCardView<T> {
    public BaseCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eXu = tbPageContext;
        setOrientation(1);
    }
}
