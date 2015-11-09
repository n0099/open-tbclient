package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.core.dialog.a {
    public c(Activity activity) {
        super(activity);
    }

    public void a(C0072c c0072c) {
        if (c0072c != null && c0072c.afF()) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(i.g.pb_dlg_img_txt, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(i.f.tip_top);
            textView.setText(c0072c.ciX);
            com.baidu.tbadk.core.util.an.b(textView, i.c.cp_cont_c, 1);
            TextView textView2 = (TextView) inflate.findViewById(i.f.tip_bottom);
            textView2.setText(c0072c.ciR);
            com.baidu.tbadk.core.util.an.b(textView2, i.c.cp_cont_c, 1);
            com.baidu.tbadk.core.util.an.c((ImageView) inflate.findViewById(i.f.tip_img), i.e.pic_orange_tanhao);
            m(inflate);
            a(c0072c.ciU, c0072c.ciW);
            b(c0072c.ciT, c0072c.ciV);
            ak(false);
            b(c0072c.ciS).sR();
        }
    }

    public void b(C0072c c0072c) {
        if (c0072c != null && c0072c.afF()) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(i.g.pb_dlg_txt, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(i.f.tip_top);
            textView.setText(c0072c.ciX);
            com.baidu.tbadk.core.util.an.b(textView, i.c.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(i.f.tip_bottom);
            textView2.setText(c0072c.ciR);
            com.baidu.tbadk.core.util.an.b(textView2, i.c.cp_cont_b, 1);
            m(inflate);
            a(c0072c.ciU, c0072c.ciW);
            b(c0072c.ciT, c0072c.ciV);
            ak(false);
            b(c0072c.ciS).sR();
        }
    }

    public void a(a aVar) {
        if (aVar != null && aVar.afF()) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(i.g.pb_dlg_multi, (ViewGroup) null);
            com.baidu.tbadk.core.util.an.b((TextView) inflate.findViewById(i.f.tip_title), i.c.cp_cont_b, 1);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(i.f.inner_img_txt_layout);
            com.baidu.tbadk.core.util.an.i(linearLayout, i.e.bg_lottery_win);
            TbImageView tbImageView = (TbImageView) linearLayout.findViewById(i.f.tip_img);
            tbImageView.setDefaultBgResource(0);
            tbImageView.d(aVar.ciP, 10, false);
            LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(i.f.inner_text_layout);
            TextView textView = (TextView) linearLayout2.findViewById(i.f.inner_text_bottom);
            if (!com.baidu.tbadk.core.util.as.isEmpty(aVar.ciR)) {
                textView.setText(aVar.ciR);
            }
            com.baidu.tbadk.core.util.an.b(textView, i.c.cp_cont_c, 1);
            TextView textView2 = (TextView) linearLayout2.findViewById(i.f.inner_text_top);
            textView2.setText(aVar.ciQ);
            com.baidu.tbadk.core.util.an.b(textView2, i.c.cp_cont_b, 1);
            m(inflate);
            a(aVar.ciU, aVar.ciW);
            b(aVar.ciT, aVar.ciV);
            ak(false);
            bH(1);
            b(aVar.ciS).sR();
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public com.baidu.adp.base.h<?> ciS;
        public String ciT = null;
        public String ciU = null;
        public a.b ciV = null;
        public a.b ciW = null;

        public boolean afF() {
            if (this.ciS == null || com.baidu.tbadk.core.util.as.isEmpty(this.ciT) || com.baidu.tbadk.core.util.as.isEmpty(this.ciU) || this.ciV == null || this.ciW == null) {
                BdLog.e("PbActDialog: wrong paras!");
                return false;
            }
            return true;
        }
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0072c extends b {
        public String ciX = null;
        public String ciR = null;

        @Override // com.baidu.tieba.pb.pb.main.c.b
        public boolean afF() {
            if (super.afF()) {
                if (com.baidu.tbadk.core.util.as.isEmpty(this.ciX) || com.baidu.tbadk.core.util.as.isEmpty(this.ciR)) {
                    BdLog.e("PbActDialog: wrong paras!");
                    return false;
                }
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends b {
        public String ciP = null;
        public String ciQ = null;
        public String ciR = null;

        @Override // com.baidu.tieba.pb.pb.main.c.b
        public boolean afF() {
            if (super.afF()) {
                if (com.baidu.tbadk.core.util.as.isEmpty(this.ciP) || com.baidu.tbadk.core.util.as.isEmpty(this.ciQ)) {
                    BdLog.e("PbActDialog: wrong paras!");
                    return false;
                }
                return true;
            }
            return false;
        }
    }
}
