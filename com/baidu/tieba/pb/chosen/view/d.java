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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes5.dex */
public class d {
    private TextView bmf;
    private View hAt;
    private b hAu;
    private TextView hAv;
    private BarImageView hAw;
    private TextView hAx;
    private TextView hAy;
    private LinearLayout hAz;
    private HeadImageView hbr;
    private TextView title;

    /* loaded from: classes5.dex */
    public interface b {
        void AR(String str);

        void aPf();

        void dK(String str, String str2);
    }

    public d(Context context) {
        this.hAt = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.hAt.findViewById(R.id.chosen_pb_title);
        this.hbr = (HeadImageView) this.hAt.findViewById(R.id.chosen_pb_person_info_head);
        this.bmf = (TextView) this.hAt.findViewById(R.id.chosen_pb_person_info_name);
        this.hAv = (TextView) this.hAt.findViewById(R.id.chosen_pb_bar_forum_name);
        this.hbr.setRadius(l.dip2px(context, 2.0f));
        this.hAw = (BarImageView) this.hAt.findViewById(R.id.chosen_pb_bar_pic);
        this.hAx = (TextView) this.hAt.findViewById(R.id.chosen_pb_bar_attention_number);
        this.hAy = (TextView) this.hAt.findViewById(R.id.chosen_pb_bar_attention_button);
        this.hAy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.hAu != null) {
                    d.this.hAu.aPf();
                }
            }
        });
        this.hAz = (LinearLayout) this.hAt.findViewById(R.id.chosen_pb_bar_container);
    }

    public View bPy() {
        return this.hAt;
    }

    public void a(b bVar) {
        this.hAu = bVar;
    }

    public void AT(String str) {
        if (!StringUtils.isNull(str) && this.hbr != null) {
            this.hbr.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.hAz.setVisibility(8);
                return;
            }
            i.abb().lZ(excellentPbThreadInfo.forum.forum_name);
            this.hAz.setVisibility(0);
            aE(context, excellentPbThreadInfo.forum.forum_name);
            if (this.hAw != null) {
                this.hAw.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.hAw.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.hAx != null && excellentPbThreadInfo.forum.member_count != null) {
                this.hAx.setText(ap.aL(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                nL(true);
            } else {
                nL(false);
            }
        }
    }

    public void setName(String str) {
        if (this.bmf != null) {
            this.bmf.setText(str);
        }
    }

    private void aE(Context context, String str) {
        if (this.hAv != null) {
            if (StringUtils.isNull(str)) {
                this.hAv.setVisibility(4);
                return;
            }
            this.hAv.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.hAv.setOnClickListener(new a(str));
            this.hAv.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            AT(userInfo.portrait);
            this.hbr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.p(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.bmf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.p(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(long j, String str) {
        if (this.hAu != null) {
            this.hAu.dK(String.valueOf(j), str);
        }
    }

    public void nL(boolean z) {
        if (z) {
            this.hAy.setText(R.string.relate_forum_is_followed);
            al.f(this.hAy, R.color.cp_cont_d, 1);
            this.hAy.setEnabled(false);
            return;
        }
        this.hAy.setText(R.string.attention);
        this.hAy.setEnabled(true);
        al.f(this.hAy, R.color.cp_cont_g, 1);
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
            if (d.this.hAu != null) {
                d.this.hAu.AR(this.forumName);
            }
        }
    }
}
