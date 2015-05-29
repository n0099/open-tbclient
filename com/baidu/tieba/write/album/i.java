package com.baidu.tieba.write.album;

import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements g {
    final /* synthetic */ h cyp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.cyp = hVar;
    }

    @Override // com.baidu.tieba.write.album.g
    public void bc(List<ImageFileInfo> list) {
        this.cyp.publishProgress(list);
    }
}
