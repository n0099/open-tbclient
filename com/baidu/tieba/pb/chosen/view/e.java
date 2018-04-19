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
    public boolean fbA;
    private Animation fbC;
    private View fbu;
    private TextView fbv;
    private ImageView fbw;
    private TextView fbx;
    private TextView fby;
    private a fbz;
    private long fbB = 0;
    private boolean fbD = false;

    /* loaded from: classes3.dex */
    public interface a {
        void jj(boolean z);

        void o(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.fbu = LayoutInflater.from(context).inflate(d.i.chosen_pb_post_info, (ViewGroup) null);
        this.fbv = (TextView) this.fbu.findViewById(d.g.chosen_post_info_copyright);
        this.fbw = (ImageView) this.fbu.findViewById(d.g.chosen_post_info_praise_icon);
        this.fbx = (TextView) this.fbu.findViewById(d.g.chosen_post_info_praise_num);
        this.fby = (TextView) this.fbu.findViewById(d.g.chosen_post_info_original_post);
    }

    public View aVi() {
        return this.fbu;
    }

    public void a(a aVar) {
        this.fbz = aVar;
    }

    public void pT(int i) {
        if (this.fbv != null) {
            this.fbv.setText(i);
        }
    }

    public void C(View.OnClickListener onClickListener) {
        if (this.fby != null) {
            this.fby.setOnClickListener(onClickListener);
        }
    }

    public void cH(long j) {
        if (j >= 0) {
            this.fbB = j;
            if (this.fbx != null) {
                this.fbx.setVisibility(0);
                this.fbx.setText(this.context.getString(d.k.chosen_pb_praise_num, an.z(j)));
            }
            if (this.fbx != null && this.fbx.getVisibility() == 8) {
                this.fbx.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            pT(d.k.chosen_pb_copyright);
            cH(excellentPbThreadInfo.zan.zansum.longValue());
            jn(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.fbw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!e.this.fbD && az.aK(e.this.context)) {
                        e.this.fbD = true;
                        e.this.fbw.startAnimation(e.this.aVk());
                        if (e.this.fbz != null) {
                            e.this.fbz.jj(e.this.fbA);
                        }
                    }
                }
            });
            C(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (e.this.fbz != null) {
                        e.this.fbz.o(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void aVj() {
        this.fbD = false;
    }

    public void jm(boolean z) {
        jn(z);
        if (z) {
            this.fbB++;
        } else {
            this.fbB--;
        }
        cH(this.fbB);
    }

    private void jn(boolean z) {
        this.fbA = z;
        if (z) {
            ak.c(this.fbw, d.f.btn_zambia_big_s);
        } else {
            ak.c(this.fbw, d.f.btn_zambia_big_n);
        }
        this.fbw.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation aVk() {
        if (this.fbC == null) {
            this.fbC = AnimationUtils.loadAnimation(this.context, d.a.praise_animation_scale3);
        }
        return this.fbC;
    }
}
