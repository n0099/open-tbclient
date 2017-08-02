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
    public View la() {
        View la = super.la();
        this.ams.setVisibility(4);
        return la;
    }

    @Override // com.baidu.tbadk.core.view.l, com.baidu.tbadk.core.view.k
    public void dn(int i) {
        super.dn(i);
        ai.k(this.amr, d.e.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.view.l, com.baidu.tbadk.core.view.k, com.baidu.adp.widget.ListView.c
    public void S(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.k, com.baidu.adp.widget.ListView.c
    public void lb() {
    }

    @Override // com.baidu.tbadk.core.view.l, com.baidu.tbadk.core.view.k, com.baidu.adp.widget.ListView.c
    public void lc() {
    }

    @Override // com.baidu.tbadk.core.view.l, com.baidu.tbadk.core.view.k, com.baidu.adp.widget.ListView.c
    public void T(boolean z) {
    }
}
