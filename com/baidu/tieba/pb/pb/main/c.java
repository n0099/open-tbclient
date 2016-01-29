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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.core.dialog.a {
    public c(Activity activity) {
        super(activity);
    }

    public void a(C0077c c0077c) {
        if (c0077c != null && c0077c.apg()) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(t.h.pb_dlg_img_txt, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(t.g.tip_top);
            textView.setText(c0077c.cMp);
            com.baidu.tbadk.core.util.ar.b(textView, t.d.cp_cont_c, 1);
            TextView textView2 = (TextView) inflate.findViewById(t.g.tip_bottom);
            textView2.setText(c0077c.cMj);
            com.baidu.tbadk.core.util.ar.b(textView2, t.d.cp_cont_c, 1);
            com.baidu.tbadk.core.util.ar.c((ImageView) inflate.findViewById(t.g.tip_img), t.f.pic_orange_tanhao);
            z(inflate);
            a(c0077c.cMm, c0077c.cMo);
            b(c0077c.cMl, c0077c.cMn);
            ak(false);
            b(c0077c.cMk).uj();
        }
    }

    public void b(C0077c c0077c) {
        if (c0077c != null && c0077c.apg()) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(t.h.pb_dlg_txt, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(t.g.tip_top);
            textView.setText(c0077c.cMp);
            com.baidu.tbadk.core.util.ar.b(textView, t.d.cp_cont_b, 1);
            TextView textView2 = (TextView) inflate.findViewById(t.g.tip_bottom);
            textView2.setText(c0077c.cMj);
            com.baidu.tbadk.core.util.ar.b(textView2, t.d.cp_cont_b, 1);
            z(inflate);
            a(c0077c.cMm, c0077c.cMo);
            b(c0077c.cMl, c0077c.cMn);
            ak(false);
            b(c0077c.cMk).uj();
        }
    }

    public void a(a aVar) {
        if (aVar != null && aVar.apg()) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(t.h.pb_dlg_multi, (ViewGroup) null);
            com.baidu.tbadk.core.util.ar.b((TextView) inflate.findViewById(t.g.tip_title), t.d.cp_cont_b, 1);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(t.g.inner_img_txt_layout);
            com.baidu.tbadk.core.util.ar.k(linearLayout, t.f.bg_lottery_win);
            TbImageView tbImageView = (TbImageView) linearLayout.findViewById(t.g.tip_img);
            tbImageView.setDefaultBgResource(0);
            tbImageView.d(aVar.cMh, 10, false);
            LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(t.g.inner_text_layout);
            TextView textView = (TextView) linearLayout2.findViewById(t.g.inner_text_bottom);
            if (!com.baidu.tbadk.core.util.aw.isEmpty(aVar.cMj)) {
                textView.setText(aVar.cMj);
            }
            com.baidu.tbadk.core.util.ar.b(textView, t.d.cp_cont_c, 1);
            TextView textView2 = (TextView) linearLayout2.findViewById(t.g.inner_text_top);
            textView2.setText(aVar.cMi);
            com.baidu.tbadk.core.util.ar.b(textView2, t.d.cp_cont_b, 1);
            z(inflate);
            a(aVar.cMm, aVar.cMo);
            b(aVar.cMl, aVar.cMn);
            ak(false);
            ca(1);
            b(aVar.cMk).uj();
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public com.baidu.adp.base.h<?> cMk;
        public String cMl = null;
        public String cMm = null;
        public a.b cMn = null;
        public a.b cMo = null;

        public boolean apg() {
            if (this.cMk == null || com.baidu.tbadk.core.util.aw.isEmpty(this.cMl) || com.baidu.tbadk.core.util.aw.isEmpty(this.cMm) || this.cMn == null || this.cMo == null) {
                BdLog.e("PbActDialog: wrong paras!");
                return false;
            }
            return true;
        }
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0077c extends b {
        public String cMp = null;
        public String cMj = null;

        @Override // com.baidu.tieba.pb.pb.main.c.b
        public boolean apg() {
            if (super.apg()) {
                if (com.baidu.tbadk.core.util.aw.isEmpty(this.cMp) || com.baidu.tbadk.core.util.aw.isEmpty(this.cMj)) {
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
        public String cMh = null;
        public String cMi = null;
        public String cMj = null;

        @Override // com.baidu.tieba.pb.pb.main.c.b
        public boolean apg() {
            if (super.apg()) {
                if (com.baidu.tbadk.core.util.aw.isEmpty(this.cMh) || com.baidu.tbadk.core.util.aw.isEmpty(this.cMi)) {
                    BdLog.e("PbActDialog: wrong paras!");
                    return false;
                }
                return true;
            }
            return false;
        }
    }
}
