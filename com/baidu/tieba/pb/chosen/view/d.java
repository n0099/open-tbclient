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
import com.baidu.tieba.R;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes5.dex */
public class d {
    private TextView bmf;
    private TextView hAA;
    private TextView hAB;
    private LinearLayout hAC;
    private View hAw;
    private b hAx;
    private TextView hAy;
    private BarImageView hAz;
    private HeadImageView hbu;
    private TextView title;

    /* loaded from: classes5.dex */
    public interface b {
        void AR(String str);

        void aPi();

        void dK(String str, String str2);
    }

    public d(Context context) {
        this.hAw = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.hAw.findViewById(R.id.chosen_pb_title);
        this.hbu = (HeadImageView) this.hAw.findViewById(R.id.chosen_pb_person_info_head);
        this.bmf = (TextView) this.hAw.findViewById(R.id.chosen_pb_person_info_name);
        this.hAy = (TextView) this.hAw.findViewById(R.id.chosen_pb_bar_forum_name);
        this.hbu.setRadius(l.dip2px(context, 2.0f));
        this.hAz = (BarImageView) this.hAw.findViewById(R.id.chosen_pb_bar_pic);
        this.hAA = (TextView) this.hAw.findViewById(R.id.chosen_pb_bar_attention_number);
        this.hAB = (TextView) this.hAw.findViewById(R.id.chosen_pb_bar_attention_button);
        this.hAB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.hAx != null) {
                    d.this.hAx.aPi();
                }
            }
        });
        this.hAC = (LinearLayout) this.hAw.findViewById(R.id.chosen_pb_bar_container);
    }

    public View bPB() {
        return this.hAw;
    }

    public void a(b bVar) {
        this.hAx = bVar;
    }

    public void AT(String str) {
        if (!StringUtils.isNull(str) && this.hbu != null) {
            this.hbu.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.hAC.setVisibility(8);
                return;
            }
            i.abb().lZ(excellentPbThreadInfo.forum.forum_name);
            this.hAC.setVisibility(0);
            aE(context, excellentPbThreadInfo.forum.forum_name);
            if (this.hAz != null) {
                this.hAz.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.hAz.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.hAA != null && excellentPbThreadInfo.forum.member_count != null) {
                this.hAA.setText(ap.aL(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                nL(true);
            } else {
                nL(false);
            }
        }
    }

    public void setName(String str) {
        if (this.bmf != null) {
            this.bmf.setText(str);
        }
    }

    private void aE(Context context, String str) {
        if (this.hAy != null) {
            if (StringUtils.isNull(str)) {
                this.hAy.setVisibility(4);
                return;
            }
            this.hAy.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.hAy.setOnClickListener(new a(str));
            this.hAy.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            AT(userInfo.portrait);
            this.hbu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.p(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.bmf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.p(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(long j, String str) {
        if (this.hAx != null) {
            this.hAx.dK(String.valueOf(j), str);
        }
    }

    public void nL(boolean z) {
        if (z) {
            this.hAB.setText(R.string.relate_forum_is_followed);
            al.f(this.hAB, R.color.cp_cont_d, 1);
            this.hAB.setEnabled(false);
            return;
        }
        this.hAB.setText(R.string.attention);
        this.hAB.setEnabled(true);
        al.f(this.hAB, R.color.cp_cont_g, 1);
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
            if (d.this.hAx != null) {
                d.this.hAx.AR(this.forumName);
            }
        }
    }
}
