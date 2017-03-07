package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.mvc.model.CacheModel;
/* loaded from: classes.dex */
public class AtMeCacheModel extends CacheModel<f, ad> {
    public AtMeCacheModel(TbPageContext<ad> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public Class<f> EX() {
        return f.class;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int EY() {
        return CmdConfigCustom.CMD_MENTION_ATME_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int EZ() {
        return CmdConfigCustom.CMD_MENTION_ATME_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public String EI() {
        return "tb_user_atme";
    }
}
