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
/* loaded from: classes23.dex */
public class e {
    private Context context;
    public boolean lgA;
    private Animation lgC;
    private View lgu;
    private TextView lgv;
    private ImageView lgw;
    private TextView lgx;
    private TextView lgy;
    private a lgz;
    private long lgB = 0;
    private boolean lgD = false;

    /* loaded from: classes23.dex */
    public interface a {
        void tE(boolean z);

        void v(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.lgu = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.lgv = (TextView) this.lgu.findViewById(R.id.chosen_post_info_copyright);
        this.lgw = (ImageView) this.lgu.findViewById(R.id.chosen_post_info_praise_icon);
        this.lgx = (TextView) this.lgu.findViewById(R.id.chosen_post_info_praise_num);
        this.lgy = (TextView) this.lgu.findViewById(R.id.chosen_post_info_original_post);
    }

    public View dfC() {
        return this.lgu;
    }

    public void a(a aVar) {
        this.lgz = aVar;
    }

    public void Fo(int i) {
        if (this.lgv != null) {
            this.lgv.setText(i);
        }
    }

    public void P(View.OnClickListener onClickListener) {
        if (this.lgy != null) {
            this.lgy.setOnClickListener(onClickListener);
        }
    }

    public void go(long j) {
        if (j >= 0) {
            this.lgB = j;
            if (this.lgx != null) {
                this.lgx.setVisibility(0);
                this.lgx.setText(this.context.getString(R.string.chosen_pb_praise_num, at.numFormatOver10000(j)));
            }
            if (this.lgx != null && this.lgx.getVisibility() == 8) {
                this.lgx.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            Fo(R.string.chosen_pb_copyright);
            go(excellentPbThreadInfo.zan.zansum.longValue());
            tI(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.lgw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.lgD && bg.checkUpIsLogin(e.this.context)) {
                        e.this.lgD = true;
                        e.this.lgw.startAnimation(e.this.dfE());
                        if (e.this.lgz != null) {
                            e.this.lgz.tE(e.this.lgA);
                        }
                    }
                }
            });
            P(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.lgz != null) {
                        e.this.lgz.v(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void dfD() {
        this.lgD = false;
    }

    public void tH(boolean z) {
        tI(z);
        if (z) {
            this.lgB++;
        } else {
            this.lgB--;
        }
        go(this.lgB);
    }

    private void tI(boolean z) {
        this.lgA = z;
        if (z) {
            ap.setImageResource(this.lgw, R.drawable.btn_zambia_big_s);
        } else {
            ap.setImageResource(this.lgw, R.drawable.btn_zambia_big_n);
        }
        this.lgw.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation dfE() {
        if (this.lgC == null) {
            this.lgC = AnimationUtils.loadAnimation(this.context, R.anim.praise_animation_scale3);
        }
        return this.lgC;
    }
}
