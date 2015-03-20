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
    private TextView aBo;
    private View bGl;
    private TextView bGm;
    private ImageView bGn;
    private TextView bGo;
    private TextView bGp;
    private TextView bGq;
    private i bGr;
    private boolean bGs;
    private Animation bGt;
    private Context context;
    private long aYN = 0;
    private boolean bGu = false;

    public e(Context context, View view) {
        this.context = context;
        this.bGl = view;
        this.bGm = (TextView) view.findViewById(v.chosen_post_info_copyright);
        this.bGn = (ImageView) view.findViewById(v.chosen_post_info_praise_icon);
        this.bGo = (TextView) view.findViewById(v.chosen_post_info_praise_num);
        this.bGp = (TextView) view.findViewById(v.chosen_post_info_bar);
        this.bGq = (TextView) view.findViewById(v.chosen_post_info_original_post);
        this.aBo = (TextView) view.findViewById(v.chosen_post_info_comment);
    }

    public void a(i iVar) {
        this.bGr = iVar;
    }

    public void hc(int i) {
        if (this.bGm != null) {
            this.bGm.setText(i);
        }
    }

    public void aj(long j) {
        if (j > 0 && this.aBo != null) {
            this.aBo.setText(this.context.getString(y.chosen_post_follow_post, Long.valueOf(j)));
        }
    }

    public void hB(String str) {
        if (this.bGp != null) {
            this.bGp.setText(this.context.getString(y.chosen_pb_original_bar, str));
        }
    }

    public void s(View.OnClickListener onClickListener) {
        if (this.bGq != null) {
            this.bGq.setOnClickListener(onClickListener);
        }
    }

    public void ak(long j) {
        if (j >= 0) {
            this.aYN = j;
            if (this.bGo != null) {
                this.bGo.setText(new StringBuilder(String.valueOf(j)).toString());
            }
        }
    }

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            aj(forumInfo.threadsnum.longValue());
            hB(forumInfo.fromfname);
            hc(y.chosen_pb_copyright);
            ak(forumInfo.zan.zansum.longValue());
            dE(forumInfo.zan.is_zan.booleanValue());
            s(new f(this, forumInfo));
            this.bGp.setOnClickListener(new g(this, forumInfo));
            this.bGn.setOnClickListener(new h(this));
        }
    }

    public void YE() {
        this.bGu = false;
    }

    public void dD(boolean z) {
        dE(z);
        if (z) {
            this.aYN++;
        } else {
            this.aYN--;
        }
        ak(this.aYN);
    }

    private void dE(boolean z) {
        this.bGs = z;
        if (z) {
            ba.c(this.bGn, u.icon_hand_yes_s);
        } else {
            ba.c(this.bGn, u.icon_hand_yes_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation YF() {
        if (this.bGt == null) {
            this.bGt = AnimationUtils.loadAnimation(this.context, p.praise_animation_scale3);
        }
        return this.bGt;
    }
}
