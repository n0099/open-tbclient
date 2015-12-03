package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.n;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
/* loaded from: classes.dex */
public class i {
    private Context context;
    private View cyP;
    private TextView cyQ;
    private ImageView cyR;
    private TextView cyS;
    private TextView cyT;
    private a cyU;
    public boolean cyV;
    private Animation cyX;
    private long cyW = 0;
    private boolean cyY = false;

    /* loaded from: classes.dex */
    public interface a {
        void eN(boolean z);

        void g(long j, String str);
    }

    public i(Context context) {
        this.context = context;
        this.cyP = LayoutInflater.from(context).inflate(n.g.chosen_pb_post_info, (ViewGroup) null);
        this.cyQ = (TextView) this.cyP.findViewById(n.f.chosen_post_info_copyright);
        this.cyR = (ImageView) this.cyP.findViewById(n.f.chosen_post_info_praise_icon);
        this.cyS = (TextView) this.cyP.findViewById(n.f.chosen_post_info_praise_num);
        this.cyT = (TextView) this.cyP.findViewById(n.f.chosen_post_info_original_post);
    }

    public View ajr() {
        return this.cyP;
    }

    public void a(a aVar) {
        this.cyU = aVar;
    }

    public void jM(int i) {
        if (this.cyQ != null) {
            this.cyQ.setText(i);
        }
    }

    public void y(View.OnClickListener onClickListener) {
        if (this.cyT != null) {
            this.cyT.setOnClickListener(onClickListener);
        }
    }

    public void bf(long j) {
        if (j >= 0) {
            this.cyW = j;
            if (this.cyS != null) {
                this.cyS.setText(this.context.getString(n.i.chosen_pb_praise_num, ax.w(j)));
            }
        }
    }

    public void a(ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            jM(n.i.chosen_pb_copyright);
            bf(excellentPbThreadInfo.zan.zansum.longValue());
            eR(excellentPbThreadInfo.zan.is_zan.booleanValue());
            y(new j(this, excellentPbThreadInfo));
            this.cyR.setOnClickListener(new k(this));
        }
    }

    public void ajs() {
        this.cyY = false;
    }

    public void eQ(boolean z) {
        eR(z);
        if (z) {
            this.cyW++;
        } else {
            this.cyW--;
        }
        bf(this.cyW);
    }

    private void eR(boolean z) {
        this.cyV = z;
        if (z) {
            as.c(this.cyR, n.e.btn_zambia_big_s);
        } else {
            as.c(this.cyR, n.e.btn_zambia_big_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation ajt() {
        if (this.cyX == null) {
            this.cyX = AnimationUtils.loadAnimation(this.context, n.a.praise_animation_scale3);
        }
        return this.cyX;
    }
}
