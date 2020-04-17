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
    private TextView cTr;
    private HeadImageView iMU;
    private View jmK;
    private b jmL;
    private TextView jmM;
    private BarImageView jmN;
    private TextView jmO;
    private TextView jmP;
    private LinearLayout jmQ;
    private TextView title;

    /* loaded from: classes10.dex */
    public interface b {
        void Hm(String str);

        void cvj();

        void eq(String str, String str2);
    }

    public d(Context context) {
        this.jmK = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.jmK.findViewById(R.id.chosen_pb_title);
        this.iMU = (HeadImageView) this.jmK.findViewById(R.id.chosen_pb_person_info_head);
        this.cTr = (TextView) this.jmK.findViewById(R.id.chosen_pb_person_info_name);
        this.jmM = (TextView) this.jmK.findViewById(R.id.chosen_pb_bar_forum_name);
        this.iMU.setRadius(l.dip2px(context, 2.0f));
        this.jmN = (BarImageView) this.jmK.findViewById(R.id.chosen_pb_bar_pic);
        this.jmO = (TextView) this.jmK.findViewById(R.id.chosen_pb_bar_attention_number);
        this.jmP = (TextView) this.jmK.findViewById(R.id.chosen_pb_bar_attention_button);
        this.jmP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.jmL != null) {
                    d.this.jmL.cvj();
                }
            }
        });
        this.jmQ = (LinearLayout) this.jmK.findViewById(R.id.chosen_pb_bar_container);
    }

    public View cvm() {
        return this.jmK;
    }

    public void a(b bVar) {
        this.jmL = bVar;
    }

    public void Ho(String str) {
        if (!StringUtils.isNull(str) && this.iMU != null) {
            this.iMU.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.jmQ.setVisibility(8);
                return;
            }
            i.aIe().setForumNameForWaterImage(excellentPbThreadInfo.forum.forum_name);
            this.jmQ.setVisibility(0);
            aW(context, excellentPbThreadInfo.forum.forum_name);
            if (this.jmN != null) {
                this.jmN.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.jmN.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.jmO != null && excellentPbThreadInfo.forum.member_count != null) {
                this.jmO.setText(aq.numFormatOver10000(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                qB(true);
            } else {
                qB(false);
            }
        }
    }

    public void setName(String str) {
        if (this.cTr != null) {
            this.cTr.setText(str);
        }
    }

    private void aW(Context context, String str) {
        if (this.jmM != null) {
            if (StringUtils.isNull(str)) {
                this.jmM.setVisibility(4);
                return;
            }
            this.jmM.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.jmM.setOnClickListener(new a(str));
            this.jmM.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            Ho(userInfo.portrait);
            this.iMU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.u(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.cTr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.u(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(long j, String str) {
        if (this.jmL != null) {
            this.jmL.eq(String.valueOf(j), str);
        }
    }

    public void qB(boolean z) {
        if (z) {
            this.jmP.setText(R.string.relate_forum_is_followed);
            am.setViewTextColor(this.jmP, R.color.cp_cont_d, 1);
            this.jmP.setEnabled(false);
            return;
        }
        this.jmP.setText(R.string.attention);
        this.jmP.setEnabled(true);
        am.setViewTextColor(this.jmP, R.color.cp_cont_g, 1);
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
            if (d.this.jmL != null) {
                d.this.jmL.Hm(this.forumName);
            }
        }
    }
}
