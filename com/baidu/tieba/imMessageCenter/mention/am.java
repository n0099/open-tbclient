package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class am extends com.baidu.tbadk.mvc.model.a<ay, bf> {
    public am(TbPageContext<bf> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public Class<ay> DD() {
        return ay.class;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public int DE() {
        return CmdConfigCustom.CMD_MENTION_REPLYME_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public int DF() {
        return CmdConfigCustom.CMD_MENTION_REPLYME_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public String Dp() {
        return "tb_user_replyme";
    }
}
