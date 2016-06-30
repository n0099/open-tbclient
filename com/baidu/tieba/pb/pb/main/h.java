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
        public String dOk = null;
        public String dOl = null;
        public String dOm = null;
    }

    /* loaded from: classes.dex */
    public static class b {
        public com.baidu.adp.base.h<?> aKR;
        public String dOn = null;
        public String dOo = null;
        public a.b dOp = null;
        public a.b dOq = null;
    }

    /* loaded from: classes.dex */
    public static class c extends b {
        public String dOr = null;
        public String dOs = null;
    }

    /* loaded from: classes.dex */
    public static class d extends b {
        public CharSequence dOt = null;
        public CharSequence dOu = null;
        public CharSequence dOv = null;
    }

    public h(Activity activity) {
        super(activity);
    }

    public void a(c cVar) {
        if (cVar != null) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(u.h.pb_dlg_txt, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(u.g.tip_top);
            textView.setText(cVar.dOr);
            com.baidu.tbadk.core.util.av.c(textView, u.d.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(u.g.tip_bottom);
            textView2.setText(cVar.dOs);
            com.baidu.tbadk.core.util.av.c(textView2, u.d.cp_cont_b, 1);
            y(inflate);
            a(cVar.dOo, cVar.dOq);
            b(cVar.dOn, cVar.dOp);
            ao(false);
            b(cVar.aKR).rT();
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            int skinType = isAutoNight() ? TbadkCoreApplication.m9getInst().getSkinType() : 0;
            View inflate = LayoutInflater.from(this.mActivity).inflate(u.h.lottery_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(u.g.lottery_title);
            textView.setText(aVar.dOk);
            com.baidu.tbadk.core.util.av.c(textView, u.d.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(u.g.lottery_des);
            textView2.setText(aVar.dOl);
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
            tbImageView2.c(aVar.dOm, 10, false);
            y(inflate);
            a(aVar.dOo, aVar.dOq);
            b(aVar.dOn, aVar.dOp);
            ao(false);
            bO(1);
            b(aVar.aKR);
            com.baidu.tbadk.core.util.av.d(rU(), u.f.dialog_push_bg, skinType);
            rT();
        }
    }

    public void a(d dVar) {
        if (dVar != null) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(u.h.pb_three_row_text_dlg, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(u.g.first_row);
            textView.setText(dVar.dOt);
            com.baidu.tbadk.core.util.av.c(textView, u.d.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(u.g.second_row);
            textView2.setText(dVar.dOu);
            com.baidu.tbadk.core.util.av.c(textView2, u.d.cp_cont_b, 1);
            TextView textView3 = (TextView) inflate.findViewById(u.g.third_row);
            textView3.setText(dVar.dOv);
            com.baidu.tbadk.core.util.av.c(textView3, u.d.cp_cont_b, 1);
            y(inflate);
            a(dVar.dOo, dVar.dOq);
            b(dVar.dOn, dVar.dOp);
            ao(false);
            b(dVar.aKR).rT();
        }
    }
}
