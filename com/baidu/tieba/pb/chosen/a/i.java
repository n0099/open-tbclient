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
    private TextView caA;
    private TextView caB;
    private a caC;
    private boolean caD;
    private Animation caE;
    private TextView caG;
    private TextView caH;
    private LinearLayout caI;
    private View cax;
    private TextView cay;
    private ImageView caz;
    private Context context;
    private long bqe = 0;
    private boolean caF = false;

    /* loaded from: classes.dex */
    public interface a {
        void d(long j, String str);

        void ee(boolean z);

        void jl(String str);
    }

    public i(Context context) {
        this.context = context;
        this.cax = LayoutInflater.from(context).inflate(i.g.chosen_pb_post_info, (ViewGroup) null);
        this.cay = (TextView) this.cax.findViewById(i.f.chosen_post_info_copyright);
        this.caz = (ImageView) this.cax.findViewById(i.f.chosen_post_info_praise_icon);
        this.caA = (TextView) this.cax.findViewById(i.f.chosen_post_info_praise_num);
        this.caB = (TextView) this.cax.findViewById(i.f.chosen_post_info_original_post);
        this.caI = (LinearLayout) this.cax.findViewById(i.f.chosen_post_info_tag_container);
        this.caG = (TextView) this.cax.findViewById(i.f.chosen_post_info_tag);
        this.caH = (TextView) this.cax.findViewById(i.f.chosen_post_info_mark);
    }

    public View acL() {
        return this.cax;
    }

    public void a(a aVar) {
        this.caC = aVar;
    }

    public void ix(int i) {
        if (this.cay != null) {
            this.cay.setText(i);
        }
    }

    public void x(View.OnClickListener onClickListener) {
        if (this.caB != null) {
            this.caB.setOnClickListener(onClickListener);
        }
    }

    public void au(long j) {
        if (j >= 0) {
            this.bqe = j;
            if (this.caA != null) {
                this.caA.setText(this.context.getString(i.h.chosen_pb_praise_num, aq.o(j)));
            }
        }
    }

    public void aW(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            this.caI.setVisibility(8);
            return;
        }
        this.caI.setVisibility(0);
        this.caG.setText(this.context.getString(i.h.chosen_pb_tag_abstract, str));
        this.caI.setOnClickListener(new j(this, str));
        this.caH.setText(str2);
    }

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            ix(i.h.chosen_pb_copyright);
            au(forumInfo.zan.zansum.longValue());
            ei(forumInfo.zan.is_zan.booleanValue());
            x(new k(this, forumInfo));
            this.caz.setOnClickListener(new l(this));
        }
    }

    public void acM() {
        this.caF = false;
    }

    public void eh(boolean z) {
        ei(z);
        if (z) {
            this.bqe++;
        } else {
            this.bqe--;
        }
        au(this.bqe);
    }

    private void ei(boolean z) {
        this.caD = z;
        if (z) {
            al.c(this.caz, i.e.btn_zambia_big_s);
        } else {
            al.c(this.caz, i.e.btn_zambia_big_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation acN() {
        if (this.caE == null) {
            this.caE = AnimationUtils.loadAnimation(this.context, i.a.praise_animation_scale3);
        }
        return this.caE;
    }
}
