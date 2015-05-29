package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.al;
/* loaded from: classes.dex */
public class p extends al {
    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.ah, com.baidu.adp.widget.ListView.f
    public View ng() {
        View ng = super.ng();
        this.ZZ.setVisibility(4);
        return ng;
    }

    @Override // com.baidu.tbadk.core.view.al
    public void cy(int i) {
        super.cy(i);
        ay.j(this.ZY, com.baidu.tieba.n.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.view.al, com.baidu.tbadk.core.view.ah, com.baidu.adp.widget.ListView.f
    public void Q(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.ah, com.baidu.adp.widget.ListView.f
    public void nh() {
    }

    @Override // com.baidu.tbadk.core.view.al, com.baidu.tbadk.core.view.ah, com.baidu.adp.widget.ListView.f
    public void ni() {
    }

    @Override // com.baidu.tbadk.core.view.al, com.baidu.tbadk.core.view.ah, com.baidu.adp.widget.ListView.f
    public void R(boolean z) {
    }
}
