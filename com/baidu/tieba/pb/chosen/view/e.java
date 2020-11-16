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
/* loaded from: classes22.dex */
public class e {
    private Context context;
    private View lmG;
    private TextView lmH;
    private ImageView lmI;
    private TextView lmJ;
    private TextView lmK;
    private a lmL;
    public boolean lmM;
    private Animation lmO;
    private long lmN = 0;
    private boolean lmP = false;

    /* loaded from: classes22.dex */
    public interface a {
        void tQ(boolean z);

        void w(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.lmG = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.lmH = (TextView) this.lmG.findViewById(R.id.chosen_post_info_copyright);
        this.lmI = (ImageView) this.lmG.findViewById(R.id.chosen_post_info_praise_icon);
        this.lmJ = (TextView) this.lmG.findViewById(R.id.chosen_post_info_praise_num);
        this.lmK = (TextView) this.lmG.findViewById(R.id.chosen_post_info_original_post);
    }

    public View dhB() {
        return this.lmG;
    }

    public void a(a aVar) {
        this.lmL = aVar;
    }

    public void FZ(int i) {
        if (this.lmH != null) {
            this.lmH.setText(i);
        }
    }

    public void P(View.OnClickListener onClickListener) {
        if (this.lmK != null) {
            this.lmK.setOnClickListener(onClickListener);
        }
    }

    public void gN(long j) {
        if (j >= 0) {
            this.lmN = j;
            if (this.lmJ != null) {
                this.lmJ.setVisibility(0);
                this.lmJ.setText(this.context.getString(R.string.chosen_pb_praise_num, au.numFormatOver10000(j)));
            }
            if (this.lmJ != null && this.lmJ.getVisibility() == 8) {
                this.lmJ.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            FZ(R.string.chosen_pb_copyright);
            gN(excellentPbThreadInfo.zan.zansum.longValue());
            tU(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.lmI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.lmP && bh.checkUpIsLogin(e.this.context)) {
                        e.this.lmP = true;
                        e.this.lmI.startAnimation(e.this.dhD());
                        if (e.this.lmL != null) {
                            e.this.lmL.tQ(e.this.lmM);
                        }
                    }
                }
            });
            P(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.lmL != null) {
                        e.this.lmL.w(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void dhC() {
        this.lmP = false;
    }

    public void tT(boolean z) {
        tU(z);
        if (z) {
            this.lmN++;
        } else {
            this.lmN--;
        }
        gN(this.lmN);
    }

    private void tU(boolean z) {
        this.lmM = z;
        if (z) {
            ap.setImageResource(this.lmI, R.drawable.btn_zambia_big_s);
        } else {
            ap.setImageResource(this.lmI, R.drawable.btn_zambia_big_n);
        }
        this.lmI.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation dhD() {
        if (this.lmO == null) {
            this.lmO = AnimationUtils.loadAnimation(this.context, R.anim.praise_animation_scale3);
        }
        return this.lmO;
    }
}
