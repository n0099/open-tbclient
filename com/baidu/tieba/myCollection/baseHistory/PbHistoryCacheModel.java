package com.baidu.tieba.myCollection.baseHistory;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.model.CacheModel;
/* loaded from: classes.dex */
public class PbHistoryCacheModel extends CacheModel<a, TbPageContext> {
    public PbHistoryCacheModel(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public Class<a> On() {
        return a.class;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int Oo() {
        return 2001186;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int Op() {
        return 2001187;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public String NY() {
        return "tb.pb_history";
    }
}
