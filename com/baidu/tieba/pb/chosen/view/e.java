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
    private TextView jEA;
    private ImageView jEB;
    private TextView jEC;
    private TextView jED;
    private a jEE;
    public boolean jEF;
    private Animation jEH;
    private View jEz;
    private long jEG = 0;
    private boolean jEI = false;

    /* loaded from: classes10.dex */
    public interface a {
        void qW(boolean z);

        void t(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.jEz = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.jEA = (TextView) this.jEz.findViewById(R.id.chosen_post_info_copyright);
        this.jEB = (ImageView) this.jEz.findViewById(R.id.chosen_post_info_praise_icon);
        this.jEC = (TextView) this.jEz.findViewById(R.id.chosen_post_info_praise_num);
        this.jED = (TextView) this.jEz.findViewById(R.id.chosen_post_info_original_post);
    }

    public View cCr() {
        return this.jEz;
    }

    public void a(a aVar) {
        this.jEE = aVar;
    }

    public void zU(int i) {
        if (this.jEA != null) {
            this.jEA.setText(i);
        }
    }

    public void N(View.OnClickListener onClickListener) {
        if (this.jED != null) {
            this.jED.setOnClickListener(onClickListener);
        }
    }

    public void fe(long j) {
        if (j >= 0) {
            this.jEG = j;
            if (this.jEC != null) {
                this.jEC.setVisibility(0);
                this.jEC.setText(this.context.getString(R.string.chosen_pb_praise_num, aq.numFormatOver10000(j)));
            }
            if (this.jEC != null && this.jEC.getVisibility() == 8) {
                this.jEC.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            zU(R.string.chosen_pb_copyright);
            fe(excellentPbThreadInfo.zan.zansum.longValue());
            ra(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.jEB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.jEI && bc.checkUpIsLogin(e.this.context)) {
                        e.this.jEI = true;
                        e.this.jEB.startAnimation(e.this.cCt());
                        if (e.this.jEE != null) {
                            e.this.jEE.qW(e.this.jEF);
                        }
                    }
                }
            });
            N(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.jEE != null) {
                        e.this.jEE.t(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void cCs() {
        this.jEI = false;
    }

    public void qZ(boolean z) {
        ra(z);
        if (z) {
            this.jEG++;
        } else {
            this.jEG--;
        }
        fe(this.jEG);
    }

    private void ra(boolean z) {
        this.jEF = z;
        if (z) {
            am.setImageResource(this.jEB, R.drawable.btn_zambia_big_s);
        } else {
            am.setImageResource(this.jEB, R.drawable.btn_zambia_big_n);
        }
        this.jEB.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation cCt() {
        if (this.jEH == null) {
            this.jEH = AnimationUtils.loadAnimation(this.context, R.anim.praise_animation_scale3);
        }
        return this.jEH;
    }
}
