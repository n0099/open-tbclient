package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {
    private final /* synthetic */ int Rz;
    final /* synthetic */ aa cuK;
    private final /* synthetic */ af cuL;
    private final /* synthetic */ ImageFileInfo cuM;
    private final /* synthetic */ n cuN;
    private final /* synthetic */ ag cuO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(aa aaVar, af afVar, n nVar, ImageFileInfo imageFileInfo, int i, ag agVar) {
        this.cuK = aaVar;
        this.cuL = afVar;
        this.cuN = nVar;
        this.cuM = imageFileInfo;
        this.Rz = i;
        this.cuO = agVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        z zVar2;
        AlbumActivity albumActivity;
        zVar = this.cuK.cuJ;
        if (zVar != null && this.cuL.cuP) {
            boolean isAdded = this.cuN.isAdded(this.cuM);
            zVar2 = this.cuK.cuJ;
            if (zVar2.onClick(this.Rz, this.cuM, !isAdded)) {
                if (!isAdded) {
                    ba.i(this.cuO.bwO, com.baidu.tieba.u.chx_camera_pic_s);
                    albumActivity = this.cuK.ctK;
                    this.cuO.bwO.startAnimation(AnimationUtils.loadAnimation(albumActivity.getPageContext().getPageActivity(), com.baidu.tieba.p.album_choose_icon));
                    return;
                }
                ba.i(this.cuO.bwO, com.baidu.tieba.u.chx_camera_pic_n);
            }
        }
    }
}
