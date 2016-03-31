package com.baidu.tieba.recommendfrs.control;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.recommendfrs.control.a.m;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.recommendfrs.c {
    final /* synthetic */ a dVV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.dVV = aVar;
    }

    @Override // com.baidu.tieba.recommendfrs.c
    public void I(int i, int i2, int i3) {
        m mVar;
        mVar = this.dVV.dVN;
        mVar.a(1, true, i, i2, 1, i3);
        if (com.baidu.adp.lib.util.i.iT()) {
            TiebaStatic.log(new aw("c11032").r("obj_source", 1));
        }
    }

    @Override // com.baidu.tieba.recommendfrs.c
    public void o(int i, int i2, int i3, int i4) {
        m mVar;
        mVar = this.dVV.dVN;
        mVar.a(2, false, i, i3, i2, i4);
        if (com.baidu.adp.lib.util.i.iT()) {
            TiebaStatic.log(new aw("c11032").r("obj_source", 2));
        }
    }

    @Override // com.baidu.tieba.recommendfrs.c
    public void cf(List<TagInfo> list) {
        this.dVV.bu(list);
    }

    @Override // com.baidu.tieba.recommendfrs.c
    public void anz() {
        this.dVV.aD(this.dVV.getView());
    }
}
