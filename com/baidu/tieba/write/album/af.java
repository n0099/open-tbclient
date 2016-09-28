package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.r;
import com.baidu.tieba.write.album.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    private final /* synthetic */ int Wf;
    final /* synthetic */ ab gdn;
    private final /* synthetic */ ab.a gdo;
    private final /* synthetic */ ImageFileInfo gdp;
    private final /* synthetic */ o gdq;
    private final /* synthetic */ ab.b gdr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ab abVar, ab.a aVar, o oVar, ImageFileInfo imageFileInfo, int i, ab.b bVar) {
        this.gdn = abVar;
        this.gdo = aVar;
        this.gdq = oVar;
        this.gdp = imageFileInfo;
        this.Wf = i;
        this.gdr = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aa aaVar;
        aa aaVar2;
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        aaVar = this.gdn.gdm;
        if (aaVar != null && this.gdo.gds) {
            boolean isAdded = this.gdq.isAdded(this.gdp);
            aaVar2 = this.gdn.gdm;
            if (aaVar2.a(this.Wf, this.gdp, !isAdded)) {
                if (!isAdded) {
                    av.k(this.gdr.fzR, r.f.chx_camera_pic_s);
                    albumActivity2 = this.gdn.gco;
                    this.gdr.fzR.startAnimation(AnimationUtils.loadAnimation(albumActivity2.getPageContext().getPageActivity(), r.a.album_choose_icon));
                    ImageView imageView = this.gdr.fzR;
                    albumActivity3 = this.gdn.gco;
                    imageView.setContentDescription(albumActivity3.getResources().getString(r.j.check_box_checked));
                    return;
                }
                av.k(this.gdr.fzR, r.f.chx_camera_pic_n);
                ImageView imageView2 = this.gdr.fzR;
                albumActivity = this.gdn.gco;
                imageView2.setContentDescription(albumActivity.getResources().getString(r.j.check_box_not_checked));
            }
        }
    }
}
