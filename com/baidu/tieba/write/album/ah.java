package com.baidu.tieba.write.album;

import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements x {
    final /* synthetic */ ac fVw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ac acVar) {
        this.fVw = acVar;
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
            albumActivity = this.fVw.fTN;
            d = albumActivity.d(imageFileInfo);
        } else {
            textView = this.fVw.fUT;
            albumActivity2 = this.fVw.fTN;
            textView.setText(albumActivity2.getResources().getText(w.l.next_step));
            albumActivity3 = this.fVw.fTN;
            d = albumActivity3.c(imageFileInfo);
            pVar = this.fVw.fTx;
            if (pVar.isOriginalImg()) {
                albumActivity4 = this.fVw.fTN;
                albumActivity4.bnu();
            }
        }
        this.fVw.bnX();
        return d;
    }
}
