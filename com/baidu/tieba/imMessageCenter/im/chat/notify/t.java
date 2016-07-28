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
    public View jp() {
        View jp = super.jp();
        this.adn.setVisibility(4);
        return jp;
    }

    @Override // com.baidu.tbadk.core.view.w, com.baidu.tbadk.core.view.t
    public void cT(int i) {
        super.cT(i);
        av.l(this.adm, u.d.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.view.w, com.baidu.tbadk.core.view.t, com.baidu.adp.widget.ListView.d
    public void P(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.t, com.baidu.adp.widget.ListView.d
    public void jq() {
    }

    @Override // com.baidu.tbadk.core.view.w, com.baidu.tbadk.core.view.t, com.baidu.adp.widget.ListView.d
    public void jr() {
    }

    @Override // com.baidu.tbadk.core.view.w, com.baidu.tbadk.core.view.t, com.baidu.adp.widget.ListView.d
    public void Q(boolean z) {
    }
}
