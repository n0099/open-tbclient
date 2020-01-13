package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
/* loaded from: classes8.dex */
public class e {
    private Context context;
    private View ize;
    private TextView izf;
    private ImageView izg;
    private TextView izh;
    private TextView izi;
    private a izj;
    public boolean izk;
    private Animation izm;
    private long izl = 0;
    private boolean izn = false;

    /* loaded from: classes8.dex */
    public interface a {
        void pm(boolean z);

        void r(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.ize = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.izf = (TextView) this.ize.findViewById(R.id.chosen_post_info_copyright);
        this.izg = (ImageView) this.ize.findViewById(R.id.chosen_post_info_praise_icon);
        this.izh = (TextView) this.ize.findViewById(R.id.chosen_post_info_praise_num);
        this.izi = (TextView) this.ize.findViewById(R.id.chosen_post_info_original_post);
    }

    public View ciH() {
        return this.ize;
    }

    public void a(a aVar) {
        this.izj = aVar;
    }

    public void ys(int i) {
        if (this.izf != null) {
            this.izf.setText(i);
        }
    }

    public void L(View.OnClickListener onClickListener) {
        if (this.izi != null) {
            this.izi.setOnClickListener(onClickListener);
        }
    }

    public void es(long j) {
        if (j >= 0) {
            this.izl = j;
            if (this.izh != null) {
                this.izh.setVisibility(0);
                this.izh.setText(this.context.getString(R.string.chosen_pb_praise_num, aq.numFormatOver10000(j)));
            }
            if (this.izh != null && this.izh.getVisibility() == 8) {
                this.izh.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            ys(R.string.chosen_pb_copyright);
            es(excellentPbThreadInfo.zan.zansum.longValue());
            pq(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.izg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.izn && bc.checkUpIsLogin(e.this.context)) {
                        e.this.izn = true;
                        e.this.izg.startAnimation(e.this.ciJ());
                        if (e.this.izj != null) {
                            e.this.izj.pm(e.this.izk);
                        }
                    }
                }
            });
            L(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.izj != null) {
                        e.this.izj.r(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void ciI() {
        this.izn = false;
    }

    public void pp(boolean z) {
        pq(z);
        if (z) {
            this.izl++;
        } else {
            this.izl--;
        }
        es(this.izl);
    }

    private void pq(boolean z) {
        this.izk = z;
        if (z) {
            am.setImageResource(this.izg, R.drawable.btn_zambia_big_s);
        } else {
            am.setImageResource(this.izg, R.drawable.btn_zambia_big_n);
        }
        this.izg.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation ciJ() {
        if (this.izm == null) {
            this.izm = AnimationUtils.loadAnimation(this.context, R.anim.praise_animation_scale3);
        }
        return this.izm;
    }
}
