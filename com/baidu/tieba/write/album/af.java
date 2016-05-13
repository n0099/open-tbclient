package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.t;
import com.baidu.tieba.write.album.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    private final /* synthetic */ int Sg;
    final /* synthetic */ ab eYI;
    private final /* synthetic */ ab.a eYJ;
    private final /* synthetic */ ImageFileInfo eYK;
    private final /* synthetic */ o eYL;
    private final /* synthetic */ ab.b eYM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ab abVar, ab.a aVar, o oVar, ImageFileInfo imageFileInfo, int i, ab.b bVar) {
        this.eYI = abVar;
        this.eYJ = aVar;
        this.eYL = oVar;
        this.eYK = imageFileInfo;
        this.Sg = i;
        this.eYM = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aa aaVar;
        aa aaVar2;
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        aaVar = this.eYI.eYH;
        if (aaVar != null && this.eYJ.eYN) {
            boolean isAdded = this.eYL.isAdded(this.eYK);
            aaVar2 = this.eYI.eYH;
            if (aaVar2.a(this.Sg, this.eYK, !isAdded)) {
                if (!isAdded) {
                    at.k(this.eYM.exF, t.f.chx_camera_pic_s);
                    albumActivity2 = this.eYI.eXL;
                    this.eYM.exF.startAnimation(AnimationUtils.loadAnimation(albumActivity2.getPageContext().getPageActivity(), t.a.album_choose_icon));
                    ImageView imageView = this.eYM.exF;
                    albumActivity3 = this.eYI.eXL;
                    imageView.setContentDescription(albumActivity3.getResources().getString(t.j.check_box_checked));
                    return;
                }
                at.k(this.eYM.exF, t.f.chx_camera_pic_n);
                ImageView imageView2 = this.eYM.exF;
                albumActivity = this.eYI.eXL;
                imageView2.setContentDescription(albumActivity.getResources().getString(t.j.check_box_not_checked));
            }
        }
    }
}
