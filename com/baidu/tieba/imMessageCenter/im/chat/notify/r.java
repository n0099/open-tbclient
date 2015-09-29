package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class r extends com.baidu.tbadk.core.view.r {
    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.p, com.baidu.adp.widget.ListView.d
    public View no() {
        View no = super.no();
        this.aex.setVisibility(4);
        return no;
    }

    @Override // com.baidu.tbadk.core.view.r
    public void cN(int i) {
        super.cN(i);
        am.j(this.aew, i.c.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.view.r, com.baidu.tbadk.core.view.p, com.baidu.adp.widget.ListView.d
    public void R(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.p, com.baidu.adp.widget.ListView.d
    public void np() {
    }

    @Override // com.baidu.tbadk.core.view.r, com.baidu.tbadk.core.view.p, com.baidu.adp.widget.ListView.d
    public void nq() {
    }

    @Override // com.baidu.tbadk.core.view.r, com.baidu.tbadk.core.view.p, com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
    }
}
