package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.model.a<com.baidu.tieba.recommendfrs.data.f, BaseFragmentActivity> {
    public a(TbPageContext<BaseFragmentActivity> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.mvc.a.b
    public Class<com.baidu.tieba.recommendfrs.data.f> AG() {
        return com.baidu.tieba.recommendfrs.data.f.class;
    }

    @Override // com.baidu.tbadk.mvc.a.b
    public String AJ() {
        return "RecommendFrsCache";
    }

    @Override // com.baidu.tbadk.mvc.a.b
    public int AH() {
        return 2001322;
    }

    @Override // com.baidu.tbadk.mvc.a.b
    public int AI() {
        return 2001323;
    }

    @Override // com.baidu.tbadk.mvc.model.a
    protected boolean BB() {
        return false;
    }
}
