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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes17.dex */
public class d {
    private TextView dpg;
    private HeadImageView jCC;
    private View kgC;
    private b kgD;
    private TextView kgE;
    private BarImageView kgF;
    private TextView kgG;
    private TextView kgH;
    private LinearLayout kgI;
    private TextView title;

    /* loaded from: classes17.dex */
    public interface b {
        void Kn(String str);

        void cKn();

        void fa(String str, String str2);
    }

    public d(Context context) {
        this.kgC = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.kgC.findViewById(R.id.chosen_pb_title);
        this.jCC = (HeadImageView) this.kgC.findViewById(R.id.chosen_pb_person_info_head);
        this.dpg = (TextView) this.kgC.findViewById(R.id.chosen_pb_person_info_name);
        this.kgE = (TextView) this.kgC.findViewById(R.id.chosen_pb_bar_forum_name);
        this.jCC.setRadius(l.dip2px(context, 2.0f));
        this.kgF = (BarImageView) this.kgC.findViewById(R.id.chosen_pb_bar_pic);
        this.kgG = (TextView) this.kgC.findViewById(R.id.chosen_pb_bar_attention_number);
        this.kgH = (TextView) this.kgC.findViewById(R.id.chosen_pb_bar_attention_button);
        this.kgH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.kgD != null) {
                    d.this.kgD.cKn();
                }
            }
        });
        this.kgI = (LinearLayout) this.kgC.findViewById(R.id.chosen_pb_bar_container);
    }

    public View cKq() {
        return this.kgC;
    }

    public void a(b bVar) {
        this.kgD = bVar;
    }

    public void Kp(String str) {
        if (!StringUtils.isNull(str) && this.jCC != null) {
            this.jCC.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.kgI.setVisibility(8);
                return;
            }
            k.aTv().setForumNameForWaterImage(excellentPbThreadInfo.forum.forum_name);
            this.kgI.setVisibility(0);
            aK(context, excellentPbThreadInfo.forum.forum_name);
            if (this.kgF != null) {
                this.kgF.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.kgF.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.kgG != null && excellentPbThreadInfo.forum.member_count != null) {
                this.kgG.setText(as.numFormatOver10000(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                rR(true);
            } else {
                rR(false);
            }
        }
    }

    public void setName(String str) {
        if (this.dpg != null) {
            this.dpg.setText(str);
        }
    }

    private void aK(Context context, String str) {
        if (this.kgE != null) {
            if (StringUtils.isNull(str)) {
                this.kgE.setVisibility(4);
                return;
            }
            this.kgE.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.kgE.setOnClickListener(new a(str));
            this.kgE.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            Kp(userInfo.portrait);
            this.jCC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.w(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.dpg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.w(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(long j, String str) {
        if (this.kgD != null) {
            this.kgD.fa(String.valueOf(j), str);
        }
    }

    public void rR(boolean z) {
        if (z) {
            this.kgH.setText(R.string.relate_forum_is_followed);
            ao.setViewTextColor(this.kgH, R.color.cp_cont_d, 1);
            this.kgH.setEnabled(false);
            return;
        }
        this.kgH.setText(R.string.attention);
        this.kgH.setEnabled(true);
        ao.setViewTextColor(this.kgH, R.color.cp_cont_g, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class a implements View.OnClickListener {
        private String forumName;

        public a(String str) {
            this.forumName = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.kgD != null) {
                d.this.kgD.Kn(this.forumName);
            }
        }
    }
}
