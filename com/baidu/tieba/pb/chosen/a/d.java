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
    private TextView bMV;
    private View fGG;
    private b fGH;
    private TextView fGI;
    private BarImageView fGJ;
    private TextView fGK;
    private TextView fGL;
    private LinearLayout fGM;
    private HeadImageView feo;
    private TextView title;

    /* loaded from: classes3.dex */
    public interface b {
        void bF(String str, String str2);

        void baf();

        void qf(String str);
    }

    public d(Context context) {
        this.fGG = LayoutInflater.from(context).inflate(d.h.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.fGG.findViewById(d.g.chosen_pb_title);
        this.feo = (HeadImageView) this.fGG.findViewById(d.g.chosen_pb_person_info_head);
        this.bMV = (TextView) this.fGG.findViewById(d.g.chosen_pb_person_info_name);
        this.fGI = (TextView) this.fGG.findViewById(d.g.chosen_pb_bar_forum_name);
        this.feo.setRadius(l.dip2px(context, 2.0f));
        this.fGJ = (BarImageView) this.fGG.findViewById(d.g.chosen_pb_bar_pic);
        this.fGK = (TextView) this.fGG.findViewById(d.g.chosen_pb_bar_attention_number);
        this.fGL = (TextView) this.fGG.findViewById(d.g.chosen_pb_bar_attention_button);
        this.fGL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.fGH != null) {
                    d.this.fGH.baf();
                }
            }
        });
        this.fGM = (LinearLayout) this.fGG.findViewById(d.g.chosen_pb_bar_container);
    }

    public View bai() {
        return this.fGG;
    }

    public void a(b bVar) {
        this.fGH = bVar;
    }

    public void qh(String str) {
        if (!StringUtils.isNull(str) && this.feo != null) {
            this.feo.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.fGM.setVisibility(8);
                return;
            }
            i.xo().cK(excellentPbThreadInfo.forum.forum_name);
            this.fGM.setVisibility(0);
            an(context, excellentPbThreadInfo.forum.forum_name);
            if (this.fGJ != null) {
                this.fGJ.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.fGJ.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.fGK != null && excellentPbThreadInfo.forum.member_count != null) {
                this.fGK.setText(am.H(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                jP(true);
            } else {
                jP(false);
            }
        }
    }

    public void setName(String str) {
        if (this.bMV != null) {
            this.bMV.setText(str);
        }
    }

    private void an(Context context, String str) {
        if (this.fGI != null) {
            if (StringUtils.isNull(str)) {
                this.fGI.setVisibility(4);
                return;
            }
            this.fGI.setText(context.getString(d.j.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.fGI.setOnClickListener(new a(str));
            this.fGI.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            qh(userInfo.portrait);
            this.feo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.a.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.o(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.bMV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.a.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.o(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(long j, String str) {
        if (this.fGH != null) {
            this.fGH.bF(String.valueOf(j), str);
        }
    }

    public void jP(boolean z) {
        if (z) {
            this.fGL.setText(d.j.relate_forum_is_followed);
            aj.e(this.fGL, d.C0141d.cp_cont_d, 1);
            this.fGL.setEnabled(false);
            return;
        }
        this.fGL.setText(d.j.attention);
        this.fGL.setEnabled(true);
        aj.e(this.fGL, d.C0141d.cp_cont_g, 1);
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
            if (d.this.fGH != null) {
                d.this.fGH.qf(this.forumName);
            }
        }
    }
}
