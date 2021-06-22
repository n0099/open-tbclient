package com.baidu.tieba.myCollection.baseHistory;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.model.CacheModel;
import d.a.o0.x1.h.a;
/* loaded from: classes4.dex */
public class PbHistoryCacheModel extends CacheModel<a, TbPageContext> {
    public PbHistoryCacheModel(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public Class<a> H() {
        return a.class;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int I() {
        return 2001186;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int J() {
        return 2001187;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public String v() {
        return "tb.pb_history";
    }
}
