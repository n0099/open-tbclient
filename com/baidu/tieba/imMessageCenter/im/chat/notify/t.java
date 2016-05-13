package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.w;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class t extends w {
    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tbadk.core.view.t, com.baidu.adp.widget.ListView.d
    public View jn() {
        View jn = super.jn();
        this.aci.setVisibility(4);
        return jn;
    }

    @Override // com.baidu.tbadk.core.view.w, com.baidu.tbadk.core.view.t
    public void cR(int i) {
        super.cR(i);
        at.l(this.ach, t.d.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.view.w, com.baidu.tbadk.core.view.t, com.baidu.adp.widget.ListView.d
    public void N(boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.t, com.baidu.adp.widget.ListView.d
    public void jo() {
    }

    @Override // com.baidu.tbadk.core.view.w, com.baidu.tbadk.core.view.t, com.baidu.adp.widget.ListView.d
    public void jp() {
    }

    @Override // com.baidu.tbadk.core.view.w, com.baidu.tbadk.core.view.t, com.baidu.adp.widget.ListView.d
    public void O(boolean z) {
    }
}
