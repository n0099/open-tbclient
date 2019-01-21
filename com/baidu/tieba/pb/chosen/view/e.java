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
    private View fTj;
    private TextView fTk;
    private ImageView fTl;
    private TextView fTm;
    private TextView fTn;
    private a fTo;
    public boolean fTp;
    private Animation fTr;
    private long fTq = 0;
    private boolean fTs = false;

    /* loaded from: classes3.dex */
    public interface a {
        void kt(boolean z);

        void q(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.fTj = LayoutInflater.from(context).inflate(e.h.chosen_pb_post_info, (ViewGroup) null);
        this.fTk = (TextView) this.fTj.findViewById(e.g.chosen_post_info_copyright);
        this.fTl = (ImageView) this.fTj.findViewById(e.g.chosen_post_info_praise_icon);
        this.fTm = (TextView) this.fTj.findViewById(e.g.chosen_post_info_praise_num);
        this.fTn = (TextView) this.fTj.findViewById(e.g.chosen_post_info_original_post);
    }

    public View bhp() {
        return this.fTj;
    }

    public void a(a aVar) {
        this.fTo = aVar;
    }

    public void so(int i) {
        if (this.fTk != null) {
            this.fTk.setText(i);
        }
    }

    public void F(View.OnClickListener onClickListener) {
        if (this.fTn != null) {
            this.fTn.setOnClickListener(onClickListener);
        }
    }

    public void cX(long j) {
        if (j >= 0) {
            this.fTq = j;
            if (this.fTm != null) {
                this.fTm.setVisibility(0);
                this.fTm.setText(this.context.getString(e.j.chosen_pb_praise_num, ao.V(j)));
            }
            if (this.fTm != null && this.fTm.getVisibility() == 8) {
                this.fTm.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            so(e.j.chosen_pb_copyright);
            cX(excellentPbThreadInfo.zan.zansum.longValue());
            kx(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.fTl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.fTs && ba.bJ(e.this.context)) {
                        e.this.fTs = true;
                        e.this.fTl.startAnimation(e.this.bhr());
                        if (e.this.fTo != null) {
                            e.this.fTo.kt(e.this.fTp);
                        }
                    }
                }
            });
            F(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.fTo != null) {
                        e.this.fTo.q(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void bhq() {
        this.fTs = false;
    }

    public void kw(boolean z) {
        kx(z);
        if (z) {
            this.fTq++;
        } else {
            this.fTq--;
        }
        cX(this.fTq);
    }

    private void kx(boolean z) {
        this.fTp = z;
        if (z) {
            al.c(this.fTl, e.f.btn_zambia_big_s);
        } else {
            al.c(this.fTl, e.f.btn_zambia_big_n);
        }
        this.fTl.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation bhr() {
        if (this.fTr == null) {
            this.fTr = AnimationUtils.loadAnimation(this.context, e.a.praise_animation_scale3);
        }
        return this.fTr;
    }
}
