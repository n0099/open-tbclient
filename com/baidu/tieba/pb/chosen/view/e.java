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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.d;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
/* loaded from: classes5.dex */
public class e {
    private Context context;
    private View hjj;
    private TextView hjk;
    private ImageView hjl;
    private TextView hjm;
    private TextView hjn;
    private a hjo;
    public boolean hjp;
    private Animation hjr;
    private long hjq = 0;
    private boolean hjs = false;

    /* loaded from: classes5.dex */
    public interface a {
        void mU(boolean z);

        void q(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.hjj = LayoutInflater.from(context).inflate(d.h.chosen_pb_post_info, (ViewGroup) null);
        this.hjk = (TextView) this.hjj.findViewById(d.g.chosen_post_info_copyright);
        this.hjl = (ImageView) this.hjj.findViewById(d.g.chosen_post_info_praise_icon);
        this.hjm = (TextView) this.hjj.findViewById(d.g.chosen_post_info_praise_num);
        this.hjn = (TextView) this.hjj.findViewById(d.g.chosen_post_info_original_post);
    }

    public View bHN() {
        return this.hjj;
    }

    public void a(a aVar) {
        this.hjo = aVar;
    }

    public void vT(int i) {
        if (this.hjk != null) {
            this.hjk.setText(i);
        }
    }

    public void G(View.OnClickListener onClickListener) {
        if (this.hjn != null) {
            this.hjn.setOnClickListener(onClickListener);
        }
    }

    public void dC(long j) {
        if (j >= 0) {
            this.hjq = j;
            if (this.hjm != null) {
                this.hjm.setVisibility(0);
                this.hjm.setText(this.context.getString(d.j.chosen_pb_praise_num, ap.ax(j)));
            }
            if (this.hjm != null && this.hjm.getVisibility() == 8) {
                this.hjm.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            vT(d.j.chosen_pb_copyright);
            dC(excellentPbThreadInfo.zan.zansum.longValue());
            mY(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.hjl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.hjs && bc.cZ(e.this.context)) {
                        e.this.hjs = true;
                        e.this.hjl.startAnimation(e.this.bHP());
                        if (e.this.hjo != null) {
                            e.this.hjo.mU(e.this.hjp);
                        }
                    }
                }
            });
            G(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.hjo != null) {
                        e.this.hjo.q(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void bHO() {
        this.hjs = false;
    }

    public void mX(boolean z) {
        mY(z);
        if (z) {
            this.hjq++;
        } else {
            this.hjq--;
        }
        dC(this.hjq);
    }

    private void mY(boolean z) {
        this.hjp = z;
        if (z) {
            al.c(this.hjl, d.f.btn_zambia_big_s);
        } else {
            al.c(this.hjl, d.f.btn_zambia_big_n);
        }
        this.hjl.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation bHP() {
        if (this.hjr == null) {
            this.hjr = AnimationUtils.loadAnimation(this.context, d.a.praise_animation_scale3);
        }
        return this.hjr;
    }
}
