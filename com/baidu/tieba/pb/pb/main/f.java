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
        public String eIz = null;
        public String eIA = null;
        public String cGS = null;
    }

    /* loaded from: classes.dex */
    public static class b {
        public String eIB = null;
        public String eIC = null;
        public a.b eID = null;
        public a.b eIE = null;
        public com.baidu.adp.base.e<?> mPageContext;
    }

    /* loaded from: classes.dex */
    public static class c extends b {
        public String eIF = null;
        public String eIG = null;
    }

    /* loaded from: classes.dex */
    public static class d extends b {
        public CharSequence eIH = null;
        public CharSequence eII = null;
        public CharSequence eIJ = null;
    }

    public f(Activity activity) {
        super(activity);
    }

    public void a(c cVar) {
        if (cVar != null) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.j.pb_dlg_txt, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.h.tip_top);
            textView.setText(cVar.eIF);
            com.baidu.tbadk.core.util.ai.c(textView, d.e.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(d.h.tip_bottom);
            textView2.setText(cVar.eIG);
            com.baidu.tbadk.core.util.ai.c(textView2, d.e.cp_cont_b, 1);
            v(inflate);
            a(cVar.eIC, cVar.eIE);
            b(cVar.eIB, cVar.eID);
            as(false);
            b(cVar.mPageContext).tr();
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.j.lottery_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.h.lottery_title);
            textView.setText(aVar.eIz);
            com.baidu.tbadk.core.util.ai.c(textView, d.e.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(d.h.lottery_des);
            textView2.setText(aVar.eIA);
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
            tbImageView2.c(aVar.cGS, 10, false);
            v(inflate);
            a(aVar.eIC, aVar.eIE);
            b(aVar.eIB, aVar.eID);
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
            textView.setText(dVar.eIH);
            com.baidu.tbadk.core.util.ai.c(textView, d.e.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(d.h.second_row);
            textView2.setText(dVar.eII);
            com.baidu.tbadk.core.util.ai.c(textView2, d.e.cp_cont_b, 1);
            TextView textView3 = (TextView) inflate.findViewById(d.h.third_row);
            textView3.setText(dVar.eIJ);
            com.baidu.tbadk.core.util.ai.c(textView3, d.e.cp_cont_b, 1);
            v(inflate);
            a(dVar.eIC, dVar.eIE);
            b(dVar.eIB, dVar.eID);
            as(false);
            b(dVar.mPageContext).tr();
        }
    }
}
