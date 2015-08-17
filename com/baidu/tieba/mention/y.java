package com.baidu.tieba.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.mvc.model.a<aj, SingleMentionActivity> {
    public y(TbPageContext<SingleMentionActivity> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public Class<aj> CR() {
        return aj.class;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public int CS() {
        return CmdConfigCustom.CMD_MENTION_REPLYME_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public int CT() {
        return CmdConfigCustom.CMD_MENTION_REPLYME_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public String CD() {
        return "tb_user_replyme";
    }
}
