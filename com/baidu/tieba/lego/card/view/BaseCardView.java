package com.baidu.tieba.lego.card.view;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.model.BaseCardInfo;
/* loaded from: classes2.dex */
public abstract class BaseCardView<T extends BaseCardInfo> extends BaseLegoCardView<T> {
    public BaseCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mContext = tbPageContext;
        setOrientation(1);
    }
}
