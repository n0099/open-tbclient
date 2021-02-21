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
/* loaded from: classes8.dex */
public class e {
    private Context context;
    private View lJJ;
    private TextView lJK;
    private ImageView lJL;
    private TextView lJM;
    private TextView lJN;
    private a lJO;
    public boolean lJP;
    private Animation lJR;
    private long lJQ = 0;
    private boolean lJS = false;

    /* loaded from: classes8.dex */
    public interface a {
        void uC(boolean z);

        void y(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.lJJ = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.lJK = (TextView) this.lJJ.findViewById(R.id.chosen_post_info_copyright);
        this.lJL = (ImageView) this.lJJ.findViewById(R.id.chosen_post_info_praise_icon);
        this.lJM = (TextView) this.lJJ.findViewById(R.id.chosen_post_info_praise_num);
        this.lJN = (TextView) this.lJJ.findViewById(R.id.chosen_post_info_original_post);
    }

    public View dla() {
        return this.lJJ;
    }

    public void a(a aVar) {
        this.lJO = aVar;
    }

    public void Ft(int i) {
        if (this.lJK != null) {
            this.lJK.setText(i);
        }
    }

    public void R(View.OnClickListener onClickListener) {
        if (this.lJN != null) {
            this.lJN.setOnClickListener(onClickListener);
        }
    }

    public void hs(long j) {
        if (j >= 0) {
            this.lJQ = j;
            if (this.lJM != null) {
                this.lJM.setVisibility(0);
                this.lJM.setText(this.context.getString(R.string.chosen_pb_praise_num, au.numFormatOver10000(j)));
            }
            if (this.lJM != null && this.lJM.getVisibility() == 8) {
                this.lJM.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            Ft(R.string.chosen_pb_copyright);
            hs(excellentPbThreadInfo.zan.zansum.longValue());
            uG(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.lJL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.lJS && bh.checkUpIsLogin(e.this.context)) {
                        e.this.lJS = true;
                        e.this.lJL.startAnimation(e.this.dlc());
                        if (e.this.lJO != null) {
                            e.this.lJO.uC(e.this.lJP);
                        }
                    }
                }
            });
            R(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.lJO != null) {
                        e.this.lJO.y(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void dlb() {
        this.lJS = false;
    }

    public void uF(boolean z) {
        uG(z);
        if (z) {
            this.lJQ++;
        } else {
            this.lJQ--;
        }
        hs(this.lJQ);
    }

    private void uG(boolean z) {
        this.lJP = z;
        if (z) {
            ap.setImageResource(this.lJL, R.drawable.btn_zambia_big_s);
        } else {
            ap.setImageResource(this.lJL, R.drawable.btn_zambia_big_n);
        }
        this.lJL.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation dlc() {
        if (this.lJR == null) {
            this.lJR = AnimationUtils.loadAnimation(this.context, R.anim.praise_animation_scale3);
        }
        return this.lJR;
    }
}
