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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.f;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
/* loaded from: classes3.dex */
public class e {
    private Context context;
    private View frS;
    private TextView frT;
    private ImageView frU;
    private TextView frV;
    private TextView frW;
    private a frX;
    public boolean frY;
    private Animation fsa;
    private long frZ = 0;
    private boolean fsb = false;

    /* loaded from: classes3.dex */
    public interface a {
        void jl(boolean z);

        void n(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.frS = LayoutInflater.from(context).inflate(f.h.chosen_pb_post_info, (ViewGroup) null);
        this.frT = (TextView) this.frS.findViewById(f.g.chosen_post_info_copyright);
        this.frU = (ImageView) this.frS.findViewById(f.g.chosen_post_info_praise_icon);
        this.frV = (TextView) this.frS.findViewById(f.g.chosen_post_info_praise_num);
        this.frW = (TextView) this.frS.findViewById(f.g.chosen_post_info_original_post);
    }

    public View aYY() {
        return this.frS;
    }

    public void a(a aVar) {
        this.frX = aVar;
    }

    public void qi(int i) {
        if (this.frT != null) {
            this.frT.setText(i);
        }
    }

    public void D(View.OnClickListener onClickListener) {
        if (this.frW != null) {
            this.frW.setOnClickListener(onClickListener);
        }
    }

    public void cF(long j) {
        if (j >= 0) {
            this.frZ = j;
            if (this.frV != null) {
                this.frV.setVisibility(0);
                this.frV.setText(this.context.getString(f.j.chosen_pb_praise_num, ap.F(j)));
            }
            if (this.frV != null && this.frV.getVisibility() == 8) {
                this.frV.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            qi(f.j.chosen_pb_copyright);
            cF(excellentPbThreadInfo.zan.zansum.longValue());
            jp(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.frU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.fsb && bb.aU(e.this.context)) {
                        e.this.fsb = true;
                        e.this.frU.startAnimation(e.this.aZa());
                        if (e.this.frX != null) {
                            e.this.frX.jl(e.this.frY);
                        }
                    }
                }
            });
            D(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.frX != null) {
                        e.this.frX.n(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void aYZ() {
        this.fsb = false;
    }

    public void jo(boolean z) {
        jp(z);
        if (z) {
            this.frZ++;
        } else {
            this.frZ--;
        }
        cF(this.frZ);
    }

    private void jp(boolean z) {
        this.frY = z;
        if (z) {
            am.c(this.frU, f.C0146f.btn_zambia_big_s);
        } else {
            am.c(this.frU, f.C0146f.btn_zambia_big_n);
        }
        this.frU.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation aZa() {
        if (this.fsa == null) {
            this.fsa = AnimationUtils.loadAnimation(this.context, f.a.praise_animation_scale3);
        }
        return this.fsa;
    }
}
