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
    final /* synthetic */ l eKu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar) {
        this.eKu = lVar;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        PbActivity pbActivity;
        Bitmap bitmap;
        PbActivity pbActivity2;
        Bitmap bitmap2;
        pbActivity = this.eKu.euf;
        ImageView imageView = new ImageView(pbActivity.getActivity());
        bitmap = this.eKu.eKr;
        if (bitmap == null) {
            try {
                l lVar = this.eKu;
                pbActivity2 = this.eKu.euf;
                lVar.eKr = BitmapFactory.decodeResource(pbActivity2.getResources(), w.g.live_video_guide_like);
                bitmap2 = this.eKu.eKr;
                imageView.setImageBitmap(bitmap2);
            } catch (Throwable th) {
            }
        }
        return imageView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int eZ() {
        return 5;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int fa() {
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
