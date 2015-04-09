package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.p;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.y;
import tbclient.FinePbPage.ForumInfo;
/* loaded from: classes.dex */
public class e {
    private TextView aBw;
    private ImageView bGA;
    private TextView bGB;
    private TextView bGC;
    private TextView bGD;
    private i bGE;
    private boolean bGF;
    private Animation bGG;
    private View bGy;
    private TextView bGz;
    private Context context;
    private long aZd = 0;
    private boolean bGH = false;

    public e(Context context, View view) {
        this.context = context;
        this.bGy = view;
        this.bGz = (TextView) view.findViewById(v.chosen_post_info_copyright);
        this.bGA = (ImageView) view.findViewById(v.chosen_post_info_praise_icon);
        this.bGB = (TextView) view.findViewById(v.chosen_post_info_praise_num);
        this.bGC = (TextView) view.findViewById(v.chosen_post_info_bar);
        this.bGD = (TextView) view.findViewById(v.chosen_post_info_original_post);
        this.aBw = (TextView) view.findViewById(v.chosen_post_info_comment);
    }

    public void a(i iVar) {
        this.bGE = iVar;
    }

    public void he(int i) {
        if (this.bGz != null) {
            this.bGz.setText(i);
        }
    }

    public void aj(long j) {
        if (j > 0 && this.aBw != null) {
            this.aBw.setText(this.context.getString(y.chosen_post_follow_post, Long.valueOf(j)));
        }
    }

    public void hE(String str) {
        if (this.bGC != null) {
            this.bGC.setText(this.context.getString(y.chosen_pb_original_bar, str));
        }
    }

    public void t(View.OnClickListener onClickListener) {
        if (this.bGD != null) {
            this.bGD.setOnClickListener(onClickListener);
        }
    }

    public void ak(long j) {
        if (j >= 0) {
            this.aZd = j;
            if (this.bGB != null) {
                this.bGB.setText(new StringBuilder(String.valueOf(j)).toString());
            }
        }
    }

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            aj(forumInfo.threadsnum.longValue());
            hE(forumInfo.fromfname);
            he(y.chosen_pb_copyright);
            ak(forumInfo.zan.zansum.longValue());
            dC(forumInfo.zan.is_zan.booleanValue());
            t(new f(this, forumInfo));
            this.bGC.setOnClickListener(new g(this, forumInfo));
            this.bGA.setOnClickListener(new h(this));
        }
    }

    public void YQ() {
        this.bGH = false;
    }

    public void dB(boolean z) {
        dC(z);
        if (z) {
            this.aZd++;
        } else {
            this.aZd--;
        }
        ak(this.aZd);
    }

    private void dC(boolean z) {
        this.bGF = z;
        if (z) {
            ba.c(this.bGA, u.icon_hand_yes_s);
        } else {
            ba.c(this.bGA, u.icon_hand_yes_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation YR() {
        if (this.bGG == null) {
            this.bGG = AnimationUtils.loadAnimation(this.context, p.praise_animation_scale3);
        }
        return this.bGG;
    }
}
