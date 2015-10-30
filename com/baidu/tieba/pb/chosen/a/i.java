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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.i;
import tbclient.FinePbPage.ForumInfo;
/* loaded from: classes.dex */
public class i {
    private View cfN;
    private TextView cfO;
    private ImageView cfP;
    private TextView cfQ;
    private TextView cfR;
    private a cfS;
    private boolean cfT;
    private Animation cfU;
    private TextView cfW;
    private TextView cfX;
    private LinearLayout cfY;
    private Context context;
    private long btq = 0;
    private boolean cfV = false;

    /* loaded from: classes.dex */
    public interface a {
        void e(long j, String str);

        void ej(boolean z);

        void jD(String str);
    }

    public i(Context context) {
        this.context = context;
        this.cfN = LayoutInflater.from(context).inflate(i.g.chosen_pb_post_info, (ViewGroup) null);
        this.cfO = (TextView) this.cfN.findViewById(i.f.chosen_post_info_copyright);
        this.cfP = (ImageView) this.cfN.findViewById(i.f.chosen_post_info_praise_icon);
        this.cfQ = (TextView) this.cfN.findViewById(i.f.chosen_post_info_praise_num);
        this.cfR = (TextView) this.cfN.findViewById(i.f.chosen_post_info_original_post);
        this.cfY = (LinearLayout) this.cfN.findViewById(i.f.chosen_post_info_tag_container);
        this.cfW = (TextView) this.cfN.findViewById(i.f.chosen_post_info_tag);
        this.cfX = (TextView) this.cfN.findViewById(i.f.chosen_post_info_mark);
    }

    public View aeE() {
        return this.cfN;
    }

    public void a(a aVar) {
        this.cfS = aVar;
    }

    public void iH(int i) {
        if (this.cfO != null) {
            this.cfO.setText(i);
        }
    }

    public void y(View.OnClickListener onClickListener) {
        if (this.cfR != null) {
            this.cfR.setOnClickListener(onClickListener);
        }
    }

    public void aQ(long j) {
        if (j >= 0) {
            this.btq = j;
            if (this.cfQ != null) {
                this.cfQ.setText(this.context.getString(i.h.chosen_pb_praise_num, as.q(j)));
            }
        }
    }

    public void aW(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            this.cfY.setVisibility(8);
            return;
        }
        this.cfY.setVisibility(0);
        this.cfW.setText(this.context.getString(i.h.chosen_pb_tag_abstract, str));
        this.cfY.setOnClickListener(new j(this, str));
        this.cfX.setText(str2);
    }

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            iH(i.h.chosen_pb_copyright);
            aQ(forumInfo.zan.zansum.longValue());
            en(forumInfo.zan.is_zan.booleanValue());
            y(new k(this, forumInfo));
            this.cfP.setOnClickListener(new l(this));
        }
    }

    public void aeF() {
        this.cfV = false;
    }

    public void em(boolean z) {
        en(z);
        if (z) {
            this.btq++;
        } else {
            this.btq--;
        }
        aQ(this.btq);
    }

    private void en(boolean z) {
        this.cfT = z;
        if (z) {
            an.c(this.cfP, i.e.btn_zambia_big_s);
        } else {
            an.c(this.cfP, i.e.btn_zambia_big_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation aeG() {
        if (this.cfU == null) {
            this.cfU = AnimationUtils.loadAnimation(this.context, i.a.praise_animation_scale3);
        }
        return this.cfU;
    }
}
