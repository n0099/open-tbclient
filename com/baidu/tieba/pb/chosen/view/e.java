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
    private TextView hjA;
    private a hjB;
    public boolean hjC;
    private Animation hjE;
    private View hjw;
    private TextView hjx;
    private ImageView hjy;
    private TextView hjz;
    private long hjD = 0;
    private boolean hjF = false;

    /* loaded from: classes5.dex */
    public interface a {
        void mU(boolean z);

        void q(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.hjw = LayoutInflater.from(context).inflate(d.h.chosen_pb_post_info, (ViewGroup) null);
        this.hjx = (TextView) this.hjw.findViewById(d.g.chosen_post_info_copyright);
        this.hjy = (ImageView) this.hjw.findViewById(d.g.chosen_post_info_praise_icon);
        this.hjz = (TextView) this.hjw.findViewById(d.g.chosen_post_info_praise_num);
        this.hjA = (TextView) this.hjw.findViewById(d.g.chosen_post_info_original_post);
    }

    public View bHQ() {
        return this.hjw;
    }

    public void a(a aVar) {
        this.hjB = aVar;
    }

    public void vX(int i) {
        if (this.hjx != null) {
            this.hjx.setText(i);
        }
    }

    public void G(View.OnClickListener onClickListener) {
        if (this.hjA != null) {
            this.hjA.setOnClickListener(onClickListener);
        }
    }

    public void dC(long j) {
        if (j >= 0) {
            this.hjD = j;
            if (this.hjz != null) {
                this.hjz.setVisibility(0);
                this.hjz.setText(this.context.getString(d.j.chosen_pb_praise_num, ap.ax(j)));
            }
            if (this.hjz != null && this.hjz.getVisibility() == 8) {
                this.hjz.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            vX(d.j.chosen_pb_copyright);
            dC(excellentPbThreadInfo.zan.zansum.longValue());
            mY(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.hjy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.hjF && bc.cZ(e.this.context)) {
                        e.this.hjF = true;
                        e.this.hjy.startAnimation(e.this.bHS());
                        if (e.this.hjB != null) {
                            e.this.hjB.mU(e.this.hjC);
                        }
                    }
                }
            });
            G(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.hjB != null) {
                        e.this.hjB.q(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void bHR() {
        this.hjF = false;
    }

    public void mX(boolean z) {
        mY(z);
        if (z) {
            this.hjD++;
        } else {
            this.hjD--;
        }
        dC(this.hjD);
    }

    private void mY(boolean z) {
        this.hjC = z;
        if (z) {
            al.c(this.hjy, d.f.btn_zambia_big_s);
        } else {
            al.c(this.hjy, d.f.btn_zambia_big_n);
        }
        this.hjy.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation bHS() {
        if (this.hjE == null) {
            this.hjE = AnimationUtils.loadAnimation(this.context, d.a.praise_animation_scale3);
        }
        return this.hjE;
    }
}
