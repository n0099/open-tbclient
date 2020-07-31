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
    private HeadImageView jCA;
    private View kgA;
    private b kgB;
    private TextView kgC;
    private BarImageView kgD;
    private TextView kgE;
    private TextView kgF;
    private LinearLayout kgG;
    private TextView title;

    /* loaded from: classes17.dex */
    public interface b {
        void Kn(String str);

        void cKn();

        void fa(String str, String str2);
    }

    public d(Context context) {
        this.kgA = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.kgA.findViewById(R.id.chosen_pb_title);
        this.jCA = (HeadImageView) this.kgA.findViewById(R.id.chosen_pb_person_info_head);
        this.dpg = (TextView) this.kgA.findViewById(R.id.chosen_pb_person_info_name);
        this.kgC = (TextView) this.kgA.findViewById(R.id.chosen_pb_bar_forum_name);
        this.jCA.setRadius(l.dip2px(context, 2.0f));
        this.kgD = (BarImageView) this.kgA.findViewById(R.id.chosen_pb_bar_pic);
        this.kgE = (TextView) this.kgA.findViewById(R.id.chosen_pb_bar_attention_number);
        this.kgF = (TextView) this.kgA.findViewById(R.id.chosen_pb_bar_attention_button);
        this.kgF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.kgB != null) {
                    d.this.kgB.cKn();
                }
            }
        });
        this.kgG = (LinearLayout) this.kgA.findViewById(R.id.chosen_pb_bar_container);
    }

    public View cKq() {
        return this.kgA;
    }

    public void a(b bVar) {
        this.kgB = bVar;
    }

    public void Kp(String str) {
        if (!StringUtils.isNull(str) && this.jCA != null) {
            this.jCA.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.kgG.setVisibility(8);
                return;
            }
            k.aTv().setForumNameForWaterImage(excellentPbThreadInfo.forum.forum_name);
            this.kgG.setVisibility(0);
            aK(context, excellentPbThreadInfo.forum.forum_name);
            if (this.kgD != null) {
                this.kgD.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.kgD.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.kgE != null && excellentPbThreadInfo.forum.member_count != null) {
                this.kgE.setText(as.numFormatOver10000(excellentPbThreadInfo.forum.member_count.intValue()));
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
        if (this.kgC != null) {
            if (StringUtils.isNull(str)) {
                this.kgC.setVisibility(4);
                return;
            }
            this.kgC.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.kgC.setOnClickListener(new a(str));
            this.kgC.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            Kp(userInfo.portrait);
            this.jCA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
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
        if (this.kgB != null) {
            this.kgB.fa(String.valueOf(j), str);
        }
    }

    public void rR(boolean z) {
        if (z) {
            this.kgF.setText(R.string.relate_forum_is_followed);
            ao.setViewTextColor(this.kgF, R.color.cp_cont_d, 1);
            this.kgF.setEnabled(false);
            return;
        }
        this.kgF.setText(R.string.attention);
        this.kgF.setEnabled(true);
        ao.setViewTextColor(this.kgF, R.color.cp_cont_g, 1);
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
            if (d.this.kgB != null) {
                d.this.kgB.Kn(this.forumName);
            }
        }
    }
}
