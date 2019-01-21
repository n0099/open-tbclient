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
    private TextView bPW;
    private View fTa;
    private b fTb;
    private TextView fTc;
    private BarImageView fTd;
    private TextView fTe;
    private TextView fTf;
    private LinearLayout fTg;
    private HeadImageView fui;
    private TextView title;

    /* loaded from: classes3.dex */
    public interface b {
        void aik();

        void cn(String str, String str2);

        void ta(String str);
    }

    public d(Context context) {
        this.fTa = LayoutInflater.from(context).inflate(e.h.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.fTa.findViewById(e.g.chosen_pb_title);
        this.fui = (HeadImageView) this.fTa.findViewById(e.g.chosen_pb_person_info_head);
        this.bPW = (TextView) this.fTa.findViewById(e.g.chosen_pb_person_info_name);
        this.fTc = (TextView) this.fTa.findViewById(e.g.chosen_pb_bar_forum_name);
        this.fui.setRadius(l.dip2px(context, 2.0f));
        this.fTd = (BarImageView) this.fTa.findViewById(e.g.chosen_pb_bar_pic);
        this.fTe = (TextView) this.fTa.findViewById(e.g.chosen_pb_bar_attention_number);
        this.fTf = (TextView) this.fTa.findViewById(e.g.chosen_pb_bar_attention_button);
        this.fTf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.fTb != null) {
                    d.this.fTb.aik();
                }
            }
        });
        this.fTg = (LinearLayout) this.fTa.findViewById(e.g.chosen_pb_bar_container);
    }

    public View bho() {
        return this.fTa;
    }

    public void a(b bVar) {
        this.fTb = bVar;
    }

    public void tc(String str) {
        if (!StringUtils.isNull(str) && this.fui != null) {
            this.fui.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.fTg.setVisibility(8);
                return;
            }
            i.xR().ej(excellentPbThreadInfo.forum.forum_name);
            this.fTg.setVisibility(0);
            aD(context, excellentPbThreadInfo.forum.forum_name);
            if (this.fTd != null) {
                this.fTd.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.fTd.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.fTe != null && excellentPbThreadInfo.forum.member_count != null) {
                this.fTe.setText(ao.V(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                kv(true);
            } else {
                kv(false);
            }
        }
    }

    public void setName(String str) {
        if (this.bPW != null) {
            this.bPW.setText(str);
        }
    }

    private void aD(Context context, String str) {
        if (this.fTc != null) {
            if (StringUtils.isNull(str)) {
                this.fTc.setVisibility(4);
                return;
            }
            this.fTc.setText(context.getString(e.j.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.fTc.setOnClickListener(new a(str));
            this.fTc.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            tc(userInfo.portrait);
            this.fui.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.r(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.bPW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.r(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(long j, String str) {
        if (this.fTb != null) {
            this.fTb.cn(String.valueOf(j), str);
        }
    }

    public void kv(boolean z) {
        if (z) {
            this.fTf.setText(e.j.relate_forum_is_followed);
            al.c(this.fTf, e.d.cp_cont_d, 1);
            this.fTf.setEnabled(false);
            return;
        }
        this.fTf.setText(e.j.attention);
        this.fTf.setEnabled(true);
        al.c(this.fTf, e.d.cp_cont_g, 1);
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
            if (d.this.fTb != null) {
                d.this.fTb.ta(this.forumName);
            }
        }
    }
}
