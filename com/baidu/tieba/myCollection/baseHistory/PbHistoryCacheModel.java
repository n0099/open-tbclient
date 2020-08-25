package com.baidu.tieba.myCollection.baseHistory;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.model.CacheModel;
/* loaded from: classes2.dex */
public class PbHistoryCacheModel extends CacheModel<a, TbPageContext> {
    public PbHistoryCacheModel(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public Class<a> btF() {
        return a.class;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int btG() {
        return CmdConfigCustom.CMD_READ_PB_HISTORY_LIST;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int btH() {
        return CmdConfigCustom.CMD_WRITE_PB_HISTORY;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public String bto() {
        return "tb.pb_history";
    }
}
