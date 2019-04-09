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
    private View hjk;
    private TextView hjl;
    private ImageView hjm;
    private TextView hjn;
    private TextView hjo;
    private a hjp;
    public boolean hjq;
    private Animation hjs;
    private long hjr = 0;
    private boolean hjt = false;

    /* loaded from: classes5.dex */
    public interface a {
        void mU(boolean z);

        void q(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.hjk = LayoutInflater.from(context).inflate(d.h.chosen_pb_post_info, (ViewGroup) null);
        this.hjl = (TextView) this.hjk.findViewById(d.g.chosen_post_info_copyright);
        this.hjm = (ImageView) this.hjk.findViewById(d.g.chosen_post_info_praise_icon);
        this.hjn = (TextView) this.hjk.findViewById(d.g.chosen_post_info_praise_num);
        this.hjo = (TextView) this.hjk.findViewById(d.g.chosen_post_info_original_post);
    }

    public View bHN() {
        return this.hjk;
    }

    public void a(a aVar) {
        this.hjp = aVar;
    }

    public void vT(int i) {
        if (this.hjl != null) {
            this.hjl.setText(i);
        }
    }

    public void G(View.OnClickListener onClickListener) {
        if (this.hjo != null) {
            this.hjo.setOnClickListener(onClickListener);
        }
    }

    public void dC(long j) {
        if (j >= 0) {
            this.hjr = j;
            if (this.hjn != null) {
                this.hjn.setVisibility(0);
                this.hjn.setText(this.context.getString(d.j.chosen_pb_praise_num, ap.ax(j)));
            }
            if (this.hjn != null && this.hjn.getVisibility() == 8) {
                this.hjn.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            vT(d.j.chosen_pb_copyright);
            dC(excellentPbThreadInfo.zan.zansum.longValue());
            mY(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.hjm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.hjt && bc.cZ(e.this.context)) {
                        e.this.hjt = true;
                        e.this.hjm.startAnimation(e.this.bHP());
                        if (e.this.hjp != null) {
                            e.this.hjp.mU(e.this.hjq);
                        }
                    }
                }
            });
            G(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.hjp != null) {
                        e.this.hjp.q(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void bHO() {
        this.hjt = false;
    }

    public void mX(boolean z) {
        mY(z);
        if (z) {
            this.hjr++;
        } else {
            this.hjr--;
        }
        dC(this.hjr);
    }

    private void mY(boolean z) {
        this.hjq = z;
        if (z) {
            al.c(this.hjm, d.f.btn_zambia_big_s);
        } else {
            al.c(this.hjm, d.f.btn_zambia_big_n);
        }
        this.hjm.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation bHP() {
        if (this.hjs == null) {
            this.hjs = AnimationUtils.loadAnimation(this.context, d.a.praise_animation_scale3);
        }
        return this.hjs;
    }
}
