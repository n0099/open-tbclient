package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.album.i;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements i.b {
    final /* synthetic */ i.c fUk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i.c cVar) {
        this.fUk = cVar;
    }

    @Override // com.baidu.tieba.write.album.i.b
    public void cN(List<ImageFileInfo> list) {
        this.fUk.publishProgress(list);
    }
}
