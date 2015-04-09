package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.ag;
import com.baidu.tieba.s;
/* loaded from: classes.dex */
public class o extends ag {
    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.ac, com.baidu.adp.widget.ListView.f
    public View mN() {
        View mN = super.mN();
        this.YY.setVisibility(4);
        return mN;
    }

    @Override // com.baidu.tbadk.core.view.ag
    public void ct(int i) {
        super.ct(i);
        ba.j(this.YX, s.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.view.ag, com.baidu.tbadk.core.view.ac, com.baidu.adp.widget.ListView.f
    public void O(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.ac, com.baidu.adp.widget.ListView.f
    public void mO() {
    }

    @Override // com.baidu.tbadk.core.view.ag, com.baidu.tbadk.core.view.ac, com.baidu.adp.widget.ListView.f
    public void mP() {
    }

    @Override // com.baidu.tbadk.core.view.ag, com.baidu.tbadk.core.view.ac, com.baidu.adp.widget.ListView.f
    public void P(boolean z) {
    }
}
