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
    private TextView aER;
    private LinearLayout aJN;
    private HeadImageView aJP;
    private TextView agd;
    private View cyH;
    private b cyI;
    private TextView cyJ;
    private BarImageView cyK;
    private TextView cyL;
    private TextView cyM;

    /* loaded from: classes.dex */
    public interface b {
        void aZ(String str, String str2);

        void ajn();

        void kt(String str);
    }

    public e(Context context) {
        this.cyH = LayoutInflater.from(context).inflate(n.g.chosen_pb_person_info, (ViewGroup) null);
        this.agd = (TextView) this.cyH.findViewById(n.f.chosen_pb_title);
        this.aJP = (HeadImageView) this.cyH.findViewById(n.f.chosen_pb_person_info_head);
        this.aER = (TextView) this.cyH.findViewById(n.f.chosen_pb_person_info_name);
        this.cyJ = (TextView) this.cyH.findViewById(n.f.chosen_pb_bar_forum_name);
        this.aJP.setRadius(com.baidu.adp.lib.util.k.dip2px(context, 2.0f));
        this.cyK = (BarImageView) this.cyH.findViewById(n.f.chosen_pb_bar_pic);
        this.cyL = (TextView) this.cyH.findViewById(n.f.chosen_pb_bar_attention_number);
        this.cyM = (TextView) this.cyH.findViewById(n.f.chosen_pb_bar_attention_button);
        this.cyM.setOnClickListener(new f(this));
        this.aJN = (LinearLayout) this.cyH.findViewById(n.f.chosen_pb_bar_container);
    }

    public View ajq() {
        return this.cyH;
    }

    public void a(b bVar) {
        this.cyI = bVar;
    }

    public void kv(String str) {
        if (!StringUtils.isNull(str) && this.aJP != null) {
            this.aJP.d(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.agd != null) {
            this.agd.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.aJN.setVisibility(8);
                return;
            }
            com.baidu.tbadk.core.m.rh().cg(excellentPbThreadInfo.forum.forum_name);
            this.aJN.setVisibility(0);
            O(context, excellentPbThreadInfo.forum.forum_name);
            if (this.cyK != null) {
                this.cyK.d(excellentPbThreadInfo.forum.avatar, 16, false);
                this.cyK.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.cyL != null && excellentPbThreadInfo.forum.member_count != null) {
                this.cyL.setText(ax.w(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                eP(true);
            } else {
                eP(false);
            }
        }
    }

    public void setName(String str) {
        if (this.aER != null) {
            this.aER.setText(str);
        }
    }

    private void O(Context context, String str) {
        if (this.cyJ != null) {
            if (StringUtils.isNull(str)) {
                this.cyJ.setVisibility(4);
                return;
            }
            this.cyJ.setText(context.getString(n.i.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.cyJ.setOnClickListener(new a(str));
            this.cyJ.setVisibility(0);
        }
    }

    public void a(UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            kv(userInfo.portrait);
            this.aJP.setOnClickListener(new g(this, userInfo));
            this.aER.setOnClickListener(new h(this, userInfo));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(long j, String str) {
        if (this.cyI != null) {
            this.cyI.aZ(String.valueOf(j), str);
        }
    }

    public void eP(boolean z) {
        if (z) {
            this.cyM.setText(n.i.chosen_pb_attentioned);
            as.b(this.cyM, n.c.cp_cont_d, 1);
            this.cyM.setEnabled(false);
            return;
        }
        this.cyM.setText(n.i.chosen_pb_attention);
        this.cyM.setEnabled(true);
        as.b(this.cyM, n.c.cp_cont_g, 1);
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
            if (e.this.cyI != null) {
                e.this.cyI.kt(this.forumName);
            }
        }
    }
}
