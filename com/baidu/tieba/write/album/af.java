package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.u;
import com.baidu.tieba.write.album.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    private final /* synthetic */ int Tf;
    final /* synthetic */ ab fQZ;
    private final /* synthetic */ ab.a fRa;
    private final /* synthetic */ ImageFileInfo fRb;
    private final /* synthetic */ o fRc;
    private final /* synthetic */ ab.b fRd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ab abVar, ab.a aVar, o oVar, ImageFileInfo imageFileInfo, int i, ab.b bVar) {
        this.fQZ = abVar;
        this.fRa = aVar;
        this.fRc = oVar;
        this.fRb = imageFileInfo;
        this.Tf = i;
        this.fRd = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aa aaVar;
        aa aaVar2;
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        aaVar = this.fQZ.fQY;
        if (aaVar != null && this.fRa.fRe) {
            boolean isAdded = this.fRc.isAdded(this.fRb);
            aaVar2 = this.fQZ.fQY;
            if (aaVar2.a(this.Tf, this.fRb, !isAdded)) {
                if (!isAdded) {
                    av.k(this.fRd.fpu, u.f.chx_camera_pic_s);
                    albumActivity2 = this.fQZ.fQb;
                    this.fRd.fpu.startAnimation(AnimationUtils.loadAnimation(albumActivity2.getPageContext().getPageActivity(), u.a.album_choose_icon));
                    ImageView imageView = this.fRd.fpu;
                    albumActivity3 = this.fQZ.fQb;
                    imageView.setContentDescription(albumActivity3.getResources().getString(u.j.check_box_checked));
                    return;
                }
                av.k(this.fRd.fpu, u.f.chx_camera_pic_n);
                ImageView imageView2 = this.fRd.fpu;
                albumActivity = this.fQZ.fQb;
                imageView2.setContentDescription(albumActivity.getResources().getString(u.j.check_box_not_checked));
            }
        }
    }
}
