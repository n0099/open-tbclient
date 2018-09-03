package com.baidu.tieba.pluginCenter.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class b extends com.baidu.tbadk.mvc.f.a<String, com.baidu.tbadk.mvc.d.b> {
    private TextView text;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.text = (TextView) view.findViewById(f.g.text);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: so */
    public void G(String str) {
        super.G(str);
        this.text.setText(str);
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.o.a.a(tbPageContext, getRootView());
        return true;
    }
}
