package com.baidu.tieba.recommendfrs.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.mvc.j.a<Integer, com.baidu.tbadk.mvc.e.c> {
    private TextView aYD;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aYD = (TextView) view.findViewById(v.time);
        a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: e */
    public void A(Integer num) {
        super.A(num);
        if (num != null) {
            this.aYD.setText(com.baidu.tieba.recommendfrs.a.b.hQ(num.intValue()));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        return true;
    }
}
