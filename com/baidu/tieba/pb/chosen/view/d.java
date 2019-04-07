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
    private TextView dfo;
    private HeadImageView gJW;
    private View hja;
    private b hjb;
    private TextView hjc;
    private BarImageView hjd;
    private TextView hje;
    private TextView hjf;
    private LinearLayout hjg;
    private TextView title;

    /* loaded from: classes5.dex */
    public interface b {
        void aIU();

        void dy(String str, String str2);

        void zB(String str);
    }

    public d(Context context) {
        this.hja = LayoutInflater.from(context).inflate(d.h.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.hja.findViewById(d.g.chosen_pb_title);
        this.gJW = (HeadImageView) this.hja.findViewById(d.g.chosen_pb_person_info_head);
        this.dfo = (TextView) this.hja.findViewById(d.g.chosen_pb_person_info_name);
        this.hjc = (TextView) this.hja.findViewById(d.g.chosen_pb_bar_forum_name);
        this.gJW.setRadius(l.dip2px(context, 2.0f));
        this.hjd = (BarImageView) this.hja.findViewById(d.g.chosen_pb_bar_pic);
        this.hje = (TextView) this.hja.findViewById(d.g.chosen_pb_bar_attention_number);
        this.hjf = (TextView) this.hja.findViewById(d.g.chosen_pb_bar_attention_button);
        this.hjf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.hjb != null) {
                    d.this.hjb.aIU();
                }
            }
        });
        this.hjg = (LinearLayout) this.hja.findViewById(d.g.chosen_pb_bar_container);
    }

    public View bHM() {
        return this.hja;
    }

    public void a(b bVar) {
        this.hjb = bVar;
    }

    public void zD(String str) {
        if (!StringUtils.isNull(str) && this.gJW != null) {
            this.gJW.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.hjg.setVisibility(8);
                return;
            }
            i.Wv().kU(excellentPbThreadInfo.forum.forum_name);
            this.hjg.setVisibility(0);
            aQ(context, excellentPbThreadInfo.forum.forum_name);
            if (this.hjd != null) {
                this.hjd.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.hjd.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.hje != null && excellentPbThreadInfo.forum.member_count != null) {
                this.hje.setText(ap.ax(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                mW(true);
            } else {
                mW(false);
            }
        }
    }

    public void setName(String str) {
        if (this.dfo != null) {
            this.dfo.setText(str);
        }
    }

    private void aQ(Context context, String str) {
        if (this.hjc != null) {
            if (StringUtils.isNull(str)) {
                this.hjc.setVisibility(4);
                return;
            }
            this.hjc.setText(context.getString(d.j.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.hjc.setOnClickListener(new a(str));
            this.hjc.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            zD(userInfo.portrait);
            this.gJW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.r(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.dfo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.r(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(long j, String str) {
        if (this.hjb != null) {
            this.hjb.dy(String.valueOf(j), str);
        }
    }

    public void mW(boolean z) {
        if (z) {
            this.hjf.setText(d.j.relate_forum_is_followed);
            al.d(this.hjf, d.C0277d.cp_cont_d, 1);
            this.hjf.setEnabled(false);
            return;
        }
        this.hjf.setText(d.j.attention);
        this.hjf.setEnabled(true);
        al.d(this.hjf, d.C0277d.cp_cont_g, 1);
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
            if (d.this.hjb != null) {
                d.this.hjb.zB(this.forumName);
            }
        }
    }
}
