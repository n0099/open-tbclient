package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.recommendfrs.data.g;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.model.a<g, BaseFragmentActivity> {
    public a(TbPageContext<BaseFragmentActivity> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public Class<g> CE() {
        return g.class;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public String Cq() {
        return "RecommendFrsCache";
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public int CF() {
        return CmdConfigCustom.CMD_RECOMMEND_FRS_READ_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public int CG() {
        return CmdConfigCustom.CMD_RECOMMEND_FRS_WRITE_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    protected boolean Cx() {
        return false;
    }
}
