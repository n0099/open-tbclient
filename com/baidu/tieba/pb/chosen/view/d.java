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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.e;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes3.dex */
public class d {
    private TextView bPV;
    private View fSZ;
    private b fTa;
    private TextView fTb;
    private BarImageView fTc;
    private TextView fTd;
    private TextView fTe;
    private LinearLayout fTf;
    private HeadImageView fuh;
    private TextView title;

    /* loaded from: classes3.dex */
    public interface b {
        void aik();

        void cn(String str, String str2);

        void ta(String str);
    }

    public d(Context context) {
        this.fSZ = LayoutInflater.from(context).inflate(e.h.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.fSZ.findViewById(e.g.chosen_pb_title);
        this.fuh = (HeadImageView) this.fSZ.findViewById(e.g.chosen_pb_person_info_head);
        this.bPV = (TextView) this.fSZ.findViewById(e.g.chosen_pb_person_info_name);
        this.fTb = (TextView) this.fSZ.findViewById(e.g.chosen_pb_bar_forum_name);
        this.fuh.setRadius(l.dip2px(context, 2.0f));
        this.fTc = (BarImageView) this.fSZ.findViewById(e.g.chosen_pb_bar_pic);
        this.fTd = (TextView) this.fSZ.findViewById(e.g.chosen_pb_bar_attention_number);
        this.fTe = (TextView) this.fSZ.findViewById(e.g.chosen_pb_bar_attention_button);
        this.fTe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.fTa != null) {
                    d.this.fTa.aik();
                }
            }
        });
        this.fTf = (LinearLayout) this.fSZ.findViewById(e.g.chosen_pb_bar_container);
    }

    public View bho() {
        return this.fSZ;
    }

    public void a(b bVar) {
        this.fTa = bVar;
    }

    public void tc(String str) {
        if (!StringUtils.isNull(str) && this.fuh != null) {
            this.fuh.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.fTf.setVisibility(8);
                return;
            }
            i.xR().ej(excellentPbThreadInfo.forum.forum_name);
            this.fTf.setVisibility(0);
            aD(context, excellentPbThreadInfo.forum.forum_name);
            if (this.fTc != null) {
                this.fTc.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.fTc.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.fTd != null && excellentPbThreadInfo.forum.member_count != null) {
                this.fTd.setText(ao.V(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                kv(true);
            } else {
                kv(false);
            }
        }
    }

    public void setName(String str) {
        if (this.bPV != null) {
            this.bPV.setText(str);
        }
    }

    private void aD(Context context, String str) {
        if (this.fTb != null) {
            if (StringUtils.isNull(str)) {
                this.fTb.setVisibility(4);
                return;
            }
            this.fTb.setText(context.getString(e.j.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.fTb.setOnClickListener(new a(str));
            this.fTb.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            tc(userInfo.portrait);
            this.fuh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.r(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.bPV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.r(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(long j, String str) {
        if (this.fTa != null) {
            this.fTa.cn(String.valueOf(j), str);
        }
    }

    public void kv(boolean z) {
        if (z) {
            this.fTe.setText(e.j.relate_forum_is_followed);
            al.c(this.fTe, e.d.cp_cont_d, 1);
            this.fTe.setEnabled(false);
            return;
        }
        this.fTe.setText(e.j.attention);
        this.fTe.setEnabled(true);
        al.c(this.fTe, e.d.cp_cont_g, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private String forumName;

        public a(String str) {
            this.forumName = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.fTa != null) {
                d.this.fTa.ta(this.forumName);
            }
        }
    }
}
