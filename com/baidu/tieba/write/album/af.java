package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.t;
import com.baidu.tieba.write.album.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    private final /* synthetic */ int VV;
    final /* synthetic */ ab gbe;
    private final /* synthetic */ ab.a gbf;
    private final /* synthetic */ ImageFileInfo gbg;
    private final /* synthetic */ o gbh;
    private final /* synthetic */ ab.b gbi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ab abVar, ab.a aVar, o oVar, ImageFileInfo imageFileInfo, int i, ab.b bVar) {
        this.gbe = abVar;
        this.gbf = aVar;
        this.gbh = oVar;
        this.gbg = imageFileInfo;
        this.VV = i;
        this.gbi = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aa aaVar;
        aa aaVar2;
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        aaVar = this.gbe.gbd;
        if (aaVar != null && this.gbf.gbj) {
            boolean isAdded = this.gbh.isAdded(this.gbg);
            aaVar2 = this.gbe.gbd;
            if (aaVar2.a(this.VV, this.gbg, !isAdded)) {
                if (!isAdded) {
                    av.k(this.gbi.fxp, t.f.chx_camera_pic_s);
                    albumActivity2 = this.gbe.gaf;
                    this.gbi.fxp.startAnimation(AnimationUtils.loadAnimation(albumActivity2.getPageContext().getPageActivity(), t.a.album_choose_icon));
                    ImageView imageView = this.gbi.fxp;
                    albumActivity3 = this.gbe.gaf;
                    imageView.setContentDescription(albumActivity3.getResources().getString(t.j.check_box_checked));
                    return;
                }
                av.k(this.gbi.fxp, t.f.chx_camera_pic_n);
                ImageView imageView2 = this.gbi.fxp;
                albumActivity = this.gbe.gaf;
                imageView2.setContentDescription(albumActivity.getResources().getString(t.j.check_box_not_checked));
            }
        }
    }
}
