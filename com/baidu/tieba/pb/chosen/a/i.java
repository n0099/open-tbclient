package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.i;
import tbclient.FinePbPage.ForumInfo;
/* loaded from: classes.dex */
public class i {
    private View bZD;
    private TextView bZE;
    private ImageView bZF;
    private TextView bZG;
    private TextView bZH;
    private a bZI;
    private boolean bZJ;
    private Animation bZK;
    private TextView bZM;
    private TextView bZN;
    private LinearLayout bZO;
    private Context context;
    private long bpG = 0;
    private boolean bZL = false;

    /* loaded from: classes.dex */
    public interface a {
        void d(long j, String str);

        void dX(boolean z);

        void jd(String str);
    }

    public i(Context context) {
        this.context = context;
        this.bZD = LayoutInflater.from(context).inflate(i.g.chosen_pb_post_info, (ViewGroup) null);
        this.bZE = (TextView) this.bZD.findViewById(i.f.chosen_post_info_copyright);
        this.bZF = (ImageView) this.bZD.findViewById(i.f.chosen_post_info_praise_icon);
        this.bZG = (TextView) this.bZD.findViewById(i.f.chosen_post_info_praise_num);
        this.bZH = (TextView) this.bZD.findViewById(i.f.chosen_post_info_original_post);
        this.bZO = (LinearLayout) this.bZD.findViewById(i.f.chosen_post_info_tag_container);
        this.bZM = (TextView) this.bZD.findViewById(i.f.chosen_post_info_tag);
        this.bZN = (TextView) this.bZD.findViewById(i.f.chosen_post_info_mark);
    }

    public View acC() {
        return this.bZD;
    }

    public void a(a aVar) {
        this.bZI = aVar;
    }

    public void im(int i) {
        if (this.bZE != null) {
            this.bZE.setText(i);
        }
    }

    public void y(View.OnClickListener onClickListener) {
        if (this.bZH != null) {
            this.bZH.setOnClickListener(onClickListener);
        }
    }

    public void at(long j) {
        if (j >= 0) {
            this.bpG = j;
            if (this.bZG != null) {
                this.bZG.setText(this.context.getString(i.C0057i.chosen_pb_praise_num, aq.o(j)));
            }
        }
    }

    public void aU(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            this.bZO.setVisibility(8);
            return;
        }
        this.bZO.setVisibility(0);
        this.bZM.setText(this.context.getString(i.C0057i.chosen_pb_tag_abstract, str));
        this.bZO.setOnClickListener(new j(this, str));
        this.bZN.setText(str2);
    }

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            im(i.C0057i.chosen_pb_copyright);
            at(forumInfo.zan.zansum.longValue());
            eb(forumInfo.zan.is_zan.booleanValue());
            y(new k(this, forumInfo));
            this.bZF.setOnClickListener(new l(this));
        }
    }

    public void acD() {
        this.bZL = false;
    }

    public void ea(boolean z) {
        eb(z);
        if (z) {
            this.bpG++;
        } else {
            this.bpG--;
        }
        at(this.bpG);
    }

    private void eb(boolean z) {
        this.bZJ = z;
        if (z) {
            al.c(this.bZF, i.e.btn_zambia_big_s);
        } else {
            al.c(this.bZF, i.e.btn_zambia_big_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation acE() {
        if (this.bZK == null) {
            this.bZK = AnimationUtils.loadAnimation(this.context, i.a.praise_animation_scale3);
        }
        return this.bZK;
    }
}
