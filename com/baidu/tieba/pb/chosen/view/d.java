package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes3.dex */
public class d {
    private TextView blN;
    private HeadImageView eyZ;
    private View fbl;
    private b fbm;
    private TextView fbn;
    private BarImageView fbo;
    private TextView fbp;
    private TextView fbq;
    private LinearLayout fbr;
    private TextView title;

    /* loaded from: classes3.dex */
    public interface b {
        void aVe();

        void bF(String str, String str2);

        void ql(String str);
    }

    public d(Context context) {
        this.fbl = LayoutInflater.from(context).inflate(d.i.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.fbl.findViewById(d.g.chosen_pb_title);
        this.eyZ = (HeadImageView) this.fbl.findViewById(d.g.chosen_pb_person_info_head);
        this.blN = (TextView) this.fbl.findViewById(d.g.chosen_pb_person_info_name);
        this.fbn = (TextView) this.fbl.findViewById(d.g.chosen_pb_bar_forum_name);
        this.eyZ.setRadius(l.dip2px(context, 2.0f));
        this.fbo = (BarImageView) this.fbl.findViewById(d.g.chosen_pb_bar_pic);
        this.fbp = (TextView) this.fbl.findViewById(d.g.chosen_pb_bar_attention_number);
        this.fbq = (TextView) this.fbl.findViewById(d.g.chosen_pb_bar_attention_button);
        this.fbq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (d.this.fbm != null) {
                    d.this.fbm.aVe();
                }
            }
        });
        this.fbr = (LinearLayout) this.fbl.findViewById(d.g.chosen_pb_bar_container);
    }

    public View aVh() {
        return this.fbl;
    }

    public void a(b bVar) {
        this.fbm = bVar;
    }

    public void qn(String str) {
        if (!StringUtils.isNull(str) && this.eyZ != null) {
            this.eyZ.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.fbr.setVisibility(8);
                return;
            }
            i.pY().cC(excellentPbThreadInfo.forum.forum_name);
            this.fbr.setVisibility(0);
            ai(context, excellentPbThreadInfo.forum.forum_name);
            if (this.fbo != null) {
                this.fbo.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.fbo.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.fbp != null && excellentPbThreadInfo.forum.member_count != null) {
                this.fbp.setText(an.z(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                jl(true);
            } else {
                jl(false);
            }
        }
    }

    public void setName(String str) {
        if (this.blN != null) {
            this.blN.setText(str);
        }
    }

    private void ai(Context context, String str) {
        if (this.fbn != null) {
            if (StringUtils.isNull(str)) {
                this.fbn.setVisibility(4);
                return;
            }
            this.fbn.setText(context.getString(d.k.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.fbn.setOnClickListener(new a(str));
            this.fbn.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            qn(userInfo.portrait);
            this.eyZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    d.this.p(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.blN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    d.this.p(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(long j, String str) {
        if (this.fbm != null) {
            this.fbm.bF(String.valueOf(j), str);
        }
    }

    public void jl(boolean z) {
        if (z) {
            this.fbq.setText(d.k.relate_forum_is_followed);
            ak.c(this.fbq, d.C0126d.cp_cont_d, 1);
            this.fbq.setEnabled(false);
            return;
        }
        this.fbq.setText(d.k.attention);
        this.fbq.setEnabled(true);
        ak.c(this.fbq, d.C0126d.cp_cont_g, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private String forumName;

        public a(String str) {
            this.forumName = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (d.this.fbm != null) {
                d.this.fbm.ql(this.forumName);
            }
        }
    }
}
