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
        public String eGV = null;
        public String eGW = null;
        public String cNh = null;
    }

    /* loaded from: classes.dex */
    public static class b {
        public String eGX = null;
        public String eGY = null;
        public a.b eGZ = null;
        public a.b eHa = null;
        public com.baidu.adp.base.e<?> mPageContext;
    }

    /* loaded from: classes.dex */
    public static class c extends b {
        public String eHb = null;
        public String eHc = null;
    }

    /* loaded from: classes.dex */
    public static class d extends b {
        public CharSequence eHd = null;
        public CharSequence eHe = null;
        public CharSequence eHf = null;
    }

    public f(Activity activity) {
        super(activity);
    }

    public void a(c cVar) {
        if (cVar != null) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.j.pb_dlg_txt, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.h.tip_top);
            textView.setText(cVar.eHb);
            com.baidu.tbadk.core.util.aj.c(textView, d.e.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(d.h.tip_bottom);
            textView2.setText(cVar.eHc);
            com.baidu.tbadk.core.util.aj.c(textView2, d.e.cp_cont_b, 1);
            v(inflate);
            a(cVar.eGY, cVar.eHa);
            b(cVar.eGX, cVar.eGZ);
            as(false);
            b(cVar.mPageContext).to();
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.j.lottery_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.h.lottery_title);
            textView.setText(aVar.eGV);
            com.baidu.tbadk.core.util.aj.c(textView, d.e.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(d.h.lottery_des);
            textView2.setText(aVar.eGW);
            com.baidu.tbadk.core.util.aj.c(textView2, d.e.cp_cont_b, 1);
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
            tbImageView2.c(aVar.cNh, 10, false);
            v(inflate);
            a(aVar.eGY, aVar.eHa);
            b(aVar.eGX, aVar.eGZ);
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
            textView.setText(dVar.eHd);
            com.baidu.tbadk.core.util.aj.c(textView, d.e.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(d.h.second_row);
            textView2.setText(dVar.eHe);
            com.baidu.tbadk.core.util.aj.c(textView2, d.e.cp_cont_b, 1);
            TextView textView3 = (TextView) inflate.findViewById(d.h.third_row);
            textView3.setText(dVar.eHf);
            com.baidu.tbadk.core.util.aj.c(textView3, d.e.cp_cont_b, 1);
            v(inflate);
            a(dVar.eGY, dVar.eHa);
            b(dVar.eGX, dVar.eGZ);
            as(false);
            b(dVar.mPageContext).to();
        }
    }
}
