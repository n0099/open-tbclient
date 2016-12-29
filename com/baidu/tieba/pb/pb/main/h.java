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
        public String dYF = null;
        public String dYG = null;
        public String dYH = null;
    }

    /* loaded from: classes.dex */
    public static class b {
        public com.baidu.adp.base.h<?> aTE;
        public String dYI = null;
        public String dYJ = null;
        public a.b dYK = null;
        public a.b dYL = null;
    }

    /* loaded from: classes.dex */
    public static class c extends b {
        public String dYM = null;
        public String dYN = null;
    }

    /* loaded from: classes.dex */
    public static class d extends b {
        public CharSequence dYO = null;
        public CharSequence dYP = null;
        public CharSequence dYQ = null;
    }

    public h(Activity activity) {
        super(activity);
    }

    public void a(c cVar) {
        if (cVar != null) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(r.h.pb_dlg_txt, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(r.g.tip_top);
            textView.setText(cVar.dYM);
            com.baidu.tbadk.core.util.ar.c(textView, r.d.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(r.g.tip_bottom);
            textView2.setText(cVar.dYN);
            com.baidu.tbadk.core.util.ar.c(textView2, r.d.cp_cont_b, 1);
            z(inflate);
            a(cVar.dYJ, cVar.dYL);
            b(cVar.dYI, cVar.dYK);
            av(false);
            b(cVar.aTE).tb();
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            int skinType = isAutoNight() ? TbadkCoreApplication.m9getInst().getSkinType() : 0;
            View inflate = LayoutInflater.from(this.mActivity).inflate(r.h.lottery_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(r.g.lottery_title);
            textView.setText(aVar.dYF);
            com.baidu.tbadk.core.util.ar.c(textView, r.d.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(r.g.lottery_des);
            textView2.setText(aVar.dYG);
            com.baidu.tbadk.core.util.ar.c(textView2, r.d.cp_cont_b, 1);
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
            tbImageView2.c(aVar.dYH, 10, false);
            z(inflate);
            a(aVar.dYJ, aVar.dYL);
            b(aVar.dYI, aVar.dYK);
            av(false);
            cd(1);
            b(aVar.aTE);
            com.baidu.tbadk.core.util.ar.d(tc(), r.f.dialog_push_bg, skinType);
            tb();
        }
    }

    public void a(d dVar) {
        if (dVar != null) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(r.h.pb_three_row_text_dlg, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(r.g.first_row);
            textView.setText(dVar.dYO);
            com.baidu.tbadk.core.util.ar.c(textView, r.d.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(r.g.second_row);
            textView2.setText(dVar.dYP);
            com.baidu.tbadk.core.util.ar.c(textView2, r.d.cp_cont_b, 1);
            TextView textView3 = (TextView) inflate.findViewById(r.g.third_row);
            textView3.setText(dVar.dYQ);
            com.baidu.tbadk.core.util.ar.c(textView3, r.d.cp_cont_b, 1);
            z(inflate);
            a(dVar.dYJ, dVar.dYL);
            b(dVar.dYI, dVar.dYK);
            av(false);
            b(dVar.aTE).tb();
        }
    }
}
