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
/* loaded from: classes5.dex */
public class e {
    private Context context;
    private View hIn;
    private TextView hIo;
    private ImageView hIp;
    private TextView hIq;
    private TextView hIr;
    private a hIs;
    public boolean hIt;
    private Animation hIv;
    private long hIu = 0;
    private boolean hIw = false;

    /* loaded from: classes5.dex */
    public interface a {
        void nM(boolean z);

        void q(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.hIn = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.hIo = (TextView) this.hIn.findViewById(R.id.chosen_post_info_copyright);
        this.hIp = (ImageView) this.hIn.findViewById(R.id.chosen_post_info_praise_icon);
        this.hIq = (TextView) this.hIn.findViewById(R.id.chosen_post_info_praise_num);
        this.hIr = (TextView) this.hIn.findViewById(R.id.chosen_post_info_original_post);
    }

    public View bQq() {
        return this.hIn;
    }

    public void a(a aVar) {
        this.hIs = aVar;
    }

    public void wn(int i) {
        if (this.hIo != null) {
            this.hIo.setText(i);
        }
    }

    public void L(View.OnClickListener onClickListener) {
        if (this.hIr != null) {
            this.hIr.setOnClickListener(onClickListener);
        }
    }

    public void dI(long j) {
        if (j >= 0) {
            this.hIu = j;
            if (this.hIq != null) {
                this.hIq.setVisibility(0);
                this.hIq.setText(this.context.getString(R.string.chosen_pb_praise_num, aq.numFormatOver10000(j)));
            }
            if (this.hIq != null && this.hIq.getVisibility() == 8) {
                this.hIq.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            wn(R.string.chosen_pb_copyright);
            dI(excellentPbThreadInfo.zan.zansum.longValue());
            nQ(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.hIp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.hIw && bc.checkUpIsLogin(e.this.context)) {
                        e.this.hIw = true;
                        e.this.hIp.startAnimation(e.this.bQs());
                        if (e.this.hIs != null) {
                            e.this.hIs.nM(e.this.hIt);
                        }
                    }
                }
            });
            L(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.hIs != null) {
                        e.this.hIs.q(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void bQr() {
        this.hIw = false;
    }

    public void nP(boolean z) {
        nQ(z);
        if (z) {
            this.hIu++;
        } else {
            this.hIu--;
        }
        dI(this.hIu);
    }

    private void nQ(boolean z) {
        this.hIt = z;
        if (z) {
            am.setImageResource(this.hIp, R.drawable.btn_zambia_big_s);
        } else {
            am.setImageResource(this.hIp, R.drawable.btn_zambia_big_n);
        }
        this.hIp.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation bQs() {
        if (this.hIv == null) {
            this.hIv = AnimationUtils.loadAnimation(this.context, R.anim.praise_animation_scale3);
        }
        return this.hIv;
    }
}
