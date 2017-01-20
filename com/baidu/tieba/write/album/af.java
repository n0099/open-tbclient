package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.r;
import com.baidu.tieba.write.album.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    private final /* synthetic */ int Vn;
    final /* synthetic */ ab fHY;
    private final /* synthetic */ ab.a fHZ;
    private final /* synthetic */ ImageFileInfo fIa;
    private final /* synthetic */ o fIb;
    private final /* synthetic */ ab.b fIc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ab abVar, ab.a aVar, o oVar, ImageFileInfo imageFileInfo, int i, ab.b bVar) {
        this.fHY = abVar;
        this.fHZ = aVar;
        this.fIb = oVar;
        this.fIa = imageFileInfo;
        this.Vn = i;
        this.fIc = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aa aaVar;
        aa aaVar2;
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        aaVar = this.fHY.fHX;
        if (aaVar != null && this.fHZ.fId) {
            boolean isAdded = this.fIb.isAdded(this.fIa);
            aaVar2 = this.fHY.fHX;
            if (aaVar2.a(this.Vn, this.fIa, !isAdded)) {
                if (!isAdded) {
                    com.baidu.tbadk.core.util.ap.j(this.fIc.fuD, r.g.chx_camera_pic_s);
                    albumActivity2 = this.fHY.fGS;
                    this.fIc.fuD.startAnimation(AnimationUtils.loadAnimation(albumActivity2.getPageContext().getPageActivity(), r.a.album_choose_icon));
                    ImageView imageView = this.fIc.fuD;
                    albumActivity3 = this.fHY.fGS;
                    imageView.setContentDescription(albumActivity3.getResources().getString(r.l.check_box_checked));
                    return;
                }
                com.baidu.tbadk.core.util.ap.j(this.fIc.fuD, r.g.chx_camera_pic_n);
                ImageView imageView2 = this.fIc.fuD;
                albumActivity = this.fHY.fGS;
                imageView2.setContentDescription(albumActivity.getResources().getString(r.l.check_box_not_checked));
            }
        }
    }
}
