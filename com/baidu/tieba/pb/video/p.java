package com.baidu.tieba.pb.video;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ l eAW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar) {
        this.eAW = lVar;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        PbActivity pbActivity;
        Bitmap bitmap;
        PbActivity pbActivity2;
        Bitmap bitmap2;
        pbActivity = this.eAW.elf;
        ImageView imageView = new ImageView(pbActivity.getActivity());
        bitmap = this.eAW.eAT;
        if (bitmap == null) {
            try {
                l lVar = this.eAW;
                pbActivity2 = this.eAW.elf;
                lVar.eAT = BitmapFactory.decodeResource(pbActivity2.getResources(), w.g.live_video_guide_like);
                bitmap2 = this.eAW.eAT;
                imageView.setImageBitmap(bitmap2);
            } catch (Throwable th) {
            }
        }
        return imageView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int fa() {
        return 5;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int fb() {
        return 32;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return 0;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return 0;
    }
}
