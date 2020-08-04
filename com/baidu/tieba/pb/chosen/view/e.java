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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.R;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
/* loaded from: classes17.dex */
public class e {
    private Context context;
    private View kgL;
    private TextView kgM;
    private ImageView kgN;
    private TextView kgO;
    private TextView kgP;
    private a kgQ;
    public boolean kgR;
    private Animation kgT;
    private long kgS = 0;
    private boolean kgU = false;

    /* loaded from: classes17.dex */
    public interface a {
        void rP(boolean z);

        void v(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.kgL = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.kgM = (TextView) this.kgL.findViewById(R.id.chosen_post_info_copyright);
        this.kgN = (ImageView) this.kgL.findViewById(R.id.chosen_post_info_praise_icon);
        this.kgO = (TextView) this.kgL.findViewById(R.id.chosen_post_info_praise_num);
        this.kgP = (TextView) this.kgL.findViewById(R.id.chosen_post_info_original_post);
    }

    public View cKr() {
        return this.kgL;
    }

    public void a(a aVar) {
        this.kgQ = aVar;
    }

    public void Bv(int i) {
        if (this.kgM != null) {
            this.kgM.setText(i);
        }
    }

    public void O(View.OnClickListener onClickListener) {
        if (this.kgP != null) {
            this.kgP.setOnClickListener(onClickListener);
        }
    }

    public void fv(long j) {
        if (j >= 0) {
            this.kgS = j;
            if (this.kgO != null) {
                this.kgO.setVisibility(0);
                this.kgO.setText(this.context.getString(R.string.chosen_pb_praise_num, as.numFormatOver10000(j)));
            }
            if (this.kgO != null && this.kgO.getVisibility() == 8) {
                this.kgO.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            Bv(R.string.chosen_pb_copyright);
            fv(excellentPbThreadInfo.zan.zansum.longValue());
            rT(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.kgN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.kgU && bf.checkUpIsLogin(e.this.context)) {
                        e.this.kgU = true;
                        e.this.kgN.startAnimation(e.this.cKt());
                        if (e.this.kgQ != null) {
                            e.this.kgQ.rP(e.this.kgR);
                        }
                    }
                }
            });
            O(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.kgQ != null) {
                        e.this.kgQ.v(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void cKs() {
        this.kgU = false;
    }

    public void rS(boolean z) {
        rT(z);
        if (z) {
            this.kgS++;
        } else {
            this.kgS--;
        }
        fv(this.kgS);
    }

    private void rT(boolean z) {
        this.kgR = z;
        if (z) {
            ao.setImageResource(this.kgN, R.drawable.btn_zambia_big_s);
        } else {
            ao.setImageResource(this.kgN, R.drawable.btn_zambia_big_n);
        }
        this.kgN.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation cKt() {
        if (this.kgT == null) {
            this.kgT = AnimationUtils.loadAnimation(this.context, R.anim.praise_animation_scale3);
        }
        return this.kgT;
    }
}
