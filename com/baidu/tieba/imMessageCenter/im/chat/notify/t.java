package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.w;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class t extends w {
    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.t, com.baidu.adp.widget.ListView.d
    public View jq() {
        View jq = super.jq();
        this.acC.setVisibility(4);
        return jq;
    }

    @Override // com.baidu.tbadk.core.view.w, com.baidu.tbadk.core.view.t
    public void cT(int i) {
        super.cT(i);
        av.l(this.acB, u.d.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.view.w, com.baidu.tbadk.core.view.t, com.baidu.adp.widget.ListView.d
    public void N(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.t, com.baidu.adp.widget.ListView.d
    public void jr() {
    }

    @Override // com.baidu.tbadk.core.view.w, com.baidu.tbadk.core.view.t, com.baidu.adp.widget.ListView.d
    public void js() {
    }

    @Override // com.baidu.tbadk.core.view.w, com.baidu.tbadk.core.view.t, com.baidu.adp.widget.ListView.d
    public void O(boolean z) {
    }
}
