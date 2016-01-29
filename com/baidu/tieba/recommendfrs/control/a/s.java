package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class s extends com.baidu.tbadk.mvc.model.a<com.baidu.tieba.recommendfrs.data.n, BaseFragmentActivity> {
    public s(TbPageContext<BaseFragmentActivity> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public Class<com.baidu.tieba.recommendfrs.data.n> EP() {
        return com.baidu.tieba.recommendfrs.data.n.class;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public String EB() {
        return "RecommendGodCache";
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public int EQ() {
        return CmdConfigCustom.CMD_RECOMMEND_FRS_READ_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public int ER() {
        return CmdConfigCustom.CMD_RECOMMEND_FRS_WRITE_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    protected boolean EI() {
        return true;
    }
}
