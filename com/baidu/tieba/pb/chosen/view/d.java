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
    private TextView bGd;
    private View hIe;
    private b hIf;
    private TextView hIg;
    private BarImageView hIh;
    private TextView hIi;
    private TextView hIj;
    private LinearLayout hIk;
    private HeadImageView hiz;
    private TextView title;

    /* loaded from: classes5.dex */
    public interface b {
        void Ay(String str);

        void bQm();

        void dz(String str, String str2);
    }

    public d(Context context) {
        this.hIe = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.hIe.findViewById(R.id.chosen_pb_title);
        this.hiz = (HeadImageView) this.hIe.findViewById(R.id.chosen_pb_person_info_head);
        this.bGd = (TextView) this.hIe.findViewById(R.id.chosen_pb_person_info_name);
        this.hIg = (TextView) this.hIe.findViewById(R.id.chosen_pb_bar_forum_name);
        this.hiz.setRadius(l.dip2px(context, 2.0f));
        this.hIh = (BarImageView) this.hIe.findViewById(R.id.chosen_pb_bar_pic);
        this.hIi = (TextView) this.hIe.findViewById(R.id.chosen_pb_bar_attention_number);
        this.hIj = (TextView) this.hIe.findViewById(R.id.chosen_pb_bar_attention_button);
        this.hIj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.hIf != null) {
                    d.this.hIf.bQm();
                }
            }
        });
        this.hIk = (LinearLayout) this.hIe.findViewById(R.id.chosen_pb_bar_container);
    }

    public View bQp() {
        return this.hIe;
    }

    public void a(b bVar) {
        this.hIf = bVar;
    }

    public void AA(String str) {
        if (!StringUtils.isNull(str) && this.hiz != null) {
            this.hiz.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.hIk.setVisibility(8);
                return;
            }
            i.agq().setForumNameForWaterImage(excellentPbThreadInfo.forum.forum_name);
            this.hIk.setVisibility(0);
            aJ(context, excellentPbThreadInfo.forum.forum_name);
            if (this.hIh != null) {
                this.hIh.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.hIh.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.hIi != null && excellentPbThreadInfo.forum.member_count != null) {
                this.hIi.setText(aq.numFormatOver10000(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                nO(true);
            } else {
                nO(false);
            }
        }
    }

    public void setName(String str) {
        if (this.bGd != null) {
            this.bGd.setText(str);
        }
    }

    private void aJ(Context context, String str) {
        if (this.hIg != null) {
            if (StringUtils.isNull(str)) {
                this.hIg.setVisibility(4);
                return;
            }
            this.hIg.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.hIg.setOnClickListener(new a(str));
            this.hIg.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            AA(userInfo.portrait);
            this.hiz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.r(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.bGd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.r(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(long j, String str) {
        if (this.hIf != null) {
            this.hIf.dz(String.valueOf(j), str);
        }
    }

    public void nO(boolean z) {
        if (z) {
            this.hIj.setText(R.string.relate_forum_is_followed);
            am.setViewTextColor(this.hIj, R.color.cp_cont_d, 1);
            this.hIj.setEnabled(false);
            return;
        }
        this.hIj.setText(R.string.attention);
        this.hIj.setEnabled(true);
        am.setViewTextColor(this.hIj, R.color.cp_cont_g, 1);
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
            if (d.this.hIf != null) {
                d.this.hIf.Ay(this.forumName);
            }
        }
    }
}
