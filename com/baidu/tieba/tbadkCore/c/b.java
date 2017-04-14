package com.baidu.tieba.tbadkCore.c;

import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements e {
    int fwI = 0;
    final /* synthetic */ a fwJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.fwJ = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.e
    public void ad(float f) {
        int i = (int) (90.0f * f);
        if (i != this.fwI) {
            this.fwI = i;
            this.fwJ.notifyUploadProgress(i);
        }
    }
}
