package com.baidu.tieba.lego.card.view;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.model.BaseCardInfo;
/* loaded from: classes8.dex */
public abstract class BaseCardView<T extends BaseCardInfo> extends BaseLegoCardView<T> {
    public BaseCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eSJ = tbPageContext;
        setOrientation(1);
    }
}
