package com.baidu.tieba.pb.chosen.a;

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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes3.dex */
public class d {
    private TextView bMS;
    private View fGq;
    private b fGr;
    private TextView fGs;
    private BarImageView fGt;
    private TextView fGu;
    private TextView fGv;
    private LinearLayout fGw;
    private HeadImageView fea;
    private TextView title;

    /* loaded from: classes3.dex */
    public interface b {
        void bF(String str, String str2);

        void bae();

        void qf(String str);
    }

    public d(Context context) {
        this.fGq = LayoutInflater.from(context).inflate(d.h.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.fGq.findViewById(d.g.chosen_pb_title);
        this.fea = (HeadImageView) this.fGq.findViewById(d.g.chosen_pb_person_info_head);
        this.bMS = (TextView) this.fGq.findViewById(d.g.chosen_pb_person_info_name);
        this.fGs = (TextView) this.fGq.findViewById(d.g.chosen_pb_bar_forum_name);
        this.fea.setRadius(l.dip2px(context, 2.0f));
        this.fGt = (BarImageView) this.fGq.findViewById(d.g.chosen_pb_bar_pic);
        this.fGu = (TextView) this.fGq.findViewById(d.g.chosen_pb_bar_attention_number);
        this.fGv = (TextView) this.fGq.findViewById(d.g.chosen_pb_bar_attention_button);
        this.fGv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.fGr != null) {
                    d.this.fGr.bae();
                }
            }
        });
        this.fGw = (LinearLayout) this.fGq.findViewById(d.g.chosen_pb_bar_container);
    }

    public View bah() {
        return this.fGq;
    }

    public void a(b bVar) {
        this.fGr = bVar;
    }

    public void qh(String str) {
        if (!StringUtils.isNull(str) && this.fea != null) {
            this.fea.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.fGw.setVisibility(8);
                return;
            }
            i.xo().cK(excellentPbThreadInfo.forum.forum_name);
            this.fGw.setVisibility(0);
            an(context, excellentPbThreadInfo.forum.forum_name);
            if (this.fGt != null) {
                this.fGt.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.fGt.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.fGu != null && excellentPbThreadInfo.forum.member_count != null) {
                this.fGu.setText(am.H(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                jK(true);
            } else {
                jK(false);
            }
        }
    }

    public void setName(String str) {
        if (this.bMS != null) {
            this.bMS.setText(str);
        }
    }

    private void an(Context context, String str) {
        if (this.fGs != null) {
            if (StringUtils.isNull(str)) {
                this.fGs.setVisibility(4);
                return;
            }
            this.fGs.setText(context.getString(d.j.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.fGs.setOnClickListener(new a(str));
            this.fGs.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            qh(userInfo.portrait);
            this.fea.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.a.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.o(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.bMS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.a.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.o(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(long j, String str) {
        if (this.fGr != null) {
            this.fGr.bF(String.valueOf(j), str);
        }
    }

    public void jK(boolean z) {
        if (z) {
            this.fGv.setText(d.j.relate_forum_is_followed);
            aj.e(this.fGv, d.C0141d.cp_cont_d, 1);
            this.fGv.setEnabled(false);
            return;
        }
        this.fGv.setText(d.j.attention);
        this.fGv.setEnabled(true);
        aj.e(this.fGv, d.C0141d.cp_cont_g, 1);
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
            if (d.this.fGr != null) {
                d.this.fGr.qf(this.forumName);
            }
        }
    }
}
