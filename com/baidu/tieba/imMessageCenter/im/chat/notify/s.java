package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.t;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class s extends t {
    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.r, com.baidu.adp.widget.ListView.d
    public View ni() {
        View ni = super.ni();
        this.ahb.setVisibility(4);
        return ni;
    }

    @Override // com.baidu.tbadk.core.view.t
    public void dg(int i) {
        super.dg(i);
        ar.l(this.aha, t.d.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.view.t, com.baidu.tbadk.core.view.r, com.baidu.adp.widget.ListView.d
    public void O(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.r, com.baidu.adp.widget.ListView.d
    public void nj() {
    }

    @Override // com.baidu.tbadk.core.view.t, com.baidu.tbadk.core.view.r, com.baidu.adp.widget.ListView.d
    public void nk() {
    }

    @Override // com.baidu.tbadk.core.view.t, com.baidu.tbadk.core.view.r, com.baidu.adp.widget.ListView.d
    public void P(boolean z) {
    }
}
