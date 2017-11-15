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
public class g extends com.baidu.tbadk.core.dialog.a {

    /* loaded from: classes.dex */
    public static class a extends b {
        public String eKe = null;
        public String eKf = null;
        public String cYu = null;
    }

    /* loaded from: classes.dex */
    public static class b {
        public String eKg = null;
        public String eKh = null;
        public a.b eKi = null;
        public a.b eKj = null;
        public com.baidu.adp.base.e<?> mPageContext;
    }

    /* loaded from: classes.dex */
    public static class c extends b {
        public String eKk = null;
        public String eKl = null;
    }

    /* loaded from: classes.dex */
    public static class d extends b {
        public CharSequence eKm = null;
        public CharSequence eKn = null;
        public CharSequence eKo = null;
    }

    public g(Activity activity) {
        super(activity);
    }

    public void a(c cVar) {
        if (cVar != null) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.h.pb_dlg_txt, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.g.tip_top);
            textView.setText(cVar.eKk);
            com.baidu.tbadk.core.util.aj.c(textView, d.C0080d.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(d.g.tip_bottom);
            textView2.setText(cVar.eKl);
            com.baidu.tbadk.core.util.aj.c(textView2, d.C0080d.cp_cont_b, 1);
            v(inflate);
            a(cVar.eKh, cVar.eKj);
            b(cVar.eKg, cVar.eKi);
            ap(false);
            b(cVar.mPageContext).th();
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.h.lottery_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.g.lottery_title);
            textView.setText(aVar.eKe);
            com.baidu.tbadk.core.util.aj.c(textView, d.C0080d.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(d.g.lottery_des);
            textView2.setText(aVar.eKf);
            com.baidu.tbadk.core.util.aj.c(textView2, d.C0080d.cp_cont_b, 1);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(d.g.lottery_image_bg);
            int f = com.baidu.adp.lib.util.l.f(this.mActivity, d.e.ds170);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tbImageView.getLayoutParams();
            layoutParams.width = (int) (f * 1.2272727272727273d);
            layoutParams.height = f;
            tbImageView.setLayoutParams(layoutParams);
            TbImageView tbImageView2 = (TbImageView) inflate.findViewById(d.g.lottery_image);
            int f2 = com.baidu.adp.lib.util.l.f(this.mActivity, d.e.ds152);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) tbImageView2.getLayoutParams();
            layoutParams2.width = (int) (f2 * 1.2272727272727273d);
            layoutParams2.height = f2;
            tbImageView2.setLayoutParams(layoutParams2);
            tbImageView2.startLoad(aVar.cYu, 10, false);
            v(inflate);
            a(aVar.eKh, aVar.eKj);
            b(aVar.eKg, aVar.eKi);
            ap(false);
            ce(1);
            b(aVar.mPageContext);
            com.baidu.tbadk.core.util.aj.d(ti(), d.f.dialog_push_bg, skinType);
            th();
        }
    }

    public void a(d dVar) {
        if (dVar != null) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.h.pb_three_row_text_dlg, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.g.first_row);
            textView.setText(dVar.eKm);
            com.baidu.tbadk.core.util.aj.c(textView, d.C0080d.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(d.g.second_row);
            textView2.setText(dVar.eKn);
            com.baidu.tbadk.core.util.aj.c(textView2, d.C0080d.cp_cont_b, 1);
            TextView textView3 = (TextView) inflate.findViewById(d.g.third_row);
            textView3.setText(dVar.eKo);
            com.baidu.tbadk.core.util.aj.c(textView3, d.C0080d.cp_cont_b, 1);
            v(inflate);
            a(dVar.eKh, dVar.eKj);
            b(dVar.eKg, dVar.eKi);
            ap(false);
            b(dVar.mPageContext).th();
        }
    }
}
