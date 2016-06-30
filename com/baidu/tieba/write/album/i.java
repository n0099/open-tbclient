package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.album.h;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements h.b {
    final /* synthetic */ h.c fDa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h.c cVar) {
        this.fDa = cVar;
    }

    @Override // com.baidu.tieba.write.album.h.b
    public void dc(List<ImageFileInfo> list) {
        this.fDa.publishProgress(list);
    }
}
