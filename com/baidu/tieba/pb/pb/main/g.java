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
public class g extends com.baidu.tbadk.core.dialog.a {

    /* loaded from: classes.dex */
    public static class a extends b {
        public String dil = null;
        public String dim = null;
        public String din = null;
    }

    /* loaded from: classes.dex */
    public static class b {
        public com.baidu.adp.base.h<?> bLj;
        public String dio = null;
        public String dip = null;
        public a.b diq = null;
        public a.b dir = null;
    }

    /* loaded from: classes.dex */
    public static class c extends b {
        public String dis = null;
        public String dit = null;
    }

    /* loaded from: classes.dex */
    public static class d extends b {
        public CharSequence diu = null;
        public CharSequence div = null;
        public CharSequence diw = null;
    }

    public g(Activity activity) {
        super(activity);
    }

    public void a(c cVar) {
        if (cVar != null) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(t.h.pb_dlg_txt, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(t.g.tip_top);
            textView.setText(cVar.dis);
            com.baidu.tbadk.core.util.at.c(textView, t.d.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(t.g.tip_bottom);
            textView2.setText(cVar.dit);
            com.baidu.tbadk.core.util.at.c(textView2, t.d.cp_cont_b, 1);
            z(inflate);
            a(cVar.dip, cVar.dir);
            b(cVar.dio, cVar.diq);
            aq(false);
            b(cVar.bLj).rV();
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            int skinType = isAutoNight() ? TbadkCoreApplication.m11getInst().getSkinType() : 0;
            View inflate = LayoutInflater.from(this.mActivity).inflate(t.h.lottery_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(t.g.lottery_title);
            textView.setText(aVar.dil);
            com.baidu.tbadk.core.util.at.c(textView, t.d.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(t.g.lottery_des);
            textView2.setText(aVar.dim);
            com.baidu.tbadk.core.util.at.c(textView2, t.d.cp_cont_b, 1);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(t.g.lottery_image_bg);
            int c2 = com.baidu.adp.lib.util.k.c(this.mActivity, t.e.ds170);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tbImageView.getLayoutParams();
            layoutParams.width = (int) (c2 * 1.2272727272727273d);
            layoutParams.height = c2;
            tbImageView.setLayoutParams(layoutParams);
            TbImageView tbImageView2 = (TbImageView) inflate.findViewById(t.g.lottery_image);
            int c3 = com.baidu.adp.lib.util.k.c(this.mActivity, t.e.ds152);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) tbImageView2.getLayoutParams();
            layoutParams2.width = (int) (c3 * 1.2272727272727273d);
            layoutParams2.height = c3;
            tbImageView2.setLayoutParams(layoutParams2);
            tbImageView2.c(aVar.din, 10, false);
            z(inflate);
            a(aVar.dip, aVar.dir);
            b(aVar.dio, aVar.diq);
            aq(false);
            bN(1);
            b(aVar.bLj);
            com.baidu.tbadk.core.util.at.d(rW(), t.f.dialog_push_bg, skinType);
            rV();
        }
    }

    public void a(d dVar) {
        if (dVar != null) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(t.h.pb_three_row_text_dlg, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(t.g.first_row);
            textView.setText(dVar.diu);
            com.baidu.tbadk.core.util.at.c(textView, t.d.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(t.g.second_row);
            textView2.setText(dVar.div);
            com.baidu.tbadk.core.util.at.c(textView2, t.d.cp_cont_b, 1);
            TextView textView3 = (TextView) inflate.findViewById(t.g.third_row);
            textView3.setText(dVar.diw);
            com.baidu.tbadk.core.util.at.c(textView3, t.d.cp_cont_b, 1);
            z(inflate);
            a(dVar.dip, dVar.dir);
            b(dVar.dio, dVar.diq);
            aq(false);
            b(dVar.bLj).rV();
        }
    }
}
