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
import com.baidu.tieba.f;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes3.dex */
public class d {
    private TextView bwl;
    private HeadImageView eTf;
    private View frJ;
    private b frK;
    private TextView frL;
    private BarImageView frM;
    private TextView frN;
    private TextView frO;
    private LinearLayout frP;
    private TextView title;

    /* loaded from: classes3.dex */
    public interface b {
        void aYU();

        void bN(String str, String str2);

        void qX(String str);
    }

    public d(Context context) {
        this.frJ = LayoutInflater.from(context).inflate(f.h.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.frJ.findViewById(f.g.chosen_pb_title);
        this.eTf = (HeadImageView) this.frJ.findViewById(f.g.chosen_pb_person_info_head);
        this.bwl = (TextView) this.frJ.findViewById(f.g.chosen_pb_person_info_name);
        this.frL = (TextView) this.frJ.findViewById(f.g.chosen_pb_bar_forum_name);
        this.eTf.setRadius(l.dip2px(context, 2.0f));
        this.frM = (BarImageView) this.frJ.findViewById(f.g.chosen_pb_bar_pic);
        this.frN = (TextView) this.frJ.findViewById(f.g.chosen_pb_bar_attention_number);
        this.frO = (TextView) this.frJ.findViewById(f.g.chosen_pb_bar_attention_button);
        this.frO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.frK != null) {
                    d.this.frK.aYU();
                }
            }
        });
        this.frP = (LinearLayout) this.frJ.findViewById(f.g.chosen_pb_bar_container);
    }

    public View aYX() {
        return this.frJ;
    }

    public void a(b bVar) {
        this.frK = bVar;
    }

    public void qZ(String str) {
        if (!StringUtils.isNull(str) && this.eTf != null) {
            this.eTf.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.frP.setVisibility(8);
                return;
            }
            i.td().da(excellentPbThreadInfo.forum.forum_name);
            this.frP.setVisibility(0);
            am(context, excellentPbThreadInfo.forum.forum_name);
            if (this.frM != null) {
                this.frM.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.frM.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.frN != null && excellentPbThreadInfo.forum.member_count != null) {
                this.frN.setText(ap.F(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                jn(true);
            } else {
                jn(false);
            }
        }
    }

    public void setName(String str) {
        if (this.bwl != null) {
            this.bwl.setText(str);
        }
    }

    private void am(Context context, String str) {
        if (this.frL != null) {
            if (StringUtils.isNull(str)) {
                this.frL.setVisibility(4);
                return;
            }
            this.frL.setText(context.getString(f.j.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.frL.setOnClickListener(new a(str));
            this.frL.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            qZ(userInfo.portrait);
            this.eTf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.o(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.bwl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.o(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(long j, String str) {
        if (this.frK != null) {
            this.frK.bN(String.valueOf(j), str);
        }
    }

    public void jn(boolean z) {
        if (z) {
            this.frO.setText(f.j.relate_forum_is_followed);
            am.c(this.frO, f.d.cp_cont_d, 1);
            this.frO.setEnabled(false);
            return;
        }
        this.frO.setText(f.j.attention);
        this.frO.setEnabled(true);
        am.c(this.frO, f.d.cp_cont_g, 1);
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
            if (d.this.frK != null) {
                d.this.frK.qX(this.forumName);
            }
        }
    }
}
