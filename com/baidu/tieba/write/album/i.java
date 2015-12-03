package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.album.h;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements h.b {
    final /* synthetic */ h.c dKZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h.c cVar) {
        this.dKZ = cVar;
    }

    @Override // com.baidu.tieba.write.album.h.b
    public void bW(List<ImageFileInfo> list) {
        this.dKZ.publishProgress(list);
    }
}
