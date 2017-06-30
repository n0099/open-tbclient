package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.album.i;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements i.b {
    final /* synthetic */ i.c geU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i.c cVar) {
        this.geU = cVar;
    }

    @Override // com.baidu.tieba.write.album.i.b
    public void dc(List<ImageFileInfo> list) {
        this.geU.publishProgress(list);
    }
}
