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
    private TextView bCa;
    private HeadImageView faA;
    private View fzt;
    private b fzu;
    private TextView fzv;
    private BarImageView fzw;
    private TextView fzx;
    private TextView fzy;
    private LinearLayout fzz;
    private TextView title;

    /* loaded from: classes3.dex */
    public interface b {
        void bV(String str, String str2);

        void bbv();

        void rD(String str);
    }

    public d(Context context) {
        this.fzt = LayoutInflater.from(context).inflate(e.h.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.fzt.findViewById(e.g.chosen_pb_title);
        this.faA = (HeadImageView) this.fzt.findViewById(e.g.chosen_pb_person_info_head);
        this.bCa = (TextView) this.fzt.findViewById(e.g.chosen_pb_person_info_name);
        this.fzv = (TextView) this.fzt.findViewById(e.g.chosen_pb_bar_forum_name);
        this.faA.setRadius(l.dip2px(context, 2.0f));
        this.fzw = (BarImageView) this.fzt.findViewById(e.g.chosen_pb_bar_pic);
        this.fzx = (TextView) this.fzt.findViewById(e.g.chosen_pb_bar_attention_number);
        this.fzy = (TextView) this.fzt.findViewById(e.g.chosen_pb_bar_attention_button);
        this.fzy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.fzu != null) {
                    d.this.fzu.bbv();
                }
            }
        });
        this.fzz = (LinearLayout) this.fzt.findViewById(e.g.chosen_pb_bar_container);
    }

    public View bby() {
        return this.fzt;
    }

    public void a(b bVar) {
        this.fzu = bVar;
    }

    public void rF(String str) {
        if (!StringUtils.isNull(str) && this.faA != null) {
            this.faA.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.fzz.setVisibility(8);
                return;
            }
            i.uj().ds(excellentPbThreadInfo.forum.forum_name);
            this.fzz.setVisibility(0);
            aC(context, excellentPbThreadInfo.forum.forum_name);
            if (this.fzw != null) {
                this.fzw.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.fzw.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.fzx != null && excellentPbThreadInfo.forum.member_count != null) {
                this.fzx.setText(ao.J(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                jO(true);
            } else {
                jO(false);
            }
        }
    }

    public void setName(String str) {
        if (this.bCa != null) {
            this.bCa.setText(str);
        }
    }

    private void aC(Context context, String str) {
        if (this.fzv != null) {
            if (StringUtils.isNull(str)) {
                this.fzv.setVisibility(4);
                return;
            }
            this.fzv.setText(context.getString(e.j.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.fzv.setOnClickListener(new a(str));
            this.fzv.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            rF(userInfo.portrait);
            this.faA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.r(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.bCa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.r(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(long j, String str) {
        if (this.fzu != null) {
            this.fzu.bV(String.valueOf(j), str);
        }
    }

    public void jO(boolean z) {
        if (z) {
            this.fzy.setText(e.j.relate_forum_is_followed);
            al.c(this.fzy, e.d.cp_cont_d, 1);
            this.fzy.setEnabled(false);
            return;
        }
        this.fzy.setText(e.j.attention);
        this.fzy.setEnabled(true);
        al.c(this.fzy, e.d.cp_cont_g, 1);
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
            if (d.this.fzu != null) {
                d.this.fzu.rD(this.forumName);
            }
        }
    }
}
