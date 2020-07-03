package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.R;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
/* loaded from: classes10.dex */
public class e {
    private Context context;
    private View jYj;
    private TextView jYk;
    private ImageView jYl;
    private TextView jYm;
    private TextView jYn;
    private a jYo;
    public boolean jYp;
    private Animation jYr;
    private long jYq = 0;
    private boolean jYs = false;

    /* loaded from: classes10.dex */
    public interface a {
        void rk(boolean z);

        void t(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.jYj = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.jYk = (TextView) this.jYj.findViewById(R.id.chosen_post_info_copyright);
        this.jYl = (ImageView) this.jYj.findViewById(R.id.chosen_post_info_praise_icon);
        this.jYm = (TextView) this.jYj.findViewById(R.id.chosen_post_info_praise_num);
        this.jYn = (TextView) this.jYj.findViewById(R.id.chosen_post_info_original_post);
    }

    public View cGH() {
        return this.jYj;
    }

    public void a(a aVar) {
        this.jYo = aVar;
    }

    public void AW(int i) {
        if (this.jYk != null) {
            this.jYk.setText(i);
        }
    }

    public void O(View.OnClickListener onClickListener) {
        if (this.jYn != null) {
            this.jYn.setOnClickListener(onClickListener);
        }
    }

    public void fh(long j) {
        if (j >= 0) {
            this.jYq = j;
            if (this.jYm != null) {
                this.jYm.setVisibility(0);
                this.jYm.setText(this.context.getString(R.string.chosen_pb_praise_num, ar.numFormatOver10000(j)));
            }
            if (this.jYm != null && this.jYm.getVisibility() == 8) {
                this.jYm.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            AW(R.string.chosen_pb_copyright);
            fh(excellentPbThreadInfo.zan.zansum.longValue());
            ro(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.jYl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.jYs && be.checkUpIsLogin(e.this.context)) {
                        e.this.jYs = true;
                        e.this.jYl.startAnimation(e.this.cGJ());
                        if (e.this.jYo != null) {
                            e.this.jYo.rk(e.this.jYp);
                        }
                    }
                }
            });
            O(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.jYo != null) {
                        e.this.jYo.t(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void cGI() {
        this.jYs = false;
    }

    public void rn(boolean z) {
        ro(z);
        if (z) {
            this.jYq++;
        } else {
            this.jYq--;
        }
        fh(this.jYq);
    }

    private void ro(boolean z) {
        this.jYp = z;
        if (z) {
            an.setImageResource(this.jYl, R.drawable.btn_zambia_big_s);
        } else {
            an.setImageResource(this.jYl, R.drawable.btn_zambia_big_n);
        }
        this.jYl.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation cGJ() {
        if (this.jYr == null) {
            this.jYr = AnimationUtils.loadAnimation(this.context, R.anim.praise_animation_scale3);
        }
        return this.jYr;
    }
}
