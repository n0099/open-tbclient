package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes6.dex */
public interface wd7 extends FrsLoadMoreModel.b {
    FrsViewData a1();

    a9 getPageContext();

    BdUniqueId getUniqueId();

    String v();
}
