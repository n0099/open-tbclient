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
    private View jmX;
    private TextView jmY;
    private ImageView jmZ;
    private TextView jna;
    private TextView jnb;
    private a jnc;
    public boolean jnd;
    private Animation jnf;
    private long jne = 0;
    private boolean jng = false;

    /* loaded from: classes10.dex */
    public interface a {
        void qz(boolean z);

        void t(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.jmX = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.jmY = (TextView) this.jmX.findViewById(R.id.chosen_post_info_copyright);
        this.jmZ = (ImageView) this.jmX.findViewById(R.id.chosen_post_info_praise_icon);
        this.jna = (TextView) this.jmX.findViewById(R.id.chosen_post_info_praise_num);
        this.jnb = (TextView) this.jmX.findViewById(R.id.chosen_post_info_original_post);
    }

    public View cvl() {
        return this.jmX;
    }

    public void a(a aVar) {
        this.jnc = aVar;
    }

    public void zi(int i) {
        if (this.jmY != null) {
            this.jmY.setText(i);
        }
    }

    public void N(View.OnClickListener onClickListener) {
        if (this.jnb != null) {
            this.jnb.setOnClickListener(onClickListener);
        }
    }

    public void fd(long j) {
        if (j >= 0) {
            this.jne = j;
            if (this.jna != null) {
                this.jna.setVisibility(0);
                this.jna.setText(this.context.getString(R.string.chosen_pb_praise_num, aq.numFormatOver10000(j)));
            }
            if (this.jna != null && this.jna.getVisibility() == 8) {
                this.jna.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            zi(R.string.chosen_pb_copyright);
            fd(excellentPbThreadInfo.zan.zansum.longValue());
            qD(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.jmZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.jng && bc.checkUpIsLogin(e.this.context)) {
                        e.this.jng = true;
                        e.this.jmZ.startAnimation(e.this.cvn());
                        if (e.this.jnc != null) {
                            e.this.jnc.qz(e.this.jnd);
                        }
                    }
                }
            });
            N(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.jnc != null) {
                        e.this.jnc.t(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void cvm() {
        this.jng = false;
    }

    public void qC(boolean z) {
        qD(z);
        if (z) {
            this.jne++;
        } else {
            this.jne--;
        }
        fd(this.jne);
    }

    private void qD(boolean z) {
        this.jnd = z;
        if (z) {
            am.setImageResource(this.jmZ, R.drawable.btn_zambia_big_s);
        } else {
            am.setImageResource(this.jmZ, R.drawable.btn_zambia_big_n);
        }
        this.jmZ.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation cvn() {
        if (this.jnf == null) {
            this.jnf = AnimationUtils.loadAnimation(this.context, R.anim.praise_animation_scale3);
        }
        return this.jnf;
    }
}
