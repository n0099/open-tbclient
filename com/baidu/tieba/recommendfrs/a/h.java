package com.baidu.tieba.recommendfrs.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.mvc.j.a<Object, com.baidu.tbadk.mvc.e.c> {
    public h(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        return true;
    }
}
