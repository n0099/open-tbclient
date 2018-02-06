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
    private TextView bNf;
    private View fGB;
    private b fGC;
    private TextView fGD;
    private BarImageView fGE;
    private TextView fGF;
    private TextView fGG;
    private LinearLayout fGH;
    private HeadImageView fem;
    private TextView title;

    /* loaded from: classes3.dex */
    public interface b {
        void bF(String str, String str2);

        void baf();

        void qf(String str);
    }

    public d(Context context) {
        this.fGB = LayoutInflater.from(context).inflate(d.h.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.fGB.findViewById(d.g.chosen_pb_title);
        this.fem = (HeadImageView) this.fGB.findViewById(d.g.chosen_pb_person_info_head);
        this.bNf = (TextView) this.fGB.findViewById(d.g.chosen_pb_person_info_name);
        this.fGD = (TextView) this.fGB.findViewById(d.g.chosen_pb_bar_forum_name);
        this.fem.setRadius(l.dip2px(context, 2.0f));
        this.fGE = (BarImageView) this.fGB.findViewById(d.g.chosen_pb_bar_pic);
        this.fGF = (TextView) this.fGB.findViewById(d.g.chosen_pb_bar_attention_number);
        this.fGG = (TextView) this.fGB.findViewById(d.g.chosen_pb_bar_attention_button);
        this.fGG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.fGC != null) {
                    d.this.fGC.baf();
                }
            }
        });
        this.fGH = (LinearLayout) this.fGB.findViewById(d.g.chosen_pb_bar_container);
    }

    public View bai() {
        return this.fGB;
    }

    public void a(b bVar) {
        this.fGC = bVar;
    }

    public void qh(String str) {
        if (!StringUtils.isNull(str) && this.fem != null) {
            this.fem.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.fGH.setVisibility(8);
                return;
            }
            i.xo().cK(excellentPbThreadInfo.forum.forum_name);
            this.fGH.setVisibility(0);
            an(context, excellentPbThreadInfo.forum.forum_name);
            if (this.fGE != null) {
                this.fGE.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.fGE.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.fGF != null && excellentPbThreadInfo.forum.member_count != null) {
                this.fGF.setText(am.H(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                jK(true);
            } else {
                jK(false);
            }
        }
    }

    public void setName(String str) {
        if (this.bNf != null) {
            this.bNf.setText(str);
        }
    }

    private void an(Context context, String str) {
        if (this.fGD != null) {
            if (StringUtils.isNull(str)) {
                this.fGD.setVisibility(4);
                return;
            }
            this.fGD.setText(context.getString(d.j.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.fGD.setOnClickListener(new a(str));
            this.fGD.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            qh(userInfo.portrait);
            this.fem.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.a.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.o(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.bNf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.a.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.o(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(long j, String str) {
        if (this.fGC != null) {
            this.fGC.bF(String.valueOf(j), str);
        }
    }

    public void jK(boolean z) {
        if (z) {
            this.fGG.setText(d.j.relate_forum_is_followed);
            aj.e(this.fGG, d.C0140d.cp_cont_d, 1);
            this.fGG.setEnabled(false);
            return;
        }
        this.fGG.setText(d.j.attention);
        this.fGG.setEnabled(true);
        aj.e(this.fGG, d.C0140d.cp_cont_g, 1);
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
            if (d.this.fGC != null) {
                d.this.fGC.qf(this.forumName);
            }
        }
    }
}
