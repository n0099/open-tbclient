package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.ac;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class t extends ac {
    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.z, com.baidu.adp.widget.ListView.d
    public View kk() {
        View kk = super.kk();
        this.agv.setVisibility(4);
        return kk;
    }

    @Override // com.baidu.tbadk.core.view.ac, com.baidu.tbadk.core.view.z
    public void dk(int i) {
        super.dk(i);
        ar.l(this.agu, r.d.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.view.ac, com.baidu.tbadk.core.view.z, com.baidu.adp.widget.ListView.d
    public void R(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.z, com.baidu.adp.widget.ListView.d
    public void kl() {
    }

    @Override // com.baidu.tbadk.core.view.ac, com.baidu.tbadk.core.view.z, com.baidu.adp.widget.ListView.d
    public void km() {
    }

    @Override // com.baidu.tbadk.core.view.ac, com.baidu.tbadk.core.view.z, com.baidu.adp.widget.ListView.d
    public void S(boolean z) {
    }
}
