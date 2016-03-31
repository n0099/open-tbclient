package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class al extends com.baidu.tbadk.mvc.model.a<ax, be> {
    public al(TbPageContext<be> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public Class<ax> FC() {
        return ax.class;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public int FD() {
        return CmdConfigCustom.CMD_MENTION_REPLYME_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public int FE() {
        return CmdConfigCustom.CMD_MENTION_REPLYME_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public String Fo() {
        return "tb_user_replyme";
    }
}
