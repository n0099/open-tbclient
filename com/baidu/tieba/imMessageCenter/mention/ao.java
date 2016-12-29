package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ao extends com.baidu.tbadk.mvc.model.a<ba, ReplyMessageActivity> {
    public ao(TbPageContext<ReplyMessageActivity> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public Class<ba> EJ() {
        return ba.class;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public int EK() {
        return CmdConfigCustom.CMD_MENTION_REPLYME_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public int EL() {
        return CmdConfigCustom.CMD_MENTION_REPLYME_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public String Ev() {
        return "tb_user_replyme";
    }
}
