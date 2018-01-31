package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.annotation.SuppressLint;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.k;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class d extends k {
    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.j, com.baidu.adp.widget.ListView.c
    public View sv() {
        View sv = super.sv();
        this.baY.setVisibility(4);
        return sv;
    }

    @Override // com.baidu.tbadk.core.view.k, com.baidu.tbadk.core.view.j
    public void gv(int i) {
        super.gv(i);
        aj.t(this.baX, d.C0108d.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.view.k, com.baidu.tbadk.core.view.j, com.baidu.adp.widget.ListView.c
    public void aA(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.j, com.baidu.adp.widget.ListView.c
    public void sw() {
    }

    @Override // com.baidu.tbadk.core.view.k, com.baidu.tbadk.core.view.j, com.baidu.adp.widget.ListView.c
    public void sx() {
    }

    @Override // com.baidu.tbadk.core.view.k, com.baidu.tbadk.core.view.j, com.baidu.adp.widget.ListView.c
    public void aB(boolean z) {
    }
}
