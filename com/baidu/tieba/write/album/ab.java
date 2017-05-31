package com.baidu.tieba.write.album;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.w;
import com.baidu.tieba.write.album.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    private final /* synthetic */ int aaj;
    final /* synthetic */ y fUJ;
    private final /* synthetic */ y.a fUK;
    private final /* synthetic */ p fUM;
    private final /* synthetic */ ImageFileInfo fUN;
    private final /* synthetic */ y.b fUO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(y yVar, y.a aVar, p pVar, ImageFileInfo imageFileInfo, int i, y.b bVar) {
        this.fUJ = yVar;
        this.fUK = aVar;
        this.fUM = pVar;
        this.fUN = imageFileInfo;
        this.aaj = i;
        this.fUO = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x xVar;
        x xVar2;
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        xVar = this.fUJ.fUF;
        if (xVar != null && this.fUK.fUP) {
            boolean isAdded = this.fUM.isAdded(this.fUN);
            xVar2 = this.fUJ.fUF;
            if (xVar2.a(this.aaj, this.fUN, !isAdded)) {
                if (!isAdded) {
                    com.baidu.tbadk.core.util.aq.j(this.fUO.fHy, w.g.ic_post_image_selected_s);
                    ImageView imageView = this.fUO.fHy;
                    albumActivity2 = this.fUJ.fTN;
                    imageView.setContentDescription(albumActivity2.getResources().getString(w.l.check_box_checked));
                    return;
                }
                com.baidu.tbadk.core.util.aq.j(this.fUO.fHy, w.g.ic_post_image_selected_n);
                ImageView imageView2 = this.fUO.fHy;
                albumActivity = this.fUJ.fTN;
                imageView2.setContentDescription(albumActivity.getResources().getString(w.l.check_box_not_checked));
            }
        }
    }
}
