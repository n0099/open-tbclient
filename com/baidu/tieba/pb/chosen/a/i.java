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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.i;
import tbclient.FinePbPage.ForumInfo;
/* loaded from: classes.dex */
public class i {
    private View cfC;
    private TextView cfD;
    private ImageView cfE;
    private TextView cfF;
    private TextView cfG;
    private a cfH;
    private boolean cfI;
    private Animation cfJ;
    private TextView cfL;
    private TextView cfM;
    private LinearLayout cfN;
    private Context context;
    private long btf = 0;
    private boolean cfK = false;

    /* loaded from: classes.dex */
    public interface a {
        void e(long j, String str);

        void ej(boolean z);

        void jD(String str);
    }

    public i(Context context) {
        this.context = context;
        this.cfC = LayoutInflater.from(context).inflate(i.g.chosen_pb_post_info, (ViewGroup) null);
        this.cfD = (TextView) this.cfC.findViewById(i.f.chosen_post_info_copyright);
        this.cfE = (ImageView) this.cfC.findViewById(i.f.chosen_post_info_praise_icon);
        this.cfF = (TextView) this.cfC.findViewById(i.f.chosen_post_info_praise_num);
        this.cfG = (TextView) this.cfC.findViewById(i.f.chosen_post_info_original_post);
        this.cfN = (LinearLayout) this.cfC.findViewById(i.f.chosen_post_info_tag_container);
        this.cfL = (TextView) this.cfC.findViewById(i.f.chosen_post_info_tag);
        this.cfM = (TextView) this.cfC.findViewById(i.f.chosen_post_info_mark);
    }

    public View aeI() {
        return this.cfC;
    }

    public void a(a aVar) {
        this.cfH = aVar;
    }

    public void iH(int i) {
        if (this.cfD != null) {
            this.cfD.setText(i);
        }
    }

    public void y(View.OnClickListener onClickListener) {
        if (this.cfG != null) {
            this.cfG.setOnClickListener(onClickListener);
        }
    }

    public void aI(long j) {
        if (j >= 0) {
            this.btf = j;
            if (this.cfF != null) {
                this.cfF.setText(this.context.getString(i.h.chosen_pb_praise_num, ar.s(j)));
            }
        }
    }

    public void aW(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            this.cfN.setVisibility(8);
            return;
        }
        this.cfN.setVisibility(0);
        this.cfL.setText(this.context.getString(i.h.chosen_pb_tag_abstract, str));
        this.cfN.setOnClickListener(new j(this, str));
        this.cfM.setText(str2);
    }

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            iH(i.h.chosen_pb_copyright);
            aI(forumInfo.zan.zansum.longValue());
            en(forumInfo.zan.is_zan.booleanValue());
            y(new k(this, forumInfo));
            this.cfE.setOnClickListener(new l(this));
        }
    }

    public void aeJ() {
        this.cfK = false;
    }

    public void em(boolean z) {
        en(z);
        if (z) {
            this.btf++;
        } else {
            this.btf--;
        }
        aI(this.btf);
    }

    private void en(boolean z) {
        this.cfI = z;
        if (z) {
            am.c(this.cfE, i.e.btn_zambia_big_s);
        } else {
            am.c(this.cfE, i.e.btn_zambia_big_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation aeK() {
        if (this.cfJ == null) {
            this.cfJ = AnimationUtils.loadAnimation(this.context, i.a.praise_animation_scale3);
        }
        return this.cfJ;
    }
}
