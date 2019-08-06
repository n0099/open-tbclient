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
/* loaded from: classes5.dex */
public class d {
    private TextView bmT;
    private View hHD;
    private b hHE;
    private TextView hHF;
    private BarImageView hHG;
    private TextView hHH;
    private TextView hHI;
    private LinearLayout hHJ;
    private HeadImageView hiA;
    private TextView title;

    /* loaded from: classes5.dex */
    public interface b {
        void BG(String str);

        void aQW();

        void dL(String str, String str2);
    }

    public d(Context context) {
        this.hHD = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.hHD.findViewById(R.id.chosen_pb_title);
        this.hiA = (HeadImageView) this.hHD.findViewById(R.id.chosen_pb_person_info_head);
        this.bmT = (TextView) this.hHD.findViewById(R.id.chosen_pb_person_info_name);
        this.hHF = (TextView) this.hHD.findViewById(R.id.chosen_pb_bar_forum_name);
        this.hiA.setRadius(l.dip2px(context, 2.0f));
        this.hHG = (BarImageView) this.hHD.findViewById(R.id.chosen_pb_bar_pic);
        this.hHH = (TextView) this.hHD.findViewById(R.id.chosen_pb_bar_attention_number);
        this.hHI = (TextView) this.hHD.findViewById(R.id.chosen_pb_bar_attention_button);
        this.hHI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.hHE != null) {
                    d.this.hHE.aQW();
                }
            }
        });
        this.hHJ = (LinearLayout) this.hHD.findViewById(R.id.chosen_pb_bar_container);
    }

    public View bSB() {
        return this.hHD;
    }

    public void a(b bVar) {
        this.hHE = bVar;
    }

    public void BI(String str) {
        if (!StringUtils.isNull(str) && this.hiA != null) {
            this.hiA.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.hHJ.setVisibility(8);
                return;
            }
            i.aca().mi(excellentPbThreadInfo.forum.forum_name);
            this.hHJ.setVisibility(0);
            aF(context, excellentPbThreadInfo.forum.forum_name);
            if (this.hHG != null) {
                this.hHG.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.hHG.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.hHH != null && excellentPbThreadInfo.forum.member_count != null) {
                this.hHH.setText(aq.aM(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                oa(true);
            } else {
                oa(false);
            }
        }
    }

    public void setName(String str) {
        if (this.bmT != null) {
            this.bmT.setText(str);
        }
    }

    private void aF(Context context, String str) {
        if (this.hHF != null) {
            if (StringUtils.isNull(str)) {
                this.hHF.setVisibility(4);
                return;
            }
            this.hHF.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.hHF.setOnClickListener(new a(str));
            this.hHF.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            BI(userInfo.portrait);
            this.hiA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.p(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.bmT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.p(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(long j, String str) {
        if (this.hHE != null) {
            this.hHE.dL(String.valueOf(j), str);
        }
    }

    public void oa(boolean z) {
        if (z) {
            this.hHI.setText(R.string.relate_forum_is_followed);
            am.f(this.hHI, R.color.cp_cont_d, 1);
            this.hHI.setEnabled(false);
            return;
        }
        this.hHI.setText(R.string.attention);
        this.hHI.setEnabled(true);
        am.f(this.hHI, R.color.cp_cont_g, 1);
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
            if (d.this.hHE != null) {
                d.this.hHE.BG(this.forumName);
            }
        }
    }
}
