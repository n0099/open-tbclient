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
/* loaded from: classes23.dex */
public class d {
    private TextView dVL;
    private HeadImageView kCp;
    private View lgl;
    private b lgm;
    private TextView lgn;
    private BarImageView lgo;
    private TextView lgp;
    private TextView lgq;
    private LinearLayout lgr;
    private TextView title;

    /* loaded from: classes23.dex */
    public interface b {
        void OW(String str);

        void dfy();

        void fR(String str, String str2);
    }

    public d(Context context) {
        this.lgl = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.lgl.findViewById(R.id.chosen_pb_title);
        this.kCp = (HeadImageView) this.lgl.findViewById(R.id.chosen_pb_person_info_head);
        this.dVL = (TextView) this.lgl.findViewById(R.id.chosen_pb_person_info_name);
        this.lgn = (TextView) this.lgl.findViewById(R.id.chosen_pb_bar_forum_name);
        this.kCp.setRadius(l.dip2px(context, 2.0f));
        this.lgo = (BarImageView) this.lgl.findViewById(R.id.chosen_pb_bar_pic);
        this.lgp = (TextView) this.lgl.findViewById(R.id.chosen_pb_bar_attention_number);
        this.lgq = (TextView) this.lgl.findViewById(R.id.chosen_pb_bar_attention_button);
        this.lgq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.lgm != null) {
                    d.this.lgm.dfy();
                }
            }
        });
        this.lgr = (LinearLayout) this.lgl.findViewById(R.id.chosen_pb_bar_container);
    }

    public View dfB() {
        return this.lgl;
    }

    public void a(b bVar) {
        this.lgm = bVar;
    }

    public void OY(String str) {
        if (!StringUtils.isNull(str) && this.kCp != null) {
            this.kCp.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.lgr.setVisibility(8);
                return;
            }
            k.bhh().setForumNameForWaterImage(excellentPbThreadInfo.forum.forum_name);
            this.lgr.setVisibility(0);
            aV(context, excellentPbThreadInfo.forum.forum_name);
            if (this.lgo != null) {
                this.lgo.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.lgo.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.lgp != null && excellentPbThreadInfo.forum.member_count != null) {
                this.lgp.setText(at.numFormatOver10000(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                tG(true);
            } else {
                tG(false);
            }
        }
    }

    public void setName(String str) {
        if (this.dVL != null) {
            this.dVL.setText(str);
        }
    }

    private void aV(Context context, String str) {
        if (this.lgn != null) {
            if (StringUtils.isNull(str)) {
                this.lgn.setVisibility(4);
                return;
            }
            this.lgn.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.lgn.setOnClickListener(new a(str));
            this.lgn.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            OY(userInfo.portrait);
            this.kCp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.w(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.dVL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.w(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(long j, String str) {
        if (this.lgm != null) {
            this.lgm.fR(String.valueOf(j), str);
        }
    }

    public void tG(boolean z) {
        if (z) {
            this.lgq.setText(R.string.relate_forum_is_followed);
            ap.setViewTextColor(this.lgq, R.color.cp_cont_d, 1);
            this.lgq.setEnabled(false);
            return;
        }
        this.lgq.setText(R.string.attention);
        this.lgq.setEnabled(true);
        ap.setViewTextColor(this.lgq, R.color.cp_cont_g, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class a implements View.OnClickListener {
        private String forumName;

        public a(String str) {
            this.forumName = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.lgm != null) {
                d.this.lgm.OW(this.forumName);
            }
        }
    }
}
