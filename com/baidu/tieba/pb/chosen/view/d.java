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
    private TextView cuv;
    private View iCE;
    private b iCF;
    private TextView iCG;
    private BarImageView iCH;
    private TextView iCI;
    private TextView iCJ;
    private LinearLayout iCK;
    private HeadImageView icZ;
    private TextView title;

    /* loaded from: classes10.dex */
    public interface b {
        void FF(String str);

        void ckE();

        void eb(String str, String str2);
    }

    public d(Context context) {
        this.iCE = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.iCE.findViewById(R.id.chosen_pb_title);
        this.icZ = (HeadImageView) this.iCE.findViewById(R.id.chosen_pb_person_info_head);
        this.cuv = (TextView) this.iCE.findViewById(R.id.chosen_pb_person_info_name);
        this.iCG = (TextView) this.iCE.findViewById(R.id.chosen_pb_bar_forum_name);
        this.icZ.setRadius(l.dip2px(context, 2.0f));
        this.iCH = (BarImageView) this.iCE.findViewById(R.id.chosen_pb_bar_pic);
        this.iCI = (TextView) this.iCE.findViewById(R.id.chosen_pb_bar_attention_number);
        this.iCJ = (TextView) this.iCE.findViewById(R.id.chosen_pb_bar_attention_button);
        this.iCJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.iCF != null) {
                    d.this.iCF.ckE();
                }
            }
        });
        this.iCK = (LinearLayout) this.iCE.findViewById(R.id.chosen_pb_bar_container);
    }

    public View ckH() {
        return this.iCE;
    }

    public void a(b bVar) {
        this.iCF = bVar;
    }

    public void FH(String str) {
        if (!StringUtils.isNull(str) && this.icZ != null) {
            this.icZ.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.iCK.setVisibility(8);
                return;
            }
            i.azR().setForumNameForWaterImage(excellentPbThreadInfo.forum.forum_name);
            this.iCK.setVisibility(0);
            bb(context, excellentPbThreadInfo.forum.forum_name);
            if (this.iCH != null) {
                this.iCH.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.iCH.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.iCI != null && excellentPbThreadInfo.forum.member_count != null) {
                this.iCI.setText(aq.numFormatOver10000(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                px(true);
            } else {
                px(false);
            }
        }
    }

    public void setName(String str) {
        if (this.cuv != null) {
            this.cuv.setText(str);
        }
    }

    private void bb(Context context, String str) {
        if (this.iCG != null) {
            if (StringUtils.isNull(str)) {
                this.iCG.setVisibility(4);
                return;
            }
            this.iCG.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.iCG.setOnClickListener(new a(str));
            this.iCG.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            FH(userInfo.portrait);
            this.icZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.s(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.cuv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.s(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(long j, String str) {
        if (this.iCF != null) {
            this.iCF.eb(String.valueOf(j), str);
        }
    }

    public void px(boolean z) {
        if (z) {
            this.iCJ.setText(R.string.relate_forum_is_followed);
            am.setViewTextColor(this.iCJ, R.color.cp_cont_d, 1);
            this.iCJ.setEnabled(false);
            return;
        }
        this.iCJ.setText(R.string.attention);
        this.iCJ.setEnabled(true);
        am.setViewTextColor(this.iCJ, R.color.cp_cont_g, 1);
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
            if (d.this.iCF != null) {
                d.this.iCF.FF(this.forumName);
            }
        }
    }
}
