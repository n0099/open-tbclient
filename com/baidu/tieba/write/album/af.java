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
    private final /* synthetic */ int WS;
    final /* synthetic */ ab eHP;
    private final /* synthetic */ ab.a eHQ;
    private final /* synthetic */ ImageFileInfo eHR;
    private final /* synthetic */ o eHS;
    private final /* synthetic */ ab.b eHT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ab abVar, ab.a aVar, o oVar, ImageFileInfo imageFileInfo, int i, ab.b bVar) {
        this.eHP = abVar;
        this.eHQ = aVar;
        this.eHS = oVar;
        this.eHR = imageFileInfo;
        this.WS = i;
        this.eHT = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aa aaVar;
        aa aaVar2;
        AlbumActivity albumActivity;
        AlbumActivity albumActivity2;
        AlbumActivity albumActivity3;
        aaVar = this.eHP.eHO;
        if (aaVar != null && this.eHQ.eHU) {
            boolean isAdded = this.eHS.isAdded(this.eHR);
            aaVar2 = this.eHP.eHO;
            if (aaVar2.a(this.WS, this.eHR, !isAdded)) {
                if (!isAdded) {
                    at.k(this.eHT.cDz, t.f.chx_camera_pic_s);
                    albumActivity2 = this.eHP.eGS;
                    this.eHT.cDz.startAnimation(AnimationUtils.loadAnimation(albumActivity2.getPageContext().getPageActivity(), t.a.album_choose_icon));
                    ImageView imageView = this.eHT.cDz;
                    albumActivity3 = this.eHP.eGS;
                    imageView.setContentDescription(albumActivity3.getResources().getString(t.j.check_box_checked));
                    return;
                }
                at.k(this.eHT.cDz, t.f.chx_camera_pic_n);
                ImageView imageView2 = this.eHT.cDz;
                albumActivity = this.eHP.eGS;
                imageView2.setContentDescription(albumActivity.getResources().getString(t.j.check_box_not_checked));
            }
        }
    }
}
