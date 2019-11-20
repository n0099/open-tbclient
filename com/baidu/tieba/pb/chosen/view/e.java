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
/* loaded from: classes5.dex */
public class e {
    private Context context;
    private TextView hHA;
    private a hHB;
    public boolean hHC;
    private Animation hHE;
    private View hHw;
    private TextView hHx;
    private ImageView hHy;
    private TextView hHz;
    private long hHD = 0;
    private boolean hHF = false;

    /* loaded from: classes5.dex */
    public interface a {
        void nM(boolean z);

        void q(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.hHw = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.hHx = (TextView) this.hHw.findViewById(R.id.chosen_post_info_copyright);
        this.hHy = (ImageView) this.hHw.findViewById(R.id.chosen_post_info_praise_icon);
        this.hHz = (TextView) this.hHw.findViewById(R.id.chosen_post_info_praise_num);
        this.hHA = (TextView) this.hHw.findViewById(R.id.chosen_post_info_original_post);
    }

    public View bQo() {
        return this.hHw;
    }

    public void a(a aVar) {
        this.hHB = aVar;
    }

    public void wm(int i) {
        if (this.hHx != null) {
            this.hHx.setText(i);
        }
    }

    public void L(View.OnClickListener onClickListener) {
        if (this.hHA != null) {
            this.hHA.setOnClickListener(onClickListener);
        }
    }

    public void dH(long j) {
        if (j >= 0) {
            this.hHD = j;
            if (this.hHz != null) {
                this.hHz.setVisibility(0);
                this.hHz.setText(this.context.getString(R.string.chosen_pb_praise_num, aq.numFormatOver10000(j)));
            }
            if (this.hHz != null && this.hHz.getVisibility() == 8) {
                this.hHz.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            wm(R.string.chosen_pb_copyright);
            dH(excellentPbThreadInfo.zan.zansum.longValue());
            nQ(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.hHy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.hHF && bc.checkUpIsLogin(e.this.context)) {
                        e.this.hHF = true;
                        e.this.hHy.startAnimation(e.this.bQq());
                        if (e.this.hHB != null) {
                            e.this.hHB.nM(e.this.hHC);
                        }
                    }
                }
            });
            L(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.hHB != null) {
                        e.this.hHB.q(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void bQp() {
        this.hHF = false;
    }

    public void nP(boolean z) {
        nQ(z);
        if (z) {
            this.hHD++;
        } else {
            this.hHD--;
        }
        dH(this.hHD);
    }

    private void nQ(boolean z) {
        this.hHC = z;
        if (z) {
            am.setImageResource(this.hHy, R.drawable.btn_zambia_big_s);
        } else {
            am.setImageResource(this.hHy, R.drawable.btn_zambia_big_n);
        }
        this.hHy.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation bQq() {
        if (this.hHE == null) {
            this.hHE = AnimationUtils.loadAnimation(this.context, R.anim.praise_animation_scale3);
        }
        return this.hHE;
    }
}
