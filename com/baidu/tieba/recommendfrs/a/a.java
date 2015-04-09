package com.baidu.tieba.recommendfrs.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.model.a<com.baidu.tieba.recommendfrs.data.c, BaseFragmentActivity> {
    public a(TbPageContext<BaseFragmentActivity> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.a.b
    public Class<com.baidu.tieba.recommendfrs.data.c> zU() {
        return com.baidu.tieba.recommendfrs.data.c.class;
    }

    @Override // com.baidu.tbadk.mvc.a.b
    public String zX() {
        return "RecommendFrsCache";
    }

    @Override // com.baidu.tbadk.mvc.a.b
    public int zV() {
        return 2001322;
    }

    @Override // com.baidu.tbadk.mvc.a.b
    public int zW() {
        return 2001323;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    protected boolean AP() {
        return false;
    }
}
