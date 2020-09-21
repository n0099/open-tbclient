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
/* loaded from: classes22.dex */
public class e {
    private Context context;
    private View kEK;
    private TextView kEL;
    private ImageView kEM;
    private TextView kEN;
    private TextView kEO;
    private a kEP;
    public boolean kEQ;
    private Animation kES;
    private long kER = 0;
    private boolean kET = false;

    /* loaded from: classes22.dex */
    public interface a {
        void sG(boolean z);

        void u(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.kEK = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.kEL = (TextView) this.kEK.findViewById(R.id.chosen_post_info_copyright);
        this.kEM = (ImageView) this.kEK.findViewById(R.id.chosen_post_info_praise_icon);
        this.kEN = (TextView) this.kEK.findViewById(R.id.chosen_post_info_praise_num);
        this.kEO = (TextView) this.kEK.findViewById(R.id.chosen_post_info_original_post);
    }

    public View cYL() {
        return this.kEK;
    }

    public void a(a aVar) {
        this.kEP = aVar;
    }

    public void Ep(int i) {
        if (this.kEL != null) {
            this.kEL.setText(i);
        }
    }

    public void P(View.OnClickListener onClickListener) {
        if (this.kEO != null) {
            this.kEO.setOnClickListener(onClickListener);
        }
    }

    public void fV(long j) {
        if (j >= 0) {
            this.kER = j;
            if (this.kEN != null) {
                this.kEN.setVisibility(0);
                this.kEN.setText(this.context.getString(R.string.chosen_pb_praise_num, at.numFormatOver10000(j)));
            }
            if (this.kEN != null && this.kEN.getVisibility() == 8) {
                this.kEN.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            Ep(R.string.chosen_pb_copyright);
            fV(excellentPbThreadInfo.zan.zansum.longValue());
            sK(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.kEM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.kET && bg.checkUpIsLogin(e.this.context)) {
                        e.this.kET = true;
                        e.this.kEM.startAnimation(e.this.cYN());
                        if (e.this.kEP != null) {
                            e.this.kEP.sG(e.this.kEQ);
                        }
                    }
                }
            });
            P(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.kEP != null) {
                        e.this.kEP.u(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void cYM() {
        this.kET = false;
    }

    public void sJ(boolean z) {
        sK(z);
        if (z) {
            this.kER++;
        } else {
            this.kER--;
        }
        fV(this.kER);
    }

    private void sK(boolean z) {
        this.kEQ = z;
        if (z) {
            ap.setImageResource(this.kEM, R.drawable.btn_zambia_big_s);
        } else {
            ap.setImageResource(this.kEM, R.drawable.btn_zambia_big_n);
        }
        this.kEM.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation cYN() {
        if (this.kES == null) {
            this.kES = AnimationUtils.loadAnimation(this.context, R.anim.praise_animation_scale3);
        }
        return this.kES;
    }
}
