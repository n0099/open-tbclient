package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdPageContext;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes7.dex */
public interface qr7 extends FrsLoadMoreModel.b {
    BdPageContext getPageContext();

    BdUniqueId getUniqueId();

    FrsViewData m1();

    String v();
}
