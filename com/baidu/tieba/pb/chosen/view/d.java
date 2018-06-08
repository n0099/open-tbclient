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
import com.baidu.tieba.d;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes3.dex */
public class d {
    private TextView bui;
    private HeadImageView eLy;
    private View fnK;
    private b fnL;
    private TextView fnM;
    private BarImageView fnN;
    private TextView fnO;
    private TextView fnP;
    private LinearLayout fnQ;
    private TextView title;

    /* loaded from: classes3.dex */
    public interface b {
        void bN(String str, String str2);

        void baa();

        void rc(String str);
    }

    public d(Context context) {
        this.fnK = LayoutInflater.from(context).inflate(d.i.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.fnK.findViewById(d.g.chosen_pb_title);
        this.eLy = (HeadImageView) this.fnK.findViewById(d.g.chosen_pb_person_info_head);
        this.bui = (TextView) this.fnK.findViewById(d.g.chosen_pb_person_info_name);
        this.fnM = (TextView) this.fnK.findViewById(d.g.chosen_pb_bar_forum_name);
        this.eLy.setRadius(l.dip2px(context, 2.0f));
        this.fnN = (BarImageView) this.fnK.findViewById(d.g.chosen_pb_bar_pic);
        this.fnO = (TextView) this.fnK.findViewById(d.g.chosen_pb_bar_attention_number);
        this.fnP = (TextView) this.fnK.findViewById(d.g.chosen_pb_bar_attention_button);
        this.fnP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.fnL != null) {
                    d.this.fnL.baa();
                }
            }
        });
        this.fnQ = (LinearLayout) this.fnK.findViewById(d.g.chosen_pb_bar_container);
    }

    public View bad() {
        return this.fnK;
    }

    public void a(b bVar) {
        this.fnL = bVar;
    }

    public void re(String str) {
        if (!StringUtils.isNull(str) && this.eLy != null) {
            this.eLy.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.fnQ.setVisibility(8);
                return;
            }
            i.tt().da(excellentPbThreadInfo.forum.forum_name);
            this.fnQ.setVisibility(0);
            ak(context, excellentPbThreadInfo.forum.forum_name);
            if (this.fnN != null) {
                this.fnN.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.fnN.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.fnO != null && excellentPbThreadInfo.forum.member_count != null) {
                this.fnO.setText(ao.C(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                js(true);
            } else {
                js(false);
            }
        }
    }

    public void setName(String str) {
        if (this.bui != null) {
            this.bui.setText(str);
        }
    }

    private void ak(Context context, String str) {
        if (this.fnM != null) {
            if (StringUtils.isNull(str)) {
                this.fnM.setVisibility(4);
                return;
            }
            this.fnM.setText(context.getString(d.k.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.fnM.setOnClickListener(new a(str));
            this.fnM.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            re(userInfo.portrait);
            this.eLy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.p(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.bui.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.p(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(long j, String str) {
        if (this.fnL != null) {
            this.fnL.bN(String.valueOf(j), str);
        }
    }

    public void js(boolean z) {
        if (z) {
            this.fnP.setText(d.k.relate_forum_is_followed);
            al.c(this.fnP, d.C0141d.cp_cont_d, 1);
            this.fnP.setEnabled(false);
            return;
        }
        this.fnP.setText(d.k.attention);
        this.fnP.setEnabled(true);
        al.c(this.fnP, d.C0141d.cp_cont_g, 1);
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
            if (d.this.fnL != null) {
                d.this.fnL.rc(this.forumName);
            }
        }
    }
}
