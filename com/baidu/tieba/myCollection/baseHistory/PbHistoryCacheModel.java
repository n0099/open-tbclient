package com.baidu.tieba.myCollection.baseHistory;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.model.CacheModel;
/* loaded from: classes.dex */
public class PbHistoryCacheModel extends CacheModel<a, TbPageContext> {
    public PbHistoryCacheModel(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public Class<a> Jv() {
        return a.class;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int Jw() {
        return 2001186;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int Jx() {
        return 2001187;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public String Jg() {
        return "tb.pb_history";
    }
}
