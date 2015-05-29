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
    private TextView aDl;
    private View bJs;
    private TextView bJt;
    private ImageView bJu;
    private TextView bJv;
    private TextView bJw;
    private k bJx;
    private boolean bJy;
    private Animation bJz;
    private Context context;
    private long bbK = 0;
    private boolean bJA = false;

    public h(Context context) {
        this.context = context;
        this.bJs = com.baidu.adp.lib.g.b.hr().inflate(context, r.chosen_pb_post_info, null);
        this.bJt = (TextView) this.bJs.findViewById(q.chosen_post_info_copyright);
        this.bJu = (ImageView) this.bJs.findViewById(q.chosen_post_info_praise_icon);
        this.bJv = (TextView) this.bJs.findViewById(q.chosen_post_info_praise_num);
        this.bJw = (TextView) this.bJs.findViewById(q.chosen_post_info_original_post);
        this.aDl = (TextView) this.bJs.findViewById(q.chosen_post_info_comment);
    }

    public View aan() {
        return this.bJs;
    }

    public void a(k kVar) {
        this.bJx = kVar;
    }

    public void hv(int i) {
        if (this.bJt != null) {
            this.bJt.setText(i);
        }
    }

    public void ak(long j) {
        if (j > 0 && this.aDl != null) {
            this.aDl.setText(this.context.getString(t.chosen_post_follow_post, Long.valueOf(j)));
        }
    }

    public void s(View.OnClickListener onClickListener) {
        if (this.bJw != null) {
            this.bJw.setOnClickListener(onClickListener);
        }
    }

    public void al(long j) {
        if (j >= 0) {
            this.bbK = j;
            if (this.bJv != null) {
                this.bJv.setText(new StringBuilder(String.valueOf(j)).toString());
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
            this.bJu.setOnClickListener(new j(this));
        }
    }

    public void aao() {
        this.bJA = false;
    }

    public void dN(boolean z) {
        dO(z);
        if (z) {
            this.bbK++;
        } else {
            this.bbK--;
        }
        al(this.bbK);
    }

    private void dO(boolean z) {
        this.bJy = z;
        if (z) {
            ay.c(this.bJu, p.icon_hand_yes_s);
        } else {
            ay.c(this.bJu, p.icon_hand_yes_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation aap() {
        if (this.bJz == null) {
            this.bJz = AnimationUtils.loadAnimation(this.context, com.baidu.tieba.k.praise_animation_scale3);
        }
        return this.bJz;
    }
}
