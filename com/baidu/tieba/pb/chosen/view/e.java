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
/* loaded from: classes7.dex */
public class e {
    private Context context;
    private View ivA;
    private TextView ivB;
    private ImageView ivC;
    private TextView ivD;
    private TextView ivE;
    private a ivF;
    public boolean ivG;
    private Animation ivI;
    private long ivH = 0;
    private boolean ivJ = false;

    /* loaded from: classes7.dex */
    public interface a {
        void pa(boolean z);

        void r(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.ivA = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.ivB = (TextView) this.ivA.findViewById(R.id.chosen_post_info_copyright);
        this.ivC = (ImageView) this.ivA.findViewById(R.id.chosen_post_info_praise_icon);
        this.ivD = (TextView) this.ivA.findViewById(R.id.chosen_post_info_praise_num);
        this.ivE = (TextView) this.ivA.findViewById(R.id.chosen_post_info_original_post);
    }

    public View chz() {
        return this.ivA;
    }

    public void a(a aVar) {
        this.ivF = aVar;
    }

    public void yn(int i) {
        if (this.ivB != null) {
            this.ivB.setText(i);
        }
    }

    public void M(View.OnClickListener onClickListener) {
        if (this.ivE != null) {
            this.ivE.setOnClickListener(onClickListener);
        }
    }

    public void en(long j) {
        if (j >= 0) {
            this.ivH = j;
            if (this.ivD != null) {
                this.ivD.setVisibility(0);
                this.ivD.setText(this.context.getString(R.string.chosen_pb_praise_num, aq.numFormatOver10000(j)));
            }
            if (this.ivD != null && this.ivD.getVisibility() == 8) {
                this.ivD.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            yn(R.string.chosen_pb_copyright);
            en(excellentPbThreadInfo.zan.zansum.longValue());
            pe(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.ivC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.ivJ && bc.checkUpIsLogin(e.this.context)) {
                        e.this.ivJ = true;
                        e.this.ivC.startAnimation(e.this.chB());
                        if (e.this.ivF != null) {
                            e.this.ivF.pa(e.this.ivG);
                        }
                    }
                }
            });
            M(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.ivF != null) {
                        e.this.ivF.r(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void chA() {
        this.ivJ = false;
    }

    public void pd(boolean z) {
        pe(z);
        if (z) {
            this.ivH++;
        } else {
            this.ivH--;
        }
        en(this.ivH);
    }

    private void pe(boolean z) {
        this.ivG = z;
        if (z) {
            am.setImageResource(this.ivC, R.drawable.btn_zambia_big_s);
        } else {
            am.setImageResource(this.ivC, R.drawable.btn_zambia_big_n);
        }
        this.ivC.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation chB() {
        if (this.ivI == null) {
            this.ivI = AnimationUtils.loadAnimation(this.context, R.anim.praise_animation_scale3);
        }
        return this.ivI;
    }
}
