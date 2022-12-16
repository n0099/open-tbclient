package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes6.dex */
public interface vs6 extends FrsLoadMoreModel.b {
    FrsViewData S0();

    String g();

    r9 getPageContext();

    BdUniqueId getUniqueId();
}
