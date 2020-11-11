package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.R;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
/* loaded from: classes23.dex */
public class e {
    private Context context;
    private View lmq;
    private TextView lmr;
    private ImageView lms;
    private TextView lmt;
    private TextView lmu;
    private a lmv;
    public boolean lmw;
    private Animation lmy;
    private long lmx = 0;
    private boolean lmz = false;

    /* loaded from: classes23.dex */
    public interface a {
        void tN(boolean z);

        void w(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.lmq = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.lmr = (TextView) this.lmq.findViewById(R.id.chosen_post_info_copyright);
        this.lms = (ImageView) this.lmq.findViewById(R.id.chosen_post_info_praise_icon);
        this.lmt = (TextView) this.lmq.findViewById(R.id.chosen_post_info_praise_num);
        this.lmu = (TextView) this.lmq.findViewById(R.id.chosen_post_info_original_post);
    }

    public View die() {
        return this.lmq;
    }

    public void a(a aVar) {
        this.lmv = aVar;
    }

    public void FB(int i) {
        if (this.lmr != null) {
            this.lmr.setText(i);
        }
    }

    public void Q(View.OnClickListener onClickListener) {
        if (this.lmu != null) {
            this.lmu.setOnClickListener(onClickListener);
        }
    }

    public void gK(long j) {
        if (j >= 0) {
            this.lmx = j;
            if (this.lmt != null) {
                this.lmt.setVisibility(0);
                this.lmt.setText(this.context.getString(R.string.chosen_pb_praise_num, at.numFormatOver10000(j)));
            }
            if (this.lmt != null && this.lmt.getVisibility() == 8) {
                this.lmt.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            FB(R.string.chosen_pb_copyright);
            gK(excellentPbThreadInfo.zan.zansum.longValue());
            tR(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.lms.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.lmz && bg.checkUpIsLogin(e.this.context)) {
                        e.this.lmz = true;
                        e.this.lms.startAnimation(e.this.dig());
                        if (e.this.lmv != null) {
                            e.this.lmv.tN(e.this.lmw);
                        }
                    }
                }
            });
            Q(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.lmv != null) {
                        e.this.lmv.w(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void dif() {
        this.lmz = false;
    }

    public void tQ(boolean z) {
        tR(z);
        if (z) {
            this.lmx++;
        } else {
            this.lmx--;
        }
        gK(this.lmx);
    }

    private void tR(boolean z) {
        this.lmw = z;
        if (z) {
            ap.setImageResource(this.lms, R.drawable.btn_zambia_big_s);
        } else {
            ap.setImageResource(this.lms, R.drawable.btn_zambia_big_n);
        }
        this.lms.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation dig() {
        if (this.lmy == null) {
            this.lmy = AnimationUtils.loadAnimation(this.context, R.anim.praise_animation_scale3);
        }
        return this.lmy;
    }
}
