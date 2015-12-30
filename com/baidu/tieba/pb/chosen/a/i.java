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
    private a cCA;
    public boolean cCB;
    private Animation cCD;
    private View cCv;
    private TextView cCw;
    private ImageView cCx;
    private TextView cCy;
    private TextView cCz;
    private Context context;
    private long cCC = 0;
    private boolean cCE = false;

    /* loaded from: classes.dex */
    public interface a {
        void eM(boolean z);

        void g(long j, String str);
    }

    public i(Context context) {
        this.context = context;
        this.cCv = LayoutInflater.from(context).inflate(n.h.chosen_pb_post_info, (ViewGroup) null);
        this.cCw = (TextView) this.cCv.findViewById(n.g.chosen_post_info_copyright);
        this.cCx = (ImageView) this.cCv.findViewById(n.g.chosen_post_info_praise_icon);
        this.cCy = (TextView) this.cCv.findViewById(n.g.chosen_post_info_praise_num);
        this.cCz = (TextView) this.cCv.findViewById(n.g.chosen_post_info_original_post);
    }

    public View akz() {
        return this.cCv;
    }

    public void a(a aVar) {
        this.cCA = aVar;
    }

    public void kj(int i) {
        if (this.cCw != null) {
            this.cCw.setText(i);
        }
    }

    public void y(View.OnClickListener onClickListener) {
        if (this.cCz != null) {
            this.cCz.setOnClickListener(onClickListener);
        }
    }

    public void bk(long j) {
        if (j >= 0) {
            this.cCC = j;
            if (this.cCy != null) {
                this.cCy.setText(this.context.getString(n.j.chosen_pb_praise_num, ax.x(j)));
            }
        }
    }

    public void a(ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            kj(n.j.chosen_pb_copyright);
            bk(excellentPbThreadInfo.zan.zansum.longValue());
            eQ(excellentPbThreadInfo.zan.is_zan.booleanValue());
            y(new j(this, excellentPbThreadInfo));
            this.cCx.setOnClickListener(new k(this));
        }
    }

    public void akA() {
        this.cCE = false;
    }

    public void eP(boolean z) {
        eQ(z);
        if (z) {
            this.cCC++;
        } else {
            this.cCC--;
        }
        bk(this.cCC);
    }

    private void eQ(boolean z) {
        this.cCB = z;
        if (z) {
            as.c(this.cCx, n.f.btn_zambia_big_s);
        } else {
            as.c(this.cCx, n.f.btn_zambia_big_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation akB() {
        if (this.cCD == null) {
            this.cCD = AnimationUtils.loadAnimation(this.context, n.a.praise_animation_scale3);
        }
        return this.cCD;
    }
}
