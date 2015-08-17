package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
import com.baidu.tieba.write.album.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ y cQS;
    private final /* synthetic */ y.a cQT;
    private final /* synthetic */ ImageFileInfo cQU;
    private final /* synthetic */ m cQV;
    private final /* synthetic */ y.b cQW;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(y yVar, y.a aVar, m mVar, ImageFileInfo imageFileInfo, int i, y.b bVar) {
        this.cQS = yVar;
        this.cQT = aVar;
        this.cQV = mVar;
        this.cQU = imageFileInfo;
        this.val$position = i;
        this.cQW = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x xVar;
        x xVar2;
        AlbumActivity albumActivity;
        xVar = this.cQS.cQR;
        if (xVar != null && this.cQT.cQX) {
            boolean isAdded = this.cQV.isAdded(this.cQU);
            xVar2 = this.cQS.cQR;
            if (xVar2.a(this.val$position, this.cQU, !isAdded)) {
                if (!isAdded) {
                    com.baidu.tbadk.core.util.al.i(this.cQW.bNn, i.e.chx_camera_pic_s);
                    albumActivity = this.cQS.cPQ;
                    this.cQW.bNn.startAnimation(AnimationUtils.loadAnimation(albumActivity.getPageContext().getPageActivity(), i.a.album_choose_icon));
                    return;
                }
                com.baidu.tbadk.core.util.al.i(this.cQW.bNn, i.e.chx_camera_pic_n);
            }
        }
    }
}
