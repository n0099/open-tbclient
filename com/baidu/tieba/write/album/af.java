package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.t;
import com.baidu.tieba.write.album.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    private final /* synthetic */ int YA;
    final /* synthetic */ ab enS;
    private final /* synthetic */ ab.a enT;
    private final /* synthetic */ ImageFileInfo enU;
    private final /* synthetic */ o enV;
    private final /* synthetic */ ab.b enW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ab abVar, ab.a aVar, o oVar, ImageFileInfo imageFileInfo, int i, ab.b bVar) {
        this.enS = abVar;
        this.enT = aVar;
        this.enV = oVar;
        this.enU = imageFileInfo;
        this.YA = i;
        this.enW = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aa aaVar;
        aa aaVar2;
        AlbumActivity albumActivity;
        aaVar = this.enS.enR;
        if (aaVar != null && this.enT.enX) {
            boolean isAdded = this.enV.isAdded(this.enU);
            aaVar2 = this.enS.enR;
            if (aaVar2.a(this.YA, this.enU, !isAdded)) {
                if (!isAdded) {
                    ar.k(this.enW.csZ, t.f.chx_camera_pic_s);
                    albumActivity = this.enS.emU;
                    this.enW.csZ.startAnimation(AnimationUtils.loadAnimation(albumActivity.getPageContext().getPageActivity(), t.a.album_choose_icon));
                    return;
                }
                ar.k(this.enW.csZ, t.f.chx_camera_pic_n);
            }
        }
    }
}
