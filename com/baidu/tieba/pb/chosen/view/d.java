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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes10.dex */
public class d {
    private TextView cug;
    private View iAQ;
    private b iAR;
    private TextView iAS;
    private BarImageView iAT;
    private TextView iAU;
    private TextView iAV;
    private LinearLayout iAW;
    private HeadImageView ibl;
    private TextView title;

    /* loaded from: classes10.dex */
    public interface b {
        void FE(String str);

        void ckh();

        void ed(String str, String str2);
    }

    public d(Context context) {
        this.iAQ = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.iAQ.findViewById(R.id.chosen_pb_title);
        this.ibl = (HeadImageView) this.iAQ.findViewById(R.id.chosen_pb_person_info_head);
        this.cug = (TextView) this.iAQ.findViewById(R.id.chosen_pb_person_info_name);
        this.iAS = (TextView) this.iAQ.findViewById(R.id.chosen_pb_bar_forum_name);
        this.ibl.setRadius(l.dip2px(context, 2.0f));
        this.iAT = (BarImageView) this.iAQ.findViewById(R.id.chosen_pb_bar_pic);
        this.iAU = (TextView) this.iAQ.findViewById(R.id.chosen_pb_bar_attention_number);
        this.iAV = (TextView) this.iAQ.findViewById(R.id.chosen_pb_bar_attention_button);
        this.iAV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.iAR != null) {
                    d.this.iAR.ckh();
                }
            }
        });
        this.iAW = (LinearLayout) this.iAQ.findViewById(R.id.chosen_pb_bar_container);
    }

    public View ckk() {
        return this.iAQ;
    }

    public void a(b bVar) {
        this.iAR = bVar;
    }

    public void FG(String str) {
        if (!StringUtils.isNull(str) && this.ibl != null) {
            this.ibl.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.iAW.setVisibility(8);
                return;
            }
            i.azM().setForumNameForWaterImage(excellentPbThreadInfo.forum.forum_name);
            this.iAW.setVisibility(0);
            bb(context, excellentPbThreadInfo.forum.forum_name);
            if (this.iAT != null) {
                this.iAT.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.iAT.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.iAU != null && excellentPbThreadInfo.forum.member_count != null) {
                this.iAU.setText(aq.numFormatOver10000(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                pr(true);
            } else {
                pr(false);
            }
        }
    }

    public void setName(String str) {
        if (this.cug != null) {
            this.cug.setText(str);
        }
    }

    private void bb(Context context, String str) {
        if (this.iAS != null) {
            if (StringUtils.isNull(str)) {
                this.iAS.setVisibility(4);
                return;
            }
            this.iAS.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.iAS.setOnClickListener(new a(str));
            this.iAS.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            FG(userInfo.portrait);
            this.ibl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.s(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.cug.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.s(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(long j, String str) {
        if (this.iAR != null) {
            this.iAR.ed(String.valueOf(j), str);
        }
    }

    public void pr(boolean z) {
        if (z) {
            this.iAV.setText(R.string.relate_forum_is_followed);
            am.setViewTextColor(this.iAV, R.color.cp_cont_d, 1);
            this.iAV.setEnabled(false);
            return;
        }
        this.iAV.setText(R.string.attention);
        this.iAV.setEnabled(true);
        am.setViewTextColor(this.iAV, R.color.cp_cont_g, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        private String forumName;

        public a(String str) {
            this.forumName = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.iAR != null) {
                d.this.iAR.FE(this.forumName);
            }
        }
    }
}
