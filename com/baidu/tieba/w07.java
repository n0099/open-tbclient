package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes6.dex */
public interface w07 extends FrsLoadMoreModel.b {
    FrsViewData X0();

    String e();

    x9 getPageContext();

    BdUniqueId getUniqueId();
}
