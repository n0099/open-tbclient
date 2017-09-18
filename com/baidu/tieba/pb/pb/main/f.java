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
        public String eHP = null;
        public String eHQ = null;
        public String cOb = null;
    }

    /* loaded from: classes.dex */
    public static class b {
        public String eHR = null;
        public String eHS = null;
        public a.b eHT = null;
        public a.b eHU = null;
        public com.baidu.adp.base.e<?> mPageContext;
    }

    /* loaded from: classes.dex */
    public static class c extends b {
        public String eHV = null;
        public String eHW = null;
    }

    /* loaded from: classes.dex */
    public static class d extends b {
        public CharSequence eHX = null;
        public CharSequence eHY = null;
        public CharSequence eHZ = null;
    }

    public f(Activity activity) {
        super(activity);
    }

    public void a(c cVar) {
        if (cVar != null) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.j.pb_dlg_txt, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.h.tip_top);
            textView.setText(cVar.eHV);
            com.baidu.tbadk.core.util.aj.c(textView, d.e.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(d.h.tip_bottom);
            textView2.setText(cVar.eHW);
            com.baidu.tbadk.core.util.aj.c(textView2, d.e.cp_cont_b, 1);
            v(inflate);
            a(cVar.eHS, cVar.eHU);
            b(cVar.eHR, cVar.eHT);
            as(false);
            b(cVar.mPageContext).to();
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.j.lottery_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.h.lottery_title);
            textView.setText(aVar.eHP);
            com.baidu.tbadk.core.util.aj.c(textView, d.e.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(d.h.lottery_des);
            textView2.setText(aVar.eHQ);
            com.baidu.tbadk.core.util.aj.c(textView2, d.e.cp_cont_b, 1);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(d.h.lottery_image_bg);
            int f = com.baidu.adp.lib.util.k.f(this.mActivity, d.f.ds170);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tbImageView.getLayoutParams();
            layoutParams.width = (int) (f * 1.2272727272727273d);
            layoutParams.height = f;
            tbImageView.setLayoutParams(layoutParams);
            TbImageView tbImageView2 = (TbImageView) inflate.findViewById(d.h.lottery_image);
            int f2 = com.baidu.adp.lib.util.k.f(this.mActivity, d.f.ds152);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) tbImageView2.getLayoutParams();
            layoutParams2.width = (int) (f2 * 1.2272727272727273d);
            layoutParams2.height = f2;
            tbImageView2.setLayoutParams(layoutParams2);
            tbImageView2.c(aVar.cOb, 10, false);
            v(inflate);
            a(aVar.eHS, aVar.eHU);
            b(aVar.eHR, aVar.eHT);
            as(false);
            ce(1);
            b(aVar.mPageContext);
            com.baidu.tbadk.core.util.aj.d(tp(), d.g.dialog_push_bg, skinType);
            to();
        }
    }

    public void a(d dVar) {
        if (dVar != null) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.j.pb_three_row_text_dlg, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.h.first_row);
            textView.setText(dVar.eHX);
            com.baidu.tbadk.core.util.aj.c(textView, d.e.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(d.h.second_row);
            textView2.setText(dVar.eHY);
            com.baidu.tbadk.core.util.aj.c(textView2, d.e.cp_cont_b, 1);
            TextView textView3 = (TextView) inflate.findViewById(d.h.third_row);
            textView3.setText(dVar.eHZ);
            com.baidu.tbadk.core.util.aj.c(textView3, d.e.cp_cont_b, 1);
            v(inflate);
            a(dVar.eHS, dVar.eHU);
            b(dVar.eHR, dVar.eHT);
            as(false);
            b(dVar.mPageContext).to();
        }
    }
}
