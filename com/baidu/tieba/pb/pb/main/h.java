package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.core.dialog.a {

    /* loaded from: classes.dex */
    public static class a extends b {
        public String euk = null;
        public String eul = null;
        public String eum = null;
    }

    /* loaded from: classes.dex */
    public static class b {
        public com.baidu.adp.base.h<?> aUn;
        public String eun = null;
        public String euo = null;
        public a.b eup = null;
        public a.b euq = null;
    }

    /* loaded from: classes.dex */
    public static class c extends b {
        public String eur = null;
        public String eus = null;
    }

    /* loaded from: classes.dex */
    public static class d extends b {
        public CharSequence eut = null;
        public CharSequence euu = null;
        public CharSequence euv = null;
    }

    public h(Activity activity) {
        super(activity);
    }

    public void a(c cVar) {
        if (cVar != null) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(r.h.pb_dlg_txt, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(r.g.tip_top);
            textView.setText(cVar.eur);
            com.baidu.tbadk.core.util.at.c(textView, r.d.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(r.g.tip_bottom);
            textView2.setText(cVar.eus);
            com.baidu.tbadk.core.util.at.c(textView2, r.d.cp_cont_b, 1);
            z(inflate);
            a(cVar.euo, cVar.euq);
            b(cVar.eun, cVar.eup);
            au(false);
            b(cVar.aUn).tq();
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            int skinType = isAutoNight() ? TbadkCoreApplication.m9getInst().getSkinType() : 0;
            View inflate = LayoutInflater.from(this.mActivity).inflate(r.h.lottery_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(r.g.lottery_title);
            textView.setText(aVar.euk);
            com.baidu.tbadk.core.util.at.c(textView, r.d.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(r.g.lottery_des);
            textView2.setText(aVar.eul);
            com.baidu.tbadk.core.util.at.c(textView2, r.d.cp_cont_b, 1);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(r.g.lottery_image_bg);
            int e = com.baidu.adp.lib.util.k.e(this.mActivity, r.e.ds170);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tbImageView.getLayoutParams();
            layoutParams.width = (int) (e * 1.2272727272727273d);
            layoutParams.height = e;
            tbImageView.setLayoutParams(layoutParams);
            TbImageView tbImageView2 = (TbImageView) inflate.findViewById(r.g.lottery_image);
            int e2 = com.baidu.adp.lib.util.k.e(this.mActivity, r.e.ds152);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) tbImageView2.getLayoutParams();
            layoutParams2.width = (int) (e2 * 1.2272727272727273d);
            layoutParams2.height = e2;
            tbImageView2.setLayoutParams(layoutParams2);
            tbImageView2.c(aVar.eum, 10, false);
            z(inflate);
            a(aVar.euo, aVar.euq);
            b(aVar.eun, aVar.eup);
            au(false);
            cc(1);
            b(aVar.aUn);
            com.baidu.tbadk.core.util.at.d(tr(), r.f.dialog_push_bg, skinType);
            tq();
        }
    }

    public void a(d dVar) {
        if (dVar != null) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(r.h.pb_three_row_text_dlg, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(r.g.first_row);
            textView.setText(dVar.eut);
            com.baidu.tbadk.core.util.at.c(textView, r.d.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(r.g.second_row);
            textView2.setText(dVar.euu);
            com.baidu.tbadk.core.util.at.c(textView2, r.d.cp_cont_b, 1);
            TextView textView3 = (TextView) inflate.findViewById(r.g.third_row);
            textView3.setText(dVar.euv);
            com.baidu.tbadk.core.util.at.c(textView3, r.d.cp_cont_b, 1);
            z(inflate);
            a(dVar.euo, dVar.euq);
            b(dVar.eun, dVar.eup);
            au(false);
            b(dVar.aUn).tq();
        }
    }
}
