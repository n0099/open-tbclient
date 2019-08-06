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
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.R;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
/* loaded from: classes5.dex */
public class e {
    private Context context;
    private View hHM;
    private TextView hHN;
    private ImageView hHO;
    private TextView hHP;
    private TextView hHQ;
    private a hHR;
    public boolean hHS;
    private Animation hHU;
    private long hHT = 0;
    private boolean hHV = false;

    /* loaded from: classes5.dex */
    public interface a {
        void nY(boolean z);

        void o(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.hHM = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.hHN = (TextView) this.hHM.findViewById(R.id.chosen_post_info_copyright);
        this.hHO = (ImageView) this.hHM.findViewById(R.id.chosen_post_info_praise_icon);
        this.hHP = (TextView) this.hHM.findViewById(R.id.chosen_post_info_praise_num);
        this.hHQ = (TextView) this.hHM.findViewById(R.id.chosen_post_info_original_post);
    }

    public View bSC() {
        return this.hHM;
    }

    public void a(a aVar) {
        this.hHR = aVar;
    }

    public void xE(int i) {
        if (this.hHN != null) {
            this.hHN.setText(i);
        }
    }

    public void K(View.OnClickListener onClickListener) {
        if (this.hHQ != null) {
            this.hHQ.setOnClickListener(onClickListener);
        }
    }

    public void ek(long j) {
        if (j >= 0) {
            this.hHT = j;
            if (this.hHP != null) {
                this.hHP.setVisibility(0);
                this.hHP.setText(this.context.getString(R.string.chosen_pb_praise_num, aq.aM(j)));
            }
            if (this.hHP != null && this.hHP.getVisibility() == 8) {
                this.hHP.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            xE(R.string.chosen_pb_copyright);
            ek(excellentPbThreadInfo.zan.zansum.longValue());
            oc(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.hHO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.hHV && bd.cF(e.this.context)) {
                        e.this.hHV = true;
                        e.this.hHO.startAnimation(e.this.bSE());
                        if (e.this.hHR != null) {
                            e.this.hHR.nY(e.this.hHS);
                        }
                    }
                }
            });
            K(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.hHR != null) {
                        e.this.hHR.o(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void bSD() {
        this.hHV = false;
    }

    public void ob(boolean z) {
        oc(z);
        if (z) {
            this.hHT++;
        } else {
            this.hHT--;
        }
        ek(this.hHT);
    }

    private void oc(boolean z) {
        this.hHS = z;
        if (z) {
            am.c(this.hHO, (int) R.drawable.btn_zambia_big_s);
        } else {
            am.c(this.hHO, (int) R.drawable.btn_zambia_big_n);
        }
        this.hHO.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation bSE() {
        if (this.hHU == null) {
            this.hHU = AnimationUtils.loadAnimation(this.context, R.anim.praise_animation_scale3);
        }
        return this.hHU;
    }
}
