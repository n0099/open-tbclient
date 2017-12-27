package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.annotation.SuppressLint;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class d extends j {
    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.i, com.baidu.adp.widget.ListView.c
    public View su() {
        View su = super.su();
        this.baR.setVisibility(4);
        return su;
    }

    @Override // com.baidu.tbadk.core.view.j, com.baidu.tbadk.core.view.i
    public void gy(int i) {
        super.gy(i);
        aj.t(this.baQ, d.C0108d.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.view.j, com.baidu.tbadk.core.view.i, com.baidu.adp.widget.ListView.c
    public void az(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.i, com.baidu.adp.widget.ListView.c
    public void sv() {
    }

    @Override // com.baidu.tbadk.core.view.j, com.baidu.tbadk.core.view.i, com.baidu.adp.widget.ListView.c
    public void sw() {
    }

    @Override // com.baidu.tbadk.core.view.j, com.baidu.tbadk.core.view.i, com.baidu.adp.widget.ListView.c
    public void aA(boolean z) {
    }
}
