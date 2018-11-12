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
    private TextView bLs;
    private LinearLayout fIA;
    private View fIu;
    private b fIv;
    private TextView fIw;
    private BarImageView fIx;
    private TextView fIy;
    private TextView fIz;
    private HeadImageView fjD;
    private TextView title;

    /* loaded from: classes3.dex */
    public interface b {
        void agx();

        void ch(String str, String str2);

        void se(String str);
    }

    public d(Context context) {
        this.fIu = LayoutInflater.from(context).inflate(e.h.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.fIu.findViewById(e.g.chosen_pb_title);
        this.fjD = (HeadImageView) this.fIu.findViewById(e.g.chosen_pb_person_info_head);
        this.bLs = (TextView) this.fIu.findViewById(e.g.chosen_pb_person_info_name);
        this.fIw = (TextView) this.fIu.findViewById(e.g.chosen_pb_bar_forum_name);
        this.fjD.setRadius(l.dip2px(context, 2.0f));
        this.fIx = (BarImageView) this.fIu.findViewById(e.g.chosen_pb_bar_pic);
        this.fIy = (TextView) this.fIu.findViewById(e.g.chosen_pb_bar_attention_number);
        this.fIz = (TextView) this.fIu.findViewById(e.g.chosen_pb_bar_attention_button);
        this.fIz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.fIv != null) {
                    d.this.fIv.agx();
                }
            }
        });
        this.fIA = (LinearLayout) this.fIu.findViewById(e.g.chosen_pb_bar_container);
    }

    public View bei() {
        return this.fIu;
    }

    public void a(b bVar) {
        this.fIv = bVar;
    }

    public void sg(String str) {
        if (!StringUtils.isNull(str) && this.fjD != null) {
            this.fjD.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.fIA.setVisibility(8);
                return;
            }
            i.wA().dI(excellentPbThreadInfo.forum.forum_name);
            this.fIA.setVisibility(0);
            aC(context, excellentPbThreadInfo.forum.forum_name);
            if (this.fIx != null) {
                this.fIx.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.fIx.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.fIy != null && excellentPbThreadInfo.forum.member_count != null) {
                this.fIy.setText(ao.N(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                kp(true);
            } else {
                kp(false);
            }
        }
    }

    public void setName(String str) {
        if (this.bLs != null) {
            this.bLs.setText(str);
        }
    }

    private void aC(Context context, String str) {
        if (this.fIw != null) {
            if (StringUtils.isNull(str)) {
                this.fIw.setVisibility(4);
                return;
            }
            this.fIw.setText(context.getString(e.j.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.fIw.setOnClickListener(new a(str));
            this.fIw.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            sg(userInfo.portrait);
            this.fjD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.r(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.bLs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.r(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(long j, String str) {
        if (this.fIv != null) {
            this.fIv.ch(String.valueOf(j), str);
        }
    }

    public void kp(boolean z) {
        if (z) {
            this.fIz.setText(e.j.relate_forum_is_followed);
            al.c(this.fIz, e.d.cp_cont_d, 1);
            this.fIz.setEnabled(false);
            return;
        }
        this.fIz.setText(e.j.attention);
        this.fIz.setEnabled(true);
        al.c(this.fIz, e.d.cp_cont_g, 1);
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
            if (d.this.fIv != null) {
                d.this.fIv.se(this.forumName);
            }
        }
    }
}
