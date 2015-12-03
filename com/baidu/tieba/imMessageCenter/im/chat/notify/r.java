package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.s;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class r extends s {
    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.q, com.baidu.adp.widget.ListView.d
    public View nv() {
        View nv = super.nv();
        this.afA.setVisibility(4);
        return nv;
    }

    @Override // com.baidu.tbadk.core.view.s
    public void cV(int i) {
        super.cV(i);
        as.j(this.afz, n.c.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.view.s, com.baidu.tbadk.core.view.q, com.baidu.adp.widget.ListView.d
    public void R(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.q, com.baidu.adp.widget.ListView.d
    public void nw() {
    }

    @Override // com.baidu.tbadk.core.view.s, com.baidu.tbadk.core.view.q, com.baidu.adp.widget.ListView.d
    public void nx() {
    }

    @Override // com.baidu.tbadk.core.view.s, com.baidu.tbadk.core.view.q, com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
    }
}
