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
import com.baidu.tieba.d;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
/* loaded from: classes3.dex */
public class e {
    private Context context;
    private View fnT;
    private TextView fnU;
    private ImageView fnV;
    private TextView fnW;
    private TextView fnX;
    private a fnY;
    public boolean fnZ;
    private Animation fob;
    private long foa = 0;
    private boolean foc = false;

    /* loaded from: classes3.dex */
    public interface a {
        void jq(boolean z);

        void o(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.fnT = LayoutInflater.from(context).inflate(d.i.chosen_pb_post_info, (ViewGroup) null);
        this.fnU = (TextView) this.fnT.findViewById(d.g.chosen_post_info_copyright);
        this.fnV = (ImageView) this.fnT.findViewById(d.g.chosen_post_info_praise_icon);
        this.fnW = (TextView) this.fnT.findViewById(d.g.chosen_post_info_praise_num);
        this.fnX = (TextView) this.fnT.findViewById(d.g.chosen_post_info_original_post);
    }

    public View bae() {
        return this.fnT;
    }

    public void a(a aVar) {
        this.fnY = aVar;
    }

    public void qe(int i) {
        if (this.fnU != null) {
            this.fnU.setText(i);
        }
    }

    public void C(View.OnClickListener onClickListener) {
        if (this.fnX != null) {
            this.fnX.setOnClickListener(onClickListener);
        }
    }

    public void cN(long j) {
        if (j >= 0) {
            this.foa = j;
            if (this.fnW != null) {
                this.fnW.setVisibility(0);
                this.fnW.setText(this.context.getString(d.k.chosen_pb_praise_num, ao.C(j)));
            }
            if (this.fnW != null && this.fnW.getVisibility() == 8) {
                this.fnW.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            qe(d.k.chosen_pb_copyright);
            cN(excellentPbThreadInfo.zan.zansum.longValue());
            ju(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.fnV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.foc && ba.aU(e.this.context)) {
                        e.this.foc = true;
                        e.this.fnV.startAnimation(e.this.bag());
                        if (e.this.fnY != null) {
                            e.this.fnY.jq(e.this.fnZ);
                        }
                    }
                }
            });
            C(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.fnY != null) {
                        e.this.fnY.o(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void baf() {
        this.foc = false;
    }

    public void jt(boolean z) {
        ju(z);
        if (z) {
            this.foa++;
        } else {
            this.foa--;
        }
        cN(this.foa);
    }

    private void ju(boolean z) {
        this.fnZ = z;
        if (z) {
            al.c(this.fnV, d.f.btn_zambia_big_s);
        } else {
            al.c(this.fnV, d.f.btn_zambia_big_n);
        }
        this.fnV.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation bag() {
        if (this.fob == null) {
            this.fob = AnimationUtils.loadAnimation(this.context, d.a.praise_animation_scale3);
        }
        return this.fob;
    }
}
