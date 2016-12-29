package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.r;
import com.baidu.tieba.write.album.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    private final /* synthetic */ int VX;
    final /* synthetic */ ab fzv;
    private final /* synthetic */ ab.a fzw;
    private final /* synthetic */ ImageFileInfo fzx;
    private final /* synthetic */ o fzy;
    private final /* synthetic */ ab.b fzz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ab abVar, ab.a aVar, o oVar, ImageFileInfo imageFileInfo, int i, ab.b bVar) {
        this.fzv = abVar;
        this.fzw = aVar;
        this.fzy = oVar;
        this.fzx = imageFileInfo;
        this.VX = i;
        this.fzz = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aa aaVar;
        aa aaVar2;
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        aaVar = this.fzv.fzu;
        if (aaVar != null && this.fzw.fzA) {
            boolean isAdded = this.fzy.isAdded(this.fzx);
            aaVar2 = this.fzv.fzu;
            if (aaVar2.a(this.VX, this.fzx, !isAdded)) {
                if (!isAdded) {
                    ar.k(this.fzz.flx, r.f.chx_camera_pic_s);
                    albumActivity2 = this.fzv.fyo;
                    this.fzz.flx.startAnimation(AnimationUtils.loadAnimation(albumActivity2.getPageContext().getPageActivity(), r.a.album_choose_icon));
                    ImageView imageView = this.fzz.flx;
                    albumActivity3 = this.fzv.fyo;
                    imageView.setContentDescription(albumActivity3.getResources().getString(r.j.check_box_checked));
                    return;
                }
                ar.k(this.fzz.flx, r.f.chx_camera_pic_n);
                ImageView imageView2 = this.fzz.flx;
                albumActivity = this.fzv.fyo;
                imageView2.setContentDescription(albumActivity.getResources().getString(r.j.check_box_not_checked));
            }
        }
    }
}
