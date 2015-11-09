package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class r extends com.baidu.tbadk.core.view.r {
    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.p, com.baidu.adp.widget.ListView.d
    public View np() {
        View np = super.np();
        this.aeD.setVisibility(4);
        return np;
    }

    @Override // com.baidu.tbadk.core.view.r
    public void cN(int i) {
        super.cN(i);
        an.j(this.aeC, i.c.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.view.r, com.baidu.tbadk.core.view.p, com.baidu.adp.widget.ListView.d
    public void R(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.p, com.baidu.adp.widget.ListView.d
    public void nq() {
    }

    @Override // com.baidu.tbadk.core.view.r, com.baidu.tbadk.core.view.p, com.baidu.adp.widget.ListView.d
    public void nr() {
    }

    @Override // com.baidu.tbadk.core.view.r, com.baidu.tbadk.core.view.p, com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
    }
}
