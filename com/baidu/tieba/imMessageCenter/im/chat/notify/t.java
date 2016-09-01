package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.w;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class t extends w {
    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.t, com.baidu.adp.widget.ListView.d
    public View kk() {
        View kk = super.kk();
        this.agc.setVisibility(4);
        return kk;
    }

    @Override // com.baidu.tbadk.core.view.w, com.baidu.tbadk.core.view.t
    public void dh(int i) {
        super.dh(i);
        av.l(this.agb, t.d.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.view.w, com.baidu.tbadk.core.view.t, com.baidu.adp.widget.ListView.d
    public void R(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.t, com.baidu.adp.widget.ListView.d
    public void kl() {
    }

    @Override // com.baidu.tbadk.core.view.w, com.baidu.tbadk.core.view.t, com.baidu.adp.widget.ListView.d
    public void km() {
    }

    @Override // com.baidu.tbadk.core.view.w, com.baidu.tbadk.core.view.t, com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
    }
}
