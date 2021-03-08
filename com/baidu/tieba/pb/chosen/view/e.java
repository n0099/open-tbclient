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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.R;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
/* loaded from: classes7.dex */
public class e {
    private Context context;
    private View lLL;
    private TextView lLM;
    private ImageView lLN;
    private TextView lLO;
    private TextView lLP;
    private a lLQ;
    public boolean lLR;
    private Animation lLT;
    private long lLS = 0;
    private boolean lLU = false;

    /* loaded from: classes7.dex */
    public interface a {
        void uC(boolean z);

        void y(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.lLL = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.lLM = (TextView) this.lLL.findViewById(R.id.chosen_post_info_copyright);
        this.lLN = (ImageView) this.lLL.findViewById(R.id.chosen_post_info_praise_icon);
        this.lLO = (TextView) this.lLL.findViewById(R.id.chosen_post_info_praise_num);
        this.lLP = (TextView) this.lLL.findViewById(R.id.chosen_post_info_original_post);
    }

    public View dlj() {
        return this.lLL;
    }

    public void a(a aVar) {
        this.lLQ = aVar;
    }

    public void Fw(int i) {
        if (this.lLM != null) {
            this.lLM.setText(i);
        }
    }

    public void S(View.OnClickListener onClickListener) {
        if (this.lLP != null) {
            this.lLP.setOnClickListener(onClickListener);
        }
    }

    public void hs(long j) {
        if (j >= 0) {
            this.lLS = j;
            if (this.lLO != null) {
                this.lLO.setVisibility(0);
                this.lLO.setText(this.context.getString(R.string.chosen_pb_praise_num, au.numFormatOver10000(j)));
            }
            if (this.lLO != null && this.lLO.getVisibility() == 8) {
                this.lLO.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            Fw(R.string.chosen_pb_copyright);
            hs(excellentPbThreadInfo.zan.zansum.longValue());
            uG(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.lLN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.lLU && bh.checkUpIsLogin(e.this.context)) {
                        e.this.lLU = true;
                        e.this.lLN.startAnimation(e.this.dll());
                        if (e.this.lLQ != null) {
                            e.this.lLQ.uC(e.this.lLR);
                        }
                    }
                }
            });
            S(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.lLQ != null) {
                        e.this.lLQ.y(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void dlk() {
        this.lLU = false;
    }

    public void uF(boolean z) {
        uG(z);
        if (z) {
            this.lLS++;
        } else {
            this.lLS--;
        }
        hs(this.lLS);
    }

    private void uG(boolean z) {
        this.lLR = z;
        if (z) {
            ap.setImageResource(this.lLN, R.drawable.btn_zambia_big_s);
        } else {
            ap.setImageResource(this.lLN, R.drawable.btn_zambia_big_n);
        }
        this.lLN.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation dll() {
        if (this.lLT == null) {
            this.lLT = AnimationUtils.loadAnimation(this.context, R.anim.praise_animation_scale3);
        }
        return this.lLT;
    }
}
