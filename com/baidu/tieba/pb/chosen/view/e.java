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
    private Animation fPB;
    private View fPt;
    private TextView fPu;
    private ImageView fPv;
    private TextView fPw;
    private TextView fPx;
    private a fPy;
    public boolean fPz;
    private long fPA = 0;
    private boolean fPC = false;

    /* loaded from: classes3.dex */
    public interface a {
        void kq(boolean z);

        void q(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.fPt = LayoutInflater.from(context).inflate(e.h.chosen_pb_post_info, (ViewGroup) null);
        this.fPu = (TextView) this.fPt.findViewById(e.g.chosen_post_info_copyright);
        this.fPv = (ImageView) this.fPt.findViewById(e.g.chosen_post_info_praise_icon);
        this.fPw = (TextView) this.fPt.findViewById(e.g.chosen_post_info_praise_num);
        this.fPx = (TextView) this.fPt.findViewById(e.g.chosen_post_info_original_post);
    }

    public View bfZ() {
        return this.fPt;
    }

    public void a(a aVar) {
        this.fPy = aVar;
    }

    public void rX(int i) {
        if (this.fPu != null) {
            this.fPu.setText(i);
        }
    }

    public void F(View.OnClickListener onClickListener) {
        if (this.fPx != null) {
            this.fPx.setOnClickListener(onClickListener);
        }
    }

    public void cS(long j) {
        if (j >= 0) {
            this.fPA = j;
            if (this.fPw != null) {
                this.fPw.setVisibility(0);
                this.fPw.setText(this.context.getString(e.j.chosen_pb_praise_num, ao.U(j)));
            }
            if (this.fPw != null && this.fPw.getVisibility() == 8) {
                this.fPw.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            rX(e.j.chosen_pb_copyright);
            cS(excellentPbThreadInfo.zan.zansum.longValue());
            ku(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.fPv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.fPC && ba.bJ(e.this.context)) {
                        e.this.fPC = true;
                        e.this.fPv.startAnimation(e.this.bgb());
                        if (e.this.fPy != null) {
                            e.this.fPy.kq(e.this.fPz);
                        }
                    }
                }
            });
            F(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.fPy != null) {
                        e.this.fPy.q(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void bga() {
        this.fPC = false;
    }

    public void kt(boolean z) {
        ku(z);
        if (z) {
            this.fPA++;
        } else {
            this.fPA--;
        }
        cS(this.fPA);
    }

    private void ku(boolean z) {
        this.fPz = z;
        if (z) {
            al.c(this.fPv, e.f.btn_zambia_big_s);
        } else {
            al.c(this.fPv, e.f.btn_zambia_big_n);
        }
        this.fPv.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation bgb() {
        if (this.fPB == null) {
            this.fPB = AnimationUtils.loadAnimation(this.context, e.a.praise_animation_scale3);
        }
        return this.fPB;
    }
}
