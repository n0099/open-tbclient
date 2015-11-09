package com.baidu.tieba.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.model.a<i, SingleMentionActivity> {
    public a(TbPageContext<SingleMentionActivity> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public Class<i> CE() {
        return i.class;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public int CF() {
        return CmdConfigCustom.CMD_MENTION_ATME_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public int CG() {
        return CmdConfigCustom.CMD_MENTION_ATME_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public String Cq() {
        return "tb_user_atme";
    }
}
