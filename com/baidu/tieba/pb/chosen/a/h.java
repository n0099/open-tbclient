package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import tbclient.FinePbPage.ForumInfo;
/* loaded from: classes.dex */
public class h {
    private TextView aDm;
    private Animation bJA;
    private View bJt;
    private TextView bJu;
    private ImageView bJv;
    private TextView bJw;
    private TextView bJx;
    private k bJy;
    private boolean bJz;
    private Context context;
    private long bbL = 0;
    private boolean bJB = false;

    public h(Context context) {
        this.context = context;
        this.bJt = com.baidu.adp.lib.g.b.hr().inflate(context, r.chosen_pb_post_info, null);
        this.bJu = (TextView) this.bJt.findViewById(q.chosen_post_info_copyright);
        this.bJv = (ImageView) this.bJt.findViewById(q.chosen_post_info_praise_icon);
        this.bJw = (TextView) this.bJt.findViewById(q.chosen_post_info_praise_num);
        this.bJx = (TextView) this.bJt.findViewById(q.chosen_post_info_original_post);
        this.aDm = (TextView) this.bJt.findViewById(q.chosen_post_info_comment);
    }

    public View aao() {
        return this.bJt;
    }

    public void a(k kVar) {
        this.bJy = kVar;
    }

    public void hv(int i) {
        if (this.bJu != null) {
            this.bJu.setText(i);
        }
    }

    public void ak(long j) {
        if (j > 0 && this.aDm != null) {
            this.aDm.setText(this.context.getString(t.chosen_post_follow_post, Long.valueOf(j)));
        }
    }

    public void s(View.OnClickListener onClickListener) {
        if (this.bJx != null) {
            this.bJx.setOnClickListener(onClickListener);
        }
    }

    public void al(long j) {
        if (j >= 0) {
            this.bbL = j;
            if (this.bJw != null) {
                this.bJw.setText(new StringBuilder(String.valueOf(j)).toString());
            }
        }
    }

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            ak(forumInfo.threadsnum.longValue());
            hv(t.chosen_pb_copyright);
            al(forumInfo.zan.zansum.longValue());
            dO(forumInfo.zan.is_zan.booleanValue());
            s(new i(this, forumInfo));
            this.bJv.setOnClickListener(new j(this));
        }
    }

    public void aap() {
        this.bJB = false;
    }

    public void dN(boolean z) {
        dO(z);
        if (z) {
            this.bbL++;
        } else {
            this.bbL--;
        }
        al(this.bbL);
    }

    private void dO(boolean z) {
        this.bJz = z;
        if (z) {
            ay.c(this.bJv, p.icon_hand_yes_s);
        } else {
            ay.c(this.bJv, p.icon_hand_yes_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation aaq() {
        if (this.bJA == null) {
            this.bJA = AnimationUtils.loadAnimation(this.context, com.baidu.tieba.k.praise_animation_scale3);
        }
        return this.bJA;
    }
}
