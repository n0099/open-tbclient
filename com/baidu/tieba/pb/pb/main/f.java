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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.core.dialog.a {

    /* loaded from: classes.dex */
    public static class a extends b {
        public String eGF = null;
        public String eGG = null;
        public String cEV = null;
    }

    /* loaded from: classes.dex */
    public static class b {
        public String eGH = null;
        public String eGI = null;
        public a.b eGJ = null;
        public a.b eGK = null;
        public com.baidu.adp.base.e<?> mPageContext;
    }

    /* loaded from: classes.dex */
    public static class c extends b {
        public String eGL = null;
        public String eGM = null;
    }

    /* loaded from: classes.dex */
    public static class d extends b {
        public CharSequence eGN = null;
        public CharSequence eGO = null;
        public CharSequence eGP = null;
    }

    public f(Activity activity) {
        super(activity);
    }

    public void a(c cVar) {
        if (cVar != null) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.j.pb_dlg_txt, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.h.tip_top);
            textView.setText(cVar.eGL);
            com.baidu.tbadk.core.util.ai.c(textView, d.e.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(d.h.tip_bottom);
            textView2.setText(cVar.eGM);
            com.baidu.tbadk.core.util.ai.c(textView2, d.e.cp_cont_b, 1);
            v(inflate);
            a(cVar.eGI, cVar.eGK);
            b(cVar.eGH, cVar.eGJ);
            as(false);
            b(cVar.mPageContext).tr();
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.j.lottery_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.h.lottery_title);
            textView.setText(aVar.eGF);
            com.baidu.tbadk.core.util.ai.c(textView, d.e.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(d.h.lottery_des);
            textView2.setText(aVar.eGG);
            com.baidu.tbadk.core.util.ai.c(textView2, d.e.cp_cont_b, 1);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(d.h.lottery_image_bg);
            int g = com.baidu.adp.lib.util.k.g(this.mActivity, d.f.ds170);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tbImageView.getLayoutParams();
            layoutParams.width = (int) (g * 1.2272727272727273d);
            layoutParams.height = g;
            tbImageView.setLayoutParams(layoutParams);
            TbImageView tbImageView2 = (TbImageView) inflate.findViewById(d.h.lottery_image);
            int g2 = com.baidu.adp.lib.util.k.g(this.mActivity, d.f.ds152);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) tbImageView2.getLayoutParams();
            layoutParams2.width = (int) (g2 * 1.2272727272727273d);
            layoutParams2.height = g2;
            tbImageView2.setLayoutParams(layoutParams2);
            tbImageView2.c(aVar.cEV, 10, false);
            v(inflate);
            a(aVar.eGI, aVar.eGK);
            b(aVar.eGH, aVar.eGJ);
            as(false);
            ce(1);
            b(aVar.mPageContext);
            com.baidu.tbadk.core.util.ai.d(ts(), d.g.dialog_push_bg, skinType);
            tr();
        }
    }

    public void a(d dVar) {
        if (dVar != null) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.j.pb_three_row_text_dlg, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.h.first_row);
            textView.setText(dVar.eGN);
            com.baidu.tbadk.core.util.ai.c(textView, d.e.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(d.h.second_row);
            textView2.setText(dVar.eGO);
            com.baidu.tbadk.core.util.ai.c(textView2, d.e.cp_cont_b, 1);
            TextView textView3 = (TextView) inflate.findViewById(d.h.third_row);
            textView3.setText(dVar.eGP);
            com.baidu.tbadk.core.util.ai.c(textView3, d.e.cp_cont_b, 1);
            v(inflate);
            a(dVar.eGI, dVar.eGK);
            b(dVar.eGH, dVar.eGJ);
            as(false);
            b(dVar.mPageContext).tr();
        }
    }
}
