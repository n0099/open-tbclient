package com.baidu.tieba.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class z extends com.baidu.tbadk.mvc.model.a<ak, SingleMentionActivity> {
    public z(TbPageContext<SingleMentionActivity> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public Class<ak> CE() {
        return ak.class;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public int CF() {
        return CmdConfigCustom.CMD_MENTION_REPLYME_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public int CG() {
        return CmdConfigCustom.CMD_MENTION_REPLYME_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public String Cq() {
        return "tb_user_replyme";
    }
}
