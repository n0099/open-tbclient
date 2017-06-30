package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.ah;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
public class t extends ah {
    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.ae, com.baidu.adp.widget.ListView.d
    public View lc() {
        View lc = super.lc();
        this.alO.setVisibility(4);
        return lc;
    }

    @Override // com.baidu.tbadk.core.view.ah, com.baidu.tbadk.core.view.ae
    public void dl(int i) {
        super.dl(i);
        as.k(this.alN, w.e.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.view.ah, com.baidu.tbadk.core.view.ae, com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.ae, com.baidu.adp.widget.ListView.d
    public void ld() {
    }

    @Override // com.baidu.tbadk.core.view.ah, com.baidu.tbadk.core.view.ae, com.baidu.adp.widget.ListView.d
    public void le() {
    }

    @Override // com.baidu.tbadk.core.view.ah, com.baidu.tbadk.core.view.ae, com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
    }
}
