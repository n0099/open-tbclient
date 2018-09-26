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
    private View fzC;
    private TextView fzD;
    private ImageView fzE;
    private TextView fzF;
    private TextView fzG;
    private a fzH;
    public boolean fzI;
    private Animation fzK;
    private long fzJ = 0;
    private boolean fzL = false;

    /* loaded from: classes3.dex */
    public interface a {
        void jM(boolean z);

        void q(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.fzC = LayoutInflater.from(context).inflate(e.h.chosen_pb_post_info, (ViewGroup) null);
        this.fzD = (TextView) this.fzC.findViewById(e.g.chosen_post_info_copyright);
        this.fzE = (ImageView) this.fzC.findViewById(e.g.chosen_post_info_praise_icon);
        this.fzF = (TextView) this.fzC.findViewById(e.g.chosen_post_info_praise_num);
        this.fzG = (TextView) this.fzC.findViewById(e.g.chosen_post_info_original_post);
    }

    public View bbz() {
        return this.fzC;
    }

    public void a(a aVar) {
        this.fzH = aVar;
    }

    public void qM(int i) {
        if (this.fzD != null) {
            this.fzD.setText(i);
        }
    }

    public void D(View.OnClickListener onClickListener) {
        if (this.fzG != null) {
            this.fzG.setOnClickListener(onClickListener);
        }
    }

    public void cJ(long j) {
        if (j >= 0) {
            this.fzJ = j;
            if (this.fzF != null) {
                this.fzF.setVisibility(0);
                this.fzF.setText(this.context.getString(e.j.chosen_pb_praise_num, ao.J(j)));
            }
            if (this.fzF != null && this.fzF.getVisibility() == 8) {
                this.fzF.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            qM(e.j.chosen_pb_copyright);
            cJ(excellentPbThreadInfo.zan.zansum.longValue());
            jQ(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.fzE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.fzL && ba.bA(e.this.context)) {
                        e.this.fzL = true;
                        e.this.fzE.startAnimation(e.this.bbB());
                        if (e.this.fzH != null) {
                            e.this.fzH.jM(e.this.fzI);
                        }
                    }
                }
            });
            D(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.fzH != null) {
                        e.this.fzH.q(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void bbA() {
        this.fzL = false;
    }

    public void jP(boolean z) {
        jQ(z);
        if (z) {
            this.fzJ++;
        } else {
            this.fzJ--;
        }
        cJ(this.fzJ);
    }

    private void jQ(boolean z) {
        this.fzI = z;
        if (z) {
            al.c(this.fzE, e.f.btn_zambia_big_s);
        } else {
            al.c(this.fzE, e.f.btn_zambia_big_n);
        }
        this.fzE.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation bbB() {
        if (this.fzK == null) {
            this.fzK = AnimationUtils.loadAnimation(this.context, e.a.praise_animation_scale3);
        }
        return this.fzK;
    }
}
