package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdPageContext;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes6.dex */
public interface jm7 extends FrsLoadMoreModel.b {
    BdPageContext getPageContext();

    BdUniqueId getUniqueId();

    FrsViewData s1();

    String v();
}
