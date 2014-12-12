package com.baidu.tieba.mention;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class s extends com.baidu.tbadk.mvc.model.a<ae, SingleMentionActivity> {
    public s(TbPageContext<SingleMentionActivity> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.a.b
    public Class<ae> ln() {
        return ae.class;
    }

    @Override // com.baidu.tbadk.mvc.a.b
    public int lo() {
        return 2001264;
    }

    @Override // com.baidu.tbadk.mvc.a.b
    public int lp() {
        return 2001264;
    }

    @Override // com.baidu.tbadk.mvc.a.b
    public String lq() {
        return "tb_user_replyme";
    }
}
