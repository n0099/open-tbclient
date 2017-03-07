package com.baidu.tieba.tbadkCore.c;

import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements e {
    int fuZ = 0;
    final /* synthetic */ a fva;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.fva = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.e
    public void ac(float f) {
        int i = (int) (90.0f * f);
        if (i != this.fuZ) {
            this.fuZ = i;
            this.fva.notifyUploadProgress(i);
        }
    }
}
