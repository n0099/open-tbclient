package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdPageContext;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes6.dex */
public interface lo7 extends FrsLoadMoreModel.b {
    FrsViewData d1();

    BdPageContext getPageContext();

    BdUniqueId getUniqueId();

    String v();
}
