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
    public View la() {
        View la = super.la();
        this.akZ.setVisibility(4);
        return la;
    }

    @Override // com.baidu.tbadk.core.view.ae, com.baidu.tbadk.core.view.ab
    public void dh(int i) {
        super.dh(i);
        aq.k(this.akY, w.e.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.view.ae, com.baidu.tbadk.core.view.ab, com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.ab, com.baidu.adp.widget.ListView.d
    public void lb() {
    }

    @Override // com.baidu.tbadk.core.view.ae, com.baidu.tbadk.core.view.ab, com.baidu.adp.widget.ListView.d
    public void lc() {
    }

    @Override // com.baidu.tbadk.core.view.ae, com.baidu.tbadk.core.view.ab, com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
    }
}
