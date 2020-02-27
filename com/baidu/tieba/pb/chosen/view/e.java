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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
/* loaded from: classes10.dex */
public class e {
    private Context context;
    private View iAZ;
    private TextView iBa;
    private ImageView iBb;
    private TextView iBc;
    private TextView iBd;
    private a iBe;
    public boolean iBf;
    private Animation iBh;
    private long iBg = 0;
    private boolean iBi = false;

    /* loaded from: classes10.dex */
    public interface a {
        void pp(boolean z);

        void r(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.iAZ = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.iBa = (TextView) this.iAZ.findViewById(R.id.chosen_post_info_copyright);
        this.iBb = (ImageView) this.iAZ.findViewById(R.id.chosen_post_info_praise_icon);
        this.iBc = (TextView) this.iAZ.findViewById(R.id.chosen_post_info_praise_num);
        this.iBd = (TextView) this.iAZ.findViewById(R.id.chosen_post_info_original_post);
    }

    public View ckl() {
        return this.iAZ;
    }

    public void a(a aVar) {
        this.iBe = aVar;
    }

    public void yz(int i) {
        if (this.iBa != null) {
            this.iBa.setText(i);
        }
    }

    public void M(View.OnClickListener onClickListener) {
        if (this.iBd != null) {
            this.iBd.setOnClickListener(onClickListener);
        }
    }

    public void es(long j) {
        if (j >= 0) {
            this.iBg = j;
            if (this.iBc != null) {
                this.iBc.setVisibility(0);
                this.iBc.setText(this.context.getString(R.string.chosen_pb_praise_num, aq.numFormatOver10000(j)));
            }
            if (this.iBc != null && this.iBc.getVisibility() == 8) {
                this.iBc.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            yz(R.string.chosen_pb_copyright);
            es(excellentPbThreadInfo.zan.zansum.longValue());
            pt(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.iBb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.iBi && bc.checkUpIsLogin(e.this.context)) {
                        e.this.iBi = true;
                        e.this.iBb.startAnimation(e.this.ckn());
                        if (e.this.iBe != null) {
                            e.this.iBe.pp(e.this.iBf);
                        }
                    }
                }
            });
            M(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.iBe != null) {
                        e.this.iBe.r(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void ckm() {
        this.iBi = false;
    }

    public void ps(boolean z) {
        pt(z);
        if (z) {
            this.iBg++;
        } else {
            this.iBg--;
        }
        es(this.iBg);
    }

    private void pt(boolean z) {
        this.iBf = z;
        if (z) {
            am.setImageResource(this.iBb, R.drawable.btn_zambia_big_s);
        } else {
            am.setImageResource(this.iBb, R.drawable.btn_zambia_big_n);
        }
        this.iBb.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation ckn() {
        if (this.iBh == null) {
            this.iBh = AnimationUtils.loadAnimation(this.context, R.anim.praise_animation_scale3);
        }
        return this.iBh;
    }
}
