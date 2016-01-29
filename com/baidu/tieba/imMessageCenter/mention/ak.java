package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ak extends com.baidu.tbadk.mvc.model.a<aw, bd> {
    public ak(TbPageContext<bd> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public Class<aw> EP() {
        return aw.class;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public int EQ() {
        return CmdConfigCustom.CMD_MENTION_REPLYME_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public int ER() {
        return CmdConfigCustom.CMD_MENTION_REPLYME_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public String EB() {
        return "tb_user_replyme";
    }
}
