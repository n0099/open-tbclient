package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.n;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes.dex */
public class e {
    private TextView aGr;
    private LinearLayout aLl;
    private HeadImageView aLn;
    private TextView ahk;
    private View cCn;
    private b cCo;
    private TextView cCp;
    private BarImageView cCq;
    private TextView cCr;
    private TextView cCs;

    /* loaded from: classes.dex */
    public interface b {
        void aU(String str, String str2);

        void aku();

        void kq(String str);
    }

    public e(Context context) {
        this.cCn = LayoutInflater.from(context).inflate(n.h.chosen_pb_person_info, (ViewGroup) null);
        this.ahk = (TextView) this.cCn.findViewById(n.g.chosen_pb_title);
        this.aLn = (HeadImageView) this.cCn.findViewById(n.g.chosen_pb_person_info_head);
        this.aGr = (TextView) this.cCn.findViewById(n.g.chosen_pb_person_info_name);
        this.cCp = (TextView) this.cCn.findViewById(n.g.chosen_pb_bar_forum_name);
        this.aLn.setRadius(com.baidu.adp.lib.util.k.dip2px(context, 2.0f));
        this.cCq = (BarImageView) this.cCn.findViewById(n.g.chosen_pb_bar_pic);
        this.cCr = (TextView) this.cCn.findViewById(n.g.chosen_pb_bar_attention_number);
        this.cCs = (TextView) this.cCn.findViewById(n.g.chosen_pb_bar_attention_button);
        this.cCs.setOnClickListener(new f(this));
        this.aLl = (LinearLayout) this.cCn.findViewById(n.g.chosen_pb_bar_container);
    }

    public View aky() {
        return this.cCn;
    }

    public void a(b bVar) {
        this.cCo = bVar;
    }

    public void ks(String str) {
        if (!StringUtils.isNull(str) && this.aLn != null) {
            this.aLn.d(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.ahk != null) {
            this.ahk.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.aLl.setVisibility(8);
                return;
            }
            com.baidu.tbadk.core.m.qQ().ci(excellentPbThreadInfo.forum.forum_name);
            this.aLl.setVisibility(0);
            O(context, excellentPbThreadInfo.forum.forum_name);
            if (this.cCq != null) {
                this.cCq.d(excellentPbThreadInfo.forum.avatar, 16, false);
                this.cCq.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.cCr != null && excellentPbThreadInfo.forum.member_count != null) {
                this.cCr.setText(ax.x(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                eO(true);
            } else {
                eO(false);
            }
        }
    }

    public void setName(String str) {
        if (this.aGr != null) {
            this.aGr.setText(str);
        }
    }

    private void O(Context context, String str) {
        if (this.cCp != null) {
            if (StringUtils.isNull(str)) {
                this.cCp.setVisibility(4);
                return;
            }
            this.cCp.setText(context.getString(n.j.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.cCp.setOnClickListener(new a(str));
            this.cCp.setVisibility(0);
        }
    }

    public void a(UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            ks(userInfo.portrait);
            this.aLn.setOnClickListener(new g(this, userInfo));
            this.aGr.setOnClickListener(new h(this, userInfo));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(long j, String str) {
        if (this.cCo != null) {
            this.cCo.aU(String.valueOf(j), str);
        }
    }

    public void eO(boolean z) {
        if (z) {
            this.cCs.setText(n.j.chosen_pb_attentioned);
            as.b(this.cCs, n.d.cp_cont_d, 1);
            this.cCs.setEnabled(false);
            return;
        }
        this.cCs.setText(n.j.chosen_pb_attention);
        this.cCs.setEnabled(true);
        as.b(this.cCs, n.d.cp_cont_g, 1);
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
            if (e.this.cCo != null) {
                e.this.cCo.kq(this.forumName);
            }
        }
    }
}
