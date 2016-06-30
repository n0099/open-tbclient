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
    private final /* synthetic */ int Sx;
    final /* synthetic */ ab fDM;
    private final /* synthetic */ ab.a fDN;
    private final /* synthetic */ ImageFileInfo fDO;
    private final /* synthetic */ o fDP;
    private final /* synthetic */ ab.b fDQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ab abVar, ab.a aVar, o oVar, ImageFileInfo imageFileInfo, int i, ab.b bVar) {
        this.fDM = abVar;
        this.fDN = aVar;
        this.fDP = oVar;
        this.fDO = imageFileInfo;
        this.Sx = i;
        this.fDQ = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aa aaVar;
        aa aaVar2;
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        aaVar = this.fDM.fDL;
        if (aaVar != null && this.fDN.fDR) {
            boolean isAdded = this.fDP.isAdded(this.fDO);
            aaVar2 = this.fDM.fDL;
            if (aaVar2.a(this.Sx, this.fDO, !isAdded)) {
                if (!isAdded) {
                    av.k(this.fDQ.fcq, u.f.chx_camera_pic_s);
                    albumActivity2 = this.fDM.fCP;
                    this.fDQ.fcq.startAnimation(AnimationUtils.loadAnimation(albumActivity2.getPageContext().getPageActivity(), u.a.album_choose_icon));
                    ImageView imageView = this.fDQ.fcq;
                    albumActivity3 = this.fDM.fCP;
                    imageView.setContentDescription(albumActivity3.getResources().getString(u.j.check_box_checked));
                    return;
                }
                av.k(this.fDQ.fcq, u.f.chx_camera_pic_n);
                ImageView imageView2 = this.fDQ.fcq;
                albumActivity = this.fDM.fCP;
                imageView2.setContentDescription(albumActivity.getResources().getString(u.j.check_box_not_checked));
            }
        }
    }
}
