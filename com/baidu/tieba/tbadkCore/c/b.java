package com.baidu.tieba.tbadkCore.c;

import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements e {
    int fCZ = 0;
    final /* synthetic */ a fDa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.fDa = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.e
    public void ad(float f) {
        int i = (int) (90.0f * f);
        if (i != this.fCZ) {
            this.fCZ = i;
            this.fDa.notifyUploadProgress(i);
        }
    }
}
