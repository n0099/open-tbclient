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
    public View st() {
        View st = super.st();
        this.bcG.setVisibility(4);
        return st;
    }

    @Override // com.baidu.tbadk.core.view.k, com.baidu.tbadk.core.view.j
    public void gx(int i) {
        super.gx(i);
        aj.t(this.bcF, d.C0141d.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.view.k, com.baidu.tbadk.core.view.j, com.baidu.adp.widget.ListView.c
    public void aD(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.j, com.baidu.adp.widget.ListView.c
    public void su() {
    }

    @Override // com.baidu.tbadk.core.view.k, com.baidu.tbadk.core.view.j, com.baidu.adp.widget.ListView.c
    public void sv() {
    }

    @Override // com.baidu.tbadk.core.view.k, com.baidu.tbadk.core.view.j, com.baidu.adp.widget.ListView.c
    public void aE(boolean z) {
    }
}
