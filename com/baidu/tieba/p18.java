package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdPageContext;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes7.dex */
public interface p18 extends FrsLoadMoreModel.b {
    FrsViewData Q1();

    BdPageContext getPageContext();

    BdUniqueId getUniqueId();

    String v();
}
