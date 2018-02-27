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
    private TextView fGA;
    private ImageView fGB;
    private TextView fGC;
    private TextView fGD;
    private a fGE;
    public boolean fGF;
    private Animation fGH;
    private View fGz;
    private long fGG = 0;
    private boolean fGI = false;

    /* loaded from: classes3.dex */
    public interface a {
        void jI(boolean z);

        void n(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.fGz = LayoutInflater.from(context).inflate(d.h.chosen_pb_post_info, (ViewGroup) null);
        this.fGA = (TextView) this.fGz.findViewById(d.g.chosen_post_info_copyright);
        this.fGB = (ImageView) this.fGz.findViewById(d.g.chosen_post_info_praise_icon);
        this.fGC = (TextView) this.fGz.findViewById(d.g.chosen_post_info_praise_num);
        this.fGD = (TextView) this.fGz.findViewById(d.g.chosen_post_info_original_post);
    }

    public View bai() {
        return this.fGz;
    }

    public void a(a aVar) {
        this.fGE = aVar;
    }

    public void sz(int i) {
        if (this.fGA != null) {
            this.fGA.setText(i);
        }
    }

    public void B(View.OnClickListener onClickListener) {
        if (this.fGD != null) {
            this.fGD.setOnClickListener(onClickListener);
        }
    }

    public void cE(long j) {
        if (j >= 0) {
            this.fGG = j;
            if (this.fGC != null) {
                this.fGC.setVisibility(0);
                this.fGC.setText(this.context.getString(d.j.chosen_pb_praise_num, am.H(j)));
            }
            if (this.fGC != null && this.fGC.getVisibility() == 8) {
                this.fGC.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            sz(d.j.chosen_pb_copyright);
            cE(excellentPbThreadInfo.zan.zansum.longValue());
            jM(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.fGB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.a.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.fGI && ay.ba(e.this.context)) {
                        e.this.fGI = true;
                        e.this.fGB.startAnimation(e.this.bak());
                        if (e.this.fGE != null) {
                            e.this.fGE.jI(e.this.fGF);
                        }
                    }
                }
            });
            B(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.a.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.fGE != null) {
                        e.this.fGE.n(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void baj() {
        this.fGI = false;
    }

    public void jL(boolean z) {
        jM(z);
        if (z) {
            this.fGG++;
        } else {
            this.fGG--;
        }
        cE(this.fGG);
    }

    private void jM(boolean z) {
        this.fGF = z;
        if (z) {
            aj.c(this.fGB, d.f.btn_zambia_big_s);
        } else {
            aj.c(this.fGB, d.f.btn_zambia_big_n);
        }
        this.fGB.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation bak() {
        if (this.fGH == null) {
            this.fGH = AnimationUtils.loadAnimation(this.context, d.a.praise_animation_scale3);
        }
        return this.fGH;
    }
}
