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
    private TextView bPh;
    private View fPk;
    private b fPl;
    private TextView fPm;
    private BarImageView fPn;
    private TextView fPo;
    private TextView fPp;
    private LinearLayout fPq;
    private HeadImageView fqu;
    private TextView title;

    /* loaded from: classes3.dex */
    public interface b {
        void ahD();

        void cm(String str, String str2);

        void sH(String str);
    }

    public d(Context context) {
        this.fPk = LayoutInflater.from(context).inflate(e.h.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.fPk.findViewById(e.g.chosen_pb_title);
        this.fqu = (HeadImageView) this.fPk.findViewById(e.g.chosen_pb_person_info_head);
        this.bPh = (TextView) this.fPk.findViewById(e.g.chosen_pb_person_info_name);
        this.fPm = (TextView) this.fPk.findViewById(e.g.chosen_pb_bar_forum_name);
        this.fqu.setRadius(l.dip2px(context, 2.0f));
        this.fPn = (BarImageView) this.fPk.findViewById(e.g.chosen_pb_bar_pic);
        this.fPo = (TextView) this.fPk.findViewById(e.g.chosen_pb_bar_attention_number);
        this.fPp = (TextView) this.fPk.findViewById(e.g.chosen_pb_bar_attention_button);
        this.fPp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.fPl != null) {
                    d.this.fPl.ahD();
                }
            }
        });
        this.fPq = (LinearLayout) this.fPk.findViewById(e.g.chosen_pb_bar_container);
    }

    public View bfY() {
        return this.fPk;
    }

    public void a(b bVar) {
        this.fPl = bVar;
    }

    public void sJ(String str) {
        if (!StringUtils.isNull(str) && this.fqu != null) {
            this.fqu.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.fPq.setVisibility(8);
                return;
            }
            i.xE().ea(excellentPbThreadInfo.forum.forum_name);
            this.fPq.setVisibility(0);
            aF(context, excellentPbThreadInfo.forum.forum_name);
            if (this.fPn != null) {
                this.fPn.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.fPn.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.fPo != null && excellentPbThreadInfo.forum.member_count != null) {
                this.fPo.setText(ao.U(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                ks(true);
            } else {
                ks(false);
            }
        }
    }

    public void setName(String str) {
        if (this.bPh != null) {
            this.bPh.setText(str);
        }
    }

    private void aF(Context context, String str) {
        if (this.fPm != null) {
            if (StringUtils.isNull(str)) {
                this.fPm.setVisibility(4);
                return;
            }
            this.fPm.setText(context.getString(e.j.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.fPm.setOnClickListener(new a(str));
            this.fPm.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            sJ(userInfo.portrait);
            this.fqu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.r(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.bPh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.r(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(long j, String str) {
        if (this.fPl != null) {
            this.fPl.cm(String.valueOf(j), str);
        }
    }

    public void ks(boolean z) {
        if (z) {
            this.fPp.setText(e.j.relate_forum_is_followed);
            al.c(this.fPp, e.d.cp_cont_d, 1);
            this.fPp.setEnabled(false);
            return;
        }
        this.fPp.setText(e.j.attention);
        this.fPp.setEnabled(true);
        al.c(this.fPp, e.d.cp_cont_g, 1);
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
            if (d.this.fPl != null) {
                d.this.fPl.sH(this.forumName);
            }
        }
    }
}
