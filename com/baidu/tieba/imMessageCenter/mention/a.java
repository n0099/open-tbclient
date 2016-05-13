package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.model.a<i, bf> {
    public a(TbPageContext<bf> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public Class<i> Dv() {
        return i.class;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public int Dw() {
        return CmdConfigCustom.CMD_MENTION_ATME_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public int Dx() {
        return CmdConfigCustom.CMD_MENTION_ATME_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public String Dh() {
        return "tb_user_atme";
    }
}
