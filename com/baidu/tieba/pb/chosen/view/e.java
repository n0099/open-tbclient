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
    private View hAF;
    private TextView hAG;
    private ImageView hAH;
    private TextView hAI;
    private TextView hAJ;
    private a hAK;
    public boolean hAL;
    private Animation hAN;
    private long hAM = 0;
    private boolean hAO = false;

    /* loaded from: classes5.dex */
    public interface a {
        void nJ(boolean z);

        void o(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.hAF = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.hAG = (TextView) this.hAF.findViewById(R.id.chosen_post_info_copyright);
        this.hAH = (ImageView) this.hAF.findViewById(R.id.chosen_post_info_praise_icon);
        this.hAI = (TextView) this.hAF.findViewById(R.id.chosen_post_info_praise_num);
        this.hAJ = (TextView) this.hAF.findViewById(R.id.chosen_post_info_original_post);
    }

    public View bPC() {
        return this.hAF;
    }

    public void a(a aVar) {
        this.hAK = aVar;
    }

    public void wY(int i) {
        if (this.hAG != null) {
            this.hAG.setText(i);
        }
    }

    public void I(View.OnClickListener onClickListener) {
        if (this.hAJ != null) {
            this.hAJ.setOnClickListener(onClickListener);
        }
    }

    public void ea(long j) {
        if (j >= 0) {
            this.hAM = j;
            if (this.hAI != null) {
                this.hAI.setVisibility(0);
                this.hAI.setText(this.context.getString(R.string.chosen_pb_praise_num, ap.aL(j)));
            }
            if (this.hAI != null && this.hAI.getVisibility() == 8) {
                this.hAI.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            wY(R.string.chosen_pb_copyright);
            ea(excellentPbThreadInfo.zan.zansum.longValue());
            nN(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.hAH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.hAO && bc.cE(e.this.context)) {
                        e.this.hAO = true;
                        e.this.hAH.startAnimation(e.this.bPE());
                        if (e.this.hAK != null) {
                            e.this.hAK.nJ(e.this.hAL);
                        }
                    }
                }
            });
            I(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.hAK != null) {
                        e.this.hAK.o(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void bPD() {
        this.hAO = false;
    }

    public void nM(boolean z) {
        nN(z);
        if (z) {
            this.hAM++;
        } else {
            this.hAM--;
        }
        ea(this.hAM);
    }

    private void nN(boolean z) {
        this.hAL = z;
        if (z) {
            al.c(this.hAH, (int) R.drawable.btn_zambia_big_s);
        } else {
            al.c(this.hAH, (int) R.drawable.btn_zambia_big_n);
        }
        this.hAH.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation bPE() {
        if (this.hAN == null) {
            this.hAN = AnimationUtils.loadAnimation(this.context, R.anim.praise_animation_scale3);
        }
        return this.hAN;
    }
}
