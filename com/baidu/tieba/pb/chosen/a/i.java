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
    private LinearLayout cgA;
    private View cgo;
    private TextView cgp;
    private ImageView cgq;
    private TextView cgr;
    private TextView cgs;
    private a cgt;
    private boolean cgu;
    private Animation cgw;
    private TextView cgy;
    private TextView cgz;
    private Context context;
    private long cgv = 0;
    private boolean cgx = false;

    /* loaded from: classes.dex */
    public interface a {
        void e(long j, String str);

        void el(boolean z);

        void jF(String str);
    }

    public i(Context context) {
        this.context = context;
        this.cgo = LayoutInflater.from(context).inflate(i.g.chosen_pb_post_info, (ViewGroup) null);
        this.cgp = (TextView) this.cgo.findViewById(i.f.chosen_post_info_copyright);
        this.cgq = (ImageView) this.cgo.findViewById(i.f.chosen_post_info_praise_icon);
        this.cgr = (TextView) this.cgo.findViewById(i.f.chosen_post_info_praise_num);
        this.cgs = (TextView) this.cgo.findViewById(i.f.chosen_post_info_original_post);
        this.cgA = (LinearLayout) this.cgo.findViewById(i.f.chosen_post_info_tag_container);
        this.cgy = (TextView) this.cgo.findViewById(i.f.chosen_post_info_tag);
        this.cgz = (TextView) this.cgo.findViewById(i.f.chosen_post_info_mark);
    }

    public View aeZ() {
        return this.cgo;
    }

    public void a(a aVar) {
        this.cgt = aVar;
    }

    public void iU(int i) {
        if (this.cgp != null) {
            this.cgp.setText(i);
        }
    }

    public void y(View.OnClickListener onClickListener) {
        if (this.cgs != null) {
            this.cgs.setOnClickListener(onClickListener);
        }
    }

    public void aQ(long j) {
        if (j >= 0) {
            this.cgv = j;
            if (this.cgr != null) {
                this.cgr.setText(this.context.getString(i.h.chosen_pb_praise_num, as.q(j)));
            }
        }
    }

    public void aV(String str, String str2) {
        if (StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            this.cgA.setVisibility(8);
            return;
        }
        this.cgA.setVisibility(0);
        this.cgy.setText(this.context.getString(i.h.chosen_pb_tag_abstract, str));
        this.cgA.setOnClickListener(new j(this, str));
        this.cgz.setText(str2);
    }

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            iU(i.h.chosen_pb_copyright);
            aQ(forumInfo.zan.zansum.longValue());
            ep(forumInfo.zan.is_zan.booleanValue());
            y(new k(this, forumInfo));
            this.cgq.setOnClickListener(new l(this));
        }
    }

    public void afa() {
        this.cgx = false;
    }

    public void eo(boolean z) {
        ep(z);
        if (z) {
            this.cgv++;
        } else {
            this.cgv--;
        }
        aQ(this.cgv);
    }

    private void ep(boolean z) {
        this.cgu = z;
        if (z) {
            an.c(this.cgq, i.e.btn_zambia_big_s);
        } else {
            an.c(this.cgq, i.e.btn_zambia_big_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation afb() {
        if (this.cgw == null) {
            this.cgw = AnimationUtils.loadAnimation(this.context, i.a.praise_animation_scale3);
        }
        return this.cgw;
    }
}
