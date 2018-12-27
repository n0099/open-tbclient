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
    private TextView bPk;
    private View fSc;
    private b fSd;
    private TextView fSe;
    private BarImageView fSf;
    private TextView fSg;
    private TextView fSh;
    private LinearLayout fSi;
    private HeadImageView ftn;
    private TextView title;

    /* loaded from: classes3.dex */
    public interface b {
        void ahN();

        void cm(String str, String str2);

        void sK(String str);
    }

    public d(Context context) {
        this.fSc = LayoutInflater.from(context).inflate(e.h.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.fSc.findViewById(e.g.chosen_pb_title);
        this.ftn = (HeadImageView) this.fSc.findViewById(e.g.chosen_pb_person_info_head);
        this.bPk = (TextView) this.fSc.findViewById(e.g.chosen_pb_person_info_name);
        this.fSe = (TextView) this.fSc.findViewById(e.g.chosen_pb_bar_forum_name);
        this.ftn.setRadius(l.dip2px(context, 2.0f));
        this.fSf = (BarImageView) this.fSc.findViewById(e.g.chosen_pb_bar_pic);
        this.fSg = (TextView) this.fSc.findViewById(e.g.chosen_pb_bar_attention_number);
        this.fSh = (TextView) this.fSc.findViewById(e.g.chosen_pb_bar_attention_button);
        this.fSh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.fSd != null) {
                    d.this.fSd.ahN();
                }
            }
        });
        this.fSi = (LinearLayout) this.fSc.findViewById(e.g.chosen_pb_bar_container);
    }

    public View bgK() {
        return this.fSc;
    }

    public void a(b bVar) {
        this.fSd = bVar;
    }

    public void sM(String str) {
        if (!StringUtils.isNull(str) && this.ftn != null) {
            this.ftn.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.fSi.setVisibility(8);
                return;
            }
            i.xE().ea(excellentPbThreadInfo.forum.forum_name);
            this.fSi.setVisibility(0);
            aF(context, excellentPbThreadInfo.forum.forum_name);
            if (this.fSf != null) {
                this.fSf.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.fSf.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.fSg != null && excellentPbThreadInfo.forum.member_count != null) {
                this.fSg.setText(ao.V(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                kv(true);
            } else {
                kv(false);
            }
        }
    }

    public void setName(String str) {
        if (this.bPk != null) {
            this.bPk.setText(str);
        }
    }

    private void aF(Context context, String str) {
        if (this.fSe != null) {
            if (StringUtils.isNull(str)) {
                this.fSe.setVisibility(4);
                return;
            }
            this.fSe.setText(context.getString(e.j.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.fSe.setOnClickListener(new a(str));
            this.fSe.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            sM(userInfo.portrait);
            this.ftn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.r(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.bPk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.r(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(long j, String str) {
        if (this.fSd != null) {
            this.fSd.cm(String.valueOf(j), str);
        }
    }

    public void kv(boolean z) {
        if (z) {
            this.fSh.setText(e.j.relate_forum_is_followed);
            al.c(this.fSh, e.d.cp_cont_d, 1);
            this.fSh.setEnabled(false);
            return;
        }
        this.fSh.setText(e.j.attention);
        this.fSh.setEnabled(true);
        al.c(this.fSh, e.d.cp_cont_g, 1);
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
            if (d.this.fSd != null) {
                d.this.fSd.sK(this.forumName);
            }
        }
    }
}
