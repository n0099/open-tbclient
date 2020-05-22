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
    private Animation jDB;
    private View jDt;
    private TextView jDu;
    private ImageView jDv;
    private TextView jDw;
    private TextView jDx;
    private a jDy;
    public boolean jDz;
    private long jDA = 0;
    private boolean jDC = false;

    /* loaded from: classes10.dex */
    public interface a {
        void qW(boolean z);

        void t(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.jDt = LayoutInflater.from(context).inflate(R.layout.chosen_pb_post_info, (ViewGroup) null);
        this.jDu = (TextView) this.jDt.findViewById(R.id.chosen_post_info_copyright);
        this.jDv = (ImageView) this.jDt.findViewById(R.id.chosen_post_info_praise_icon);
        this.jDw = (TextView) this.jDt.findViewById(R.id.chosen_post_info_praise_num);
        this.jDx = (TextView) this.jDt.findViewById(R.id.chosen_post_info_original_post);
    }

    public View cCb() {
        return this.jDt;
    }

    public void a(a aVar) {
        this.jDy = aVar;
    }

    public void zS(int i) {
        if (this.jDu != null) {
            this.jDu.setText(i);
        }
    }

    public void N(View.OnClickListener onClickListener) {
        if (this.jDx != null) {
            this.jDx.setOnClickListener(onClickListener);
        }
    }

    public void fe(long j) {
        if (j >= 0) {
            this.jDA = j;
            if (this.jDw != null) {
                this.jDw.setVisibility(0);
                this.jDw.setText(this.context.getString(R.string.chosen_pb_praise_num, aq.numFormatOver10000(j)));
            }
            if (this.jDw != null && this.jDw.getVisibility() == 8) {
                this.jDw.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            zS(R.string.chosen_pb_copyright);
            fe(excellentPbThreadInfo.zan.zansum.longValue());
            ra(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.jDv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.jDC && bc.checkUpIsLogin(e.this.context)) {
                        e.this.jDC = true;
                        e.this.jDv.startAnimation(e.this.cCd());
                        if (e.this.jDy != null) {
                            e.this.jDy.qW(e.this.jDz);
                        }
                    }
                }
            });
            N(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.jDy != null) {
                        e.this.jDy.t(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void cCc() {
        this.jDC = false;
    }

    public void qZ(boolean z) {
        ra(z);
        if (z) {
            this.jDA++;
        } else {
            this.jDA--;
        }
        fe(this.jDA);
    }

    private void ra(boolean z) {
        this.jDz = z;
        if (z) {
            am.setImageResource(this.jDv, R.drawable.btn_zambia_big_s);
        } else {
            am.setImageResource(this.jDv, R.drawable.btn_zambia_big_n);
        }
        this.jDv.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation cCd() {
        if (this.jDB == null) {
            this.jDB = AnimationUtils.loadAnimation(this.context, R.anim.praise_animation_scale3);
        }
        return this.jDB;
    }
}
