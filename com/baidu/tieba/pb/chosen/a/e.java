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
    private LinearLayout aIR;
    private HeadImageView aIT;
    private TextView aPv;
    private TextView amV;
    private View cao;
    private b cap;
    private TextView caq;
    private BarImageView car;
    private TextView cas;
    private TextView cat;
    private TextView cau;

    /* loaded from: classes.dex */
    public interface b {
        void aV(String str, String str2);

        void acH();

        void jj(String str);
    }

    public e(Context context) {
        this.cao = LayoutInflater.from(context).inflate(i.g.chosen_pb_person_info, (ViewGroup) null);
        this.amV = (TextView) this.cao.findViewById(i.f.chosen_pb_title);
        this.aIT = (HeadImageView) this.cao.findViewById(i.f.chosen_pb_person_info_head);
        this.aPv = (TextView) this.cao.findViewById(i.f.chosen_pb_person_info_name);
        this.caq = (TextView) this.cao.findViewById(i.f.chosen_pb_bar_forum_name);
        this.aIT.setRadius(com.baidu.adp.lib.util.k.dip2px(context, 2.0f));
        this.car = (BarImageView) this.cao.findViewById(i.f.chosen_pb_bar_pic);
        this.cat = (TextView) this.cao.findViewById(i.f.chosen_pb_bar_attention_number);
        this.cau = (TextView) this.cao.findViewById(i.f.chosen_pb_bar_attention_button);
        this.cau.setOnClickListener(new f(this));
        this.aIR = (LinearLayout) this.cao.findViewById(i.f.chosen_pb_bar_container);
        this.cas = (TextView) this.cao.findViewById(i.f.chosen_pb_person_info_remark);
    }

    public View acK() {
        return this.cao;
    }

    public void a(b bVar) {
        this.cap = bVar;
    }

    public void jm(String str) {
        if (!StringUtils.isNull(str) && this.aIT != null) {
            this.aIT.d(str, 12, false);
        }
    }

    public void a(Context context, ForumInfo forumInfo) {
        if (forumInfo != null && this.amV != null) {
            this.amV.setText(forumInfo.title);
            if (StringUtils.isNull(forumInfo.fromfname) || forumInfo.fromfid == null || forumInfo.fromfid.longValue() <= 0) {
                this.aIR.setVisibility(8);
                return;
            }
            this.aIR.setVisibility(0);
            P(context, forumInfo.fromfname);
            if (this.car != null) {
                this.car.d(forumInfo.avatar, 16, false);
                this.car.setOnClickListener(new a(forumInfo.fromfname));
            }
            if (StringUtils.isNull(forumInfo.authorremark)) {
                this.cas.setVisibility(8);
            } else {
                this.cas.setVisibility(0);
                this.cas.setText(forumInfo.authorremark);
            }
            if (this.cat != null && forumInfo.member_num != null) {
                this.cat.setText(aq.o(forumInfo.member_num.longValue()));
            }
            if (forumInfo.is_like != null && forumInfo.is_like.intValue() == 1) {
                eg(true);
            } else {
                eg(false);
            }
        }
    }

    public void setName(String str) {
        if (this.aPv != null) {
            this.aPv.setText(str);
        }
    }

    private void P(Context context, String str) {
        if (this.caq != null) {
            if (StringUtils.isNull(str)) {
                this.caq.setVisibility(4);
                return;
            }
            this.caq.setText(context.getString(i.h.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.caq.setOnClickListener(new a(str));
            this.caq.setVisibility(0);
        }
    }

    public void a(User_Info user_Info) {
        if (user_Info != null) {
            setName(user_Info.name);
            jm(user_Info.portrait);
            this.aIT.setOnClickListener(new g(this, user_Info));
            this.aPv.setOnClickListener(new h(this, user_Info));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(long j, String str) {
        if (this.cap != null) {
            this.cap.aV(String.valueOf(j), str);
        }
    }

    public void eg(boolean z) {
        if (z) {
            this.cau.setText(i.h.chosen_pb_attentioned);
            al.b(this.cau, i.c.cp_cont_d, 1);
            this.cau.setEnabled(false);
            return;
        }
        this.cau.setText(i.h.chosen_pb_attention);
        this.cau.setEnabled(true);
        al.b(this.cau, i.c.cp_cont_g, 1);
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
            if (e.this.cap != null) {
                e.this.cap.jj(this.forumName);
            }
        }
    }
}
