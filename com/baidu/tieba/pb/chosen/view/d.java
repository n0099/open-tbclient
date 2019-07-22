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
    private View hGL;
    private b hGM;
    private TextView hGN;
    private BarImageView hGO;
    private TextView hGP;
    private TextView hGQ;
    private LinearLayout hGR;
    private HeadImageView hhH;
    private TextView title;

    /* loaded from: classes5.dex */
    public interface b {
        void BF(String str);

        void aQU();

        void dL(String str, String str2);
    }

    public d(Context context) {
        this.hGL = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.hGL.findViewById(R.id.chosen_pb_title);
        this.hhH = (HeadImageView) this.hGL.findViewById(R.id.chosen_pb_person_info_head);
        this.bmT = (TextView) this.hGL.findViewById(R.id.chosen_pb_person_info_name);
        this.hGN = (TextView) this.hGL.findViewById(R.id.chosen_pb_bar_forum_name);
        this.hhH.setRadius(l.dip2px(context, 2.0f));
        this.hGO = (BarImageView) this.hGL.findViewById(R.id.chosen_pb_bar_pic);
        this.hGP = (TextView) this.hGL.findViewById(R.id.chosen_pb_bar_attention_number);
        this.hGQ = (TextView) this.hGL.findViewById(R.id.chosen_pb_bar_attention_button);
        this.hGQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.hGM != null) {
                    d.this.hGM.aQU();
                }
            }
        });
        this.hGR = (LinearLayout) this.hGL.findViewById(R.id.chosen_pb_bar_container);
    }

    public View bSn() {
        return this.hGL;
    }

    public void a(b bVar) {
        this.hGM = bVar;
    }

    public void BH(String str) {
        if (!StringUtils.isNull(str) && this.hhH != null) {
            this.hhH.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.hGR.setVisibility(8);
                return;
            }
            i.aca().mi(excellentPbThreadInfo.forum.forum_name);
            this.hGR.setVisibility(0);
            aF(context, excellentPbThreadInfo.forum.forum_name);
            if (this.hGO != null) {
                this.hGO.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.hGO.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.hGP != null && excellentPbThreadInfo.forum.member_count != null) {
                this.hGP.setText(aq.aM(excellentPbThreadInfo.forum.member_count.intValue()));
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
        if (this.hGN != null) {
            if (StringUtils.isNull(str)) {
                this.hGN.setVisibility(4);
                return;
            }
            this.hGN.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.hGN.setOnClickListener(new a(str));
            this.hGN.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            BH(userInfo.portrait);
            this.hhH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
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
        if (this.hGM != null) {
            this.hGM.dL(String.valueOf(j), str);
        }
    }

    public void oa(boolean z) {
        if (z) {
            this.hGQ.setText(R.string.relate_forum_is_followed);
            am.f(this.hGQ, R.color.cp_cont_d, 1);
            this.hGQ.setEnabled(false);
            return;
        }
        this.hGQ.setText(R.string.attention);
        this.hGQ.setEnabled(true);
        am.f(this.hGQ, R.color.cp_cont_g, 1);
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
            if (d.this.hGM != null) {
                d.this.hGM.BF(this.forumName);
            }
        }
    }
}
