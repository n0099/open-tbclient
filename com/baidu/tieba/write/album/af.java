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
    final /* synthetic */ ab eYJ;
    private final /* synthetic */ ab.a eYK;
    private final /* synthetic */ ImageFileInfo eYL;
    private final /* synthetic */ o eYM;
    private final /* synthetic */ ab.b eYN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ab abVar, ab.a aVar, o oVar, ImageFileInfo imageFileInfo, int i, ab.b bVar) {
        this.eYJ = abVar;
        this.eYK = aVar;
        this.eYM = oVar;
        this.eYL = imageFileInfo;
        this.Sg = i;
        this.eYN = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aa aaVar;
        aa aaVar2;
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        aaVar = this.eYJ.eYI;
        if (aaVar != null && this.eYK.eYO) {
            boolean isAdded = this.eYM.isAdded(this.eYL);
            aaVar2 = this.eYJ.eYI;
            if (aaVar2.a(this.Sg, this.eYL, !isAdded)) {
                if (!isAdded) {
                    at.k(this.eYN.exG, t.f.chx_camera_pic_s);
                    albumActivity2 = this.eYJ.eXM;
                    this.eYN.exG.startAnimation(AnimationUtils.loadAnimation(albumActivity2.getPageContext().getPageActivity(), t.a.album_choose_icon));
                    ImageView imageView = this.eYN.exG;
                    albumActivity3 = this.eYJ.eXM;
                    imageView.setContentDescription(albumActivity3.getResources().getString(t.j.check_box_checked));
                    return;
                }
                at.k(this.eYN.exG, t.f.chx_camera_pic_n);
                ImageView imageView2 = this.eYN.exG;
                albumActivity = this.eYJ.eXM;
                imageView2.setContentDescription(albumActivity.getResources().getString(t.j.check_box_not_checked));
            }
        }
    }
}
