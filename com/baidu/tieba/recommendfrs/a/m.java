package com.baidu.tieba.recommendfrs.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.q;
/* loaded from: classes.dex */
public class m extends com.baidu.tbadk.mvc.j.a<String, com.baidu.tbadk.mvc.e.c> {
    private TextView bbl;

    public m(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bbl = (TextView) view.findViewById(q.time);
        a(tbPageContext, TbadkCoreApplication.m411getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: iJ */
    public void z(String str) {
        super.z(str);
        if (str != null) {
            this.bbl.setText(str);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        return true;
    }
}
