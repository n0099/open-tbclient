package com.baidu.tieba.write.album;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.w;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {
    final /* synthetic */ ac fNP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ac acVar) {
        this.fNP = acVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        View view3;
        View view4;
        View view5;
        View view6;
        TbCameraView tbCameraView;
        TbCameraView tbCameraView2;
        TbCameraView tbCameraView3;
        TbCameraView tbCameraView4;
        p pVar;
        p pVar2;
        p pVar3;
        AlbumActivity albumActivity;
        p pVar4;
        AlbumActivity albumActivity2;
        com.baidu.tieba.write.view.a aVar;
        p pVar5;
        p pVar6;
        com.baidu.tieba.write.view.a aVar2;
        View view7;
        int i;
        int i2;
        TextView textView2;
        int id = view.getId();
        textView = this.fNP.bKb;
        if (id == textView.getId()) {
            aVar = this.fNP.fNn;
            pVar5 = this.fNP.fLQ;
            List<e> bmt = pVar5.bmt();
            pVar6 = this.fNP.fLQ;
            aVar.b(bmt, pVar6.bmr());
            aVar2 = this.fNP.fNn;
            view7 = this.fNP.aTA;
            aVar2.aC(view7);
            i = this.fNP.fNC;
            if (i <= 50) {
                i2 = w.g.d_ic_post_gallery_spread_s;
            } else {
                i2 = w.g.ic_post_gallery_spread_s;
            }
            Drawable drawable = this.fNP.getResources().getDrawable(i2);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView2 = this.fNP.bKb;
            textView2.setCompoundDrawables(null, null, drawable, null);
            return;
        }
        int id2 = view.getId();
        view2 = this.fNP.fNt;
        if (id2 == view2.getId()) {
            this.fNP.lE(true);
            this.fNP.bmy();
            return;
        }
        int id3 = view.getId();
        view3 = this.fNP.fNu;
        if (id3 == view3.getId()) {
            pVar = this.fNP.fLQ;
            int maxImagesAllowed = pVar.getMaxImagesAllowed();
            pVar2 = this.fNP.fLQ;
            if (pVar2.size() >= maxImagesAllowed) {
                albumActivity2 = this.fNP.fMg;
                if (!albumActivity2.blT()) {
                    this.fNP.showToast(String.format(this.fNP.getPageContext().getString(w.l.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
                    return;
                }
            }
            pVar3 = this.fNP.fLQ;
            pVar3.qV(String.valueOf(System.currentTimeMillis()));
            albumActivity = this.fNP.fMg;
            pVar4 = this.fNP.fLQ;
            albumActivity.hA(pVar4.bmv());
            return;
        }
        int id4 = view.getId();
        view4 = this.fNP.fNv;
        if (id4 == view4.getId()) {
            tbCameraView3 = this.fNP.fNr;
            if (tbCameraView3 != null) {
                tbCameraView4 = this.fNP.fNr;
                tbCameraView4.bmJ();
                return;
            }
            return;
        }
        int id5 = view.getId();
        view5 = this.fNP.fNy;
        if (id5 == view5.getId()) {
            this.fNP.bmz();
            return;
        }
        int id6 = view.getId();
        view6 = this.fNP.fNx;
        if (id6 == view6.getId()) {
            tbCameraView = this.fNP.fNr;
            if (tbCameraView != null) {
                tbCameraView2 = this.fNP.fNr;
                tbCameraView2.bmL();
            }
        }
    }
}
