package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes22.dex */
public class d {
    private TextView dBn;
    private View kEB;
    private b kEC;
    private TextView kED;
    private BarImageView kEE;
    private TextView kEF;
    private TextView kEG;
    private LinearLayout kEH;
    private HeadImageView kaE;
    private TextView title;

    /* loaded from: classes22.dex */
    public interface b {
        void NJ(String str);

        void cYH();

        void fF(String str, String str2);
    }

    public d(Context context) {
        this.kEB = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.kEB.findViewById(R.id.chosen_pb_title);
        this.kaE = (HeadImageView) this.kEB.findViewById(R.id.chosen_pb_person_info_head);
        this.dBn = (TextView) this.kEB.findViewById(R.id.chosen_pb_person_info_name);
        this.kED = (TextView) this.kEB.findViewById(R.id.chosen_pb_bar_forum_name);
        this.kaE.setRadius(l.dip2px(context, 2.0f));
        this.kEE = (BarImageView) this.kEB.findViewById(R.id.chosen_pb_bar_pic);
        this.kEF = (TextView) this.kEB.findViewById(R.id.chosen_pb_bar_attention_number);
        this.kEG = (TextView) this.kEB.findViewById(R.id.chosen_pb_bar_attention_button);
        this.kEG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.kEC != null) {
                    d.this.kEC.cYH();
                }
            }
        });
        this.kEH = (LinearLayout) this.kEB.findViewById(R.id.chosen_pb_bar_container);
    }

    public View cYK() {
        return this.kEB;
    }

    public void a(b bVar) {
        this.kEC = bVar;
    }

    public void NL(String str) {
        if (!StringUtils.isNull(str) && this.kaE != null) {
            this.kaE.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.kEH.setVisibility(8);
                return;
            }
            k.bcG().setForumNameForWaterImage(excellentPbThreadInfo.forum.forum_name);
            this.kEH.setVisibility(0);
            aR(context, excellentPbThreadInfo.forum.forum_name);
            if (this.kEE != null) {
                this.kEE.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.kEE.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.kEF != null && excellentPbThreadInfo.forum.member_count != null) {
                this.kEF.setText(at.numFormatOver10000(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                sI(true);
            } else {
                sI(false);
            }
        }
    }

    public void setName(String str) {
        if (this.dBn != null) {
            this.dBn.setText(str);
        }
    }

    private void aR(Context context, String str) {
        if (this.kED != null) {
            if (StringUtils.isNull(str)) {
                this.kED.setVisibility(4);
                return;
            }
            this.kED.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.kED.setOnClickListener(new a(str));
            this.kED.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            NL(userInfo.portrait);
            this.kaE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.v(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.dBn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.v(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(long j, String str) {
        if (this.kEC != null) {
            this.kEC.fF(String.valueOf(j), str);
        }
    }

    public void sI(boolean z) {
        if (z) {
            this.kEG.setText(R.string.relate_forum_is_followed);
            ap.setViewTextColor(this.kEG, R.color.cp_cont_d, 1);
            this.kEG.setEnabled(false);
            return;
        }
        this.kEG.setText(R.string.attention);
        this.kEG.setEnabled(true);
        ap.setViewTextColor(this.kEG, R.color.cp_cont_g, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class a implements View.OnClickListener {
        private String forumName;

        public a(String str) {
            this.forumName = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.kEC != null) {
                d.this.kEC.NJ(this.forumName);
            }
        }
    }
}
