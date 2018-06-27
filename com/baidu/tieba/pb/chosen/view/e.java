package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.d;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
/* loaded from: classes3.dex */
public class e {
    private Context context;
    private View frN;
    private TextView frO;
    private ImageView frP;
    private TextView frQ;
    private TextView frR;
    private a frS;
    public boolean frT;
    private Animation frV;
    private long frU = 0;
    private boolean frW = false;

    /* loaded from: classes3.dex */
    public interface a {
        void jz(boolean z);

        void o(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.frN = LayoutInflater.from(context).inflate(d.i.chosen_pb_post_info, (ViewGroup) null);
        this.frO = (TextView) this.frN.findViewById(d.g.chosen_post_info_copyright);
        this.frP = (ImageView) this.frN.findViewById(d.g.chosen_post_info_praise_icon);
        this.frQ = (TextView) this.frN.findViewById(d.g.chosen_post_info_praise_num);
        this.frR = (TextView) this.frN.findViewById(d.g.chosen_post_info_original_post);
    }

    public View baL() {
        return this.frN;
    }

    public void a(a aVar) {
        this.frS = aVar;
    }

    public void ql(int i) {
        if (this.frO != null) {
            this.frO.setText(i);
        }
    }

    public void F(View.OnClickListener onClickListener) {
        if (this.frR != null) {
            this.frR.setOnClickListener(onClickListener);
        }
    }

    public void cJ(long j) {
        if (j >= 0) {
            this.frU = j;
            if (this.frQ != null) {
                this.frQ.setVisibility(0);
                this.frQ.setText(this.context.getString(d.k.chosen_pb_praise_num, ap.D(j)));
            }
            if (this.frQ != null && this.frQ.getVisibility() == 8) {
                this.frQ.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            ql(d.k.chosen_pb_copyright);
            cJ(excellentPbThreadInfo.zan.zansum.longValue());
            jD(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.frP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.frW && bb.aU(e.this.context)) {
                        e.this.frW = true;
                        e.this.frP.startAnimation(e.this.baN());
                        if (e.this.frS != null) {
                            e.this.frS.jz(e.this.frT);
                        }
                    }
                }
            });
            F(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.frS != null) {
                        e.this.frS.o(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void baM() {
        this.frW = false;
    }

    public void jC(boolean z) {
        jD(z);
        if (z) {
            this.frU++;
        } else {
            this.frU--;
        }
        cJ(this.frU);
    }

    private void jD(boolean z) {
        this.frT = z;
        if (z) {
            am.c(this.frP, d.f.btn_zambia_big_s);
        } else {
            am.c(this.frP, d.f.btn_zambia_big_n);
        }
        this.frP.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation baN() {
        if (this.frV == null) {
            this.frV = AnimationUtils.loadAnimation(this.context, d.a.praise_animation_scale3);
        }
        return this.frV;
    }
}
