package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.mvc.model.CacheModel;
/* loaded from: classes2.dex */
public class ReplyMeCacheModel extends CacheModel<m, ReplyMessageActivity> {
    public ReplyMeCacheModel(TbPageContext<ReplyMessageActivity> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public Class<m> Fs() {
        return m.class;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int Ft() {
        return CmdConfigCustom.CMD_MENTION_REPLYME_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int Fu() {
        return CmdConfigCustom.CMD_MENTION_REPLYME_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public String Fd() {
        return "tb_user_replyme";
    }
}
