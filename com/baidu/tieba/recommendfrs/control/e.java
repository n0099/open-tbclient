package com.baidu.tieba.recommendfrs.control;

import java.util.List;
import tbclient.Personalized.TagInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.recommendfrs.c {
    final /* synthetic */ a dEd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.dEd = aVar;
    }

    @Override // com.baidu.tieba.recommendfrs.c
    public void I(int i, int i2, int i3) {
        com.baidu.tieba.recommendfrs.control.a.j jVar;
        jVar = this.dEd.dDW;
        jVar.a(1, true, i, i2, 1, i3);
    }

    @Override // com.baidu.tieba.recommendfrs.c
    public void o(int i, int i2, int i3, int i4) {
        com.baidu.tieba.recommendfrs.control.a.j jVar;
        jVar = this.dEd.dDW;
        jVar.a(2, false, i, i3, i2, i4);
    }

    @Override // com.baidu.tieba.recommendfrs.c
    public void bM(List<TagInfo> list) {
        this.dEd.bO(list);
    }

    @Override // com.baidu.tieba.recommendfrs.c
    public void aES() {
        this.dEd.aK(this.dEd.getView());
    }
}
