package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ae;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class t extends ae {
    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.ab, com.baidu.adp.widget.ListView.d
    public View lf() {
        View lf = super.lf();
        this.alp.setVisibility(4);
        return lf;
    }

    @Override // com.baidu.tbadk.core.view.ae, com.baidu.tbadk.core.view.ab
    public void dk(int i) {
        super.dk(i);
        aq.k(this.alo, w.e.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.view.ae, com.baidu.tbadk.core.view.ab, com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.ab, com.baidu.adp.widget.ListView.d
    public void lg() {
    }

    @Override // com.baidu.tbadk.core.view.ae, com.baidu.tbadk.core.view.ab, com.baidu.adp.widget.ListView.d
    public void lh() {
    }

    @Override // com.baidu.tbadk.core.view.ae, com.baidu.tbadk.core.view.ab, com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
    }
}
