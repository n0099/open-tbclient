package com.baidu.tieba.pluginCenter.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b extends com.baidu.tbadk.mvc.f.a<String, com.baidu.tbadk.mvc.d.b> {
    private TextView Yu;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.Yu = (TextView) view.findViewById(R.id.text);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: BZ */
    public void ab(String str) {
        super.ab(str);
        this.Yu.setText(str);
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.s.a.a(tbPageContext, getRootView());
        return true;
    }
}
