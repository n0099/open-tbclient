package com.baidu.tieba.tbadkCore.c;

import com.baidu.tieba.tbadkCore.videoupload.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements a.InterfaceC0088a {
    int dXK = 0;
    final /* synthetic */ a dXL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.dXL = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.a.InterfaceC0088a
    public void K(int i, int i2, int i3) {
        int i4;
        if (i2 > 0 && i >= 0 && (i4 = (int) (((i + (i3 / 100.0f)) / i2) * 90.0f)) != this.dXK) {
            this.dXK = i4;
            this.dXL.ol(i4);
        }
    }
}
