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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.R;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
/* loaded from: classes23.dex */
public class e {
    private Context context;
    private View lAi;
    private TextView lAj;
    private ImageView lAk;
    private TextView lAl;
    private TextView lAm;
    private a lAn;
    public boolean lAo;
    private Animation lAq;
    private long lAp = 0;
    private boolean lAr = false;

    /* loaded from: classes23.dex */
    public interface a {
        void us(boolean z);

        void y(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.lAi = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.lAj = (TextView) this.lAi.findViewById(R.id.chosen_post_info_copyright);
        this.lAk = (ImageView) this.lAi.findViewById(R.id.chosen_post_info_praise_icon);
        this.lAl = (TextView) this.lAi.findViewById(R.id.chosen_post_info_praise_num);
        this.lAm = (TextView) this.lAi.findViewById(R.id.chosen_post_info_original_post);
    }

    public View dmO() {
        return this.lAi;
    }

    public void a(a aVar) {
        this.lAn = aVar;
    }

    public void GO(int i) {
        if (this.lAj != null) {
            this.lAj.setText(i);
        }
    }

    public void P(View.OnClickListener onClickListener) {
        if (this.lAm != null) {
            this.lAm.setOnClickListener(onClickListener);
        }
    }

    public void hs(long j) {
        if (j >= 0) {
            this.lAp = j;
            if (this.lAl != null) {
                this.lAl.setVisibility(0);
                this.lAl.setText(this.context.getString(R.string.chosen_pb_praise_num, au.numFormatOver10000(j)));
            }
            if (this.lAl != null && this.lAl.getVisibility() == 8) {
                this.lAl.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            GO(R.string.chosen_pb_copyright);
            hs(excellentPbThreadInfo.zan.zansum.longValue());
            uw(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.lAk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.lAr && bh.checkUpIsLogin(e.this.context)) {
                        e.this.lAr = true;
                        e.this.lAk.startAnimation(e.this.dmQ());
                        if (e.this.lAn != null) {
                            e.this.lAn.us(e.this.lAo);
                        }
                    }
                }
            });
            P(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.lAn != null) {
                        e.this.lAn.y(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void dmP() {
        this.lAr = false;
    }

    public void uv(boolean z) {
        uw(z);
        if (z) {
            this.lAp++;
        } else {
            this.lAp--;
        }
        hs(this.lAp);
    }

    private void uw(boolean z) {
        this.lAo = z;
        if (z) {
            ap.setImageResource(this.lAk, R.drawable.btn_zambia_big_s);
        } else {
            ap.setImageResource(this.lAk, R.drawable.btn_zambia_big_n);
        }
        this.lAk.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation dmQ() {
        if (this.lAq == null) {
            this.lAq = AnimationUtils.loadAnimation(this.context, R.anim.praise_animation_scale3);
        }
        return this.lAq;
    }
}
