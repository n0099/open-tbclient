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
    private View fTi;
    private TextView fTj;
    private ImageView fTk;
    private TextView fTl;
    private TextView fTm;
    private a fTn;
    public boolean fTo;
    private Animation fTq;
    private long fTp = 0;
    private boolean fTr = false;

    /* loaded from: classes3.dex */
    public interface a {
        void kt(boolean z);

        void q(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.fTi = LayoutInflater.from(context).inflate(e.h.chosen_pb_post_info, (ViewGroup) null);
        this.fTj = (TextView) this.fTi.findViewById(e.g.chosen_post_info_copyright);
        this.fTk = (ImageView) this.fTi.findViewById(e.g.chosen_post_info_praise_icon);
        this.fTl = (TextView) this.fTi.findViewById(e.g.chosen_post_info_praise_num);
        this.fTm = (TextView) this.fTi.findViewById(e.g.chosen_post_info_original_post);
    }

    public View bhp() {
        return this.fTi;
    }

    public void a(a aVar) {
        this.fTn = aVar;
    }

    public void so(int i) {
        if (this.fTj != null) {
            this.fTj.setText(i);
        }
    }

    public void F(View.OnClickListener onClickListener) {
        if (this.fTm != null) {
            this.fTm.setOnClickListener(onClickListener);
        }
    }

    public void cX(long j) {
        if (j >= 0) {
            this.fTp = j;
            if (this.fTl != null) {
                this.fTl.setVisibility(0);
                this.fTl.setText(this.context.getString(e.j.chosen_pb_praise_num, ao.V(j)));
            }
            if (this.fTl != null && this.fTl.getVisibility() == 8) {
                this.fTl.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            so(e.j.chosen_pb_copyright);
            cX(excellentPbThreadInfo.zan.zansum.longValue());
            kx(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.fTk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.fTr && ba.bJ(e.this.context)) {
                        e.this.fTr = true;
                        e.this.fTk.startAnimation(e.this.bhr());
                        if (e.this.fTn != null) {
                            e.this.fTn.kt(e.this.fTo);
                        }
                    }
                }
            });
            F(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.fTn != null) {
                        e.this.fTn.q(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void bhq() {
        this.fTr = false;
    }

    public void kw(boolean z) {
        kx(z);
        if (z) {
            this.fTp++;
        } else {
            this.fTp--;
        }
        cX(this.fTp);
    }

    private void kx(boolean z) {
        this.fTo = z;
        if (z) {
            al.c(this.fTk, e.f.btn_zambia_big_s);
        } else {
            al.c(this.fTk, e.f.btn_zambia_big_n);
        }
        this.fTk.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation bhr() {
        if (this.fTq == null) {
            this.fTq = AnimationUtils.loadAnimation(this.context, e.a.praise_animation_scale3);
        }
        return this.fTq;
    }
}
