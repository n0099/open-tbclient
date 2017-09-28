package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.annotation.SuppressLint;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class d extends h {
    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.g, com.baidu.adp.widget.ListView.c
    public View ld() {
        View ld = super.ld();
        this.amo.setVisibility(4);
        return ld;
    }

    @Override // com.baidu.tbadk.core.view.h, com.baidu.tbadk.core.view.g
    public void dz(int i) {
        super.dz(i);
        aj.k(this.amn, d.e.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.view.h, com.baidu.tbadk.core.view.g, com.baidu.adp.widget.ListView.c
    public void U(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.g, com.baidu.adp.widget.ListView.c
    public void le() {
    }

    @Override // com.baidu.tbadk.core.view.h, com.baidu.tbadk.core.view.g, com.baidu.adp.widget.ListView.c
    public void lf() {
    }

    @Override // com.baidu.tbadk.core.view.h, com.baidu.tbadk.core.view.g, com.baidu.adp.widget.ListView.c
    public void V(boolean z) {
    }
}
