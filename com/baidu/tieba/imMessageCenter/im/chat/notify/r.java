package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.z;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class r extends z {
    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.x, com.baidu.adp.widget.ListView.d
    public View nq() {
        View nq = super.nq();
        this.afa.setVisibility(4);
        return nq;
    }

    @Override // com.baidu.tbadk.core.view.z
    public void cG(int i) {
        super.cG(i);
        al.j(this.aeZ, i.c.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.view.z, com.baidu.tbadk.core.view.x, com.baidu.adp.widget.ListView.d
    public void R(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.x, com.baidu.adp.widget.ListView.d
    public void nr() {
    }

    @Override // com.baidu.tbadk.core.view.z, com.baidu.tbadk.core.view.x, com.baidu.adp.widget.ListView.d
    public void ns() {
    }

    @Override // com.baidu.tbadk.core.view.z, com.baidu.tbadk.core.view.x, com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
    }
}
