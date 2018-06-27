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
    private TextView bvD;
    private HeadImageView ePo;
    private View frE;
    private b frF;
    private TextView frG;
    private BarImageView frH;
    private TextView frI;
    private TextView frJ;
    private LinearLayout frK;
    private TextView title;

    /* loaded from: classes3.dex */
    public interface b {
        void bR(String str, String str2);

        void baH();

        void rb(String str);
    }

    public d(Context context) {
        this.frE = LayoutInflater.from(context).inflate(d.i.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.frE.findViewById(d.g.chosen_pb_title);
        this.ePo = (HeadImageView) this.frE.findViewById(d.g.chosen_pb_person_info_head);
        this.bvD = (TextView) this.frE.findViewById(d.g.chosen_pb_person_info_name);
        this.frG = (TextView) this.frE.findViewById(d.g.chosen_pb_bar_forum_name);
        this.ePo.setRadius(l.dip2px(context, 2.0f));
        this.frH = (BarImageView) this.frE.findViewById(d.g.chosen_pb_bar_pic);
        this.frI = (TextView) this.frE.findViewById(d.g.chosen_pb_bar_attention_number);
        this.frJ = (TextView) this.frE.findViewById(d.g.chosen_pb_bar_attention_button);
        this.frJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.frF != null) {
                    d.this.frF.baH();
                }
            }
        });
        this.frK = (LinearLayout) this.frE.findViewById(d.g.chosen_pb_bar_container);
    }

    public View baK() {
        return this.frE;
    }

    public void a(b bVar) {
        this.frF = bVar;
    }

    public void rd(String str) {
        if (!StringUtils.isNull(str) && this.ePo != null) {
            this.ePo.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.frK.setVisibility(8);
                return;
            }
            i.tt().dc(excellentPbThreadInfo.forum.forum_name);
            this.frK.setVisibility(0);
            ak(context, excellentPbThreadInfo.forum.forum_name);
            if (this.frH != null) {
                this.frH.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.frH.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.frI != null && excellentPbThreadInfo.forum.member_count != null) {
                this.frI.setText(ap.D(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                jB(true);
            } else {
                jB(false);
            }
        }
    }

    public void setName(String str) {
        if (this.bvD != null) {
            this.bvD.setText(str);
        }
    }

    private void ak(Context context, String str) {
        if (this.frG != null) {
            if (StringUtils.isNull(str)) {
                this.frG.setVisibility(4);
                return;
            }
            this.frG.setText(context.getString(d.k.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.frG.setOnClickListener(new a(str));
            this.frG.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            rd(userInfo.portrait);
            this.ePo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.p(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.bvD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.p(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(long j, String str) {
        if (this.frF != null) {
            this.frF.bR(String.valueOf(j), str);
        }
    }

    public void jB(boolean z) {
        if (z) {
            this.frJ.setText(d.k.relate_forum_is_followed);
            am.c(this.frJ, d.C0142d.cp_cont_d, 1);
            this.frJ.setEnabled(false);
            return;
        }
        this.frJ.setText(d.k.attention);
        this.frJ.setEnabled(true);
        am.c(this.frJ, d.C0142d.cp_cont_g, 1);
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
            if (d.this.frF != null) {
                d.this.frF.rb(this.forumName);
            }
        }
    }
}
