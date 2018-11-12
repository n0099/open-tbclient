package com.baidu.tieba.myCollection.baseHistory;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.model.CacheModel;
/* loaded from: classes.dex */
public class PbHistoryCacheModel extends CacheModel<a, TbPageContext> {
    public PbHistoryCacheModel(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public Class<a> Nj() {
        return a.class;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int Nk() {
        return 2001186;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int Nl() {
        return 2001187;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public String MU() {
        return "tb.pb_history";
    }
}
