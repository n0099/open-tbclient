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
    private View lAg;
    private TextView lAh;
    private ImageView lAi;
    private TextView lAj;
    private TextView lAk;
    private a lAl;
    public boolean lAm;
    private Animation lAo;
    private long lAn = 0;
    private boolean lAp = false;

    /* loaded from: classes23.dex */
    public interface a {
        void us(boolean z);

        void y(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.lAg = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.lAh = (TextView) this.lAg.findViewById(R.id.chosen_post_info_copyright);
        this.lAi = (ImageView) this.lAg.findViewById(R.id.chosen_post_info_praise_icon);
        this.lAj = (TextView) this.lAg.findViewById(R.id.chosen_post_info_praise_num);
        this.lAk = (TextView) this.lAg.findViewById(R.id.chosen_post_info_original_post);
    }

    public View dmN() {
        return this.lAg;
    }

    public void a(a aVar) {
        this.lAl = aVar;
    }

    public void GO(int i) {
        if (this.lAh != null) {
            this.lAh.setText(i);
        }
    }

    public void P(View.OnClickListener onClickListener) {
        if (this.lAk != null) {
            this.lAk.setOnClickListener(onClickListener);
        }
    }

    public void hs(long j) {
        if (j >= 0) {
            this.lAn = j;
            if (this.lAj != null) {
                this.lAj.setVisibility(0);
                this.lAj.setText(this.context.getString(R.string.chosen_pb_praise_num, au.numFormatOver10000(j)));
            }
            if (this.lAj != null && this.lAj.getVisibility() == 8) {
                this.lAj.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            GO(R.string.chosen_pb_copyright);
            hs(excellentPbThreadInfo.zan.zansum.longValue());
            uw(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.lAi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.lAp && bh.checkUpIsLogin(e.this.context)) {
                        e.this.lAp = true;
                        e.this.lAi.startAnimation(e.this.dmP());
                        if (e.this.lAl != null) {
                            e.this.lAl.us(e.this.lAm);
                        }
                    }
                }
            });
            P(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.lAl != null) {
                        e.this.lAl.y(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void dmO() {
        this.lAp = false;
    }

    public void uv(boolean z) {
        uw(z);
        if (z) {
            this.lAn++;
        } else {
            this.lAn--;
        }
        hs(this.lAn);
    }

    private void uw(boolean z) {
        this.lAm = z;
        if (z) {
            ap.setImageResource(this.lAi, R.drawable.btn_zambia_big_s);
        } else {
            ap.setImageResource(this.lAi, R.drawable.btn_zambia_big_n);
        }
        this.lAi.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation dmP() {
        if (this.lAo == null) {
            this.lAo = AnimationUtils.loadAnimation(this.context, R.anim.praise_animation_scale3);
        }
        return this.lAo;
    }
}
