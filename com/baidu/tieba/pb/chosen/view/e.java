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
    private View fSl;
    private TextView fSm;
    private ImageView fSn;
    private TextView fSo;
    private TextView fSp;
    private a fSq;
    public boolean fSr;
    private Animation fSt;
    private long fSs = 0;
    private boolean fSu = false;

    /* loaded from: classes3.dex */
    public interface a {
        void kt(boolean z);

        void q(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.fSl = LayoutInflater.from(context).inflate(e.h.chosen_pb_post_info, (ViewGroup) null);
        this.fSm = (TextView) this.fSl.findViewById(e.g.chosen_post_info_copyright);
        this.fSn = (ImageView) this.fSl.findViewById(e.g.chosen_post_info_praise_icon);
        this.fSo = (TextView) this.fSl.findViewById(e.g.chosen_post_info_praise_num);
        this.fSp = (TextView) this.fSl.findViewById(e.g.chosen_post_info_original_post);
    }

    public View bgL() {
        return this.fSl;
    }

    public void a(a aVar) {
        this.fSq = aVar;
    }

    public void sk(int i) {
        if (this.fSm != null) {
            this.fSm.setText(i);
        }
    }

    public void F(View.OnClickListener onClickListener) {
        if (this.fSp != null) {
            this.fSp.setOnClickListener(onClickListener);
        }
    }

    public void cX(long j) {
        if (j >= 0) {
            this.fSs = j;
            if (this.fSo != null) {
                this.fSo.setVisibility(0);
                this.fSo.setText(this.context.getString(e.j.chosen_pb_praise_num, ao.V(j)));
            }
            if (this.fSo != null && this.fSo.getVisibility() == 8) {
                this.fSo.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            sk(e.j.chosen_pb_copyright);
            cX(excellentPbThreadInfo.zan.zansum.longValue());
            kx(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.fSn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.fSu && ba.bJ(e.this.context)) {
                        e.this.fSu = true;
                        e.this.fSn.startAnimation(e.this.bgN());
                        if (e.this.fSq != null) {
                            e.this.fSq.kt(e.this.fSr);
                        }
                    }
                }
            });
            F(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.fSq != null) {
                        e.this.fSq.q(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void bgM() {
        this.fSu = false;
    }

    public void kw(boolean z) {
        kx(z);
        if (z) {
            this.fSs++;
        } else {
            this.fSs--;
        }
        cX(this.fSs);
    }

    private void kx(boolean z) {
        this.fSr = z;
        if (z) {
            al.c(this.fSn, e.f.btn_zambia_big_s);
        } else {
            al.c(this.fSn, e.f.btn_zambia_big_n);
        }
        this.fSn.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation bgN() {
        if (this.fSt == null) {
            this.fSt = AnimationUtils.loadAnimation(this.context, e.a.praise_animation_scale3);
        }
        return this.fSt;
    }
}
