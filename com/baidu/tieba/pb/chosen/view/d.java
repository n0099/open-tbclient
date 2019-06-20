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
    private BarImageView hAA;
    private TextView hAB;
    private TextView hAC;
    private LinearLayout hAD;
    private View hAx;
    private b hAy;
    private TextView hAz;
    private HeadImageView hbv;
    private TextView title;

    /* loaded from: classes5.dex */
    public interface b {
        void AT(String str);

        void aPi();

        void dK(String str, String str2);
    }

    public d(Context context) {
        this.hAx = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.hAx.findViewById(R.id.chosen_pb_title);
        this.hbv = (HeadImageView) this.hAx.findViewById(R.id.chosen_pb_person_info_head);
        this.bmf = (TextView) this.hAx.findViewById(R.id.chosen_pb_person_info_name);
        this.hAz = (TextView) this.hAx.findViewById(R.id.chosen_pb_bar_forum_name);
        this.hbv.setRadius(l.dip2px(context, 2.0f));
        this.hAA = (BarImageView) this.hAx.findViewById(R.id.chosen_pb_bar_pic);
        this.hAB = (TextView) this.hAx.findViewById(R.id.chosen_pb_bar_attention_number);
        this.hAC = (TextView) this.hAx.findViewById(R.id.chosen_pb_bar_attention_button);
        this.hAC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.hAy != null) {
                    d.this.hAy.aPi();
                }
            }
        });
        this.hAD = (LinearLayout) this.hAx.findViewById(R.id.chosen_pb_bar_container);
    }

    public View bPC() {
        return this.hAx;
    }

    public void a(b bVar) {
        this.hAy = bVar;
    }

    public void AV(String str) {
        if (!StringUtils.isNull(str) && this.hbv != null) {
            this.hbv.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.hAD.setVisibility(8);
                return;
            }
            i.abb().lY(excellentPbThreadInfo.forum.forum_name);
            this.hAD.setVisibility(0);
            aE(context, excellentPbThreadInfo.forum.forum_name);
            if (this.hAA != null) {
                this.hAA.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.hAA.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.hAB != null && excellentPbThreadInfo.forum.member_count != null) {
                this.hAB.setText(ap.aL(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                nM(true);
            } else {
                nM(false);
            }
        }
    }

    public void setName(String str) {
        if (this.bmf != null) {
            this.bmf.setText(str);
        }
    }

    private void aE(Context context, String str) {
        if (this.hAz != null) {
            if (StringUtils.isNull(str)) {
                this.hAz.setVisibility(4);
                return;
            }
            this.hAz.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.hAz.setOnClickListener(new a(str));
            this.hAz.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            AV(userInfo.portrait);
            this.hbv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
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
        if (this.hAy != null) {
            this.hAy.dK(String.valueOf(j), str);
        }
    }

    public void nM(boolean z) {
        if (z) {
            this.hAC.setText(R.string.relate_forum_is_followed);
            al.f(this.hAC, R.color.cp_cont_d, 1);
            this.hAC.setEnabled(false);
            return;
        }
        this.hAC.setText(R.string.attention);
        this.hAC.setEnabled(true);
        al.f(this.hAC, R.color.cp_cont_g, 1);
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
            if (d.this.hAy != null) {
                d.this.hAy.AT(this.forumName);
            }
        }
    }
}
