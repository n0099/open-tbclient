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
    public View nn() {
        View nn = super.nn();
        this.afk.setVisibility(4);
        return nn;
    }

    @Override // com.baidu.tbadk.core.view.z
    public void cM(int i) {
        super.cM(i);
        al.i(this.afj, i.c.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.view.z, com.baidu.tbadk.core.view.x, com.baidu.adp.widget.ListView.d
    public void R(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.x, com.baidu.adp.widget.ListView.d
    public void no() {
    }

    @Override // com.baidu.tbadk.core.view.z, com.baidu.tbadk.core.view.x, com.baidu.adp.widget.ListView.d
    public void np() {
    }

    @Override // com.baidu.tbadk.core.view.z, com.baidu.tbadk.core.view.x, com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
    }
}
