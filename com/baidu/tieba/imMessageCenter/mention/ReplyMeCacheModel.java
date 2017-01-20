package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.mvc.model.CacheModel;
/* loaded from: classes.dex */
public class ReplyMeCacheModel extends CacheModel<at, ReplyMessageActivity> {
    public ReplyMeCacheModel(TbPageContext<ReplyMessageActivity> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public Class<at> ED() {
        return at.class;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int EE() {
        return CmdConfigCustom.CMD_MENTION_REPLYME_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int EF() {
        return CmdConfigCustom.CMD_MENTION_REPLYME_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public String Ep() {
        return "tb_user_replyme";
    }
}
