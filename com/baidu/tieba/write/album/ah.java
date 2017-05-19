package com.baidu.tieba.write.album;

import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements x {
    final /* synthetic */ ac fNP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ac acVar) {
        this.fNP = acVar;
    }

    @Override // com.baidu.tieba.write.album.x
    public boolean a(int i, ImageFileInfo imageFileInfo, boolean z) {
        AlbumActivity albumActivity;
        boolean d;
        TextView textView;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        p pVar;
        AlbumActivity albumActivity4;
        if (!z) {
            albumActivity = this.fNP.fMg;
            d = albumActivity.d(imageFileInfo);
        } else {
            textView = this.fNP.fNm;
            albumActivity2 = this.fNP.fMg;
            textView.setText(albumActivity2.getResources().getText(w.l.next_step));
            albumActivity3 = this.fNP.fMg;
            d = albumActivity3.c(imageFileInfo);
            pVar = this.fNP.fLQ;
            if (pVar.isOriginalImg()) {
                albumActivity4 = this.fNP.fMg;
                albumActivity4.blX();
            }
        }
        this.fNP.bmA();
        return d;
    }
}
