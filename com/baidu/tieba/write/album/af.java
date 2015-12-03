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
    final /* synthetic */ ab dLP;
    private final /* synthetic */ ab.a dLQ;
    private final /* synthetic */ ImageFileInfo dLR;
    private final /* synthetic */ o dLS;
    private final /* synthetic */ ab.b dLT;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ab abVar, ab.a aVar, o oVar, ImageFileInfo imageFileInfo, int i, ab.b bVar) {
        this.dLP = abVar;
        this.dLQ = aVar;
        this.dLS = oVar;
        this.dLR = imageFileInfo;
        this.val$position = i;
        this.dLT = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aa aaVar;
        aa aaVar2;
        AlbumActivity albumActivity;
        aaVar = this.dLP.dLO;
        if (aaVar != null && this.dLQ.dLU) {
            boolean isAdded = this.dLS.isAdded(this.dLR);
            aaVar2 = this.dLP.dLO;
            if (aaVar2.a(this.val$position, this.dLR, !isAdded)) {
                if (!isAdded) {
                    as.i(this.dLT.cip, n.e.chx_camera_pic_s);
                    albumActivity = this.dLP.dKK;
                    this.dLT.cip.startAnimation(AnimationUtils.loadAnimation(albumActivity.getPageContext().getPageActivity(), n.a.album_choose_icon));
                    return;
                }
                as.i(this.dLT.cip, n.e.chx_camera_pic_n);
            }
        }
    }
}
