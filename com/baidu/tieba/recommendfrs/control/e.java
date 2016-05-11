package com.baidu.tieba.recommendfrs.control;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.recommendfrs.c {
    final /* synthetic */ a dYW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.dYW = aVar;
    }

    @Override // com.baidu.tieba.recommendfrs.c
    public void H(int i, int i2, int i3) {
        com.baidu.tieba.recommendfrs.control.a.m mVar;
        mVar = this.dYW.dYO;
        mVar.a(1, true, i, i2, 1, i3);
        if (com.baidu.adp.lib.util.i.fe()) {
            TiebaStatic.log(new aw("c11032").s("obj_source", 1));
        }
    }

    @Override // com.baidu.tieba.recommendfrs.c
    public void p(int i, int i2, int i3, int i4) {
        com.baidu.tieba.recommendfrs.control.a.m mVar;
        mVar = this.dYW.dYO;
        mVar.a(2, false, i, i3, i2, i4);
        if (com.baidu.adp.lib.util.i.fe()) {
            TiebaStatic.log(new aw("c11032").s("obj_source", 2));
        }
    }

    @Override // com.baidu.tieba.recommendfrs.c
    public void ch(List<TagInfo> list) {
        this.dYW.bu(list);
    }

    @Override // com.baidu.tieba.recommendfrs.c
    public void anv() {
        this.dYW.aMj();
    }
}
