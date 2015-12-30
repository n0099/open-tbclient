package com.baidu.tieba.recommendfrs.control;

import com.baidu.tieba.recommendfrs.control.a.j;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.recommendfrs.b {
    final /* synthetic */ a doN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.doN = aVar;
    }

    @Override // com.baidu.tieba.recommendfrs.b
    public void J(int i, int i2, int i3) {
        j jVar;
        jVar = this.doN.doH;
        jVar.a(1, true, i, i2, 1, i3);
    }

    @Override // com.baidu.tieba.recommendfrs.b
    public void p(int i, int i2, int i3, int i4) {
        j jVar;
        jVar = this.doN.doH;
        jVar.a(2, false, i, i3, i2, i4);
    }

    @Override // com.baidu.tieba.recommendfrs.b
    public void bC(List<TagInfo> list) {
        this.doN.bE(list);
    }

    @Override // com.baidu.tieba.recommendfrs.b
    public void axU() {
        this.doN.au(this.doN.getView());
    }
}
