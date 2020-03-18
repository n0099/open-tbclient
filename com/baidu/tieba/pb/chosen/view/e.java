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
    private View iCN;
    private TextView iCO;
    private ImageView iCP;
    private TextView iCQ;
    private TextView iCR;
    private a iCS;
    public boolean iCT;
    private Animation iCV;
    private long iCU = 0;
    private boolean iCW = false;

    /* loaded from: classes10.dex */
    public interface a {
        void pv(boolean z);

        void r(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.iCN = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.iCO = (TextView) this.iCN.findViewById(R.id.chosen_post_info_copyright);
        this.iCP = (ImageView) this.iCN.findViewById(R.id.chosen_post_info_praise_icon);
        this.iCQ = (TextView) this.iCN.findViewById(R.id.chosen_post_info_praise_num);
        this.iCR = (TextView) this.iCN.findViewById(R.id.chosen_post_info_original_post);
    }

    public View ckI() {
        return this.iCN;
    }

    public void a(a aVar) {
        this.iCS = aVar;
    }

    public void yH(int i) {
        if (this.iCO != null) {
            this.iCO.setText(i);
        }
    }

    public void M(View.OnClickListener onClickListener) {
        if (this.iCR != null) {
            this.iCR.setOnClickListener(onClickListener);
        }
    }

    public void et(long j) {
        if (j >= 0) {
            this.iCU = j;
            if (this.iCQ != null) {
                this.iCQ.setVisibility(0);
                this.iCQ.setText(this.context.getString(R.string.chosen_pb_praise_num, aq.numFormatOver10000(j)));
            }
            if (this.iCQ != null && this.iCQ.getVisibility() == 8) {
                this.iCQ.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            yH(R.string.chosen_pb_copyright);
            et(excellentPbThreadInfo.zan.zansum.longValue());
            pz(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.iCP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.iCW && bc.checkUpIsLogin(e.this.context)) {
                        e.this.iCW = true;
                        e.this.iCP.startAnimation(e.this.ckK());
                        if (e.this.iCS != null) {
                            e.this.iCS.pv(e.this.iCT);
                        }
                    }
                }
            });
            M(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.iCS != null) {
                        e.this.iCS.r(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void ckJ() {
        this.iCW = false;
    }

    public void py(boolean z) {
        pz(z);
        if (z) {
            this.iCU++;
        } else {
            this.iCU--;
        }
        et(this.iCU);
    }

    private void pz(boolean z) {
        this.iCT = z;
        if (z) {
            am.setImageResource(this.iCP, R.drawable.btn_zambia_big_s);
        } else {
            am.setImageResource(this.iCP, R.drawable.btn_zambia_big_n);
        }
        this.iCP.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation ckK() {
        if (this.iCV == null) {
            this.iCV = AnimationUtils.loadAnimation(this.context, R.anim.praise_animation_scale3);
        }
        return this.iCV;
    }
}
