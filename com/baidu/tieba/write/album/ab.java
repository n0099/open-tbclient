package com.baidu.tieba.write.album;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.w;
import com.baidu.tieba.write.album.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    private final /* synthetic */ int aak;
    final /* synthetic */ y fNc;
    private final /* synthetic */ y.a fNd;
    private final /* synthetic */ p fNf;
    private final /* synthetic */ ImageFileInfo fNg;
    private final /* synthetic */ y.b fNh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(y yVar, y.a aVar, p pVar, ImageFileInfo imageFileInfo, int i, y.b bVar) {
        this.fNc = yVar;
        this.fNd = aVar;
        this.fNf = pVar;
        this.fNg = imageFileInfo;
        this.aak = i;
        this.fNh = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x xVar;
        x xVar2;
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        xVar = this.fNc.fMY;
        if (xVar != null && this.fNd.fNi) {
            boolean isAdded = this.fNf.isAdded(this.fNg);
            xVar2 = this.fNc.fMY;
            if (xVar2.a(this.aak, this.fNg, !isAdded)) {
                if (!isAdded) {
                    com.baidu.tbadk.core.util.aq.j(this.fNh.fzD, w.g.ic_post_image_selected_s);
                    ImageView imageView = this.fNh.fzD;
                    albumActivity2 = this.fNc.fMg;
                    imageView.setContentDescription(albumActivity2.getResources().getString(w.l.check_box_checked));
                    return;
                }
                com.baidu.tbadk.core.util.aq.j(this.fNh.fzD, w.g.ic_post_image_selected_n);
                ImageView imageView2 = this.fNh.fzD;
                albumActivity = this.fNc.fMg;
                imageView2.setContentDescription(albumActivity.getResources().getString(w.l.check_box_not_checked));
            }
        }
    }
}
