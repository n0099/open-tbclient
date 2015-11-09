package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
import com.baidu.tieba.write.album.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {
    final /* synthetic */ z dmJ;
    private final /* synthetic */ z.a dmK;
    private final /* synthetic */ ImageFileInfo dmL;
    private final /* synthetic */ m dmM;
    private final /* synthetic */ z.b dmN;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(z zVar, z.a aVar, m mVar, ImageFileInfo imageFileInfo, int i, z.b bVar) {
        this.dmJ = zVar;
        this.dmK = aVar;
        this.dmM = mVar;
        this.dmL = imageFileInfo;
        this.val$position = i;
        this.dmN = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        y yVar;
        y yVar2;
        AlbumActivity albumActivity;
        yVar = this.dmJ.dmI;
        if (yVar != null && this.dmK.dmO) {
            boolean isAdded = this.dmM.isAdded(this.dmL);
            yVar2 = this.dmJ.dmI;
            if (yVar2.a(this.val$position, this.dmL, !isAdded)) {
                if (!isAdded) {
                    com.baidu.tbadk.core.util.an.i(this.dmN.bSc, i.e.chx_camera_pic_s);
                    albumActivity = this.dmJ.dlE;
                    this.dmN.bSc.startAnimation(AnimationUtils.loadAnimation(albumActivity.getPageContext().getPageActivity(), i.a.album_choose_icon));
                    return;
                }
                com.baidu.tbadk.core.util.an.i(this.dmN.bSc, i.e.chx_camera_pic_n);
            }
        }
    }
}
