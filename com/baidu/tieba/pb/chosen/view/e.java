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
    private View fID;
    private TextView fIE;
    private ImageView fIF;
    private TextView fIG;
    private TextView fIH;
    private a fII;
    public boolean fIJ;
    private Animation fIL;
    private long fIK = 0;
    private boolean fIM = false;

    /* loaded from: classes3.dex */
    public interface a {
        void kn(boolean z);

        void q(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.fID = LayoutInflater.from(context).inflate(e.h.chosen_pb_post_info, (ViewGroup) null);
        this.fIE = (TextView) this.fID.findViewById(e.g.chosen_post_info_copyright);
        this.fIF = (ImageView) this.fID.findViewById(e.g.chosen_post_info_praise_icon);
        this.fIG = (TextView) this.fID.findViewById(e.g.chosen_post_info_praise_num);
        this.fIH = (TextView) this.fID.findViewById(e.g.chosen_post_info_original_post);
    }

    public View bej() {
        return this.fID;
    }

    public void a(a aVar) {
        this.fII = aVar;
    }

    public void rD(int i) {
        if (this.fIE != null) {
            this.fIE.setText(i);
        }
    }

    public void F(View.OnClickListener onClickListener) {
        if (this.fIH != null) {
            this.fIH.setOnClickListener(onClickListener);
        }
    }

    public void cL(long j) {
        if (j >= 0) {
            this.fIK = j;
            if (this.fIG != null) {
                this.fIG.setVisibility(0);
                this.fIG.setText(this.context.getString(e.j.chosen_pb_praise_num, ao.N(j)));
            }
            if (this.fIG != null && this.fIG.getVisibility() == 8) {
                this.fIG.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            rD(e.j.chosen_pb_copyright);
            cL(excellentPbThreadInfo.zan.zansum.longValue());
            kr(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.fIF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.fIM && ba.bG(e.this.context)) {
                        e.this.fIM = true;
                        e.this.fIF.startAnimation(e.this.bel());
                        if (e.this.fII != null) {
                            e.this.fII.kn(e.this.fIJ);
                        }
                    }
                }
            });
            F(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.fII != null) {
                        e.this.fII.q(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void bek() {
        this.fIM = false;
    }

    public void kq(boolean z) {
        kr(z);
        if (z) {
            this.fIK++;
        } else {
            this.fIK--;
        }
        cL(this.fIK);
    }

    private void kr(boolean z) {
        this.fIJ = z;
        if (z) {
            al.c(this.fIF, e.f.btn_zambia_big_s);
        } else {
            al.c(this.fIF, e.f.btn_zambia_big_n);
        }
        this.fIF.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation bel() {
        if (this.fIL == null) {
            this.fIL = AnimationUtils.loadAnimation(this.context, e.a.praise_animation_scale3);
        }
        return this.fIL;
    }
}
