package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    private final /* synthetic */ int RY;
    final /* synthetic */ ac czc;
    private final /* synthetic */ ah czd;
    private final /* synthetic */ ImageFileInfo cze;
    private final /* synthetic */ p czf;
    private final /* synthetic */ ai czg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ac acVar, ah ahVar, p pVar, ImageFileInfo imageFileInfo, int i, ai aiVar) {
        this.czc = acVar;
        this.czd = ahVar;
        this.czf = pVar;
        this.cze = imageFileInfo;
        this.RY = i;
        this.czg = aiVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ab abVar;
        ab abVar2;
        AlbumActivity albumActivity;
        abVar = this.czc.czb;
        if (abVar != null && this.czd.czh) {
            boolean isAdded = this.czf.isAdded(this.cze);
            abVar2 = this.czc.czb;
            if (abVar2.a(this.RY, this.cze, !isAdded)) {
                if (!isAdded) {
                    ay.i(this.czg.bzw, com.baidu.tieba.p.chx_camera_pic_s);
                    albumActivity = this.czc.cxZ;
                    this.czg.bzw.startAnimation(AnimationUtils.loadAnimation(albumActivity.getPageContext().getPageActivity(), com.baidu.tieba.k.album_choose_icon));
                    return;
                }
                ay.i(this.czg.bzw, com.baidu.tieba.p.chx_camera_pic_n);
            }
        }
    }
}
