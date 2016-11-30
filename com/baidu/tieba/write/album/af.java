package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.r;
import com.baidu.tieba.write.album.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    private final /* synthetic */ int WD;
    final /* synthetic */ ab gkS;
    private final /* synthetic */ ab.a gkT;
    private final /* synthetic */ ImageFileInfo gkU;
    private final /* synthetic */ o gkV;
    private final /* synthetic */ ab.b gkW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ab abVar, ab.a aVar, o oVar, ImageFileInfo imageFileInfo, int i, ab.b bVar) {
        this.gkS = abVar;
        this.gkT = aVar;
        this.gkV = oVar;
        this.gkU = imageFileInfo;
        this.WD = i;
        this.gkW = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aa aaVar;
        aa aaVar2;
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        aaVar = this.gkS.gkR;
        if (aaVar != null && this.gkT.gkX) {
            boolean isAdded = this.gkV.isAdded(this.gkU);
            aaVar2 = this.gkS.gkR;
            if (aaVar2.a(this.WD, this.gkU, !isAdded)) {
                if (!isAdded) {
                    at.k(this.gkW.fHt, r.f.chx_camera_pic_s);
                    albumActivity2 = this.gkS.gjT;
                    this.gkW.fHt.startAnimation(AnimationUtils.loadAnimation(albumActivity2.getPageContext().getPageActivity(), r.a.album_choose_icon));
                    ImageView imageView = this.gkW.fHt;
                    albumActivity3 = this.gkS.gjT;
                    imageView.setContentDescription(albumActivity3.getResources().getString(r.j.check_box_checked));
                    return;
                }
                at.k(this.gkW.fHt, r.f.chx_camera_pic_n);
                ImageView imageView2 = this.gkW.fHt;
                albumActivity = this.gkS.gjT;
                imageView2.setContentDescription(albumActivity.getResources().getString(r.j.check_box_not_checked));
            }
        }
    }
}
