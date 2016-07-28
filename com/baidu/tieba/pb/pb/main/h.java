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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.core.dialog.a {

    /* loaded from: classes.dex */
    public static class a extends b {
        public String eax = null;
        public String eay = null;
        public String eaz = null;
    }

    /* loaded from: classes.dex */
    public static class b {
        public com.baidu.adp.base.h<?> aLK;
        public String eaA = null;
        public String eaB = null;
        public a.b eaC = null;
        public a.b eaD = null;
    }

    /* loaded from: classes.dex */
    public static class c extends b {
        public String eaE = null;
        public String eaF = null;
    }

    /* loaded from: classes.dex */
    public static class d extends b {
        public CharSequence eaG = null;
        public CharSequence eaH = null;
        public CharSequence eaI = null;
    }

    public h(Activity activity) {
        super(activity);
    }

    public void a(c cVar) {
        if (cVar != null) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(u.h.pb_dlg_txt, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(u.g.tip_top);
            textView.setText(cVar.eaE);
            com.baidu.tbadk.core.util.av.c(textView, u.d.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(u.g.tip_bottom);
            textView2.setText(cVar.eaF);
            com.baidu.tbadk.core.util.av.c(textView2, u.d.cp_cont_b, 1);
            y(inflate);
            a(cVar.eaB, cVar.eaD);
            b(cVar.eaA, cVar.eaC);
            aq(false);
            b(cVar.aLK).rS();
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            int skinType = isAutoNight() ? TbadkCoreApplication.m10getInst().getSkinType() : 0;
            View inflate = LayoutInflater.from(this.mActivity).inflate(u.h.lottery_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(u.g.lottery_title);
            textView.setText(aVar.eax);
            com.baidu.tbadk.core.util.av.c(textView, u.d.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(u.g.lottery_des);
            textView2.setText(aVar.eay);
            com.baidu.tbadk.core.util.av.c(textView2, u.d.cp_cont_b, 1);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(u.g.lottery_image_bg);
            int c2 = com.baidu.adp.lib.util.k.c(this.mActivity, u.e.ds170);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tbImageView.getLayoutParams();
            layoutParams.width = (int) (c2 * 1.2272727272727273d);
            layoutParams.height = c2;
            tbImageView.setLayoutParams(layoutParams);
            TbImageView tbImageView2 = (TbImageView) inflate.findViewById(u.g.lottery_image);
            int c3 = com.baidu.adp.lib.util.k.c(this.mActivity, u.e.ds152);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) tbImageView2.getLayoutParams();
            layoutParams2.width = (int) (c3 * 1.2272727272727273d);
            layoutParams2.height = c3;
            tbImageView2.setLayoutParams(layoutParams2);
            tbImageView2.c(aVar.eaz, 10, false);
            y(inflate);
            a(aVar.eaB, aVar.eaD);
            b(aVar.eaA, aVar.eaC);
            aq(false);
            bO(1);
            b(aVar.aLK);
            com.baidu.tbadk.core.util.av.d(rT(), u.f.dialog_push_bg, skinType);
            rS();
        }
    }

    public void a(d dVar) {
        if (dVar != null) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(u.h.pb_three_row_text_dlg, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(u.g.first_row);
            textView.setText(dVar.eaG);
            com.baidu.tbadk.core.util.av.c(textView, u.d.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(u.g.second_row);
            textView2.setText(dVar.eaH);
            com.baidu.tbadk.core.util.av.c(textView2, u.d.cp_cont_b, 1);
            TextView textView3 = (TextView) inflate.findViewById(u.g.third_row);
            textView3.setText(dVar.eaI);
            com.baidu.tbadk.core.util.av.c(textView3, u.d.cp_cont_b, 1);
            y(inflate);
            a(dVar.eaB, dVar.eaD);
            b(dVar.eaA, dVar.eaC);
            aq(false);
            b(dVar.aLK).rS();
        }
    }
}
