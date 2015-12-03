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

    public void a(C0080c c0080c) {
        if (c0080c != null && c0080c.ajX()) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(n.g.pb_dlg_img_txt, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(n.f.tip_top);
            textView.setText(c0080c.cBt);
            com.baidu.tbadk.core.util.as.b(textView, n.c.cp_cont_c, 1);
            TextView textView2 = (TextView) inflate.findViewById(n.f.tip_bottom);
            textView2.setText(c0080c.cBn);
            com.baidu.tbadk.core.util.as.b(textView2, n.c.cp_cont_c, 1);
            com.baidu.tbadk.core.util.as.c((ImageView) inflate.findViewById(n.f.tip_img), n.e.pic_orange_tanhao);
            m(inflate);
            a(c0080c.cBq, c0080c.cBs);
            b(c0080c.cBp, c0080c.cBr);
            am(false);
            b(c0080c.cBo).tv();
        }
    }

    public void b(C0080c c0080c) {
        if (c0080c != null && c0080c.ajX()) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(n.g.pb_dlg_txt, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(n.f.tip_top);
            textView.setText(c0080c.cBt);
            com.baidu.tbadk.core.util.as.b(textView, n.c.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(n.f.tip_bottom);
            textView2.setText(c0080c.cBn);
            com.baidu.tbadk.core.util.as.b(textView2, n.c.cp_cont_b, 1);
            m(inflate);
            a(c0080c.cBq, c0080c.cBs);
            b(c0080c.cBp, c0080c.cBr);
            am(false);
            b(c0080c.cBo).tv();
        }
    }

    public void a(a aVar) {
        if (aVar != null && aVar.ajX()) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(n.g.pb_dlg_multi, (ViewGroup) null);
            com.baidu.tbadk.core.util.as.b((TextView) inflate.findViewById(n.f.tip_title), n.c.cp_cont_b, 1);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(n.f.inner_img_txt_layout);
            com.baidu.tbadk.core.util.as.i(linearLayout, n.e.bg_lottery_win);
            TbImageView tbImageView = (TbImageView) linearLayout.findViewById(n.f.tip_img);
            tbImageView.setDefaultBgResource(0);
            tbImageView.d(aVar.cBl, 10, false);
            LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(n.f.inner_text_layout);
            TextView textView = (TextView) linearLayout2.findViewById(n.f.inner_text_bottom);
            if (!com.baidu.tbadk.core.util.ax.isEmpty(aVar.cBn)) {
                textView.setText(aVar.cBn);
            }
            com.baidu.tbadk.core.util.as.b(textView, n.c.cp_cont_c, 1);
            TextView textView2 = (TextView) linearLayout2.findViewById(n.f.inner_text_top);
            textView2.setText(aVar.cBm);
            com.baidu.tbadk.core.util.as.b(textView2, n.c.cp_cont_b, 1);
            m(inflate);
            a(aVar.cBq, aVar.cBs);
            b(aVar.cBp, aVar.cBr);
            am(false);
            bP(1);
            b(aVar.cBo).tv();
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public com.baidu.adp.base.h<?> cBo;
        public String cBp = null;
        public String cBq = null;
        public a.b cBr = null;
        public a.b cBs = null;

        public boolean ajX() {
            if (this.cBo == null || com.baidu.tbadk.core.util.ax.isEmpty(this.cBp) || com.baidu.tbadk.core.util.ax.isEmpty(this.cBq) || this.cBr == null || this.cBs == null) {
                BdLog.e("PbActDialog: wrong paras!");
                return false;
            }
            return true;
        }
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0080c extends b {
        public String cBt = null;
        public String cBn = null;

        @Override // com.baidu.tieba.pb.pb.main.c.b
        public boolean ajX() {
            if (super.ajX()) {
                if (com.baidu.tbadk.core.util.ax.isEmpty(this.cBt) || com.baidu.tbadk.core.util.ax.isEmpty(this.cBn)) {
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
        public String cBl = null;
        public String cBm = null;
        public String cBn = null;

        @Override // com.baidu.tieba.pb.pb.main.c.b
        public boolean ajX() {
            if (super.ajX()) {
                if (com.baidu.tbadk.core.util.ax.isEmpty(this.cBl) || com.baidu.tbadk.core.util.ax.isEmpty(this.cBm)) {
                    BdLog.e("PbActDialog: wrong paras!");
                    return false;
                }
                return true;
            }
            return false;
        }
    }
}
