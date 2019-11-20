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
    private TextView bFm;
    private View hHn;
    private b hHo;
    private TextView hHp;
    private BarImageView hHq;
    private TextView hHr;
    private TextView hHs;
    private LinearLayout hHt;
    private HeadImageView hhH;
    private TextView title;

    /* loaded from: classes5.dex */
    public interface b {
        void Ay(String str);

        void bQk();

        void dz(String str, String str2);
    }

    public d(Context context) {
        this.hHn = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.hHn.findViewById(R.id.chosen_pb_title);
        this.hhH = (HeadImageView) this.hHn.findViewById(R.id.chosen_pb_person_info_head);
        this.bFm = (TextView) this.hHn.findViewById(R.id.chosen_pb_person_info_name);
        this.hHp = (TextView) this.hHn.findViewById(R.id.chosen_pb_bar_forum_name);
        this.hhH.setRadius(l.dip2px(context, 2.0f));
        this.hHq = (BarImageView) this.hHn.findViewById(R.id.chosen_pb_bar_pic);
        this.hHr = (TextView) this.hHn.findViewById(R.id.chosen_pb_bar_attention_number);
        this.hHs = (TextView) this.hHn.findViewById(R.id.chosen_pb_bar_attention_button);
        this.hHs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.hHo != null) {
                    d.this.hHo.bQk();
                }
            }
        });
        this.hHt = (LinearLayout) this.hHn.findViewById(R.id.chosen_pb_bar_container);
    }

    public View bQn() {
        return this.hHn;
    }

    public void a(b bVar) {
        this.hHo = bVar;
    }

    public void AA(String str) {
        if (!StringUtils.isNull(str) && this.hhH != null) {
            this.hhH.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.hHt.setVisibility(8);
                return;
            }
            i.ago().setForumNameForWaterImage(excellentPbThreadInfo.forum.forum_name);
            this.hHt.setVisibility(0);
            aJ(context, excellentPbThreadInfo.forum.forum_name);
            if (this.hHq != null) {
                this.hHq.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.hHq.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.hHr != null && excellentPbThreadInfo.forum.member_count != null) {
                this.hHr.setText(aq.numFormatOver10000(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                nO(true);
            } else {
                nO(false);
            }
        }
    }

    public void setName(String str) {
        if (this.bFm != null) {
            this.bFm.setText(str);
        }
    }

    private void aJ(Context context, String str) {
        if (this.hHp != null) {
            if (StringUtils.isNull(str)) {
                this.hHp.setVisibility(4);
                return;
            }
            this.hHp.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.hHp.setOnClickListener(new a(str));
            this.hHp.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            AA(userInfo.portrait);
            this.hhH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.r(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.bFm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.r(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(long j, String str) {
        if (this.hHo != null) {
            this.hHo.dz(String.valueOf(j), str);
        }
    }

    public void nO(boolean z) {
        if (z) {
            this.hHs.setText(R.string.relate_forum_is_followed);
            am.setViewTextColor(this.hHs, R.color.cp_cont_d, 1);
            this.hHs.setEnabled(false);
            return;
        }
        this.hHs.setText(R.string.attention);
        this.hHs.setEnabled(true);
        am.setViewTextColor(this.hHs, R.color.cp_cont_g, 1);
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
            if (d.this.hHo != null) {
                d.this.hHo.Ay(this.forumName);
            }
        }
    }
}
