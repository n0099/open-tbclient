package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.R;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
/* loaded from: classes8.dex */
public class e {
    private Context context;
    private View lFn;
    private TextView lFo;
    private ImageView lFp;
    private TextView lFq;
    private TextView lFr;
    private a lFs;
    public boolean lFt;
    private Animation lFv;
    private long lFu = 0;
    private boolean lFw = false;

    /* loaded from: classes8.dex */
    public interface a {
        void ut(boolean z);

        void x(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.lFn = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.lFo = (TextView) this.lFn.findViewById(R.id.chosen_post_info_copyright);
        this.lFp = (ImageView) this.lFn.findViewById(R.id.chosen_post_info_praise_icon);
        this.lFq = (TextView) this.lFn.findViewById(R.id.chosen_post_info_praise_num);
        this.lFr = (TextView) this.lFn.findViewById(R.id.chosen_post_info_original_post);
    }

    public View dmz() {
        return this.lFn;
    }

    public void a(a aVar) {
        this.lFs = aVar;
    }

    public void GG(int i) {
        if (this.lFo != null) {
            this.lFo.setText(i);
        }
    }

    public void R(View.OnClickListener onClickListener) {
        if (this.lFr != null) {
            this.lFr.setOnClickListener(onClickListener);
        }
    }

    public void hn(long j) {
        if (j >= 0) {
            this.lFu = j;
            if (this.lFq != null) {
                this.lFq.setVisibility(0);
                this.lFq.setText(this.context.getString(R.string.chosen_pb_praise_num, at.numFormatOver10000(j)));
            }
            if (this.lFq != null && this.lFq.getVisibility() == 8) {
                this.lFq.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            GG(R.string.chosen_pb_copyright);
            hn(excellentPbThreadInfo.zan.zansum.longValue());
            ux(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.lFp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.lFw && bg.checkUpIsLogin(e.this.context)) {
                        e.this.lFw = true;
                        e.this.lFp.startAnimation(e.this.dmB());
                        if (e.this.lFs != null) {
                            e.this.lFs.ut(e.this.lFt);
                        }
                    }
                }
            });
            R(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.lFs != null) {
                        e.this.lFs.x(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void dmA() {
        this.lFw = false;
    }

    public void uw(boolean z) {
        ux(z);
        if (z) {
            this.lFu++;
        } else {
            this.lFu--;
        }
        hn(this.lFu);
    }

    private void ux(boolean z) {
        this.lFt = z;
        if (z) {
            ao.setImageResource(this.lFp, R.drawable.btn_zambia_big_s);
        } else {
            ao.setImageResource(this.lFp, R.drawable.btn_zambia_big_n);
        }
        this.lFp.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation dmB() {
        if (this.lFv == null) {
            this.lFv = AnimationUtils.loadAnimation(this.context, R.anim.praise_animation_scale3);
        }
        return this.lFv;
    }
}
