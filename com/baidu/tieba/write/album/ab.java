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
    final /* synthetic */ y gft;
    private final /* synthetic */ y.a gfu;
    private final /* synthetic */ p gfw;
    private final /* synthetic */ ImageFileInfo gfx;
    private final /* synthetic */ y.b gfy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(y yVar, y.a aVar, p pVar, ImageFileInfo imageFileInfo, int i, y.b bVar) {
        this.gft = yVar;
        this.gfu = aVar;
        this.gfw = pVar;
        this.gfx = imageFileInfo;
        this.aak = i;
        this.gfy = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x xVar;
        x xVar2;
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        xVar = this.gft.gfp;
        if (xVar != null && this.gfu.gfz) {
            boolean isAdded = this.gfw.isAdded(this.gfx);
            xVar2 = this.gft.gfp;
            if (xVar2.a(this.aak, this.gfx, !isAdded)) {
                if (!isAdded) {
                    com.baidu.tbadk.core.util.as.j(this.gfy.bVw, w.g.ic_post_image_selected_s);
                    ImageView imageView = this.gfy.bVw;
                    albumActivity2 = this.gft.gex;
                    imageView.setContentDescription(albumActivity2.getResources().getString(w.l.check_box_checked));
                    return;
                }
                com.baidu.tbadk.core.util.as.j(this.gfy.bVw, w.g.ic_post_image_selected_n);
                ImageView imageView2 = this.gfy.bVw;
                albumActivity = this.gft.gex;
                imageView2.setContentDescription(albumActivity.getResources().getString(w.l.check_box_not_checked));
            }
        }
    }
}
