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
/* loaded from: classes10.dex */
public class e {
    private Context context;
    private View iBn;
    private TextView iBo;
    private ImageView iBp;
    private TextView iBq;
    private TextView iBr;
    private a iBs;
    public boolean iBt;
    private Animation iBv;
    private long iBu = 0;
    private boolean iBw = false;

    /* loaded from: classes10.dex */
    public interface a {
        void pp(boolean z);

        void r(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.iBn = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.iBo = (TextView) this.iBn.findViewById(R.id.chosen_post_info_copyright);
        this.iBp = (ImageView) this.iBn.findViewById(R.id.chosen_post_info_praise_icon);
        this.iBq = (TextView) this.iBn.findViewById(R.id.chosen_post_info_praise_num);
        this.iBr = (TextView) this.iBn.findViewById(R.id.chosen_post_info_original_post);
    }

    public View cko() {
        return this.iBn;
    }

    public void a(a aVar) {
        this.iBs = aVar;
    }

    public void yz(int i) {
        if (this.iBo != null) {
            this.iBo.setText(i);
        }
    }

    public void M(View.OnClickListener onClickListener) {
        if (this.iBr != null) {
            this.iBr.setOnClickListener(onClickListener);
        }
    }

    public void es(long j) {
        if (j >= 0) {
            this.iBu = j;
            if (this.iBq != null) {
                this.iBq.setVisibility(0);
                this.iBq.setText(this.context.getString(R.string.chosen_pb_praise_num, aq.numFormatOver10000(j)));
            }
            if (this.iBq != null && this.iBq.getVisibility() == 8) {
                this.iBq.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            yz(R.string.chosen_pb_copyright);
            es(excellentPbThreadInfo.zan.zansum.longValue());
            pt(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.iBp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.iBw && bc.checkUpIsLogin(e.this.context)) {
                        e.this.iBw = true;
                        e.this.iBp.startAnimation(e.this.ckq());
                        if (e.this.iBs != null) {
                            e.this.iBs.pp(e.this.iBt);
                        }
                    }
                }
            });
            M(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.iBs != null) {
                        e.this.iBs.r(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void ckp() {
        this.iBw = false;
    }

    public void ps(boolean z) {
        pt(z);
        if (z) {
            this.iBu++;
        } else {
            this.iBu--;
        }
        es(this.iBu);
    }

    private void pt(boolean z) {
        this.iBt = z;
        if (z) {
            am.setImageResource(this.iBp, R.drawable.btn_zambia_big_s);
        } else {
            am.setImageResource(this.iBp, R.drawable.btn_zambia_big_n);
        }
        this.iBp.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation ckq() {
        if (this.iBv == null) {
            this.iBv = AnimationUtils.loadAnimation(this.context, R.anim.praise_animation_scale3);
        }
        return this.iBv;
    }
}
