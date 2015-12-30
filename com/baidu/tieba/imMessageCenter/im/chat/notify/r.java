package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.t;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class r extends t {
    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.r, com.baidu.adp.widget.ListView.d
    public View mT() {
        View mT = super.mT();
        this.agn.setVisibility(4);
        return mT;
    }

    @Override // com.baidu.tbadk.core.view.t
    public void cP(int i) {
        super.cP(i);
        as.j(this.agm, n.d.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.view.t, com.baidu.tbadk.core.view.r, com.baidu.adp.widget.ListView.d
    public void O(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.r, com.baidu.adp.widget.ListView.d
    public void mU() {
    }

    @Override // com.baidu.tbadk.core.view.t, com.baidu.tbadk.core.view.r, com.baidu.adp.widget.ListView.d
    public void mV() {
    }

    @Override // com.baidu.tbadk.core.view.t, com.baidu.tbadk.core.view.r, com.baidu.adp.widget.ListView.d
    public void P(boolean z) {
    }
}
