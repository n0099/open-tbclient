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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.core.dialog.a {

    /* loaded from: classes.dex */
    public static class a extends b {
        public String ekB = null;
        public String ekC = null;
        public String ekD = null;
    }

    /* loaded from: classes.dex */
    public static class b {
        public String ekE = null;
        public String ekF = null;
        public a.b ekG = null;
        public a.b ekH = null;
        public com.baidu.adp.base.g<?> mPageContext;
    }

    /* loaded from: classes.dex */
    public static class c extends b {
        public String ekI = null;
        public String ekJ = null;
    }

    /* loaded from: classes.dex */
    public static class d extends b {
        public CharSequence ekK = null;
        public CharSequence ekL = null;
        public CharSequence ekM = null;
    }

    public h(Activity activity) {
        super(activity);
    }

    public void a(c cVar) {
        if (cVar != null) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(w.j.pb_dlg_txt, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(w.h.tip_top);
            textView.setText(cVar.ekI);
            com.baidu.tbadk.core.util.aq.c(textView, w.e.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(w.h.tip_bottom);
            textView2.setText(cVar.ekJ);
            com.baidu.tbadk.core.util.aq.c(textView2, w.e.cp_cont_b, 1);
            v(inflate);
            a(cVar.ekF, cVar.ekH);
            b(cVar.ekE, cVar.ekG);
            aw(false);
            b(cVar.mPageContext).tQ();
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            int skinType = isAutoNight() ? TbadkCoreApplication.m9getInst().getSkinType() : 0;
            View inflate = LayoutInflater.from(this.mActivity).inflate(w.j.lottery_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(w.h.lottery_title);
            textView.setText(aVar.ekB);
            com.baidu.tbadk.core.util.aq.c(textView, w.e.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(w.h.lottery_des);
            textView2.setText(aVar.ekC);
            com.baidu.tbadk.core.util.aq.c(textView2, w.e.cp_cont_b, 1);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(w.h.lottery_image_bg);
            int g = com.baidu.adp.lib.util.k.g(this.mActivity, w.f.ds170);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tbImageView.getLayoutParams();
            layoutParams.width = (int) (g * 1.2272727272727273d);
            layoutParams.height = g;
            tbImageView.setLayoutParams(layoutParams);
            TbImageView tbImageView2 = (TbImageView) inflate.findViewById(w.h.lottery_image);
            int g2 = com.baidu.adp.lib.util.k.g(this.mActivity, w.f.ds152);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) tbImageView2.getLayoutParams();
            layoutParams2.width = (int) (g2 * 1.2272727272727273d);
            layoutParams2.height = g2;
            tbImageView2.setLayoutParams(layoutParams2);
            tbImageView2.c(aVar.ekD, 10, false);
            v(inflate);
            a(aVar.ekF, aVar.ekH);
            b(aVar.ekE, aVar.ekG);
            aw(false);
            cb(1);
            b(aVar.mPageContext);
            com.baidu.tbadk.core.util.aq.d(tR(), w.g.dialog_push_bg, skinType);
            tQ();
        }
    }

    public void a(d dVar) {
        if (dVar != null) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(w.j.pb_three_row_text_dlg, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(w.h.first_row);
            textView.setText(dVar.ekK);
            com.baidu.tbadk.core.util.aq.c(textView, w.e.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(w.h.second_row);
            textView2.setText(dVar.ekL);
            com.baidu.tbadk.core.util.aq.c(textView2, w.e.cp_cont_b, 1);
            TextView textView3 = (TextView) inflate.findViewById(w.h.third_row);
            textView3.setText(dVar.ekM);
            com.baidu.tbadk.core.util.aq.c(textView3, w.e.cp_cont_b, 1);
            v(inflate);
            a(dVar.ekF, dVar.ekH);
            b(dVar.ekE, dVar.ekG);
            aw(false);
            b(dVar.mPageContext).tQ();
        }
    }
}
