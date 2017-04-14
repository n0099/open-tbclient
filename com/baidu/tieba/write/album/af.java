package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.w;
import com.baidu.tieba.write.album.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    private final /* synthetic */ int aaO;
    final /* synthetic */ ab fOb;
    private final /* synthetic */ ab.a fOc;
    private final /* synthetic */ ImageFileInfo fOd;
    private final /* synthetic */ o fOe;
    private final /* synthetic */ ab.b fOf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ab abVar, ab.a aVar, o oVar, ImageFileInfo imageFileInfo, int i, ab.b bVar) {
        this.fOb = abVar;
        this.fOc = aVar;
        this.fOe = oVar;
        this.fOd = imageFileInfo;
        this.aaO = i;
        this.fOf = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aa aaVar;
        aa aaVar2;
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        aaVar = this.fOb.fOa;
        if (aaVar != null && this.fOc.fOg) {
            boolean isAdded = this.fOe.isAdded(this.fOd);
            aaVar2 = this.fOb.fOa;
            if (aaVar2.a(this.aaO, this.fOd, !isAdded)) {
                if (!isAdded) {
                    aq.j(this.fOf.fAL, w.g.chx_camera_pic_s);
                    albumActivity2 = this.fOb.fMV;
                    this.fOf.fAL.startAnimation(AnimationUtils.loadAnimation(albumActivity2.getPageContext().getPageActivity(), w.a.album_choose_icon));
                    ImageView imageView = this.fOf.fAL;
                    albumActivity3 = this.fOb.fMV;
                    imageView.setContentDescription(albumActivity3.getResources().getString(w.l.check_box_checked));
                    return;
                }
                aq.j(this.fOf.fAL, w.g.chx_camera_pic_n);
                ImageView imageView2 = this.fOf.fAL;
                albumActivity = this.fOb.fMV;
                imageView2.setContentDescription(albumActivity.getResources().getString(w.l.check_box_not_checked));
            }
        }
    }
}
