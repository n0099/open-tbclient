package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.annotation.SuppressLint;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.l;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class d extends l {
    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.k, com.baidu.adp.widget.ListView.c
    public View lj() {
        View lj = super.lj();
        this.anM.setVisibility(4);
        return lj;
    }

    @Override // com.baidu.tbadk.core.view.l, com.baidu.tbadk.core.view.k
    public void dp(int i) {
        super.dp(i);
        ai.k(this.anL, d.e.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.view.l, com.baidu.tbadk.core.view.k, com.baidu.adp.widget.ListView.c
    public void S(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.k, com.baidu.adp.widget.ListView.c
    public void lk() {
    }

    @Override // com.baidu.tbadk.core.view.l, com.baidu.tbadk.core.view.k, com.baidu.adp.widget.ListView.c
    public void ll() {
    }

    @Override // com.baidu.tbadk.core.view.l, com.baidu.tbadk.core.view.k, com.baidu.adp.widget.ListView.c
    public void T(boolean z) {
    }
}
