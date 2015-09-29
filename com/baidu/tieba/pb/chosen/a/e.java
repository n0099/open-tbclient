package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.i;
import tbclient.FinePbPage.ForumInfo;
import tbclient.FinePbPage.User_Info;
/* loaded from: classes.dex */
public class e {
    private TextView aDa;
    private LinearLayout aHJ;
    private HeadImageView aHL;
    private TextView alt;
    private View cft;
    private b cfu;
    private TextView cfv;
    private BarImageView cfw;
    private TextView cfx;
    private TextView cfy;
    private TextView cfz;

    /* loaded from: classes.dex */
    public interface b {
        void aV(String str, String str2);

        void aeE();

        void jB(String str);
    }

    public e(Context context) {
        this.cft = LayoutInflater.from(context).inflate(i.g.chosen_pb_person_info, (ViewGroup) null);
        this.alt = (TextView) this.cft.findViewById(i.f.chosen_pb_title);
        this.aHL = (HeadImageView) this.cft.findViewById(i.f.chosen_pb_person_info_head);
        this.aDa = (TextView) this.cft.findViewById(i.f.chosen_pb_person_info_name);
        this.cfv = (TextView) this.cft.findViewById(i.f.chosen_pb_bar_forum_name);
        this.aHL.setRadius(com.baidu.adp.lib.util.k.dip2px(context, 2.0f));
        this.cfw = (BarImageView) this.cft.findViewById(i.f.chosen_pb_bar_pic);
        this.cfy = (TextView) this.cft.findViewById(i.f.chosen_pb_bar_attention_number);
        this.cfz = (TextView) this.cft.findViewById(i.f.chosen_pb_bar_attention_button);
        this.cfz.setOnClickListener(new f(this));
        this.aHJ = (LinearLayout) this.cft.findViewById(i.f.chosen_pb_bar_container);
        this.cfx = (TextView) this.cft.findViewById(i.f.chosen_pb_person_info_remark);
    }

    public View aeH() {
        return this.cft;
    }

    public void a(b bVar) {
        this.cfu = bVar;
    }

    public void jE(String str) {
        if (!StringUtils.isNull(str) && this.aHL != null) {
            this.aHL.d(str, 12, false);
        }
    }

    public void a(Context context, ForumInfo forumInfo) {
        if (forumInfo != null && this.alt != null) {
            this.alt.setText(forumInfo.title);
            if (StringUtils.isNull(forumInfo.fromfname) || forumInfo.fromfid == null || forumInfo.fromfid.longValue() <= 0) {
                this.aHJ.setVisibility(8);
                return;
            }
            this.aHJ.setVisibility(0);
            O(context, forumInfo.fromfname);
            if (this.cfw != null) {
                this.cfw.d(forumInfo.avatar, 16, false);
                this.cfw.setOnClickListener(new a(forumInfo.fromfname));
            }
            if (StringUtils.isNull(forumInfo.authorremark)) {
                this.cfx.setVisibility(8);
            } else {
                this.cfx.setVisibility(0);
                this.cfx.setText(forumInfo.authorremark);
            }
            if (this.cfy != null && forumInfo.member_num != null) {
                this.cfy.setText(ar.s(forumInfo.member_num.longValue()));
            }
            if (forumInfo.is_like != null && forumInfo.is_like.intValue() == 1) {
                el(true);
            } else {
                el(false);
            }
        }
    }

    public void setName(String str) {
        if (this.aDa != null) {
            this.aDa.setText(str);
        }
    }

    private void O(Context context, String str) {
        if (this.cfv != null) {
            if (StringUtils.isNull(str)) {
                this.cfv.setVisibility(4);
                return;
            }
            this.cfv.setText(context.getString(i.h.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.cfv.setOnClickListener(new a(str));
            this.cfv.setVisibility(0);
        }
    }

    public void a(User_Info user_Info) {
        if (user_Info != null) {
            setName(user_Info.name);
            jE(user_Info.portrait);
            this.aHL.setOnClickListener(new g(this, user_Info));
            this.aDa.setOnClickListener(new h(this, user_Info));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(long j, String str) {
        if (this.cfu != null) {
            this.cfu.aV(String.valueOf(j), str);
        }
    }

    public void el(boolean z) {
        if (z) {
            this.cfz.setText(i.h.chosen_pb_attentioned);
            am.b(this.cfz, i.c.cp_cont_d, 1);
            this.cfz.setEnabled(false);
            return;
        }
        this.cfz.setText(i.h.chosen_pb_attention);
        this.cfz.setEnabled(true);
        am.b(this.cfz, i.c.cp_cont_g, 1);
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
            if (e.this.cfu != null) {
                e.this.cfu.jB(this.forumName);
            }
        }
    }
}
