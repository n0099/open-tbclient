package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes.dex */
public class e {
    private TextView aHk;
    private LinearLayout aMq;
    private HeadImageView aMs;
    private TextView apm;
    private View cIS;
    private b cIT;
    private TextView cIU;
    private BarImageView cIV;
    private TextView cIW;
    private TextView cIX;

    /* loaded from: classes.dex */
    public interface b {
        void aos();

        void bb(String str, String str2);

        void kt(String str);
    }

    public e(Context context) {
        this.cIS = LayoutInflater.from(context).inflate(t.h.chosen_pb_person_info, (ViewGroup) null);
        this.apm = (TextView) this.cIS.findViewById(t.g.chosen_pb_title);
        this.aMs = (HeadImageView) this.cIS.findViewById(t.g.chosen_pb_person_info_head);
        this.aHk = (TextView) this.cIS.findViewById(t.g.chosen_pb_person_info_name);
        this.cIU = (TextView) this.cIS.findViewById(t.g.chosen_pb_bar_forum_name);
        this.aMs.setRadius(com.baidu.adp.lib.util.k.dip2px(context, 2.0f));
        this.cIV = (BarImageView) this.cIS.findViewById(t.g.chosen_pb_bar_pic);
        this.cIW = (TextView) this.cIS.findViewById(t.g.chosen_pb_bar_attention_number);
        this.cIX = (TextView) this.cIS.findViewById(t.g.chosen_pb_bar_attention_button);
        this.cIX.setOnClickListener(new f(this));
        this.aMq = (LinearLayout) this.cIS.findViewById(t.g.chosen_pb_bar_container);
    }

    public View aow() {
        return this.cIS;
    }

    public void a(b bVar) {
        this.cIT = bVar;
    }

    public void kv(String str) {
        if (!StringUtils.isNull(str) && this.aMs != null) {
            this.aMs.d(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.apm != null) {
            this.apm.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.aMq.setVisibility(8);
                return;
            }
            com.baidu.tbadk.core.l.rn().ch(excellentPbThreadInfo.forum.forum_name);
            this.aMq.setVisibility(0);
            U(context, excellentPbThreadInfo.forum.forum_name);
            if (this.cIV != null) {
                this.cIV.d(excellentPbThreadInfo.forum.avatar, 16, false);
                this.cIV.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.cIW != null && excellentPbThreadInfo.forum.member_count != null) {
                this.cIW.setText(aw.y(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                fc(true);
            } else {
                fc(false);
            }
        }
    }

    public void setName(String str) {
        if (this.aHk != null) {
            this.aHk.setText(str);
        }
    }

    private void U(Context context, String str) {
        if (this.cIU != null) {
            if (StringUtils.isNull(str)) {
                this.cIU.setVisibility(4);
                return;
            }
            this.cIU.setText(context.getString(t.j.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.cIU.setOnClickListener(new a(str));
            this.cIU.setVisibility(0);
        }
    }

    public void a(UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            kv(userInfo.portrait);
            this.aMs.setOnClickListener(new g(this, userInfo));
            this.aHk.setOnClickListener(new h(this, userInfo));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(long j, String str) {
        if (this.cIT != null) {
            this.cIT.bb(String.valueOf(j), str);
        }
    }

    public void fc(boolean z) {
        if (z) {
            this.cIX.setText(t.j.chosen_pb_attentioned);
            ar.b(this.cIX, t.d.cp_cont_d, 1);
            this.cIX.setEnabled(false);
            return;
        }
        this.cIX.setText(t.j.chosen_pb_attention);
        this.cIX.setEnabled(true);
        ar.b(this.cIX, t.d.cp_cont_g, 1);
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
            if (e.this.cIT != null) {
                e.this.cIT.kt(this.forumName);
            }
        }
    }
}
