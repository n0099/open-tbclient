package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.i;
import tbclient.FinePbPage.ForumInfo;
import tbclient.FinePbPage.User_Info;
/* loaded from: classes.dex */
public class e {
    private TextView aCf;
    private LinearLayout aGO;
    private HeadImageView aGQ;
    private TextView alz;
    private View cgf;
    private b cgg;
    private TextView cgh;
    private BarImageView cgi;
    private TextView cgj;
    private TextView cgk;
    private TextView cgl;

    /* loaded from: classes.dex */
    public interface b {
        void aU(String str, String str2);

        void aeV();

        void jD(String str);
    }

    public e(Context context) {
        this.cgf = LayoutInflater.from(context).inflate(i.g.chosen_pb_person_info, (ViewGroup) null);
        this.alz = (TextView) this.cgf.findViewById(i.f.chosen_pb_title);
        this.aGQ = (HeadImageView) this.cgf.findViewById(i.f.chosen_pb_person_info_head);
        this.aCf = (TextView) this.cgf.findViewById(i.f.chosen_pb_person_info_name);
        this.cgh = (TextView) this.cgf.findViewById(i.f.chosen_pb_bar_forum_name);
        this.aGQ.setRadius(com.baidu.adp.lib.util.k.dip2px(context, 2.0f));
        this.cgi = (BarImageView) this.cgf.findViewById(i.f.chosen_pb_bar_pic);
        this.cgk = (TextView) this.cgf.findViewById(i.f.chosen_pb_bar_attention_number);
        this.cgl = (TextView) this.cgf.findViewById(i.f.chosen_pb_bar_attention_button);
        this.cgl.setOnClickListener(new f(this));
        this.aGO = (LinearLayout) this.cgf.findViewById(i.f.chosen_pb_bar_container);
        this.cgj = (TextView) this.cgf.findViewById(i.f.chosen_pb_person_info_remark);
    }

    public View aeY() {
        return this.cgf;
    }

    public void a(b bVar) {
        this.cgg = bVar;
    }

    public void jG(String str) {
        if (!StringUtils.isNull(str) && this.aGQ != null) {
            this.aGQ.d(str, 12, false);
        }
    }

    public void a(Context context, ForumInfo forumInfo) {
        if (forumInfo != null && this.alz != null) {
            this.alz.setText(forumInfo.title);
            if (StringUtils.isNull(forumInfo.fromfname) || forumInfo.fromfid == null || forumInfo.fromfid.longValue() <= 0) {
                this.aGO.setVisibility(8);
                return;
            }
            this.aGO.setVisibility(0);
            O(context, forumInfo.fromfname);
            if (this.cgi != null) {
                this.cgi.d(forumInfo.avatar, 16, false);
                this.cgi.setOnClickListener(new a(forumInfo.fromfname));
            }
            if (StringUtils.isNull(forumInfo.authorremark)) {
                this.cgj.setVisibility(8);
            } else {
                this.cgj.setVisibility(0);
                this.cgj.setText(forumInfo.authorremark);
            }
            if (this.cgk != null && forumInfo.member_num != null) {
                this.cgk.setText(as.q(forumInfo.member_num.longValue()));
            }
            if (forumInfo.is_like != null && forumInfo.is_like.intValue() == 1) {
                en(true);
            } else {
                en(false);
            }
        }
    }

    public void setName(String str) {
        if (this.aCf != null) {
            this.aCf.setText(str);
        }
    }

    private void O(Context context, String str) {
        if (this.cgh != null) {
            if (StringUtils.isNull(str)) {
                this.cgh.setVisibility(4);
                return;
            }
            this.cgh.setText(context.getString(i.h.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.cgh.setOnClickListener(new a(str));
            this.cgh.setVisibility(0);
        }
    }

    public void a(User_Info user_Info) {
        if (user_Info != null) {
            setName(user_Info.name);
            jG(user_Info.portrait);
            this.aGQ.setOnClickListener(new g(this, user_Info));
            this.aCf.setOnClickListener(new h(this, user_Info));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(long j, String str) {
        if (this.cgg != null) {
            this.cgg.aU(String.valueOf(j), str);
        }
    }

    public void en(boolean z) {
        if (z) {
            this.cgl.setText(i.h.chosen_pb_attentioned);
            an.b(this.cgl, i.c.cp_cont_d, 1);
            this.cgl.setEnabled(false);
            return;
        }
        this.cgl.setText(i.h.chosen_pb_attention);
        this.cgl.setEnabled(true);
        an.b(this.cgl, i.c.cp_cont_g, 1);
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
            if (e.this.cgg != null) {
                e.this.cgg.jD(this.forumName);
            }
        }
    }
}
