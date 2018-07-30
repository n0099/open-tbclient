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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes3.dex */
public class d {
    private TextView bwj;
    private HeadImageView eTk;
    private View frQ;
    private b frR;
    private TextView frS;
    private BarImageView frT;
    private TextView frU;
    private TextView frV;
    private LinearLayout frW;
    private TextView title;

    /* loaded from: classes3.dex */
    public interface b {
        void aYZ();

        void bN(String str, String str2);

        void qU(String str);
    }

    public d(Context context) {
        this.frQ = LayoutInflater.from(context).inflate(d.h.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.frQ.findViewById(d.g.chosen_pb_title);
        this.eTk = (HeadImageView) this.frQ.findViewById(d.g.chosen_pb_person_info_head);
        this.bwj = (TextView) this.frQ.findViewById(d.g.chosen_pb_person_info_name);
        this.frS = (TextView) this.frQ.findViewById(d.g.chosen_pb_bar_forum_name);
        this.eTk.setRadius(l.dip2px(context, 2.0f));
        this.frT = (BarImageView) this.frQ.findViewById(d.g.chosen_pb_bar_pic);
        this.frU = (TextView) this.frQ.findViewById(d.g.chosen_pb_bar_attention_number);
        this.frV = (TextView) this.frQ.findViewById(d.g.chosen_pb_bar_attention_button);
        this.frV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.frR != null) {
                    d.this.frR.aYZ();
                }
            }
        });
        this.frW = (LinearLayout) this.frQ.findViewById(d.g.chosen_pb_bar_container);
    }

    public View aZc() {
        return this.frQ;
    }

    public void a(b bVar) {
        this.frR = bVar;
    }

    public void qW(String str) {
        if (!StringUtils.isNull(str) && this.eTk != null) {
            this.eTk.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.frW.setVisibility(8);
                return;
            }
            i.te().cZ(excellentPbThreadInfo.forum.forum_name);
            this.frW.setVisibility(0);
            am(context, excellentPbThreadInfo.forum.forum_name);
            if (this.frT != null) {
                this.frT.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.frT.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.frU != null && excellentPbThreadInfo.forum.member_count != null) {
                this.frU.setText(ap.F(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                jn(true);
            } else {
                jn(false);
            }
        }
    }

    public void setName(String str) {
        if (this.bwj != null) {
            this.bwj.setText(str);
        }
    }

    private void am(Context context, String str) {
        if (this.frS != null) {
            if (StringUtils.isNull(str)) {
                this.frS.setVisibility(4);
                return;
            }
            this.frS.setText(context.getString(d.j.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.frS.setOnClickListener(new a(str));
            this.frS.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            qW(userInfo.portrait);
            this.eTk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.o(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.bwj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.o(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(long j, String str) {
        if (this.frR != null) {
            this.frR.bN(String.valueOf(j), str);
        }
    }

    public void jn(boolean z) {
        if (z) {
            this.frV.setText(d.j.relate_forum_is_followed);
            am.c(this.frV, d.C0140d.cp_cont_d, 1);
            this.frV.setEnabled(false);
            return;
        }
        this.frV.setText(d.j.attention);
        this.frV.setEnabled(true);
        am.c(this.frV, d.C0140d.cp_cont_g, 1);
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
            if (d.this.frR != null) {
                d.this.frR.qU(this.forumName);
            }
        }
    }
}
