package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {
    private final /* synthetic */ int Rx;
    final /* synthetic */ aa cuu;
    private final /* synthetic */ af cuv;
    private final /* synthetic */ ImageFileInfo cuw;
    private final /* synthetic */ n cux;
    private final /* synthetic */ ag cuy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(aa aaVar, af afVar, n nVar, ImageFileInfo imageFileInfo, int i, ag agVar) {
        this.cuu = aaVar;
        this.cuv = afVar;
        this.cux = nVar;
        this.cuw = imageFileInfo;
        this.Rx = i;
        this.cuy = agVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        z zVar2;
        AlbumActivity albumActivity;
        zVar = this.cuu.cut;
        if (zVar != null && this.cuv.cuz) {
            boolean isAdded = this.cux.isAdded(this.cuw);
            zVar2 = this.cuu.cut;
            if (zVar2.onClick(this.Rx, this.cuw, !isAdded)) {
                if (!isAdded) {
                    ba.i(this.cuy.bwy, com.baidu.tieba.u.chx_camera_pic_s);
                    albumActivity = this.cuu.ctu;
                    this.cuy.bwy.startAnimation(AnimationUtils.loadAnimation(albumActivity.getPageContext().getPageActivity(), com.baidu.tieba.p.album_choose_icon));
                    return;
                }
                ba.i(this.cuy.bwy, com.baidu.tieba.u.chx_camera_pic_n);
            }
        }
    }
}
