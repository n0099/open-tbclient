package com.baidu.tieba.pluginCenter.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.mvc.f.a<String, com.baidu.tbadk.mvc.d.b> {
    private TextView cjI;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cjI = (TextView) view.findViewById(w.h.text);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: oW */
    public void E(String str) {
        super.E(str);
        this.cjI.setText(str);
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.m.a.a(tbPageContext, getRootView());
        return true;
    }
}
