package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.w;
import com.baidu.tieba.write.album.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    private final /* synthetic */ int aay;
    final /* synthetic */ ab fMs;
    private final /* synthetic */ ab.a fMt;
    private final /* synthetic */ ImageFileInfo fMu;
    private final /* synthetic */ o fMv;
    private final /* synthetic */ ab.b fMw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ab abVar, ab.a aVar, o oVar, ImageFileInfo imageFileInfo, int i, ab.b bVar) {
        this.fMs = abVar;
        this.fMt = aVar;
        this.fMv = oVar;
        this.fMu = imageFileInfo;
        this.aay = i;
        this.fMw = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aa aaVar;
        aa aaVar2;
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        aaVar = this.fMs.fMr;
        if (aaVar != null && this.fMt.fMx) {
            boolean isAdded = this.fMv.isAdded(this.fMu);
            aaVar2 = this.fMs.fMr;
            if (aaVar2.a(this.aay, this.fMu, !isAdded)) {
                if (!isAdded) {
                    aq.j(this.fMw.fzc, w.g.chx_camera_pic_s);
                    albumActivity2 = this.fMs.fLm;
                    this.fMw.fzc.startAnimation(AnimationUtils.loadAnimation(albumActivity2.getPageContext().getPageActivity(), w.a.album_choose_icon));
                    ImageView imageView = this.fMw.fzc;
                    albumActivity3 = this.fMs.fLm;
                    imageView.setContentDescription(albumActivity3.getResources().getString(w.l.check_box_checked));
                    return;
                }
                aq.j(this.fMw.fzc, w.g.chx_camera_pic_n);
                ImageView imageView2 = this.fMw.fzc;
                albumActivity = this.fMs.fLm;
                imageView2.setContentDescription(albumActivity.getResources().getString(w.l.check_box_not_checked));
            }
        }
    }
}
