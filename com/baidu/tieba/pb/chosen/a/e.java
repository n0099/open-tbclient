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
    private View fGK;
    private TextView fGL;
    private ImageView fGM;
    private TextView fGN;
    private TextView fGO;
    private a fGP;
    public boolean fGQ;
    private Animation fGS;
    private long fGR = 0;
    private boolean fGT = false;

    /* loaded from: classes3.dex */
    public interface a {
        void jI(boolean z);

        void n(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.fGK = LayoutInflater.from(context).inflate(d.h.chosen_pb_post_info, (ViewGroup) null);
        this.fGL = (TextView) this.fGK.findViewById(d.g.chosen_post_info_copyright);
        this.fGM = (ImageView) this.fGK.findViewById(d.g.chosen_post_info_praise_icon);
        this.fGN = (TextView) this.fGK.findViewById(d.g.chosen_post_info_praise_num);
        this.fGO = (TextView) this.fGK.findViewById(d.g.chosen_post_info_original_post);
    }

    public View baj() {
        return this.fGK;
    }

    public void a(a aVar) {
        this.fGP = aVar;
    }

    public void sy(int i) {
        if (this.fGL != null) {
            this.fGL.setText(i);
        }
    }

    public void B(View.OnClickListener onClickListener) {
        if (this.fGO != null) {
            this.fGO.setOnClickListener(onClickListener);
        }
    }

    public void cE(long j) {
        if (j >= 0) {
            this.fGR = j;
            if (this.fGN != null) {
                this.fGN.setVisibility(0);
                this.fGN.setText(this.context.getString(d.j.chosen_pb_praise_num, am.H(j)));
            }
            if (this.fGN != null && this.fGN.getVisibility() == 8) {
                this.fGN.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            sy(d.j.chosen_pb_copyright);
            cE(excellentPbThreadInfo.zan.zansum.longValue());
            jM(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.fGM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.a.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.fGT && ay.ba(e.this.context)) {
                        e.this.fGT = true;
                        e.this.fGM.startAnimation(e.this.bal());
                        if (e.this.fGP != null) {
                            e.this.fGP.jI(e.this.fGQ);
                        }
                    }
                }
            });
            B(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.a.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.fGP != null) {
                        e.this.fGP.n(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void bak() {
        this.fGT = false;
    }

    public void jL(boolean z) {
        jM(z);
        if (z) {
            this.fGR++;
        } else {
            this.fGR--;
        }
        cE(this.fGR);
    }

    private void jM(boolean z) {
        this.fGQ = z;
        if (z) {
            aj.c(this.fGM, d.f.btn_zambia_big_s);
        } else {
            aj.c(this.fGM, d.f.btn_zambia_big_n);
        }
        this.fGM.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation bal() {
        if (this.fGS == null) {
            this.fGS = AnimationUtils.loadAnimation(this.context, d.a.praise_animation_scale3);
        }
        return this.fGS;
    }
}
