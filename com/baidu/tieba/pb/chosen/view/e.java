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
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.R;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
/* loaded from: classes5.dex */
public class e {
    private Context context;
    private View hGU;
    private TextView hGV;
    private ImageView hGW;
    private TextView hGX;
    private TextView hGY;
    private a hGZ;
    public boolean hHa;
    private Animation hHc;
    private long hHb = 0;
    private boolean hHd = false;

    /* loaded from: classes5.dex */
    public interface a {
        void nY(boolean z);

        void o(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.hGU = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.hGV = (TextView) this.hGU.findViewById(R.id.chosen_post_info_copyright);
        this.hGW = (ImageView) this.hGU.findViewById(R.id.chosen_post_info_praise_icon);
        this.hGX = (TextView) this.hGU.findViewById(R.id.chosen_post_info_praise_num);
        this.hGY = (TextView) this.hGU.findViewById(R.id.chosen_post_info_original_post);
    }

    public View bSo() {
        return this.hGU;
    }

    public void a(a aVar) {
        this.hGZ = aVar;
    }

    public void xC(int i) {
        if (this.hGV != null) {
            this.hGV.setText(i);
        }
    }

    public void K(View.OnClickListener onClickListener) {
        if (this.hGY != null) {
            this.hGY.setOnClickListener(onClickListener);
        }
    }

    public void ek(long j) {
        if (j >= 0) {
            this.hHb = j;
            if (this.hGX != null) {
                this.hGX.setVisibility(0);
                this.hGX.setText(this.context.getString(R.string.chosen_pb_praise_num, aq.aM(j)));
            }
            if (this.hGX != null && this.hGX.getVisibility() == 8) {
                this.hGX.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            xC(R.string.chosen_pb_copyright);
            ek(excellentPbThreadInfo.zan.zansum.longValue());
            oc(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.hGW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.hHd && bd.cF(e.this.context)) {
                        e.this.hHd = true;
                        e.this.hGW.startAnimation(e.this.bSq());
                        if (e.this.hGZ != null) {
                            e.this.hGZ.nY(e.this.hHa);
                        }
                    }
                }
            });
            K(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.hGZ != null) {
                        e.this.hGZ.o(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void bSp() {
        this.hHd = false;
    }

    public void ob(boolean z) {
        oc(z);
        if (z) {
            this.hHb++;
        } else {
            this.hHb--;
        }
        ek(this.hHb);
    }

    private void oc(boolean z) {
        this.hHa = z;
        if (z) {
            am.c(this.hGW, (int) R.drawable.btn_zambia_big_s);
        } else {
            am.c(this.hGW, (int) R.drawable.btn_zambia_big_n);
        }
        this.hGW.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation bSq() {
        if (this.hHc == null) {
            this.hHc = AnimationUtils.loadAnimation(this.context, R.anim.praise_animation_scale3);
        }
        return this.hHc;
    }
}
