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
    private View iBb;
    private TextView iBc;
    private ImageView iBd;
    private TextView iBe;
    private TextView iBf;
    private a iBg;
    public boolean iBh;
    private Animation iBj;
    private long iBi = 0;
    private boolean iBk = false;

    /* loaded from: classes10.dex */
    public interface a {
        void pp(boolean z);

        void r(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.iBb = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.iBc = (TextView) this.iBb.findViewById(R.id.chosen_post_info_copyright);
        this.iBd = (ImageView) this.iBb.findViewById(R.id.chosen_post_info_praise_icon);
        this.iBe = (TextView) this.iBb.findViewById(R.id.chosen_post_info_praise_num);
        this.iBf = (TextView) this.iBb.findViewById(R.id.chosen_post_info_original_post);
    }

    public View ckn() {
        return this.iBb;
    }

    public void a(a aVar) {
        this.iBg = aVar;
    }

    public void yz(int i) {
        if (this.iBc != null) {
            this.iBc.setText(i);
        }
    }

    public void M(View.OnClickListener onClickListener) {
        if (this.iBf != null) {
            this.iBf.setOnClickListener(onClickListener);
        }
    }

    public void es(long j) {
        if (j >= 0) {
            this.iBi = j;
            if (this.iBe != null) {
                this.iBe.setVisibility(0);
                this.iBe.setText(this.context.getString(R.string.chosen_pb_praise_num, aq.numFormatOver10000(j)));
            }
            if (this.iBe != null && this.iBe.getVisibility() == 8) {
                this.iBe.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            yz(R.string.chosen_pb_copyright);
            es(excellentPbThreadInfo.zan.zansum.longValue());
            pt(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.iBd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.iBk && bc.checkUpIsLogin(e.this.context)) {
                        e.this.iBk = true;
                        e.this.iBd.startAnimation(e.this.ckp());
                        if (e.this.iBg != null) {
                            e.this.iBg.pp(e.this.iBh);
                        }
                    }
                }
            });
            M(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.iBg != null) {
                        e.this.iBg.r(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void cko() {
        this.iBk = false;
    }

    public void ps(boolean z) {
        pt(z);
        if (z) {
            this.iBi++;
        } else {
            this.iBi--;
        }
        es(this.iBi);
    }

    private void pt(boolean z) {
        this.iBh = z;
        if (z) {
            am.setImageResource(this.iBd, R.drawable.btn_zambia_big_s);
        } else {
            am.setImageResource(this.iBd, R.drawable.btn_zambia_big_n);
        }
        this.iBd.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation ckp() {
        if (this.iBj == null) {
            this.iBj = AnimationUtils.loadAnimation(this.context, R.anim.praise_animation_scale3);
        }
        return this.iBj;
    }
}
