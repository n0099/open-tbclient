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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.d;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
/* loaded from: classes3.dex */
public class e {
    private Context context;
    private View frZ;
    private TextView fsa;
    private ImageView fsb;
    private TextView fsc;
    private TextView fsd;
    private a fse;
    public boolean fsf;
    private Animation fsh;
    private long fsg = 0;
    private boolean fsi = false;

    /* loaded from: classes3.dex */
    public interface a {
        void jl(boolean z);

        void n(long j, String str);
    }

    public e(Context context) {
        this.context = context;
        this.frZ = LayoutInflater.from(context).inflate(d.h.chosen_pb_post_info, (ViewGroup) null);
        this.fsa = (TextView) this.frZ.findViewById(d.g.chosen_post_info_copyright);
        this.fsb = (ImageView) this.frZ.findViewById(d.g.chosen_post_info_praise_icon);
        this.fsc = (TextView) this.frZ.findViewById(d.g.chosen_post_info_praise_num);
        this.fsd = (TextView) this.frZ.findViewById(d.g.chosen_post_info_original_post);
    }

    public View aZd() {
        return this.frZ;
    }

    public void a(a aVar) {
        this.fse = aVar;
    }

    public void qi(int i) {
        if (this.fsa != null) {
            this.fsa.setText(i);
        }
    }

    public void D(View.OnClickListener onClickListener) {
        if (this.fsd != null) {
            this.fsd.setOnClickListener(onClickListener);
        }
    }

    public void cF(long j) {
        if (j >= 0) {
            this.fsg = j;
            if (this.fsc != null) {
                this.fsc.setVisibility(0);
                this.fsc.setText(this.context.getString(d.j.chosen_pb_praise_num, ap.F(j)));
            }
            if (this.fsc != null && this.fsc.getVisibility() == 8) {
                this.fsc.setVisibility(0);
            }
        }
    }

    public void a(final ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null) {
            qi(d.j.chosen_pb_copyright);
            cF(excellentPbThreadInfo.zan.zansum.longValue());
            jp(excellentPbThreadInfo.zan.is_zan.booleanValue());
            this.fsb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!e.this.fsi && ba.aV(e.this.context)) {
                        e.this.fsi = true;
                        e.this.fsb.startAnimation(e.this.aZf());
                        if (e.this.fse != null) {
                            e.this.fse.jl(e.this.fsf);
                        }
                    }
                }
            });
            D(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.fse != null) {
                        e.this.fse.n(excellentPbThreadInfo.forum.forum_id.longValue(), excellentPbThreadInfo.thread_id + "");
                    }
                }
            });
        }
    }

    public void aZe() {
        this.fsi = false;
    }

    public void jo(boolean z) {
        jp(z);
        if (z) {
            this.fsg++;
        } else {
            this.fsg--;
        }
        cF(this.fsg);
    }

    private void jp(boolean z) {
        this.fsf = z;
        if (z) {
            am.c(this.fsb, d.f.btn_zambia_big_s);
        } else {
            am.c(this.fsb, d.f.btn_zambia_big_n);
        }
        this.fsb.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation aZf() {
        if (this.fsh == null) {
            this.fsh = AnimationUtils.loadAnimation(this.context, d.a.praise_animation_scale3);
        }
        return this.fsh;
    }
}
