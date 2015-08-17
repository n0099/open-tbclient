package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.write.album.f;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements f.b {
    final /* synthetic */ f.c cQf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f.c cVar) {
        this.cQf = cVar;
    }

    @Override // com.baidu.tieba.write.album.f.b
    public void bl(List<ImageFileInfo> list) {
        this.cQf.publishProgress(list);
    }
}
