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
    private View fHf;
    private TextView fHg;
    private ImageView fHh;
    private TextView fHi;
    private TextView fHj;
    private a fHk;
    public boolean fHl;
    private Animation fHn;
    private long fHm = 0;
    private boolean fHo = false;

    /* loaded from: classes3.dex */
    public interface a {
        void kd(boolean z);

        void q(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.fHf = LayoutInflater.from(context).inflate(e.h.chosen_pb_post_info, (ViewGroup) null);
        this.fHg = (TextView) this.fHf.findViewById(e.g.chosen_post_info_copyright);
        this.fHh = (ImageView) this.fHf.findViewById(e.g.chosen_post_info_praise_icon);
        this.fHi = (TextView) this.fHf.findViewById(e.g.chosen_post_info_praise_num);
        this.fHj = (TextView) this.fHf.findViewById(e.g.chosen_post_info_original_post);
    }

    public View beL() {
        return this.fHf;
    }

    public void a(a aVar) {
        this.fHk = aVar;
    }

    public void rk(int i) {
        if (this.fHg != null) {
            this.fHg.setText(i);
        }
    }

    public void D(View.OnClickListener onClickListener) {
        if (this.fHj != null) {
            this.fHj.setOnClickListener(onClickListener);
        }
    }

    public void cQ(long j) {
        if (j >= 0) {
            this.fHm = j;
            if (this.fHi != null) {
                this.fHi.setVisibility(0);
                this.fHi.setText(this.context.getString(e.j.chosen_pb_praise_num, ao.L(j)));
            }
            if (this.fHi != null && this.fHi.getVisibility() == 8) {
                this.fHi.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            rk(e.j.chosen_pb_copyright);
            cQ(excellentPbThreadInfo.zan.zansum.longValue());
            kh(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.fHh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.fHo && ba.bI(e.this.context)) {
                        e.this.fHo = true;
                        e.this.fHh.startAnimation(e.this.beN());
                        if (e.this.fHk != null) {
                            e.this.fHk.kd(e.this.fHl);
                        }
                    }
                }
            });
            D(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.fHk != null) {
                        e.this.fHk.q(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void beM() {
        this.fHo = false;
    }

    public void kg(boolean z) {
        kh(z);
        if (z) {
            this.fHm++;
        } else {
            this.fHm--;
        }
        cQ(this.fHm);
    }

    private void kh(boolean z) {
        this.fHl = z;
        if (z) {
            al.c(this.fHh, e.f.btn_zambia_big_s);
        } else {
            al.c(this.fHh, e.f.btn_zambia_big_n);
        }
        this.fHh.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation beN() {
        if (this.fHn == null) {
            this.fHn = AnimationUtils.loadAnimation(this.context, e.a.praise_animation_scale3);
        }
        return this.fHn;
    }
}
