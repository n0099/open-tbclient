package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.R;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
/* loaded from: classes7.dex */
public class e {
    private Context context;
    private View lAI;
    private TextView lAJ;
    private ImageView lAK;
    private TextView lAL;
    private TextView lAM;
    private a lAN;
    public boolean lAO;
    private Animation lAQ;
    private long lAP = 0;
    private boolean lAR = false;

    /* loaded from: classes7.dex */
    public interface a {
        void up(boolean z);

        void x(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.lAI = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.lAJ = (TextView) this.lAI.findViewById(R.id.chosen_post_info_copyright);
        this.lAK = (ImageView) this.lAI.findViewById(R.id.chosen_post_info_praise_icon);
        this.lAL = (TextView) this.lAI.findViewById(R.id.chosen_post_info_praise_num);
        this.lAM = (TextView) this.lAI.findViewById(R.id.chosen_post_info_original_post);
    }

    public View diH() {
        return this.lAI;
    }

    public void a(a aVar) {
        this.lAN = aVar;
    }

    public void Fa(int i) {
        if (this.lAJ != null) {
            this.lAJ.setText(i);
        }
    }

    public void R(View.OnClickListener onClickListener) {
        if (this.lAM != null) {
            this.lAM.setOnClickListener(onClickListener);
        }
    }

    public void hn(long j) {
        if (j >= 0) {
            this.lAP = j;
            if (this.lAL != null) {
                this.lAL.setVisibility(0);
                this.lAL.setText(this.context.getString(R.string.chosen_pb_praise_num, at.numFormatOver10000(j)));
            }
            if (this.lAL != null && this.lAL.getVisibility() == 8) {
                this.lAL.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            Fa(R.string.chosen_pb_copyright);
            hn(excellentPbThreadInfo.zan.zansum.longValue());
            ut(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.lAK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.lAR && bg.checkUpIsLogin(e.this.context)) {
                        e.this.lAR = true;
                        e.this.lAK.startAnimation(e.this.diJ());
                        if (e.this.lAN != null) {
                            e.this.lAN.up(e.this.lAO);
                        }
                    }
                }
            });
            R(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.lAN != null) {
                        e.this.lAN.x(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void diI() {
        this.lAR = false;
    }

    public void us(boolean z) {
        ut(z);
        if (z) {
            this.lAP++;
        } else {
            this.lAP--;
        }
        hn(this.lAP);
    }

    private void ut(boolean z) {
        this.lAO = z;
        if (z) {
            ao.setImageResource(this.lAK, R.drawable.btn_zambia_big_s);
        } else {
            ao.setImageResource(this.lAK, R.drawable.btn_zambia_big_n);
        }
        this.lAK.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation diJ() {
        if (this.lAQ == null) {
            this.lAQ = AnimationUtils.loadAnimation(this.context, R.anim.praise_animation_scale3);
        }
        return this.lAQ;
    }
}
