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
/* loaded from: classes2.dex */
public class g extends com.baidu.tbadk.core.dialog.a {

    /* loaded from: classes2.dex */
    public static class a extends b {
        public String fGS = null;
        public String fGT = null;
        public String dVD = null;
    }

    /* loaded from: classes2.dex */
    public static class b {
        public String fGU = null;
        public String fGV = null;
        public a.b fGW = null;
        public a.b fGX = null;
        public com.baidu.adp.base.e<?> mPageContext;
    }

    /* loaded from: classes2.dex */
    public static class c extends b {
        public String fGY = null;
        public String fGZ = null;
    }

    /* loaded from: classes2.dex */
    public static class d extends b {
        public CharSequence fHa = null;
        public CharSequence fHb = null;
        public CharSequence fHc = null;
    }

    public g(Activity activity) {
        super(activity);
    }

    public void a(c cVar) {
        if (cVar != null) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.h.pb_dlg_txt, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.g.tip_top);
            textView.setText(cVar.fGY);
            com.baidu.tbadk.core.util.aj.e(textView, d.C0107d.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(d.g.tip_bottom);
            textView2.setText(cVar.fGZ);
            com.baidu.tbadk.core.util.aj.e(textView2, d.C0107d.cp_cont_b, 1);
            aO(inflate);
            a(cVar.fGV, cVar.fGX);
            b(cVar.fGU, cVar.fGW);
            aW(false);
            b(cVar.mPageContext).AA();
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            int skinType = isAutoNight() ? TbadkCoreApplication.getInst().getSkinType() : 0;
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.h.lottery_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.g.lottery_title);
            textView.setText(aVar.fGS);
            com.baidu.tbadk.core.util.aj.e(textView, d.C0107d.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(d.g.lottery_des);
            textView2.setText(aVar.fGT);
            com.baidu.tbadk.core.util.aj.e(textView2, d.C0107d.cp_cont_b, 1);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(d.g.lottery_image_bg);
            int s = com.baidu.adp.lib.util.l.s(this.mActivity, d.e.ds170);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tbImageView.getLayoutParams();
            layoutParams.width = (int) (s * 1.2272727272727273d);
            layoutParams.height = s;
            tbImageView.setLayoutParams(layoutParams);
            TbImageView tbImageView2 = (TbImageView) inflate.findViewById(d.g.lottery_image);
            int s2 = com.baidu.adp.lib.util.l.s(this.mActivity, d.e.ds152);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) tbImageView2.getLayoutParams();
            layoutParams2.width = (int) (s2 * 1.2272727272727273d);
            layoutParams2.height = s2;
            tbImageView2.setLayoutParams(layoutParams2);
            tbImageView2.startLoad(aVar.dVD, 10, false);
            aO(inflate);
            a(aVar.fGV, aVar.fGX);
            b(aVar.fGU, aVar.fGW);
            aW(false);
            fd(1);
            b(aVar.mPageContext);
            com.baidu.tbadk.core.util.aj.f(AB(), d.f.dialog_push_bg, skinType);
            AA();
        }
    }

    public void a(d dVar) {
        if (dVar != null) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.h.pb_three_row_text_dlg, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.g.first_row);
            textView.setText(dVar.fHa);
            com.baidu.tbadk.core.util.aj.e(textView, d.C0107d.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(d.g.second_row);
            textView2.setText(dVar.fHb);
            com.baidu.tbadk.core.util.aj.e(textView2, d.C0107d.cp_cont_b, 1);
            TextView textView3 = (TextView) inflate.findViewById(d.g.third_row);
            textView3.setText(dVar.fHc);
            com.baidu.tbadk.core.util.aj.e(textView3, d.C0107d.cp_cont_b, 1);
            aO(inflate);
            a(dVar.fGV, dVar.fGX);
            b(dVar.fGU, dVar.fGW);
            aW(false);
            b(dVar.mPageContext).AA();
        }
    }
}
