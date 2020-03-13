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
    private TextView cui;
    private View iBe;
    private b iBf;
    private TextView iBg;
    private BarImageView iBh;
    private TextView iBi;
    private TextView iBj;
    private LinearLayout iBk;
    private HeadImageView ibz;
    private TextView title;

    /* loaded from: classes10.dex */
    public interface b {
        void FF(String str);

        void ckk();

        void ed(String str, String str2);
    }

    public d(Context context) {
        this.iBe = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.iBe.findViewById(R.id.chosen_pb_title);
        this.ibz = (HeadImageView) this.iBe.findViewById(R.id.chosen_pb_person_info_head);
        this.cui = (TextView) this.iBe.findViewById(R.id.chosen_pb_person_info_name);
        this.iBg = (TextView) this.iBe.findViewById(R.id.chosen_pb_bar_forum_name);
        this.ibz.setRadius(l.dip2px(context, 2.0f));
        this.iBh = (BarImageView) this.iBe.findViewById(R.id.chosen_pb_bar_pic);
        this.iBi = (TextView) this.iBe.findViewById(R.id.chosen_pb_bar_attention_number);
        this.iBj = (TextView) this.iBe.findViewById(R.id.chosen_pb_bar_attention_button);
        this.iBj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.iBf != null) {
                    d.this.iBf.ckk();
                }
            }
        });
        this.iBk = (LinearLayout) this.iBe.findViewById(R.id.chosen_pb_bar_container);
    }

    public View ckn() {
        return this.iBe;
    }

    public void a(b bVar) {
        this.iBf = bVar;
    }

    public void FH(String str) {
        if (!StringUtils.isNull(str) && this.ibz != null) {
            this.ibz.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.iBk.setVisibility(8);
                return;
            }
            i.azO().setForumNameForWaterImage(excellentPbThreadInfo.forum.forum_name);
            this.iBk.setVisibility(0);
            bb(context, excellentPbThreadInfo.forum.forum_name);
            if (this.iBh != null) {
                this.iBh.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.iBh.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.iBi != null && excellentPbThreadInfo.forum.member_count != null) {
                this.iBi.setText(aq.numFormatOver10000(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                pr(true);
            } else {
                pr(false);
            }
        }
    }

    public void setName(String str) {
        if (this.cui != null) {
            this.cui.setText(str);
        }
    }

    private void bb(Context context, String str) {
        if (this.iBg != null) {
            if (StringUtils.isNull(str)) {
                this.iBg.setVisibility(4);
                return;
            }
            this.iBg.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.iBg.setOnClickListener(new a(str));
            this.iBg.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            FH(userInfo.portrait);
            this.ibz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.s(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.cui.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.s(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(long j, String str) {
        if (this.iBf != null) {
            this.iBf.ed(String.valueOf(j), str);
        }
    }

    public void pr(boolean z) {
        if (z) {
            this.iBj.setText(R.string.relate_forum_is_followed);
            am.setViewTextColor(this.iBj, R.color.cp_cont_d, 1);
            this.iBj.setEnabled(false);
            return;
        }
        this.iBj.setText(R.string.attention);
        this.iBj.setEnabled(true);
        am.setViewTextColor(this.iBj, R.color.cp_cont_g, 1);
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
            if (d.this.iBf != null) {
                d.this.iBf.FF(this.forumName);
            }
        }
    }
}
