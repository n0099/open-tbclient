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
    private View hJI;
    private TextView hJJ;
    private ImageView hJK;
    private TextView hJL;
    private TextView hJM;
    private a hJN;
    public boolean hJO;
    private Animation hJQ;
    private long hJP = 0;
    private boolean hJR = false;

    /* loaded from: classes5.dex */
    public interface a {
        void o(long j, String str);

        void oc(boolean z);
    }

    public e(Context context) {
        this.context = context;
        this.hJI = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.hJJ = (TextView) this.hJI.findViewById(R.id.chosen_post_info_copyright);
        this.hJK = (ImageView) this.hJI.findViewById(R.id.chosen_post_info_praise_icon);
        this.hJL = (TextView) this.hJI.findViewById(R.id.chosen_post_info_praise_num);
        this.hJM = (TextView) this.hJI.findViewById(R.id.chosen_post_info_original_post);
    }

    public View bTp() {
        return this.hJI;
    }

    public void a(a aVar) {
        this.hJN = aVar;
    }

    public void xH(int i) {
        if (this.hJJ != null) {
            this.hJJ.setText(i);
        }
    }

    public void K(View.OnClickListener onClickListener) {
        if (this.hJM != null) {
            this.hJM.setOnClickListener(onClickListener);
        }
    }

    public void en(long j) {
        if (j >= 0) {
            this.hJP = j;
            if (this.hJL != null) {
                this.hJL.setVisibility(0);
                this.hJL.setText(this.context.getString(R.string.chosen_pb_praise_num, aq.aM(j)));
            }
            if (this.hJL != null && this.hJL.getVisibility() == 8) {
                this.hJL.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            xH(R.string.chosen_pb_copyright);
            en(excellentPbThreadInfo.zan.zansum.longValue());
            og(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.hJK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.hJR && bc.cF(e.this.context)) {
                        e.this.hJR = true;
                        e.this.hJK.startAnimation(e.this.bTr());
                        if (e.this.hJN != null) {
                            e.this.hJN.oc(e.this.hJO);
                        }
                    }
                }
            });
            K(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.hJN != null) {
                        e.this.hJN.o(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void bTq() {
        this.hJR = false;
    }

    public void of(boolean z) {
        og(z);
        if (z) {
            this.hJP++;
        } else {
            this.hJP--;
        }
        en(this.hJP);
    }

    private void og(boolean z) {
        this.hJO = z;
        if (z) {
            am.c(this.hJK, (int) R.drawable.btn_zambia_big_s);
        } else {
            am.c(this.hJK, (int) R.drawable.btn_zambia_big_n);
        }
        this.hJK.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation bTr() {
        if (this.hJQ == null) {
            this.hJQ = AnimationUtils.loadAnimation(this.context, R.anim.praise_animation_scale3);
        }
        return this.hJQ;
    }
}
