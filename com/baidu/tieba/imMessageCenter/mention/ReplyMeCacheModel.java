package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.model.CacheModel;
/* loaded from: classes7.dex */
public class ReplyMeCacheModel extends CacheModel<l, ReplyMessageFragment> {
    public ReplyMeCacheModel(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public Class<l> aOc() {
        return l.class;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int aOd() {
        return CmdConfigCustom.CMD_MENTION_REPLYME_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public int aOe() {
        return CmdConfigCustom.CMD_MENTION_REPLYME_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.CacheModel
    public String aNL() {
        return "tb_user_replyme";
    }
}
