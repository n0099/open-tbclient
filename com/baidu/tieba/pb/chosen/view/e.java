package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.R;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
/* loaded from: classes17.dex */
public class e {
    private Context context;
    private View kwe;
    private TextView kwf;
    private ImageView kwg;
    private TextView kwh;
    private TextView kwi;
    private a kwj;
    public boolean kwk;
    private Animation kwm;
    private long kwl = 0;
    private boolean kwn = false;

    /* loaded from: classes17.dex */
    public interface a {
        void sw(boolean z);

        void u(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.kwe = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.kwf = (TextView) this.kwe.findViewById(R.id.chosen_post_info_copyright);
        this.kwg = (ImageView) this.kwe.findViewById(R.id.chosen_post_info_praise_icon);
        this.kwh = (TextView) this.kwe.findViewById(R.id.chosen_post_info_praise_num);
        this.kwi = (TextView) this.kwe.findViewById(R.id.chosen_post_info_original_post);
    }

    public View cVf() {
        return this.kwe;
    }

    public void a(a aVar) {
        this.kwj = aVar;
    }

    public void DO(int i) {
        if (this.kwf != null) {
            this.kwf.setText(i);
        }
    }

    public void P(View.OnClickListener onClickListener) {
        if (this.kwi != null) {
            this.kwi.setOnClickListener(onClickListener);
        }
    }

    public void fH(long j) {
        if (j >= 0) {
            this.kwl = j;
            if (this.kwh != null) {
                this.kwh.setVisibility(0);
                this.kwh.setText(this.context.getString(R.string.chosen_pb_praise_num, at.numFormatOver10000(j)));
            }
            if (this.kwh != null && this.kwh.getVisibility() == 8) {
                this.kwh.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            DO(R.string.chosen_pb_copyright);
            fH(excellentPbThreadInfo.zan.zansum.longValue());
            sA(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.kwg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.kwn && bg.checkUpIsLogin(e.this.context)) {
                        e.this.kwn = true;
                        e.this.kwg.startAnimation(e.this.cVh());
                        if (e.this.kwj != null) {
                            e.this.kwj.sw(e.this.kwk);
                        }
                    }
                }
            });
            P(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.kwj != null) {
                        e.this.kwj.u(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void cVg() {
        this.kwn = false;
    }

    public void sz(boolean z) {
        sA(z);
        if (z) {
            this.kwl++;
        } else {
            this.kwl--;
        }
        fH(this.kwl);
    }

    private void sA(boolean z) {
        this.kwk = z;
        if (z) {
            ap.setImageResource(this.kwg, R.drawable.btn_zambia_big_s);
        } else {
            ap.setImageResource(this.kwg, R.drawable.btn_zambia_big_n);
        }
        this.kwg.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation cVh() {
        if (this.kwm == null) {
            this.kwm = AnimationUtils.loadAnimation(this.context, R.anim.praise_animation_scale3);
        }
        return this.kwm;
    }
}
