package com.baidu.tieba.myCollection.baseHistory;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.mvc.model.CacheModel;
/* loaded from: classes.dex */
public class PbHistoryCacheModel extends CacheModel<a, TbPageContext> {
    public PbHistoryCacheModel(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public Class<a> EM() {
        return a.class;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int EN() {
        return CmdConfigCustom.CMD_READ_PB_HISTORY_LIST;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int EO() {
        return CmdConfigCustom.CMD_WRITE_PB_HISTORY;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public String Ex() {
        return "tb.pb_history";
    }
}
