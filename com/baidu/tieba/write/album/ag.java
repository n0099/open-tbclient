package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.img.ImageFileInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    private final /* synthetic */ int RY;
    final /* synthetic */ ac czd;
    private final /* synthetic */ ah cze;
    private final /* synthetic */ ImageFileInfo czf;
    private final /* synthetic */ p czg;
    private final /* synthetic */ ai czh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ac acVar, ah ahVar, p pVar, ImageFileInfo imageFileInfo, int i, ai aiVar) {
        this.czd = acVar;
        this.cze = ahVar;
        this.czg = pVar;
        this.czf = imageFileInfo;
        this.RY = i;
        this.czh = aiVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ab abVar;
        ab abVar2;
        AlbumActivity albumActivity;
        abVar = this.czd.czc;
        if (abVar != null && this.cze.czi) {
            boolean isAdded = this.czg.isAdded(this.czf);
            abVar2 = this.czd.czc;
            if (abVar2.a(this.RY, this.czf, !isAdded)) {
                if (!isAdded) {
                    ay.i(this.czh.bzx, com.baidu.tieba.p.chx_camera_pic_s);
                    albumActivity = this.czd.cya;
                    this.czh.bzx.startAnimation(AnimationUtils.loadAnimation(albumActivity.getPageContext().getPageActivity(), com.baidu.tieba.k.album_choose_icon));
                    return;
                }
                ay.i(this.czh.bzx, com.baidu.tieba.p.chx_camera_pic_n);
            }
        }
    }
}
