package com.baidu.tieba.write.album;

import android.widget.TextView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements x {
    final /* synthetic */ ac ggh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ac acVar) {
        this.ggh = acVar;
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
            albumActivity = this.ggh.gex;
            d = albumActivity.d(imageFileInfo);
        } else {
            textView = this.ggh.gfE;
            albumActivity2 = this.ggh.gex;
            textView.setText(albumActivity2.getResources().getText(w.l.next_step));
            albumActivity3 = this.ggh.gex;
            d = albumActivity3.c(imageFileInfo);
            pVar = this.ggh.gei;
            if (pVar.isOriginalImg()) {
                albumActivity4 = this.ggh.gex;
                albumActivity4.brR();
            }
        }
        this.ggh.bsu();
        return d;
    }
}
