package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
import com.baidu.tieba.write.album.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ x dkB;
    private final /* synthetic */ x.a dkC;
    private final /* synthetic */ ImageFileInfo dkD;
    private final /* synthetic */ l dkE;
    private final /* synthetic */ x.b dkF;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(x xVar, x.a aVar, l lVar, ImageFileInfo imageFileInfo, int i, x.b bVar) {
        this.dkB = xVar;
        this.dkC = aVar;
        this.dkE = lVar;
        this.dkD = imageFileInfo;
        this.val$position = i;
        this.dkF = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        w wVar;
        w wVar2;
        AlbumActivity albumActivity;
        wVar = this.dkB.dkA;
        if (wVar != null && this.dkC.dkG) {
            boolean isAdded = this.dkE.isAdded(this.dkD);
            wVar2 = this.dkB.dkA;
            if (wVar2.a(this.val$position, this.dkD, !isAdded)) {
                if (!isAdded) {
                    am.i(this.dkF.bRw, i.e.chx_camera_pic_s);
                    albumActivity = this.dkB.djw;
                    this.dkF.bRw.startAnimation(AnimationUtils.loadAnimation(albumActivity.getPageContext().getPageActivity(), i.a.album_choose_icon));
                    return;
                }
                am.i(this.dkF.bRw, i.e.chx_camera_pic_n);
            }
        }
    }
}
