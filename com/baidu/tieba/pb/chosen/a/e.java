package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.i;
import tbclient.FinePbPage.ForumInfo;
import tbclient.FinePbPage.User_Info;
/* loaded from: classes.dex */
public class e {
    private LinearLayout aIE;
    private HeadImageView aIG;
    private TextView aPi;
    private TextView anH;
    private TextView bZA;
    private View bZu;
    private b bZv;
    private TextView bZw;
    private BarImageView bZx;
    private TextView bZy;
    private TextView bZz;

    /* loaded from: classes.dex */
    public interface b {
        void aT(String str, String str2);

        void acy();

        void jb(String str);
    }

    public e(Context context) {
        this.bZu = LayoutInflater.from(context).inflate(i.g.chosen_pb_person_info, (ViewGroup) null);
        this.anH = (TextView) this.bZu.findViewById(i.f.chosen_pb_title);
        this.aIG = (HeadImageView) this.bZu.findViewById(i.f.chosen_pb_person_info_head);
        this.aPi = (TextView) this.bZu.findViewById(i.f.chosen_pb_person_info_name);
        this.bZw = (TextView) this.bZu.findViewById(i.f.chosen_pb_bar_forum_name);
        this.aIG.setRadius(com.baidu.adp.lib.util.k.dip2px(context, 2.0f));
        this.bZx = (BarImageView) this.bZu.findViewById(i.f.chosen_pb_bar_pic);
        this.bZz = (TextView) this.bZu.findViewById(i.f.chosen_pb_bar_attention_number);
        this.bZA = (TextView) this.bZu.findViewById(i.f.chosen_pb_bar_attention_button);
        this.bZA.setOnClickListener(new f(this));
        this.aIE = (LinearLayout) this.bZu.findViewById(i.f.chosen_pb_bar_container);
        this.bZy = (TextView) this.bZu.findViewById(i.f.chosen_pb_person_info_remark);
    }

    public View acB() {
        return this.bZu;
    }

    public void a(b bVar) {
        this.bZv = bVar;
    }

    public void je(String str) {
        if (!StringUtils.isNull(str) && this.aIG != null) {
            this.aIG.d(str, 12, false);
        }
    }

    public void a(Context context, ForumInfo forumInfo) {
        if (forumInfo != null && this.anH != null) {
            this.anH.setText(forumInfo.title);
            if (StringUtils.isNull(forumInfo.fromfname) || forumInfo.fromfid == null || forumInfo.fromfid.longValue() <= 0) {
                this.aIE.setVisibility(8);
                return;
            }
            this.aIE.setVisibility(0);
            P(context, forumInfo.fromfname);
            if (this.bZx != null) {
                this.bZx.d(forumInfo.avatar, 16, false);
                this.bZx.setOnClickListener(new a(forumInfo.fromfname));
            }
            if (StringUtils.isNull(forumInfo.authorremark)) {
                this.bZy.setVisibility(8);
            } else {
                this.bZy.setVisibility(0);
                this.bZy.setText(forumInfo.authorremark);
            }
            if (this.bZz != null && forumInfo.member_num != null) {
                this.bZz.setText(aq.o(forumInfo.member_num.longValue()));
            }
            if (forumInfo.is_like != null && forumInfo.is_like.intValue() == 1) {
                dZ(true);
            } else {
                dZ(false);
            }
        }
    }

    public void setName(String str) {
        if (this.aPi != null) {
            this.aPi.setText(str);
        }
    }

    private void P(Context context, String str) {
        if (this.bZw != null) {
            if (StringUtils.isNull(str)) {
                this.bZw.setVisibility(4);
                return;
            }
            this.bZw.setText(context.getString(i.C0057i.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.bZw.setOnClickListener(new a(str));
            this.bZw.setVisibility(0);
        }
    }

    public void a(User_Info user_Info) {
        if (user_Info != null) {
            setName(user_Info.name);
            je(user_Info.portrait);
            this.aIG.setOnClickListener(new g(this, user_Info));
            this.aPi.setOnClickListener(new h(this, user_Info));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(long j, String str) {
        if (this.bZv != null) {
            this.bZv.aT(String.valueOf(j), str);
        }
    }

    public void dZ(boolean z) {
        if (z) {
            this.bZA.setText(i.C0057i.chosen_pb_attentioned);
            al.b(this.bZA, i.c.cp_cont_d, 1);
            this.bZA.setEnabled(false);
            return;
        }
        this.bZA.setText(i.C0057i.chosen_pb_attention);
        this.bZA.setEnabled(true);
        al.b(this.bZA, i.c.cp_cont_g, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private String forumName;

        public a(String str) {
            this.forumName = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.bZv != null) {
                e.this.bZv.jb(this.forumName);
            }
        }
    }
}
