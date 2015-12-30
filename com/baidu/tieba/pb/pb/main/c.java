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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.core.dialog.a {
    public c(Activity activity) {
        super(activity);
    }

    public void a(C0075c c0075c) {
        if (c0075c != null && c0075c.ale()) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(n.h.pb_dlg_img_txt, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(n.g.tip_top);
            textView.setText(c0075c.cEY);
            com.baidu.tbadk.core.util.as.b(textView, n.d.cp_cont_c, 1);
            TextView textView2 = (TextView) inflate.findViewById(n.g.tip_bottom);
            textView2.setText(c0075c.cES);
            com.baidu.tbadk.core.util.as.b(textView2, n.d.cp_cont_c, 1);
            com.baidu.tbadk.core.util.as.c((ImageView) inflate.findViewById(n.g.tip_img), n.f.pic_orange_tanhao);
            m(inflate);
            a(c0075c.cEV, c0075c.cEX);
            b(c0075c.cEU, c0075c.cEW);
            aj(false);
            b(c0075c.cET).tf();
        }
    }

    public void b(C0075c c0075c) {
        if (c0075c != null && c0075c.ale()) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(n.h.pb_dlg_txt, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(n.g.tip_top);
            textView.setText(c0075c.cEY);
            com.baidu.tbadk.core.util.as.b(textView, n.d.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(n.g.tip_bottom);
            textView2.setText(c0075c.cES);
            com.baidu.tbadk.core.util.as.b(textView2, n.d.cp_cont_b, 1);
            m(inflate);
            a(c0075c.cEV, c0075c.cEX);
            b(c0075c.cEU, c0075c.cEW);
            aj(false);
            b(c0075c.cET).tf();
        }
    }

    public void a(a aVar) {
        if (aVar != null && aVar.ale()) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(n.h.pb_dlg_multi, (ViewGroup) null);
            com.baidu.tbadk.core.util.as.b((TextView) inflate.findViewById(n.g.tip_title), n.d.cp_cont_b, 1);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(n.g.inner_img_txt_layout);
            com.baidu.tbadk.core.util.as.i(linearLayout, n.f.bg_lottery_win);
            TbImageView tbImageView = (TbImageView) linearLayout.findViewById(n.g.tip_img);
            tbImageView.setDefaultBgResource(0);
            tbImageView.d(aVar.cEQ, 10, false);
            LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(n.g.inner_text_layout);
            TextView textView = (TextView) linearLayout2.findViewById(n.g.inner_text_bottom);
            if (!com.baidu.tbadk.core.util.ax.isEmpty(aVar.cES)) {
                textView.setText(aVar.cES);
            }
            com.baidu.tbadk.core.util.as.b(textView, n.d.cp_cont_c, 1);
            TextView textView2 = (TextView) linearLayout2.findViewById(n.g.inner_text_top);
            textView2.setText(aVar.cER);
            com.baidu.tbadk.core.util.as.b(textView2, n.d.cp_cont_b, 1);
            m(inflate);
            a(aVar.cEV, aVar.cEX);
            b(aVar.cEU, aVar.cEW);
            aj(false);
            bI(1);
            b(aVar.cET).tf();
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public com.baidu.adp.base.h<?> cET;
        public String cEU = null;
        public String cEV = null;
        public a.b cEW = null;
        public a.b cEX = null;

        public boolean ale() {
            if (this.cET == null || com.baidu.tbadk.core.util.ax.isEmpty(this.cEU) || com.baidu.tbadk.core.util.ax.isEmpty(this.cEV) || this.cEW == null || this.cEX == null) {
                BdLog.e("PbActDialog: wrong paras!");
                return false;
            }
            return true;
        }
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0075c extends b {
        public String cEY = null;
        public String cES = null;

        @Override // com.baidu.tieba.pb.pb.main.c.b
        public boolean ale() {
            if (super.ale()) {
                if (com.baidu.tbadk.core.util.ax.isEmpty(this.cEY) || com.baidu.tbadk.core.util.ax.isEmpty(this.cES)) {
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
        public String cEQ = null;
        public String cER = null;
        public String cES = null;

        @Override // com.baidu.tieba.pb.pb.main.c.b
        public boolean ale() {
            if (super.ale()) {
                if (com.baidu.tbadk.core.util.ax.isEmpty(this.cEQ) || com.baidu.tbadk.core.util.ax.isEmpty(this.cER)) {
                    BdLog.e("PbActDialog: wrong paras!");
                    return false;
                }
                return true;
            }
            return false;
        }
    }
}
