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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
/* loaded from: classes5.dex */
public class e {
    private Context context;
    private View hAG;
    private TextView hAH;
    private ImageView hAI;
    private TextView hAJ;
    private TextView hAK;
    private a hAL;
    public boolean hAM;
    private Animation hAO;
    private long hAN = 0;
    private boolean hAP = false;

    /* loaded from: classes5.dex */
    public interface a {
        void nK(boolean z);

        void o(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.hAG = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.hAH = (TextView) this.hAG.findViewById(R.id.chosen_post_info_copyright);
        this.hAI = (ImageView) this.hAG.findViewById(R.id.chosen_post_info_praise_icon);
        this.hAJ = (TextView) this.hAG.findViewById(R.id.chosen_post_info_praise_num);
        this.hAK = (TextView) this.hAG.findViewById(R.id.chosen_post_info_original_post);
    }

    public View bPD() {
        return this.hAG;
    }

    public void a(a aVar) {
        this.hAL = aVar;
    }

    public void wY(int i) {
        if (this.hAH != null) {
            this.hAH.setText(i);
        }
    }

    public void I(View.OnClickListener onClickListener) {
        if (this.hAK != null) {
            this.hAK.setOnClickListener(onClickListener);
        }
    }

    public void ea(long j) {
        if (j >= 0) {
            this.hAN = j;
            if (this.hAJ != null) {
                this.hAJ.setVisibility(0);
                this.hAJ.setText(this.context.getString(R.string.chosen_pb_praise_num, ap.aL(j)));
            }
            if (this.hAJ != null && this.hAJ.getVisibility() == 8) {
                this.hAJ.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            wY(R.string.chosen_pb_copyright);
            ea(excellentPbThreadInfo.zan.zansum.longValue());
            nO(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.hAI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.hAP && bc.cE(e.this.context)) {
                        e.this.hAP = true;
                        e.this.hAI.startAnimation(e.this.bPF());
                        if (e.this.hAL != null) {
                            e.this.hAL.nK(e.this.hAM);
                        }
                    }
                }
            });
            I(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.hAL != null) {
                        e.this.hAL.o(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void bPE() {
        this.hAP = false;
    }

    public void nN(boolean z) {
        nO(z);
        if (z) {
            this.hAN++;
        } else {
            this.hAN--;
        }
        ea(this.hAN);
    }

    private void nO(boolean z) {
        this.hAM = z;
        if (z) {
            al.c(this.hAI, (int) R.drawable.btn_zambia_big_s);
        } else {
            al.c(this.hAI, (int) R.drawable.btn_zambia_big_n);
        }
        this.hAI.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation bPF() {
        if (this.hAO == null) {
            this.hAO = AnimationUtils.loadAnimation(this.context, R.anim.praise_animation_scale3);
        }
        return this.hAO;
    }
}
