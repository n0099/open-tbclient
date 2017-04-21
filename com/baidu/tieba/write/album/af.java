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
    private final /* synthetic */ int aaP;
    private final /* synthetic */ o fQA;
    private final /* synthetic */ ab.b fQB;
    final /* synthetic */ ab fQx;
    private final /* synthetic */ ab.a fQy;
    private final /* synthetic */ ImageFileInfo fQz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ab abVar, ab.a aVar, o oVar, ImageFileInfo imageFileInfo, int i, ab.b bVar) {
        this.fQx = abVar;
        this.fQy = aVar;
        this.fQA = oVar;
        this.fQz = imageFileInfo;
        this.aaP = i;
        this.fQB = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aa aaVar;
        aa aaVar2;
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        aaVar = this.fQx.fQw;
        if (aaVar != null && this.fQy.fQC) {
            boolean isAdded = this.fQA.isAdded(this.fQz);
            aaVar2 = this.fQx.fQw;
            if (aaVar2.a(this.aaP, this.fQz, !isAdded)) {
                if (!isAdded) {
                    aq.j(this.fQB.fDb, w.g.chx_camera_pic_s);
                    albumActivity2 = this.fQx.fPr;
                    this.fQB.fDb.startAnimation(AnimationUtils.loadAnimation(albumActivity2.getPageContext().getPageActivity(), w.a.album_choose_icon));
                    ImageView imageView = this.fQB.fDb;
                    albumActivity3 = this.fQx.fPr;
                    imageView.setContentDescription(albumActivity3.getResources().getString(w.l.check_box_checked));
                    return;
                }
                aq.j(this.fQB.fDb, w.g.chx_camera_pic_n);
                ImageView imageView2 = this.fQB.fDb;
                albumActivity = this.fQx.fPr;
                imageView2.setContentDescription(albumActivity.getResources().getString(w.l.check_box_not_checked));
            }
        }
    }
}
