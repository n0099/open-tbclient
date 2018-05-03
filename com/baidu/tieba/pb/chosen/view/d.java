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
    private HeadImageView eyW;
    private View fbi;
    private b fbj;
    private TextView fbk;
    private BarImageView fbl;
    private TextView fbm;
    private TextView fbn;
    private LinearLayout fbo;
    private TextView title;

    /* loaded from: classes3.dex */
    public interface b {
        void aVe();

        void bF(String str, String str2);

        void ql(String str);
    }

    public d(Context context) {
        this.fbi = LayoutInflater.from(context).inflate(d.i.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.fbi.findViewById(d.g.chosen_pb_title);
        this.eyW = (HeadImageView) this.fbi.findViewById(d.g.chosen_pb_person_info_head);
        this.blN = (TextView) this.fbi.findViewById(d.g.chosen_pb_person_info_name);
        this.fbk = (TextView) this.fbi.findViewById(d.g.chosen_pb_bar_forum_name);
        this.eyW.setRadius(l.dip2px(context, 2.0f));
        this.fbl = (BarImageView) this.fbi.findViewById(d.g.chosen_pb_bar_pic);
        this.fbm = (TextView) this.fbi.findViewById(d.g.chosen_pb_bar_attention_number);
        this.fbn = (TextView) this.fbi.findViewById(d.g.chosen_pb_bar_attention_button);
        this.fbn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (d.this.fbj != null) {
                    d.this.fbj.aVe();
                }
            }
        });
        this.fbo = (LinearLayout) this.fbi.findViewById(d.g.chosen_pb_bar_container);
    }

    public View aVh() {
        return this.fbi;
    }

    public void a(b bVar) {
        this.fbj = bVar;
    }

    public void qn(String str) {
        if (!StringUtils.isNull(str) && this.eyW != null) {
            this.eyW.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.fbo.setVisibility(8);
                return;
            }
            i.pY().cC(excellentPbThreadInfo.forum.forum_name);
            this.fbo.setVisibility(0);
            ai(context, excellentPbThreadInfo.forum.forum_name);
            if (this.fbl != null) {
                this.fbl.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.fbl.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.fbm != null && excellentPbThreadInfo.forum.member_count != null) {
                this.fbm.setText(an.z(excellentPbThreadInfo.forum.member_count.intValue()));
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
        if (this.fbk != null) {
            if (StringUtils.isNull(str)) {
                this.fbk.setVisibility(4);
                return;
            }
            this.fbk.setText(context.getString(d.k.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.fbk.setOnClickListener(new a(str));
            this.fbk.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            qn(userInfo.portrait);
            this.eyW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
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
        if (this.fbj != null) {
            this.fbj.bF(String.valueOf(j), str);
        }
    }

    public void jl(boolean z) {
        if (z) {
            this.fbn.setText(d.k.relate_forum_is_followed);
            ak.c(this.fbn, d.C0126d.cp_cont_d, 1);
            this.fbn.setEnabled(false);
            return;
        }
        this.fbn.setText(d.k.attention);
        this.fbn.setEnabled(true);
        ak.c(this.fbn, d.C0126d.cp_cont_g, 1);
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
            if (d.this.fbj != null) {
                d.this.fbj.ql(this.forumName);
            }
        }
    }
}
