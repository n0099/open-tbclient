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
    private View lFo;
    private TextView lFp;
    private ImageView lFq;
    private TextView lFr;
    private TextView lFs;
    private a lFt;
    public boolean lFu;
    private Animation lFw;
    private long lFv = 0;
    private boolean lFx = false;

    /* loaded from: classes8.dex */
    public interface a {
        void ut(boolean z);

        void x(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.lFo = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.lFp = (TextView) this.lFo.findViewById(R.id.chosen_post_info_copyright);
        this.lFq = (ImageView) this.lFo.findViewById(R.id.chosen_post_info_praise_icon);
        this.lFr = (TextView) this.lFo.findViewById(R.id.chosen_post_info_praise_num);
        this.lFs = (TextView) this.lFo.findViewById(R.id.chosen_post_info_original_post);
    }

    public View dmy() {
        return this.lFo;
    }

    public void a(a aVar) {
        this.lFt = aVar;
    }

    public void GG(int i) {
        if (this.lFp != null) {
            this.lFp.setText(i);
        }
    }

    public void R(View.OnClickListener onClickListener) {
        if (this.lFs != null) {
            this.lFs.setOnClickListener(onClickListener);
        }
    }

    public void hn(long j) {
        if (j >= 0) {
            this.lFv = j;
            if (this.lFr != null) {
                this.lFr.setVisibility(0);
                this.lFr.setText(this.context.getString(R.string.chosen_pb_praise_num, at.numFormatOver10000(j)));
            }
            if (this.lFr != null && this.lFr.getVisibility() == 8) {
                this.lFr.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            GG(R.string.chosen_pb_copyright);
            hn(excellentPbThreadInfo.zan.zansum.longValue());
            ux(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.lFq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.lFx && bg.checkUpIsLogin(e.this.context)) {
                        e.this.lFx = true;
                        e.this.lFq.startAnimation(e.this.dmA());
                        if (e.this.lFt != null) {
                            e.this.lFt.ut(e.this.lFu);
                        }
                    }
                }
            });
            R(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.lFt != null) {
                        e.this.lFt.x(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void dmz() {
        this.lFx = false;
    }

    public void uw(boolean z) {
        ux(z);
        if (z) {
            this.lFv++;
        } else {
            this.lFv--;
        }
        hn(this.lFv);
    }

    private void ux(boolean z) {
        this.lFu = z;
        if (z) {
            ao.setImageResource(this.lFq, R.drawable.btn_zambia_big_s);
        } else {
            ao.setImageResource(this.lFq, R.drawable.btn_zambia_big_n);
        }
        this.lFq.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation dmA() {
        if (this.lFw == null) {
            this.lFw = AnimationUtils.loadAnimation(this.context, R.anim.praise_animation_scale3);
        }
        return this.lFw;
    }
}
