package com.baidu.tieba.write.album;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.w;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {
    final /* synthetic */ ac ggh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ac acVar) {
        this.ggh = acVar;
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
        textView = this.ggh.bWL;
        if (id == textView.getId()) {
            aVar = this.ggh.gfF;
            pVar5 = this.ggh.gei;
            List<e> bsn = pVar5.bsn();
            pVar6 = this.ggh.gei;
            aVar.c(bsn, pVar6.bsl());
            aVar2 = this.ggh.gfF;
            view7 = this.ggh.bDz;
            aVar2.aE(view7);
            i = this.ggh.gfU;
            if (i <= 50) {
                i2 = w.g.d_ic_post_gallery_spread_s;
            } else {
                i2 = w.g.ic_post_gallery_spread_s;
            }
            Drawable drawable = this.ggh.getResources().getDrawable(i2);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView2 = this.ggh.bWL;
            textView2.setCompoundDrawables(null, null, drawable, null);
            return;
        }
        int id2 = view.getId();
        view2 = this.ggh.gfL;
        if (id2 == view2.getId()) {
            this.ggh.my(true);
            this.ggh.bss();
            return;
        }
        int id3 = view.getId();
        view3 = this.ggh.gfM;
        if (id3 == view3.getId()) {
            pVar = this.ggh.gei;
            int maxImagesAllowed = pVar.getMaxImagesAllowed();
            pVar2 = this.ggh.gei;
            if (pVar2.size() >= maxImagesAllowed) {
                albumActivity2 = this.ggh.gex;
                if (!albumActivity2.brN()) {
                    this.ggh.showToast(String.format(this.ggh.getPageContext().getString(w.l.album_beyond_max_choose), Integer.valueOf(maxImagesAllowed)));
                    return;
                }
            }
            pVar3 = this.ggh.gei;
            pVar3.sh(String.valueOf(System.currentTimeMillis()));
            albumActivity = this.ggh.gex;
            pVar4 = this.ggh.gei;
            albumActivity.ia(pVar4.bsp());
            return;
        }
        int id4 = view.getId();
        view4 = this.ggh.gfN;
        if (id4 == view4.getId()) {
            tbCameraView3 = this.ggh.gfJ;
            if (tbCameraView3 != null) {
                tbCameraView4 = this.ggh.gfJ;
                tbCameraView4.bsD();
                return;
            }
            return;
        }
        int id5 = view.getId();
        view5 = this.ggh.gfQ;
        if (id5 == view5.getId()) {
            this.ggh.bst();
            return;
        }
        int id6 = view.getId();
        view6 = this.ggh.gfP;
        if (id6 == view6.getId()) {
            tbCameraView = this.ggh.gfJ;
            if (tbCameraView != null) {
                tbCameraView2 = this.ggh.gfJ;
                tbCameraView2.bsF();
            }
        }
    }
}
