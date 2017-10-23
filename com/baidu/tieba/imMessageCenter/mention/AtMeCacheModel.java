package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.mvc.model.CacheModel;
/* loaded from: classes2.dex */
public class AtMeCacheModel extends CacheModel<c, g> {
    public AtMeCacheModel(TbPageContext<g> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public Class<c> EM() {
        return c.class;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int EN() {
        return CmdConfigCustom.CMD_MENTION_ATME_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int EO() {
        return CmdConfigCustom.CMD_MENTION_ATME_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public String Ex() {
        return "tb_user_atme";
    }
}
