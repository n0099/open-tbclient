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
    private View kTV;
    private TextView kTW;
    private ImageView kTX;
    private TextView kTY;
    private TextView kTZ;
    private a kUa;
    public boolean kUb;
    private Animation kUd;
    private long kUc = 0;
    private boolean kUe = false;

    /* loaded from: classes23.dex */
    public interface a {
        void tn(boolean z);

        void v(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.kTV = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.kTW = (TextView) this.kTV.findViewById(R.id.chosen_post_info_copyright);
        this.kTX = (ImageView) this.kTV.findViewById(R.id.chosen_post_info_praise_icon);
        this.kTY = (TextView) this.kTV.findViewById(R.id.chosen_post_info_praise_num);
        this.kTZ = (TextView) this.kTV.findViewById(R.id.chosen_post_info_original_post);
    }

    public View dcu() {
        return this.kTV;
    }

    public void a(a aVar) {
        this.kUa = aVar;
    }

    public void EV(int i) {
        if (this.kTW != null) {
            this.kTW.setText(i);
        }
    }

    public void P(View.OnClickListener onClickListener) {
        if (this.kTZ != null) {
            this.kTZ.setOnClickListener(onClickListener);
        }
    }

    public void gn(long j) {
        if (j >= 0) {
            this.kUc = j;
            if (this.kTY != null) {
                this.kTY.setVisibility(0);
                this.kTY.setText(this.context.getString(R.string.chosen_pb_praise_num, at.numFormatOver10000(j)));
            }
            if (this.kTY != null && this.kTY.getVisibility() == 8) {
                this.kTY.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            EV(R.string.chosen_pb_copyright);
            gn(excellentPbThreadInfo.zan.zansum.longValue());
            tr(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.kTX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.kUe && bg.checkUpIsLogin(e.this.context)) {
                        e.this.kUe = true;
                        e.this.kTX.startAnimation(e.this.dcw());
                        if (e.this.kUa != null) {
                            e.this.kUa.tn(e.this.kUb);
                        }
                    }
                }
            });
            P(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.kUa != null) {
                        e.this.kUa.v(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void dcv() {
        this.kUe = false;
    }

    public void tq(boolean z) {
        tr(z);
        if (z) {
            this.kUc++;
        } else {
            this.kUc--;
        }
        gn(this.kUc);
    }

    private void tr(boolean z) {
        this.kUb = z;
        if (z) {
            ap.setImageResource(this.kTX, R.drawable.btn_zambia_big_s);
        } else {
            ap.setImageResource(this.kTX, R.drawable.btn_zambia_big_n);
        }
        this.kTX.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation dcw() {
        if (this.kUd == null) {
            this.kUd = AnimationUtils.loadAnimation(this.context, R.anim.praise_animation_scale3);
        }
        return this.kUd;
    }
}
