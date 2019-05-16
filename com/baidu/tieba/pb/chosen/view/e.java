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
    private View hAC;
    private TextView hAD;
    private ImageView hAE;
    private TextView hAF;
    private TextView hAG;
    private a hAH;
    public boolean hAI;
    private Animation hAK;
    private long hAJ = 0;
    private boolean hAL = false;

    /* loaded from: classes5.dex */
    public interface a {
        void nJ(boolean z);

        void o(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.hAC = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.hAD = (TextView) this.hAC.findViewById(R.id.chosen_post_info_copyright);
        this.hAE = (ImageView) this.hAC.findViewById(R.id.chosen_post_info_praise_icon);
        this.hAF = (TextView) this.hAC.findViewById(R.id.chosen_post_info_praise_num);
        this.hAG = (TextView) this.hAC.findViewById(R.id.chosen_post_info_original_post);
    }

    public View bPz() {
        return this.hAC;
    }

    public void a(a aVar) {
        this.hAH = aVar;
    }

    public void wY(int i) {
        if (this.hAD != null) {
            this.hAD.setText(i);
        }
    }

    public void I(View.OnClickListener onClickListener) {
        if (this.hAG != null) {
            this.hAG.setOnClickListener(onClickListener);
        }
    }

    public void ea(long j) {
        if (j >= 0) {
            this.hAJ = j;
            if (this.hAF != null) {
                this.hAF.setVisibility(0);
                this.hAF.setText(this.context.getString(R.string.chosen_pb_praise_num, ap.aL(j)));
            }
            if (this.hAF != null && this.hAF.getVisibility() == 8) {
                this.hAF.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            wY(R.string.chosen_pb_copyright);
            ea(excellentPbThreadInfo.zan.zansum.longValue());
            nN(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.hAE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.hAL && bc.cE(e.this.context)) {
                        e.this.hAL = true;
                        e.this.hAE.startAnimation(e.this.bPB());
                        if (e.this.hAH != null) {
                            e.this.hAH.nJ(e.this.hAI);
                        }
                    }
                }
            });
            I(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.hAH != null) {
                        e.this.hAH.o(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void bPA() {
        this.hAL = false;
    }

    public void nM(boolean z) {
        nN(z);
        if (z) {
            this.hAJ++;
        } else {
            this.hAJ--;
        }
        ea(this.hAJ);
    }

    private void nN(boolean z) {
        this.hAI = z;
        if (z) {
            al.c(this.hAE, (int) R.drawable.btn_zambia_big_s);
        } else {
            al.c(this.hAE, (int) R.drawable.btn_zambia_big_n);
        }
        this.hAE.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation bPB() {
        if (this.hAK == null) {
            this.hAK = AnimationUtils.loadAnimation(this.context, R.anim.praise_animation_scale3);
        }
        return this.hAK;
    }
}
