package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.album.e;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements e.b {
    final /* synthetic */ e.c djL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e.c cVar) {
        this.djL = cVar;
    }

    @Override // com.baidu.tieba.write.album.e.b
    public void bD(List<ImageFileInfo> list) {
        this.djL.publishProgress(list);
    }
}
