package com.baidu.tieba.tbadkCore.c;

import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements e {
    int fqB = 0;
    final /* synthetic */ a fqC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.fqC = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.e
    public void ae(float f) {
        int i = (int) (90.0f * f);
        if (i != this.fqB) {
            this.fqB = i;
            this.fqC.notifyUploadProgress(i);
        }
    }
}
