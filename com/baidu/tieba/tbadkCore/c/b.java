package com.baidu.tieba.tbadkCore.c;

import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements e {
    int fhn = 0;
    final /* synthetic */ a fho;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.fho = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.e
    public void al(float f) {
        int i = (int) (90.0f * f);
        if (i != this.fhn) {
            this.fhn = i;
            this.fho.rj(i);
        }
    }
}
