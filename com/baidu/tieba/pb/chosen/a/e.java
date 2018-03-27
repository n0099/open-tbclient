package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.d;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
/* loaded from: classes3.dex */
public class e {
    private Context context;
    private View fGP;
    private TextView fGQ;
    private ImageView fGR;
    private TextView fGS;
    private TextView fGT;
    private a fGU;
    public boolean fGV;
    private Animation fGX;
    private long fGW = 0;
    private boolean fGY = false;

    /* loaded from: classes3.dex */
    public interface a {
        void jN(boolean z);

        void n(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.fGP = LayoutInflater.from(context).inflate(d.h.chosen_pb_post_info, (ViewGroup) null);
        this.fGQ = (TextView) this.fGP.findViewById(d.g.chosen_post_info_copyright);
        this.fGR = (ImageView) this.fGP.findViewById(d.g.chosen_post_info_praise_icon);
        this.fGS = (TextView) this.fGP.findViewById(d.g.chosen_post_info_praise_num);
        this.fGT = (TextView) this.fGP.findViewById(d.g.chosen_post_info_original_post);
    }

    public View baj() {
        return this.fGP;
    }

    public void a(a aVar) {
        this.fGU = aVar;
    }

    public void sz(int i) {
        if (this.fGQ != null) {
            this.fGQ.setText(i);
        }
    }

    public void B(View.OnClickListener onClickListener) {
        if (this.fGT != null) {
            this.fGT.setOnClickListener(onClickListener);
        }
    }

    public void cE(long j) {
        if (j >= 0) {
            this.fGW = j;
            if (this.fGS != null) {
                this.fGS.setVisibility(0);
                this.fGS.setText(this.context.getString(d.j.chosen_pb_praise_num, am.H(j)));
            }
            if (this.fGS != null && this.fGS.getVisibility() == 8) {
                this.fGS.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            sz(d.j.chosen_pb_copyright);
            cE(excellentPbThreadInfo.zan.zansum.longValue());
            jR(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.fGR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.a.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.fGY && ay.ba(e.this.context)) {
                        e.this.fGY = true;
                        e.this.fGR.startAnimation(e.this.bal());
                        if (e.this.fGU != null) {
                            e.this.fGU.jN(e.this.fGV);
                        }
                    }
                }
            });
            B(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.a.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.fGU != null) {
                        e.this.fGU.n(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void bak() {
        this.fGY = false;
    }

    public void jQ(boolean z) {
        jR(z);
        if (z) {
            this.fGW++;
        } else {
            this.fGW--;
        }
        cE(this.fGW);
    }

    private void jR(boolean z) {
        this.fGV = z;
        if (z) {
            aj.c(this.fGR, d.f.btn_zambia_big_s);
        } else {
            aj.c(this.fGR, d.f.btn_zambia_big_n);
        }
        this.fGR.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation bal() {
        if (this.fGX == null) {
            this.fGX = AnimationUtils.loadAnimation(this.context, d.a.praise_animation_scale3);
        }
        return this.fGX;
    }
}
