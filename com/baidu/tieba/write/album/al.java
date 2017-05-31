package com.baidu.tieba.write.album;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.w;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {
    final /* synthetic */ ac fVw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ac acVar) {
        this.fVw = acVar;
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
        textView = this.fVw.bPO;
        if (id == textView.getId()) {
            aVar = this.fVw.fUU;
            pVar5 = this.fVw.fTx;
            List<e> bnQ = pVar5.bnQ();
            pVar6 = this.fVw.fTx;
            aVar.b(bnQ, pVar6.bnO());
            aVar2 = this.fVw.fUU;
            view7 = this.fVw.bCG;
            aVar2.aC(view7);
            i = this.fVw.fVj;
            if (i <= 50) {
                i2 = w.g.d_ic_post_gallery_spread_s;
            } else {
                i2 = w.g.ic_post_gallery_spread_s;
            }
            Drawable drawable = this.fVw.getResources().getDrawable(i2);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView2 = this.fVw.bPO;
            textView2.setCompoundDrawables(null, null, drawable, null);
            return;
        }
        int id2 = view.getId();
        view2 = this.fVw.fVa;
        if (id2 == view2.getId()) {
            this.fVw.lX(true);
            this.fVw.bnV();
            return;
        }
        int id3 = view.getId();
        view3 = this.fVw.fVb;
        if (id3 == view3.getId()) {
            pVar = this.fVw.fTx;
            int maxImagesAllowed = pVar.getMaxImagesAllowed();
            pVar2 = this.fVw.fTx;
            if (pVar2.size() >= maxImagesAllowed) {
                albumActivity2 = this.fVw.fTN;
                if (!albumActivity2.bnq()) {
                    this.fVw.showToast(String.format(this.fVw.getPageContext().getString(w.l.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
                    return;
                }
            }
            pVar3 = this.fVw.fTx;
            pVar3.ri(String.valueOf(System.currentTimeMillis()));
            albumActivity = this.fVw.fTN;
            pVar4 = this.fVw.fTx;
            albumActivity.hB(pVar4.bnS());
            return;
        }
        int id4 = view.getId();
        view4 = this.fVw.fVc;
        if (id4 == view4.getId()) {
            tbCameraView3 = this.fVw.fUY;
            if (tbCameraView3 != null) {
                tbCameraView4 = this.fVw.fUY;
                tbCameraView4.bog();
                return;
            }
            return;
        }
        int id5 = view.getId();
        view5 = this.fVw.fVf;
        if (id5 == view5.getId()) {
            this.fVw.bnW();
            return;
        }
        int id6 = view.getId();
        view6 = this.fVw.fVe;
        if (id6 == view6.getId()) {
            tbCameraView = this.fVw.fUY;
            if (tbCameraView != null) {
                tbCameraView2 = this.fVw.fUY;
                tbCameraView2.boi();
            }
        }
    }
}
