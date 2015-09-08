package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
import com.baidu.tieba.write.album.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ y cZD;
    private final /* synthetic */ y.a cZE;
    private final /* synthetic */ ImageFileInfo cZF;
    private final /* synthetic */ m cZG;
    private final /* synthetic */ y.b cZH;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(y yVar, y.a aVar, m mVar, ImageFileInfo imageFileInfo, int i, y.b bVar) {
        this.cZD = yVar;
        this.cZE = aVar;
        this.cZG = mVar;
        this.cZF = imageFileInfo;
        this.val$position = i;
        this.cZH = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x xVar;
        x xVar2;
        AlbumActivity albumActivity;
        xVar = this.cZD.cZC;
        if (xVar != null && this.cZE.cZI) {
            boolean isAdded = this.cZG.isAdded(this.cZF);
            xVar2 = this.cZD.cZC;
            if (xVar2.a(this.val$position, this.cZF, !isAdded)) {
                if (!isAdded) {
                    com.baidu.tbadk.core.util.al.h(this.cZH.bNU, i.e.chx_camera_pic_s);
                    albumActivity = this.cZD.cYB;
                    this.cZH.bNU.startAnimation(AnimationUtils.loadAnimation(albumActivity.getPageContext().getPageActivity(), i.a.album_choose_icon));
                    return;
                }
                com.baidu.tbadk.core.util.al.h(this.cZH.bNU, i.e.chx_camera_pic_n);
            }
        }
    }
}
