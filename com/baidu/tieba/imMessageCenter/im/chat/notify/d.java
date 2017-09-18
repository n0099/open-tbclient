package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.annotation.SuppressLint;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.l;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class d extends l {
    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.k, com.baidu.adp.widget.ListView.c
    public View lb() {
        View lb = super.lb();
        this.ane.setVisibility(4);
        return lb;
    }

    @Override // com.baidu.tbadk.core.view.l, com.baidu.tbadk.core.view.k
    public void dq(int i) {
        super.dq(i);
        aj.k(this.and, d.e.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.view.l, com.baidu.tbadk.core.view.k, com.baidu.adp.widget.ListView.c
    public void T(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.k, com.baidu.adp.widget.ListView.c
    public void lc() {
    }

    @Override // com.baidu.tbadk.core.view.l, com.baidu.tbadk.core.view.k, com.baidu.adp.widget.ListView.c
    public void ld() {
    }

    @Override // com.baidu.tbadk.core.view.l, com.baidu.tbadk.core.view.k, com.baidu.adp.widget.ListView.c
    public void U(boolean z) {
    }
}
