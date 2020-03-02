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
    private TextView cuh;
    private View iAS;
    private b iAT;
    private TextView iAU;
    private BarImageView iAV;
    private TextView iAW;
    private TextView iAX;
    private LinearLayout iAY;
    private HeadImageView ibn;
    private TextView title;

    /* loaded from: classes10.dex */
    public interface b {
        void FE(String str);

        void ckj();

        void ed(String str, String str2);
    }

    public d(Context context) {
        this.iAS = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.iAS.findViewById(R.id.chosen_pb_title);
        this.ibn = (HeadImageView) this.iAS.findViewById(R.id.chosen_pb_person_info_head);
        this.cuh = (TextView) this.iAS.findViewById(R.id.chosen_pb_person_info_name);
        this.iAU = (TextView) this.iAS.findViewById(R.id.chosen_pb_bar_forum_name);
        this.ibn.setRadius(l.dip2px(context, 2.0f));
        this.iAV = (BarImageView) this.iAS.findViewById(R.id.chosen_pb_bar_pic);
        this.iAW = (TextView) this.iAS.findViewById(R.id.chosen_pb_bar_attention_number);
        this.iAX = (TextView) this.iAS.findViewById(R.id.chosen_pb_bar_attention_button);
        this.iAX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.iAT != null) {
                    d.this.iAT.ckj();
                }
            }
        });
        this.iAY = (LinearLayout) this.iAS.findViewById(R.id.chosen_pb_bar_container);
    }

    public View ckm() {
        return this.iAS;
    }

    public void a(b bVar) {
        this.iAT = bVar;
    }

    public void FG(String str) {
        if (!StringUtils.isNull(str) && this.ibn != null) {
            this.ibn.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.iAY.setVisibility(8);
                return;
            }
            i.azO().setForumNameForWaterImage(excellentPbThreadInfo.forum.forum_name);
            this.iAY.setVisibility(0);
            bb(context, excellentPbThreadInfo.forum.forum_name);
            if (this.iAV != null) {
                this.iAV.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.iAV.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.iAW != null && excellentPbThreadInfo.forum.member_count != null) {
                this.iAW.setText(aq.numFormatOver10000(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                pr(true);
            } else {
                pr(false);
            }
        }
    }

    public void setName(String str) {
        if (this.cuh != null) {
            this.cuh.setText(str);
        }
    }

    private void bb(Context context, String str) {
        if (this.iAU != null) {
            if (StringUtils.isNull(str)) {
                this.iAU.setVisibility(4);
                return;
            }
            this.iAU.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.iAU.setOnClickListener(new a(str));
            this.iAU.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            FG(userInfo.portrait);
            this.ibn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.s(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.cuh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.s(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(long j, String str) {
        if (this.iAT != null) {
            this.iAT.ed(String.valueOf(j), str);
        }
    }

    public void pr(boolean z) {
        if (z) {
            this.iAX.setText(R.string.relate_forum_is_followed);
            am.setViewTextColor(this.iAX, R.color.cp_cont_d, 1);
            this.iAX.setEnabled(false);
            return;
        }
        this.iAX.setText(R.string.attention);
        this.iAX.setEnabled(true);
        am.setViewTextColor(this.iAX, R.color.cp_cont_g, 1);
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
            if (d.this.iAT != null) {
                d.this.iAT.FE(this.forumName);
            }
        }
    }
}
