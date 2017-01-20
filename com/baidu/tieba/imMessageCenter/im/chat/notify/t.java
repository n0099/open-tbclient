package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ad;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class t extends ad {
    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.aa, com.baidu.adp.widget.ListView.d
    public View kg() {
        View kg = super.kg();
        this.afH.setVisibility(4);
        return kg;
    }

    @Override // com.baidu.tbadk.core.view.ad, com.baidu.tbadk.core.view.aa
    public void dl(int i) {
        super.dl(i);
        ap.k(this.afG, r.e.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.view.ad, com.baidu.tbadk.core.view.aa, com.baidu.adp.widget.ListView.d
    public void R(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.aa, com.baidu.adp.widget.ListView.d
    public void kh() {
    }

    @Override // com.baidu.tbadk.core.view.ad, com.baidu.tbadk.core.view.aa, com.baidu.adp.widget.ListView.d
    public void ki() {
    }

    @Override // com.baidu.tbadk.core.view.ad, com.baidu.tbadk.core.view.aa, com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
    }
}
