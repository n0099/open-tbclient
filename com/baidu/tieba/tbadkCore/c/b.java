package com.baidu.tieba.tbadkCore.c;

import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements e {
    int fDj = 0;
    final /* synthetic */ a fDk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.fDk = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.e
    public void as(float f) {
        int i = (int) (90.0f * f);
        if (i != this.fDj) {
            this.fDj = i;
            this.fDk.sg(i);
        }
    }
}
