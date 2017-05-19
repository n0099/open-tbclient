package com.baidu.tieba.write.album;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.w;
import com.baidu.tieba.write.album.TransparentHeadGridView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements TransparentHeadGridView.a {
    final /* synthetic */ ac fNP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ac acVar) {
        this.fNP = acVar;
    }

    @Override // com.baidu.tieba.write.album.TransparentHeadGridView.a
    public void sR(int i) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        ImageView imageView;
        View view;
        View view2;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        ImageView imageView2;
        View view3;
        this.fNP.fNC = i;
        if (i <= 50) {
            textView4 = this.fNP.bKb;
            textView4.setTextColor(this.fNP.getResources().getColor(w.e.white_alpha100));
            Drawable drawable = this.fNP.getResources().getDrawable(w.g.d_ic_post_gallery_spread_n);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView5 = this.fNP.bKb;
            textView5.setCompoundDrawables(null, null, drawable, null);
            textView6 = this.fNP.fNm;
            textView6.setTextColor(this.fNP.getResources().getColor(w.e.white_alpha100));
            imageView2 = this.fNP.fNl;
            imageView2.setImageResource(w.g.d_con_pb_post_close_n);
            view3 = this.fNP.aTA;
            view3.setAlpha(1.0f - ((i * 2.0f) / 100.0f));
        } else {
            textView = this.fNP.bKb;
            textView.setTextColor(this.fNP.getResources().getColor(w.e.cp_cont_b));
            Drawable drawable2 = this.fNP.getResources().getDrawable(w.g.ic_post_gallery_spread_n);
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
            textView2 = this.fNP.bKb;
            textView2.setCompoundDrawables(null, null, drawable2, null);
            textView3 = this.fNP.fNm;
            textView3.setTextColor(this.fNP.getResources().getColor(w.e.cp_cont_b));
            imageView = this.fNP.fNl;
            imageView.setImageResource(w.g.icon_topbar_close_n);
            view = this.fNP.aTA;
            view.setAlpha(((i - 50) * 2.0f) / 100.0f);
        }
        view2 = this.fNP.fNq;
        view2.setAlpha((i * 1.0f) / 100.0f);
    }
}
