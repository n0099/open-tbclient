package com.baidu.tieba.pluginCenter.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.mvc.g.a<String, com.baidu.tbadk.mvc.d.b> {
    private TextView cfp;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cfp = (TextView) view.findViewById(u.g.text);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: oQ */
    public void B(String str) {
        super.B(str);
        this.cfp.setText(str);
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.j.a.a(tbPageContext, getRootView());
        return true;
    }
}
