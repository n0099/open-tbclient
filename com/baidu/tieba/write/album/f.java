package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.album.e;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements e.b {
    final /* synthetic */ e.c dkl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e.c cVar) {
        this.dkl = cVar;
    }

    @Override // com.baidu.tieba.write.album.e.b
    public void bE(List<ImageFileInfo> list) {
        this.dkl.publishProgress(list);
    }
}
