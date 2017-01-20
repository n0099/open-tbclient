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
        public String ehn = null;
        public String eho = null;
        public String ehp = null;
    }

    /* loaded from: classes.dex */
    public static class b {
        public String ehq = null;
        public String ehr = null;
        public a.b ehs = null;
        public a.b eht = null;
        public com.baidu.adp.base.g<?> mPageContext;
    }

    /* loaded from: classes.dex */
    public static class c extends b {
        public String ehu = null;
        public String ehv = null;
    }

    /* loaded from: classes.dex */
    public static class d extends b {
        public CharSequence ehw = null;
        public CharSequence ehx = null;
        public CharSequence ehy = null;
    }

    public h(Activity activity) {
        super(activity);
    }

    public void a(c cVar) {
        if (cVar != null) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(r.j.pb_dlg_txt, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(r.h.tip_top);
            textView.setText(cVar.ehu);
            com.baidu.tbadk.core.util.ap.c(textView, r.e.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(r.h.tip_bottom);
            textView2.setText(cVar.ehv);
            com.baidu.tbadk.core.util.ap.c(textView2, r.e.cp_cont_b, 1);
            x(inflate);
            a(cVar.ehr, cVar.eht);
            b(cVar.ehq, cVar.ehs);
            av(false);
            b(cVar.mPageContext).sV();
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            int skinType = isAutoNight() ? TbadkCoreApplication.m9getInst().getSkinType() : 0;
            View inflate = LayoutInflater.from(this.mActivity).inflate(r.j.lottery_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(r.h.lottery_title);
            textView.setText(aVar.ehn);
            com.baidu.tbadk.core.util.ap.c(textView, r.e.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(r.h.lottery_des);
            textView2.setText(aVar.eho);
            com.baidu.tbadk.core.util.ap.c(textView2, r.e.cp_cont_b, 1);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(r.h.lottery_image_bg);
            int e = com.baidu.adp.lib.util.k.e(this.mActivity, r.f.ds170);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tbImageView.getLayoutParams();
            layoutParams.width = (int) (e * 1.2272727272727273d);
            layoutParams.height = e;
            tbImageView.setLayoutParams(layoutParams);
            TbImageView tbImageView2 = (TbImageView) inflate.findViewById(r.h.lottery_image);
            int e2 = com.baidu.adp.lib.util.k.e(this.mActivity, r.f.ds152);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) tbImageView2.getLayoutParams();
            layoutParams2.width = (int) (e2 * 1.2272727272727273d);
            layoutParams2.height = e2;
            tbImageView2.setLayoutParams(layoutParams2);
            tbImageView2.c(aVar.ehp, 10, false);
            x(inflate);
            a(aVar.ehr, aVar.eht);
            b(aVar.ehq, aVar.ehs);
            av(false);
            cc(1);
            b(aVar.mPageContext);
            com.baidu.tbadk.core.util.ap.d(sW(), r.g.dialog_push_bg, skinType);
            sV();
        }
    }

    public void a(d dVar) {
        if (dVar != null) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(r.j.pb_three_row_text_dlg, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(r.h.first_row);
            textView.setText(dVar.ehw);
            com.baidu.tbadk.core.util.ap.c(textView, r.e.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(r.h.second_row);
            textView2.setText(dVar.ehx);
            com.baidu.tbadk.core.util.ap.c(textView2, r.e.cp_cont_b, 1);
            TextView textView3 = (TextView) inflate.findViewById(r.h.third_row);
            textView3.setText(dVar.ehy);
            com.baidu.tbadk.core.util.ap.c(textView3, r.e.cp_cont_b, 1);
            x(inflate);
            a(dVar.ehr, dVar.eht);
            b(dVar.ehq, dVar.ehs);
            av(false);
            b(dVar.mPageContext).sV();
        }
    }
}
