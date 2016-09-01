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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.core.dialog.a {

    /* loaded from: classes.dex */
    public static class a extends b {
        public String emC = null;
        public String emD = null;
        public String emE = null;
    }

    /* loaded from: classes.dex */
    public static class b {
        public com.baidu.adp.base.h<?> aRe;
        public String emF = null;
        public String emG = null;
        public a.b emH = null;
        public a.b emI = null;
    }

    /* loaded from: classes.dex */
    public static class c extends b {
        public String emJ = null;
        public String emK = null;
    }

    /* loaded from: classes.dex */
    public static class d extends b {
        public CharSequence emL = null;
        public CharSequence emM = null;
        public CharSequence emN = null;
    }

    public h(Activity activity) {
        super(activity);
    }

    public void a(c cVar) {
        if (cVar != null) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(t.h.pb_dlg_txt, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(t.g.tip_top);
            textView.setText(cVar.emJ);
            com.baidu.tbadk.core.util.av.c(textView, t.d.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(t.g.tip_bottom);
            textView2.setText(cVar.emK);
            com.baidu.tbadk.core.util.av.c(textView2, t.d.cp_cont_b, 1);
            z(inflate);
            a(cVar.emG, cVar.emI);
            b(cVar.emF, cVar.emH);
            ar(false);
            b(cVar.aRe).sX();
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            int skinType = isAutoNight() ? TbadkCoreApplication.m9getInst().getSkinType() : 0;
            View inflate = LayoutInflater.from(this.mActivity).inflate(t.h.lottery_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(t.g.lottery_title);
            textView.setText(aVar.emC);
            com.baidu.tbadk.core.util.av.c(textView, t.d.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(t.g.lottery_des);
            textView2.setText(aVar.emD);
            com.baidu.tbadk.core.util.av.c(textView2, t.d.cp_cont_b, 1);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(t.g.lottery_image_bg);
            int e = com.baidu.adp.lib.util.k.e(this.mActivity, t.e.ds170);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tbImageView.getLayoutParams();
            layoutParams.width = (int) (e * 1.2272727272727273d);
            layoutParams.height = e;
            tbImageView.setLayoutParams(layoutParams);
            TbImageView tbImageView2 = (TbImageView) inflate.findViewById(t.g.lottery_image);
            int e2 = com.baidu.adp.lib.util.k.e(this.mActivity, t.e.ds152);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) tbImageView2.getLayoutParams();
            layoutParams2.width = (int) (e2 * 1.2272727272727273d);
            layoutParams2.height = e2;
            tbImageView2.setLayoutParams(layoutParams2);
            tbImageView2.c(aVar.emE, 10, false);
            z(inflate);
            a(aVar.emG, aVar.emI);
            b(aVar.emF, aVar.emH);
            ar(false);
            cb(1);
            b(aVar.aRe);
            com.baidu.tbadk.core.util.av.d(sY(), t.f.dialog_push_bg, skinType);
            sX();
        }
    }

    public void a(d dVar) {
        if (dVar != null) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(t.h.pb_three_row_text_dlg, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(t.g.first_row);
            textView.setText(dVar.emL);
            com.baidu.tbadk.core.util.av.c(textView, t.d.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(t.g.second_row);
            textView2.setText(dVar.emM);
            com.baidu.tbadk.core.util.av.c(textView2, t.d.cp_cont_b, 1);
            TextView textView3 = (TextView) inflate.findViewById(t.g.third_row);
            textView3.setText(dVar.emN);
            com.baidu.tbadk.core.util.av.c(textView3, t.d.cp_cont_b, 1);
            z(inflate);
            a(dVar.emG, dVar.emI);
            b(dVar.emF, dVar.emH);
            ar(false);
            b(dVar.aRe).sX();
        }
    }
}
