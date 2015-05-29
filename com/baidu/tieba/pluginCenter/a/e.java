package com.baidu.tieba.pluginCenter.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.q;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.mvc.j.a<String, com.baidu.tbadk.mvc.e.c> {
    private TextView aXI;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aXI = (TextView) view.findViewById(q.text);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: iJ */
    public void z(String str) {
        super.z(str);
        this.aXI.setText(str);
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        return true;
    }
}
