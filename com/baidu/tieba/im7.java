package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes6.dex */
public interface im7 extends FrsLoadMoreModel.b {
    FrsViewData c1();

    k9 getPageContext();

    BdUniqueId getUniqueId();

    String v();
}
