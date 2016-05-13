package com.baidu.tieba.tbadkCore.c;

import com.baidu.tieba.tbadkCore.videoupload.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements a.InterfaceC0078a {
    int etI = 0;
    final /* synthetic */ a etJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.etJ = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.videoupload.a.a.InterfaceC0078a
    public void J(int i, int i2, int i3) {
        int i4;
        if (i2 > 0 && i >= 0 && (i4 = (int) (((i + (i3 / 100.0f)) / i2) * 90.0f)) != this.etI) {
            this.etI = i4;
            this.etJ.pp(i4);
        }
    }
}
