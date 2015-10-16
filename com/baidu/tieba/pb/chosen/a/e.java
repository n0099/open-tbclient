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
    private TextView aDl;
    private LinearLayout aHU;
    private HeadImageView aHW;
    private TextView alu;
    private View cfE;
    private b cfF;
    private TextView cfG;
    private BarImageView cfH;
    private TextView cfI;
    private TextView cfJ;
    private TextView cfK;

    /* loaded from: classes.dex */
    public interface b {
        void aV(String str, String str2);

        void aeE();

        void jB(String str);
    }

    public e(Context context) {
        this.cfE = LayoutInflater.from(context).inflate(i.g.chosen_pb_person_info, (ViewGroup) null);
        this.alu = (TextView) this.cfE.findViewById(i.f.chosen_pb_title);
        this.aHW = (HeadImageView) this.cfE.findViewById(i.f.chosen_pb_person_info_head);
        this.aDl = (TextView) this.cfE.findViewById(i.f.chosen_pb_person_info_name);
        this.cfG = (TextView) this.cfE.findViewById(i.f.chosen_pb_bar_forum_name);
        this.aHW.setRadius(com.baidu.adp.lib.util.k.dip2px(context, 2.0f));
        this.cfH = (BarImageView) this.cfE.findViewById(i.f.chosen_pb_bar_pic);
        this.cfJ = (TextView) this.cfE.findViewById(i.f.chosen_pb_bar_attention_number);
        this.cfK = (TextView) this.cfE.findViewById(i.f.chosen_pb_bar_attention_button);
        this.cfK.setOnClickListener(new f(this));
        this.aHU = (LinearLayout) this.cfE.findViewById(i.f.chosen_pb_bar_container);
        this.cfI = (TextView) this.cfE.findViewById(i.f.chosen_pb_person_info_remark);
    }

    public View aeH() {
        return this.cfE;
    }

    public void a(b bVar) {
        this.cfF = bVar;
    }

    public void jE(String str) {
        if (!StringUtils.isNull(str) && this.aHW != null) {
            this.aHW.d(str, 12, false);
        }
    }

    public void a(Context context, ForumInfo forumInfo) {
        if (forumInfo != null && this.alu != null) {
            this.alu.setText(forumInfo.title);
            if (StringUtils.isNull(forumInfo.fromfname) || forumInfo.fromfid == null || forumInfo.fromfid.longValue() <= 0) {
                this.aHU.setVisibility(8);
                return;
            }
            this.aHU.setVisibility(0);
            O(context, forumInfo.fromfname);
            if (this.cfH != null) {
                this.cfH.d(forumInfo.avatar, 16, false);
                this.cfH.setOnClickListener(new a(forumInfo.fromfname));
            }
            if (StringUtils.isNull(forumInfo.authorremark)) {
                this.cfI.setVisibility(8);
            } else {
                this.cfI.setVisibility(0);
                this.cfI.setText(forumInfo.authorremark);
            }
            if (this.cfJ != null && forumInfo.member_num != null) {
                this.cfJ.setText(as.s(forumInfo.member_num.longValue()));
            }
            if (forumInfo.is_like != null && forumInfo.is_like.intValue() == 1) {
                el(true);
            } else {
                el(false);
            }
        }
    }

    public void setName(String str) {
        if (this.aDl != null) {
            this.aDl.setText(str);
        }
    }

    private void O(Context context, String str) {
        if (this.cfG != null) {
            if (StringUtils.isNull(str)) {
                this.cfG.setVisibility(4);
                return;
            }
            this.cfG.setText(context.getString(i.h.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.cfG.setOnClickListener(new a(str));
            this.cfG.setVisibility(0);
        }
    }

    public void a(User_Info user_Info) {
        if (user_Info != null) {
            setName(user_Info.name);
            jE(user_Info.portrait);
            this.aHW.setOnClickListener(new g(this, user_Info));
            this.aDl.setOnClickListener(new h(this, user_Info));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(long j, String str) {
        if (this.cfF != null) {
            this.cfF.aV(String.valueOf(j), str);
        }
    }

    public void el(boolean z) {
        if (z) {
            this.cfK.setText(i.h.chosen_pb_attentioned);
            an.b(this.cfK, i.c.cp_cont_d, 1);
            this.cfK.setEnabled(false);
            return;
        }
        this.cfK.setText(i.h.chosen_pb_attention);
        this.cfK.setEnabled(true);
        an.b(this.cfK, i.c.cp_cont_g, 1);
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
            if (e.this.cfF != null) {
                e.this.cfF.jB(this.forumName);
            }
        }
    }
}
