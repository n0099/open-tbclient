package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes5.dex */
public interface nr6 extends FrsLoadMoreModel.b {
    FrsViewData O0();

    String c();

    r9 getPageContext();

    BdUniqueId getUniqueId();
}
