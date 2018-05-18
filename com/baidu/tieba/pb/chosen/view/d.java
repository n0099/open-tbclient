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
    private TextView bmc;
    private HeadImageView eAe;
    private View fcp;
    private b fcq;
    private TextView fcr;
    private BarImageView fcs;
    private TextView fct;
    private TextView fcu;
    private LinearLayout fcv;
    private TextView title;

    /* loaded from: classes3.dex */
    public interface b {
        void aVe();

        void bF(String str, String str2);

        void qo(String str);
    }

    public d(Context context) {
        this.fcp = LayoutInflater.from(context).inflate(d.i.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.fcp.findViewById(d.g.chosen_pb_title);
        this.eAe = (HeadImageView) this.fcp.findViewById(d.g.chosen_pb_person_info_head);
        this.bmc = (TextView) this.fcp.findViewById(d.g.chosen_pb_person_info_name);
        this.fcr = (TextView) this.fcp.findViewById(d.g.chosen_pb_bar_forum_name);
        this.eAe.setRadius(l.dip2px(context, 2.0f));
        this.fcs = (BarImageView) this.fcp.findViewById(d.g.chosen_pb_bar_pic);
        this.fct = (TextView) this.fcp.findViewById(d.g.chosen_pb_bar_attention_number);
        this.fcu = (TextView) this.fcp.findViewById(d.g.chosen_pb_bar_attention_button);
        this.fcu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (d.this.fcq != null) {
                    d.this.fcq.aVe();
                }
            }
        });
        this.fcv = (LinearLayout) this.fcp.findViewById(d.g.chosen_pb_bar_container);
    }

    public View aVh() {
        return this.fcp;
    }

    public void a(b bVar) {
        this.fcq = bVar;
    }

    public void qq(String str) {
        if (!StringUtils.isNull(str) && this.eAe != null) {
            this.eAe.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.fcv.setVisibility(8);
                return;
            }
            i.pX().cC(excellentPbThreadInfo.forum.forum_name);
            this.fcv.setVisibility(0);
            ai(context, excellentPbThreadInfo.forum.forum_name);
            if (this.fcs != null) {
                this.fcs.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.fcs.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.fct != null && excellentPbThreadInfo.forum.member_count != null) {
                this.fct.setText(an.z(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                jm(true);
            } else {
                jm(false);
            }
        }
    }

    public void setName(String str) {
        if (this.bmc != null) {
            this.bmc.setText(str);
        }
    }

    private void ai(Context context, String str) {
        if (this.fcr != null) {
            if (StringUtils.isNull(str)) {
                this.fcr.setVisibility(4);
                return;
            }
            this.fcr.setText(context.getString(d.k.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.fcr.setOnClickListener(new a(str));
            this.fcr.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            qq(userInfo.portrait);
            this.eAe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    d.this.p(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.bmc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    d.this.p(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(long j, String str) {
        if (this.fcq != null) {
            this.fcq.bF(String.valueOf(j), str);
        }
    }

    public void jm(boolean z) {
        if (z) {
            this.fcu.setText(d.k.relate_forum_is_followed);
            ak.c(this.fcu, d.C0126d.cp_cont_d, 1);
            this.fcu.setEnabled(false);
            return;
        }
        this.fcu.setText(d.k.attention);
        this.fcu.setEnabled(true);
        ak.c(this.fcu, d.C0126d.cp_cont_g, 1);
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
            if (d.this.fcq != null) {
                d.this.fcq.qo(this.forumName);
            }
        }
    }
}
