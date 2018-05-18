package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.d;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
/* loaded from: classes3.dex */
public class e {
    private Context context;
    private ImageView fcA;
    private TextView fcB;
    private TextView fcC;
    private a fcD;
    public boolean fcE;
    private Animation fcG;
    private View fcy;
    private TextView fcz;
    private long fcF = 0;
    private boolean fcH = false;

    /* loaded from: classes3.dex */
    public interface a {
        void jk(boolean z);

        void o(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.fcy = LayoutInflater.from(context).inflate(d.i.chosen_pb_post_info, (ViewGroup) null);
        this.fcz = (TextView) this.fcy.findViewById(d.g.chosen_post_info_copyright);
        this.fcA = (ImageView) this.fcy.findViewById(d.g.chosen_post_info_praise_icon);
        this.fcB = (TextView) this.fcy.findViewById(d.g.chosen_post_info_praise_num);
        this.fcC = (TextView) this.fcy.findViewById(d.g.chosen_post_info_original_post);
    }

    public View aVi() {
        return this.fcy;
    }

    public void a(a aVar) {
        this.fcD = aVar;
    }

    public void pS(int i) {
        if (this.fcz != null) {
            this.fcz.setText(i);
        }
    }

    public void C(View.OnClickListener onClickListener) {
        if (this.fcC != null) {
            this.fcC.setOnClickListener(onClickListener);
        }
    }

    public void cH(long j) {
        if (j >= 0) {
            this.fcF = j;
            if (this.fcB != null) {
                this.fcB.setVisibility(0);
                this.fcB.setText(this.context.getString(d.k.chosen_pb_praise_num, an.z(j)));
            }
            if (this.fcB != null && this.fcB.getVisibility() == 8) {
                this.fcB.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            pS(d.k.chosen_pb_copyright);
            cH(excellentPbThreadInfo.zan.zansum.longValue());
            jo(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.fcA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!e.this.fcH && az.aK(e.this.context)) {
                        e.this.fcH = true;
                        e.this.fcA.startAnimation(e.this.aVk());
                        if (e.this.fcD != null) {
                            e.this.fcD.jk(e.this.fcE);
                        }
                    }
                }
            });
            C(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (e.this.fcD != null) {
                        e.this.fcD.o(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void aVj() {
        this.fcH = false;
    }

    public void jn(boolean z) {
        jo(z);
        if (z) {
            this.fcF++;
        } else {
            this.fcF--;
        }
        cH(this.fcF);
    }

    private void jo(boolean z) {
        this.fcE = z;
        if (z) {
            ak.c(this.fcA, d.f.btn_zambia_big_s);
        } else {
            ak.c(this.fcA, d.f.btn_zambia_big_n);
        }
        this.fcA.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation aVk() {
        if (this.fcG == null) {
            this.fcG = AnimationUtils.loadAnimation(this.context, d.a.praise_animation_scale3);
        }
        return this.fcG;
    }
}
