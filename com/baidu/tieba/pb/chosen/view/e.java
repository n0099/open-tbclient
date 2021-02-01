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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.R;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
/* loaded from: classes8.dex */
public class e {
    private Context context;
    private a lJA;
    public boolean lJB;
    private Animation lJD;
    private View lJv;
    private TextView lJw;
    private ImageView lJx;
    private TextView lJy;
    private TextView lJz;
    private long lJC = 0;
    private boolean lJE = false;

    /* loaded from: classes8.dex */
    public interface a {
        void uC(boolean z);

        void y(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.lJv = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.lJw = (TextView) this.lJv.findViewById(R.id.chosen_post_info_copyright);
        this.lJx = (ImageView) this.lJv.findViewById(R.id.chosen_post_info_praise_icon);
        this.lJy = (TextView) this.lJv.findViewById(R.id.chosen_post_info_praise_num);
        this.lJz = (TextView) this.lJv.findViewById(R.id.chosen_post_info_original_post);
    }

    public View dkT() {
        return this.lJv;
    }

    public void a(a aVar) {
        this.lJA = aVar;
    }

    public void Ft(int i) {
        if (this.lJw != null) {
            this.lJw.setText(i);
        }
    }

    public void R(View.OnClickListener onClickListener) {
        if (this.lJz != null) {
            this.lJz.setOnClickListener(onClickListener);
        }
    }

    public void hs(long j) {
        if (j >= 0) {
            this.lJC = j;
            if (this.lJy != null) {
                this.lJy.setVisibility(0);
                this.lJy.setText(this.context.getString(R.string.chosen_pb_praise_num, au.numFormatOver10000(j)));
            }
            if (this.lJy != null && this.lJy.getVisibility() == 8) {
                this.lJy.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            Ft(R.string.chosen_pb_copyright);
            hs(excellentPbThreadInfo.zan.zansum.longValue());
            uG(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.lJx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.lJE && bh.checkUpIsLogin(e.this.context)) {
                        e.this.lJE = true;
                        e.this.lJx.startAnimation(e.this.dkV());
                        if (e.this.lJA != null) {
                            e.this.lJA.uC(e.this.lJB);
                        }
                    }
                }
            });
            R(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.lJA != null) {
                        e.this.lJA.y(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void dkU() {
        this.lJE = false;
    }

    public void uF(boolean z) {
        uG(z);
        if (z) {
            this.lJC++;
        } else {
            this.lJC--;
        }
        hs(this.lJC);
    }

    private void uG(boolean z) {
        this.lJB = z;
        if (z) {
            ap.setImageResource(this.lJx, R.drawable.btn_zambia_big_s);
        } else {
            ap.setImageResource(this.lJx, R.drawable.btn_zambia_big_n);
        }
        this.lJx.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation dkV() {
        if (this.lJD == null) {
            this.lJD = AnimationUtils.loadAnimation(this.context, R.anim.praise_animation_scale3);
        }
        return this.lJD;
    }
}
