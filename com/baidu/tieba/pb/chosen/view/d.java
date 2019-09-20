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
    private TextView bnr;
    private b hJA;
    private TextView hJB;
    private BarImageView hJC;
    private TextView hJD;
    private TextView hJE;
    private LinearLayout hJF;
    private View hJz;
    private HeadImageView hku;
    private TextView title;

    /* loaded from: classes5.dex */
    public interface b {
        void Cf(String str);

        void aRA();

        void dN(String str, String str2);
    }

    public d(Context context) {
        this.hJz = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.hJz.findViewById(R.id.chosen_pb_title);
        this.hku = (HeadImageView) this.hJz.findViewById(R.id.chosen_pb_person_info_head);
        this.bnr = (TextView) this.hJz.findViewById(R.id.chosen_pb_person_info_name);
        this.hJB = (TextView) this.hJz.findViewById(R.id.chosen_pb_bar_forum_name);
        this.hku.setRadius(l.dip2px(context, 2.0f));
        this.hJC = (BarImageView) this.hJz.findViewById(R.id.chosen_pb_bar_pic);
        this.hJD = (TextView) this.hJz.findViewById(R.id.chosen_pb_bar_attention_number);
        this.hJE = (TextView) this.hJz.findViewById(R.id.chosen_pb_bar_attention_button);
        this.hJE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.hJA != null) {
                    d.this.hJA.aRA();
                }
            }
        });
        this.hJF = (LinearLayout) this.hJz.findViewById(R.id.chosen_pb_bar_container);
    }

    public View bTo() {
        return this.hJz;
    }

    public void a(b bVar) {
        this.hJA = bVar;
    }

    public void Ch(String str) {
        if (!StringUtils.isNull(str) && this.hku != null) {
            this.hku.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.hJF.setVisibility(8);
                return;
            }
            i.ace().mk(excellentPbThreadInfo.forum.forum_name);
            this.hJF.setVisibility(0);
            aM(context, excellentPbThreadInfo.forum.forum_name);
            if (this.hJC != null) {
                this.hJC.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.hJC.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.hJD != null && excellentPbThreadInfo.forum.member_count != null) {
                this.hJD.setText(aq.aM(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                oe(true);
            } else {
                oe(false);
            }
        }
    }

    public void setName(String str) {
        if (this.bnr != null) {
            this.bnr.setText(str);
        }
    }

    private void aM(Context context, String str) {
        if (this.hJB != null) {
            if (StringUtils.isNull(str)) {
                this.hJB.setVisibility(4);
                return;
            }
            this.hJB.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.hJB.setOnClickListener(new a(str));
            this.hJB.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            Ch(userInfo.portrait);
            this.hku.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.p(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.bnr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.p(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(long j, String str) {
        if (this.hJA != null) {
            this.hJA.dN(String.valueOf(j), str);
        }
    }

    public void oe(boolean z) {
        if (z) {
            this.hJE.setText(R.string.relate_forum_is_followed);
            am.f(this.hJE, R.color.cp_cont_d, 1);
            this.hJE.setEnabled(false);
            return;
        }
        this.hJE.setText(R.string.attention);
        this.hJE.setEnabled(true);
        am.f(this.hJE, R.color.cp_cont_g, 1);
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
            if (d.this.hJA != null) {
                d.this.hJA.Cf(this.forumName);
            }
        }
    }
}
