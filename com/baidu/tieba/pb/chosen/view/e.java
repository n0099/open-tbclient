package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.e;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
/* loaded from: classes3.dex */
public class e {
    private Context context;
    private View fHe;
    private TextView fHf;
    private ImageView fHg;
    private TextView fHh;
    private TextView fHi;
    private a fHj;
    public boolean fHk;
    private Animation fHm;
    private long fHl = 0;
    private boolean fHn = false;

    /* loaded from: classes3.dex */
    public interface a {
        void kd(boolean z);

        void q(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.fHe = LayoutInflater.from(context).inflate(e.h.chosen_pb_post_info, (ViewGroup) null);
        this.fHf = (TextView) this.fHe.findViewById(e.g.chosen_post_info_copyright);
        this.fHg = (ImageView) this.fHe.findViewById(e.g.chosen_post_info_praise_icon);
        this.fHh = (TextView) this.fHe.findViewById(e.g.chosen_post_info_praise_num);
        this.fHi = (TextView) this.fHe.findViewById(e.g.chosen_post_info_original_post);
    }

    public View beL() {
        return this.fHe;
    }

    public void a(a aVar) {
        this.fHj = aVar;
    }

    public void rk(int i) {
        if (this.fHf != null) {
            this.fHf.setText(i);
        }
    }

    public void D(View.OnClickListener onClickListener) {
        if (this.fHi != null) {
            this.fHi.setOnClickListener(onClickListener);
        }
    }

    public void cQ(long j) {
        if (j >= 0) {
            this.fHl = j;
            if (this.fHh != null) {
                this.fHh.setVisibility(0);
                this.fHh.setText(this.context.getString(e.j.chosen_pb_praise_num, ao.L(j)));
            }
            if (this.fHh != null && this.fHh.getVisibility() == 8) {
                this.fHh.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            rk(e.j.chosen_pb_copyright);
            cQ(excellentPbThreadInfo.zan.zansum.longValue());
            kh(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.fHg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.fHn && ba.bI(e.this.context)) {
                        e.this.fHn = true;
                        e.this.fHg.startAnimation(e.this.beN());
                        if (e.this.fHj != null) {
                            e.this.fHj.kd(e.this.fHk);
                        }
                    }
                }
            });
            D(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.fHj != null) {
                        e.this.fHj.q(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void beM() {
        this.fHn = false;
    }

    public void kg(boolean z) {
        kh(z);
        if (z) {
            this.fHl++;
        } else {
            this.fHl--;
        }
        cQ(this.fHl);
    }

    private void kh(boolean z) {
        this.fHk = z;
        if (z) {
            al.c(this.fHg, e.f.btn_zambia_big_s);
        } else {
            al.c(this.fHg, e.f.btn_zambia_big_n);
        }
        this.fHg.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation beN() {
        if (this.fHm == null) {
            this.fHm = AnimationUtils.loadAnimation(this.context, e.a.praise_animation_scale3);
        }
        return this.fHm;
    }
}
