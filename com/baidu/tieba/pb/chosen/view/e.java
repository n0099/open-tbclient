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
    private View kgJ;
    private TextView kgK;
    private ImageView kgL;
    private TextView kgM;
    private TextView kgN;
    private a kgO;
    public boolean kgP;
    private Animation kgR;
    private long kgQ = 0;
    private boolean kgS = false;

    /* loaded from: classes17.dex */
    public interface a {
        void rP(boolean z);

        void v(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.kgJ = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.kgK = (TextView) this.kgJ.findViewById(R.id.chosen_post_info_copyright);
        this.kgL = (ImageView) this.kgJ.findViewById(R.id.chosen_post_info_praise_icon);
        this.kgM = (TextView) this.kgJ.findViewById(R.id.chosen_post_info_praise_num);
        this.kgN = (TextView) this.kgJ.findViewById(R.id.chosen_post_info_original_post);
    }

    public View cKr() {
        return this.kgJ;
    }

    public void a(a aVar) {
        this.kgO = aVar;
    }

    public void Bv(int i) {
        if (this.kgK != null) {
            this.kgK.setText(i);
        }
    }

    public void O(View.OnClickListener onClickListener) {
        if (this.kgN != null) {
            this.kgN.setOnClickListener(onClickListener);
        }
    }

    public void fv(long j) {
        if (j >= 0) {
            this.kgQ = j;
            if (this.kgM != null) {
                this.kgM.setVisibility(0);
                this.kgM.setText(this.context.getString(R.string.chosen_pb_praise_num, as.numFormatOver10000(j)));
            }
            if (this.kgM != null && this.kgM.getVisibility() == 8) {
                this.kgM.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            Bv(R.string.chosen_pb_copyright);
            fv(excellentPbThreadInfo.zan.zansum.longValue());
            rT(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.kgL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.kgS && bf.checkUpIsLogin(e.this.context)) {
                        e.this.kgS = true;
                        e.this.kgL.startAnimation(e.this.cKt());
                        if (e.this.kgO != null) {
                            e.this.kgO.rP(e.this.kgP);
                        }
                    }
                }
            });
            O(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.kgO != null) {
                        e.this.kgO.v(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void cKs() {
        this.kgS = false;
    }

    public void rS(boolean z) {
        rT(z);
        if (z) {
            this.kgQ++;
        } else {
            this.kgQ--;
        }
        fv(this.kgQ);
    }

    private void rT(boolean z) {
        this.kgP = z;
        if (z) {
            ao.setImageResource(this.kgL, R.drawable.btn_zambia_big_s);
        } else {
            ao.setImageResource(this.kgL, R.drawable.btn_zambia_big_n);
        }
        this.kgL.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation cKt() {
        if (this.kgR == null) {
            this.kgR = AnimationUtils.loadAnimation(this.context, R.anim.praise_animation_scale3);
        }
        return this.kgR;
    }
}
