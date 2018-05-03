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
    private View fbr;
    private TextView fbs;
    private ImageView fbt;
    private TextView fbu;
    private TextView fbv;
    private a fbw;
    public boolean fbx;
    private Animation fbz;
    private long fby = 0;
    private boolean fbA = false;

    /* loaded from: classes3.dex */
    public interface a {
        void jj(boolean z);

        void o(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.fbr = LayoutInflater.from(context).inflate(d.i.chosen_pb_post_info, (ViewGroup) null);
        this.fbs = (TextView) this.fbr.findViewById(d.g.chosen_post_info_copyright);
        this.fbt = (ImageView) this.fbr.findViewById(d.g.chosen_post_info_praise_icon);
        this.fbu = (TextView) this.fbr.findViewById(d.g.chosen_post_info_praise_num);
        this.fbv = (TextView) this.fbr.findViewById(d.g.chosen_post_info_original_post);
    }

    public View aVi() {
        return this.fbr;
    }

    public void a(a aVar) {
        this.fbw = aVar;
    }

    public void pT(int i) {
        if (this.fbs != null) {
            this.fbs.setText(i);
        }
    }

    public void C(View.OnClickListener onClickListener) {
        if (this.fbv != null) {
            this.fbv.setOnClickListener(onClickListener);
        }
    }

    public void cH(long j) {
        if (j >= 0) {
            this.fby = j;
            if (this.fbu != null) {
                this.fbu.setVisibility(0);
                this.fbu.setText(this.context.getString(d.k.chosen_pb_praise_num, an.z(j)));
            }
            if (this.fbu != null && this.fbu.getVisibility() == 8) {
                this.fbu.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            pT(d.k.chosen_pb_copyright);
            cH(excellentPbThreadInfo.zan.zansum.longValue());
            jn(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.fbt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!e.this.fbA && az.aK(e.this.context)) {
                        e.this.fbA = true;
                        e.this.fbt.startAnimation(e.this.aVk());
                        if (e.this.fbw != null) {
                            e.this.fbw.jj(e.this.fbx);
                        }
                    }
                }
            });
            C(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (e.this.fbw != null) {
                        e.this.fbw.o(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void aVj() {
        this.fbA = false;
    }

    public void jm(boolean z) {
        jn(z);
        if (z) {
            this.fby++;
        } else {
            this.fby--;
        }
        cH(this.fby);
    }

    private void jn(boolean z) {
        this.fbx = z;
        if (z) {
            ak.c(this.fbt, d.f.btn_zambia_big_s);
        } else {
            ak.c(this.fbt, d.f.btn_zambia_big_n);
        }
        this.fbt.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation aVk() {
        if (this.fbz == null) {
            this.fbz = AnimationUtils.loadAnimation(this.context, d.a.praise_animation_scale3);
        }
        return this.fbz;
    }
}
