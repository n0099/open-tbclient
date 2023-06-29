package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes8.dex */
public interface um7 extends FrsLoadMoreModel.b {
    FrsViewData c1();

    l9 getPageContext();

    BdUniqueId getUniqueId();

    String v();
}
