package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
import com.baidu.tieba.write.album.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ x dlb;
    private final /* synthetic */ x.a dlc;
    private final /* synthetic */ ImageFileInfo dld;
    private final /* synthetic */ l dle;
    private final /* synthetic */ x.b dlf;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(x xVar, x.a aVar, l lVar, ImageFileInfo imageFileInfo, int i, x.b bVar) {
        this.dlb = xVar;
        this.dlc = aVar;
        this.dle = lVar;
        this.dld = imageFileInfo;
        this.val$position = i;
        this.dlf = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        w wVar;
        w wVar2;
        AlbumActivity albumActivity;
        wVar = this.dlb.dla;
        if (wVar != null && this.dlc.dlg) {
            boolean isAdded = this.dle.isAdded(this.dld);
            wVar2 = this.dlb.dla;
            if (wVar2.a(this.val$position, this.dld, !isAdded)) {
                if (!isAdded) {
                    an.i(this.dlf.bRH, i.e.chx_camera_pic_s);
                    albumActivity = this.dlb.djW;
                    this.dlf.bRH.startAnimation(AnimationUtils.loadAnimation(albumActivity.getPageContext().getPageActivity(), i.a.album_choose_icon));
                    return;
                }
                an.i(this.dlf.bRH, i.e.chx_camera_pic_n);
            }
        }
    }
}
