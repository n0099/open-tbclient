package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.t;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
/* loaded from: classes.dex */
public class i {
    private View cJa;
    private TextView cJb;
    private ImageView cJc;
    private TextView cJd;
    private TextView cJe;
    private a cJf;
    public boolean cJg;
    private Animation cJi;
    private Context context;
    private long cJh = 0;
    private boolean cJj = false;

    /* loaded from: classes.dex */
    public interface a {
        void fa(boolean z);

        void g(long j, String str);
    }

    public i(Context context) {
        this.context = context;
        this.cJa = LayoutInflater.from(context).inflate(t.h.chosen_pb_post_info, (ViewGroup) null);
        this.cJb = (TextView) this.cJa.findViewById(t.g.chosen_post_info_copyright);
        this.cJc = (ImageView) this.cJa.findViewById(t.g.chosen_post_info_praise_icon);
        this.cJd = (TextView) this.cJa.findViewById(t.g.chosen_post_info_praise_num);
        this.cJe = (TextView) this.cJa.findViewById(t.g.chosen_post_info_original_post);
    }

    public View aox() {
        return this.cJa;
    }

    public void a(a aVar) {
        this.cJf = aVar;
    }

    public void kJ(int i) {
        if (this.cJb != null) {
            this.cJb.setText(i);
        }
    }

    public void E(View.OnClickListener onClickListener) {
        if (this.cJe != null) {
            this.cJe.setOnClickListener(onClickListener);
        }
    }

    public void bm(long j) {
        if (j >= 0) {
            this.cJh = j;
            if (this.cJd != null) {
                this.cJd.setText(this.context.getString(t.j.chosen_pb_praise_num, aw.y(j)));
            }
        }
    }

    public void a(ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            kJ(t.j.chosen_pb_copyright);
            bm(excellentPbThreadInfo.zan.zansum.longValue());
            fe(excellentPbThreadInfo.zan.is_zan.booleanValue());
            E(new j(this, excellentPbThreadInfo));
            this.cJc.setOnClickListener(new k(this));
        }
    }

    public void aoy() {
        this.cJj = false;
    }

    public void fd(boolean z) {
        fe(z);
        if (z) {
            this.cJh++;
        } else {
            this.cJh--;
        }
        bm(this.cJh);
    }

    private void fe(boolean z) {
        this.cJg = z;
        if (z) {
            ar.c(this.cJc, t.f.btn_zambia_big_s);
        } else {
            ar.c(this.cJc, t.f.btn_zambia_big_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation aoz() {
        if (this.cJi == null) {
            this.cJi = AnimationUtils.loadAnimation(this.context, t.a.praise_animation_scale3);
        }
        return this.cJi;
    }
}
