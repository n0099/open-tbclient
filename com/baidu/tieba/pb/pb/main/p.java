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
public class p extends com.baidu.tbadk.core.dialog.a {

    /* loaded from: classes.dex */
    public static class a extends b {
        public String dfY = null;
        public String dfZ = null;
        public String dga = null;
    }

    /* loaded from: classes.dex */
    public static class b {
        public com.baidu.adp.base.h<?> bLb;
        public String dgb = null;
        public String dgc = null;
        public a.b dgd = null;
        public a.b dge = null;
    }

    /* loaded from: classes.dex */
    public static class c extends b {
        public String dgf = null;
        public String dgg = null;
    }

    /* loaded from: classes.dex */
    public static class d extends b {
        public CharSequence dgh = null;
        public CharSequence dgi = null;
        public CharSequence dgj = null;
    }

    public p(Activity activity) {
        super(activity);
    }

    public void a(c cVar) {
        if (cVar != null) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(t.h.pb_dlg_txt, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(t.g.tip_top);
            textView.setText(cVar.dgf);
            com.baidu.tbadk.core.util.at.b(textView, t.d.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(t.g.tip_bottom);
            textView2.setText(cVar.dgg);
            com.baidu.tbadk.core.util.at.b(textView2, t.d.cp_cont_b, 1);
            z(inflate);
            a(cVar.dgc, cVar.dge);
            b(cVar.dgb, cVar.dgd);
            an(false);
            b(cVar.bLb).up();
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            int skinType = isAutoNight() ? TbadkCoreApplication.m411getInst().getSkinType() : 0;
            View inflate = LayoutInflater.from(this.mActivity).inflate(t.h.lottery_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(t.g.lottery_title);
            textView.setText(aVar.dfY);
            com.baidu.tbadk.core.util.at.b(textView, t.d.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(t.g.lottery_des);
            textView2.setText(aVar.dfZ);
            com.baidu.tbadk.core.util.at.b(textView2, t.d.cp_cont_b, 1);
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
            tbImageView2.c(aVar.dga, 10, false);
            z(inflate);
            a(aVar.dgc, aVar.dge);
            b(aVar.dgb, aVar.dgd);
            an(false);
            cc(1);
            b(aVar.bLb);
            com.baidu.tbadk.core.util.at.c(uq(), t.f.dialog_push_bg, skinType);
            up();
        }
    }

    public void a(d dVar) {
        if (dVar != null) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(t.h.pb_three_row_text_dlg, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(t.g.first_row);
            textView.setText(dVar.dgh);
            com.baidu.tbadk.core.util.at.b(textView, t.d.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(t.g.second_row);
            textView2.setText(dVar.dgi);
            com.baidu.tbadk.core.util.at.b(textView2, t.d.cp_cont_b, 1);
            TextView textView3 = (TextView) inflate.findViewById(t.g.third_row);
            textView3.setText(dVar.dgj);
            com.baidu.tbadk.core.util.at.b(textView3, t.d.cp_cont_b, 1);
            z(inflate);
            a(dVar.dgc, dVar.dge);
            b(dVar.dgb, dVar.dgd);
            an(false);
            b(dVar.bLb).up();
        }
    }
}
