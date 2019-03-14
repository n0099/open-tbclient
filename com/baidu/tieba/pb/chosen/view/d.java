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
    private TextView dfk;
    private HeadImageView gKj;
    private View hjn;
    private b hjo;
    private TextView hjp;
    private BarImageView hjq;
    private TextView hjr;
    private TextView hjs;
    private LinearLayout hjt;
    private TextView title;

    /* loaded from: classes5.dex */
    public interface b {
        void aJf();

        void dx(String str, String str2);

        void zC(String str);
    }

    public d(Context context) {
        this.hjn = LayoutInflater.from(context).inflate(d.h.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.hjn.findViewById(d.g.chosen_pb_title);
        this.gKj = (HeadImageView) this.hjn.findViewById(d.g.chosen_pb_person_info_head);
        this.dfk = (TextView) this.hjn.findViewById(d.g.chosen_pb_person_info_name);
        this.hjp = (TextView) this.hjn.findViewById(d.g.chosen_pb_bar_forum_name);
        this.gKj.setRadius(l.dip2px(context, 2.0f));
        this.hjq = (BarImageView) this.hjn.findViewById(d.g.chosen_pb_bar_pic);
        this.hjr = (TextView) this.hjn.findViewById(d.g.chosen_pb_bar_attention_number);
        this.hjs = (TextView) this.hjn.findViewById(d.g.chosen_pb_bar_attention_button);
        this.hjs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.hjo != null) {
                    d.this.hjo.aJf();
                }
            }
        });
        this.hjt = (LinearLayout) this.hjn.findViewById(d.g.chosen_pb_bar_container);
    }

    public View bHP() {
        return this.hjn;
    }

    public void a(b bVar) {
        this.hjo = bVar;
    }

    public void zE(String str) {
        if (!StringUtils.isNull(str) && this.gKj != null) {
            this.gKj.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.hjt.setVisibility(8);
                return;
            }
            i.Wy().kT(excellentPbThreadInfo.forum.forum_name);
            this.hjt.setVisibility(0);
            aQ(context, excellentPbThreadInfo.forum.forum_name);
            if (this.hjq != null) {
                this.hjq.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.hjq.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.hjr != null && excellentPbThreadInfo.forum.member_count != null) {
                this.hjr.setText(ap.ax(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                mW(true);
            } else {
                mW(false);
            }
        }
    }

    public void setName(String str) {
        if (this.dfk != null) {
            this.dfk.setText(str);
        }
    }

    private void aQ(Context context, String str) {
        if (this.hjp != null) {
            if (StringUtils.isNull(str)) {
                this.hjp.setVisibility(4);
                return;
            }
            this.hjp.setText(context.getString(d.j.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.hjp.setOnClickListener(new a(str));
            this.hjp.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            zE(userInfo.portrait);
            this.gKj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.r(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.dfk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.r(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(long j, String str) {
        if (this.hjo != null) {
            this.hjo.dx(String.valueOf(j), str);
        }
    }

    public void mW(boolean z) {
        if (z) {
            this.hjs.setText(d.j.relate_forum_is_followed);
            al.d(this.hjs, d.C0277d.cp_cont_d, 1);
            this.hjs.setEnabled(false);
            return;
        }
        this.hjs.setText(d.j.attention);
        this.hjs.setEnabled(true);
        al.d(this.hjs, d.C0277d.cp_cont_g, 1);
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
            if (d.this.hjo != null) {
                d.this.hjo.zC(this.forumName);
            }
        }
    }
}
