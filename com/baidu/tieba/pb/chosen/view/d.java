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
/* loaded from: classes17.dex */
public class d {
    private TextView dzm;
    private HeadImageView jSb;
    private View kwc;
    private b kwd;
    private TextView kwe;
    private BarImageView kwf;
    private TextView kwg;
    private TextView kwh;
    private LinearLayout kwi;
    private TextView title;

    /* loaded from: classes17.dex */
    public interface b {
        void Nh(String str);

        void cVc();

        void fs(String str, String str2);
    }

    public d(Context context) {
        this.kwc = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.kwc.findViewById(R.id.chosen_pb_title);
        this.jSb = (HeadImageView) this.kwc.findViewById(R.id.chosen_pb_person_info_head);
        this.dzm = (TextView) this.kwc.findViewById(R.id.chosen_pb_person_info_name);
        this.kwe = (TextView) this.kwc.findViewById(R.id.chosen_pb_bar_forum_name);
        this.jSb.setRadius(l.dip2px(context, 2.0f));
        this.kwf = (BarImageView) this.kwc.findViewById(R.id.chosen_pb_bar_pic);
        this.kwg = (TextView) this.kwc.findViewById(R.id.chosen_pb_bar_attention_number);
        this.kwh = (TextView) this.kwc.findViewById(R.id.chosen_pb_bar_attention_button);
        this.kwh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.kwd != null) {
                    d.this.kwd.cVc();
                }
            }
        });
        this.kwi = (LinearLayout) this.kwc.findViewById(R.id.chosen_pb_bar_container);
    }

    public View cVf() {
        return this.kwc;
    }

    public void a(b bVar) {
        this.kwd = bVar;
    }

    public void Nj(String str) {
        if (!StringUtils.isNull(str) && this.jSb != null) {
            this.jSb.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.kwi.setVisibility(8);
                return;
            }
            k.bbM().setForumNameForWaterImage(excellentPbThreadInfo.forum.forum_name);
            this.kwi.setVisibility(0);
            aO(context, excellentPbThreadInfo.forum.forum_name);
            if (this.kwf != null) {
                this.kwf.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.kwf.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.kwg != null && excellentPbThreadInfo.forum.member_count != null) {
                this.kwg.setText(at.numFormatOver10000(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                sA(true);
            } else {
                sA(false);
            }
        }
    }

    public void setName(String str) {
        if (this.dzm != null) {
            this.dzm.setText(str);
        }
    }

    private void aO(Context context, String str) {
        if (this.kwe != null) {
            if (StringUtils.isNull(str)) {
                this.kwe.setVisibility(4);
                return;
            }
            this.kwe.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.kwe.setOnClickListener(new a(str));
            this.kwe.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            Nj(userInfo.portrait);
            this.jSb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.v(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.dzm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.v(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(long j, String str) {
        if (this.kwd != null) {
            this.kwd.fs(String.valueOf(j), str);
        }
    }

    public void sA(boolean z) {
        if (z) {
            this.kwh.setText(R.string.relate_forum_is_followed);
            ap.setViewTextColor(this.kwh, R.color.cp_cont_d, 1);
            this.kwh.setEnabled(false);
            return;
        }
        this.kwh.setText(R.string.attention);
        this.kwh.setEnabled(true);
        ap.setViewTextColor(this.kwh, R.color.cp_cont_g, 1);
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
            if (d.this.kwd != null) {
                d.this.kwd.Nh(this.forumName);
            }
        }
    }
}
