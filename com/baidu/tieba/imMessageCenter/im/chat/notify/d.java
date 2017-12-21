package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.annotation.SuppressLint;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.i;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class d extends i {
    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.h, com.baidu.adp.widget.ListView.c
    public View kX() {
        View kX = super.kX();
        this.amT.setVisibility(4);
        return kX;
    }

    @Override // com.baidu.tbadk.core.view.i, com.baidu.tbadk.core.view.h
    public void dz(int i) {
        super.dz(i);
        aj.k(this.amS, d.C0095d.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.view.i, com.baidu.tbadk.core.view.h, com.baidu.adp.widget.ListView.c
    public void T(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.h, com.baidu.adp.widget.ListView.c
    public void kY() {
    }

    @Override // com.baidu.tbadk.core.view.i, com.baidu.tbadk.core.view.h, com.baidu.adp.widget.ListView.c
    public void kZ() {
    }

    @Override // com.baidu.tbadk.core.view.i, com.baidu.tbadk.core.view.h, com.baidu.adp.widget.ListView.c
    public void U(boolean z) {
    }
}
