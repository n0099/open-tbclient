package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ah;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
public class t extends ah {
    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.ae, com.baidu.adp.widget.ListView.d
    public View le() {
        View le = super.le();
        this.alk.setVisibility(4);
        return le;
    }

    @Override // com.baidu.tbadk.core.view.ah, com.baidu.tbadk.core.view.ae
    public void di(int i) {
        super.di(i);
        aq.k(this.alj, w.e.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.view.ah, com.baidu.tbadk.core.view.ae, com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.ae, com.baidu.adp.widget.ListView.d
    public void lf() {
    }

    @Override // com.baidu.tbadk.core.view.ah, com.baidu.tbadk.core.view.ae, com.baidu.adp.widget.ListView.d
    public void lg() {
    }

    @Override // com.baidu.tbadk.core.view.ah, com.baidu.tbadk.core.view.ae, com.baidu.adp.widget.ListView.d
    public void T(boolean z) {
    }
}
