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
/* loaded from: classes17.dex */
public class e {
    private Context context;
    private View kwl;
    private TextView kwm;
    private ImageView kwn;
    private TextView kwo;
    private TextView kwp;
    private a kwq;
    public boolean kwr;
    private Animation kwt;
    private long kws = 0;
    private boolean kwu = false;

    /* loaded from: classes17.dex */
    public interface a {
        void sy(boolean z);

        void u(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.kwl = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.kwm = (TextView) this.kwl.findViewById(R.id.chosen_post_info_copyright);
        this.kwn = (ImageView) this.kwl.findViewById(R.id.chosen_post_info_praise_icon);
        this.kwo = (TextView) this.kwl.findViewById(R.id.chosen_post_info_praise_num);
        this.kwp = (TextView) this.kwl.findViewById(R.id.chosen_post_info_original_post);
    }

    public View cVg() {
        return this.kwl;
    }

    public void a(a aVar) {
        this.kwq = aVar;
    }

    public void DO(int i) {
        if (this.kwm != null) {
            this.kwm.setText(i);
        }
    }

    public void P(View.OnClickListener onClickListener) {
        if (this.kwp != null) {
            this.kwp.setOnClickListener(onClickListener);
        }
    }

    public void fH(long j) {
        if (j >= 0) {
            this.kws = j;
            if (this.kwo != null) {
                this.kwo.setVisibility(0);
                this.kwo.setText(this.context.getString(R.string.chosen_pb_praise_num, at.numFormatOver10000(j)));
            }
            if (this.kwo != null && this.kwo.getVisibility() == 8) {
                this.kwo.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            DO(R.string.chosen_pb_copyright);
            fH(excellentPbThreadInfo.zan.zansum.longValue());
            sC(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.kwn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.kwu && bg.checkUpIsLogin(e.this.context)) {
                        e.this.kwu = true;
                        e.this.kwn.startAnimation(e.this.cVi());
                        if (e.this.kwq != null) {
                            e.this.kwq.sy(e.this.kwr);
                        }
                    }
                }
            });
            P(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.kwq != null) {
                        e.this.kwq.u(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void cVh() {
        this.kwu = false;
    }

    public void sB(boolean z) {
        sC(z);
        if (z) {
            this.kws++;
        } else {
            this.kws--;
        }
        fH(this.kws);
    }

    private void sC(boolean z) {
        this.kwr = z;
        if (z) {
            ap.setImageResource(this.kwn, R.drawable.btn_zambia_big_s);
        } else {
            ap.setImageResource(this.kwn, R.drawable.btn_zambia_big_n);
        }
        this.kwn.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation cVi() {
        if (this.kwt == null) {
            this.kwt = AnimationUtils.loadAnimation(this.context, R.anim.praise_animation_scale3);
        }
        return this.kwt;
    }
}
