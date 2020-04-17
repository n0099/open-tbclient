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
    private View jmT;
    private TextView jmU;
    private ImageView jmV;
    private TextView jmW;
    private TextView jmX;
    private a jmY;
    public boolean jmZ;
    private Animation jnb;
    private long jna = 0;
    private boolean jnc = false;

    /* loaded from: classes10.dex */
    public interface a {
        void qz(boolean z);

        void t(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.jmT = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.jmU = (TextView) this.jmT.findViewById(R.id.chosen_post_info_copyright);
        this.jmV = (ImageView) this.jmT.findViewById(R.id.chosen_post_info_praise_icon);
        this.jmW = (TextView) this.jmT.findViewById(R.id.chosen_post_info_praise_num);
        this.jmX = (TextView) this.jmT.findViewById(R.id.chosen_post_info_original_post);
    }

    public View cvn() {
        return this.jmT;
    }

    public void a(a aVar) {
        this.jmY = aVar;
    }

    public void zi(int i) {
        if (this.jmU != null) {
            this.jmU.setText(i);
        }
    }

    public void N(View.OnClickListener onClickListener) {
        if (this.jmX != null) {
            this.jmX.setOnClickListener(onClickListener);
        }
    }

    public void fd(long j) {
        if (j >= 0) {
            this.jna = j;
            if (this.jmW != null) {
                this.jmW.setVisibility(0);
                this.jmW.setText(this.context.getString(R.string.chosen_pb_praise_num, aq.numFormatOver10000(j)));
            }
            if (this.jmW != null && this.jmW.getVisibility() == 8) {
                this.jmW.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            zi(R.string.chosen_pb_copyright);
            fd(excellentPbThreadInfo.zan.zansum.longValue());
            qD(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.jmV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.jnc && bc.checkUpIsLogin(e.this.context)) {
                        e.this.jnc = true;
                        e.this.jmV.startAnimation(e.this.cvp());
                        if (e.this.jmY != null) {
                            e.this.jmY.qz(e.this.jmZ);
                        }
                    }
                }
            });
            N(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.jmY != null) {
                        e.this.jmY.t(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void cvo() {
        this.jnc = false;
    }

    public void qC(boolean z) {
        qD(z);
        if (z) {
            this.jna++;
        } else {
            this.jna--;
        }
        fd(this.jna);
    }

    private void qD(boolean z) {
        this.jmZ = z;
        if (z) {
            am.setImageResource(this.jmV, R.drawable.btn_zambia_big_s);
        } else {
            am.setImageResource(this.jmV, R.drawable.btn_zambia_big_n);
        }
        this.jmV.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation cvp() {
        if (this.jnb == null) {
            this.jnb = AnimationUtils.loadAnimation(this.context, R.anim.praise_animation_scale3);
        }
        return this.jnb;
    }
}
