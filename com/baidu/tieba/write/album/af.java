package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.n;
import com.baidu.tieba.write.album.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    final /* synthetic */ ab dTo;
    private final /* synthetic */ ab.a dTp;
    private final /* synthetic */ ImageFileInfo dTq;
    private final /* synthetic */ o dTr;
    private final /* synthetic */ ab.b dTs;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ab abVar, ab.a aVar, o oVar, ImageFileInfo imageFileInfo, int i, ab.b bVar) {
        this.dTo = abVar;
        this.dTp = aVar;
        this.dTr = oVar;
        this.dTq = imageFileInfo;
        this.val$position = i;
        this.dTs = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aa aaVar;
        aa aaVar2;
        AlbumActivity albumActivity;
        aaVar = this.dTo.dTn;
        if (aaVar != null && this.dTp.dTt) {
            boolean isAdded = this.dTr.isAdded(this.dTq);
            aaVar2 = this.dTo.dTn;
            if (aaVar2.a(this.val$position, this.dTq, !isAdded)) {
                if (!isAdded) {
                    as.i(this.dTs.cmu, n.f.chx_camera_pic_s);
                    albumActivity = this.dTo.dSj;
                    this.dTs.cmu.startAnimation(AnimationUtils.loadAnimation(albumActivity.getPageContext().getPageActivity(), n.a.album_choose_icon));
                    return;
                }
                as.i(this.dTs.cmu, n.f.chx_camera_pic_n);
            }
        }
    }
}
