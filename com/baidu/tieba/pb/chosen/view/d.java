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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes5.dex */
public class d {
    private TextView dfp;
    private HeadImageView gJX;
    private View hjb;
    private b hjc;
    private TextView hjd;
    private BarImageView hje;
    private TextView hjf;
    private TextView hjg;
    private LinearLayout hjh;
    private TextView title;

    /* loaded from: classes5.dex */
    public interface b {
        void aIU();

        void dy(String str, String str2);

        void zB(String str);
    }

    public d(Context context) {
        this.hjb = LayoutInflater.from(context).inflate(d.h.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.hjb.findViewById(d.g.chosen_pb_title);
        this.gJX = (HeadImageView) this.hjb.findViewById(d.g.chosen_pb_person_info_head);
        this.dfp = (TextView) this.hjb.findViewById(d.g.chosen_pb_person_info_name);
        this.hjd = (TextView) this.hjb.findViewById(d.g.chosen_pb_bar_forum_name);
        this.gJX.setRadius(l.dip2px(context, 2.0f));
        this.hje = (BarImageView) this.hjb.findViewById(d.g.chosen_pb_bar_pic);
        this.hjf = (TextView) this.hjb.findViewById(d.g.chosen_pb_bar_attention_number);
        this.hjg = (TextView) this.hjb.findViewById(d.g.chosen_pb_bar_attention_button);
        this.hjg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.hjc != null) {
                    d.this.hjc.aIU();
                }
            }
        });
        this.hjh = (LinearLayout) this.hjb.findViewById(d.g.chosen_pb_bar_container);
    }

    public View bHM() {
        return this.hjb;
    }

    public void a(b bVar) {
        this.hjc = bVar;
    }

    public void zD(String str) {
        if (!StringUtils.isNull(str) && this.gJX != null) {
            this.gJX.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.hjh.setVisibility(8);
                return;
            }
            i.Wv().kU(excellentPbThreadInfo.forum.forum_name);
            this.hjh.setVisibility(0);
            aQ(context, excellentPbThreadInfo.forum.forum_name);
            if (this.hje != null) {
                this.hje.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.hje.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.hjf != null && excellentPbThreadInfo.forum.member_count != null) {
                this.hjf.setText(ap.ax(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                mW(true);
            } else {
                mW(false);
            }
        }
    }

    public void setName(String str) {
        if (this.dfp != null) {
            this.dfp.setText(str);
        }
    }

    private void aQ(Context context, String str) {
        if (this.hjd != null) {
            if (StringUtils.isNull(str)) {
                this.hjd.setVisibility(4);
                return;
            }
            this.hjd.setText(context.getString(d.j.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.hjd.setOnClickListener(new a(str));
            this.hjd.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            zD(userInfo.portrait);
            this.gJX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.r(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.dfp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.r(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(long j, String str) {
        if (this.hjc != null) {
            this.hjc.dy(String.valueOf(j), str);
        }
    }

    public void mW(boolean z) {
        if (z) {
            this.hjg.setText(d.j.relate_forum_is_followed);
            al.d(this.hjg, d.C0277d.cp_cont_d, 1);
            this.hjg.setEnabled(false);
            return;
        }
        this.hjg.setText(d.j.attention);
        this.hjg.setEnabled(true);
        al.d(this.hjg, d.C0277d.cp_cont_g, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        private String forumName;

        public a(String str) {
            this.forumName = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.hjc != null) {
                d.this.hjc.zB(this.forumName);
            }
        }
    }
}
