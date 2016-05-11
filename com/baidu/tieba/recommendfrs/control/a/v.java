package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class v extends com.baidu.tbadk.mvc.model.a<com.baidu.tieba.recommendfrs.data.r, BaseFragmentActivity> {
    public v(TbPageContext<BaseFragmentActivity> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public Class<com.baidu.tieba.recommendfrs.data.r> Du() {
        return com.baidu.tieba.recommendfrs.data.r.class;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public String Dg() {
        return "RecommendGodCache";
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public int Dv() {
        return CmdConfigCustom.CMD_RECOMMEND_FRS_READ_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    public int Dw() {
        return CmdConfigCustom.CMD_RECOMMEND_FRS_WRITE_CACHE;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    protected boolean Dn() {
        return true;
    }
}
