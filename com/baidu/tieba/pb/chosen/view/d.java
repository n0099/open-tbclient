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
    private TextView bKH;
    private View fGV;
    private b fGW;
    private TextView fGX;
    private BarImageView fGY;
    private TextView fGZ;
    private TextView fHa;
    private LinearLayout fHb;
    private HeadImageView fii;
    private TextView title;

    /* loaded from: classes3.dex */
    public interface b {
        void beH();

        void ch(String str, String str2);

        void sd(String str);
    }

    public d(Context context) {
        this.fGV = LayoutInflater.from(context).inflate(e.h.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.fGV.findViewById(e.g.chosen_pb_title);
        this.fii = (HeadImageView) this.fGV.findViewById(e.g.chosen_pb_person_info_head);
        this.bKH = (TextView) this.fGV.findViewById(e.g.chosen_pb_person_info_name);
        this.fGX = (TextView) this.fGV.findViewById(e.g.chosen_pb_bar_forum_name);
        this.fii.setRadius(l.dip2px(context, 2.0f));
        this.fGY = (BarImageView) this.fGV.findViewById(e.g.chosen_pb_bar_pic);
        this.fGZ = (TextView) this.fGV.findViewById(e.g.chosen_pb_bar_attention_number);
        this.fHa = (TextView) this.fGV.findViewById(e.g.chosen_pb_bar_attention_button);
        this.fHa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.fGW != null) {
                    d.this.fGW.beH();
                }
            }
        });
        this.fHb = (LinearLayout) this.fGV.findViewById(e.g.chosen_pb_bar_container);
    }

    public View beK() {
        return this.fGV;
    }

    public void a(b bVar) {
        this.fGW = bVar;
    }

    public void sf(String str) {
        if (!StringUtils.isNull(str) && this.fii != null) {
            this.fii.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.fHb.setVisibility(8);
                return;
            }
            i.ws().dI(excellentPbThreadInfo.forum.forum_name);
            this.fHb.setVisibility(0);
            aE(context, excellentPbThreadInfo.forum.forum_name);
            if (this.fGY != null) {
                this.fGY.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.fGY.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.fGZ != null && excellentPbThreadInfo.forum.member_count != null) {
                this.fGZ.setText(ao.L(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                kf(true);
            } else {
                kf(false);
            }
        }
    }

    public void setName(String str) {
        if (this.bKH != null) {
            this.bKH.setText(str);
        }
    }

    private void aE(Context context, String str) {
        if (this.fGX != null) {
            if (StringUtils.isNull(str)) {
                this.fGX.setVisibility(4);
                return;
            }
            this.fGX.setText(context.getString(e.j.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.fGX.setOnClickListener(new a(str));
            this.fGX.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            sf(userInfo.portrait);
            this.fii.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.r(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.bKH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.r(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(long j, String str) {
        if (this.fGW != null) {
            this.fGW.ch(String.valueOf(j), str);
        }
    }

    public void kf(boolean z) {
        if (z) {
            this.fHa.setText(e.j.relate_forum_is_followed);
            al.c(this.fHa, e.d.cp_cont_d, 1);
            this.fHa.setEnabled(false);
            return;
        }
        this.fHa.setText(e.j.attention);
        this.fHa.setEnabled(true);
        al.c(this.fHa, e.d.cp_cont_g, 1);
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
            if (d.this.fGW != null) {
                d.this.fGW.sd(this.forumName);
            }
        }
    }
}
