package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.u;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class t extends u {
    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.s, com.baidu.adp.widget.ListView.d
    public View mZ() {
        View mZ = super.mZ();
        this.agC.setVisibility(4);
        return mZ;
    }

    @Override // com.baidu.tbadk.core.view.u
    public void dj(int i) {
        super.dj(i);
        at.l(this.agB, t.d.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.view.u, com.baidu.tbadk.core.view.s, com.baidu.adp.widget.ListView.d
    public void N(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.s, com.baidu.adp.widget.ListView.d
    public void na() {
    }

    @Override // com.baidu.tbadk.core.view.u, com.baidu.tbadk.core.view.s, com.baidu.adp.widget.ListView.d
    public void nb() {
    }

    @Override // com.baidu.tbadk.core.view.u, com.baidu.tbadk.core.view.s, com.baidu.adp.widget.ListView.d
    public void O(boolean z) {
    }
}
